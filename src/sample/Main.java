package sample;

import org.joml.Vector3d;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        double radius = 15.0d;


        Vector3d center = new Vector3d(0.0d,0.0d,0.0d);
        Sphere sphere = new Sphere(center,radius);
        //Ray r = new Ray(new Vector3d(0.0f,0.0f,-5f),new Vector3d(0.0f,0.0f,1.0f));
        //Camera camera = new Camera(new Vector3d(0.0,0.0,-500),new Vector3d(0.0d,0.0d,1.0d),new Vector3d(1.0d,0.0d,0.0d),Math.PI / 4);
        //Camera2 camera2 = new Camera2(new Vector3d(0.0d,0.0d,-5.0d),new Vector3d(0.0d,0.0d,1.0d),new Vector3d(1.0d,0.0d,0.0d),Math.PI/2);
        //Intersection intersection = sphere.intersect(ray);
        int width=512;
        int height=512;
        double distance= 50.0d;
        int[]pixels=new int[width*height];
        Scene scene = new Scene(new Geometry[]{sphere}, Color.BLACK);
        Pinhole_Camera pinhole_camera= new Pinhole_Camera(new Vector3d(0.0d,0.0d,-distance),new Vector3d(new Vector3d(0.0d,0.0d,1.0d)));
        Ray r = new Ray(new Vector3d(0.0d,0.0d,-distance), new Vector3d(0.0d,0.0d,1.0d));
        Intersection intersection;
        //Get pixel Array
        for(int x=0; x<width; x++)
            for(int y=0; y<height; y++)
            {
                r.setDir(pinhole_camera.getRayDir(width,height,x,y));
                intersection = scene.intersectWorld(r);
                if(intersection.getType()!= Intersection.IntersectionType.NONE){
                    System.out.println(intersection);
                    int red=100;
                    int green=100;
                    int blue=255;
                    int rgb = (red << 16) | (green << 8) | blue;
                    pixels[x+y*width]=rgb;
                }
                else {
                    int red = 0;
                    int green = 0;
                    int blue = 0;
                    int rgb = (red << 16) | (green << 8) | blue;
                    pixels[x+y*width]=rgb;
                }
            }

        Display display = new Display(width,height,pixels);
            display.draw();
    }
}
