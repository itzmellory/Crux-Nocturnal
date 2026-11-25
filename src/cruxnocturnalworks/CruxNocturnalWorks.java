package cruxnocturnalworks;
import mindustry.mod.Mod;
import arc.Events;
import mindustry.game.EventType.Trigger;
import mindustry.gen.*;
import mindustry.entities.Fires;
import mindustry.world.Block;
import mindustry.content.Fx;
import mindustry.Vars;
import cruxnocturnalworks.content.blocks.*;
import cruxnocturnalworks.content.items.ItemsContent;
import cruxnocturnalworks.content.units.UnitsContent;
import cruxnocturnalworks.content.planets.PlanetsContent;
import cruxnocturnalworks.content.sectors.SectorsContent;
import cruxnocturnalworks.content.tech.PlanetTechTree;
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
PlanetTechTree.load();
cruxnocturnalworks.mechanics.UnitMechanics.load();
cruxnocturnalworks.mechanics.DrillLimitMechanics.load();
}
}
