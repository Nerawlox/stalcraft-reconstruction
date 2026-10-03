/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.map.render;

import gloomyfolken.bundle.common.core.tupg;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.faction.pidb;
import gloomyfolken.mods.party.kjui;
import gloomyfolken.mods.party.zwat;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import gloomyfolken.mods.stalker.misc.zwaw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import mods.pda.MapNpc;
import mods.pda.PdaMod;
import mods.pda.client.PdaClient;
import mods.pda.client.map.MapSettings;
import mods.pda.client.map.icon.MapIcon;
import mods.pda.client.minimap.MapCanvas;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumRoleType;
import org.lwjgl.util.vector.Vector2f;

public class DefaultMapRenderer
implements MapCanvas.MapRenderer {
    protected boolean drawNpcs = true;
    protected MapSettings settings;
    protected tupg viewerFaction = tupg._a;
    protected boolean showTextIcons = true;

    public DefaultMapRenderer(MapSettings mapSettings) {
        this.settings = mapSettings;
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        if (entityClientPlayerMP != null) {
            this.setViewerFaction(pidb._a(entityClientPlayerMP)._a());
        }
    }

    @Override
    public void drawMapObjects(MapCanvas mapCanvas, float f) {
        tupg tupg2 = this.viewerFaction;
        mapCanvas.drawQuestWaypoints(PdaMod.getClientPda().questWaypoints.values(), PdaMod.instance.quests.getActiveQuest());
        mapCanvas.drawPlayer(Minecraft._E()._t);
        if (mapCanvas.getZoom() <= 8.0f) {
            if (this.settings.showLands && yuch._a != null) {
                mapCanvas.drawLands(yuch._a._q);
            }
            if (this.settings.showSafezones) {
                mapCanvas.drawSavezones(this.settings.savezones, tupg2);
            }
            if (this.settings.showTeleportation) {
                mapCanvas.drawMapIcons(this.settings.icons.get((Object)MapIcon.MapIconType.TELEPORTATION));
            }
            if (mapCanvas.getZoom() <= 2.0f) {
                this.drawNpcs(mapCanvas, PdaMod.getClientPda().npcs.values());
            }
            if (this.settings.showUserWaypoints) {
                mapCanvas.drawWaypoints(PdaMod.getClientPda().waypoints.getWaypointList(), true);
            }
            if (this.settings.showAvailableQuests) {
                this.drawAvailableQuests(mapCanvas);
            }
            this.drawSpottedEntities(mapCanvas, f, StalkerMiscMod._Y._d.values());
            kjui kjui2 = zwat._a;
            if (kjui2 != null && !kjui2._a.isEmpty()) {
                this.drawParty(mapCanvas, new ArrayList<kjui.kjui>(kjui2._a.values()), f);
                mapCanvas.drawWaypoints(kjui2._b, true);
            }
            if (this.showTextIcons) {
                mapCanvas.drawMapIcons(this.settings.icons.get((Object)MapIcon.MapIconType.TEXT));
            }
        }
    }

    @Override
    public void update() {
        kjui kjui2 = zwat._a;
        if (kjui2 != null && !kjui2._a.isEmpty()) {
            for (kjui.kjui kjui3 : kjui2._a.values()) {
                kjui3._b();
            }
        }
    }

    public void drawParty(MapCanvas mapCanvas, List<kjui.kjui> list2, float f) {
        Minecraft._E()._R()._a(iedw._a);
        for (int i = 0; i < list2.size(); ++i) {
            kjui.kjui kjui2 = list2.get(i);
            if (!kjui2._c || kjui2._a.equals(Minecraft._E()._t.username)) continue;
            boolean bl = kjui2._e.x != 0.0f || kjui2._e.y != 0.0f;
            float f2 = 1.0f - jywc._a((float)kjui2._f + 1.0f, (float)kjui2._f, f) / 10.0f;
            float f3 = bl ? jywc._a(kjui2._e.x, kjui2._d.x, f2) : kjui2._d.x;
            float f4 = bl ? jywc._a(kjui2._e.y, kjui2._d.y, f2) : kjui2._d.y;
            Point point = i == 0 ? new Point(149, 796) : new Point(129, 796);
            Dimension dimension = new Dimension(19, 19);
            mapCanvas.drawMapIcon(new Vector2f(f3, f4), point, dimension, () -> (kjui2._a() ? "\u041f\u043e\u0441\u043b\u0435\u0434\u043d\u044f\u044f \u043f\u043e\u0437\u0438\u0446\u0438\u044f " : "") + kjui2._a, -1, false, true);
        }
    }

    public void drawNpcs(MapCanvas mapCanvas, Collection<MapNpc> collection) {
        Minecraft._E()._R()._a(MapNpc.ICON_RES);
        float f = (float)Minecraft._E()._t.posY;
        Dimension dimension = new Dimension(19, 19);
        for (MapNpc mapNpc : collection) {
            Point point;
            if (!this.canBeDrawn(mapNpc) || PdaClient.mapSettings.showAvailableQuests && CustomNpcs.npcQuestAvailability.getOrDefault(mapNpc.entityId, 0) != 0 || (point = mapNpc.getTextureUv()) == null) continue;
            Vector2f vector2f = mapCanvas.drawMapIcon(mapNpc.getLoc(), point, dimension, mapNpc::getDisplayText, mapNpc.getColor(), false, false, 128.0, 128.0);
            Point point2 = new Point(112, 112);
            float f2 = mapNpc.yPos - f;
            mapCanvas.drawHeightIcon(vector2f, point2, mapNpc.getColor(), f2, 4.0f, 3.0f, 128.0f, 128.0f);
        }
    }

    private void drawAvailableQuests(MapCanvas mapCanvas) {
        Map<Integer, Integer> map = CustomNpcs.npcQuestAvailability;
        Minecraft minecraft = Minecraft._E();
        minecraft._R()._a(MapNpc.ICON_RES);
        Dimension dimension = new Dimension(19, 19);
        int n = (int)minecraft._t.posY;
        for (int n2 : map.keySet()) {
            float f;
            float f2;
            float f3;
            int n3 = map.get(n2);
            if (n3 == 0) continue;
            MapNpc mapNpc = PdaMod.getClientPda().npcs.get(n2);
            if (mapNpc != null) {
                f3 = mapNpc.xPos;
                f2 = mapNpc.yPos;
                f = mapNpc.zPos;
            } else {
                Entity entity = minecraft._r.getEntityByID(n2);
                if (!(entity instanceof EntityNPCInterface)) continue;
                f3 = (float)entity.posX;
                f2 = (float)entity.posY;
                f = (float)entity.posZ;
            }
            boolean bl = n3 == 2;
            Point point = PdaClient.NPC_ICONS_POS.get("task");
            int n4 = bl ? -256 : -16711936;
            Vector2f vector2f = mapCanvas.drawMapIcon(f3, f, point, dimension, () -> "\u0414\u043e\u0441\u0442\u0443\u043f\u0435\u043d \u043a\u0432\u0435\u0441\u0442", n4, false, false, 128.0, 128.0);
            mapCanvas.drawHeightIcon(vector2f, new Point(112, 112), n4, f2 - (float)n, 4.0f, 3.0f, 128.0f, 128.0f);
        }
    }

    public void drawSpottedEntities(MapCanvas mapCanvas, float f, Collection<zwaw> collection) {
        long l = 3500L;
        long l2 = System.currentTimeMillis();
        mapCanvas.renderer.bindTexture(oxmc._a);
        for (zwaw zwaw2 : collection) {
            if (l2 - zwaw2._g() > l) continue;
            int n = 0xFF0000;
            float f2 = (float)Math.abs(Math.sin((float)(l2 - zwaw2._h()) / 200.0f)) * 0.3f + 0.7f;
            int n2 = (int)(f2 * 255.0f);
            Point point = new Point(504, 139);
            Dimension dimension = new Dimension(8, 14);
            float f3 = jywc._a(zwaw2._e(), zwaw2._c(), f);
            float f4 = jywc._a(zwaw2._f(), zwaw2._d(), f);
            mapCanvas.drawMapIcon(new Vector2f(f3, f4), point, dimension, () -> "", n |= n2 << 24, false, false, 512.0, 512.0);
        }
    }

    private boolean canBeDrawn(MapNpc mapNpc) {
        if (!this.settings.showAuc && mapNpc.role == EnumRoleType.Auctioneer) {
            return false;
        }
        if (!this.settings.showTraders && mapNpc.role == EnumRoleType.Trader) {
            return false;
        }
        return this.settings.showTransporters || mapNpc.role != EnumRoleType.Postman;
    }

    public boolean isShowTextIcons() {
        return this.showTextIcons;
    }

    public DefaultMapRenderer setShowTextIcons(boolean bl) {
        this.showTextIcons = bl;
        return this;
    }

    public boolean isDrawNpcs() {
        return this.drawNpcs;
    }

    public DefaultMapRenderer setDrawNpcs(boolean bl) {
        this.drawNpcs = bl;
        return this;
    }

    public MapSettings getSettings() {
        return this.settings;
    }

    public DefaultMapRenderer setSettings(MapSettings mapSettings) {
        this.settings = mapSettings;
        return this;
    }

    public tupg getViewerFaction() {
        return this.viewerFaction;
    }

    public DefaultMapRenderer setViewerFaction(tupg tupg2) {
        this.viewerFaction = tupg2;
        return this;
    }
}

