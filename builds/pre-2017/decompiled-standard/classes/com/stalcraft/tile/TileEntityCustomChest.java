/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.tile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;

public class TileEntityCustomChest
extends hurg
implements mssh {
    private cvzo[] chestContents = new cvzo[27];
    public float lidAngle;
    public float prevLidAngle;
    public int numUsingPlayers;
    private int ticksSinceSync;
    private int cachedChestType;
    private String customName;

    public TileEntityCustomChest() {
        this.cachedChestType = -1;
    }

    @SideOnly(value=Side.CLIENT)
    public TileEntityCustomChest(int n) {
        this.cachedChestType = n;
    }

    @Override
    public int func_70302_i_() {
        return 27;
    }

    @Override
    public cvzo func_70301_a(int n) {
        return this.chestContents[n];
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        if (this.chestContents[n] != null) {
            if (this.chestContents[n]._b <= n2) {
                cvzo cvzo2 = this.chestContents[n];
                this.chestContents[n] = null;
                this.func_70296_d();
                return cvzo2;
            }
            cvzo cvzo3 = this.chestContents[n]._a(n2);
            if (this.chestContents[n]._b == 0) {
                this.chestContents[n] = null;
            }
            this.func_70296_d();
            return cvzo3;
        }
        return null;
    }

    @Override
    public cvzo func_70304_b(int n) {
        if (this.chestContents[n] != null) {
            cvzo cvzo2 = this.chestContents[n];
            this.chestContents[n] = null;
            return cvzo2;
        }
        return null;
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        this.chestContents[n] = cvzo2;
        if (cvzo2 != null && cvzo2._b > this.func_70297_j_()) {
            cvzo2._b = this.func_70297_j_();
        }
        this.func_70296_d();
    }

    @Override
    public String func_70303_b() {
        return this.func_94042_c() ? this.customName : "\u0413\u043e\u043b\u0443\u0431\u043e\u0439 \u0448\u043a\u0430\u0444";
    }

    @Override
    public boolean func_94042_c() {
        return this.customName != null && this.customName.length() > 0;
    }

    public void setChestGuiName(String string) {
        this.customName = string;
    }

    @Override
    public int func_70297_j_() {
        return 10000;
    }

    @Override
    public boolean func_70300_a(EntityPlayer entityPlayer) {
        return this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n) != this ? false : entityPlayer.func_70092_e((double)this.field_70329_l + 0.5, (double)this.field_70330_m + 0.5, (double)this.field_70327_n + 0.5) <= 64.0;
    }

    private boolean func_94044_a(int n, int n2, int n3) {
        twgu twgu2 = twgu.field_71973_m[this.field_70331_k.func_72798_a(n, n2, n3)];
        return twgu2 != null && twgu2 instanceof ydso ? ((ydso)twgu2)._b == this.getChestType() : false;
    }

    @Override
    public void func_70316_g() {
        float f;
        super.func_70316_g();
        ++this.ticksSinceSync;
        if (!this.field_70331_k.field_72995_K && this.numUsingPlayers != 0 && (this.ticksSinceSync + this.field_70329_l + this.field_70330_m + this.field_70327_n) % 200 == 0) {
            this.numUsingPlayers = 0;
            f = 5.0f;
            List list2 = this.field_70331_k.func_72872_a(EntityPlayer.class, eidj._a()._a((float)this.field_70329_l - f, (float)this.field_70330_m - f, (float)this.field_70327_n - f, (float)(this.field_70329_l + 1) + f, (float)(this.field_70330_m + 1) + f, (float)(this.field_70327_n + 1) + f));
            for (EntityPlayer entityPlayer : list2) {
                mssh mssh2;
                if (!(entityPlayer.field_71070_bA instanceof wpkx) || (mssh2 = ((wpkx)entityPlayer.field_71070_bA)._a()) != this && (!(mssh2 instanceof huew) || !((huew)mssh2)._a(this))) continue;
                ++this.numUsingPlayers;
            }
        }
        this.prevLidAngle = this.lidAngle;
        f = 0.1f;
        if (this.numUsingPlayers == 0 && this.lidAngle > 0.0f || this.numUsingPlayers > 0 && this.lidAngle < 1.0f) {
            float f2 = this.lidAngle;
            this.lidAngle = this.numUsingPlayers > 0 ? (this.lidAngle += f) : (this.lidAngle -= f);
            if (this.lidAngle > 1.0f) {
                this.lidAngle = 1.0f;
            }
            float f3 = 0.5f;
            if (this.lidAngle < 0.0f) {
                this.lidAngle = 0.0f;
            }
        }
    }

    @Override
    public boolean func_70315_b(int n, int n2) {
        if (n == 1) {
            this.numUsingPlayers = n2;
            return true;
        }
        return super.func_70315_b(n, n2);
    }

    @Override
    public void func_70295_k_() {
        if (this.numUsingPlayers < 0) {
            this.numUsingPlayers = 0;
        }
        ++this.numUsingPlayers;
        this.field_70331_k.func_72965_b(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.func_70311_o().field_71990_ca, 1, this.numUsingPlayers);
        this.field_70331_k.func_72898_h(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.func_70311_o().field_71990_ca);
        this.field_70331_k.func_72898_h(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n, this.func_70311_o().field_71990_ca);
    }

    @Override
    public void func_70305_f() {
        if (this.func_70311_o() != null && this.func_70311_o() instanceof ydso) {
            --this.numUsingPlayers;
            this.field_70331_k.func_72965_b(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.func_70311_o().field_71990_ca, 1, this.numUsingPlayers);
            this.field_70331_k.func_72898_h(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.func_70311_o().field_71990_ca);
            this.field_70331_k.func_72898_h(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n, this.func_70311_o().field_71990_ca);
        }
    }

    @Override
    public boolean func_94041_b(int n, cvzo cvzo2) {
        return true;
    }

    @Override
    public void func_70313_j() {
        super.func_70313_j();
        this.func_70321_h();
    }

    public int getChestType() {
        if (this.cachedChestType == -1) {
            if (this.field_70331_k == null || !(this.func_70311_o() instanceof ydso)) {
                return 0;
            }
            this.cachedChestType = ((ydso)this.func_70311_o())._b;
        }
        return this.cachedChestType;
    }
}

