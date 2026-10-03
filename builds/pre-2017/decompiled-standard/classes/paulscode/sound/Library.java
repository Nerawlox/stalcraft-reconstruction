/*
 * Decompiled with CFR 0.152.
 */
package paulscode.sound;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.sound.sampled.AudioFormat;
import paulscode.sound.Channel;
import paulscode.sound.FilenameURL;
import paulscode.sound.ListenerData;
import paulscode.sound.MidiChannel;
import paulscode.sound.SoundBuffer;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemException;
import paulscode.sound.SoundSystemLogger;
import paulscode.sound.Source;
import paulscode.sound.StreamThread;

public class Library {
    private SoundSystemLogger logger = SoundSystemConfig.getLogger();
    protected ListenerData listener;
    protected HashMap<String, SoundBuffer> bufferMap = new HashMap();
    protected HashMap<String, Source> sourceMap = new HashMap();
    private MidiChannel midiChannel;
    protected List<Channel> streamingChannels;
    protected List<Channel> normalChannels;
    private String[] streamingChannelSourceNames;
    private String[] normalChannelSourceNames;
    private int nextStreamingChannel = 0;
    private int nextNormalChannel = 0;
    protected StreamThread streamThread;
    protected boolean reverseByteOrder = false;

    public Library() throws SoundSystemException {
        this.listener = new ListenerData(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f);
        this.streamingChannels = new LinkedList<Channel>();
        this.normalChannels = new LinkedList<Channel>();
        this.streamingChannelSourceNames = new String[SoundSystemConfig.getNumberStreamingChannels()];
        this.normalChannelSourceNames = new String[SoundSystemConfig.getNumberNormalChannels()];
        this.streamThread = new StreamThread();
        this.streamThread.start();
    }

