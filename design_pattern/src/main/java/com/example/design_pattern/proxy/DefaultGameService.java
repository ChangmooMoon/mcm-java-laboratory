package com.example.design_pattern.proxy;

// 실제 서비스 핵심기능
public class DefaultGameService implements GameService {

    @Override
    public void startGame() throws InterruptedException {
        System.out.println("게임 시작");
        Thread.sleep(1000L);
    }
}
