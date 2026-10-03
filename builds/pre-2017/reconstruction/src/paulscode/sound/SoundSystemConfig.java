/*
 * Decompiled with CFR 0.152.
 */
package paulscode.sound;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Locale;
import paulscode.sound.ICodec;
import paulscode.sound.IStreamListener;
import paulscode.sound.Library;
import paulscode.sound.SoundSystemException;
import paulscode.sound.SoundSystemLogger;

public class SoundSystemConfig {
    public static final Object THREAD_SYNC = new Object();
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_STREAMING = 1;
    public static final int ATTENUATION_NONE = 0;
    public static final int ATTENUATION_ROLLOFF = 1;
    public static final int ATTENUATION_LINEAR = 2;
    public static String EXTENSION_MIDI = ".*[mM][iI][dD][iI]?$";
    public static String PREFIX_URL = "^[hH][tT][tT][pP]://.*";
    private static SoundSystemLogger logger = null;
    private static LinkedList<Class> libraries;
    private static LinkedList<Codec> codecs;
    private static LinkedList<IStreamListener> streamListeners;
    private static final Object streamListenersLock;
    private static int numberNormalChannels;
    private static int numberStreamingChannels;
    private static float masterGain;
    private static int defaultAttenuationModel;
    private static float defaultRolloffFactor;
    private static float dopplerFactor;
    private static float dopplerVelocity;
    private static float defaultFadeDistance;
    private static String soundFilesPackage;
    private static int streamingBufferSize;
    private static int numberStreamingBuffers;
    private static boolean streamQueueFormatsMatch;
    private static int maxFileSize;
    private static int fileChunkSize;
    private static boolean midiCodec;
    private static String overrideMIDISynthesizer;

    public static void addLibrary(Class clazz) throws SoundSystemException {
        if (clazz == null) {
            throw new SoundSystemException("Parameter null in method 'addLibrary'", 2);
        }
        if (!Library.class.isAssignableFrom(clazz)) {
            throw new SoundSystemException("The specified class does not extend class 'Library' in method 'addLibrary'");
        }
        if (libraries == null) {
            libraries = new LinkedList();
        }
        if (!libraries.contains(clazz)) {
            libraries.add(clazz);
        }
    }

    public static void removeLibrary(Class clazz) throws SoundSystemException {
        if (libraries == null || clazz == null) {
            return;
        }
        libraries.remove(clazz);
    }

    public static LinkedList<Class> getLibraries() {
        return libraries;
    }

    public static boolean libraryCompatible(Class clazz) {
        if (clazz == null) {
            SoundSystemConfig.errorMessage("Parameter 'libraryClass' null in method'librayCompatible'");
            return false;
        }
        if (!Library.class.isAssignableFrom(clazz)) {
            SoundSystemConfig.errorMessage("The specified class does not extend class 'Library' in method 'libraryCompatible'");
            return false;
        }
        Object object = SoundSystemConfig.runMethod(clazz, "libraryCompatible", new Class[0], new Object[0]);
        if (object == null) {
            SoundSystemConfig.errorMessage("Method 'Library.libraryCompatible' returned 'null' in method 'libraryCompatible'");
            return false;
        }
        return (Boolean)object;
    }

    public static String getLibraryTitle(Class clazz) {
        if (clazz == null) {
            SoundSystemConfig.errorMessage("Parameter 'libraryClass' null in method'getLibrayTitle'");
            return null;
        }
        if (!Library.class.isAssignableFrom(clazz)) {
            SoundSystemConfig.errorMessage("The specified class does not extend class 'Library' in method 'getLibraryTitle'");
            return null;
        }
        Object object = SoundSystemConfig.runMethod(clazz, "getTitle", new Class[0], new Object[0]);
        if (object == null) {
            SoundSystemConfig.errorMessage("Method 'Library.getTitle' returned 'null' in method 'getLibraryTitle'");
            return null;
        }
        return (String)object;
    }

