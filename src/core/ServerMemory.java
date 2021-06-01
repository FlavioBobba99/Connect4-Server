package core;

import java.util.HashMap;

public class ServerMemory {

    private HashMap<String,Player> currentPlayersList;
    private static ServerMemory memory = null;

    private ServerMemory(){
        currentPlayersList = new HashMap<>();
    }

    public synchronized static ServerMemory getServerMemory(){
        if(memory==null)
            memory = new ServerMemory();
        return memory;
    }

    public synchronized void addPlayer(Player p){
        currentPlayersList.put(p.getNickName(),p);
        System.out.println("Player"+p.getNickName()+"added");
    }

}
