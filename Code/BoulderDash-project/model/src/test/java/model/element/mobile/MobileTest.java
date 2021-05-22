package model.element.mobile;

import static org.junit.Assert.*;

import org.junit.Test;

import model.element.ElementTest;

public abstract class MobileTest extends ElementTest {
	
	@Test
	public void testMoveLeft() {
		int expected = -16;
		((Mobile) this.element).moveLeft();
		assertEquals(expected, ((Mobile) this.element).getX());
	}

	@Test
	public void testMoveRight() {
		int expected = 16;
		((Mobile) this.element).moveRight();
		assertEquals(expected, ((Mobile) this.element).getX());
	}

	@Test
	public void testMoveUp() {
		int expected = -16;
		((Mobile) this.element).moveUp();
		assertEquals(expected, ((Mobile) this.element).getY());
	}

	@Test
	public void testMoveDown() {
		int expected = 16;
		((Mobile) this.element).moveDown();
		assertEquals(expected, ((Mobile) this.element).getY());
	}

}
