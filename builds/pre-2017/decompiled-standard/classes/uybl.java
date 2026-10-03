/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.anomaly.qlgf;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.ezfc;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&JP\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J0\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0017J0\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 H\u0016J(\u0010!\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0005J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0016\u00a8\u0006%"}, d2={"Lgloomyfolken/mods/anomaly/block/BlockTeleport;", "Lgloomyfolken/mods/anomaly/block/BlockAnomaly;", "Lgloomyfolken/mods/core/misc/IEditPermissions;", "par1", "", "drop", "Lgloomyfolken/mods/anomaly/RandomList;", "id", "", "(ILgloomyfolken/mods/anomaly/RandomList;Ljava/lang/String;)V", "createNewTileEntity", "Lgloomyfolken/mods/anomaly/tile/TileEntityTeleport;", "world", "Lnet/minecraft/world/World;", "onBlockActivated", "", "par1World", "par2", "par3", "par4", "par5EntityPlayer", "Lnet/minecraft/entity/player/EntityPlayer;", "par6", "par7", "", "par8", "par9", "onBlockPreDestroy", "", "par5", "onEntityCollidedWithBlock", "par5Entity", "Lnet/minecraft/entity/Entity;", "openEditGui", "registerIcons", "par1IconRegister", "Lnet/minecraft/client/renderer/texture/IconRegister;", "minecraft"})
public abstract class uybl
extends kkdx
implements ezfc {
    @ezey(_a={eidj.CLIENT})
    protected final void _a(@NotNull ozlu ozlu2, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "par1World");
        xpzm._E()._a(new hayt(ozlu2, n, n2, n3));
    }

    @Override
    public void func_94332_a(@NotNull nege nege2) {
        Intrinsics.checkParameterIsNotNull(nege2, "par1IconRegister");
        this.field_94336_cN = nege2._b("stalker:transparent");
        this._b = nege2._b("anomalies:portal");
    }

    @Override
    public boolean func_71903_a(final @NotNull ozlu ozlu2, final int n, final int n2, final int n3, @NotNull EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "par1World");
        Intrinsics.checkParameterIsNotNull(entityPlayer, "par5EntityPlayer");
        if (this.hasEditPermissions(entityPlayer) && ozlu2.field_72995_K) {
            InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(){

                @Override
                public final void run() {
                    this._a(ozlu2, n, n2, n3);
                }
            });
        }
        return true;
    }

    @Override
    public void func_71869_a(@NotNull ozlu ozlu2, int n, int n2, int n3, @NotNull Entity entity) {
        block2: {
            Intrinsics.checkParameterIsNotNull(ozlu2, "par1World");
            Intrinsics.checkParameterIsNotNull(entity, "par5Entity");
            hurg hurg2 = ozlu2.func_72796_p(n, n2, n3);
            if (!(hurg2 instanceof jydd)) {
                hurg2 = null;
            }
            jydd jydd2 = (jydd)hurg2;
            if (!(entity instanceof EntityLivingBase)) break block2;
            jydd jydd3 = jydd2;
            if (jydd3 != null) {
                jydd3._b((EntityLivingBase)entity);
            }
        }
    }

    @NotNull
    public abstract jydd _a(@NotNull ozlu var1);

    public uybl(int n, @NotNull qlgf qlgf2, @NotNull String string) {
        Intrinsics.checkParameterIsNotNull(qlgf2, "drop");
        Intrinsics.checkParameterIsNotNull(string, "id");
        super(n, GloomyCore.fakeAir, qlgf2, "", 0.0f);
        this.func_71864_b(string);
    }
}

