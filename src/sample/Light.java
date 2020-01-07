package sample;

import org.joml.Vector3d;


public class Light {


    private Vector3d pos;
    private int color;

    public Light(Vector3d pos, int color) {
        this.pos = pos;
        this.color = color;
    }

    public Vector3d getPos() {
        return pos;
    }

    public int getColor() {
        return color;
    }
}
