package controller;

import contract.ControllerOrder;
import contract.IController;
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
public final class Controller implements IController {

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
					break;
				}
			break;
		case NOP:
			this.model.doNothing();
			break;
		}
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
			nextElement = (IMotionless) this.model.getMap().getOnTheMapXY(this.model.getRockford().getX()-1, this.model.getRockford().getY());
			break;
		case RIGHT:
			nextElement = (IMotionless) this.model.getMap().getOnTheMapXY(this.model.getRockford().getX()+1, this.model.getRockford().getY());
			break;
		case UP:
			nextElement = (IMotionless) this.model.getMap().getOnTheMapXY(this.model.getRockford().getX(), this.model.getRockford().getY()-1);
			break;
		case DOWN:
			nextElement = (IMotionless) this.model.getMap().getOnTheMapXY(this.model.getRockford().getX(), this.model.getRockford().getY()+1);
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

}
