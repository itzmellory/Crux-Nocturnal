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
public class FactoryBlocks{
public static void load(){
        ContentVars.siliconBasicFactory = new GenericCrafter("silicon-basic-factory"){{
            size=2; hasItems=true; craftTime=120f; itemCapacity=10;
            requirements(Category.crafting, ItemStack.with(Items.graphite,50));
            consumeItems(ItemStack.with(Items.graphite,5,Items.sand,10));
            outputItem=new ItemStack(Items.silicon,10);
        }};
}
}
