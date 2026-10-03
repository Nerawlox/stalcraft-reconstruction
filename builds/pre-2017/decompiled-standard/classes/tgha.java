/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class tgha
extends tgdv {
    public final int field_77855_a = 32;
    public final int field_77853_b;
    public final float field_77854_c;
    public final boolean field_77856_bY;
    public boolean field_77852_bZ;
    public int field_77851_ca;
    public int field_77850_cb;
    public int field_77857_cc;
    public float field_77858_cd;

    public tgha(int n, int n2, float f, boolean bl) {
        super(n);
        this.field_77853_b = n2;
        this.field_77856_bY = bl;
        this.field_77854_c = f;
        this.func_77637_a(tgbl.field_78039_h);
    }

    public tgha(int n, int n2, boolean bl) {
        this(n, n2, 0.6f, bl);
    }

    @Override
    public cvzo func_77654_b(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        --cvzo2._b;
        entityPlayer.func_71024_bL()._a(this);
        ozlu2.func_72956_a(entityPlayer, "random.burp", 0.5f, ozlu2.field_73012_v.nextFloat() * 0.1f + 0.9f);
        this.func_77849_c(cvzo2, ozlu2, entityPlayer);
        return cvzo2;
    }

    public void func_77849_c(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        if (!ozlu2.field_72995_K && this.field_77851_ca > 0 && ozlu2.field_73012_v.nextFloat() < this.field_77858_cd) {
            entityPlayer.func_70690_d(new supr(this.field_77851_ca, this.field_77850_cb * 20, this.field_77857_cc));
        }
    }

    @Override
    public int func_77626_a(cvzo cvzo2) {
        return 32;
    }

    @Override
    public bsre func_77661_b(cvzo cvzo2) {
        return bsre._b;
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        if (entityPlayer.func_71043_e(this.field_77852_bZ)) {
            entityPlayer.func_71008_a(cvzo2, this.func_77626_a(cvzo2));
        }
        return cvzo2;
    }

    public int func_77847_f() {
        return this.field_77853_b;
    }

    public float func_77846_g() {
        return this.field_77854_c;
    }

    public boolean func_77845_h() {
        return this.field_77856_bY;
    }

    public tgha func_77844_a(int n, int n2, int n3, float f) {
        this.field_77851_ca = n;
        this.field_77850_cb = n2;
        this.field_77857_cc = n3;
        this.field_77858_cd = f;
        return this;
    }

    public tgha func_77848_i() {
        this.field_77852_bZ = true;
        return this;
    }
}

