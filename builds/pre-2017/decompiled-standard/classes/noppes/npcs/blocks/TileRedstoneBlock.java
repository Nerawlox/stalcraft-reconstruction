/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.blocks;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import noppes.npcs.CustomNpcs;
import noppes.npcs.blocks.BlockNpcRedstone;
import noppes.npcs.controllers.Availability;

public class TileRedstoneBlock
extends hurg {
    public int onRangeX = 6;
    public int onRangeY = 6;
    public int onRangeZ = 6;
    public int offRangeX = 10;
    public int offRangeY = 10;
    public int offRangeZ = 10;
    public Availability availability = new Availability();
    public boolean isActivated = false;
    private int ticks = 10;

    @Override
    public void func_70316_g() {
        if (!this.field_70331_k.field_72995_K) {
            --this.ticks;
            if (this.ticks <= 0) {
                this.ticks = 20;
                twgu twgu2 = twgu.field_71973_m[this.field_70331_k.func_72798_a(this.field_70329_l, this.field_70330_m, this.field_70327_n)];
                if (twgu2 != null && twgu2 instanceof BlockNpcRedstone) {
                    if (CustomNpcs.FreezeNPCs) {
                        if (this.isActivated) {
                            this.setActive(twgu2, false);
                        }
                    } else if (!this.isActivated) {
                        List list2 = this.getPlayerList(this.onRangeX, this.onRangeY, this.onRangeZ);
                        if (list2.isEmpty()) {
                            return;
                        }
                        for (EntityPlayer entityPlayer : list2) {
                            if (!this.availability.isAvailable(entityPlayer)) continue;
                            this.setActive(twgu2, true);
                            return;
                        }
                    } else {
                        List list3 = this.getPlayerList(this.offRangeX, this.offRangeY, this.offRangeZ);
                        for (EntityPlayer entityPlayer : list3) {
                            if (!this.availability.isAvailable(entityPlayer)) continue;
                            return;
                        }
                        this.setActive(twgu2, false);
                    }
                } else {
                    this.field_70331_k.func_72932_q(this.field_70329_l, this.field_70330_m, this.field_70327_n);
                }
            }
        }
    }

    private void setActive(twgu twgu2, boolean bl) {
        this.isActivated = bl;
        this.field_70331_k.func_72921_c(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.isActivated ? 1 : 0, 2);
        this.field_70331_k.func_72845_h(this.field_70329_l, this.field_70330_m, this.field_70327_n);
        if (this.func_70309_m()) {
            twgu2.func_71861_g(this.field_70331_k, this.field_70329_l, this.field_70330_m, this.field_70327_n);
        }
    }

    private List getPlayerList(int n, int n2, int n3) {
        return this.field_70331_k.func_72872_a(EntityPlayer.class, eidj._a(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.field_70329_l + 1, this.field_70330_m + 1, this.field_70327_n + 1)._b(n, n2, n3));
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        this.onRangeX = qoac2._f("BlockOnRangeX");
        this.onRangeY = qoac2._f("BlockOnRangeY");
        this.onRangeZ = qoac2._f("BlockOnRangeZ");
        this.offRangeX = qoac2._f("BlockOffRangeX");
        this.offRangeY = qoac2._f("BlockOffRangeY");
        this.offRangeZ = qoac2._f("BlockOffRangeZ");
        this.isActivated = qoac2._o("BlockActivated");
        this.availability.readFromNBT(qoac2);
        if (this.func_70309_m()) {
            this.setActive(this.func_70311_o(), this.isActivated);
        }
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        qoac2._a("BlockOnRangeX", this.onRangeX);
        qoac2._a("BlockOnRangeY", this.onRangeY);
        qoac2._a("BlockOnRangeZ", this.onRangeZ);
        qoac2._a("BlockOffRangeX", this.offRangeX);
        qoac2._a("BlockOffRangeY", this.offRangeY);
        qoac2._a("BlockOffRangeZ", this.offRangeZ);
        qoac2._a("BlockActivated", this.isActivated);
        this.availability.writeToNBT(qoac2);
    }
}

