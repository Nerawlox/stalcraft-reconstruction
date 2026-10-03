/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;

public class fmib {
    public static HashMap<ResourceLocation, sctg> _a = new HashMap();
    private static sctt _e;
    static pknz _b;
    static ResourceManager _c;
    static TextureManager _d;
    private static String[] _f;

    private static sctt _b() {
        if (_e == null) {
            _e = new sctt(1, 1);
            _e._a();
        }
        return _e;
    }

    public static int _a(int n) {
        if (n == 3553) {
            return fmib._b().getGlTextureId();
        }
        return 0;
    }

    public static int _b(int n) {
        if (n == 3553) {
            return bsfn._b.getGlTextureId();
        }
        return 0;
    }

    public static boolean _a(ResourceLocation resourceLocation) {
        if (resourceLocation == null) {
            return false;
        }
        sctg sctg2 = (sctg)fmib._d._a.get(resourceLocation);
        if (sctg2 == null) {
            return false;
        }
        return sctg2.getGlTextureId() != fmib._a(3553) && sctg2 != bsfn._b;
    }

    public static String[] _a() {
        return _f;
    }

    public static void _a(ResourceLocation ... resourceLocationArray) {
        for (ResourceLocation resourceLocation : resourceLocationArray) {
            fmib._b(resourceLocation);
        }
    }

    public static kkwv _b(ResourceLocation resourceLocation) {
        return fmib._a(resourceLocation, false);
    }

    public static kkwv _c(ResourceLocation resourceLocation) {
        return fmib._a(resourceLocation, true);
    }

    public static kkwv _a(ResourceLocation resourceLocation, boolean bl) {
        Object v = fmib._d._a.get(resourceLocation);
        if (v instanceof kkwv) {
            return (kkwv)v;
        }
        if (v != null) {
            return null;
        }
        kkwv kkwv2 = new kkwv(resourceLocation, bl);
        _d._a(resourceLocation, kkwv2);
        return kkwv2;
    }

    public static kkwv _d(ResourceLocation resourceLocation) {
        Object v = fmib._d._a.get(resourceLocation);
        if (v instanceof kkwv) {
            return (kkwv)v;
        }
        return null;
    }

    public static void _b(ResourceLocation ... resourceLocationArray) {
        for (ResourceLocation resourceLocation : resourceLocationArray) {
            ((sctg)fmib._d._a.get(resourceLocation)).getGlTextureId();
        }
    }

    public static void _e(ResourceLocation resourceLocation) {
        ((sctg)fmib._d._a.get(resourceLocation)).getGlTextureId();
    }

    public static void _c(ResourceLocation ... resourceLocationArray) {
        for (ResourceLocation resourceLocation : resourceLocationArray) {
            if (_a.containsKey(resourceLocation)) continue;
            try {
                temw temw2 = fmib._f(resourceLocation);
                _a.put(resourceLocation, temw2);
                _d._a(resourceLocation, temw2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public static temw _f(ResourceLocation resourceLocation) {
        Object v = fmib._d._a.get(resourceLocation);
        if (v instanceof temw) {
            return (temw)v;
        }
        uytm uytm2 = hsju._a._b(resourceLocation);
        if (!(uytm2 instanceof temw)) {
            throw new IllegalArgumentException("Resource at " + resourceLocation + " is not a texture!");
        }
        return (temw)uytm2;
    }

    public static void _g(ResourceLocation resourceLocation) {
        fmib._d._a.put(resourceLocation, bsfn._b);
    }

    public static void _a(boolean bl) {
        long l = System.currentTimeMillis();
        for (Map.Entry<ResourceLocation, sctg> entry : _a.entrySet()) {
            ResourceLocation resourceLocation = entry.getKey();
            sctg sctg2 = entry.getValue();
            try {
                if (bl) {
                    _d._a(resourceLocation, sctg2);
                    continue;
                }
                fmib._d._a.put(resourceLocation, sctg2);
            }
            catch (Exception exception) {
                gpmu._b("Can not load texture at %s", resourceLocation);
                exception.printStackTrace();
            }
        }
        gpmu._d("Textures preloading time: %d ms", System.currentTimeMillis() - l);
    }

    static {
        if (Minecraft._E() == null) {
            MetadataSerializer metadataSerializer = new MetadataSerializer();
            File file = new File(".");
            yvjs yvjs2 = new yvjs(file);
            _b = new pknz(file, yvjs2, metadataSerializer, new GameSettings());
            _c = new scvi(metadataSerializer);
            ((scvi)_c)._a(yvjs2);
            _d = new TextureManager(_c);
        } else {
            _b = Minecraft._E()._T();
            _c = Minecraft._E()._S();
            _d = Minecraft._E()._h;
        }
        _f = new String[]{"png", "mic", "dds", "erk", "ol"};
    }
}

