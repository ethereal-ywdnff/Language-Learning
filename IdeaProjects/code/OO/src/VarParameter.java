public class VarParameter {
    public static void main(String[] args) {
        System.out.println("the sum of these is " + sum(1,2,3,4));
        System.out.println(showScore("Tom",97,85));
        System.out.println(showScore("Tim",97,85,34,33.4));
    }

    int age;//No need to assign a value
    //nums can be int or int[]
    public static int sum(int... nums) {
        System.out.println("the number of figures is " + nums.length);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res+=nums[i];
        }
        return res;
    }
    //there can only be one variable parameter
    public static void e(String a, int... nums) {
        int num = 0;//Must be assigned a value
    }
    public static String showScore(String name, double... scores) {
        double totalScore = 0;
        for (int i = 0; i < scores.length; i++) {
            totalScore += scores[i];
        }
        return name + " has " + scores.length + " subjects, and the total scores is " + totalScore;
    }
}
