package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import contract.ControllerOrder;
import contract.IElement;
import contract.IGround;
import contract.IMap;
import contract.IMobile;
import contract.IModel;
import contract.IMotionless;
import contract.Permeability;
import model.element.mobile.Rockford;
import model.element.motionless.BreakableBrick;
import model.element.motionless.BrokenBrick;
import model.element.motionless.Motionless;
import model.element.motionless.MotionlessFactory;

/**
 * The Class Model.
 *
 * @authors Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
 */
public final class Model extends Observable implements IModel {

	
	/**key of the map*/
	private static final String MAP_KEY = "Map1";
	
	/**The width of the map */
	private static final int MAP_WIDTH = 50;
	
	/**The height of the map */
	private static final int MAP_HEIGHT = 50;
	
	/**Start position of the character*/
	private static final int ROCKFORD_START_X = 4;
	
	/**Start position of the character*/
	private static final int ROCKFORD_START_Y = 5;

	/** The map. */
	private IMap map;
	
	/**The character */
	private Rockford rockford;
	
	/** The ground*/
	private IGround ground;
	
	/** The score */
	private int score;
	
	private int timer = 60;

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		//this.map = new Map(1,MAP_KEY, MAP_WIDTH, MAP_HEIGHT);
		try {
			this.map = new Map(1, MAP_KEY, "txt/Level1.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setGround(new Ground(this.getMap().getWidth(), this.getMap().getHeight()));
		this.setRockford(new Rockford("sprites/74336.png", ROCKFORD_START_X, ROCKFORD_START_Y));
		//this.fillMap();
		this.fillGround();
	}

	/**
     * Gets the map.
     *
     * @return the map.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMap()
	 */
	public IMap getMap() {
		return this.map;
	}

	/**
     * Sets the map.
     *
     * @param map
     *            the new map
     */
	private void setMap(final Map map) {
		this.map = map;
	}

	/**
     * Load map.
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
	
	/** Fills the map*/
	public void fillMap() {
		for(int y=0;y<this.getMap().getHeight();y+=1) {
			for(int x=0;x<this.getMap().getWidth();x+=1) {
				if(x==this.getRockford().getX() && y==this.getRockford().getY())
					this.getMap().setOnTheMapXY(null, x, y);
				else
					this.getMap().setOnTheMapXY(MotionlessFactory.createBreakableBrick(), x, y);
			}
		}
		this.getMap().setOnTheMapXY(MotionlessFactory.createUnBreakableBrick(), 10, 10);
		this.getMap().setOnTheMapXY(MotionlessFactory.createRock(), 15, 20);
		this.getMap().setOnTheMapXY(MotionlessFactory.createDiamond(), 20, 20);
	}
	
	/**Fills the ground*/
	public void fillGround() {
		for(int y=0; y<this.getGround().getHeight(); y++) {
			for(int x=0; x<this.getGround().getWidth(); x++) {
				this.getGround().setOnTheGroundXY((BrokenBrick) MotionlessFactory.createBrokenBrick(), x, y);
			}
		}
	}
	
	/** Gets the character */
	public IMobile getRockford() {
		return rockford;
	}

	/** Sets the character
	 * 
	 * @param rockford
	 */
	private void setRockford(Rockford rockford) {
		this.rockford = rockford;
	}
	
	/** Gets the ground*/
	public IGround getGround() {
		return ground;
	}
	
	/**Sets the ground*/
	private void setGround(Ground ground) {
		this.ground = ground;
	}
	
	/** Moves the character to the right on the map */
	public void moveRockfordRight() {
		this.getMap().setOnTheMapXY(null, this.getRockford().getX(), this.getRockford().getY());
		this.getRockford().moveRight();
		this.getMap().setOnTheMapXY(null, this.getRockford().getX(), this.getRockford().getY());
	}
	
	/** Moves the character to the left on the map */
	public void moveRockfordLeft() {
		this.getMap().setOnTheMapXY(null, this.getRockford().getX(), this.getRockford().getY());
		this.getRockford().moveLeft();
		this.getMap().setOnTheMapXY(null, this.getRockford().getX(), this.getRockford().getY());
	}
	
	/** Moves the character upward on the map */
	public void moveRockfordUp() {
		this.getMap().setOnTheMapXY(null, this.getRockford().getX(), this.getRockford().getY());
		this.getRockford().moveUp();
		this.getMap().setOnTheMapXY(null, this.getRockford().getX(), this.getRockford().getY());
	}
	
	/** Moves the character downward on the map */
	public void moveRockfordDown() {
		this.getMap().setOnTheMapXY(null, this.getRockford().getX(), this.getRockford().getY());
		this.getRockford().moveDown();
		this.getMap().setOnTheMapXY(null, this.getRockford().getX(), this.getRockford().getY());
	}
	
	public void makeRockfordMoveElementRightXY(int x, int y) {
		IMotionless elmnt = this.getMap().getOnTheMapXY(x, y);
		this.getMap().setOnTheMapXY(null, x, y);
		this.getMap().setOnTheMapXY(null, x+1, y);
		this.getRockford().moveRight();
	}

	@Override
	public int getScore() {
		return this.score;
	}
	
	public void doNothing() {
		
	}

	@Override
	public void setScore(int score) {
		this.score = score;
	}
	
	public void notifyModelHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}
	
	public boolean rockfordIsAlive() {
		if(rockford.isAlive)
			return true;
		return false;
	}
	
	public void setRockfordAlive(boolean b) {
		this.rockford.isAlive = b;
	}
}
