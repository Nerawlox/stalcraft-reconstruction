/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.stalker.mobs.StalkerMobsHooks;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import mods.sound.SoundHooks;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.client.event.sound.PlayBackgroundMusicEvent;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.client.event.sound.SoundSetupEvent;
import net.minecraftforge.common.MinecraftForge;
import org.apache.commons.io.FileUtils;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemException;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;

@SideOnly(value=Side.CLIENT)
public class jzqf
implements cvkw {
    public boolean _a = true;
    public static final String[] _b = new String[]{"ogg"};
    public SoundSystem _c;
    public boolean _d;
    public final uiog _e;
    public final uiog _f;
    public final uiog _g;
    public int _h;
    public final GameSettings _i;
    public final File _j;
    public final Set _k = new HashSet();
    public final List _l = new ArrayList();
    public Random _m = new Random();
    public int _n = this._m.nextInt(_o);
    public static int _o = 12000;

    public jzqf(xsfs xsfs2, GameSettings gameSettings, File file) {
        this._i = gameSettings;
        this._j = file;
        this._e = new uiog(xsfs2, "sound", true);
        this._f = new uiog(xsfs2, "records", false);
        this._g = new uiog(xsfs2, "music", true);
        try {
            SoundSystemConfig.addLibrary(LibraryLWJGLOpenAL.class);
            SoundSystemConfig.setCodec("ogg", CodecJOrbis.class);
            SoundSystemConfig.setCodec("wav", CodecWav.class);
            MinecraftForge.EVENT_BUS.post(new SoundSetupEvent(this));
        }
        catch (SoundSystemException soundSystemException) {
            soundSystemException.printStackTrace();
            System.err.println("error linking with the LibraryJavaSound plug-in");
        }
        this._a();
    }

    @Override
    public void func_110549_a(xsfs xsfs2) {
        if (!this._a) {
            return;
        }
        this._f();
        this._d();
        this._b();
        MinecraftForge.EVENT_BUS.post(new SoundLoadEvent(this));
    }

    public void _a() {
        if (this._j.isDirectory()) {
            Collection<File> collection = FileUtils.listFiles(this._j, _b, true);
            for (File file : collection) {
                this._a(file);
            }
        }
    }

    public void _a(File file) {
        String string = this._j.toURI().relativize(file.toURI()).getPath();
        int n = string.indexOf("/");
        if (n != -1) {
            String string2 = string.substring(0, n);
            string = string.substring(n + 1);
            if ("sound".equalsIgnoreCase(string2)) {
                this._a(string);
            } else if ("records".equalsIgnoreCase(string2)) {
                this._b(string);
            } else if ("music".equalsIgnoreCase(string2)) {
                this._c(string);
            }
        }
    }

    public synchronized void _b() {
        SoundHooks.tryToSetLibraryAndCodecs(this);
        boolean bl = GloomyHooks.tryToSetLibraryAndCodecs(this);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        if (!this._d) {
            float f = this._i.field_74340_b;
            float f2 = this._i.field_74342_a;
            this._i.field_74340_b = 0.0f;
            this._i.field_74342_a = 0.0f;
            this._i.func_74303_b();
            try {
                new Thread(new dyad(this)).start();
                this._i.field_74340_b = f;
                this._i.field_74342_a = f2;
            }
            catch (RuntimeException runtimeException) {
                runtimeException.printStackTrace();
                System.err.println("error starting SoundSystem turning off sounds & music");
                this._i.field_74340_b = 0.0f;
                this._i.field_74342_a = 0.0f;
            }
            this._i.func_74303_b();
        }
    }

    public void _c() {
        if (this._d) {
            if (this._i.field_74342_a == 0.0f) {
                this._c.stop("BgMusic");
                this._c.stop("streaming");
            } else {
                this._c.setVolume("BgMusic", this._i.field_74342_a);
                this._c.setVolume("streaming", this._i.field_74342_a);
            }
        }
    }

    public void _d() {
        GloomyHooks.cleanup(this);
    }

    public void _a(String string) {
        this._e._a(string);
    }

    public void _b(String string) {
        this._f._a(string);
    }

    public void _c(String string) {
        this._g._a(string);
    }

    public void _e() {
        boolean bl = SoundHooks.playRandomMusicIfReady(this);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        if (this._d && this._i.field_74342_a != 0.0f && !this._c.playing("BgMusic") && !this._c.playing("streaming")) {
            if (this._n > 0) {
                --this._n;
            } else {
                xavs xavs2 = this._g._a();
                if ((xavs2 = SoundEvent.getResult(new PlayBackgroundMusicEvent(this, xavs2))) != null) {
                    this._n = this._m.nextInt(_o) + _o;
                    this._c.backgroundMusic("BgMusic", xavs2._b(), xavs2._a(), false);
                    this._c.setVolume("BgMusic", this._i.field_74342_a);
                    this._c.play("BgMusic");
                }
            }
        }
    }

    public void _a(EntityLivingBase entityLivingBase, float f) {
        SoundHooks.setListener(this, entityLivingBase, f);
    }

    public void _f() {
        if (this._d) {
            for (String string : this._k) {
                this._c.stop(string);
            }
            this._k.clear();
        }
        StalkerMobsHooks.stopAllSounds(this);
    }

    public void _a(String string, float f, float f2, float f3) {
        SoundHooks.playStreaming(this, string, f, f2, f3);
    }

    public void _a(Entity entity) {
        this._a(entity, entity);
    }

    public void _a(Entity entity, Entity entity2) {
        String string = "entity_" + entity.field_70157_k;
        if (this._k.contains(string)) {
            if (this._c.playing(string)) {
                this._c.setPosition(string, (float)entity2.field_70165_t, (float)entity2.field_70163_u, (float)entity2.field_70161_v);
                this._c.setVelocity(string, (float)entity2.field_70159_w, (float)entity2.field_70181_x, (float)entity2.field_70179_y);
            } else {
                this._k.remove(string);
            }
        }
    }

    public boolean _b(Entity entity) {
        if (entity != null && this._d) {
            String string = "entity_" + entity.field_70157_k;
            return this._c.playing(string);
        }
        return false;
    }

    public void _c(Entity entity) {
        String string;
        if (entity != null && this._d && this._k.contains(string = "entity_" + entity.field_70157_k)) {
            if (this._c.playing(string)) {
                this._c.stop(string);
            }
            this._k.remove(string);
        }
    }

    public void _a(Entity entity, float f) {
        String string;
        if (entity != null && this._d && this._i.field_74340_b != 0.0f && this._c.playing(string = "entity_" + entity.field_70157_k)) {
            this._c.setVolume(string, f * this._i.field_74340_b);
        }
    }

    public void _b(Entity entity, float f) {
        String string;
        if (entity != null && this._d && this._i.field_74340_b != 0.0f && this._c.playing(string = "entity_" + entity.field_70157_k)) {
            this._c.setPitch(string, f);
        }
    }

    public void _a(String string, Entity entity, float f, float f2, boolean bl) {
        if (this._d && (this._i.field_74340_b != 0.0f || string == null) && entity != null) {
            String string2 = "entity_" + entity.field_70157_k;
            if (this._k.contains(string2)) {
                this._a(entity);
            } else {
                xavs xavs2;
                if (this._c.playing(string2)) {
                    this._c.stop(string2);
                }
                if (string != null && (xavs2 = this._e._c(string)) != null && f > 0.0f) {
                    float f3 = 16.0f;
                    if (f > 1.0f) {
                        f3 *= f;
                    }
                    this._c.newSource(bl, string2, xavs2._b(), xavs2._a(), false, (float)entity.field_70165_t, (float)entity.field_70163_u, (float)entity.field_70161_v, 2, f3);
                    this._c.setLooping(string2, true);
                    this._c.setPitch(string2, f2);
                    if (f > 1.0f) {
                        f = 1.0f;
                    }
                    this._c.setVolume(string2, f * this._i.field_74340_b);
                    this._c.setVelocity(string2, (float)entity.field_70159_w, (float)entity.field_70181_x, (float)entity.field_70179_y);
                    this._c.play(string2);
                    this._k.add(string2);
                }
            }
        }
    }

    public void _a(String string, float f, float f2, float f3, float f4, float f5) {
        SoundHooks.playSound(this, string, f, f2, f3, f4, f5);
    }

    public void _a(String string, float f, float f2) {
        SoundHooks.playSoundFX(this, string, f, f2);
    }

    public void _g() {
        for (String string : this._k) {
            this._c.pause(string);
        }
    }

    public void _h() {
        for (String string : this._k) {
            this._c.play(string);
        }
    }

    public void _i() {
        if (!this._l.isEmpty()) {
            Iterator iterator2 = this._l.iterator();
            while (iterator2.hasNext()) {
                dyaj dyaj2 = (dyaj)iterator2.next();
                --dyaj2._g;
                if (dyaj2._g > 0) continue;
                this._a(dyaj2._a, dyaj2._b, dyaj2._c, dyaj2._d, dyaj2._e, dyaj2._f);
                iterator2.remove();
            }
        }
    }

    public void _a(String string, float f, float f2, float f3, float f4, float f5, int n) {
        this._l.add(new dyaj(string, f, f2, f3, f4, f5, n));
    }

    public static SoundSystem _a(jzqf jzqf2, SoundSystem soundSystem) {
        jzqf2._c = soundSystem;
        return jzqf2._c;
    }

    public static boolean _a(jzqf jzqf2, boolean bl) {
        SoundHooks.soundManagerInit(null, jzqf2, bl);
        jzqf2._d = bl;
        return jzqf2._d;
    }
}

