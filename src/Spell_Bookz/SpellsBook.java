package Spell_Bookz;

/**
 * Represents a book of spells from which spells can be looked up for casting
 * and new spells can be added or removed etc.
 * @author jpq
 *
 */
public class SpellsBook {

	private final int maxNumSpells = 10;
	private Spell [] spells = new Spell[maxNumSpells];// spells.length is 10
	private int numSpells =0;
	
	
	/**
	 *  You should check if the spell book is full before
	 *  otherwise this will throw a IndexOutOfBounds exception
	 * @param spell
	 */
	public void addSpell(Spell spell) {
		spells[numSpells] = spell;	
		numSpells++;
	}
	
	public Spell getSpell (int i){
		return spells[i];
		
	}
	
	public Spell getSpellSafe (int i){
		if(numSpells > i){
			return spells[i];
		}
		return null;
		
	}
	/**
	 *  You should check if the spell book is full before
	 *  otherwise this will throw a IndexOutOfBounds exception
	 * @param spell
	 */
	public void addSpellSafe(Spell spell) {
		if(maxNumSpells > numSpells){
			spells[numSpells] = spell;	
			numSpells++;
		}else{
			System.out.println("Your book is full");
		}
	}
	
	public int getNumSpells(){
		return numSpells;
	}
	
	public int getMaxNumSpells(){
		return maxNumSpells;
	}


}
