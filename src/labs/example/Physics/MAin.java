package labs.example.Physics;

import java.lang.Math;

public class MAin {
    public static void main(String[] args) throws Exception{
        Physics maths = new Physics();

        double distance1 = 3;
        double distance2 = 2;

        maths.getDistance(distance1, distance2);
        
        maths.getVelocity(12, 21);
        
        maths.getMomentum(15, 3);
        
        maths.getForce(4, 41);
        
        maths.getWork(10, 7);
        
        maths.getKineticEnergy(100, 5);
        
        maths.getPotentialEnergy(8, 30);
        
        maths.getAngle(4, 3);
        
        if (maths.getAngle(4, 3) > 37 && maths.getAngle(3, 4) < 36.87){
            maths.logInvalidAngleInfo(maths.getAngle(4, 3));
        }
        
        else {
            maths.logValidAngleInfo(maths.getAngle(4, 3));
        }
        
        if (maths.getDistance(maths.getTimeFromSunToEarthInHours(), maths.getLightSpeedinMPH()) > 92955807.3) {
            System.out.println("The distance from the sun to the earth is greater than 92955807.3 miles.");
        }
        else {
            System.out.println("The distance from the sun to the earth is less than 92955807.3 miles.");
        }
    }
}
