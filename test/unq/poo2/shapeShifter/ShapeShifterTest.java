package unq.poo2.shapeShifter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShapeShifterTest {

	IShapeShifter a;
	IShapeShifter b;
	IShapeShifter c;
	IShapeShifter d;
	IShapeShifter e;
	IShapeShifter f;
	
	
	@BeforeEach
	void setup() {
		a = new ShapeShifterLeaf(1);
		b = new ShapeShifterLeaf(2); 
		
		c = new ShapeShifter();
		
		d = new ShapeShifterLeaf(3);
		e = new ShapeShifterLeaf(4);
		
		f = new ShapeShifter();
	}
	
	
	@Test
	void testEjemploEjercicio() {
		
		//exercise
		c = a.compose(b);
		d = d.compose(c);
		f = d.compose(e);
		
		//verify
		assertEquals(Arrays.asList(1,2), c.values());
		assertEquals(Arrays.asList(3,1,2), d.values());
		assertEquals(Arrays.asList(3,1,2,4), f.values());
		
		assertEquals(0, a.deepest());
		assertEquals(1, c.deepest());
		assertEquals(3, f.deepest());
		
		assertEquals(a, a.flat());
		
	}

}
