package sample;

import org.joml.Vector3d;

import java.awt.*;


public class Light {


    private Vector3d pos;
    private Color color;

    public Light(Vector3d pos, Color color) {
        this.pos = pos;
        this.color = color;
    }

    public Vector3d getPos() {
        return pos;
    }

    public Color getColor() {
        return color;
    }
}
