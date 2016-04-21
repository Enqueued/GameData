package Spell_Bookz;

public abstract class Book {
	private int numPages;
	private int currentPage;
	
	public abstract void turnPage();
	
	public int getCurrentPage(){
		return currentPage;
	}
	
	public int getNumPages() {
		return numPages;
	}
	
	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}

}
