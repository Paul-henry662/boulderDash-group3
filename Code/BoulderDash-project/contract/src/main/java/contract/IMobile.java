package contract;

public interface IMobile extends IElement{
	
	/** Get the x position of a Mobile element
	 * 
	 * @return the x position
	 */
	public int getX();
	
	/** Get the y position of a Mobile element
	 * 
	 * @return the y position
	 */
	public int getY();
	
	/**Move a Mobile element on the left*/
	public void moveLeft();
	
	/**Move a Mobile element on the right*/
	public void moveRight();
	
	/**Move a Mobile element upward*/
	public void moveUp();
	
	/**Move a Mobile element downward*/
	public void moveDown();
}
