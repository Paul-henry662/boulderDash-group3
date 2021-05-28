package model.element.mobile;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;


public class ButterflyTest extends MobileTest {

	@Before
	public void setUp() throws Exception {
		this.element = new Butterfly();
	}

	@Override
	public void testLoadImages() {
		try {
			this.element.loadImages("sprites/74359.png");
		}catch(IOException e) {
			fail("Can't read input file");
		}
		
		assertNotNull(this.element.getSpriteByKey("flyPhaseOne"));
		assertNotNull(this.element.getSpriteByKey("flyPhaseTwo"));
		assertNotNull(this.element.getSpriteByKey("flyPhaseThree"));
		assertNotNull(this.element.getSpriteByKey("flyPhaseFour"));
	}

}
