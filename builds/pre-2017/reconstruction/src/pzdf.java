/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0086\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0007J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0096\u0002J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0004J\b\u0010\u0019\u001a\u00020\u0014H\u0007J\u0016\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cR\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001d"}, d2={"Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldsList;", "", "Lgloomyfolken/bundle/common/clans/battlefield/Battlefield;", "data", "Lnet/minecraft/nbt/NBTTagCompound;", "(Lnet/minecraft/nbt/NBTTagCompound;)V", "configList", "", "Lgloomyfolken/bundle/common/clans/battlefield/BattlefieldConfig;", "(Ljava/util/List;)V", "battlefields", "", "", "getBattlefields", "()Ljava/util/Map;", "getConfigList", "()Ljava/util/List;", "get", "name", "init", "", "iterator", "", "readFromNBT", "tag", "update", "writeToNBT", "writeBattleResults", "", "minecraft"})
public final class pzdf
implements Iterable<sajz>,
KMappedMarker {
    @NotNull
    private final Map<String, sajz> _a;
    @NotNull
    private final List<amxi> _b;

    @NotNull
    public final Map<String, sajz> _a() {
        return this._a;
    }

    public final void _a(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        NBTTagList nBTTagList = nBTTagCompound._n("battlefields");
        int n = 0;
        int n2 = nBTTagList._d() - 1;
        if (n <= n2) {
            while (true) {
                NBTBase nBTBase = ezpx._a(nBTTagList, n);
                if (nBTBase == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.nbt.NBTTagCompound");
                }
                NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTBase;
                String string = nBTTagCompound2._j("id");
                sajz sajz2 = this._a.get(string);
                if (sajz2 != null) {
                    sajz2._b(nBTTagCompound2);
                }
                if (nBTTagCompound2._c("battle_results")) {
                    sajz sajz3 = this._a.get(string);
                    if (sajz3 != null) {
                        sajz3._a(nBTTagCompound2._m("battle_results"));
                    }
                }
                if (n == n2) break;
                ++n;
            }
        }
    }

    public final void _a(@NotNull NBTTagCompound nBTTagCompound, boolean bl) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "tag");
        NBTTagList nBTTagList = new NBTTagList();
        for (sajz sajz2 : this._a.values()) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("id", sajz2._i()._d());
            sajz2._c(nBTTagCompound2);
            if (bl && sajz2._g() != null) {
                NBTTagCompound nBTTagCompound3 = sajz2._g();
                if (nBTTagCompound3 == null) {
                    Intrinsics.throwNpe();
                }
                ezpx._a(nBTTagCompound2, "battle_results", nBTTagCompound3);
            }
            nBTTagList._a(nBTTagCompound2);
        }
        ezpx._a(nBTTagCompound, "battlefields", nBTTagList);
    }

    @Nullable
    public final sajz _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        return this._a.get(string);
    }

    @Override
    @NotNull
    public Iterator<sajz> iterator() {
        return this._a.values().iterator();
    }

    @NotNull
    public final List<amxi> _b() {
        return this._b;
    }

    public pzdf(@NotNull List<amxi> list) {
        Object object;
        Object object2;
        Object object3;
        Intrinsics.checkParameterIsNotNull(list, "configList");
        this._b = list;
        Iterable iterable = this._b;
        pzdf pzdf2 = this;
        Object object4 = iterable;
        Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        Iterator<Object> iterator22 = object4.iterator();
        while (iterator22.hasNext()) {
            object3 = iterator22.next();
            amxi amxi2 = (amxi)object3;
            object2 = collection;
            object = new sajz(amxi2);
            object2.add(object);
        }
        object2 = (List)collection;
        iterable = (Iterable)object2;
        object4 = new LinkedHashMap();
        for (Iterator<Object> iterator22 : iterable) {
            object3 = (sajz)((Object)iterator22);
            object2 = object4;
            object = ((sajz)object3)._i()._d();
            object2.put(object, iterator22);
        }
        pzdf2._a = object2 = object4;
    }

    public pzdf(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "data");
        this(pibk._a._b());
        this._a(nBTTagCompound);
    }
}

