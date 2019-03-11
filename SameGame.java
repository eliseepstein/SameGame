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
import javafx.scene.control.Alert.AlertType;

/** @author Elise Epstein
  * a class that simulates the SameGame
  **/
public class SameGame extends Application {
        
  /** the number of rows in the array of ButtonVisuals **/
  private int numRows = 12;
  
  /** the number of columns in the array of ButtonVisuals **/
  private int numColumns = 12;
  
  /** the array of ButtonVisual objects **/
  private ButtonVisual[][] buttonarray;
  
  /** the number of different colors in the game **/
  private int numColors = 3;
  
  /** an array of the different options for colors for the colors of the buttons**/
  private Color[] colorarray = { Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE};
  
  /** a LinkedList that holds which buttons should be removed before they are changed to gray **/
  private LinkedList<ButtonVisual> buttonsToBeRemoved = new LinkedList<ButtonVisual>();
  
  /** a String that holds the version of the game that is being played**/
  private String version = "same";
  
  /** the value of the score of the game **/
  private int scorevalue;
  
  /** the Label that shows the score of the game**/
  private Label score;
  
  private static Alert alert; 
  /** returns the buttonarray
    * @return buttonarray the array of ButtonVisual on the screen
    **/
  public ButtonVisual[][] getButtonArray() {
    return buttonarray;
  } 
  
  /** returns the value of the score
    * @return the value of the score
    **/
  public int getScoreValue() {
    return scorevalue;
  }
  
  /** sets the score value
    * @param newScoreValue the new value of the score
    **/
  public void setScoreValue(int newScoreValue) {
    scorevalue = newScoreValue; 
  }
  
  /** returns the version of the game being played
    * @return the version of the game being played
    **/
  public String getVersion() {
    return version;
  }
  
  /** sets the version of the game being played
    * @param newversion the new version of the game
    **/
  public void setVersion(String newversion) {
    version = newversion;
  }
  
  /** returns the number of rows of the array of ButtonVisual objects
    * @return the number of rows of the array of ButtonVisual objects
    **/
  public int getNumRows() {
    return numRows;
  }
  
  /** sets the number of rows of the array of ButtonVisual objects
    * @param newNumRows the number of rows of the array of ButtonVisual objects 
    **/
  public void setNumRows(int newNumRows) {
    numRows = newNumRows;
  }
  
  /** returns the number of columns in the array of ButtonVisual objects
    * @return the number of columns in the array of ButtonVisual objects
    **/
  public int getNumColumns() {
    return numColumns;
  }
  
  /** sets the number of columns in the array of ButtonVisual objects
    * @param newNumColumns the number of columns in the array of ButtonVisual objects
    **/
  public void setNumColumns(int newNumColumns) {
    numColumns = newNumColumns;
  }
  
  /** gets the number of different colors for the buttons in the instance of SameGame
    * @return the number of different colors for the buttons in the instance of SameGame 
    **/
  public int getNumColors() {
    return numColors;
  }
  
  /** sets the number of different colors for the buttons in the instance of SameGame
    * @param newNumColors the number of different colors for the buttons in the instance of SameGame
    **/
  public void setNumColors(int newNumColors) {
    numColors = newNumColors; 
  }
  
  /** gets a random color from the color array to assign to a ButtonVisual object
    * @return a color for a ButtonVisual object
    **/
  public Color colorPicker() {
    return colorarray[(int)(Math.random() * getNumColors())];
  }
  
  /** sets the color of a ButtonVisual to grey
    * @param row the row of the button in the button array
    * @param column the column of the button in the button array
    **/
  public void setToGrey(int row, int column) {
    ((Shape)getButtonArray()[row][column].getGraphic()).setFill(Color.LIGHTGRAY);
  }
  
