package sample;

import org.joml.Vector3d;

import java.awt.*;

public class Sphere extends Geometry{
    private Vector3d pos;
    private double radius;

    public Sphere(Vector3d pos, double radius) {
        super(pos,new Material(new Color(0,121,107),0.3,0.7,0.2));
        //super(pos,new Material(new Color(255,255,0),0.3,0.7,0.2));

        this.pos = pos;
        this.radius = radius;
    }
    public Sphere(Vector3d pos, double radius, Material material) {
        super(pos,material);
        this.pos = pos;
        this.radius = radius;
    }

    @Override
    public Intersection intersect(Ray r)
    {

        Intersection intersection;
        // Wo ist der Punkt auf dem Strahl, der am n nächsten an mir liegt?
         double alpha = -r.getDir().dot(r.getOrigin().sub(this.pos));
        Vector3d q=new Vector3d();
        q = r.position(alpha);
         // Abstand zum Kugelmittelpunkt?
         q.sub(this.pos);
         double distToCenterSquared = q.lengthSquared();
         double radiusSquared = (double) Math.pow(this.radius,2);

         if (distToCenterSquared > radiusSquared){
             intersection = new Intersection(Intersection.IntersectionType.NONE,this.getClass().getName(),material);
             return intersection;
         }

         // Über Pythagoras zu den beiden Schnittpunkten.
          double x = (double)Math.sqrt(radiusSquared - distToCenterSquared);
         // Welcher von beiden liegt näher am Ray - Ursprung
         // positiver Strahlrichtung?
         double dist = 0.0f;

         if (alpha >= x){
            dist = alpha - x;
            intersection = new Intersection(Intersection.IntersectionType.EXTERNAL,this.getClass().getName(),material);
         }
         else if(alpha+x>0){
             intersection = new Intersection(Intersection.IntersectionType.INTERNAL,this.getClass().getName(),material);
            dist = alpha + x;
         }
         else{
             intersection = new Intersection(Intersection.IntersectionType.NONE,this.getClass().getName(),material);
             return intersection;
         }

         // Das ist unser finaler Schnittpunkt:
         q = r.position(dist);

         //Compute normal from intersection point and pos

         Vector3d normal = new Vector3d();
         q.sub(pos,normal).normalize(normal);

        intersection.setPos(q);
        intersection.setNormal(normal);
        intersection.setDistance(dist);

         return intersection;
    }
}
