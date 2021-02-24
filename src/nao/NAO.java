package nao;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;
import nao.logs.Log;
import nao.movement.postures.*;
import nao.sound.Voice;

public class NAO {
    private String name;
    private Application application;
    private Posture posture;
    private Voice voice;

    public NAO(String name) {
        this.name = name;
    }

    public void connect(String hostname, int port){
        String robotUrl = "tcp://" + hostname + ":" + port;
        // Connect to application
        this.application = new Application(new String[]{}, robotUrl);
        application.start();
        this.voice = new Voice(this.name, this.application.session());
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
        this.posture = new Standing(this.name, this.application.session());
        Log.newLog(this.name + " is in standing position");
    }

    public void sit() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("Sit", 0.6f);
        this.posture = new Sitting(this.name, this.application.session());
        Log.newLog(this.name + " is in siting position");
    }

    public Voice getVoice() {
        return voice;
    }

    public Posture getPosture() {
        return posture;
    }
}