  /** gets the fill of the circle of a button
    * @param row the row of the button in the button array
    * @param column the column of the button in the button array
    * @return the paint of the circle of the graphic of the button
    **/
  public Paint getFillOfCircle(int row, int column) {
    return ((Shape)getButtonArray()[row][column].getGraphic()).getFill();
  }
  
  
  /** sets the fill of the circle of a button 
    * @param row the row of the button where the color of the graphic is to be changed
    * @param column the column of the button where the color of the graphic is to be changed
    * @param paint the paint the color of the circle for the circle to be changed to
    **/
  public void setFillOfCircle(int row, int column, Paint paint) {
    ((Shape)getButtonArray()[row][column].getGraphic()).setFill(paint);        
  }
  
  /** gets the LinkedList of the buttons to be removed
    * @return the LinkedList of the buttons to be removed
    **/
  public LinkedList<ButtonVisual> getButtonsToBeRemoved() {
    return buttonsToBeRemoved;
  }
  
  /** sets the LinkedList of the buttons to be removed
    * @param newLL the new LinkedList of ButtonVisuals
    **/
  public void setButtonsToBeRemoved(LinkedList<ButtonVisual> newLL) {
    buttonsToBeRemoved = newLL;
  }
  
  public static void setTextOfAlert(String text) {
    alert.setContentText(text);
  }
  
  /** handles exceptions in the command line arguments **/
  public void exceptionHandler() {
    if (this.getParameters().getRaw().size() == 0) {
    }
    else {
       setVersion(this.getParameters().getRaw().get(0));
      if (this.getParameters().getRaw().size() != 4 && this.getParameters().getRaw().size() != 0) {
       alert = new Alert(Alert.AlertType.WARNING);
       alert.setContentText("Your command line is not in the format of 'java SameGame version numberRow numberColumn numberColors'. The program will restart.");
       alert.showAndWait();
       System.exit(0);
      }
    else if (!getVersion().equals("plus") && !getVersion().equals("star") && !getVersion().equals("same")) {
     alert = new Alert(Alert.AlertType.WARNING);
     alert.setContentText("The version can be either plus, star, or same. The same version will show up by default.");
    alert.showAndWait();
    }
    try {
      if(Integer.parseInt(this.getParameters().getRaw().get(1)) < 1) {
        alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("You entered an invalid number of rows. The default number of rows will show up");
        alert.showAndWait();
      }
      else {
        setNumRows(Integer.parseInt(this.getParameters().getRaw().get(1)));
      }
    }
    catch (NumberFormatException e) {
      alert = new Alert(Alert.AlertType.WARNING);
      alert.setContentText("You entered a non-integer number of rows. The default number of rows will show up.");
      alert.showAndWait();
    }
    try {
      if(Integer.parseInt(this.getParameters().getRaw().get(2)) < 1) {
        alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("You entered an invalid number of columns. The default number of columns will show up.");
       alert.showAndWait();         
      }
      else {
        setNumColumns(Integer.parseInt(this.getParameters().getRaw().get(2)));
      }
    }
    catch (NumberFormatException e) {
      alert = new Alert(Alert.AlertType.WARNING);
      alert.setContentText("You entered a non-integer number of columns. The default number of columns will show up.");
      alert.showAndWait();
    }
    try {
      if (this.getParameters().getRaw().size() == 4 && ((Integer.parseInt(this.getParameters().getRaw().get(3)) > colorarray.length) || Integer.parseInt(this.getParameters().getRaw().get(3)) < 0)) {
        alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("You choose too many or too few colors. The default number of colors will show up.");
        alert.showAndWait();
      }
      else {
        setNumColors(Integer.parseInt(this.getParameters().getRaw().get(3)));
      }
    }
    catch (NumberFormatException e) {
      alert = new Alert(Alert.AlertType.WARNING);
      alert.setContentText("You choose a non-integer number of colors. The default number of colors will show up");
      alert.showAndWait();
    }
  }
  }
  
