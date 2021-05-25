package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import contract.IElement;
import contract.IMap;
import entity.Entity;
import model.element.Element;
import model.element.motionless.MotionlessFactory;

/**
 * The Class Map.
 *
 * @authors Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
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
	
	/** The elements on the map */
	private IElement[][] onTheMap;

	/**Instantiates a new Map 
	 * 
	 * @param id
	 * @param key
	 * @param width
	 * @param height
	 */
	public Map(final int id, final String key, final int width, final int height) {
		this.setId(id);
		this.setKey(key);
		this.setWidth(width);
		this.setHeight(height);
		this.onTheMap = new Element[width][height];
	}
	
	public Map(final int id, final String key, String fileUrl) throws IOException {
		this.setId(id);
		this.setKey(key);
		this.generateMapFromFile(fileUrl);
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
		this(0, "", 50, 50);
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Override
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *          the new id
	 */
	@Override
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	@Override
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

	@Override
	public IElement getOnTheMapXY(int x, int y) {
		return this.onTheMap[x][y];
	}
	
	@Override
	public void setOnTheMapXY(IElement element, int x, int y) {
		this.onTheMap[x][y] = (Element) element;
	}
	
	public void generateMapFromFile(String fileUrl) throws IOException {
		FileReader fr = new FileReader(fileUrl);
		BufferedReader br = new BufferedReader(fr);
		int y = 0;
		
		String line = br.readLine();
		this.setWidth(Integer.parseInt(line));
		line = br.readLine();
		this.setHeight(Integer.parseInt(line));
		
		this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
		line = br.readLine();
        while (line != null && y < this.getWidth()) {
            for (int x = 0; x < line.toCharArray().length; x++) {
            	this.setOnTheMapXY(MotionlessFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
            }
            line = br.readLine();
            y++;
        }
        br.close();
       
	}


}
