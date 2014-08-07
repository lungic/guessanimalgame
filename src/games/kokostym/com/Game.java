package games.kokostym.com;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;
import games.kokostym.com.*;

public class Game {

	private static Game mGameBoard;
	private static Random mRandom;
	
	private GameCategories mCategory;
	private Card[] mCards;
	private int mCorrectPos;
	

	private HashMap<GameCategories, GameCategoryGroup> mDecks;
	
	public static void setBoard(Game b){
		mGameBoard = b;
		mRandom= new Random();
	}
	
	public static Game getGame(){
		return mGameBoard;
	}	
	
	public Game(){
		mDecks = new HashMap<GameCategories, GameCategoryGroup>();
		createAllCategories();
//		groupAnimals();
	}

	private void createAllCategories() {
		
		Card[] animals = createAnimalCards();
		GameCategoryGroup animalGroup = new GameCategoryGroup(GameCategories.animals,"Djur");
		animalGroup.setCards(animals);
		animalGroup.groupCards();
		mDecks.put(GameCategories.animals, animalGroup);
		
		Card[] cards;
		GameCategoryGroup group;
		
		cards = createFoodCards();
		group = new GameCategoryGroup(GameCategories.food,"Mat");
		group.setCards(cards);
		group.groupCards();
		mDecks.put(GameCategories.food, group);
		
		cards = createToolsCards();
		group = new GameCategoryGroup(GameCategories.tools,"Verktyg");
		group.setCards(cards);
		group.groupCards();
		mDecks.put(GameCategories.tools, group);
		
		cards = createNumberCards();
		group = new GameCategoryGroup(GameCategories.numbers,"Siffror");
		group.setCards(cards);
		group.groupCards();
		mDecks.put(GameCategories.numbers, group);
		
		cards = createLetterCards();
		group = new GameCategoryGroup(GameCategories.letters,"Bokstäver");
		group.setCards(cards);
		group.groupCards();
		mDecks.put(GameCategories.letters, group);
		
		
		
		/*
		createToolsCards();
		createFoodCards();
		createNumberCards();
		createLetterCards();
		createPeopleCards();
		*/
	}

