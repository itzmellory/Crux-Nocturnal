package cruxnocturnalworks.content.planets;
import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Vec3;
import arc.util.noise.Ridged;
import arc.util.noise.Simplex;
import mindustry.maps.planet.SerpuloPlanetGenerator;
public class OrbitalStationPlanetGenerator extends SerpuloPlanetGenerator{
private final Color deep = Color.valueOf("35121b");
private final Color dark = Color.valueOf("5a1724");
private final Color red = Color.valueOf("8e2634");
private final Color crimson = Color.valueOf("c33d49");
private final Color bright = Color.valueOf("e05a5c");
private final Color shadow = Color.valueOf("481722");
private final Color pale = Color.valueOf("d94a50");
public OrbitalStationPlanetGenerator(){baseSeed=24681;}
@Override
public float getHeight(Vec3 position){
float broad = Simplex.noise3d(seed + 11, 3, 0.58f, 0.72f, position.x, position.y, position.z);
float detail = Simplex.noise3d(seed + 12, 7, 0.52f, 1.45f, position.x, position.y, position.z);
float ridges = Ridged.noise3d(baseSeed, position.x, position.y, position.z, 5, 2f);
float bands = (float)Math.sin((position.y * 7.5f + broad * 0.42f) * Math.PI);
return Mathf.clamp(0.22f + broad * 0.16f + detail * 0.055f + Math.max(0f, bands) * ridges * 0.12f, 0.02f, 0.72f);
}
@Override
public void getColor(Vec3 position, Color out){
float broad = Simplex.noise3d(seed + 11, 3, 0.58f, 0.72f, position.x, position.y, position.z);
float detail = Simplex.noise3d(seed + 12, 7, 0.52f, 1.45f, position.x, position.y, position.z);
float fine = Simplex.noise3d(seed + 13, 13, 0.5f, 2.2f, position.x, position.y, position.z);
float ridges = Ridged.noise3d(baseSeed, position.x, position.y, position.z, 5, 2f);
float bands = (float)Math.sin((position.y * 7.5f + broad * 0.42f) * Math.PI);
float height = getHeight(position);
float shade = Mathf.clamp((broad + 0.45f) * 0.72f + detail * 0.18f);
if(height < 0.2f){
out.set(deep).lerp(dark, shade);
}else if(bands > 0.25f && ridges > 0.28f){
out.set(shadow).lerp(crimson, Mathf.clamp(ridges * 1.15f));
}else{
out.set(dark).lerp(red, shade);
}
if(fine > 0.34f){
out.lerp(bright, Mathf.clamp((fine - 0.34f) * 0.42f));
}else if(fine < -0.32f){
out.lerp(deep, Mathf.clamp((-fine - 0.32f) * 0.42f));
}
if(Math.abs(position.y) > 0.88f){
out.lerp(pale, Mathf.clamp((Math.abs(position.y) - 0.88f) * 2.2f));
}
}
}
