package model.element.mobile;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Before;

public class SkullTest extends MobileTest {

	@Before
	public void setUp() throws Exception {
		this.element = new Skull();
	}
	
	@Override
	public void testLoadImages() {
		try {
			this.element.loadImages("sprites/74359.png");
		}catch(IOException e) {
			fail("Can't read input file");
		}
		
		assertNotNull(this.element.getSpriteByKey("PhaseOne"));
		assertNotNull(this.element.getSpriteByKey("PhaseTwo"));
		assertNotNull(this.element.getSpriteByKey("PhaseThree"));
		assertNotNull(this.element.getSpriteByKey("PhaseFour"));
	}

}
