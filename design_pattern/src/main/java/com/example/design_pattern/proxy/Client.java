package com.example.design_pattern.proxy;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        GameService gameService = new GameServiceProxy(); // 프록시를 거쳐서 핵심기능을 실행함
        gameService.startGame();
    }
}
