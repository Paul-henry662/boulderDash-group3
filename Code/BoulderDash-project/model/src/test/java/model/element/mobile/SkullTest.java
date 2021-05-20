package model.element.mobile;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SkullTest extends MobileTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.element = new Skull(null, 0, 0);
		try {
			this.element.loadImages("sprites/74359.png");
		}catch(IOException e) {
			fail("Can't read input file");
		}
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Override
	public void testGetSprite() {
		assertNotNull(this.element.getSprite("PhaseOne"));
	}
	
	@Override
	public void testLoadImages() {
		assertNotNull(this.element.getSprite("PhaseOne"));
		assertNotNull(this.element.getSprite("PhaseTwo"));
		assertNotNull(this.element.getSprite("PhaseThree"));
		assertNotNull(this.element.getSprite("PhaseFour"));
	}

}
