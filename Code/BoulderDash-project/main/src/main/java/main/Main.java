package main;

import controller.Controller;
import model.Model;
import view.View;
import view.ViewSound;

/**
 * The Class Main.
 *
 * @authors Paul-henry NGANKAM
 * 			Georges Arthur Balog
 * 			Prince Jordan Tankwa
 * 			Gregori Tema
 */
public abstract class Main {
	
	

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final Model model = new Model();
        final View view = new View(model);
        final Controller controller = new Controller(view, model);
        view.setController(controller);
        controller.control();        
      
  }  
}   