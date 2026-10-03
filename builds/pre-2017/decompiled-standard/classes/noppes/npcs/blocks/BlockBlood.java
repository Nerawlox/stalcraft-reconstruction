/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.sajh;
import noppes.npcs.CustomItems;

public class BlockBlood
extends twgu {
    @SideOnly(value=Side.CLIENT)
    private dwan field_94458_cO;
    @SideOnly(value=Side.CLIENT)
    private dwan field_94459_cP;

    public BlockBlood(int n) {
        super(n, tflj._l);
        this.func_71875_q();
        this.func_71849_a(CustomItems.tabMisc);
        this.func_71905_a(0.01f, 0.01f, 0.01f, 0.99f, 0.99f, 0.99f);
        this.func_71900_a(0.08f);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public dwan func_71858_a(int n, int n2) {
        return n2 % 3 == 1 ? this.field_94459_cP : (n2 % 3 == 2 ? this.field_94458_cO : this.field_94336_cN);
    }

    @Override
    public eidj func_71872_e(ozlu ozlu2, int n, int n2, int n3) {
        return null;
    }

    @Override
    public eidj func_71911_a_(ozlu ozlu2, int n, int n2, int n3) {
        return eidj._a()._a(n, n2, n3, n, n2, n3);
    }

    @Override
    public boolean func_71886_c() {
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_94332_a(nege nege2) {
        this.field_94336_cN = nege2._b(this.func_111023_E());
        this.field_94459_cP = nege2._b(this.func_111023_E() + "2");
        this.field_94458_cO = nege2._b(this.func_111023_E() + "3");
    }

    @Override
    public boolean func_71877_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        twgu twgu2 = twgu.field_71973_m[sdrg2.func_72798_a(n, n2, n3)];
        return twgu2 != null && twgu2.func_71886_c();
    }

    @Override
    public boolean func_71926_d() {
        return false;
    }

    @Override
    public int func_71856_s_() {
        return 1;
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        int n4 = sajh._c((double)(entityLivingBase.field_70177_z / 90.0f) + 0.5) & 3;
        ozlu2.func_72921_c(n, n2, n3, n4, 2);
    }
}

