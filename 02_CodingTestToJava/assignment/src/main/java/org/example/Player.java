package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private int hp;
    private int ad;
    private int ap;

    public Player() {
        this.hp = 50;
        this.ad = 10;
        this.ap = 5;
    }

    // getter, setter 설정
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAd() {
        return ad;
    }
    public void setAd(int ad) {
        this.ad = ad;
    }

    public int getAp() {
        return ap;
    }
    public void setAp(int ap) {
        this.ap = ap;
    }

    public void setStatus(int point) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------");
        System.out.printf("%d만큼의 스테이터스를 추가합니다. 체력, 공격력, 마법력 순으로 입력하세요\n(1 포인트 당 체력 = 3, 공격력 = 1, 마법력 = 1 증가)\n", point);
        System.out.println("플레이어의 기본 스탯은 체력: 50, 공격력: 10, 마법력: 5입니다.\n");
        System.out.println("체력, 공격력, 마법력을 입력하세요. (띄어쓰기로 구분해서 세 개의 숫자를 입력)");

        while (true) {
            String input = scanner.nextLine();
            String[] points = input.split(" ");

            // 입력값 오류 겁증(1) 3개 값 아닌 경우
            if (points.length != 3) {
                System.out.println("세 개의 값을 입력하세요.");
                continue;
            }

            try {
                int hpPoint = Integer.parseInt(points[0]);
                int adPoint = Integer.parseInt(points[1]);
                int apPoint = Integer.parseInt(points[2]);

                if (hpPoint + adPoint + apPoint != point) { // 입력값 오류 검증(3) 총합이 point 와 다른 경우
                    System.out.printf("입력한 능력치의 총합이 %d와 같아야 합니다. 다시 입력해주세요.\n", point);
                    continue;
                } else {
                    int hp = getHp();
                    int ad = getAd();
                    int ap = getAp();
                    setHp(hp + hpPoint * 3);
                    setAd(ad + adPoint);
                    setAp(ap + apPoint);

                    System.out.printf("체력: %d, 공격력: %d, 마법력: %d \n", getHp(), getAd(), getAp());
                    break;
                }
            } catch (NumberFormatException e) { // 입력값 오류 겁증(2) 숫자 아닌 경우
                System.out.println("숫자를 입력해주세요.");
            }

        }

    }

    public void decreaseHp(int damage) {

    }

    public void checkStatus() {

    }

    public void basicAttack() {

    }

    public void magicAttack() {

    }

    public void selfHeal() {

    }
}


//    public static void main(String[] args) {
//        Player player = new Player();
//        player.setStatus(13);
//    }
