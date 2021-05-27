package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class ExtrasPanel extends JPanel implements Observer{
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
	public ExtrasPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		this.width = this.getViewFrame().getModel().getMap().getWidth()*View.SQUARE_SIZE;
		this.height = (this.getViewFrame().getModel().getMap().getHeight()*View.SQUARE_SIZE);
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
	
	
	private void paintScore(Graphics graphics) {
		graphics.drawString("Score: "+this.getViewFrame().getModel().getScore(), 20, 20);
	}
	
	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}
	
	private void paintTime(Graphics graphics) {
		graphics.drawString("Time: "+this.getViewFrame().getModel().getTimer(), 100, 20);
	}
	
	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {	
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setPaint(Color.white);
		this.paintScore(graphics2d);
		this.paintTime(graphics2d);
	}
}
