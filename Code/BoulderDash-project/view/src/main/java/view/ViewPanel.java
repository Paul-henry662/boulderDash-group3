package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * The class ViewPanel.
 *
 * @author Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	
	/** The Constant serialVersionUID. */
	private static final long			serialVersionUID	= -998294702363713521L;
	
	/** The width of the panel */
	private int width;
	
	/** The height of the panel */
	private int height;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		this.width = this.getViewFrame().getModel().getMap().getWidth()*View.SQUARE_SIZE;
		this.height = this.getViewFrame().getModel().getMap().getHeight()*View.SQUARE_SIZE;
		this.setPreferredSize(new Dimension(this.width, this.height));
		viewFrame.getModel().getObservable().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}
	
	/** Paints the ground behind the map 
	 * 
	 * @param graphics
	 * 			the graphics component.
	 */
	private void paintGround(Graphics graphics) {
		for(int y=0; y<this.getViewFrame().getModel().getGround().getHeight(); y++) {
			for(int x=0; x<this.getViewFrame().getModel().getGround().getWidth(); x++)
				graphics.drawImage(this.getViewFrame().getModel().getGround().getOnTheGroundXY(x, y).getCurrentSprite(), x*View.SQUARE_SIZE, y*View.SQUARE_SIZE, null);
		}
	}
	
	/** Paints the map 
	 * 
	 * @param graphics
	 * 		the graphics component.
	 */
	private void paintMap(Graphics graphics) {
		for(int y=0; y<this.getViewFrame().getModel().getMap().getHeight(); y++) {
			for(int x=0; x<this.getViewFrame().getModel().getMap().getWidth(); x++)
				if(this.getViewFrame().getModel().getMap().getOnTheMapXY(x, y) != null)
					graphics.drawImage(this.getViewFrame().getModel().getMap().getOnTheMapXY(x, y).getCurrentSprite(), x*View.SQUARE_SIZE, y*View.SQUARE_SIZE, null);
		}
	}
	
	private void paintRockford(Graphics graphics) {
		int x = this.getViewFrame().getModel().getRockford().getX()*View.SQUARE_SIZE;
		int y = this.getViewFrame().getModel().getRockford().getY()*View.SQUARE_SIZE;
		graphics.drawImage(this.getViewFrame().getModel().getRockford().getCurrentSprite(), x, y, null);
	}
	
	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}
	private void followOnX(Graphics graphics) {
		int rockfordX = this.getViewFrame().getModel().getRockford().getX();
		int mapWidth = this.getViewFrame().getModel().getMap().getWidth();
		
		if(rockfordX >= (int) mapWidth/4)
			graphics.translate(-2*View.SQUARE_SIZE, 0);
		if(rockfordX >= (int) mapWidth/3)
			graphics.translate(-4*View.SQUARE_SIZE, 0);
		if(rockfordX >= (int) mapWidth/2)
			graphics.translate(-6*View.SQUARE_SIZE, 0);
		if(rockfordX >= (int) 2*mapWidth/3)
			graphics.translate(-8*View.SQUARE_SIZE, 0);
		if(rockfordX >= (int) 3*mapWidth/4)
			graphics.translate(-10*View.SQUARE_SIZE, 0);
	}
	
	private void followOnY(Graphics graphics) {
		int rockfordY = this.getViewFrame().getModel().getRockford().getY();
		int mapHeight = this.getViewFrame().getModel().getMap().getHeight();
		
		if(rockfordY >= (int) mapHeight/4)
			graphics.translate(0, -2*View.SQUARE_SIZE);
		if(rockfordY >= (int) mapHeight/3)
			graphics.translate(0, -4*View.SQUARE_SIZE);
		if(rockfordY >= (int) mapHeight/2)
			graphics.translate(0, -6*View.SQUARE_SIZE);
		if(rockfordY >= (int) 2*mapHeight/3)
			graphics.translate(0, -8*View.SQUARE_SIZE);
		if(rockfordY >= (int) 3*mapHeight/4)
			graphics.translate(0, -10*View.SQUARE_SIZE);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {		
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.scale(2, 2);
		this.followOnX(graphics2d);
		this.followOnY(graphics2d);
		this.paintGround(graphics2d);
		this.paintMap(graphics2d);
		this.paintRockford(graphics2d);
	}
}