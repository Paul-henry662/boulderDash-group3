package model.element.mobile;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class RockfordTest extends MobileTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.element = new Rockford(null, 0, 0);
		try {
			this.element.loadImages("sprites/74336.png");
		}catch(IOException e) {
			fail("Can't read input file");
		}
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Override
	public void testGetSprite() {
		assertNotNull(this.element.getSprite("stepRightPhaseOne"));
	}
	
	@Override
	public void testLoadImages() {
		assertNotNull(this.element.getSprite("stepRightPhaseOne"));
		assertNotNull(this.element.getSprite("stepRightPhaseTwo"));
		assertNotNull(this.element.getSprite("stepRightPhaseThree"));
		assertNotNull(this.element.getSprite("stepLeftPhaseOne"));
		assertNotNull(this.element.getSprite("stepLeftPhaseTwo"));
		assertNotNull(this.element.getSprite("stepLeftPhaseThree"));
	}
	
}
