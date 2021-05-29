package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModelTest {
	
	Model model;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		model = new Model();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoadMapInt() {
		model.loadMap(1);
		
		assertNotNull(model.getMap());
		assertEquals(1, model.getMap().getId());
		assertEquals("Map1", model.getMap().getKey());
		assertEquals(50, model.getMap().getWidth());
		assertEquals(50, model.getMap().getHeight());
	}

	@Test
	public void testFillMap() {
		model.fillMap();
		assertNotNull(this.model.getMap().getOnTheMapXY(0, 0));
	}

}
