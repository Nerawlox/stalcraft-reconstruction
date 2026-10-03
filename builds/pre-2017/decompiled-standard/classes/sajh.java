/*
 * Decompiled with CFR 0.152.
 */
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010$\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002]^B\u0085\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0011\u0012\u0006\u0010 \u001a\u00020\u0011\u0012\u0006\u0010!\u001a\u00020\u0011\u0012\u0006\u0010\"\u001a\u00020\u0011\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020%\u0012\u0006\u0010&\u001a\u00020'\u0012\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180)\u0012\u0006\u0010*\u001a\u00020\u000f\u00a2\u0006\u0002\u0010+J\u0016\u0010Y\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020'2\u0006\u0010[\u001a\u00020'J\b\u0010\\\u001a\u00020\u0003H\u0016R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010 \u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010!\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00101R\u0011\u0010\u001f\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00101R\u0011\u0010\"\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00101R\u0011\u0010*\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010#\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u00108R\u0011\u0010$\u001a\u00020%\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010&\u001a\u00020'\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u00101R\u0011\u0010\u0013\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u00101R\u0011\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u00101R\u0011\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u00101R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u00108R\u0011\u0010\u001a\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u00106R\u0011\u0010\u001b\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u00106R\u0011\u0010\u0019\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u00106R\u0011\u0010\u001d\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u00106R\u0011\u0010\u001c\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u00106R\u0011\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u00101R\u0011\u0010I\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u00101R\u0011\u0010\u001e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u00106R\u001d\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180)\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u00106R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0011\u0010Q\u001a\u00020R\u00a2\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010/R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\bX\u00101\u00a8\u0006_"}, d2={"Lgloomyfolken/bundle/common/config/LocationConfigEntry;", "", "name", "", "localizedName", "type", "Lgloomyfolken/bundle/common/config/LocationConfigEntry$LocationType;", "bounds", "", "Ljava/awt/geom/Point2D;", "tpBorders", "Lgloomyfolken/bundle/common/config/LocationConfigEntry$TeleportBorder;", "spawnPoint", "Lgloomyfolken/bundle/common/utils/position/LocalPosition;", "respawnOnPoint", "", "xmxMB", "", "optimalPlayersPerInstance", "maxPlayersPerInstance", "maxInstances", "minServers", "maxServers", "artefaktSpawnFactor", "", "noEjection", "noCorpses", "noDrop", "noMobs", "noItemDamage", "removeCommonEntities", "corpseBagSpawnDelay", "corpseBagEmptyLifetime", "corpseBagLootedLifetime", "corpseBagUnlootedLifetime", "locationLoot", "locationLootCooldown", "Ljava/time/Duration;", "locationLootProbability", "", "resourcePoints", "", "ignoreGlobalTime", "(Ljava/lang/String;Ljava/lang/String;Lgloomyfolken/bundle/common/config/LocationConfigEntry$LocationType;Ljava/util/List;Ljava/util/List;Lgloomyfolken/bundle/common/utils/position/LocalPosition;ZIIIIIIFZZZZZZIIIILjava/lang/String;Ljava/time/Duration;DLjava/util/Map;Z)V", "getArtefaktSpawnFactor", "()F", "getBounds", "()Ljava/util/List;", "getCorpseBagEmptyLifetime", "()I", "getCorpseBagLootedLifetime", "getCorpseBagSpawnDelay", "getCorpseBagUnlootedLifetime", "getIgnoreGlobalTime", "()Z", "getLocalizedName", "()Ljava/lang/String;", "getLocationLoot", "getLocationLootCooldown", "()Ljava/time/Duration;", "getLocationLootProbability", "()D", "getMaxInstances", "getMaxPlayersPerInstance", "getMaxServers", "getMinServers", "getName", "getNoCorpses", "getNoDrop", "getNoEjection", "getNoItemDamage", "getNoMobs", "getOptimalPlayersPerInstance", "optimalPlayersPerServer", "getOptimalPlayersPerServer", "getRemoveCommonEntities", "getResourcePoints", "()Ljava/util/Map;", "getRespawnOnPoint", "getSpawnPoint", "()Lgloomyfolken/bundle/common/utils/position/LocalPosition;", "spawnPointGlobal", "Lgloomyfolken/bundle/common/utils/position/GlobalPosition;", "getSpawnPointGlobal", "()Lgloomyfolken/bundle/common/utils/position/GlobalPosition;", "getTpBorders", "getType", "()Lgloomyfolken/bundle/common/config/LocationConfigEntry$LocationType;", "getXmxMB", "isPointInLocation", "x", "z", "toString", "LocationType", "TeleportBorder", "minecraft"})
public final class sajh {
    private final int _a;
    @NotNull
    private final iuyn _b;
    @NotNull
    private final String _c;
    @NotNull
    private final String _d;
    @NotNull
    private final kjui _e;
    @NotNull
    private final List<Point2D> _f;
    @NotNull
    private final List<pidb> _g;
    @NotNull
    private final hrvl _h;
    private final boolean _i;
    private final int _j;
    private final int _k;
    private final int _l;
    private final int _m;
    private final int _n;
    private final int _o;
    private final float _p;
    private final boolean _q;
    private final boolean _r;
    private final boolean _s;
    private final boolean _t;
    private final boolean _u;
    private final boolean _v;
    private final int _w;
    private final int _x;
    private final int _y;
    private final int _z;
    @NotNull
    private final String _A;
    @NotNull
    private final Duration _B;
    private final double _C;
    @NotNull
    private final Map<String, Float> _D;
    private final boolean _E;

