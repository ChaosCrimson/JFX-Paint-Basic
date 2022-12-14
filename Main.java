
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class Main extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    final int[] brushSizeXY = new int[1];
    brushSizeXY[0] = 20;
    BorderPane borderPane = new BorderPane();
    Canvas canvas = new Canvas();
    canvas.setHeight(375);
    canvas.setWidth(700);
    ToolBar toolBar = new ToolBar();
    primaryStage.setTitle("New Drawing: ");
    borderPane.setCenter(canvas);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    gc.setFill(Color.WHITE);
    gc.fillRect(0, 0, 700, 375);
    gc.setFill(Color.BLACK);
    
    Button btnBlack = new Button("Black");
    btnBlack.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          gc.setFill(Color.BLACK);
          System.out.println("Black Color");
        }
    });
    Button btnRed = new Button("Red");
    btnRed.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          gc.setFill(Color.RED);
          System.out.println("Red Color");
        }
    });
    Button btnBlue = new Button("Blue");
    btnBlue.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          gc.setFill(Color.BLUE);
          System.out.println("Blue Color");
        }
    });
    Button btnGreen = new Button("Green");
    btnGreen.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          gc.setFill(Color.GREEN);
          System.out.println("Green Color");
        }
    });
    Button btnOrange = new Button("Orange");
    btnOrange.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          gc.setFill(Color.ORANGE);
          System.out.println("Orange Color");
        }
    });
    Button btnYellow = new Button("Yellow");
    btnYellow.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          gc.setFill(Color.YELLOW);
          System.out.println("Yellow Color");
        }
    });
    Button btnPurple = new Button("Purple");
    btnPurple.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          gc.setFill(Color.PURPLE);
          System.out.println("Purple Color");
        }
    });
    Button btnWhite = new Button("White");
    btnWhite.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          gc.setFill(Color.WHITE);
          System.out.println("White Color");
        }
    });
    Button btnSizeUp = new Button("+Brush");
    btnSizeUp.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        brushSizeXY[0] = brushSizeXY[0] + 5;
        System.out.println("Brush Size set to " + brushSizeXY[0]);
      }
    });
    Button btnSizeDown = new Button("-Brush");
    btnSizeDown.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          if(brushSizeXY[0] <= 5) {
            brushSizeXY[0] = 5;
            System.out.println("Nothing happened");
          }
          else {
            brushSizeXY[0] -= 5;
            System.out.println("Brush Size set to " + brushSizeXY[0]);
          }
        }
    });
  Button btnClear = new Button("Clear");
    btnClear.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          gc.setFill(Color.WHITE);
          gc.fillRect(0, 0, 700, 375);
          gc.setFill(Color.BLACK);
          System.out.println("Canvas Reset");
        }
    });
    
    toolBar.getItems().add(btnBlack);
    toolBar.getItems().add(btnRed);
    toolBar.getItems().add(btnBlue);
    toolBar.getItems().add(btnGreen);
    toolBar.getItems().add(btnOrange);
    toolBar.getItems().add(btnYellow);
    toolBar.getItems().add(btnPurple);
    toolBar.getItems().add(btnWhite);
    toolBar.getItems().add(btnSizeUp);
    toolBar.getItems().add(btnSizeDown);
    toolBar.getItems().add(btnClear);
    
    canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, 
      new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
          gc.fillOval(e.getX() - brushSizeXY[0] / 2, e.getY() - brushSizeXY[0] / 2, brushSizeXY[0], brushSizeXY[0]);
        }
      });
    canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, 
      new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
          gc.fillOval(e.getX() - brushSizeXY[0] / 2, e.getY() - brushSizeXY[0] / 2, brushSizeXY[0], brushSizeXY[0]);
        }
      });
    
    borderPane.setTop(toolBar);
    primaryStage.setScene(new Scene(borderPane, 700, 375));
    primaryStage.show();
  }
}
