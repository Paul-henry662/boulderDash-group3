package model.element.mobile;

import contract.IElement;
import model.element.Element;

public class EnemyFactory {
	public static IElement createButterfly(int x, int y) {
		return new Butterfly("sprites/74359.png", x, y);
	}
}
