package com.example.design_pattern.proxy;

// 부가기능을 수행하는 프록시 클래스
public class GameServiceProxy implements GameService {

    private GameService gameService;

    @Override
    public void startGame() throws InterruptedException {
        long before = System.currentTimeMillis();
        if (this.gameService == null) {
            this.gameService = new DefaultGameService();
        }
        gameService.startGame();
        long end = System.currentTimeMillis();
        System.out.println(end - before);
    }

}
