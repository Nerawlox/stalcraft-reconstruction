/*
 * Decompiled with CFR 0.152.
 */
package mods.sound.client;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import javax.vecmath.Vector3f;
import mods.sound.SoundMod;
import mods.sound.client.SoundGraph;
import mods.sound.client.environment.EnvironmentProcessor;
import mods.sound.config.SoundEntry;
import mods.sound.config.SoundGroup;
import mods.sound.config.SoundSource;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.ForgeSubscribe;
import org.apache.commons.io.FilenameUtils;
import org.lwjgl.opengl.GL11;
import paulscode.sound.IStreamListener;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;

public class ClientSoundController
implements nttf {
    private static final ResourceLocation SOUND_ICON = new ResourceLocation("stalkersounds", "textures/sound_icon.png");
    private static final List<String> SUPPORTED_EXTS = Arrays.asList("ogg", "wav");
    private static final String SOURCENAME = "StalkerBG";
    private static final int PLAYING = 0;
    private static final int SILENCE = 1;
    private static final int FAR = 2;
    private long silenceTime = 0L;
    private Set<String> playingGroups = new HashSet<String>();
    public Map<String, SoundGroup> soundGroups = new HashMap<String, SoundGroup>();
    public Multimap<String, SourceGroup> sourceGroups = HashMultimap.create();
    public static boolean enableSoundTick = true;
    private int ticks = 0;
    private float prevVolume = this.getMusicVolume();
    private uiog pool = new uiog(xpzm._E()._S(), "", false);
    private IStreamListener streamListener = this::onSoundEnd;

    public void loadSoundsFrom(String string, String string2) {
        String string3 = "/assets/" + string + string2;
        List<String> list2 = srxe._a(string3);
        for (String string4 : list2) {
            String string5 = FilenameUtils.getExtension(string4);
            if (!SUPPORTED_EXTS.contains(string5)) continue;
            this.pool._a(string + ":" + string4.substring(string3.length()));
        }
    }

    public void setSoundData(long l, Collection<SoundGroup> collection, Collection<SoundSource> collection2) {
        this.sourceGroups.clear();
        this.silenceTime = l;
        for (SoundGroup soundGroup : collection) {
            this.soundGroups.put(soundGroup.getName(), soundGroup);
        }
        this.clusterizeSources(collection2);
        SoundSystemConfig.addStreamListener(this.streamListener);
    }

    public void clusterizeSources(Collection<SoundSource> collection) {
        this.sourceGroups.clear();
        HashMultimap<String, SoundSource> hashMultimap = HashMultimap.create();
        for (SoundSource object : collection) {
            hashMultimap.put(object.getGroup(), object);
        }
        Map map = hashMultimap.asMap();
        for (Map.Entry entry : map.entrySet()) {
            SoundGroup soundGroup = this.soundGroups.get(entry.getKey());
            if (soundGroup == null) continue;
            SoundGraph soundGraph = new SoundGraph((Collection)entry.getValue());
            List<Set<SoundSource>> list2 = soundGraph.getConnectedComponents();
            for (int i = 0; i < list2.size(); ++i) {
                this.sourceGroups.put(soundGroup.getName(), new SourceGroup(i, soundGroup, list2.get(i), 2));
            }
        }
    }

    public void onSoundEnd(String string, int n) {
        if (string.startsWith(SOURCENAME)) {
            String[] stringArray = string.split("\\|");
            String string2 = stringArray[1] + "|" + stringArray[2];
            System.out.println("Received EOS for " + string2 + " with queued " + n);
            this.playingGroups.remove(string2);
        }
    }

    @Override
    public void onGameJoined() {
        this.clearPlayingSources();
        this.ticks = 0;
        this.soundGroups.clear();
        this.sourceGroups.clear();
        this.playingGroups.clear();
    }

    @Override
    public void onTickInGame() {
        xpzm._E().__ah._a("sound_sources");
        jysc jysc2 = jysc._H();
        if (jysc2 != null && jysc2._B() <= 0) {
            EnvironmentProcessor.instance.globalCutoff = (float)(1.0 - jysc2._A() * (double)0.95f);
        }
        if (enableSoundTick) {
            float f = this.getMusicVolume();
            if (++this.ticks % 20 == 0 && f > 0.0f) {
                this.sourceGroups.values().forEach(this::update);
            }
            if (this.prevVolume != f) {
                this.updateGlobalVolume(f);
            }
            this.prevVolume = f;
        }
        xpzm._E().__ah._b();
    }

    @Override
    public void onGameLeft() {
        this.clearPlayingSources();
    }

    private void clearPlayingSources() {
        for (SourceGroup sourceGroup : this.sourceGroups.values()) {
            for (int i = 0; i < sourceGroup.sources.size(); ++i) {
                this.getSoundManager()._c.stop(this.sourceId(sourceGroup, i));
            }
        }
    }

    private void updateGlobalVolume(float f) {
        SoundSystem soundSystem = this.getSoundManager()._c;
        for (SourceGroup sourceGroup : this.sourceGroups.values()) {
            int n = 0;
            for (SoundSource soundSource : sourceGroup.sources) {
                soundSystem.setVolume(this.sourceId(sourceGroup, n++), f * soundSource.getGain());
            }
        }
    }

    @ForgeSubscribe
    public void onRenderWorld(RenderWorldLastEvent renderWorldLastEvent) {
        if (!SoundMod.visualDebug || !xpzm._E()._t.field_71075_bZ._d) {
            return;
        }
        for (SourceGroup sourceGroup : this.sourceGroups.values()) {
            for (SoundSource soundSource : sourceGroup.sources) {
                this.renderSoundSourceInWorld(soundSource.getPos(), sourceGroup.state == 0);
            }
        }
    }

    private void renderSoundSourceInWorld(Vector3f vector3f, boolean bl) {
        float f = (float)((double)vector3f.x - gqqu._d + 0.5);
        float f2 = (float)((double)vector3f.y - gqqu._e + 1.0);
        float f3 = (float)((double)vector3f.z - gqqu._f + 0.5);
        double d = Math.sqrt(f * f + f2 * f2 + f3 * f3);
        double d2 = d > 8.0 ? d * 0.1 * 0.0025 : 0.002;
        xpzm xpzm2 = xpzm._E();
        GL11.glPushMatrix();
        GL11.glDisable(2896);
        GL11.glTranslated(f, f2, f3);
        GL11.glRotatef(-gqqu._b._l, 0.0f, 1.0f, 0.0f);
        float f4 = xpzm2._M.field_74320_O == 2 ? -1.0f : 1.0f;
        GL11.glRotatef(gqqu._b._m * f4, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(-d2, -d2, d2);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        xpzm2._R()._a(SOUND_ICON);
        int n = 128;
        int n2 = 128;
        if (bl) {
            GL11.glColor4f(0.0f, 1.0f, 0.0f, 1.0f);
        } else {
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
        qozx._a(-n / 2, n2 / 2, n, n2, 0.0, 0.0, n, n2, n, n2);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        if (bl) {
            GL11.glColor4f(0.0f, 1.0f, 0.0f, 0.4f);
        } else {
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.4f);
        }
        qozx._a(-n / 2, n2 / 2, n, n2, 0.0, 0.0, n, n2, n, n2);
        GL11.glEnable(2896);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glPopMatrix();
    }

    private void update(SourceGroup sourceGroup) {
        boolean bl;
        if (sourceGroup.sources.isEmpty()) {
            return;
        }
        long l = System.currentTimeMillis();
        int n2 = sourceGroup.state;
        boolean bl2 = false;
        boolean bl3 = bl = n2 == 1 && l - sourceGroup.lastUpdate > this.silenceTime || n2 == 2 && (bl2 = this.isPlayerInRadius(sourceGroup, 1.0f));
        if (n2 == 0) {
            boolean bl4;
            boolean bl5 = false;
            if (l - sourceGroup.lastUpdate > 5000L && this.ticks % 200 == 0 && (bl4 = IntStream.range(0, sourceGroup.sources.size()).noneMatch(n -> this.getSoundManager()._c.playing(this.sourceId(sourceGroup, n))))) {
                System.out.println(sourceGroup.getUniqueId() + " is not really playing");
                this.playingGroups.remove(sourceGroup.getUniqueId());
                bl5 = true;
            }
            if (!bl5 && !(bl2 = this.isPlayerInRadius(sourceGroup, 2.0f))) {
                System.out.println(sourceGroup.getUniqueId() + " not in radius, stopping");
                IntStream.range(0, sourceGroup.sources.size()).forEach(n -> this.getSoundManager()._c.stop(this.sourceId(sourceGroup, n)));
                this.playingGroups.remove(sourceGroup.getUniqueId());
            }
            boolean bl6 = bl = !this.isPlaying(sourceGroup);
        }
        if (bl) {
            this.reselectSound(sourceGroup, bl2 || this.isPlayerInRadius(sourceGroup, 1.0f));
        }
    }

    private boolean isPlaying(SourceGroup sourceGroup) {
        return this.playingGroups.contains(sourceGroup.getUniqueId());
    }

    private boolean isPlayerInRadius(SourceGroup sourceGroup, float f) {
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        for (SoundSource soundSource : sourceGroup.sources) {
            double d;
            double d2;
            float f2 = soundSource.getRolloff() * f;
            if (!((double)(f2 * f2) > (d2 = entityClientPlayerMP.field_70165_t - (double)soundSource.getPos().x) * d2 + (d = entityClientPlayerMP.field_70161_v - (double)soundSource.getPos().z) * d)) continue;
            return true;
        }
        return false;
    }

    private void reselectSound(SourceGroup sourceGroup, boolean bl) {
        long l = System.currentTimeMillis();
        if (!bl) {
            sourceGroup.lastUpdate = l;
            sourceGroup.state = 2;
            sourceGroup.lastPlayed = null;
            return;
        }
        ArrayList<SoundEntry> arrayList = new ArrayList<SoundEntry>(sourceGroup.group.getSounds());
        arrayList.remove(sourceGroup.lastPlayed);
        float f = 0.0f;
        for (SoundEntry soundEntry : arrayList) {
            f += soundEntry.weight;
        }
        f += sourceGroup.group.getSilenceWeight();
        f *= ThreadLocalRandom.current().nextFloat();
        if ((f -= sourceGroup.group.getSilenceWeight()) <= 0.0f) {
            this.play(sourceGroup, null);
            sourceGroup.lastUpdate = l;
            sourceGroup.state = 1;
        } else {
            for (SoundEntry soundEntry : arrayList) {
                if (!((f -= soundEntry.weight) <= 0.0f)) continue;
                this.play(sourceGroup, soundEntry);
                sourceGroup.lastUpdate = l;
                sourceGroup.state = 0;
                return;
            }
        }
    }

    private void play(SourceGroup sourceGroup, SoundEntry soundEntry) {
        sourceGroup.lastPlayed = soundEntry;
        if (soundEntry == null) {
            return;
        }
        String string = soundEntry.path.replace("/", ".");
        xavs xavs2 = this.pool._c("stalkersounds:" + string.substring(0, string.lastIndexOf(".")));
        if (xavs2 == null) {
            return;
        }
        this.playingGroups.add(sourceGroup.getUniqueId());
        SoundSystem soundSystem = this.getSoundManager()._c;
        if (soundSystem.playing("BgMusic")) {
            soundSystem.stop("BgMusic");
        }
        int n = 0;
        for (SoundSource soundSource : sourceGroup.sources) {
            Vector3f vector3f = soundSource.getPos();
            String string2 = this.sourceId(sourceGroup, n++);
            SoundMod.starterThread.addTask(() -> {
                System.out.println("Starting playing " + string2);
                soundSystem.newStreamingSource(true, string2, xavs2._b(), xavs2._a(), false, vector3f.x, vector3f.y, vector3f.z, 2, soundSource.getRolloff());
                soundSystem.setVolume(string2, soundSource.getGain() * this.getMusicVolume());
                soundSystem.play(string2);
            });
        }
    }

    private String sourceId(SourceGroup sourceGroup, int n) {
        return "StalkerBG|" + sourceGroup.getUniqueId() + "|" + n;
    }

    public jzqf getSoundManager() {
        return xpzm._E()._N;
    }

    public float getMusicVolume() {
        return xpzm._E()._M.field_74342_a;
    }

    public class SourceGroup {
        public int id;
        public SoundGroup group;
        public Set<SoundSource> sources;
        public int state = 2;
        public long lastUpdate = -1L;
        public SoundEntry lastPlayed = null;
        public int color;

        public SourceGroup(int n, SoundGroup soundGroup, Set<SoundSource> set, int n2) {
            this.id = n;
            this.group = soundGroup;
            this.sources = set;
            this.state = n2;
            Random random = new Random();
            this.color = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()).getRGB();
        }

        public String getUniqueId() {
            return this.group.getName() + "|" + this.id;
        }
    }
}

