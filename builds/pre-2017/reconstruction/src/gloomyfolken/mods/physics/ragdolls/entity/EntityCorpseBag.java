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
import gloomyfolken.mods.core.entity.EntityImmovableLiving;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.ugqi;
import gloomyfolken.mods.effects.client.mcsa.kjui;
import gloomyfolken.mods.physics.ragdolls.RagdollsMod;
import gloomyfolken.mods.physics.ragdolls.client.render.RenderCorpseLeftovers;
import gloomyfolken.mods.physics.ragdolls.entity.CorpseInventoryProvider;
import gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse;
import gloomyfolken.mods.physics.ragdolls.entity.ILeftoversRenderInfo;
import gloomyfolken.mods.physics.ragdolls.inventory.ContainerCorpse;
import gloomyfolken.mods.physics.ragdolls.inventory.InventoryCorpse;
import gloomyfolken.mods.physics.ragdolls.packet.PacketSearchCorpse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010:\u001a\u00020%H\u0016J\b\u0010;\u001a\u00020\u0019H\u0016J\u0018\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0004H\u0017J\u0006\u0010A\u001a\u000205J\b\u0010B\u001a\u00020\u001fH\u0016J\u0010\u0010C\u001a\u00020+2\u0006\u0010D\u001a\u00020EH\u0014J\b\u0010F\u001a\u00020+H\u0016J\u0010\u0010G\u001a\u00020+2\u0006\u0010H\u001a\u00020EH\u0016J\b\u0010I\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u00020J2\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010L\u001a\u00020J2\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u00020J2\u0006\u0010P\u001a\u00020QH\u0016J\b\u0010R\u001a\u00020+H\u0016J\u0010\u0010S\u001a\u00020J2\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010T\u001a\u00020J2\u0006\u0010P\u001a\u00020UH\u0016R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00101\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0019@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001b\"\u0004\b3\u0010\u001dR\u001a\u00104\u001a\u000205X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u00a8\u0006V"}, d2={"Lgloomyfolken/mods/physics/ragdolls/entity/EntityCorpseBag;", "Lgloomyfolken/mods/core/entity/EntityImmovableLiving;", "Lgloomyfolken/mods/physics/ragdolls/entity/CorpseInventoryProvider;", "Lcpw/mods/fml/common/registry/IEntityAdditionalSpawnData;", "Lgloomyfolken/mods/physics/ragdolls/entity/ILeftoversRenderInfo;", "Lgloomyfolken/mods/core/misc/IDisabledStateManager;", "owner", "Lgloomyfolken/mods/physics/ragdolls/entity/EntityRagdollCorpse;", "(Lgloomyfolken/mods/physics/ragdolls/entity/EntityRagdollCorpse;)V", "par1World", "Lnet/minecraft/world/World;", "(Lnet/minecraft/world/World;)V", "bagX", "", "getBagX", "()D", "setBagX", "(D)V", "bagY", "getBagY", "setBagY", "bagZ", "getBagZ", "setBagZ", "corpseEntityId", "", "getCorpseEntityId", "()I", "setCorpseEntityId", "(I)V", "corpseName", "", "getCorpseName", "()Ljava/lang/String;", "setCorpseName", "(Ljava/lang/String;)V", "inventory", "Lgloomyfolken/mods/physics/ragdolls/inventory/InventoryCorpse;", "getInventory", "()Lgloomyfolken/mods/physics/ragdolls/inventory/InventoryCorpse;", "setInventory", "(Lgloomyfolken/mods/physics/ragdolls/inventory/InventoryCorpse;)V", "looted", "", "getLooted", "()Z", "setLooted", "(Z)V", "<set-?>", "skinId", "getSkinId", "setSkinId", "timeDiedAt", "", "getTimeDiedAt", "()J", "setTimeDiedAt", "(J)V", "getCorpseInventory", "getEntityId", "getLeftoverRenderer", "Lgloomyfolken/mods/effects/client/mcsa/DynamicMcsaRenderer;", "render", "Lgloomyfolken/mods/physics/ragdolls/client/render/RenderCorpseLeftovers;", "entity", "getLifespanMillis", "getNameForCorpse", "interact", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "isServer", "isUsable", "par1EntityPlayer", "onUpdate", "", "openContainer", "readEntityFromNBT", "par1NBTTagCompound", "Lnet/minecraft/nbt/NBTTagCompound;", "readSpawnData", "data", "Lcom/google/common/io/ByteArrayDataInput;", "shouldUseLeftoversRenderer", "writeEntityToNBT", "writeSpawnData", "Lcom/google/common/io/ByteArrayDataOutput;", "minecraft"})
public class EntityCorpseBag
extends EntityImmovableLiving
implements IEntityAdditionalSpawnData,
ugqi,
CorpseInventoryProvider,
ILeftoversRenderInfo {
    private int corpseEntityId;
    private double bagX;
    private double bagY;
    private double bagZ;
    @NotNull
    private InventoryCorpse inventory;
    private long timeDiedAt;
    private boolean looted;
    @NotNull
    private String corpseName;
    private int skinId;

    public final int getCorpseEntityId() {
        return this.corpseEntityId;
    }

    public final void setCorpseEntityId(int n) {
        this.corpseEntityId = n;
    }

    public final double getBagX() {
        return this.bagX;
    }

    public final void setBagX(double d) {
        this.bagX = d;
    }

    public final double getBagY() {
        return this.bagY;
    }

    public final void setBagY(double d) {
        this.bagY = d;
    }

    public final double getBagZ() {
        return this.bagZ;
    }

    public final void setBagZ(double d) {
        this.bagZ = d;
    }

    @NotNull
    public final InventoryCorpse getInventory() {
        return this.inventory;
    }

    public final void setInventory(@NotNull InventoryCorpse inventoryCorpse) {
        Intrinsics.checkParameterIsNotNull(inventoryCorpse, "<set-?>");
        this.inventory = inventoryCorpse;
    }

    public final long getTimeDiedAt() {
        return this.timeDiedAt;
    }

    public final void setTimeDiedAt(long l) {
        this.timeDiedAt = l;
    }

    public final boolean getLooted() {
        return this.looted;
    }

    public final void setLooted(boolean bl) {
        this.looted = bl;
    }

    @NotNull
    public final String getCorpseName() {
        return this.corpseName;
    }

    public final void setCorpseName(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "<set-?>");
        this.corpseName = string;
    }

    public final int getSkinId() {
        return this.skinId;
    }

    private final void setSkinId(int n) {
        this.skinId = n;
    }

    @Override
    @NotNull
    public String getNameForCorpse() {
        return this.corpseName;
    }

    @Override
    public boolean isServer() {
        return !this.worldObj.isRemote;
    }

    @Override
    public int getEntityId() {
        return this.entityId;
    }

    @Override
    public boolean isUsable(@NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "par1EntityPlayer");
        double d = Math.hypot(this.posX - entityPlayer.posX, this.posZ - entityPlayer.posZ);
        return !this.isDead && d < RagdollsMod.LOOT_PICKUP_DISTANCE;
    }

    @Override
    @NotNull
    public InventoryCorpse getCorpseInventory() {
        return this.inventory;
    }

    @Override
    protected boolean interact(@NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
        if (this.worldObj.isRemote) {
            InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(this){
                final /* synthetic */ EntityCorpseBag this$0;

                public final void run() {
                    new PacketSearchCorpse(this.this$0.entityId).sendToServer();
                }
                {
                    this.this$0 = entityCorpseBag;
                }
            });
        }
        return true;
    }

    @Override
    public void openContainer(@NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
        if (!this.worldObj.isRemote) {
            ContainerCorpse containerCorpse = RagdollsMod.createCorpseContainer(this);
            InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(this, entityPlayer, containerCorpse){
                final /* synthetic */ EntityCorpseBag this$0;
                final /* synthetic */ EntityPlayer $player;
                final /* synthetic */ ContainerCorpse $container;

                public final void run() {
                }
                {
                    this.this$0 = entityCorpseBag;
                    this.$player = entityPlayer;
                    this.$container = containerCorpse;
                }
            });
        }
    }

    @Override
    public void readEntityFromNBT(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "par1NBTTagCompound");
        super.readEntityFromNBT(nBTTagCompound);
        this.timeDiedAt = nBTTagCompound._g("timeDiedAt");
        String string = nBTTagCompound._j("corpseName");
        Intrinsics.checkExpressionValueIsNotNull(string, "par1NBTTagCompound.getString(\"corpseName\")");
        this.corpseName = string;
    }

    @Override
    public void writeEntityToNBT(@NotNull NBTTagCompound nBTTagCompound) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "par1NBTTagCompound");
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("timeDiedAt", this.timeDiedAt);
        nBTTagCompound._a("corpseName", this.corpseName);
    }

    @Override
    public void writeSpawnData(@NotNull ByteArrayDataOutput byteArrayDataOutput) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataOutput, "data");
        byteArrayDataOutput.writeInt(this.corpseEntityId);
        byteArrayDataOutput.writeInt(this.skinId);
    }

    @Override
    public void readSpawnData(@NotNull ByteArrayDataInput byteArrayDataInput) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataInput, "data");
        this.corpseEntityId = byteArrayDataInput.readInt();
        this.skinId = byteArrayDataInput.readInt();
        Entity entity = this.worldObj.getEntityByID(this.corpseEntityId);
        if (entity instanceof EntityRagdollCorpse) {
            this.posX = entity.posX;
            this.posY = entity.posY;
            this.posZ = entity.posZ;
        }
        this.bagX = this.posX;
        this.bagY = this.posY;
        this.bagZ = this.posZ;
        this.setPosition(this.bagX, this.bagY, this.bagZ);
    }

    public final long getLifespanMillis() {
        return GloomyCore.getIntOption(this.inventory.isEmpty() ? "corpse_bag_empty_lifetime" : (this.looted ? "corpse_bag_looted_lifetime" : "corpse_bag_unlooted_lifetime"));
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.posX = this.bagX;
        this.posY = this.bagY;
        this.posZ = this.bagZ;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (!this.onGround) {
            this.fallDown();
        }
        this.bagX = this.posX;
        this.bagY = this.posY;
        this.bagZ = this.posZ;
        this.isAirBorne = false;
        if (!this.worldObj.isRemote && !this.isDead && System.currentTimeMillis() > this.timeDiedAt + this.getLifespanMillis() && this.inventory.getUsers() == 0) {
            this.setDead();
        }
    }

    @Override
    public boolean shouldUseLeftoversRenderer() {
        return true;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    @NotNull
    public kjui getLeftoverRenderer(@NotNull RenderCorpseLeftovers renderCorpseLeftovers, @NotNull ILeftoversRenderInfo iLeftoversRenderInfo) {
        Intrinsics.checkParameterIsNotNull(renderCorpseLeftovers, "render");
        Intrinsics.checkParameterIsNotNull(iLeftoversRenderInfo, "entity");
        kjui kjui2 = renderCorpseLeftovers.getBipedLeftoversRenderer()._a("corpse_bag_" + this.skinId % 9);
        Intrinsics.checkExpressionValueIsNotNull(kjui2, "render.bipedLeftoversRen\u2026orpse_bag_${skinId % 9}\")");
        return kjui2;
    }

    public EntityCorpseBag(@NotNull World world) {
        Intrinsics.checkParameterIsNotNull(world, "par1World");
        super(world);
        this.corpseEntityId = -1;
        this.inventory = new InventoryCorpse(this);
        this.corpseName = "";
        this.setSize(0.6f, 0.35f);
    }

    public EntityCorpseBag(@NotNull EntityRagdollCorpse entityRagdollCorpse) {
        Object[] objectArray;
        Intrinsics.checkParameterIsNotNull(entityRagdollCorpse, "owner");
        World world = entityRagdollCorpse.worldObj;
        Intrinsics.checkExpressionValueIsNotNull(world, "owner.worldObj");
        this(world);
        Object[] objectArray2 = objectArray = (Object[])entityRagdollCorpse.getInventory().getMainInventory();
        Collection collection = new ArrayList();
        Object[] objectArray3 = objectArray2;
        int n = 0;
        for (int i = 0; i < objectArray3.length; ++i) {
            Pair<Integer, ItemStack> pair;
            Object object = objectArray3[i];
            int n2 = n++;
            Object object2 = object;
            int n3 = n2;
            ItemStack itemStack = (ItemStack)object2;
            int n4 = n3;
            Pair<Integer, ItemStack> pair2 = itemStack == null ? null : TuplesKt.to(n4, itemStack);
            if (pair2 == null) continue;
            Pair<Integer, ItemStack> pair3 = pair = pair2;
            collection.add(pair3);
        }
        Map<Integer, ItemStack> map = MapsKt.toMap((List)collection);
        this.inventory = new InventoryCorpse(this, map);
        this.corpseEntityId = entityRagdollCorpse.entityId;
        this.bagX = entityRagdollCorpse.posX;
        this.bagY = entityRagdollCorpse.posY;
        this.bagZ = entityRagdollCorpse.posZ;
        this.bagX += (double)entityRagdollCorpse.rand.nextFloat() * 0.25;
        this.bagZ += (double)entityRagdollCorpse.rand.nextFloat() * 0.25;
        this.posX = this.bagX;
        this.posY = this.bagY;
        this.posZ = this.bagZ;
        this.setPosition(this.bagX, this.bagY, this.bagZ);
        this.corpseName = entityRagdollCorpse.getCorpseName();
        this.timeDiedAt = System.currentTimeMillis();
        this.rotationYaw = entityRagdollCorpse.getRNG().nextFloat() * 360.0f;
        this.skinId = entityRagdollCorpse.getRNG().nextInt();
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

