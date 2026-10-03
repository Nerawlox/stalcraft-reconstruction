/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.eidj;
import noppes.npcs.CustomItems;
import noppes.npcs.controllers.RecipeCarpentry;
import noppes.npcs.controllers.RecipeController;

public class ContainerCarpentryBench
extends jjgc {
    public bsse craftMatrix = new bsse(this, 4, 4);
    public mssh craftResult = new wpoq();
    private EntityPlayer player;
    private ozlu worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public ContainerCarpentryBench(eidj eidj2, ozlu ozlu2, int n, int n2, int n3) {
        int n4;
        int n5;
        this.worldObj = ozlu2;
        this.posX = n;
        this.posY = n2;
        this.posZ = n3;
        this.player = eidj2._e;
        this.func_75146_a(new pkzb(eidj2._e, this.craftMatrix, this.craftResult, 0, 132, 35));
        for (n5 = 0; n5 < 4; ++n5) {
            for (n4 = 0; n4 < 4; ++n4) {
                this.func_75146_a(new yeso(this.craftMatrix, n4 + n5 * 4, 17 + n4 * 18, 8 + n5 * 18));
            }
        }
        for (n5 = 0; n5 < 3; ++n5) {
            for (n4 = 0; n4 < 9; ++n4) {
                this.func_75146_a(new yeso(eidj2, n4 + n5 * 9 + 9, 8 + n4 * 18, 84 + n5 * 18));
            }
        }
        for (n5 = 0; n5 < 9; ++n5) {
            this.func_75146_a(new yeso(eidj2, n5, 8 + n5 * 18, 142));
        }
        this.func_75130_a(this.craftMatrix);
    }

    @Override
    public void func_75130_a(mssh mssh2) {
        if (!this.worldObj.field_72995_K) {
            RecipeCarpentry recipeCarpentry = RecipeController.instance.findMatchingRecipe(this.craftMatrix);
            cvzo cvzo2 = null;
            if (recipeCarpentry != null && recipeCarpentry.availability.isAvailable(this.player)) {
                cvzo2 = recipeCarpentry.func_77572_b(this.craftMatrix);
            }
            this.craftResult.func_70299_a(0, cvzo2);
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)this.player;
            entityPlayerMP.field_71135_a.func_72567_b(new ixmv(this.field_75152_c, 0, cvzo2));
        }
    }

    @Override
    public void func_75134_a(EntityPlayer entityPlayer) {
        super.func_75134_a(entityPlayer);
        if (!this.worldObj.field_72995_K) {
            for (int i = 0; i < 16; ++i) {
                cvzo cvzo2 = this.craftMatrix.func_70304_b(i);
                if (cvzo2 == null) continue;
                entityPlayer.func_71021_b(cvzo2);
            }
        }
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return this.worldObj.func_72798_a(this.posX, this.posY, this.posZ) != CustomItems.carpentyBench.field_71990_ca ? false : entityPlayer.func_70092_e((double)this.posX + 0.5, (double)this.posY + 0.5, (double)this.posZ + 0.5) <= 64.0;
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        cvzo cvzo2 = null;
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null && yeso2.func_75216_d()) {
            cvzo cvzo3 = yeso2.func_75211_c();
            cvzo2 = cvzo3._l();
            if (n == 0) {
                if (!this.func_75135_a(cvzo3, 17, 53, true)) {
                    return null;
                }
                yeso2.func_75220_a(cvzo3, cvzo2);
            } else if (n >= 17 && n < 44 ? !this.func_75135_a(cvzo3, 44, 53, false) : (n >= 44 && n < 53 ? !this.func_75135_a(cvzo3, 17, 44, false) : !this.func_75135_a(cvzo3, 17, 53, false))) {
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
}

