package sample;

import org.joml.Vector3d;

public class Camera {
    private Vector3d pos;
    private Vector3d dir;
    private Vector3d up;
    private Vector3d w = new Vector3d();
    private Vector3d u = new Vector3d();
    private Vector3d v = new Vector3d();

    private double angle;

    public Camera(Vector3d pos, Vector3d dir, Vector3d up, double angle) {
        this.pos = pos;
        this.dir = dir;
        this.up = up;
        this.angle = angle;

        // Now Calculating vector w
        // The formular for this vector looks like this
        //          g
        //  w = - -----
        //         |g|
        dir.normalize(w).negate(w);


        // Now calculationg vector u
        // The formuar for this vector looks like this
        //      t x w
        // u = ---------
        //      |t x w|
        Vector3d up_cross_w = new Vector3d();
        this.w.cross(this.up,up_cross_w);
        up_cross_w.div(up_cross_w.length(),u);

        // Now calculating vector v
        // The formular for this vector looks like this
        //
        // v = w x u
        //
        this.w.cross(this.u,this.v);
    }
    public Ray getRay(int width, int height, int x,int y){
        // The direction of the rays is based on the given angle of the camera
        // This is the formular used to calculate the vector
        //
        //               h
        //              ---
        //               2             w-1                w-1
        // r = -w * ( ------ ) + (x - ----- ) * u + (y - ----- ) * v
        //            tan a             2                  2
        //
        // In order to ensure better readability we declare three variables standing for the big brackets in the formular
        final double firstBracket = ((double) height/2.0d)/(Math.tan(this.angle));
        final double xBracket = (double)x-(((double)width-1.0d)/2.0d);
        final double yBracket = (double)y-(((double)width-1.0d)/2.0d);
        // Finally the calculation for r is made.
        Vector3d r = new Vector3d();
        w.negate(r).mul(firstBracket,r).add(u.mul(xBracket,r),r).add(v.mul(yBracket,r),r);

        return new Ray(pos,r);
    }



}
