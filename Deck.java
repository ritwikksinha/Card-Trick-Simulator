
public class Deck
{
    public Card [] deck = new Card [52];
    public Deck()
    {
        int card = 0;
        for(int i = 1;i<=13;i++)
        {
            deck[card] = new Card(i,"Hearts");
            card++;
        }
        for(int j = 1;j<=13;j++)
        {
            deck[card] = new Card(j,"Spades");
            card++;
        }
        for(int k = 1;k<=13;k++)
        {
            deck[card] = new Card(k,"Diamonds");
            card++;
        }
        for(int l = 1;l<=13;l++)
        {
            deck[card] = new Card(l,"Clubs");
            card++;
        }
    }
    
    public void Shuffle()
    {
        int c1,c2;
        for(;;)
        {
            c1 = (int)(Math.random()*100);
            if(c1<52)
            {
                break;
            }
        }
        for(;;)
        {
            c2 = (int)(Math.random()*100);
            if(c2<52)
            {
                break;
            }
        }
        Card temp = deck[c1];
        deck[c1] = deck[c2];
        deck[c2] = temp;
    }
    public void Print()
    {
        for(int i=0;i<51;i++)
        {
            System.out.println(deck[i].rank +"of"+deck[i].suit);
        }
    }
}
