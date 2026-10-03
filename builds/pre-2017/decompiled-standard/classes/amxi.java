/*
 * Decompiled with CFR 0.152.
 */
import java.awt.geom.Point2D;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b(\u0018\u00002\u00020\u0001:\u0002JKB\u00eb\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0007\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u001f\u0012\u0006\u0010 \u001a\u00020\u0014\u0012\u0006\u0010!\u001a\u00020\u0010\u0012\u0006\u0010\"\u001a\u00020\u0014\u0012\u0006\u0010#\u001a\u00020$\u00a2\u0006\u0002\u0010%J\u0006\u0010H\u001a\u00020\u001aJ\u0006\u0010I\u001a\u00020\u001aR\u0011\u0010 \u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010,R\u0011\u00101\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010.R\u0011\u0010\u000e\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010,R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00104R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010,R\u001d\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010)R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010)R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010)R\u0011\u0010\u001c\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010>R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010>R\u0011\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010>R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010'R\u0011\u0010!\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010.R\u0011\u0010#\u001a\u00020$\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010)R\u0011\u0010\"\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010'\u00a8\u0006L"}, d2={"Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig;", "", "battleId", "", "battleName", "locationName", "capturedBases", "", "icon", "description", "captureDays", "Ljava/time/DayOfWeek;", "captureStart", "Ljava/time/LocalTime;", "captureEnd", "biddingStart", "Ljava/time/Duration;", "biddingEnd", "winnerClanLoot", "personalCaseId", "", "battleSlots", "Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig$BattlefieldSlotConfig;", "capturePoints", "Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig$BattlefieldPointConfig;", "mapStartX", "", "mapStartZ", "mapFinishX", "mapFinishZ", "defaultLoot", "", "ammoClips", "respawnDuration", "worldStartTime", "scoreEnemyKill", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/time/LocalTime;Ljava/time/LocalTime;Ljava/time/Duration;Ljava/time/Duration;Ljava/lang/String;ILjava/util/List;Ljava/util/List;FFFFLjava/util/Map;ILjava/time/Duration;ID)V", "getAmmoClips", "()I", "getBattleId", "()Ljava/lang/String;", "getBattleName", "getBattleSlots", "()Ljava/util/List;", "getBiddingEnd", "()Ljava/time/Duration;", "getBiddingStart", "getCaptureDays", "captureDuration", "getCaptureDuration", "getCaptureEnd", "()Ljava/time/LocalTime;", "getCapturePoints", "getCaptureStart", "getCapturedBases", "getDefaultLoot", "()Ljava/util/Map;", "getDescription", "getIcon", "getLocationName", "getMapFinishX", "()F", "getMapFinishZ", "getMapStartX", "getMapStartZ", "getPersonalCaseId", "getRespawnDuration", "getScoreEnemyKill", "()D", "getWinnerClanLoot", "getWorldStartTime", "getMapCenterX", "getMapCenterZ", "BattlefieldPointConfig", "BattlefieldSlotConfig", "minecraft"})
public final class amxi {
    @NotNull
    private final Duration _a;
    @NotNull
    private final String _b;
    @NotNull
    private final String _c;
    @NotNull
    private final String _d;
    @NotNull
    private final List<String> _e;
    @NotNull
    private final String _f;
    @NotNull
    private final String _g;
    @NotNull
    private final List<DayOfWeek> _h;
    @NotNull
    private final LocalTime _i;
    @NotNull
    private final LocalTime _j;
    @NotNull
    private final Duration _k;
    @NotNull
    private final Duration _l;
    @Nullable
    private final String _m;
    private final int _n;
    @NotNull
    private final List<pidb> _o;
    @NotNull
    private final List<kjui> _p;
    private final float _q;
    private final float _r;
    private final float _s;
    private final float _t;
    @NotNull
    private final Map<Integer, Integer> _u;
    private final int _v;
    @NotNull
    private final Duration _w;
    private final int _x;
    private final double _y;

    @NotNull
    public final Duration _a() {
        return this._a;
    }

    public final float _b() {
        return this._q + (this._s - this._q) / 2.0f;
    }

    public final float _c() {
        return this._r + (this._t - this._r) / 2.0f;
    }

    @NotNull
    public final String _d() {
        return this._b;
    }

    @NotNull
    public final String _e() {
        return this._c;
    }

    @NotNull
    public final String _f() {
        return this._d;
    }

    @NotNull
    public final List<String> _g() {
        return this._e;
    }

    @NotNull
    public final String _h() {
        return this._f;
    }

    @NotNull
    public final String _i() {
        return this._g;
    }

    @NotNull
    public final List<DayOfWeek> _j() {
        return this._h;
    }

    @NotNull
    public final LocalTime _k() {
        return this._i;
    }

