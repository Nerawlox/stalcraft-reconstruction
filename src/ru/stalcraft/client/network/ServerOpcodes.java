/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client.network;

import ru.stalcraft.network.DebugGroup;
import ru.stalcraft.network.DebugPriority;
import ru.stalcraft.network.IOpcode;

public enum ServerOpcodes implements IOpcode
{
    SHOOT_REQUEST("SHOOT_REQUEST", 0, DebugPriority.LOW, DebugGroup.WEAPONS, null){}
    ,
    RELOAD_REQUEST("RELOAD_REQUEST", 1, DebugPriority.LOW, DebugGroup.WEAPONS, null){}
    ,
    MACHINE_GUN_RELOAD_REQUEST("MACHINE_GUN_RELOAD_REQUEST", 2, DebugPriority.MIDDLE, DebugGroup.WEAPONS, null){}
    ,
    MACHINE_GUN_SHOOT_REQUEST("MACHINE_GUN_SHOOT_REQUEST", 3, DebugPriority.MIDDLE, DebugGroup.WEAPONS, null){}
    ,
    EXTRACT_AMMO_REQUEST("EXTRACT_AMMO_REQUEST", 4, DebugPriority.HIGH, DebugGroup.WEAPONS, null){}
    ,
    CLAN_INFO_REQUEST("CLAN_INFO_REQUEST", 5, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    CLAN_RULES_REQUEST("CLAN_RULES_REQUEST", 6, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    CLAN_MEMBERS_REQUEST("CLAN_MEMBERS_REQUEST", 7, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    CLAN_LIST_REQUEST("CLAN_LIST_REQUEST", 8, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    CLAN_CREATE_REQUEST("CLAN_CREATE_REQUEST", 9, DebugPriority.HIGH, DebugGroup.CLANS, null){}
    ,
    CLAN_DELETE_REQUEST("CLAN_DELETE_REQUEST", 10, DebugPriority.HIGH, DebugGroup.CLANS, null){}
    ,
    CLAN_SET_LEADER_REQUEST("CLAN_SET_LEADER_REQUEST", 11, DebugPriority.HIGH, DebugGroup.CLANS, null){}
    ,
    CLAN_INVITE_CLIENT_REQUEST("CLAN_INVITE_CLIENT_REQUEST", 12, DebugPriority.MIDDLE, DebugGroup.CLANS, null){}
    ,
    CLAN_KICK_REQUEST("CLAN_KICK_REQUEST", 13, DebugPriority.MIDDLE, DebugGroup.CLANS, null){}
    ,
    CLAN_WAR_REQUEST("CLAN_WAR_REQUEST", 14, DebugPriority.HIGH, DebugGroup.CLANS, null){}
    ,
    CLAN_PEACE_OFFER_REQUEST("CLAN_PEACE_OFFER_REQUEST", 15, DebugPriority.HIGH, DebugGroup.CLANS, null){}
    ,
    CLAN_LANDS_REQUEST("CLAN_LANDS_REQUEST", 16, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    CLAN_LEAVE_REQUEST("CLAN_LEAVE_REQUEST", 17, DebugPriority.MIDDLE, DebugGroup.CLANS, null){}
    ,
    CLAN_RANK_UP_REQUEST("CLAN_RANK_UP_REQUEST", 18, DebugPriority.MIDDLE, DebugGroup.CLANS, null){}
    ,
    CLAN_RANK_DOWN_REQUEST("CLAN_RANK_DOWN_REQUEST", 19, DebugPriority.MIDDLE, DebugGroup.CLANS, null){}
    ,
    CLAN_PEACE_OFFER_CANCEL_REQUEST("CLAN_PEACE_OFFER_CANCEL_REQUEST", 20, DebugPriority.HIGH, DebugGroup.CLANS, null){}
    ,
    CLAN_CLEAR_RULES_REQUEST("CLAN_CLEAR_RULES_REQUEST", 21, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    CLAN_ADD_RULES_REQUEST("CLAN_ADD_RULES_REQUEST", 22, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    CLAN_JOIN_REQUEST("CLAN_JOIN_REQUEST", 23, DebugPriority.MIDDLE, DebugGroup.CLANS, null){}
    ,
    CLAN_LAND_RENAME_REQUEST("CLAN_LAND_RENAME_REQUEST", 24, DebugPriority.MIDDLE, DebugGroup.CLANS, null){}
    ,
    CLAN_GET_MONEY_REQUEST("CLAN_GET_MONEY_REQUEST", 25, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    CLAN_SYNC_REPUTATION_REQUEST("CLAN_SYNC_REPUTATION_REQUEST", 26, DebugPriority.HIGH, DebugGroup.CLANS, null){}
    ,
    HANDCUFFS_ANSWER("HANDCUFFS_ANSWER", 27, DebugPriority.MIDDLE, DebugGroup.OTHER, null){}
    ,
    USE_HEALING_REQUEST("USE_HEALING_REQUEST", 28, DebugPriority.MIDDLE, DebugGroup.OTHER, null){}
    ,
    FLASHLIGHT_TOGGLE_REQUEST("FLASHLIGHT_TOGGLE_REQUEST", 29, DebugPriority.LOW, DebugGroup.OTHER, null){}
    ,
    RIGHT_CLICK_PLAYER_REQUEST("RIGHT_CLICK_PLAYER_REQUEST", 30, DebugPriority.MIDDLE, DebugGroup.OTHER, null){}
    ,
    GUI_OPEN_INVENTORY("GUI_OPEN_INVENTORY", 31, DebugPriority.MIDDLE, DebugGroup.OTHER, null){}
    ,
    RIGHT_CLICK_BLOCK("RIGHT_CLICK_BLOCK", 32, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    WEAPON_FIRE_MODE("WEAPON_FIRE_MODE", 33, DebugPriority.HIGH, DebugGroup.WEAPONS, null){}
    ,
    MACHINE_GUN_SHOOTER("MACHINE_GUN_SHOOTER", 34, DebugPriority.HIGH, DebugGroup.WEAPONS, null){};

    private final DebugPriority priority;
    private final DebugGroup group;

    private ServerOpcodes(String var1, int var2, DebugPriority priority, DebugGroup group) {
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

    private ServerOpcodes(String x0, int x1, DebugPriority x2, DebugGroup x3, Object x4) {
        this(x0, x1, x2, x3);
    }
}

