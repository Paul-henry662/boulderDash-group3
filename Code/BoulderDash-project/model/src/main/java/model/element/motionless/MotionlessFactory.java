package model.element.motionless;

public class MotionlessFactory {
	
	/**The Diamond*/
	private static final Motionless DIAMOND = new Diamond("sprites/74359.png");
	
	/**The BrokenBrick*/
	private static final Motionless BROCKEN_BRICK = new BrokenBrick("sprites/74359.png");
	
	/**The BreakableBrick*/
	private static final Motionless BREAKABLE_BRICK = new BreakableBrick("sprites/74359.png");
	
	/**The UnBreakableBrick*/
	private static final Motionless UNBREAKABLE_BRICK = new UnBreakableBrick("sprites/74359.png");
	
	/**The Rock*/
	private static final Motionless ROCK = new Rock("sprites/74359.png");
	
	public static Motionless createDiamond() {
		return DIAMOND;
	}
	
	public static Motionless createBrokenBrick() {
		return BROCKEN_BRICK;
	}
	
	public static Motionless createBreakableBrick() {
		return BREAKABLE_BRICK;
	}
	
	public static Motionless createUnBreakableBrick() {
		return UNBREAKABLE_BRICK;
	}
	
	
	public static Motionless createRock() {
		return ROCK;
	}
}
