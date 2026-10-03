/*
 * Decompiled with CFR 0.152.
 */
package mods.sound.client.environment;

import carpentersblocks.block.BlockBase;
import java.nio.IntBuffer;
import mods.sound.SoundHooks;
import mods.sound.SoundMod;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.util.amww;
import net.minecraft.util.ezfa;
import net.minecraft.util.hank;
import net.minecraft.util.iurn;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.AL11;
import org.lwjgl.openal.EFX10;
import org.lwjgl.openal.EFXUtil;
import paulscode.sound.Vector3D;
import paulscode.sound.libraries.ChannelLWJGLOpenAL;
import paulscode.sound.libraries.SourceLWJGLOpenAL;

public class EnvironmentProcessor {
    private static iurn vecPool = new iurn(100, 1000);
    public static EnvironmentProcessor instance = new EnvironmentProcessor();
    public static final Reverb REVERB_SMALL = new Reverb(0.15f, 0.0f, 1.0f, 0.2f, 0.99f, 0.6f, 2.5f, 0.001f, 1.26f, 0.011f, 0.944f, 0.16f);
    public static final Reverb REVERB_MEDIUM = new Reverb(0.55f, 0.0f, 1.0f, 0.3f, 0.99f, 0.7f, 0.2f, 0.015f, 1.26f, 0.011f, 0.944f, 0.15f);
    public static final Reverb REVERB_BIG = new Reverb(1.68f, 0.1f, 1.0f, 0.5f, 0.99f, 0.7f, 0.0f, 0.021f, 1.26f, 0.021f, 0.944f, 0.13f);
    public static final Reverb REVERB_LARGE = new Reverb(4.142f, 0.5f, 1.0f, 0.4f, 0.89f, 0.7f, 0.0f, 0.025f, 1.26f, 0.021f, 0.944f, 0.11f);
    public static final Reverb[] REVERBS = new Reverb[]{REVERB_SMALL, REVERB_MEDIUM, REVERB_BIG, REVERB_LARGE};
    private IntBuffer auxSlots;
    private IntBuffer effects;
    private IntBuffer filters;
    private int directFilter;
    private String upcomingSoundName;
    public float globalCutoff = 1.0f;

    public void setup() {
        int n;
        if (!EFXUtil.isEfxSupported()) {
            throw new IllegalStateException("ALC_EXT_EFX not present in the system");
        }
        System.out.println("ALC_EXT_EFX found");
        if (!EFXUtil.isEffectSupported(32768)) {
            throw new IllegalStateException("EAXREVERB is not supported!");
        }
        if (!EFXUtil.isFilterSupported(1)) {
            throw new IllegalStateException("LOWPASS is not supported!");
        }
        this.auxSlots = BufferUtils.createIntBuffer(4);
        for (n = 0; n < 4; ++n) {
            this.auxSlots.put(n, EFX10.alGenAuxiliaryEffectSlots());
        }
        this.effects = BufferUtils.createIntBuffer(4);
        EFX10.alGenEffects(this.effects);
        this.filters = BufferUtils.createIntBuffer(4);
        EFX10.alGenFilters(this.filters);
        System.out.println("Allocated buffers");
        for (n = 0; n < 4; ++n) {
            EFX10.alEffecti(this.effects.get(n), 32769, 32768);
            EFX10.alFilteri(this.filters.get(n), 32769, 1);
            this.applyReverb(REVERBS[n], this.auxSlots.get(n), this.effects.get(n));
            this.checkAlError();
        }
        this.directFilter = EFX10.alGenFilters();
        EFX10.alFilteri(this.directFilter, 32769, 1);
        System.out.println("Created effects, filters and reverbs");
        this.checkAlError();
    }

    public void setUpcomingSoundName(String string) {
        this.upcomingSoundName = string;
    }

