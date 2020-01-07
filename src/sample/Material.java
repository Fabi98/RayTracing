package sample;

public class Material {
    private double ambient;
    private double brilliance;
    private double diffuse;
    private double specular;

    public double getAmbient() {
        return ambient;
    }

    public double getBrilliance() {
        return brilliance;
    }

    public double getDiffuse() {
        return diffuse;
    }

    public double getSpecular() {
        return specular;
    }

    public double getRoughness() {
        return roughness;
    }

    public double getReflection() {
        return reflection;
    }

    public int getColor() {
        return color;
    }

    private double roughness;
    private double reflection;

    private int color;

    public Material(int color, double ambient, double brilliance, double diffuse, double specular, double roughness, double reflection) {
        this.color = color;
        this.ambient = ambient;
        this.brilliance = brilliance;
        this.diffuse = diffuse;
        this.specular = specular;
        this.roughness = roughness;
        this.reflection = reflection;
    }
}
