package cruxnocturnalworks.content.units;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Mathf;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.Effect;
import mindustry.entities.abilities.ShieldArcAbility;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.entities.part.ShapePart;
import mindustry.gen.MechUnit;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import cruxnocturnalworks.content.ContentVars;
public class UnitsContent{
private static final Color dark = Color.valueOf("21151d");
private static final Color crimson = Color.valueOf("762235");
private static final Color red = Color.valueOf("bd354b");
private static final Color pale = Color.valueOf("e16a75");
private static final Effect darkMuzzle = new Effect(26f, e -> {
Draw.color(dark, crimson, e.fin());
Lines.stroke(2.4f * e.fout());
Lines.circle(e.x, e.y, 3f + e.fin() * 13f);
Angles.randLenVectors(e.id, 9, e.fin() * 19f, (x, y) -> {
Fill.circle(e.x + x, e.y + y, 1.1f * e.fout());
});
});
private static final Effect darkImpact = new Effect(42f, e -> {
Draw.color(dark, red, e.fin());
Lines.stroke(3.2f * e.fout());
Lines.circle(e.x, e.y, 5f + e.fin() * e.rotation);
Draw.color(pale);
Angles.randLenVectors(e.id, 14, e.fin() * e.rotation, (x, y) -> {
Fill.circle(e.x + x, e.y + y, 1.5f * e.fout());
});
});
private static final Effect pavonisImpact = new Effect(58f, e -> {
Draw.color(dark, crimson, e.fin());
Lines.stroke(4f * e.fout());
Lines.circle(e.x, e.y, 8f + e.fin() * e.rotation);
Draw.color(red);
Lines.stroke(1.5f * e.fout());
Lines.circle(e.x, e.y, 4f + e.fin() * e.rotation * 0.72f);
Angles.randLenVectors(e.id, 22, e.fin() * e.rotation, (x, y) -> {
Fill.circle(e.x + x, e.y + y, 2f * e.fout());
});
});
public static void load(){
ContentVars.researcher = new UnitType("researcher"){{
constructor = UnitEntity::create;
flying = true;
drag = 0.05f;
speed = 3.2f;
rotateSpeed = 15f;
accel = 0.1f;
health = 580f;
armor = 0f;
itemCapacity = 30;
buildSpeed = 1.35f;
mineFloor = true;
mineWalls = true;
mineTier = 2;
mineSpeed = 6.5f;
coreUnitDock = true;
outlineColor = Color.valueOf("222222");
parts.add(new ShapePart(){{
circle = true;
hollow = true;
radius = 8f;
stroke = 2f;
color = Color.valueOf("aa4444aa");
layer = 110f;
rotateSpeed = 1.5f;
}});
}};
ContentVars.elysium = new UnitType("a-elysium"){{
constructor = MechUnit::create;
speed = 0.35f;
hitSize = 8f;
health = 850f;
faceTarget = true;
armor = 8f;
range = 60f;
rotateSpeed = 3f;
drawCell = false;
targetAir = false;
outlineColor = Color.valueOf("222222");
mechLegColor = Color.valueOf("222222");
mechFrontSway = 0.2f;
mechSideSway = 0.4f;
mechStride = 3f;
legStraightness = 0f;
hovering = false;
immunities.add(StatusEffects.burning);
immunities.add(StatusEffects.melting);
abilities.add(new ShieldArcAbility(){{
max = 250f;
regen = 0f;
angle = 110f;
width = 2f;
radius = 3f;
whenShooting = false;
x = 0f;
y = 2f;
cooldown = Float.MAX_VALUE;
}});
weapons.add(new Weapon("a-elysium-shield-weapon"){{
showStatSprite = true;
x = 0f;
y = 0f;
mirror = false;
reload = 45f;
shootCone = 360f;
bullet = new BasicBulletType(1f, 45f){{
lifetime = 1f;
width = 0f;
height = 0f;
rangeOverride = 60f;
hitEffect = darkImpact;
shootEffect = darkMuzzle;
smokeEffect = Fx.none;
splashDamage = 19.5f;
splashDamageRadius = 60f;
collidesTeam = false;
instantDisappear = true;
despawnEffect = darkImpact;
}};
}});
}};
ContentVars.pavonis = new UnitType("a-pavonis"){{
constructor = MechUnit::create;
speed = 0.3f;
hitSize = 12f;
health = 2975f;
faceTarget = true;
armor = 12f;
range = 100f;
rotateSpeed = 2f;
drawCell = false;
targetAir = false;
outlineColor = Color.valueOf("222222");
mechLegColor = Color.valueOf("222222");
mechFrontSway = 0.2f;
mechSideSway = 0.4f;
mechStride = 3f;
legStraightness = 0f;
hovering = false;
immunities.add(StatusEffects.burning);
immunities.add(StatusEffects.melting);
parts.add(new RegionPart("-tail-inner"){{
mirror = true;
under = true;
x = 0f;
y = -4f;
moveRot = 65f;
moveX = 1f;
moveY = -3f;
}});
parts.add(new RegionPart("-tail-outer"){{
mirror = true;
under = false;
x = 0f;
y = -2f;
moveRot = 25f;
moveX = 0f;
moveY = 0f;
}});
abilities.add(new ShieldArcAbility(){{
max = 600f;
regen = 0.166f;
width = 2f;
angle = 110f;
radius = 6f;
whenShooting = true;
cooldown = 60f;
x = 0f;
y = 0f;
}});
weapons.add(new Weapon("a-pavonis-shield-weapon"){{
showStatSprite = true;
x = 0f;
y = 0f;
mirror = false;
reload = 120f;
shootCone = 360f;
bullet = new BasicBulletType(1f, 105f){{
lifetime = 1f;
width = 0f;
height = 0f;
rangeOverride = 60f;
status = StatusEffects.burning;
statusDuration = 180f;
hitEffect = pavonisImpact;
shootEffect = darkMuzzle;
smokeEffect = Fx.none;
splashDamage = 57.5f;
splashDamageRadius = 100f;
collidesTeam = false;
instantDisappear = true;
despawnEffect = pavonisImpact;
}};
}});
}};
}
}
