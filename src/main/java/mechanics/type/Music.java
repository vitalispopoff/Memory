package mechanics.type;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {

    public void playMusic(String musicLocation){

        try {
            File musicPath = new File(musicLocation);

            if (musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            } else {
                System.out.println("File not found");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}