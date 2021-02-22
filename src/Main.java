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
                naoPort = 60701;
                break;
        }
        naomi.connect(naoUrl, naoPort);
        naomi.stand();
//        Music.playSong(naomi.getApplicationSession(), naomi.getName(), "pokemon.mp3");
        naomi.moveLimb("RShoulderPitch", 0.1f, 0.5f);
        naomi.moveLimb("LShoulderPitch", 0.2f, 0.5f);
        naomi.moveLimb("LShoulderPitch", 0.1f, 0.5f);
        naomi.moveLimb("RShoulderPitch", 0.3f, 0.5f);
//        naomi.moveLimb("HeadYaw", 0.3f, 0.5f);
        Speak.say(naomi.getApplicationSession(), naomi.getName(), "Hello World");
        Thread.sleep(1000);
        naomi.sit();
    }
}