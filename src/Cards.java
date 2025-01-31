public class Cards {
    public int[] duplicates(String[] arr)
    {
        String[] cards = {"Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        int[] counts = new int[13];
        for (int i = 0; i < cards.length; i++)
        {
            int count = 0;
            for (String s : arr) {
                if (cards[i].equals(s)) {
                    count++;
                }
            }
            counts[i] = count;
        }
        return counts;
    }


    public int fiveOfAKind(int[] arr)
    {
        int count = 0;
        for (int numbers : arr){
            if (numbers == 5)
            {
                count++;
            }
        }
        return count;
    }


    public int fourOfAKind(int[] arr)
    {
        int count = 0;
        for (int numbers : arr){
            if (numbers == 4)
            {
                count++;
            }
        }
        return count;
    }
    public int fullHouse(int[] arr) {
        int countThree = 0;
        int countTwo = 0;

        for (int numbers : arr) {
            if (numbers == 3) {
                countThree++;
            } else if (numbers == 2) {
                countTwo++;
            }
        }

        if (countThree == 1 && countTwo == 1) {
            return 1;
        }
        return 0;
    }
    public int threeOfAKind(int[] arr)
    {
        int count = 0;
        int countOne = 0;
        for (int numbers : arr){
            if (numbers == 3)
            {
                count++;
            }
            if (numbers == 1)
            {
                countOne++;
            }
        }
        if (countOne == 0)
        {
            count = 0;
        }
        return count;
    }
    public int twoPair(int[] arr) {
        int count = 0;

        for (int numbers : arr) {
            if (numbers == 2) {
                count++;
            }
        }

        if (count == 2) {
            return 1;
        }
        return 0;
    }
    public int onePair(int[] arr)
    {
        int count = 0;
        int countOne = 0;
        for (int numbers : arr){
            if (numbers == 1)
            {
                countOne ++;
            }
            if ( numbers == 2)
            {
                count++;
            }
        }
        if (countOne != 3)
        {
            count = 0;
        }
        return count;
    }
    public int highCard(int[] arr)
    {
        int count = 0;
        for (int numbers : arr){
            if (numbers == 1)
            {
                count ++;
            }
        }
        if (count != 5){
            count = 0;
        } else count = 1;
        return count;
    }
    public String hands(String [] arr)
    {
        int five = 0;
        int four = 0;
        int full = 0;
        int three = 0;
        int two = 0;
        int one = 0;
        int high = 0;
        for (String hand : arr) {
            String[] temp = hand.split(",");
            int[] counts = duplicates(temp);

            if (fiveOfAKind(counts) == 1) {
                five++;
            } else if (fourOfAKind(counts) == 1) {
                four++;
            } else if (fullHouse(counts) == 1) {
                full++;
            } else if (threeOfAKind(counts) == 1) {
                three++;
            } else if (twoPair(counts) == 1) {
                two++;
            } else if (onePair(counts) == 1) {
                one++;
            } else {
                high++;
            }
        }
        return "Number of five of a kind hands: " + five + "\n" + "Number of full house hands: " + full + "\n" + "Number of four of a kind hands: " + four + "\n" + "Number of three of a kind hands: " + three + "\n" + "Number of two pair hands: " + two + "\n" + "Number of one pair hands: " + one + "\n" + "Number of high card hands: " + high;


    }
}

