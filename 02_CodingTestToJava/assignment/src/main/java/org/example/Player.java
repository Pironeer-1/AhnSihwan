package org.example;
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
        int hp = getHp();
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
        setHp(hp);
    }

    public void checkStatus(Enemy enemy) {
        System.out.printf("현재 유저: 체력 %d, 공격력 %d, 마법력 %d", getHp(), getAd(), getAp());
        System.out.printf("적: 체력 %d, 공격력 %d, 방어력 %d, 마법 방어력 %d\n", enemy.getHp(), enemy.getAd(), enemy.getAdDefense(), enemy.getApDefense());
        int damage = getAd() - enemy.getAdDefense();
        enemy.decreaseHp(damage);
        System.out.printf("일반 공격으로 %d의 데미지를 주었습니다.\n", damage);
    }

    public void basicAttack(Enemy enemy) {
        int criticalPoint = (int) (Math.random() * 10) + 1; // 1~10 사이 랜덤정수
        int damage = getAd() - enemy.getAdDefense();

        if (criticalPoint > 2) {
            enemy.decreaseHp(damage);
            System.out.printf("일반 공격으로 %d의 데미지를 주었습니다.\n", damage);
        } else {
            damage *= 2;
            enemy.decreaseHp(damage);
            System.out.printf("치명타가 적용되어 %d의 데미지를 주었습니다.\n", damage);
        }
    }

    public void magicAttack(Enemy enemy) {
        int damage = getAp() * 2 - enemy.getApDefense();
        enemy.decreaseHp(damage);
        System.out.printf("마법 공격으로 %d의 데미지를 주었습니다.\n", damage);
    }

    public void selfHeal() {
        int healPoint = (int) (Math.random() * 5) + 5; // 5~10 사이 랜덤정수
        int hp = getHp() + healPoint;
        System.out.printf("체력을 회복합니다. 현재 hp는 %d입니다.\n", hp);
        setHp(hp);
    }

    public void attack(Enemy enemy, int playerIndex, Scanner scanner) {
        while (true) {
            try {
                System.out.println("------------------------------------------------------------------------------\n");
                System.out.printf("%d번 플레이어의 차례입니다. 행동을 선택하세요. (1: 스테이터스 확인 + 일반 공격, 2: 기본 공격, 3: 마법 공격, 4: 체력 회복, exit: 종료)\n", playerIndex + 1);
                String input = scanner.nextLine();
                if (input.equals("exit")) {
                    System.out.println("프로그램을 종료합니다.\n");
                    System.exit(0);
                }

                int inputKey = Integer.parseInt(input);

                switch (inputKey) {
                    case 1:
                        checkStatus(enemy);
                        break;

                    case 2:
                        basicAttack(enemy);
                        break;

                    case 3:
                        magicAttack(enemy);
                        break;

                    case 4:
                        selfHeal();
                        break;

                    default:
                        System.out.println("유효한 숫자를 입력하세요. (1: 스테이터스 확인 + 일반 공격, 2: 기본 공격, 3: 마법 공격, 4: 체력 회복\n");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.\n");
            }
        }
    }
}



