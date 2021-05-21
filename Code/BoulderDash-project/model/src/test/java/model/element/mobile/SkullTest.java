package model.element.mobile;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Before;

public class SkullTest extends MobileTest {

	@Before
	public void setUp() throws Exception {
		this.element = new Skull(null, 0, 0);
	}
	
	@Override
	public void testLoadImages() {
		try {
			this.element.loadImages("sprites/74359.png");
		}catch(IOException e) {
			fail("Can't read input file");
		}
		
		assertNotNull(this.element.getSprite("PhaseOne"));
		assertNotNull(this.element.getSprite("PhaseTwo"));
		assertNotNull(this.element.getSprite("PhaseThree"));
		assertNotNull(this.element.getSprite("PhaseFour"));
	}

}