  /** a method that is called when the program is launched
    * @param stage a stage that the program is going to be run on
    **/
  public void start(Stage stage){  
    
 
     alert = new Alert(AlertType.ERROR);
     
    //handles exception in the command line arguments
    exceptionHandler();
    
    
    //the Label for the score that is to be displayed
    score = new Label();
    
  setScoreValue(0);
    
    //the gridpane of the application
    GridPane gridpane = new GridPane();
    
    //the borderpane of the application
    BorderPane pane = new BorderPane();
    
    //a restart button
    Button restart = new Button("Restart");
    
    //default text for the scoring
   score.setText("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" +"    Score: "+  "      " + "\n"  + "    " + getScoreValue() + "       " + "\n");
     
    //the array of buttons  
    buttonarray = new ButtonVisual[getNumRows()][getNumColumns()]; 
    
    addButtons(gridpane);
    
    //the scene for the application
    Scene scene = new Scene(pane);
    
    stage.setScene(scene);
    pane.setCenter(gridpane);
    
    //setting the restart button to restart the program
    restart.setOnAction(e -> {
      stage.close();
      start(stage);
    });                
    
    //sets the positions of the things on the screen
    pane.setTop(restart);
    pane.setLeft(score);
    stage.show();
  }
  
  /** adds buttons to a gridpane
    * @param gridpane the gridpane the buttons will be added on
    **/
  public void addButtons(GridPane gridpane) {
    /* Precondition: the current row number is less than the total number of rows
     * Subgoal: a new row is moved to 
     */
    for (int i = 0; i < getNumRows(); i++) { 
      
      /* Precondition: the current column number is less than the total number of columns
       * Subgoal: a button is initialized and has the appropriate graphics
       */
      for (int j = 0; j < getNumColumns(); j++) {
        
        //initializing each button in the button array
        getButtonArray()[i][j] = new ButtonVisual(i, j);
        
        //making a new circle for the graphic of the button
        Circle circle = new Circle(15);
        
        circle.setFill(colorPicker());
        getButtonArray()[i][j].setGraphic(circle);
        getButtonArray()[i][j].setOnAction(new ButtonEventHandler());     
        gridpane.add(getButtonArray()[i][j], j, i);
      }
    }
  }
  
  /** @author Elise Epstein
    * a class that represents the events of a button being clicked
    **/
  private class ButtonEventHandler implements EventHandler<ActionEvent> {
    
    /**deals with button clicks
      * @param e an ActionEvent of a button being clicked
      **/
    @Override
    public void handle(ActionEvent e) {
      
      //the button that was clicked
      ButtonVisual b = (ButtonVisual)e.getSource();
      
      eraseButtons(buttonsToBeRemoved(b));
      condenseAllColumns();
      shiftAllColumns();
    }
  }
  
  /** erases the buttons that are in the LinkedList of buttons to be removed
    * @param remove the LinkedList of buttons to be removed
    **/
  public void eraseButtons(LinkedList<ButtonVisual> remove) {
    
    /* Precondition: the inputted LinkedList is not empty
     * Subgoal: the color of the current button is changed to gray
     */
    for (ButtonVisual button: remove){
      setToGrey(button.getRow(), button.getColumn());
      button.setAddedToLinkedList(false);
    }
    buttonsToBeRemoved.clear();
  }
  
