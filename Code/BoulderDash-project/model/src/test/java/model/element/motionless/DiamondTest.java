package model.element.motionless;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DiamondTest extends MotionlessTest {

	@Before
	public void setUp(){
		this.element = new Diamond();
	}
	
	@Override
	public void testLoadImages() {
		try {
			this.element.loadImages("sprites/74359.png");
		} catch(IOException e) {
			fail("Can't read input file");
		}
		
		assertNotNull(this.element.getSpriteByKey("normal"));
	}

}
