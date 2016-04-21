package Spell_Bookz;

public class Spell implements Castable {

	private String type;
	private int damage;
	public Spell(String string, int i) {
		type= string;
		damage = i;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public void cast(){
		
		System.out.println("You cast " +type+ " for " + damage + " power" );
	}

	public boolean equals(Spell o){
		
		return type.equals(o.type) && damage == o.damage;
	}

}