	private Card[] createAnimalCards() {
		Vector<Card> animals = new Vector<Card>();
		animals.add(new Card("Farm","Ant","Myra",R.drawable.ant1,R.raw.silent_sound,R.raw.ant_voice));
		animals.add(new Card("Forest","Bear","Björn",R.drawable.bear1,R.raw.silent_sound,R.raw.bear_voice));
		animals.add(new Card("Forest","Bear","Björn",R.drawable.bear2,R.raw.silent_sound,R.raw.bear_voice));
		animals.add(new Card("Forest","Bear","Björn",R.drawable.bear3,R.raw.silent_sound,R.raw.bear_voice));
		animals.add(new Card("Farm","Bumblebee","Humla",R.drawable.bumblebee1,R.raw.silent_sound,R.raw.bumblebee_voice));
		animals.add(new Card("Farm","Bumblebee","Humla",R.drawable.bumblebee2,R.raw.silent_sound,R.raw.bumblebee_voice));
		animals.add(new Card("Farm","Butterfly","Fjäril",R.drawable.butterfly1,R.raw.silent_sound,R.raw.butterfly_voice));
		animals.add(new Card("Farm","Butterfly","Fjäril",R.drawable.butterfly2,R.raw.silent_sound,R.raw.butterfly_voice));
		animals.add(new Card("Farm","Butterfly","Fjäril",R.drawable.butterfly3,R.raw.silent_sound,R.raw.butterfly_voice));
		animals.add(new Card("Farm","Butterfly","Fjäril",R.drawable.butterfly4,R.raw.silent_sound,R.raw.butterfly_voice));
		animals.add(new Card("Farm","Cat","Katt",R.drawable.cat1,R.raw.silent_sound,R.raw.cat_voice));
		animals.add(new Card("Farm","Cat","Katt",R.drawable.cat2,R.raw.silent_sound,R.raw.cat_voice));
		animals.add(new Card("Farm","Cat","Katt",R.drawable.cat3,R.raw.silent_sound,R.raw.cat_voice));
		animals.add(new Card("Farm","Cow","Ko", R.drawable.cow1,R.raw.silent_sound,R.raw.cow_voice));
		animals.add(new Card("Jungle","Chimpanzee","Chimpans",R.drawable.chimp1,R.raw.silent_sound,R.raw.chimp_voice));
		animals.add(new Card("Jungle","Chimpanzee","Chimpans",R.drawable.chimp2,R.raw.silent_sound,R.raw.chimp_voice));
		animals.add(new Card("Jungle","Crocodile","Krokodil",R.drawable.cock1,R.raw.silent_sound,R.raw.croc_voice));
		animals.add(new Card("Jungle","Crocodile","Krokodil",R.drawable.croc1,R.raw.silent_sound,R.raw.croc_voice));
		animals.add(new Card("Jungle","Crocodile","Krokodil",R.drawable.croc2,R.raw.silent_sound,R.raw.croc_voice));
		animals.add(new Card("Jungle","Crocodile","Krokodil",R.drawable.croc3,R.raw.silent_sound,R.raw.croc_voice));
		animals.add(new Card("Forest","Crow","Kråka",R.drawable.crow,R.raw.silent_sound,R.raw.crow_voice));
		animals.add(new Card("Forest","Deer","Rådjur",R.drawable.deer1,R.raw.silent_sound,R.raw.deer_voice));
		animals.add(new Card("Forest","Deer","Rådjur",R.drawable.deer2,R.raw.silent_sound,R.raw.deer_voice));
		animals.add(new Card("Forest","Deer","Rådjur",R.drawable.deer3,R.raw.silent_sound,R.raw.deer_voice));
		animals.add(new Card("Farm","Dog","Hund",R.drawable.dog1,R.raw.silent_sound,R.raw.dog_voice));
		animals.add(new Card("Farm","Dog","Hund",R.drawable.dog2,R.raw.silent_sound,R.raw.dog_voice));
		animals.add(new Card("Farm","Dog","Hund",R.drawable.dog3,R.raw.silent_sound,R.raw.dog_voice));
		animals.add(new Card("Farm","Dog","Hund",R.drawable.dog4,R.raw.silent_sound,R.raw.dog_voice));
		animals.add(new Card("Farm","Dog","Hund",R.drawable.dog5,R.raw.silent_sound,R.raw.dog_voice));
		animals.add(new Card("Sea","Dolphin","Delfin",R.drawable.dolphin1,R.raw.silent_sound,R.raw.dolphin_voice));
		animals.add(new Card("Sea","Dolphin","Delfin",R.drawable.dolphin2,R.raw.silent_sound,R.raw.dolphin_voice));
		animals.add(new Card("Sea","Dolphin","Delfin",R.drawable.dolphin3,R.raw.silent_sound,R.raw.dolphin_voice));
		animals.add(new Card("Sea","Dolphin","Delfin",R.drawable.dolphin4,R.raw.silent_sound,R.raw.dolphin_voice));
		animals.add(new Card("Farm","Donkey","Åsna",R.drawable.donkey,R.raw.silent_sound,R.raw.donkey_voice));
		animals.add(new Card("Farm","Donkey","Åsna",R.drawable.donkey2,R.raw.silent_sound,R.raw.donkey_voice));
		animals.add(new Card("Farm","Duck","Anka", R.drawable.duck1,R.raw.silent_sound,R.raw.duck_voice));
		animals.add(new Card("Farm","Duckling","Ankunge",R.drawable.duckling1,R.raw.silent_sound,R.raw.duckling_voice));
		animals.add(new Card("Farm","Duckling","Ankunge",R.drawable.duckling2,R.raw.silent_sound,R.raw.duckling_voice));
		animals.add(new Card("Farm","Duckling","Ankunge",R.drawable.duckling3,R.raw.silent_sound,R.raw.duckling_voice));
		animals.add(new Card("Forest","Eagle","Örn",R.drawable.eagle1,R.raw.silent_sound,R.raw.eagle_voice));
		animals.add(new Card("Savannah","Elephant","Elefant",R.drawable.elephant1,R.raw.silent_sound,R.raw.elephant_voice));
		animals.add(new Card("Savannah","Elephant","Elefant",R.drawable.elephant2,R.raw.silent_sound,R.raw.elephant_voice));
		animals.add(new Card("Forest","Falcon","Falk",R.drawable.falcon1,R.raw.silent_sound,R.raw.falcon_voice));
		animals.add(new Card("Forest","Falcon","Falk",R.drawable.falcon2,R.raw.silent_sound,R.raw.falcon_voice));
		animals.add(new Card("Forest","Fox","Räv",R.drawable.fox1,R.raw.silent_sound,R.raw.fox_voice));
		animals.add(new Card("Forest","Fox","Räv",R.drawable.fox2,R.raw.silent_sound,R.raw.fox_voice));
		animals.add(new Card("Forest","Fox","Räv",R.drawable.fox3,R.raw.silent_sound,R.raw.fox_voice));
		animals.add(new Card("Savannah","Gepard","Gepard",R.drawable.gepard1,R.raw.silent_sound,R.raw.gepard_voice));
		animals.add(new Card("Savannah","Giraffe","Giraff",R.drawable.giraffe1,R.raw.silent_sound,R.raw.giraffe_voice));
		animals.add(new Card("Savannah","Giraffe","Giraff",R.drawable.giraffe2,R.raw.silent_sound,R.raw.giraffe_voice));
		animals.add(new Card("Savannah","Giraffe","Giraff",R.drawable.giraffe3,R.raw.silent_sound,R.raw.giraffe_voice));
		animals.add(new Card("Savannah","Giraffe","Giraff",R.drawable.goat1,R.raw.silent_sound,R.raw.giraffe_voice));
		animals.add(new Card("Farm","Goat","Get",R.drawable.goat1, R.raw.silent_sound, R.raw.goat_voice));
		animals.add(new Card("Sea","Goldfish","Guldfisk",R.drawable.goldfish1,R.raw.silent_sound,R.raw.goldfish_voice));
		animals.add(new Card("Sea","Goldfish","Guldfisk",R.drawable.goldfish2,R.raw.silent_sound,R.raw.goldfish_voice));
		animals.add(new Card("Farm","Goose","Gås",R.drawable.goose1,R.raw.silent_sound,R.raw.goose_voice));
		animals.add(new Card("Farm","Goose","Gås",R.drawable.goose2,R.raw.silent_sound,R.raw.goose_voice));
		animals.add(new Card("Forest","Heron","Häger",R.drawable.heron1,R.raw.silent_sound,R.raw.heron_voice));
		animals.add(new Card("Forest","Heron","Häger",R.drawable.heron2,R.raw.silent_sound,R.raw.heron_voice));
		animals.add(new Card("Farm","Horse","Häst",R.drawable.horse1,R.raw.silent_sound,R.raw.horse_voice));
		animals.add(new Card("Exotic","Kangaroo","Känguru",R.drawable.kangaroo1,R.raw.silent_sound,R.raw.kangaroo_voice));
		animals.add(new Card("Exotic","Kangaroo","Känguru",R.drawable.kangaroo2,R.raw.silent_sound,R.raw.kangaroo_voice));
		animals.add(new Card("Exotic","Koala","Koala",R.drawable.koala1,R.raw.silent_sound,R.raw.koala_voice));
		animals.add(new Card("Exotic","Koala","Koala",R.drawable.koala2,R.raw.silent_sound,R.raw.koala_voice));
		animals.add(new Card("Farm","Ladybug","Nyckelpiga",R.drawable.ladybug1,R.raw.silent_sound,R.raw.ladybug_voice));
		animals.add(new Card("Farm","Ladybug","Nyckelpiga",R.drawable.ladybug2,R.raw.silent_sound,R.raw.ladybug_voice));
		animals.add(new Card("Farm","Ladybug","Nyckelpiga",R.drawable.ladybug3,R.raw.silent_sound,R.raw.ladybug_voice));
		animals.add(new Card("Farm","Ladybug","Nyckelpiga",R.drawable.ladybug4,R.raw.silent_sound,R.raw.ladybug_voice));
		animals.add(new Card("Farm","Lamb","Lamm",R.drawable.lamb1,R.raw.silent_sound,R.raw.lamb_voice));
		animals.add(new Card("Savannah","Leopard","Leopard",R.drawable.leopard1,R.raw.silent_sound,R.raw.leopard_voice));
		animals.add(new Card("Savannah","Leopard","Leopard",R.drawable.leopard2,R.raw.silent_sound,R.raw.leopard_voice));
		animals.add(new Card("Savannah","Leopard","Leopard",R.drawable.leopard3,R.raw.silent_sound,R.raw.leopard_voice));
		animals.add(new Card("Savannah","Lion","Lejon",R.drawable.lion1,R.raw.silent_sound,R.raw.lion_voice));
		animals.add(new Card("Savannah","Lion","Lejon",R.drawable.lion2,R.raw.silent_sound,R.raw.lion_voice));
		animals.add(new Card("Savannah","Lion","Lejon",R.drawable.lion3,R.raw.silent_sound,R.raw.lion_voice));
		animals.add(new Card("Forest","Moose","Älg",R.drawable.moose1,R.raw.silent_sound,R.raw.moose_voice));
		animals.add(new Card("Forest","Moose","Älg",R.drawable.moose2,R.raw.silent_sound,R.raw.moose_voice));
		animals.add(new Card("Djungle","Orangutan","Orangutan",R.drawable.orangutan1,R.raw.silent_sound,R.raw.orangutan_voice));
		animals.add(new Card("Djungle","Orangutan","Orangutan",R.drawable.orangutan2,R.raw.silent_sound,R.raw.orangutan_voice));
		animals.add(new Card("Savannah","Ostrich","Struts",R.drawable.ostrich1,R.raw.silent_sound,R.raw.ostrich_voice));
		animals.add(new Card("Savannah","Ostrich","Struts",R.drawable.ostrich3,R.raw.silent_sound,R.raw.ostrich_voice));
		animals.add(new Card("Forest","Owl","Uggla",R.drawable.owl1,R.raw.silent_sound,R.raw.owl_voice));
		animals.add(new Card("Forest","Owl","Uggla",R.drawable.owl2,R.raw.silent_sound,R.raw.owl_voice));
		animals.add(new Card("Forest","Owl","Uggla",R.drawable.owl3,R.raw.silent_sound,R.raw.owl_voice));
		animals.add(new Card("Exotic","Panda","Panda",R.drawable.panda1,R.raw.silent_sound,R.raw.panda_voice));
		animals.add(new Card("Exotic","Panda","Panda",R.drawable.panda2,R.raw.silent_sound,R.raw.panda_voice));
		animals.add(new Card("Sea","Penguin","Pingvin",R.drawable.penguin1,R.raw.silent_sound,R.raw.penguin_voice));
		animals.add(new Card("Sea","Penguin","Pingvin",R.drawable.penguin2,R.raw.silent_sound,R.raw.penguin_voice));
		animals.add(new Card("Sea","Penguin","Pingvin",R.drawable.penguin3,R.raw.silent_sound,R.raw.penguin_voice));
		animals.add(new Card("Sea","Penguin","Pingvin",R.drawable.penguin4,R.raw.silent_sound,R.raw.penguin_voice));
		animals.add(new Card("Farm","Piglet","Kulting",R.drawable.piglet1,R.raw.silent_sound,R.raw.piglet_voice));
		animals.add(new Card("Farm","Piglet","Kulting",R.drawable.piglet2,R.raw.silent_sound,R.raw.piglet_voice));
		animals.add(new Card("Sea","Polarbear","Isbjörn",R.drawable.polarbear1,R.raw.silent_sound,R.raw.polarbear_voice));
		animals.add(new Card("Sea","Polarbear","Isbjörn",R.drawable.polarbear2,R.raw.silent_sound,R.raw.polarbear_voice));
		animals.add(new Card("Sea","Polarbear","Isbjörn",R.drawable.polarbear3,R.raw.silent_sound,R.raw.polarbear_voice));
		animals.add(new Card("Farm","Polarbear","Isbjörn",R.drawable.polarbear4,R.raw.silent_sound,R.raw.polarbear_voice));
		animals.add(new Card("Farm","Rabbit","Kanin",R.drawable.rabbit1,R.raw.silent_sound,R.raw.rabbit_voice));
		animals.add(new Card("Exotic","Panda","Röd Panda",R.drawable.redpanda1,R.raw.silent_sound,R.raw.panda_voice));
		animals.add(new Card("Savannah","Rhino","Noshörning",R.drawable.rhino1,R.raw.silent_sound,R.raw.rhino_voice));
		animals.add(new Card("Savannah","Rhino","Noshörning",R.drawable.rhino2,R.raw.silent_sound,R.raw.rhino_voice));
		animals.add(new Card("Sea","Seahorse","Sjöhäst",R.drawable.seahorse1,R.raw.silent_sound,R.raw.seahorse_voice));
		animals.add(new Card("Sea","Seal","Säl",R.drawable.seal1,R.raw.silent_sound,R.raw.seal_voice));
		animals.add(new Card("Sea","Seal","Säl",R.drawable.seal2,R.raw.silent_sound,R.raw.seal_voice));
		animals.add(new Card("Sea","Seal","Säl",R.drawable.seal3,R.raw.silent_sound,R.raw.seal_voice));
		animals.add(new Card("Farm","Sheep","Får",R.drawable.sheep1,R.raw.silent_sound,R.raw.sheep_voice));
		animals.add(new Card("Farm","Sheep","Får",R.drawable.sheep2,R.raw.silent_sound,R.raw.sheep_voice));
		animals.add(new Card("Farm","Snail","Snäcka",R.drawable.snail1,R.raw.silent_sound,R.raw.snail_voice));
		animals.add(new Card("Farm","Snail","Snäcka",R.drawable.snail2,R.raw.silent_sound,R.raw.snail_voice));
		animals.add(new Card("Forest","Squirrel","Ekorre",R.drawable.squirrel1,R.raw.silent_sound,R.raw.squirrel_voice));
		animals.add(new Card("Forest","Squirrel","Ekorre",R.drawable.squirrel2,R.raw.silent_sound,R.raw.squirrel_voice));
		animals.add(new Card("Exotic","Tiger","Tiger",R.drawable.tiger1,R.raw.silent_sound,R.raw.tiger_voice));
		animals.add(new Card("Exotic","Tiger","Tiger",R.drawable.tiger2,R.raw.silent_sound,R.raw.tiger_voice));
		animals.add(new Card("Exotic","Tiger","Tiger",R.drawable.tiger3,R.raw.silent_sound,R.raw.tiger_voice));
		animals.add(new Card("Exotic","Tiger","Tiger",R.drawable.tiger4,R.raw.silent_sound,R.raw.tiger_voice));
		animals.add(new Card("Exotic","Tiger","Tiger",R.drawable.tiger5,R.raw.silent_sound,R.raw.tiger_voice));
		animals.add(new Card("Exotic","Tiger","Tiger",R.drawable.tiger6,R.raw.silent_sound,R.raw.tiger_voice));
		animals.add(new Card("Sea","Turtle","Sköldpadda",R.drawable.turtle1,R.raw.silent_sound,R.raw.turtle_voice));
		animals.add(new Card("Sea","Turtle","Sköldpadda",R.drawable.turtle2,R.raw.silent_sound,R.raw.turtle_voice));
		animals.add(new Card("Forest","Wolf","Varg",R.drawable.wolf1,R.raw.silent_sound,R.raw.wolf_voice));
		animals.add(new Card("Forest","Wolf","Varg",R.drawable.wolf2,R.raw.silent_sound,R.raw.wolf_voice));
		animals.add(new Card("Savannah","Zebra","Zebra",R.drawable.zebra1,R.raw.silent_sound,R.raw.zebra_voice));
		animals.add(new Card("Savannah","Zebra","Zebra",R.drawable.zebra2,R.raw.silent_sound,R.raw.zebra_voice));
		
		return (Card[])animals.toArray(new Card[animals.size()]);
	}
	private Card[] createFoodCards(){
		Vector<Card> cards = new Vector<Card>();
		cards.add(new Card("Candy","Gummybears","Gummybjörnar",R.drawable.gummybears1,R.raw.silent_sound,R.raw.silent_voice));
		cards.add(new Card("Fruits","Cherry","Körsbär",R.drawable.cherry1,R.raw.silent_sound,R.raw.silent_voice));
		cards.add(new Card("Vegetable","Peppers","Paprika",R.drawable.peppers1,R.raw.silent_sound,R.raw.silent_voice));
		cards.add(new Card("Fruits","Apple","Äpple",R.drawable.apple1,R.raw.silent_sound,R.raw.silent_voice));
		return (Card[])cards.toArray(new Card[cards.size()]);
	}
	

