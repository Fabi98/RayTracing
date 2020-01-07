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
            double spec = ((exponent+2.0d)/(2*Math.PI))*Math.pow((viewDir.dot(lightDir)),exponent);
            //double spec = Math.pow(R.dot(viewDir),exponent);
            double spec_factor= intersection.getMaterial().getSpecular();
            double intensity= light.getColor().getRGB();
            illumination_for_lights=((diffuse_factor*intensity*diffuse)+(spec_factor*intensity*spec));
        }
        double color = intersection.getMaterial().getColor().getRGB();
        color*=ambiant_factor+illumination_for_lights;
        Color erg = new Color((int)(color));
        System.out.println(erg);
        return erg;
    }

}
