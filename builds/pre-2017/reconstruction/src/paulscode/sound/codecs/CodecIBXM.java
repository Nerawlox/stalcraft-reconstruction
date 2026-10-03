/*
 * Decompiled with CFR 0.152.
 */
package paulscode.sound.codecs;

import ibxm.FastTracker2;
import ibxm.IBXM;
import ibxm.Module;
import ibxm.ProTracker;
import ibxm.ScreamTracker3;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import javax.sound.sampled.AudioFormat;
import paulscode.sound.ICodec;
import paulscode.sound.SoundBuffer;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemLogger;

public class CodecIBXM
implements ICodec {
    private static final boolean GET = false;
    private static final boolean SET = true;
    private static final boolean XXX = false;
    private boolean endOfStream = false;
    private boolean initialized = false;
    private AudioFormat myAudioFormat = null;
    private boolean reverseBytes = false;
    private IBXM ibxm;
    private Module module;
    private int songDuration;
    private int playPosition;
    private SoundSystemLogger logger = SoundSystemConfig.getLogger();

    @Override
    public void reverseByteOrder(boolean bl) {
        this.reverseBytes = bl;
    }

    @Override
    public boolean initialize(URL uRL) {
        this.initialized(true, false);
        this.cleanup();
        if (uRL == null) {
            this.errorMessage("url null in method 'initialize'");
            this.cleanup();
            return false;
        }
        InputStream inputStream = null;
        try {
            inputStream = uRL.openStream();
        }
        catch (IOException iOException) {
            this.errorMessage("Unable to open stream in method 'initialize'");
            this.printStackTrace(iOException);
            return false;
        }
        if (this.ibxm == null) {
            this.ibxm = new IBXM(48000);
        }
        if (this.myAudioFormat == null) {
            this.myAudioFormat = new AudioFormat(48000.0f, 16, 2, true, true);
        }
        try {
            this.setModule(CodecIBXM.loadModule(inputStream));
        }
        catch (IllegalArgumentException illegalArgumentException) {
            this.errorMessage("Illegal argument in method 'initialize'");
            this.printStackTrace(illegalArgumentException);
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (IOException iOException) {
                    // empty catch block
                }
            }
            return false;
        }
        catch (IOException iOException) {
            this.errorMessage("Error loading module in method 'initialize'");
            this.printStackTrace(iOException);
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (IOException iOException2) {
                    // empty catch block
                }
            }
            return false;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        this.endOfStream(true, false);
        this.initialized(true, true);
        return true;
    }

    @Override
    public boolean initialized() {
        return this.initialized(false, false);
    }

    @Override
    public SoundBuffer read() {
        if (this.endOfStream(false, false)) {
            return null;
        }
        if (this.module == null) {
            this.errorMessage("Module null in method 'read'");
            return null;
        }
        if (this.myAudioFormat == null) {
            this.errorMessage("Audio Format null in method 'read'");
            return null;
        }
        int n = this.songDuration - this.playPosition;
        int n2 = SoundSystemConfig.getStreamingBufferSize() / 4;
        if (n > n2) {
            n = n2;
        }
        if (n <= 0) {
            this.endOfStream(true, true);
            return null;
        }
        byte[] byArray = new byte[n * 4];
        this.ibxm.get_audio(byArray, n);
        this.playPosition += n;
        if (this.playPosition >= this.songDuration) {
            this.endOfStream(true, true);
        }
        if (this.reverseBytes) {
            CodecIBXM.reverseBytes(byArray, 0, n * 4);
        }
        SoundBuffer soundBuffer = new SoundBuffer(byArray, this.myAudioFormat);
        return soundBuffer;
    }

    @Override
    public SoundBuffer readAll() {
        if (this.module == null) {
            this.errorMessage("Module null in method 'readAll'");
            return null;
        }
        if (this.myAudioFormat == null) {
            this.errorMessage("Audio Format null in method 'readAll'");
            return null;
        }
        int n = SoundSystemConfig.getFileChunkSize() / 4;
        byte[] byArray = new byte[n * 4];
        byte[] byArray2 = null;
        int n2 = 0;
        while (!this.endOfStream(false, false) && n2 < SoundSystemConfig.getMaxFileSize()) {
            int n3 = this.songDuration - this.playPosition;
            if (n3 > n) {
                n3 = n;
            }
            this.ibxm.get_audio(byArray, n3);
            n2 += n3 * 4;
            byArray2 = CodecIBXM.appendByteArrays(byArray2, byArray, n3 * 4);
            this.playPosition += n3;
            if (this.playPosition < this.songDuration) continue;
            this.endOfStream(true, true);
        }
        if (this.reverseBytes) {
            CodecIBXM.reverseBytes(byArray2, 0, n2);
        }
        SoundBuffer soundBuffer = new SoundBuffer(byArray2, this.myAudioFormat);
        return soundBuffer;
    }

    @Override
    public boolean endOfStream() {
        return this.endOfStream(false, false);
    }

    @Override
    public void cleanup() {
        this.playPosition = 0;
    }

    @Override
    public AudioFormat getAudioFormat() {
        return this.myAudioFormat;
    }

    private static Module loadModule(InputStream inputStream) throws IllegalArgumentException, IOException {
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

    private void setModule(Module module) {
        if (module != null) {
            this.module = module;
        }
        this.ibxm.set_module(this.module);
        this.songDuration = this.ibxm.calculate_song_duration();
    }

    private synchronized boolean initialized(boolean bl, boolean bl2) {
        if (bl) {
            this.initialized = bl2;
        }
        return this.initialized;
    }

    private synchronized boolean endOfStream(boolean bl, boolean bl2) {
        if (bl) {
            this.endOfStream = bl2;
        }
        return this.endOfStream;
    }

    private static byte[] trimArray(byte[] byArray, int n) {
        byte[] byArray2 = null;
        if (byArray != null && byArray.length > n) {
            byArray2 = new byte[n];
            System.arraycopy(byArray, 0, byArray2, 0, n);
        }
        return byArray2;
    }

    public static void reverseBytes(byte[] byArray) {
        CodecIBXM.reverseBytes(byArray, 0, byArray.length);
    }

    public static void reverseBytes(byte[] byArray, int n, int n2) {
        for (int i = n; i < n + n2; i += 2) {
            byte by = byArray[i];
            byArray[i] = byArray[i + 1];
            byArray[i + 1] = by;
        }
    }

    private static byte[] convertAudioBytes(byte[] byArray, boolean bl) {
        Object object;
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(byArray.length);
        byteBuffer.order(ByteOrder.nativeOrder());
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(byArray);
        byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
        if (bl) {
            object = byteBuffer.asShortBuffer();
            ShortBuffer shortBuffer = byteBuffer2.asShortBuffer();
            while (shortBuffer.hasRemaining()) {
                ((ShortBuffer)object).put(shortBuffer.get());
            }
        } else {
            while (byteBuffer2.hasRemaining()) {
                byteBuffer.put(byteBuffer2.get());
            }
        }
        byteBuffer.rewind();
        if (!byteBuffer.hasArray()) {
            object = new byte[byteBuffer.capacity()];
            byteBuffer.get((byte[])object);
            byteBuffer.clear();
            return object;
        }
        return byteBuffer.array();
    }

    private static byte[] appendByteArrays(byte[] byArray, byte[] byArray2, int n) {
        byte[] byArray3;
        if (byArray == null && byArray2 == null) {
            return null;
        }
        if (byArray == null) {
            byArray3 = new byte[n];
            System.arraycopy(byArray2, 0, byArray3, 0, n);
            byArray2 = null;
        } else if (byArray2 == null) {
            byArray3 = new byte[byArray.length];
            System.arraycopy(byArray, 0, byArray3, 0, byArray.length);
            byArray = null;
        } else {
            byArray3 = new byte[byArray.length + n];
            System.arraycopy(byArray, 0, byArray3, 0, byArray.length);
            System.arraycopy(byArray2, 0, byArray3, byArray.length, n);
            byArray = null;
            byArray2 = null;
        }
        return byArray3;
    }

    private void errorMessage(String string) {
        this.logger.errorMessage("CodecWav", string, 0);
    }

    private void printStackTrace(Exception exception) {
        this.logger.printStackTrace(exception, 1);
    }
}

