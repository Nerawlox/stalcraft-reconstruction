/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.asm.ItemAtlasHooks;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mcoptifine.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.turb;
import org.lwjgl.opengl.GL11;

public class TextureManager
implements apch,
cvkw {
    public final Map _a = Maps.newConcurrentMap();
    public final Map _b = Maps.newHashMap();
    public final List _c = Lists.newArrayList();
    public final Map _d = Maps.newHashMap();
    public ResourceManager _e;

    public TextureManager(ResourceManager resourceManager) {
        this._e = resourceManager;
    }

    public void _a(ResourceLocation resourceLocation) {
        boolean bl = ItemAtlasHooks.bindTexture(this, resourceLocation);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        fmej._a(this, resourceLocation);
    }

    public ResourceLocation _a(int n) {
        return (ResourceLocation)this._b.get(n);
    }

    public boolean _a(ResourceLocation resourceLocation, sctd sctd2) {
        if (this._a(resourceLocation, (cegw)sctd2)) {
            this._b.put(sctd2._j(), resourceLocation);
            return true;
        }
        return false;
    }

    public boolean _a(ResourceLocation resourceLocation, cegw cegw2) {
        if (this._a(resourceLocation, (sctg)cegw2)) {
            this._c.add(cegw2);
            return true;
        }
        return false;
    }

    public boolean _a(ResourceLocation resourceLocation, sctg sctg2) {
        boolean bl = true;
        try {
            sctg2.loadTexture(this._e);
        }
        catch (IOException iOException) {
            Minecraft._E()._O()._a("Failed to load texture: " + resourceLocation, iOException);
            sctg2 = bsfn._b;
            this._a.put(resourceLocation, sctg2);
            bl = false;
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Registering texture");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("Resource location being registered");
            crashReportCategory._a("Resource location", resourceLocation);
            crashReportCategory._a("Texture object class", new scti(this, sctg2));
            throw new turb(crashReport);
        }
        this._a.put(resourceLocation, sctg2);
        return bl;
    }

    public sctg _b(ResourceLocation resourceLocation) {
        return (sctg)this._a.get(resourceLocation);
    }

    public ResourceLocation _a(String string, sctt sctt2) {
        Integer n = (Integer)this._d.get(string);
        n = n == null ? Integer.valueOf(1) : Integer.valueOf(n + 1);
        this._d.put(string, n);
        ResourceLocation resourceLocation = new ResourceLocation(String.format("dynamic/%s_%d", string, n));
        this._a(resourceLocation, (sctg)sctt2);
        return resourceLocation;
    }

    @Override
    public void tick() {
        GloomyHooks.tick(this);
        for (apch apch2 : this._c) {
            apch2.tick();
        }
    }

    @Override
    public void onResourceManagerReload(ResourceManager resourceManager) {
        Config.dbg("*** Reloading textures ***");
        Config.log("Resource pack: \"" + Config.getResourcePack().getPackName() + "\"");
        Iterator iterator2 = this._a.keySet().iterator();
        while (iterator2.hasNext()) {
            ResourceLocation resourceLocation = (ResourceLocation)iterator2.next();
            if (!resourceLocation.getResourcePath().startsWith("mcpatcher/")) continue;
            sctg object = (sctg)this._a.get(resourceLocation);
            int n = object.getGlTextureId();
            if (n > 0) {
                GL11.glDeleteTextures(n);
            }
            iterator2.remove();
        }
        for (Map.Entry entry : this._a.entrySet()) {
            this._a((ResourceLocation)entry.getKey(), (sctg)entry.getValue());
        }
    }
}

