package main.java;
public class Food {
    private FoodGroup foodGroup; // 음식 분류
    private String name; // 음식 이름
    private int calories; // 칼로리
    private double carbohydrate; // 탄수화물 (g)
    private double protein; // 단백질 (g)
    private double fat; // 지방 (g)

    private double Vegetable;

    private double Snack;
    private int servingSize; // 서빙 사이즈 (g)

    public Food(FoodGroup foodGroup, String name, int calories, double carbohydrate, double protein, double fat) {
        this.foodGroup = foodGroup;
        this.name = name;
        this.calories = calories;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
        this.servingSize = servingSize;
        this.Vegetable  = Vegetable;
        this.Snack = Snack;
    }

    public double getVegetable() {
        return Vegetable;
    }

    public void setVegetable(double vegetable) {
        Vegetable = vegetable;
    }

    public double getSnack() {
        return Snack;
    }

    public void setSnack(double snack) {
        Snack = snack;
    }

    public FoodGroup getFoodGroup() {
        return foodGroup;
    }

    public void setFoodGroup(FoodGroup foodGroup) {
        this.foodGroup = foodGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbohydrates() {
        return carbohydrate;
    }

    public int getServingSize() {
        return servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    @Override
    public String toString() {
        return  "[그룹분류] " + foodGroup +
                " [이름] " + name +
                " [칼로리] " + calories + "kcal" +
                " [탄수화물] " + carbohydrate + "g" +
                " [단백질] " + protein + "g" +
                " [지방] " + fat + "g" +
                " [기준 양] " + "100g";
    }


    // 열거형 정의: 음식 그룹
    public enum FoodGroup { //번호로 지정하도록 하지 않으면 String 타입은 오타의 위험
        탄수화물,
        단백질,
        지방,
        야채,
        간식

    }
}

