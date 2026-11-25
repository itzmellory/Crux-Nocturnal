package cruxnocturnalworks.content.planets;
import arc.graphics.Color;
import arc.math.geom.Mat3D;
import arc.math.geom.Vec3;
import arc.struct.Seq;
import mindustry.content.Planets;
import mindustry.graphics.g3d.*;
import mindustry.maps.planet.AsteroidGenerator;
import cruxnocturnalworks.content.ContentVars;
import static cruxnocturnalworks.content.ContentVars.*;
public class PlanetsContent{
public static void load(){
ContentVars.orbitalStation = new mindustry.type.Planet("orbitalstation", Planets.serpulo, 0.4f, 1){{
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
meshLoader = () -> {
Seq<GenericMesh> meshes = new Seq<>();
meshes.add(new NoiseMesh(this, 42, 3, 0.38f, 4, 0.55f, 0.45f, 1f, Color.valueOf("7d2929ff"), Color.valueOf("212121ff"), 4, 0.6f, 0.38f, 0.43f));
meshes.add(new NoiseMesh(this, 67, 3, 0.25f, 4, 0.55f, 0.45f, 5.02f, Color.valueOf("21212188"), Color.valueOf("381f1f88"), 4, 0.6f, 0.38f, 0.43f));
addOrbitDecoration(this, meshes);
return new MultiMesh(meshes.toArray(GenericMesh.class));
};
cloudMeshLoader = () -> new MultiMesh(
new HexSkyMesh(this, 27, 0f, 0.28f, 3, Color.valueOf("000000bb"), 3, 0.28f, 1f, 0.5f),
new HexSkyMesh(this, 19, 0.03f, 0.105f, 3, Color.valueOf("9d2638").a(0.23f), 3, 0.28f, 1f, 0.5f)
);
}};
}
private static void addOrbitDecoration(mindustry.type.Planet planet, Seq<GenericMesh> meshes){
Color red = Color.valueOf("9f2434");
Color redLight = Color.valueOf("ed5960");
Color darkRed = Color.valueOf("4b1421");
addArc(planet, meshes, -205f, 35f, 30, 0.535f, 0.17f, 0.025f, red, redLight, 100);
addArc(planet, meshes, 42f, 128f, 14, 0.565f, 0.17f, 0.018f, darkRed, red, 200);
addArc(planet, meshes, 145f, 205f, 12, 0.525f, 0.17f, 0.014f, red, redLight, 300);
}
private static void addArc(mindustry.type.Planet planet, Seq<GenericMesh> meshes, float start, float end, int count, float radius, float tilt, float size, Color color1, Color color2, int seed){
for(int i = 0; i < count; i++){
float angle = start + (end - start) * i / (count - 1f);
float rad = (float)Math.toRadians(angle);
float x = (float)Math.cos(rad) * radius;
float z = (float)Math.sin(rad) * radius;
float y = (float)Math.sin(rad * 0.72f) * tilt;
NoiseMesh segment = new NoiseMesh(planet, seed + i, 1, size, 2, 0.6f, 1f, 0.12f, color1, color2, 3, 0.6f, 0.38f, 0.42f);
meshes.add(new MatMesh(segment, new Mat3D().setToTranslation(new Vec3(x, y, z))));
}
}
}
