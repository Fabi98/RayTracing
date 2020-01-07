package sample;

import org.joml.Vector3d;
import java.util.Arrays;

public class Scene {
    private Geometry[] objects;
    private Light[] lights;
    public Scene(Geometry[] objects, Light[] lights, int background){
        this.objects=objects;
    }
    public Intersection intersectWorld(Ray r){
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

    @Override
    public String toString() {
        return "Objects: "+ Arrays.toString(objects);
    }
}
