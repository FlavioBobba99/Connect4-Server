package core.queue;

import core.queue.util.GameDuration;

public class GameParameters {

    public GameDuration duration;

    public GameParameters(){
        //TODO FORSE
    }

    public void setDuration(String s){
        if(s=="f")
            this.duration = GameDuration.SHORT;
        if(s=="l")
            this.duration = GameDuration.LONG;
    }

    public boolean compareParameters(GameParameters gameParameters){
        if(this.duration==gameParameters.duration)
            return true;
        return false;
    }

}
