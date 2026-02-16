package labs.example.Physics;

import java.lang.Math;

public class Physics {
    
    final static double GRAVITY = 9.81;

    public double getDistance(double v, double t){
        double x = (v * t); 
        return x;
    };

    public double getVelocity(double x, double t){
        double v = (x / t); 
        return v;
    };

    public double getMomentum(double m, double v){
        double p = (m * v); 
        return p;
    };

    public double getForce(double m, double a){
        double f = (m * a); 
        return f;
    };

    public double getWork(double f, double d){
        double w = (f * d); 
        return w;
    };

    public double getKineticEnergy(double m, double v){
        double ke = ((1/2)*m*(v*v));
        return ke;
    };

    public double getPotentialEnergy(double m, double h){
        double pe = (m * GRAVITY * h);
        return pe;
    };

    public double getAngle(double x, double y){
        double theta = Math.atan2(x,y);
        double thetaAngle = Math.toDegrees(theta);
        return thetaAngle;
    };
}
