import java.util.Scanner;


public class play{

    public static void main(String[] args){
        TicTacToe2[] game = new TicTacToe2[3];
        System.out.println("Welcome to public Tic Tac Toe. We have three boards for 6 players.");
        System.out.println("Please input their names: ");

        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 3; i++){
            String player1 = in.nextLine();

            String player2 = in.nextLine();
            game[i] = new TicTacToe2(player1, player2);
        }
        System.out.println("Board initialized.");
        //the form of input with random player order:
        //playerName row col
        while(true) {
            System.out.println("Input the next player's next move: ");
            String nextPlayer = in.next();
            int nextRow = in.nextInt();
            int nextCol = in.nextInt();
            for (int i = 0; i < 3; i++){
                if (game[i] == null)
                    continue;
                if(game[i].getPlayer1().equals(nextPlayer) && game[i].getPlayer()) {
                    game[i].run(nextRow, nextCol);
                    if (game[i].checkWin())
                        System.out.println("Player one wins game " + i);
                    if(game[i].isFull())
                        System.out.println("game " + i + " end with board full. Nobody win.");
                }
                if(game[i].getPlayer2().equals(nextPlayer) && !game[i].getPlayer()) {
                    game[i].run(nextRow, nextCol);
                    if (game[i].checkWin())
                        System.out.println("Player two wins game " + i);
                    if(game[i].isFull())
                        System.out.println("game " + i + " end with board full. Nobody win.");
                }
            }
            if(game[0].getGameend() && game[1].getGameend() && game[2].getGameend()) {
                System.out.println("All game ends! Thanks for playing");
                break;
            }
        }
    }
}
class TicTacToe2 {
    private char[][] board;
    private String player1;
    private String player2;
    private boolean player; //true for player 1
    private boolean gameend; //use this to indicate the game ends or not

    public TicTacToe2(String player1, String player2){
        board = new char[3][3];
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                board[i][j] = '0';
        this.player1 = player1;
        this.player2 = player2;
        player = true;
    }

    public void alterPlayer(){
        player = !player;
    }

    public String getPlayer1() {
        return player1;

    }

    public String getPlayer2() {
        return player2;

    }

    public boolean getPlayer(){
        return player;
    }


        public void run(int nextRow, int nextCol) {

            String nextPlayer;

            if (player == true) {
                nextPlayer = getPlayer1();
            }
            else {
                nextPlayer = getPlayer2();
            }

            if(nextRow == 0){
                System.out.println("Thanks for playing, " + player1 + ", " + player2);
                gameend = true;
                return;
            }

            if(!move(nextRow, nextCol, player)){
                System.out.println(nextPlayer + ", you're having an invalid move");

            }
            if (isFull() == true || checkWin() == true) {
                gameend = true;
            }

            alterPlayer();

            if(getPlayer() == true){
                System.out.println(getPlayer1() + ", you are playing with "+ getPlayer2());
                System.out.println("Next move is for " + player2);
            }
            else {
                System.out.println(getPlayer2() + ", you are playing with "+getPlayer1());
                System.out.println("Next move is for " + getPlayer1());
            }

            printBoard();

    }



    public boolean move(int row, int col, boolean player1){
        if(row > 3 || row < 1 || col > 3 || col < 1)
            return false;
        if(board[row - 1][col - 1] != '0')
            return false;
        if(player1)
            board[row - 1][col - 1] = this.player1.charAt(0);
        else
            board[row - 1][col - 1] = this.player2.charAt(0);
        return true;
    }

    public void printBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public boolean checkWin(){
        for (int i = 0; i < 3; i++){
            if(board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != '0') {
                return true;
            }
            if(board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[2][i] != '0'){
                return true;

            }
        }
        if(board[1][1] == board[2][2] && board[0][0] ==board[1][1] && board[1][1] != '0')
            return true;
        if (board[0][2] == board[1][1] && board[2][0] ==board[1][1] && board[1][1] != '0')
            return true;
        return false;
    }

    public boolean isFull(){
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if (board[i][j] =='0')
                    return false;
        return true;
    }
    public boolean getGameend() {

        return gameend;

    }


}

