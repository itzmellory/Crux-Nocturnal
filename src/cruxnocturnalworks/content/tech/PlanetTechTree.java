package cruxnocturnalworks.content.tech;

import arc.struct.Seq;
import mindustry.content.TechTree;
import mindustry.game.Objectives;
import mindustry.type.Planet;
import mindustry.world.Block;
import cruxnocturnalworks.content.ContentVars;

import static cruxnocturnalworks.content.ContentVars.*;

public class PlanetTechTree {
    public static void load() {
        Planet planet = ContentVars.orbitalStation;
        TechTree.TechNode root = TechTree.nodeRoot("orbitalstation", coreHeart, () -> {
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
            TechTree.node(elysium);
            TechTree.node(pavonis);
            TechTree.node(ashTree);
            TechTree.node(petalsA);
            TechTree.node(petalsB);
            TechTree.node(petalsC);
            TechTree.node(structureConcrete);
        });
        root.each(node -> node.planet = planet);
        root.addPlanet(planet);
        planet.techTree = root;
    }
}
