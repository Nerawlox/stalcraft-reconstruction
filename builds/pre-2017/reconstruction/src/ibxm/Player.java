/*
 * Decompiled with CFR 0.152.
 */
package ibxm;

import ibxm.FastTracker2;
import ibxm.IBXM;
import ibxm.Module;
import ibxm.ProTracker;
import ibxm.ScreamTracker3;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class Player {
    private Thread play_thread;
    private IBXM ibxm = new IBXM(48000);
    private Module module;
    private int song_duration;
    private int play_position;
    private boolean running;
    private boolean loop;
    private byte[] output_buffer;
    private SourceDataLine output_line;

    public static void main(String[] stringArray) throws Exception {
        if (stringArray.length < 1) {
            System.err.println("Usage: java ibxm.Player <module file>");
            System.exit(0);
        }
        FileInputStream fileInputStream = new FileInputStream(stringArray[0]);
        Player player = new Player();
        player.set_module(Player.load_module(fileInputStream));
        fileInputStream.close();
        player.play();
    }

    public static Module load_module(InputStream inputStream) throws IllegalArgumentException, IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        byte[] byArray = new byte[60];
        dataInputStream.readFully(byArray);
        if (FastTracker2.is_xm(byArray)) {
            return FastTracker2.load_xm(byArray, dataInputStream);
        }
        byte[] byArray2 = new byte[96];
        System.arraycopy(byArray, 0, byArray2, 0, 60);
        dataInputStream.readFully(byArray2, 60, 36);
        if (ScreamTracker3.is_s3m(byArray2)) {
            return ScreamTracker3.load_s3m(byArray2, dataInputStream);
        }
        byte[] byArray3 = new byte[1084];
        System.arraycopy(byArray2, 0, byArray3, 0, 96);
        dataInputStream.readFully(byArray3, 96, 988);
        return ProTracker.load_mod(byArray3, dataInputStream);
    }

    public Player() throws LineUnavailableException {
        this.set_loop(true);
        this.output_line = AudioSystem.getSourceDataLine(new AudioFormat(48000.0f, 16, 2, true, true));
        this.output_buffer = new byte[4096];
    }

    public void set_module(Module module) {
        if (module != null) {
            this.module = module;
        }
        this.stop();
        this.ibxm.set_module(this.module);
        this.song_duration = this.ibxm.calculate_song_duration();
    }

    public void set_loop(boolean bl) {
        this.loop = bl;
    }

    public void play() {
        this.stop();
        this.play_thread = new Thread(new Driver());
        this.play_thread.start();
    }

    public void stop() {
        this.running = false;
        if (this.play_thread != null) {
            try {
                this.play_thread.join();
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
    }

    private class Driver
    implements Runnable {
        private Driver() {
        }

        @Override
        public void run() {
            if (Player.this.running) {
                return;
            }
            try {
                Player.this.output_line.open();
                Player.this.output_line.start();
                Player.this.play_position = 0;
                Player.this.running = true;
                while (Player.this.running) {
                    int n = Player.this.song_duration - Player.this.play_position;
                    if (n > 1024) {
                        n = 1024;
                    }
                    Player.this.ibxm.get_audio(Player.this.output_buffer, n);
                    Player.this.output_line.write(Player.this.output_buffer, 0, n * 4);
                    Player.this.play_position += n;
                    if (Player.this.play_position < Player.this.song_duration) continue;
                    Player.this.play_position = 0;
                    if (Player.this.loop) continue;
                    Player.this.running = false;
                }
                Player.this.output_line.drain();
                Player.this.output_line.close();
            }
            catch (LineUnavailableException lineUnavailableException) {
                lineUnavailableException.printStackTrace();
            }
        }
    }
}

