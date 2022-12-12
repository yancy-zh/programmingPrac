package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import algorithms.ValidParathesis;
class ValidParenthesesTest {
  @Test
  public void validParenthesesTest() {
    assertEquals(true, ValidParathesis.validParentheses( "()" ));
  }

  @Test
  public void onlyCharsTest() {
    assertEquals(true, ValidParathesis.validParentheses( "adasdasfa" ));
  }

  @Test
  public void invalidParenthesesTest() {
    assertEquals(false, ValidParathesis.validParentheses( "())" ));
  }

  @Test
  public void invalidParenthesesTest1() {
    assertEquals(false, ValidParathesis.validParentheses( ")(" ));
  }
  
  @Test
  public void validParenthesesWithCharsTest() {
    assertEquals(true, ValidParathesis.validParentheses( "32423(sgsdg)" ));
  }

  @Test
  public void invalidParenthesesWithCharsTest() {
    assertEquals(false, ValidParathesis.validParentheses( "(dsgdsg))2432" ));
  }
}