    public void cleanup() {
        this.streamThread.kill();
        this.streamThread.interrupt();
        for (int i = 0; i < 50 && this.streamThread.alive(); ++i) {
            try {
                Thread.sleep(100L);
                continue;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (this.streamThread.alive()) {
            this.errorMessage("Stream thread did not die!");
            this.message("Ignoring errors... continuing clean-up.");
        }
        if (this.midiChannel != null) {
            this.midiChannel.cleanup();
            this.midiChannel = null;
        }
        Channel channel = null;
        if (this.streamingChannels != null) {
            while (!this.streamingChannels.isEmpty()) {
                channel = this.streamingChannels.remove(0);
                channel.close();
                channel.cleanup();
                channel = null;
            }
            this.streamingChannels.clear();
            this.streamingChannels = null;
        }
        if (this.normalChannels != null) {
            while (!this.normalChannels.isEmpty()) {
                channel = this.normalChannels.remove(0);
                channel.close();
                channel.cleanup();
                channel = null;
            }
            this.normalChannels.clear();
            this.normalChannels = null;
        }
        Set<String> set = this.sourceMap.keySet();
        for (String string : set) {
            Source source = this.sourceMap.get(string);
            if (source == null) continue;
            source.cleanup();
        }
        this.sourceMap.clear();
        this.sourceMap = null;
        this.listener = null;
        this.streamThread = null;
    }

    public void init() throws SoundSystemException {
        int n;
        Channel channel = null;
        for (n = 0; n < SoundSystemConfig.getNumberStreamingChannels() && (channel = this.createChannel(1)) != null; ++n) {
            this.streamingChannels.add(channel);
        }
        for (n = 0; n < SoundSystemConfig.getNumberNormalChannels() && (channel = this.createChannel(0)) != null; ++n) {
            this.normalChannels.add(channel);
        }
    }

    public static boolean libraryCompatible() {
        return true;
    }

    protected Channel createChannel(int n) {
        return new Channel(n);
    }

    public boolean loadSound(FilenameURL filenameURL) {
        return true;
    }

    public boolean loadSound(SoundBuffer soundBuffer, String string) {
        return true;
    }

    public LinkedList<String> getAllLoadedFilenames() {
        LinkedList<String> linkedList = new LinkedList<String>();
        Set<String> set = this.bufferMap.keySet();
        Iterator<String> iterator2 = set.iterator();
        while (iterator2.hasNext()) {
            linkedList.add(iterator2.next());
        }
        return linkedList;
    }

    public LinkedList<String> getAllSourcenames() {
        LinkedList<String> linkedList = new LinkedList<String>();
        Set<String> set = this.sourceMap.keySet();
        Iterator<String> iterator2 = set.iterator();
        if (this.midiChannel != null) {
            linkedList.add(this.midiChannel.getSourcename());
        }
        while (iterator2.hasNext()) {
            linkedList.add(iterator2.next());
        }
        return linkedList;
    }

    public void unloadSound(String string) {
        this.bufferMap.remove(string);
    }

    public void rawDataStream(AudioFormat audioFormat, boolean bl, String string, float f, float f2, float f3, int n, float f4) {
        this.sourceMap.put(string, new Source(audioFormat, bl, string, f, f2, f3, n, f4));
    }

    public void newSource(boolean bl, boolean bl2, boolean bl3, String string, FilenameURL filenameURL, float f, float f2, float f3, int n, float f4, boolean bl4) {
        this.sourceMap.put(string, new Source(bl, bl2, bl3, string, filenameURL, null, f, f2, f3, n, f4, false));
    }

    public void quickPlay(boolean bl, boolean bl2, boolean bl3, String string, FilenameURL filenameURL, float f, float f2, float f3, int n, float f4, boolean bl4) {
        this.sourceMap.put(string, new Source(bl, bl2, bl3, string, filenameURL, null, f, f2, f3, n, f4, bl4));
    }

    public void setTemporary(String string, boolean bl) {
        Source source = this.sourceMap.get(string);
        if (source != null) {
            source.setTemporary(bl);
        }
    }

    public void setPosition(String string, float f, float f2, float f3) {
        Source source = this.sourceMap.get(string);
        if (source != null) {
            source.setPosition(f, f2, f3);
        }
    }

    public void setPriority(String string, boolean bl) {
        Source source = this.sourceMap.get(string);
        if (source != null) {
            source.setPriority(bl);
        }
    }

    public void setLooping(String string, boolean bl) {
        Source source = this.sourceMap.get(string);
        if (source != null) {
            source.setLooping(bl);
        }
    }

    public void setAttenuation(String string, int n) {
        Source source = this.sourceMap.get(string);
        if (source != null) {
            source.setAttenuation(n);
        }
    }

    public void setDistOrRoll(String string, float f) {
        Source source = this.sourceMap.get(string);
        if (source != null) {
            source.setDistOrRoll(f);
        }
    }

    public void setVelocity(String string, float f, float f2, float f3) {
        Source source = this.sourceMap.get(string);
        if (source != null) {
            source.setVelocity(f, f2, f3);
        }
    }

    public void setListenerVelocity(float f, float f2, float f3) {
        this.listener.setVelocity(f, f2, f3);
    }

    public void dopplerChanged() {
    }

    public float millisecondsPlayed(String string) {
        if (string == null || string.equals("")) {
            this.errorMessage("Sourcename not specified in method 'millisecondsPlayed'");
            return -1.0f;
        }
        if (this.midiSourcename(string)) {
            this.errorMessage("Unable to calculate milliseconds for MIDI source.");
            return -1.0f;
        }
        Source source = this.sourceMap.get(string);
        if (source == null) {
            this.errorMessage("Source '" + string + "' not found in method 'millisecondsPlayed'");
        }
        return source.millisecondsPlayed();
    }

    public int feedRawAudioData(String string, byte[] byArray) {
        if (string == null || string.equals("")) {
            this.errorMessage("Sourcename not specified in method 'feedRawAudioData'");
            return -1;
        }
        if (this.midiSourcename(string)) {
            this.errorMessage("Raw audio data can not be fed to the MIDI channel.");
            return -1;
        }
        Source source = this.sourceMap.get(string);
        if (source == null) {
            this.errorMessage("Source '" + string + "' not found in method 'feedRawAudioData'");
        }
        return this.feedRawAudioData(source, byArray);
    }

    public int feedRawAudioData(Source source, byte[] byArray) {
        if (source == null) {
            this.errorMessage("Source parameter null in method 'feedRawAudioData'");
            return -1;
        }
        if (!source.toStream) {
            this.errorMessage("Only a streaming source may be specified in method 'feedRawAudioData'");
            return -1;
        }
        if (!source.rawDataStream) {
            this.errorMessage("Streaming source already associated with a file or URL in method'feedRawAudioData'");
            return -1;
        }
        if (!source.playing() || source.channel == null) {
            Channel channel = source.channel != null && source.channel.attachedSource == source ? source.channel : this.getNextChannel(source);
            int n = source.feedRawAudioData(channel, byArray);
            channel.attachedSource = source;
            this.streamThread.watch(source);
            this.streamThread.interrupt();
            return n;
        }
        return source.feedRawAudioData(source.channel, byArray);
    }

    public void play(String string) {
        if (string == null || string.equals("")) {
            this.errorMessage("Sourcename not specified in method 'play'");
            return;
        }
        if (this.midiSourcename(string)) {
            this.midiChannel.play();
        } else {
            Source source = this.sourceMap.get(string);
            if (source == null) {
                this.errorMessage("Source '" + string + "' not found in method 'play'");
            }
            this.play(source);
        }
    }

    public void play(Source source) {
        if (source == null) {
            return;
        }
        if (source.rawDataStream) {
            return;
        }
        if (!source.active()) {
            return;
        }
        if (!source.playing()) {
            Channel channel = this.getNextChannel(source);
            if (source != null && channel != null) {
                if (source.channel != null && source.channel.attachedSource != source) {
                    source.channel = null;
                }
                channel.attachedSource = source;
                source.play(channel);
                if (source.toStream) {
                    this.streamThread.watch(source);
                    this.streamThread.interrupt();
                }
            }
        }
    }

    public void stop(String string) {
        if (string == null || string.equals("")) {
            this.errorMessage("Sourcename not specified in method 'stop'");
            return;
        }
        if (this.midiSourcename(string)) {
            this.midiChannel.stop();
        } else {
            Source source = this.sourceMap.get(string);
            if (source != null) {
                source.stop();
            }
        }
    }

    public void pause(String string) {
        if (string == null || string.equals("")) {
            this.errorMessage("Sourcename not specified in method 'stop'");
            return;
        }
        if (this.midiSourcename(string)) {
            this.midiChannel.pause();
        } else {
            Source source = this.sourceMap.get(string);
            if (source != null) {
                source.pause();
            }
        }
    }

    public void rewind(String string) {
        if (this.midiSourcename(string)) {
            this.midiChannel.rewind();
        } else {
            Source source = this.sourceMap.get(string);
            if (source != null) {
                source.rewind();
            }
        }
    }

    public void flush(String string) {
        if (this.midiSourcename(string)) {
            this.errorMessage("You can not flush the MIDI channel");
        } else {
            Source source = this.sourceMap.get(string);
            if (source != null) {
                source.flush();
            }
        }
    }

    public void cull(String string) {
        Source source = this.sourceMap.get(string);
        if (source != null) {
            source.cull();
        }
    }

    public void activate(String string) {
        Source source = this.sourceMap.get(string);
        if (source != null) {
            source.activate();
            if (source.toPlay) {
                this.play(source);
            }
        }
    }

    public void setMasterVolume(float f) {
        SoundSystemConfig.setMasterGain(f);
        if (this.midiChannel != null) {
            this.midiChannel.resetGain();
        }
    }

    public void setVolume(String string, float f) {
        if (this.midiSourcename(string)) {
            this.midiChannel.setVolume(f);
        } else {
            Source source = this.sourceMap.get(string);
            if (source != null) {
                float f2 = f;
                if (f2 < 0.0f) {
                    f2 = 0.0f;
                } else if (f2 > 1.0f) {
                    f2 = 1.0f;
                }
                source.sourceVolume = f2;
                source.positionChanged();
            }
        }
    }

    public float getVolume(String string) {
        if (this.midiSourcename(string)) {
            return this.midiChannel.getVolume();
        }
        Source source = this.sourceMap.get(string);
        if (source != null) {
            return source.sourceVolume;
        }
        return 0.0f;
    }

    public void setPitch(String string, float f) {
        Source source;
        if (!this.midiSourcename(string) && (source = this.sourceMap.get(string)) != null) {
            float f2 = f;
            if (f2 < 0.5f) {
                f2 = 0.5f;
            } else if (f2 > 2.0f) {
                f2 = 2.0f;
            }
            source.setPitch(f2);
            source.positionChanged();
        }
    }

    public float getPitch(String string) {
        Source source;
        if (!this.midiSourcename(string) && (source = this.sourceMap.get(string)) != null) {
            return source.getPitch();
        }
        return 1.0f;
    }

    public void moveListener(float f, float f2, float f3) {
        this.setListenerPosition(this.listener.position.x + f, this.listener.position.y + f2, this.listener.position.z + f3);
    }

    public void setListenerPosition(float f, float f2, float f3) {
        this.listener.setPosition(f, f2, f3);
        Set<String> set = this.sourceMap.keySet();
        for (String string : set) {
            Source source = this.sourceMap.get(string);
            if (source == null) continue;
            source.positionChanged();
        }
    }

    public void turnListener(float f) {
        this.setListenerAngle(this.listener.angle + f);
        Set<String> set = this.sourceMap.keySet();
        for (String string : set) {
            Source source = this.sourceMap.get(string);
            if (source == null) continue;
            source.positionChanged();
        }
    }

    public void setListenerAngle(float f) {
        this.listener.setAngle(f);
        Set<String> set = this.sourceMap.keySet();
        for (String string : set) {
            Source source = this.sourceMap.get(string);
            if (source == null) continue;
            source.positionChanged();
        }
    }

    public void setListenerOrientation(float f, float f2, float f3, float f4, float f5, float f6) {
        this.listener.setOrientation(f, f2, f3, f4, f5, f6);
        Set<String> set = this.sourceMap.keySet();
        for (String string : set) {
            Source source = this.sourceMap.get(string);
            if (source == null) continue;
            source.positionChanged();
        }
    }

    public void setListenerData(ListenerData listenerData) {
        this.listener.setData(listenerData);
    }

    public void copySources(HashMap<String, Source> hashMap) {
        if (hashMap == null) {
            return;
        }
        Set<String> set = hashMap.keySet();
        Iterator<String> iterator2 = set.iterator();
        this.sourceMap.clear();
        while (iterator2.hasNext()) {
            String string = iterator2.next();
            Source source = hashMap.get(string);
            if (source == null) continue;
            this.loadSound(source.filenameURL);
            this.sourceMap.put(string, new Source(source, null));
        }
    }

    public void removeSource(String string) {
        Source source = this.sourceMap.get(string);
        if (source != null) {
            source.cleanup();
        }
        this.sourceMap.remove(string);
    }

    public void removeTemporarySources() {
        Set<String> set = this.sourceMap.keySet();
        Iterator<String> iterator2 = set.iterator();
        while (iterator2.hasNext()) {
            String string = iterator2.next();
            Source source = this.sourceMap.get(string);
            if (source == null || !source.temporary || source.playing()) continue;
            source.cleanup();
            iterator2.remove();
        }
    }

    private Channel getNextChannel(Source source) {
        Source source2;
        String string;
        int n;
        String[] stringArray;
        List<Channel> list;
        int n2;
        if (source == null) {
            return null;
        }
        String string2 = source.sourcename;
        if (string2 == null) {
            return null;
        }
        if (source.toStream) {
            n2 = this.nextStreamingChannel;
            list = this.streamingChannels;
            stringArray = this.streamingChannelSourceNames;
        } else {
            n2 = this.nextNormalChannel;
            list = this.normalChannels;
            stringArray = this.normalChannelSourceNames;
        }
        int n3 = list.size();
        for (n = 0; n < n3; ++n) {
            if (!string2.equals(stringArray[n])) continue;
            return list.get(n);
        }
        int n4 = n2;
        for (n = 0; n < n3; ++n) {
            string = stringArray[n4];
            source2 = string == null ? null : this.sourceMap.get(string);
            if (source2 == null || !source2.playing()) {
                if (source.toStream) {
                    this.nextStreamingChannel = n4 + 1;
                    if (this.nextStreamingChannel >= n3) {
                        this.nextStreamingChannel = 0;
                    }
                } else {
                    this.nextNormalChannel = n4 + 1;
                    if (this.nextNormalChannel >= n3) {
                        this.nextNormalChannel = 0;
                    }
                }
                stringArray[n4] = string2;
                return list.get(n4);
            }
            if (++n4 < n3) continue;
            n4 = 0;
        }
        n4 = n2;
        for (n = 0; n < n3; ++n) {
            string = stringArray[n4];
            source2 = string == null ? null : this.sourceMap.get(string);
            if (source2 == null || !source2.playing() || !source2.priority) {
                if (source.toStream) {
                    this.nextStreamingChannel = n4 + 1;
                    if (this.nextStreamingChannel >= n3) {
                        this.nextStreamingChannel = 0;
                    }
                } else {
                    this.nextNormalChannel = n4 + 1;
                    if (this.nextNormalChannel >= n3) {
                        this.nextNormalChannel = 0;
                    }
                }
                stringArray[n4] = string2;
                return list.get(n4);
            }
            if (++n4 < n3) continue;
            n4 = 0;
        }
        return null;
    }

    public void replaySources() {
        Set<String> set = this.sourceMap.keySet();
        for (String string : set) {
            Source source = this.sourceMap.get(string);
            if (source == null || !source.toPlay || source.playing()) continue;
            this.play(string);
            source.toPlay = false;
        }
    }

    public void queueSound(String string, FilenameURL filenameURL) {
        if (this.midiSourcename(string)) {
            this.midiChannel.queueSound(filenameURL);
        } else {
            Source source = this.sourceMap.get(string);
            if (source != null) {
                source.queueSound(filenameURL);
            }
        }
    }

    public void dequeueSound(String string, String string2) {
        if (this.midiSourcename(string)) {
            this.midiChannel.dequeueSound(string2);
        } else {
            Source source = this.sourceMap.get(string);
            if (source != null) {
                source.dequeueSound(string2);
            }
        }
    }

    public void fadeOut(String string, FilenameURL filenameURL, long l) {
        if (this.midiSourcename(string)) {
            this.midiChannel.fadeOut(filenameURL, l);
        } else {
            Source source = this.sourceMap.get(string);
            if (source != null) {
                source.fadeOut(filenameURL, l);
            }
        }
    }

    public void fadeOutIn(String string, FilenameURL filenameURL, long l, long l2) {
        if (this.midiSourcename(string)) {
            this.midiChannel.fadeOutIn(filenameURL, l, l2);
        } else {
            Source source = this.sourceMap.get(string);
            if (source != null) {
                source.fadeOutIn(filenameURL, l, l2);
            }
        }
    }

    public void checkFadeVolumes() {
        Source source;
        Channel channel;
        if (this.midiChannel != null) {
            this.midiChannel.resetGain();
        }
        for (int i = 0; i < this.streamingChannels.size(); ++i) {
            channel = this.streamingChannels.get(i);
            if (channel == null || (source = channel.attachedSource) == null) continue;
            source.checkFadeOut();
        }
        channel = null;
        source = null;
    }

    public void loadMidi(boolean bl, String string, FilenameURL filenameURL) {
        if (filenameURL == null) {
            this.errorMessage("Filename/URL not specified in method 'loadMidi'.");
            return;
        }
        if (!filenameURL.getFilename().matches(SoundSystemConfig.EXTENSION_MIDI)) {
            this.errorMessage("Filename/identifier doesn't end in '.mid' or'.midi' in method loadMidi.");
            return;
        }
        if (this.midiChannel == null) {
            this.midiChannel = new MidiChannel(bl, string, filenameURL);
        } else {
            this.midiChannel.switchSource(bl, string, filenameURL);
        }
    }

    public void unloadMidi() {
        if (this.midiChannel != null) {
            this.midiChannel.cleanup();
        }
        this.midiChannel = null;
    }

    public boolean midiSourcename(String string) {
        if (this.midiChannel == null || string == null) {
            return false;
        }
        if (this.midiChannel.getSourcename() == null || string.equals("")) {
            return false;
        }
        return string.equals(this.midiChannel.getSourcename());
    }

    public Source getSource(String string) {
        return this.sourceMap.get(string);
    }

    public MidiChannel getMidiChannel() {
        return this.midiChannel;
    }

    public void setMidiChannel(MidiChannel midiChannel) {
        if (this.midiChannel != null && this.midiChannel != midiChannel) {
            this.midiChannel.cleanup();
        }
        this.midiChannel = midiChannel;
    }

    public void listenerMoved() {
        Set<String> set = this.sourceMap.keySet();
        for (String string : set) {
            Source source = this.sourceMap.get(string);
            if (source == null) continue;
            source.listenerMoved();
        }
    }

    public HashMap<String, Source> getSources() {
        return this.sourceMap;
    }

    public ListenerData getListenerData() {
        return this.listener;
    }

    public boolean reverseByteOrder() {
        return this.reverseByteOrder;
    }

    public static String getTitle() {
        return "No Sound";
    }

    public static String getDescription() {
        return "Silent Mode";
    }

    public String getClassName() {
        return "Library";
    }

    protected void message(String string) {
        this.logger.message(string, 0);
    }

    protected void importantMessage(String string) {
        this.logger.importantMessage(string, 0);
    }

    protected boolean errorCheck(boolean bl, String string) {
        return this.logger.errorCheck(bl, this.getClassName(), string, 0);
    }

    protected void errorMessage(String string) {
        this.logger.errorMessage(this.getClassName(), string, 0);
    }

    protected void printStackTrace(Exception exception) {
        this.logger.printStackTrace(exception, 1);
    }
}

