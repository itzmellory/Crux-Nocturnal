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
public class UnitMechanics{
public static void load(){
Events.run(Trigger.update, ()->{
            if(Vars.state==null || Vars.state.isMenu()) return;
            Groups.unit.each(u->{
                if(u.type==pavonis && u.isShooting() && u.healthf()<0.51f){
                    Tile t=Vars.world.tileWorld(u.x,u.y);
                    if(t!=null) for(int dx=-1;dx<=1;dx++) for(int dy=-1;dy<=1;dy++){
                        Tile near=Vars.world.tile(t.x+dx,t.y+dy);
                        if(near!=null) Fires.create(near);
                    }
                }
            });
        });
}
}
