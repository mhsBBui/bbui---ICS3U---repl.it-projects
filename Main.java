//Card Game Assignment
//March 23, 2021
//Torrey Liu and Bryan Bui
//Create a game that will deal two player's hands, display them along with the type of hand.

class Main {

  public static String[] faces = {"Two", "Three" ,"Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"}; //ace change in position because i need it to be detected as higher than king, which only benefits isStraight so it's fine
  public static String[] suits = {"Clubs", "Spades", "Hearts", "Diamonds"};
  public static String[] handFaces = new String [5]; //a string array to store any edited string without tampering with the actual hand itself; basically to prevent any stack tracing or something
  public static String[] inGameDeck = new String [52]; //since i have no idea how to use shuffleDeck to return a shuffled deck, instead i'll just put it in a new seperate array

  public static void main(String[] args) {
    shuffleDeck(createDeck());
    String[] p1hand = dealHand(inGameDeck).clone(); //again, clone method
    String[] p2hand = {"Ten Hearts","Jack Hearts","Queen Hearts","King Hearts","Ace Hearts"};
    //dealHand(inGameDeck).clone(); //again, clone method

    //print player 1 hand
    System.out.print("Player 1: ");
    for (int count = 0; count<p1hand.length; count++) {
      if (count == p1hand.length-1) {
        System.out.print(p1hand[count]+"\n");
      } else
        System.out.printf("%s, ",p1hand[count]);
    }
    //print type of player 1 hand
    System.out.printf("Type of Hand: %s\n",typeHand(p1hand));

    //print player 2 hand
    System.out.print("Player 2: ");
    for (int count = 0; count<p2hand.length; count++) {
      if (count == p2hand.length-1) {
        System.out.print(p2hand[count]+"\n");
      } else
        System.out.printf("%s, ",p2hand[count]);
    }
    //print type of player 2 hand
    System.out.printf("Type of Hand: %s",typeHand(p2hand));
    
  }

  //DEFINITION of createDeck()
  //Creates a full deck of cards (52) in order
  public static String[] createDeck() {
    String[] faceSuits = new String[52];
    int deckCount = 0; //counting variable to change array position 52 times in loops below
    for (int count = 0; count<faces.length; count++) {
      for (int count2 = 0; count2<suits.length; count2++) {
        faceSuits[deckCount] = faces[count].concat(" "+suits[count2]);
        deckCount++;
      }
    }
	  return faceSuits;
  }

  //DEFINITION of shuffleDeck()
  //Shuffle the deck of cards - after part (a) you have a deck of cards in order, now you randomly choose a number and swap positions with that card.
  public static void shuffleDeck(String[] fullDeck){
    int randCard;
    String temp;
    for (String count : fullDeck) {
      randCard = (int)(52*Math.random());
      temp = fullDeck[randCard];
      fullDeck[randCard] = fullDeck[0];
      fullDeck[0] = temp;
    }
    inGameDeck = fullDeck.clone(); //copy the whole array into an empty array using clone, a method that might be bad considering
  }
  
  //DEFINITION of dealCard method
  //Deals a single card – take a card from your shuffled deck
  public static String dealCard(String[] fullDeck){
    String card = null; //use a string variable to store the first card within deck (that isn't taken)
    for (int count = 0; count<fullDeck.length; count++) {
      if (fullDeck[count] != "Taken") {
        card = fullDeck[count];
        fullDeck[count] = "Taken"; //instead of changing the storage of the array, change the contents instead to know that it is taken
        break; //once done choosing an available card, leave the loop
      }
    }
	  return card; //returns a card
  }

  //DEFINITION of dealHand method
  //dealHand() - Deals a full hand (5 cards) – do part (c) 5 times - (e.g. Creates a Hand Array)
  public static String[] dealHand(String[] fullDeck){ //Parameter list may be modified (specifically if used more than once)
    String[] playerHand = new String[5]; 
    for (int count = 0; count<playerHand.length; count++)
      playerHand[count] = dealCard(fullDeck); //call back method 5 times and store it within the player's hand
	  return playerHand;
  }

