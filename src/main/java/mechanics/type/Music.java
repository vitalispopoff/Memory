package mechanics.type;

import gui.CardPanel;
import gui.InfoPanel;
import gui.OutroPanel;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Music {

    static String musicLocation = "src\\main\\resources\\SFX\\";
    static Random random = new Random();
    static Clip bcgClip;
    static boolean isBcgMusicOn = false;
    static AudioInputStream bcgInput;
    static long bcgMusicLength;


//    public static boolean musicBcg = true;

    public static void playMusicAction() {

        try {
            File musicPath = new File(
                    new StringBuilder()
                            .append(musicLocation)
                            .append("flipCard")
                            .append(random.nextInt(3))
                            .append(".wav")
                            .toString()
            );
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
            File musicPath = new File(
                    new StringBuilder()
                            .append(musicLocation)
                            .append("backGroundMusicLoops1.wav")

                            .toString()
            );
            if (musicPath.exists()) {
                AudioInputStream bcgInput = AudioSystem.getAudioInputStream(musicPath);
                bcgClip = AudioSystem.getClip();
                bcgClip.open(bcgInput);
                bcgClip.start();
                bcgClip.loop(Clip.LOOP_CONTINUOUSLY);
                isBcgMusicOn = true;
//                bcgMusicLength = bcgClip.getMicrosecondLength();

            } else {
                System.out.println("File not found BG");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopMusicBackground() {
        File musicPath = new File(
                new StringBuilder()
                        .append(musicLocation)
                        .append("outro.wav")
                        .toString()
        );
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
                        } catch (UnsupportedAudioFileException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (LineUnavailableException e) {
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
