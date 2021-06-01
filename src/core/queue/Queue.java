package core.queue;

import core.Player;

import java.util.HashMap;
import java.util.Map;

public class Queue {

    private static Queue myQueue = null;

    private HashMap<Player,GameParameters> queue;

    private Queue(){

    }

    public static Queue getQueue(){
        if(myQueue==null)
            myQueue = new Queue();
        return myQueue;
    }

    public synchronized void addPlayerToQueue(Player player,GameParameters gameParameters){
        queue.put(player, gameParameters);
        for(Map.Entry<Player,GameParameters> entry : queue.entrySet()){

            if(gameParameters.compareParameters(entry.getValue())&&(player!= entry.getKey())){
                //TODO GENERAZIONE NUOVA PARTITA
            }
        }
    }

    public synchronized void removePlayer(Player p){
        queue.remove(p);
    }
}
