package sample;

import org.joml.Vector3d;

public abstract class Geometry {
    private Vector3d pos;
    private Material material;

    public Geometry(Vector3d pos, Material material){
        this.pos=pos;
        this.material=material;
    }
    public abstract Intersection intersect(Ray r);
}