	private Card[]  createLetterCards(){
		Vector<Card> cards = new Vector<Card>();
		cards.add(new Card("Alphabet","A","A",R.drawable.lettera,R.raw.silent_sound,R.raw.lettera_voice));
		cards.add(new Card("Alphabet","B","B",R.drawable.letterb,R.raw.silent_sound,R.raw.letterb_voice));
		cards.add(new Card("Alphabet","C","C",R.drawable.letterc,R.raw.silent_sound,R.raw.letterc_voice));
		cards.add(new Card("Alphabet","D","D",R.drawable.letterd,R.raw.silent_sound,R.raw.letterd_voice));
		cards.add(new Card("Alphabet","E","E",R.drawable.lettere,R.raw.silent_sound,R.raw.lettere_voice));
		cards.add(new Card("Alphabet","F","F",R.drawable.letterf,R.raw.silent_sound,R.raw.letterf_voice));
		cards.add(new Card("Alphabet","G","G",R.drawable.letterg,R.raw.silent_sound,R.raw.letterg_voice));
		cards.add(new Card("Alphabet","H","H",R.drawable.letterh,R.raw.silent_sound,R.raw.letterh_voice));
		cards.add(new Card("Alphabet","I","I",R.drawable.letteri,R.raw.silent_sound,R.raw.letteri_voice));
		cards.add(new Card("Alphabet","J","J",R.drawable.letterj,R.raw.silent_sound,R.raw.letterj_voice));
		cards.add(new Card("Alphabet","K","K",R.drawable.letterk,R.raw.silent_sound,R.raw.letterk_voice));
		cards.add(new Card("Alphabet","L","L",R.drawable.letterl,R.raw.silent_sound,R.raw.letterl_voice));
		cards.add(new Card("Alphabet","M","M",R.drawable.letterm,R.raw.silent_sound,R.raw.letterm_voice));
		cards.add(new Card("Alphabet","N","N",R.drawable.lettern,R.raw.silent_sound,R.raw.lettern_voice));
		cards.add(new Card("Alphabet","O","O",R.drawable.lettero,R.raw.silent_sound,R.raw.lettero_voice));
		cards.add(new Card("Alphabet","P","P",R.drawable.letterp,R.raw.silent_sound,R.raw.letterp_voice));
		cards.add(new Card("Alphabet","Q","Q",R.drawable.letterq,R.raw.silent_sound,R.raw.letterq_voice));
		cards.add(new Card("Alphabet","R","R",R.drawable.letterr,R.raw.silent_sound,R.raw.letterr_voice));
		cards.add(new Card("Alphabet","S","S",R.drawable.letters,R.raw.silent_sound,R.raw.letters_voice));
		cards.add(new Card("Alphabet","T","T",R.drawable.lettert,R.raw.silent_sound,R.raw.lettert_voice));
		cards.add(new Card("Alphabet","U","U",R.drawable.letteru,R.raw.silent_sound,R.raw.letteru_voice));
		cards.add(new Card("Alphabet","V","V",R.drawable.letterv,R.raw.silent_sound,R.raw.letterv_voice));
		cards.add(new Card("Alphabet","W","W",R.drawable.letterw,R.raw.silent_sound,R.raw.letterw_voice));
		cards.add(new Card("Alphabet","X","X",R.drawable.letterx,R.raw.silent_sound,R.raw.letterx_voice));
		cards.add(new Card("Alphabet","Y","Y",R.drawable.lettery,R.raw.silent_sound,R.raw.lettery_voice));
		cards.add(new Card("Alphabet","Z","Z",R.drawable.letterz,R.raw.silent_sound,R.raw.letterz_voice));
		cards.add(new Card("Alphabet","Å","Å",R.drawable.letteraa,R.raw.silent_sound,R.raw.letteraa_voice));
		cards.add(new Card("Alphabet","Ä","Ä",R.drawable.letterae,R.raw.silent_sound,R.raw.letterae_voice));
		cards.add(new Card("Alphabet","Ö","Ö",R.drawable.letteroo,R.raw.silent_sound,R.raw.letteroo_voice));
		return (Card[])cards.toArray(new Card[cards.size()]);
	}
	
