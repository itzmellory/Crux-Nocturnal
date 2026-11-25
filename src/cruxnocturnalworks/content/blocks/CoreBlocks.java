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
public class CoreBlocks{
public static void load(){
        ContentVars.coreHeart = new CoreBlock("core-heart"){{
            size=3; health=5200; itemCapacity=2700; unitType=researcher; unitCapModifier=8;
            requirements(Category.effect, ItemStack.with(Items.silicon,1300,Items.graphite,1600,structureMetall,8));
            alwaysUnlocked=true;
        }};
}
}
