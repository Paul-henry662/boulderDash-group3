package model.element.motionless;

import contract.IElement;
import contract.IGround;

public class Ground implements IGround{
	
	private int width;
	private int height;
	private BrokenBrick[][] onTheGround;
	
	public Ground(int width, int height) {
		this.onTheGround = new BrokenBrick[width][height];
		this.setWidth(width);
		this.setHeight(height);
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

	
	public void setOnTheGroundXY(IElement brokenBrick, int x, int y) {
		this.onTheGround[x][y] = (BrokenBrick) brokenBrick;
	}
	
	public IElement getOnTheGroundXY(int x, int y) {
		return this.onTheGround[x][y];
	}
}
