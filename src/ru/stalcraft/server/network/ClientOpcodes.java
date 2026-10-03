/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.server.network;

import ru.stalcraft.network.DebugGroup;
import ru.stalcraft.network.DebugPriority;
import ru.stalcraft.network.IOpcode;

public enum ClientOpcodes implements IOpcode
{
    CONTAMINATIONS("CONTAMINATIONS", 0, DebugPriority.LOW, DebugGroup.CLIENT_DATA, null){}
    ,
    EJECTION_START("EJECTION_START", 1, DebugPriority.MIDDLE, DebugGroup.CLIENT_DATA, null){}
    ,
    EJECTION_END("EJECTION_END", 2, DebugPriority.MIDDLE, DebugGroup.CLIENT_DATA, null){}
    ,
    FORCE_COOLDOWN("FORCE_COOLDOWN", 3, DebugPriority.MIDDLE, DebugGroup.CLIENT_DATA, null){}
    ,
    REPUTATION("REPUTATION", 4, DebugPriority.LOW, DebugGroup.CLIENT_DATA, null){}
    ,
    DEATH_SCORE("DEATH_SCORE", 5, DebugPriority.LOW, DebugGroup.CLIENT_DATA, null){}
    ,
    BACKPACK("BACKPACK", 6, DebugPriority.LOW, DebugGroup.PLAYERS_DATA, null){}
    ,
    FLASHLIGHT("FLASHLIGHT", 7, DebugPriority.LOW, DebugGroup.PLAYERS_DATA, null){}
    ,
    EQUIPPED_WEAPONS("EQUIPPED_WEAPONS", 8, DebugPriority.LOW, DebugGroup.PLAYERS_DATA, null),
    LEASHING("LEASHING", 9, DebugPriority.MIDDLE, DebugGroup.PLAYERS_DATA, null){}
    ,
    HANDCUFFS("HANDCUFFS", 10, DebugPriority.MIDDLE, DebugGroup.PLAYERS_DATA, null){}
    ,
    TAG_LIST("TAG_LIST", 11, DebugPriority.LOW, DebugGroup.PLAYERS_DATA, null){}
    ,
    PLAYER_QUIT("PLAYER_QUIT", 12, DebugPriority.MIDDLE, DebugGroup.PLAYERS_DATA, null){}
    ,
    RELOAD_START("RELOAD_START", 13, DebugPriority.LOW, DebugGroup.WEAPONS, null){}
    ,
    RELOAD_END("RELOAD_END", 14, DebugPriority.LOW, DebugGroup.WEAPONS, null){}
    ,
    SHOOT("SHOOT", 15, DebugPriority.LOW, DebugGroup.WEAPONS, null){}
    ,
    UPDATE_BULLETS("UPDATE_BULLETS", 16, DebugPriority.LOW, DebugGroup.WEAPONS, null){}
    ,
    MACHINEGUN_INFO("MACHINEGUN_INFO", 17, DebugPriority.MIDDLE, DebugGroup.WEAPONS, null){}
    ,
    CLAN_INFO("CLAN_INFO", 18, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    CLAN_ADD_RULES("CLAN_ADD_RULES", 19, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    CLAN_MEMBERS("CLAN_MEMBERS", 20, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    CLAN_LIST("CLAN_LIST", 21, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    CLAN_ADD_ENEMIES("CLAN_ADD_ENEMIES", 22, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    CLAN_GUI_UPDATE("CLAN_GUI_UPDATE", 23, DebugPriority.MIDDLE, DebugGroup.CLANS, null){}
    ,
    CLAN_INVITE_SERVER_REQUEST("CLAN_INVITE_SERVER_REQUEST", 24, DebugPriority.MIDDLE, DebugGroup.CLANS, null){}
    ,
    CLAN_LANDS("CLAN_LANDS", 25, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    CLAN_COMMON_DATA("CLAN_COMMON_DATA", 26, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    CLAN_CLEAR_LANDS("CLAN_CLEAR_LANDS", 27, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    CLAN_CLEAR_ENEMIES("CLAN_CLEAR_ENEMIES", 28, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    CLAN_CLEAR_MEMBERS("CLAN_CLEAR_MEMBERS", 29, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    CLAN_CLEAR_RULES("CLAN_CLEAR_RULES", 30, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    CLAN_CLEAR_LIST("CLAN_CLEAR_LIST", 31, DebugPriority.LOW, DebugGroup.CLANS, null){}
    ,
    HANDCUFFS_SERVER_REQUEST("HANDCUFFS_SERVER_REQUEST", 32, DebugPriority.MIDDLE, DebugGroup.OTHER, null){}
    ,
    ENTITY_POS("ENTITY_POS", 33, DebugPriority.LOW, DebugGroup.OTHER, null){}
    ,
    ADD_VELOCITY("ADD_VELOCITY", 34, DebugPriority.LOW, DebugGroup.OTHER, null){}
    ,
    WINDOW_ID("WINDOW_ID", 35, DebugPriority.LOW, DebugGroup.OTHER, null){}
    ,
    ROTATION("ROTATION", 36, DebugPriority.LOW, DebugGroup.OTHER, null){}
    ,
    TURREL_SHOOT("TURREL_SHOOT", 37, DebugPriority.LOW, DebugGroup.OTHER, null){}
    ,
    TILE_ENTITY_EVENT("TILE_ENTITY_EVENT", 38, DebugPriority.LOW, DebugGroup.ANOMALIES, null){}
    ,
    UPDATE_STALKER_INVENTORY("UPDATE_STALKER_INVENTORY", 39, DebugPriority.LOW, DebugGroup.OTHER, null){}
    ,
    HIT_MARKER_UPDATE("HIT_MARKER_UPDATE", 40, DebugPriority.LOW, DebugGroup.OTHER, null){};

    private final DebugPriority priority;
    private final DebugGroup group;

    private ClientOpcodes(String var1, int var2, DebugPriority priority, DebugGroup group) {
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

    private ClientOpcodes(String x0, int x1, DebugPriority x2, DebugGroup x3, Object x4) {
        this(x0, x1, x2, x3);
    }
}

