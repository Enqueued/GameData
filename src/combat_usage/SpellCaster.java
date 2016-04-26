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
		ArrayList<Castable> casts = new ArrayList<Castable>();

		Spell storedSpell;
		if (casts.get(0) instanceof Spell)
			storedSpell = (Spell) casts.get(0);
		c.cast();
		//	s.cast();
		TimedSpell timed = new TimedSpell("Haste1", 12);
		timed.setDuration(5);
		timed.cast();
	}
}
