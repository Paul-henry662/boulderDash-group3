package contract;

import java.util.Observable;

import entity.Level;

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
	Level getLevel();

	/**
	 * Load the message.
	 *
	 * @param code
	 *          the code
	 */
	void loadLevel(String code);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
