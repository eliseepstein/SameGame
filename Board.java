import javafx.application.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.paint.*;

public class Board {
 
  private int rows;
  private int columns;
  private int numColors;
  private Scene scene;
 private Button[][] buttonarray;
 private GridPane gridpane; 
 private Color[] colorarray; 
 private Stage stage;
 private Board board; 
  
   public void makeBoard(Stage stage) {
     
  colorarray[0] = Color.BLACK;
  colorarray[1] = Color.BLUE;
  colorarray[2] = Color.CYAN;
  colorarray[3] = Color.GREEN;
  colorarray[4] = Color.YELLOW;
  colorarray[5] = Color.MAGENTA;
  colorarray[6] = Color.ORANGE;
  colorarray[7] = Color.PINK;
  colorarray[8] = Color.RED;
  colorarray[9] = Color.WHITE;
   }
   
   public Board getBoard() {
     return board;
   }
   
   public int getRows() {
     return rows;
   }
   
   public void setRows(int newrows) {
    rows = newrows;
}

public int getColumns() {
  return columns;
}

public void setColumns(int newcolumns) {
  columns = newcolumns; 
}

 public void addButtons(GridPane gridpane) {
     
  for (int i = 0; i < buttonarray[1].length; i++) {
    
    for (int j = 0; j < buttonarray.length; j++) {
      
      gridpane.add(buttonarray[i][j], i, j);
      
    }
  }
  stage.show();
  }
 
}
 
