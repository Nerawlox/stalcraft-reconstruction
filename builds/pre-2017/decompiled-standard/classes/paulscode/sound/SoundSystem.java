/*
 * Decompiled with CFR 0.152.
 */
package paulscode.sound;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Set;
import javax.sound.sampled.AudioFormat;
import mods.sound.SoundHooks;
import paulscode.sound.CommandObject;
import paulscode.sound.CommandThread;
import paulscode.sound.FilenameURL;
import paulscode.sound.Library;
import paulscode.sound.ListenerData;
import paulscode.sound.MidiChannel;
import paulscode.sound.SoundBuffer;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemException;
import paulscode.sound.SoundSystemLogger;
import paulscode.sound.Source;

public class SoundSystem {
    private static final boolean GET = false;
    private static final boolean SET = true;
    private static final boolean XXX = false;
    protected SoundSystemLogger logger = SoundSystemConfig.getLogger();
    protected Library soundLibrary;
    protected List<CommandObject> commandQueue;
    private List<CommandObject> sourcePlayList;
    protected CommandThread commandThread;
    public Random randomNumberGenerator;
    protected String className = "SoundSystem";
    private static Class currentLibrary = null;
    private static boolean initialized = false;
    private static SoundSystemException lastException = null;

    public SoundSystem() {
        if (this.logger == null) {
            this.logger = new SoundSystemLogger();
            SoundSystemConfig.setLogger(this.logger);
        }
        this.linkDefaultLibrariesAndCodecs();
        LinkedList<Class> linkedList = SoundSystemConfig.getLibraries();
        if (linkedList != null) {
            ListIterator listIterator = linkedList.listIterator();
            while (listIterator.hasNext()) {
                Class clazz = (Class)listIterator.next();
                try {
                    this.init(clazz);
                    return;
                }
                catch (SoundSystemException soundSystemException) {
                    this.logger.printExceptionMessage(soundSystemException, 1);
                }
            }
        }
        try {
            this.init(Library.class);
            return;
        }
        catch (SoundSystemException soundSystemException) {
            this.logger.printExceptionMessage(soundSystemException, 1);
            return;
        }
    }

    public SoundSystem(Class clazz) throws SoundSystemException {
        if (this.logger == null) {
            this.logger = new SoundSystemLogger();
            SoundSystemConfig.setLogger(this.logger);
        }
        this.linkDefaultLibrariesAndCodecs();
        this.init(clazz);
    }

    protected void linkDefaultLibrariesAndCodecs() {
    }

    protected void init(Class clazz) throws SoundSystemException {
        this.message("", 0);
        this.message("Starting up " + this.className + "...", 0);
        this.randomNumberGenerator = new Random();
        this.commandQueue = new LinkedList<CommandObject>();
        this.sourcePlayList = new LinkedList<CommandObject>();
        this.commandThread = new CommandThread(this);
        this.commandThread.start();
        SoundSystem.snooze(200L);
        this.newLibrary(clazz);
        this.message("", 0);
    }

    public void cleanup() {
        boolean bl = false;
        this.message("", 0);
        this.message(this.className + " shutting down...", 0);
        try {
            this.commandThread.kill();
            this.commandThread.interrupt();
        }
        catch (Exception exception) {
            bl = true;
        }
        if (!bl) {
            for (int i = 0; i < 50 && this.commandThread.alive(); ++i) {
                SoundSystem.snooze(100L);
            }
        }
        if (bl || this.commandThread.alive()) {
            this.errorMessage("Command thread did not die!", 0);
            this.message("Ignoring errors... continuing clean-up.", 0);
        }
        SoundSystem.initialized(true, false);
        SoundSystem.currentLibrary(true, null);
        try {
            if (this.soundLibrary != null) {
                this.soundLibrary.cleanup();
            }
        }
        catch (Exception exception) {
            this.errorMessage("Problem during Library.cleanup()!", 0);
            this.message("Ignoring errors... continuing clean-up.", 0);
        }
        try {
            if (this.commandQueue != null) {
                this.commandQueue.clear();
            }
        }
        catch (Exception exception) {
            this.errorMessage("Unable to clear the command queue!", 0);
            this.message("Ignoring errors... continuing clean-up.", 0);
        }
        try {
            if (this.sourcePlayList != null) {
                this.sourcePlayList.clear();
            }
        }
        catch (Exception exception) {
            this.errorMessage("Unable to clear the source management list!", 0);
            this.message("Ignoring errors... continuing clean-up.", 0);
        }
        this.randomNumberGenerator = null;
        this.soundLibrary = null;
        this.commandQueue = null;
        this.sourcePlayList = null;
        this.commandThread = null;
        this.importantMessage("Author: Paul Lamb, www.paulscode.com", 1);
        this.message("", 0);
    }

    public void interruptCommandThread() {
        if (this.commandThread == null) {
            this.errorMessage("Command Thread null in method 'interruptCommandThread'", 0);
            return;
        }
        this.commandThread.interrupt();
    }

    public void loadSound(String string) {
        this.CommandQueue(new CommandObject(2, new FilenameURL(string)));
        this.commandThread.interrupt();
    }

    public void loadSound(URL uRL, String string) {
        this.CommandQueue(new CommandObject(2, new FilenameURL(uRL, string)));
        this.commandThread.interrupt();
    }

    public void loadSound(byte[] byArray, AudioFormat audioFormat, String string) {
        this.CommandQueue(new CommandObject(3, string, new SoundBuffer(byArray, audioFormat)));
        this.commandThread.interrupt();
    }

    public void unloadSound(String string) {
        this.CommandQueue(new CommandObject(4, string));
        this.commandThread.interrupt();
    }

