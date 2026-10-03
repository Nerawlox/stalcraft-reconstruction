/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.jxtc;
import gloomyfolken.mods.anomaly.qlgf;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J8\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\t\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lgloomyfolken/mods/anomaly/block/BlockTeleportShared;", "Lgloomyfolken/mods/anomaly/block/BlockTeleport;", "par1", "", "drop", "Lgloomyfolken/mods/anomaly/RandomList;", "id", "", "(ILgloomyfolken/mods/anomaly/RandomList;Ljava/lang/String;)V", "SCAN_HALFSIZE_X", "SCAN_HALFSIZE_Y", "SCAN_HALFSIZE_Z", "createNewTileEntity", "Lgloomyfolken/mods/anomaly/tile/TileEntityTeleport;", "world", "Lnet/minecraft/world/World;", "onBlockPlacedBy", "", "par1World", "par2", "par3", "par4", "par5EntityLivingBase", "Lnet/minecraft/entity/EntityLivingBase;", "par6ItemStack", "Lnet/minecraft/item/ItemStack;", "minecraft"})
public class bqkn
extends uybl {
    private final int _c = 1;
    private final int _d = 1;
    private final int _e = 1;

    @Override
    public void func_71860_a(@NotNull ozlu ozlu2, int n, int n2, int n3, @NotNull EntityLivingBase entityLivingBase, @NotNull cvzo cvzo2) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "par1World");
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "par5EntityLivingBase");
        Intrinsics.checkParameterIsNotNull(cvzo2, "par6ItemStack");
        hurg hurg2 = ozlu2.func_72796_p(n, n2, n3);
        if (!(hurg2 instanceof ctro)) {
            hurg2 = null;
        }
        ctro ctro2 = (ctro)hurg2;
        if (ctro2 == null) {
            return;
        }
        ctro ctro3 = ctro2;
        int n4 = -this._c;
        int n5 = this._c;
        if (n4 <= n5) {
            while (true) {
                int n6;
                int n7;
                if ((n7 = -this._d) <= (n6 = this._d)) {
                    while (true) {
                        int n8;
                        int n9;
                        if ((n9 = -this._e) <= (n8 = this._e)) {
                            while (true) {
                                ctro ctro4;
                                hurg hurg3;
                                if (!((hurg3 = ozlu2.func_72796_p(n + n4, n2 + n7, n3 + n9)) instanceof ctro)) {
                                    hurg3 = null;
                                }
                                if ((ctro4 = (ctro)hurg3) != null && Intrinsics.areEqual(ctro3, ctro4) ^ true) {
                                    ctro3._a(new jxtc(ctro4._i()));
                                    return;
                                }
                                if (n9 == n8) break;
                                ++n9;
                            }
                        }
                        if (n7 == n6) break;
                        ++n7;
                    }
                }
                if (n4 == n5) break;
                ++n4;
            }
        }
    }

    @Override
    @NotNull
    public jydd _a(@NotNull ozlu ozlu2) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "world");
        return new ctro();
    }

    @Override
    public /* synthetic */ hurg func_72274_a(ozlu ozlu2) {
        return this._a(ozlu2);
    }

    public bqkn(int n, @NotNull qlgf qlgf2, @NotNull String string) {
        Intrinsics.checkParameterIsNotNull(qlgf2, "drop");
        Intrinsics.checkParameterIsNotNull(string, "id");
        super(n, qlgf2, string);
        this._c = 1;
        this._d = 1;
        this._e = 1;
    }
}

