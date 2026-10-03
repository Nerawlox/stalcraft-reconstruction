/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.clans;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.stats.Stat;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.weapon.WeaponMod;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import mods.pda.client.PdaClient;
import mods.pda.client.map.MapSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.util.vector.Vector2f;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u00d8\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 \u008f\u00012\u00020\u0001:\u0010\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001\u008d\u0001\u008e\u0001\u008f\u0001\u0090\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010J\u001a\u0002042\u0006\u0010K\u001a\u000208H\u0007J\b\u0010L\u001a\u00020MH\u0003J\b\u0010N\u001a\u00020\u0017H\u0003J\b\u0010O\u001a\u00020MH\u0003J\u0016\u0010P\u001a\u00020M2\f\u0010Q\u001a\b\u0018\u00010/R\u00020\u0000H\u0003J\u0014\u0010R\u001a\b\u0012\u0004\u0012\u00020$0\u00072\u0006\u0010K\u001a\u000208J$\u0010S\u001a\b\u0018\u00010 R\u00020\u00002\u0006\u0010T\u001a\u00020<2\u0006\u0010U\u001a\u00020<2\u0006\u0010V\u001a\u00020<J\u000e\u0010W\u001a\b\u0012\u0004\u0012\u00020X0\u0007H\u0007J\u000e\u0010Y\u001a\b\u0012\u0004\u0012\u00020[0ZH\u0003J\b\u0010\\\u001a\u00020]H\u0007J\u0016\u0010^\u001a\b\u0018\u00010/R\u00020\u00002\b\u0010_\u001a\u0004\u0018\u00010\u0003J\u0014\u0010^\u001a\b\u0018\u00010/R\u00020\u00002\u0006\u0010K\u001a\u000208J\u0010\u0010`\u001a\u00020M2\u0006\u0010K\u001a\u000208H\u0007J\b\u0010a\u001a\u00020MH\u0003J\u0006\u0010b\u001a\u000204J\u0006\u0010c\u001a\u000204J\u000e\u0010d\u001a\u00020M2\u0006\u0010e\u001a\u00020fJ\b\u0010g\u001a\u00020MH\u0003J\u0010\u0010h\u001a\u00020M2\u0006\u0010e\u001a\u00020fH\u0003J\u0006\u0010i\u001a\u000204J\u000e\u0010j\u001a\u0002042\u0006\u0010K\u001a\u000208J\u0010\u0010k\u001a\u00020M2\u0006\u0010K\u001a\u000208H\u0007J\b\u0010l\u001a\u00020MH\u0003J\u0018\u0010m\u001a\u00020M2\u0006\u0010n\u001a\u0002082\u0006\u0010o\u001a\u000208H\u0007J\b\u0010p\u001a\u00020MH\u0003J,\u0010q\u001a\b\u0012\u0004\u0012\u00020s0r2\u0006\u0010t\u001a\u00020u2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020s0w2\u0006\u0010x\u001a\u00020yH\u0003J\u000e\u0010z\u001a\u00020M2\u0006\u0010{\u001a\u00020|J\u0010\u0010}\u001a\u00020M2\u0006\u0010K\u001a\u000208H\u0007J\b\u0010~\u001a\u00020MH\u0003J\u0019\u0010\u007f\u001a\u00020M2\u0006\u0010K\u001a\u0002082\u0007\u0010\u0080\u0001\u001a\u00020$H\u0007J\t\u0010\u0081\u0001\u001a\u00020MH\u0007J\t\u0010\u0082\u0001\u001a\u00020MH\u0003J\t\u0010\u0083\u0001\u001a\u00020MH\u0007J\u000f\u0010\u0084\u0001\u001a\u00020M2\u0006\u0010{\u001a\u00020|J(\u0010\u0085\u0001\u001a\u000204*\u0002082\u0007\u0010\u0086\u0001\u001a\u00020<2\u0007\u0010\u0087\u0001\u001a\u00020<2\u0007\u0010\u0088\u0001\u001a\u00020<H\u0003R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\n \u0015*\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u0019R\u00020\u00000\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR(\u0010\u001c\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u001b\u0010\u001f\u001a\f\u0012\b\u0012\u00060 R\u00020\u00000\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR6\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$0#j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$`%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020+\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0017\u0010.\u001a\b\u0018\u00010/R\u00020\u0000\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0013R\u000e\u00103\u001a\u000204X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u00105\u001a\f\u0012\b\u0012\u00060/R\u00020\u00000\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001bR*\u00107\u001a\u001e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002090#j\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000209`%X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000204X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010;\u001a\u00020<X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010\u001bR\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010\u001bR\u0015\u0010C\u001a\u00060DR\u00020\u0000\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u001c\u0010G\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0013\"\u0004\bI\u0010\u0004\u00a8\u0006\u0091\u0001"}, d2={"Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext;", "", "battleId", "", "(Ljava/lang/String;)V", "defenderClanName", "slotOwnerClans", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "battleEndDuration", "Ljava/time/Duration;", "<set-?>", "Ljava/time/Instant;", "battleEndTime", "getBattleEndTime", "()Ljava/time/Instant;", "setBattleEndTime", "(Ljava/time/Instant;)V", "getBattleId", "()Ljava/lang/String;", "battleResultShowDuration", "kotlin.jvm.PlatformType", "battleResults", "Lgloomyfolken/mods/stalker/clans/BattleResult;", "battleSlots", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureSlot;", "getBattleSlots", "()Ljava/util/List;", "battleStartTime", "getBattleStartTime", "setBattleStartTime", "capturePoints", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CapturePoint;", "getCapturePoints", "colors", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getColors", "()Ljava/util/HashMap;", "setColors", "(Ljava/util/HashMap;)V", "config", "Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig;", "getConfig", "()Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig;", "defenderClan", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$BattlefieldParticipant;", "getDefenderClan", "()Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$BattlefieldParticipant;", "getDefenderClanName", "isRemote", "", "participants", "getParticipants", "prevPositions", "Lnet/minecraft/entity/player/EntityPlayer;", "Lnet/minecraft/util/Vec3;", "processedBattleResults", "scoreToWin", "", "getScoreToWin", "()D", "getSlotOwnerClans", "spawnPoints", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$IRespawnPoint;", "getSpawnPoints", "stats", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStats;", "getStats", "()Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStats;", "wonClan", "getWonClan", "setWonClan", "canSpawn", "player", "checkBattleFinish", "", "collectBattleResults", "evacuateInvalidMembers", "finishBattle", "winnerClan", "getAvailableSpawnIndices", "getCapturePointAt", "x", "y", "z", "getCaseWinners", "Lnet/minecraft/entity/player/EntityPlayerMP;", "getFeaturedPlayers", "", "Lgloomyfolken/mods/stalker/clans/FeaturedPlayer;", "getMapPage", "Lmods/pda/client/map/MapSettings$MapPage;", "getMemberClan", "clanName", "giveDefaultLoot", "giveRandomLoot", "hasBattleFinished", "hasBattleStarted", "init", "world", "Lnet/minecraft/world/World;", "initClient", "initServer", "isBattleActive", "isMember", "leaveRequest", "movePlayersFromHostileSpawns", "onPlayerKillEvent", "victim", "killer", "processBattleResults", "putItems", "", "Lnet/minecraft/item/ItemStack;", "slots", "Lkotlin/ranges/IntRange;", "items", "Ljava/util/Queue;", "inv", "Lnet/minecraft/inventory/IInventory;", "readFromNBT", "tag", "Lnet/minecraft/nbt/NBTTagCompound;", "sendOpenGuiPacket", "setupColors", "spawnRequest", "spawnId", "startBattle", "syncState", "update", "writeToNBT", "isAtHostileSpawn", "posX", "posY", "posZ", "BattleMapPage", "BattlefieldParticipant", "CapturePoint", "CaptureSlot", "CaptureStatType", "CaptureStats", "Companion", "IRespawnPoint", "minecraft"})
public final class pidb {
    private final double _b = 1000.0;
    @NotNull
    private final amxi _c;
    @NotNull
    private final List<pidb> _d;
    @Nullable
    private final pidb _e;
    @NotNull
    private final List<ezey> _f;
    @NotNull
    private final List<eidj> _g;
    @NotNull
    private final List<tupg> _h;
    @NotNull
    private final zwaw _i;
    @Nullable
    private Instant _j;
    @Nullable
    private Instant _k;
    private boolean _l;
    private gloomyfolken.mods.stalker.clans.kjui _m;
    @Nullable
    private String _n;
    @NotNull
    private HashMap<String, Integer> _o;
    private final Duration _p;
    private final Duration _q;
    private boolean _r;
    private final HashMap<EntityPlayer, Vec3> _s;
    @NotNull
    private final String _t;
    @Nullable
    private final String _u;
    @NotNull
    private final List<String> _v;
    @NotNull
    private static final Long[] _w;
    @NotNull
    private static final zwat[] _x;
    public static final jgro _a;

