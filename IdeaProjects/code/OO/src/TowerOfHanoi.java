public class TowerOfHanoi {
    public static void main(String[] args) {
        Tower tower = new Tower();
        tower.move(3, 'A', 'B', 'C');
    }
}

class Tower {
    public void move(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println(a + " -> " + c);
        } else {
            //There are multiple discs, which can be regarded as two parts
            //First move all the discs above except the bottom one to b, with the help of c
            move(num - 1, a, c, b);
            //Move the bottom disc to c
            System.out.println(a + " -> " + c);
            //Then move all the discs of b to c, with the help of a
            move(num - 1, b, a, c);
        }
    }
}