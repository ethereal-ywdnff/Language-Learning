

/*public class Mora {
    public static void main(String[] args) {
        Tom t= new Tom();
        int isWinCount = 0;

        int[][] arr1 = new int[3][3];
        int j = 0;

        String[] arr2 = new String[3];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            //Get the numbers from the player
            System.out.println("please enter(0-rock, 1-scissors, 2-cloth): ");
            int num = scanner.nextInt();
            t.tomGuess = t.getTomGuessNum();
            arr1[i][j+1] = tomGuess;

            //Get the numbers from the computer
            int comGuess = t.computerNum();
            arr1[i][j+2] = comGuess;

            //compare the player's number and computer's number
            String isWin = t.vsComputer();
            arr1[i] = isWin;
            arr1[i][j] = t.count;

            System.out.println("number\tplayer\tcomputer\tcondition");
            System.out.println(t.count + "\t" + tomGuess + "\t" + comGuess);

            ////
            ///261
        }
    }
}*/
