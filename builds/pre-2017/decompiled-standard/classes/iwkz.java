/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.dwan;

public class iwkz
extends twgu {
    public dwan _a;
    public dwan _b;

    public iwkz(int n) {
        super(n, tflj._u);
        this.func_71849_a(tgbl.field_78028_d);
    }

    @Override
    public dwan func_71858_a(int n, int n2) {
        if (n == 0) {
            return this._b;
        }
        if (n == 1) {
            return this._a;
        }
        return this.field_94336_cN;
    }

    @Override
    public void func_71861_g(ozlu ozlu2, int n, int n2, int n3) {
        super.func_71861_g(ozlu2, n, n2, n3);
        if (ozlu2.func_72864_z(n, n2, n3)) {
            this.func_71898_d(ozlu2, n, n2, n3, 1);
            ozlu2.func_94571_i(n, n2, n3);
        }
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        if (ozlu2.func_72864_z(n, n2, n3)) {
            this.func_71898_d(ozlu2, n, n2, n3, 1);
            ozlu2.func_94571_i(n, n2, n3);
        }
    }

    @Override
    public int func_71925_a(Random random) {
        return 1;
    }

    @Override
    public void func_71867_k(ozlu ozlu2, int n, int n2, int n3, elkd elkd2) {
        if (ozlu2.field_72995_K) {
            return;
        }
        EntityTNTPrimed entityTNTPrimed = new EntityTNTPrimed(ozlu2, (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, elkd2._c());
        entityTNTPrimed.field_70516_a = ozlu2.field_73012_v.nextInt(entityTNTPrimed.field_70516_a / 4) + entityTNTPrimed.field_70516_a / 8;
        ozlu2.func_72838_d(entityTNTPrimed);
    }

    @Override
    public void func_71898_d(ozlu ozlu2, int n, int n2, int n3, int n4) {
        this._a(ozlu2, n, n2, n3, n4, null);
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4, EntityLivingBase entityLivingBase) {
        if (ozlu2.field_72995_K) {
            return;
        }
        if ((n4 & 1) == 1) {
            EntityTNTPrimed entityTNTPrimed = new EntityTNTPrimed(ozlu2, (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, entityLivingBase);
            ozlu2.func_72838_d(entityTNTPrimed);
            ozlu2.func_72956_a(entityTNTPrimed, "random.fuse", 1.0f, 1.0f);
        }
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (entityPlayer.func_71045_bC() != null && entityPlayer.func_71045_bC()._d == tgdv.field_77709_i.field_77779_bT) {
            this._a(ozlu2, n, n2, n3, 1, entityPlayer);
            ozlu2.func_94571_i(n, n2, n3);
            entityPlayer.func_71045_bC()._a(1, (EntityLivingBase)entityPlayer);
            return true;
        }
        return super.func_71903_a(ozlu2, n, n2, n3, entityPlayer, n4, f, f2, f3);
    }

    @Override
    public void func_71869_a(ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        EntityArrow entityArrow;
        if (entity instanceof EntityArrow && !ozlu2.field_72995_K && (entityArrow = (EntityArrow)entity).func_70027_ad()) {
            this._a(ozlu2, n, n2, n3, 1, entityArrow.field_70250_c instanceof EntityLivingBase ? (EntityLivingBase)entityArrow.field_70250_c : null);
            ozlu2.func_94571_i(n, n2, n3);
        }
    }

    @Override
    public boolean func_85103_a(elkd elkd2) {
        return false;
    }

    @Override
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b(this.func_111023_E() + "_side");
        this._a = nege2._b(this.func_111023_E() + "_top");
        this._b = nege2._b(this.func_111023_E() + "_bottom");
    }
}

