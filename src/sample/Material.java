package sample;

import java.awt.*;

public class Material {
    private double ambient;
    private double diffuse;
    private double specular;
    private Color color;

    public Material(Color color, double ambient, double diffuse, double specular) {
        this.color = color;
        this.ambient = ambient;
        this.diffuse = diffuse;
        this.specular = specular;
    }

    public double getAmbient() {
        return ambient;
    }


    public double getDiffuse() {
        return diffuse;
    }

    public double getSpecular() {
        return specular;
    }

    public Color getColor() {
        return color;
    }
}
