package labs.example.Physics;

import java.lang.Math;
public class MAin {
    public static void main(String[] args) throws Exception{
        Physics maths = new Physics();

        maths.getDistance(6, 20);
        maths.getVelocity(12, 21);
        maths.getMomentum(15, 3);
        maths.getForce(4, 41);
        maths.getWork(10, 7);
        maths.getKineticEnergy(100, 5);
        maths.getPotentialEnergy(8, 30);
        maths.getAngle(4, 3);
        if (maths.getAngle(4, 3) > 37 && maths.getAngle(3, 4) < 36.87){
            
        }
    }
}
