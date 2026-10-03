/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.entity;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.entity.EntityImmovableLiving;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.jxtc;
import gloomyfolken.mods.core.misc.ugqi;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.physics.core.client.world.PhysicsWorldContext;
import gloomyfolken.mods.physics.ragdolls.RagdollsMod;
import gloomyfolken.mods.physics.ragdolls.client.RagdollsClient;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.CollisionModel;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.CorpseRagdollContext;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.SavedAnimationStateEntry;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.SkeletonPresetMesh;
import gloomyfolken.mods.physics.ragdolls.client.render.CorpseAnimationHandler;
import gloomyfolken.mods.physics.ragdolls.entity.CorpseInventoryProvider;
import gloomyfolken.mods.physics.ragdolls.entity.CorpseRagdollState;
import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpseBag;
import gloomyfolken.mods.physics.ragdolls.entity.ILeftoversRenderInfo;
import gloomyfolken.mods.physics.ragdolls.inventory.ContainerCorpse;
import gloomyfolken.mods.physics.ragdolls.inventory.InventoryCorpse;
import gloomyfolken.mods.physics.ragdolls.items.ItemCorpseRemover;
import gloomyfolken.mods.physics.ragdolls.packet.PacketDeleteCorpse;
import gloomyfolken.mods.physics.ragdolls.packet.PacketSearchCorpse;
import gloomyfolken.mods.weapon.trace.EntityTracer;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u00de\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\r\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010X\u001a\u00020\u001fH\u0016J\u0010\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\H\u0017J\u0010\u0010]\u001a\u00020Z2\u0006\u0010^\u001a\u00020_H\u0014J\b\u0010`\u001a\u00020aH'J\b\u0010b\u001a\u00020cH\u0016J\n\u0010d\u001a\u0004\u0018\u00010eH\u0007J\u0010\u0010f\u001a\u00020\u00192\u0006\u0010g\u001a\u00020:H\u0016J\b\u0010h\u001a\u00020iH\u0017J\n\u0010j\u001a\u0004\u0018\u00010.H\u0017J\b\u0010k\u001a\u00020%H\u0016J\u0010\u0010l\u001a\n\u0012\u0006\b\u0001\u0012\u00020_0mH'J\b\u0010n\u001a\u00020\u0019H\u0016J\b\u0010o\u001a\u00020\u0013H\u0016J\b\u0010p\u001a\u0004\u0018\u00010\u0011J\b\u0010q\u001a\u00020rH\u0017J\b\u0010s\u001a\u00020\u0013H\u0016J\b\u0010t\u001a\u00020\u0013H\u0016J\u0010\u0010u\u001a\u00020\u001f2\u0006\u0010v\u001a\u00020wH\u0014J\b\u0010x\u001a\u00020\u001fH\u0016J\u0010\u0010y\u001a\u00020\u001f2\u0006\u0010z\u001a\u00020wH\u0016J\b\u0010{\u001a\u00020ZH\u0016J\b\u0010|\u001a\u00020ZH\u0014J\b\u0010}\u001a\u00020ZH\u0016J\u0010\u0010~\u001a\u00020Z2\u0006\u0010v\u001a\u00020wH\u0016J\u0012\u0010\u007f\u001a\u00020Z2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0016J\u0011\u0010\u0082\u0001\u001a\u00020Z2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001J\u0013\u0010\u0085\u0001\u001a\u00020Z2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J\u0013\u0010\u0086\u0001\u001a\u0004\u0018\u00010.2\u0006\u0010[\u001a\u00020\\H'J)\u0010\u0087\u0001\u001a\u00020\u00002\u0007\u0010\u0088\u0001\u001a\u00020\\2\u0015\u0010\u0089\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0005\u0012\u00030\u008b\u00010\u008a\u0001H\u0016J\t\u0010\u008c\u0001\u001a\u00020ZH\u0016J\u0010\u0010\u008d\u0001\u001a\u00020Z2\u0007\u0010\u008e\u0001\u001a\u00020\u0011J\t\u0010\u008f\u0001\u001a\u00020ZH\u0017J\t\u0010\u0090\u0001\u001a\u00020\u001fH\u0016J\t\u0010\u0091\u0001\u001a\u00020ZH\u0004J\u0013\u0010\u0092\u0001\u001a\u00020Z2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0016J\u0013\u0010\u0093\u0001\u001a\u00020Z2\b\u0010\u0083\u0001\u001a\u00030\u0094\u0001H\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001f@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0016\u00103\u001a\n 5*\u0004\u0018\u00010404X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u00106\u001a\n 5*\u0004\u0018\u00010404\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001a\u00109\u001a\u00020:X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001b\"\u0004\bA\u0010\u001dR\u001a\u0010B\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001b\"\u0004\bD\u0010\u001dR\u0019\u0010E\u001a\n 5*\u0004\u0018\u00010404\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u00108R\u001a\u0010G\u001a\u00020:X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010<\"\u0004\bI\u0010>R\u0019\u0010J\u001a\n 5*\u0004\u0018\u00010404\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u00108R\u001a\u0010L\u001a\u00020MX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020MX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010O\"\u0004\bT\u0010QR\u001a\u0010U\u001a\u00020\u001fX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010!\"\u0004\bW\u0010#\u00a8\u0006\u0095\u0001"}, d2={"Lgloomyfolken/mods/physics/ragdolls/entity/EntityRagdollCorpse;", "Lgloomyfolken/mods/core/entity/EntityImmovableLiving;", "Lgloomyfolken/mods/physics/ragdolls/entity/CorpseInventoryProvider;", "Lcpw/mods/fml/common/registry/IEntityAdditionalSpawnData;", "Lgloomyfolken/mods/core/misc/FrontendMetrics$IEntityMetricsType;", "Lgloomyfolken/mods/physics/ragdolls/entity/ILeftoversRenderInfo;", "Lgloomyfolken/mods/core/misc/IDisabledStateManager;", "par1World", "Lnet/minecraft/world/World;", "(Lnet/minecraft/world/World;)V", "_animationHandler", "", "get_animationHandler", "()Ljava/lang/Object;", "set_animationHandler", "(Ljava/lang/Object;)V", "_physicsState", "Lgloomyfolken/mods/physics/ragdolls/entity/CorpseRagdollState;", "corpseName", "", "getCorpseName", "()Ljava/lang/String;", "setCorpseName", "(Ljava/lang/String;)V", "currentItem", "", "getCurrentItem", "()I", "setCurrentItem", "(I)V", "initialDeath", "", "getInitialDeath", "()Z", "setInitialDeath", "(Z)V", "inventory", "Lgloomyfolken/mods/physics/ragdolls/inventory/InventoryCorpse;", "getInventory", "()Lgloomyfolken/mods/physics/ragdolls/inventory/InventoryCorpse;", "setInventory", "(Lgloomyfolken/mods/physics/ragdolls/inventory/InventoryCorpse;)V", "<set-?>", "isLeftovers", "setLeftovers", "lastOwnerSkeletonState", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;", "getLastOwnerSkeletonState", "()Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;", "setLastOwnerSkeletonState", "(Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;)V", "leftoversPos", "Lnet/minecraft/util/Vec3;", "kotlin.jvm.PlatformType", "ownerDeathPos", "getOwnerDeathPos", "()Lnet/minecraft/util/Vec3;", "ownerDeathYaw", "", "getOwnerDeathYaw", "()F", "setOwnerDeathYaw", "(F)V", "ownerDiedAt", "getOwnerDiedAt", "setOwnerDiedAt", "ownerEntityId", "getOwnerEntityId", "setOwnerEntityId", "ownerMotion", "getOwnerMotion", "ownerScale", "getOwnerScale", "setOwnerScale", "physCorpseWorldPos", "getPhysCorpseWorldPos", "timeDiedAt", "", "getTimeDiedAt", "()J", "setTimeDiedAt", "(J)V", "timeLootedAt", "getTimeLootedAt", "setTimeLootedAt", "wasLooted", "getWasLooted", "setWasLooted", "canBeCollidedWith", "cloneOwnerEntity", "", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "collideWithEntity", "par1Entity", "Lnet/minecraft/entity/Entity;", "createAnimationContext", "Lgloomyfolken/mods/effects/common/mcsa/animation/IAnimation;", "createBag", "Lgloomyfolken/mods/physics/ragdolls/entity/EntityCorpseBag;", "getAnimationHandler", "Lgloomyfolken/mods/physics/ragdolls/client/render/CorpseAnimationHandler;", "getBrightnessForRender", "par1", "getCollisionModel", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/CollisionModel;", "getCorpseInitialState", "getCorpseInventory", "getCorpseOwnerClass", "Ljava/lang/Class;", "getEntityId", "getNameForCorpse", "getPhysicsState", "getSkeletonPreset", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/SkeletonPresetMesh;", "getTranslatedEntityName", "getType", "interact", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "isServer", "isUsable", "par1EntityPlayer", "killOwner", "onDeathUpdate", "onUpdate", "openContainer", "readEntityFromNBT", "tag", "Lnet/minecraft/nbt/NBTTagCompound;", "readSpawnData", "data", "Lcom/google/common/io/ByteArrayDataInput;", "readSpawnDataInternal", "restoreOwnerLastSkeletonState", "serverInit", "owner", "itemsToDrop", "", "Lnet/minecraft/item/ItemStack;", "setDead", "setPhysicsState", "state", "setToLeftovers", "shouldUseLeftoversRenderer", "spawnBag", "writeEntityToNBT", "writeSpawnData", "Lcom/google/common/io/ByteArrayDataOutput;", "minecraft"})
public abstract class EntityRagdollCorpse
extends EntityImmovableLiving
implements IEntityAdditionalSpawnData,
jxtc.pidb,
ugqi,
CorpseInventoryProvider,
ILeftoversRenderInfo {
    @NotNull
    private String corpseName;
    private int ownerEntityId;
    @NotNull
    private InventoryCorpse inventory;
    private boolean initialDeath;
    private int currentItem;
    private boolean wasLooted;
    private final ofbx physCorpseWorldPos;
    private int ownerDiedAt;
    private final ofbx ownerDeathPos;
    private final ofbx ownerMotion;
    private float ownerDeathYaw;
    private float ownerScale;
    private long timeDiedAt;
    private long timeLootedAt;
    private boolean isLeftovers;
    private final ofbx leftoversPos;
    private CorpseRagdollState _physicsState;
    @Nullable
    private Object _animationHandler;
    @ezey(_a={eidj.CLIENT})
    @Nullable
    private ivtm lastOwnerSkeletonState;

    @NotNull
    public final String getCorpseName() {
        return this.corpseName;
    }

    public final void setCorpseName(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "<set-?>");
        this.corpseName = string;
    }

    public final int getOwnerEntityId() {
        return this.ownerEntityId;
    }

    public final void setOwnerEntityId(int n) {
        this.ownerEntityId = n;
    }

    @NotNull
    public final InventoryCorpse getInventory() {
        return this.inventory;
    }

    public final void setInventory(@NotNull InventoryCorpse inventoryCorpse) {
        Intrinsics.checkParameterIsNotNull(inventoryCorpse, "<set-?>");
        this.inventory = inventoryCorpse;
    }

    public final boolean getInitialDeath() {
        return this.initialDeath;
    }

    public final void setInitialDeath(boolean bl) {
        this.initialDeath = bl;
    }

    protected final int getCurrentItem() {
        return this.currentItem;
    }

    protected final void setCurrentItem(int n) {
        this.currentItem = n;
    }

    protected final boolean getWasLooted() {
        return this.wasLooted;
    }

    protected final void setWasLooted(boolean bl) {
        this.wasLooted = bl;
    }

    public final ofbx getPhysCorpseWorldPos() {
        return this.physCorpseWorldPos;
    }

    public final int getOwnerDiedAt() {
        return this.ownerDiedAt;
    }

    public final void setOwnerDiedAt(int n) {
        this.ownerDiedAt = n;
    }

    public final ofbx getOwnerDeathPos() {
        return this.ownerDeathPos;
    }

    public final ofbx getOwnerMotion() {
        return this.ownerMotion;
    }

    public final float getOwnerDeathYaw() {
        return this.ownerDeathYaw;
    }

    public final void setOwnerDeathYaw(float f) {
        this.ownerDeathYaw = f;
    }

    public final float getOwnerScale() {
        return this.ownerScale;
    }

    public final void setOwnerScale(float f) {
        this.ownerScale = f;
    }

    public final long getTimeDiedAt() {
        return this.timeDiedAt;
    }

    public final void setTimeDiedAt(long l) {
        this.timeDiedAt = l;
    }

    public final long getTimeLootedAt() {
        return this.timeLootedAt;
    }

    public final void setTimeLootedAt(long l) {
        this.timeLootedAt = l;
    }

    public final boolean isLeftovers() {
        return this.isLeftovers;
    }

    private final void setLeftovers(boolean bl) {
        this.isLeftovers = bl;
    }

    @Nullable
    protected final Object get_animationHandler() {
        return this._animationHandler;
    }

    protected final void set_animationHandler(@Nullable Object object) {
        this._animationHandler = object;
    }

    @ezey(_a={eidj.CLIENT})
    @Nullable
    public final ivtm getLastOwnerSkeletonState() {
        return this.lastOwnerSkeletonState;
    }

    @ezey(_a={eidj.CLIENT})
    public final void setLastOwnerSkeletonState(@Nullable ivtm ivtm2) {
        this.lastOwnerSkeletonState = ivtm2;
    }

    @Override
    public boolean isServer() {
        return !this.field_70170_p.field_72995_K;
    }

    @Override
    public int getEntityId() {
        return this.field_70157_k;
    }

    @Override
    @NotNull
    public String getNameForCorpse() {
        return this.corpseName;
    }

    @Override
    public boolean isUsable(@NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "par1EntityPlayer");
        double d = Math.hypot(this.field_70165_t - entityPlayer.field_70165_t, this.field_70161_v - entityPlayer.field_70161_v);
        return !this.field_70128_L && d < RagdollsMod.LOOT_PICKUP_DISTANCE;
    }

    @Override
    @NotNull
    public InventoryCorpse getCorpseInventory() {
        return this.inventory;
    }

    @NotNull
    public EntityRagdollCorpse serverInit(@NotNull EntityLivingBase entityLivingBase, @NotNull Map<Integer, cvzo> map) {
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "owner");
        Intrinsics.checkParameterIsNotNull(map, "itemsToDrop");
        this.field_82174_bp = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.field_70759_as = entityLivingBase.field_70759_as;
        this.field_70761_aq = this.field_70760_ar = entityLivingBase.field_70761_aq;
        this.field_70145_X = true;
        this.ownerEntityId = entityLivingBase.field_70157_k;
        VecExtensionsKt.set(this.ownerDeathPos, McExtensionsKt.getPos(entityLivingBase));
        this.ownerDeathYaw = entityLivingBase.field_70177_z;
        this.ownerDiedAt = entityLivingBase.field_70173_aa;
        this.field_70714_bg._a.clear();
        this.field_70715_bh._a.clear();
        this.func_70012_b(entityLivingBase.field_70165_t, entityLivingBase.field_70163_u, entityLivingBase.field_70161_v, entityLivingBase.field_70177_z, entityLivingBase.field_70125_A);
        return this;
    }

    @Override
    public int func_70070_b(float f) {
        int n;
        int n2;
        int n3 = sajh._c(this.field_70165_t);
        if (this.field_70170_p.func_72899_e(n3, n2 = sajh._c(this.field_70163_u), n = sajh._c(this.field_70161_v))) {
            return this.field_70170_p.func_72802_i(n3, n2, n, 0);
        }
        return 0;
    }

    public void killOwner() {
        block0: {
            if (this.field_70170_p.func_73045_a(this.ownerEntityId) == null) break block0;
            this.field_70170_p.func_73045_a(this.ownerEntityId).field_70128_L = true;
        }
    }

    @Override
    protected boolean func_70085_c(@NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        boolean bl = booleanRef.element = !this.field_70170_p.field_72995_K;
        if (this.field_70170_p.field_72995_K) {
            InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(this, entityPlayer, booleanRef){
                final /* synthetic */ EntityRagdollCorpse this$0;
                final /* synthetic */ EntityPlayer $player;
                final /* synthetic */ Ref.BooleanRef $foundEntity;

                /*
                 * Enabled aggressive block sorting
                 */
                public final void run() {
                    EntityRagdollCorpse entityRagdollCorpse;
                    T t;
                    EntityRagdollCorpse entityRagdollCorpse2;
                    if (this.$player.func_71045_bC() != null) {
                        cvzo cvzo2 = this.$player.func_71045_bC();
                        if (cvzo2 == null) {
                            Intrinsics.throwNpe();
                        }
                        if (cvzo2._a() instanceof ItemCorpseRemover) {
                            new PacketDeleteCorpse(this.this$0.field_70157_k).sendToServer();
                            return;
                        }
                    }
                    EntityRagdollCorpse entityRagdollCorpse3 = entityRagdollCorpse2 = this.this$0;
                    Iterable iterable = this.this$0.field_70170_p.func_72872_a(EntityRagdollCorpse.class, this.this$0.field_70121_D);
                    Iterator<T> iterator2 = iterable.iterator();
                    do {
                        if (!iterator2.hasNext()) return;
                        T t2 = iterator2.next();
                        T t3 = t2;
                        t = t3;
                        if (t instanceof EntityRagdollCorpse) continue;
                        t = null;
                    } while ((EntityRagdollCorpse)t == null || !Intrinsics.areEqual(EntityTracer._a((ozlu)this.this$0.field_70170_p, (ofbx)ofbx._a((double)this.$player.field_70165_t, (double)(this.$player.field_70163_u + (double)this.$player.func_70047_e()), (double)this.$player.field_70161_v), (float)this.$player.field_70177_z, (float)this.$player.field_70125_A, (float)0.0f, (float)3.0f, (Entity)((Entity)this.$player))._i, entityRagdollCorpse));
                    new PacketSearchCorpse(entityRagdollCorpse.field_70157_k).sendToServer();
                    this.$foundEntity.element = true;
                }
                {
                    this.this$0 = entityRagdollCorpse;
                    this.$player = entityPlayer;
                    this.$foundEntity = booleanRef;
                }
            });
        }
        return booleanRef.element;
    }

    @Override
    public boolean func_70067_L() {
        return RagdollsMod.instance.tracingCorpses;
    }

    public final void setPhysicsState(@NotNull CorpseRagdollState corpseRagdollState) {
        Intrinsics.checkParameterIsNotNull(corpseRagdollState, "state");
        this._physicsState = corpseRagdollState;
    }

    @Nullable
    public final CorpseRagdollState getPhysicsState() {
        return this._physicsState;
    }

    @Override
    public void openContainer(@NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
        ContainerCorpse containerCorpse = RagdollsMod.createCorpseContainer(this);
        InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(this, entityPlayer, containerCorpse){
            final /* synthetic */ EntityRagdollCorpse this$0;
            final /* synthetic */ EntityPlayer $player;
            final /* synthetic */ ContainerCorpse $container;

            public final void run() {
            }
            {
                this.this$0 = entityRagdollCorpse;
                this.$player = entityPlayer;
                this.$container = containerCorpse;
            }
        });
        if (this.timeLootedAt < (long)0) {
            this.timeLootedAt = System.currentTimeMillis();
        }
    }

    @Override
    public void func_70037_a(@NotNull qoac qoac2) {
        Intrinsics.checkParameterIsNotNull(qoac2, "tag");
        super.func_70037_a(qoac2);
        String string = qoac2._j("corpseName");
        Intrinsics.checkExpressionValueIsNotNull(string, "tag.getString(\"corpseName\")");
        this.corpseName = string;
        this.currentItem = qoac2._f("current_item");
        qoac qoac3 = qoac2._m("inv");
        Intrinsics.checkExpressionValueIsNotNull(qoac3, "tag.getCompoundTag(\"inv\")");
        this.inventory.readFromNBT(qoac3);
        ofbx ofbx2 = this.ownerDeathPos;
        Intrinsics.checkExpressionValueIsNotNull(ofbx2, "ownerDeathPos");
        McExtensionsKt.readVec3f(qoac2, "ownerDeathPos", ofbx2);
        this.ownerDeathYaw = qoac2._h("ownerDeathYaw");
        this.ownerScale = qoac2._h("scale");
        this.timeDiedAt = qoac2._g("timeDiedAt");
        if (qoac2._c("timeLootedAt")) {
            this.timeLootedAt = qoac2._g("timeLootedAt");
        }
    }

    @Override
    public void func_70014_b(@NotNull qoac qoac2) {
        Intrinsics.checkParameterIsNotNull(qoac2, "tag");
        super.func_70014_b(qoac2);
        qoac2._a("corpseName", this.corpseName);
        qoac2._a("current_item", this.currentItem);
        qoac2._a("inv", (huhy)this.inventory.writeToNBT(new qoac()));
        ofbx ofbx2 = this.ownerDeathPos;
        Intrinsics.checkExpressionValueIsNotNull(ofbx2, "ownerDeathPos");
        McExtensionsKt.writeVec3f(qoac2, "ownerDeathPos", ofbx2);
        qoac2._a("ownerDeathYaw", this.ownerDeathYaw);
        qoac2._a("scale", this.ownerScale);
        qoac2._a("timeDiedAt", this.timeDiedAt);
        qoac2._a("timeLootedAt", this.timeLootedAt);
    }

    @Override
    public void writeSpawnData(@NotNull ByteArrayDataOutput byteArrayDataOutput) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataOutput, "data");
        byteArrayDataOutput.writeInt(this.currentItem);
        byteArrayDataOutput.writeInt(this.ownerEntityId);
        byteArrayDataOutput.writeUTF(this.corpseName);
        ofbx ofbx2 = this.ownerDeathPos;
        Intrinsics.checkExpressionValueIsNotNull(ofbx2, "ownerDeathPos");
        McExtensionsKt.writeVec3f(byteArrayDataOutput, ofbx2);
        byteArrayDataOutput.writeFloat(this.ownerDeathYaw);
        byteArrayDataOutput.writeFloat(this.ownerScale);
        byteArrayDataOutput.writeBoolean(this.field_70173_aa == 0 && this.ownerDiedAt > 0);
    }

    @Override
    public final void readSpawnData(@NotNull ByteArrayDataInput byteArrayDataInput) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataInput, "data");
        this.readSpawnDataInternal(byteArrayDataInput);
        InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(this){
            final /* synthetic */ EntityRagdollCorpse this$0;

            public final void run() {
                SavedAnimationStateEntry savedAnimationStateEntry = RagdollsMod.instance.getSavedRagdollState(this.this$0.field_70157_k);
                ivtm ivtm2 = savedAnimationStateEntry != null ? savedAnimationStateEntry.getState() : null;
                Entity entity = this.this$0.field_70170_p.func_73045_a(this.this$0.getOwnerEntityId());
                if (entity != null && entity instanceof EntityLivingBase && this.this$0.getInitialDeath()) {
                    this.this$0.cloneOwnerEntity((EntityLivingBase)entity);
                    if (ivtm2 == null) {
                        ivtm ivtm3 = this.this$0.restoreOwnerLastSkeletonState((EntityLivingBase)entity);
                        if (ivtm3 == null) {
                            ivtm3 = new ivtm(this.this$0.getCollisionModel().getSkeleton()._e);
                        }
                        this.this$0.setLastOwnerSkeletonState(ivtm3);
                        ivtm2 = this.this$0.getLastOwnerSkeletonState();
                    }
                } else {
                    this.this$0.setInitialDeath(false);
                }
                if (ivtm2 == null) {
                    this.this$0.setToLeftovers();
                } else {
                    this.this$0.set_animationHandler(new CorpseAnimationHandler(this.this$0, ivtm2));
                }
            }
            {
                this.this$0 = entityRagdollCorpse;
            }
        });
        ofbx ofbx2 = this.ownerDeathPos;
        Intrinsics.checkExpressionValueIsNotNull(ofbx2, "ownerDeathPos");
        VecExtensionsKt.set(this.physCorpseWorldPos, ofbx2);
        ofbx ofbx3 = this.ownerDeathPos;
        Intrinsics.checkExpressionValueIsNotNull(ofbx3, "ownerDeathPos");
        McExtensionsKt.setLastTickPos(this, ofbx3);
        ofbx ofbx4 = this.ownerDeathPos;
        Intrinsics.checkExpressionValueIsNotNull(ofbx4, "ownerDeathPos");
        McExtensionsKt.setPrevPos(this, ofbx4);
        ofbx ofbx5 = this.ownerDeathPos;
        Intrinsics.checkExpressionValueIsNotNull(ofbx5, "ownerDeathPos");
        McExtensionsKt.setPos(this, ofbx5);
        VecExtensionsKt.set(this.leftoversPos, McExtensionsKt.getPos(this));
        this.field_70177_z = this.ownerDeathYaw;
        this.field_70126_B = this.ownerDeathYaw;
        this.func_70080_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0f);
    }

    @ezey(_a={eidj.CLIENT})
    public void setToLeftovers() {
        this.isLeftovers = true;
        this.func_70105_a(0.6f, 0.35f);
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    }

    public void readSpawnDataInternal(@NotNull ByteArrayDataInput byteArrayDataInput) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataInput, "data");
        this.currentItem = byteArrayDataInput.readInt();
        this.ownerEntityId = byteArrayDataInput.readInt();
        String string = byteArrayDataInput.readUTF();
        Intrinsics.checkExpressionValueIsNotNull(string, "data.readUTF()");
        this.corpseName = string;
        ofbx ofbx2 = this.ownerDeathPos;
        Intrinsics.checkExpressionValueIsNotNull(ofbx2, "ownerDeathPos");
        McExtensionsKt.readVec3f(byteArrayDataInput, ofbx2);
        this.ownerDeathYaw = byteArrayDataInput.readFloat();
        this.ownerScale = byteArrayDataInput.readFloat();
        this.initialDeath = byteArrayDataInput.readBoolean();
    }

    @Override
    protected void func_82167_n(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "par1Entity");
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70128_L) {
            return;
        }
        if (!this.field_70170_p.field_72995_K) {
            this.field_70145_X = true;
            ofbx ofbx2 = this.ownerDeathPos;
            Intrinsics.checkExpressionValueIsNotNull(ofbx2, "ownerDeathPos");
            McExtensionsKt.setPos(this, ofbx2);
        } else {
            this.field_70126_B = this.field_70177_z;
            McExtensionsKt.setPrevPos(this, McExtensionsKt.getPos(this));
            if (this.isLeftovers) {
                ofbx ofbx3 = McExtensionsKt.getPos(this);
                ofbx ofbx4 = this.leftoversPos;
                Intrinsics.checkExpressionValueIsNotNull(ofbx4, "leftoversPos");
                VecExtensionsKt.set(ofbx3, ofbx4);
                if (!this.field_70122_E) {
                    this.fallDown();
                }
                VecExtensionsKt.set(this.leftoversPos, McExtensionsKt.getPos(this));
                this.field_70160_al = false;
            } else {
                ofbx ofbx5 = this.physCorpseWorldPos;
                Intrinsics.checkExpressionValueIsNotNull(ofbx5, "physCorpseWorldPos");
                McExtensionsKt.setPos(this, ofbx5);
                InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(this){
                    final /* synthetic */ EntityRagdollCorpse this$0;

                    public final void run() {
                        block0: {
                            CorpseAnimationHandler corpseAnimationHandler = this.this$0.getAnimationHandler();
                            if (corpseAnimationHandler == null) break block0;
                            corpseAnimationHandler.tick();
                        }
                    }
                    {
                        this.this$0 = entityRagdollCorpse;
                    }
                });
                VecExtensionsKt.set(this.leftoversPos, McExtensionsKt.getPos(this));
            }
        }
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        if (!this.field_70170_p.field_72995_K && this.field_70170_p.field_73013_u == 0) {
            this.func_70106_y();
        }
        if (this.field_70163_u < -64.0) {
            this.func_70106_y();
        }
        if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
            boolean bl;
            boolean bl2 = System.currentTimeMillis() > this.timeDiedAt + (long)600000;
            boolean bl3 = bl = System.currentTimeMillis() > this.timeDiedAt + (long)GloomyCore.getIntOption("corpse_bag_spawn_delay");
            if (bl && this.inventory.getUsers() == 0 || bl2) {
                if (this.inventory.getUsers() != 0) {
                    Logger.warning("Despawning corpse while it's container was opened! This may be a bug, or just a coincidence.", new Object[0]);
                }
                this.spawnBag();
            }
        }
    }

    protected final void spawnBag() {
        if (!this.inventory.isEmpty()) {
            EntityCorpseBag entityCorpseBag = this.createBag();
            this.field_70170_p.func_72838_d(entityCorpseBag);
        }
        this.func_70106_y();
    }

    @NotNull
    public EntityCorpseBag createBag() {
        return new EntityCorpseBag(this);
    }

    @Override
    public void func_70106_y() {
        super.func_70106_y();
        if (this.field_70170_p.field_72995_K) {
            InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(this){
                final /* synthetic */ EntityRagdollCorpse this$0;

                public final void run() {
                    block0: {
                        Object object = this.this$0.getPhysicsState();
                        if (object == null || (object = ((CorpseRagdollState)object).getClientPhysicsContext()) == null || (object = ((CorpseRagdollContext)object).getWorldContext()) == null) break block0;
                        ((PhysicsWorldContext)object).setShouldSimulationStop(true);
                    }
                }
                {
                    this.this$0 = entityRagdollCorpse;
                }
            });
        }
    }

    @Override
    protected void func_70609_aI() {
        EntityRagdollCorpse entityRagdollCorpse = this;
        ++entityRagdollCorpse.field_70725_aQ;
        int cfr_ignored_0 = entityRagdollCorpse.field_70725_aQ;
        if (this.field_70725_aQ == 20) {
            this.func_70106_y();
        }
    }

    @Override
    @NotNull
    public String func_96090_ax() {
        return "\u0422\u0440\u0443\u043f " + this.corpseName;
    }

    @ezey(_a={eidj.CLIENT})
    @Nullable
    public final CorpseAnimationHandler getAnimationHandler() {
        Object object = this._animationHandler;
        if (!(object instanceof CorpseAnimationHandler)) {
            object = null;
        }
        return (CorpseAnimationHandler)object;
    }

    @ezey(_a={eidj.CLIENT})
    @Nullable
    public abstract ivtm restoreOwnerLastSkeletonState(@NotNull EntityLivingBase var1);

    @ezey(_a={eidj.CLIENT})
    @NotNull
    public CollisionModel getCollisionModel() {
        CollisionModel collisionModel = RagdollsClient.Companion.getInstance().getCache()._a(this.getCorpseOwnerClass());
        if (collisionModel == null) {
            Intrinsics.throwNpe();
        }
        return collisionModel;
    }

    @ezey(_a={eidj.CLIENT})
    @NotNull
    public SkeletonPresetMesh getSkeletonPreset() {
        return this.getCollisionModel().getSkeletonPreset();
    }

    @ezey(_a={eidj.CLIENT})
    @NotNull
    public abstract nuct createAnimationContext();

    @ezey(_a={eidj.CLIENT})
    @NotNull
    public abstract Class<? extends Entity> getCorpseOwnerClass();

    @ezey(_a={eidj.CLIENT})
    public void cloneOwnerEntity(@NotNull EntityLivingBase entityLivingBase) {
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "entity");
        this.field_70130_N = entityLivingBase.field_70130_N;
        this.field_70131_O = entityLivingBase.field_70131_O;
        VecExtensionsKt.set(this.ownerDeathPos, McExtensionsKt.getPrevPos(entityLivingBase));
        VecExtensionsKt.set(this.ownerMotion, VecExtensionsKt.minus(McExtensionsKt.getPos(entityLivingBase), McExtensionsKt.getPrevPos(entityLivingBase)));
        this.ownerDeathYaw = entityLivingBase.field_70126_B;
    }

    @ezey(_a={eidj.CLIENT})
    @Nullable
    public ivtm getCorpseInitialState() {
        return this.lastOwnerSkeletonState;
    }

    @Override
    public boolean shouldUseLeftoversRenderer() {
        return this.isLeftovers;
    }

    @Override
    @NotNull
    public String getType() {
        return "corpse";
    }

    public EntityRagdollCorpse(@NotNull ozlu ozlu2) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "par1World");
        super(ozlu2);
        this.corpseName = "";
        this.ownerEntityId = -1;
        this.physCorpseWorldPos = VecExtensionsKt.vec3();
        this.ownerDiedAt = -1;
        this.ownerDeathPos = VecExtensionsKt.vec3();
        this.ownerMotion = VecExtensionsKt.vec3();
        this.ownerScale = 1.0f;
        this.timeLootedAt = -1L;
        this.leftoversPos = VecExtensionsKt.vec3();
        this.inventory = new InventoryCorpse(this, MapsKt.emptyMap());
        this.timeDiedAt = System.currentTimeMillis();
        this.func_70105_a(1.0E-4f, 1.0E-4f);
    }

    @Override
    public void open() {
        CorpseInventoryProvider.DefaultImpls.open(this);
    }

    @Override
    public void close() {
        CorpseInventoryProvider.DefaultImpls.close(this);
    }
}

