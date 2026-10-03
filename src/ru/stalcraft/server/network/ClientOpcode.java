/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.MinecraftServer
 */
package ru.stalcraft.server.network;

import net.minecraft.server.MinecraftServer;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.WeaponInfo;
import ru.stalcraft.clans.ClanRank;
import ru.stalcraft.inventory.WeaponContainer;
import ru.stalcraft.items.ItemMedicine;
import ru.stalcraft.items.ItemWeapon;
import ru.stalcraft.network.DebugGroup;
import ru.stalcraft.network.DebugPriority;
import ru.stalcraft.network.IOpcodeServer;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerStalkerCapabilities;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.server.WeaponServerInfo;
import ru.stalcraft.server.clans.ClanManager;
import ru.stalcraft.server.clans.FlagManager;
import ru.stalcraft.server.clans.FlagsLand;
import ru.stalcraft.server.network.ServerPacketSender;
import ru.stalcraft.server.player.PlayerServerInfo;
import ru.stalcraft.tile.TileEntityMachineGun;

public enum ClientOpcode implements IOpcodeServer
{
    SHOOT_REQUEST("SHOOT_REQUEST", 0, DebugPriority.LOW, DebugGroup.WEAPONS, null){

        @Override
        public void handle(jv player, String ... data) {
            PlayerInfo par3 = ((PlayerStalkerCapabilities)player.bG).getInfo();
            int slot = player.bn.c;
            if (player.bn.a[slot] != null && ((WeaponServerInfo)par3.weaponInfo).canShoot(player.bn.a[slot])) {
                int itemID = player.bn.a[slot].d;
                ItemWeapon weapon = (ItemWeapon)yc.g[itemID];
                int type = Integer.parseInt(data[0]);
                if (type == 0) {
                    weapon.shootRequest(player, slot, false);
                } else if (type == 1) {
                    weapon.shootRequest(player, slot, true);
                } else if (type == 2) {
                    weapon.grenadeShootRequest(player, slot);
                }
            }
        }
    }
    ,
    RELOAD_REQUEST("RELOAD_REQUEST", 1, DebugPriority.LOW, DebugGroup.WEAPONS, null){

        @Override
        public void handle(jv player, String ... data) {
            if (player.bn.h() != null && player.bn.h().b() instanceof ItemWeapon) {
                PlayerUtils.getInfo((uf)player).weaponInfo.reloadRequest(player.bn.h());
            }
        }
    }
    ,
    MACHINE_GUN_RELOAD_REQUEST("MACHINE_GUN_RELOAD_REQUEST", 2, DebugPriority.MIDDLE, DebugGroup.WEAPONS, null){

        @Override
        public void handle(jv player, String ... data) {
            WeaponInfo wi2 = PlayerUtils.getInfo((uf)player).weaponInfo;
            if (wi2.currentGun != null) {
                wi2.currentGun.reloadRequest();
            }
        }
    }
    ,
    MACHINE_GUN_SHOOT_REQUEST("MACHINE_GUN_SHOOT_REQUEST", 3, DebugPriority.MIDDLE, DebugGroup.WEAPONS, null){

        @Override
        public void handle(jv player, String ... data) {
            WeaponInfo wi2 = PlayerUtils.getInfo((uf)player).weaponInfo;
            if (wi2.currentGun != null) {
                wi2.currentGun.shootRequest();
            }
        }
    }
    ,
    EXTRACT_AMMO_REQUEST("EXTRACT_AMMO_REQUEST", 4, DebugPriority.HIGH, DebugGroup.WEAPONS, null){

        @Override
        public void handle(jv player, String ... data) {
            ((WeaponContainer)player.bp).tryExtractAmmo();
        }
    }
    ,
    CLAN_INFO_REQUEST("CLAN_INFO_REQUEST", 5, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ServerPacketSender.sendClanInformation(player);
        }
    }
    ,
    CLAN_RULES_REQUEST("CLAN_RULES_REQUEST", 6, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ServerPacketSender.sendClanRules(player);
        }
    }
    ,
    CLAN_MEMBERS_REQUEST("CLAN_MEMBERS_REQUEST", 7, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ServerPacketSender.sendClanMembers(player);
        }
    }
    ,
    CLAN_LIST_REQUEST("CLAN_LIST_REQUEST", 8, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ServerPacketSender.sendClansList(player);
            ServerPacketSender.sendClanInformation(player);
        }
    }
    ,
    CLAN_CREATE_REQUEST("CLAN_CREATE_REQUEST", 9, DebugPriority.HIGH, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ClanManager.instance().tryRegisterClan(data[0], player);
        }
    }
    ,
    CLAN_DELETE_REQUEST("CLAN_DELETE_REQUEST", 10, DebugPriority.HIGH, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ClanManager.instance().tryRemoveClan(player);
        }
    }
    ,
    CLAN_SET_LEADER_REQUEST("CLAN_SET_LEADER_REQUEST", 11, DebugPriority.HIGH, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ClanManager.instance().trySetLeader(player, data[0]);
        }
    }
    ,
    CLAN_INVITE_CLIENT_REQUEST("CLAN_INVITE_CLIENT_REQUEST", 12, DebugPriority.MIDDLE, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ClanManager.instance().tryAddInvite(player, data[0]);
        }
    }
    ,
    CLAN_KICK_REQUEST("CLAN_KICK_REQUEST", 13, DebugPriority.MIDDLE, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ClanManager.instance().tryKickPlayer(player, data[0]);
        }
    }
    ,
    CLAN_WAR_REQUEST("CLAN_WAR_REQUEST", 14, DebugPriority.HIGH, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ClanManager.instance().tryStartWar(player, data[0]);
        }
    }
    ,
    CLAN_PEACE_OFFER_REQUEST("CLAN_PEACE_OFFER_REQUEST", 15, DebugPriority.HIGH, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ClanManager.instance().tryEndWar(player, data[0]);
        }
    }
    ,
    CLAN_LANDS_REQUEST("CLAN_LANDS_REQUEST", 16, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ServerPacketSender.sendClanLands(player);
        }
    }
    ,
    CLAN_LEAVE_REQUEST("CLAN_LEAVE_REQUEST", 17, DebugPriority.MIDDLE, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ClanManager.instance().tryLeaveClan(player);
        }
    }
    ,
    CLAN_RANK_UP_REQUEST("CLAN_RANK_UP_REQUEST", 18, DebugPriority.MIDDLE, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ClanManager.instance().trySetRank(player, data[0], ClanRank.OFFICER);
        }
    }
    ,
    CLAN_RANK_DOWN_REQUEST("CLAN_RANK_DOWN_REQUEST", 19, DebugPriority.MIDDLE, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ClanManager.instance().trySetRank(player, data[0], ClanRank.MEMBER);
        }
    }
    ,
    CLAN_PEACE_OFFER_CANCEL_REQUEST("CLAN_PEACE_OFFER_CANCEL_REQUEST", 20, DebugPriority.HIGH, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ClanManager.instance().tryCancelPeaceOffer(player, data[0]);
        }
    }
    ,
    CLAN_CLEAR_RULES_REQUEST("CLAN_CLEAR_RULES_REQUEST", 21, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ClanManager.instance().tryClearRules(player);
        }
    }
    ,
    CLAN_ADD_RULES_REQUEST("CLAN_ADD_RULES_REQUEST", 22, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ClanManager.instance().tryAddRules(player, data[0]);
        }
    }
    ,
    CLAN_JOIN_REQUEST("CLAN_JOIN_REQUEST", 23, DebugPriority.MIDDLE, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ClanManager.instance().tryJoinClan(player, data[0]);
        }
    }
    ,
    CLAN_LAND_RENAME_REQUEST("CLAN_LAND_RENAME_REQUEST", 24, DebugPriority.MIDDLE, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            FlagManager.instance().trySetFlagName(player, Integer.parseInt(data[0]), data[1]);
        }
    }
    ,
    CLAN_GET_MONEY_REQUEST("CLAN_GET_MONEY_REQUEST", 25, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ClanManager.instance().tryGetMoney(player);
        }
    }
    ,
    CLAN_SYNC_REPUTATION_REQUEST("CLAN_SYNC_REPUTATION_REQUEST", 26, DebugPriority.HIGH, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            ClanManager.instance().trySyncReputation(player);
        }
    }
    ,
    HANDCUFFS_ANSWER("HANDCUFFS_ANSWER", 27, DebugPriority.MIDDLE, DebugGroup.OTHER, null){

        @Override
        public void handle(jv player, String ... data) {
            jv handcuffer = (jv)player.q.a(Integer.parseInt(data[0]));
            boolean confirmed = data[1].equals("1");
            if (handcuffer != null) {
                if (!confirmed) {
                    handcuffer.a(handcuffer.bu + " \u043e\u0442\u043a\u0430\u0437\u0430\u043b\u0441\u044f \u043d\u0430\u0434\u0435\u0432\u0430\u0442\u044c \u043d\u0430\u0440\u0443\u0447\u043d\u0438\u043a\u0438.");
                } else if (handcuffer.by() != null && handcuffer.by().d == StalkerMain.handcuffs.cv) {
                    handcuffer.a(handcuffer.bu + " \u0441\u043e\u0433\u043b\u0430\u0441\u0438\u043b\u0441\u044f \u043d\u0430\u0434\u0435\u0442\u044c \u043d\u0430\u0440\u0443\u0447\u043d\u0438\u043a\u0438.");
                    handcuffer.c(0, null);
                    PlayerUtils.getInfo(player).setHandcuffs(true);
                } else {
                    player.a(handcuffer.bu + " \u0443\u0436\u0435 \u0443\u0431\u0440\u0430\u043b \u043d\u0430\u0440\u0443\u0447\u043d\u0438\u043a\u0438.");
                    handcuffer.a(handcuffer.bu + " \u0441\u043e\u0433\u043b\u0430\u0441\u0438\u043b\u0441\u044f \u043d\u0430\u0434\u0435\u0442\u044c \u043d\u0430\u0440\u0443\u0447\u043d\u0438\u043a\u0438, \u043d\u043e \u0432\u044b \u0438\u0445 \u0443\u0436\u0435 \u0443\u0431\u0440\u0430\u043b\u0438.");
                }
            } else {
                player.a("\u0422\u043e\u0442, \u043a\u0442\u043e \u0445\u043e\u0442\u0435\u043b \u043d\u0430\u0434\u0435\u0442\u044c \u043d\u0430 \u0432\u0430\u0441 \u043d\u0430\u0440\u0443\u0447\u043d\u0438\u043a\u0438, \u043a\u0443\u0434\u0430-\u0442\u043e \u0434\u0435\u043b\u0441\u044f.");
            }
        }
    }
    ,
    USE_HEALING_REQUEST("USE_HEALING_REQUEST", 28, DebugPriority.MIDDLE, DebugGroup.OTHER, null){

        @Override
        public void handle(jv player, String ... data) {
            int number = Integer.parseInt(data[0]) + 7;
            PlayerServerInfo info = (PlayerServerInfo)PlayerUtils.getInfo(player);
            if (number > 7 && number < 12 && info.stInv.mainInventory[number] != null && info.medicineCooldown == 0) {
                ItemMedicine meds = (ItemMedicine)info.stInv.mainInventory[number].b();
                meds.useHealing(player);
                info.medicineCooldown = 100;
                --info.stInv.mainInventory[number].b;
                if (info.stInv.mainInventory[number] != null && info.stInv.mainInventory[number].b < 1) {
                    info.stInv.mainInventory[number] = null;
                }
                ((PlayerServerInfo)PlayerUtils.getInfo(player)).sendUpdateStalkerContainer();
            }
        }
    }
    ,
    FLASHLIGHT_TOGGLE_REQUEST("FLASHLIGHT_TOGGLE_REQUEST", 29, DebugPriority.LOW, DebugGroup.OTHER, null){

        @Override
        public void handle(jv player, String ... data) {
            ((WeaponServerInfo)PlayerUtils.getInfo((uf)player).weaponInfo).flashlightToggleRequest(player.bn.a[player.bn.c]);
        }
    }
    ,
    RIGHT_CLICK_PLAYER_REQUEST("RIGHT_CLICK_PLAYER_REQUEST", 30, DebugPriority.MIDDLE, DebugGroup.OTHER, null){

        @Override
        public void handle(jv player, String ... data) {
            jv inventoryToOpen = MinecraftServer.F().af().f(data[0]);
            if (inventoryToOpen != null) {
                PlayerInfo info = PlayerUtils.getInfo(inventoryToOpen);
                if (info.getLeashingPlayer() == player) {
                    info.setLeahingPlayer(null);
                    player.bn.a(new ye(StalkerMain.rope.cv, 1, 0));
                } else if (info.getHandcuffs()) {
                    player.openGui(StalkerMain.instance, 3, player.q, inventoryToOpen.k, 0, 0);
                    ServerPacketSender.sendWindowId(player, player.bp.d);
                }
            }
        }
    }
    ,
    GUI_OPEN_INVENTORY("GUI_OPEN_INVENTORY", 31, DebugPriority.MIDDLE, DebugGroup.OTHER, null){

        @Override
        public void handle(jv player, String ... data) {
            player.openGui(StalkerMain.instance, 4, player.q, 0, 0, 0);
        }
    }
    ,
    RIGHT_CLICK_BLOCK("RIGHT_CLICK_BLOCK", 32, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        public void handle(jv player, String ... data) {
            int par3 = Integer.parseInt(data[0]);
            int par4 = Integer.parseInt(data[1]);
            int par5 = Integer.parseInt(data[2]);
            int par6 = Integer.parseInt(data[3]);
            FlagManager.instance().addFlagsLand(new FlagsLand(player.q.N().j(), par3, par4, par5, par6, 30000, 72000));
        }
    }
    ,
    WEAPON_FIRE_MODE("WEAPON_FIRE_MODE", 33, DebugPriority.HIGH, DebugGroup.WEAPONS, null){

        @Override
        public void handle(jv player, String ... data) {
            PlayerInfo playerInfo = ((PlayerStalkerCapabilities)player.bG).getInfo();
            int slot = player.bn.c;
            if (player.bn.a[slot] != null && yc.g[player.bn.a[slot].d] instanceof ItemWeapon) {
                ((WeaponServerInfo)playerInfo.weaponInfo).updateFireMode(player.bn.a[slot]);
            }
        }
    }
    ,
    MACHINE_GUN_SHOOTER("WEAPON_FIRE_MODE", 34, DebugPriority.HIGH, DebugGroup.WEAPONS, null){

        @Override
        public void handle(jv player, String ... data) {
            int posX = Integer.parseInt(data[0]);
            int posY = Integer.parseInt(data[1]);
            int posZ = Integer.parseInt(data[2]);
            ((TileEntityMachineGun)player.q.r(posX, posY, posZ)).onRightClick(player);
        }
    };

    private final DebugPriority priority;
    private final DebugGroup group;
    private static final ClientOpcode[] $VALUES;

    private ClientOpcode(String var1, int var2, DebugPriority priority, DebugGroup group) {
        this.priority = priority;
        this.group = group;
    }

    @Override
    public DebugPriority getPriority() {
        return this.priority;
    }

    @Override
    public DebugGroup getGroup() {
        return this.group;
    }

    @Override
    public int getOrdinal() {
        return this.ordinal();
    }

    @Override
    public String getName() {
        return this.name();
    }

    private ClientOpcode(String x0, int x1, DebugPriority x2, DebugGroup x3, Object x4) {
        this(x0, x1, x2, x3);
    }

    static {
        $VALUES = new ClientOpcode[]{SHOOT_REQUEST, RELOAD_REQUEST, MACHINE_GUN_RELOAD_REQUEST, MACHINE_GUN_SHOOT_REQUEST, EXTRACT_AMMO_REQUEST, CLAN_INFO_REQUEST, CLAN_RULES_REQUEST, CLAN_MEMBERS_REQUEST, CLAN_LIST_REQUEST, CLAN_CREATE_REQUEST, CLAN_DELETE_REQUEST, CLAN_SET_LEADER_REQUEST, CLAN_INVITE_CLIENT_REQUEST, CLAN_KICK_REQUEST, CLAN_WAR_REQUEST, CLAN_PEACE_OFFER_REQUEST, CLAN_LANDS_REQUEST, CLAN_LEAVE_REQUEST, CLAN_RANK_UP_REQUEST, CLAN_RANK_DOWN_REQUEST, CLAN_PEACE_OFFER_CANCEL_REQUEST, CLAN_CLEAR_RULES_REQUEST, CLAN_ADD_RULES_REQUEST, CLAN_JOIN_REQUEST, CLAN_LAND_RENAME_REQUEST, CLAN_GET_MONEY_REQUEST, CLAN_SYNC_REPUTATION_REQUEST, HANDCUFFS_ANSWER, USE_HEALING_REQUEST, FLASHLIGHT_TOGGLE_REQUEST, RIGHT_CLICK_PLAYER_REQUEST};
    }
}

