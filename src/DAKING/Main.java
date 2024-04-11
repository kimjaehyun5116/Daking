package DAKING;

import java.util.Scanner;
import DAKING.User;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();

        while (true) {
            System.out.println("===== 메뉴를 선택해주세요 =====");
            System.out.println("1. 식단 구성하기");
            System.out.println("2. 음식 정보 조회");
            System.out.println("3. 음식 정보 추가");
            System.out.println("4. 음식 정보 수정");
            System.out.println("5. 음식정보 삭제");
            System.out.println("6. 종료");
            System.out.print("메뉴를 선택하세요 : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // 사용자 정보 입력
                    User user = User.getUserInfoFromInput();
                    // DietPlanner 클래스 인스턴스 생성
                    DietPlanner dietPlanner = new DietPlanner(database, user, 1.0);
                    dietPlanner.provideDietPlan(user); // 식단 계획 제공 메서드 호출
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}