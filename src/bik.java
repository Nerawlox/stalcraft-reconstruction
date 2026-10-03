/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bia
 *  big
 *  bir
 *  bis
 *  bjo
 *  bjp
 *  com.google.common.collect.Lists
 *  com.google.common.collect.Maps
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ms
 *  mt
 *  net.minecraftforge.client.ForgeHooksClient
 *  u
 */
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraftforge.client.ForgeHooksClient;

@SideOnly(value=Side.CLIENT)
public class bik
extends bia
implements bir,
mt {
    public static final bjo b = new bjo("textures/atlas/blocks.png");
    public static final bjo c = new bjo("textures/atlas/items.png");
    private final List d = Lists.newArrayList();
    private final Map e = Maps.newHashMap();
    private final Map f = Maps.newHashMap();
    public final int g;
    public final String h;
    private final bil i = new bil("missingno");

    public bik(int par1, String par2Str) {
        this.g = par1;
        this.h = par2Str;
        this.f();
    }

    private void e() {
        this.i.a(Lists.newArrayList((Object[])new int[][]{bip.b}));
        this.i.b(16);
        this.i.c(16);
    }

    public void a(bjp par1ResourceManager) throws IOException {
        this.e();
        this.b(par1ResourceManager);
    }

    public void b(bjp par1ResourceManager) {
        this.f();
        int i2 = atv.y();
        big stitcher = new big(i2, i2, true);
        this.f.clear();
        this.d.clear();
        ForgeHooksClient.onTextureStitchedPre((bik)this);
        for (Map.Entry entry : this.e.entrySet()) {
            bil textureatlassprite;
            block12: {
                bjo resourcelocation = new bjo((String)entry.getKey());
                textureatlassprite = (bil)entry.getValue();
                bjo resourcelocation1 = new bjo(resourcelocation.b(), String.format("%s/%s%s", this.h, resourcelocation.a(), ".png"));
                try {
                    if (!textureatlassprite.load(par1ResourceManager, resourcelocation1)) {
                    }
                    break block12;
                }
                catch (RuntimeException runtimeexception) {
                    atv.w().an().c(String.format("Unable to parse animation metadata from %s: %s", resourcelocation1, runtimeexception.getMessage()));
                }
                catch (IOException ioexception) {
                    atv.w().an().c("Using missing texture, unable to load: " + resourcelocation1);
                }
                continue;
            }
            stitcher.a(textureatlassprite);
        }
        stitcher.a(this.i);
        stitcher.c();
        bip.a(this.b(), stitcher.a(), stitcher.b());
        HashMap hashmap = Maps.newHashMap((Map)this.e);
        for (bil textureatlassprite1 : stitcher.d()) {
            String s2 = textureatlassprite1.g();
            hashmap.remove(s2);
            this.f.put(s2, textureatlassprite1);
            try {
                bip.a(textureatlassprite1.a(0), textureatlassprite1.a(), textureatlassprite1.b(), textureatlassprite1.h(), textureatlassprite1.i(), false, false);
            }
            catch (Throwable throwable) {
                b crashreport = b.a(throwable, "Stitching texture atlas");
                m crashreportcategory = crashreport.a("Texture being stitched together");
                crashreportcategory.a("Atlas path", this.h);
                crashreportcategory.a("Sprite", textureatlassprite1);
                throw new u(crashreport);
            }
            if (textureatlassprite1.m()) {
                this.d.add(textureatlassprite1);
                continue;
            }
            textureatlassprite1.l();
        }
        for (bil textureatlassprite1 : hashmap.values()) {
            textureatlassprite1.a(this.i);
        }
        ForgeHooksClient.onTextureStitchedPost((bik)this);
    }

    private void f() {
        this.e.clear();
        if (this.g == 0) {
            for (aqz block : aqz.s) {
                if (block == null) continue;
                block.a(this);
            }
            atv.w().g.a(this);
            bgl.a.a(this);
        }
        for (yc item : yc.g) {
            if (item == null || item.l() != this.g) continue;
            item.a(this);
        }
    }

    public bil b(String par1Str) {
        bil textureatlassprite = (bil)this.f.get(par1Str);
        if (textureatlassprite == null) {
            textureatlassprite = this.i;
        }
        return textureatlassprite;
    }

    public void c() {
        bip.b(this.b());
        for (bil textureatlassprite : this.d) {
            textureatlassprite.j();
        }
    }

    public ms a(String par1Str) {
        Object object;
        if (par1Str == null) {
            new RuntimeException("Don't register null!").printStackTrace();
            par1Str = "null";
        }
        if ((object = (bil)this.e.get(par1Str)) == null) {
            object = this.g == 1 ? ("clock".equals(par1Str) ? new bis(par1Str) : ("compass".equals(par1Str) ? new bit(par1Str) : new bil(par1Str))) : new bil(par1Str);
            this.e.put(par1Str, object);
        }
        return (ms)object;
    }

    public int a() {
        return this.g;
    }

    public void d() {
        this.c();
    }

    public bil getTextureExtry(String name) {
        return (bil)this.e.get(name);
    }

    public boolean setTextureEntry(String name, bil entry) {
        if (!this.e.containsKey(name)) {
            this.e.put(name, entry);
            return true;
        }
        return false;
    }
}

