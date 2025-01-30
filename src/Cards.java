public class Cards {

    public void  duplicates(String[] arr)
    {
        String[] cards = {"Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        int[] counts = new int[13];
        for (int i = 0; i < cards.length; i++)
        {
            int count = 0;
            for (int x = 0; x < arr.length; x++)
            {
                if (cards[i].equals(arr[x])) {
                    count++;
                }
            }
            counts[i] = count;
        }
    }

}
