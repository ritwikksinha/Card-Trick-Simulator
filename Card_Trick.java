import java.util.*;
public class Card_Trick
{
    public static Card table[][]  = new Card[7][3];
    public static Card temp[] = new Card[21];
    public static Scanner sc = new Scanner(System.in);
    public Card_Trick()
    {
    }

    public static void Start_Trick()//Function for the trick.
    {
        Deck d1 = new Deck();//Initializing deck of cards.
        for(int i = 0;i<100;i++)//Shuffling the deck a hundred times.
        {
            d1.Shuffle();
        }
        
        for(int j = 0;j<3;j++)//Assigning the cards from deck to table in three columns.
        {
            for(int k = 0;k<7;k++)
            {
                table[k][j] = d1.deck[j*7+k];
            }
        }

        for(int x = 0;x<3;x++)//Loop for taking input and changing the arrangement of cards.
        {
            System.out.printf("%s\t\t%s\t\t%s", "Column 1", "Column 2", "Column 3");
            System.out.println();
            print();
            System.out.println("Which column is your card in?");
            int input = sc.nextInt();
            input -= 1;
            reassign(input);
            System.out.println("-----------------------------------------------------------------");
        }
        System.out.println("Your card is : " + temp[10].rank + " of " + temp[10].suit);
    }

    public static void print()//Function for printing the table.
    {
        for(int a = 0;a<7;a++)
        {
            for(int b = 0;b<3;b++)
            {
                System.out.printf("%d %s \t\t",table[a][b].rank,table[a][b].suit);
            }
            System.out.println();
        }
        
    }

    public static void reassign(int input)//Function for reassigning the cards as per trick.
    {
        int top = 0;
        int end = 0;
        switch (input)
        {
            case 0 :
                top = 1;
                end = 2;
                break;
            case 1:
                top = 0;
                end = 2;
                break;
            case 2:
                top = 0;
                end = 1;
                break;
            default:
                System.out.println("Wrong input!");
        }
        for(int i=0;i<7;i++)//Three loops for shifting cards from table to temporary array of size 21.
        {
            temp[i]=table[i][top];
        }
         for(int j=0;j<7;j++)
        {
            temp[7+j]=table[j][input];
        }
         for(int k=0;k<7;k++)
        {
            temp[14+k]=table[k][end];
        }
        for(int tp=0;tp<21;tp++)//Loop for reassigning the cards from temporary array back to table.
        {
            table[tp/3][tp%3] = temp[tp];
        }
        
    }

    public static void main(String[]args)
    {
        System.out.println("Start card trick?(y/n)");
        String input = sc.next();
        char ch = input.charAt(0);
        System.out.println();
        if ((ch == 'n')||(ch == 'N'))
        {
            System .out.println("Bye!");
            return;
        }
        else
        {
            Start_Trick();
        }
    }
}
