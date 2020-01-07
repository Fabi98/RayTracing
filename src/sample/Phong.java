package sample;

import org.joml.Vector3d;

public class Phong {

    public static int getIlluminationColor(Light[] lights, Vector3d viewpos, Intersection intersection, double exponent){
        //OUT=Ambiant+Diffus+Specular

        //1) Ambiant Part
        double ambiant_factor = intersection.getMaterial().getAmbient();

        for (Light light: lights) {
            Vector3d lightDir   = new Vector3d();
            Vector3d viewDir    = new Vector3d();
            Vector3d halfwayDir = new Vector3d();

            intersection.getPos().sub(light.getPos(),lightDir).normalize(lightDir);
            intersection.getPos().sub(viewpos,viewDir).normalize(viewDir);
            viewDir.add(lightDir,halfwayDir).normalize(halfwayDir);

            //2) Diffuse Part
            double diffuse = lightDir.dot(intersection.getNormal());
            double diffuse_factor=intersection.getMaterial().getDiffuse();

            //Blinn Phong Specular
            Vector3d pow_temp= new Vector3d();
            double spec = Math.pow(Math.max(intersection.getNormal().dot(halfwayDir),0.0d),intersection.getMaterial().getSpecular());


            double out = ambiant_factor + intersection.getMaterial().getColor() * (diffuse*diffuse_factor+spec);
        }
        return 0;
    }
}
