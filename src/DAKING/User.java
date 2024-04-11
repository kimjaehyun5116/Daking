package DAKING;

import java.util.Scanner;

public class User {
    private String name;
    private int age;
    private int weight;
    private int height;
    private char gender;

    public User(String name, int age, int weight, int height, char gender) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public static User getUserInfoFromInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("사용자 정보를 입력하세요");
        System.out.print("이름 : ");
        String name = scanner.nextLine();

        System.out.print("성별(남, 여) : ");
        String genderInput = scanner.nextLine();
        char gender;
        if (genderInput.equals("남") || genderInput.equals("여")) {
            gender = genderInput.charAt(0); // 문자열의 첫 번째 문자 추출
        } else {
            // 유효하지 않은 입력일 경우 기본값으로 설정
            gender = 'U'; // Unknown을 나타내는 기본값
            System.out.println("잘못된 입력입니다. 기본값 'U'가 설정됩니다.");
        }

        System.out.print("나이 : ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("키 : ");
        int height = scanner.nextInt();
        scanner.nextLine();

        System.out.print("몸무게 : ");
        int weight = scanner.nextInt();
        scanner.nextLine();


        return new User(name, age, weight, height, gender);
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", gender=" + gender +
                '}';
    }

}