    private float calculateOcclusion(ozlu ozlu2, ofbx ofbx2, ofbx ofbx3, int n) {
        hank hank2;
        ofbx ofbx4 = ofbx2._a(ofbx3)._a();
        ofbx ofbx5 = ofbx2;
        float f = 0.0f;
        for (int i = 0; i < n && (hank2 = this.customBlockRaytrace(ozlu2, ofbx5, ofbx3, true)) != null && hank2._c == amww._a; ++i) {
            twgu twgu2 = twgu.field_71973_m[ozlu2.func_72798_a(hank2._d, hank2._e, hank2._f)];
            if (twgu2 != null) {
                ndrq.kjui kjui2 = sbzn._c._a(twgu2.field_71990_ca, 0);
                float f2 = kjui2 != null ? kjui2._f : (twgu2.func_71926_d() ? 0.5f : 0.15f);
                f += f2;
            }
            ofbx5 = hank2._h._c(ofbx4._c * 0.1, ofbx4._d * 0.1, ofbx4._e * 0.1);
        }
        return f;
    }

    private float evaluateSoundRays(ozlu ozlu2, ofbx ofbx2, ofbx ofbx3, float[] fArray, float[] fArray2, int n, int n2) {
        float f = 0.0f;
        float f2 = 1.618f;
        float f3 = (float)((double)f2 * Math.PI * 2.0);
        float f4 = 128.0f;
        float f5 = 1.0f / (float)(n * n2);
        block0: for (int i = 0; i < n; ++i) {
            ofbx ofbx4;
            float f6 = i;
            float f7 = f6 / (float)n;
            float f8 = f3 * f6;
            float f9 = (float)Math.asin(f7 * 2.0f - 1.0f);
            ofbx ofbx5 = vecPool._a(Math.cos(f9) * Math.cos(f8), Math.cos(f9) * Math.sin(f8), Math.sin(f9));
            ofbx ofbx6 = vecPool._a(ofbx2._c, ofbx2._d, ofbx2._e);
            hank hank2 = this.customBlockRaytrace(ozlu2, ofbx6, ofbx4 = ofbx2._c(ofbx5._c * (double)f4, ofbx5._d * (double)f4, ofbx5._e * (double)f4), true);
            if (hank2 == null) continue;
            float f10 = (float)ofbx2._d(hank2._h);
            int n3 = hank2._d;
            int n4 = hank2._e;
            int n5 = hank2._f;
            ofbx ofbx7 = hank2._h;
            ofbx ofbx8 = this.getDirection(hank2._g);
            ofbx ofbx9 = ofbx5;
            float f11 = f10;
            for (int j = 0; j < n2; ++j) {
                ofbx ofbx10 = this.getReflectedVector(ofbx9, ofbx8);
                ofbx ofbx11 = ofbx7._c(ofbx8._c * 0.01, ofbx8._d * 0.01, ofbx8._e * 0.01);
                ofbx ofbx12 = ofbx11._c(ofbx10._c * (double)f4, ofbx10._d * (double)f4, ofbx10._e * (double)f4);
                float f12 = this.getBlockReflection(n3, n4, n5);
                float f13 = 0.25f * (f12 * 0.75f + 0.25f);
                hank hank3 = this.customBlockRaytrace(ozlu2, ofbx11, ofbx12, true);
                if (hank3 == null) {
                    f11 = (float)((double)f11 + ofbx7._d(ofbx3));
                } else {
                    double d = ofbx7._d(hank3._h);
                    int n6 = j;
                    fArray2[n6] = fArray2[n6] + f12;
                    f11 = (float)((double)f11 + d);
                    ofbx7 = hank3._h;
                    ofbx8 = this.getDirection(hank3._g);
                    ofbx9 = ofbx10;
                    n3 = hank3._d;
                    n4 = hank3._e;
                    n5 = hank3._f;
                    ofbx ofbx13 = ofbx7._c(ofbx8._c * 0.01, ofbx8._d * 0.01, ofbx8._e * 0.01);
                    hank hank4 = this.customBlockRaytrace(ozlu2, ofbx13, ofbx3, true);
                    if (hank4 == null) {
                        f += 1.0f;
                    }
                }
                float f14 = (float)(Math.max((double)f11, 0.0) * (double)0.12f * (double)f12);
                float f15 = 1.0f - sajh._a(Math.abs(f14 - 0.0f), 0.0f, 1.0f);
                float f16 = 1.0f - sajh._a(Math.abs(f14 - 1.0f), 0.0f, 1.0f);
                float f17 = 1.0f - sajh._a(Math.abs(f14 - 2.0f), 0.0f, 1.0f);
                float f18 = sajh._a(f14 - 2.0f, 0.0f, 1.0f);
                fArray[0] = fArray[0] + f15 * f13 * 6.4f * f5;
                fArray[1] = fArray[1] + f16 * f13 * 12.8f * f5;
                fArray[2] = fArray[2] + f17 * f13 * 12.8f * f5;
                fArray[3] = fArray[3] + f18 * f13 * 12.8f * f5;
                if (hank3 == null) continue block0;
            }
        }
        return f;
    }

