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
        int hp = getHp();
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
        setHp(hp);
    }

    public void basicAttack(Player player, int playerIndex) {
        int damage = getAd();
        player.decreaseHp(damage);

        System.out.printf("%d번 유저에게 %d의 데미지. 적의 공격으로 현재 남은 체력은 %d입니다.", playerIndex + 1, damage, player.getHp());
    }

    public void selfHeal(){
        int healingAmount = 7;
        int maxHp = getMaxHp();
        int hp = getHp();

        if (maxHp < hp + healingAmount) {
            System.out.println("적이 회복했지만 적은 이미 최대체력입니다.\n");
        } else {
            hp += healingAmount;
            setHp(hp);
            System.out.printf("적의 회복으로 현재 적의 체력은 %d입니다.\n", hp);
        }
    }

    public void action(Player player, int playerIndex) {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("적의 차례입니다.");
        int enemyAction = (int) (Math.random() * 10) + 1; // 1~10 사이 랜덤정수

        if (enemyAction == 1) {
            System.out.println("적은 섣불리 움직이지 못하고 있습니다.");
        } else if (2 <= enemyAction && enemyAction <= 8) {
            basicAttack(player, playerIndex);
        } else {
            selfHeal();
        }
    }
}
