package sample;

import org.joml.Vector3d;

import java.awt.*;

public class Intersection {
    private String objectname;
    private Vector3d pos;
    private Vector3d normal;

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    private Material material;
    private double distance;
    private IntersectionType type;

    public enum IntersectionType {
        EXTERNAL,
        INTERNAL,
        NONE

    }

    public Intersection(Vector3d pos, double distance, IntersectionType type, String objectname, Material material) {
        this.pos = pos;
        this.distance = distance;
        this.type = type;
        this.objectname = objectname;
        this.material=material;
    }
    public Intersection(double distance){
        this.pos = new Vector3d();
        this.distance= distance;
        this.type = IntersectionType.NONE;
        this.objectname = "Default";
        this.material = new Material(Color.red.getRGB(),0.35,2,0.3,0.80,1/20.0,0.1);
    }

    public Object getObjectname() {
        return objectname;
    }

    public void setObjectname(String objectname) {
        this.objectname = objectname;
    }

    public Intersection(IntersectionType type, String objectname, Material material) {
        this.pos = new Vector3d();
        this.normal = new Vector3d();
        this.distance = 0.0f;
        this.type = type;
        this.objectname = objectname;
        this.material=material;
    }

    public IntersectionType getType() {
        return type;
    }
    @Override
    public String toString() {
        return "Intersection with Object "+ objectname +" in Point "+pos+", Distance "+distance+", Type:{"+type+"}";
    }

    public Vector3d getPos() {
        return pos;
    }

    public void setPos(Vector3d pos) {
        this.pos = pos;
    }

    public Vector3d getNormal() {
        return normal;
    }

    public void setNormal(Vector3d normal) {
        this.normal = normal;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
