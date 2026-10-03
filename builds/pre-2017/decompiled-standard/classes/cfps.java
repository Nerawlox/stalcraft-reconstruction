/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

public class cfps {
    public static Map _a = new HashMap();
    public static Map _b = new HashMap();
    public static Map _c = new HashMap();
    public static Map _d = new HashMap();

    public static void _a(Class clazz, String string) {
        _a.put(string, clazz);
        _b.put(clazz, string);
    }

    public static void _b(Class clazz, String string) {
        _c.put(string, clazz);
        _d.put(clazz, string);
    }

    public static String _a(tycc tycc2) {
        return (String)_b.get(tycc2.getClass());
    }

    public static String _a(zztd zztd2) {
        return (String)_d.get(zztd2.getClass());
    }

    public static tycc _a(qoac qoac2, ozlu ozlu2) {
        tycc tycc2 = null;
        try {
            Class clazz = (Class)_a.get(qoac2._j("id"));
            if (clazz != null) {
                tycc2 = (tycc)clazz.newInstance();
            }
        }
        catch (Exception exception) {
            ozlu2.func_98180_V()._b("Failed Start with id " + qoac2._j("id"));
            exception.printStackTrace();
        }
        if (tycc2 != null) {
            tycc2._a(ozlu2, qoac2);
        } else {
            ozlu2.func_98180_V()._b("Skipping Structure with id " + qoac2._j("id"));
        }
        return tycc2;
    }

    public static zztd _b(qoac qoac2, ozlu ozlu2) {
        zztd zztd2 = null;
        try {
            Class clazz = (Class)_c.get(qoac2._j("id"));
            if (clazz != null) {
                zztd2 = (zztd)clazz.newInstance();
            }
        }
        catch (Exception exception) {
            ozlu2.func_98180_V()._b("Failed Piece with id " + qoac2._j("id"));
            exception.printStackTrace();
        }
        if (zztd2 != null) {
            zztd2._a(ozlu2, qoac2);
        } else {
            ozlu2.func_98180_V()._b("Skipping Piece with id " + qoac2._j("id"));
        }
        return zztd2;
    }

    static {
        cfps._a(yfou.class, "Mineshaft");
        cfps._a(nfoq.class, "Village");
        cfps._a(dzua.class, "Fortress");
        cfps._a(razs.class, "Stronghold");
        cfps._a(vnhh.class, "Temple");
        mtob._a();
        tybp._a();
        yfov._a();
        iyda._a();
        ozsb._a();
    }
}

