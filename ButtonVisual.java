import javafx.scene.control.*;

/** @author Elise Epstein
  * a class that has the buttons of the SameGame 
  **/
public class ButtonVisual extends Button {
  
  /**the row number of a button**/
  private int row;
  
  /** the column number of a button**/
  private int column;
  
  /** a boolean saying if the button is added to the LinkedList in the SameGame class **/
  private boolean addedToLinkedList; 
  
  /** the constructor of a ButtonVisual object which represents a button in the SameGame
    * @param row the row number of a ButtonVisual object
    * @param column the column number of a ButtonVisual object
    **/
  public ButtonVisual(int row, int column) {
    this.row = row;
    this.column = column;
  }
  
  /** returns the row number of the ButtonVisual object
    * @return the row number of the ButtonVisual object
    **/
  public int getRow() {
    return row;
  }
  
  /**sets the row number of the ButtonVisual object
    * @param newRow the row to be set for the ButtonVisual object
    **/
  public void setRow(int newRow) {
    row = newRow;
  }
  
  /**gets the column number of the ButtonVisual object
    * @return the column number of the ButtonVisual object
    **/
  public int getColumn() {
    return column;
  }
  
  /**sets the column number of the ButtonVisual object
    * @param newColumn the column to be set for the ButtonVisual object
    **/
  public void setColumn(int newColumn) {
    column = newColumn;
  }
  
  /** gets whether the ButtonVisual object has been added to the LinkedList in the SameGame class
    * @return a boolean that represents whether the ButtonVisual object has been added to the LinkedList in the SameGame class
    **/
  public boolean getAddedToLinkedList(){
    return addedToLinkedList;
  }
  
  /**sets whether the ButtonVisual object has been added to the LinkedList in the SameGame class
    * @param added a boolean to be set for whether the ButtonVisual object has been added to the LinkedList in the SameGame class
    **/
  public void setAddedToLinkedList(boolean added) {
    addedToLinkedList = added;
  }
  
  
  
  
  
  
  
  
  
  
  
}
