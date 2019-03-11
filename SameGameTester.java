
import junit.framework.TestCase;
import org.junit.*;
import javafx.application.Application;
import javafx.stage.Stage;
import java.lang.reflect.*;
import static org.junit.Assert.*;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.event.*;
import javax.swing.JOptionPane;
import java.util.*;
import javafx.embed.swing.JFXPanel;
/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */

public class SameGameTester extends TestCase {
  JFXPanel environment = new JFXPanel();
  SameGame samegame = new SameGame();
  
  public void testGettersAndSetters() {
    assertEquals(samegame.getButtonArray(), null);
    
    //getting and setting score value
    assertEquals(samegame.getScoreValue(), 0);
    samegame.setScoreValue(20);
   assertEquals(samegame.getScoreValue(), 20);
   
   //getting and setting version
   assertEquals(samegame.getVersion(), "same"); 
    samegame.setVersion("star");
    assertEquals(samegame.getVersion(), "star");
    
    //setting and getting the number of rows
    assertEquals(samegame.getNumRows(), 12);
    samegame.setNumRows(25);
    assertEquals(samegame.getNumRows(), 25);
    
    //setting and getting the number of columns
    assertEquals(samegame.getNumColumns(), 12);
   samegame.setNumColumns(15);
   assertEquals(samegame.getNumColumns(), 15);
   
   //setting and getting the number of colors
    assertEquals(samegame.getNumColors(), 3);
    samegame.setNumColors(13);
    assertEquals(samegame.getNumColors(), 13);
    
    //setting and getting the getButtonsToBeRemoved method
    ButtonVisual b = new ButtonVisual(1, 1);
    LinkedList<ButtonVisual> ll = new LinkedList<ButtonVisual>();
    ll.add(b);
    samegame.setButtonsToBeRemoved(ll);
    assertEquals(samegame.getButtonsToBeRemoved().get(0), b);
    
    //setFillOfCircle and getFillOfCircle
    Thread thread = new Thread() {
      public void run() {
    ButtonVisual[][] buttonarray = new ButtonVisual[1][1];
   buttonarray[0][0] = new ButtonVisual(0, 0);
   Circle circle = new Circle(15);
   circle.setFill(Color.BLUE);
   buttonarray[0][0].setGraphic(circle);
   assertEquals(samegame.getFillOfCircle(0, 0), Color.BLUE);                           
      
      //settingToGrey method
     samegame.setToGrey(0, 0);
     assertEquals(samegame.getFillOfCircle(0, 0), Color.LIGHTGRAY);
      }
    };
  }
  
