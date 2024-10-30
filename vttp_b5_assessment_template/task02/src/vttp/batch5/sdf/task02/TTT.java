package vttp.batch5.sdf.task02;

public class TTT {

    public char[][] board;
    
    public TTT(){
        board = new char[3][3];
    }

    public void printBoard(){
        System.out.println(board[0][0] + board[0][1] + board[0][2]);
        System.out.println(board[1][0] + board[1][1] + board[1][2]);
        System.out.println(board[2][0] + board[2][1] + board[2][2]);
    }

      public void possibleMoves(){
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (board[y][x] == '.') {
                    board[y][x] = 'X';
                    int utility = evaluate();
                    System.out.printf("y=%d, x=%d, utility=%d", y, x, utility);
                    System.out.println();
                    board[y][x] = '.';
                }
            }
        }        
    }

    public int evaluate(){
        if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] == 'X'){return 1;}
        if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] == 'X'){return 1;}
        if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] == 'X'){return 1;}
        if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] == 'X'){return 1;}
        if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] == 'X'){return 1;}
        if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] == 'X'){return 1;}
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == 'X'){return 1;}
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] == 'X'){return 1;}

        if (board[0][0] == board[0][1] && board[0][2] == '.' && board[0][0] == 'O'){return -1;}
        if (board[0][0] == board[0][2] && board[0][1] == '.' && board[0][0] == 'O'){return -1;}
        if (board[0][1] == board[0][2] && board[0][0] == '.' && board[0][1] == 'O'){return -1;}
        if (board[1][0] == board[1][1] && board[1][2] == '.' && board[1][0] == 'O'){return -1;}
        if (board[1][0] == board[1][2] && board[1][1] == '.' && board[1][0] == 'O'){return -1;}
        if (board[1][1] == board[1][2] && board[1][0] == '.' && board[1][1] == 'O'){return -1;}
        if (board[2][0] == board[2][1] && board[2][2] == '.' && board[2][0] == 'O'){return -1;}
        if (board[2][0] == board[2][2] && board[2][1] == '.' && board[2][0] == 'O'){return -1;}
        if (board[2][1] == board[2][2] && board[2][0] == '.' && board[2][1] == 'O'){return -1;}
        if (board[0][0] == board[1][0] && board[2][0] == '.' && board[0][0] == 'O'){return -1;}
        if (board[0][0] == board[2][0] && board[1][0] == '.' && board[0][0] == 'O'){return -1;}
        if (board[1][0] == board[2][0] && board[0][0] == '.' && board[1][0] == 'O'){return -1;}
        if (board[0][1] == board[1][1] && board[2][1] == '.' && board[0][1] == 'O'){return -1;}
        if (board[0][1] == board[2][1] && board[1][1] == '.' && board[0][1] == 'O'){return -1;}
        if (board[1][1] == board[2][1] && board[0][1] == '.' && board[1][1] == 'O'){return -1;}
        if (board[0][2] == board[1][2] && board[2][2] == '.' && board[0][2] == 'O'){return -1;}
        if (board[0][2] == board[2][2] && board[1][2] == '.' && board[0][2] == 'O'){return -1;}
        if (board[1][2] == board[2][2] && board[0][2] == '.' && board[1][2] == 'O'){return -1;}
        if (board[0][0] == board[1][1] && board[2][2] == '.' && board[0][0] == 'O'){return -1;}
        if (board[0][0] == board[2][2] && board[1][1] == '.' && board[0][0] == 'O'){return -1;}
        if (board[1][1] == board[2][2] && board[0][0] == '.' && board[1][1] == 'O'){return -1;}
        if (board[2][0] == board[1][1] && board[0][2] == '.' && board[2][0] == 'O'){return -1;}
        if (board[2][0] == board[0][2] && board[1][1] == '.' && board[2][0] == 'O'){return -1;}
        if (board[1][1] == board[0][2] && board[2][0] == '.' && board[1][1] == 'O'){return -1;}

        return 0;
    }
}
