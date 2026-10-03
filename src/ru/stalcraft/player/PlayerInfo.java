/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.player;

import java.util.ArrayList;
import ru.stalcraft.BlockPos;
import ru.stalcraft.Contamination;
import ru.stalcraft.WeaponInfo;
import ru.stalcraft.clans.IClan;
import ru.stalcraft.inventory.StalkerContainer;
import ru.stalcraft.inventory.StalkerInventory;
import ru.stalcraft.player.PlayerStalkerCapabilities;

public abstract class PlayerInfo {
    protected Attribs attribs;
    public int medicineCooldown = 0;
    public int activeEnergyEffect;
    public Contamination cont;
    public WeaponInfo weaponInfo;
    public final uf player;
    public StalkerInventory stInv;
    public StalkerContainer inventoryContainer;
    protected float speedFactor = 1.0f;
    protected int[] protection = new int[4];
    protected boolean[] immunity = new boolean[4];
    protected float bulletDamageFactor = 1.0f;
    protected float jumpIncrease = 0.0f;
    protected boolean fireResistance = false;
    protected boolean waterWalking = false;
    protected float weightSpeed = 1.0f;
    protected float weight = 0.0f;
    protected float maxWeight = 60.0f;
    protected int fallProtection = 0;
    public BlockPos secondSelected = null;
    public BlockPos firstSelected = null;
    public ArrayList quitListeners = new ArrayList();
    public int money;
    private int tickInfo;

    public PlayerInfo(uf player, WeaponInfo par2, Contamination par3) {
        this.player = player;
        this.weaponInfo = par2;
        this.cont = par3;
        this.stInv = new StalkerInventory(player);
        player.bG = new PlayerStalkerCapabilities(player, this);
        this.inventoryContainer = new StalkerContainer(player.bn, player.q.I, player);
        this.attribs = new Attribs();
    }

    public void onUpdate() {
        this.weaponInfo.tick();
        this.cont.tick();
        if (this.medicineCooldown > 0) {
            --this.medicineCooldown;
        }
        if (this.activeEnergyEffect > 0) {
            --this.activeEnergyEffect;
        }
        this.tick();
        ++this.tickInfo;
    }

    public abstract void tick();

    public boolean canJump() {
        return this.weight < this.maxWeight;
    }

    public float getWeight() {
        return this.weight;
    }

    public float getMaxWeight() {
        return this.maxWeight;
    }

    public float getWeightSpeed() {
        return this.weightSpeed;
    }

    public float getSpeedFactor() {
        return this.speedFactor;
    }

    public int getProtection(int effectId) {
        return this.protection[effectId];
    }

    public boolean getImmunity(int effectId) {
        return this.immunity[effectId];
    }

    public float getBulletDamageFactor() {
        return this.bulletDamageFactor;
    }

    public float getJumpIncrease() {
        return this.jumpIncrease;
    }

    public boolean getFireResistance() {
        return this.fireResistance;
    }

    public boolean getWaterWalking() {
        return this.waterWalking;
    }

    public int getFallProtection() {
        return this.fallProtection;
    }

    public uf getLeashingPlayer() {
        return this.attribs != null ? this.attribs.leashingPlayer : null;
    }

    public boolean getHandcuffs() {
        return this.attribs != null ? Boolean.valueOf(this.attribs.handcuffs) : null;
    }

    public boolean isPlayerAgressive() {
        return this.attribs.agressionTimer > 0;
    }

    public int getBackpackId() {
        return this.attribs.backpack;
    }

    public int getReputation() {
        return this.getPersistedTag().e("reputation");
    }

    public int getDeathScore() {
        return this.getPersistedTag().e("deathScore");
    }

    public void setReputation(int reputation) {
        this.getPersistedTag().a("reputation", reputation);
    }

    public void setDeathScore(int deathScore) {
        this.getPersistedTag().a("deathScore", deathScore);
    }

    protected abstract by getPersistedTag();

    public abstract int getForceCooldown();

    public abstract void itemInteractionForEntity(uf var1);

    public abstract void setLeahingPlayer(uf var1);

    public abstract void setBackpackId(int var1);

    public abstract void setHandcuffs(boolean var1);

    public abstract void onAgression();

    public abstract void setRespawnPoint(int var1, int var2, int var3, int var4);

    public abstract IClan getClan();

    public abstract void setClan(IClan var1);

    protected static class Attribs {
        public uf leashingPlayer;
        public int backpack;
        public int prevBackpack;
        public boolean handcuffs;
        public int agressionTimer;
    }
}