    public final int _a() {
        return this._a;
    }

    @NotNull
    public final iuyn _b() {
        return this._b;
    }

    public final boolean _a(double d, double d2) {
        return iuyu._a(d, d2, this._f);
    }

    @NotNull
    public String toString() {
        return this._c;
    }

    @NotNull
    public final String _c() {
        return this._c;
    }

    @NotNull
    public final String _d() {
        return this._d;
    }

    @NotNull
    public final kjui _e() {
        return this._e;
    }

    @NotNull
    public final List<Point2D> _f() {
        return this._f;
    }

    @NotNull
    public final List<pidb> _g() {
        return this._g;
    }

    @NotNull
    public final hrvl _h() {
        return this._h;
    }

    public final boolean _i() {
        return this._i;
    }

    public final int _j() {
        return this._j;
    }

    public final int _k() {
        return this._k;
    }

    public final int _l() {
        return this._l;
    }

    public final int _m() {
        return this._m;
    }

    public final int _n() {
        return this._n;
    }

    public final int _o() {
        return this._o;
    }

    public final float _p() {
        return this._p;
    }

    public final boolean _q() {
        return this._q;
    }

    public final boolean _r() {
        return this._r;
    }

    public final boolean _s() {
        return this._s;
    }

    public final boolean _t() {
        return this._t;
    }

    public final boolean _u() {
        return this._u;
    }

    public final boolean _v() {
        return this._v;
    }

    public final int _w() {
        return this._w;
    }

    public final int _x() {
        return this._x;
    }

    public final int _y() {
        return this._y;
    }

    public final int _z() {
        return this._z;
    }

    @NotNull
    public final String _A() {
        return this._A;
    }

    @NotNull
    public final Duration _B() {
        return this._B;
    }

    public final double _C() {
        return this._C;
    }

    @NotNull
    public final Map<String, Float> _D() {
        return this._D;
    }

    public final boolean _E() {
        return this._E;
    }

