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
                naoPort = 64053;
                break;
        }
        naomi.connect(naoUrl, naoPort);
        naomi.stand();
//        naomi.getPosture().walk(0.1f, 0f, 0f, 3000);
//        naomi.getPosture().walk(0.1f, 0.1f, 0f, 3000);
//        naomi.getPosture().walk(0.1f, 0f, 0.1f, 3000);
//        naomi.getPosture().walk(-0.1f, 0f, 0f, 3000);
//        naomi.getPosture().walk(0f, 0f, 0f, 1000);

//        naomi.getVoice().playSong("douiyea_1613565391.mp3");
        naomi.getPosture().moveLimb("RShoulderPitch", 0.1f, 0.5f, 1000);
        naomi.getPosture().moveLimb("RShoulderRoll", -5f, 0.1f, 1000);
        naomi.getPosture().moveLimb("RElbowRoll", 5f, 0.1f, 1000);
        naomi.getPosture().moveLimb("LShoulderPitch", -0.1f, 0.5f, 1000);
        naomi.getPosture().moveLimb("LShoulderRoll", 5f, 0.1f, 1000);
        naomi.getPosture().moveLimb("LElbowRoll", -5f, 0.1f, 1000);
//        naomi.getPosture().moveLimb("HeadPitch", 0.5f, 0.5f, 1000);
        naomi.getVoice().say("Hello World!");
        naomi.sit();
        naomi.getPosture().walk(1f, 0f, 0f, 1000);

    }
}