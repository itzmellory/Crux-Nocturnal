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
public class EnvironmentBlocks{
public static void load(){
        ContentVars.ashTree = new TreeBlock("ash-tree"){{
            breakable=false; rotate=true; clipSize=128f;
        }};
        ContentVars.petalsA = new OverlayFloor("ashtree-petals-a"){{
            variants=3; attributes.set(Attribute.heat,0.5f);
        }};
        ContentVars.petalsB = new OverlayFloor("ashtree-petals-b"){{
            variants=3; attributes.set(Attribute.heat,1f);
        }};
        ContentVars.petalsC = new OverlayFloor("ashtree-petals-c"){{
            variants=3; attributes.set(Attribute.heat,1.5f);
        }};
        ContentVars.structureConcrete = new Floor("structure-concrete"){{
            variants=3; itemDrop=structureMetall; playerUnmineable=false;
            mapColor=arc.graphics.Color.valueOf("989aa4");
        }};
}
}