    public sajh(@NotNull String string, @NotNull String string2, @NotNull kjui kjui2, @NotNull List<? extends Point2D> list, @NotNull List<pidb> list2, @NotNull hrvl hrvl2, boolean bl, int n, int n2, int n3, int n4, int n5, int n6, float f, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, int n7, int n8, int n9, int n10, @NotNull String string3, @NotNull Duration duration, double d, @NotNull Map<String, Float> map, boolean bl8) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(string2, "localizedName");
        Intrinsics.checkParameterIsNotNull((Object)kjui2, "type");
        Intrinsics.checkParameterIsNotNull(list, "bounds");
        Intrinsics.checkParameterIsNotNull(list2, "tpBorders");
        Intrinsics.checkParameterIsNotNull(hrvl2, "spawnPoint");
        Intrinsics.checkParameterIsNotNull(string3, "locationLoot");
        Intrinsics.checkParameterIsNotNull(duration, "locationLootCooldown");
        Intrinsics.checkParameterIsNotNull(map, "resourcePoints");
        this._c = string;
        this._d = string2;
        this._e = kjui2;
        this._f = list;
        this._g = list2;
        this._h = hrvl2;
        this._i = bl;
        this._j = n;
        this._k = n2;
        this._l = n3;
        this._m = n4;
        this._n = n5;
        this._o = n6;
        this._p = f;
        this._q = bl2;
        this._r = bl3;
        this._s = bl4;
        this._t = bl5;
        this._u = bl6;
        this._v = bl7;
        this._w = n7;
        this._x = n8;
        this._y = n9;
        this._z = n10;
        this._A = string3;
        this._B = duration;
        this._C = d;
        this._D = map;
        this._E = bl8;
        this._a = this._k * this._m;
        this._b = new iuyn(this._c, this._h);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f\u00a8\u0006\u0011"}, d2={"Lgloomyfolken/bundle/common/config/LocationConfigEntry$TeleportBorder;", "", "destLocation", "", "point1", "Ljava/awt/geom/Point2D;", "point2", "(Ljava/lang/String;Ljava/awt/geom/Point2D;Ljava/awt/geom/Point2D;)V", "getDestLocation", "()Ljava/lang/String;", "line", "Ljava/awt/geom/Line2D$Double;", "getLine", "()Ljava/awt/geom/Line2D$Double;", "getPoint1", "()Ljava/awt/geom/Point2D;", "getPoint2", "minecraft"})
    public static final class pidb {
        @NotNull
        private final Line2D.Double _a;
        @NotNull
        private final String _b;
        @NotNull
        private final Point2D _c;
        @NotNull
        private final Point2D _d;

        @NotNull
        public final Line2D.Double _a() {
            return this._a;
        }

        @NotNull
        public final String _b() {
            return this._b;
        }

        @NotNull
        public final Point2D _c() {
            return this._c;
        }

        @NotNull
        public final Point2D _d() {
            return this._d;
        }

        public pidb(@NotNull String string, @NotNull Point2D point2D, @NotNull Point2D point2D2) {
            Intrinsics.checkParameterIsNotNull(string, "destLocation");
            Intrinsics.checkParameterIsNotNull(point2D, "point1");
            Intrinsics.checkParameterIsNotNull(point2D2, "point2");
            this._b = string;
            this._c = point2D;
            this._d = point2D2;
            this._a = new Line2D.Double(this._c, this._d);
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2={"Lgloomyfolken/bundle/common/config/LocationConfigEntry$LocationType;", "", "cfgName", "", "reloadWorlds", "", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getCfgName", "()Ljava/lang/String;", "getReloadWorlds", "()Z", "OPEN_WORLD", "DUNGEON", "BATTLEFIELD", "minecraft"})
    public static final class kjui
    extends Enum<kjui> {
        public static final /* enum */ kjui _a;
        public static final /* enum */ kjui _b;
        public static final /* enum */ kjui _c;
        private static final /* synthetic */ kjui[] $VALUES;
        @NotNull
        private final String _d;
        private final boolean _e;

        static {
            kjui[] kjuiArray = new kjui[3];
            kjui[] kjuiArray2 = kjuiArray;
            kjuiArray[0] = _a = new kjui("open_world", false);
            kjuiArray[1] = _b = new kjui("dungeon", true);
            kjuiArray[2] = _c = new kjui("battlefield", false);
            $VALUES = kjuiArray;
        }

        @NotNull
        public final String _a() {
            return this._d;
        }

        public final boolean _b() {
            return this._e;
        }

        protected kjui(@NotNull String string2, boolean bl) {
            Intrinsics.checkParameterIsNotNull(string2, "cfgName");
            this._d = string2;
            this._e = bl;
        }

        public static kjui[] values() {
            return (kjui[])$VALUES.clone();
        }

        public static kjui valueOf(String string) {
            return Enum.valueOf(kjui.class, string);
        }
    }
}

