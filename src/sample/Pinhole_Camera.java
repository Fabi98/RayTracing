package sample;

import org.joml.Vector3d;

public class Pinhole_Camera {
    Vector3d pos;
    Vector3d dir;
    double fov = Math.tan(Math.PI/4);


    public Pinhole_Camera(Vector3d pos, Vector3d dir){
        this.pos =pos;
        this.dir=dir;
    }
    public Vector3d getRayDir(double width, double height, int x, int y){
        //Canvas to Space conversion:
        double Sx=2*x/width-1;
        double Sy=2*y/height-1;
        double aspect_ratio = width/height;     //bsp 1:1
        return new Vector3d(Sx*aspect_ratio,Sy,fov).normalize();
    }
}
