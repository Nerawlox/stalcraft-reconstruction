/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.effects.client.main.pidb;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ezey(_a={eidj.CLIENT})
@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0006\u0010\u001b\u001a\u00020\u0013J\u0012\u0010\u001c\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u001f"}, d2={"Lgloomyfolken/mods/stalker/misc/item/ArtefactEffectSourceItem;", "Lnet/minecraftforge/common/IExtendedEntityProperties;", "itemEntity", "Lnet/minecraft/entity/item/EntityItem;", "(Lnet/minecraft/entity/item/EntityItem;)V", "getItemEntity", "()Lnet/minecraft/entity/item/EntityItem;", "spawnedEffect", "", "getSpawnedEffect", "()Z", "setSpawnedEffect", "(Z)V", "createParticleEmitter", "Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEffectSystem;", "preset", "Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEffectPreset;", "getStackEffectPreset", "init", "", "entity", "Lnet/minecraft/entity/Entity;", "world", "Lnet/minecraft/world/World;", "loadNBTData", "compound", "Lnet/minecraft/nbt/NBTTagCompound;", "onEntityUpdate", "saveNBTData", "spawnArtefaktEffectInWorld", "Companion", "minecraft"})
public final class fmsn
implements IExtendedEntityProperties {
    private boolean _b;
    @NotNull
    private final EntityItem _c;
    @NotNull
    private static final String _d = "art_eff_source_item";
    public static final kjui _a = new kjui(null);

    public final boolean _a() {
        return this._b;
    }

    public final void _a(boolean bl) {
        this._b = bl;
    }

    @Override
    public void saveNBTData(@Nullable NBTTagCompound nBTTagCompound) {
    }

    @Override
    public void loadNBTData(@Nullable NBTTagCompound nBTTagCompound) {
    }

    @Override
    public void init(@Nullable Entity entity, @Nullable World world) {
    }

    public final void _b() {
        if (this._c.worldObj.isRemote) {
            ItemStack itemStack = this._c.getEntityItem();
            if (itemStack == null) {
                return;
            }
            ItemStack itemStack2 = itemStack;
            if (!this._b && itemStack2._d != Block.stone.blockID) {
                zgiu zgiu2 = this._c();
                if (zgiu2 == null) {
                    return;
                }
                zgiu zgiu3 = zgiu2;
                this._a(zgiu3);
            }
        }
    }

    @ezey(_a={eidj.CLIENT})
    public final void _a(@NotNull zgiu zgiu2) {
        Intrinsics.checkParameterIsNotNull(zgiu2, "preset");
        this._b = true;
        oxkw oxkw2 = this._b(zgiu2);
        Iterable iterable = oxkw2._b();
        for (Object t : iterable) {
            cuib cuib2 = (cuib)t;
            pidb._a(cuib2);
        }
        pidb._a(oxkw2);
    }

    @ezey(_a={eidj.CLIENT})
    @Nullable
    public final zgiu _c() {
        ItemStack itemStack = this._c.getEntityItem();
        Item item = itemStack != null ? itemStack._a() : null;
        if (!(item instanceof cdit)) {
            item = null;
        }
        cdit cdit2 = (cdit)item;
        if (cdit2 == null) {
            return null;
        }
        cdit cdit3 = cdit2;
        return StalkerMiscMod.instance.__av.get(cdit3._e);
    }

    @ezey(_a={eidj.CLIENT})
    @NotNull
    public final oxkw _b(@NotNull zgiu zgiu2) {
        Intrinsics.checkParameterIsNotNull(zgiu2, "preset");
        return new oxkw(this._c, zgiu2);
    }

    @NotNull
    public final EntityItem _d() {
        return this._c;
    }

    public fmsn(@NotNull EntityItem entityItem) {
        Intrinsics.checkParameterIsNotNull(entityItem, "itemEntity");
        this._c = entityItem;
    }

    static {
        _d = _d;
    }

    @NotNull
    public static final String _f() {
        return _a._b();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lgloomyfolken/mods/stalker/misc/item/ArtefactEffectSourceItem$Companion;", "", "()V", "ID", "", "ID$annotations", "getID", "()Ljava/lang/String;", "minecraft"})
    public static final class kjui {
        @JvmStatic
        public static /* synthetic */ void _a() {
        }

        @NotNull
        public final String _b() {
            return _d;
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

