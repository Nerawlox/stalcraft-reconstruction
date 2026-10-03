/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cb
 *  cd
 *  cl
 *  cpw.mods.fml.common.network.Player
 *  net.minecraft.server.MinecraftServer
 *  ot
 */
package ru.stalcraft.server.player;

import cpw.mods.fml.common.network.Player;
import java.util.Calendar;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import ru.stalcraft.Logger;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.WeaponInfo;
import ru.stalcraft.clans.IClan;
import ru.stalcraft.entity.EntityBullet;
import ru.stalcraft.items.IArtefakt;
import ru.stalcraft.items.ItemBackpack;
import ru.stalcraft.player.IPlayerServerInfo;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.server.CommonProxy;
import ru.stalcraft.server.ServerContamination;
import ru.stalcraft.server.WeaponServerInfo;
import ru.stalcraft.server.WeightMap;
import ru.stalcraft.server.clans.ClanManager;
import ru.stalcraft.server.clans.Flag;
import ru.stalcraft.server.clans.FlagManager;
import ru.stalcraft.server.ejection.ServerEjection;
import ru.stalcraft.server.network.ServerPacketSender;
import ru.stalcraft.tile.TileEntityMachineGun;

public class PlayerServerInfo
extends PlayerInfo
implements IPlayerServerInfo {
    private IClan clan;
    private float preMaxWeight;
    private float preWeight;
    private int tickPlayer;
    public boolean isEjectionSave;
    private boolean isPlayerCreativeAndOp;
    private boolean hasOpenInventory;
    private static final int MAX_REPUTATION_TIMER = 72000;
    private static final int MAX_DEATH_TIMER = 12000;
    private float prevSpeedModifier = 0.0f;
    private static final UUID speedModifierUUID = new UUID(482390457L, 547283457L);
    private double[] prevPosition = new double[]{0.0, 0.0, 0.0};
    private float[] prevRotation = new float[]{0.0f, 0.0f};

    public PlayerServerInfo(uf par1) {
        super(par1, new WeaponServerInfo(par1), new ServerContamination(par1));
        this.player.v().a(20, Float.valueOf(0.0f));
        this.player.v().a(21, Float.valueOf(60.0f));
        this.updatePrevPos();
        this.updateWeightSpeed();
        this.updateArtefaktStats();
        this.clan = ClanManager.instance().getPlayerClan(par1);
        by tag = null;
        if (this.stInv.mainInventory[12] != null && yc.g[this.stInv.mainInventory[12].d] instanceof ItemBackpack && !(tag = PlayerUtils.getTag(this.stInv.mainInventory[12])).b("weightModifier")) {
            tag.a("weightModifier", ((ItemBackpack)yc.g[this.stInv.mainInventory[12].d]).weightModifier);
        }
        for (int i2 = 0; i2 < this.player.bn.a.length; ++i2) {
            if (this.player.bn.a[i2] == null || !WeightMap.itemsWeight.containsKey(this.player.bn.a[i2].d) || (tag = PlayerUtils.getTag(this.player.bn.a[i2])).b("weight")) continue;
            tag.a("weight", WeightMap.getWeight(this.player.bn.a[i2]));
        }
        ye stack = null;
        IArtefakt artefakt = null;
        for (int i3 = 0; i3 < 9; ++i3) {
            ye ye2 = stack = i3 > 3 ? this.stInv.mainInventory[i3 - 3] : this.player.bn.b[i3];
            if (stack == null || !(yc.g[stack.d] instanceof IArtefakt)) continue;
            tag = PlayerUtils.getTag(stack);
            artefakt = (IArtefakt)((Object)yc.g[stack.d]);
            if (!tag.b("speedFactor")) {
                tag.a("speedFactor", artefakt.getSpeedFactor());
            }
            if (!tag.b("protection")) {
                tag.a("protection", new int[]{artefakt.getProtection(0), artefakt.getProtection(1), artefakt.getProtection(2), artefakt.getProtection(3)});
            }
            if (!tag.b("protection")) {
                tag.a("immunity", new int[]{artefakt.getImmunity(0) ? 1 : 0, artefakt.getImmunity(1) ? 1 : 0, artefakt.getImmunity(2) ? 1 : 0, artefakt.getImmunity(3) ? 1 : 0});
            }
            if (!tag.b("bulletDamageFactor")) {
                tag.a("bulletDamageFactor", artefakt.getSpeedFactor());
            }
            if (!tag.b("jumpIncrease")) {
                tag.a("jumpIncrease", artefakt.getSpeedFactor());
            }
            if (!tag.b("fireResistance")) {
                tag.a("fireResistance", artefakt.getFireResistance());
            }
            if (!tag.b("waterWalking")) {
                tag.a("waterWalking", artefakt.getWaterWalking());
            }
            if (tag.b("fallProtection")) continue;
            tag.a("fallProtection", artefakt.getFallProtection());
        }
        tag = this.getPersistedTag();
        if (!tag.b("reputation")) {
            tag.a("reputation", 0);
        }
        if (!tag.b("deathScore")) {
            tag.a("deathScore", 10);
        }
        if (!tag.b("reputationTimer")) {
            tag.a("reputationTimer", 72000);
        }
        if (!tag.b("deathScoreTimer")) {
            tag.a("deathScoreTimer", 12000);
        }
        if (this.clan != null && this.clan.getSpecialClan() != null && !tag.b("specialClanRepTimer")) {
            tag.a("specialClanRepTimer", this.clan.getSpecialClan().getMaxReputationTimer());
        }
    }

    @Override
    public void tick() {
        this.updatePrevPos();
        by tag = null;
        ye stack = null;
        IArtefakt artefakt = null;
        int i2 = 0;
        if (this.tickPlayer % 10 == 0) {
            if (this.player.bG.d || MinecraftServer.F().af().e(this.player.bu)) {
                for (i2 = 0; i2 < 4; ++i2) {
                    this.protection[i2] = 100;
                    this.immunity[i2] = false;
                }
                for (i2 = 0; i2 < this.immunity.length; ++i2) {
                    if (this.immunity[i2]) continue;
                    this.immunity[i2] = true;
                }
                this.isPlayerCreativeAndOp = true;
            } else {
                if (this.isPlayerCreativeAndOp) {
                    for (i2 = 0; i2 < 4; ++i2) {
                        this.protection[i2] = 0;
                        this.immunity[i2] = false;
                    }
                    this.isPlayerCreativeAndOp = false;
                }
                this.updateArtefaktStats();
            }
            if (this.stInv.mainInventory[12] != null && yc.g[this.stInv.mainInventory[12].d] instanceof ItemBackpack && !(tag = PlayerUtils.getTag(this.stInv.mainInventory[12])).b("weightModifier")) {
                tag.a("weightModifier", ((ItemBackpack)yc.g[this.stInv.mainInventory[12].d]).weightModifier);
            }
            for (i2 = 0; i2 < this.player.bn.a.length; ++i2) {
                if (this.player.bn.a[i2] == null || !WeightMap.itemsWeight.containsKey(this.player.bn.a[i2].d) || (tag = PlayerUtils.getTag(this.player.bn.a[i2])).b("weight")) continue;
                tag.a("weight", WeightMap.getWeight(this.player.bn.a[i2]));
            }
            for (i2 = 0; i2 < 9; ++i2) {
                ye ye2 = stack = i2 > 3 ? this.stInv.mainInventory[i2 - 3] : this.player.bn.b[i2];
                if (stack == null || !(yc.g[stack.d] instanceof IArtefakt)) continue;
                tag = PlayerUtils.getTag(stack);
                artefakt = (IArtefakt)((Object)yc.g[stack.d]);
                if (!tag.b("speedFactor")) {
                    tag.a("speedFactor", artefakt.getSpeedFactor());
                    continue;
                }
                if (!tag.b("protection")) {
                    tag.a("protection", new int[]{artefakt.getProtection(0), artefakt.getProtection(1), artefakt.getProtection(2), artefakt.getProtection(3)});
                    continue;
                }
                if (!tag.b("protection")) {
                    tag.a("immunity", new int[]{artefakt.getImmunity(0) ? 1 : 0, artefakt.getImmunity(1) ? 1 : 0, artefakt.getImmunity(2) ? 1 : 0, artefakt.getImmunity(3) ? 1 : 0});
                    continue;
                }
                if (!tag.b("bulletDamageFactor")) {
                    tag.a("bulletDamageFactor", artefakt.getSpeedFactor());
                    continue;
                }
                if (!tag.b("jumpIncrease")) {
                    tag.a("jumpIncrease", artefakt.getSpeedFactor());
                    continue;
                }
                if (!tag.b("fireResistance")) {
                    tag.a("fireResistance", artefakt.getFireResistance());
                    continue;
                }
                if (!tag.b("waterWalking")) {
                    tag.a("waterWalking", artefakt.getWaterWalking());
                    continue;
                }
                if (tag.b("fallProtection")) continue;
                tag.a("fallProtection", artefakt.getFallProtection());
            }
            this.updateWeightSpeed();
        }
        if ((tag = this.getPersistedTag()).e("deathScore") < 10 && this.tickPlayer > 0 && this.tickPlayer % 2400 == 0) {
            tag.a("deathScore", ls.a(tag.e("deathScore") + 1, 0, 10));
        }
        if (this.activeEnergyEffect > 0) {
            --this.activeEnergyEffect;
        }
        this.weightSpeed = this.weight <= 20.0f ? 1.0f : (this.weight > this.maxWeight ? 0.15f : Math.max(1.0f - this.weight / this.maxWeight / 2.0f, 0.01f));
        float speedModifier = this.weightSpeed * (this.speedFactor + (this.activeEnergyEffect > 0 ? 0.25f : 0.0f));
        if (speedModifier != this.prevSpeedModifier) {
            ot prevModifier = this.player.a(tp.d).a(speedModifierUUID);
            if (prevModifier != null) {
                this.player.a(tp.d).b(prevModifier);
            }
            if (speedModifier != 1.0f) {
                ot modifier = new ot(speedModifierUUID, "stalker_speed", (double)(speedModifier - 1.0f), 1);
                this.player.a(tp.d).a(modifier);
            }
            this.prevSpeedModifier = speedModifier;
        }
        ++this.tickPlayer;
    }

    @Override
    public void readNBT(by tag) {
        try {
            ((ServerContamination)this.cont).readNBT(tag);
            ((WeaponServerInfo)this.weaponInfo).readNBT(tag);
            cg nbttaglist = tag.m("StalkerInventory");
            this.stInv.readFromNBT(nbttaglist);
            this.inventoryContainer.handleBackpackChanged(this.stInv.mainInventory[12] != null);
            this.attribs.handcuffs = tag.n("handcuffs");
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override
    public void writeNBT(by tag) {
        try {
            ((ServerContamination)this.cont).writeNBT(tag);
            ((WeaponServerInfo)this.weaponInfo).writeNBT(tag);
            tag.a("StalkerInventory", this.stInv.writeToNBT(new cg()));
            tag.a("handcuffs", this.attribs.handcuffs);
            Logger.debug("Saving pos: " + this.player.bu + " (" + this.prevPosition[0] + ", " + this.prevPosition[1] + ", " + this.prevPosition[2]);
            tag.a("Pos", this.newDoubleNBTList(this.prevPosition));
            tag.a("Rotation", this.newFloatNBTList(this.prevRotation));
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private cg newDoubleNBTList(double ... par1ArrayOfDouble) {
        cg nbttaglist = new cg();
        for (int i2 = 0; i2 < par1ArrayOfDouble.length; ++i2) {
            nbttaglist.a((cl)new cb((String)null, par1ArrayOfDouble[i2]));
        }
        return nbttaglist;
    }

    private cg newFloatNBTList(float ... par1ArrayOfFloat) {
        cg nbttaglist = new cg();
        for (int i2 = 0; i2 < par1ArrayOfFloat.length; ++i2) {
            nbttaglist.a((cl)new cd((String)null, par1ArrayOfFloat[i2]));
        }
        return nbttaglist;
    }

    @Override
    public void setRespawnPoint(int dimension, int x2, int y2, int z2) {
        by tag = this.getPersistedTag();
        tag.a("respawnDimension", dimension);
        if ((tag.e("respawnX") != x2 || tag.e("respawnY") != y2 || tag.e("respawnZ") != z2) && FlagManager.instance().getFlagByPlayer(this.player) == null) {
            this.player.a("\u0422\u0435\u043f\u0435\u0440\u044c \u0432\u044b \u0432\u043e\u0437\u0440\u043e\u0436\u0434\u0430\u0435\u0442\u0435\u0441\u044c \u0437\u0434\u0435\u0441\u044c.");
        }
        tag.a("respawnX", x2);
        tag.a("respawnY", y2);
        tag.a("respawnZ", z2);
    }

    public void setPositionToPrevious() {
        this.player.a(this.prevPosition[0], this.prevPosition[1], this.prevPosition[2], this.prevRotation[0], this.prevRotation[1]);
    }

    private void updatePrevPos() {
        this.prevPosition[0] = this.player.r;
        this.prevPosition[1] = this.player.s + (double)this.player.X;
        this.prevPosition[2] = this.player.t;
        this.prevRotation[0] = this.player.C;
        this.prevRotation[1] = this.player.D;
    }

    public void onDeath() {
        by tag = this.getPersistedTag();
        tag.a("deathScore", Math.max(-10, tag.e("deathScore") - 3));
        tag.a("deathScoreTimer", 12000);
        ServerPacketSender.sendDeathScore(this.player);
        tag.a("last_death", System.currentTimeMillis());
        int cooldown = Math.max(0, -tag.e("reputation") * 1200 - tag.e("deathScore") * 600);
        tag.a("last_cooldown", cooldown);
        ServerPacketSender.sendForceCooldown(this.player);
    }

    public void addReputation(int amount) {
        by tag = this.getPersistedTag();
        int oldReputation = tag.e("reputation");
        int reputation = oldReputation + amount;
        if (reputation > 10) {
            reputation = 10;
        }
        if (reputation < -10) {
            reputation = -10;
        }
        if (this.clan != null) {
            this.clan.addReputation(reputation - oldReputation);
        }
        tag.a("reputation", reputation);
        ServerPacketSender.sendReputation(this.player);
        ServerPacketSender.sendPlayerTag(this.player);
    }

    public void onWithdrawSalary() {
        this.getPersistedTag().a("last_salary", System.currentTimeMillis());
    }

    @Override
    public void onAgression() {
        if (this.attribs.agressionTimer == 0) {
            this.attribs.agressionTimer = 1200;
            ServerPacketSender.sendPlayerTag(this.player);
        } else {
            this.attribs.agressionTimer = 1200;
        }
    }

    @Override
    public void setHandcuffs(boolean handcuffs) {
        this.attribs.handcuffs = handcuffs;
        ServerPacketSender.sendHandcuffs(this.player, handcuffs);
        if (this.attribs.leashingPlayer != null && !handcuffs) {
            this.attribs.leashingPlayer.bn.a(new ye(StalkerMain.rope.cv, 1, 0));
            this.setLeahingPlayer(null);
        }
    }

    @Override
    public void setLeahingPlayer(uf par1) {
        this.attribs.leashingPlayer = par1;
        ServerPacketSender.sendLeashing(this.player, this.attribs.leashingPlayer);
    }

    public void teleportToSpawnPoint() {
        int respawnZ;
        int respawnY;
        int respawnX;
        int dimension;
        Logger.debug("teleporting " + this.player.bu + " to spawn point");
        by tag = this.getPersistedTag();
        Flag flag = FlagManager.instance().getFlagByPlayer(this.player);
        if (flag != null) {
            dimension = flag.dimension;
            respawnX = flag.x;
            respawnY = flag.y;
            respawnZ = flag.z;
        } else {
            dimension = tag.e("respawnDimension");
            respawnX = tag.e("respawnX");
            respawnY = tag.e("respawnY");
            respawnZ = tag.e("respawnZ");
        }
        if (respawnX != 0 || respawnY != 0 || respawnZ != 0) {
            if (this.player.ar != dimension) {
                this.player.b(dimension);
            }
            this.player.a((double)respawnX + 0.5, (double)respawnY + 0.5, (double)respawnZ + 0.5);
        }
    }

    @Override
    public by getPersistedTag() {
        by data = this.player.getEntityData();
        if (!data.b("PlayerPersisted")) {
            data.a("PlayerPersisted", (cl)new by());
        }
        return data.l("PlayerPersisted");
    }

    @Override
    public int getForceCooldown() {
        if (MinecraftServer.F().af().e(this.player.bu) || this.player.bG.d) {
            return 0;
        }
        by tag = this.getPersistedTag();
        if (tag.f("last_death") == 0L) {
            return 0;
        }
        int cooldown = Math.min(Math.max(0, tag.e("last_cooldown") - (int)((System.currentTimeMillis() - tag.f("last_death")) / 50L)), 36000);
        if (tag.n("deathTimer")) {
            cooldown = 0;
        }
        return cooldown;
    }

    public boolean canGetSalary() {
        Calendar oldDate = Calendar.getInstance();
        Calendar newDate = Calendar.getInstance();
        oldDate.setTimeInMillis(this.getPersistedTag().f("last_salary"));
        newDate.setTimeInMillis(System.currentTimeMillis());
        return newDate.after(oldDate) && newDate.get(6) > oldDate.get(6) && newDate.get(1) > oldDate.get(1);
    }

    @Override
    public void setBackpackId(int newId) {
        this.attribs.backpack = newId;
    }

    public void resetInfo(WeaponInfo par1, uf par2) {
        this.weaponInfo = par1;
        this.cont = new ServerContamination(par2);
        this.attribs = new PlayerInfo.Attribs();
        this.updateArtefaktStats();
        this.updateWeightSpeed();
        this.teleportToSpawnPoint();
    }

    public void updateArtefaktStats() {
        this.speedFactor = 1.0f;
        int i2 = 0;
        for (i2 = 0; i2 < 4; ++i2) {
            this.protection[i2] = 0;
            this.immunity[i2] = false;
        }
        this.bulletDamageFactor = 1.0f;
        this.jumpIncrease = 0.0f;
        this.fallProtection = 0;
        this.fireResistance = false;
        this.waterWalking = false;
        ye stack = null;
        by tag = null;
        IArtefakt artefakt = null;
        for (i2 = 0; i2 < 9; ++i2) {
            ye ye2 = stack = i2 > 3 ? this.stInv.mainInventory[i2 - 3] : this.player.bn.b[i2];
            if (stack == null || !(yc.g[stack.d] instanceof IArtefakt)) continue;
            tag = PlayerUtils.getTag(stack);
            artefakt = (IArtefakt)((Object)yc.g[stack.d]);
            this.speedFactor += tag.g("speedFactor") - 1.0f;
            for (int j2 = 0; j2 < 4; ++j2) {
                int n2 = j2;
                this.protection[n2] = this.protection[n2] + (tag.k("protection").length > 0 ? tag.k("protection")[j2] : 0);
                int n3 = j2;
                this.immunity[n3] = this.immunity[n3] | (tag.k("immunity").length > 0 ? tag.k("immunity")[j2] != 0 : false);
            }
            this.bulletDamageFactor += tag.g("bulletDamageFactor") - 1.0f;
            this.jumpIncrease += tag.g("jumpIncrease");
            this.fireResistance |= tag.n("fireResistance");
            this.waterWalking |= tag.n("waterWalking");
            this.fallProtection += tag.e("fallProtection");
        }
        if (this.speedFactor < 0.0f) {
            this.speedFactor = 0.0f;
        }
    }

    @Override
    public void itemInteractionForEntity(uf par1) {
        if (this.getHandcuffs() && this.getLeashingPlayer() == null) {
            this.setLeahingPlayer(this.player);
            par1.c(0, null);
            par1.a("\u0412\u044b \u043f\u0440\u0438\u0432\u044f\u0437\u0430\u043b\u0438 \u0438\u0433\u0440\u043e\u043a\u0430 " + par1.bu);
            par1.a("\u0412\u0430\u0441 \u043f\u0440\u0438\u0432\u044f\u0437\u0430\u043b \u0438\u0433\u0440\u043e\u043a " + this.player.bu);
        } else if (!this.getHandcuffs()) {
            par1.a("\u0418\u0433\u0440\u043e\u043a \u0434\u043e\u043b\u0436\u0435\u043d \u0441\u043d\u0430\u0447\u0430\u043b\u0430 \u043d\u0430\u0434\u0435\u0442\u044c \u043d\u0430\u0440\u0443\u0447\u043d\u0438\u043a\u0438.");
        } else {
            par1.a("\u0418\u0433\u0440\u043e\u043a \u0443\u0436\u0435 \u043f\u0440\u0438\u0432\u044f\u0437\u0430\u043d.");
        }
    }

    @Override
    public IClan getClan() {
        return this.clan;
    }

    @Override
    public void setClan(IClan par1) {
        this.clan = par1;
    }

    @Override
    public void startEjection() {
        if (CommonProxy.serverEjectionManager.hasEjection()) {
            ServerEjection e2 = (ServerEjection)CommonProxy.serverEjectionManager.getEjection();
            ServerPacketSender.sendEjectionStartToPlayer((Player)this.player, e2.id, e2.age);
        }
    }

    @Override
    public void shooterMachineGun(TileEntityMachineGun par1) {
        if (par1.getShooter() == null && this.player.bn.h() == null && this.player.ar == par1.k.t.i && !this.player.M && this.player.aN() > 0.0f && this.player.f(par1.l, par1.m, par1.n) <= 2.0) {
            par1.updatePlayerPos();
            par1.updateRotation();
            this.weaponInfo.currentGun = par1;
            ServerPacketSender.sendMachinegunState(this.player, par1, true);
            ServerPacketSender.sendTileEntityEvent(par1, 1, par1.bulletsInCage);
            par1.setShooter(this.player);
        } else if (par1.getShooter() == this.player) {
            par1.removeShooter();
        }
    }

    public void sendUpdateStalkerContainer() {
        ((jv)this.player).bN();
        ServerPacketSender.sendUpdateStalkerInventory(this.player);
        ServerPacketSender.sendWindowId(this.player, ((jv)this.player).bY);
        this.inventoryContainer.d = ((jv)this.player).bY;
        ((jv)this.player).a(this.inventoryContainer);
    }

    @Override
    public void shootMachineGun(TileEntityMachineGun par1) {
        if (par1.getShooter() == this.player && par1.reloadTime == -1 && par1.bulletsInCage > 0 && par1.cooldown <= 0) {
            --par1.bulletsInCage;
            EntityBullet bullet = new EntityBullet(this.player, (double)par1.l + 0.5, (double)par1.m + 0.5, (double)par1.n + 0.5, par1.yaw + (float)(par1.p * 90), par1.pitch, 10, 2.0f, "stalker:machinegun_hit", 0.995);
            ServerPacketSender.sendTileEntityEvent(par1, 1, par1.bulletsInCage);
            ServerPacketSender.sendTileEntityEvent(par1, 2, 0);
            par1.k.a((double)par1.l + 0.5, (double)par1.m + 0.5, (double)par1.n + 0.5, "stalker:machinegun_shoot", 5.0f, 0.9f + par1.k.s.nextFloat() * 0.1f);
            par1.k.d(bullet);
            par1.cooldown = 2;
        }
    }

    @Override
    public void reloadRequestMachineGun(TileEntityMachineGun par1) {
        if (par1.reloadTime == -1 && par1.getShooter() == this.player) {
            if (par1.bulletsInCage >= 300) {
                return;
            }
            if (!PlayerUtils.hasItem(this.player, 14955)) {
                return;
            }
            par1.reloadTime = 100;
            par1.k.a((double)par1.l + 0.5, (double)par1.m + 0.5, (double)par1.n + 0.5, "stalker:machinegun_reload", 1.0f, 0.9f + par1.k.s.nextFloat());
            ServerPacketSender.sendTileEntityEvent(par1, 3, 100);
        }
    }

    @Override
    public void reloadFinishMachineGun(TileEntityMachineGun par1) {
        if (par1.getShooter() == this.player && this.player.bn.e(14955)) {
            this.player.bn.d(14955);
            par1.bulletsInCage = 300;
            ((jv)this.player).a(this.player.bo);
            ServerPacketSender.sendTileEntityEvent(par1, 1, par1.bulletsInCage);
            ServerPacketSender.sendTileEntityEvent(par1, 3, -1);
        }
    }

    @Override
    public void addItemSafe(uf par1EntityPlayer, ye updatedWeapon) {
    }

    @Override
    public void updateWeightSpeed() {
        this.updateWeight();
        this.updateMaxWeight();
    }

    private void updateWeight() {
        int i2;
        this.weight = 0.0f;
        if (this.player.bG.d) {
            return;
        }
        for (i2 = 0; i2 < this.player.bn.a.length; ++i2) {
            if (this.player.bn.a[i2] == null) continue;
            this.weight += WeightMap.getWeight(this.player.bn.a[i2]);
        }
        for (i2 = 0; i2 < this.player.bn.b.length; ++i2) {
            if (this.player.bn.b[i2] == null) continue;
            this.weight += WeightMap.getWeight(this.player.bn.b[i2]);
        }
        for (i2 = 0; i2 < this.stInv.mainInventory.length; ++i2) {
            if (this.stInv.mainInventory[i2] == null) continue;
            this.weight += WeightMap.getWeight(this.stInv.mainInventory[i2]);
        }
        if (this.weight > this.preWeight || this.weight < this.preWeight) {
            this.player.v().b(20, Float.valueOf(this.weight));
            this.preWeight = this.weight;
        }
    }

    private void updateMaxWeight() {
        this.maxWeight = 60.0f;
        if (this.stInv.mainInventory[12] != null) {
            ItemBackpack par1 = (ItemBackpack)yc.g[this.stInv.mainInventory[12].d];
            this.maxWeight += (float)PlayerUtils.getTag(this.stInv.mainInventory[12]).e("weightModifier");
        }
        if (this.maxWeight > this.preMaxWeight || this.maxWeight < this.preMaxWeight) {
            this.player.v().b(21, Float.valueOf(this.maxWeight));
            this.preMaxWeight = this.maxWeight;
        }
    }

    @Override
    public void activeEffectEnergy() {
        this.activeEnergyEffect = 440;
    }
}

