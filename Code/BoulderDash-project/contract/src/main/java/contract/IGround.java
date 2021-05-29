package contract;

/**
 * The Interface IGround.
 *
 * @author Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
 */
public interface IGround {
	
	/** Get the height of the ground
	 * 
	 * @return the height of the ground.
	 */
	public int getHeight();
	
	/** Get the width of the ground
	 * 
	 * @return the width of the ground.
	 */
	public int getWidth();
	
	/** Set a broken brick on the ground at position (x,y)
	 * 
	 * @param brokenBrick
	 * 			The brokenBrick element.
	 * @param x
	 * 			the x position.
	 * @param y
	 * 			the y position.
	 */
	public void setOnTheGroundXY(IElement brokenBrick, int x, int y);
	
	/** Get the element on the ground at position (x,y).
	 * 
	 * @param x
	 * 			the x position.
	 * @param y
	 * 			the y position.
	 * @return the element on the ground at (x,y). 
	 */
	public IElement getOnTheGroundXY(int x, int y);
}
