package nao.movement.postures;

import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;
import javafx.geometry.Pos;
import nao.NAO;
import nao.logs.Log;

public class Standing extends Posture {
    public Standing(String name, Session session){
        super(name, session);
    }
    @Override
    public void walk(float walkingX, float walkingY, float theta, int waitInMilliseconds) throws Exception {
        ALMotion motion = new ALMotion(Posture.session);
        motion.moveTo(walkingX, walkingY, theta);
        Thread.sleep(waitInMilliseconds);
        Log.newLog(Posture.name + " x:" + walkingX + ", y: " + walkingY + ", thetha: "+ theta + "f walking voor " + waitInMilliseconds + "milliseconds");
    }
}
