package sample;

import org.joml.Vector3f;

public class Intersection {
    private Vector3f pos;
    private Vector3f norm;
    private float t;

    private IntersectionType type;
    public enum IntersectionType {
        NONE,
        INTERNAL,
        EXTERNAL
    }

    public Intersection(Vector3f pos, float t,IntersectionType type) {
        this.pos = pos;
        this.t = t;
        this.type = type;
    }

    public Intersection(IntersectionType type) {
        this.pos = new Vector3f();
        this.norm = new Vector3f();
        this.t = 0.0f;
        this.type = type;
    }

    public IntersectionType getType() {
        return type;
    }

    public Vector3f getPos() {
        return pos;
    }

    public void setPos(Vector3f pos) {
        this.pos = pos;
    }

    public Vector3f getNorm() {
        return norm;
    }

    public void setNorm(Vector3f norm) {
        this.norm = norm;
    }

    public float getT() {
        return t;
    }

    public void setT(float t) {
        this.t = t;
    }
}
