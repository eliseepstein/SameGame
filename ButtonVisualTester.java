import junit.framework.TestCase;
import javafx.scene.control.*;
import javafx.embed.swing.JFXPanel;
import org.junit.*;
/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class ButtonVisualTester extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
 
  
    
  public void testGetRow() {
    JFXPanel environment = new JFXPanel();
    ButtonVisual b = new ButtonVisual(3,4);
    assertEquals(3, b.getRow());
  }
  
  
  public void testSetRow() {
 JFXPanel environment = new JFXPanel();
    ButtonVisual b = new ButtonVisual(3,4);
   b.setRow(6);
   assertEquals(b.getRow(), 6);
  }
  
  public void testGetColumn() {
    JFXPanel environment = new JFXPanel();
        ButtonVisual b = new ButtonVisual(3,4);
    assertEquals(b.getColumn(), 4);
  }
  
  public void testSetColumn() {
   JFXPanel environment = new JFXPanel();
      ButtonVisual b = new ButtonVisual(3,4);
    b.setColumn(7);
    assertEquals(b.getColumn(), 7);
  }
  
  public void testGetAddedToLinkedList() {
   JFXPanel environment = new JFXPanel();
        ButtonVisual b = new ButtonVisual(3,4);
   assertEquals(b.getAddedToLinkedList(), false);
  }
  
  public void testSetAddedToLinkedList() {
   JFXPanel environment = new JFXPanel();
        ButtonVisual b = new ButtonVisual(3,4);
    b.setAddedToLinkedList(true);
    assertEquals(b.getAddedToLinkedList(), true);
  } 
}