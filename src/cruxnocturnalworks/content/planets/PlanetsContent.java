package cruxnocturnalworks.content.planets;
import arc.graphics.Color;
import arc.math.Rand;
import arc.math.geom.Mat3D;
import arc.math.geom.Vec3;
import arc.struct.Seq;
import mindustry.content.Planets;
import mindustry.graphics.g3d.*;
import cruxnocturnalworks.content.ContentVars;
import static cruxnocturnalworks.content.ContentVars.*;
public class PlanetsContent{
public static void load(){
ContentVars.orbitalStation = new mindustry.type.Planet("orbitalstation", Planets.serpulo, 0.22f, 3){{
generator = new OrbitalStationPlanetGenerator();
meshLoader = () -> {
Seq<GenericMesh> meshes = new Seq<>();
Color surface = Color.valueOf("651b25");
Color surfaceLight = Color.valueOf("bd3945");
Color asteroid = Color.valueOf("173b3b");
Color asteroidLight = Color.valueOf("4e8174");
meshes.add(new NoiseMesh(this, 17, 3, radius, 4, 0.55f, 0.45f, 14f, surface, surfaceLight, 4, 0.6f, 0.38f, 0.43f));
Rand rand = new Rand(id + 73);
for(int i = 0; i < 76; i++){
float angle = rand.random(360f);
float distance = rand.random(0.47f, 0.7f);
float y = rand.random(-0.055f, 0.055f);
float size = rand.random(0.012f, 0.027f);
NoiseMesh rock = new NoiseMesh(this, i + 31, 1, size, 2, 0.6f, 0.38f, 20f, asteroid, asteroidLight, 3, 0.6f, 0.38f, 0.5f);
Vec3 offset = new Vec3().setToRandomDirection(rand);
offset.set((float)Math.cos(Math.toRadians(angle)) * distance, y, (float)Math.sin(Math.toRadians(angle)) * distance);
meshes.add(new MatMesh(rock, new Mat3D().setToTranslation(offset)));
}
return new MultiMesh(meshes.toArray(GenericMesh.class));
};
cloudMeshLoader = () -> new HexSkyMesh(this, 29, 0.08f, 1.03f, 4, Color.valueOf("a52c35").a(0.16f), 5, 0.18f, 1f, 0.32f);
radius = 0.4f;
rotateTime = 110f;
visible = true;
accessible = true;
hasAtmosphere = true;
atmosphereColor = Color.valueOf("b52d3c");
atmosphereRadIn = 0.008f;
atmosphereRadOut = 0.16f;
alwaysUnlocked = true;
startSector = 0;
sectorSeed = 0;
orbitSpacing = 1.2f;
orbitRadius = 5f;
defaultCore = coreHeart;
autoAssignPlanet = true;
}};
}
}
