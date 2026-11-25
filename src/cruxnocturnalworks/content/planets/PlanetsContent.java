package cruxnocturnalworks.content.planets;
import arc.graphics.Color;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.*;
import cruxnocturnalworks.content.ContentVars;
import static cruxnocturnalworks.content.ContentVars.*;
public class PlanetsContent{
public static void load(){
ContentVars.orbitalStation = new Planet("orbitalstation", Planets.sun, 1f, 3){{
generator = new mindustry.maps.planet.SerpuloPlanetGenerator();
meshLoader = () -> new mindustry.graphics.g3d.HexMesh(this, 5);
cloudMeshLoader = () -> new mindustry.graphics.g3d.HexSkyMesh(this, 27, 0.28f, 3.6f, 3, Color.valueOf("000000bb"), 3, 0.28f, 1f, 0.5f);
radius = 0.4f;
rotateTime = 160f;
accessible = true;
visible = true;
hasAtmosphere = true;
atmosphereColor = Color.valueOf("7d292933");
atmosphereRadIn = 0.02f;
atmosphereRadOut = 0.3f;
alwaysUnlocked = true;
startSector = 0;
sectorSeed = 0;
orbitSpacing = 2f;
defaultCore = coreHeart;
autoAssignPlanet = true;
}};
}
}
