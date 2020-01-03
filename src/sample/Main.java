package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Main extends Application {
    // Main EPSILON value, used for floating point value comparison
    public static final float  EPSILON = 1e-3f;

    @Override
    public void start(Stage stage) {
        float radius = 1.0f;
        Vector3f center = new Vector3f(0.0f,0.0f,0.0f);
        Ray ray = new Ray(new Vector3f(0.0f,0.0f,-5.0f),new Vector3f(0.0f,0.0f,1.0f));
        Sphere sphere = new Sphere(center,radius);
        Intersection.IntersectionType type = sphere.intersect(ray).getType();
        System.out.println(type);




        //Drawing a Circle
        Circle circle = new Circle();
        //Setting the properties of the circle
        circle.setCenterX(300.0f);
        circle.setCenterY(135.0f);
        circle.setRadius(radius);

        //Creating a Group object
        Group root = new Group(circle);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 300);
        //Setting title to the Stage
        stage.setTitle("Drawing a Circle");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}
