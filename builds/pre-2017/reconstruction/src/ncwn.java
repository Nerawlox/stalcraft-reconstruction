/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 52\u00020\u0001:\u00015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010-\u001a\u00020.2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020.2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020.2\u0006\u00102\u001a\u000203H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R!\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001a\u0010'\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\u001a\u0010*\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014\u00a8\u00066"}, d2={"Lgloomyfolken/mods/core/spawn/EntitySpawnerTag;", "Lnet/minecraftforge/common/IExtendedEntityProperties;", "()V", "entity", "Lnet/minecraft/entity/Entity;", "getEntity", "()Lnet/minecraft/entity/Entity;", "setEntity", "(Lnet/minecraft/entity/Entity;)V", "hasHome", "", "getHasHome", "()Z", "setHasHome", "(Z)V", "homeHeightMax", "", "getHomeHeightMax", "()I", "setHomeHeightMax", "(I)V", "homeHeightMin", "getHomeHeightMin", "setHomeHeightMin", "homeTriangles", "Ljava/util/ArrayList;", "Lgloomyfolken/mods/core/spawn/RegionTriangle;", "Lkotlin/collections/ArrayList;", "getHomeTriangles", "()Ljava/util/ArrayList;", "spawnController", "Lgloomyfolken/mods/core/spawn/EntitySpawnController;", "getSpawnController", "()Lgloomyfolken/mods/core/spawn/EntitySpawnController;", "setSpawnController", "(Lgloomyfolken/mods/core/spawn/EntitySpawnController;)V", "spawnX", "getSpawnX", "setSpawnX", "spawnY", "getSpawnY", "setSpawnY", "spawnZ", "getSpawnZ", "setSpawnZ", "init", "", "world", "Lnet/minecraft/world/World;", "loadNBTData", "compound", "Lnet/minecraft/nbt/NBTTagCompound;", "saveNBTData", "Companion", "minecraft"})
public final class ncwn
implements IExtendedEntityProperties {
    @Nullable
    private Entity _c;
    private int _d;
    private int _e;
    private int _f;
    private boolean _g;
    @NotNull
    private final ArrayList<kksf> _h;
    private int _i;
    private int _j;
    @NotNull
    public ivki _a;
    @NotNull
    private static final String _k = "stalspawntag";
    public static final kjui _b = new kjui(null);

    @Nullable
    public final Entity _a() {
        return this._c;
    }

    public final void _a(@Nullable Entity entity) {
        this._c = entity;
    }

    public final int _b() {
        return this._d;
    }

    public final void _a(int n) {
        this._d = n;
    }

    public final int _c() {
        return this._e;
    }

    public final void _b(int n) {
        this._e = n;
    }

    public final int _d() {
        return this._f;
    }

    public final void _c(int n) {
        this._f = n;
    }

    public final boolean _e() {
        return this._g;
    }

    public final void _a(boolean bl) {
        this._g = bl;
    }

    @NotNull
    public final ArrayList<kksf> _f() {
        return this._h;
    }

    public final int _g() {
        return this._i;
    }

    public final void _d(int n) {
        this._i = n;
    }

    public final int _h() {
        return this._j;
    }

    public final void _e(int n) {
        this._j = n;
    }

    @NotNull
    public final ivki _i() {
        ivki ivki2 = this._a;
        if (ivki2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spawnController");
        }
        return ivki2;
    }

    public final void _a(@NotNull ivki ivki2) {
        Intrinsics.checkParameterIsNotNull(ivki2, "<set-?>");
        this._a = ivki2;
    }

    @Override
    public void saveNBTData(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "compound");
    }

    @Override
    public void loadNBTData(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "compound");
    }

    @Override
    public void init(@NotNull Entity entity, @NotNull World world) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        Intrinsics.checkParameterIsNotNull(world, "world");
        this._c = entity;
    }

    public ncwn() {
        ncwn ncwn2 = this;
        ArrayList arrayList = new ArrayList();
        ncwn2._h = arrayList;
    }

    static {
        _k = _k;
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lgloomyfolken/mods/core/spawn/EntitySpawnerTag$Companion;", "", "()V", "ATTRIB", "", "getATTRIB", "()Ljava/lang/String;", "minecraft"})
    public static final class kjui {
        @NotNull
        public final String _a() {
            return _k;
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