    public final double _a() {
        return this._b;
    }

    @NotNull
    public final amxi _b() {
        return this._c;
    }

    @NotNull
    public final List<pidb> _c() {
        return this._d;
    }

    @Nullable
    public final pidb _d() {
        return this._e;
    }

    @NotNull
    public final List<ezey> _e() {
        return this._f;
    }

    @NotNull
    public final List<eidj> _f() {
        return this._g;
    }

    @NotNull
    public final List<tupg> _g() {
        return this._h;
    }

    @NotNull
    public final zwaw _h() {
        return this._i;
    }

    @Nullable
    public final Instant _i() {
        return this._j;
    }

    private final void _a(Instant instant) {
        this._j = instant;
    }

    @Nullable
    public final Instant _j() {
        return this._k;
    }

    private final void _b(Instant instant) {
        this._k = instant;
    }

    @Nullable
    public final String _k() {
        return this._n;
    }

    public final void _a(@Nullable String string) {
        this._n = string;
    }

    @NotNull
    public final HashMap<String, Integer> _l() {
        return this._o;
    }

    public final void _a(@NotNull HashMap<String, Integer> hashMap) {
        Intrinsics.checkParameterIsNotNull(hashMap, "<set-?>");
        this._o = hashMap;
    }

    @Nullable
    public final pidb _b(@Nullable String string) {
        Object v0;
        block1: {
            Iterable iterable;
            Iterable iterable2 = iterable = (Iterable)this._d;
            for (Object t : iterable2) {
                pidb pidb2 = (pidb)t;
                if (!Intrinsics.areEqual(pidb2._b(), string)) continue;
                v0 = t;
                break block1;
            }
            v0 = null;
        }
        return v0;
    }

    @Nullable
    public final pidb _a(@NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
        return this._b(gloomyfolken.mods.stalker.clans.zwat._b((EntityPlayer)entityPlayer)._c._b());
    }

    public final boolean _b(@NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
        return this._a(entityPlayer) != null;
    }

    public final boolean _m() {
        return this._j != null;
    }

    public final boolean _n() {
        return this._k != null;
    }

    public final boolean _o() {
        return this._m() && !this._n();
    }

    public final void _a(@NotNull NBTTagCompound nBTTagCompound) {
        block3: {
            Object object;
            Object object22;
            Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
            NBTTagList nBTTagList = new NBTTagList();
            for (Object object22 : this._d) {
                nBTTagList._a(new qoae("", ((pidb)object22)._c()));
            }
            ezpx._a(nBTTagCompound, "scores", nBTTagList);
            object22 = new NBTTagList();
            for (eidj eidj2 : this._g) {
                NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
                eidj2._a(nBTTagCompound2);
                ((NBTTagList)object22)._a(nBTTagCompound2);
            }
            ezpx._a(nBTTagCompound, "points", (NBTBase)object22);
            Instant instant = this._j;
            if (instant != null) {
                Instant instant2 = instant;
                object = instant2;
                ezpx._a(nBTTagCompound, "battleStartTime", ((Instant)object).toEpochMilli());
            }
            Instant instant3 = this._k;
            if (instant3 == null) break block3;
            Instant instant4 = instant3;
            object = instant4;
            ezpx._a(nBTTagCompound, "battleEndTime", ((Instant)object).toEpochMilli());
        }
    }

    public final void _b(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        NBTTagList nBTTagList = nBTTagCompound._n("scores");
        int n = 0;
        int n2 = Integer.min(this._d.size(), nBTTagList._d()) - 1;
        if (n <= n2) {
            while (true) {
                NBTBase nBTBase = ezpx._a(nBTTagList, n);
                if (nBTBase == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagDouble");
                }
                this._d.get(n)._b(((qoae)nBTBase)._c);
                if (n == n2) break;
                ++n;
            }
        }
        NBTTagList nBTTagList2 = nBTTagCompound._n("points");
        n2 = 0;
        int n3 = Integer.min(this._g.size(), nBTTagList2._d()) - 1;
        if (n2 <= n3) {
            while (true) {
                NBTBase nBTBase = ezpx._a(nBTTagList2, n2);
                if (nBTBase == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagCompound");
                }
                this._g.get(n2)._b((NBTTagCompound)nBTBase);
                if (n2 == n3) break;
                ++n2;
            }
        }
        if (ezpx._a(nBTTagCompound, "battleStartTime")) {
            this._j = Instant.ofEpochMilli(nBTTagCompound._g("battleStartTime"));
        }
        if (ezpx._a(nBTTagCompound, "battleEndTime")) {
            this._k = Instant.ofEpochMilli(nBTTagCompound._g("battleEndTime"));
        }
    }

