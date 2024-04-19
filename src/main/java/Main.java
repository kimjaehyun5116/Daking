package main.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();

        while (true) {
            System.out.println("===== 메뉴를 선택해주세요 =====");
            System.out.println("1. 식단 구성하기");
            System.out.println("2. 음식 정보 조회");
            System.out.println("3. 종료");
            System.out.print("메뉴를 선택하세요 : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    User user = User.getUserInfoFromInput();
                    DietPlanner dietPlanner = new DietPlanner(database, user, 1.0);
                    choiceDietPlanner(user, dietPlanner);
                    break;
                case 2:
                    showFoodInfoMenu(database, scanner); // 음식 정보 조회 메뉴
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    private static void choiceDietPlanner(User user , DietPlanner dietPlanner) {

        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        System.out.println("===== 메뉴를 선택해주세요 =====");
        System.out.println("1. 식단 랜덤으로 구성하기");
        System.out.println("2. 식단 선택하여 구성하기");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                dietPlanner.provideDietPlan(user); // 식단 계획 제공 메서드 호출
                break;
            case 2:
                dietPlanner.choiceDietPlan(user);
                break;
        }
    }

    private static void showFoodInfoMenu(Database database, Scanner scanner) {
        System.out.println("==== 음식 정보 조회 메뉴 ====");
        System.out.println("1. 그룹별 조회하기");
        System.out.println("2. 식품명으로 조회하기");
        System.out.println("3. 전체 목록 조회하기");
        System.out.println("4. 이전 메뉴로 돌아가기");
        System.out.print("메뉴를 선택하세요 : ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                database.showGroupedFoods(scanner); // 그룹별 음식 조회 메서드 호출
                break;
            case 2:
                System.out.print("조회할 식품명을 입력하세요 (ex: 닭가슴살) : ");
                String foodName = scanner.nextLine();
                Food food = database.searchFood(foodName);
                if (food != null) {
                    System.out.println("===== 조회 결과 =====");
                    System.out.println(food);
                } else {
                    System.out.println("입력한 음식명에 해당하는 음식이 없습니다.");
                }
                break;
            case 3:
                database.showPredefinedFoods(); //전체 목록 조회 메서드 호출
                break;
            case 4:
                return;
            default:
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        }
    }

}