package contract;

/**
 * The Interface IMap.
 *
 * @authors Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
 */

public interface IMap {
	
	/** Get the width of the map. */
	public int getWidth();

	/** Get the height of the map. */
	public int getHeight();

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId();
	

	/**
	 * Sets the id.
	 *
	 * @param id
	 *          the new id
	 */
	public void setId(final int id);
	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey();
	

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	
	public IElement getOnTheMapXY(int x, int y);
	
	/** Set an element on the map at position (x, y)
	 * 
	 * @param elmnt
	 * @param x
	 * @param y
	 */
	public void setOnTheMapXY(IElement elmnt, int x, int y);
}
