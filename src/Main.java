import nao.NAO;
import nao.sound.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String naoUrl;
        int naoPort;
        int changePort = 1;

        NAO naomi = new NAO("NAOmi");

        switch (changePort) {
            case 0:
                naoUrl = "naomi.robot.hva-robots.nl";
                naoPort = 9559;
                break;
            default:
                naoUrl = "localhost";
                naoPort = 64035;
                break;
        }
        naomi.connect(naoUrl, naoPort);
        naomi.stand();
        naomi.getPosture().walk(0.1f, 0f, 0f, 3000);
        naomi.getPosture().walk(0.1f, 0.1f, 0f, 3000);
        naomi.getPosture().walk(0.1f, 0f, 0.1f, 3000);
        naomi.getPosture().walk(-0.1f, 0f, 0f, 3000);
        naomi.getPosture().walk(0f, 0f, 0f, 1000);

//        Music.playSong(naomi.getApplicationSession(), naomi.getName(), "douiyea_1613565391.mp3");
//        naomi.getPosture().moveLimb("RShoulderPitch", 0.1f, 0.5f, 1000);
//        naomi.getPosture().moveLimb("LShoulderPitch", 0.2f, 0.5f, 1000);
//        naomi.getPosture().moveLimb("LShoulderPitch", 0.1f, 0.5f, 1000);
//        naomi.getPosture().moveLimb("RShoulderPitch", 0.3f, 0.5f, 1000);
        Speak.say(naomi.getApplicationSession(), naomi.getName(), "Hello World");
        naomi.sit();
        naomi.getPosture().walk(1f, 0f, 0f, 1000);

    }
}