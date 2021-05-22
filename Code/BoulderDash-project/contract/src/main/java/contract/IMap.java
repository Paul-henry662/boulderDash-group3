package contract;


public interface IMap {

	public int getWidth();

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
	public String getMessage();

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	public void setMessage(final String message);
	
	public IElement getOnTheMapXY(int x, int y);
	
	public void setOnTheMapXY(IElement element, int x, int y);
}
