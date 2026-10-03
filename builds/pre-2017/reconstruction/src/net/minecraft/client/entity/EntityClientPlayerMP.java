/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.entity;

import gloomyfolken.mods.anticheat.pidb;
import gloomyfolken.mods.weapon.xpzm;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.network.packet.Packet101CloseWindow;
import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.network.packet.Packet18Animation;
import net.minecraft.network.packet.Packet19EntityAction;
import net.minecraft.network.packet.Packet202PlayerAbilities;
import net.minecraft.network.packet.Packet205ClientCommand;
import net.minecraft.network.packet.Packet27PlayerInput;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.stats.StatBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.hanr;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityClientPlayerMP
extends EntityPlayerSP {
    public bscn sendQueue;
    public double oldPosX;
    public double oldMinY;
    public double oldPosY;
    public double oldPosZ;
    public float oldRotationYaw;
    public float oldRotationPitch;
    public boolean wasOnGround;
    public boolean shouldStopSneaking;
    public boolean wasSneaking;
    public int field_71168_co;
    public boolean hasSetHealth;
    public String field_142022_ce;

    public EntityClientPlayerMP(Minecraft minecraft, World world, hanr hanr2, bscn bscn2) {
        super(minecraft, world, hanr2, 0);
        this.sendQueue = bscn2;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        return false;
    }

    @Override
    public void heal(float f) {
    }

    @Override
    public void onUpdate() {
        if (!this.worldObj.blockExists(sajh._c(this.posX), 0, sajh._c(this.posZ))) {
            return;
        }
        super.onUpdate();
        if (this.isRiding()) {
            this.sendQueue._b(new ixmg(this.rotationYaw, this.rotationPitch, this.onGround));
            this.sendQueue._b(new Packet27PlayerInput(this.moveStrafing, this.moveForward, this.movementInput._c, this.movementInput._d));
        } else {
            this.sendMotionUpdates();
        }
    }

    public void sendMotionUpdates() {
        xpzm._a(this);
        pidb._a(this);
    }

    @Override
    public EntityItem dropOneItem(boolean bl) {
        int n = bl ? 3 : 4;
        this.sendQueue._b(new Packet14BlockDig(n, 0, 0, 0, 0));
        return null;
    }

    @Override
    public void joinEntityItemWithWorld(EntityItem entityItem) {
    }

    public void sendChatMessage(String string) {
        this.sendQueue._b(new Packet3Chat(string));
    }

    @Override
    public void swingItem() {
        super.swingItem();
        this.sendQueue._b(new Packet18Animation(this, 1));
    }

    @Override
    public void respawnPlayer() {
        this.sendQueue._b(new Packet205ClientCommand(1));
    }

    @Override
    public void damageEntity(DamageSource damageSource, float f) {
        if (this.isEntityInvulnerable()) {
            return;
        }
        this.setHealth(this.getHealth() - f);
    }

    @Override
    public void closeScreen() {
        this.sendQueue._b(new Packet101CloseWindow(this.openContainer.windowId));
        this.func_92015_f();
    }

    public void func_92015_f() {
        this.inventory._d(null);
        super.closeScreen();
    }

    @Override
    public void setPlayerSPHealth(float f) {
        if (this.hasSetHealth) {
            super.setPlayerSPHealth(f);
        } else {
            this.setHealth(f);
            this.hasSetHealth = true;
        }
    }

    @Override
    public void addStat(StatBase statBase, int n) {
        if (statBase == null) {
            return;
        }
        if (statBase.isIndependent) {
            super.addStat(statBase, n);
        }
    }

    public void incrementStat(StatBase statBase, int n) {
        if (statBase == null) {
            return;
        }
        if (!statBase.isIndependent) {
            super.addStat(statBase, n);
        }
    }

    @Override
    public void sendPlayerAbilities() {
        this.sendQueue._b(new Packet202PlayerAbilities(this.capabilities));
    }

    @Override
    public void func_110318_g() {
        this.sendQueue._b(new Packet19EntityAction(this, 6, (int)(this.getHorseJumpPower() * 100.0f)));
    }

    public void func_110322_i() {
        this.sendQueue._b(new Packet19EntityAction(this, 7));
    }

    public void func_142020_c(String string) {
        this.field_142022_ce = string;
    }

    public String func_142021_k() {
        return this.field_142022_ce;
    }
}

