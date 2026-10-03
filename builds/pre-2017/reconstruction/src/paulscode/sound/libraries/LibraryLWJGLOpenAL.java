/*
 * Decompiled with CFR 0.152.
 */
package paulscode.sound.libraries;

import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.sound.sampled.AudioFormat;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import paulscode.sound.Channel;
import paulscode.sound.FilenameURL;
import paulscode.sound.ICodec;
import paulscode.sound.Library;
import paulscode.sound.ListenerData;
import paulscode.sound.SoundBuffer;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemException;
import paulscode.sound.Source;
import paulscode.sound.libraries.ChannelLWJGLOpenAL;
import paulscode.sound.libraries.SourceLWJGLOpenAL;

public class LibraryLWJGLOpenAL
extends Library {
    private static final boolean GET = false;
    private static final boolean SET = true;
    private static final boolean XXX = false;
    private FloatBuffer listenerPositionAL = null;
    private FloatBuffer listenerOrientation = null;
    private FloatBuffer listenerVelocity = null;
    private HashMap<String, IntBuffer> ALBufferMap = new HashMap();
    private static boolean alPitchSupported = true;

    public LibraryLWJGLOpenAL() throws SoundSystemException {
        this.reverseByteOrder = true;
    }

    @Override
    public void init() throws SoundSystemException {
        boolean bl = false;
        try {
            AL.create();
            bl = this.checkALError();
        }
        catch (LWJGLException lWJGLException) {
            this.errorMessage("Unable to initialize OpenAL.  Probable cause: OpenAL not supported.");
            this.printStackTrace(lWJGLException);
            throw new Exception(lWJGLException.getMessage(), 101);
        }
        if (bl) {
            this.importantMessage("OpenAL did not initialize properly!");
        } else {
            this.message("OpenAL initialized.");
        }
        this.listenerPositionAL = BufferUtils.createFloatBuffer(3).put(new float[]{this.listener.position.x, this.listener.position.y, this.listener.position.z});
        this.listenerOrientation = BufferUtils.createFloatBuffer(6).put(new float[]{this.listener.lookAt.x, this.listener.lookAt.y, this.listener.lookAt.z, this.listener.up.x, this.listener.up.y, this.listener.up.z});
        this.listenerVelocity = BufferUtils.createFloatBuffer(3).put(new float[]{0.0f, 0.0f, 0.0f});
        this.listenerPositionAL.flip();
        this.listenerOrientation.flip();
        this.listenerVelocity.flip();
        AL10.alListener(4100, this.listenerPositionAL);
        bl = this.checkALError() || bl;
        AL10.alListener(4111, this.listenerOrientation);
        bl = this.checkALError() || bl;
        AL10.alListener(4102, this.listenerVelocity);
        bl = this.checkALError() || bl;
        AL10.alDopplerFactor(SoundSystemConfig.getDopplerFactor());
        bl = this.checkALError() || bl;
        AL10.alDopplerVelocity(SoundSystemConfig.getDopplerVelocity());
        boolean bl2 = bl = this.checkALError() || bl;
        if (bl) {
            this.importantMessage("OpenAL did not initialize properly!");
            throw new Exception("Problem encountered while loading OpenAL or creating the listener.  Probable cause:  OpenAL not supported", 101);
        }
        super.init();
        ChannelLWJGLOpenAL channelLWJGLOpenAL = (ChannelLWJGLOpenAL)this.normalChannels.get(1);
        try {
            AL10.alSourcef(channelLWJGLOpenAL.ALSource.get(0), 4099, 1.0f);
            if (this.checkALError()) {
                LibraryLWJGLOpenAL.alPitchSupported(true, false);
                throw new Exception("OpenAL: AL_PITCH not supported.", 108);
            }
            LibraryLWJGLOpenAL.alPitchSupported(true, true);
        }
        catch (java.lang.Exception exception) {
            LibraryLWJGLOpenAL.alPitchSupported(true, false);
            throw new Exception("OpenAL: AL_PITCH not supported.", 108);
        }
    }

    public static boolean libraryCompatible() {
        if (AL.isCreated()) {
            return true;
        }
        try {
            AL.create();
        }
        catch (java.lang.Exception exception) {
            return false;
        }
        try {
            AL.destroy();
        }
        catch (java.lang.Exception exception) {
            // empty catch block
        }
        return true;
    }

    @Override
    protected Channel createChannel(int n) {
        IntBuffer intBuffer = BufferUtils.createIntBuffer(1);
        try {
            AL10.alGenSources(intBuffer);
        }
        catch (java.lang.Exception exception) {
            AL10.alGetError();
            return null;
        }
        if (AL10.alGetError() != 0) {
            return null;
        }
        ChannelLWJGLOpenAL channelLWJGLOpenAL = new ChannelLWJGLOpenAL(n, intBuffer);
        return channelLWJGLOpenAL;
    }

    @Override
    public void cleanup() {
        super.cleanup();
        Set set = this.bufferMap.keySet();
        for (String string : set) {
            IntBuffer intBuffer = this.ALBufferMap.get(string);
            if (intBuffer == null) continue;
            AL10.alDeleteBuffers(intBuffer);
            this.checkALError();
            intBuffer.clear();
        }
        this.bufferMap.clear();
        AL.destroy();
        this.bufferMap = null;
        this.listenerPositionAL = null;
        this.listenerOrientation = null;
        this.listenerVelocity = null;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public boolean loadSound(FilenameURL filenameURL) {
        if (this.bufferMap == null) {
            this.bufferMap = new HashMap();
            this.importantMessage("Buffer Map was null in method 'loadSound'");
        }
        if (this.ALBufferMap == null) {
            this.ALBufferMap = new HashMap();
            this.importantMessage("Open AL Buffer Map was null in method'loadSound'");
        }
        if (this.errorCheck(filenameURL == null, "Filename/URL not specified in method 'loadSound'")) {
            return false;
        }
        if (this.bufferMap.get(filenameURL.getFilename()) != null) {
            return true;
        }
        ICodec iCodec = SoundSystemConfig.getCodec(filenameURL.getFilename());
        if (this.errorCheck(iCodec == null, "No codec found for file '" + filenameURL.getFilename() + "' in method 'loadSound'")) {
            return false;
        }
        iCodec.reverseByteOrder(true);
        URL uRL = filenameURL.getURL();
        if (this.errorCheck(uRL == null, "Unable to open file '" + filenameURL.getFilename() + "' in method 'loadSound'")) {
            return false;
        }
        iCodec.initialize(uRL);
        SoundBuffer soundBuffer = iCodec.readAll();
        iCodec.cleanup();
        iCodec = null;
        if (this.errorCheck(soundBuffer == null, "Sound buffer null in method 'loadSound'")) {
            return false;
        }
        this.bufferMap.put(filenameURL.getFilename(), soundBuffer);
        AudioFormat audioFormat = soundBuffer.audioFormat;
        int n = 0;
        if (audioFormat.getChannels() == 1) {
            if (audioFormat.getSampleSizeInBits() == 8) {
                n = 4352;
            } else {
                if (audioFormat.getSampleSizeInBits() != 16) {
                    this.errorMessage("Illegal sample size in method 'loadSound'");
                    return false;
                }
                n = 4353;
            }
        } else {
            if (audioFormat.getChannels() != 2) {
                this.errorMessage("File neither mono nor stereo in method 'loadSound'");
                return false;
            }
            if (audioFormat.getSampleSizeInBits() == 8) {
                n = 4354;
            } else {
                if (audioFormat.getSampleSizeInBits() != 16) {
                    this.errorMessage("Illegal sample size in method 'loadSound'");
                    return false;
                }
                n = 4355;
            }
        }
        IntBuffer intBuffer = BufferUtils.createIntBuffer(1);
        AL10.alGenBuffers(intBuffer);
        if (this.errorCheck(AL10.alGetError() != 0, "alGenBuffers error when loading " + filenameURL.getFilename())) {
            return false;
        }
        AL10.alBufferData(intBuffer.get(0), n, (ByteBuffer)BufferUtils.createByteBuffer(soundBuffer.audioData.length).put(soundBuffer.audioData).flip(), (int)audioFormat.getSampleRate());
        if (this.errorCheck(AL10.alGetError() != 0, "alBufferData error when loading " + filenameURL.getFilename()) && this.errorCheck(intBuffer == null, "Sound buffer was not created for " + filenameURL.getFilename())) {
            return false;
        }
        this.ALBufferMap.put(filenameURL.getFilename(), intBuffer);
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public boolean loadSound(SoundBuffer soundBuffer, String string) {
        if (this.bufferMap == null) {
            this.bufferMap = new HashMap();
            this.importantMessage("Buffer Map was null in method 'loadSound'");
        }
        if (this.ALBufferMap == null) {
            this.ALBufferMap = new HashMap();
            this.importantMessage("Open AL Buffer Map was null in method'loadSound'");
        }
        if (this.errorCheck(string == null, "Identifier not specified in method 'loadSound'")) {
            return false;
        }
        if (this.bufferMap.get(string) != null) {
            return true;
        }
        if (this.errorCheck(soundBuffer == null, "Sound buffer null in method 'loadSound'")) {
            return false;
        }
        this.bufferMap.put(string, soundBuffer);
        AudioFormat audioFormat = soundBuffer.audioFormat;
        int n = 0;
        if (audioFormat.getChannels() == 1) {
            if (audioFormat.getSampleSizeInBits() == 8) {
                n = 4352;
            } else {
                if (audioFormat.getSampleSizeInBits() != 16) {
                    this.errorMessage("Illegal sample size in method 'loadSound'");
                    return false;
                }
                n = 4353;
            }
        } else {
            if (audioFormat.getChannels() != 2) {
                this.errorMessage("File neither mono nor stereo in method 'loadSound'");
                return false;
            }
            if (audioFormat.getSampleSizeInBits() == 8) {
                n = 4354;
            } else {
                if (audioFormat.getSampleSizeInBits() != 16) {
                    this.errorMessage("Illegal sample size in method 'loadSound'");
                    return false;
                }
                n = 4355;
            }
        }
        IntBuffer intBuffer = BufferUtils.createIntBuffer(1);
        AL10.alGenBuffers(intBuffer);
        if (this.errorCheck(AL10.alGetError() != 0, "alGenBuffers error when saving " + string)) {
            return false;
        }
        AL10.alBufferData(intBuffer.get(0), n, (ByteBuffer)BufferUtils.createByteBuffer(soundBuffer.audioData.length).put(soundBuffer.audioData).flip(), (int)audioFormat.getSampleRate());
        if (this.errorCheck(AL10.alGetError() != 0, "alBufferData error when saving " + string) && this.errorCheck(intBuffer == null, "Sound buffer was not created for " + string)) {
            return false;
        }
        this.ALBufferMap.put(string, intBuffer);
        return true;
    }

    @Override
    public void unloadSound(String string) {
        this.ALBufferMap.remove(string);
        super.unloadSound(string);
    }

    @Override
    public void setMasterVolume(float f) {
        super.setMasterVolume(f);
        AL10.alListenerf(4106, f);
        this.checkALError();
    }

    @Override
    public void newSource(boolean bl, boolean bl2, boolean bl3, String string, FilenameURL filenameURL, float f, float f2, float f3, int n, float f4, boolean bl4) {
        IntBuffer intBuffer = null;
        if (!bl2) {
            intBuffer = this.ALBufferMap.get(filenameURL.getFilename());
            if (intBuffer == null && !this.loadSound(filenameURL)) {
                this.errorMessage("Source '" + string + "' was not created because an error occurred while loading " + filenameURL.getFilename());
                return;
            }
            intBuffer = this.ALBufferMap.get(filenameURL.getFilename());
            if (intBuffer == null) {
                this.errorMessage("Source '" + string + "' was not created because a sound buffer was not found for " + filenameURL.getFilename());
                return;
            }
        }
        SoundBuffer soundBuffer = null;
        if (!bl2) {
            soundBuffer = (SoundBuffer)this.bufferMap.get(filenameURL.getFilename());
            if (soundBuffer == null && !this.loadSound(filenameURL)) {
                this.errorMessage("Source '" + string + "' was not created because an error occurred while loading " + filenameURL.getFilename());
                return;
            }
            soundBuffer = (SoundBuffer)this.bufferMap.get(filenameURL.getFilename());
            if (soundBuffer == null) {
                this.errorMessage("Source '" + string + "' was not created because audio data was not found for " + filenameURL.getFilename());
                return;
            }
        }
        this.sourceMap.put(string, new SourceLWJGLOpenAL(this.listenerPositionAL, intBuffer, bl, bl2, bl3, string, filenameURL, soundBuffer, f, f2, f3, n, f4, false, bl4));
    }

    @Override
    public void rawDataStream(AudioFormat audioFormat, boolean bl, String string, float f, float f2, float f3, int n, float f4) {
        this.sourceMap.put(string, new SourceLWJGLOpenAL(this.listenerPositionAL, audioFormat, bl, string, f, f2, f3, n, f4));
    }

    @Override
    public void quickPlay(boolean bl, boolean bl2, boolean bl3, String string, FilenameURL filenameURL, float f, float f2, float f3, int n, float f4, boolean bl4) {
        IntBuffer intBuffer = null;
        if (!bl2) {
            intBuffer = this.ALBufferMap.get(filenameURL.getFilename());
            if (intBuffer == null) {
                this.loadSound(filenameURL);
            }
            if ((intBuffer = this.ALBufferMap.get(filenameURL.getFilename())) == null) {
                this.errorMessage("Sound buffer was not created for " + filenameURL.getFilename());
                return;
            }
        }
        SoundBuffer soundBuffer = null;
        if (!bl2) {
            soundBuffer = (SoundBuffer)this.bufferMap.get(filenameURL.getFilename());
            if (soundBuffer == null && !this.loadSound(filenameURL)) {
                this.errorMessage("Source '" + string + "' was not created because an error occurred while loading " + filenameURL.getFilename());
                return;
            }
            soundBuffer = (SoundBuffer)this.bufferMap.get(filenameURL.getFilename());
            if (soundBuffer == null) {
                this.errorMessage("Source '" + string + "' was not created because audio data was not found for " + filenameURL.getFilename());
                return;
            }
        }
        SourceLWJGLOpenAL sourceLWJGLOpenAL = new SourceLWJGLOpenAL(this.listenerPositionAL, intBuffer, bl, bl2, bl3, string, filenameURL, soundBuffer, f, f2, f3, n, f4, false, false);
        this.sourceMap.put(string, sourceLWJGLOpenAL);
        this.play(sourceLWJGLOpenAL);
        if (bl4) {
            sourceLWJGLOpenAL.setTemporary(true);
        }
    }

    @Override
    public void copySources(HashMap<String, Source> hashMap) {
        if (hashMap == null) {
            return;
        }
        Set<String> set = hashMap.keySet();
        Iterator<String> iterator2 = set.iterator();
        if (this.bufferMap == null) {
            this.bufferMap = new HashMap();
            this.importantMessage("Buffer Map was null in method 'copySources'");
        }
        if (this.ALBufferMap == null) {
            this.ALBufferMap = new HashMap();
            this.importantMessage("Open AL Buffer Map was null in method'copySources'");
        }
        this.sourceMap.clear();
        while (iterator2.hasNext()) {
            String string = iterator2.next();
            Source source = hashMap.get(string);
            if (source == null) continue;
            SoundBuffer soundBuffer = null;
            if (!source.toStream) {
                this.loadSound(source.filenameURL);
                soundBuffer = (SoundBuffer)this.bufferMap.get(source.filenameURL.getFilename());
            }
            if (!source.toStream && soundBuffer == null) continue;
            this.sourceMap.put(string, new SourceLWJGLOpenAL(this.listenerPositionAL, this.ALBufferMap.get(source.filenameURL.getFilename()), source, soundBuffer));
        }
    }

    @Override
    public void setListenerPosition(float f, float f2, float f3) {
        super.setListenerPosition(f, f2, f3);
        this.listenerPositionAL.put(0, f);
        this.listenerPositionAL.put(1, f2);
        this.listenerPositionAL.put(2, f3);
        AL10.alListener(4100, this.listenerPositionAL);
        this.checkALError();
    }

    @Override
    public void setListenerAngle(float f) {
        super.setListenerAngle(f);
        this.listenerOrientation.put(0, this.listener.lookAt.x);
        this.listenerOrientation.put(2, this.listener.lookAt.z);
        AL10.alListener(4111, this.listenerOrientation);
        this.checkALError();
    }

    @Override
    public void setListenerOrientation(float f, float f2, float f3, float f4, float f5, float f6) {
        super.setListenerOrientation(f, f2, f3, f4, f5, f6);
        this.listenerOrientation.put(0, f);
        this.listenerOrientation.put(1, f2);
        this.listenerOrientation.put(2, f3);
        this.listenerOrientation.put(3, f4);
        this.listenerOrientation.put(4, f5);
        this.listenerOrientation.put(5, f6);
        AL10.alListener(4111, this.listenerOrientation);
        this.checkALError();
    }

    @Override
    public void setListenerData(ListenerData listenerData) {
        super.setListenerData(listenerData);
        this.listenerPositionAL.put(0, listenerData.position.x);
        this.listenerPositionAL.put(1, listenerData.position.y);
        this.listenerPositionAL.put(2, listenerData.position.z);
        AL10.alListener(4100, this.listenerPositionAL);
        this.checkALError();
        this.listenerOrientation.put(0, listenerData.lookAt.x);
        this.listenerOrientation.put(1, listenerData.lookAt.y);
        this.listenerOrientation.put(2, listenerData.lookAt.z);
        this.listenerOrientation.put(3, listenerData.up.x);
        this.listenerOrientation.put(4, listenerData.up.y);
        this.listenerOrientation.put(5, listenerData.up.z);
        AL10.alListener(4111, this.listenerOrientation);
        this.checkALError();
        this.listenerVelocity.put(0, listenerData.velocity.x);
        this.listenerVelocity.put(1, listenerData.velocity.y);
        this.listenerVelocity.put(2, listenerData.velocity.z);
        AL10.alListener(4102, this.listenerVelocity);
        this.checkALError();
    }

    @Override
    public void setListenerVelocity(float f, float f2, float f3) {
        super.setListenerVelocity(f, f2, f3);
        this.listenerVelocity.put(0, this.listener.velocity.x);
        this.listenerVelocity.put(1, this.listener.velocity.y);
        this.listenerVelocity.put(2, this.listener.velocity.z);
        AL10.alListener(4102, this.listenerVelocity);
    }

    @Override
    public void dopplerChanged() {
        super.dopplerChanged();
        AL10.alDopplerFactor(SoundSystemConfig.getDopplerFactor());
        this.checkALError();
        AL10.alDopplerVelocity(SoundSystemConfig.getDopplerVelocity());
        this.checkALError();
    }

    private boolean checkALError() {
        switch (AL10.alGetError()) {
            case 0: {
                return false;
            }
            case 40961: {
                this.errorMessage("Invalid name parameter.");
                return true;
            }
            case 40962: {
                this.errorMessage("Invalid parameter.");
                return true;
            }
            case 40963: {
                this.errorMessage("Invalid enumerated parameter value.");
                return true;
            }
            case 40964: {
                this.errorMessage("Illegal call.");
                return true;
            }
            case 40965: {
                this.errorMessage("Unable to allocate memory.");
                return true;
            }
        }
        this.errorMessage("An unrecognized error occurred.");
        return true;
    }

    public static boolean alPitchSupported() {
        return LibraryLWJGLOpenAL.alPitchSupported(false, false);
    }

    private static synchronized boolean alPitchSupported(boolean bl, boolean bl2) {
        if (bl) {
            alPitchSupported = bl2;
        }
        return alPitchSupported;
    }

    public static String getTitle() {
        return "LWJGL OpenAL";
    }

    public static String getDescription() {
        return "The LWJGL binding of OpenAL.  For more information, see http://www.lwjgl.org";
    }

    @Override
    public String getClassName() {
        return "LibraryLWJGLOpenAL";
    }

    public static class Exception
    extends SoundSystemException {
        private static final long serialVersionUID = -7502452059037798035L;
        public static final int CREATE = 101;
        public static final int INVALID_NAME = 102;
        public static final int INVALID_ENUM = 103;
        public static final int INVALID_VALUE = 104;
        public static final int INVALID_OPERATION = 105;
        public static final int OUT_OF_MEMORY = 106;
        public static final int LISTENER = 107;
        public static final int NO_AL_PITCH = 108;

        public Exception(String string) {
            super(string);
        }

        public Exception(String string, int n) {
            super(string, n);
        }
    }
}

