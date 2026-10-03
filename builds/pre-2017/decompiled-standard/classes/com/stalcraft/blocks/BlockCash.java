/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.blocks;

import com.stalcraft.blocks.StalcraftBlock;
import com.stalcraft.tile.TileEntityCash;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.sajh;
import net.minecraftforge.common.ForgeDirection;

public class BlockCash
extends iwgt
implements StalcraftBlock {
    private final Random random = new Random();
    public final int chestType;

    public BlockCash(int n, int n2) {
        super(n, tflj._f);
        this.chestType = n2;
        this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        String string = "stalcraft:inv";
        this.func_111022_d(string);
    }

    @Override
    public void func_71860_a(ozlu ozlu2, int n, int n2, int n3, EntityLivingBase entityLivingBase, cvzo cvzo2) {
        int n4 = sajh._c((double)(entityLivingBase.field_70177_z * 4.0f / 360.0f) + 2.5) & 3;
        ozlu2.func_72921_c(n, n2, n3, n4, 2);
    }

    @Override
    public int func_71857_b() {
        return -1;
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
    public hurg func_72274_a(ozlu ozlu2) {
        return new TileEntityCash();
    }

    public void unifyAdjacentChests(ozlu ozlu2, int n, int n2, int n3) {
        if (!ozlu2.field_72995_K) {
            int n4;
            int n5 = ozlu2.func_72798_a(n, n2, n3 - 1);
            int n6 = ozlu2.func_72798_a(n, n2, n3 + 1);
            int n7 = ozlu2.func_72798_a(n - 1, n2, n3);
            int n8 = ozlu2.func_72798_a(n + 1, n2, n3);
            boolean bl = true;
            if (n5 != this.field_71990_ca && n6 != this.field_71990_ca) {
                if (n7 != this.field_71990_ca && n8 != this.field_71990_ca) {
                    n4 = 3;
                    if (twgu.field_71970_n[n5] && !twgu.field_71970_n[n6]) {
                        n4 = 3;
                    }
                    if (twgu.field_71970_n[n6] && !twgu.field_71970_n[n5]) {
                        n4 = 2;
                    }
                    if (twgu.field_71970_n[n7] && !twgu.field_71970_n[n8]) {
                        n4 = 5;
                    }
                    if (twgu.field_71970_n[n8] && !twgu.field_71970_n[n7]) {
                        n4 = 4;
                    }
                } else {
                    int n9 = ozlu2.func_72798_a(n7 == this.field_71990_ca ? n - 1 : n + 1, n2, n3 - 1);
                    int n10 = ozlu2.func_72798_a(n7 == this.field_71990_ca ? n - 1 : n + 1, n2, n3 + 1);
                    n4 = 3;
                    boolean bl2 = true;
                    int n11 = n7 == this.field_71990_ca ? ozlu2.func_72805_g(n - 1, n2, n3) : ozlu2.func_72805_g(n + 1, n2, n3);
                    if (n11 == 2) {
                        n4 = 2;
                    }
                    if ((twgu.field_71970_n[n5] || twgu.field_71970_n[n9]) && !twgu.field_71970_n[n6] && !twgu.field_71970_n[n10]) {
                        n4 = 3;
                    }
                    if ((twgu.field_71970_n[n6] || twgu.field_71970_n[n10]) && !twgu.field_71970_n[n5] && !twgu.field_71970_n[n9]) {
                        n4 = 2;
                    }
                }
            } else {
                int n12 = ozlu2.func_72798_a(n - 1, n2, n5 == this.field_71990_ca ? n3 - 1 : n3 + 1);
                int n13 = ozlu2.func_72798_a(n + 1, n2, n5 == this.field_71990_ca ? n3 - 1 : n3 + 1);
                n4 = 5;
                boolean bl3 = true;
                int n14 = n5 == this.field_71990_ca ? ozlu2.func_72805_g(n, n2, n3 - 1) : ozlu2.func_72805_g(n, n2, n3 + 1);
                if (n14 == 4) {
                    n4 = 4;
                }
                if ((twgu.field_71970_n[n7] || twgu.field_71970_n[n12]) && !twgu.field_71970_n[n8] && !twgu.field_71970_n[n13]) {
                    n4 = 5;
                }
                if ((twgu.field_71970_n[n8] || twgu.field_71970_n[n13]) && !twgu.field_71970_n[n7] && !twgu.field_71970_n[n12]) {
                    n4 = 4;
                }
            }
            ozlu2.func_72921_c(n, n2, n3, n4, 3);
        }
    }

    private boolean isThereANeighborChest(ozlu ozlu2, int n, int n2, int n3) {
        return ozlu2.func_72798_a(n, n2, n3) != this.field_71990_ca ? false : (ozlu2.func_72798_a(n - 1, n2, n3) == this.field_71990_ca ? true : (ozlu2.func_72798_a(n + 1, n2, n3) == this.field_71990_ca ? true : (ozlu2.func_72798_a(n, n2, n3 - 1) == this.field_71990_ca ? true : ozlu2.func_72798_a(n, n2, n3 + 1) == this.field_71990_ca)));
    }

    @Override
    public void func_71863_a(ozlu ozlu2, int n, int n2, int n3, int n4) {
        super.func_71863_a(ozlu2, n, n2, n3, n4);
        TileEntityCash tileEntityCash = (TileEntityCash)ozlu2.func_72796_p(n, n2, n3);
        if (tileEntityCash != null) {
            tileEntityCash.func_70321_h();
        }
    }

    @Override
    public void func_71852_a(ozlu ozlu2, int n, int n2, int n3, int n4, int n5) {
        TileEntityCash tileEntityCash = (TileEntityCash)ozlu2.func_72796_p(n, n2, n3);
        if (tileEntityCash != null) {
            for (int i = 0; i < tileEntityCash.func_70302_i_(); ++i) {
                cvzo cvzo2 = tileEntityCash.func_70301_a(i);
                if (cvzo2 == null) continue;
                float f = this.random.nextFloat() * 0.8f + 0.1f;
                float f2 = this.random.nextFloat() * 0.8f + 0.1f;
                float f3 = this.random.nextFloat() * 0.8f + 0.1f;
                while (cvzo2._b > 0) {
                    int n6 = this.random.nextInt(21) + 10;
                    if (n6 > cvzo2._b) {
                        n6 = cvzo2._b;
                    }
                    cvzo2._b -= n6;
                    EntityItem entityItem = new EntityItem(ozlu2, (float)n + f, (float)n2 + f2, (float)n3 + f3, new cvzo(cvzo2._d, n6, cvzo2._j()));
                    float f4 = 0.05f;
                    entityItem.field_70159_w = (float)this.random.nextGaussian() * f4;
                    entityItem.field_70181_x = (float)this.random.nextGaussian() * f4 + 0.2f;
                    entityItem.field_70179_y = (float)this.random.nextGaussian() * f4;
                    if (cvzo2._p()) {
                        entityItem.func_92059_d()._d((qoac)cvzo2._q()._c());
                    }
                    ozlu2.func_72838_d(entityItem);
                }
            }
            ozlu2.func_96440_m(n, n2, n3, n4);
        }
        super.func_71852_a(ozlu2, n, n2, n3, n4, n5);
    }

    @Override
    public boolean func_71903_a(ozlu ozlu2, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (ozlu2.field_72995_K) {
            return true;
        }
        mssh mssh2 = this.getInventory(ozlu2, n, n2, n3);
        if (mssh2 != null) {
            entityPlayer.func_71007_a(mssh2);
        }
        return true;
    }

    public mssh getInventory(ozlu ozlu2, int n, int n2, int n3) {
        TileEntityCash tileEntityCash = (TileEntityCash)ozlu2.func_72796_p(n, n2, n3);
        if (tileEntityCash == null) {
            return null;
        }
        if (ozlu2.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN)) {
            return null;
        }
        if (BlockCash.isOcelotBlockingChest(ozlu2, n, n2, n3)) {
            return null;
        }
        if (ozlu2.func_72798_a(n - 1, n2, n3) == this.field_71990_ca && (ozlu2.isBlockSolidOnSide(n - 1, n2 + 1, n3, ForgeDirection.DOWN) || BlockCash.isOcelotBlockingChest(ozlu2, n - 1, n2, n3))) {
            return null;
        }
        if (ozlu2.func_72798_a(n + 1, n2, n3) == this.field_71990_ca && (ozlu2.isBlockSolidOnSide(n + 1, n2 + 1, n3, ForgeDirection.DOWN) || BlockCash.isOcelotBlockingChest(ozlu2, n + 1, n2, n3))) {
            return null;
        }
        if (ozlu2.func_72798_a(n, n2, n3 - 1) == this.field_71990_ca && (ozlu2.isBlockSolidOnSide(n, n2 + 1, n3 - 1, ForgeDirection.DOWN) || BlockCash.isOcelotBlockingChest(ozlu2, n, n2, n3 - 1))) {
            return null;
        }
        if (ozlu2.func_72798_a(n, n2, n3 + 1) == this.field_71990_ca && (ozlu2.isBlockSolidOnSide(n, n2 + 1, n3 + 1, ForgeDirection.DOWN) || BlockCash.isOcelotBlockingChest(ozlu2, n, n2, n3 + 1))) {
            return null;
        }
        return tileEntityCash;
    }

    @Override
    public boolean func_71853_i() {
        return this.chestType == 1;
    }

    @Override
    public int func_71865_a(sdrg sdrg2, int n, int n2, int n3, int n4) {
        if (!this.func_71853_i()) {
            return 0;
        }
        int n5 = ((TileEntityCash)sdrg2.func_72796_p((int)n, (int)n2, (int)n3)).numUsingPlayers;
        return sajh._a(n5, 0, 15);
    }

    @Override
    public int func_71855_c(sdrg sdrg2, int n, int n2, int n3, int n4) {
        return n4 == 1 ? this.func_71865_a(sdrg2, n, n2, n3, n4) : 0;
    }

    public static boolean isOcelotBlockingChest(ozlu ozlu2, int n, int n2, int n3) {
        EntityOcelot entityOcelot;
        EntityOcelot entityOcelot2;
        Iterator iterator2 = ozlu2.func_72872_a(EntityOcelot.class, eidj._a()._a(n, n2 + 1, n3, n + 1, n2 + 2, n3 + 1)).iterator();
        do {
            if (iterator2.hasNext()) continue;
            return false;
        } while (!(entityOcelot2 = (entityOcelot = (EntityOcelot)iterator2.next())).func_70906_o());
        return true;
    }

    @Override
    public boolean func_96468_q_() {
        return true;
    }

    @Override
    public int func_94328_b_(ozlu ozlu2, int n, int n2, int n3, int n4) {
        return jjgc.func_94526_b(this.getInventory(ozlu2, n, n2, n3));
    }
}