    public static String getLibraryDescription(Class clazz) {
        if (clazz == null) {
            SoundSystemConfig.errorMessage("Parameter 'libraryClass' null in method'getLibrayDescription'");
            return null;
        }
        if (!Library.class.isAssignableFrom(clazz)) {
            SoundSystemConfig.errorMessage("The specified class does not extend class 'Library' in method 'getLibraryDescription'");
            return null;
        }
        Object object = SoundSystemConfig.runMethod(clazz, "getDescription", new Class[0], new Object[0]);
        if (object == null) {
            SoundSystemConfig.errorMessage("Method 'Library.getDescription' returned 'null' in method 'getLibraryDescription'");
            return null;
        }
        return (String)object;
    }

    public static boolean reverseByteOrder(Class clazz) {
        if (clazz == null) {
            SoundSystemConfig.errorMessage("Parameter 'libraryClass' null in method'reverseByteOrder'");
            return false;
        }
        if (!Library.class.isAssignableFrom(clazz)) {
            SoundSystemConfig.errorMessage("The specified class does not extend class 'Library' in method 'reverseByteOrder'");
            return false;
        }
        Object object = SoundSystemConfig.runMethod(clazz, "reversByteOrder", new Class[0], new Object[0]);
        if (object == null) {
            SoundSystemConfig.errorMessage("Method 'Library.reverseByteOrder' returned 'null' in method 'getLibraryDescription'");
            return false;
        }
        return (Boolean)object;
    }

    public static void setLogger(SoundSystemLogger soundSystemLogger) {
        logger = soundSystemLogger;
    }

    public static SoundSystemLogger getLogger() {
        return logger;
    }

    public static synchronized void setNumberNormalChannels(int n) {
        numberNormalChannels = n;
    }

    public static synchronized int getNumberNormalChannels() {
        return numberNormalChannels;
    }

    public static synchronized void setNumberStreamingChannels(int n) {
        numberStreamingChannels = n;
    }

    public static synchronized int getNumberStreamingChannels() {
        return numberStreamingChannels;
    }

    public static synchronized void setMasterGain(float f) {
        masterGain = f;
    }

    public static synchronized float getMasterGain() {
        return masterGain;
    }

    public static synchronized void setDefaultAttenuation(int n) {
        defaultAttenuationModel = n;
    }

    public static synchronized int getDefaultAttenuation() {
        return defaultAttenuationModel;
    }

    public static synchronized void setDefaultRolloff(float f) {
        defaultRolloffFactor = f;
    }

    public static synchronized float getDopplerFactor() {
        return dopplerFactor;
    }

    public static synchronized void setDopplerFactor(float f) {
        dopplerFactor = f;
    }

    public static synchronized float getDopplerVelocity() {
        return dopplerVelocity;
    }

    public static synchronized void setDopplerVelocity(float f) {
        dopplerVelocity = f;
    }

    public static synchronized float getDefaultRolloff() {
        return defaultRolloffFactor;
    }

    public static synchronized void setDefaultFadeDistance(float f) {
        defaultFadeDistance = f;
    }

    public static synchronized float getDefaultFadeDistance() {
        return defaultFadeDistance;
    }

    public static synchronized void setSoundFilesPackage(String string) {
        soundFilesPackage = string;
    }

    public static synchronized String getSoundFilesPackage() {
        return soundFilesPackage;
    }

    public static synchronized void setStreamingBufferSize(int n) {
        streamingBufferSize = n;
    }

    public static synchronized int getStreamingBufferSize() {
        return streamingBufferSize;
    }

    public static synchronized void setNumberStreamingBuffers(int n) {
        numberStreamingBuffers = n;
    }

    public static synchronized int getNumberStreamingBuffers() {
        return numberStreamingBuffers;
    }

    public static synchronized void setStreamQueueFormatsMatch(boolean bl) {
        streamQueueFormatsMatch = bl;
    }

    public static synchronized boolean getStreamQueueFormatsMatch() {
        return streamQueueFormatsMatch;
    }