  /** adds buttons of the same color on the line to the linkedlist of which buttons to turn gray later. It also returns how many buttons have been added to the linkedlist
    * @param b the button that the line starts from
    * @param dx the change in the horizontial direction between buttons
    * @param dy the change in the vertical direction between buttons
    * @return the count of how many buttons have been added to the LinkedList of which buttons to be removed later
    **/
  public int line(ButtonVisual b, int dx, int dy) {
    
    //the count of how many buttons have been added to the LinkedList
    int count = 0;
    
    //initializing the horizontial change from the original button
    int i = dx; 
    
    //initializing the vertical change frm the original button
    int j = dy;
    
    /* Precondition: the rows and columns are in bounds of the array and the color of the next circle is the same as the color of the original button
     * Subgoal: a button is added to the LinkedList if the color is the same and the button has not already been added to the LinkedList
     */
    while(b.getColumn() + i < getNumColumns() && b.getColumn() + i >= 0 && b.getRow() + j < getNumRows() && b.getRow() + j >= 0 && getFillOfCircle(b.getRow(), b.getColumn()) == getFillOfCircle(b.getRow()+j, b.getColumn()+i)) {
      if (!getButtonArray()[b.getRow() + j][b.getColumn() + i].getAddedToLinkedList()) {
        buttonsToBeRemoved.add(getButtonArray()[b.getRow() + j][b.getColumn()+i]);
        getButtonArray()[b.getRow()+j][b.getColumn()+i].setAddedToLinkedList(true);
        i = i + dx;
        j = j + dy;
        count++;
      }
    }
    return count;
  }
  /** adds the adjacent buttons of the same color to a button (no diagonals), to the LinkedList of buttons to be turned to grey later
    * @param b the ButtonVisual object that the adjacent buttons of the same color to are checked
    **/
  public void adjacentButtons(ButtonVisual b) {
    
    //looking for a button down
    if(b.getRow() + 1 < getNumRows() &&  !getButtonArray()[b.getRow() + 1][b.getColumn()].getAddedToLinkedList() && getFillOfCircle(b.getRow() + 1, b.getColumn()) == getFillOfCircle(b.getRow(), b.getColumn())) { 
      getButtonsToBeRemoved().add(getButtonArray()[b.getRow() + 1][b.getColumn()]);
      getButtonArray()[b.getRow() + 1][b.getColumn()].setAddedToLinkedList(true);
    }
    
    //looking for a button up
    if(b.getRow() - 1 >= 0 && !getButtonArray()[b.getRow() - 1][b.getColumn()].getAddedToLinkedList() && getFillOfCircle(b.getRow() - 1, b.getColumn()) == getFillOfCircle(b.getRow(), b.getColumn())) {
      getButtonsToBeRemoved().add(getButtonArray()[b.getRow() - 1][b.getColumn()]);
      getButtonArray()[b.getRow() - 1][b.getColumn()].setAddedToLinkedList(true);
    }
    
    //looking for a button to the left
    if(b.getColumn() - 1 >= 0 && !getButtonArray()[b.getRow()][b.getColumn()-1].getAddedToLinkedList() && getFillOfCircle(b.getRow(), b.getColumn() - 1) == getFillOfCircle(b.getRow(), b.getColumn())) {
      getButtonsToBeRemoved().add(getButtonArray()[b.getRow()][b.getColumn()-1]);
      getButtonArray()[b.getRow()][b.getColumn()-1].setAddedToLinkedList(true);
    }
    
    //looking for a button to the right
    if(b.getColumn() + 1 < getNumColumns() && !getButtonArray()[b.getRow()][b.getColumn()+1].getAddedToLinkedList() && getFillOfCircle(b.getRow(), b.getColumn() + 1) == getFillOfCircle(b.getRow(), b.getColumn())) {
      getButtonsToBeRemoved().add(getButtonArray()[b.getRow()][b.getColumn() + 1]);
      getButtonArray()[b.getRow()][b.getColumn()+1].setAddedToLinkedList(true);
    }
  }
  
