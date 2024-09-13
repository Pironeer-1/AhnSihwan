package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> playerList = new ArrayList<>();
    private Enemy enemy;
    private Scanner scanner = new Scanner(System.in);

    public ArrayList<Player> getPlayers() {
        return playerList;
    }

    public void setPlayers(int point) { // 플레이어 초기세팅
        System.out.println("플레이어 인원을 정하세요: ");
        int playerCount = Integer.parseInt(scanner.nextLine());

        // playerList 에 플레이어 추가
        for (int i=0; i < playerCount; i++) {
            Player player = new Player();
            player.setStatus(point);
            playerList.add(player);
        }
    }

    public void setEnemy() {
        int playerCount = getPlayers().size();
        enemy = new Enemy(playerCount);
    }

    public boolean turnCheck() {
        playerList.removeIf(player -> player.getHp() <= 0);
        return !playerList.isEmpty() && enemy.getHp() != 0;
        // 플레이어 리스트 남아있고, 적 hp 0 이상이면 turnCheck = True
    }


    public void game() {
        setPlayers(13);
        setEnemy();

        // 턴 반복
        while (turnCheck()) {
            // 플레이어의 턴
            for (int playerIndex = 0; playerIndex < playerList.size(); playerIndex++) {
                Player player = playerList.get(playerIndex);
                player.attack(enemy, playerIndex, scanner);

                if (enemy.getHp() == 0) {
                    System.out.println("축하합니다! 승리하셨습니다!");
                    break;
                }
            }
            // 적의 턴
            if (turnCheck()) {
                int targetIndex = (int) (Math.random() * playerList.size());
                Player targetPlayer = playerList.get(targetIndex);
                enemy.attack(targetPlayer, targetIndex);

                if (playerList.isEmpty()) {
                    System.out.println("아쉽지만 패배하셨습니다.");
                    return;
                }
            } else {
                break;
            }
        }
        scanner.close();
    }
}
