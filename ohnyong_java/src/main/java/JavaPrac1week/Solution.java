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
        inputTitle = sc.next();
        System.out.println("레시피의 별점을 입력해주세요.");
        inputStar = sc.nextDouble();
        System.out.println("레시피는 총 몇단계로 구성되어 있습니까?");
        inputRecipeLevel = sc.nextInt();

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
        System.out.printf("[ 백종원 %s 만들기 ]\n", recipeTitle);
        System.out.printf("별점 : %d (%.1f%%)\n", recipeStar, recipeStarRatio);
        int i;
        int n;
        for (i = 0; i < recipeTextArr.length; i++) {
            n = i + 1;
            System.out.printf("%d. %s\n", n, recipeTextArr[i]);
        }
    }
}