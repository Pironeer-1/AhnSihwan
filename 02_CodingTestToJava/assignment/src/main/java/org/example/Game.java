package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> playerList = new ArrayList<>();
    private Enemy enemy;
    private Scanner scanner = new Scanner(System.in);

    // 플레이어 리스트 반환
    public ArrayList<Player> getPlayers() {
        return playerList;
    }

    // 플레이어 초기 설정
    public void setPlayers(int point) {
        System.out.println("플레이어 인원을 정하세요: ");
        int playerCount = Integer.parseInt(scanner.nextLine());

        // playerList에 플레이어 추가
        for (int i = 0; i < playerCount; i++) {
            Player player = new Player();
            player.setStatus(point, scanner); // Scanner 객체 전달
            playerList.add(player);
        }
        // 여기서 scanner.close()를 하지 않습니다.
    }

    // 적 설정
    public void setEnemy() {
        int playerCount = getPlayers().size();
        enemy = new Enemy(playerCount);
    }

    // 턴 체크 메서드
    public boolean turnCheck() {
        playerList.removeIf(player -> player.getHp() <= 0);
        return !playerList.isEmpty() && enemy.getHp() > 0;
    }

    // 게임 진행 메서드
    public void game() {
        setPlayers(13); // 포인트를 13으로 설정
        setEnemy();

        // 턴 반복
        while (turnCheck()) {
            // 플레이어의 턴
            for (int playerIndex = 0; playerIndex < playerList.size(); playerIndex++) {
                Player player = playerList.get(playerIndex);
                player.attack(enemy, playerIndex, scanner);

                if (enemy.getHp() == 0) {
                    System.out.println("축하합니다! 승리하셨습니다!");
                    scanner.close(); // 스캐너 닫기
                    return; // 게임 종료
                }
            }

            // 적의 턴
            if (turnCheck()) {
                int targetIndex = (int) (Math.random() * playerList.size());
                Player targetPlayer = playerList.get(targetIndex);
                enemy.attack(targetPlayer, targetIndex);

                if (playerList.isEmpty()) {
                    System.out.println("아쉽지만 패배하셨습니다.");
                    scanner.close(); // 스캐너 닫기
                    return; // 게임 종료
                }
            } else {
                break;
            }
        }

        // 게임 종료 시 스캐너 닫기
        scanner.close();
    }
}