package sample;

import org.joml.Vector3d;

import java.awt.*;

public class Phong {


    public static Color getIlluminationColor(Light[] lights, Vector3d viewpos, Intersection intersection, double exponent){
        //OUT=Ambiant+Diffus+Specular
        double illumination_for_lights=0;
        //1) Ambiant Part
        double ambiant_factor = intersection.getMaterial().getAmbient();

        for (Light light: lights) {
            Vector3d lightDir   = new Vector3d();
            Vector3d viewDir    = new Vector3d();

            light.getPos().sub(intersection.getPos(),lightDir).normalize(lightDir);
            viewpos.sub(intersection.getPos(),viewDir).normalize(viewDir);
            double distance_to_light=1/lightDir.lengthSquared();

            //2) Diffuse Part

            Vector3d NL = new Vector3d();
            lightDir.sub(intersection.getNormal(),NL);
            Vector3d R = new Vector3d();
            NL.mul(2*lightDir.dot(intersection.getNormal()),R);

            double diffuse = lightDir.dot(intersection.getNormal());
            double diffuse_factor=intersection.getMaterial().getDiffuse();
            // Specular Part
            double spec = (exponent+2.0d)/(2.0d*Math.PI) *Math.pow(lightDir.dot(viewDir),exponent);
            //double spec = Math.pow(R.dot(viewDir),exponent);
            double spec_factor= intersection.getMaterial().getSpecular();
            double intensity= light.getColor().getRGB();
            illumination_for_lights=((diffuse_factor*intensity*diffuse)+(spec_factor*intensity*spec));
        }
        float color_r = intersection.getMaterial().getColor().getRed()/255.0f;
        float color_g = intersection.getMaterial().getColor().getGreen()/255.0f;
        float color_b = intersection.getMaterial().getColor().getBlue()/255.0f;
        color_r*=ambiant_factor+illumination_for_lights;
        color_g*=ambiant_factor+illumination_for_lights;
        color_b*=ambiant_factor+illumination_for_lights;
        //color_r = clamp(color_r,0,1);
        //color_g = clamp(color_r,0,1);
        //color_b = clamp(color_r,0,1);
        //color_r = Math.max(color_r,0);
        //color_g = Math.max(color_g,0);
        //color_b = Math.max(color_b,0);

        Color erg = new Color(color_r,color_g,color_b);
        System.out.println(erg);
        return erg;
    }
    public static float clamp(float val, float min, float max) {
        return Math.max(min, Math.min(max, val));
    }

}
