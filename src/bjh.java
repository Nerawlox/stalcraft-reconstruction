/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjn
 *  bjo
 *  bjp
 *  bjr
 *  bki
 *  com.google.common.collect.Lists
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import com.google.common.collect.Lists;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SideOnly(value=Side.CLIENT)
public class bjh
implements bjp {
    protected final List a = new ArrayList();
    private final bki b;

    public bjh(bki par1MetadataSerializer) {
        this.b = par1MetadataSerializer;
    }

    public void a(bjr par1ResourcePack) {
        this.a.add(par1ResourcePack);
    }

    public Set a() {
        return null;
    }

    public bjn a(bjo par1ResourceLocation) throws IOException {
        bjr resourcepack = null;
        bjo resourcelocation1 = bjh.c(par1ResourceLocation);
        for (int i2 = this.a.size() - 1; i2 >= 0; --i2) {
            bjr resourcepack1 = (bjr)this.a.get(i2);
            if (resourcepack == null && resourcepack1.b(resourcelocation1)) {
                resourcepack = resourcepack1;
            }
            if (!resourcepack1.b(par1ResourceLocation)) continue;
            InputStream inputstream = null;
            if (resourcepack != null) {
                inputstream = resourcepack.a(resourcelocation1);
            }
            return new bjy(par1ResourceLocation, resourcepack1.a(par1ResourceLocation), inputstream, this.b);
        }
        throw new FileNotFoundException(par1ResourceLocation.toString());
    }

    public List b(bjo par1ResourceLocation) throws IOException {
        ArrayList arraylist = Lists.newArrayList();
        bjo resourcelocation1 = bjh.c(par1ResourceLocation);
        for (bjr resourcepack : this.a) {
            if (!resourcepack.b(par1ResourceLocation)) continue;
            InputStream inputstream = resourcepack.b(resourcelocation1) ? resourcepack.a(resourcelocation1) : null;
            arraylist.add(new bjy(par1ResourceLocation, resourcepack.a(par1ResourceLocation), inputstream, this.b));
        }
        if (arraylist.isEmpty()) {
            throw new FileNotFoundException(par1ResourceLocation.toString());
        }
        return arraylist;
    }

    static bjo c(bjo par0ResourceLocation) {
        return new bjo(par0ResourceLocation.b(), par0ResourceLocation.a() + ".mcmeta");
    }
}

