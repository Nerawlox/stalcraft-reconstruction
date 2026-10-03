/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.clans;

import gloomyfolken.mods.stalker.clans.pidb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.NBTTagCompound;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2={"Lgloomyfolken/mods/stalker/clans/FeaturedPlayer;", "", "username", "", "clan", "stat", "Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;", "value", "", "armorStack", "Lnet/minecraft/nbt/NBTTagCompound;", "(Ljava/lang/String;Ljava/lang/String;Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;DLnet/minecraft/nbt/NBTTagCompound;)V", "getArmorStack", "()Lnet/minecraft/nbt/NBTTagCompound;", "getClan", "()Ljava/lang/String;", "getStat", "()Lgloomyfolken/mods/stalker/clans/BattlefieldCaptureContext$CaptureStatType;", "getUsername", "getValue", "()D", "minecraft"})
public final class zwaw {
    @NotNull
    private final String _a;
    @NotNull
    private final String _b;
    @NotNull
    private final pidb.zwat _c;
    private final double _d;
    @Nullable
    private final NBTTagCompound _e;

    @NotNull
    public final String _a() {
        return this._a;
    }

    @NotNull
    public final String _b() {
        return this._b;
    }

    @NotNull
    public final pidb.zwat _c() {
        return this._c;
    }

    public final double _d() {
        return this._d;
    }

    @Nullable
    public final NBTTagCompound _e() {
        return this._e;
    }

    public zwaw(@NotNull String string, @NotNull String string2, @NotNull pidb.zwat zwat2, double d, @Nullable NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(string, "username");
        Intrinsics.checkParameterIsNotNull(string2, "clan");
        Intrinsics.checkParameterIsNotNull((Object)zwat2, "stat");
        this._a = string;
        this._b = string2;
        this._c = zwat2;
        this._d = d;
        this._e = nBTTagCompound;
    }
}

