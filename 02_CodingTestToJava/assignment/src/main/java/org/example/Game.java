package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> playerList = new ArrayList<>();
    public ArrayList<Player> getPlayers() {
        return playerList;
    }


    public void setPlayers(int point) { // 플레이어 초기세팅
        Scanner scanner = new Scanner(System.in);
        System.out.println("플레이어 인원을 정하세요: ");
        int playerCount = Integer.parseInt(scanner.nextLine());

        // playerList 에 플레이어 추가
        for (int i=0; i < playerCount; i++) {
            Player player = new Player();
            player.setStatus(point);
            playerList.add(player);
        }
        scanner.close();
    }

    private Enemy enemy;
    public Enemy getEnemy() {
        return enemy;
    }
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void setEnemy() {
        int playerCount = getPlayers().size();
        enemy = new Enemy(playerCount);
    }


    // While turn_check (*player_list의 모든 player.Hp 가 0 이거나 enemy.hp=0 일 때까지)
        // [ Player의 턴 ]
        // for 문으로 player_list 에서 반복
                // Player.attack(~~)
                // if (Enemy.hp == 0){
                    //  break};
        // [ Enemy의 턴 ]
        // if (turn_check)
            // target player 지정
            // Enemy.attack(target_player)

    // if (Enemy.hp <= 0){
    //   "승리"
    // } else {
    //   "패배" }

//    public static void main(String[] args) {
//        Game game = new Game();
//        game.setPlayers(13);
//        game.setEnemy();
//    }

}
