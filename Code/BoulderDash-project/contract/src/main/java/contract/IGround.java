package contract;

public interface IGround {

	public int getHeight();
	
	public int getWidth();
	
	public void setOnTheGroundXY(IElement brokenBrick, int x, int y);
	
	public IElement getOnTheGroundXY(int x, int y);
}
