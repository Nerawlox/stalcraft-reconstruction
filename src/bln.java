/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjp
 *  bjq
 *  blm
 *  blo
 *  blp
 *  blq
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraftforge.client.event.sound.PlayBackgroundMusicEvent
 *  net.minecraftforge.client.event.sound.PlaySoundEffectEvent
 *  net.minecraftforge.client.event.sound.PlaySoundEffectSourceEvent
 *  net.minecraftforge.client.event.sound.PlaySoundEvent
 *  net.minecraftforge.client.event.sound.PlaySoundSourceEvent
 *  net.minecraftforge.client.event.sound.PlayStreamingEvent
 *  net.minecraftforge.client.event.sound.PlayStreamingSourceEvent
 *  net.minecraftforge.client.event.sound.SoundEvent
 *  net.minecraftforge.client.event.sound.SoundLoadEvent
 *  net.minecraftforge.client.event.sound.SoundResultEvent
 *  net.minecraftforge.client.event.sound.SoundSetupEvent
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.Event
 *  org.apache.commons.io.FileUtils
 *  paulscode.sound.SoundSystem
 *  paulscode.sound.SoundSystemConfig
 *  paulscode.sound.SoundSystemException
 *  paulscode.sound.codecs.CodecJOrbis
 *  paulscode.sound.codecs.CodecWav
 *  paulscode.sound.libraries.LibraryLWJGLOpenAL
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import net.minecraftforge.client.event.sound.PlayBackgroundMusicEvent;
import net.minecraftforge.client.event.sound.PlaySoundEffectEvent;
import net.minecraftforge.client.event.sound.PlaySoundEffectSourceEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.client.event.sound.PlaySoundSourceEvent;
import net.minecraftforge.client.event.sound.PlayStreamingEvent;
import net.minecraftforge.client.event.sound.PlayStreamingSourceEvent;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.client.event.sound.SoundResultEvent;
import net.minecraftforge.client.event.sound.SoundSetupEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import org.apache.commons.io.FileUtils;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemException;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;

