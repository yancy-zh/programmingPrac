package algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import algorithms.RotateStringMatrix;
class rotateStringMatrixTest
{
	
	@Test
	  void testSolution() {
		RotateStringMatrix showMeBug = new RotateStringMatrix();
	    
	    assertArrayEquals(
	      showMeBug.rotate(new String[]{}),
	      new String[]{}
	    );
	    
	        assertArrayEquals(
	      showMeBug.rotate(new String[]{""}),
	      new String[]{}
	    );
	    
	       assertArrayEquals(
	      showMeBug.rotate(new String[]{"","",""}),
	      new String[]{}
	    );
	    
	       assertArrayEquals(
	      showMeBug.rotate(new String[]{"a","b","c"}),
	      new String[]{"cba"}
	    );
	    
	      assertArrayEquals(
	      showMeBug.rotate(new String[]{"abc"}),
	      new String[]{"a","b","c"}
	    );
	    
	      assertArrayEquals(
	      showMeBug.rotate(new String[]{"abc","def"}),
	      new String[]{"da","eb","fc"}
	    );
	    
	         assertArrayEquals(
	      showMeBug.rotate(new String[]{"cba"}),
	      new String[]{"c","b","a"}
	    );
	    
	         assertArrayEquals(
	      showMeBug.rotate(new String[]{
	        "###.....",
	        "..###...",
	        "....###.",
	        ".....###",
	        ".....###",
	        "....###.",
	        "..###...",
	        "###....."
	      }),
	      new String[]{
	        "#......#",
	        "#......#",
	        "##....##",
	        ".#....#.",
	        ".##..##.",
	        "..####..",
	        "..####..",
	        "...##..."
	      }
	    );
	  }
	
}
