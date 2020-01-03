package sample;

import org.joml.Vector3f;

public class Ray {
    private Vector3f origin;
    private Vector3f dir;

    //Constructor
    public Ray(Vector3f origin, Vector3f dir) {
        this.origin = origin;
        this.dir = dir.normalize();
    }

    //Getter and Setter
    public void setOrigin(Vector3f origin) {
        this.origin = origin;
    }

    public void setDir(Vector3f dir) {
        this.dir = dir;
    }

    public Vector3f getOrigin() {
        return origin;
    }

    public Vector3f getDir() {
        return dir;
    }
}
