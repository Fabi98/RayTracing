package sample;

import org.joml.Vector3d;

import java.awt.*;

public class Phong2 {


    public static Color getIlluminationColor(Light[] lights, Vector3d viewpos, Intersection intersection, double exponent){
        // Normal of the hit object
        Vector3d n = intersection.getNormal();
        // Vector pointing to the viewers Position from the intersection point given by the hit object.
        Vector3d e = new Vector3d();
        viewpos.sub(intersection.getPos(),e).normalize(e);
        // Setting up Variables cd (color diffus), ca (color ambient), cs (color specular) and c (return value "Color").
        double diffuse_factor = intersection.getMaterial().getDiffuse();
        double ambient_factor = intersection.getMaterial().getAmbient();
        double specular_factor = intersection.getMaterial().getSpecular();
        double c = diffuse_factor*ambient_factor;

        // Every source of light is now checked.
        // Whenever the light illuminates the interception point of the hit object the color is calculated and added to c.
        for (Light light: lights) {
            Light currentLight = light;
            // if the Point is illuminated by the current light source, then the color is added.
            //if(currentLight.illuminates(hit.ray.at(hit.t), world)){
                // Vector pointing to the light source
                Vector3d lightdir = new Vector3d();
                currentLight.getPos().sub(intersection.getPos(),lightdir).normalize(lightdir);
                // Vector which is reflected by the Material using the Normal n
                Double s = lightdir.dot(n);
                Vector3d no = new Vector3d();
                no.mul(s,no).mul(2.0,no);
                Vector3d rn = new Vector3d();
                no.sub(lightdir,rn);

                // Color of the current Light (cl)
                Color lightColor = currentLight.getColor();
                // Sum of all the light generated colors
                double phongColor = diffuse_factor * (lightColor.getRGB())*(Math.max(0, n.dot(lightdir)))+(specular_factor*(lightColor.getRGB())*(Math.pow(Math.max(0,e.dot(rn)), exponent)));

                // Color is added to the return value
                c = c+phongColor;
                c*=intersection.getMaterial().getColor().getRGB();
            System.out.println(c);
            //}
        }
        return new Color((int)c);
    }


}
