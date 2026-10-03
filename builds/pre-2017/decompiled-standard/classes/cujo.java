/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.uxqz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;

public class cujo
implements rplk {
    public static ejcz[] _a = new ejcz[4];
    public static ejcz[] _b = new ejcz[4];
    public static ejcz _c;
    public static ejcz _d;
    public static ejcz _e;
    public static ejcz _f;
    public static ejcz _g;
    public static ejcz _h;
    public static HashMap<String, ejcz> _i;
    private HashMap<String, String> _j = new HashMap();

    public void _a() {
        for (ResourceLocation resourceLocation : this._b()) {
            zgiu zgiu2 = this._a(resourceLocation);
            if (zgiu2 == null) continue;
            for (ogjh ogjh2 : zgiu2._a()) {
                this._a(ogjh2._d()._j());
            }
        }
    }

    public zgiu _a(ResourceLocation resourceLocation) {
        try {
            return uxqz._a(IOUtils.toString(uyvo._e(resourceLocation), "UTF-8"), zgiu.class);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
    }

    public List<ResourceLocation> _b() {
        ArrayList<ResourceLocation> arrayList = new ArrayList<ResourceLocation>();
        String string = "stalker";
        String string2 = "/assets/" + string + "/";
        String string3 = string2 + "effects/";
        List<String> list2 = srxe._a(string3);
        for (String string4 : list2) {
            arrayList.add(new ResourceLocation(string, string4.substring(string2.length())));
        }
        arrayList.sort(Comparator.comparing(ResourceLocation::toString));
        return arrayList;
    }

    private String _b(String string) {
        String string2 = string.replaceFirst("assets/", "").replaceFirst("/", ":").replace("textures/particles/", "");
        return string2.substring(0, string2.lastIndexOf("."));
    }

    public void _a(String string) {
        this._j.put(string, this._b(string));
    }

    @Override
    public void registerIcons(nege nege2) {
        int n;
        for (n = 0; n < 4; ++n) {
            cujo._a[n] = (ejcz)nege2._b("stalker:smoke/smoke" + (n + 1));
        }
        for (n = 0; n < 4; ++n) {
            cujo._b[n] = (ejcz)nege2._b("stalker:campfire/fire" + (n + 1));
        }
        _i.clear();
        this._j.forEach((string, string2) -> _i.put((String)string, (ejcz)nege2._b((String)string2)));
        _f = (ejcz)nege2._b("stalker:explosion/expl_glow");
        _g = (ejcz)nege2._b("stalker:explosion/dirt-particles");
        _c = (ejcz)nege2._b("stalker:distortion/pfx_dist_glass2");
        _d = (ejcz)nege2._b("stalker:distortion/pfx_dist_glass5");
        _e = (ejcz)nege2._b("stalker:distortion/pfx_dist2_big");
        _e = (ejcz)nege2._b("stalker:distortion/pfx_dist2_big");
        _h = (ejcz)nege2._b("");
    }

    static {
        _i = new HashMap();
    }
}