  /** returns the LinkedList of buttons to be removed and first modifies it based on different command line arguments
    * @param b the ButtonVisual object that is clicked 
    * @return the LinkedList of buttons to be removed
    **/
  public LinkedList<ButtonVisual> buttonsToBeRemoved(ButtonVisual b) {  
    
    //the number of buttons to the left that are to be removed
    int left = 0;
    
    //the number of buttons to the right that are to be removed
    int right = 0;
    
    //the number of buttons up to be removed
    int up = 0;
    
    //the number of buttons down to be removed
    int down = 0;
    
    //the number of buttons diagonally up and to the left to be removed
    int upleft = 0;
    
    //the number of buttons diagonally up and to the right to be removed
    int upright = 0;
    
    //the number of buttons diagonally down and to the left to be removed
    int downleft = 0;
    
    //the number of buttons diagonally down and to the right to be removed
    int downright = 0;
    
    //updating the above variables 
    if (getVersion().equals("star") || getVersion().equals("plus")) {
      left = line(b, -1, 0);
      right = line(b, 1, 0);
      up = line(b, 0, 1);
      down = line(b, 0, -1);
      
      if (getVersion().equals("star")) {
        upleft = line(b, -1, 1);
        upright = line(b, 1, 1);
        downleft = line(b, -1, -1);
        downright = line(b, 1, -1);
      }
    }
    
    //adding buttons to linkedlist if the version is plus
    if (getVersion().equals("plus")) {
      if(left + right + up + down > 0) {
        getButtonsToBeRemoved().add(b);
        b.setAddedToLinkedList(true);
      }
    }
    
    //adding buttons to linkedlist if the version is star
    if (getVersion().equals("star") && left + right + up + down + upleft + upright + downleft + downright > 0) {
      getButtonsToBeRemoved().add(b);
      b.setAddedToLinkedList(true);
    }
    
    //adding buttons to linkedlist if the version is same
    if (getVersion().equals("same")) {
      adjacentButtons(b);
      
      //holds the positon of the button that the loop is at 
      int i= 0;
      
      /* Precondition: the size of the LinkedList of buttons to be removed is greater than 0
       * Subgoal: for the current button, the adjacentButtons method is called in order to add buttons around it that haven't yet been added to the LinkedList
       */
      while (i < getButtonsToBeRemoved().size()) {
        ButtonVisual button = getButtonsToBeRemoved().get(i); 
        adjacentButtons(button);
        i++;
      }
    }
    
    //updating the score
    if (!getButtonsToBeRemoved().isEmpty() && getFillOfCircle(b.getRow(), b.getColumn()) != Color.LIGHTGRAY) {
      setScoreValue(getScoreValue() + (getButtonsToBeRemoved().size() - 2) * (getButtonsToBeRemoved().size() - 2));
      score.setText( "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" +"    Score: " + "      " +
                    "\n" + "    " + getScoreValue() + "\n" );
    }
    return getButtonsToBeRemoved();
  }
  
  /** condenses the column by shifting everything down if there are gray spaces
    * @param columnNumber the column number that is being shifted down
    **/
  public void condenseColumn(int columnNumber) {
    
    //the number of empty buttons that have been reached so far by going up a column
    int emptycellssofar = 0;
    
    /* Precondition: the number of rows is greater than 0
     * Subgoal: a column is condensed downwards if there are gray buttons
     */
    for (int j = getNumRows()-1; j >= 0; j--) {
      if (getFillOfCircle(j,columnNumber) == Color.LIGHTGRAY) {
        emptycellssofar++;
      }
      else if(emptycellssofar > 0) {
        setFillOfCircle(j+emptycellssofar, columnNumber, getFillOfCircle(j, columnNumber));
        setToGrey(j, columnNumber); 
      }
    }
  }
  
  /** condenses all columns by shifting everything down if there are gray spaces **/
  public void condenseAllColumns() {
    /* Precondition: the number of columns is greater than 0
     * Subgoal: the current column is condensed
     */
    for (int i = 0; i < numColumns; i++) {
      condenseColumn(i);
    }
  }
  
  
  /** shifts a column to a different column number
    * @param columnNumber the original column number
    * @param destinationColumn the column number for the column to be shifted to
    **/
  public void shiftColumn(int columnNumber, int destinationColumn) {
    /* Precondition: the number of rows is greater than 0
     * Subgoal: a button's color is shift to the destinationColumn
     */
    for (int i = 0; i < numRows; i++) {
      if (columnNumber > 0) {
        setFillOfCircle(i, destinationColumn, getFillOfCircle(i, columnNumber));
        setToGrey(i, columnNumber);
      }
    }
  }
  
  /**shifts all columns to the left if there is an empty column **/
  public void shiftAllColumns() {
    
    //the number of empty columns reached so far
    int emptyColumns = 0;
    
    /* Precondition: the number of columns is greater than 0
     * Subgoal: shifts the current column to the left by how many empty column have been reached so far
     */
    for (int i = 0; i < getNumColumns(); i++) {
      if (getFillOfCircle(numRows - 1, i) == Color.LIGHTGRAY) {
        emptyColumns++;
      }
      else if (emptyColumns > 0) {
        shiftColumn(i, i- emptyColumns);
      }
    }
  }
  
  /** runs the program
    * @param args an array of Strings from the command line
    **/
  public static void main(String[] args) {
    Application.launch(args);
    System.exit(0);
}
}