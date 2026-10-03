/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0007J\b\u0010%\u001a\u00020\u0019H\u0007J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0007R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004R\u0011\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u0011\u0010\u0010\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\b\u00a8\u0006'"}, d2={"Lgloomyfolken/mods/stalker/misc/sickness/SicknessList;", "", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "(Lnet/minecraft/entity/player/EntityPlayer;)V", "biological", "Lgloomyfolken/mods/stalker/misc/sickness/Sickness;", "getBiological", "()Lgloomyfolken/mods/stalker/misc/sickness/Sickness;", "bleeding", "getBleeding", "getPlayer", "()Lnet/minecraft/entity/player/EntityPlayer;", "setPlayer", "psycho", "getPsycho", "radiation", "getRadiation", "sicknesses", "Ljava/util/ArrayList;", "getSicknesses", "()Ljava/util/ArrayList;", "thermal", "getThermal", "addPower", "", "accumulation", "Lgloomyfolken/mods/stalker/misc/sickness/SicknessAccumulation;", "addSickness", "type", "Lgloomyfolken/mods/stalker/misc/sickness/SicknessType;", "getSickness", "name", "", "readNBT", "tag", "Lnet/minecraft/nbt/NBTTagCompound;", "tick", "writeNBT", "minecraft"})
public final class mrja {
    @NotNull
    private final ArrayList<ejqm> _a;
    @NotNull
    private final ejqm _b;
    @NotNull
    private final ejqm _c;
    @NotNull
    private final ejqm _d;
    @NotNull
    private final ejqm _e;
    @NotNull
    private final ejqm _f;
    @NotNull
    private EntityPlayer _g;

    @NotNull
    public final ArrayList<ejqm> _a() {
        return this._a;
    }

    @NotNull
    public final ejqm _b() {
        return this._b;
    }

    @NotNull
    public final ejqm _c() {
        return this._c;
    }

    @NotNull
    public final ejqm _d() {
        return this._d;
    }

    @NotNull
    public final ejqm _e() {
        return this._e;
    }

    @NotNull
    public final ejqm _f() {
        return this._f;
    }

    private final ejqm _a(klcb klcb2) {
        ejqm ejqm2 = new ejqm(klcb2, this._g);
        Collection collection = this._a;
        collection.add(ejqm2);
        return ejqm2;
    }

    public final void _a(@NotNull yulf yulf2) {
        Intrinsics.checkParameterIsNotNull(yulf2, "accumulation");
        Iterable iterable = this._a;
        for (Object t : iterable) {
            ejqm ejqm2 = (ejqm)t;
            ejqm2._a(yulf2._a(ejqm2._g()));
        }
    }

    @Nullable
    public final ejqm _a(@NotNull String string) {
        Object v0;
        block1: {
            Iterable iterable;
            Intrinsics.checkParameterIsNotNull(string, "name");
            Iterable iterable2 = iterable = (Iterable)this._a;
            for (Object t : iterable2) {
                ejqm ejqm2 = (ejqm)t;
                if (!Intrinsics.areEqual(ejqm2._b(), string)) continue;
                v0 = t;
                break block1;
            }
            v0 = null;
        }
        return v0;
    }

    @NotNull
    public final EntityPlayer _g() {
        return this._g;
    }

    public final void _a(@NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "<set-?>");
        this._g = entityPlayer;
    }

    public mrja(@NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
        this._g = entityPlayer;
        this._a = new ArrayList();
        this._b = this._a(klcb._a);
        this._c = this._a(klcb._b);
        this._d = this._a(klcb._c);
        this._e = this._a(klcb._d);
        this._f = this._a(klcb._e);
    }
}

