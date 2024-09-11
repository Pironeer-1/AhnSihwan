package org.example;

public class Enemy {
    private int maxHp;
    private int hp;
    private int ad;
    private int adDefense;
    private int apDefense;

    public Enemy(int playerCount){
        this.maxHp = 100 * playerCount;
        this.hp = 100 * playerCount;
        this.ad = 25;
        this.adDefense = 7;
        this.apDefense = 7;
    }

    // getter, setter 설정
    public int getMaxHp() {
        return maxHp;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getAd() {
        return ad;
    }
    public int getAdDefense() {
        return adDefense;
    }
    public int getApDefense() {
        return apDefense;
    }

    public void decreaseHp(int damage) {

    }

    public void action(Player player) {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("적의 차례입니다.");
        int enemyAction = (int) (Math.random() * 10) + 1; // 1~10 사이 랜덤정수

        if (enemyAction == 1) {
            System.out.println("적은 섣불리 움직이지 못하고 있습니다.");
        } else if (2 <= enemyAction && enemyAction <= 8) {
            basicAttack(player);
        } else {
            selfHeal();
        }
    }

    public void basicAttack(Player player) {

    }

    public void selfHeal(){

    }
}
