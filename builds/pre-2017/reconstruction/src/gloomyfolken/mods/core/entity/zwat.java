/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.entity;

import gloomyfolken.mods.core.entity.ezey;
import gloomyfolken.mods.core.misc.pibn;
import gloomyfolken.mods.core.misc.samo;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0006J*\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0013J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\u001c\u0010\u001f\u001a\u00020\u00172\b\u0010\u0002\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0006H\u0002J\b\u0010'\u001a\u00020\fH\u0002J\u0006\u0010(\u001a\u00020\u0017J\u0012\u0010)\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0006\u0010*\u001a\u00020\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0010j\b\u0012\u0004\u0012\u00020\f`\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2={"Lgloomyfolken/mods/core/entity/EntityStateManager;", "Lnet/minecraftforge/common/IExtendedEntityProperties;", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "(Lnet/minecraft/entity/EntityLivingBase;)V", "STATE_HISTORY_LENGTH", "", "getEntity", "()Lnet/minecraft/entity/EntityLivingBase;", "lastPoolIndex", "localStatePool", "", "Lgloomyfolken/mods/core/misc/IWorldStatePart;", "[Lgloomyfolken/mods/core/misc/IWorldStatePart;", "masterState", "stateHistory", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "temp", "Lnet/minecraft/util/Vec3;", "kotlin.jvm.PlatformType", "temp1", "applyMasterState", "", "applyStateAtIndex", "amount", "applyStateWithGuess", "Lkotlin/Pair;", "baseRollback", "maxOffset", "sourcePosition", "init", "Lnet/minecraft/entity/Entity;", "world", "Lnet/minecraft/world/World;", "loadNBTData", "compound", "Lnet/minecraft/nbt/NBTTagCompound;", "maxIndex", "provideNewState", "save", "saveNBTData", "tick", "Companion", "minecraft"})
public final class zwat
implements IExtendedEntityProperties {
    private int _b;
    private final pibn[] _c;
    private int _d;
    private final ArrayList<pibn> _e;
    private pibn _f;
    private final Vec3 _g;
    private final Vec3 _h;
    @NotNull
    private final EntityLivingBase _i;
    @NotNull
    private static final String _j = "entity_game_state";
    private static final samo<EntityLivingBase, Function1<zwat, pibn>> _k;
    public static final kjui _a;

    private final void _h() {
        this._e.ensureCapacity(this._b);
        this._f = this._i();
        this._a();
    }

    private final pibn _i() {
        return (pibn)((Function1)zwat._a._c()._a(this._i.getClass())).invoke(this);
    }

    private final int _j() {
        return this._e.size() - 1;
    }

    public final void _a() {
        int n = this._d;
        this._d = n + 1;
        pibn pibn2 = this._c[n];
        this._d %= this._b;
        while (this._b > 0 && this._e.size() >= this._b) {
            this._e.remove(0);
        }
        this._b();
        pibn2._a();
        this._e.add(pibn2);
    }

    public final void _b() {
        this._f._a();
    }

    public final void _c() {
        this._f._b();
    }

    public final void _a(int n) {
        if (n >= 0) {
            int n2 = owkq._b(n, this._j());
            Collection collection = this._e;
            if (!collection.isEmpty()) {
                this._e.get(this._e.size() - 1 - n2)._b();
            }
        }
    }

    @NotNull
    public final Pair<Integer, Vec3> _a(int n, int n2, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "sourcePosition");
        double d = 999.0;
        int n3 = n;
        int n4 = owkq._c(n - n2, 0);
        int n5 = owkq._b(n + n2, this._j());
        int n6 = n4;
        int n7 = n5;
        if (n6 <= n7) {
            while (true) {
                this._a(n6);
                VecExtensionsKt.set(this._g, this._i.posX, this._i.posY, this._i.posZ);
                double d2 = this._g._d(vec3);
                if (d2 < d) {
                    d = d2;
                    n3 = n6;
                    Vec3 vec32 = this._g;
                    Intrinsics.checkExpressionValueIsNotNull(vec32, "temp");
                    VecExtensionsKt.set(this._h, vec32);
                }
                if (n6 == n7) break;
                ++n6;
            }
        }
        this._a(n3);
        Integer n8 = n3;
        Vec3 vec33 = this._h;
        Intrinsics.checkExpressionValueIsNotNull(vec33, "temp1");
        return TuplesKt.to(n8, VecExtensionsKt.vec3(vec33));
    }

    @Override
    public void saveNBTData(@Nullable NBTTagCompound nBTTagCompound) {
    }

    @Override
    public void loadNBTData(@Nullable NBTTagCompound nBTTagCompound) {
    }

    @Override
    public void init(@Nullable Entity entity, @Nullable World world) {
        if (entity != null && entity instanceof EntityLivingBase) {
            this._h();
        }
    }

    @NotNull
    public final EntityLivingBase _d() {
        return this._i;
    }

    public zwat(@NotNull EntityLivingBase entityLivingBase) {
        Object object;
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "entity");
        this._i = entityLivingBase;
        int n = this._b = 16;
        zwat zwat2 = this;
        pibn[] pibnArray = new pibn[n];
        int n2 = 0;
        int n3 = n - 1;
        if (n2 <= n3) {
            do {
                pibn pibn2;
                int n4 = ++n2;
                int n5 = n2;
                object = pibnArray;
                object[n5] = pibn2 = this._i();
            } while (n2 != n3);
        }
        object = pibnArray;
        zwat2._c = object;
        zwat2 = this;
        zwat2._e = object = new ArrayList();
        this._f = new ezey<EntityLivingBase>(this._i);
        this._g = VecExtensionsKt.vec3();
        this._h = VecExtensionsKt.vec3();
    }

    static {
        _a = new kjui(null);
        _j = _j;
        _k = new samo(EntityLivingBase.class);
        zwat._a._c()._a(EntityLivingBase.class, pidb._a);
    }

    @NotNull
    public static final String _g() {
        return _a._b();
    }

    @JvmStatic
    @Nullable
    public static final zwat _a(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        return _a._a(entity);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R,\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\tX\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2={"Lgloomyfolken/mods/core/entity/EntityStateManager$Companion;", "", "()V", "ATTRIB", "", "ATTRIB$annotations", "getATTRIB", "()Ljava/lang/String;", "stateInitializers", "Lgloomyfolken/mods/core/misc/NearestInstanceAbstractFactory;", "Lnet/minecraft/entity/EntityLivingBase;", "Lkotlin/Function1;", "Lgloomyfolken/mods/core/entity/EntityStateManager;", "Lgloomyfolken/mods/core/misc/IWorldStatePart;", "getStateInitializers", "()Lgloomyfolken/mods/core/misc/NearestInstanceAbstractFactory;", "getInstance", "entity", "Lnet/minecraft/entity/Entity;", "minecraft"})
    public static final class kjui {
        @JvmStatic
        public static /* synthetic */ void _a() {
        }

        @NotNull
        public final String _b() {
            return _j;
        }

        private final samo<EntityLivingBase, Function1<zwat, pibn>> _c() {
            return _k;
        }

        @JvmStatic
        @Nullable
        public final zwat _a(@NotNull Entity entity) {
            Intrinsics.checkParameterIsNotNull(entity, "entity");
            IExtendedEntityProperties iExtendedEntityProperties = entity.getExtendedProperties(this._b());
            if (!(iExtendedEntityProperties instanceof zwat)) {
                iExtendedEntityProperties = null;
            }
            return (zwat)iExtendedEntityProperties;
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

