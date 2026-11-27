package cruxnocturnalworks.content.units;
import arc.Core;
import arc.math.Angles;
import arc.math.geom.Tmp;
import arc.util.Time;
import mindustry.Vars;
import mindustry.game.EventType.Trigger;
import mindustry.gen.Building;
import mindustry.gen.Groups;
import mindustry.gen.Unit;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import arc.Events;
public class HiddenUnitsContent{
public static UnitType leech;
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
lowAltitude = false;
targetAir = false;
targetGround = true;
faceTarget = false;
outlineColor = mindustry.graphics.Pal.darkerMetal;
load = () -> {
region = Core.atlas.find("crawler", Core.atlas.find("dagger"));
fullIcon = region;
};
}};
Events.run(Trigger.update, ()->{
if(Vars.state == null || Vars.state.isMenu() || Vars.world == null) return;
Groups.unit.each(unit->{
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
if(dst > reach){
unit.moveAt(Tmp.v1.set(target.x - unit.x, target.y - unit.y).setLength(leech.speed));
unit.rotation = Angles.moveToward(unit.rotation, unit.angleTo(target), leech.rotateSpeed * Time.delta);
}else{
float angle = unit.angleTo(target);
unit.vel.setZero();
unit.set(target.x + Angles.trnsx(angle, reach - 1f), target.y + Angles.trnsy(angle, reach - 1f));
unit.rotation = Angles.moveToward(unit.rotation, angle + 180f, leech.rotateSpeed * Time.delta);
target.damage(0.12f * Time.delta);
}
});
});
}
}
