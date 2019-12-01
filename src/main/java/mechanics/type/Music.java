package mechanics.type;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {

    public static void playMusicAction(String musicLocation){

        try {
            File musicPath = new File(musicLocation);

            if (musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            } else {
                System.out.println("File not found AC");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void playMusicBackground(String musicLocation){

        try {
            File musicPath = new File(musicLocation);

            if (musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("File not found BG");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void playMusicInro(String musicLocation){

        try {
            File musicPath = new File(musicLocation);

            if (musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
//                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("File not found INT");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
