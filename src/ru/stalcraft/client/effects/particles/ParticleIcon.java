/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjn
 *  bkn
 *  bko
 *  com.google.common.collect.Lists
 *  cpw.mods.fml.relauncher.ReflectionHelper
 */
package ru.stalcraft.client.effects.particles;

import com.google.common.collect.Lists;
import cpw.mods.fml.relauncher.ReflectionHelper;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import ru.stalcraft.Util;

public class ParticleIcon
extends bil {
    public final int index;

    public ParticleIcon(String par1Str, int index) {
        super(par1Str);
        this.index = index;
    }

    @Override
    public void a(bjn par1Resource) throws IOException {
        int l2;
        int k2;
        int j2;
        int i2;
        try {
            ReflectionHelper.findMethod(bil.class, (Object)this, (String[])new String[]{"resetSprite", "func_130102_n", "n"}, (Class[])new Class[]{null}).invoke(null, new Object[]{null});
        }
        catch (Exception exception) {
            // empty catch block
        }
        InputStream inputstream = par1Resource.b();
        bko animationmetadatasection = (bko)par1Resource.a("animation");
        BufferedImage bufferedimage = ImageIO.read(inputstream);
        this.f = bufferedimage.getHeight();
        this.e = bufferedimage.getWidth();
        int[] aint = new int[this.f * this.e];
        bufferedimage.getRGB(0, 0, this.e, this.f, aint, 0, this.e);
        for (i2 = 0; i2 < aint.length; ++i2) {
            j2 = aint[i2];
            k2 = j2 >> 24 & 0xFF;
            l2 = (int)((float)(j2 >> 16 & 0xFF) * ((float)k2 / 255.0f));
            int arraylist = (int)((float)(j2 >> 8 & 0xFF) * ((float)k2 / 255.0f));
            int b2 = (int)((float)(j2 & 0xFF) * ((float)k2 / 255.0f));
            aint[i2] = (k2 & 0xFF) << 24 | (l2 & 0xFF) << 16 | (arraylist & 0xFF) << 8 | b2 & 0xFF;
        }
        if (animationmetadatasection == null) {
            if (this.f != this.e) {
                throw new RuntimeException("broken aspect ratio and not an animation");
            }
            this.a.add(aint);
        } else {
            i2 = this.f / this.e;
            j2 = this.e;
            k2 = this.e;
            this.f = this.e;
            if (animationmetadatasection.c() > 0) {
                Iterator var12 = animationmetadatasection.e().iterator();
                while (var12.hasNext()) {
                    l2 = (Integer)var12.next();
                    if (l2 >= i2) {
                        throw new RuntimeException("invalid frameindex " + l2);
                    }
                    this.d(l2);
                    this.a.set(l2, ParticleIcon.a(aint, j2, k2, l2));
                }
                Util.setPrivateValue(ParticleIcon.class, this, animationmetadatasection, "animationMetadata", "field_110982_k", "j");
            } else {
                ArrayList var13 = Lists.newArrayList();
                for (l2 = 0; l2 < i2; ++l2) {
                    this.a.add(ParticleIcon.a(aint, j2, k2, l2));
                    var13.add(new bkn(l2, -1));
                }
                Util.setPrivateValue(ParticleIcon.class, this, new bko((List)var13, this.e, this.f, animationmetadatasection.d()), "animationMetadata", "field_110982_k", "j");
            }
        }
    }

    private static int[] a(int[] par0ArrayOfInteger, int par1, int par2, int par3) {
        int[] aint1 = new int[par1 * par2];
        System.arraycopy(par0ArrayOfInteger, par3 * aint1.length, aint1, 0, aint1.length);
        return aint1;
    }

    private void d(int par1) {
        if (this.a.size() <= par1) {
            for (int j2 = this.a.size(); j2 <= par1; ++j2) {
                this.a.add(null);
            }
        }
    }
}

