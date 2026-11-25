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
public class DefenseBlocks{
public static void load(){
        ContentVars.structureWall = new Wall("structure-wall"){{
            health=620; chanceDeflect=0.06f;
            requirements(Category.defense, ItemStack.with(Items.silicon,8,structureMetall,1));
        }};
        ContentVars.structureLargeWall = new Wall("structure-large-wall"){{
            size=2; health=2480; chanceDeflect=0.2f;
            requirements(Category.defense, ItemStack.with(Items.silicon,25,structureMetall,4));
        }};
}
}
