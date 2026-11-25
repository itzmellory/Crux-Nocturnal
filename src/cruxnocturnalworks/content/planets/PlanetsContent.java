package cruxnocturnalworks.content.planets;
import arc.graphics.Color;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.world.meta.*;
import mindustry.game.*;
import mindustry.gen.*;
import cruxnocturnalworks.content.ContentVars;
import static cruxnocturnalworks.content.ContentVars.*;
public class PlanetsContent{
public static void load(){
        ContentVars.orbitalStation = new Planet("orbitalstation", Planets.serpulo, 4.5f, 3){{
            generator=new mindustry.maps.planet.SerpuloPlanetGenerator();
            meshLoader=()->new mindustry.graphics.g3d.HexMesh(this,3);
            cloudMeshLoader=()->new mindustry.graphics.g3d.HexSkyMesh(this,27,0.28f,3.6f,3,arc.graphics.Color.valueOf("000000bb"),3,0.28f,1f,0.5f);
            radius=0.4f; rotateTime=160f; accessible=true; hasAtmosphere=true;
            atmosphereColor=arc.graphics.Color.valueOf("7d292933");
            alwaysUnlocked=true; defaultCore=coreHeart;
        }};
}
}
