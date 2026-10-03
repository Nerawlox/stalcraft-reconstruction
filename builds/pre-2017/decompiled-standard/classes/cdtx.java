/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class cdtx
extends iwgt {
    public cdtx(int n) {
        super(n, tflj._s);
        this.func_71848_c(3.0f);
        this.func_71849_a(tgbl.field_78026_f);
    }

    @Override
    public hurg func_72274_a(ozlu ozlu2) {
        return new vmyb();
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (ozlu2.field_72995_K) {
            return true;
        }
        vmyb vmyb2 = (vmyb)ozlu2.func_72796_p(n, n2, n3);
        if (vmyb2 != null) {
            entityPlayer.func_82240_a(vmyb2);
        }
        return true;
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    public int func_71857_b() {
        return 34;
    }

    @Override
    public void func_94332_a(nege nege2) {
        super.func_94332_a(nege2);
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        super.func_71860_a(ozlu2, n, n2, n3, entityLivingBase, cvzo2);
        if (cvzo2._u()) {
            ((vmyb)ozlu2.func_72796_p(n, n2, n3))._a(cvzo2._s());
        }
    }
}

