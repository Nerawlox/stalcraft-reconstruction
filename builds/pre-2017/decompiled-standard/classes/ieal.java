/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.ezfc;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.particle.kjui;
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J8\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u001eH$J*\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0016J\u001a\u0010%\u001a\u0004\u0018\u00010\b2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0017J\b\u0010'\u001a\u00020\u0005H\u0017J\b\u0010(\u001a\u00020\u0005H\u0016J(\u0010)\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0017J(\u0010*\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u000eH\u0016JP\u0010,\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000201H\u0016J8\u00104\u001a\u0002052\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0016J0\u0010:\u001a\u0002052\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0005H\u0017J(\u0010<\u001a\u0002052\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H%J\u0010\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020?H\u0016J0\u0010@\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010A\u001a\u00020.2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006B"}, d2={"Lgloomyfolken/mods/core/block/BlockSpawnerStalker;", "Lnet/minecraft/block/Block;", "Lnet/minecraft/block/ITileEntityProvider;", "Lgloomyfolken/mods/core/misc/IEditPermissions;", "id", "", "(I)V", "creativeIcon", "Lnet/minecraft/util/Icon;", "getCreativeIcon", "()Lnet/minecraft/util/Icon;", "setCreativeIcon", "(Lnet/minecraft/util/Icon;)V", "addBlockDestroyEffects", "", "world", "Lnet/minecraft/world/World;", "x", "y", "z", "meta", "effectRenderer", "Lnet/minecraft/client/particle/EffectRenderer;", "addBlockHitEffects", "worldObj", "target", "Lnet/minecraft/util/MovingObjectPosition;", "createNewTileEntity", "Lnet/minecraft/tileentity/TileEntity;", "createSpawnerTileEntity", "Lgloomyfolken/mods/core/spawn/TileEntityStalkerSpawner;", "getCollisionBoundingBoxFromPool", "Lnet/minecraft/util/AxisAlignedBB;", "par1World", "par2", "par3", "par4", "getIcon", "par1", "getRenderBlockPass", "getRenderType", "getSelectedBoundingBoxFromPool", "isAirBlock", "isOpaqueCube", "onBlockActivated", "par5EntityPlayer", "Lnet/minecraft/entity/player/EntityPlayer;", "par6", "par7", "", "par8", "par9", "onBlockPlacedBy", "", "par5EntityLivingBase", "Lnet/minecraft/entity/EntityLivingBase;", "par6ItemStack", "Lnet/minecraft/item/ItemStack;", "onBlockPreDestroy", "par5", "openEditGui", "quantityDropped", "par1Random", "Ljava/util/Random;", "removeBlockByPlayer", "player", "minecraft"})
public abstract class ieal
extends twgu
implements ezfc,
stgn {
    @Nullable
    private dwan creativeIcon;

    @Nullable
    protected final dwan getCreativeIcon() {
        return this.creativeIcon;
    }

    protected final void setCreativeIcon(@Nullable dwan dwan2) {
        this.creativeIcon = dwan2;
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    protected abstract void openEditGui(@NotNull ozlu var1, int var2, int var3, int var4);

    @NotNull
    protected abstract bqyt createSpawnerTileEntity();

    @Override
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    @Nullable
    public dwan func_71858_a(int n, int n2) {
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        if (entityClientPlayerMP == null || !entityClientPlayerMP.field_71075_bZ._d) {
            return this.field_94336_cN;
        }
        return this.creativeIcon;
    }

    @Override
    public boolean func_71903_a(final @NotNull ozlu ozlu2, final int n, final int n2, final int n3, @NotNull EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "par1World");
        Intrinsics.checkParameterIsNotNull(entityPlayer, "par5EntityPlayer");
        if (this.hasEditPermissions(entityPlayer) && ozlu2.field_72995_K) {
            InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(){

                @Override
                public final void run() {
                    this.openEditGui(ozlu2, n, n2, n3);
                }
            });
        }
        return true;
    }

    @Override
    public boolean removeBlockByPlayer(@NotNull ozlu ozlu2, @NotNull EntityPlayer entityPlayer, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "world");
        Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
        return this.hasEditPermissions(entityPlayer) && McExtensionsKt.isOpped(entityPlayer) && super.removeBlockByPlayer(ozlu2, entityPlayer, n, n2, n3);
    }

    @Override
    public boolean isAirBlock(@NotNull ozlu ozlu2, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "world");
        return true;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    @Nullable
    public eidj func_71872_e(@NotNull ozlu ozlu2, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "par1World");
        return null;
    }

    @Override
    public boolean addBlockDestroyEffects(@NotNull ozlu ozlu2, int n, int n2, int n3, int n4, @NotNull kjui kjui2) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "world");
        Intrinsics.checkParameterIsNotNull(kjui2, "effectRenderer");
        return true;
    }

    @Override
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    @NotNull
    public eidj func_71911_a_(@NotNull ozlu ozlu2, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "par1World");
        if (xpzm._E()._t.field_71075_bZ._d) {
            eidj eidj2 = super.func_71911_a_(ozlu2, n, n2, n3);
            Intrinsics.checkExpressionValueIsNotNull(eidj2, "super.getSelectedBoundin\u20261World, par2, par3, par4)");
            return eidj2;
        }
        eidj eidj3 = eidj._a(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        Intrinsics.checkExpressionValueIsNotNull(eidj3, "AxisAlignedBB.getBoundin\u2026 0.0, 0.0, 0.0, 0.0, 0.0)");
        return eidj3;
    }

    @Override
    public boolean addBlockHitEffects(@NotNull ozlu ozlu2, @NotNull hank hank2, @NotNull kjui kjui2) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "worldObj");
        Intrinsics.checkParameterIsNotNull(hank2, "target");
        Intrinsics.checkParameterIsNotNull(kjui2, "effectRenderer");
        return true;
    }

    @Override
    public int func_71925_a(@NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(random, "par1Random");
        return 0;
    }

    @Override
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public int func_71856_s_() {
        return 1;
    }

    @Override
    public int func_71857_b() {
        return GloomyCore.transparentsRenderType;
    }

    @Override
    public void func_71860_a(@NotNull ozlu ozlu2, int n, int n2, int n3, @NotNull EntityLivingBase entityLivingBase, @NotNull cvzo cvzo2) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "par1World");
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "par5EntityLivingBase");
        Intrinsics.checkParameterIsNotNull(cvzo2, "par6ItemStack");
        hurg hurg2 = ozlu2.func_72796_p(n, n2, n3);
        if (hurg2 instanceof bqyt && entityLivingBase instanceof EntityPlayerMP) {
            ((bqyt)hurg2).placeTile(n, n2, n3);
        }
    }

    @Override
    @NotNull
    public hurg func_72274_a(@NotNull ozlu ozlu2) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "world");
        return this.createSpawnerTileEntity();
    }

    public ieal(int n) {
        super(n, tflj._a);
    }
}

