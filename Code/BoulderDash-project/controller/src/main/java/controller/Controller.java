package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IElement;
import contract.IModel;
import contract.IMotionless;
import contract.IView;
import contract.Permeability;

/**
 * The Class Controller.
 *
 * @authors Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
 */
public final class Controller extends Thread implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/**
     * Control.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Pick all the diamonds!");
	}
	
	public void play() {
		this.view.begin();
		this.start();
	}

	/**
     * Sets the view.
     *
     * @param pview
     *            the new view
     */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch(controllerOrder) {
		case LEFT:
			if(this.rockfordInLeftBound())
				switch(this.getNextElementPermeability(controllerOrder)) {
				case BLOCKING:
					this.model.doNothing();
					break;
				case PASSING:
					this.model.moveRockfordLeft();
					break;
				case PICKABLE:
					this.pick();
					this.model.moveRockfordLeft();
					break;
				}
			break;
		case RIGHT:
			if(this.rockfordInRightBound())
				switch(this.getNextElementPermeability(controllerOrder)) {
				case BLOCKING:
					this.model.doNothing();
					break;
				case PASSING:
					this.model.moveRockfordRight();
					break;
				case PICKABLE:
					this.pick();
					this.model.moveRockfordRight();
					break;
				}
			break;
			
		case UP:
			if(this.rockfordInUpBound())
				switch(this.getNextElementPermeability(controllerOrder)) {
				case BLOCKING:
					this.model.doNothing();
					break;
				case PASSING:
					this.model.moveRockfordUp();
					break;
				case PICKABLE:
					this.pick();
					this.model.moveRockfordUp();
					break;
				}
			break;
		case DOWN: 
			if(this.rockfordInDownBound())
				switch(this.getNextElementPermeability(controllerOrder)) {
				case BLOCKING:
					this.model.doNothing();
					break;
				case PASSING:
					this.model.moveRockfordDown();
					break;
				case PICKABLE:
					this.pick();
					this.model.moveRockfordDown();
					break;
				}
			break;
		case NOP:
			this.model.doNothing();
			break;
		}
		this.model.notifyModelHasChanged();
	}
	
	private boolean rockfordInLeftBound() {
		if(this.model.getRockford().getX()-1 >= 0)
			return true;
		return false;
	}
	
	private boolean rockfordInRightBound() {
		if(this.model.getRockford().getX()+1 < this.model.getMap().getWidth())
			return true;
		return false;
	}
	
	private boolean rockfordInUpBound() {
		if(this.model.getRockford().getY()-1 >= 0)
			return true;
		return false;
	}
	
	private boolean rockfordInDownBound() {
		if(this.model.getRockford().getY()+1 < this.model.getMap().getHeight())
			return true;
		return false;
	}
	
	/*private Permeability getNextElementPermeability() {
		IMotionless nextElement = (IMotionless) this.model.getMap().getOnTheMapXY(this.model.getRockford().getX(), this.model.getRockford().getY());
		
		if(nextElement == null)
			return Permeability.PASSING;
		return nextElement.getPermeability();
	}*/
	
	private void pick() {
		this.model.setScore(this.model.getScore()+1);
	}
	
	private Permeability getNextElementPermeability(ControllerOrder controllerOrder) {
		IMotionless nextElement = null;
		
		switch(controllerOrder) {
		case LEFT:
			nextElement = this.model.getMap().getOnTheMapXY(this.model.getRockford().getX()-1, this.model.getRockford().getY());
			break;
		case RIGHT:
			nextElement = this.model.getMap().getOnTheMapXY(this.model.getRockford().getX()+1, this.model.getRockford().getY());
			break;
		case UP:
			nextElement = this.model.getMap().getOnTheMapXY(this.model.getRockford().getX(), this.model.getRockford().getY()-1);
			break;
		case DOWN:
			nextElement = this.model.getMap().getOnTheMapXY(this.model.getRockford().getX(), this.model.getRockford().getY()+1);
			break;
		case NOP:
			break;
		default:
			break;	
		}
		
		if(nextElement == null)
			return Permeability.PASSING;
		return nextElement.getPermeability();
	}
	
	public void setGravity() {
	IMotionless elmnt;
	
	while(true) {
		for(int y=0; y<this.model.getMap().getHeight()-1; y++) {
			for(int x=0; x<this.model.getMap().getWidth()-1; x++) {
				elmnt = this.model.getMap().getOnTheMapXY(x, y);

				if(elmnt==null) {
					continue;
				}
				else if(elmnt.getPermeability() == Permeability.MOVABLE ||elmnt.getPermeability() == Permeability.PICKABLE) {
					int finalY = this.calculateFinalY(x, y);
					this.makeElementXYFallOnTheMap(x, y, finalY);
				}
			}
		}
	}
}

@Override
public void run() {
	this.setGravity();
}


private boolean rockfordCarriesElementXY(int x, int y) {
	if(x==this.model.getRockford().getX() && this.model.getRockford().getY()==y+1) {
		System.out.println("He carries");
		return true;
	}
	return false;
}

private boolean rockfordIsUnderElementXY(int x, int y) {
	if(x==this.model.getRockford().getX() && this.model.getRockford().getY() > y+1)
		return true;
	return false;
}

private void delay(long time) {
	try {
		Thread.sleep(time);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void makeElementXYFallOnTheMap(int x, int y, int finalY) {
	IMotionless elmnt = this.model.getMap().getOnTheMapXY(x, y);
	
	for(int i=y; i<finalY-1;i++) {
		this.delay(100);
		this.model.getMap().setOnTheMapXY(null, x, i);
		this.model.getMap().setOnTheMapXY(elmnt, x, i+1);
		this.model.notifyModelHasChanged();
	}
}

private int calculateFinalY(int x, int y) {
	IMotionless elmnt = this.model.getMap().getOnTheMapXY(x, y+1);
	
	while(elmnt == null) {
		if(this.rockfordCarriesElementXY(x, y))
			break;
		y++;
		elmnt = this.model.getMap().getOnTheMapXY(x, y);
	}
	
	return y;
}

}
