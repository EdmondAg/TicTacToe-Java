import java.util.*;

public class TicTacToe {


    public static void main(String[] args) {
        TicTacToe.start();
    }
    private static final String[][] board =new String[3][3];
    private static final Scanner scanner = new Scanner(System.in);
    private static void createBoard(){
        for (int i = 0;i<board.length;i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = "-";
            }
        }
    }
    private static void printBoard(){
        for(String[] ls: board){
            for (String s: ls){
                System.out.print(s);
            }
            System.out.println();
        }
    }

    private static String random(){
        Random random =new Random();
        int nr = random.nextInt(2);
        return nr ==1 ? "X"  : "O";
    }

    private static void fixCoord(int row, int column, String player){
        board[row][column] = player;
    }

    public static void start(){
        //creating game main board//
        createBoard();

        //choosing a random player//
        String player = random();



        //main game running loop
        while (true){
            printBoard();

            System.out.println(player + " put row and column: ");
            int answer = scanner.nextInt();

            //List start at 0 but human at 1
            answer-=11;

            //Getting first and last digit for the column and row cords
            int column = (answer)%10;
            int row =  (answer-column)/10;

            /*Putting x or 0 at coordination*/
            fixCoord(row,column,player);

            if (victory(player)){
                System.out.println(player + " won the game!");
                break;
            }

            /*Swapping turns*/
            player = Objects.equals(player, "X") ? "O" : "X";
        }
    }

    public static boolean victory(String player){
        int length= board.length;
        int j;
        int i;
        boolean win;

        //Checking rows
        for (String[] strings : board) {
            win = true;
            for (j = 0; j < length; j++) {
                if (!Objects.equals(strings[j], player)) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }

        //checking columns
        for (i  = 0; i < length; i++) {
            win = true;
            for (j = 0; j < length; j++) {
                if (!Objects.equals(board[j][i], player)) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }

        //checking diagonals
        for (i  = 0; i < length; i++) {
            win = true;

            for (j = 0; j < length; j++){
                if (!Objects.equals(board[j][j], player)){
                    win = false;
                    break;
                }
            }
            if (win){
                return true;
            }
            win = true;

            for (j = 0; j < length; j++){
                if (!Objects.equals(board[j][length - 1 - i], player)){
                    win = false;
                    break;
                }
            }
            if (win){
                return true;
            }
        }
        return false;
    }
}