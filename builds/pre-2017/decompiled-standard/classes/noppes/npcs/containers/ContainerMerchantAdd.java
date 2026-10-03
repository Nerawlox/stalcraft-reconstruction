/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.amww;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;

public class ContainerMerchantAdd
extends jjgc {
    private final ozlu theWorld;
    private amww theMerchant;
    private tgfo merchantInventory;

    public ContainerMerchantAdd(eidj eidj2, amww amww2, ozlu ozlu2) {
        int n;
        this.theMerchant = amww2;
        this.theWorld = ozlu2;
        this.merchantInventory = new tgfo("", false, 3);
        this.func_75146_a(new yeso(this.merchantInventory, 0, 36, 53));
        this.func_75146_a(new yeso(this.merchantInventory, 1, 62, 53));
        this.func_75146_a(new yeso(this.merchantInventory, 2, 120, 53));
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.func_75146_a(new yeso(eidj2, i + n * 9 + 9, 8 + i * 18, 84 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.func_75146_a(new yeso(eidj2, n, 8 + n * 18, 142));
        }
    }

    @Override
    public void func_75132_a(sdcd sdcd2) {
        super.func_75132_a(sdcd2);
    }

    @Override
    public void func_75142_b() {
        super.func_75142_b();
    }

    @Override
    public void func_75130_a(mssh mssh2) {
        super.func_75130_a(mssh2);
    }

    public void setCurrentRecipeIndex(int n) {
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_75137_b(int n, int n2) {
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        cvzo cvzo2 = null;
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null && yeso2.func_75216_d()) {
            cvzo cvzo3 = yeso2.func_75211_c();
            cvzo2 = cvzo3._l();
            if (n != 0 && n != 1 && n != 2 ? (n >= 3 && n < 30 ? !this.func_75135_a(cvzo3, 30, 39, false) : n >= 30 && n < 39 && !this.func_75135_a(cvzo3, 3, 30, false)) : !this.func_75135_a(cvzo3, 3, 39, false)) {
                return null;
            }
            if (cvzo3._b == 0) {
                yeso2.func_75215_d(null);
            } else {
                yeso2.func_75218_e();
            }
            if (cvzo3._b == cvzo2._b) {
                return null;
            }
            yeso2.func_82870_a(entityPlayer, cvzo3);
        }
        return cvzo2;
    }

    @Override
    public void func_75134_a(EntityPlayer entityPlayer) {
        super.func_75134_a(entityPlayer);
        this.theMerchant.func_70932_a_(null);
        super.func_75134_a(entityPlayer);
        if (!this.theWorld.field_72995_K) {
            cvzo cvzo2 = this.merchantInventory.func_70304_b(0);
            if (cvzo2 != null) {
                entityPlayer.func_71021_b(cvzo2);
            }
            if ((cvzo2 = this.merchantInventory.func_70304_b(1)) != null) {
                entityPlayer.func_71021_b(cvzo2);
            }
        }
    }
}

