package model.element.mobile;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;


public class RockfordTest extends MobileTest {

	@Before
	public void setUp(){
		this.element = new Rockford(null, 0, 0);
	}

	@Override
	public void testLoadImages() {
		try {
			this.element.loadImages("sprites/74336.png");
		}catch(IOException e) {
			fail("Can't read input file");
		}
		
		assertNotNull(this.element.getSprite("stepRightPhaseOne"));
		assertNotNull(this.element.getSprite("stepRightPhaseTwo"));
		assertNotNull(this.element.getSprite("stepRightPhaseThree"));
		assertNotNull(this.element.getSprite("stepLeftPhaseOne"));
		assertNotNull(this.element.getSprite("stepLeftPhaseTwo"));
		assertNotNull(this.element.getSprite("stepLeftPhaseThree"));
	}
	
}
