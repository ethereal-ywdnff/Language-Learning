public class Maze {
    public static void main(String[] args) {
        //construct the maze
        int maze[][] = new int[8][7];
        for (int i = 0; i < 7; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }
        for (int j = 0; j < 8; j++) {
            maze[j][0] = 1;
            maze[j][6] = 1;
        }
        maze[3][1] = 1;
        maze[3][2] = 1;
        maze[2][2] = 1;

        System.out.println("the condition of the original maze");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }

        FindWay way = new FindWay();
        way.findWay(maze,1,1);
        System.out.println("the condition of finding a way");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
}


//0 means the way that can walk
//1 means obstacle
//2 means the way that has been walked
//3 means the way has been walked but cannot get through
//4 means each side of the way cannot be walked
class FindWay {
    public boolean findWay(int[][] maze, int i, int j) {
        if (maze[6][5] == 2) {
            return true;
        } else {
            if(maze[i][j] == 0) {
                maze[i][j] = 2;
                //moving strategy: down -> right -> up -> left
                if(findWay(maze,i+1,j)) {//move down
                    return true;
                } else if (findWay(maze,i,j+1)) {//move right
                    return true;
                } else if (findWay(maze,i-1,j)) {//move up
                    return true;
                } else if (findWay(maze,i,j-1)) {//move left
                    return true;
                } else {
                    maze[i][j] = 4;
                    return false;
                }
            } else {
                maze[i][j] = 3;
                return false;
            }
        }
    }
}
