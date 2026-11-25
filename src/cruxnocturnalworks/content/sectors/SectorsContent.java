package cruxnocturnalworks.content.sectors;
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
public class SectorsContent{
public static void load(){
        ContentVars.preparationArea = new SectorPreset("preparation-area", orbitalStation, 0){{
            difficulty=4; alwaysUnlocked=true; captureWave=11;
        }};
}
}
