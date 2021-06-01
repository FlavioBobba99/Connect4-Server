package core;

import util.PlayerStatus;

import java.net.Socket;

public class Player {

    private Socket playerSocket;
    private String nickName;
    private PlayerStatus status;

    public Player(Socket playerSocket, String nickName) {
        this.playerSocket = playerSocket;
        this.nickName = nickName;
    }

    public Socket getPlayerSocket() {
        return playerSocket;
    }

    public void setPlayerSocket(Socket playerSocket) {
        this.playerSocket = playerSocket;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }
}
