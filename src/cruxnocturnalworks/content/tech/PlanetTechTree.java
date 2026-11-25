package cruxnocturnalworks.content.tech;
import mindustry.content.TechTree;
import static cruxnocturnalworks.content.ContentVars.*;
public class PlanetTechTree{
public static void load(){
orbitalStation.techTree = TechTree.nodeRoot("orbitalstation", orbitalStation, () -> {
TechTree.node(coreHeart, () -> {
TechTree.node(structureWall, () -> {
TechTree.node(structureLargeWall);
});
TechTree.node(magneticRail);
TechTree.node(siliconBasicFactory);
TechTree.node(basicDrill, () -> {
TechTree.node(hologramDrill);
TechTree.node(structureMetallDrill);
});
TechTree.node(ichor);
TechTree.node(inflammation);
TechTree.node(elysium, () -> {
TechTree.node(pavonis);
});
TechTree.node(ashTree);
TechTree.node(petalsA);
TechTree.node(petalsB);
TechTree.node(petalsC);
TechTree.node(structureConcrete);
});
TechTree.nodeProduce(structureMetall, () -> {});
});
}
}
