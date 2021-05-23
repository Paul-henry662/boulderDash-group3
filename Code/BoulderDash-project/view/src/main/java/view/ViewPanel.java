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
 * @authors Paul-henry NGANKAM
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
	 */
	public void paintGround(Graphics graphics) {
		for(int y=0; y<this.getViewFrame().getModel().getGround().getHeight(); y++) {
			for(int x=0; x<this.getViewFrame().getModel().getGround().getWidth(); x++)
				graphics.drawImage(this.getViewFrame().getModel().getGround().getOnTheGroundXY(x, y).getCurrentSprite(), x*View.SQUARE_SIZE, y*View.SQUARE_SIZE, null);
		}
	}
	
	/** Paints the map 
	 * 
	 * @param graphics
	 */
	public void paintMap(Graphics graphics) {
		for(int y=0; y<this.getViewFrame().getModel().getMap().getHeight(); y++) {
			for(int x=0; x<this.getViewFrame().getModel().getMap().getWidth(); x++)
				if(this.getViewFrame().getModel().getMap().getOnTheMapXY(x, y) != null)
					graphics.drawImage(this.getViewFrame().getModel().getMap().getOnTheMapXY(x, y).getCurrentSprite(), x*View.SQUARE_SIZE, y*View.SQUARE_SIZE, null);
		}
	}
	
	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}
	

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {		
		Graphics2D graphics2d = (Graphics2D) graphics;
		this.paintGround(graphics2d);
		this.paintMap(graphics2d);
		/*graphics2d.setPaint(Color.white);
		graphics2d.drawString("Score: ", 50, 50);*/
	}
}