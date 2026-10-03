/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.ezfc;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J8\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u001eH$J*\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0016J\u001a\u0010%\u001a\u0004\u0018\u00010\b2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0017J\b\u0010'\u001a\u00020\u0005H\u0017J\b\u0010(\u001a\u00020\u0005H\u0016J(\u0010)\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0017J(\u0010*\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u000eH\u0016JP\u0010,\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000201H\u0016J8\u00104\u001a\u0002052\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0016J0\u0010:\u001a\u0002052\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0005H\u0017J(\u0010<\u001a\u0002052\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H%J\u0010\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020?H\u0016J0\u0010@\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010A\u001a\u00020.2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006B"}, d2={"Lgloomyfolken/mods/core/block/BlockSpawnerStalker;", "Lnet/minecraft/block/Block;", "Lnet/minecraft/block/ITileEntityProvider;", "Lgloomyfolken/mods/core/misc/IEditPermissions;", "id", "", "(I)V", "creativeIcon", "Lnet/minecraft/util/Icon;", "getCreativeIcon", "()Lnet/minecraft/util/Icon;", "setCreativeIcon", "(Lnet/minecraft/util/Icon;)V", "addBlockDestroyEffects", "", "world", "Lnet/minecraft/world/World;", "x", "y", "z", "meta", "effectRenderer", "Lnet/minecraft/client/particle/EffectRenderer;", "addBlockHitEffects", "worldObj", "target", "Lnet/minecraft/util/MovingObjectPosition;", "createNewTileEntity", "Lnet/minecraft/tileentity/TileEntity;", "createSpawnerTileEntity", "Lgloomyfolken/mods/core/spawn/TileEntityStalkerSpawner;", "getCollisionBoundingBoxFromPool", "Lnet/minecraft/util/AxisAlignedBB;", "par1World", "par2", "par3", "par4", "getIcon", "par1", "getRenderBlockPass", "getRenderType", "getSelectedBoundingBoxFromPool", "isAirBlock", "isOpaqueCube", "onBlockActivated", "par5EntityPlayer", "Lnet/minecraft/entity/player/EntityPlayer;", "par6", "par7", "", "par8", "par9", "onBlockPlacedBy", "", "par5EntityLivingBase", "Lnet/minecraft/entity/EntityLivingBase;", "par6ItemStack", "Lnet/minecraft/item/ItemStack;", "onBlockPreDestroy", "par5", "openEditGui", "quantityDropped", "par1Random", "Ljava/util/Random;", "removeBlockByPlayer", "player", "minecraft"})
public abstract class ieal
extends Block
implements ezfc,
stgn {
    @Nullable
    private Icon creativeIcon;

    @Nullable
    protected final Icon getCreativeIcon() {
        return this.creativeIcon;
    }

    protected final void setCreativeIcon(@Nullable Icon icon) {
        this.creativeIcon = icon;
    }

    @ezey(_a={eidj.CLIENT})
    protected abstract void openEditGui(@NotNull World var1, int var2, int var3, int var4);

    @NotNull
    protected abstract bqyt createSpawnerTileEntity();

    @Override
    @ezey(_a={eidj.CLIENT})
    @Nullable
    public Icon getIcon(int n, int n2) {
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        if (entityClientPlayerMP == null || !entityClientPlayerMP.capabilities._d) {
            return this.blockIcon;
        }
        return this.creativeIcon;
    }

    @Override
    public boolean onBlockActivated(final @NotNull World world, final int n, final int n2, final int n3, @NotNull EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(world, "par1World");
        Intrinsics.checkParameterIsNotNull(entityPlayer, "par5EntityPlayer");
        if (this.hasEditPermissions(entityPlayer) && world.isRemote) {
            InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(){

                @Override
                public final void run() {
                    this.openEditGui(world, n, n2, n3);
                }
            });
        }
        return true;
    }

    @Override
    public boolean removeBlockByPlayer(@NotNull World world, @NotNull EntityPlayer entityPlayer, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
        return this.hasEditPermissions(entityPlayer) && McExtensionsKt.isOpped(entityPlayer) && super.removeBlockByPlayer(world, entityPlayer, n, n2, n3);
    }

    @Override
    public boolean isAirBlock(@NotNull World world, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        return true;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    @Nullable
    public AxisAlignedBB getCollisionBoundingBoxFromPool(@NotNull World world, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(world, "par1World");
        return null;
    }

    @Override
    public boolean addBlockDestroyEffects(@NotNull World world, int n, int n2, int n3, int n4, @NotNull EffectRenderer effectRenderer) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        Intrinsics.checkParameterIsNotNull(effectRenderer, "effectRenderer");
        return true;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    @NotNull
    public AxisAlignedBB getSelectedBoundingBoxFromPool(@NotNull World world, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(world, "par1World");
        if (Minecraft._E()._t.capabilities._d) {
            AxisAlignedBB axisAlignedBB = super.getSelectedBoundingBoxFromPool(world, n, n2, n3);
            Intrinsics.checkExpressionValueIsNotNull(axisAlignedBB, "super.getSelectedBoundin\u20261World, par2, par3, par4)");
            return axisAlignedBB;
        }
        AxisAlignedBB axisAlignedBB = AxisAlignedBB._a(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        Intrinsics.checkExpressionValueIsNotNull(axisAlignedBB, "AxisAlignedBB.getBoundin\u2026 0.0, 0.0, 0.0, 0.0, 0.0)");
        return axisAlignedBB;
    }

    @Override
    public boolean addBlockHitEffects(@NotNull World world, @NotNull MovingObjectPosition movingObjectPosition, @NotNull EffectRenderer effectRenderer) {
        Intrinsics.checkParameterIsNotNull(world, "worldObj");
        Intrinsics.checkParameterIsNotNull(movingObjectPosition, "target");
        Intrinsics.checkParameterIsNotNull(effectRenderer, "effectRenderer");
        return true;
    }

    @Override
    public int quantityDropped(@NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(random, "par1Random");
        return 0;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public int getRenderType() {
        return GloomyCore.transparentsRenderType;
    }

    @Override
    public void onBlockPlacedBy(@NotNull World world, int n, int n2, int n3, @NotNull EntityLivingBase entityLivingBase, @NotNull ItemStack itemStack) {
        Intrinsics.checkParameterIsNotNull(world, "par1World");
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "par5EntityLivingBase");
        Intrinsics.checkParameterIsNotNull(itemStack, "par6ItemStack");
        TileEntity tileEntity = world.getBlockTileEntity(n, n2, n3);
        if (tileEntity instanceof bqyt && entityLivingBase instanceof EntityPlayerMP) {
            ((bqyt)tileEntity).placeTile(n, n2, n3);
        }
    }

    @Override
    @NotNull
    public TileEntity createNewTileEntity(@NotNull World world) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        return this.createSpawnerTileEntity();
    }

    public ieal(int n) {
        super(n, Material._a);
    }
}

