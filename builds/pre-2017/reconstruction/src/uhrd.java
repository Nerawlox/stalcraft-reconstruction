/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class uhrd {
    private final HashMap<String, kjui> _a = new HashMap();
    private final HashMap<ResourceLocation, jyth> _b = new HashMap();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public jyth _a(@NotNull ResourceLocation resourceLocation) {
        if (resourceLocation == null) {
            uhrd._a(0);
        }
        HashMap<ResourceLocation, jyth> hashMap = this._b;
        synchronized (hashMap) {
            jyth jyth2 = this._b.get(resourceLocation);
            if (jyth2 == null) {
                jyth jyth3 = new jyth(resourceLocation);
                this._b.put(resourceLocation, jyth3);
                return jyth3;
            }
            return jyth2;
        }
    }

    public uhrd() {
        this._a(rpms::new, "mcsa");
        this._a(rpms::new, "mcvd");
        this._a(iest::new, "mcal");
    }

    public void _a(kjui kjui2, String ... stringArray) {
        for (String string : stringArray) {
            this._a.put(string, kjui2);
        }
    }

    public uytm _b(ResourceLocation resourceLocation) {
        return this._e(resourceLocation).createResource(resourceLocation);
    }

    public uytm _c(ResourceLocation resourceLocation) {
        try {
            return this._d(resourceLocation);
        }
        catch (Exception exception) {
            gpmu._b("Can not load resource at " + resourceLocation, new Object[0]);
            exception.printStackTrace();
            return null;
        }
    }

    public uytm _d(ResourceLocation resourceLocation) {
        uytm uytm2 = this._b(resourceLocation);
        uytm2.load(false);
        if (uytm2.getState() == oxca.kjui._c) {
            return uytm2;
        }
        throw new RuntimeException("Resource " + resourceLocation + " was not loaded, current state: " + (Object)((Object)uytm2.getState()));
    }

    kjui _e(ResourceLocation resourceLocation) {
        String string = resourceLocation.getResourcePath();
        int n = string.lastIndexOf(".");
        if (n == -1) {
            throw new IllegalArgumentException("Invalid resource location: " + resourceLocation + " (no extension)");
        }
        String string2 = string.substring(n + 1);
        kjui kjui2 = this._a.get(string2);
        if (kjui2 == null) {
            throw new IllegalArgumentException("Invalid resource location: " + resourceLocation + " (resource extension ." + string2 + " is not registered)");
        }
        return kjui2;
    }

    public static uhrd _a() {
        return ogai._t()._j;
    }

    private static /* synthetic */ void _a(int n) {
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "resourceLocation", "gloomyfolken/mods/effects/common/loaders/ResourceFactory", "createDynamicReference"));
    }

    public static interface kjui<T extends uytm> {
        public T createResource(ResourceLocation var1);
    }
}

