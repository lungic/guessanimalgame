package games.kokostym.com;

import java.util.HashMap;

public class GameCategoryGroup {
	private HashMap<String, CardGroup> mGroupedCards;
	private Card[] mCards;
	
	private GameCategories mGameCategory;
	private String mName;
	
	public GameCategoryGroup(GameCategories cat, String name){
		mGameCategory = cat;
		mName = name;
	}
	
	public void setCards(Card[] cards){
		this.mCards = cards;
	}
	
	public void groupCards(){
		this.mGroupedCards = new HashMap<String, CardGroup>();
		
		for(int i = 0 ; i< mCards.length; i++){
			Card c = mCards[i];
			
			String name = c.getName().toUpperCase();
			if(!this.mGroupedCards.containsKey(name)){
				this.mGroupedCards.put(name, new CardGroup(name));
			}
			
			CardGroup cc = (CardGroup)this.mGroupedCards.get(name);
			cc.Add(c);
		}
	}
	
	public HashMap<String, CardGroup> getGroupedCards(){
		return this.mGroupedCards;
	}
}