    public void queueSound(String string, String string2) {
        this.CommandQueue(new CommandObject(5, string, new FilenameURL(string2)));
        this.commandThread.interrupt();
    }

    public void queueSound(String string, URL uRL, String string2) {
        this.CommandQueue(new CommandObject(5, string, new FilenameURL(uRL, string2)));
        this.commandThread.interrupt();
    }

    public void dequeueSound(String string, String string2) {
        this.CommandQueue(new CommandObject(6, string, string2));
        this.commandThread.interrupt();
    }

    public void fadeOut(String string, String string2, long l) {
        FilenameURL filenameURL = null;
        if (string2 != null) {
            filenameURL = new FilenameURL(string2);
        }
        this.CommandQueue(new CommandObject(7, string, filenameURL, l));
        this.commandThread.interrupt();
    }

    public void fadeOut(String string, URL uRL, String string2, long l) {
        FilenameURL filenameURL = null;
        if (uRL != null && string2 != null) {
            filenameURL = new FilenameURL(uRL, string2);
        }
        this.CommandQueue(new CommandObject(7, string, filenameURL, l));
        this.commandThread.interrupt();
    }

    public void fadeOutIn(String string, String string2, long l, long l2) {
        this.CommandQueue(new CommandObject(8, string, new FilenameURL(string2), l, l2));
        this.commandThread.interrupt();
    }

    public void fadeOutIn(String string, URL uRL, String string2, long l, long l2) {
        this.CommandQueue(new CommandObject(8, string, new FilenameURL(uRL, string2), l, l2));
        this.commandThread.interrupt();
    }

    public void checkFadeVolumes() {
        this.CommandQueue(new CommandObject(9));
        this.commandThread.interrupt();
    }

    public void backgroundMusic(String string, String string2, boolean bl) {
        this.CommandQueue(new CommandObject(12, true, true, bl, string, new FilenameURL(string2), 0.0f, 0.0f, 0.0f, 0, 0.0f, false));
        this.CommandQueue(new CommandObject(24, string));
        this.commandThread.interrupt();
    }

    public void backgroundMusic(String string, URL uRL, String string2, boolean bl) {
        this.CommandQueue(new CommandObject(12, true, true, bl, string, new FilenameURL(uRL, string2), 0.0f, 0.0f, 0.0f, 0, 0.0f, false));
        this.CommandQueue(new CommandObject(24, string));
        this.commandThread.interrupt();
    }

    public void newSource(boolean bl, String string, String string2, boolean bl2, float f, float f2, float f3, int n, float f4) {
        this.CommandQueue(new CommandObject(10, bl, false, bl2, string, new FilenameURL(string2), f, f2, f3, n, f4, false));
        this.commandThread.interrupt();
    }

    public void newSource(boolean bl, String string, String string2, boolean bl2, float f, float f2, float f3, int n, float f4, boolean bl3) {
        this.CommandQueue(new CommandObject(10, bl, false, bl2, string, new FilenameURL(string2), f, f2, f3, n, f4, bl3));
        this.commandThread.interrupt();
    }

    public void newSource(boolean bl, String string, URL uRL, String string2, boolean bl2, float f, float f2, float f3, int n, float f4) {
        this.CommandQueue(new CommandObject(10, bl, false, bl2, string, new FilenameURL(uRL, string2), f, f2, f3, n, f4, false));
        this.commandThread.interrupt();
    }

    public void newSource(boolean bl, String string, URL uRL, String string2, boolean bl2, float f, float f2, float f3, int n, float f4, boolean bl3) {
        this.CommandQueue(new CommandObject(10, bl, false, bl2, string, new FilenameURL(uRL, string2), f, f2, f3, n, f4, bl3));
        this.commandThread.interrupt();
    }

    public void newStreamingSource(boolean bl, String string, String string2, boolean bl2, float f, float f2, float f3, int n, float f4) {
        this.CommandQueue(new CommandObject(10, bl, true, bl2, string, new FilenameURL(string2), f, f2, f3, n, f4, false));
        this.commandThread.interrupt();
    }

    public void newStreamingSource(boolean bl, String string, URL uRL, String string2, boolean bl2, float f, float f2, float f3, int n, float f4) {
        this.CommandQueue(new CommandObject(10, bl, true, bl2, string, new FilenameURL(uRL, string2), f, f2, f3, n, f4, false));
        this.commandThread.interrupt();
    }

    public void rawDataStream(AudioFormat audioFormat, boolean bl, String string, float f, float f2, float f3, int n, float f4) {
        this.CommandQueue(new CommandObject(11, audioFormat, bl, string, f, f2, f3, n, f4));
        this.commandThread.interrupt();
    }

    public String quickPlay(boolean bl, String string, boolean bl2, float f, float f2, float f3, int n, float f4) {
        String string2 = "Source_" + this.randomNumberGenerator.nextInt() + "_" + this.randomNumberGenerator.nextInt();
        this.CommandQueue(new CommandObject(12, bl, false, bl2, string2, new FilenameURL(string), f, f2, f3, n, f4, true));
        this.CommandQueue(new CommandObject(24, string2));
        this.commandThread.interrupt();
        return string2;
    }

    public String quickPlay(boolean bl, URL uRL, String string, boolean bl2, float f, float f2, float f3, int n, float f4) {
        String string2 = "Source_" + this.randomNumberGenerator.nextInt() + "_" + this.randomNumberGenerator.nextInt();
        this.CommandQueue(new CommandObject(12, bl, false, bl2, string2, new FilenameURL(uRL, string), f, f2, f3, n, f4, true));
        this.CommandQueue(new CommandObject(24, string2));
        this.commandThread.interrupt();
        return string2;
    }