    public static synchronized void setMaxFileSize(int n) {
        maxFileSize = n;
    }

    public static synchronized int getMaxFileSize() {
        return maxFileSize;
    }

    public static synchronized void setFileChunkSize(int n) {
        fileChunkSize = n;
    }

    public static synchronized int getFileChunkSize() {
        return fileChunkSize;
    }

    public static synchronized String getOverrideMIDISynthesizer() {
        return overrideMIDISynthesizer;
    }

    public static synchronized void setOverrideMIDISynthesizer(String string) {
        overrideMIDISynthesizer = string;
    }

    public static synchronized void setCodec(String string, Class clazz) throws SoundSystemException {
        if (string == null) {
            throw new SoundSystemException("Parameter 'extension' null in method 'setCodec'.", 2);
        }
        if (clazz == null) {
            throw new SoundSystemException("Parameter 'iCodecClass' null in method 'setCodec'.", 2);
        }
        if (!ICodec.class.isAssignableFrom(clazz)) {
            throw new SoundSystemException("The specified class does not implement interface 'ICodec' in method 'setCodec'", 3);
        }
        if (codecs == null) {
            codecs = new LinkedList();
        }
        ListIterator listIterator = codecs.listIterator();
        while (listIterator.hasNext()) {
            Codec codec = (Codec)listIterator.next();
            if (!string.matches(codec.extensionRegX)) continue;
            listIterator.remove();
        }
        codecs.add(new Codec(string, clazz));
        if (string.matches(EXTENSION_MIDI)) {
            midiCodec = true;
        }
    }

    public static synchronized ICodec getCodec(String string) {
        if (codecs == null) {
            return null;
        }
        ListIterator listIterator = codecs.listIterator();
        while (listIterator.hasNext()) {
            Codec codec = (Codec)listIterator.next();
            if (!string.matches(codec.extensionRegX)) continue;
            return codec.getInstance();
        }
        return null;
    }

