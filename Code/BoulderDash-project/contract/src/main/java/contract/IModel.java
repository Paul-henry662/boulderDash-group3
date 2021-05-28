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
	
	/**
	 * Gets the ground*/
	IGround getGround();

	/**
	 * Load a map.
	 *
	 * @param code
	 *          the code
	 */
	void loadMap(String code);
	
	/**
	 * Moves the character according to a ControllerOrder.
	 * 
	 * @param controllerOrder
	 */
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
	
	public int getScore();
	
	public void setScore(int score);
	
	public IMobile getRockford();
	
	public void doNothing();
	
	public void makeRockfordMoveElementRightXY(int x, int y);

	void notifyModelHasChanged();
	
	int getTimer();
	
	void setTimer(int timer);
	
	public boolean rockfordIsAlive();
	
	public void setRockfordAlive(boolean b);
	
	public void animateButterflies();
	
	public void moveButterflies();
}
