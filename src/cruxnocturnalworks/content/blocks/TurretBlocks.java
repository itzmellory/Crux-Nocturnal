package cruxnocturnalworks.content.blocks;
import arc.graphics.Color;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.world.meta.*;
import mindustry.game.*;
import mindustry.gen.*;
import cruxnocturnalworks.content.ContentVars;
import static cruxnocturnalworks.content.ContentVars.*;
public class TurretBlocks{
public static void load(){
        ContentVars.ichor = new ItemTurret("ichor"){{
            size=2; health=340; range=220f; reload=120f; recoil=1f; cooldownTime=180f;
            inaccuracy=10f; maxAmmo=15; rotateSpeed=4f; targetAir=true; targetGround=false;
            ammo(
                Items.lead, new MissileBulletType(5f,19.2f){{
                    width=20f;height=20f; lifetime=45f; homingDelay=25f; homingPower=0.18f;
                    homingRange=120f; weaveMag=3.5f; weaveScale=3f; splashDamage=5f;
                    splashDamageRadius=36f; collidesGround=false; status=StatusEffects.blasted;
                    statusDuration=180f;
                }},
                Items.silicon, new MissileBulletType(5f,35.1f){{
                    width=20f;height=20f; lifetime=36f; homingDelay=25f; homingPower=0.18f;
                    homingRange=90f; weaveMag=3.5f; weaveScale=3f; splashDamage=5f;
                    splashDamageRadius=20f; collidesGround=false; status=StatusEffects.blasted;
                    statusDuration=180f;
                }}
            );
            requirements(Category.turret, ItemStack.with(Items.lead,80,Items.silicon,15,Items.graphite,60));
        }};
        ContentVars.inflammation = new ItemTurret("inflammation"){{
            size=1; health=400; range=90f; reload=90f; maxAmmo=10; inaccuracy=5f; rotateSpeed=4f;
            targetAir=false; targetGround=true;
            ammo(
                Items.graphite, new MissileBulletType(3f,34.2f){{
                    width=24f;height=24f;lifetime=30f;homingPower=0.08f;homingRange=40f;
                    homingDelay=27f;splashDamage=17f;splashDamageRadius=36f;
                    status=StatusEffects.blasted;statusDuration=180f;
                    fragBullets=3;fragBullet=new BasicBulletType(2f,8f){{
                        lifetime=6f;status=StatusEffects.blasted;statusDuration=120f;
                    }};
                }},
                Items.silicon, new MissileBulletType(3f,34.2f){{
                    width=24f;height=24f;lifetime=30f;homingPower=0.2f;homingRange=60f;
                    homingDelay=20f;splashDamage=10f;splashDamageRadius=20f;
                    status=StatusEffects.blasted;statusDuration=180f;
                }},
                structureMetall, new MissileBulletType(2.9f,420f){{
                    width=24f;height=24f;lifetime=30f;splashDamage=50f;splashDamageRadius=40f;
                    status=StatusEffects.blasted;statusDuration=180f;
                }}
            );
            requirements(Category.turret, ItemStack.with(Items.silicon,30,Items.graphite,130));
        }};
}
}
