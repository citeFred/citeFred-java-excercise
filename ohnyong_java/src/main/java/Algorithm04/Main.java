package Algorithm04;

public class Main {
    public static void main(String[] args) {
        System.out.println("각에서 0도 초과 90도 미만은 예각,\n" +
                " 90도는 직각, 90도 초과 180도 미만은 둔각 180도는 평각으로 분류합니다.\n" +
                " 각 angle이 매개변수로 주어질 때 \n" +
                "예각일 때 1, 직각일 때 2, 둔각일 때 3, 평각일 때 4를\n" +
                "return하도록 solution 함수를 완성해주세요.\n" +
                "\n" +
                "예각 : 0 < angle < 90\n" +
                "직각 : angle = 90\n" +
                "둔각 : 90 < angle < 180\n" +
                "평각 : angle = 180\n" +
                "제한사항\n" +
                "0 < angle ≤ 180\n" +
                "angle은 정수입니다.\n");
        Solution solution = new Solution();
        solution.intputAngle();
    }
}
