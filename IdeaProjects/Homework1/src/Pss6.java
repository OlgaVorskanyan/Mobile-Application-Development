public class Pss6 {
    public static void main(String[] args) {
        String answer = "";

        int n = 10;

        for (int i = 0; i < 10; i++) {
            answer += (int) (Math.random() * 94 + 32);

        }
        System.out.println(answer);
    }

}