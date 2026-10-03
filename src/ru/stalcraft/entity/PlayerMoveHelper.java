/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.entity;

import ru.stalcraft.client.player.PlayerClientInfo;
import ru.stalcraft.player.PlayerUtils;

public class PlayerMoveHelper {
    private uf entity;
    private PlayerClientInfo info;
    private double posX;
    private double posY;
    private double posZ;
    private double speed;
    private boolean update;

    public PlayerMoveHelper(uf player) {
        this.entity = player;
        this.info = (PlayerClientInfo)PlayerUtils.getInfo(player);
        this.posX = player.u;
        this.posY = player.v;
        this.posZ = player.w;
    }

    public boolean isUpdating() {
        return this.update;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setMoveTo(double par1, double par3, double par5, double par7) {
        this.posX = par1;
        this.posY = par3;
        this.posZ = par5;
        this.speed = par7;
        this.update = true;
    }

    public void onUpdateMoveHelper() {
        this.entity.bf = 0.0f;
        if (this.update) {
            double d1;
            this.update = false;
            double d0 = this.posX - this.entity.u;
            int i2 = ls.c(this.entity.E.b + 0.5);
            double d2 = this.posY - (double)i2;
            double d3 = d0 * d0 + d2 * d2 + (d1 = this.posZ - this.entity.w) * d1;
            if (d3 >= 2.500000277905201E-7) {
                float f2 = (float)(Math.atan2(d1, d0) * 180.0 / Math.PI) - 90.0f;
                float prevYaw = this.entity.A;
                this.entity.A = this.limitAngle(this.entity.A, f2, 30.0f);
                this.entity.C += this.entity.A - prevYaw;
                this.info.shouldMove = true;
                if (d2 > 0.0 && d0 * d0 + d1 * d1 < 1.0) {
                    this.info.jumpHelper.setJumping();
                }
            }
        }
        if (this.entity.H() || this.entity.J()) {
            this.info.jumpHelper.setJumping();
        }
    }

    private float limitAngle(float par1, float par2, float par3) {
        float f3 = ls.g(par2 - par1);
        if (f3 > par3) {
            f3 = par3;
        }
        if (f3 < -par3) {
            f3 = -par3;
        }
        return par1 + f3;
    }
}

