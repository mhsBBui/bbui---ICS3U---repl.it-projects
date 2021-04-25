#### **You MUST only work with String arrays in this assignment**
	
- no integer arrays
- no arrayLists
- no other imports (without prior approval)

This assignment will display your understanding of Methods and Strings and One Dimensional Arrays.

Given the following Global String arrays in the Main class
```                   
String[] faces
                  
String[] suits
```
Create methods that will:

a) Name: `createDeck()` - Creates a full deck of cards (52) (ordered as per the following image http://www.milefoot.com/math/discrete/counting/cardfreq.htm) 

b) Name: `shuffleDeck()` - Shuffle the deck of cards - after part (a) you have a deck of cards in order, 
   now you randomly choose a number and swap positions with that card. 
   To swap positions you will need a temp variable to hold the value of your current card.

c) `dealCard()` - Deals a single card – take a card from your shuffled deck

d) `dealHand()` - Deals a full hand (5 cards) – do part (c) 5 times  - (e.g. Creates a Hand Array) 
    A hand should be hidden from other players.
		(Test by outputting but don;t leave this as an output)

e) `typeHand()` - Create a method to determine which type of hand and return this type of hand as a String
	`e.g. Full House`  
   (based on what it contains): 
	 - Use boolean methods

- `isPair()` - A pair   (Two cards with matching faces)

- `is2Pairs()` - Two pairs (Two sets of two face cards that match e.g. two tens and two aces)

- `is3Kind()` - Three of a kind (Three matching face cards ex. three jacks)

- `is4Kind()` - Four of a kind (Four matching face cards ex. Four tens)

- `isFlush()` - A flush (ie. All five cards of the same suit eg. 5 hearts)

- `isStraight()` - A straight (ie. Five cards of consecutive face values – suit irrelevant)
   		e.g. Ace, Deuce, Three, Four, Five  e.g. Ten, Jack, Queen, King, Ace
	 		Not an example: Queen, King, Ace, Deuce, Three
- `isStFlush()` - A straight flush (ie. Five cards of consecutive face values, same suit)

- `isFullHouse()` - A full house (ie. Two cards of one face value and three cards of another face value)
			e.g. two Tens along with three Aces
 
You may wish to make methods to `getSuit()` and `getFace()`; `printDeck()` and `printCard()`.

Create a game that will deal two player's hands, display them along with the type of hand.
Methods can use other methods! This is encouraged in fact.

Level 3 Accomplished with all of the above. (**Do not need to declare a winner**)

Level 4: Name: `winner()` - Method to determine a winner (as well as all of the above). Will return a string for the player that won

Method in addition to ALL of the above methods

- `isRoyFlush()` - Royal Flush (ie. Similar to a straight flush but must be from ten all the way to the ace)
e.g. ten spades, jack spades, queen spades, king spades, ace spades

To determine a winner or a tie....
The order to who wins from *lowest* to *highest* is as follows:

1. High Card e.g. Deuce, Five, Ten, Jack, Queen     (high card is a queen)
2. Pair  
3. Two Pairs
4. Three of a Kind
5. Straight
6. Flush
7. Full House
8. Four of a kind
9. Straight Flush
10. Royal Flush

Watch for TIES...In any potential tie the next highest cards will prevail (down to the last one if necessary). 
A true *tie* is only when the hands match in type and high cards too. See Sample Runs and rewatch class video for these details.

Sample Runs: (All Levels except what is in brackets is level 4 only)

Sample Run 1:
```
Player 1: Two Spades, Ace Spades, Ten Hearts, Queen Spades, Five Diamonds
Type of Hand: High Card
Player 2: Two Hearts, Ace Hearts, Ten Diamonds, Queen Hearts, Five Spades
Type of Hand: High Card
Outcome: Tie                             <-- Output for Level 4 Only
```
Sample Run 2:
```
Player 1: Two Spades, Ace Spades, Ace Hearts, Five Hearts, Five Diamonds
Type of Hand: Two Pairs
Player 2: Three Hearts, Ace Diamonds, Ace Clubs, Five Clubs, Five Spades
Type of Hand: Two Pairs
Outcome: Player 2 Wins!
```
Sample Run 3:
```
Player 1: Two Spades, Two Hearts, Two Diamonds, Two Clubs, Five Diamonds
Type of Hand: Four of a kind
Player 2: Three Hearts, Three Diamonds, Three Clubs, Five Clubs, Five Spades
Type of Hand: Full House
Outcome: Player 1 Wins!   
```
Sample Run 4:
```
Player 1: Two Spades, Three Spades, Four Spades, Five Spades, Six Spades
Type of Hand: Straight Flush
Player 2: Ace Hearts, Jack Hearts, Queen Hearts, King Hearts, Ten Hearts
Type of Hand: Royal Flush
Outcome: Player 2 Wins!
```
Sample Run 5:
```
Player 1: Queen Spades, Queen Hearts, Queen Diamonds, Ace Spades, Ace Hearts
Type of Hand: Full House
Player 2: King Spades, King Hearts, King Diamonds, Three Hearts, Three Clubs
Type of Hand: Full House
Outcome: Player 2 Wins!
```