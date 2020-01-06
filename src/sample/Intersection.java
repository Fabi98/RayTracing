package sample;

import org.joml.Vector3d;

public class Intersection {
    private Object object;
    private Vector3d pos;
    private Vector3d norm;
    private double distance;
    private IntersectionType type;

    public enum IntersectionType {
        EXTERNAL,
        INTERNAL,
        NONE

    }

    public Intersection(Vector3d pos, double distance, IntersectionType type, Object object) {
        this.pos = pos;
        this.distance = distance;
        this.type = type;
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Intersection(IntersectionType type, String object) {
        this.pos = new Vector3d();
        this.norm = new Vector3d();
        this.distance = 0.0f;
        this.type = type;
        this.object = object;
    }

    public IntersectionType getType() {
        return type;
    }
    @Override
    public String toString() {
        return "Intersection with Object "+object+" in Point "+pos+", Distance "+distance+", Type:{"+type+"}";
    }

    public Vector3d getPos() {
        return pos;
    }

    public void setPos(Vector3d pos) {
        this.pos = pos;
    }

    public Vector3d getNorm() {
        return norm;
    }

    public void setNorm(Vector3d norm) {
        this.norm = norm;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
