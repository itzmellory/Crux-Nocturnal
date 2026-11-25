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
public class ProductionBlocks{
public static void load(){
        ContentVars.basicDrill = new Drill("basic-drill"){{
            size=2; tier=2; drillTime=800f; rotateSpeed=0.07f;
            requirements(Category.production, ItemStack.with(Items.graphite,20));
        }};
        ContentVars.hologramDrill = new BeamDrill("hologram-drill"){{
            size=2; range=2; drillTime=240f; tier=2;
            requirements(Category.production, ItemStack.with(Items.graphite,60));
        }};
        ContentVars.structureMetallDrill = new Drill("structure-metall-drill"){{
            size=3; tier=4; drillTime=5000f; rotateSpeed=0.05f;
            blockedItems.add(Items.sand, Items.lead);
            requirements(Category.production, ItemStack.with(Items.graphite,100,Items.silicon,50));
        }};
}
}
