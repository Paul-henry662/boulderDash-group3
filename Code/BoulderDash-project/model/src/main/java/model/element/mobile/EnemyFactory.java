package model.element.mobile;

import contract.IElement;
import model.element.Element;

public class EnemyFactory {
	public static IElement createButterfly(int x, int y) {
		return new Butterfly("sprites/74359.png", x, y);
	}
	
	public static IElement getFromFileSymbol(char c, int x, int y) {
		IElement elmnt = null;
		
		switch(c) {
		case 'E':
			elmnt = new Butterfly("sprites/74359.png", x, y);
			break;
		case 'M':
			elmnt = elmnt = new Butterfly("sprites/74359.png", x, y);
			break;
		}
		
		return elmnt;
	}
}
