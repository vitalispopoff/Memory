package gra.memory.mechanics.type;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Music implements Musical{

    private static String musicLocation = "src\\main\\resources\\SFX\\";
    private static Random random = new Random();
    private static Clip bcgClip;
    private static boolean isBcgMusicOn = false;

    public static void playMusicAction() {

        try {
            File musicPath = new File(musicLocation + "flipCard" + random.nextInt(3) + ".wav");
            if (musicPath.exists()) {
                AudioInputStream sfxInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(sfxInput);
                clip.start();
            } else {
                System.out.println("File not found AC");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void playMusicBackground() {

        try {
            File musicPath = new File(musicLocation + "backGroundMusicLoops1.wav");
            if (musicPath.exists()) {
                AudioInputStream bcgInput = AudioSystem.getAudioInputStream(musicPath);
                bcgClip = AudioSystem.getClip();
                bcgClip.open(bcgInput);
                bcgClip.start();
                bcgClip.loop(Clip.LOOP_CONTINUOUSLY);
                isBcgMusicOn = true;
            } else {
                System.out.println("File not found BG");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopMusicBackground() {
        File musicPath = new File(musicLocation + "outro.wav");
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        try {
                            if (isBcgMusicOn) {
                                bcgClip.close();
                                isBcgMusicOn = false;
                            }
                            AudioInputStream outroInput = AudioSystem.getAudioInputStream(musicPath);
                            Clip outroClip = AudioSystem.getClip();
                            outroClip.open(outroInput);
                            outroClip.start();
                        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                            e.printStackTrace();
                        }
                        {
                            new java.util.Timer().schedule(
                                    new java.util.TimerTask() {
                                        @Override
                                        public void run() {
                                            System.exit(0);
                                        }
                                    },
                                    5700
                            );

                        }
                    }
                },
                1500
        );
    }

    public static void playMusicIntro(String musicLocation) {

        try {
            File musicPath = new File(musicLocation);

            if (musicPath.exists()) {
                AudioInputStream introInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(introInput);
                clip.start();
            } else {
                System.out.println("File not found INT");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
