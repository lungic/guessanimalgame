package games.kokostym.com;

import java.util.Vector;

import android.graphics.Color;

public class FrontPageCategory {
	private String mText;
	private int mImage;
	private int mColor;
	private GameCategories mGameCategory;

	public GameCategories getGameCategory(){return this.mGameCategory;}
	public String getText(){return this.mText;}
	public int getImage(){return this.mImage;}
	public int getColor() { return this.mColor;}
	
	public FrontPageCategory(GameCategories cat, int color, String name, int image){
		this.mGameCategory = cat;
		this.mColor = color;
		this.mText = name;
		this.mImage = image;
	}
	
	public static FrontPageCategory[] mFrontPageCategories = null;

	public static FrontPageCategory[] getFrontPageCategories(){
		if(null == mFrontPageCategories){
			mFrontPageCategories=  createCategories();
		}
		
		return mFrontPageCategories;
	}
	
	public static FrontPageCategory[] createCategories(){
		Vector<FrontPageCategory> items = new Vector<FrontPageCategory>();
		items.add(new FrontPageCategory(GameCategories.animals, Color.GRAY, "Djur", R.drawable.category_animals));
		items.add(new FrontPageCategory(GameCategories.tools, Color.WHITE, "Verktyg", R.drawable.category_tools));
		items.add(new FrontPageCategory(GameCategories.numbers, Color.GRAY, "Siffror", R.drawable.category_numbers));
		items.add(new FrontPageCategory(GameCategories.letters, Color.WHITE, "Bokstäver", R.drawable.category_letters));
		items.add(new FrontPageCategory(GameCategories.food,Color.GRAY, "Mat", R.drawable.category_food));
		items.add(new FrontPageCategory(GameCategories.people,Color.WHITE, "Människor", R.drawable.category_people));
		return (FrontPageCategory[])items.toArray(new FrontPageCategory[items.size()] );
	}
}