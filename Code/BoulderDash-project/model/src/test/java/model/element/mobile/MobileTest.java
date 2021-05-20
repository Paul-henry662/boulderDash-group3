package model.element.mobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.element.ElementTest;

public abstract class MobileTest extends ElementTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetX() {
		int expected = 0;
		assertEquals(expected, ((Mobile) this.element).getX());
	}

	@Test
	public void testGetY() {
		int expected = 0;
		assertEquals(expected, ((Mobile) this.element).getY());
	}

	@Test
	public void testMoveLeft() {
		((Mobile) this.element).moveLeft();
		int expected = -1;
		assertEquals(expected, ((Mobile) this.element).getX());
	}

	@Test
	public void testMoveRight() {
		((Mobile) this.element).moveRight();
		int expected = 1;
		assertEquals(expected, ((Mobile) this.element).getX());
	}

	@Test
	public void testMoveUp() {
		((Mobile) this.element).moveUp();
		int expected = -1;
		assertEquals(expected, ((Mobile) this.element).getY());
	}

	@Test
	public void testMoveDown() {
		((Mobile) this.element).moveDown();
		int expected = 1;
		assertEquals(expected, ((Mobile) this.element).getY());
	}

}
