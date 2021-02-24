package nao.sound;

import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALAudioPlayer;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;
import nao.logs.Log;

public class Voice {
    private String name;
    private Session session;

    public Voice(String name, Session session){
        this.name = name;
        this.session = session;
    }

    public void say(String text) throws Exception {
        // Create an ALTextToSpeech object and link it to your current session
        ALTextToSpeech tts = new ALTextToSpeech(this.session);
        // Make your robot say something
        tts.say(text);
        System.out.println();
        Log.newLog(this.name + " said: " + text);
    }

    public void playSong(String song) throws Exception {
        ALAudioPlayer audioPlayer = new ALAudioPlayer(this.session);
        String path = "/home/nao/wav/";
        audioPlayer.playFile(path + song, 0.2f, 0f);
        Log.newLog(this.name + " sang " + song);
    }
}
