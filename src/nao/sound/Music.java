package nao.sound;

import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALAudioPlayer;
import java.nio.file.Paths;
import nao.logs.Log;

public class Music {
    public static void playSong(Session session, String name, String song) throws Exception {
        ALAudioPlayer audioPlayer = new ALAudioPlayer(session);
        String path = "/home/nao/wav/";
        audioPlayer.playFile(path + song, 0.2f, 0f);
        Log.newLog(name + " sang " + song);
    }
}
