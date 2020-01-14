package sample;

import org.joml.Vector3d;
import java.util.Arrays;

public class Scene {
    private Geometry[] objects;
    private int background;
    private Light[] lights;

    public int getBackground() {
        return background;
    }

    public Scene(Geometry[] objects, Light[] lights, int background){
        this.objects=objects;
        this.lights=lights;
        this.background = background;
    }
    public Intersection intersectWorld(Ray r){
        //Find nearest intersection in scene

        Intersection nearest_intersection = new Intersection(Double.MAX_VALUE);
        for (Geometry geometry: objects) {
            //Get current intersection
            Intersection intersection_current=geometry.intersect(r);
            if (intersection_current!=null){
                if (intersection_current.getDistance()<nearest_intersection.getDistance()){
                    //Determine nearest Intersection
                    nearest_intersection=intersection_current;
                }
            }
        }
        return nearest_intersection;
    }
    public Light[] getLights() {
        return lights;
    }

    @Override
    public String toString() {
        return "Objects: "+ Arrays.toString(objects);
    }
}
