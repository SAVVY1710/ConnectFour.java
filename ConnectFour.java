/*
Sai Avula
1.29.24
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
        //While loop keeps running until someone looses
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
            
        }
    }

    /*
     * @purpose: Method used to check weather red has won
     * @param: Chars is the array used for which charecters are red or blue
     */
    public boolean CheckItA(char [][] chars){}
    /*
     * @purpose: Method used to check weather blue has won
     * @param: Chars is the array used for which charecters are red or blue
     */
    public boolean CheckItB(char [][] chars){}
    /*
     * @purpose: Method used to check the diagonals to see wheather red has won
     * @param: Chars is the array used for which charecters are red or blue
     */
    public boolean diagonalsA(char [][] chars){}
    /*
     * @purpose:Method used to check the diagonals to see wheather red has won
     * @param: Chars is the array used for which charecters are red or blue
     */
    public boolean diagonalsB(char [][] chars){}
}