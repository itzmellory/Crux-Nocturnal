package cruxnocturnalworks.content.units;

import arc.Core;
import arc.math.Angles;
import arc.util.Time;
import arc.Events;
import mindustry.Vars;
import mindustry.entities.part.PartProgress;
import mindustry.entities.part.RegionPart;
import mindustry.game.EventType.Trigger;
import mindustry.gen.Building;
import mindustry.gen.Groups;
import mindustry.gen.Unit;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;

public class HiddenUnitsContent{
    public static UnitType leech;

    public static void load(){
        leech = new UnitType("cnw-hidden-leech"){
            {
                constructor = UnitEntity::create;
                speed = 1.55f;
                accel = 0.12f;
                drag = 0.18f;
                rotateSpeed = 8f;
                hitSize = 9f;
                health = 260f;
                armor = 3f;
                flying = false;
                lowAltitude = false;
                targetAir = false;
                targetGround = true;
                faceTarget = false;
                outlineColor = mindustry.graphics.Pal.darkerMetal;

                for(int i = 0; i < 4; i++){
                    final int side = i;
                    parts.add(new RegionPart(""){{
                        mirror = false;
                        under = true;
                        layerOffset = -0.01f;
                        x = side % 2 == 0 ? -4.5f : 4.5f;
                        y = side < 2 ? -2.5f : 2.5f;
                        moveX = side % 2 == 0 ? -2.2f : 2.2f;
                        moveY = side < 2 ? -1.6f : 1.6f;
                        moveRot = side % 2 == 0 ? -35f : 35f;
                        progress = PartProgress.moving;
                    }});
                }
            }

            @Override
            public void load(){
                super.load();
                region = Core.atlas.find("crawler", Core.atlas.find("dagger"));
                fullIcon = region;
                for(int i = 0; i < parts.size; i++){
                    if(parts.get(i) instanceof RegionPart part){
                        part.region = Core.atlas.find("crawler", Core.atlas.find("dagger"));
                    }
                }
            }
        };

        Events.run(Trigger.update, () -> {
            if(Vars.state == null || Vars.state.isMenu() || Vars.world == null) return;
            Groups.unit.each(unit -> {
                if(unit.type != leech || !unit.isAdded() || unit.dead) return;
                Building target = null;
                float best = Float.MAX_VALUE;
                for(Building build : Groups.build){
                    if(build == null || !build.isAdded() || build.dead || build.health <= 0f) continue;
                    float dst = unit.dst2(build);
                    if(dst < best){
                        best = dst;
                        target = build;
                    }
                }
                if(target == null){
                    unit.vel.setZero();
                    return;
                }
                float reach = target.block.size * Vars.tilesize * 0.5f + unit.hitSize * 0.5f;
                float dst = unit.dst(target);
                float angle = unit.angleTo(target);
                if(dst > reach){
                    unit.vel.set(target.x - unit.x, target.y - unit.y).setLength(leech.speed);
                    unit.rotation = Angles.moveToward(unit.rotation, angle, leech.rotateSpeed * Time.delta);
                }else{
                    unit.vel.setZero();
                    unit.set(target.x + Angles.trnsx(angle, reach - 1f), target.y + Angles.trnsy(angle, reach - 1f));
                    unit.rotation = Angles.moveToward(unit.rotation, angle + 180f, leech.rotateSpeed * Time.delta);
                    target.damage(0.12f * Time.delta);
                }
            });
        });
    }
}
