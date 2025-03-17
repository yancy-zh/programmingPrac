package JavaTutorial;

public class Deck
{
	/*
	 * public class DisplayDeck { public static void main(String[] args) { Deck deck = new Deck(); for (int suit = Card.DIAMONDS; suit <= Card.SPADES; suit++) {
	 * for (int rank = Card.ACE; rank <= Card.KING; rank++) { Card card = deck.getCard(suit, rank); System.out.format("%s of %s%n",
	 * card.rankToString(card.getRank()), card.suitToString(card.getSuit())); } } } }
	 */
	public static int numSuits = 4;
	public static int numRanks = 13;
	public static int numCards = numSuits * numRanks;
	
	private Card[][] cards;
	
	public Deck()
	{
		cards = new Card[numSuits][numRanks];
		for (int suit = Card.DIAMONDS; suit <= Card.SPADES; suit++)
		{
			for (int rank = Card.ACE; rank <= Card.KING; rank++)
			{
				cards[suit - 1][rank - 1] = new Card(rank, suit);
			}
		}
	}
	
	public Card getCard(int suit, int rank)
	{
		return cards[suit - 1][rank - 1];
	}
}