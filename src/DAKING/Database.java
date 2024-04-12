package DAKING;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Database {
    private Map<String, Food> foodDatabase; // 음식 데이터베이스

    // 생성자
    public Database() {
        this.foodDatabase = new HashMap<>();

        addPredefinedFoods();
    }

    // 음식 추가 메서드
    public void addFood(Food food) {
        foodDatabase.put(food.getName(), food);
    }

    // 음식 검색 메서드
    public Food searchFood(String name) {
        return foodDatabase.get(name);
    }

    // 음식 목록 반환 메서드
    public List<Food> getAllFood() {
        return new ArrayList<>(foodDatabase.values());
    }
    // 음식 그룹에서 랜덤하게 음식을 선택하는 메서드
    public List<Food> getPredefinedFoods(Food.FoodGroup group) {
        List<Food> foodsInGroup = new ArrayList<>();
        for (Food food : foodDatabase.values()) {
            if (food.getFoodGroup() == group) {
                foodsInGroup.add(food);
            }
        }
        return foodsInGroup;
    }


    private void addPredefinedFoods() {
        // 음식 추가
        Food food1 = new Food(Food.FoodGroup.탄수화물, "백미밥", 143, 31.2, 2.72, 0.48);
        Food food2 = new Food(Food.FoodGroup.탄수화물, "현미밥", 153, 32.83, 3, 0.73);
        Food food3 = new Food(Food.FoodGroup.탄수화물, "고구마", 128, 30.36, 1.72, 0.15);
        Food food4 = new Food(Food.FoodGroup.탄수화물, "감자", 85, 19.63, 1.83, 0.1);
        Food food5 = new Food(Food.FoodGroup.탄수화물, "오트밀", 388, 70, 12.5, 8.75);
        Food food6 = new Food(Food.FoodGroup.탄수화물, "단호박", 39, 9.34, 1.09, 0.27);
        Food food7 = new Food(Food.FoodGroup.탄수화물, "파스타면", 355, 73, 14, 1);
        Food food8 = new Food(Food.FoodGroup.탄수화물, "보리밥", 150, 32.88, 3.12, 0.35);
        Food food9 = new Food(Food.FoodGroup.탄수화물, "콩밥", 345, 74.57, 9.11, 1.97);
        Food food10 = new Food(Food.FoodGroup.탄수화물, "식빵", 266, 50.61, 7.64, 3.29);
        Food food11 = new Food(Food.FoodGroup.탄수화물, "옥수수", 131, 29.58, 3.87, 1.59);
        Food food12 = new Food(Food.FoodGroup.탄수화물, "바나나", 89, 22.84, 1.09, 0.33);
        Food food13 = new Food(Food.FoodGroup.탄수화물, "사과", 52, 13.81, 0.26, 0.17);
        Food food14 = new Food(Food.FoodGroup.탄수화물, "통밀빵", 259, 47.14, 9.13, 4.11);
        Food food15 = new Food(Food.FoodGroup.단백질, "닭가슴살", 109, 0, 22.98, 1.23);
        Food food16 = new Food(Food.FoodGroup.단백질, "연어", 146, 0, 21.62, 5.93);
        Food food17 = new Food(Food.FoodGroup.단백질, "돼지안심살", 136, 0, 20.54, 5.41);
        Food food18 = new Food(Food.FoodGroup.단백질, "우둔살", 137, 0, 22.17, 4.92);
        Food food19 = new Food(Food.FoodGroup.단백질, "부채살", 149, 0, 20.4, 6.89);
        Food food20 = new Food(Food.FoodGroup.단백질, "고등어", 167, 0, 19.32, 9.36);
        Food food21 = new Food(Food.FoodGroup.단백질, "계란", 147, 0.77, 12.58, 9.94);
        Food food22 = new Food(Food.FoodGroup.단백질, "닭다리살", 156, 0, 18.7, 8.78);
        Food food23 = new Food(Food.FoodGroup.단백질, "참치회", 108, 2.81, 23.38, 0.95);
        Food food24 = new Food(Food.FoodGroup.단백질, "광어회", 103, 0, 20.44, 1.72);
        Food food25 = new Food(Food.FoodGroup.단백질, "참치캔", 137, 0, 12, 4.67);
        Food food26 = new Food(Food.FoodGroup.단백질, "임연수", 198, 1.4, 20, 7.1);
        Food food27 = new Food(Food.FoodGroup.단백질, "삼치", 177, 0, 20.25, 10.2);
        Food food28 = new Food(Food.FoodGroup.단백질, "조개", 74, 2.57, 12.77, 0.97);
        Food food29 = new Food(Food.FoodGroup.지방, "코코넛오일", 90, 0, 0, 10);
        Food food30 = new Food(Food.FoodGroup.지방, "올리브오일", 88, 0, 0, 10);
        Food food31 = new Food(Food.FoodGroup.지방, "캐놀라오일", 90, 0, 0, 10);
        Food food32 = new Food(Food.FoodGroup.야채, "양파", 42, 10.11, 0.92, 0.08);
        Food food33 = new Food(Food.FoodGroup.야채, "양배추찜", 2, 0.56, 0.14, 0.01);
        Food food34 = new Food(Food.FoodGroup.야채, "케일", 43, 8.66, 2.87, 0.6);
        Food food35 = new Food(Food.FoodGroup.야채, "깻잎", 33, 5.87, 3.68, 0.36);
        Food food36 = new Food(Food.FoodGroup.야채, "방울토마토", 16, 2.9, 0.9, 0.1);
        Food food37 = new Food(Food.FoodGroup.야채, "파프리카", 20, 4.64, 0.86, 0.17);
        Food food38 = new Food(Food.FoodGroup.야채, "상추", 14, 2.97, 0.9, 0.14);
        Food food39 = new Food(Food.FoodGroup.야채, "오이", 12, 2.16, 0.59, 0.16);
        Food food40 = new Food(Food.FoodGroup.야채, "아스파라거스", 39, 4.03, 2.33, 2.21);
        Food food41 = new Food(Food.FoodGroup.야채, "토마토", 2, 0.39, 0.09, 0.02);
        Food food42 = new Food(Food.FoodGroup.야채, "오이고추", 20, 4.64, 0.86, 0.17);
        Food food43 = new Food(Food.FoodGroup.간식, "저지방우유", 40, 5, 3, 1);
        Food food44 = new Food(Food.FoodGroup.간식, "우유", 156, 4.71, 3.29, 2);
        Food food45 = new Food(Food.FoodGroup.간식, "플레인요거트", 68, 6, 3, 3.5);
        Food food46 = new Food(Food.FoodGroup.간식, "아몬드", 58, 1.97, 2.13, 5.06);
        Food food47 = new Food(Food.FoodGroup.간식, "아보카도", 16, 0.85, 0.2, 1.47);
        Food food48 = new Food(Food.FoodGroup.간식, "호박씨", 54, 1.78, 2.45, 4.59);
        Food food49 = new Food(Food.FoodGroup.간식, "리코타치즈", 156, 4.09, 11.32, 10.44);
        Food food50 = new Food(Food.FoodGroup.간식, "마카다미아", 72, 1.38, 0.79, 7.58);
        Food food51 = new Food(Food.FoodGroup.간식, "땅콩버터", 59, 1.96, 2.51, 5.04);
        Food food52 = new Food(Food.FoodGroup.간식, "땅콩", 57, 1.61, 2.58, 4.92);
        Food food53 = new Food(Food.FoodGroup.간식, "호두", 65, 1.37, 1.52, 6.52);
        Food food54 = new Food(Food.FoodGroup.간식, "해바라기씨", 57, 1.88, 2.28, 4.96);
        Food food55 = new Food(Food.FoodGroup.간식, "캐슈너트", 58, 3.02, 1.68, 4.78);
        Food food56 = new Food(Food.FoodGroup.간식, "피스타치오", 56, 2.8, 2.06, 4.44);
        addFood(food1);
        addFood(food2);
        addFood(food3);
        addFood(food4);
        addFood(food5);
        addFood(food6);
        addFood(food7);
        addFood(food8);
        addFood(food9);
        addFood(food10);
        addFood(food11);
        addFood(food12);
        addFood(food13);
        addFood(food14);
        addFood(food15);
        addFood(food16);
        addFood(food17);
        addFood(food18);
        addFood(food19);
        addFood(food20);
        addFood(food21);
        addFood(food22);
        addFood(food23);
        addFood(food24);
        addFood(food25);
        addFood(food26);
        addFood(food27);
        addFood(food28);
        addFood(food29);
        addFood(food30);
        addFood(food31);
        addFood(food32);
        addFood(food33);
        addFood(food34);
        addFood(food35);
        addFood(food36);
        addFood(food37);
        addFood(food38);
        addFood(food39);
        addFood(food40);
        addFood(food41);
        addFood(food42);
        addFood(food43);
        addFood(food44);
        addFood(food45);
        addFood(food46);
        addFood(food47);
        addFood(food48);
        addFood(food49);
        addFood(food50);
        addFood(food51);
        addFood(food52);
        addFood(food53);
        addFood(food54);
        addFood(food55);
        addFood(food56);
    }


}
