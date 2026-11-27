package cruxnocturnalworks.content.units;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.math.Angles;
import arc.util.Time;
import mindustry.Vars;
import mindustry.entities.Effect;
import mindustry.game.EventType.Trigger;
import mindustry.gen.Building;
import mindustry.gen.Groups;
import mindustry.gen.Unit;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.world.Block;
import arc.Events;

public class HiddenUnitsContent{
    public static UnitType leech;
    private static TextureRegion legRegion;

    public static void load(){
        leech = new UnitType("cnw-hidden-leech"){{
            constructor = UnitEntity::create;
            speed = 1.55f;
            accel = 0.12f;
            drag = 0.18f;
            rotateSpeed = 8f;
            hitSize = 9f;
            health = 260f;
            armor = 3f;
            flying = false;
            targetAir = false;
            targetGround = true;
            faceTarget = false;
            outlineColor = mindustry.graphics.Pal.darkerMetal;
        }};

        Events.run(Trigger.update, () -> {
            if(Vars.state == null || Vars.state.isMenu() || Vars.world == null) return;

            for(Unit unit : Groups.unit){
                if(unit.type != leech || unit.dead || !unit.isAdded()) continue;

                Building target = null;
                float best = Float.MAX_VALUE;

                for(Building build : Groups.build){
                    if(build == null || build.dead || !build.isAdded() || build.health <= 0f) continue;
                    float dst = unit.dst2(build);
                    if(dst < best){
                        best = dst;
                        target = build;
                    }
                }

                if(target == null){
                    unit.vel.setZero();
                    continue;
                }

                float angle = unit.angleTo(target);
                float reach = target.block.size * Vars.tilesize * 0.5f + unit.hitSize * 0.5f;
                float dst = unit.dst(target);

                if(dst > reach){
                    unit.vel.set(target.x - unit.x, target.y - unit.y).setLength(leech.speed);
                    unit.rotation = Angles.moveToward(unit.rotation, angle, leech.rotateSpeed * Time.delta);
                }else{
                    unit.vel.setZero();
                    unit.rotation = Angles.moveToward(unit.rotation, angle + 180f, leech.rotateSpeed * Time.delta);
                    target.damage(0.12f * Time.delta);
                }
            }
        });
    }

    public static void drawLegs(Unit unit){
        if(legRegion == null) legRegion = Core.atlas.find("crawler-leg");
        if(legRegion == null || !legRegion.found()) return;

        Draw.z(mindustry.graphics.Layer.groundUnit + 0.01f);
        Draw.color();

        float walk = unit.vel.len() > 0.05f ? (float)Math.sin(Time.time * 0.35f) : 0f;

        for(int i = 0; i < 4; i++){
            float side = i % 2 == 0 ? -1f : 1f;
            float front = i < 2 ? 1f : -1f;
            float offsetX = side * (3.5f + walk * side);
            float offsetY = front * 2.5f + walk * front;
            float x = unit.x + Angles.trnsx(unit.rotation, offsetX, offsetY);
            float y = unit.y + Angles.trnsy(unit.rotation, offsetX, offsetY);
            float rotation = unit.rotation + (side * 22f) + walk * 12f;

            Draw.rect(legRegion, x, y, legRegion.width * Draw.scl, legRegion.height * Draw.scl, rotation);
        }

        Draw.reset();
    }
}
