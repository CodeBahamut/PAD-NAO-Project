package nao.movement.postures;

import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;
import nao.NAO;
import nao.logs.Log;

public abstract class Posture {
    protected static String name;
    protected static Session session;

    public Posture(String name, Session session){
        this.name = name;
        this.session = session;
    }
    public void walk(float walkingX, float walkingY, float theta, int waitInMilliseconds) throws Exception {
        System.out.println(this.name + " can\'t walk");
        Log.newLog( this.name + " can\'t succeed this function, because it\'s not in a standing position.");
    }

    public void moveLimb(String limbs, float angle, float maxSpeed, int waitInMilliseconds) throws Exception {
        ALMotion motion = new ALMotion(this.session);
        motion.angleInterpolationWithSpeed(limbs, angle, maxSpeed);
        Thread.sleep(waitInMilliseconds);
        Log.newLog(this.name + " " + limbs + " set to " + angle + "f with " + maxSpeed + "f speed waiting for " + waitInMilliseconds + "milliseconds");
    }
}
