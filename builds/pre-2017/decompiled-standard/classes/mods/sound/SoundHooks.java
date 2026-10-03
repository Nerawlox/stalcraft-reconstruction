/*
 * Decompiled with CFR 0.152.
 */
package mods.sound;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import mods.sound.SoundMod;
import mods.sound.client.environment.EnvironmentProcessor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;
import net.minecraftforge.client.event.sound.PlaySoundEffectEvent;
import net.minecraftforge.client.event.sound.PlaySoundEffectSourceEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.client.event.sound.PlaySoundSourceEvent;
import net.minecraftforge.client.event.sound.PlayStreamingEvent;
import net.minecraftforge.client.event.sound.PlayStreamingSourceEvent;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import paulscode.sound.Channel;
import paulscode.sound.CommandObject;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.libraries.ChannelLWJGLOpenAL;
import paulscode.sound.libraries.SourceLWJGLOpenAL;

public class SoundHooks {
    private static long queueStart = -1L;

    @ezey(_a={eidj.CLIENT})
    @Hook
    public static void tryToSetLibraryAndCodecs(jzqf jzqf2) {
        SoundSystemConfig.setNumberStreamingChannels(8);
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(targetMethod="CommandQueue")
    public static void commandQueuePre(SoundSystem soundSystem, CommandObject commandObject) {
        if (Thread.currentThread().getId() != SoundMod.mainThreadId) {
            return;
        }
        queueStart = System.currentTimeMillis();
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(targetMethod="CommandQueue", injectOnExit=true)
    public static void commandQueuePost(SoundSystem soundSystem, CommandObject commandObject) {
        if (Thread.currentThread().getId() != SoundMod.mainThreadId) {
            return;
        }
        if (queueStart == -1L) {
            System.out.println("Command queue method didnt start");
        } else {
            long l = System.currentTimeMillis() - queueStart;
            if (l > 25L) {
                if (commandObject != null) {
                    System.out.println("Command " + commandObject.Command + " took " + l + " ms");
                } else {
                    System.out.println("Execution of sounds commands took " + l + " ms");
                }
            }
        }
        queueStart = -1L;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(targetMethod="func_130082_a")
    public static void soundManagerInit(jzqf jzqf2, jzqf jzqf3, boolean bl) {
        if (bl) {
            EnvironmentProcessor.instance.setup();
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook
    public static void play(SourceLWJGLOpenAL sourceLWJGLOpenAL, Channel channel) {
        if (!(channel instanceof ChannelLWJGLOpenAL)) {
            return;
        }
        EnvironmentProcessor.instance.onSoundPlay(sourceLWJGLOpenAL, (ChannelLWJGLOpenAL)channel);
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean playSoundAtEntity(ozlu ozlu2, Entity entity, String string, float f, float f2) {
        if (string != null && !string.isEmpty() && !string.contains("step")) {
            PlaySoundAtEntityEvent playSoundAtEntityEvent = new PlaySoundAtEntityEvent(entity, string, f, f2);
            if (!MinecraftForge.EVENT_BUS.post(playSoundAtEntityEvent)) {
                string = playSoundAtEntityEvent.name;
                ozlu2.func_72908_a(entity.field_70165_t, entity.field_70163_u + (double)entity.func_70047_e(), entity.field_70161_v, string, f, f2);
            }
            return true;
        }
        return false;
    }

    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean playSoundToNearExcept(ozlu ozlu2, EntityPlayer entityPlayer, String string, float f, float f2) {
        if (string != null && !string.isEmpty() && !string.contains("step")) {
            PlaySoundAtEntityEvent playSoundAtEntityEvent = new PlaySoundAtEntityEvent(entityPlayer, string, f, f2);
            if (MinecraftForge.EVENT_BUS.post(playSoundAtEntityEvent)) {
                string = playSoundAtEntityEvent.name;
                if (entityPlayer != null && string != null) {
                    for (Object e : ozlu2.field_73021_x) {
                        ((aqaj)e)._a(entityPlayer, string, entityPlayer.field_70165_t, entityPlayer.field_70163_u + (double)entityPlayer.func_70047_e(), entityPlayer.field_70161_v, f, f2);
                    }
                }
            }
            return true;
        }
        return false;
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean playRandomMusicIfReady(jzqf jzqf2) {
        return !SoundMod.instance.soundController.sourceGroups.isEmpty();
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void playStreaming(jzqf jzqf2, String string, float f, float f2, float f3) {
        if (!jzqf2._d || jzqf2._i.field_74340_b == 0.0f && string != null) {
            return;
        }
        String string2 = "streaming";
        SoundMod.starterThread.addTask(() -> {
            if (jzqf2._c.playing("streaming")) {
                jzqf2._c.stop("streaming");
            }
        });
        if (string != null) {
            xavs xavs2 = jzqf2._f._c(string);
            xavs xavs3 = SoundEvent.getResult(new PlayStreamingEvent(jzqf2, xavs2, string, f, f2, f3));
            if (xavs3 == null) {
                return;
            }
            MinecraftForge.EVENT_BUS.post(new PlayStreamingSourceEvent(jzqf2, string2, f, f2, f3));
            SoundMod.starterThread.addTask(() -> {
                if (jzqf2._c.playing("BgMusic")) {
                    jzqf2._c.stop("BgMusic");
                }
                jzqf2._c.newStreamingSource(true, string2, xavs3._b(), xavs3._a(), false, f, f2, f3, 2, 64.0f);
                jzqf2._c.setVolume(string2, 0.5f * jzqf2._i.field_74340_b);
                jzqf2._c.play(string2);
            });
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void playSound(jzqf jzqf2, String string, float f, float f2, float f3, float f4, float f5) {
        SoundHooks.playSound(jzqf2, string, f, f2, f3, f4, f5, false);
    }

    @ezey(_a={eidj.CLIENT})
    public static void playSound(jzqf jzqf2, String string, float f, float f2, float f3, float f4, float f5, boolean bl) {
        if (!jzqf2._d || jzqf2._i.field_74340_b == 0.0f) {
            return;
        }
        xavs xavs2 = jzqf2._e._c(string);
        xavs xavs3 = SoundEvent.getResult(new PlaySoundEvent(jzqf2, xavs2, string, f, f2, f3, f4, f5));
        if (xavs3 != null && f4 > 0.0f) {
            jzqf2._h = (jzqf2._h + 1) % 256;
            String string2 = "sound_" + jzqf2._h;
            float f6 = f4 > 1.0f ? 16.0f * f4 : 16.0f;
            MinecraftForge.EVENT_BUS.post(new PlaySoundSourceEvent(jzqf2, string2, f, f2, f3));
            SoundMod.starterThread.addTask(() -> {
                jzqf2._c.newSource(false, string2, xavs3._b(), xavs3._a(), false, f, f2, f3, 2, f6, bl);
                jzqf2._c.setPitch(string2, f5);
                jzqf2._c.setVolume(string2, Math.min(f4, 1.0f) * 0.25f * jzqf2._i.field_74340_b);
                jzqf2._c.play(string2);
                EnvironmentProcessor.instance.setUpcomingSoundName(string);
            });
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void playSoundFX(jzqf jzqf2, String string, float f, float f2) {
        if (!jzqf2._d || jzqf2._i.field_74340_b == 0.0f) {
            return;
        }
        xavs xavs2 = jzqf2._e._c(string);
        xavs xavs3 = SoundEvent.getResult(new PlaySoundEffectEvent(jzqf2, xavs2, string, f, f2));
        if (xavs3 != null && f > 0.0f) {
            jzqf2._h = (jzqf2._h + 1) % 256;
            String string2 = "sound_" + jzqf2._h;
            MinecraftForge.EVENT_BUS.post(new PlaySoundEffectSourceEvent(jzqf2, string2));
            SoundMod.starterThread.addTask(() -> {
                jzqf2._c.newSource(false, string2, xavs3._b(), xavs3._a(), false, 0.0f, 0.0f, 0.0f, 0, 0.0f);
                jzqf2._c.setPitch(string2, f2);
                jzqf2._c.setVolume(string2, Math.min(1.0f, f) * 0.25f * jzqf2._i.field_74340_b);
                jzqf2._c.play(string2);
            });
        }
    }

    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void setListener(jzqf jzqf2, EntityLivingBase entityLivingBase, float f) {
        if (jzqf2._d && jzqf2._i.field_74340_b != 0.0f && entityLivingBase != null) {
            float f2 = jywc._a(entityLivingBase.field_70127_C, entityLivingBase.field_70125_A, f);
            float f3 = jywc._a(entityLivingBase.field_70126_B, entityLivingBase.field_70177_z, f);
            float f4 = jywc._a((float)entityLivingBase.field_70169_q, (float)entityLivingBase.field_70165_t, f);
            float f5 = jywc._a((float)entityLivingBase.field_70167_r, (float)entityLivingBase.field_70163_u, f);
            float f6 = jywc._a((float)entityLivingBase.field_70166_s, (float)entityLivingBase.field_70161_v, f);
            float f7 = -sajh._a(-f3 * ((float)Math.PI / 180) - (float)Math.PI);
            float f8 = -sajh._a(-f2 * ((float)Math.PI / 180) - (float)Math.PI);
            float f9 = -sajh._b(-f3 * ((float)Math.PI / 180) - (float)Math.PI);
            float f10 = 0.0f;
            float f11 = 1.0f;
            float f12 = 0.0f;
            SoundMod.starterThread.addTask(() -> {
                jzqf2._c.setListenerPosition(f4, f5, f6);
                jzqf2._c.setListenerOrientation(f7, f8, f9, f10, f11, f12);
            });
        }
    }
}

