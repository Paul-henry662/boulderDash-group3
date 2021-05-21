package model.element.mobile;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;


public class ButterflyTest extends MobileTest {

	@Before
	public void setUp() throws Exception {
		this.element = new Butterfly(null, 0, 0);
	}

	@Override
	public void testLoadImages() {
		try {
			this.element.loadImages("sprites/74359.png");
		}catch(IOException e) {
			fail("Can't read input file");
		}
		
		assertNotNull(this.element.getSprite("flyPhaseOne"));
		assertNotNull(this.element.getSprite("flyPhaseTwo"));
		assertNotNull(this.element.getSprite("flyPhaseThree"));
		assertNotNull(this.element.getSprite("flyPhaseFour"));
	}

}
