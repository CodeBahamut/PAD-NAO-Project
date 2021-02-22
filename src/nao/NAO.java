package nao;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;
import nao.logs.Log;

public class NAO {
    private String name;
    private Application application;

    public NAO(String name) {
        this.name = name;
    }

    public void connect(String hostname, int port){
        String robotUrl = "tcp://" + hostname + ":" + port;
        // Connect to application
        this.application = new Application(new String[]{}, robotUrl);
        application.start();
        Log.newLog(this.name +" is Connected!");
    }

    public String getName() {
        return this.name;
    }

    public Session getApplicationSession() {
        return this.application.session();
    }

    public void stand() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("StandInit", 0.6f);
        Log.newLog(this.name + " is in standing position");
    }

    public void sit() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("Sit", 0.6f);
        Log.newLog(this.name + " is in siting position");
    }

    public void moveLimb(String limbs, float angle, float maxSpeed) throws Exception {
        ALMotion motion = new ALMotion(this.application.session());
        motion.angleInterpolationWithSpeed(limbs, angle, maxSpeed);
        Log.newLog(this.name + " " + limbs + " set to " + angle + "f with " + maxSpeed + "f speed");
    }
}