	private Card[] createToolsCards(){
		Vector<Card> cards = new Vector<Card>();
		cards.add(new Card("Kitchen","Bowl","Skål",R.drawable.bowl1,R.raw.silent_sound,R.raw.silent_voice));
		cards.add(new Card("Painting","Brush","Pensel",R.drawable.brush1,R.raw.silent_sound,R.raw.silent_voice));
		cards.add(new Card("Painting","Brush","Pensel",R.drawable.brush2,R.raw.silent_sound,R.raw.silent_voice));
		cards.add(new Card("Painting","Brush","Pensel",R.drawable.brush3,R.raw.silent_sound,R.raw.silent_voice));
		cards.add(new Card("Toolbox","Hammer","Hammare",R.drawable.hammer1,R.raw.silent_sound,R.raw.silent_voice));
		cards.add(new Card("Toolbox","Saw","Såg",R.drawable.saw1,R.raw.silent_sound,R.raw.silent_voice));
		return (Card[])cards.toArray(new Card[cards.size()]);
	}
	
	
	private Card[] createNumberCards(){
		Vector<Card> cards = new Vector<Card>();
		cards.add(new Card("Numbers","Zero","Noll",R.drawable.number01,R.raw.silent_sound,R.raw.number_0));
		cards.add(new Card("Numbers","One","Ett",R.drawable.number11,R.raw.silent_sound,R.raw.number_1));
		cards.add(new Card("Numbers","Two","Två",R.drawable.number21,R.raw.silent_sound,R.raw.number_2));
		cards.add(new Card("Numbers","Three","Tre",R.drawable.number31,R.raw.silent_sound,R.raw.number_3));
		cards.add(new Card("Numbers","Four","Fyra",R.drawable.number41,R.raw.silent_sound,R.raw.number_4));
		cards.add(new Card("Numbers","Five","Fem",R.drawable.number51,R.raw.silent_sound,R.raw.number_5));
		cards.add(new Card("Numbers","Six","Sex",R.drawable.number61, R.raw.silent_sound,R.raw.number_6));
		cards.add(new Card("Numbers","Seven","Sju",R.drawable.number71,R.raw.silent_sound,R.raw.number_7));
		cards.add(new Card("Numbers","Eight","Åtta",R.drawable.number81,R.raw.silent_sound,R.raw.number_8));
		cards.add(new Card("Numbers","Nine","Nio",R.drawable.number91,R.raw.silent_sound,R.raw.number_9));
		return (Card[])cards.toArray(new Card[cards.size()]);
	}

