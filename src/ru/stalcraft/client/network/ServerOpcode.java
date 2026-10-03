/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
package ru.stalcraft.client.network;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.WeaponInfo;
import ru.stalcraft.client.ClientProxy;
import ru.stalcraft.client.ClientRenderTicker;
import ru.stalcraft.client.ClientWeaponInfo;
import ru.stalcraft.client.clans.GuiClanInvite;
import ru.stalcraft.client.clans.TagData;
import ru.stalcraft.client.ejection.ClientEjection;
import ru.stalcraft.client.gui.GuiHandcuffs;
import ru.stalcraft.client.gui.GuiSettingsStalker;
import ru.stalcraft.client.player.PlayerClientInfo;
import ru.stalcraft.entity.EntityShot;
import ru.stalcraft.entity.EntitySleeve;
import ru.stalcraft.entity.EntityTurrel;
import ru.stalcraft.items.ItemWeapon;
import ru.stalcraft.network.DebugGroup;
import ru.stalcraft.network.DebugPriority;
import ru.stalcraft.network.IOpcodeClient;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.tile.TileEntityMachineGun;

public enum ServerOpcode implements IOpcodeClient
{
    CONTAMINATIONS("CONTAMINATIONS", 0, DebugPriority.LOW, DebugGroup.CLIENT_DATA, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            PlayerUtils.getInfo((uf)atv.w().h).cont.setAttackLevels(new int[]{Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3])});
        }
    }
    ,
    EJECTION_START("EJECTION_START", 1, DebugPriority.MIDDLE, DebugGroup.CLIENT_DATA, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            new ClientEjection(Integer.parseInt(data[0]), Integer.parseInt(data[1])).start();
        }
    }
    ,
    EJECTION_END("EJECTION_END", 2, DebugPriority.MIDDLE, DebugGroup.CLIENT_DATA, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            StalkerMain.getProxy().getEjectionManager().getEjection().end();
        }
    }
    ,
    FORCE_COOLDOWN("FORCE_COOLDOWN", 3, DebugPriority.MIDDLE, DebugGroup.CLIENT_DATA, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            ((PlayerClientInfo)PlayerUtils.getInfo((uf)atv.w().h)).setForceCooldown(Integer.parseInt(data[0]));
        }
    }
    ,
    REPUTATION("REPUTATION", 4, DebugPriority.LOW, DebugGroup.CLIENT_DATA, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            PlayerUtils.getInfo((uf)atv.w().h).setReputation(Integer.parseInt(data[0]));
        }
    }
    ,
    DEATH_SCORE("DEATH_SCORE", 5, DebugPriority.LOW, DebugGroup.CLIENT_DATA, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            PlayerUtils.getInfo((uf)atv.w().h).setDeathScore(Integer.parseInt(data[0]));
        }
    }
    ,
    BACKPACK("BACKPACK", 6, DebugPriority.LOW, DebugGroup.PLAYERS_DATA, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            nn entity = atv.w().f.a(Integer.parseInt(data[0]));
            if (entity != null && entity instanceof uf) {
                uf p2 = (uf)entity;
                PlayerUtils.getInfo(p2).setBackpackId(Integer.parseInt(data[1]));
            }
        }
    }
    ,
    FLASHLIGHT("FLASHLIGHT", 7, DebugPriority.LOW, DebugGroup.PLAYERS_DATA, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            int entityId = Integer.parseInt(data[1]);
            if (atv.w().f.a(entityId) instanceof uf) {
                ((ClientWeaponInfo)PlayerUtils.getInfo((uf)((uf)atv.w().f.a((int)entityId))).weaponInfo).setFlashlightOn(data[0].equals("1"));
            }
        }
    }
    ,
    EQUIPPED_WEAPONS("EQUIPPED_WEAPONS", 8, DebugPriority.LOW, DebugGroup.PLAYERS_DATA, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            int entityId = Integer.parseInt(data[0]);
            if (atv.w().f.a(entityId) instanceof uf) {
                ClientWeaponInfo weaponInfo = (ClientWeaponInfo)PlayerUtils.getInfo((uf)((uf)atv.w().f.a((int)entityId))).weaponInfo;
                ye rifle = new ye(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                by rifleTag = PlayerUtils.getTag(rifle);
                rifleTag.a("flashlight", data[4].equals("1"));
                rifleTag.a("silencer", data[5].equals("1"));
                rifleTag.a("sight", data[6].equals("1"));
                ye pistol = new ye(Integer.parseInt(data[7]), Integer.parseInt(data[8]), Integer.parseInt(data[9]));
                by pistolTag = PlayerUtils.getTag(pistol);
                pistolTag.a("flashlight", data[10].equals("1"));
                pistolTag.a("silencer", data[11].equals("1"));
                pistolTag.a("sight", data[12].equals("1"));
                weaponInfo.setRifle(rifle);
                weaponInfo.setPistol(pistol);
            }
        }
    }
    ,
    LEASHING("LEASHING", 9, DebugPriority.MIDDLE, DebugGroup.PLAYERS_DATA, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            boolean isLeashing = !data[1].equals("0");
            uf player = (uf)atv.w().f.a(Integer.parseInt(data[0]));
            PlayerInfo info = PlayerUtils.getInfo(player);
            if (isLeashing) {
                info.setLeahingPlayer((uf)atv.w().f.a(Integer.parseInt(data[1])));
            } else {
                info.setLeahingPlayer(null);
            }
        }
    }
    ,
    HANDCUFFS("HANDCUFFS", 10, DebugPriority.MIDDLE, DebugGroup.PLAYERS_DATA, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            boolean handcuffs = data[0].equals("1");
            int entityId = Integer.parseInt(data[1]);
            if (atv.w().f.a(entityId) instanceof uf) {
                uf player = (uf)atv.w().f.a(entityId);
                PlayerUtils.getInfo(player).setHandcuffs(handcuffs);
                if (handcuffs && player == atv.w().h && atv.w().n instanceof axv) {
                    atv.w().a((awe)null);
                }
            }
        }
    }
    ,
    TAG_LIST("TAG_LIST", 11, DebugPriority.LOW, DebugGroup.PLAYERS_DATA, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            for (int i2 = 0; i2 < data.length / 4; ++i2) {
                ClientProxy.tags.put(data[i2 * 4], new TagData(Integer.parseInt(data[i2 * 4 + 1]), data[i2 * 4 + 2], data[i2 * 4 + 3].equals("1")));
            }
        }
    }
    ,
    PLAYER_QUIT("PLAYER_QUIT", 12, DebugPriority.MIDDLE, DebugGroup.PLAYERS_DATA, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            nn entity = atv.w().f.a(Integer.parseInt(data[0]));
            if (entity instanceof uf) {
                ((PlayerClientInfo)PlayerUtils.getInfo((uf)((uf)entity))).hasQuitted = true;
            }
        }
    }
    ,
    RELOAD_START("RELOAD_START", 13, DebugPriority.LOW, DebugGroup.WEAPONS, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            of shooter = (of)atv.w().f.a(Integer.parseInt(data[0]));
            ye stack = shooter.aZ();
            if (stack != null && yc.g[stack.d] instanceof ItemWeapon) {
                if (shooter instanceof uf) {
                    PlayerUtils.getInfo((uf)((uf)shooter)).weaponInfo.reloadRequest(stack);
                }
                ((ItemWeapon)yc.g[stack.d]).clientReload(shooter, stack);
            }
        }
    }
    ,
    RELOAD_END("RELOAD_END", 14, DebugPriority.LOW, DebugGroup.WEAPONS, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            nn entity = atv.w().f.a(Integer.parseInt(data[0]));
            if (entity instanceof uf) {
                // empty if block
            }
        }
    }
    ,
    SHOOT("SHOOT", 15, DebugPriority.LOW, DebugGroup.WEAPONS, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            of shooter;
            nn entity = atv.w().f.a(Integer.parseInt(data[0]));
            if (entity instanceof of && (shooter = (of)entity).aZ() != null && shooter.aZ().b() instanceof ItemWeapon) {
                ItemWeapon weapon = (ItemWeapon)shooter.aZ().b();
                weapon.shoot(shooter, shooter.aZ(), false, !PlayerUtils.getTag(shooter.n(0)).n("silencer"));
            }
        }
    }
    ,
    UPDATE_BULLETS("UPDATE_BULLETS", 16, DebugPriority.LOW, DebugGroup.WEAPONS, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
        }
    }
    ,
    MACHINEGUN_INFO("MACHINEGUN_INFO", 17, DebugPriority.MIDDLE, DebugGroup.WEAPONS, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            int x2 = Integer.parseInt(data[1]);
            int y2 = Integer.parseInt(data[2]);
            int z2 = Integer.parseInt(data[3]);
            int entityId = Integer.parseInt(data[4]);
            nn entity = atv.w().f.a(entityId);
            if (data[0].equals("1")) {
                if (entity instanceof uf) {
                    uf tile = (uf)entity;
                    WeaponInfo player = PlayerUtils.getInfo((uf)tile).weaponInfo;
                    if (atv.w().f.r(x2, y2, z2) instanceof TileEntityMachineGun) {
                        TileEntityMachineGun weaponInfo;
                        player.currentGun = weaponInfo = (TileEntityMachineGun)atv.w().f.r(x2, y2, z2);
                        weaponInfo.setShooter(tile);
                    }
                }
            } else {
                asp tile1 = atv.w().f.r(x2, y2, z2);
                if (tile1 instanceof TileEntityMachineGun) {
                    ((TileEntityMachineGun)tile1).setShooter(null);
                }
                if (entity instanceof uf) {
                    uf player1 = (uf)entity;
                    WeaponInfo weaponInfo1 = PlayerUtils.getInfo((uf)player1).weaponInfo;
                    PlayerUtils.getInfo((uf)player1).weaponInfo.currentGun = null;
                }
            }
        }
    }
    ,
    CLAN_INFO("CLAN_INFO", 18, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            ClientProxy.clanData.parseInfo(data);
        }
    }
    ,
    CLAN_ADD_RULES("CLAN_ADD_RULES", 19, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            ClientProxy.clanData.addRules(data[0]);
        }
    }
    ,
    CLAN_MEMBERS("CLAN_MEMBERS", 20, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            ClientProxy.clanData.parseMembers(data);
        }
    }
    ,
    CLAN_LIST("CLAN_LIST", 21, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            ClientProxy.clanData.parseClans(data);
        }
    }
    ,
    CLAN_ADD_ENEMIES("CLAN_ADD_ENEMIES", 22, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            ClientProxy.clanData.parseEnemies(data);
        }
    }
    ,
    CLAN_GUI_UPDATE("CLAN_GUI_UPDATE", 23, DebugPriority.MIDDLE, DebugGroup.CLANS, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            ClientProxy.updateClanGui();
        }
    }
    ,
    CLAN_INVITE_SERVER_REQUEST("CLAN_INVITE_SERVER_REQUEST", 24, DebugPriority.MIDDLE, DebugGroup.CLANS, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            atv.w().a(new GuiClanInvite(data[0], data[1]));
        }
    }
    ,
    CLAN_LANDS("CLAN_LANDS", 25, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            ClientProxy.clanData.parseLands(data);
        }
    }
    ,
    CLAN_COMMON_DATA("CLAN_COMMON_DATA", 26, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            ClientProxy.clanData.parseCommonData(data);
        }
    }
    ,
    CLAN_CLEAR_LANDS("CLAN_CLEAR_LANDS", 27, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            ClientProxy.clanData.clearLands();
        }
    }
    ,
    CLAN_CLEAR_ENEMIES("CLAN_CLEAR_ENEMIES", 28, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            ClientProxy.clanData.clearEnemies();
        }
    }
    ,
    CLAN_CLEAR_MEMBERS("CLAN_CLEAR_MEMBERS", 29, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            ClientProxy.clanData.clearMembers();
        }
    }
    ,
    CLAN_CLEAR_RULES("CLAN_CLEAR_RULES", 30, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            ClientProxy.clanData.clearRules();
        }
    }
    ,
    CLAN_CLEAR_LIST("CLAN_CLEAR_LIST", 31, DebugPriority.LOW, DebugGroup.CLANS, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            ClientProxy.clanData.clearClans();
        }
    }
    ,
    HANDCUFFS_SERVER_REQUEST("HANDCUFFS_SERVER_REQUEST", 32, DebugPriority.MIDDLE, DebugGroup.OTHER, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            if (atv.w().f.a(Integer.parseInt(data[0])) != null) {
                atv.w().a(new GuiHandcuffs((uf)atv.w().f.a(Integer.parseInt(data[0]))));
            }
        }
    }
    ,
    ENTITY_POS("ENTITY_POS", 33, DebugPriority.LOW, DebugGroup.OTHER, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            nn entity = atv.w().f.a(Integer.parseInt(data[0]));
            if (entity != null) {
                entity.b(Float.parseFloat(data[1]), Float.parseFloat(data[2]), Float.parseFloat(data[3]));
            }
        }
    }
    ,
    ADD_VELOCITY("ADD_VELOCITY", 34, DebugPriority.LOW, DebugGroup.OTHER, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            atv.w().f.a(Integer.parseInt(data[0])).g(Float.parseFloat(data[1]), Float.parseFloat(data[2]), Float.parseFloat(data[3]));
        }
    }
    ,
    WINDOW_ID("WINDOW_ID", 35, DebugPriority.LOW, DebugGroup.OTHER, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            atv.w().h.bp.d = Integer.parseInt(data[0]);
        }
    }
    ,
    ROTATION("ROTATION", 36, DebugPriority.LOW, DebugGroup.OTHER, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            int entityId = Integer.parseInt(data[0]);
            float yaw = Float.parseFloat(data[1]);
            float pitch = Float.parseFloat(data[2]);
            nn entity = atv.w().f.a(entityId);
            entity.A = yaw;
            entity.B = pitch;
            if (entity instanceof of) {
                ((of)entity).aP = yaw;
            }
        }
    }
    ,
    TURREL_SHOOT("TURREL_SHOOT", 37, DebugPriority.LOW, DebugGroup.OTHER, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            int entityId = Integer.parseInt(data[0]);
            EntityTurrel turrel = (EntityTurrel)atv.w().f.a(entityId);
            turrel.D = Math.max(turrel.minPitch, turrel.D - 3.0f);
            if (GuiSettingsStalker.renderSleeves) {
                atv.w().f.d((nn)new EntitySleeve((abw)atv.w().f, turrel.u, turrel.v + (double)turrel.f(), turrel.w, turrel.A, turrel.B, turrel.getSleeveDistance(), turrel.getSleeveModelName()));
            }
            float xOffset = -ls.a(turrel.A / 180.0f * (float)Math.PI) * turrel.getRotationPointZ();
            float zOffset = ls.b(turrel.A / 180.0f * (float)Math.PI) * turrel.getRotationPointZ();
            atv.w().f.d((nn)new EntityShot((abw)atv.w().f, turrel.u + (double)xOffset, turrel.v + (double)turrel.f(), turrel.w + (double)zOffset, turrel.A, turrel.B, 1.0f, turrel.getLightDistance()));
            turrel.shoot();
        }
    }
    ,
    TILE_ENTITY_EVENT("TILE_ENTITY_EVENT", 38, DebugPriority.LOW, DebugGroup.ANOMALIES, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... data) {
            int x2 = Integer.parseInt(data[0]);
            int y2 = Integer.parseInt(data[1]);
            int z2 = Integer.parseInt(data[2]);
            asp tile = atv.w().f.r(x2, y2, z2);
            tile.b(Integer.parseInt(data[3]), Integer.parseInt(data[4]));
        }
    }
    ,
    UPDATE_STALKER_INVETORY("UPDATE_STALKER_INVETORY", 39, DebugPriority.LOW, DebugGroup.OTHER, null){

        @Override
        @SideOnly(value=Side.CLIENT)
        public void handle(String ... par1) {
            atv.w().h.bp = PlayerUtils.getInfo((uf)atv.w().h).inventoryContainer;
        }
    }
    ,
    HIT_MARKER_UPDATE("HIT_MARKER_UPDATE", 40, DebugPriority.LOW, DebugGroup.OTHER, null){

        @Override
        public void handle(String ... par1) {
            ClientRenderTicker.hitMarker = 8;
        }
    };

    private final DebugPriority priority;
    private final DebugGroup group;
    private static final ServerOpcode[] $VALUES;

    private ServerOpcode(String var1, int var2, DebugPriority priority, DebugGroup group) {
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

    private ServerOpcode(String x0, int x1, DebugPriority x2, DebugGroup x3, Object x4) {
        this(x0, x1, x2, x3);
    }

    static {
        $VALUES = new ServerOpcode[]{CONTAMINATIONS, EJECTION_START, EJECTION_END, FORCE_COOLDOWN, REPUTATION, DEATH_SCORE, BACKPACK, FLASHLIGHT, EQUIPPED_WEAPONS, LEASHING, HANDCUFFS, TAG_LIST, PLAYER_QUIT, RELOAD_START, RELOAD_END, SHOOT, UPDATE_BULLETS, MACHINEGUN_INFO, CLAN_INFO, CLAN_ADD_RULES, CLAN_MEMBERS, CLAN_LIST, CLAN_ADD_ENEMIES, CLAN_GUI_UPDATE, CLAN_INVITE_SERVER_REQUEST, CLAN_LANDS, CLAN_COMMON_DATA, CLAN_CLEAR_LANDS, CLAN_CLEAR_ENEMIES, CLAN_CLEAR_MEMBERS, CLAN_CLEAR_RULES, CLAN_CLEAR_LIST, HANDCUFFS_SERVER_REQUEST, ENTITY_POS, ADD_VELOCITY, WINDOW_ID, ROTATION, TURREL_SHOOT, TILE_ENTITY_EVENT};
    }
}