    private void simulateEnvironment(String string, int n, ofbx ofbx2, ofbx ofbx3) {
        int n2;
        float f;
        xpzm xpzm2 = xpzm._E();
        ofbx ofbx4 = ofbx3;
        if (xpzm2._r.func_72798_a((int)ofbx3._c, (int)ofbx3._d, (int)ofbx3._e) > 0) {
            ofbx ofbx5 = ofbx4._a(ofbx2);
            double d = ofbx5._b();
            double d2 = 0.8;
            ofbx4 = ofbx4._c(ofbx5._c / d * d2, ofbx5._d / d * d2, ofbx5._e / d * d2);
        }
        float f2 = 1.0f;
        float f3 = this.calculateOcclusion(xpzm2._r, ofbx4, ofbx2, 10);
        float f4 = (float)Math.exp(-f3 * f2);
        float[] fArray = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        float[] fArray2 = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
        int n3 = 32;
        int n4 = 4;
        float[] fArray3 = new float[n4];
        float f5 = this.evaluateSoundRays(xpzm2._r, ofbx4, ofbx2, fArray, fArray3, n3, n4);
        for (int i = 0; i < fArray3.length; ++i) {
            fArray3[i] = fArray3[i] / (float)n3;
        }
        float f6 = 1.0f / (float)(n3 * n4);
        f5 *= 64.0f * f6;
        float[] fArray4 = new float[4];
        for (int i = 0; i < fArray4.length; ++i) {
            float f7 = Math.max(20.0f - 5.0f * (float)i, 10.0f);
            fArray4[i] = sajh._a(f5 / f7, 0.0f, 1.0f);
        }
        float f8 = 0.0f;
        for (int i = 0; i < fArray2.length; ++i) {
            f = fArray4[i];
            fArray2[i] = (float)Math.exp(-f3 * f2 * (i > 1 ? 1.5f : 1.0f)) * (1.0f - f) + f;
            f8 += f;
        }
        float f9 = f8 / (float)fArray4.length;
        f4 = Math.max((float)Math.pow(f9, 0.5), f4);
        f = (float)Math.pow(f4, 0.1);
        fArray[1] = fArray[1] * fArray3[1];
        fArray[2] = fArray[2] * (float)Math.pow(fArray3[2], 3.0);
        fArray[3] = fArray[3] * (float)Math.pow(fArray3[3], 4.0);
        fArray[0] = sajh._a(fArray[0], 0.0f, 1.0f);
        fArray[1] = sajh._a(fArray[1], 0.0f, 1.0f);
        fArray[2] = sajh._a(fArray[2] * 1.05f - 0.05f, 0.0f, 1.0f);
        fArray[3] = sajh._a(fArray[3] * 1.05f - 0.05f, 0.0f, 1.0f);
        for (n2 = 0; n2 < fArray.length; ++n2) {
            int n5 = n2;
            fArray[n5] = fArray[n5] * (float)Math.pow(fArray2[n2], 0.1);
        }
        n2 = xpzm2._t.func_70090_H() ? 1 : 0;
        for (int i = 0; i < fArray2.length; ++i) {
            int n6 = i;
            fArray2[n6] = fArray2[n6] * (this.globalCutoff * (n2 != 0 ? 0.4f : 1.0f));
        }
        this.applySourceSettings(n, fArray, fArray2, f4 *= this.globalCutoff, f);
        vecPool._a();
    }

