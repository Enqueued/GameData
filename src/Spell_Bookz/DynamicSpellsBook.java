package Spell_Bookz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a book of spells from which spells can be looked up for casting
 * and new spells can be added or removed etc.
 * @author jpq
 *
 */
public class DynamicSpellsBook extends Book {

	//private final int maxNumSpells = 10;
	//private Spell [] spells = new Spell[maxNumSpells];// spells.length is 10
	private ArrayList<Spell> spells = new ArrayList<Spell>();
	private int level;
	//private int numSpells =0;
	public DynamicSpellsBook(int lvl){
		level = lvl;
		
	}
	public DynamicSpellsBook (String filename){
		this(99);
		Scanner in = null;
		
		try {
		    in = new Scanner(new File(filename));
		} catch (FileNotFoundException exception) {
		    System.err.println("failed to open " +filename);
		    System.exit(1);
		}
		while (in.hasNext()) {
		    String name = in.next();
		    if(in.hasNextInt()){
		    	addSpell(new Spell(name, in.nextInt()));
		    }
		  
		}   
	}
	/**
	 *  You should check if the spell book is full before
	 *  otherwise this will throw a IndexOutOfBounds exception
	 * @param spell
	 */
	public void addSpell(Spell spell) {
		//spells[numSpells] = spell;	
		spells.add(spell);
		//numSpells++;
	}
	/**
	 *  strings are arrys of characters but you dont use [].
	 *  0 1 2 3 4
	 *  f i r e 1
	 *  
	 *  
	 *  
	 * @param name
	 * @return
	 */
	public Spell find(String name){
		for(int i = 0; i<spells.size();i++ )
		{
			
			if(getSpell(i).getType().equals(name))
				return spells.get(i);
		
			
				// compare references
			if(getSpell(i).getType() ==(name))
				return spells.get(i);
			
		}
		return null;
	}
/*	public Spell getSpell (int i){
		return spells.get(i);
		
	}
	*/
	public Spell getSpell (int i){
		if(spells.size() > i){ // preventing ArrayIndexOutOfBounds exception
			return spells.get(i); //should return the string at the index i
		}
		return null;
		
	}
	/**
	 *  You should check if the spell book is full before
	 *  otherwise this will throw a IndexOutOfBounds exception
	 * @param spell
	 */
/*	public void addSpellSafe(Spell spell) {
		if(maxNumSpells > numSpells){
			spells.add(e)			numSpells++;
		}else{
			System.out.println("Your book is full");
		}
	}*/
	
	public int getNumSpells(){
		return spells.size(); // same as numspells
	}
	
	/*public int getMaxNumSpells(){
		return maxNumSpells;
	}*/

	public void turnPage(){System.out.println("A page has been turned");}
}
