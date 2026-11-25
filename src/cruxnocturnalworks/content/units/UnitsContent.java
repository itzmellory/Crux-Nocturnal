package cruxnocturnalworks.content.units;
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
public class UnitsContent{
public static void load(){
        ContentVars.researcher = new UnitType("researcher"){{
            constructor = UnitEntity::new; flying = true; drag = 0.05f; speed = 3.2f;
            rotateSpeed = 15f; accel = 0.1f; health = 580; armor = 0;
            itemCapacity = 30; buildSpeed = 1.35f; mineFloor = true; mineWalls = true;
            mineTier = 2; mineSpeed = 6.5f; coreUnitDock = true;
        }};
        ContentVars.elysium = new UnitType("a-elysium"){{
            constructor=MechUnit::new; speed=0.35f; hitSize=8f; health=850; faceTarget=true;
            armor=8f; range=60f; rotateSpeed=3f; drawCell=false; targetAir=false;
            immunities.add(StatusEffects.burning,StatusEffects.melting);
            abilities.add(new ShieldArcAbility(){{
                max=250f; regen=0f; angle=110f; width=2f; radius=3f; whenShooting=false;
                x=0f;y=2f;cooldown=Float.MAX_VALUE;
            }});
        }};
        ContentVars.pavonis = new UnitType("a-pavonis"){{
            constructor=MechUnit::new; speed=0.3f; hitSize=12f; health=2975; faceTarget=true;
            armor=12f; range=100f; rotateSpeed=2f; drawCell=false; targetAir=false;
            immunities.add(StatusEffects.burning,StatusEffects.melting);
            abilities.add(new ShieldArcAbility(){{
                max=600f; regen=0.166f; width=2f; angle=110f; radius=6f;
                whenShooting=true; cooldown=60f;
            }});
        }};
}
}
