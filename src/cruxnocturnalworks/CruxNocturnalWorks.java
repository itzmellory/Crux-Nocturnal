package cruxnocturnalworks;
import mindustry.Mod;
import arc.Events;
import mindustry.game.EventType.Trigger;
import mindustry.gen.*;
import mindustry.entities.Fires;
import mindustry.world.Block;
import mindustry.content.Fx;
import mindustry.Vars;
import cruxnocturnalworks.content.blocks.cores.CoreBlocks;
import cruxnocturnalworks.content.blocks.defense.DefenseBlocks;
import cruxnocturnalworks.content.blocks.distribution.DistributionBlocks;
import cruxnocturnalworks.content.blocks.environment.EnvironmentBlocks;
import cruxnocturnalworks.content.blocks.factories.FactoryBlocks;
import cruxnocturnalworks.content.blocks.production.ProductionBlocks;
import cruxnocturnalworks.content.blocks.turrets.TurretBlocks;
import cruxnocturnalworks.content.items.ItemsContent;
import cruxnocturnalworks.content.units.UnitsContent;
import cruxnocturnalworks.content.planets.PlanetsContent;
import cruxnocturnalworks.content.sectors.SectorsContent;
import cruxnocturnalworks.content.ContentVars;
import static cruxnocturnalworks.content.ContentVars.*;
public class CruxNocturnalWorks extends Mod{
@Override public void loadContent(){
ItemsContent.load();
UnitsContent.load();
CoreBlocks.load();
DefenseBlocks.load();
DistributionBlocks.load();
EnvironmentBlocks.load();
FactoryBlocks.load();
ProductionBlocks.load();
TurretBlocks.load();
PlanetsContent.load();
SectorsContent.load();
cruxnocturnalworks.mechanics.UnitMechanics.load();
cruxnocturnalworks.mechanics.DrillLimitMechanics.load();
}
}
