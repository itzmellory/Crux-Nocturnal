package cruxnocturnalworks.content.units;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.abilities.ShieldArcAbility;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.part.RegionPart;
import mindustry.entities.part.ShapePart;
import mindustry.gen.MechUnit;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.weapons.Weapon;
import cruxnocturnalworks.content.ContentVars;
public class UnitsContent{
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
cooldown = 2147483647f;
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
hitEffect = Fx.none;
shootEffect = Fx.explosion;
smokeEffect = Fx.none;
splashDamage = 19.5f;
splashDamageRadius = 60f;
collidesTeam = false;
instantDisappear = true;
despawnEffect = new WaveEffect(){{
lifetime = 35f;
sizeFrom = 0f;
sizeTo = 45f;
strokeFrom = 5f;
strokeTo = 0f;
colorFrom = Color.valueOf("222222");
colorTo = Color.valueOf("222222");
}};
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
hitEffect = Fx.none;
shootEffect = Fx.explosion;
smokeEffect = Fx.none;
splashDamage = 57.5f;
splashDamageRadius = 100f;
collidesTeam = false;
instantDisappear = true;
despawnEffect = new WaveEffect(){{
lifetime = 55f;
sizeFrom = 0f;
sizeTo = 55f;
strokeFrom = 5f;
strokeTo = 0f;
colorFrom = Color.valueOf("662222");
colorTo = Color.valueOf("aa4422");
}};
}};
}});
}};
}
}
