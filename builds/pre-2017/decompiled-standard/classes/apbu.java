/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.asm.ItemAtlasHooks;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mcoptifine.Config;
import net.minecraft.client.xpzm;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.jxsn;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.turb;
import org.lwjgl.opengl.GL11;

public class apbu
implements apch,
cvkw {
    public final Map _a = Maps.newConcurrentMap();
    public final Map _b = Maps.newHashMap();
    public final List _c = Lists.newArrayList();
    public final Map _d = Maps.newHashMap();
    public xsfs _e;

    public apbu(xsfs xsfs2) {
        this._e = xsfs2;
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
            sctg2.func_110551_a(this._e);
        }
        catch (IOException iOException) {
            xpzm._E()._O()._a("Failed to load texture: " + resourceLocation, iOException);
            sctg2 = bsfn._b;
            this._a.put(resourceLocation, sctg2);
            bl = false;
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.func_85055_a(throwable, "Registering texture");
            jxsn jxsn2 = crashReport.func_85058_a("Resource location being registered");
            jxsn2._a("Resource location", resourceLocation);
            jxsn2._a("Texture object class", new scti(this, sctg2));
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
    public void func_110550_d() {
        GloomyHooks.tick(this);
        for (apch apch2 : this._c) {
            apch2.func_110550_d();
        }
    }

    @Override
    public void func_110549_a(xsfs xsfs2) {
        Config.dbg("*** Reloading textures ***");
        Config.log("Resource pack: \"" + Config.getResourcePack().func_130077_b() + "\"");
        Iterator iterator2 = this._a.keySet().iterator();
        while (iterator2.hasNext()) {
            ResourceLocation resourceLocation = (ResourceLocation)iterator2.next();
            if (!resourceLocation.func_110623_a().startsWith("mcpatcher/")) continue;
            sctg object = (sctg)this._a.get(resourceLocation);
            int n = object.func_110552_b();
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

