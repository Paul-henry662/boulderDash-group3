package contract;

/**
 * The Interface IGround.
 *
 * @authors Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
 */

public interface IGround {
	
	/** Get the height of the ground*/
	public int getHeight();
	
	/** Get the width of the ground*/
	public int getWidth();
	
	/** Set a broken brick on the ground at position (x,y)
	 * 
	 * @param brokenBrick
	 * @param x
	 * @param y
	 */
	public void setOnTheGroundXY(IElement brokenBrick, int x, int y);
	
	
	/** Get the element on the ground at position (x,y).
	 * 
	 * @param x
	 * @param y
	 * @return the element on the ground at (x,y). 
	 */
	public IElement getOnTheGroundXY(int x, int y);
}
