/*
 * Decompiled with CFR 0.152.
 */
public class flra {
    public static final String _a = "ForgeData";
    public static final String _b = "PlayerPersisted";
    public static final String _c = "cerf";
    public static final String _d = "Dimension";
    public static final String _e = "Pos";
    public static final String _f = "Rotation";
    public static final String _g = "LastPlayed";
    public static final String _h = "instance_id";
    public static final String _i = "worldLeavePos";
    public static final String _j = "newPos";
    public static final String _k = "instant_leave";

    public static qoac _a(qoac qoac2) {
        return flra._b(flra._a(qoac2, _a));
    }

    public static qoac _b(qoac qoac2) {
        return flra._a(qoac2, _b);
    }

    public static qoac _a(qoac qoac2, String string) {
        if (!qoac2._c(string)) {
            qoac2._a(string, (huhy)new qoac());
        }
        return qoac2._m(string);
    }
}

