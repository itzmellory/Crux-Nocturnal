package cruxnocturnalworks.mechanics;
import arc.Events;
import mindustry.game.EventType.Trigger;
import mindustry.Vars;
import mindustry.gen.*;
import mindustry.world.*;
import mindustry.content.*;
import mindustry.entities.Fires;
import cruxnocturnalworks.content.ContentVars;
import static cruxnocturnalworks.content.ContentVars.*;
public class DrillLimitMechanics{
public static void load(){
Events.run(Trigger.update, ()->{
            if(Vars.state==null || Vars.state.isMenu() || Vars.player==null) return;
            Block target=structureMetallDrill;
            var buildings=Vars.state.teams.get(Vars.player.team()).buildings;
            int count=0;
            for(var build:buildings){
                if(build!=null && build.block==target && ++count>2){
                    build.tile.setAir();
                    Fx.breakBlock.at(build.x,build.y,build.block.size);
                    Vars.ui.hudfrag.showToast("Too noisy, no more than 2");
                }
            }
        });
}
}
