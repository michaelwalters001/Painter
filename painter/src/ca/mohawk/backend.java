package ca.mohawk;


import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Michael Walters
 * 
 * This is the back end of the paint application.
 * This class will take care of all the behind the scene functions that are need to allow the application
 * to work properly. This class contains objects that are called on when specific actions take place on the
 * paint screen. Those Actions include: Clearing the screen, draw a circle, draw a rectangle, mouse click, mouse relaseed
 * mouse drag.
 * 
 */
public class backend extends Application{

    // TODO: Instance Variables for View Components and Model
    // TODO: Private Event Handlers and Helper Methods
    //private //class name model;
    private Button rectDraw, clear, circleDraw, oldInput;
    private TextField radius, width, hieght, colorPOne, colorPtwo, colorPThree, oldInputTxt;
    private Label info, widthLabel, hieghtLabel, radiusLabel, circleLabel, rectLabel, colorLabel;
    private GraphicsContext gc;
    private int radi = 10, height= 20, widtth = 20, colorSlotOne = 255, colorSlotTwo = 255, colorSlotThree = 222, drawValue = 0;
    ArrayList<Shape> a = new ArrayList<>();
    Shape adding;
    Shape old = new Shape(50, 50, 1, 0, 0, 0, 50);
    
    
    
    //action when the button is pressed
    private void drawCircle(ActionEvent e) {
      try {  
        radi = Integer.parseInt(radius.getText());
        colorSlotOne = Integer.parseInt(colorPOne.getText());
        colorSlotTwo = Integer.parseInt(colorPtwo.getText());
        colorSlotThree = Integer.parseInt(colorPThree.getText());
      }
    catch (NumberFormatException ex){
         new Alert(Alert.AlertType.WARNING, "Invalid Entry\n"
                 + "Radius must be Numeric").showAndWait();
     }    
        radius.setText("");
        width.setText("");
        hieght.setText("");
        colorPOne.setText(String.format("%d", colorSlotOne));
        colorPtwo.setText(String.format("%d", colorSlotTwo));
        colorPThree.setText(String.format("%d", colorSlotThree));
        drawValue = 1;
    } 
    
    
    
    private void drawRect(ActionEvent e) {
     try {
        height = Integer.parseInt(hieght.getText());
        widtth = Integer.parseInt(width.getText());
        colorSlotOne = Integer.parseInt(colorPOne.getText());
        colorSlotTwo = Integer.parseInt(colorPtwo.getText());
        colorSlotThree = Integer.parseInt(colorPThree.getText());
     }
     catch (NumberFormatException ex){
         new Alert(Alert.AlertType.WARNING, "Invalid Entry\n"
                 + "Width and Hieght must be Numeric").showAndWait();
     }
        radius.setText("");
        width.setText("");
        hieght.setText("");
        colorPOne.setText(String.format("%d", colorSlotOne));
        colorPtwo.setText(String.format("%d", colorSlotTwo));
        colorPThree.setText(String.format("%d", colorSlotThree));
        drawValue = 2;
    }

    private void clear(ActionEvent e) {
        setGC();
        radius.setText("");
        width.setText("");
        hieght.setText("");
        colorPOne.setText(String.format("%d", colorSlotOne));
        colorPtwo.setText(String.format("%d", colorSlotTwo));
        colorPThree.setText(String.format("%d", colorSlotThree));

        adding = new Shape(widtth, height, drawValue, colorSlotOne, colorSlotTwo, colorSlotThree, radi);
        a.add(adding);
        
    }

    private void inputOld(ActionEvent e) {
     try {   
      int arrayValue = Integer.parseInt(oldInputTxt.getText());
      
      widtth = old.getWidth();
      height = old.getHieght();
      radi = old.getRadius();
      colorSlotOne = old.getColorOne();
      colorSlotTwo = old.getColorTwo();
      colorSlotThree = old.getColorThree();
      drawValue = old.getDrawValue();
     } catch (NumberFormatException ex){
         new Alert(Alert.AlertType.WARNING, "Invalid Entry").showAndWait();
     }
              
              
        radius.setText("");
        width.setText("");
        hieght.setText("");
        colorPOne.setText(String.format("%d", colorSlotOne));
        colorPtwo.setText(String.format("%d", colorSlotTwo));
        colorPThree.setText(String.format("%d", colorSlotThree));
        
        
    } 
    
