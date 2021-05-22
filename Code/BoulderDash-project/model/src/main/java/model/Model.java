package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import model.element.mobile.Rockford;
import model.element.motionless.BrokenBrick;
import model.element.motionless.Ground;
import model.element.motionless.MotionlessFactory;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	
	/**key of the map*/
	private static final String MAP_KEY = "Map1";
	
	/**Size of a square*/
	private static final String MAP_MESSAGE = "I'm the map one";
	
	/**The width of the map */
	private static final int MAP_WIDTH = 40;
	
	/**The height of the map */
	private static final int MAP_HEIGHT = 40;
	
	private static final int ROCKFORD_START_X = 0;
	private static final int ROCKFORD_START_Y = 0;

	/** The map. */
	private Map map;
	
	/**The character */
	private Rockford rockford;
	
	/** The ground*/
	private Ground ground;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.map = new Map(1,MAP_KEY, MAP_WIDTH, MAP_HEIGHT, MAP_MESSAGE);
		this.setGround(new Ground(MAP_WIDTH, MAP_HEIGHT));
		this.setRockford(new Rockford("sprites/74336.png", ROCKFORD_START_X, ROCKFORD_START_Y));
		this.fillMap();
		this.fillGround();
	}

	/**
     * Gets the hello world.
     *
     * @return the hello world
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public Map getMap() {
		return this.map;
	}

	/**
     * Sets the hello world.
     *
     * @param helloWorld
     *            the new hello world
     */
	private void setMap(final Map map) {
		this.map = map;
	}

	/**
     * Load hello world.
     *
     * @param code
     *            the code
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadMap(final String code) {
		try {
			final DAOMap daoLevel = new DAOMap(DBConnection.getInstance().getConnection());
			this.setMap(daoLevel.find(code));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
	
	public void fillMap() {
		for(int y=0;y<this.getMap().getHeight();y+=1) {
			for(int x=0;x<this.getMap().getWidth();x+=1) {
				if(x==this.getRockford().getX() && y==this.getRockford().getY())
					this.getMap().setOnTheMapXY(rockford, x, y);
				else
					this.getMap().setOnTheMapXY(MotionlessFactory.createUnBreakableBrick(), x, y);
			}
		}
	}
	
	public void fillGround() {
		for(int y=0; y<this.getGround().getHeight(); y++) {
			for(int x=0; x<this.getGround().getWidth(); x++) {
				this.getGround().setOnTheGroundXY((BrokenBrick) MotionlessFactory.createBrokenBrick(), x, y);
			}
		}
	}
	
	public Rockford getRockford() {
		return rockford;
	}

	private void setRockford(Rockford rockford) {
		this.rockford = rockford;
	}

	public Ground getGround() {
		return ground;
	}

	private void setGround(Ground ground) {
		this.ground = ground;
	}
	
	public void moveRockfordRight() {
		this.getMap().setOnTheMapXY(null, this.getRockford().getX(), this.getRockford().getY());
		this.getRockford().moveRight();
		this.getRockford().setCurrentSprite(this.getRockford().getSpriteByKey("stepRightPhaseOne"));
		this.getMap().setOnTheMapXY(rockford, this.getRockford().getX(), this.getRockford().getY());
		this.setChanged();
		this.notifyObservers();
	}
	
	public void moveRockfordLeft() {
		this.getMap().setOnTheMapXY(null, this.getRockford().getX(), this.getRockford().getY());
		this.getRockford().moveLeft();
		this.getRockford().setCurrentSprite(this.getRockford().getSpriteByKey("stepLeftPhaseOne"));
		this.getMap().setOnTheMapXY(rockford, this.getRockford().getX(), this.getRockford().getY());
		this.setChanged();
		this.notifyObservers();
	}
	
	public void moveRockfordUp() {
		this.getMap().setOnTheMapXY(null, this.getRockford().getX(), this.getRockford().getY());
		this.getRockford().moveUp();
		this.getRockford().setCurrentSprite(this.getRockford().getSpriteByKey("stepUp"));
		this.getMap().setOnTheMapXY(rockford, this.getRockford().getX(), this.getRockford().getY());
		this.setChanged();
		this.notifyObservers();
	}
	
	public void moveRockfordDown() {
		this.getMap().setOnTheMapXY(null, this.getRockford().getX(), this.getRockford().getY());
		this.getRockford().moveDown();
		this.getRockford().setCurrentSprite(this.getRockford().getSpriteByKey("stepDown"));
		this.getMap().setOnTheMapXY(rockford, this.getRockford().getX(), this.getRockford().getY());
		this.setChanged();
		this.notifyObservers();
	}
	
}
