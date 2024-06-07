public class MonkeyEatPeach {
    public static void main(String[] args) {
        int day = 1;
        if (peach(day) != -1) {
            System.out.println(peach(day));
        } else {
            System.out.println("day isn't between 1-10");
        }
    }

    //A monkey eats half of the peaches plus one a day, and it is found that
    // there is only one left in the tenth day(haven't eaten at tenth day)
    public static int peach(int day) {
        if (day == 10) {
            return 1;
        } else if (day>=1 && day <=9) {
            return ((peach(day+1)+1)*2);
        } else {
            return -1 ;
        }
    }
}
