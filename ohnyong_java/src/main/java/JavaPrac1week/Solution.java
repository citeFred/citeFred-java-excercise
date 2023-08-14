package JavaPrac1week;

import java.util.Arrays;
import java.util.Scanner;


public class Solution {
    //인풋 데이터 생각
    //요리제목 String inputTitle
    //요리별점 double inputStar
    //요리레시피 String String inputRecipe
    //레시피의 단계(배열의 크기) inputRecipeLevel

    //아웃풋 데이터 생각
    //레시피제목 String recipeTitle
    //요리레시피별점 int recipeStar
    //요리레시피별점퍼센트 double recipeStarRatio
    //요리레시피순서문장 String recipeText

    //Inputs
    String inputTitle;
    double inputStar;
    String inputRecipeArr[];
    double starMax = 5.0;
    int inputRecipeLevel;
    //Outputs
    String recipeTitle;
    int recipeStar;
    double recipeStarRatio;
    String recipeTextArr[];

    //Function
    Scanner sc = new Scanner(System.in);

    public Solution() {

    }

    void run() {
        input();
    }

    void input() {
        System.out.println("요리의 이름을 입력해주세요.");
        inputTitle = sc.nextLine();
        while (true) {
            System.out.println("레시피의 별점을 입력해주세요.");
            inputStar = sc.nextDouble();
            if (inputStar < 1.00 || inputStar > 5.00){
                System.out.println("별점은 1.00~5.00까지만 입력해주세요.");
                continue;
            }
            System.out.println("입력하신 값은 '"+inputStar+"'로 소수점을 제외한 정수로 변환됩니다!");
            break;
        }
        while (true) {
            System.out.println("레시피는 총 몇단계로 구성되어 있습니까?(최대10단계)");
            inputRecipeLevel = sc.nextInt();
            if (inputRecipeLevel < 1 || inputRecipeLevel > 10){
                System.out.println("레시피는 1~10단계로만 구성해주세요");
                continue;
            }
            break;
        }


        sc.nextLine(); //초기화

        int i;
        inputRecipeArr = new String[inputRecipeLevel];
        for (i = 0; i < inputRecipeArr.length; i++) {
            System.out.println((i + 1) + "번째 레시피의 내용을 입력해주세요.");
            inputRecipeArr[i] = sc.nextLine();
        }
        calculate(inputTitle, inputStar, inputRecipeArr, inputRecipeLevel);
    }

    void calculate(String inputTitle, double inputStar, String[] inputRecipeArr, int inputRecipeLevel) {
        recipeTitle = inputTitle;
        recipeStar = (int) Math.floor(inputStar);
        recipeStarRatio = (recipeStar / starMax) * 100;

        int i;
        recipeTextArr = new String[inputRecipeLevel];
        for (i = 0; i < inputRecipeArr.length; i++) {
            int j = i;
            recipeTextArr[j] = inputRecipeArr[i];
        }
        outputEnd(recipeTitle, recipeStar, recipeStarRatio, recipeTextArr);
    }

    void outputEnd(String recipeTitle, int recipeStar, double recipeStarRatio, String[] recipeTextArr) {
        System.out.println("==============================<< R E C I P E >>==============================");
        System.out.printf("[ 백종원 %s 만들기 ]\n", recipeTitle);
        System.out.printf("별점 : %d (%.1f%%)\n", recipeStar, recipeStarRatio);
        int i;
        int n;
        for (i = 0; i < recipeTextArr.length; i++) {
            n = i + 1;
            System.out.printf("%d. %s\n", n, recipeTextArr[i]);
        }
        System.out.println("==============================<< T H A N K U >>==============================");
        tryAgain();
    }

    void tryAgain(){
        System.out.println("계속해서 레시피를 작성하시겠습니까? [1] YES / [2] NO");
        int tryNum;
        tryNum = sc.nextInt();
        if(tryNum == 1){
            System.out.println("새로운 레시피를 입력합니다.");
            run();
        } else if (tryNum == 2) {
            System.out.println("이용해주셔서 감사합니다^^~");
            System.exit(0);
        }
    }
}