	private void createPeopleCards(){
	}
	
	

	public void setGameMode(GameCategories mode){
		this.mCategory = mode;
	}
	
	public void NewGame(int cnt){
		try {
			this.mCards = this.getRandomCards(cnt);
			this.mCorrectPos = mRandom.nextInt(this.mCards.length);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Card[] getCards(){
		return this.mCards;
	}
	
	
	public Card[] getRandomCards(int cnt) throws Exception{
		
		if(cnt > this.mDecks.get(this.mCategory).getGroupedCards().size()){
			throw new Exception("Not enough items in the list");
		}
		
		Vector<Card> items = new Vector<Card>();
		Vector<CardGroup> tmp = new Vector<CardGroup>();
		
		tmp.addAll(this.mDecks.get(this.mCategory).getGroupedCards().values());
		for(int i = 0; i < cnt; i++){
			
			// Get a random category
			int pos = mRandom.nextInt(tmp.size());
			CardGroup cat = tmp.get(pos);
			
			// Get a random card in the mix
			int catpos = mRandom.nextInt(cat.getCards().size());
			
			// Add said card
			items.add(cat.getCards().get(catpos));
			
			// Remove category
			tmp.remove(pos);
		}
		
		return items.toArray(new Card[cnt]);
	}
	
	public Card getCorrect(){
		return this.mCards[this.mCorrectPos];
	}
}
