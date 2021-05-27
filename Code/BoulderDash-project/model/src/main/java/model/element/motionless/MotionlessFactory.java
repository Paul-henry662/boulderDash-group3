package model.element.motionless;

import contract.IElement;
import model.element.Element;

public class MotionlessFactory {
	
	/**The Diamond*/
	private static final IElement DIAMOND = new Diamond("sprites/74359.png");
	
	/**The BrokenBrick*/
	private static final IElement BROKEN_BRICK = new BrokenBrick("sprites/74359.png");
	
	/**The BreakableBrick*/
	private static final IElement BREAKABLE_BRICK = new BreakableBrick("sprites/74359.png");
	
	/**The UnBreakableBrick*/
	private static final IElement UNBREAKABLE_BRICK = new UnBreakableBrick("sprites/74359.png");
	
	/**The Rock*/
	private static final IElement ROCK = new Rock("sprites/74359.png");
	
	public static IElement createDiamond() {
		return DIAMOND;
	}
	
	public static IElement createBrokenBrick() {
		return BROKEN_BRICK;
	}
	
	public static IElement createBreakableBrick() {
		return BREAKABLE_BRICK;
	}
	
	public static IElement createUnBreakableBrick() {
		return UNBREAKABLE_BRICK;
	}
	
	
	public static IElement createRock() {
		return ROCK;
	}
	
	public static IElement getFromFileSymbol(char character) {
		
		IElement elmnt = null;
		switch(character) {
		case 'B':
			elmnt = BREAKABLE_BRICK;
			break;
		case 'b':
			break;
		case 'U':
			elmnt = UNBREAKABLE_BRICK;
			break;
		case 'D':
			elmnt = DIAMOND;
			break;
		case 'R':
			elmnt = ROCK;
			break;
		default:
			break;	
		}
		return elmnt;
	}
}
