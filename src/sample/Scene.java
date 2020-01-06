package sample;

import org.joml.Vector3d;

import java.awt.*;
import java.util.Arrays;

public class Scene {
    private Geometry[] objects;
    public Scene(Geometry[] objects, Color background){
        this.objects=objects;
    }
    public Intersection intersectWorld(Ray r){
        Intersection nearest_intersection = new Intersection(new Vector3d(),Double.MAX_VALUE, Intersection.IntersectionType.NONE,this.getClass().getName());
        for (Geometry geometry: objects) {

            Intersection intersection_current=geometry.intersect(r);
            if (intersection_current!=null){
                if (intersection_current.getDistance()<nearest_intersection.getDistance()){
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
