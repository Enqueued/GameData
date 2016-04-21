package Spell_Bookz;

public class TimedSpell extends Spell implements Castable{

	private int duration;
	public TimedSpell(String string, int i) {
		super(string, i);
		setDuration(0);
		// TODO Auto-generated constructor stub
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public void cast(){
		super.cast();
		System.out.println("for " + duration + " turns");
	}

}
