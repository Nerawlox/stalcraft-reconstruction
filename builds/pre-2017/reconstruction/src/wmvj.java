/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.base.Charsets;
import com.google.gson.Gson;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;

public class wmvj {
    public static final Gson _a = new Gson();
    public static Map<Long, tdpx> _b = new HashMap<Long, tdpx>();
    public static List<turb> _c = new ArrayList<turb>();
    public static Map<Class<? extends EntityLiving>, srok> _d = new HashMap<Class<? extends EntityLiving>, srok>();
    public static Map<DamageSource, tdpx> _e = new HashMap<DamageSource, tdpx>();
    public static Map<Integer, tdpx> _f = new HashMap<Integer, tdpx>();
    public static Map<Integer, tdpx> _g = new HashMap<Integer, tdpx>();
    public static List<dfkn> _h = new ArrayList<dfkn>();
    public static Map<String, tdpx> _i = new HashMap<String, tdpx>();
    private static Map<dfkn, tdpx> _j = new HashMap<dfkn, tdpx>();
    private static Map<String, turb> _k = new LinkedHashMap<String, turb>();

    public static void _a(dfkn dfkn2, tdpx tdpx2) {
        _j.put(dfkn2, tdpx2);
        _h.add(dfkn2);
    }

    public static tdpx _a(dfkn dfkn2) {
        return _j.get(dfkn2);
    }

    public static <T extends turb> T _a(T t) {
        _k.put(t._a(), t);
        return t;
    }

    public static tdpx _a(String string, String string2, String string3, String string4, int n) {
        return wmvj._a(new tdpx(string, string2, string3, string4, n));
    }

    public static tdpx _a(String string, String string2, int n) {
        return wmvj._a(new tdpx(string, string2, n));
    }

    public static srok _a(String string, String string2, String string3, String string4, int n, int n2) {
        return wmvj._a(new srok(string, string2, string3, string4, n, n2));
    }

    public static srok _b(String string, String string2, int n) {
        return wmvj._a(new srok(string, string2, n));
    }

    public static hanr _a(String string, String string2, String string3, String string4, int n, Set<String> set) {
        return wmvj._a(new hanr(string, string2, string3, string4, n, set));
    }

    public static turb _a(String string) {
        return _k.get(string);
    }

    public static Collection<turb> _a() {
        return _k.values();
    }

    public static Collection<String> _b() {
        return _k.keySet();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public static String _a(ResourceLocation resourceLocation) {
        String string3 = "/assets/" + resourceLocation.getResourceDomain() + "/" + resourceLocation.getResourcePath();
        try (InputStream inputStream = GloomyCore.class.getResourceAsStream(string3);){
            if (inputStream == null) {
                String string2 = null;
                return string2;
            }
            String string = String.join((CharSequence)"", IOUtils.readLines(inputStream, Charsets.UTF_8));
            return string;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public static void _a(List<turb> list2, EntityPlayer entityPlayer) {
        ccxr ccxr2 = ncwh._a(entityPlayer);
        for (turb turb2 : list2) {
            if (turb2 instanceof tdpx) {
                ccxr2._a((tdpx)turb2)._e();
                continue;
            }
            if (!(turb2 instanceof srok)) continue;
            ccxr2._a((srok)turb2)._e();
        }
    }
}

