import java.util.ArrayList;
import java.util.Arrays;

public class Cards {
    ArrayList<String> fiveCard = new ArrayList<>();
    ArrayList<String> fourCard = new ArrayList<>();
    ArrayList<String> fullHouse = new ArrayList<>();
    ArrayList<String> three = new ArrayList<>();
    ArrayList<String> twoPair = new ArrayList<>();
    ArrayList<String> onePair = new ArrayList<>();
    ArrayList<String> high = new ArrayList<>();
    ArrayList<String> sortedHands = new ArrayList<>();
    ArrayList<Integer> sortedBids = new ArrayList<>();
    ArrayList<Integer> fiveCardBidValue = new ArrayList<>();
    ArrayList<Integer> fourCardBidValue = new ArrayList<>();
    ArrayList<Integer> fullHouseBidValue = new ArrayList<>();
    ArrayList<Integer> threeBidValue = new ArrayList<>();
    ArrayList<Integer> twoPairBidValue = new ArrayList<>();
    ArrayList<Integer> onePairBidValue = new ArrayList<>();
    ArrayList<Integer> highBidValue = new ArrayList<>();
    int[] bidValue = new int[50];

    public int[] duplicates(String[] arr) {
        String[] cards = {"Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        int[] counts = new int[13];
        for (int i = 0; i < cards.length; i++) {
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

    public int fiveOfAKind(int[] arr) {
        int count = 0;
        for (int numbers : arr) {
            if (numbers == 5) {
                count++;
            }
        }
        return count;
    }


    public int fourOfAKind(int[] arr) {
        int count = 0;
        for (int numbers : arr) {
            if (numbers == 4) {
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

    public int threeOfAKind(int[] arr) {
        int count = 0;
        int countOne = 0;
        for (int numbers : arr) {
            if (numbers == 3) {
                count++;
            }
            if (numbers == 1) {
                countOne++;
            }
        }
        if (countOne == 0) {
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

    public int onePair(int[] arr) {
        int count = 0;
        int countOne = 0;
        for (int numbers : arr) {
            if (numbers == 1) {
                countOne++;
            }
            if (numbers == 2) {
                count++;
            }
        }
        if (countOne != 3) {
            count = 0;
        }
        return count;
    }

    public String hands(String[] arr) {
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

    public void setBidValue(String str) {
        String[] temp = str.split("\n");
        for (int i = 0; i < temp.length; i++) {
            bidValue[i] = Integer.parseInt(temp[i].substring(temp[i].indexOf("|") + 1));
        }
    }

    public String[] setHand(String str) {
        String[] fileArray = str.split("\n");
        String[] stringHand = new String[fileArray.length];

        for (int i = 0; i < fileArray.length; i++) {
            // split by space, now we have a list of String numbers
            stringHand[i] = Arrays.toString(fileArray[i].split(" "));
        }

        for (int i = 0; i < fileArray.length; i++) {
            // removes |
            stringHand[i] = fileArray[i].substring(0, fileArray[i].indexOf("|"));
        }
        return stringHand;
    }

    //part 2
    public void setHandArrayList(String str) {
        String[] stringNumbers = setHand(str);
        for (int i = 0; i < stringNumbers.length; i++) {
            if (fiveOfAKind(singleDuplicates(stringNumbers[i])) == 1) {
                fiveCard.add(stringNumbers[i]);
                fiveCardBidValue.add(bidValue[i]);
            } else if (fourOfAKind(singleDuplicates(stringNumbers[i])) == 1) {
                fourCard.add(stringNumbers[i]);
                fourCardBidValue.add(bidValue[i]);
            } else if (fullHouse(singleDuplicates(stringNumbers[i])) == 1) {
                fullHouse.add(stringNumbers[i]);
                fullHouseBidValue.add(bidValue[i]);
            } else if (threeOfAKind(singleDuplicates(stringNumbers[i])) == 1) {
                three.add(stringNumbers[i]);
                threeBidValue.add(bidValue[i]);
            } else if (twoPair(singleDuplicates(stringNumbers[i])) == 1) {
                twoPair.add(stringNumbers[i]);
                twoPairBidValue.add(bidValue[i]);
            } else if (onePair(singleDuplicates(stringNumbers[i])) == 1) {
                onePair.add(stringNumbers[i]);
                onePairBidValue.add(bidValue[i]);
            } else
                high.add(stringNumbers[i]);
            highBidValue.add(bidValue[i]);
        }
    }

    public int[] singleDuplicates(String singleDeck) {
        String[] cards = {"Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        int[] counts = new int[13];
        String[] temp = singleDeck.split(",");
        for (int i = 0; i < cards.length; i++) {
            int count = 0;
            for (String s : temp) {
                if (cards[i].equals(s)) {
                    count++;
                }
            }
            counts[i] = count;
        }
        return counts;
    }

    public String strongerDeck(String deck1, String deck2) {
        String[] tempDeck1 = deck1.split(",");
        String[] tempDeck2 = deck2.split(",");

        for (int i = 0; i < tempDeck1.length; i++) {
            int strength1 = cardStrength(tempDeck1[i]);
            int strength2 = cardStrength(tempDeck2[i]);

            if (strength1 > strength2) {
                return deck1;
            } else if (strength1 < strength2) {
                return deck2;
            }
        }
        return "same";
    }
    public void sortHand(ArrayList<String> list, ArrayList<Integer> bid) {
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                String stronger = strongerDeck(list.get(j), list.get(j + 1));

                if (stronger.equals(list.get(j + 1))) {
                    String tempHand = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tempHand);

                    int tempBid = bid.get(j);
                    bid.set(j, bid.get(j + 1));
                    bid.set(j + 1, tempBid);
                }
            }
        }
    }
    public void sortAllHands() {
        //sorts hand
        sortHand(fiveCard, fiveCardBidValue);
        sortHand(fourCard, fourCardBidValue);
        sortHand(fullHouse, fullHouseBidValue);
        sortHand(three, threeBidValue);
        sortHand(twoPair, twoPairBidValue);
        sortHand(onePair, onePairBidValue);
        sortHand(high, highBidValue);
        //adds hand to list
        sortedHands.addAll(fiveCard);
        sortedBids.addAll(fiveCardBidValue);
        sortedHands.addAll(fourCard);
        sortedBids.addAll(fourCardBidValue);
        sortedHands.addAll(fullHouse);
        sortedBids.addAll(fullHouseBidValue);
        sortedHands.addAll(three);
        sortedBids.addAll(threeBidValue);
        sortedHands.addAll(twoPair);
        sortedBids.addAll(twoPairBidValue);
        sortedHands.addAll(onePair);
        sortedBids.addAll(onePairBidValue);
        sortedHands.addAll(high);
        sortedBids.addAll(highBidValue);
    }
    public int calculateBidValue() {
        int totalValue = 0;
        int numHands = sortedHands.size();

        for (int i = 0; i < numHands; i++) {
            int rank = numHands - i;
            int bid = sortedBids.get(i);
            totalValue += rank * bid;
        }
        return totalValue;
    }

    public int cardStrength(String card) {
        if (card.equals("Ace")) {
            return 14;
        }
        if (card.equals("King")) {
            return 13;
        }
        if (card.equals("Queen")) {
            return 12;
        }
        if (card.equals("Jack")) {
            return 11;
        }
        return Integer.parseInt(card);
    }


}