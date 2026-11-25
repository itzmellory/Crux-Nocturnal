package cruxnocturnalworks;
import arc.Events;
import arc.graphics.Color;
import arc.graphics.Gl;
import arc.math.geom.Vec3;
import arc.util.Tmp;
import mindustry.Vars;
import mindustry.game.EventType.Trigger;
import mindustry.mod.Mod;
import cruxnocturnalworks.content.blocks.CoreBlocks;
import cruxnocturnalworks.content.blocks.DefenseBlocks;
import cruxnocturnalworks.content.blocks.DistributionBlocks;
import cruxnocturnalworks.content.blocks.EnvironmentBlocks;
import cruxnocturnalworks.content.blocks.FactoryBlocks;
import cruxnocturnalworks.content.blocks.ProductionBlocks;
import cruxnocturnalworks.content.blocks.TurretBlocks;
import cruxnocturnalworks.content.items.ItemsContent;
import cruxnocturnalworks.content.units.UnitsContent;
import cruxnocturnalworks.content.planets.PlanetsContent;
import cruxnocturnalworks.content.sectors.SectorsContent;
import cruxnocturnalworks.content.tech.PlanetTechTree;
import cruxnocturnalworks.content.ContentVars;
public class CruxNocturnalWorks extends Mod{
@Override
public void loadContent(){
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
Events.run(Trigger.universeDraw, () -> {
if(ContentVars.orbitalStation == null || ContentVars.orbitalStation.parent == null || Vars.renderer == null) return;
Vec3 center = ContentVars.orbitalStation.parent.position;
float radius = ContentVars.orbitalStation.orbitRadius;
float tilt = 28f;
float cos = (float)Math.cos(Math.toRadians(tilt));
float sin = (float)Math.sin(Math.toRadians(tilt));
int points = 180;
Color orbitColor = Color.valueOf("9d4149").a(0.62f);
for(int i = 0; i < points; i++){
float angle = (float)(Math.PI * 2d * i / points);
float x = (float)Math.cos(angle) * radius;
float z = (float)Math.sin(angle) * radius * cos;
float y = (float)Math.sin(angle) * radius * sin;
Vars.renderer.planets.batch.vertex(Tmp.v32.set(center).add(x, y, z), orbitColor);
}
Vars.renderer.planets.batch.flush(Gl.lineLoop);
});
}
}
