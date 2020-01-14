package sample;

import org.joml.Vector3d;

public class Ray {
    private Vector3d origin;
    private Vector3d dir;
    private byte[] imageData;

    //Constructor
    public Ray(Vector3d origin, Vector3d dir) {
        this.origin = origin;
        this.dir =dir.normalize();
    }

    //Getter and Setter
    public void setOrigin(Vector3d origin) {
        this.origin = origin;
    }

    public void setDir(Vector3d dir) {
        this.dir = dir;
    }

    public Vector3d getOrigin() {
        return origin;
    }

    public Vector3d getDir() {
        return dir;
    }

    public Vector3d position(double scale) {
        //Return position with scalar

        Vector3d pos= new Vector3d();
        Vector3d scalar_v = new Vector3d();
        scalar_v = dir.mul(scale,scalar_v);
        pos=origin.add(scalar_v,pos);
        return pos;
    }
}
