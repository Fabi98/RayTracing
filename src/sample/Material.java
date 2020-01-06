package sample;

public class Material {
    private double ambient
            ,brilliance
            ,diffuse,
            specular,
            roughness,
            reflection;

    public Material(double ambient, double brilliance, double diffuse, double specular, double roughness, double reflection) {
        this.ambient = ambient;
        this.brilliance = brilliance;
        this.diffuse = diffuse;
        this.specular = specular;
        this.roughness = roughness;
        this.reflection = reflection;
    }
}