    @NotNull
    public final LocalTime _l() {
        return this._j;
    }

    @NotNull
    public final Duration _m() {
        return this._k;
    }

    @NotNull
    public final Duration _n() {
        return this._l;
    }

    @Nullable
    public final String _o() {
        return this._m;
    }

    public final int _p() {
        return this._n;
    }

    @NotNull
    public final List<pidb> _q() {
        return this._o;
    }

    @NotNull
    public final List<kjui> _r() {
        return this._p;
    }

    public final float _s() {
        return this._q;
    }

    public final float _t() {
        return this._r;
    }

    public final float _u() {
        return this._s;
    }

    public final float _v() {
        return this._t;
    }

    @NotNull
    public final Map<Integer, Integer> _w() {
        return this._u;
    }

    public final int _x() {
        return this._v;
    }

    @NotNull
    public final Duration _y() {
        return this._w;
    }

    public final int _z() {
        return this._x;
    }

    public final double _A() {
        return this._y;
    }

    public amxi(@NotNull String string, @NotNull String string2, @NotNull String string3, @NotNull List<String> list2, @NotNull String string4, @NotNull String string5, @NotNull List<? extends DayOfWeek> list3, @NotNull LocalTime localTime, @NotNull LocalTime localTime2, @NotNull Duration duration, @NotNull Duration duration2, @Nullable String string6, int n, @NotNull List<pidb> list4, @NotNull List<kjui> list5, float f, float f2, float f3, float f4, @NotNull Map<Integer, Integer> map, int n2, @NotNull Duration duration3, int n3, double d) {
        Intrinsics.checkParameterIsNotNull(string, "battleId");
        Intrinsics.checkParameterIsNotNull(string2, "battleName");
        Intrinsics.checkParameterIsNotNull(string3, "locationName");
        Intrinsics.checkParameterIsNotNull(list2, "capturedBases");
        Intrinsics.checkParameterIsNotNull(string4, "icon");
        Intrinsics.checkParameterIsNotNull(string5, "description");
        Intrinsics.checkParameterIsNotNull(list3, "captureDays");
        Intrinsics.checkParameterIsNotNull(localTime, "captureStart");
        Intrinsics.checkParameterIsNotNull(localTime2, "captureEnd");
        Intrinsics.checkParameterIsNotNull(duration, "biddingStart");
        Intrinsics.checkParameterIsNotNull(duration2, "biddingEnd");
        Intrinsics.checkParameterIsNotNull(list4, "battleSlots");
        Intrinsics.checkParameterIsNotNull(list5, "capturePoints");
        Intrinsics.checkParameterIsNotNull(map, "defaultLoot");
        Intrinsics.checkParameterIsNotNull(duration3, "respawnDuration");
        this._b = string;
        this._c = string2;
        this._d = string3;
        this._e = list2;
        this._f = string4;
        this._g = string5;
        this._h = list3;
        this._i = localTime;
        this._j = localTime2;
        this._k = duration;
        this._l = duration2;
        this._m = string6;
        this._n = n;
        this._o = list4;
        this._p = list5;
        this._q = f;
        this._r = f2;
        this._s = f3;
        this._t = f4;
        this._u = map;
        this._v = n2;
        this._w = duration3;
        this._x = n3;
        this._y = d;
        Duration duration4 = Duration.between(this._i, this._j);
        Intrinsics.checkExpressionValueIsNotNull(duration4, "Duration.between(captureStart, captureEnd)");
        this._a = duration4;
        if (this._j.isBefore(this._i)) {
            throw (Throwable)new IllegalArgumentException("Capture end should be after capture start");
        }
        if (this._h.isEmpty()) {
            throw (Throwable)new IllegalArgumentException("Capture days not specified");
        }
        if (this._o.isEmpty()) {
            throw (Throwable)new IllegalArgumentException("Battle slots not specified");
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n\u00a2\u0006\u0002\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016\u00a8\u0006\u0018"}, d2={"Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig$BattlefieldSlotConfig;", "", "position", "Lgloomyfolken/bundle/common/utils/position/LocalLocation;", "isDefenderSlot", "", "basePrice", "", "numPlayers", "spawnPoints", "", "Lgloomyfolken/bundle/common/utils/position/LocalPosition;", "spawnRegions", "Lgloomyfolken/bundle/common/utils/Cuboid;", "(Lgloomyfolken/bundle/common/utils/position/LocalLocation;ZIILjava/util/List;Ljava/util/List;)V", "getBasePrice", "()I", "()Z", "getNumPlayers", "getPosition", "()Lgloomyfolken/bundle/common/utils/position/LocalLocation;", "getSpawnPoints", "()Ljava/util/List;", "getSpawnRegions", "minecraft"})
    public static final class pidb {
        @NotNull
        private final einh _a;
        private final boolean _b;
        private final int _c;
        private final int _d;
        @NotNull
        private final List<hrvl> _e;
        @NotNull
        private final List<dfkn> _f;

        @NotNull
        public final einh _a() {
            return this._a;
        }

        public final boolean _b() {
            return this._b;
        }

        public final int _c() {
            return this._c;
        }

        public final int _d() {
            return this._d;
        }

        @NotNull
        public final List<hrvl> _e() {
            return this._e;
        }

        @NotNull
        public final List<dfkn> _f() {
            return this._f;
        }

        public pidb(@NotNull einh einh2, boolean bl, int n, int n2, @NotNull List<? extends hrvl> list2, @NotNull List<? extends dfkn> list3) {
            Intrinsics.checkParameterIsNotNull(einh2, "position");
            Intrinsics.checkParameterIsNotNull(list2, "spawnPoints");
            Intrinsics.checkParameterIsNotNull(list3, "spawnRegions");
            this._a = einh2;
            this._b = bl;
            this._c = n;
            this._d = n2;
            this._e = list2;
            this._f = list3;
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\u0002\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0019\u00a8\u0006-"}, d2={"Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig$BattlefieldPointConfig;", "", "name", "", "position", "Lgloomyfolken/bundle/common/utils/position/LocalLocation;", "blockId", "", "scoreGainPerSecond", "", "captureSeconds", "maxCapturePlayers", "captureMinY", "captureMaxY", "captureBounds", "", "Ljava/awt/geom/Point2D;", "spawnPoints", "Lgloomyfolken/bundle/common/utils/position/LocalPosition;", "ownedByDefender", "", "(Ljava/lang/String;Lgloomyfolken/bundle/common/utils/position/LocalLocation;IDDIDDLjava/util/List;Ljava/util/List;Z)V", "getBlockId", "()I", "getCaptureBounds", "()Ljava/util/List;", "getCaptureMaxY", "()D", "getCaptureMinY", "captureRangeY", "Lkotlin/ranges/ClosedFloatingPointRange;", "getCaptureRangeY", "()Lkotlin/ranges/ClosedFloatingPointRange;", "getCaptureSeconds", "getMaxCapturePlayers", "getName", "()Ljava/lang/String;", "getOwnedByDefender", "()Z", "getPosition", "()Lgloomyfolken/bundle/common/utils/position/LocalLocation;", "progressIncreasePerTick", "getProgressIncreasePerTick", "getScoreGainPerSecond", "getSpawnPoints", "minecraft"})
    public static final class kjui {
        private final double _a;
        @NotNull
        private final ClosedFloatingPointRange<Double> _b;
        @NotNull
        private final String _c;
        @NotNull
        private final einh _d;
        private final int _e;
        private final double _f;
        private final double _g;
        private final int _h;
        private final double _i;
        private final double _j;
        @NotNull
        private final List<Point2D> _k;
        @NotNull
        private final List<hrvl> _l;
        private final boolean _m;

        public final double _a() {
            return this._a;
        }

        @NotNull
        public final ClosedFloatingPointRange<Double> _b() {
            return this._b;
        }

        @NotNull
        public final String _c() {
            return this._c;
        }

        @NotNull
        public final einh _d() {
            return this._d;
        }

        public final int _e() {
            return this._e;
        }

        public final double _f() {
            return this._f;
        }

        public final double _g() {
            return this._g;
        }

        public final int _h() {
            return this._h;
        }

        public final double _i() {
            return this._i;
        }

        public final double _j() {
            return this._j;
        }

        @NotNull
        public final List<Point2D> _k() {
            return this._k;
        }

        @NotNull
        public final List<hrvl> _l() {
            return this._l;
        }

        public final boolean _m() {
            return this._m;
        }

        public kjui(@NotNull String string, @NotNull einh einh2, int n, double d, double d2, int n2, double d3, double d4, @NotNull List<? extends Point2D> list2, @NotNull List<? extends hrvl> list3, boolean bl) {
            Intrinsics.checkParameterIsNotNull(string, "name");
            Intrinsics.checkParameterIsNotNull(einh2, "position");
            Intrinsics.checkParameterIsNotNull(list2, "captureBounds");
            Intrinsics.checkParameterIsNotNull(list3, "spawnPoints");
            this._c = string;
            this._d = einh2;
            this._e = n;
            this._f = d;
            this._g = d2;
            this._h = n2;
            this._i = d3;
            this._j = d4;
            this._k = list2;
            this._l = list3;
            this._m = bl;
            this._a = 1.0 / (this._g * (double)20);
            this._b = RangesKt.rangeTo(this._i, this._j);
        }
    }
}

