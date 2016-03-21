package Game;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Game extends Application{
    GameState gameState;

    protected void loadContent(){
        Image background = new Image("background.png");
        Image mine_cart = new Image("mine_cart.png");
        Image product_box = new Image("product_box.png");
        Image volvo = new Image("volvo.png");
        Image mine = new Image("mine.png");
        Image ikea = new Image("ikea.png");
        Image ore_container = new Image("ore_container.png");
        Image product_container = new Image("product_container.png");

        gameState = new GameState(background, mine_cart, product_box, volvo, mine, ikea, ore_container, product_container);
    }

    public void start(Stage stage){
        stage.setTitle("INFDEV02-3 - Assignment 1");

        Group root = new Group();
        Scene theScene = new Scene( root );
        stage.setScene( theScene );

        final Canvas canvas = new Canvas( 800, 800 );
        root.getChildren().add( canvas );

        final GraphicsContext gc = canvas.getGraphicsContext2D();

        loadContent();
        stage.show();

        //this acts as the main loop
        new AnimationTimer(){
            public void handle(long currentNanoTime){
                //clear the canvas before painting over it
                gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
                gameState.draw(gc);
                gameState.update(0.3f);
            }
        }.start();
    }

    public static void main(String[] args) {
        launch();
    }
}
