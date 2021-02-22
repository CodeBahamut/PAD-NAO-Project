package nao.sound;

import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;
import nao.logs.Log;

public class Speak {
    public static void say(Session session, String name, String text) throws Exception {
        // Create an ALTextToSpeech object and link it to your current session
        ALTextToSpeech tts = new ALTextToSpeech(session);
        // Make your robot say something
        tts.say(text);
        System.out.println();
        Log.newLog(name + " said: " + text);
    }
}
