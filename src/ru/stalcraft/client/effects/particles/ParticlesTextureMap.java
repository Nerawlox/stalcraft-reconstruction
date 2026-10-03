/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bia
 *  big
 *  bir
 *  bjo
 *  bjp
 *  com.google.common.collect.Lists
 *  com.google.common.collect.Maps
 *  ms
 *  mt
 *  u
 */
package ru.stalcraft.client.effects.particles;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ru.stalcraft.client.effects.particles.ParticleIcon;

public class ParticlesTextureMap
extends bia
implements bir,
mt {
    public static final bjo particlesTexture = new bjo("textures/atlas/particles.png");
    private final List listAnimatedSprites = Lists.newArrayList();
    private final Map mapRegisteredSprites = Maps.newHashMap();
    private final Map mapUploadedSprites = Maps.newHashMap();
    private final int textureType;
    private final String basePath;
    private List emitterClasses;
    public List icons = new ArrayList();

    public ParticlesTextureMap(List emitterClasses) {
        this.basePath = "textures/particles";
        this.textureType = 347;
        this.emitterClasses = emitterClasses;
        this.registerIcons();
    }

    public void a(bjp par1ResourceManager) throws IOException {
        this.loadTextureAtlas(par1ResourceManager);
    }

    public void loadTextureAtlas(bjp par1) {
        Object par6;
        int par2 = atv.y();
        big par3 = new big(par2, par2, true);
        this.mapUploadedSprites.clear();
        this.listAnimatedSprites.clear();
        for (Map.Entry entry : this.mapRegisteredSprites.entrySet()) {
            ParticleIcon par7;
            block11: {
                par6 = new bjo((String)entry.getKey());
                par7 = (ParticleIcon)entry.getValue();
                bjo par8 = new bjo(par6.b(), String.format("%s/%s%s", this.basePath, par6.a(), ".png"));
                try {
                    if (!par7.load(par1, par8)) {
                    }
                    break block11;
                }
                catch (RuntimeException runtimeexception) {
                    atv.w().an().c(String.format("Unable to parse animation metadata from %s: %s", par8, runtimeexception.getMessage()));
                }
                catch (IOException ioexception) {
                    atv.w().an().c("Using missing texture, unable to load: " + par8);
                }
                continue;
            }
            par3.a((bil)par7);
        }
        par3.c();
        bip.a(this.b(), par3.a(), par3.b());
        for (ParticleIcon particleIcon : par3.d()) {
            par6 = particleIcon.g();
            this.mapUploadedSprites.put(par6, particleIcon);
            try {
                bip.a(particleIcon.a(0), particleIcon.a(), particleIcon.b(), particleIcon.h(), particleIcon.i(), false, false);
            }
            catch (Throwable t2) {
                b par7 = b.a(t2, "Stitching texture atlas");
                m par8 = par7.a("Texture being stitched together");
                par8.a("Atlas path", this.basePath);
                par8.a("Sprite", particleIcon);
                throw new u(par7);
            }
            if (particleIcon.m()) {
                this.listAnimatedSprites.add(particleIcon);
                continue;
            }
            particleIcon.l();
        }
    }

    private void registerIcons() {
        for (Class clazz : this.emitterClasses) {
            try {
                Method e2 = clazz.getMethod("registerIcons", mt.class);
                e2.invoke(null, new Object[]{this});
            }
            catch (Exception var4) {
                var4.printStackTrace();
            }
        }
    }

    public int getTextureType() {
        return this.textureType;
    }

    public void d() {
        this.updateAnimations();
    }

    public void updateAnimations() {
    }

    public ms a(String par1Str) {
        ParticleIcon object;
        if (par1Str == null) {
            new RuntimeException("Don't register null!").printStackTrace();
            par1Str = "null";
        }
        if ((object = (ParticleIcon)this.mapRegisteredSprites.get(par1Str)) == null) {
            object = new ParticleIcon(par1Str, this.icons.size());
            this.mapRegisteredSprites.put(par1Str, object);
        }
        this.icons.add(object);
        return object;
    }
}

