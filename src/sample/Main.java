package sample;

import org.joml.Vector3d;

import java.awt.*;

import static java.awt.Color.WHITE;

public class Main {
    public static void main(String[] args) {

        int width=1024;
        int height=1024;
        double distance= 20d;
        Intersection intersection;

        //Initialize Pixel Array
        int[]pixels=new int[width*height];

        double radius = 10.0d;

        //Add Sphere
        Vector3d center = new Vector3d(0.0d,0.0d,0.0d);
        Sphere sphere = new Sphere(center,radius);

        //Add Lights
        //Light light_rear_left = new Light(new Vector3d(-10,-20,0), WHITE);
        Light light_upper_left = new Light(new Vector3d(10.0d,30.0d,0d), WHITE);

        Scene scene = new Scene(new Geometry[]{sphere}
                                , new Light[]{light_upper_left
                                },Color.RED.getRGB());

        Pinhole_Camera pinhole_camera= new Pinhole_Camera(new Vector3d(0.0d,0.0d,-distance),new Vector3d(new Vector3d(0.0d,0.0d,1.0d)));
        Ray r = new Ray(pinhole_camera.getPos(),pinhole_camera.getDir());
        //Compute all color Values for Pixels
        for(int x=0; x<width; x++)
            for(int y=0; y<height; y++)
            {
                r.setDir(pinhole_camera.getRayDir(width,height,x,y));
                intersection = scene.intersectWorld(r);
                if(intersection.getType()!= Intersection.IntersectionType.NONE){
                    //System.out.println(intersection);
                    /*int red=100;
                    int green=100;
                    int blue=255;
                    int rgb = (red << 16) | (green << 8) | blue;*/
                    pixels[x+y*width]=Phong.getIlluminationColor(scene.getLights(),pinhole_camera.pos,intersection,300).getRGB();
                    //pixels[x+y*width]= Phong2.getIlluminationColor(scene.getLights(),pinhole_camera.pos,intersection,200).getRGB();
                }
                else {
                    int red = 100;
                    int green = 100;
                    int blue = 100;
                    int rgb = (red << 16) | (green << 8) | blue;
                    pixels[x+y*width]=rgb;
                }
            }

        Display display = new Display(width,height,pixels);
            display.draw();
    }
}
