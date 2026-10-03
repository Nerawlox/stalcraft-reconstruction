/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.font.SdfFont;
import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.main.qlgf;
import gloomyfolken.mods.effects.client.mcsa.ezfa;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import gloomyfolken.mods.party.pidb;
import gloomyfolken.mods.party.zwat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import mods.pda.PdaMod;
import mods.pda.client.PdaClient;
import mods.pda.client.waypoint.DeathWaypoint;
import mods.pda.client.waypoint.MapWaypoint;
import mods.pda.client.waypoint.QuestWaypoint;
import mods.pda.client.waypoint.UserWaypoint;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ofbx;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.ForgeSubscribe;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class WaypointsRender {
    private static qlgf<WaypointEntry> pool = new qlgf<WaypointEntry>(() -> new WaypointEntry());
    private static final DecimalFormat distanceFormat = new DecimalFormat("0.00");
    private static final ResourceLocation WAYPOINTS = new ResourceLocation("pda", "textures/waypoint/waypoints.png");
    private static final Dimension WAYPOINTS_RESOLUTION = new Dimension(512, 512);
    private static final SimpleDateFormat deathTimeFormat = new SimpleDateFormat("MM-dd HH:mm");
    private double farDistance = 1.0;

    @ForgeSubscribe
    public void onWorldRender(RenderWorldLastEvent renderWorldLastEvent) {
        this.farDistance = xpzm._E()._M.ofRenderDistanceFine;
        if (!PdaClient.showWaypointsWorld.enabled) {
            return;
        }
        this.drawUserWaypoints();
        this.drawPartyWaypoints();
        if (PdaClient.showQuestWaypointsWorld.enabled) {
            this.drawQuestWaypoints();
        }
    }

    private void drawPartyWaypoints() {
        if (zwat._a != null) {
            for (pidb pidb2 : zwat._a._b) {
                this.renderWaypoint(pidb2);
            }
        }
    }

    private void drawUserWaypoints() {
        for (MapWaypoint mapWaypoint : PdaMod.getClientPda().waypoints.getWaypointList()) {
            if (!mapWaypoint.enabled()) continue;
            this.renderWaypoint(mapWaypoint);
        }
    }

    private void drawQuestWaypoints() {
        for (Map.Entry<Integer, Collection<QuestWaypoint>> entry : PdaMod.getClientPda().questWaypoints.asMap().entrySet()) {
            if (PdaMod.instance.quests.getHiddenQuests().contains(entry.getKey())) continue;
            for (QuestWaypoint questWaypoint : entry.getValue()) {
                this.renderWaypoint(questWaypoint);
            }
        }
    }

    private boolean isLookingAt(Vector3f vector3f) {
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        ofbx ofbx2 = entityClientPlayerMP.func_70040_Z();
        ofbx ofbx3 = entityClientPlayerMP.field_70170_p.func_82732_R()._a((double)vector3f.x - entityClientPlayerMP.field_70165_t - 0.5, (double)vector3f.y - (entityClientPlayerMP.field_70163_u + (double)entityClientPlayerMP.func_70047_e()) + 0.5, (double)vector3f.z - entityClientPlayerMP.field_70161_v + 0.5);
        double d = ofbx2._b(ofbx3) / (ofbx2._b() * ofbx3._b());
        double d2 = ofbx3._b();
        double d3 = d2 > this.farDistance ? 0.9999 : 1.0 - 0.05 * (1.0 / Math.max(1.0, d2));
        return Math.abs(d) > d3;
    }

    private void renderWaypoint(MapWaypoint mapWaypoint) {
        boolean bl;
        double d;
        Vector3f vector3f = mapWaypoint.worldPos();
        float f = (float)((double)vector3f.x - gqqu._d - 0.5);
        float f2 = (float)((double)vector3f.y - gqqu._e + 0.5);
        float f3 = (float)((double)vector3f.z - gqqu._f + 0.5);
        double d2 = d = Math.sqrt(f * f + f2 * f2 + f3 * f3);
        if (d > this.farDistance) {
            double d3 = this.farDistance / d;
            f = (float)((double)f * d3);
            f2 = (float)((double)f2 * d3);
            f3 = (float)((double)f3 * d3);
            d = this.farDistance;
        }
        float f4 = eidj._a._z;
        double d4 = (d * 0.1 + 0.5) * 0.02666666666666667 * (double)(f4 / 90.0f);
        boolean bl2 = this.isLookingAt(vector3f);
        boolean bl3 = PdaClient.onlyHoveredWaypointTitles.enabled;
        boolean bl4 = bl = !bl3 || bl2;
        String string = mapWaypoint instanceof DeathWaypoint ? "\u0421\u043c\u0435\u0440\u0442\u044c " + this.formatRelativeTime(((UserWaypoint)mapWaypoint).getTime()) : (!mapWaypoint.title().isEmpty() ? "[" + mapWaypoint.title() + " " + distanceFormat.format(d2) + "m]" : "[" + distanceFormat.format(d2) + "m]");
        Point point = mapWaypoint.worldUv();
        Dimension dimension = mapWaypoint.size();
        Dimension dimension2 = mapWaypoint.worldSize();
        int n = mapWaypoint.color();
        WaypointsRender.drawIconWorld(new Vector3f(f, f2, f3), string, d4, WAYPOINTS, point, dimension2, dimension, WAYPOINTS_RESOLUTION, n, bl, bl3 && bl2);
    }

    private String formatRelativeTime(long l) {
        long l2 = System.currentTimeMillis();
        String string = bqgh._e(l2 - l);
        if (string != null) {
            return string;
        }
        return deathTimeFormat.format(new Date(l));
    }

    private static void drawIconWorld(Vector3f vector3f, String string, double d, ResourceLocation resourceLocation, Point point, Dimension dimension, Dimension dimension2, Dimension dimension3, int n, boolean bl, boolean bl2) {
        xpzm xpzm2 = xpzm._E();
        float f = (float)Math.min(1.0, Math.sqrt(vector3f.x * vector3f.x + vector3f.y * vector3f.y + vector3f.z * vector3f.z) / 2.0);
        GL11.glPushMatrix();
        GL11.glTranslated(vector3f.x, vector3f.y, vector3f.z);
        GL11.glRotatef(-gqqu._b._l, 0.0f, 1.0f, 0.0f);
        float f2 = xpzm2._M.field_74320_O == 2 ? -1.0f : 1.0f;
        GL11.glRotatef(gqqu._b._m * f2, 1.0f, 0.0f, 0.0f);
        GL11.glScaled(-d, -d, d);
        ezfc._a();
        ezfc._d();
        WaypointEntry waypointEntry = pool._a();
        waypointEntry.tex = resourceLocation;
        waypointEntry.color = n;
        waypointEntry.alpha = f;
        waypointEntry.disableDepthCheck = bl2;
        waypointEntry.uv = point;
        waypointEntry.size = dimension2;
        waypointEntry.texSize = dimension;
        waypointEntry.resourceResolution = dimension3;
        waypointEntry.title = string;
        waypointEntry.alpha = f;
        waypointEntry.showTitle = bl;
        waypointEntry.load();
        ezfa._a._b.add(waypointEntry);
        ezfc._b();
        GL11.glPopMatrix();
    }

    private static void drawIcon(ResourceLocation resourceLocation, int n, float f, boolean bl, Point point, Dimension dimension, Dimension dimension2, Dimension dimension3) {
        float f2 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n & 0xFF) / 255.0f;
        xpzm._E()._R()._a(resourceLocation);
        if (!bl) {
            GL11.glDisable(2929);
            GL11.glDepthMask(false);
            GL11.glColor4f(f2, f3, f4, 0.4f * f);
            qozx._a(-dimension.width / 2, -dimension.height / 2, dimension.width, dimension.height, point.x, point.y, point.x + dimension2.width, point.y + dimension2.height, dimension3.width, dimension3.height);
            GL11.glEnable(2929);
            GL11.glDepthMask(true);
        } else {
            GL11.glDisable(2929);
            GL11.glDepthMask(false);
        }
        GL11.glColor4f(f2, f3, f4, f);
        qozx._a(-dimension.width / 2, -dimension.height / 2, dimension.width, dimension.height, point.x, point.y, point.x + dimension2.width, point.y + dimension2.height, dimension3.width, dimension3.height);
    }

    private static void drawTitle(String string, float f, int n, boolean bl) {
        int n2 = (int)(SdfFont.tahoma.getStringWidth(string, 12.0f) / 2.0f);
        int n3 = (int)(255.0f * f);
        if (bl) {
            qozx._b(-n2, -4 - n, n2 + 4, 10 - n, (int)((float)n3 * 0.4f) << 24);
            GL11.glDisable(2929);
        } else {
            GL11.glEnable(2929);
        }
        GL11.glDepthMask(false);
        SdfFont.tahoma.renderCenteredString(0.0f, -n - 5, string, 0xFFFFFF + (n3 << 24), true, 12.0f, SdfFont.FontWeight.Normal.INSTANCE);
    }

    private static class WaypointEntry
    extends qlgf.kjui {
        private String title;
        private ResourceLocation tex;
        private Point uv;
        private Dimension texSize;
        private Dimension size;
        private Dimension resourceResolution;
        private int color;
        private boolean showTitle;
        boolean disableDepthCheck;
        private float alpha;

        private WaypointEntry() {
        }

        @Override
        protected void render(float f) {
            GL11.glPushMatrix();
            ezfc._a();
            ezfc._a(this.modelView);
            ezfc._e();
            GL11.glEnable(3042);
            GL11.glDisable(2896);
            GL11.glBlendFunc(770, 771);
            GL11.glEnable(3553);
            WaypointsRender.drawIcon(this.tex, this.color, this.alpha, this.disableDepthCheck, this.uv, this.size, this.texSize, this.resourceResolution);
            if (this.showTitle) {
                WaypointsRender.drawTitle(this.title, this.alpha, this.size.height, this.disableDepthCheck);
            }
            GL11.glEnable(2929);
            GL11.glDepthMask(true);
            GL11.glDisable(3042);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glEnable(2896);
            ezfc._b();
            GL11.glPopMatrix();
        }

        @Override
        protected boolean isSolid() {
            return false;
        }
    }
}