  //DEFINITION of typeHand method
  //typeHand() - Create a method to determine which type of hand and return this type of hand as a String. Note: as much as this code looks dumb, switch case won't work with non-constants; even if there were, there would be more lines of code
  public static String typeHand(String[] hand){
    String determineHand = "Sorry, nothing"; //string variable to return and store hand type
    if (isStFlush(hand)) {
      determineHand = "Straight Flush";
    } else if (isFlush(hand)) {
      determineHand = "Flush";
    } else if (isStraight(hand)) {
      determineHand = "Straight";
    } else if (isFullHouse(hand)) {
      determineHand = "Full House";
    } else if (is4Kind(hand)) {
      determineHand = "Four of a kind";
    } else if (is3Kind(hand)) {
      determineHand = "Three of a kind";
    } else if (is2Pairs(hand)) {
      determineHand = "Two pairs";
    } else if (isPair(hand)) {
      determineHand = "A pair";
    }
	  return determineHand;
  }

  //DEFINITION of isPair method
  //A pair (Two cards with matching faces)
  public static boolean isPair(String[] hand) {
    boolean pairCheck = false;
    //rid of the suit
    for (int count = 0; count<hand.length; count++)
      handFaces[count] = hand[count].substring(0,hand[count].indexOf(' '));
    //for loop to check every combo with each card (10 max)
    for(int i = 0; i < hand.length; i++){
      for(int bothHand = 0; bothHand < hand.length; bothHand++){
        if(handFaces[i].equals(handFaces[bothHand]) && bothHand != i)
          //code to check
          pairCheck = true;
      }
    }
    return pairCheck; //this isnt really perfect bc im not sure its malleable but for now its good
  }

  //DEFINITION of is2Pairs method
  //Two pairs (Two sets of two face cards that match e.g. two tens and two aces) and since isPair cannot be adjusted for this method, code is reused but slightly altered

  public static boolean is2Pairs(String[] hand) {
    int pairsCheck = 0; //int instead boolean bc checking for 2 pairs, and two boolean variables are too much

    //rid of the suit
    for (int count = 0; count<hand.length; count++)
      handFaces[count] = hand[count].substring(0,hand[count].indexOf(' '));

    //for loop to check every combo with each card (10 max) 
    for(int i = 0; i < hand.length; i++){
      for(int bothHand = 0; bothHand < hand.length; bothHand++){
        if(handFaces[i].equals(handFaces[bothHand]) && bothHand != i) {
          handFaces[i] = handFaces[i].valueOf(i);
          handFaces[bothHand] = handFaces[bothHand].valueOf(bothHand);
          pairsCheck++;
        }
      }
    }
    return pairsCheck==2;
  } 

  //DEFINITION of is3Kind method
  //Three of a kind (Three matching face cards ex. three jacks)
  public static boolean is3Kind(String[] hand) {
    int kind3Check = 0;

    //rid of the suit
    for (int count = 0; count<hand.length; count++)
      handFaces[count] = hand[count].substring(0,hand[count].indexOf(' '));
    match: { //this may not be necessary but it does the job
      for(int i = 0; i < hand.length; i++){
        kind3Check = 0;
        for(int bothHand = 0; bothHand < hand.length; bothHand++){
          if (kind3Check == 2)
            break match;
          if(handFaces[i].equals(handFaces[bothHand]) && bothHand != i)
            kind3Check++;
        }
      }
    }
    return kind3Check==2; //instead of checking if there are 6 matches total, it checks if one card is equal to two other cards in hand, being 2, because checking for 6 matches would include checking remaining cards for pairs
  }

  //DEFINITION of is4Kind method
  //Four of a kind (Four matching face cards ex. Four tens)