    public void onSoundPlay(SourceLWJGLOpenAL sourceLWJGLOpenAL, ChannelLWJGLOpenAL channelLWJGLOpenAL) {
        try {
            EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
            if (entityClientPlayerMP == null) {
                return;
            }
            ofbx ofbx2 = vecPool._a(entityClientPlayerMP.field_70165_t, entityClientPlayerMP.field_70163_u + (double)entityClientPlayerMP.func_70047_e(), entityClientPlayerMP.field_70161_v);
            Vector3D vector3D = sourceLWJGLOpenAL.position;
            ofbx ofbx3 = vecPool._a(vector3D.x, vector3D.y, vector3D.z);
            int n = channelLWJGLOpenAL.ALSource.get(0);
            if (SoundMod.simulateEnvironment.enabled && vector3D.y > 0.0f) {
                this.simulateEnvironment(sourceLWJGLOpenAL.sourcename, n, ofbx2, ofbx3);
            } else {
                this.applySourceSettings(n, new float[]{0.0f, 0.0f, 0.0f, 0.0f}, new float[]{1.0f, 1.0f, 1.0f, 1.0f}, 1.0f, 1.0f);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public float getBlockReflection(int n, int n2, int n3) {
        int n4;
        xpzm xpzm2 = xpzm._E();
        int n5 = xpzm2._r.func_72798_a(n, n2, n3);
        ndrq.kjui kjui2 = sbzn._c._a(n5, n4 = xpzm2._r.func_72805_g(n, n2, n3));
        if (kjui2 != null) {
            return kjui2._e;
        }
        twgu twgu2 = twgu.field_71973_m[n5];
        if (twgu2 != null) {
            uioo uioo2 = twgu2.field_72020_cn;
            if (uioo2 == twgu.field_71976_h) {
                return 1.0f;
            }
            if (uioo2 == twgu.field_71967_e) {
                return 0.4f;
            }
            if (uioo2 == twgu.field_71964_f) {
                return 0.3f;
            }
            if (uioo2 == twgu.field_71965_g) {
                return 0.5f;
            }
            if (uioo2 == twgu.field_71977_i) {
                return 1.0f;
            }
            if (uioo2 == twgu.field_71974_j) {
                return 0.5f;
            }
            if (uioo2 == twgu.field_71975_k) {
                return 0.05f;
            }
            if (uioo2 == twgu.field_71972_l) {
                return 0.2f;
            }
            if (uioo2 == twgu.field_82509_m) {
                return 0.2f;
            }
            if (uioo2 == twgu.field_82507_n) {
                return 0.4f;
            }
            if (uioo2 == twgu.field_82508_o) {
                return 1.0f;
            }
        }
        return 0.5f;
    }

    public void playSoundRelatively(String string, float f, float f2, float f3, float f4, float f5, boolean bl, boolean bl2) {
        xpzm xpzm2 = xpzm._E();
        jzqf jzqf2 = xpzm2._N;
        if (bl && !bl2) {
            f = (float)((double)f - xpzm2._t.field_70165_t);
            f2 = (float)((double)f2 - (xpzm2._t.field_70163_u + (double)xpzm2._t.func_70047_e()));
            f3 = (float)((double)f3 - xpzm2._t.field_70161_v);
        }
        SoundHooks.playSound(jzqf2, string, f, f2, f3, f4, f5, bl);
    }

    private ofbx getReflectedVector(ofbx ofbx2, ofbx ofbx3) {
        double d = ofbx2._b(ofbx3);
        double d2 = ofbx2._c - 2.0 * d * ofbx3._c;
        double d3 = ofbx2._d - 2.0 * d * ofbx3._d;
        double d4 = ofbx2._e - 2.0 * d * ofbx3._e;
        return vecPool._a(d2, d3, d4);
    }

    private ofbx getDirection(int n) {
        ezfa ezfa2 = ezfa._a(n);
        return vecPool._a(ezfa2._a(), ezfa2._b(), ezfa2._c());
    }

    public void applySourceSettings(int n, float[] fArray, float[] fArray2, float f, float f2) {
        for (int i = 0; i < 4; ++i) {
            EFX10.alFilterf(this.filters.get(i), 1, fArray[i]);
            EFX10.alFilterf(this.filters.get(i), 2, fArray2[i]);
            AL11.alSource3i(n, 131078, this.auxSlots.get(i), i, this.filters.get(i));
        }
        EFX10.alFilterf(this.directFilter, 1, f2);
        EFX10.alFilterf(this.directFilter, 2, f);
        AL10.alSourcei(n, 131077, this.directFilter);
    }

    public void applyReverb(Reverb reverb, int n, int n2) {
        EFX10.alEffectf(n2, 1, reverb.density);
        EFX10.alEffectf(n2, 2, reverb.diffusion);
        EFX10.alEffectf(n2, 3, reverb.gain);
        EFX10.alEffectf(n2, 4, reverb.gainHF);
        EFX10.alEffectf(n2, 6, reverb.decayTime);
        EFX10.alEffectf(n2, 7, reverb.decayHFRatio);
        EFX10.alEffectf(n2, 9, reverb.reflectionsGain);
        EFX10.alEffectf(n2, 12, reverb.lateReverbGain);
        EFX10.alEffectf(n2, 13, reverb.lateReverbDelay);
        EFX10.alEffectf(n2, 19, reverb.airAbsirptionGainHF);
        EFX10.alEffectf(n2, 22, reverb.roomRolloffFactor);
        EFX10.alAuxiliaryEffectSloti(n, 1, n2);
    }

    private void checkAlError() {
        int n = AL10.alGetError();
        if (n == 0) {
            return;
        }
        if (n == 40961) {
            throw new IllegalStateException("AL_INVALID_NAME");
        }
        if (n == 40962) {
            throw new IllegalStateException("AL_INVALID_ENUM");
        }
        if (n == 40963) {
            throw new IllegalStateException("AL_INVALID_VALUE");
        }
        if (n == 40964) {
            throw new IllegalStateException("AL_INVALID_OPERATION");
        }
        if (n == 40965) {
            throw new IllegalStateException("AL_OUT_OF_MEMORY");
        }
        throw new IllegalStateException("Unknown  AL exception: " + n);
    }

    private hank customBlockRaytrace(ozlu ozlu2, ofbx ofbx2, ofbx ofbx3, boolean bl) {
        hank hank2;
        int n;
        int n2;
        int n3 = sajh._c(ofbx3._c);
        int n4 = sajh._c(ofbx3._d);
        int n5 = sajh._c(ofbx3._e);
        int n6 = sajh._c(ofbx2._c);
        int n7 = ozlu2.func_72798_a(n6, n2 = sajh._c(ofbx2._d), n = sajh._c(ofbx2._e));
        twgu twgu2 = twgu.field_71973_m[n7];
        if (twgu2 != null && n7 > 0 && (!bl || twgu2.func_71926_d() || twgu2 instanceof BlockBase) && twgu2.func_71913_a(0, false) && (hank2 = this.raytraceBlock(twgu2, ozlu2, n6, n2, n, ofbx2, ofbx3)) != null) {
            return hank2;
        }
        n7 = 200;
        while (n7-- >= 0) {
            hank hank3;
            int n8;
            twgu twgu3;
            int n9;
            if (Double.isNaN(ofbx2._c) || Double.isNaN(ofbx2._d) || Double.isNaN(ofbx2._e)) {
                return null;
            }
            if (n6 == n3 && n2 == n4 && n == n5) {
                return null;
            }
            boolean bl2 = true;
            boolean bl3 = true;
            boolean bl4 = true;
            double d = 999.0;
            double d2 = 999.0;
            double d3 = 999.0;
            if (n3 > n6) {
                d = (double)n6 + 1.0;
            } else if (n3 < n6) {
                d = (double)n6 + 0.0;
            } else {
                bl2 = false;
            }
            if (n4 > n2) {
                d2 = (double)n2 + 1.0;
            } else if (n4 < n2) {
                d2 = (double)n2 + 0.0;
            } else {
                bl3 = false;
            }
            if (n5 > n) {
                d3 = (double)n + 1.0;
            } else if (n5 < n) {
                d3 = (double)n + 0.0;
            } else {
                bl4 = false;
            }
            double d4 = 999.0;
            double d5 = 999.0;
            double d6 = 999.0;
            double d7 = ofbx3._c - ofbx2._c;
            double d8 = ofbx3._d - ofbx2._d;
            double d9 = ofbx3._e - ofbx2._e;
            if (bl2) {
                d4 = (d - ofbx2._c) / d7;
            }
            if (bl3) {
                d5 = (d2 - ofbx2._d) / d8;
            }
            if (bl4) {
                d6 = (d3 - ofbx2._e) / d9;
            }
            if (d4 < d5 && d4 < d6) {
                n9 = n3 > n6 ? 4 : 5;
                ofbx2._c = d;
                ofbx2._d += d8 * d4;
                ofbx2._e += d9 * d4;
            } else if (d5 < d6) {
                n9 = n4 > n2 ? 0 : 1;
                ofbx2._c += d7 * d5;
                ofbx2._d = d2;
                ofbx2._e += d9 * d5;
            } else {
                n9 = n5 > n ? 2 : 3;
                ofbx2._c += d7 * d6;
                ofbx2._d += d8 * d6;
                ofbx2._e = d3;
            }
            ofbx ofbx4 = vecPool._a(ofbx2._c, ofbx2._d, ofbx2._e);
            ofbx4._c = sajh._c(ofbx2._c);
            n6 = (int)ofbx4._c;
            if (n9 == 5) {
                --n6;
                ofbx4._c += 1.0;
            }
            ofbx4._d = sajh._c(ofbx2._d);
            n2 = (int)ofbx4._d;
            if (n9 == 1) {
                --n2;
                ofbx4._d += 1.0;
            }
            ofbx4._e = sajh._c(ofbx2._e);
            n = (int)ofbx4._e;
            if (n9 == 3) {
                --n;
                ofbx4._e += 1.0;
            }
            if ((twgu3 = twgu.field_71973_m[n8 = ozlu2.func_72798_a(n6, n2, n)]) == null || n8 <= 0 || bl && !twgu3.func_71926_d() && !(twgu2 instanceof BlockBase) || !twgu3.func_71913_a(0, false) || (hank3 = this.raytraceBlock(twgu3, ozlu2, n6, n2, n, ofbx2, ofbx3)) == null) continue;
            return hank3;
        }
        return null;
    }

    private hank raytraceBlock(twgu twgu2, ozlu ozlu2, int n, int n2, int n3, ofbx ofbx2, ofbx ofbx3) {
        twgu twgu3 = twgu2 instanceof BlockBase ? twgu.field_71981_t : twgu2;
        return twgu3.func_71878_a(ozlu2, n, n2, n3, ofbx2, ofbx3);
    }

    public static class Reverb {
        public float decayTime;
        public float density;
        public float diffusion;
        public float gain;
        public float gainHF;
        public float decayHFRatio;
        public float reflectionsGain;
        public float reflectionsDelay;
        public float lateReverbGain;
        public float lateReverbDelay;
        public float airAbsirptionGainHF;
        public float roomRolloffFactor;

        public Reverb(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
            this.decayTime = f;
            this.density = f2;
            this.diffusion = f3;
            this.gain = f4;
            this.gainHF = f5;
            this.decayHFRatio = f6;
            this.reflectionsGain = f7;
            this.reflectionsDelay = f8;
            this.lateReverbGain = f9;
            this.lateReverbDelay = f10;
            this.airAbsirptionGainHF = f11;
            this.roomRolloffFactor = f12;
        }
    }
}