    public String quickStream(boolean bl, String string, boolean bl2, float f, float f2, float f3, int n, float f4) {
        String string2 = "Source_" + this.randomNumberGenerator.nextInt() + "_" + this.randomNumberGenerator.nextInt();
        this.CommandQueue(new CommandObject(12, bl, true, bl2, string2, new FilenameURL(string), f, f2, f3, n, f4, true));
        this.CommandQueue(new CommandObject(24, string2));
        this.commandThread.interrupt();
        return string2;
    }

    public String quickStream(boolean bl, URL uRL, String string, boolean bl2, float f, float f2, float f3, int n, float f4) {
        String string2 = "Source_" + this.randomNumberGenerator.nextInt() + "_" + this.randomNumberGenerator.nextInt();
        this.CommandQueue(new CommandObject(12, bl, true, bl2, string2, new FilenameURL(uRL, string), f, f2, f3, n, f4, true));
        this.CommandQueue(new CommandObject(24, string2));
        this.commandThread.interrupt();
        return string2;
    }

    public void setPosition(String string, float f, float f2, float f3) {
        this.CommandQueue(new CommandObject(13, string, f, f2, f3));
        this.commandThread.interrupt();
    }

    public void setVolume(String string, float f) {
        this.CommandQueue(new CommandObject(14, string, f));
        this.commandThread.interrupt();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public float getVolume(String string) {
        Object object = SoundSystemConfig.THREAD_SYNC;
        synchronized (object) {
            if (this.soundLibrary != null) {
                return this.soundLibrary.getVolume(string);
            }
            return 0.0f;
        }
    }

    public void setPitch(String string, float f) {
        this.CommandQueue(new CommandObject(15, string, f));
        this.commandThread.interrupt();
    }

    public float getPitch(String string) {
        if (this.soundLibrary != null) {
            return this.soundLibrary.getPitch(string);
        }
        return 1.0f;
    }

    public void setPriority(String string, boolean bl) {
        this.CommandQueue(new CommandObject(16, string, bl));
        this.commandThread.interrupt();
    }

    public void setLooping(String string, boolean bl) {
        this.CommandQueue(new CommandObject(17, string, bl));
        this.commandThread.interrupt();
    }

    public void setAttenuation(String string, int n) {
        this.CommandQueue(new CommandObject(18, string, n));
        this.commandThread.interrupt();
    }

    public void setDistOrRoll(String string, float f) {
        this.CommandQueue(new CommandObject(19, string, f));
        this.commandThread.interrupt();
    }

    public void changeDopplerFactor(float f) {
        this.CommandQueue(new CommandObject(20, f));
        this.commandThread.interrupt();
    }

    public void changeDopplerVelocity(float f) {
        this.CommandQueue(new CommandObject(21, f));
        this.commandThread.interrupt();
    }

    public void setVelocity(String string, float f, float f2, float f3) {
        this.CommandQueue(new CommandObject(22, string, f, f2, f3));
        this.commandThread.interrupt();
    }

    public void setListenerVelocity(float f, float f2, float f3) {
        this.CommandQueue(new CommandObject(23, f, f2, f3));
        this.commandThread.interrupt();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public float millisecondsPlayed(String string) {
        Object object = SoundSystemConfig.THREAD_SYNC;
        synchronized (object) {
            return this.soundLibrary.millisecondsPlayed(string);
        }
    }

    public void feedRawAudioData(String string, byte[] byArray) {
        this.CommandQueue(new CommandObject(25, string, byArray));
        this.commandThread.interrupt();
    }

    public void play(String string) {
        this.CommandQueue(new CommandObject(24, string));
        this.commandThread.interrupt();
    }

    public void pause(String string) {
        this.CommandQueue(new CommandObject(26, string));
        this.commandThread.interrupt();
    }

    public void stop(String string) {
        this.CommandQueue(new CommandObject(27, string));
        this.commandThread.interrupt();
    }

    public void rewind(String string) {
        this.CommandQueue(new CommandObject(28, string));
        this.commandThread.interrupt();
    }

    public void flush(String string) {
        this.CommandQueue(new CommandObject(29, string));
        this.commandThread.interrupt();
    }

    public void cull(String string) {
        this.CommandQueue(new CommandObject(30, string));
        this.commandThread.interrupt();
    }

    public void activate(String string) {
        this.CommandQueue(new CommandObject(31, string));
        this.commandThread.interrupt();
    }

    public void setTemporary(String string, boolean bl) {
        this.CommandQueue(new CommandObject(32, string, bl));
        this.commandThread.interrupt();
    }

    public void removeSource(String string) {
        this.CommandQueue(new CommandObject(33, string));
        this.commandThread.interrupt();
    }

    public void moveListener(float f, float f2, float f3) {
        this.CommandQueue(new CommandObject(34, f, f2, f3));
        this.commandThread.interrupt();
    }

    public void setListenerPosition(float f, float f2, float f3) {
        this.CommandQueue(new CommandObject(35, f, f2, f3));
        this.commandThread.interrupt();
    }

    public void turnListener(float f) {
        this.CommandQueue(new CommandObject(36, f));
        this.commandThread.interrupt();
    }

    public void setListenerAngle(float f) {
        this.CommandQueue(new CommandObject(37, f));
        this.commandThread.interrupt();
    }

    public void setListenerOrientation(float f, float f2, float f3, float f4, float f5, float f6) {
        this.CommandQueue(new CommandObject(38, f, f2, f3, f4, f5, f6));
        this.commandThread.interrupt();
    }

    public void setMasterVolume(float f) {
        this.CommandQueue(new CommandObject(39, f));
        this.commandThread.interrupt();
    }

    public float getMasterVolume() {
        return SoundSystemConfig.getMasterGain();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ListenerData getListenerData() {
        Object object = SoundSystemConfig.THREAD_SYNC;
        synchronized (object) {
            return this.soundLibrary.getListenerData();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean switchLibrary(Class clazz) throws SoundSystemException {
        Object object = SoundSystemConfig.THREAD_SYNC;
        synchronized (object) {
            SoundSystem.initialized(true, false);
            HashMap<String, Source> hashMap = null;
            ListenerData listenerData = null;
            boolean bl = false;
            MidiChannel midiChannel = null;
            FilenameURL filenameURL = null;
            String string = "";
            boolean bl2 = true;
            if (this.soundLibrary != null) {
                SoundSystem.currentLibrary(true, null);
                hashMap = this.copySources(this.soundLibrary.getSources());
                listenerData = this.soundLibrary.getListenerData();
                midiChannel = this.soundLibrary.getMidiChannel();
                if (midiChannel != null) {
                    bl = true;
                    bl2 = midiChannel.getLooping();
                    string = midiChannel.getSourcename();
                    filenameURL = midiChannel.getFilenameURL();
                }
                this.soundLibrary.cleanup();
                this.soundLibrary = null;
            }
            this.message("", 0);
            this.message("Switching to " + SoundSystemConfig.getLibraryTitle(clazz), 0);
            this.message("(" + SoundSystemConfig.getLibraryDescription(clazz) + ")", 1);
            try {
                this.soundLibrary = (Library)clazz.newInstance();
            }
            catch (InstantiationException instantiationException) {
                this.errorMessage("The specified library did not load properly", 1);
            }
            catch (IllegalAccessException illegalAccessException) {
                this.errorMessage("The specified library did not load properly", 1);
            }
            catch (ExceptionInInitializerError exceptionInInitializerError) {
                this.errorMessage("The specified library did not load properly", 1);
            }
            catch (SecurityException securityException) {
                this.errorMessage("The specified library did not load properly", 1);
            }
            if (this.errorCheck(this.soundLibrary == null, "Library null after initialization in method 'switchLibrary'", 1)) {
                SoundSystemException soundSystemException = new SoundSystemException(this.className + " did not load properly.  Library was null after initialization.", 4);
                SoundSystem.lastException(true, soundSystemException);
                SoundSystem.initialized(true, true);
                throw soundSystemException;
            }
            try {
                this.soundLibrary.init();
            }
            catch (SoundSystemException soundSystemException) {
                SoundSystem.lastException(true, soundSystemException);
                SoundSystem.initialized(true, true);
                throw soundSystemException;
            }
            this.soundLibrary.setListenerData(listenerData);
            if (bl) {
                if (midiChannel != null) {
                    midiChannel.cleanup();
                }
                midiChannel = new MidiChannel(bl2, string, filenameURL);
                this.soundLibrary.setMidiChannel(midiChannel);
            }
            this.soundLibrary.copySources(hashMap);
            this.message("", 0);
            SoundSystem.lastException(true, null);
            SoundSystem.initialized(true, true);
            return true;
        }
    }

    public boolean newLibrary(Class clazz) throws SoundSystemException {
        SoundSystem.initialized(true, false);
        this.CommandQueue(new CommandObject(40, clazz));
        this.commandThread.interrupt();
        for (int i = 0; !SoundSystem.initialized(false, false) && i < 100; ++i) {
            SoundSystem.snooze(400L);
            this.commandThread.interrupt();
        }
        if (!SoundSystem.initialized(false, false)) {
            SoundSystemException soundSystemException = new SoundSystemException(this.className + " did not load after 30 seconds.", 4);
            SoundSystem.lastException(true, soundSystemException);
            throw soundSystemException;
        }
        SoundSystemException soundSystemException = SoundSystem.lastException(false, null);
        if (soundSystemException != null) {
            throw soundSystemException;
        }
        return true;
    }

    private void CommandNewLibrary(Class clazz) {
        SoundSystem.initialized(true, false);
        String string = "Initializing ";
        if (this.soundLibrary != null) {
            SoundSystem.currentLibrary(true, null);
            string = "Switching to ";
            this.soundLibrary.cleanup();
            this.soundLibrary = null;
        }
        this.message(string + SoundSystemConfig.getLibraryTitle(clazz), 0);
        this.message("(" + SoundSystemConfig.getLibraryDescription(clazz) + ")", 1);
        try {
            this.soundLibrary = (Library)clazz.newInstance();
        }
        catch (InstantiationException instantiationException) {
            this.errorMessage("The specified library did not load properly", 1);
        }
        catch (IllegalAccessException illegalAccessException) {
            this.errorMessage("The specified library did not load properly", 1);
        }
        catch (ExceptionInInitializerError exceptionInInitializerError) {
            this.errorMessage("The specified library did not load properly", 1);
        }
        catch (SecurityException securityException) {
            this.errorMessage("The specified library did not load properly", 1);
        }
        if (this.errorCheck(this.soundLibrary == null, "Library null after initialization in method 'newLibrary'", 1)) {
            SoundSystem.lastException(true, new SoundSystemException(this.className + " did not load properly.  Library was null after initialization.", 4));
            this.importantMessage("Switching to silent mode", 1);
            try {
                this.soundLibrary = new Library();
            }
            catch (SoundSystemException soundSystemException) {
                SoundSystem.lastException(true, new SoundSystemException("Silent mode did not load properly.  Library was null after initialization.", 4));
                SoundSystem.initialized(true, true);
                return;
            }
        }
        try {
            this.soundLibrary.init();
        }
        catch (SoundSystemException soundSystemException) {
            SoundSystem.lastException(true, soundSystemException);
            SoundSystem.initialized(true, true);
            return;
        }
        SoundSystem.lastException(true, null);
        SoundSystem.initialized(true, true);
    }

    private void CommandInitialize() {
        try {
            if (this.errorCheck(this.soundLibrary == null, "Library null after initialization in method 'CommandInitialize'", 1)) {
                SoundSystemException soundSystemException = new SoundSystemException(this.className + " did not load properly.  Library was null after initialization.", 4);
                SoundSystem.lastException(true, soundSystemException);
                throw soundSystemException;
            }
            this.soundLibrary.init();
        }
        catch (SoundSystemException soundSystemException) {
            SoundSystem.lastException(true, soundSystemException);
            SoundSystem.initialized(true, true);
        }
    }

    private void CommandLoadSound(FilenameURL filenameURL) {
        if (this.soundLibrary != null) {
            this.soundLibrary.loadSound(filenameURL);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandLoadSound'", 0);
        }
    }

    private void CommandLoadSound(SoundBuffer soundBuffer, String string) {
        if (this.soundLibrary != null) {
            this.soundLibrary.loadSound(soundBuffer, string);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandLoadSound'", 0);
        }
    }

    private void CommandUnloadSound(String string) {
        if (this.soundLibrary != null) {
            this.soundLibrary.unloadSound(string);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandLoadSound'", 0);
        }
    }

    private void CommandQueueSound(String string, FilenameURL filenameURL) {
        if (this.soundLibrary != null) {
            this.soundLibrary.queueSound(string, filenameURL);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandQueueSound'", 0);
        }
    }

    private void CommandDequeueSound(String string, String string2) {
        if (this.soundLibrary != null) {
            this.soundLibrary.dequeueSound(string, string2);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandDequeueSound'", 0);
        }
    }

    private void CommandFadeOut(String string, FilenameURL filenameURL, long l) {
        if (this.soundLibrary != null) {
            this.soundLibrary.fadeOut(string, filenameURL, l);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandFadeOut'", 0);
        }
    }

    private void CommandFadeOutIn(String string, FilenameURL filenameURL, long l, long l2) {
        if (this.soundLibrary != null) {
            this.soundLibrary.fadeOutIn(string, filenameURL, l, l2);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandFadeOutIn'", 0);
        }
    }

    private void CommandCheckFadeVolumes() {
        if (this.soundLibrary != null) {
            this.soundLibrary.checkFadeVolumes();
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandCheckFadeVolumes'", 0);
        }
    }

    private void CommandNewSource(boolean bl, boolean bl2, boolean bl3, String string, FilenameURL filenameURL, float f, float f2, float f3, int n, float f4, boolean bl4) {
        if (this.soundLibrary != null) {
            if (filenameURL.getFilename().matches(SoundSystemConfig.EXTENSION_MIDI) && !SoundSystemConfig.midiCodec()) {
                this.soundLibrary.loadMidi(bl3, string, filenameURL);
            } else {
                this.soundLibrary.newSource(bl, bl2, bl3, string, filenameURL, f, f2, f3, n, f4, bl4);
            }
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandNewSource'", 0);
        }
    }

    private void CommandRawDataStream(AudioFormat audioFormat, boolean bl, String string, float f, float f2, float f3, int n, float f4) {
        if (this.soundLibrary != null) {
            this.soundLibrary.rawDataStream(audioFormat, bl, string, f, f2, f3, n, f4);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandRawDataStream'", 0);
        }
    }

    private void CommandQuickPlay(boolean bl, boolean bl2, boolean bl3, String string, FilenameURL filenameURL, float f, float f2, float f3, int n, float f4, boolean bl4) {
        if (this.soundLibrary != null) {
            if (filenameURL.getFilename().matches(SoundSystemConfig.EXTENSION_MIDI) && !SoundSystemConfig.midiCodec()) {
                this.soundLibrary.loadMidi(bl3, string, filenameURL);
            } else {
                this.soundLibrary.quickPlay(bl, bl2, bl3, string, filenameURL, f, f2, f3, n, f4, bl4);
            }
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandQuickPlay'", 0);
        }
    }

    private void CommandSetPosition(String string, float f, float f2, float f3) {
        if (this.soundLibrary != null) {
            this.soundLibrary.setPosition(string, f, f2, f3);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandMoveSource'", 0);
        }
    }

    private void CommandSetVolume(String string, float f) {
        if (this.soundLibrary != null) {
            this.soundLibrary.setVolume(string, f);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandSetVolume'", 0);
        }
    }

    private void CommandSetPitch(String string, float f) {
        if (this.soundLibrary != null) {
            this.soundLibrary.setPitch(string, f);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandSetPitch'", 0);
        }
    }

    private void CommandSetPriority(String string, boolean bl) {
        if (this.soundLibrary != null) {
            this.soundLibrary.setPriority(string, bl);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandSetPriority'", 0);
        }
    }

    private void CommandSetLooping(String string, boolean bl) {
        if (this.soundLibrary != null) {
            this.soundLibrary.setLooping(string, bl);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandSetLooping'", 0);
        }
    }

    private void CommandSetAttenuation(String string, int n) {
        if (this.soundLibrary != null) {
            this.soundLibrary.setAttenuation(string, n);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandSetAttenuation'", 0);
        }
    }

    private void CommandSetDistOrRoll(String string, float f) {
        if (this.soundLibrary != null) {
            this.soundLibrary.setDistOrRoll(string, f);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandSetDistOrRoll'", 0);
        }
    }

    private void CommandChangeDopplerFactor(float f) {
        if (this.soundLibrary != null) {
            SoundSystemConfig.setDopplerFactor(f);
            this.soundLibrary.dopplerChanged();
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandSetDopplerFactor'", 0);
        }
    }

    private void CommandChangeDopplerVelocity(float f) {
        if (this.soundLibrary != null) {
            SoundSystemConfig.setDopplerVelocity(f);
            this.soundLibrary.dopplerChanged();
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandSetDopplerFactor'", 0);
        }
    }

    private void CommandSetVelocity(String string, float f, float f2, float f3) {
        if (this.soundLibrary != null) {
            this.soundLibrary.setVelocity(string, f, f2, f3);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandVelocity'", 0);
        }
    }

    private void CommandSetListenerVelocity(float f, float f2, float f3) {
        if (this.soundLibrary != null) {
            this.soundLibrary.setListenerVelocity(f, f2, f3);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandSetListenerVelocity'", 0);
        }
    }

    private void CommandPlay(String string) {
        if (this.soundLibrary != null) {
            this.soundLibrary.play(string);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandPlay'", 0);
        }
    }

    private void CommandFeedRawAudioData(String string, byte[] byArray) {
        if (this.soundLibrary != null) {
            this.soundLibrary.feedRawAudioData(string, byArray);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandFeedRawAudioData'", 0);
        }
    }

    private void CommandPause(String string) {
        if (this.soundLibrary != null) {
            this.soundLibrary.pause(string);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandPause'", 0);
        }
    }

    private void CommandStop(String string) {
        if (this.soundLibrary != null) {
            this.soundLibrary.stop(string);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandStop'", 0);
        }
    }

    private void CommandRewind(String string) {
        if (this.soundLibrary != null) {
            this.soundLibrary.rewind(string);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandRewind'", 0);
        }
    }

    private void CommandFlush(String string) {
        if (this.soundLibrary != null) {
            this.soundLibrary.flush(string);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandFlush'", 0);
        }
    }

    private void CommandSetTemporary(String string, boolean bl) {
        if (this.soundLibrary != null) {
            this.soundLibrary.setTemporary(string, bl);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandSetActive'", 0);
        }
    }

    private void CommandRemoveSource(String string) {
        if (this.soundLibrary != null) {
            this.soundLibrary.removeSource(string);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandRemoveSource'", 0);
        }
    }

    private void CommandMoveListener(float f, float f2, float f3) {
        if (this.soundLibrary != null) {
            this.soundLibrary.moveListener(f, f2, f3);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandMoveListener'", 0);
        }
    }

    private void CommandSetListenerPosition(float f, float f2, float f3) {
        if (this.soundLibrary != null) {
            this.soundLibrary.setListenerPosition(f, f2, f3);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandSetListenerPosition'", 0);
        }
    }

    private void CommandTurnListener(float f) {
        if (this.soundLibrary != null) {
            this.soundLibrary.turnListener(f);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandTurnListener'", 0);
        }
    }

    private void CommandSetListenerAngle(float f) {
        if (this.soundLibrary != null) {
            this.soundLibrary.setListenerAngle(f);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandSetListenerAngle'", 0);
        }
    }

    private void CommandSetListenerOrientation(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.soundLibrary != null) {
            this.soundLibrary.setListenerOrientation(f, f2, f3, f4, f5, f6);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandSetListenerOrientation'", 0);
        }
    }

    private void CommandCull(String string) {
        if (this.soundLibrary != null) {
            this.soundLibrary.cull(string);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandCull'", 0);
        }
    }

    private void CommandActivate(String string) {
        if (this.soundLibrary != null) {
            this.soundLibrary.activate(string);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandActivate'", 0);
        }
    }

    private void CommandSetMasterVolume(float f) {
        if (this.soundLibrary != null) {
            this.soundLibrary.setMasterVolume(f);
        } else {
            this.errorMessage("Variable 'soundLibrary' null in method 'CommandSetMasterVolume'", 0);
        }
    }

    protected void ManageSources() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean CommandQueue(CommandObject commandObject) {
        boolean bl;
        SoundHooks.commandQueuePre(this, commandObject);
        Object object = SoundSystemConfig.THREAD_SYNC;
        synchronized (object) {
            CommandObject commandObject2;
            boolean bl2;
            if (commandObject == null) {
                bl2 = false;
            } else {
                if (this.commandQueue == null) {
                    // MONITOREXIT @DISABLED, blocks:[3, 53, 54] lbl8 : MonitorExitStatement: MONITOREXIT : var2_2
                    SoundHooks.commandQueuePost(this, commandObject);
                    return false;
                }
                this.commandQueue.add(commandObject);
                // MONITOREXIT @DISABLED, blocks:[3, 54] lbl13 : MonitorExitStatement: MONITOREXIT : var2_2
                SoundHooks.commandQueuePost(this, commandObject);
                return true;
            }
            block50: while (this.commandQueue != null && this.commandQueue.size() > 0) {
                commandObject2 = this.commandQueue.remove(0);
                if (commandObject2 == null) continue;
                switch (commandObject2.Command) {
                    case 1: {
                        this.CommandInitialize();
                        continue block50;
                    }
                    case 2: {
                        this.CommandLoadSound((FilenameURL)commandObject2.objectArgs[0]);
                        continue block50;
                    }
                    case 3: {
                        this.CommandLoadSound((SoundBuffer)commandObject2.objectArgs[0], commandObject2.stringArgs[0]);
                        continue block50;
                    }
                    case 4: {
                        this.CommandUnloadSound(commandObject2.stringArgs[0]);
                        continue block50;
                    }
                    case 5: {
                        this.CommandQueueSound(commandObject2.stringArgs[0], (FilenameURL)commandObject2.objectArgs[0]);
                        continue block50;
                    }
                    case 6: {
                        this.CommandDequeueSound(commandObject2.stringArgs[0], commandObject2.stringArgs[1]);
                        continue block50;
                    }
                    case 7: {
                        this.CommandFadeOut(commandObject2.stringArgs[0], (FilenameURL)commandObject2.objectArgs[0], commandObject2.longArgs[0]);
                        continue block50;
                    }
                    case 8: {
                        this.CommandFadeOutIn(commandObject2.stringArgs[0], (FilenameURL)commandObject2.objectArgs[0], commandObject2.longArgs[0], commandObject2.longArgs[1]);
                        continue block50;
                    }
                    case 9: {
                        this.CommandCheckFadeVolumes();
                        continue block50;
                    }
                    case 10: {
                        this.CommandNewSource(commandObject2.boolArgs[0], commandObject2.boolArgs[1], commandObject2.boolArgs[2], commandObject2.stringArgs[0], (FilenameURL)commandObject2.objectArgs[0], commandObject2.floatArgs[0], commandObject2.floatArgs[1], commandObject2.floatArgs[2], commandObject2.intArgs[0], commandObject2.floatArgs[3], commandObject2.boolArgs[3]);
                        continue block50;
                    }
                    case 11: {
                        this.CommandRawDataStream((AudioFormat)commandObject2.objectArgs[0], commandObject2.boolArgs[0], commandObject2.stringArgs[0], commandObject2.floatArgs[0], commandObject2.floatArgs[1], commandObject2.floatArgs[2], commandObject2.intArgs[0], commandObject2.floatArgs[3]);
                        continue block50;
                    }
                    case 12: {
                        this.CommandQuickPlay(commandObject2.boolArgs[0], commandObject2.boolArgs[1], commandObject2.boolArgs[2], commandObject2.stringArgs[0], (FilenameURL)commandObject2.objectArgs[0], commandObject2.floatArgs[0], commandObject2.floatArgs[1], commandObject2.floatArgs[2], commandObject2.intArgs[0], commandObject2.floatArgs[3], commandObject2.boolArgs[3]);
                        continue block50;
                    }
                    case 13: {
                        this.CommandSetPosition(commandObject2.stringArgs[0], commandObject2.floatArgs[0], commandObject2.floatArgs[1], commandObject2.floatArgs[2]);
                        continue block50;
                    }
                    case 14: {
                        this.CommandSetVolume(commandObject2.stringArgs[0], commandObject2.floatArgs[0]);
                        continue block50;
                    }
                    case 15: {
                        this.CommandSetPitch(commandObject2.stringArgs[0], commandObject2.floatArgs[0]);
                        continue block50;
                    }
                    case 16: {
                        this.CommandSetPriority(commandObject2.stringArgs[0], commandObject2.boolArgs[0]);
                        continue block50;
                    }
                    case 17: {
                        this.CommandSetLooping(commandObject2.stringArgs[0], commandObject2.boolArgs[0]);
                        continue block50;
                    }
                    case 18: {
                        this.CommandSetAttenuation(commandObject2.stringArgs[0], commandObject2.intArgs[0]);
                        continue block50;
                    }
                    case 19: {
                        this.CommandSetDistOrRoll(commandObject2.stringArgs[0], commandObject2.floatArgs[0]);
                        continue block50;
                    }
                    case 20: {
                        this.CommandChangeDopplerFactor(commandObject2.floatArgs[0]);
                        continue block50;
                    }
                    case 21: {
                        this.CommandChangeDopplerVelocity(commandObject2.floatArgs[0]);
                        continue block50;
                    }
                    case 22: {
                        this.CommandSetVelocity(commandObject2.stringArgs[0], commandObject2.floatArgs[0], commandObject2.floatArgs[1], commandObject2.floatArgs[2]);
                        continue block50;
                    }
                    case 23: {
                        this.CommandSetListenerVelocity(commandObject2.floatArgs[0], commandObject2.floatArgs[1], commandObject2.floatArgs[2]);
                        continue block50;
                    }
                    case 24: {
                        this.sourcePlayList.add(commandObject2);
                        continue block50;
                    }
                    case 25: {
                        this.sourcePlayList.add(commandObject2);
                        continue block50;
                    }
                    case 26: {
                        this.CommandPause(commandObject2.stringArgs[0]);
                        continue block50;
                    }
                    case 27: {
                        this.CommandStop(commandObject2.stringArgs[0]);
                        continue block50;
                    }
                    case 28: {
                        this.CommandRewind(commandObject2.stringArgs[0]);
                        continue block50;
                    }
                    case 29: {
                        this.CommandFlush(commandObject2.stringArgs[0]);
                        continue block50;
                    }
                    case 30: {
                        this.CommandCull(commandObject2.stringArgs[0]);
                        continue block50;
                    }
                    case 31: {
                        bl2 = true;
                        this.CommandActivate(commandObject2.stringArgs[0]);
                        continue block50;
                    }
                    case 32: {
                        this.CommandSetTemporary(commandObject2.stringArgs[0], commandObject2.boolArgs[0]);
                        continue block50;
                    }
                    case 33: {
                        this.CommandRemoveSource(commandObject2.stringArgs[0]);
                        continue block50;
                    }
                    case 34: {
                        this.CommandMoveListener(commandObject2.floatArgs[0], commandObject2.floatArgs[1], commandObject2.floatArgs[2]);
                        continue block50;
                    }
                    case 35: {
                        this.CommandSetListenerPosition(commandObject2.floatArgs[0], commandObject2.floatArgs[1], commandObject2.floatArgs[2]);
                        continue block50;
                    }
                    case 36: {
                        this.CommandTurnListener(commandObject2.floatArgs[0]);
                        continue block50;
                    }
                    case 37: {
                        this.CommandSetListenerAngle(commandObject2.floatArgs[0]);
                        continue block50;
                    }
                    case 38: {
                        this.CommandSetListenerOrientation(commandObject2.floatArgs[0], commandObject2.floatArgs[1], commandObject2.floatArgs[2], commandObject2.floatArgs[3], commandObject2.floatArgs[4], commandObject2.floatArgs[5]);
                        continue block50;
                    }
                    case 39: {
                        this.CommandSetMasterVolume(commandObject2.floatArgs[0]);
                        continue block50;
                    }
                    case 40: {
                        this.CommandNewLibrary(commandObject2.classArgs[0]);
                        continue block50;
                    }
                }
            }
            if (bl2) {
                this.soundLibrary.replaySources();
            }
            block51: while (this.sourcePlayList != null && this.sourcePlayList.size() > 0) {
                commandObject2 = this.sourcePlayList.remove(0);
                if (commandObject2 == null) continue;
                switch (commandObject2.Command) {
                    case 24: {
                        this.CommandPlay(commandObject2.stringArgs[0]);
                        break;
                    }
                    case 25: {
                        this.CommandFeedRawAudioData(commandObject2.stringArgs[0], commandObject2.buffer);
                        continue block51;
                    }
                }
            }
            bl = this.commandQueue != null && this.commandQueue.size() > 0;
        }
        SoundHooks.commandQueuePost(this, commandObject);
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeTemporarySources() {
        Object object = SoundSystemConfig.THREAD_SYNC;
        synchronized (object) {
            if (this.soundLibrary != null) {
                this.soundLibrary.removeTemporarySources();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean playing(String string) {
        Object object = SoundSystemConfig.THREAD_SYNC;
        synchronized (object) {
            if (this.soundLibrary == null) {
                return false;
            }
            Source source = this.soundLibrary.getSources().get(string);
            if (source == null) {
                return false;
            }
            return source.playing();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean playing() {
        Object object = SoundSystemConfig.THREAD_SYNC;
        synchronized (object) {
            if (this.soundLibrary == null) {
                return false;
            }
            HashMap<String, Source> hashMap = this.soundLibrary.getSources();
            if (hashMap == null) {
                return false;
            }
            Set<String> set = hashMap.keySet();
            for (String string : set) {
                Source source = hashMap.get(string);
                if (source == null || !source.playing()) continue;
                return true;
            }
            return false;
        }
    }

    private HashMap<String, Source> copySources(HashMap<String, Source> hashMap) {
        Set<String> set = hashMap.keySet();
        Iterator<String> iterator2 = set.iterator();
        HashMap<String, Source> hashMap2 = new HashMap<String, Source>();
        while (iterator2.hasNext()) {
            String string = iterator2.next();
            Source source = hashMap.get(string);
            if (source == null) continue;
            hashMap2.put(string, new Source(source, null));
        }
        return hashMap2;
    }

    public static boolean libraryCompatible(Class clazz) {
        SoundSystemLogger soundSystemLogger = SoundSystemConfig.getLogger();
        if (soundSystemLogger == null) {
            soundSystemLogger = new SoundSystemLogger();
            SoundSystemConfig.setLogger(soundSystemLogger);
        }
        soundSystemLogger.message("", 0);
        soundSystemLogger.message("Checking if " + SoundSystemConfig.getLibraryTitle(clazz) + " is compatible...", 0);
        boolean bl = SoundSystemConfig.libraryCompatible(clazz);
        if (bl) {
            soundSystemLogger.message("...yes", 1);
        } else {
            soundSystemLogger.message("...no", 1);
        }
        return bl;
    }

    public static Class currentLibrary() {
        return SoundSystem.currentLibrary(false, null);
    }

    public static boolean initialized() {
        return SoundSystem.initialized(false, false);
    }

    public static SoundSystemException getLastException() {
        return SoundSystem.lastException(false, null);
    }

    public static void setException(SoundSystemException soundSystemException) {
        SoundSystem.lastException(true, soundSystemException);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static boolean initialized(boolean bl, boolean bl2) {
        Object object = SoundSystemConfig.THREAD_SYNC;
        synchronized (object) {
            if (bl) {
                initialized = bl2;
            }
            return initialized;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static Class currentLibrary(boolean bl, Class clazz) {
        Object object = SoundSystemConfig.THREAD_SYNC;
        synchronized (object) {
            if (bl) {
                currentLibrary = clazz;
            }
            return currentLibrary;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static SoundSystemException lastException(boolean bl, SoundSystemException soundSystemException) {
        Object object = SoundSystemConfig.THREAD_SYNC;
        synchronized (object) {
            if (bl) {
                lastException = soundSystemException;
            }
            return lastException;
        }
    }

    protected static void snooze(long l) {
        try {
            Thread.sleep(l);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    protected void message(String string, int n) {
        this.logger.message(string, n);
    }

    protected void importantMessage(String string, int n) {
        this.logger.importantMessage(string, n);
    }

    protected boolean errorCheck(boolean bl, String string, int n) {
        return this.logger.errorCheck(bl, this.className, string, n);
    }

    protected void errorMessage(String string, int n) {
        this.logger.errorMessage(this.className, string, n);
    }
}

