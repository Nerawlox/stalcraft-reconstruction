/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.primitives.Ints;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0003defB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020'H\u0007J\u0012\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010'H\u0007J\b\u0010F\u001a\u00020DH\u0003J\u0013\u0010G\u001a\b\u0012\u0004\u0012\u00020I0HH\u0002\u00a2\u0006\u0002\u0010JJ\u0012\u0010K\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020NH\u0002J\u001a\u0010O\u001a\f\u0018\u00010PR\u00060!R\u00020\u00002\u0006\u0010B\u001a\u00020'H\u0003J\u0012\u0010Q\u001a\u00020:2\b\b\u0002\u0010M\u001a\u00020NH\u0002J\u0010\u0010R\u001a\u00020\r2\b\b\u0002\u0010M\u001a\u00020NJ\b\u0010S\u001a\u00020AH\u0003J\b\u0010T\u001a\u00020DH\u0007J\u0010\u0010U\u001a\u00020D2\u0006\u0010B\u001a\u00020'H\u0007J\u000e\u0010V\u001a\u00020D2\u0006\u0010W\u001a\u00020\u0016J\u0006\u0010X\u001a\u00020DJ\u001e\u0010Y\u001a\u00020D2\u0006\u0010Z\u001a\u00020'2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020'0\\H\u0003J\b\u0010]\u001a\u00020DH\u0003J\b\u0010^\u001a\u00020DH\u0003J\b\u0010_\u001a\u00020DH\u0003J\b\u0010`\u001a\u00020DH\u0007J\b\u0010a\u001a\u00020DH\u0003J\b\u0010b\u001a\u00020DH\u0003J\u000e\u0010c\u001a\u00020D2\u0006\u0010W\u001a\u00020\u0016R0\u0010\u0007\u001a\b\u0018\u00010\u0006R\u00020\u00002\f\u0010\u0005\u001a\b\u0018\u00010\u0006R\u00020\u0000@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R0\u0010\"\u001a\b\u0018\u00010!R\u00020\u00002\f\u0010\u0005\u001a\b\u0018\u00010!R\u00020\u0000@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010(\u001a\u0004\u0018\u00010'2\b\u0010\u0005\u001a\u0004\u0018\u00010'@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R(\u00105\u001a\u0004\u0018\u0001042\b\u00103\u001a\u0004\u0018\u000104@GX\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u00020:2\u0006\u0010\u0005\u001a\u00020:@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?\u00a8\u0006g"}, d2={"Lgloomyfolken/bundle/common/clans/battlefield/Battlefield;", "", "config", "Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig;", "(Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig;)V", "<set-?>", "Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldBidding;", "bidding", "getBidding", "()Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldBidding;", "setBidding", "(Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldBidding;)V", "biddingEndOffset", "Ljava/time/Duration;", "kotlin.jvm.PlatformType", "getBiddingEndOffset", "()Ljava/time/Duration;", "setBiddingEndOffset", "(Ljava/time/Duration;)V", "getConfig", "()Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig;", "lastBattleResults", "Lnet/minecraft/nbt/NBTTagCompound;", "getLastBattleResults", "()Lnet/minecraft/nbt/NBTTagCompound;", "setLastBattleResults", "(Lnet/minecraft/nbt/NBTTagCompound;)V", "location", "Lgloomyfolken/bundle/common/config/LocationConfigEntry;", "getLocation", "()Lgloomyfolken/bundle/common/config/LocationConfigEntry;", "setLocation", "(Lgloomyfolken/bundle/common/config/LocationConfigEntry;)V", "Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldMembers;", "members", "getMembers", "()Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldMembers;", "setMembers", "(Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldMembers;)V", "", "ownerClanName", "getOwnerClanName", "()Ljava/lang/String;", "setOwnerClanName", "(Ljava/lang/String;)V", "ownerDefendStreak", "", "getOwnerDefendStreak", "()I", "setOwnerDefendStreak", "(I)V", "value", "Lgloomyfolken/bundle/backend/server/LoadBalancer$Server;", "server", "getServer", "()Lgloomyfolken/bundle/backend/server/LoadBalancer$Server;", "setServer", "(Lgloomyfolken/bundle/backend/server/LoadBalancer$Server;)V", "Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldState;", "state", "getState", "()Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldState;", "setState", "(Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldState;)V", "checkCanPlayerJoin", "", "username", "finishBattle", "", "winnerClanName", "finishBattleWithSoloMember", "getCurrentRandomLoot", "", "Lgloomyfolken/bundle/common/utils/ItemStackData;", "()[Lgloomyfolken/bundle/common/utils/ItemStackData;", "getNextCapture", "Ljava/time/Instant;", "timeOffset", "Lgloomyfolken/bundle/common/utils/ServerTimeOffset;", "getReserveSlot", "Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldMembers$BattlefieldReserveSlot;", "getScheduledState", "getTimeToNextStage", "hasEnoughMembers", "init", "onPlayerJoin", "readFromNBT", "tag", "reset", "sendNotification", "type", "players", "", "startBattle", "startBidding", "startPreparation", "update", "updateMembers", "updateState", "writeToNBT", "BattlefieldBidding", "BattlefieldMembers", "BattlefieldState", "minecraft"})
public final class sajz {
    @Nullable
    private String _a;
    private int _b;
    @NotNull
    private eidj _c;
    @Nullable
    private kjui _d;
    @Nullable
    private pidb _e;
    private Duration _f;
    @Nullable
    private NBTTagCompound _g;
    @NotNull
    private final amxi _h;

    @Nullable
    public final String _a() {
        return this._a;
    }

    private final void _a(String string) {
        this._a = string;
    }

    public final int _b() {
        return this._b;
    }

    public final void _a(int n) {
        this._b = n;
    }

    @NotNull
    public final eidj _c() {
        return this._c;
    }

    private final void _a(eidj eidj2) {
        this._c = eidj2;
    }

    @Nullable
    public final kjui _d() {
        return this._d;
    }

    private final void _a(kjui kjui2) {
        this._d = kjui2;
    }

    @Nullable
    public final pidb _e() {
        return this._e;
    }

    private final void _a(pidb pidb2) {
        this._e = pidb2;
    }

    public final Duration _f() {
        return this._f;
    }

    public final void _a(Duration duration) {
        this._f = duration;
    }

    @Nullable
    public final NBTTagCompound _g() {
        return this._g;
    }

    public final void _a(@Nullable NBTTagCompound nBTTagCompound) {
        this._g = nBTTagCompound;
    }

    public final void _h() {
        this._c = eidj._a;
        this._d = null;
        this._e = null;
        this._f = Duration.ZERO;
    }

    @NotNull
    public final Duration _a(@NotNull rotc rotc2) {
        Instant instant;
        Intrinsics.checkParameterIsNotNull(rotc2, "timeOffset");
        Instant instant2 = rotc2._b();
        Instant instant3 = this._b(rotc2);
        switch (dwan._b[this._c.ordinal()]) {
            case 1: {
                instant = instant3.minus(this._h._m());
                break;
            }
            case 2: {
                instant = instant3.minus(this._h._n().minus(this._f));
                break;
            }
            case 3: {
                instant = instant3;
                break;
            }
            default: {
                instant = instant3.plus(this._h._a());
            }
        }
        Instant instant4 = instant;
        Duration duration = Duration.between(instant2, instant4);
        Intrinsics.checkExpressionValueIsNotNull(duration, "Duration.between(now, stateChangeTime)");
        return duration;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Duration _a(sajz sajz2, rotc rotc2, int n, Object object) {
        if ((n & 1) != 0) {
            rotc2 = rotc._a._a();
        }
        return sajz2._a(rotc2);
    }

    private final Instant _b(rotc rotc2) {
        OffsetDateTime offsetDateTime = rotc2._c();
        LocalDate localDate = offsetDateTime.toLocalDate();
        int n = 0;
        int n2 = 7;
        while (true) {
            OffsetDateTime offsetDateTime2;
            if ((offsetDateTime2 = OffsetDateTime.of(localDate, this._h._l(), rotc2._a())).compareTo(offsetDateTime) > 0 && this._h._j().contains(localDate.getDayOfWeek())) {
                Instant instant = OffsetDateTime.of(localDate, this._h._k(), rotc2._a()).toInstant();
                Intrinsics.checkExpressionValueIsNotNull(instant, "OffsetDateTime.of(curren\u2026t.zoneOffset).toInstant()");
                return instant;
            }
            localDate = localDate.plusDays(1L);
            if (n == n2) break;
            ++n;
        }
        throw (Throwable)new IllegalStateException("WTF? next capture not found");
    }

    static /* synthetic */ Instant _b(sajz sajz2, rotc rotc2, int n, Object object) {
        if ((n & 1) != 0) {
            rotc2 = rotc._a._a();
        }
        return sajz2._b(rotc2);
    }

    private final eidj _c(rotc rotc2) {
        Instant instant;
        Instant instant2 = rotc2._b();
        return instant2.compareTo((instant = this._b(rotc2)).minus(this._h._m())) < 0 ? eidj._a : (instant2.compareTo(instant.minus(this._h._n().minus(this._f))) < 0 ? eidj._b : (instant2.compareTo(instant) < 0 ? eidj._c : eidj._d));
    }

    static /* synthetic */ eidj _c(sajz sajz2, rotc rotc2, int n, Object object) {
        if ((n & 1) != 0) {
            rotc2 = rotc._a._a();
        }
        return sajz2._c(rotc2);
    }

    private final wnce[] _j() {
        flpm flpm2;
        Object object;
        satl satl2 = tdmn._a(this._h._o());
        if (satl2 == null) {
            return new wnce[0];
        }
        satl satl3 = satl2;
        wnce[] wnceArray = (wnce[])satl3._a;
        Object object2 = wnceArray;
        Collection iterator22 = new ArrayList();
        Object object3 = object2.iterator();
        while (object3.hasNext()) {
            object = object3.next();
            flpm2 = (flpm)object;
            Iterable iterable = flpm2._b;
            CollectionsKt.addAll(iterator22, iterable);
        }
        wnceArray = CollectionsKt.filterIsInstance((List)iterator22, tdmn.kjui.class);
        object2 = wnceArray.iterator();
        while (object2.hasNext()) {
            Object e = object2.next();
            object3 = (tdmn.kjui)e;
            ((pzne)object3)._b *= ((tdmn.kjui)object3)._b(this._b);
        }
        wnceArray = satl3._b();
        Object object4 = object2 = (Iterable)satl3._a;
        object3 = new ArrayList();
        object = object4.iterator();
        while (object.hasNext()) {
            flpm flpm3 = flpm2 = object.next();
            Iterable iterable = flpm3._b;
            CollectionsKt.addAll(object3, iterable);
        }
        object2 = CollectionsKt.filterIsInstance((List)object3, tdmn.kjui.class);
        Iterator iterator2 = object2.iterator();
        while (iterator2.hasNext()) {
            object3 = iterator2.next();
            object = (tdmn.kjui)object3;
            ((pzne)object)._b /= ((tdmn.kjui)object)._b(this._b);
        }
        Intrinsics.checkExpressionValueIsNotNull(wnceArray, "items");
        return wnceArray;
    }

    public final void _b(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        this._a = owkq._a(nBTTagCompound._j("ownerClan"));
        this._b = nBTTagCompound._f("defendStreak");
        this._c = eidj.values()[nBTTagCompound._f("state")];
        if (ezpx._a(nBTTagCompound, "bidding")) {
            kjui kjui2 = new kjui();
            NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("bidding");
            Intrinsics.checkExpressionValueIsNotNull(nBTTagCompound2, "tag.getCompoundTag(\"bidding\")");
            kjui2._a(nBTTagCompound2);
            this._d = kjui2;
        }
        this._f = ezpx._a(nBTTagCompound, "biddingEndOffset") ? Duration.ofMillis(nBTTagCompound._g("biddingEndOffset")) : Duration.ZERO;
    }

    public final void _c(@NotNull NBTTagCompound nBTTagCompound) {
        block2: {
            Object object;
            Object object2;
            Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
            String string = this._a;
            if (string == null) {
                string = "";
            }
            ezpx._a(nBTTagCompound, "ownerClan", string);
            ezpx._a(nBTTagCompound, "defendStreak", this._b);
            ezpx._a(nBTTagCompound, "state", this._c.ordinal());
            kjui kjui2 = this._d;
            if (kjui2 != null) {
                object = object2 = kjui2;
                NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
                ((kjui)object)._b(nBTTagCompound2);
                ezpx._a(nBTTagCompound, "bidding", nBTTagCompound2);
            }
            Duration duration = this._f;
            if (duration == null) break block2;
            object = object2 = duration;
            ezpx._a(nBTTagCompound, "biddingEndOffset", ((Duration)object).toMillis());
        }
    }

    @NotNull
    public final amxi _i() {
        return this._h;
    }

    public sajz(@NotNull amxi amxi2) {
        Intrinsics.checkParameterIsNotNull(amxi2, "config");
        this._h = amxi2;
        this._c = eidj._a;
        this._f = Duration.ZERO;
    }

    @Nullable
    public static final /* synthetic */ String _a(sajz sajz2) {
        return sajz2._a;
    }

    public static final /* synthetic */ void _a(sajz sajz2, @Nullable String string) {
        sajz2._a = string;
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2={"Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldState;", "", "(Ljava/lang/String;I)V", "IDLENESS", "BIDDING", "PREPARATION", "BATTLE", "COMPLETED_BATTLE", "minecraft"})
    public static final class eidj
    extends Enum<eidj> {
        public static final /* enum */ eidj _a;
        public static final /* enum */ eidj _b;
        public static final /* enum */ eidj _c;
        public static final /* enum */ eidj _d;
        public static final /* enum */ eidj _e;
        private static final /* synthetic */ eidj[] $VALUES;

        static {
            eidj[] eidjArray = new eidj[5];
            eidj[] eidjArray2 = eidjArray;
            eidjArray[0] = _a = new eidj();
            eidjArray[1] = _b = new eidj();
            eidjArray[2] = _c = new eidj();
            eidjArray[3] = _d = new eidj();
            eidjArray[4] = _e = new eidj();
            $VALUES = eidjArray;
        }

        public static eidj[] values() {
            return (eidj[])$VALUES.clone();
        }

        public static eidj valueOf(String string) {
            return Enum.valueOf(eidj.class, string);
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001:\u0001\u001bB\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rJ\u001c\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u0007R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078G\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR%\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\f\u0012\n0\u000eR\u00060\u0000R\u00020\u00040\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0011\u001a\u0010\u0012\f\u0012\n0\u000eR\u00060\u0000R\u00020\u00040\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2={"Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldMembers;", "", "bidding", "Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldBidding;", "Lgloomyfolken/bundle/common/clans/battlefield/Battlefield;", "(Lgloomyfolken/bundle/common/clans/battlefield/Battlefield;Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldBidding;)V", "clans", "", "Lgloomyfolken/bundle/backend/clans/BackendClan;", "getClans", "()Ljava/util/List;", "membersByClans", "", "", "Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldMembers$BattlefieldReserveSlot;", "getMembersByClans", "()Ljava/util/Map;", "reserveSlots", "", "getReserveSlots", "()Ljava/util/Collection;", "hasClan", "", "clanName", "setReserve", "", "reservedUsernames", "BattlefieldReserveSlot", "minecraft"})
    public final class pidb {
        @NotNull
        private final Map<String, kjui> _b;

        @NotNull
        public final Map<String, kjui> _a() {
            return this._b;
        }

        @NotNull
        public final Collection<kjui> _b() {
            return this._b.values();
        }

        public final boolean _a(@NotNull String string) {
            Map<String, kjui> map;
            Map<String, kjui> map2;
            Intrinsics.checkParameterIsNotNull(string, "clanName");
            Map<String, kjui> map3 = map2 = (map = this._b);
            if (map3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            }
            return map3.containsKey(string);
        }

        public final void _a(@NotNull String string, @NotNull List<String> list) {
            Intrinsics.checkParameterIsNotNull(string, "clanName");
            Intrinsics.checkParameterIsNotNull(list, "reservedUsernames");
            kjui kjui2 = this._b.get(string);
            if (kjui2 == null) {
                throw (Throwable)new IllegalArgumentException("Clan has no members");
            }
            kjui kjui3 = kjui2;
            kjui3._c().clear();
            kjui3._c().addAll((Collection<String>)list);
        }

        public pidb(@NotNull sajz$kjui kjui2) {
            Map map;
            Object object;
            Object object2;
            Map.Entry entry;
            Object object3;
            Object object4;
            kjui.kjui kjui3;
            Object object52;
            Iterable iterable;
            Intrinsics.checkParameterIsNotNull(kjui2, "bidding");
            Iterable iterable2 = iterable = (Iterable)kjui2._a();
            Object object6 = new ArrayList();
            for (Object object52 : iterable2) {
                kjui3 = (kjui.kjui)object52;
                if (!(kjui3._a() != null)) continue;
                object6.add(object52);
            }
            iterable = (List)object6;
            iterable2 = iterable;
            object6 = new LinkedHashMap();
            for (Object object52 : iterable2) {
                Object object7;
                kjui3 = (kjui.kjui)object52;
                if (kjui3._a() == null) {
                    Intrinsics.throwNpe();
                }
                if ((object4 = (object3 = object6).get(entry)) == null) {
                    object2 = new ArrayList();
                    object3.put(entry, object2);
                    object7 = object2;
                } else {
                    object7 = object4;
                }
                object = (List)object7;
                object.add(object52);
            }
            Object object8 = object6;
            iterable = object8.entrySet();
            pidb pidb2 = this;
            int n = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16);
            object6 = iterable;
            Map map2 = new LinkedHashMap(n);
            object52 = object6.iterator();
            while (object52.hasNext()) {
                Collection<Integer> collection;
                kjui kjui4;
                kjui3 = object52.next();
                Map map3 = map2;
                entry = (Map.Entry)((Object)kjui3);
                object3 = (Iterable)entry.getValue();
                object4 = (String)entry.getKey();
                object2 = this;
                object = kjui4;
                kjui kjui5 = kjui4;
                Object k = entry.getKey();
                Object object9 = object3;
                Collection collection2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(object3, 10));
                Iterator iterator2 = object9.iterator();
                while (iterator2.hasNext()) {
                    Object t = iterator2.next();
                    kjui.kjui kjui6 = (kjui.kjui)t;
                    collection = collection2;
                    Integer n2 = kjui6._d()._d();
                    collection.add(n2);
                }
                collection = (List)collection2;
                Object t = CollectionsKt.max((Iterable)collection);
                if (t == null) {
                    Intrinsics.throwNpe();
                }
                ((kjui)object)((String)object4, ((Number)t).intValue());
                Pair pair = TuplesKt.to(k, kjui5);
                map3.put(pair.getFirst(), pair.getSecond());
            }
            pidb2._b = map = map2;
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003H\u0007J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u000ej\b\u0012\u0004\u0012\u00020\u0003`\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R-\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u0015j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0016`\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u000ej\b\u0012\u0004\u0012\u00020\u0003`\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011\u00a8\u0006#"}, d2={"Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldMembers$BattlefieldReserveSlot;", "", "clanName", "", "numPlayers", "", "(Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldMembers;Ljava/lang/String;I)V", "getClanName", "()Ljava/lang/String;", "joiningUsernames", "", "getJoiningUsernames", "()Ljava/util/Set;", "memberUsernames", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "getMemberUsernames", "()Ljava/util/LinkedHashSet;", "getNumPlayers", "()I", "playerJoinTimes", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "getPlayerJoinTimes", "()Ljava/util/LinkedHashMap;", "reservedUsernames", "getReservedUsernames", "hasSpaceFor", "", "username", "joinPlayer", "", "player", "Lgloomyfolken/bundle/backend/player/ConnectedPlayer;", "minecraft"})
        public final class kjui {
            @NotNull
            private final LinkedHashMap<String, Long> _b;
            @NotNull
            private final Set<String> _c;
            @NotNull
            private final LinkedHashSet<String> _d;
            @NotNull
            private final LinkedHashSet<String> _e;
            @NotNull
            private final String _f;
            private final int _g;

            @NotNull
            public final LinkedHashMap<String, Long> _a() {
                return this._b;
            }

            @NotNull
            public final Set<String> _b() {
                return this._c;
            }

            @NotNull
            public final LinkedHashSet<String> _c() {
                return this._d;
            }

            @NotNull
            public final LinkedHashSet<String> _d() {
                return this._e;
            }

            @NotNull
            public final String _e() {
                return this._f;
            }

            public final int _f() {
                return this._g;
            }

            public kjui(@NotNull String string, int n) {
                Intrinsics.checkParameterIsNotNull(string, "clanName");
                this._f = string;
                this._g = n;
                this._b = new LinkedHashMap();
                this._c = this._b.keySet();
                this._d = new LinkedHashSet();
                this._e = new LinkedHashSet();
            }
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001f\u0010\u0003\u001a\u0010\u0012\f\u0012\n0\u0005R\u00060\u0000R\u00020\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2={"Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldBidding;", "", "(Lgloomyfolken/bundle/common/clans/battlefield/Battlefield;)V", "slots", "", "Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldBidding$BattlefieldBidSlot;", "Lgloomyfolken/bundle/common/clans/battlefield/Battlefield;", "getSlots", "()Ljava/util/List;", "hasEnoughMembers", "", "readFromNBT", "", "tag", "Lnet/minecraft/nbt/NBTTagCompound;", "writeToNBT", "BattlefieldBidSlot", "minecraft"})
    public final class sajz$kjui {
        @NotNull
        private final List<kjui> _b;

        @NotNull
        public final List<kjui> _a() {
            return this._b;
        }

        public final void _a(@NotNull NBTTagCompound nBTTagCompound) {
            Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
            NBTTagList nBTTagList = nBTTagCompound._n("slots");
            int n = 0;
            int n2 = Math.min(nBTTagList._d(), this._b.size()) - 1;
            if (n <= n2) {
                while (true) {
                    kjui kjui2 = this._b.get(n);
                    NBTBase nBTBase = ezpx._a(nBTTagList, n);
                    if (nBTBase == null) {
                        throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagCompound");
                    }
                    NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTBase;
                    kjui2._a(owkq._a(nBTTagCompound2._j("currentClanName")));
                    kjui2._a(nBTTagCompound2._f("currentBid"));
                    if (n == n2) break;
                    ++n;
                }
            }
        }

        public final void _b(@NotNull NBTTagCompound nBTTagCompound) {
            Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
            NBTTagList nBTTagList = new NBTTagList();
            for (kjui kjui2 : this._b) {
                NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
                String string = kjui2._a();
                String string2 = "currentClanName";
                NBTTagCompound nBTTagCompound3 = nBTTagCompound2;
                String string3 = string;
                if (string3 == null) {
                    string3 = "";
                }
                String string4 = string3;
                ezpx._a(nBTTagCompound3, string2, string4);
                ezpx._a(nBTTagCompound2, "currentBid", kjui2._b());
                nBTTagList._a(nBTTagCompound2);
            }
            ezpx._a(nBTTagCompound, "slots", nBTTagList);
        }

        public sajz$kjui() {
            Collection<kjui> collection;
            Iterable iterable = sajz.this._i()._q();
            sajz$kjui kjui2 = this;
            Iterable iterable2 = iterable;
            Collection collection2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Object t : iterable2) {
                amxi.pidb pidb2 = (amxi.pidb)t;
                collection = collection2;
                kjui kjui3 = new kjui(pidb2);
                collection.add(kjui3);
            }
            collection = (List)collection2;
            kjui2._b = collection;
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0006J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006H\u0007J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0003J\b\u0010\u001a\u001a\u00020\u0015H\u0007R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001b"}, d2={"Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldBidding$BattlefieldBidSlot;", "", "slotConfig", "Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig$BattlefieldSlotConfig;", "(Lgloomyfolken/bundle/common/clans/battlefield/Battlefield$BattlefieldBidding;Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig$BattlefieldSlotConfig;)V", "currentBid", "", "getCurrentBid", "()I", "setCurrentBid", "(I)V", "currentClanName", "", "getCurrentClanName", "()Ljava/lang/String;", "setCurrentClanName", "(Ljava/lang/String;)V", "getSlotConfig", "()Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig$BattlefieldSlotConfig;", "getNextBid", "makeBid", "", "clan", "Lgloomyfolken/bundle/backend/clans/BackendClan;", "bid", "sendLostNotification", "sendWonNotification", "minecraft"})
        public final class kjui {
            @Nullable
            private String _b;
            private int _c;
            @NotNull
            private final amxi.pidb _d;

            @Nullable
            public final String _a() {
                return this._b;
            }

            public final void _a(@Nullable String string) {
                this._b = string;
            }

            public final int _b() {
                return this._c;
            }

            public final void _a(int n) {
                this._c = n;
            }

            public final int _c() {
                return Ints.max(this._d._c(), this._c + 1, owkq._k((float)this._c * 1.1f));
            }

            @NotNull
            public final amxi.pidb _d() {
                return this._d;
            }

            public kjui(@NotNull amxi.pidb pidb2) {
                Intrinsics.checkParameterIsNotNull(pidb2, "slotConfig");
                this._d = pidb2;
                this._b = this._d._b() ? sajz.this._a() : null;
            }
        }
    }
}

