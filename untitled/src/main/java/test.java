import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        printDiamond(10);

    }

    public static int printDiamond(int maxWidth)
    {
        if(maxWidth % 2 == 0)
        {
            maxWidth += 1;
        }
        for(int i = 1 ; i <= (maxWidth+1)/2; i++ )
        {
            for (int j = i ; j < (maxWidth+1)/2; j++)
            {
                System.out.print("  ");
            }
            for (int k = 1; k < (2*i); k++)
            {
                System.out.print("* ");
            }
            System.out.println("");
        }

        for(int i = (maxWidth+1)/2-1 ; i > 0; i-- )
        {
            for (int j = i ; j < (maxWidth+1)/2; j++)
            {
                System.out.print("  ");
            }
            for (int k = 1; k < (2*i); k++)
            {
                System.out.print("* ");
            }
            System.out.println("");
        }

        return maxWidth;
    }

}

