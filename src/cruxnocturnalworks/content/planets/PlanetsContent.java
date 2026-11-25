package cruxnocturnalworks.content.planets;
import arc.graphics.Color;
import mindustry.content.Planets;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.maps.planet.SerpuloPlanetGenerator;
import cruxnocturnalworks.content.ContentVars;
import static cruxnocturnalworks.content.ContentVars.*;
public class PlanetsContent{
public static void load(){
ContentVars.orbitalStation = new mindustry.type.Planet("orbitalstation", Planets.serpulo, 0.22f, 3){{
generator = new SerpuloPlanetGenerator();
meshLoader = () -> new HexMesh(this, 5);
cloudMeshLoader = () -> new MultiMesh(
new HexSkyMesh(this, 48, 0.16f, 1.8f, 4, Color.valueOf("a52c35").a(0.58f), 7, 0.18f, 1.1f, 0.35f),
new HexSkyMesh(this, 32, 0.29f, 2.6f, 3, Color.valueOf("3a1018").a(0.72f), 19, 0.22f, 0.8f, 0.28f)
);
radius = 0.4f;
rotateTime = 110f;
visible = true;
accessible = true;
hasAtmosphere = true;
atmosphereColor = Color.valueOf("9e2635");
atmosphereRadIn = 0.018f;
atmosphereRadOut = 0.27f;
alwaysUnlocked = true;
startSector = 0;
sectorSeed = 0;
orbitSpacing = 3f;
orbitRadius = 15f;
defaultCore = coreHeart;
autoAssignPlanet = true;
}};
}
}
