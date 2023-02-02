package ca.mohawk;


import javafx.application.Application;
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
 * @author Michael Walters 000775981
 * 
 * This is a simulation of microsoft paint, you are able to input value to would like you
 * can draw two different a circle and Dora rectangle. You can also change the 
 * color to whatever you would like by inputting RGB values. You can clear the
 * screen to draw something else. The whole function behind this is to simulate a paint.
 * 
 * 
 */
public class paint extends Application{

    // TODO: Instance Variables for View Components and Model
    // TODO: Private Event Handlers and Helper Methods
    //private //class name model;
    private Button rectDraw, clear, circleDraw;
    private TextField radius, width, hieght, colorPOne, colorPtwo, colorPThree;
    private Label info, widthLabel, hieghtLabel, radiusLabel, circleLabel, rectLabel, colorLabel;
    private GraphicsContext gc;
    private int radi, height, widtth, colorSlotOne = 255, colorSlotTwo = 255, colorSlotThree = 222, drawValue = 0;
    
    
    
    
    //this void is for when the draw circle button is clicked and will set the values of colors and radius desired
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
    
    
    //this void is for when the draw rectangle button is clicked and will set the values of colors and radius desired
   
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
    
    //when the clear button is pressed is will display a new blank white screen
    private void clear(ActionEvent e) {
        setGC();
        radius.setText("");
        width.setText("");
        hieght.setText("");
        colorPOne.setText(String.format("%d", colorSlotOne));
        colorPtwo.setText(String.format("%d", colorSlotTwo));
        colorPThree.setText(String.format("%d", colorSlotThree));
        
    } 
    
    
    //places a new screen
    private void setGC() {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 1000, 800);
        
    }
    
    
    //when the the mouse is prssed it will diplays the desird paint objact and wil
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
    
    //will display the dirsed paint object when the mouse is released
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

    //
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
     * 
     * this is the main scene of the game this will displays all of the value and get all of the
     * object needed to past on the screen to set it up
     * 
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
        info = new Label("To start drawing you must enter values first and decide what you would like to draw with first");
        widthLabel = new Label("Width:");
        hieghtLabel = new Label("Height:");
        radiusLabel = new Label("Radius:");
        circleLabel = new Label("Circle info: ");
        rectLabel = new Label("Rectangle Info: ");
        colorLabel = new Label("Color:");
        
        
        // 3. Add components to the root
        root.getChildren().addAll(canvas,rectDraw, clear, circleDraw, radius, width, hieght, colorPOne, colorPtwo, colorPThree, info, widthLabel, hieghtLabel, radiusLabel, circleLabel, rectLabel, colorLabel);
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
        
       
        //buttons
        clear.relocate(770, 600);
        rectDraw.relocate(820, 600);
        circleDraw.relocate(900, 600);
        gc = canvas.getGraphicsContext2D();
        // 5. Add Event Handlers and do final setup
        circleDraw.setOnAction(this::drawCircle);
        clear.setOnAction(this::clear);
        rectDraw.setOnAction(this::drawRect);
        
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressHandler);
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, this::releaseHandler);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::dragHandler);
        setGC();

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
