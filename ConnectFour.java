/*
Sai Avula
7.19.24
ConnectFour
Make a connect four game
*/
import java.util.Scanner;
public class ConnectFour
{
    public static void main(String[]args)
    {
        ConnectFour sai = new ConnectFour();
        sai.runner();
    }
    public void runner()
    {
        Scanner scan = new Scanner(System.in);
        char [][] chars = new char[6][7];
        System.out.println("\n");
        for (int i = 0; i < 6; i++)
        {
            System.out.println();
            for (int n = 0; n < 7; n++)
            {
                chars[i][n] = 'O';
                System.out.print(chars[i][n] + " ");
            }
        }
        System.out.println("\n");

        int [] checkarr  = new int[7];
        int highest = 0;
        while(highest < 4)
        {
            System.out.print("Player 1, choose a column ");
            int ans = scan.nextInt();

            for(int i = 5; i >=0 ; i--)
            {
                if (chars[i][ans-1] == 'O')
                {
                    chars[i][ans-1] = 'R';
                    i=-10;
                }
            }
            if(CheckItA(chars))
            {
                System.out.println("Blue Wins!");
                break;
            }
            if(CheckItB(chars))
            {
                System.out.println("Red Wins!");
                break;
            }
            if(diagonalsA(chars))
            {
                System.out.println("Blue Wins!");
                break;
            }
            if(diagonalsB(chars))
            {
                System.out.println("Red Wins!");
                break;
            }

            for (int i = 0; i < 6; i++)
            {
                System.out.println();
                for (int n = 0; n < 7; n++)
                {
                    System.out.print(chars[i][n] + " ");
                }
            }
            System.out.println("\n");

            System.out.print("Player 2, choose a column ");
            ans = scan.nextInt();

            for(int i = 5; i >=0; i --)
            {
                if(chars[i][ans-1] == 'O')
                {
                    chars[i][ans-1] = 'B';
                    i =-10;
                }
            }
            for (int i = 0; i < 6; i++)
            {
                System.out.println();
                for (int n = 0; n < 7; n++)
                {
                    System.out.print(chars[i][n] + " ");
                }
            }
            System.out.println("\n");
            if(CheckItA(chars))
            {
                System.out.println("Blue Wins");
                break;
            }
            if(CheckItB(chars))
            {
                System.out.println("Red Wins");
                break;
            }
            if(diagonalsA(chars))
            {
                System.out.println("Blue Wins!");
                break;
            }
            if(diagonalsB(chars))
            {
                System.out.println("Red Wins!");
                break;
            }

        }
    }
    public boolean CheckItA(char [][] chars)
    {
        boolean bool = false;
        String [] rowcol = new String[13];
        for (int i = 0; i < 13; i++)rowcol[i] = "";
        for (int i = 0; i < 6; i++)
        {
            for (int n = 0; n < 7; n++)
            {
                rowcol[i] += chars[i][n];
            }
        }
        for (int i = 0; i < 7; i++)
        {
            for (int n = 0; n < 6; n++)
            {
                rowcol[i+6] += chars[n][i];
            }
        }
        for (int i = 0; i < 13; i++)
        {
            if(rowcol[i].indexOf("BBBB") >= 0)
            {
                bool = true;
            }
        }
        return bool;
    }
    public boolean CheckItB(char [][] chars)
    {
        boolean bool = false;
        String [] rowcol = new String[13];
        for (int i = 0; i < 13; i++)rowcol[i] = "";
        for (int i = 0; i < 6; i++)
        {
            for (int n = 0; n < 7; n++)
            {
                rowcol[i] += chars[i][n];
            }
        }
        for (int i = 0; i < 7; i++)
        {
            for (int n = 0; n < 6; n++)
            {
                rowcol[i+6] += chars[n][i];
            }
        }
        for (int i = 0; i < 13; i++)
        {
            if(rowcol[i].indexOf("RRRR") >= 0)
            {
                bool = true;
            }
        }
        return bool;
    }
    public boolean diagonalsA(char [][] chars)
    {
        boolean bool = false;
        String[] diagonals = new String[12];
        for(int i = 0; i<12; i++)diagonals[i] = "";
        diagonals[0] = chars[2][0] + "" + chars[3][1] +"" + chars[4][2] + "" + chars[5][3];
        diagonals[1] = chars[1][0] + "" + chars[2][1] +"" + chars[3][2] + "" + chars[4][3] + chars[5][4];
        diagonals[2] = chars[0][0] + "" + chars[1][1] +"" + chars[2][2] + "" + chars[3][3] + chars[4][4] + chars[5][5];
        diagonals[3] = chars[0][1] + "" + chars[1][2] +"" + chars[2][3] + "" + chars[3][4] + chars[4][5] + chars[5][6];
        diagonals[4] = chars[0][2] + "" + chars[1][3] +"" + chars[2][4] + "" + chars[3][5] + chars[4][6];
        diagonals[5] = chars[0][3] + "" + chars[1][4] +"" + chars[2][5] + "" + chars[3][6];
        diagonals[6] = chars[0][3] + "" + chars[1][2] + chars[2][1] + chars[3][0];
        diagonals[7] = chars[0][4] + "" + chars[1][3] + chars[2][2] + chars[3][1] + chars[4][0];
        diagonals[8] = chars[0][5] + "" + chars[1][4] + chars[2][3] + chars[3][2] + chars[4][1] + chars[5][0];
        diagonals[9] = chars[0][6] + "" + chars[1][5] + chars[2][4] + chars[3][3] + chars[4][2] + chars[5][1];
        diagonals[10] = chars[1][6] + "" + chars[2][5] + chars[3][4] + chars[4][3] + chars[5][2];
        diagonals[11] = chars[2][6] + "" + chars[3][5] + chars[4][4] + chars[5][3];

        for(int i = 0; i < 12; i++)
        {
            if(diagonals[i].indexOf("BBBB") >= 0)
            {
                bool = true;
                i = 100;
            }
        }
        return bool;
    }
    public boolean diagonalsB(char [][] chars)
    {
        boolean bool = false;
        String[] diagonals = new String[12];
        for(int i = 0; i<12; i++)diagonals[i] = "";
        diagonals[0] = chars[2][0] + "" + chars[3][1] +"" + chars[4][2] + "" + chars[5][3];
        diagonals[1] = chars[1][0] + "" + chars[2][1] +"" + chars[3][2] + "" + chars[4][3] + chars[5][4];
        diagonals[2] = chars[0][0] + "" + chars[1][1] +"" + chars[2][2] + "" + chars[3][3] + chars[4][4] + chars[5][5];
        diagonals[3] = chars[0][1] + "" + chars[1][2] +"" + chars[2][3] + "" + chars[3][4] + chars[4][5] + chars[5][6];
        diagonals[4] = chars[0][2] + "" + chars[1][3] +"" + chars[2][4] + "" + chars[3][5] + chars[4][6];
        diagonals[5] = chars[0][3] + "" + chars[1][4] +"" + chars[2][5] + "" + chars[3][6];
        diagonals[6] = chars[0][3] + "" + chars[1][2] + chars[2][1] + chars[3][0];
        diagonals[7] = chars[0][4] + "" + chars[1][3] + chars[2][2] + chars[3][1] + chars[4][0];
        diagonals[8] = chars[0][5] + "" + chars[1][4] + chars[2][3] + chars[3][2] + chars[4][1] + chars[5][0];
        diagonals[9] = chars[0][6] + "" + chars[1][5] + chars[2][4] + chars[3][3] + chars[4][2] + chars[5][1];
        diagonals[10] = chars[1][6] + "" + chars[2][5] + chars[3][4] + chars[4][3] + chars[5][2];
        diagonals[11] = chars[2][6] + "" + chars[3][5] + chars[4][4] + chars[5][3];

        for(int i = 0; i < 12; i++)
        {
            if(diagonals[i].indexOf("RRRR") >= 0)
            {
                bool = true;
                i = 100;
            }
        }
        return bool;
    }
}