  public void testEraseButtons() {
  
    Thread thread = new Thread() {
      public void run() {
  SameGame samegame = new SameGame();
 
  ButtonVisual[][] buttonarray = new ButtonVisual[2][2];
  buttonarray[0][0] = new ButtonVisual(0, 0);
   Circle circle = new Circle(15);
   buttonarray[0][0].setGraphic(circle);
  samegame.setFillOfCircle(buttonarray[0][0].getRow(), buttonarray[0][0].getColumn(), Color.BLUE);
  samegame.eraseButtons(samegame.getButtonsToBeRemoved());
  LinkedList<ButtonVisual> ll = new LinkedList<ButtonVisual>();             
 //Test 0
   assertEquals(samegame.getFillOfCircle(buttonarray[0][0].getRow(), buttonarray[0][0].getColumn()), Color.BLUE);
               
  ll.add(buttonarray[0][0]);
  samegame.eraseButtons(samegame.getButtonsToBeRemoved());
               
  //Test 1
  assertEquals(samegame.getFillOfCircle(0, 0), Color.LIGHTGRAY);
  
  //reversing what I did in erasing the buttons 
  ll.clear();
  buttonarray[0][0].setAddedToLinkedList(false);
  buttonarray[0][0].setGraphic(circle);
     
  ll.add(buttonarray[0][0]);
  ll.add(buttonarray[0][1]);
  buttonarray[0][0].setAddedToLinkedList(true);
  buttonarray[0][1].setAddedToLinkedList(true);
  
  //Test 2
  assertEquals(samegame.getFillOfCircle(0, 0), Color.LIGHTGRAY);
  }
    };
  }
      

public void testLine() {
  Thread thread = new Thread() {
    public void run() {
  ButtonVisual[][] buttonarray = new ButtonVisual[3][3];
  Circle circle = new Circle();
  circle.setFill(Color.BLUE);
  Circle circle2 = new Circle();
  circle2.setFill(Color.GREEN);
  
  buttonarray[0][0] = new ButtonVisual(0,0);
  buttonarray[0][1] = new ButtonVisual(0, 1);
  buttonarray[0][2] = new ButtonVisual(0, 2);
  buttonarray[1][0] = new ButtonVisual(1, 0);
  buttonarray[1][1] = new ButtonVisual(1, 1);
  buttonarray[1][2] = new ButtonVisual(1, 2);
  buttonarray[2][0] = new ButtonVisual(2, 0);
  buttonarray[2][1] = new ButtonVisual(2, 1);
  buttonarray[2][2] = new ButtonVisual(2,2);
  
  buttonarray[0][0].setGraphic(circle);
  buttonarray[0][1].setGraphic(circle);
  buttonarray[0][2].setGraphic(circle);
  buttonarray[1][0].setGraphic(circle2);
  buttonarray[1][1].setGraphic(circle2);
  buttonarray[1][2].setGraphic(circle2);
  buttonarray[2][0].setGraphic(circle2);
  buttonarray[2][1].setGraphic(circle2);
  buttonarray[2][2].setGraphic(circle2);
  
  //Test 0
  assertEquals(samegame.line(buttonarray[2][2], 0, 1), 0);
  //Test 1
  assertEquals(samegame.line(buttonarray[2][1], 1, 0), 1);
  //Test many
  assertEquals(samegame.line(buttonarray[2][0], 1, 0), 2);
}
  };
}

public void testAdjacentButtons() {
  Thread thread = new Thread() {
    public void run() {
    ButtonVisual[][] buttonarray = new ButtonVisual[3][3];
  Circle circle = new Circle();
  circle.setFill(Color.BLUE);
  Circle circle2 = new Circle();
  circle2.setFill(Color.GREEN);
  
  buttonarray[0][0] = new ButtonVisual(0,0);
  buttonarray[0][1] = new ButtonVisual(0, 1);
  buttonarray[0][2] = new ButtonVisual(0, 2);
  buttonarray[1][0] = new ButtonVisual(1, 0);
  buttonarray[1][1] = new ButtonVisual(1, 1);
  buttonarray[1][2] = new ButtonVisual(1, 2);
  buttonarray[2][0] = new ButtonVisual(2, 0);
  buttonarray[2][1] = new ButtonVisual(2, 1);
  buttonarray[2][2] = new ButtonVisual(2,2);
  
  buttonarray[0][0].setGraphic(circle2);
  buttonarray[0][1].setGraphic(circle);
  buttonarray[0][2].setGraphic(circle);
  buttonarray[1][0].setGraphic(circle2);
  buttonarray[1][1].setGraphic(circle2);
  buttonarray[1][2].setGraphic(circle2);
  buttonarray[2][0].setGraphic(circle2);
  buttonarray[2][1].setGraphic(circle2);
  buttonarray[2][2].setGraphic(circle2);
  
  //Test 0
  samegame.adjacentButtons(buttonarray[0][0]);
  assertEquals(samegame.getButtonsToBeRemoved().size(), 0);
  
  //Test 1
  samegame.adjacentButtons(buttonarray[0][1]);
  assertEquals(samegame.getButtonsToBeRemoved().size(), 1);
  
  samegame.getButtonsToBeRemoved().clear();
  
  //Test many 
  samegame.adjacentButtons(buttonarray[2][1]);
  assertEquals(samegame.getButtonsToBeRemoved().size(), 3);
}
  };
}

public void testCondenseColumn() {
  Thread thread = new Thread() {
    public void run() {
   ButtonVisual[][] buttonarray = new ButtonVisual[3][3];
  Circle circle = new Circle();
  circle.setFill(Color.LIGHTGRAY);
  Circle circle2 = new Circle();
  circle2.setFill(Color.GREEN);
  
  buttonarray[0][0] = new ButtonVisual(0,0);
  buttonarray[0][1] = new ButtonVisual(0, 1);
  buttonarray[0][2] = new ButtonVisual(0, 2);
  buttonarray[1][0] = new ButtonVisual(1, 0);
  buttonarray[1][1] = new ButtonVisual(1, 1);
  buttonarray[1][2] = new ButtonVisual(1, 2);
  buttonarray[2][0] = new ButtonVisual(2, 0);
  buttonarray[2][1] = new ButtonVisual(2, 1);
  buttonarray[2][2] = new ButtonVisual(2,2);
  
  buttonarray[0][0].setGraphic(circle2);
  buttonarray[0][1].setGraphic(circle2);
  buttonarray[0][2].setGraphic(circle);
  buttonarray[1][0].setGraphic(circle2);
  buttonarray[1][1].setGraphic(circle);
  buttonarray[1][2].setGraphic(circle);
  buttonarray[2][0].setGraphic(circle2);
  buttonarray[2][1].setGraphic(circle2);
  buttonarray[2][2].setGraphic(circle2);
  
 //Test 0
  samegame.condenseColumn(0);
  assertEquals(samegame.getFillOfCircle(2, 0), Color.GREEN);
  
  //Test 1
  samegame.condenseColumn(1);
  assertEquals(samegame.getFillOfCircle(1, 1), Color.GREEN);
  
  //Test Many
  samegame.condenseColumn(2);
  assertEquals(samegame.getFillOfCircle(1, 2), Color.GREEN);
}
  };
}

public void testShiftColumn() {
  
  Thread thread = new Thread() {
    public void run() {
  ButtonVisual[][] buttonarray = new ButtonVisual[3][3];
  Circle circle = new Circle();
  circle.setFill(Color.BLUE);
  Circle circle2 = new Circle();
  circle2.setFill(Color.GREEN);
  
  buttonarray[0][0] = new ButtonVisual(0,0);
  buttonarray[0][1] = new ButtonVisual(0, 1);
  buttonarray[0][2] = new ButtonVisual(0, 2);
  buttonarray[1][0] = new ButtonVisual(1, 0);
  buttonarray[1][1] = new ButtonVisual(1, 1);
  buttonarray[1][2] = new ButtonVisual(1, 2);
  buttonarray[2][0] = new ButtonVisual(2, 0);
  buttonarray[2][1] = new ButtonVisual(2, 1);
  buttonarray[2][2] = new ButtonVisual(2,2);
  
  buttonarray[0][0].setGraphic(circle2);
  buttonarray[0][1].setGraphic(circle2);
  buttonarray[0][2].setGraphic(circle);
  buttonarray[1][0].setGraphic(circle2);
  buttonarray[1][1].setGraphic(circle);
  buttonarray[1][2].setGraphic(circle);
  buttonarray[2][0].setGraphic(circle2);
  buttonarray[2][1].setGraphic(circle);
  buttonarray[2][2].setGraphic(circle2);
  
  //Test 0
  samegame.shiftColumn(2, 2);
  assertEquals(samegame.getFillOfCircle(2, 2), Color.GREEN);
  
  //Test 1
  samegame.shiftColumn(2, 1);
  assertEquals(samegame.getFillOfCircle(2, 1), Color.GREEN);
  
  //Test Many
  samegame.shiftColumn(2, 0);
  assertEquals(samegame.getFillOfCircle(0, 1), Color.LIGHTGRAY);
 
}
};
}

}
  
  
