package model;

import contract.IElement;
import contract.IMap;
import entity.Entity;
import model.element.Element;

/**
 * The Class HelloWorld.
 *
 * @author Jean-Aymeric Diet
 */
public class Map extends Entity implements IMap{

	/** The id. */
	private int			id;
	
	/** The width of the map */
	private int 		width;
	
	/** The height of the map */
	private int 		height;

	/** The key. */
	private String	key;

	/** The message. */
	private String	message;
	
	/** The elements on the map */
	private Element[][] onTheMap;

	/**
	 * Instantiates a new hello world.
	 *
	 * @param id
	 *          the id
	 * @param key
	 *          the key
	 * @param message
	 *          the message
	 */
	public Map(final int id, final String key, final int width, final int height, final String message) {
		this.setId(id);
		this.setKey(key);
		this.setWidth(width);
		this.setHeight(height);
		this.setMessage(message);
		this.onTheMap = new Element[width][height];
	}

	public int getWidth() {
		return width;
	}

	private void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	private void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Instantiates a new hello world.
	 */
	public Map() {
		this(0, "", 500, 500, "");
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *          the new id
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey() {
		return this.key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key
	 *          the new key
	 */
	public void setKey(final String key) {
		this.key = key;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	public void setMessage(final String message) {
		this.message = message;
	}
	
	public Element getOnTheMapXY(int x, int y) {
		return this.onTheMap[x][y];
	}
	
	@Override
	public void setOnTheMapXY(IElement element, int x, int y) {
		this.onTheMap[x][y] = (Element) element;
	}


}
