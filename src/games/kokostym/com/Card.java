package games.kokostym.com;

public class Card {

	public String Name;
	public String SwedishName;
	public int Image;
	public int Sound;
	public int Voice;
	public String Category;
	
	public Card(String category, String name, String caption, int image, int sound, int voice){
		this.Category = category;
		this.Image = image;
		this.Sound =sound;
		this.Voice = voice;
		this.Name = name;
		this.SwedishName = caption;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return Name;
	}
}
