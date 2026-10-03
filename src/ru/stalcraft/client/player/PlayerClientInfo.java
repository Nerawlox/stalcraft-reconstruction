/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cl
 */
package ru.stalcraft.client.player;

import ru.stalcraft.clans.IClan;
import ru.stalcraft.client.ClientContamination;
import ru.stalcraft.client.ClientWeaponInfo;
import ru.stalcraft.entity.PlayerJumpHelper;
import ru.stalcraft.entity.PlayerMoveHelper;
import ru.stalcraft.entity.PlayerPathNavigator;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;

public class PlayerClientInfo
extends PlayerInfo {
    private int forceCooldown = -1;
    public boolean hasQuitted;
    public PlayerMoveHelper moveHelper;
    public PlayerJumpHelper jumpHelper;
    public PlayerPathNavigator navigator;
    public boolean shouldMove;
    public boolean shouldJump;

    public PlayerClientInfo(uf par1) {
        super(par1, new ClientWeaponInfo(par1), new ClientContamination(par1));
        this.navigator = new PlayerPathNavigator(par1, par1.q);
        this.moveHelper = new PlayerMoveHelper(par1);
        this.jumpHelper = new PlayerJumpHelper(par1);
        this.player.v().a(20, Float.valueOf(0.0f));
        this.player.v().a(21, Float.valueOf(60.0f));
        this.clonePlayer();
    }

    private void clonePlayer() {
        PlayerInfo info = PlayerUtils.getInfo((uf)atv.w().h);
        if (info != null) {
            this.setReputation(info.getReputation());
            this.setDeathScore(info.getDeathScore());
        }
    }

    @Override
    public void tick() {
        this.weight = this.player.v().d(20);
        this.maxWeight = this.player.v().d(21);
        this.player.am = this.attribs.leashingPlayer != null;
        this.shouldMove = false;
        this.weightSpeed = this.weight <= 20.0f ? 1.0f : (this.weight > this.maxWeight ? 0.15f : Math.max(1.0f - this.weight / this.maxWeight / 2.0f, 0.01f));
        if (this.attribs.leashingPlayer != null && !this.attribs.leashingPlayer.M && this.attribs.leashingPlayer.e((nn)this.player) > 6.5) {
            this.navigator.tryMoveToEntityLiving(this.attribs.leashingPlayer, 32.0);
        } else {
            this.navigator.clearPathEntity();
        }
        this.navigator.onUpdateNavigation();
        this.moveHelper.onUpdateMoveHelper();
        this.jumpHelper.doJump();
    }

    @Override
    protected by getPersistedTag() {
        by data = this.player.getEntityData();
        if (!data.b("PlayerPersisted")) {
            data.a("PlayerPersisted", (cl)new by());
        }
        return data.l("PlayerPersisted");
    }

    public void setForceCooldown(int par1) {
        this.forceCooldown = par1;
    }

    @Override
    public int getForceCooldown() {
        return this.forceCooldown;
    }

    @Override
    public void itemInteractionForEntity(uf par1) {
    }

    @Override
    public void setLeahingPlayer(uf par1) {
        this.attribs.leashingPlayer = par1;
    }

    @Override
    public void setBackpackId(int par1) {
        this.attribs.backpack = par1;
    }

    @Override
    public void setHandcuffs(boolean par1) {
        this.attribs.handcuffs = par1;
    }

    @Override
    public void onAgression() {
    }

    @Override
    public void setRespawnPoint(int par1, int par2, int par3, int par4) {
    }

    public boolean isNoDrop(ye par1) {
        return par1.e != null && par1.e.e("no_drop") != 0;
    }

    public boolean isPersonal(ye par1) {
        return par1.e != null && par1.e.e("personal") != 0;
    }

    @Override
    public IClan getClan() {
        return null;
    }

    @Override
    public void setClan(IClan par1) {
    }
}

