package combat_usage;

import Spell_Bookz.*;

import java.util.ArrayList;

/**
 * Purpose: to understand better how to use arraylists
 * Feel free to work with / discuss with neighbors / google.
 * 
 *   Make a search function for the DynamicSpellsBook
 *  public class Spell{
 *  ...
 *  public String getType() {
		return type;
	}
	
	 public int getDamage() {
		return damage;
	}
 *   
 *   public class DynamicSpellsBook{
 *   
 *   private ArrayList<Spell> spells = new ArrayList<Spell>();
 *   ...
 *   /**
 *   * Finds a spell by name
 *   * @param name - the name of the spell
 *   * @return the spell or null if not found   
  		public Spell find(String name){ ... 
  	//	name.equals(type)}
 *
 *
 */
public class SpellCaster {
	public int strength, dex, con, wisdom, charm, intel;
	public DynamicSpellsBook book;

	public SpellCaster() {

		book = new DynamicSpellsBook("spelldata.txt");
		Spell s = book.getSpell(1);
		Castable c = s;
		ArrayList<Castable> casts = new ArrayList <Castable>();
		
		Spell storedSpell; 
				if(casts.get(0) instanceof Spell)
					storedSpell = (Spell) casts.get(0);
		c.cast();
	//	s.cast();
		TimedSpell timed = new TimedSpell("Haste1", 12);
		timed.setDuration(5);
		timed.cast();
		
		//bookd.addSpell(timed);
		//bookd.find("Haste1").cast();
		
		/*
		String spellname = "fire1";
		// how to find out how long a string is
		System.out.println("length =" +spellname.length());
		// how to find the character at 4th index
		System.out.println("character at 4  =" +spellname.charAt(4)); //1
		// how to find the character at last index
		System.out.println("character at last index =" +spellname.charAt(spellname.length()-1));
		
		//index like an array
		char[] spellbook_characterarray = new char[spellname.length()];		
		spellname.getChars(0, spellname.length(), spellbook_characterarray, 0);
		System.out.println(spellbook_characterarray[4]);//prints 1

		//find a character
		spellname.indexOf('1');// returns 4
		
		//get a substring
		System.out.println(spellname.substring(1).replace('1','2')); //ire2
		System.out.println(spellname.substring(1,4)); //ire
		//concatenation s1 + s2
		System.out.println(spellname.concat(spellname.substring(1))); //fire1ire1
		//convert strings to numbers (atoi or atof etc)
		String damage = "42";
		String damage2 = "44";
		System.out.println(damage+damage2);//4244
		
		//order of operations for + is left to right. if a string is part of it, it will concatenate
		System.out.println(Integer.valueOf(damage) + Integer.valueOf(damage2)+"end"); //86
		//toString() - use to convert objects to strings
		int i  = Integer.valueOf(damage); //atoi
		System.out.println("the answer: "+i); //ire1

		//Double.valueOf(d);

		 /*  strings are arrays of characters but you dont use [].
		 *  0 1 2 3 4
		 *  f i r e 1
		 *  
		 *  
		 */  
		
	}
}
