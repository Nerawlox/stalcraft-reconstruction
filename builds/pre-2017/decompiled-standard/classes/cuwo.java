/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.stalker.misc.qlgf;
import net.minecraft.entity.Entity;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterLeaves;
import poersch.minecraft.bettergrassandleaves.renderer.BetterLeavesRenderer;

public class cuwo
extends twgu
implements IBetterLeaves {
    public boolean _f;

    public cuwo(int n, tflj tflj2, boolean bl) {
        super(n, tflj2);
        this._f = bl;
        BetterGrassAndLeavesMod.info("Initiated block: " + this.getClass().getName());
        BetterLeavesRenderer.leafBlocks.add(this);
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        int n5 = sdrg2.func_72798_a(n, n2, n3);
        return !this._f && n5 == this.field_71990_ca ? false : super.func_71877_c(sdrg2, n, n2, n3, n4);
    }

    @Override
    public dwan getIconBetterLeaves(int n, float f) {
        return null;
    }

    @Override
    public dwan getIconBetterLeavesSnowed(int n, float f) {
        if (BetterLeavesRenderer.iconBetterLeavesSnowed == null || this != twgu.field_71952_K) {
            return null;
        }
        return BetterLeavesRenderer.iconBetterLeavesSnowed[(int)(f * (float)(BetterLeavesRenderer.iconBetterLeavesSnowed.length - 1) + 0.5f)];
    }

    @Override
    public dwan getIconFallingLeaves(int n) {
        return this.func_71858_a(0, n);
    }

    @Override
    public float getSpawnChanceFallingLeaves(int n) {
        return 0.008f;
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public void func_71869_a(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        qlgf._b(entity);
    }
}

