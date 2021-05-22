package contract;

import java.util.Observable;


/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the hello world.
	 *
	 * @return the helloworld entity
	 */
	IMap getMap();
	
	IGround getGround();

	/**
	 * Load the message.
	 *
	 * @param code
	 *          the code
	 */
	void loadMap(String code);
	
	public void moveRockfordLeft();
	
	public void moveRockfordRight();
	
	public void moveRockfordUp();
	
	public void moveRockfordDown();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
