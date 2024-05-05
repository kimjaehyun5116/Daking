package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class DietPlanner {

    private Database database;
    private User user;
    private Scanner scanner;
    private double metabolicRate;


    public DietPlanner(Database database, User user, double metabolicRate) {
        this.database = database;
        this.user = user;
        this.metabolicRate = metabolicRate;
        this.scanner = new Scanner(System.in);
    }

    public void provideDietPlan(User user) {

        System.out.println("================================================");
        System.out.println("식단 계획을 제공합니다.");

        // 유저의 기초대사랑 (BMR) 계산

        int bmr;
        if (user.getGender() == '남') {
            // 남성의 경우 대사율 계산 방법
            bmr = (int) (66.5 + (13.75 * user.getWeight()) + (5.003 * user.getHeight()) - (6.755 * user.getAge()));
        } else {
            // 여성의 경우 대사율 계산 방법
            bmr = (int) (655.1 + (9.563 * user.getWeight()) + (1.850 * user.getHeight()) - (4.676 * user.getAge()));
        }

        // 필요대사량 구하기 (기초대사량*활동대사량)+목표
        double neededCalories = (bmr * getMetabolicRateFromActivityLevel()) + adjustMetabolicRateBasedOnDietPurpose();

        // 식단 비율 선택
        double[] macronutrientRatios = selectMacronutrientRatios();

        // 하루 끼니 수 선택
        int numMeals = selectNumberOfMeals(user);

        // 한 끼당 필요한 칼로리 계산
        double caloriesPerMeal = neededCalories / numMeals;

        test(bmr, numMeals, macronutrientRatios, neededCalories);


        // 각 끼니별로 음식을 추천하여 출력
        recommendFoodsForMeals((int) caloriesPerMeal, macronutrientRatios, (int) numMeals);
    }
    private void recommendFoodsForMeals(int caloriesPerMeal, double[] requiredCarbohydrate, int numMeals) {
        List<Food> recommendedFoods = new ArrayList<>();
        Random random = new Random();

        // 각 끼니마다 음식 추천
        for (int i = 0; i < numMeals; i++) {
            // 음식 데이터베이스에서 랜덤하게 음식 선택
            List<Food> allFoods = database.getAllFood();
            Food randomFood = allFoods.get(random.nextInt(allFoods.size()));

            // 추천된 음식을 리스트에 추가
            recommendedFoods.add(randomFood);

        }
    }

    public void SampleDietPlan(User user) {

        System.out.println("================================================");
        System.out.println("메뉴를 선택해주세요.");
        System.out.println("1. 샘플 벌크업 식단 보기");
        System.out.println("2. 샘플 다이어트 식단 보기");
        System.out.print("메뉴를 선택하세요 : ");

        int sampleChoice = scanner.nextInt();
        scanner.nextLine();

        switch (sampleChoice) {
            case 1:
                bulkUpDietSample();
                break;
            case 2:

                dietDietsample();
                break;

            default:
                System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                return;
        }
    }
        public static void bulkUpDietSample() {
            System.out.println("벌크업을 위한 식단은 고단백, 고탄수화물, 그리고 적정양의 지방을 포함하는 것이 일반적입니다.");
            System.out.println("아래는 벌크업을 위한 샘플 식단표의 예시입니다. 이는 단순한 예시이며, 각 개인의 몸무게, 목표 등에따라 조절되어야 합니다.");
            System.out.println("또한, 식단은 영양학적으로 균형을 이루는 것이 중요하므로 이를 고려하여 구성되어야 합니다.");
            System.out.println("===============================================================================");

            // 아침
            System.out.println("아침");
            System.out.println("계란 3개");
            System.out.println("오트밀 100g");
            System.out.println("바나나 1개");
            System.out.println("닭가슴살 샐러드");

            // 간식 1
            System.out.println("\n간식 (1)");
            System.out.println("견과류 혼합 1/4컵");
            System.out.println("그릭 요거트 1컵");
            System.out.println("사과 2개");

            // 점심
            System.out.println("\n점심");
            System.out.println("갈비찜 200g");
            System.out.println("현미 300g");
            System.out.println("콩 샐러드");
            System.out.println("시금치 스프");

            // 간식 2
            System.out.println("\n간식 (2)");
            System.out.println("닭가슴살 샌드위치");
            System.out.println("아몬드 우유 1잔");
            System.out.println("바나나 3개");

            // 저녘
            System.out.println("\n저녘");
            System.out.println("연어 스테이크 200g");
            System.out.println("감자 3개");
            System.out.println("브로콜리 스팀 1컵");
            System.out.println("올리브 오일 드레싱");

        }
        public static void dietDietsample() {
            System.out.println("다이어트를 위한 식단은 칼로리를 제한하면서도 영양소를 균형 있게 섭취하여 건강하게 체중을 감량하는데 도움이 됩니다.");
            System.out.println("아래는 다이어트를 위한 샘플 식단표의 예시입니다. 이는 단순한 예시이며, 각 개인의 몸무게, 목표 등에따라 조절되어야 합니다. ");
            System.out.println("또한, 식단은 영양학적으로 균형을 이루는 것이 중요하므로 이를 고려하여 구성되어야 합니다.");
            System.out.println("===============================================================================");

            // 아침
            System.out.println("아침");
            System.out.println("삶은 계란 2개");
            System.out.println("샐러드");
            System.out.println("닭가슴살 샐러드");

            // 간식 1
            System.out.println("\n간식 (1)");
            System.out.println("그릭 요거트와 소량의 과일");

            // 점심
            System.out.println("\n점심");
            System.out.println("참치 샐러드 샌드위치 ½쪽");
            System.out.println("양배추 슬로우");

            // 간식 2
            System.out.println("\n간식 (2)");
            System.out.println("건강한 영양바");

            // 저녘
            System.out.println("\n저녘");
            System.out.println("연어 스테이크 100g");
            System.out.println("채소볶음");
            System.out.println("통밀빵 1쪽");

        }


        public void choicedFoodsForMeals ( double caloriesPerMeal, double[] requiredCarbohydrate, int numMeals){
            List<Food> recommendedFoods = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);

            // 사용자가 각 영양소에 해당하는 음식 이름을 입력하여 추천 음식을 가져옴
            for (int i = 0; i < numMeals; i++) {
                System.out.print("===== 음식을 선택해주세요 =====");
                System.out.print("1. 탄수화물 :");
                System.out.print("2. 단백질 :");
                System.out.print("3. 지방 :");
                System.out.print("4. 간식 :");

                int nutrientChoice = scanner.nextInt();
                scanner.nextLine();

                String nutrient = "";

                // 사용자가 선택한 영양소에 따라 영양소 이름 설정
                switch (nutrientChoice) {
                    case 1:
                        nutrient = "탄수화물";
                        break;
                    case 2:
                        nutrient = "단백질";
                        break;
                    case 3:
                        nutrient = "지방";
                        break;
                    case 4:
                        nutrient = "간식";
                        break;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                        return;
                }

                System.out.print(nutrient + " 음식을 입력하세요: ");
                String foodName = scanner.nextLine();

                // 입력한 음식 이름으로 음식 데이터베이스에서 음식을 가져옴
                Food recommendedFood = database.getByName(foodName);

                // 추천된 음식을 리스트에 추가
                if (recommendedFood != null) {
                    recommendedFoods.add(recommendedFood);

                    // 음식 정보 출력
                    System.out.println("추천된 음식: " + recommendedFood.getName());
                    System.out.println("칼로리: " + recommendedFood.getCalories() + "kcal");
                    System.out.println("탄수화물: " + recommendedFood.getCarbohydrates() + "g");
                    System.out.println("단백질: " + recommendedFood.getProtein() + "g");
                    System.out.println("지방: " + recommendedFood.getFat() + "g");

                } else {
                    System.out.println("해당하는 음식이 데이터베이스에 없습니다.");
                }
            }
        }
    private double getMetabolicRateFromActivityLevel() {
        System.out.println("================================================");
        System.out.println("활동 수준을 선택하세요");
        System.out.print("1.거의 없음 2.가벼운 활동(주 1~3회 운동) 3.보통 활동(주 3~5회 운동) 4.매우 활동적(하루에 운동 2회 이상) : ");
        int activityChoice = scanner.nextInt();
        double metabolicRate;

        switch (activityChoice) {
            case 1:
                metabolicRate = 1.2;
                break;
            case 2:
                metabolicRate = 1.375;
                break;
            case 3:
                metabolicRate = 1.55;
                break;
            case 4:
                metabolicRate = 1.725;
                break;
            default:
                System.out.println("잘못된 입력입니다. 기본값으로 보통을 선택합니다.");
                metabolicRate = 1.2;
                break;
        }

        return metabolicRate;
    }

    private int adjustMetabolicRateBasedOnDietPurpose() {
        System.out.println("================================================");
        System.out.println("식단 목적을 선택하세요");
        System.out.print("1. 다이어트 2. 벌크업 3. 건강 유지 : ");
        int dietPurposeChoice = scanner.nextInt();

        switch (dietPurposeChoice) {
            case 1:
                metabolicRate -= 500; // 다이어트일 경우 필요 칼로리에서 500을 빼줌
                break;
            case 2:
                metabolicRate += 500; // 벌크업일 경우 필요 칼로리에 500을 더해줌
                break;
            case 3:
                // 건강 유지일 경우 아무 조정 없음
                break;
            default:
                System.out.println("잘못된 입력입니다. 기본값으로 건강 유지를 선택합니다.");
                break;
        }

        return (int) metabolicRate;
    }

    private double[] selectMacronutrientRatios() {
        System.out.println("================================================");
        System.out.println("식단 비율을 선택하세요");
        System.out.println("1. 벌크업 (5:3:2)");
        System.out.println("2. 다이어트 (4:4:2)");
        System.out.println("3. 균형 식사 (4:3:3)");
        System.out.println("4. 키토제닉 다이어트 (5:20:75)");
        System.out.println("5. 사용자 지정");
        System.out.print("번호를 입력하세요 : ");

        int choice = scanner.nextInt();
        double[] macronutrientRatios = new double[3];

        switch (choice) {
            case 1:
                macronutrientRatios = new double[]{0.5, 0.3, 0.2};
                break;
            case 2:
                macronutrientRatios = new double[]{0.4, 0.4, 0.2};
                break;
            case 3:
                macronutrientRatios = new double[]{0.4, 0.3, 0.3};
                break;
            case 4:
                macronutrientRatios = new double[]{0.05, 0.2, 0.75};
                break;
            case 5:
                System.out.print("탄수화물 비율을 입력하세요: ");
                macronutrientRatios[0] = scanner.nextDouble();
                System.out.print("단백질 비율을 입력하세요: ");
                macronutrientRatios[1] = scanner.nextDouble();
                System.out.print("지방 비율을 입력하세요: ");
                macronutrientRatios[2] = scanner.nextDouble();
                break;
            default:
                System.out.println("잘못된 선택입니다. 기본 비율을 사용합니다.");
                macronutrientRatios = new double[]{0.4, 0.4, 0.2};
                break;
        }

        return macronutrientRatios;
    }

    private int selectNumberOfMeals(User user) {
        int numMeals;

        do {
            System.out.println("================================================");
            System.out.print("하루 섭취할 끼니 수를 선택하세요 (3, 4, 5): ");
            numMeals = scanner.nextInt();
        } while (numMeals != 3 && numMeals != 4 && numMeals != 5);

        return numMeals;
    }

    private int calculateGoalCalories() {
        int goalCalories = (int) metabolicRate * user.getWeight();
        return goalCalories;
    }

    private double[] calculateCaloriesPerMeal(int numMeals, int totalCalories) {
        double[] caloriesPerMeal = new double[numMeals];
        for (int i = 0; i < numMeals; i++) {
            caloriesPerMeal[i] = totalCalories / numMeals;
        }
        return caloriesPerMeal;
    }

    private List<List<Food>> recommendFoodsForMeals(double[] caloriesPerMeal, int numMeals) {
        List<List<Food>> recommendedFoods = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numMeals; i++) {
            List<Food> mealFoods = new ArrayList<>();
            // 각 끼니마다 랜덤하게 음식 선택하여 추가
            mealFoods.add(getRandomFoodFromGroup(Food.FoodGroup.탄수화물));
            mealFoods.add(getRandomFoodFromGroup(Food.FoodGroup.단백질));
            mealFoods.add(getRandomFoodFromGroup(Food.FoodGroup.지방));
            mealFoods.add(getRandomFoodFromGroup(Food.FoodGroup.야채));
            mealFoods.add(getRandomFoodFromGroup(Food.FoodGroup.간식));
            recommendedFoods.add(mealFoods);
        }

        return recommendedFoods;
    }

    private Food getRandomFoodFromGroup(Food.FoodGroup group) {
        // 해당 그룹에서 랜덤하게 음식 선택
        List<Food> foodsInGroup = database.getPredefinedFoods(group);
        return foodsInGroup.get(new Random().nextInt(foodsInGroup.size()));
    }

    private void test(int bmr, int numMeals, double[] macronutrientRatios, double neededCalories) {
        double carbohydrateRatio = macronutrientRatios[0];
        double proteinRatio = macronutrientRatios[1];
        double fatRatio = macronutrientRatios[2];


        double carbohydrate1day = neededCalories * carbohydrateRatio / 4; // 탄수화물 1g당 4칼로리
        double protein1day = neededCalories * proteinRatio / 4; // 단백질 1g당 4칼로리
        double fat1day = neededCalories * fatRatio / 9; // 지방 1g당 9칼로리

        // 사용자의 탄단지칼로리 계산
        System.out.println("=====================================================");
        System.out.println(user.getName() + " 님의 하루 총 필요 탄,단,지,칼로리는");
        System.out.println("[탄] " + String.format("%.2f", carbohydrate1day) + "g [단] " + String.format("%.2f", protein1day) + "g [지] " + String.format("%.2f", fat1day) + "g [칼]: " + String.format("%.2f", neededCalories) + "kcal 이고, ");
        System.out.println(user.getName() + " 님의 끼니당 필요 탄,단,지,칼로리는");
        System.out.println("[탄] " + String.format("%.2f", carbohydrate1day / numMeals) + "g [단] " + String.format("%.2f", protein1day / numMeals) + "g [지]: " + String.format("%.2f", fat1day / numMeals) + "g [칼]: " + String.format("%.2f", neededCalories / numMeals) + "kcal 입니다 ");
        System.out.println("=====================================================");
        System.out.println(" ");

        // 각 끼니당 먹어야 할 칼로리 계산
        double[] caloriesPerMeal = calculateCaloriesPerMeal(numMeals, (int) bmr);

        // 각 끼니에 추천할 음식들을 선택
        List<List<Food>> recommendedFoods = recommendFoodsForMeals(caloriesPerMeal, numMeals);

        // 추천된 음식들 출력
        printRecommendedFoods(recommendedFoods, carbohydrate1day, protein1day, fat1day, neededCalories, numMeals);
    }

    private void printRecommendedFoods(List<List<Food>> recommendedFoods, double carbohydrate1day, double protein1day, double fat1day, double neededCalories, int numMeals) {
        for (int i = 0; i < recommendedFoods.size(); i++) {
            System.out.println((i + 1) + "번째 식사");
            System.out.println(" ");

            List<Food> mealFoods = recommendedFoods.get(i);

            for (Food food : mealFoods) {
                double carbohydratePerServing = carbohydrate1day / numMeals;
                double proteinPerServing = protein1day / numMeals;
                double fatPerServing = fat1day / numMeals;
                double carbCalPerGram = food.getCalories() / carbohydratePerServing;
                double carperServing = (carbohydratePerServing * 100) / food.getCarbohydrate();
                double properServing = (proteinPerServing * 100) / food.getProtein();
                double fatperServing = (fatPerServing * 100) / food.getFat();
                double caloriesPerServing = carbohydratePerServing * carbCalPerGram;
                System.out.println("------------------------------------------------------------------------------------");
                System.out.print(food.getFoodGroup() + ": " + food.getName() + " ");

                switch (food.getFoodGroup().toString()) {
                    case "탄수화물":
                        System.out.println("(탄: " + String.format("%.2f", carbohydratePerServing) + "g, "
                                + "단: " + String.format("%.2f", carperServing * food.getProtein() / 100.0) + "g, "
                                + "지: " + String.format("%.2f", carperServing * food.getFat() / 100.0) + "g, "
                                + "칼: " + String.format("%.2f", carperServing * food.getCalories() / 100.0) + "kcal, "
                                + "섭취량: " + String.format("%.2f", carperServing) + "g)");
                        break;
                    case "단백질":
                        System.out.println("(탄: " + String.format("%.2f", properServing * food.getCarbohydrate() / 100.0) + "g, "
                                + "단: " + String.format("%.2f", proteinPerServing) + "g, "
                                + "지: " + String.format("%.2f", properServing * food.getFat() / 100.0) + "g, "
                                + "칼: " + String.format("%.2f", properServing * food.getCalories() / 100.0) + "kcal, "
                                + "섭취량: " + String.format("%.2f", properServing) + "g)");
                        break;
                    case "지방":
                        System.out.println("(탄: " + String.format("%.2f", fatperServing * food.getCarbohydrate() / 100.0) + "g, "
                                + "단: " + String.format("%.2f", fatperServing * food.getProtein() / 100.0) + "g, "
                                + "지: " + String.format("%.2f", fatPerServing) + "g, "
                                + "칼: " + String.format("%.2f", fatperServing * food.getCalories() / 100.0) + "kcal, "
                                + "섭취량: " + String.format("%.2f", fatperServing) + "g)");
                        break;
                    case "야채":
                        System.out.println("(탄: " + (food.getCarbohydrate()) + "g, "
                                + "단: " + (food.getProtein()) + "g, "
                                + "지: " + (food.getFat()) + "g, "
                                + "칼: " + (food.getCalories()) + "kcal, "
                                + "섭취량: " + (100) + "g)");
                        break;
                    case "간식":
                        System.out.println("(탄: " + (food.getCarbohydrate()) + "g, "
                                + "단: " + (food.getProtein()) + "g, "
                                + "지: " + (food.getFat()) + "g, "
                                + "칼: " + (food.getCalories()) + "kcal, "
                                + "섭취량: " + (100) + "g)");
                        System.out.println("------------------------------------------------------------------------------------");
                        break;
                    default:
                        System.out.println("유효하지 않은 식품 그룹입니다.");
                        break;
                }

            }

            System.out.println(); // 끼니 사이에 빈 줄 추가

        }
    }
}