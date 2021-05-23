package contract;

import java.util.Observable;



/**
 * The Interface IModel.
 *
 * @authors Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
 */
public interface IModel {

	/**
	 * Gets a map.
	 *
	 * @return the map entity;
	 */
	IMap getMap();
	
	/**Gets the ground*/
	IGround getGround();

	/**
	 * Load a map.
	 *
	 * @param code
	 *          the code
	 */
	void loadMap(String code);
	
	/** Move the character left.*/
	public void moveRockfordLeft();
	
	/** Move the character right.*/
	public void moveRockfordRight();
	
	/** Move the character up.*/
	public void moveRockfordUp();
	
	/** Move the character down.*/
	public void moveRockfordDown();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