  public static boolean is4Kind(String[] hand) {

    int pair4Check = 0;
    //rid of the suit
    for (int count = 0; count<hand.length; count++)
      handFaces[count] = hand[count].substring(0,hand[count].indexOf(' '));
    for(int i = 0; i < hand.length; i++){
      for(int bothHand = 0; bothHand < hand.length; bothHand++){
        if(handFaces[i].equals(handFaces[bothHand]) && bothHand != i)
          pair4Check++;
      }
    }
    return pair4Check==12;
  }

  //DEFINITION of isFlush method
  //A flush (ie. All five cards of the same suit eg. 5 hearts)

  public static boolean isFlush(String[] hand) {
    boolean suitCheck = true;
    for (int count = 0; count<hand.length; count++) {
      handFaces[count] = hand[count].substring(hand[count].indexOf(' ')+1); //could use split method but this way is easier for the time being
    }
    for (int count2 = 0; count2<hand.length; count2++) {
      for (int count3 = 0; count3<hand.length; count3++) {
        if(!handFaces[count2].equals(handFaces[count3]))
          suitCheck=false; //for loop checks if each card in hand has the same suit with every card in hand. basically, comparing every card w every card
      }
    }
	  return suitCheck;
  }

  //DEFINITION of isStraight method
  //A straight (ie. Five cards of consecutive face values – suit irrelevant)

  public static boolean isStraight(String[] hand) {

    int facePos = 0; //temp int variable
    boolean straightCheck = false;
    String[] compareHand = new String[5];

    //rid of the suit and leave only the face
    for (int count = 0; count<hand.length; count++)
      handFaces[count] = hand[count].substring(0,hand[count].indexOf(' '));

    //arranging each card in hand so that they are actual numbers and find the lowest card in deck
    for (int count2 = 0; count2<hand.length; count2++) {
      for(int count3 = 0; count3<faces.length; count3++) {
        if (handFaces[count2].equals(faces[count3])) {
          handFaces[count2] = hand[count2].valueOf(count3+1);
          if (facePos > count3 || facePos == 0)
            facePos = count3+1; //adding one usually is because of arrays or a for loop
        }
      }
    }

    //create an ideal straight hand from lowest card up by 5 individually
    for (int count4 = 0; count4<compareHand.length; count4++)
      compareHand[count4] = compareHand[count4].valueOf(facePos+count4);
    //compare hand to ideal straight hand
    for (int count5 = 0; count5<compareHand.length; count5++) {
      straightCheck = false; //restart straightCheck for every card
      for (int count6 = 0; count6<hand.length; count6++) {
        if (compareHand[count5].equals(handFaces[count6])) {
          straightCheck = true;
          break; //break if true, because the card fits within the straight parameter
        }
      }
      if (straightCheck == false)
        break; //break out of the loop entirely if no cards in hand align with the one card in ideal
    }
	  return straightCheck;
  }

  //DEFINITION of isStFLush method
  //A straight flush (ie. Five cards of consecutive face values, same suit)

  public static boolean isStFlush(String[] hand) {
    return isStraight(hand) && isFlush(hand); 
  }

  //DEFINITION of isFullHouse method
  //A full house (ie. Two cards of one face value and three cards of another face value)
  public static boolean isFullHouse(String[] hand) {
    int fullHouseCheck = 0;
    
    //rid of the suit
    for (int count = 0; count<hand.length; count++)
      handFaces[count] = hand[count].substring(0,hand[count].indexOf(' '));
    for(int i = 0; i < hand.length; i++){
      for(int bothHand = 0; bothHand < hand.length; bothHand++){
        if(handFaces[i].equals(handFaces[bothHand]) && bothHand != i)
          fullHouseCheck++;
      }
    }
    return fullHouseCheck==8; //8 specifically proves that it is full house
  }


 //Methods below were Added by Mr. Linseman to allow for unit testing

 public static boolean isRoyalFlush(String[] hand){
	 return false;
 } 

 public static String winner(String[] hand1, String[] hand2){
	 return null;
 }

}