@SideOnly(value=Side.CLIENT)
public class bln
implements bjq {
    public boolean LOAD_SOUND_SYSTEM = true;
    private static final String[] a = new String[]{"ogg"};
    public SoundSystem b;
    public boolean c;
    public final blq d;
    public final blq e;
    public final blq f;
    private int g;
    private final aul h;
    private final File i;
    private final Set j = new HashSet();
    private final List k = new ArrayList();
    private Random l = new Random();
    private int m = this.l.nextInt(MUSIC_INTERVAL);
    public static int MUSIC_INTERVAL = 12000;

    public bln(bjp par1ResourceManager, aul par2GameSettings, File par3File) {
        this.h = par2GameSettings;
        this.i = par3File;
        this.d = new blq(par1ResourceManager, "sound", true);
        this.e = new blq(par1ResourceManager, "records", false);
        this.f = new blq(par1ResourceManager, "music", true);
        try {
            SoundSystemConfig.addLibrary(LibraryLWJGLOpenAL.class);
            SoundSystemConfig.setCodec((String)"ogg", CodecJOrbis.class);
            SoundSystemConfig.setCodec((String)"wav", CodecWav.class);
            MinecraftForge.EVENT_BUS.post((Event)new SoundSetupEvent(this));
        }
        catch (SoundSystemException soundsystemexception) {
            soundsystemexception.printStackTrace();
            System.err.println("error linking with the LibraryJavaSound plug-in");
        }
        this.h();
    }

    public void a(bjp par1ResourceManager) {
        if (!this.LOAD_SOUND_SYSTEM) {
            return;
        }
        this.d();
        this.b();
        this.i();
        MinecraftForge.EVENT_BUS.post((Event)new SoundLoadEvent(this));
    }

    private void h() {
        if (this.i.isDirectory()) {
            Collection collection = FileUtils.listFiles((File)this.i, (String[])a, (boolean)true);
            for (File file1 : collection) {
                this.a(file1);
            }
        }
    }

    private void a(File par1File) {
        String s2 = this.i.toURI().relativize(par1File.toURI()).getPath();
        int i2 = s2.indexOf("/");
        if (i2 != -1) {
            String s1 = s2.substring(0, i2);
            s2 = s2.substring(i2 + 1);
            if ("sound".equalsIgnoreCase(s1)) {
                this.a(s2);
            } else if ("records".equalsIgnoreCase(s1)) {
                this.b(s2);
            } else if ("music".equalsIgnoreCase(s1)) {
                this.c(s2);
            }
        }
    }

    private synchronized void i() {
        if (!this.c) {
            float f2 = this.h.b;
            float f1 = this.h.a;
            this.h.b = 0.0f;
            this.h.a = 0.0f;
            this.h.b();
            try {
                new Thread((Runnable)new blo(this)).start();
                this.h.b = f2;
                this.h.a = f1;
            }
            catch (RuntimeException runtimeexception) {
                runtimeexception.printStackTrace();
                System.err.println("error starting SoundSystem turning off sounds & music");
                this.h.b = 0.0f;
                this.h.a = 0.0f;
            }
            this.h.b();
        }
    }

    public void a() {
        if (this.c) {
            if (this.h.a == 0.0f) {
                this.b.stop("BgMusic");
                this.b.stop("streaming");
            } else {
                this.b.setVolume("BgMusic", this.h.a);
                this.b.setVolume("streaming", this.h.a);
            }
        }
    }

    public void b() {
        if (this.c) {
            this.b.cleanup();
            this.c = false;
        }
    }

    public void a(String par1Str) {
        this.d.a(par1Str);
    }

    public void b(String par1Str) {
        this.e.a(par1Str);
    }

    public void c(String par1Str) {
        this.f.a(par1Str);
    }

    public void c() {
        if (this.c && this.h.a != 0.0f && !this.b.playing("BgMusic") && !this.b.playing("streaming")) {
            if (this.m > 0) {
                --this.m;
            } else {
                blm soundpoolentry = this.f.a();
                if ((soundpoolentry = SoundEvent.getResult((SoundResultEvent)new PlayBackgroundMusicEvent(this, soundpoolentry))) != null) {
                    this.m = this.l.nextInt(MUSIC_INTERVAL) + MUSIC_INTERVAL;
                    this.b.backgroundMusic("BgMusic", soundpoolentry.b(), soundpoolentry.a(), false);
                    this.b.setVolume("BgMusic", this.h.a);
                    this.b.play("BgMusic");
                }
            }
        }
    }

    public void a(of par1EntityLivingBase, float par2) {
        if (this.c && this.h.b != 0.0f && par1EntityLivingBase != null) {
            float f1 = par1EntityLivingBase.D + (par1EntityLivingBase.B - par1EntityLivingBase.D) * par2;
            float f2 = par1EntityLivingBase.C + (par1EntityLivingBase.A - par1EntityLivingBase.C) * par2;
            double d0 = par1EntityLivingBase.r + (par1EntityLivingBase.u - par1EntityLivingBase.r) * (double)par2;
            double d1 = par1EntityLivingBase.s + (par1EntityLivingBase.v - par1EntityLivingBase.s) * (double)par2;
            double d2 = par1EntityLivingBase.t + (par1EntityLivingBase.w - par1EntityLivingBase.t) * (double)par2;
            float f3 = ls.b(-f2 * ((float)Math.PI / 180) - (float)Math.PI);
            float f4 = ls.a(-f2 * ((float)Math.PI / 180) - (float)Math.PI);
            float f5 = -f4;
            float f6 = -ls.a(-f1 * ((float)Math.PI / 180) - (float)Math.PI);
            float f7 = -f3;
            float f8 = 0.0f;
            float f9 = 1.0f;
            float f10 = 0.0f;
            this.b.setListenerPosition((float)d0, (float)d1, (float)d2);
            this.b.setListenerOrientation(f5, f6, f7, f8, f9, f10);
        }
    }

    public void d() {
        if (this.c) {
            for (String s2 : this.j) {
                this.b.stop(s2);
            }
            this.j.clear();
        }
    }

    public void a(String par1Str, float par2, float par3, float par4) {
        if (this.c && (this.h.b != 0.0f || par1Str == null)) {
            String s1 = "streaming";
            if (this.b.playing(s1)) {
                this.b.stop(s1);
            }
            if (par1Str != null) {
                blm soundpoolentry = this.e.b(par1Str);
                if ((soundpoolentry = SoundEvent.getResult((SoundResultEvent)new PlayStreamingEvent(this, soundpoolentry, par1Str, par2, par3, par4))) != null) {
                    if (this.b.playing("BgMusic")) {
                        this.b.stop("BgMusic");
                    }
                    this.b.newStreamingSource(true, s1, soundpoolentry.b(), soundpoolentry.a(), false, par2, par3, par4, 2, 64.0f);
                    this.b.setVolume(s1, 0.5f * this.h.b);
                    MinecraftForge.EVENT_BUS.post((Event)new PlayStreamingSourceEvent(this, s1, par2, par3, par4));
                    this.b.play(s1);
                }
            }
        }
    }

    public void a(nn par1Entity) {
        this.a(par1Entity, par1Entity);
    }

    public void a(nn par1Entity, nn par2Entity) {
        String s2 = "entity_" + par1Entity.k;
        if (this.j.contains(s2)) {
            if (this.b.playing(s2)) {
                this.b.setPosition(s2, (float)par2Entity.u, (float)par2Entity.v, (float)par2Entity.w);
                this.b.setVelocity(s2, (float)par2Entity.x, (float)par2Entity.y, (float)par2Entity.z);
            } else {
                this.j.remove(s2);
            }
        }
    }

    public boolean b(nn par1Entity) {
        if (par1Entity != null && this.c) {
            String s2 = "entity_" + par1Entity.k;
            return this.b.playing(s2);
        }
        return false;
    }

    public void c(nn par1Entity) {
        String s2;
        if (par1Entity != null && this.c && this.j.contains(s2 = "entity_" + par1Entity.k)) {
            if (this.b.playing(s2)) {
                this.b.stop(s2);
            }
            this.j.remove(s2);
        }
    }

    public void a(nn par1Entity, float par2) {
        String s2;
        if (par1Entity != null && this.c && this.h.b != 0.0f && this.b.playing(s2 = "entity_" + par1Entity.k)) {
            this.b.setVolume(s2, par2 * this.h.b);
        }
    }

    public void b(nn par1Entity, float par2) {
        String s2;
        if (par1Entity != null && this.c && this.h.b != 0.0f && this.b.playing(s2 = "entity_" + par1Entity.k)) {
            this.b.setPitch(s2, par2);
        }
    }

    public void a(String par1Str, nn par2Entity, float par3, float par4, boolean par5) {
        if (this.c && (this.h.b != 0.0f || par1Str == null) && par2Entity != null) {
            String s1 = "entity_" + par2Entity.k;
            if (this.j.contains(s1)) {
                this.a(par2Entity);
            } else {
                blm soundpoolentry;
                if (this.b.playing(s1)) {
                    this.b.stop(s1);
                }
                if (par1Str != null && (soundpoolentry = this.d.b(par1Str)) != null && par3 > 0.0f) {
                    float f2 = 16.0f;
                    if (par3 > 1.0f) {
                        f2 *= par3;
                    }
                    this.b.newSource(par5, s1, soundpoolentry.b(), soundpoolentry.a(), false, (float)par2Entity.u, (float)par2Entity.v, (float)par2Entity.w, 2, f2);
                    this.b.setLooping(s1, true);
                    this.b.setPitch(s1, par4);
                    if (par3 > 1.0f) {
                        par3 = 1.0f;
                    }
                    this.b.setVolume(s1, par3 * this.h.b);
                    this.b.setVelocity(s1, (float)par2Entity.x, (float)par2Entity.y, (float)par2Entity.z);
                    this.b.play(s1);
                    this.j.add(s1);
                }
            }
        }
    }

    public void a(String par1Str, float par2, float par3, float par4, float par5, float par6) {
        if (this.c && this.h.b != 0.0f) {
            blm soundpoolentry = this.d.b(par1Str);
            if ((soundpoolentry = SoundEvent.getResult((SoundResultEvent)new PlaySoundEvent(this, soundpoolentry, par1Str, par2, par3, par4, par5, par6))) != null && par5 > 0.0f) {
                this.g = (this.g + 1) % 256;
                String s1 = "sound_" + this.g;
                float f5 = 16.0f;
                if (par5 > 1.0f) {
                    f5 *= par5;
                }
                this.b.newSource(par5 > 1.0f, s1, soundpoolentry.b(), soundpoolentry.a(), false, par2, par3, par4, 2, f5);
                if (par5 > 1.0f) {
                    par5 = 1.0f;
                }
                this.b.setPitch(s1, par6);
                this.b.setVolume(s1, par5 * this.h.b);
                MinecraftForge.EVENT_BUS.post((Event)new PlaySoundSourceEvent(this, s1, par2, par3, par4));
                this.b.play(s1);
            }
        }
    }

    public void a(String par1Str, float par2, float par3) {
        if (this.c && this.h.b != 0.0f) {
            blm soundpoolentry = this.d.b(par1Str);
            if ((soundpoolentry = SoundEvent.getResult((SoundResultEvent)new PlaySoundEffectEvent(this, soundpoolentry, par1Str, par2, par3))) != null && par2 > 0.0f) {
                this.g = (this.g + 1) % 256;
                String s1 = "sound_" + this.g;
                this.b.newSource(false, s1, soundpoolentry.b(), soundpoolentry.a(), false, 0.0f, 0.0f, 0.0f, 0, 0.0f);
                if (par2 > 1.0f) {
                    par2 = 1.0f;
                }
                this.b.setPitch(s1, par3);
                this.b.setVolume(s1, (par2 *= 0.25f) * this.h.b);
                MinecraftForge.EVENT_BUS.post((Event)new PlaySoundEffectSourceEvent(this, s1));
                this.b.play(s1);
            }
        }
    }

    public void e() {
        for (String s2 : this.j) {
            this.b.pause(s2);
        }
    }

    public void f() {
        for (String s2 : this.j) {
            this.b.play(s2);
        }
    }

    public void g() {
        if (!this.k.isEmpty()) {
            Iterator iterator = this.k.iterator();
            while (iterator.hasNext()) {
                blp scheduledsound = (blp)iterator.next();
                --scheduledsound.g;
                if (scheduledsound.g > 0) continue;
                this.a(scheduledsound.a, scheduledsound.b, scheduledsound.c, scheduledsound.d, scheduledsound.e, scheduledsound.f);
                iterator.remove();
            }
        }
    }

    public void a(String par1Str, float par2, float par3, float par4, float par5, float par6, int par7) {
        this.k.add(new blp(par1Str, par2, par3, par4, par5, par6, par7));
    }

    static SoundSystem a(bln par0SoundManager, SoundSystem par1SoundSystem) {
        par0SoundManager.b = par1SoundSystem;
        return par0SoundManager.b;
    }

    static boolean a(bln par0SoundManager, boolean par1) {
        par0SoundManager.c = par1;
        return par0SoundManager.c;
    }
}