    public static boolean midiCodec() {
        return midiCodec;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void addStreamListener(IStreamListener iStreamListener) {
        Object object = streamListenersLock;
        synchronized (object) {
            if (streamListeners == null) {
                streamListeners = new LinkedList();
            }
            if (!streamListeners.contains(iStreamListener)) {
                streamListeners.add(iStreamListener);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void removeStreamListener(IStreamListener iStreamListener) {
        Object object = streamListenersLock;
        synchronized (object) {
            if (streamListeners == null) {
                streamListeners = new LinkedList();
            }
            if (streamListeners.contains(iStreamListener)) {
                streamListeners.remove(iStreamListener);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void notifyEOS(String string, int n) {
        Object object = streamListenersLock;
        synchronized (object) {
            if (streamListeners == null) {
                return;
            }
        }
        object = string;
        int n2 = n;
        new Thread((String)object, n2){
            final /* synthetic */ String val$srcName;
            final /* synthetic */ int val$qSize;
            {
                this.val$srcName = string;
                this.val$qSize = n;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public void run() {
                Object object = streamListenersLock;
                synchronized (object) {
                    if (streamListeners == null) {
                        return;
                    }
                    ListIterator listIterator = streamListeners.listIterator();
                    while (listIterator.hasNext()) {
                        IStreamListener iStreamListener = (IStreamListener)listIterator.next();
                        if (iStreamListener == null) {
                            listIterator.remove();
                            continue;
                        }
                        iStreamListener.endOfStream(this.val$srcName, this.val$qSize);
                    }
                }
            }
        }.start();
    }

    private static void errorMessage(String string) {
        if (logger != null) {
            logger.errorMessage("SoundSystemConfig", string, 0);
        }
    }

    private static Object runMethod(Class clazz, String string, Class[] classArray, Object[] objectArray) {
        Method method = null;
        try {
            method = clazz.getMethod(string, classArray);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            SoundSystemConfig.errorMessage("NoSuchMethodException thrown when attempting to call method '" + string + "' in method 'runMethod'");
            return null;
        }
        catch (SecurityException securityException) {
            SoundSystemConfig.errorMessage("Access denied when attempting to call method '" + string + "' in method 'runMethod'");
            return null;
        }
        catch (NullPointerException nullPointerException) {
            SoundSystemConfig.errorMessage("NullPointerException thrown when attempting to call method '" + string + "' in method 'runMethod'");
            return null;
        }
        if (method == null) {
            SoundSystemConfig.errorMessage("Method '" + string + "' not found for the class specified in method 'runMethod'");
            return null;
        }
        Object object = null;
        try {
            object = method.invoke(null, objectArray);
        }
        catch (IllegalAccessException illegalAccessException) {
            SoundSystemConfig.errorMessage("IllegalAccessException thrown when attempting to invoke method '" + string + "' in method 'runMethod'");
            return null;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            SoundSystemConfig.errorMessage("IllegalArgumentException thrown when attempting to invoke method '" + string + "' in method 'runMethod'");
            return null;
        }
        catch (InvocationTargetException invocationTargetException) {
            SoundSystemConfig.errorMessage("InvocationTargetException thrown while attempting to invoke method 'Library.getTitle' in method 'getLibraryTitle'");
            return null;
        }
        catch (NullPointerException nullPointerException) {
            SoundSystemConfig.errorMessage("NullPointerException thrown when attempting to invoke method '" + string + "' in method 'runMethod'");
            return null;
        }
        catch (ExceptionInInitializerError exceptionInInitializerError) {
            SoundSystemConfig.errorMessage("ExceptionInInitializerError thrown when attempting to invoke method '" + string + "' in method 'runMethod'");
            return null;
        }
        return object;
    }

    static {
        codecs = null;
        streamListeners = null;
        streamListenersLock = new Object();
        numberNormalChannels = 28;
        numberStreamingChannels = 4;
        masterGain = 1.0f;
        defaultAttenuationModel = 1;
        defaultRolloffFactor = 0.03f;
        dopplerFactor = 0.0f;
        dopplerVelocity = 1.0f;
        defaultFadeDistance = 1000.0f;
        soundFilesPackage = "Sounds/";
        streamingBufferSize = 131072;
        numberStreamingBuffers = 3;
        streamQueueFormatsMatch = false;
        maxFileSize = 0x10000000;
        fileChunkSize = 0x100000;
        midiCodec = false;
        overrideMIDISynthesizer = "";
    }

    private static class Codec {
        public String extensionRegX = "";
        public Class iCodecClass;

        public Codec(String string, Class clazz) {
            if (string != null && string.length() > 0) {
                this.extensionRegX = ".*";
                for (int i = 0; i < string.length(); ++i) {
                    String string2 = string.substring(i, i + 1);
                    this.extensionRegX = this.extensionRegX + "[" + string2.toLowerCase(Locale.ENGLISH) + string2.toUpperCase(Locale.ENGLISH) + "]";
                }
                this.extensionRegX = this.extensionRegX + "$";
            }
            this.iCodecClass = clazz;
        }

        public ICodec getInstance() {
            if (this.iCodecClass == null) {
                return null;
            }
            Object var1_1 = null;
            try {
                var1_1 = this.iCodecClass.newInstance();
            }
            catch (InstantiationException instantiationException) {
                this.instantiationErrorMessage();
                return null;
            }
            catch (IllegalAccessException illegalAccessException) {
                this.instantiationErrorMessage();
                return null;
            }
            catch (ExceptionInInitializerError exceptionInInitializerError) {
                this.instantiationErrorMessage();
                return null;
            }
            catch (SecurityException securityException) {
                this.instantiationErrorMessage();
                return null;
            }
            if (var1_1 == null) {
                this.instantiationErrorMessage();
                return null;
            }
            return var1_1;
        }

        private void instantiationErrorMessage() {
            SoundSystemConfig.errorMessage("Unrecognized ICodec implementation in method 'getInstance'.  Ensure that the implementing class has one public, parameterless constructor.");
        }
    }
}

