package games.kokostym.com;

import java.util.Vector;

public class CardGroup {

	private Vector<Card> mCards;
	private String mName;
	
	public CardGroup(String categoryname){
		this.mName = categoryname;
		this.mCards = new Vector<Card>();
	}
	
	public void Add(Card c){
		this.mCards.add(c);
	}

	public String getName(){
		return this.mName;
	}
	
	public Vector<Card> getCards(){
		return this.mCards;
	}
}
