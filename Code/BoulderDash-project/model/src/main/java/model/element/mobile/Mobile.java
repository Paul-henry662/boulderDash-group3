package model.element.mobile;

import model.element.Element;

public abstract class Mobile extends Element{
	
	/** The x position of a Mobile element*/
	private int x;
	
	/** The y position of a Mobile element*/
	private int y;
	
	/** Instantiates a new Mobile element
	 * 
	 * @param imageUrl
	 * 		element's image sprite url.
	 */
	public Mobile(String imageUrl, int x, int y) {
		super(imageUrl);
		this.setX(x);
		this.setY(y);
	}
	
	public Mobile() {
		super();
	}
	
	/** Get the x position of a Mobile element*/
	public int getX() {
		return x;
	}

	/** Set the x position of a Mobile element
	 * 
	 * @param x
	 * 		the new x position.
	 */
	private void setX(int x) {
		this.x = x;
	}
	
	/** Get the y position of a Mobile element*/
	public int getY() {
		return y;
	}
	
	/** Set the y position of a Mobile element
	 * 
	 * @param y
	 * 		the new y position.
	 */
	private void setY(int y) {
		this.y = y;
	}
	
	/**Move a Mobile element on the left*/
	public void moveLeft() {
		this.setX(this.getX()-1);
	}
	
	/**Move a Mobile element on the right*/
	public void moveRight() {
		this.setX(this.getX()+1);
	}
	
	/**Move a Mobile element upward*/
	public void moveUp() {
		this.setY(this.getY()-1);
	}
	
	/**Move a Mobile element downward*/
	public void moveDown() {
		this.setY(this.getY()+1);
	}
}
