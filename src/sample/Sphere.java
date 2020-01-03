package sample;

import org.joml.Vector3f;

public class Sphere {
    private Vector3f pos;
    private double radius;

    public Sphere(Vector3f pos, float radius) {
        this.pos = pos;
        this.radius = radius;
    }

    public Intersection intersect(Ray r)
    {
        System.out.println("Origin"+r.getOrigin());
        Intersection intersection;
        // Wo ist der Punkt auf dem Strahl, der am n nächsten an mir liegt?
         double alpha = -r.getDir().dot(r.getOrigin().sub(this.pos));

         Vector3f q = r.getOrigin().add((float) alpha*r.getDir().x(),(float) alpha*r.getDir().y(),(float) alpha*r.getDir().z());
        System.out.println("Origin"+r.getOrigin());
         // Abstand zum Kugelmittelpunkt?
         q.sub(this.pos);
         double distToCenterSquared = q.lengthSquared();
         double radiusSquared = Math.pow(this.radius,2);

         if (distToCenterSquared > radiusSquared){
             intersection = new Intersection(Intersection.IntersectionType.NONE);
             return intersection;
         }


         // Über Pythagoras zu den beiden Schnittpunkten.
         double x = Math.sqrt(radiusSquared - distToCenterSquared);
         // Welcher von beiden liegt näher am Ray - Ursprung
         // positiver Strahlrichtung?
         double dist = 0.0;

         if (alpha >= x){
            dist = alpha - x;
            intersection = new Intersection(Intersection.IntersectionType.EXTERNAL);
         }
         else if(alpha+x>0){
             intersection = new Intersection(Intersection.IntersectionType.INTERNAL);
            dist = alpha + x;
         }
         else{
             intersection = new Intersection(Intersection.IntersectionType.NONE);
             return intersection;
         }
         System.out.println("Distance:"+dist);
        System.out.println("Origin"+r.getOrigin());
         // Das ist unser finaler Schnittpunkt:
         q = r.getOrigin().add((float) dist*r.getDir().x(),(float) dist*r.getDir().y(),(float) dist*r.getDir().z());
         System.out.println("Intersection point:"+q);
         intersection.setPos(q);
         intersection.setT((float)dist);
         return intersection;
    }
}
