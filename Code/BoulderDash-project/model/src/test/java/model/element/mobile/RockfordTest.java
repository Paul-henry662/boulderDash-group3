package model.element.mobile;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;


public class RockfordTest extends MobileTest {

	@Before
	public void setUp(){
		this.element = new Rockford();
	}

	@Override
	public void testLoadImages() {
		try {
			this.element.loadImages("sprites/74336.png");
		}catch(IOException e) {
			fail("Can't read input file");
		}
		
		assertNotNull(this.element.getSpriteByKey("stepRightPhaseOne"));
		assertNotNull(this.element.getSpriteByKey("stepRightPhaseTwo"));
		assertNotNull(this.element.getSpriteByKey("stepRightPhaseThree"));
		assertNotNull(this.element.getSpriteByKey("stepLeftPhaseOne"));
		assertNotNull(this.element.getSpriteByKey("stepLeftPhaseTwo"));
		assertNotNull(this.element.getSpriteByKey("stepLeftPhaseThree"));
	}
	
}
