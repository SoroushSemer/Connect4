//Soroush Semerkant
import java.util.Scanner;
public class Project {
    public static void main(String[] args){
        Connect4 game = new Connect4();
        game.startGame();
    }
}
class Connect4{
    char[][] board = new char[6][7];
    public Connect4(char[][] board){
        this.board = board;
    }
    public Connect4(){
        for(int i = 0; i < 6; i++)
            for(int j =0; j < 7; j++)
                board[i][j]=' ';
    }
    public void startGame(){
        char player;
        printBoard();
        for(int i = 0; i < 42; i++){
            String print = "Drop a ";
            if(i%2==0) {
                player = 'R';
                print+="red";
            }
            else {
                player = 'Y';
                print+="yellow";
            }
            Scanner stdin = new Scanner(System.in);
            int input = -1;
            while(input <0 || input >6) {
                System.out.print(print + " at column (0-6): ");
                input = stdin.nextInt();
            }
            dropPeice(player, input);
            printBoard();
            if(winCheck() !=' ')
                break;
        }

        if(winCheck() == 'R')
            System.out.println("The red player won");
        else if (winCheck() == 'Y')
            System.out.println("The yellow player won");
        else
            System.out.println("There was a tie");
    }
    public char winCheck(){
        for(int i = 0; i<6; i++)
            for (int j = 0;j < 4;j++){
                if (board[i][j] == 'R' && board[i][j+1] == 'R' && board[i][j+2] == 'R' && board[i][j+3] == 'R')
                    return 'R';
                if (board[i][j] == 'Y' && board[i][j+1] == 'Y' && board[i][j+2] == 'Y' && board[i][j+3] == 'Y')
                    return 'Y';
            }
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 7; j++){
                if (board[i][j] == 'R' && board[i+1][j] == 'R' && board[i+2][j] == 'R' && board[i+3][j] == 'R')
                    return 'R';
                if (board[i][j] == 'Y' && board[i+1][j] == 'Y' && board[i+2][j] == 'Y' && board[i+3][j] == 'Y')
                    return 'Y';
            }
        for(int i = 3; i < 6; i++)
            for(int j = 0; j < 4; j++){
                if (board[i][j] == 'R' && board[i-1][j+1] == 'R' && board[i-2][j+2] == 'R' && board[i-3][j+3] == 'R')
                    return 'R';
                if (board[i][j] == 'Y' && board[i-1][j+1] == 'Y' && board[i-2][j+2] == 'Y' && board[i-3][j+3] == 'Y')
                    return 'Y';
            }
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 4; j++){
                if (board[i][j] == 'R' && board[i+1][j+1] == 'R' && board[i+2][j+2] == 'R' && board[i+3][j+3] == 'R')
                    return 'R';
                if (board[i][j] == 'Y' && board[i+1][j+1] == 'Y' && board[i+2][j+2] == 'Y' && board[i+3][j+3] == 'Y')
                    return 'Y';
            }
        return ' ';
    }

    public void dropPeice(char player, int column){
        int pos = 5;
        boolean found = true;
        while(board[pos][column] != ' '){
            pos--;
            if(pos==-1) {
                System.out.print("Error Column already full.\nReenter a column: ");
                Scanner stdin = new Scanner(System.in);
                dropPeice(player, stdin.nextInt());
                found = false;
                break;
            }
        }
        if(found)
            board[pos][column] = player;
    }
    public void printBoard() {
        String output="";
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                output+="|"+board[i][j];
            }
            output+="|\n";
        }
        output+="...............";
        System.out.println(output);
    }
}
