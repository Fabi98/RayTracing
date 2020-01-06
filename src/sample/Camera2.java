package sample;

import org.joml.Vector3d;

public class Camera2 {
    private double angle;
    private Vector3d pos;
    private Vector3d dir;
    private Vector3d up = new Vector3d();
    private Vector3d t = new Vector3d();
    private Vector3d b = new Vector3d();
    private Vector3d v = new Vector3d();

    public Camera2(Vector3d pos, Vector3d dir, Vector3d v, double angle) {
        this.angle = angle;
        this.pos = pos;
        this.dir = dir;
        //b = v x dir
        v.cross(dir,b);

        //Normalize dir and b
        //dir.normalize(dir);
        b.normalize(b).negate(b);
    }
    public Ray getRay(double width, double height, int i, int j){
        //https://en.wikipedia.org/wiki/Ray_tracing_(graphics)#Calculate_rays_for_rectangular_viewport

        double gx= Math.tan((angle/2));
        double gy = gx * (width/height);
        double distance= (height/2)/Math.tan(angle);
        Vector3d qx = new Vector3d();
        Vector3d qy = new Vector3d();

        b.mul((2*gx)/(width-1),qx);
        v.mul((2*gy)/(height-1),qy);


        Vector3d p_1m= new Vector3d();
        Vector3d p_1m_x= new Vector3d();
        Vector3d p_1m_y= new Vector3d();
        b.mul(gx,p_1m_x);
        v.mul(gy,p_1m_y);
        t.sub(p_1m_x.sub(p_1m_y,p_1m),p_1m);

        System.out.println(b+"--"+v);

        Vector3d r_ij= new Vector3d();
        Vector3d r_ij_x= new Vector3d();
        Vector3d r_ij_y= new Vector3d();
        qx.mul(i-1,r_ij_x);
        qy.mul(j-1,r_ij_y);
        p_1m.add(r_ij_x.add(r_ij_y,r_ij),r_ij);
        //System.out.println(r_ij);
        return new Ray(pos,r_ij);
    }
}