    // cleans the board
    private void setGC() {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 1000, 800);
        
    }

    // When the application screen is clicked it will put what shaped was selected and draw it one screen
    private void pressHandler(MouseEvent me) {
        gc.setFill(Color.rgb(colorSlotOne, colorSlotTwo, colorSlotThree));       
        if (me.getButton().equals(MouseButton.PRIMARY)) {
            if (drawValue == 1) {
                gc.fillOval(me.getX(), me.getY(), radi, radi);
            } else if (drawValue == 2) {
                gc.fillRect(me.getX(), me.getY(), widtth, height);
            }
        } else {
            if (drawValue == 1) {
                gc.fillOval(me.getX(), me.getY(), radi, radi);
            } else if (drawValue == 2) {
                gc.fillRect(me.getX(), me.getY(), widtth, height);
            }  else {
                new Alert(Alert.AlertType.WARNING, "Please select what you want to draw with").showAndWait();
            }
        }
    }

    // When the user releases the mouse click it will stop the drawing of the shape.
    private void releaseHandler(MouseEvent me) {
        gc.setFill(Color.rgb(colorSlotOne, colorSlotTwo, colorSlotThree));
        if (drawValue == 1) {       
                gc.fillOval(me.getX(), me.getY(), radi, radi);
            } else if (drawValue == 2) {
                gc.fillRect(me.getX(), me.getY(), widtth, height);
            }  else {
                new Alert(Alert.AlertType.WARNING, "Please select what you want to draw with").showAndWait();
            }
    }

    // When the mouse click is held down it will draw on the screen the shape that you selected to simulate drawing
    private void dragHandler(MouseEvent me) {
        gc.setFill(Color.rgb(colorSlotOne, colorSlotTwo, colorSlotThree));
        if (drawValue == 1) {            
                gc.fillOval(me.getX(), me.getY(), radi, radi);
            } else if (drawValue == 2) {
                gc.fillRect(me.getX(), me.getY(), widtth, height);
            } else {
                new Alert(Alert.AlertType.WARNING, "Please select what you want to draw with").showAndWait();
            }
    }
    
    
    
    

    /**
     * This is where you create your components sand the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        
        Pane root = new Pane();
        Scene scene = new Scene(root, 1000, 650); // set the size here
        stage.setTitle("Math Game"); // set the window title here
        stage.setScene(scene);
        
        // TODO: Add your GUI-building code here
        
        

        // 1. Create the model       
        // 2. Create the GUI components
        Canvas canvas = new Canvas(1000, 550);
        
        rectDraw = new Button("Rect Draw");
        clear = new Button("Clear");
        circleDraw = new Button("Circle Draw");
        radius = new TextField();
        width = new TextField("");
        hieght = new TextField("");
        colorPOne = new TextField(String.format("%d", colorSlotOne));
        colorPtwo = new TextField(String.format("%d", colorSlotTwo));
        colorPThree = new TextField(String.format("%d", colorSlotThree));
        oldInputTxt = new TextField();
        info = new Label("Click and drag on the canvas to draw or Press on the canvas");
        widthLabel = new Label("Width:");
        hieghtLabel = new Label("Height:");
        radiusLabel = new Label("Radius:");
        circleLabel = new Label("Circle info: ");
        rectLabel = new Label("Rectangle Info: ");
        colorLabel = new Label("Color:");
        
        oldInput = new Button("Old Input");
        oldInputTxt = new TextField();
        
        // 3. Add components to the root
        root.getChildren().addAll(canvas, oldInput, oldInputTxt, rectDraw, clear, circleDraw, radius, width, hieght, colorPOne, colorPtwo, colorPThree, info, widthLabel, hieghtLabel, radiusLabel, circleLabel, rectLabel, colorLabel);
        // 4. Configure the components (colors, fonts, size, location)
        canvas.relocate(0, 50);
        info.relocate(0, 10);
        info.setFont(new Font("Arial", 24));
        //rectangle
        widthLabel.relocate(125, 600);
        widthLabel.setFont(new Font("Arial", 16));
        width.relocate(175, 600);
        width.setPrefWidth(50);
        hieghtLabel.relocate(225, 600);
        hieghtLabel.setFont(new Font("Arial", 16));
        hieght.relocate(275, 600);
        hieght.setPrefWidth(50);
        rectLabel.relocate(0, 600);
        rectLabel.setFont(new Font("Arial", 18));
        
        //circle
        radiusLabel.relocate(410, 600);
        radiusLabel.setFont(new Font("Arial", 14));
        radius.relocate(460, 600);
        radius.setPrefWidth(40);
        circleLabel.relocate(330, 600);
        circleLabel.setFont(new Font("Arial", 16));
        
        //color
        colorLabel.relocate(520, 600);
        colorLabel.setFont(new Font("Arial", 18));
        colorPOne.relocate(570, 600);
        colorPOne.setPrefWidth(50);
        colorPtwo.relocate(620, 600);
        colorPtwo.setPrefWidth(50);
        colorPThree.relocate(670, 600);
        colorPThree.setPrefWidth(50);
        
        //old inputs
        oldInputTxt.relocate(0 , 0);
        oldInput.relocate(0,100);

        //buttons
        clear.relocate(770, 600);
        rectDraw.relocate(820, 600);
        circleDraw.relocate(900, 600);
        gc = canvas.getGraphicsContext2D();
        // 5. Add Event Handlers and do final setup
        circleDraw.setOnAction(this::drawCircle);
        clear.setOnAction(this::clear);
        rectDraw.setOnAction(this::drawRect);
        oldInput.setOnAction(this::inputOld);
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressHandler);
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, this::releaseHandler);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::dragHandler);
        setGC();
        adding = new Shape(widtth, height, drawValue, colorSlotOne, colorSlotTwo, colorSlotThree, radi);
        a.add(adding);

        // 6. Show the stage
        stage.show();
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
