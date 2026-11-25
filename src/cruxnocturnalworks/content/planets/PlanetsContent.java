package cruxnocturnalworks.content.planets;
import arc.graphics.Color;
import arc.math.geom.Mat3D;
import arc.math.geom.Vec3;
import arc.struct.Seq;
import arc.util.Tmp;
import mindustry.content.Planets;
import mindustry.graphics.g3d.*;
import mindustry.maps.planet.AsteroidGenerator;
import mindustry.type.Planet;
import cruxnocturnalworks.content.ContentVars;
import static cruxnocturnalworks.content.ContentVars.*;
public class PlanetsContent{
public static void load(){
ContentVars.orbitalStation = new Planet("orbitalstation", Planets.serpulo, 0.4f, 1){{
localizedName = "Orbital Station";
description = "A massive dark steel structure belonging to the Crux fraction and located on the moon of Serpulo.";
icon = "planet";
iconColor = Color.valueOf("aa5555ff");
radius = 0.4f;
orbitRadius = 4.5f;
rotateTime = 160f;
accessible = true;
hasAtmosphere = true;
atmosphereColor = Color.valueOf("7d292933");
atmosphereRadIn = 0f;
atmosphereRadOut = 0.09f;
lightSrcFrom = 0f;
lightSrcTo = 0f;
lightDstFrom = 0f;
lightDstTo = 0f;
updateLighting = false;
lightColor = Color.valueOf("7d2929ff");
camRadius = 0.25f;
minZoom = 0.95f;
maxZoom = 2f;
alwaysUnlocked = true;
startSector = 0;
orbitSpacing = 1.2f;
defaultCore = coreHeart;
generator = new AsteroidGenerator(){{
min = 1;
max = 1;
}};
meshLoader = () -> new MultiMesh(
new NoiseMesh(this, 42, 3, 0.38f, 1, 0.5f, 1f, 1f, Color.valueOf("7d2929ff"), Color.valueOf("212121ff"), 1, 0.5f, 1f, 0.5f),
new NoiseMesh(this, 67, 3, 0.25f, 1, 0.5f, 1f, 5.02f, Color.valueOf("21212188"), Color.valueOf("381f1f88"), 1, 0.5f, 1f, 0.5f)
);
cloudMeshLoader = () -> new HexSkyMesh(this, 27, 0f, 0.28f, 3, Color.valueOf("000000bb"), 1, 0.5f, 1f, 0.5f);
}};
}
}
