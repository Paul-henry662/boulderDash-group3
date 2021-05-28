package model.element.motionless;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BrokenBrickTest extends BrickTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() {
		this.element = new BrokenBrick();
		
		try {
			this.element.loadImages("sprites/74359.png");
		} catch(IOException e) {
			fail("Can't read input file");
		}
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Override 
	public void testLoadImages() {
		assertNotNull(this.element.getSpriteByKey("normal"));
	}

}