    public final void _a(final @NotNull World world) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        this._l = world.isRemote;
        if (this._l) {
            InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(){

                @Override
                public final void run() {
                    this._v();
                }
            });
        } else {
            InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(){

                @Override
                public final void run() {
                }
            });
        }
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    private final void _v() {
        MapSettings.MapPage mapPage = this._p();
        PdaClient.mapSettings.mapPages.put(mapPage.id, mapPage);
        this._w();
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    @NotNull
    public final MapSettings.MapPage _p() {
        amxi amxi2;
        amxi amxi3 = amxi2 = this._c;
        return new kjui("battle_" + amxi3._d(), amxi3._e(), new Vector2f(amxi3._s(), amxi3._t()), new Vector2f(amxi3._u(), amxi3._v()));
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    private final void _w() {
        String string;
        Object object;
        Object object2;
        Iterable iterable;
        String string2 = yuch._a._a;
        Iterable iterable2 = iterable = (Iterable)this._d;
        Iterable iterable3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Object object3 : iterable2) {
            pidb pidb2 = (pidb)object3;
            object2 = iterable3;
            object = pidb2._b();
            object2.add(object);
        }
        List list2 = (List)iterable3;
        iterable2 = list2;
        iterable3 = iterable2;
        Object object4 = new ArrayList();
        for (pidb pidb2 : iterable3) {
            string = (String)((Object)pidb2);
            if (!(Intrinsics.areEqual(string, string2) ^ true)) continue;
            object4.add(pidb2);
        }
        iterable = (List)object4;
        this._o.clear();
        iterable2 = list2;
        object2 = this._o;
        iterable3 = iterable2;
        object4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        for (pidb pidb2 : iterable3) {
            string = (String)((Object)pidb2);
            object = object4;
            Pair<String, Integer> pair = TuplesKt.to(string, Intrinsics.areEqual(string, string2) ? (int)4283033662L : (int)_a._a()[iterable.indexOf(string)].longValue());
            object.add(pair);
        }
        object = (List)object4;
        ((HashMap)object2).putAll(MapsKt.toMap((Iterable)object));
    }

    @NotNull
    public final List<Integer> _c(@NotNull EntityPlayer entityPlayer) {
        IndexedValue indexedValue;
        Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
        Iterable iterable = CollectionsKt.withIndex((Iterable)this._h);
        Iterable iterable2 = iterable;
        Collection collection = new ArrayList();
        for (IndexedValue indexedValue2 : iterable2) {
            indexedValue = indexedValue2;
            if (!((tupg)indexedValue.getValue())._a(entityPlayer)) continue;
            collection.add(indexedValue2);
        }
        iterable = (List)collection;
        iterable2 = iterable;
        collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        Iterator iterator2 = iterable2.iterator();
        while (iterator2.hasNext()) {
            IndexedValue indexedValue2;
            indexedValue = indexedValue2 = iterator2.next();
            Collection collection2 = collection;
            Integer n = indexedValue.getIndex();
            collection2.add(n);
        }
        return (List)collection;
    }

    @Nullable
    public final eidj _a(double d, double d2, double d3) {
        Object v0;
        block1: {
            Iterable iterable;
            Iterable iterable2 = iterable = (Iterable)this._g;
            for (Object t : iterable2) {
                eidj eidj2 = (eidj)t;
                if (!eidj2._a(d, d2, d3)) continue;
                v0 = t;
                break block1;
            }
            v0 = null;
        }
        return v0;
    }

    @NotNull
    public final String _q() {
        return this._t;
    }

    @Nullable
    public final String _r() {
        return this._u;
    }

    @NotNull
    public final List<String> _s() {
        return this._v;
    }

    public pidb(@NotNull String string, @Nullable String string2, @NotNull List<String> list2) {
        int n;
        Object object;
        Iterator<Object> iterator2;
        Object object2;
        HashMap hashMap;
        Object object3;
        Iterable iterable;
        pidb pidb2;
        Iterable iterable2;
        block5: {
            Intrinsics.checkParameterIsNotNull(string, "battleId");
            Intrinsics.checkParameterIsNotNull(list2, "slotOwnerClans");
            this._t = string;
            this._u = string2;
            this._v = list2;
            this._b = 1000.0;
            amxi amxi2 = pibk._a._a(this._t);
            if (amxi2 == null) {
                throw (Throwable)new IllegalArgumentException();
            }
            this._c = amxi2;
            iterable2 = CollectionsKt.distinct(CollectionsKt.filterNotNull((Iterable)this._v));
            pidb2 = this;
            iterable = iterable2;
            object3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
            for (Object object4 : iterable) {
                String string3 = (String)object4;
                hashMap = object3;
                object2 = new pidb(this, string3, 0.0, 2, null);
                hashMap.add(object2);
            }
            hashMap = (List)object3;
            pidb2._d = hashMap;
            iterable2 = this._d;
            pidb2 = this;
            iterable = iterable2;
            for (Iterator<Object> iterator3 : iterable) {
                Object object4;
                object4 = (pidb)((Object)iterator3);
                if (!Intrinsics.areEqual(((pidb)object4)._b(), this._u)) continue;
                iterator2 = iterator3;
                break block5;
            }
            iterator2 = null;
        }
        hashMap = iterator2;
        pidb2._e = (pidb)((Object)hashMap);
        iterable2 = this._c._q();
        pidb2 = this;
        iterable = iterable2;
        object3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        int n2 = 0;
        for (String string3 : iterable) {
            int n3 = n2++;
            object = (amxi.pidb)((Object)string3);
            n = n3;
            hashMap = object3;
            object2 = new ezey((amxi.pidb)object, this._b(this._v.get(n)));
            hashMap.add(object2);
        }
        hashMap = (List)object3;
        pidb2._f = hashMap;
        iterable2 = this._c._r();
        pidb2 = this;
        iterable = iterable2;
        object3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        n2 = 0;
        for (String string3 : iterable) {
            int n4 = n2++;
            object = (amxi.kjui)((Object)string3);
            n = n4;
            hashMap = object3;
            object2 = new eidj(n, (amxi.kjui)object);
            hashMap.add(object2);
        }
        hashMap = (List)object3;
        pidb2._g = hashMap;
        this._h = CollectionsKt.plus((Collection)this._f, (Iterable)this._g);
        this._i = new zwaw();
        pidb2 = this;
        hashMap = new HashMap();
        pidb2._o = hashMap;
        this._p = Duration.ofSeconds(4L);
        Duration duration = Duration.ofMinutes(5L);
        Intrinsics.checkExpressionValueIsNotNull(duration, "Duration.ofMinutes(5L)");
        this._q = duration;
        this._s = new HashMap();
    }

    public pidb(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "battleId");
        this(string, null, ArraysKt.toList((Object[])new String[4]));
    }

    static {
        _a = new jgro(null);
        Object[] objectArray = new Long[]{4293413680L, 4294956082L, 4289872895L};
        _w = (Long[])objectArray;
        objectArray = (Object[])new zwat[]{zwat._a, zwat._b, zwat._d, zwat._e, zwat._f, zwat._g, zwat._h};
        _x = (zwat[])objectArray;
    }

    public static final /* synthetic */ void _a(pidb pidb2, boolean bl) {
        pidb2._l = bl;
    }

    @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0087\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$BattleMapPage;", "Lmods/pda/client/map/MapSettings$MapPage;", "id", "", "name", "start", "Lorg/lwjgl/util/vector/Vector2f;", "finish", "(Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext;Ljava/lang/String;Ljava/lang/String;Lorg/lwjgl/util/vector/Vector2f;Lorg/lwjgl/util/vector/Vector2f;)V", "isValid", "", "minecraft"})
    public final class kjui
    extends MapSettings.MapPage {
        @Override
        public boolean isValid() {
            return Intrinsics.areEqual(yuch._c, pidb.this) && !pidb.this._n();
        }

        public kjui(@NotNull String string, @NotNull String string2, @NotNull Vector2f vector2f, @NotNull Vector2f vector2f2) {
            Intrinsics.checkParameterIsNotNull(string, "id");
            Intrinsics.checkParameterIsNotNull(string2, "name");
            Intrinsics.checkParameterIsNotNull(vector2f, "start");
            Intrinsics.checkParameterIsNotNull(vector2f2, "finish");
            super(string, string2, 10, vector2f, vector2f2);
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0012R\u00020\u00130\u0011J\u0016\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u0011H\u0007J\b\u0010\u0017\u001a\u00020\u000eH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2={"Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$BattlefieldParticipant;", "", "clanName", "", "clanScore", "", "(Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext;Ljava/lang/String;D)V", "getClanName", "()Ljava/lang/String;", "getClanScore", "()D", "setClanScore", "(D)V", "addScore", "", "value", "getControlledPoints", "", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CapturePoint;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext;", "getPlayers", "Lnet/minecraft/entity/player/EntityPlayerMP;", "kotlin.jvm.PlatformType", "update", "minecraft"})
    public final class pidb {
        @NotNull
        private final String _b;
        private double _c;
        final /* synthetic */ pidb _a;

        public final void _a(double d) {
            this._c = Math.min(this._c + d, this._a._a());
        }

        @NotNull
        public final List<eidj> _a() {
            Iterable iterable;
            Iterable iterable2 = iterable = (Iterable)this._a._f();
            Collection collection = new ArrayList();
            for (Object t : iterable2) {
                eidj eidj2 = (eidj)t;
                if (!(Intrinsics.areEqual(eidj2._a(), this) && eidj2._b())) continue;
                collection.add(t);
            }
            return (List)collection;
        }

        @NotNull
        public final String _b() {
            return this._b;
        }

        public final double _c() {
            return this._c;
        }

        public final void _b(double d) {
            this._c = d;
        }

        public pidb(pidb pidb2, @NotNull String string, double d) {
            Intrinsics.checkParameterIsNotNull(string, "clanName");
            this._a = pidb2;
            this._b = string;
            this._c = d;
        }

        public /* synthetic */ pidb(pidb pidb2, String string, double d, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 2) != 0) {
                d = 0.0;
            }
            this(pidb2, string, d);
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H'J\b\u0010\b\u001a\u00020\tH&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&\u00a8\u0006\r"}, d2={"Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$IRespawnPoint;", "", "canSpawn", "", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "getColor", "", "getPosition", "Lgloomyfolken/bundle/common/utils/position/LocalLocation;", "getSpawnPoints", "", "Lgloomyfolken/bundle/common/utils/position/LocalPosition;", "minecraft"})
    public static interface tupg {
        public boolean _a(@NotNull EntityPlayer var1);

        @NotNull
        public List<hrvl> _f();

        @NotNull
        public einh _h();

        @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
        public int _g();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0018\u00010\u0005R\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0017J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016R\u0017\u0010\u0004\u001a\b\u0018\u00010\u0005R\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0017"}, d2={"Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureSlot;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$IRespawnPoint;", "slotConfig", "Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig$BattlefieldSlotConfig;", "ownerClan", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$BattlefieldParticipant;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext;", "(Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext;Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig$BattlefieldSlotConfig;Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$BattlefieldParticipant;)V", "getOwnerClan", "()Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$BattlefieldParticipant;", "getSlotConfig", "()Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig$BattlefieldSlotConfig;", "canSpawn", "", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "getColor", "", "getPosition", "Lgloomyfolken/bundle/common/utils/position/LocalLocation;", "getSpawnPoints", "", "Lgloomyfolken/bundle/common/utils/position/LocalPosition;", "minecraft"})
    public final class ezey
    implements tupg {
        @NotNull
        private final amxi.pidb _b;
        @Nullable
        private final pidb _c;

        @Override
        @NotNull
        public einh _h() {
            return this._b._a();
        }

        @Override
        public boolean _a(@NotNull EntityPlayer entityPlayer) {
            Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
            return Intrinsics.areEqual(pidb.this._a(entityPlayer), this._c);
        }

        @Override
        @NotNull
        public List<hrvl> _f() {
            return this._b._e();
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
        public int _g() {
            int n;
            Object object = this._c;
            if (object != null) {
                pidb pidb2;
                pidb pidb3 = pidb2 = object;
                object = pidb.this._l().get(pidb3._b());
                if (object != null) {
                    n = (Integer)object;
                    return n;
                }
            }
            n = (int)0xAFFFFFFFL;
            return n;
        }

        @NotNull
        public final amxi.pidb _a() {
            return this._b;
        }

        @Nullable
        public final pidb _b() {
            return this._c;
        }

        public ezey(@NotNull amxi.pidb pidb3, @Nullable pidb pidb4) {
            Intrinsics.checkParameterIsNotNull(pidb3, "slotConfig");
            this._b = pidb3;
            this._c = pidb4;
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0003H\u0017J\b\u0010,\u001a\u00020-H\u0016J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u0002000/H\u0016J\u001e\u00101\u001a\u00020\u00102\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\bJ\u000e\u00105\u001a\u0002062\u0006\u00107\u001a\u000208J\b\u00109\u001a\u000206H\u0007J\u000e\u0010:\u001a\u0002062\u0006\u00107\u001a\u000208R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0010@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R0\u0010\u0017\u001a\b\u0018\u00010\u0015R\u00020\u00162\f\u0010\u0007\u001a\b\u0018\u00010\u0015R\u00020\u0016@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001c\u001a\u0012\u0012\b\u0012\u00060\u0015R\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2={"Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CapturePoint;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$IRespawnPoint;", "index", "", "pointConfig", "Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig$BattlefieldPointConfig;", "(Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext;ILgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig$BattlefieldPointConfig;)V", "<set-?>", "", "captureProgress", "getCaptureProgress", "()D", "setCaptureProgress", "(D)V", "getIndex", "()I", "", "isCaptured", "()Z", "setCaptured", "(Z)V", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$BattlefieldParticipant;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext;", "ownerClan", "getOwnerClan", "()Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$BattlefieldParticipant;", "setOwnerClan", "(Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$BattlefieldParticipant;)V", "players", "", "getPlayers", "()Ljava/util/Map;", "setPlayers", "(Ljava/util/Map;)V", "playersCount", "getPlayersCount", "getPointConfig", "()Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig$BattlefieldPointConfig;", "rewardSpan", "rewardedProgress", "canSpawn", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "getColor", "getPosition", "Lgloomyfolken/bundle/common/utils/position/LocalLocation;", "getSpawnPoints", "", "Lgloomyfolken/bundle/common/utils/position/LocalPosition;", "isAtPoint", "x", "y", "z", "readFromNBT", "", "tag", "Lnet/minecraft/nbt/NBTTagCompound;", "update", "writeToNBT", "minecraft"})
    public final class eidj
    implements tupg {
        @Nullable
        private pidb _b;
        private boolean _c;
        private double _d;
        @NotNull
        private Map<pidb, Integer> _e;
        private double _f;
        private final double _g = 0.05;
        private final int _h;
        @NotNull
        private final amxi.kjui _i;

        @Nullable
        public final pidb _a() {
            return this._b;
        }

        private final void _a(pidb pidb2) {
            this._b = pidb2;
        }

        public final boolean _b() {
            return this._c;
        }

        private final void _a(boolean bl) {
            this._c = bl;
        }

        public final double _c() {
            return this._d;
        }

        private final void _a(double d) {
            this._d = d;
        }

        @NotNull
        public final Map<pidb, Integer> _d() {
            return this._e;
        }

        public final void _a(@NotNull Map<pidb, Integer> map) {
            Intrinsics.checkParameterIsNotNull(map, "<set-?>");
            this._e = map;
        }

        public final int _e() {
            Iterable iterable = this._e.entrySet();
            int n = 0;
            for (Object t : iterable) {
                Map.Entry entry = (Map.Entry)t;
                int n2 = n;
                int n3 = ((Number)entry.getValue()).intValue();
                n = n2 + n3;
            }
            return n;
        }

        @Override
        public boolean _a(@NotNull EntityPlayer entityPlayer) {
            Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
            return Intrinsics.areEqual(pidb.this._a(entityPlayer), this._b) && this._c;
        }

        @Override
        @NotNull
        public List<hrvl> _f() {
            return this._i._l();
        }

        public final boolean _a(double d, double d2, double d3) {
            return this._i._b().contains((Double)((Comparable)Double.valueOf(d2))) && iuyu._a(d, d3, this._i._k());
        }

        public final void _a(@NotNull NBTTagCompound nBTTagCompound) {
            Map.Entry<pidb, Integer> entry;
            Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
            ezpx._a(nBTTagCompound, "captureProgress", this._d);
            Object object = this._b;
            if (object == null || (object = ((pidb)object)._b()) == null) {
                object = "";
            }
            ezpx._a(nBTTagCompound, "ownerClan", (String)object);
            ezpx._a(nBTTagCompound, "isCaptured", this._c);
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            Map map = this._e;
            Map<pidb, Integer> map2 = new LinkedHashMap();
            Object object2 = map;
            Object object3 = object2.entrySet().iterator();
            while (object3.hasNext()) {
                entry = object3.next();
                int n = ((Number)entry.getValue()).intValue();
                if (!(n > 0)) continue;
                ((HashMap)map2).put(entry.getKey(), entry.getValue());
            }
            map = map2;
            map2 = map;
            object2 = map2.entrySet().iterator();
            while (object2.hasNext()) {
                entry = object3 = (Map.Entry)object2.next();
                ezpx._a(nBTTagCompound2, ((pidb)entry.getKey())._b(), ((Number)entry.getValue()).intValue());
            }
            ezpx._a(nBTTagCompound, "players", nBTTagCompound2);
        }

        public final void _b(@NotNull NBTTagCompound nBTTagCompound) {
            Collection<Pair<pidb, Integer>> collection;
            Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
            this._d = nBTTagCompound._i("captureProgress");
            this._b = pidb.this._b(nBTTagCompound._j("ownerClan"));
            this._c = nBTTagCompound._o("isCaptured");
            Map map = nBTTagCompound._m((String)"players")._c;
            eidj eidj2 = this;
            Map map2 = map;
            Collection collection2 = new ArrayList(map.size());
            Map map3 = map2;
            Iterator iterator2 = map3.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry entry;
                Map.Entry entry2 = entry = iterator2.next();
                collection = collection2;
                Object k = entry2.getKey();
                if (k == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                }
                pidb pidb2 = pidb.this._b((String)k);
                if (pidb2 == null) {
                    Intrinsics.throwNpe();
                }
                Object v = entry2.getValue();
                if (v == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagInt");
                }
                Pair<pidb, Integer> pair = TuplesKt.to(pidb2, ((hdfw)v)._c);
                collection.add(pair);
            }
            collection = (List)collection2;
            eidj2._e = MapsKt.toMap((Iterable)collection);
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        @gloomyfolken.bundle.common.core.ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
        public int _g() {
            int n;
            Object object = this._b;
            if (object != null) {
                pidb pidb2;
                pidb pidb3 = pidb2 = object;
                object = pidb.this._l().get(pidb3._b());
                if (object != null) {
                    n = (Integer)object;
                    return n;
                }
            }
            n = (int)0xAFFFFFFFL;
            return n;
        }

        @Override
        @NotNull
        public einh _h() {
            return this._i._d();
        }

        public final int _i() {
            return this._h;
        }

        @NotNull
        public final amxi.kjui _j() {
            return this._i;
        }

        public eidj(int n, @NotNull amxi.kjui kjui2) {
            Intrinsics.checkParameterIsNotNull(kjui2, "pointConfig");
            this._h = n;
            this._i = kjui2;
            this._b = this._i._m() ? pidb.this._d() : null;
            this._c = this._b != null;
            this._d = this._b == null ? 0.0 : 1.0;
            eidj eidj2 = this;
            Map map = MapsKt.emptyMap();
            eidj2._e = map;
            this._f = this._b == null ? 0.0 : 1.0;
            this._g = 0.05;
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ!\u0010\u0010\u001a\n0\u0004R\u00060\u0000R\u00020\u00052\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0086\u0002J\u0019\u0010\u0010\u001a\n0\u0004R\u00060\u0000R\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0086\u0002J%\u0010\u0010\u001a\u000e0\u0015R\n0\u0004R\u00060\u0000R\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\u0002J\u0014\u0010\u0018\u001a\u0010\u0012\f\u0012\n0\u0004R\u00060\u0000R\u00020\u00050\u0019J \u0010\u001a\u001a\u0010\u0012\f\u0012\n0\u0004R\u00060\u0000R\u00020\u00050\u00192\n\u0010\u001b\u001a\u00060\bR\u00020\u0005J\b\u0010\u001c\u001a\u00020\u000fH\u0007R\u0016\u0010\u0003\u001a\n0\u0004R\u00060\u0000R\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000RM\u0010\u0006\u001a>\u0012\b\u0012\u00060\bR\u00020\u0005\u00120\u0012.\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n0\u0004R\u00060\u0000R\u00020\u00050\tj\u0016\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n0\u0004R\u00060\u0000R\u00020\u0005`\u000b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001e"}, d2={"Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStats;", "", "(Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext;)V", "fakeStats", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStats$CapturePlayer;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext;", "statsByClans", "", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$BattlefieldParticipant;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getStatsByClans", "()Ljava/util/Map;", "clear", "", "get", "username", "clanName", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStats$CapturePlayer$CaptureStatValue;", "type", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;", "getAllStats", "", "getSortedClanStats", "clan", "update", "CapturePlayer", "minecraft"})
    public final class zwaw {
        @NotNull
        private final Map<pidb, HashMap<String, kjui>> _b;
        private final kjui _c;

        @NotNull
        public final Map<pidb, HashMap<String, kjui>> _a() {
            return this._b;
        }

        @NotNull
        public final kjui _a(@NotNull String string, @NotNull String string2) {
            Object object;
            Object v0;
            Object object2;
            Iterator<Object> iterator2;
            Object object3;
            Object object4;
            block5: {
                Intrinsics.checkParameterIsNotNull(string, "username");
                Intrinsics.checkParameterIsNotNull(string2, "clanName");
                object3 = object4 = (Iterable)pidb.this._c();
                iterator2 = object3.iterator();
                while (iterator2.hasNext()) {
                    Object t = iterator2.next();
                    object2 = (pidb)t;
                    if (!Intrinsics.areEqual(((pidb)object2)._b(), string2)) continue;
                    v0 = t;
                    break block5;
                }
                v0 = null;
            }
            pidb pidb2 = v0;
            if (pidb2 == null) {
                return this._c;
            }
            pidb pidb3 = pidb2;
            HashMap<String, kjui> hashMap = this._b.get(pidb3);
            if (hashMap == null) {
                return this._c;
            }
            object4 = hashMap;
            object3 = (Map)object4;
            iterator2 = object3.get(string);
            if (iterator2 == null) {
                object2 = new kjui(string, string2);
                object3.put(string, object2);
                object = object2;
            } else {
                object = iterator2;
            }
            return (kjui)object;
        }

        @NotNull
        public final kjui _a(@NotNull EntityPlayer entityPlayer) {
            Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
            String string = gloomyfolken.mods.stalker.clans.zwat._b((EntityPlayer)entityPlayer)._c._b();
            if (string == null) {
                return this._c;
            }
            String string2 = string;
            String string3 = entityPlayer.username;
            Intrinsics.checkExpressionValueIsNotNull(string3, "player.username");
            return this._a(string3, string2);
        }

        @NotNull
        public final kjui.kjui _a(@NotNull EntityPlayer entityPlayer, @NotNull zwat zwat2) {
            Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
            Intrinsics.checkParameterIsNotNull((Object)zwat2, "type");
            return this._a(entityPlayer)._a(zwat2);
        }

        @NotNull
        public final List<kjui> _a(@NotNull pidb pidb2) {
            Iterable iterable;
            Intrinsics.checkParameterIsNotNull(pidb2, "clan");
            HashMap<String, kjui> hashMap = this._b.get(pidb2);
            if (hashMap == null) {
                return CollectionsKt.emptyList();
            }
            HashMap<String, kjui> hashMap2 = hashMap;
            Iterable iterable2 = iterable = (Iterable)hashMap2.values();
            Comparator comparator = new Comparator<T>(){

                public final int compare(T t, T t2) {
                    kjui kjui2 = (kjui)t2;
                    Comparable comparable = Integer.valueOf(kjui2._b());
                    kjui2 = (kjui)t;
                    Comparable comparable2 = comparable;
                    Integer n = kjui2._b();
                    return ComparisonsKt.compareValues(comparable2, (Comparable)n);
                }
            };
            return CollectionsKt.sortedWith(iterable2, comparator);
        }

        @NotNull
        public final List<kjui> _b() {
            Map<pidb, HashMap<String, kjui>> map;
            Map<pidb, HashMap<String, kjui>> map2 = map = this._b;
            Collection collection = new ArrayList();
            Object object = map2;
            Iterator<Map.Entry<pidb, HashMap<String, kjui>>> iterator2 = object.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry<pidb, HashMap<String, kjui>> entry;
                Map.Entry<pidb, HashMap<String, kjui>> entry2 = entry = iterator2.next();
                object = entry2.getValue().values();
                CollectionsKt.addAll(collection, object);
            }
            return (List)collection;
        }

        public final void _c() {
            Iterable iterable = this._b.values();
            for (Object t : iterable) {
                HashMap hashMap = (HashMap)t;
                hashMap.clear();
            }
        }

        public zwaw() {
            Map map;
            Iterable iterable = pidb.this._c();
            zwaw zwaw2 = this;
            int n = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16);
            Iterable iterable2 = iterable;
            Map map2 = new LinkedHashMap(n);
            for (Object t : iterable2) {
                Map map3 = map2;
                pidb pidb3 = (pidb)t;
                Pair pair = TuplesKt.to(pidb3, new HashMap());
                map3.put(pair.getFirst(), pair.getSecond());
            }
            zwaw2._b = map = map2;
            this._c = new kjui("", "");
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0000R\u00060\u0002R\u00020\u00030\u0001:\u0001$B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0019\u0010\u001c\u001a\u00020\u00192\u000e\u0010\u001d\u001a\n0\u0000R\u00060\u0002R\u00020\u0003H\u0096\u0002J\u001d\u0010\u001e\u001a\u000e0\u0011R\n0\u0000R\u00060\u0002R\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0010H\u0086\u0002J\u0006\u0010 \u001a\u00020\u0019J\u0019\u0010!\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0086\u0002J\u0019\u0010!\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0019H\u0086\u0002R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b8G\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR)\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e0\u0011R\n0\u0000R\u00060\u0002R\u00020\u00030\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\t\u00a8\u0006%"}, d2={"Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStats$CapturePlayer;", "", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStats;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext;", "username", "", "clanName", "(Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStats;Ljava/lang/String;Ljava/lang/String;)V", "getClanName", "()Ljava/lang/String;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "getPlayer", "()Lnet/minecraft/entity/player/EntityPlayer;", "stats", "Ljava/util/EnumMap;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStats$CapturePlayer$CaptureStatValue;", "getStats", "()Ljava/util/EnumMap;", "getUsername", "addScore", "", "source", "points", "", "title", "displayColor", "compareTo", "other", "get", "type", "getScore", "set", "value", "", "CaptureStatValue", "minecraft"})
        public final class gloomyfolken.mods.stalker.clans.pidb$zwaw$kjui
        implements Comparable<gloomyfolken.mods.stalker.clans.pidb$zwaw$kjui> {
            @NotNull
            private final EnumMap<zwat, kjui> _b;
            @NotNull
            private final String _c;
            @NotNull
            private final String _d;

            @NotNull
            public final EnumMap<zwat, kjui> _a() {
                return this._b;
            }

            @NotNull
            public final kjui _a(@NotNull zwat zwat2) {
                Object object;
                Intrinsics.checkParameterIsNotNull((Object)zwat2, "type");
                Map map = this._b;
                Object v = map.get((Object)zwat2);
                if (v == null) {
                    kjui kjui2 = new kjui(zwat2);
                    map.put(zwat2, kjui2);
                    object = kjui2;
                } else {
                    object = v;
                }
                return (kjui)object;
            }

            public final void _a(@NotNull zwat zwat2, double d) {
                Intrinsics.checkParameterIsNotNull((Object)zwat2, "type");
                this._a(zwat2)._a(d);
            }

            public final void _a(@NotNull zwat zwat2, int n) {
                Intrinsics.checkParameterIsNotNull((Object)zwat2, "type");
                this._a(zwat2, owkq._o(n));
            }

            public final int _b() {
                return this._a(zwat._j)._b();
            }

            public int _a(@NotNull gloomyfolken.mods.stalker.clans.pidb$zwaw$kjui kjui2) {
                Intrinsics.checkParameterIsNotNull(kjui2, "other");
                return Intrinsics.compare(this._b(), kjui2._b());
            }

            @Override
            public /* synthetic */ int compareTo(Object object) {
                return this._a((gloomyfolken.mods.stalker.clans.pidb$zwaw$kjui)object);
            }

            @NotNull
            public final String _c() {
                return this._c;
            }

            @NotNull
            public final String _d() {
                return this._d;
            }

            public gloomyfolken.mods.stalker.clans.pidb$zwaw$kjui(@NotNull String string, @NotNull String string2) {
                Object object;
                Intrinsics.checkParameterIsNotNull(string, "username");
                Intrinsics.checkParameterIsNotNull(string2, "clanName");
                this._c = string;
                this._d = string2;
                this._b = new EnumMap(zwat.class);
                Object object2 = object = (Object[])zwat._k._a();
                Collection collection = new ArrayList();
                for (int i = 0; i < ((Object[])object2).length; ++i) {
                    Object object3 = object2[i];
                    zwat zwat2 = (zwat)((Object)object3);
                    if (!zwat2._b()) continue;
                    collection.add(object3);
                }
                object = (List)collection;
                object2 = object.iterator();
                while (object2.hasNext()) {
                    collection = object2.next();
                    zwat zwat3 = (zwat)((Object)collection);
                    this._a(zwat3, 0.0);
                }
            }

            @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0015\u001a\u00020\u0016J\u0011\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0010H\u0086\u0002J\u0011\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\nH\u0086\u0002J\u0006\u0010\u0018\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0006J\b\u0010\u001b\u001a\u00020\u0016H\u0003R\u0011\u0010\u0005\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2={"Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStats$CapturePlayer$CaptureStatValue;", "", "type", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;", "(Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStats$CapturePlayer;Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;)V", "bool", "", "getBool", "()Z", "integer", "", "getInteger", "()I", "getType", "()Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;", "value", "", "getValue", "()D", "setValue", "(D)V", "increment", "", "plusAssign", "reset", "set", "boolean", "sync", "minecraft"})
            public final class kjui {
                private double _b;
                @NotNull
                private final zwat _c;

                public final double _a() {
                    return this._b;
                }

                public final void _a(double d) {
                    boolean bl = this._b != d;
                    double d2 = d - this._b;
                    if (pidb.this._l || pidb.this._o()) {
                        this._c._a(kjui.this, d2, pidb.this._l);
                        this._b = d;
                    }
                    if (!pidb.this._l && this._c._b() && bl) {
                        this._c._a(kjui.this, d2, pidb.this._l);
                        InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(){

                            @Override
                            public final void run() {
                            }
                        });
                    }
                }

                public final int _b() {
                    return owkq._k(this._b);
                }

                public final boolean _c() {
                    return this._b > 0.0;
                }

                public final void _a(int n) {
                    kjui kjui2 = this;
                    kjui2._a(kjui2._b + (double)n);
                }

                public final void _b(double d) {
                    kjui kjui2 = this;
                    kjui2._a(kjui2._b + d);
                }

                public final void _d() {
                    this._a(0.0);
                }

                public final void _e() {
                    this._a(1);
                }

                public final void _a(boolean bl) {
                    this._a(owkq._o(owkq._b(bl)));
                }

                @NotNull
                public final zwat _f() {
                    return this._c;
                }

                public kjui(@NotNull zwat zwat2) {
                    Intrinsics.checkParameterIsNotNull((Object)zwat2, "type");
                    this._c = zwat2;
                }
            }
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\"B#\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ(\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n0\u0012R\u00060\u0013R\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000ej\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!\u00a8\u0006#"}, d2={"Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;", "", "stat", "Lgloomyfolken/bundle/common/core/stats/Stat;", "sync", "", "title", "", "(Ljava/lang/String;ILgloomyfolken/bundle/common/core/stats/Stat;ZLjava/lang/String;)V", "getStat", "()Lgloomyfolken/bundle/common/core/stats/Stat;", "getSync", "()Z", "getTitle", "()Ljava/lang/String;", "onChange", "", "player", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStats$CapturePlayer;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStats;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext;", "delta", "", "isRemote", "KILL", "ASSIST", "DEATH", "DAMAGE", "HEADSHOT", "EXPLOSION_KILL", "MELEE_KILL", "MAX_KILL_STREAK", "IS_ALIVE", "SCORE", "Companion", "minecraft"})
    public static final class zwat
    extends Enum<zwat> {
        public static final /* enum */ zwat _a;
        public static final /* enum */ zwat _b;
        public static final /* enum */ zwat _c;
        public static final /* enum */ zwat _d;
        public static final /* enum */ zwat _e;
        public static final /* enum */ zwat _f;
        public static final /* enum */ zwat _g;
        public static final /* enum */ zwat _h;
        public static final /* enum */ zwat _i;
        public static final /* enum */ zwat _j;
        private static final /* synthetic */ zwat[] $VALUES;
        @Nullable
        private final Stat _l;
        private final boolean _m;
        @NotNull
        private final String _n;
        private static final Map<Stat, zwat> _o;
        @NotNull
        private static final zwat[] _p;
        public static final pidb _k;

        static {
            zwat zwat2;
            Iterator iterator2;
            _a = new zwat("KILL", 0, GloomyCore.KILLS, true, null, 4, null);
            _b = new kjui("ASSIST", 1);
            _c = new zwat("DEATH", 2, GloomyCore.DEATHS, true, null, 4, null);
            _d = new eidj("DAMAGE", 3);
            _e = new zwat("HEADSHOT", 4, WeaponMod._e, false, null, 4, null);
            _f = new zwat("EXPLOSION_KILL", 5, GloomyCore.EXPLOSION_KILLS, false, null, 4, null);
            _g = new zwat("MELEE_KILL", 6, WeaponMod._l, false, null, 4, null);
            _h = new zwat("MAX_KILL_STREAK", 7, GloomyCore.MAX_KILL_SERIES, false, null, 4, null);
            _i = new zwat("IS_ALIVE", 8, null, true, null, 4, null);
            _j = new zwat(null, true, "\u0421\u0447\u0451\u0442");
            $VALUES = new zwat[]{_a, _b, _c, _d, _e, _f, _g, _h, _i, _j};
            _k = new pidb(null);
            Object object = (Object[])zwat.values();
            zwat[] zwatArray = $VALUES;
            Object[] objectArray = object;
            Object object2 = new ArrayList();
            for (int i = 0; i < objectArray.length; ++i) {
                iterator2 = objectArray[i];
                zwat2 = (zwat)((Object)iterator2);
                if (!(zwat2._l != null)) continue;
                object2.add(iterator2);
            }
            Object object3 = (List)object2;
            object = (Iterable)object3;
            int n = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(object, 10)), 16);
            object2 = object;
            Map map = new LinkedHashMap(n);
            iterator2 = object2.iterator();
            while (iterator2.hasNext()) {
                zwat2 = iterator2.next();
                Map map2 = map;
                zwat zwat3 = zwat2;
                Stat stat = zwat3._l;
                if (stat == null) {
                    Intrinsics.throwNpe();
                }
                Pair<Stat, zwat> pair = TuplesKt.to(stat, zwat3);
                map2.put(pair.getFirst(), pair.getSecond());
            }
            object3 = map;
            zwat[] zwatArray2 = zwatArray;
            _o = object3;
            _p = zwat.values();
        }

        public void _a(@NotNull zwaw.kjui kjui2, double d, boolean bl) {
            Intrinsics.checkParameterIsNotNull(kjui2, "player");
        }

        @Nullable
        public final Stat _a() {
            return this._l;
        }

        public final boolean _b() {
            return this._m;
        }

        @NotNull
        public final String _c() {
            return this._n;
        }

        protected zwat(@Nullable Stat stat, boolean bl, @NotNull String string2) {
            Intrinsics.checkParameterIsNotNull(string2, "title");
            this._l = stat;
            this._m = bl;
            this._n = string2;
        }

        /* synthetic */ zwat(String string, int n, Stat stat, boolean bl, String object, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 4) != 0) {
                Object object2 = stat;
                if (object2 == null || (object2 = ((Stat)object2).title) == null) {
                    object2 = "";
                }
                object = object2;
            }
            this(stat, bl, (String)object);
        }

        public static zwat[] values() {
            return (zwat[])$VALUES.clone();
        }

        public static zwat valueOf(String string) {
            return Enum.valueOf(zwat.class, string);
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n0\u0006R\u00060\u0007R\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2={"Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType$ASSIST;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;", "(Ljava/lang/String;I)V", "onChange", "", "player", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStats$CapturePlayer;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStats;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext;", "delta", "", "isRemote", "", "minecraft"})
        public static final class kjui
        extends zwat {
            @Override
            public void _a(final @NotNull zwaw.kjui kjui2, final double d, boolean bl) {
                Intrinsics.checkParameterIsNotNull(kjui2, "player");
                InvokeSideOnly.frontend(!bl, new InvokeSideOnly.InvokeFrontendOnly(){

                    @Override
                    public final void run() {
                    }
                });
            }

            kjui() {
            }
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n0\u0006R\u00060\u0007R\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2={"Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType$DAMAGE;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;", "(Ljava/lang/String;I)V", "onChange", "", "player", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStats$CapturePlayer;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStats;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext;", "delta", "", "isRemote", "", "minecraft"})
        public static final class eidj
        extends zwat {
            @Override
            public void _a(final @NotNull zwaw.kjui kjui2, final double d, boolean bl) {
                Intrinsics.checkParameterIsNotNull(kjui2, "player");
                InvokeSideOnly.frontend(!bl, new InvokeSideOnly.InvokeFrontendOnly(){

                    @Override
                    public final void run() {
                    }
                });
            }

            eidj() {
            }
        }

        @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0005R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2={"Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType$Companion;", "", "()V", "captureStatMap", "", "Lgloomyfolken/bundle/common/core/stats/Stat;", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;", "getCaptureStatMap", "()Ljava/util/Map;", "types", "", "getTypes", "()[Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;", "[Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;", "get", "stat", "minecraft"})
        public static final class pidb {
            private final Map<Stat, zwat> _b() {
                return _o;
            }

            @NotNull
            public final zwat[] _a() {
                return _p;
            }

            @Nullable
            public final zwat _a(@NotNull Stat stat) {
                Intrinsics.checkParameterIsNotNull(stat, "stat");
                return this._b().get(stat);
            }

            private pidb() {
            }

            public /* synthetic */ pidb(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2={"Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$Companion;", "", "()V", "COLORS", "", "", "getCOLORS", "()[Ljava/lang/Long;", "[Ljava/lang/Long;", "statsToRewardFor", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;", "getStatsToRewardFor", "()[Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;", "[Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;", "minecraft"})
    public static final class jgro {
        @NotNull
        public final Long[] _a() {
            return _w;
        }

        @NotNull
        public final zwat[] _b() {
            return _x;
        }

        private jgro() {
        }

        public /* synthetic */ jgro(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

