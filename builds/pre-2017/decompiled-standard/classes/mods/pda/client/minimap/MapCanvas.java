/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.minimap;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import gloomyfolken.bundle.common.core.tupg;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.ScissorHelper;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.effects.client.main.jxtc;
import gloomyfolken.mods.party.pidb;
import gloomyfolken.mods.party.zwat;
import java.time.format.TextStyle;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import mods.pda.PdaMod;
import mods.pda.client.PdaClient;
import mods.pda.client.map.MapInitEvent;
import mods.pda.client.map.MapSettings;
import mods.pda.client.map.icon.MapIcon;
import mods.pda.client.map.icon.MapSavezone;
import mods.pda.client.waypoint.DeathWaypoint;
import mods.pda.client.waypoint.MapWaypoint;
import mods.pda.client.waypoint.QuestWaypoint;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ezfc;
import net.minecraft.util.sajh;
import net.minecraftforge.common.MinecraftForge;
import noppes.npcs.QuestLogUnit;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class MapCanvas {
    public static final int REGION_SIZE = 512;
    public static final float BLOCK_TO_PIXEL = 1.0f;
    public static final float MIN_ZOOM = 0.5f;
    public static final ResourceLocation regionsDir = new ResourceLocation("pda", "map/");
    private static final Vector2f world2MapTemp = new Vector2f();
    private static final Table<Integer, Integer, ResourceLocation> MAP_TEX = HashBasedTable.create();
    public MapSettings.MapPage mapPage;
    private Dimension mapSize;
    public static boolean DEBUG = false;
    public Vector2f prevMapCoords = new Vector2f(0.0f, 0.0f);
    public Vector2f interMapCoords = new Vector2f(0.0f, 0.0f);
    public Vector2f mapCoords = new Vector2f(0.0f, 0.0f);
    public Vector2f newMapCoords = new Vector2f(0.0f, 0.0f);
    protected Consumer<Vector2f> onCoordsChange = null;
    protected float zoom = 1.0f;
    public Vector2f mapCenter = new Vector2f();
    protected Set<MapRenderer> mapRenderers = new HashSet<MapRenderer>();
    protected Point location;
    protected Dimension size;
    private String mapName;
    public GuiRenderer renderer;
    protected boolean boundsRestriction = true;
    protected boolean mapRotation = false;
    public String pendingTooltip;
    public float playerIconScale = 1.0f;
    public Vector2f cursorPos = new Vector2f();

    public MapCanvas(String string, GuiRenderer guiRenderer, Point point, Dimension dimension) {
        this.mapName = string;
        this.renderer = guiRenderer;
        this.location = point;
        this.size = dimension;
        this.mapCenter = point.add(dimension.width / 2, dimension.height / 2).toVec();
        MinecraftForge.EVENT_BUS.post(new MapInitEvent(this));
    }

    public Set<MapRenderer> getMapRenderers() {
        return this.mapRenderers;
    }

    public String getMapName() {
        return this.mapName;
    }

    public void drawMap(Point point, int n, float f) {
        this.interMapCoords = this.lerpMapCoords(this.interMapCoords, this.prevMapCoords, this.mapCoords, f);
        this.mapCenter.x = point.x;
        this.mapCenter.y = point.y;
        float f2 = this.interMapCoords.x;
        float f3 = this.interMapCoords.y;
        int n2 = (int)(f2 / 512.0f);
        int n3 = (int)(f3 / 512.0f);
        float f4 = 1.0f / this.zoom;
        float f5 = -(f2 % 512.0f) * 1.0f;
        float f6 = -(f3 % 512.0f) * 1.0f;
        this.drawMap(n2, n3, f5, f6, point, f, f4, n);
    }

    public void tick() {
        this.prevMapCoords = new Vector2f(this.mapCoords);
        if (this.mapCoords.x != this.newMapCoords.x || this.mapCoords.y != this.newMapCoords.y) {
            this.mapCoords = new Vector2f(this.newMapCoords);
            if (this.onCoordsChange != null) {
                this.onCoordsChange.accept(this.mapCoords);
            }
        }
        this.mapRenderers.forEach(MapRenderer::update);
    }

    protected Vector2f lerpMapCoords(Vector2f vector2f, Vector2f vector2f2, Vector2f vector2f3, float f) {
        vector2f.x = jywc._a(vector2f2.x, vector2f3.x, f);
        vector2f.y = jywc._a(vector2f2.y, vector2f3.y, f);
        return vector2f;
    }

    protected void drawMap(int n, int n2, float f, float f2, Point point, float f3, float f4, int n3) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glEnable(3553);
        this.renderer.scaledScissor(this.getLocation(), this.getSize());
        GL11.glScalef(f4, f4, 1.0f);
        GL11.glTranslatef((float)point.x * this.renderer.scale * this.zoom, (float)point.y * this.renderer.scale * this.zoom, 1.0f);
        if (this.mapRotation) {
            GL11.glRotatef(-(xpzm._E()._t.field_70177_z + 180.0f), 0.0f, 0.0f, 1.0f);
        }
        this.drawRegions(n, n2, f, f2, n3);
        GL11.glScalef(this.zoom, this.zoom, 1.0f);
        if (this.mapRotation) {
            GL11.glRotatef(xpzm._E()._t.field_70177_z + 180.0f, 0.0f, 0.0f, 1.0f);
        }
        for (MapRenderer mapRenderer : this.mapRenderers) {
            mapRenderer.drawMapObjects(this, f3);
        }
        ScissorHelper.popScissor();
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }

    protected void drawRegions(int n, int n2, float f, float f2, int n3) {
        int n4 = 512;
        for (int i = n3; i >= -n3 - 1; --i) {
            for (int j = n3; j >= -n3 - 1; --j) {
                this.drawRegion(n + i, n2 + j, f + (float)(n4 * i), f2 + (float)(n4 * j));
            }
        }
    }

    protected void drawRegion(int n, int n2, float f, float f2) {
        if (!this.isValidMapCoord(n, n2)) {
            return;
        }
        if (!this.bindRegionTexture(n, n2)) {
            return;
        }
        qozx._a(f, f2, 512.0, 512.0, 0.0, 0.0, 1024.0, 1024.0, 1024.0, 1024.0);
        if (!this.boundsRestriction) {
            this.drawMapCover(n, n2, f, f2);
        }
        if (DEBUG) {
            ExternalFont.tahoma14.renderString(n + "," + n2, (int)f, (int)f2, 0xFFFFFF);
        }
    }

    private boolean bindRegionTexture(int n, int n2) {
        ResourceLocation resourceLocation = MAP_TEX.get(n, n2);
        if (resourceLocation == null) {
            String string = "r." + n + "." + n2 + ".dds";
            resourceLocation = new ResourceLocation(regionsDir.func_110624_b(), regionsDir.func_110623_a() + string);
            MAP_TEX.put(n, n2, resourceLocation);
        }
        int n3 = (int)(512.0f / (this.zoom * this.renderer.scale));
        fmib._c(resourceLocation)._a((float)(n3 * n3));
        sctg sctg2 = (sctg)xpzm._E()._R()._a.get(resourceLocation);
        if (sctg2 != bsfn._b) {
            GL11.glBindTexture(3553, sctg2.func_110552_b());
            GL11.glTexParameteri(3553, 10240, 9728);
            GL11.glTexParameteri(3553, 10242, 33071);
            GL11.glTexParameteri(3553, 10243, 33071);
            return true;
        }
        return false;
    }

    private void drawMapCover(int n, int n2, float f, float f2) {
        Vector2f vector2f = this.mapPage.getBlocksStart();
        Vector2f vector2f2 = this.mapPage.getBlocksFinish();
        int n3 = n * 512;
        int n4 = n2 * 512;
        boolean bl = (float)n3 < vector2f.x && (float)(n3 + 512) > vector2f.x;
        boolean bl2 = (float)n3 < vector2f2.x && (float)(n3 + 512) > vector2f2.x;
        boolean bl3 = (float)n4 < vector2f.y && (float)(n4 + 512) > vector2f.y;
        boolean bl4 = (float)n4 < vector2f2.y && (float)(n4 + 512) > vector2f2.y;
        Vector2f vector2f3 = this.mapPage.getMapStart();
        Vector2f vector2f4 = this.mapPage.getMapFinish();
        boolean bl5 = (float)n >= vector2f4.x || (float)n < vector2f3.x || (float)n2 >= vector2f4.y || (float)n2 < vector2f3.y;
        jxtc jxtc2 = PdaMod.noiseShader;
        if (jxtc2._g()) {
            jxtc2._e();
            jxtc2._a("time", (float)(System.currentTimeMillis() % 1000000L) * 0.004f);
            jxtc2._a("scale", Math.max(1.0f, this.getZoom() * 0.009f));
        }
        if (!bl5) {
            int n5;
            int n6 = -1;
            if (bl3) {
                this.renderer.drawRect(f * 2.0f, f2 * 2.0f, 1024.0, (vector2f.y - (float)n4) * 2.0f, n6);
            }
            if (bl) {
                this.renderer.drawRect(f * 2.0f, f2 * 2.0f, (vector2f.x - (float)n3) * 2.0f, 1024.0, n6);
            }
            if (bl4) {
                n5 = (int)((float)(n4 + 512) - vector2f2.y);
                this.renderer.drawRect(f * 2.0f, (f2 + (float)(512 - n5)) * 2.0f, 1024.0, n5 * 2, n6);
            }
            if (bl2) {
                n5 = (int)((float)(n3 + 512) - vector2f2.x);
                this.renderer.drawRect((f + (float)(512 - n5)) * 2.0f, f2 * 2.0f, n5 * 2, 1024.0, n6);
            }
        } else {
            this.renderer.drawRect(f * 2.0f, f2 * 2.0f, 1024.0, 1024.0, -65536);
        }
        GL20.glUseProgram(0);
    }

    public Vector2f screenToWorldCoords(Vector2f vector2f) {
        return this.screenToWorldCoords(vector2f, world2MapTemp);
    }

    public Vector2f screenToWorldCoords(Vector2f vector2f, Vector2f vector2f2) {
        vector2f2.x = (-this.mapCenter.x + vector2f.x) * this.renderer.scale * this.zoom;
        vector2f2.y = (-this.mapCenter.y + vector2f.y) * this.renderer.scale * this.zoom;
        return vector2f2;
    }

    public Vector2f worldCoordsToScreen(Vector2f vector2f) {
        return this.worldCoordsToScreen(vector2f, world2MapTemp);
    }

    public Vector2f worldCoordsToScreen(Vector2f vector2f, Vector2f vector2f2) {
        return this.worldCoordsToScreen(vector2f.x, vector2f.y, vector2f2);
    }

    public Vector2f worldCoordsToScreen(float f, float f2) {
        return this.worldCoordsToScreen(f, f2, world2MapTemp);
    }

    public Vector2f worldCoordsToScreen(float f, float f2, Vector2f vector2f) {
        float f3 = (f - this.interMapCoords.x) * 1.0f / this.zoom;
        float f4 = (f2 - this.interMapCoords.y) * 1.0f / this.zoom;
        if (this.mapRotation) {
            double d = Math.toRadians(-(xpzm._E()._t.field_70177_z + 180.0f));
            double d2 = Math.cos(d);
            double d3 = Math.sin(d);
            vector2f.x = (float)((double)f3 * d2 - (double)f4 * d3);
            vector2f.y = (float)((double)f3 * d3 + (double)f4 * d2);
        } else {
            vector2f.x = f3;
            vector2f.y = f4;
        }
        return vector2f;
    }

    public Vector2f worldCoordsToScreenSticky(Vector2f vector2f) {
        return this.worldCoordsToScreenSticky(vector2f.x, vector2f.y);
    }

    public Vector2f worldCoordsToScreenSticky(float f, float f2) {
        Vector2f vector2f = this.worldCoordsToScreen(f, f2);
        float f3 = this.renderer.scale;
        float f4 = (float)(-this.size.width / 2 + 15) * f3;
        float f5 = (float)(this.size.width / 2 - 15) * f3;
        float f6 = (float)(-this.size.height / 2 + 15) * f3;
        float f7 = (float)(this.size.height / 2 - 15) * f3;
        vector2f.x = sajh._a(vector2f.x, f4, f5);
        vector2f.y = sajh._a(vector2f.y, f6, f7);
        return vector2f;
    }

    public boolean worldCoordsVisible(Vector2f vector2f) {
        return this.worldCoordsVisible(vector2f.x, vector2f.y);
    }

    public boolean worldCoordsVisible(float f, float f2) {
        Vector2f vector2f = this.worldCoordsToScreen(f, f2);
        float f3 = this.renderer.scale;
        float f4 = (float)(-this.size.width / 2 + 15) * f3;
        float f5 = (float)(this.size.width / 2 - 15) * f3;
        float f6 = (float)(-this.size.height / 2 + 15) * f3;
        float f7 = (float)(this.size.height / 2 - 15) * f3;
        return vector2f.x > f4 && vector2f.x < f5 && vector2f.y > f6 && vector2f.y < f7;
    }

    public <T> T findObjectUnderMouse(Collection<pzop<T, Vector2f, Float>> collection, Point point) {
        Vector2f vector2f = Vector2f.add(this.screenToWorldCoords(point.toVec()), this.getMapCoords(), null);
        return collection.stream().map(pzop2 -> pzop._a(pzop2._a, Float.valueOf(Vector2f.sub(vector2f, (Vector2f)pzop2._b, null).length()), pzop2._c)).filter(pzop2 -> ((Float)pzop2._b).floatValue() < ((Float)pzop2._c).floatValue() * this.getZoom()).min((pzop2, pzop3) -> Float.compare(((Float)pzop2._b).floatValue(), ((Float)pzop3._b).floatValue())).map(pzop2 -> pzop2._a).orElse(null);
    }

    public void drawPlayer(EntityPlayer entityPlayer) {
        GL11.glEnable(3042);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        float f = xpzm._E()._p._f;
        float f2 = jywc._a((float)entityPlayer.field_70169_q, (float)entityPlayer.field_70165_t, f);
        float f3 = jywc._a((float)entityPlayer.field_70166_s, (float)entityPlayer.field_70161_v, f);
        Vector2f vector2f = this.worldCoordsToScreen(new Vector2f(f2, f3));
        xpzm._E()._R()._a(iedw._a);
        float f4 = this.renderer.scale * this.playerIconScale;
        qozx._a(vector2f.x - 12.0f * f4, vector2f.y - 12.0f * f4, 25.0f * f4, 25.0f * f4, 226.0, 769.0, 251.0, 794.0, 1024.0, 1024.0);
        GL11.glPushMatrix();
        GL11.glTranslatef(vector2f.x, vector2f.y, 0.0f);
        if (!this.mapRotation) {
            GL11.glRotated(entityPlayer.field_70177_z + 180.0f, 0.0, 0.0, 1.0);
        }
        qozx._a(-12.0f * f4, -24.0f * f4, 23.0f * f4, 14.0f * f4, 252.0, 769.0, 275.0, 783.0, 1024.0, 1024.0);
        GL11.glPopMatrix();
        GL11.glDisable(3042);
        this.drawMapTooltip("\u0412\u044b", vector2f.x - 7.0f, vector2f.y - 7.0f, vector2f.x + 7.0f, vector2f.y + 7.0f);
    }

    public void drawQuestWaypoints(Collection<QuestWaypoint> collection, int n) {
        xpzm._E()._R()._a(iedw._a);
        for (QuestWaypoint questWaypoint : collection) {
            if (PdaMod.instance.quests.getHiddenQuests().contains(questWaypoint.getId())) continue;
            boolean bl = questWaypoint.getId() == n;
            Supplier<String> supplier = () -> {
                StringBuilder stringBuilder = new StringBuilder(String.valueOf((Object)ezfc._o)).append(questWaypoint.title());
                if (bl) {
                    Map<Integer, QuestLogUnit> map = PdaMod.getClientPda().questState;
                    QuestLogUnit questLogUnit = map.get(questWaypoint.getId());
                    if (questLogUnit != null && !questLogUnit.getLocalizedStatuses().isEmpty()) {
                        stringBuilder.append("\n").append((Object)ezfc._v).append(String.join((CharSequence)"\n", questLogUnit.getLocalizedStatuses())).append("\n");
                    }
                } else {
                    stringBuilder.append("\n\u041d\u0430\u0436\u043c\u0438\u0442\u0435 \u041f\u041a\u041c \u0447\u0442\u043e\u0431\u044b \u0441\u0434\u0435\u043b\u0430\u0442\u044c \u0430\u043a\u0442\u0438\u0432\u043d\u044b\u043c");
                }
                stringBuilder.append("\n\u041d\u0430\u0436\u043c\u0438\u0442\u0435 \u0434\u0432\u0430\u0436\u0434\u044b \u0447\u0442\u043e\u0431\u044b \u043e\u0442\u043a\u0440\u044b\u0442\u044c \u0432 \u041f\u0414\u0410");
                return stringBuilder.toString();
            };
            boolean bl2 = PdaMod.getClientPda().primaryQuests.contains(questWaypoint.getId());
            boolean bl3 = questWaypoint.hasArea() && this.drawQuestArea(questWaypoint.worldPos().x, questWaypoint.worldPos().z, questWaypoint.getAreaRadius(), supplier, bl2, bl);
            if (bl3) continue;
            this.drawQuestIcon(questWaypoint.worldPos(), questWaypoint.color(), supplier, bl);
        }
    }

    public void drawQuestIcon(Vector3f vector3f, int n, Supplier<String> supplier, boolean bl) {
        Point point = new Point(201, 769);
        Dimension dimension = new Dimension(23, 23);
        Vector2f vector2f = this.drawMapIcon(new Vector2f(vector3f.x, vector3f.z), point, dimension, supplier, n, true, bl);
        float f = vector3f.y - (float)xpzm._E()._t.field_70163_u;
        this.drawHeightIcon(vector2f, new Point(171, 817), n, f, 4.0f, 5.0f, 1024.0f, 1024.0f);
    }

    public boolean drawQuestArea(float f, float f2, float f3, Supplier<String> supplier, boolean bl, boolean bl2) {
        float f4;
        float f5;
        Vector2f vector2f = this.worldCoordsToScreen(f, f2);
        float f6 = f3 * (1.0f / this.zoom);
        if (f6 < 5.0f) {
            return false;
        }
        if (Math.abs(vector2f.x) - f6 >= (float)(this.getSize().width / 4) || Math.abs(vector2f.y) - f6 >= (float)(this.getSize().height / 4)) {
            return false;
        }
        float f7 = vector2f.x;
        float f8 = vector2f.y;
        int n = bl ? -2304 : (bl2 ? -4921096 : -3355444);
        GL11.glPushMatrix();
        GL11.glDisable(3553);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        jxtc jxtc2 = PdaMod.questAreaShader;
        if (jxtc2._g()) {
            jxtc2._e();
            f5 = (float)(this.getLocation().x + this.getSize().width / 2) + f7 * 2.0f;
            f4 = (float)xpzm._E()._o - ((float)this.getLocation().y + (float)this.getSize().height / 2.0f + f8 * 2.0f);
            jxtc2._a("centerPos", f5, f4);
            jxtc2._a("radius", f6 * 2.0f);
            jxtc2._a("gradient", bl2);
        }
        this.renderer.drawRect(f7 * 2.0f - f6 * 2.0f, f8 * 2.0f - f6 * 2.0f, f6 * 4.0f, f6 * 4.0f, n);
        GL20.glUseProgram(0);
        GL11.glEnable(3008);
        GL11.glEnable(3553);
        GL11.glPopMatrix();
        f5 = vector2f.x - (-this.mapCenter.x + this.cursorPos.x) * this.renderer.scale;
        f4 = vector2f.y - (-this.mapCenter.y + this.cursorPos.y) * this.renderer.scale;
        if (Math.sqrt(f5 * f5 + f4 * f4) < (double)f6) {
            this.pendingTooltip = supplier.get();
        }
        return true;
    }

    public void drawHeightIcon(Vector2f vector2f, Point point, int n, float f, float f2, float f3, float f4, float f5) {
        if (Math.abs(f) < 3.0f) {
            return;
        }
        Dimension dimension = new Dimension(16, 16);
        GL11.glEnable(3042);
        GL11.glColor4f((float)(n >> 16 & 0xFF) / 255.0f, (float)(n >> 8 & 0xFF) / 255.0f, (float)(n & 0xFF) / 255.0f, 1.0f);
        boolean bl = f > 0.0f;
        float f6 = bl ? vector2f.x + f2 : vector2f.x - f2;
        float f7 = bl ? vector2f.y - f3 : vector2f.y + f3;
        float f8 = bl ? 180.0f : 0.0f;
        GL11.glTranslatef(f6, f7, 0.0f);
        GL11.glRotatef(f8, 0.0f, 0.0f, 1.0f);
        qozx._a(0.0, 0.0, dimension.width / 2, dimension.height / 2, point.x, point.y, point.x + dimension.width, point.y + dimension.height, f4, f5);
        GL11.glRotatef(-f8, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-f6, -f7, 0.0f);
        GL11.glDisable(3042);
    }

    public void drawLands(Collection<kkzc.kjui> collection) {
        GL11.glEnable(3042);
        Point point = new Point(359, 768);
        xpzm._E()._R()._a(iedw._a);
        for (kkzc.kjui kjui2 : collection) {
            zfdc.kjui kjui3 = kjui2._a;
            Supplier<String> supplier = () -> {
                StringBuilder stringBuilder = new StringBuilder(String.valueOf((Object)ezfc._o)).append(kjui2._a).append("\n").append("\u0412\u043b\u0430\u0434\u0435\u043b\u0435\u0446: ").append(kjui2._i.isEmpty() ? "\u043d\u0435\u0442" : kjui2._i).append("\n");
                if (kjui2._m) {
                    stringBuilder.append("\u0414\u0435\u043d\u044c \u0437\u0430\u0445\u0432\u0430\u0442\u0430: ").append(kjui2._j == null ? "\u0435\u0436\u0435\u0434\u043d\u0435\u0432\u043d\u043e" : kjui2._j.getDisplayName(TextStyle.FULL, new Locale("ru"))).append("\n").append("\u0412\u0440\u0435\u043c\u044f \u0437\u0430\u0445\u0432\u0430\u0442\u0430: ").append(kjui2._k).append("\n").append("\u0414\u043b\u0438\u0442\u0435\u043b\u044c\u043d\u043e\u0441\u0442\u044c \u0437\u0430\u0445\u0432\u0430\u0442\u0430: ").append(kjui2._l.toMinutes()).append(" \u043c\u0438\u043d.\n");
                }
                if (PdaClient.mapSettings.advancedClanLands) {
                    stringBuilder.append("\u0421\u0435\u0440\u0432\u0435\u0440: ").append(kjui2._c).append("\n\u041d\u0430\u0433\u0440\u0430\u0434\u0430: ").append(kjui2._n).append("\n");
                }
                stringBuilder.append("\n\u041d\u0430\u0436\u043c\u0438\u0442\u0435 \u0434\u0432\u0430\u0436\u0434\u044b \u0447\u0442\u043e\u0431\u044b \u043e\u0442\u043a\u0440\u044b\u0442\u044c \u0432 \u041f\u0414\u0410");
                return stringBuilder.toString();
            };
            this.drawMapIcon(new Vector2f(kjui2._a._e, kjui2._a._g), point, new Dimension(29, 29), supplier, kjui2.getColor(), true, false);
        }
    }

    public void drawSavezones(List<MapSavezone> list2, tupg tupg2) {
        this.renderer.bindTexture(iedw._a);
        for (int i = 0; i < list2.size(); ++i) {
            MapSavezone mapSavezone = list2.get(i);
            this.drawMapIcon(mapSavezone.getPos(), MapSavezone.UV, MapSavezone.SIZE, mapSavezone.getName(), mapSavezone.getColor(tupg2), false, false);
        }
    }

    public void drawMapIcons(List<MapIcon> list2) {
        xpzm._E()._R()._a(iedw._a);
        for (int i = 0; i < list2.size(); ++i) {
            MapIcon mapIcon = list2.get(i);
            if (mapIcon.getType().drawIcon) {
                this.drawMapIcon(mapIcon.getLoc(), mapIcon.getType().uv, mapIcon.getType().size, mapIcon::getDisplayedString, -1, false, false);
                continue;
            }
            Vector2f vector2f = this.worldCoordsToScreen(mapIcon.getLoc());
            ExternalFont externalFont = ExternalFont.tahoma11;
            externalFont.drawCenteredString(mapIcon.getDisplayedString(), vector2f.x, vector2f.y, -1, true);
        }
    }

    public void drawWaypoints(Collection<? extends MapWaypoint> collection, boolean bl) {
        xpzm._E()._R()._a(iedw._a);
        for (MapWaypoint mapWaypoint : collection) {
            GL11.glEnable(3042);
            if (bl && !mapWaypoint.enabled()) continue;
            Supplier<String> supplier = () -> {
                String string;
                String string2 = string = !mapWaypoint.title().isEmpty() ? (Object)((Object)ezfc._o) + mapWaypoint.title() + "\n" : "";
                if (!(mapWaypoint instanceof pidb) || zwat._a(((pidb)mapWaypoint)._a)) {
                    string = string + "\u041d\u0430\u0436\u043c\u0438\u0442\u0435 \u0434\u0432\u0430\u0436\u0434\u044b \u0447\u0442\u043e\u0431\u044b \u0443\u0434\u0430\u043b\u0438\u0442\u044c";
                }
                return string;
            };
            this.drawMapIcon(mapWaypoint.worldPos().x, mapWaypoint.worldPos().z, mapWaypoint.uv(), mapWaypoint.size(), supplier, mapWaypoint.color(), true, mapWaypoint instanceof DeathWaypoint, 1024.0, 1024.0);
            GL11.glDisable(3042);
        }
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
    }

    public Vector2f drawMapIcon(Vector2f vector2f, Point point, Dimension dimension, String string, int n, boolean bl, boolean bl2) {
        return this.drawMapIcon(vector2f, point, dimension, () -> string, n, bl, bl2);
    }

    public Vector2f drawMapIcon(Vector2f vector2f, Point point, Dimension dimension, Supplier<String> supplier, int n, boolean bl, boolean bl2) {
        return this.drawMapIcon(vector2f, point, dimension, supplier, n, bl, bl2, 1024.0, 1024.0);
    }

    public Vector2f drawMapIcon(Vector2f vector2f, Point point, Dimension dimension, Supplier<String> supplier, int n, boolean bl, boolean bl2, double d, double d2) {
        return this.drawMapIcon(vector2f.x, vector2f.y, point, dimension, supplier, n, bl, bl2, d, d2);
    }

    public Vector2f drawMapIcon(float f, float f2, Point point, Dimension dimension, Supplier<String> supplier, int n, boolean bl, boolean bl2, double d, double d2) {
        GL11.glEnable(3042);
        double d3 = 0.8;
        boolean bl3 = bl2 && !this.worldCoordsVisible(f, f2);
        Vector2f vector2f = bl2 ? this.worldCoordsToScreenSticky(f, f2) : this.worldCoordsToScreen(f, f2);
        Dimension dimension2 = bl3 ? new Dimension((int)((double)dimension.width * d3), (int)((double)dimension.height * d3)) : dimension;
        float f3 = dimension2.width / 2;
        float f4 = dimension2.height / 2;
        float f5 = 1.0f;
        float f6 = this.renderer.scale;
        f5 = !bl3 && bl && this.isMapUnderCursor(vector2f.x - f3 / 2.0f, vector2f.y - f4 / 2.0f, vector2f.x + f3 / 2.0f, vector2f.y + f4 / 2.0f) ? (f5 *= 0.5f) : (f5 *= (float)(n >> 24 & 0xFF) / 255.0f);
        GL11.glColor4f((float)(n >> 16 & 0xFF) / 255.0f, (float)(n >> 8 & 0xFF) / 255.0f, (float)(n & 0xFF) / 255.0f, f5);
        qozx._a(vector2f.x - f3 * f6, vector2f.y - f4 * f6, (float)dimension2.width * f6, (float)dimension2.height * f6, point.x, point.y, point.x + dimension.width, point.y + dimension.height, d, d2);
        if (!bl3 && supplier != null && this.isMapUnderCursor(vector2f.x - f3 / 2.0f, vector2f.y - f4 / 2.0f, vector2f.x + f3 / 2.0f, vector2f.y + f4 / 2.0f)) {
            this.pendingTooltip = supplier.get();
        }
        GL11.glDisable(3042);
        return vector2f;
    }

    public void drawCircle(float f, float f2, float f3, double d) {
        float f4 = (float)(Math.PI * 2 / (double)f3);
        double d2 = Math.cos(f4);
        double d3 = Math.sin(f4);
        double d4 = d;
        double d5 = 0.0;
        int n = 0;
        while ((float)n < f3 + 1.0f) {
            GL11.glVertex2d(d5 + (double)f, d4 + (double)f2);
            double d6 = d4;
            d4 = d2 * d4 - d3 * d5;
            d5 = d3 * d6 + d2 * d5;
            ++n;
        }
    }

    public void drawMapTooltip(String string, float f, float f2, float f3, float f4) {
        if (this.isMapUnderCursor(f, f2, f3, f4)) {
            this.pendingTooltip = string;
        }
    }

    public boolean isMapUnderCursor(float f, float f2, float f3, float f4) {
        float f5 = (-this.mapCenter.x + this.cursorPos.x) * this.renderer.scale;
        float f6 = (-this.mapCenter.y + this.cursorPos.y) * this.renderer.scale;
        return f5 > f && f5 < f3 && f6 > f2 && f6 < f4;
    }

    protected boolean isValidMapCoord(int n, int n2) {
        return !this.boundsRestriction || (float)n >= this.mapPage.getMapStart().x && (float)n < this.mapPage.getMapStart().x + (float)this.mapSize.width && (float)n2 >= this.mapPage.getMapStart().y && (float)n2 < this.mapPage.getMapStart().y + (float)this.mapSize.height;
    }

    public float getZoom() {
        return this.zoom;
    }

    public void setZoom(float f) {
        this.zoom = sajh._a(f, 0.5f, this.getMaxZoom());
        this.setMapCoords(this.getMapCoords());
    }

    public Vector2f getMapCoords() {
        return this.newMapCoords;
    }

    protected Vector2f getValidMapCoords(Vector2f vector2f) {
        if (!this.boundsRestriction) {
            return vector2f;
        }
        Vector2f vector2f2 = this.getSafeMapStart();
        Vector2f vector2f3 = this.getSafeMapFinish();
        float f = vector2f.x;
        float f2 = vector2f.y;
        if (!(f > vector2f2.x && f < vector2f3.x && f2 > vector2f2.y && f2 < vector2f3.y)) {
            return new Vector2f(sajh._a(vector2f.x, vector2f2.x, vector2f3.x), sajh._a(vector2f.y, vector2f2.y, vector2f3.y));
        }
        return vector2f;
    }

    public void setMapCoords(Vector2f vector2f) {
        this.newMapCoords = this.getValidMapCoords(vector2f);
    }

    public void setInitialMapCoords(Vector2f vector2f) {
        if (this.mapPage == null || !this.mapPage.contains(vector2f.x, vector2f.y)) {
            this.setMapPage(PdaClient.mapSettings.getPageForCoords(vector2f.x, vector2f.y), false);
        }
        this.setMapCoords(vector2f);
        this.mapCoords = this.prevMapCoords = this.newMapCoords;
        if (this.onCoordsChange != null) {
            this.onCoordsChange.accept(this.mapCoords);
        }
    }

    public Vector2f getSafeMapStart() {
        float f = (float)(this.getSize().width / 4) * this.zoom;
        float f2 = (float)(this.getSize().height / 4) * this.zoom;
        return new Vector2f(this.mapPage.getBlocksStart().x + f, this.mapPage.getBlocksStart().y + f2);
    }

    public Vector2f getSafeMapFinish() {
        float f = (float)(this.getSize().width / 4) * this.zoom;
        float f2 = (float)(this.getSize().height / 4) * this.zoom;
        return new Vector2f(this.mapPage.getBlocksFinish().x - f, this.mapPage.getBlocksFinish().y - f2);
    }

    public void addObjectRenderer(MapRenderer mapRenderer) {
        this.mapRenderers.add(mapRenderer);
    }

    public void removeObjectRenderer(MapRenderer mapRenderer) {
        this.mapRenderers.remove(mapRenderer);
    }

    public void setMapPage(MapSettings.MapPage mapPage, boolean bl) {
        this.mapPage = mapPage;
        this.mapSize = new Dimension((int)(mapPage.getMapFinish().x - mapPage.getMapStart().x), (int)(mapPage.getMapFinish().y - mapPage.getMapStart().y));
        if (bl && !this.mapPage.contains(this.mapCoords.x, this.mapCoords.y)) {
            float f = this.mapPage.getBlocksStart().x + (this.mapPage.getBlocksFinish().x - this.mapPage.getBlocksStart().x) / 2.0f;
            float f2 = this.mapPage.getBlocksStart().y + (this.mapPage.getBlocksFinish().y - this.mapPage.getBlocksStart().y) / 2.0f;
            this.setMapCoords(new Vector2f(f, f2));
        }
    }

    public float getMaxZoom() {
        return (this.mapPage.getBlocksFinish().x - this.mapPage.getBlocksStart().x) * 2.0f / (float)this.getSize().width;
    }

    public Point getLocation() {
        return this.location;
    }

    public MapCanvas setLocation(Point point) {
        this.location = point;
        return this;
    }

    public Consumer<Vector2f> getOnCoordsChange() {
        return this.onCoordsChange;
    }

    public MapCanvas setOnCoordsChange(Consumer<Vector2f> consumer) {
        this.onCoordsChange = consumer;
        return this;
    }

    public Dimension getSize() {
        return this.size;
    }

    public MapCanvas setSize(Dimension dimension) {
        this.size = dimension;
        return this;
    }

    public void displayPlayerPos() {
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        this.setInitialMapCoords(new Vector2f((float)entityClientPlayerMP.field_70165_t, (float)entityClientPlayerMP.field_70161_v));
    }

    public boolean isMapRotation() {
        return this.mapRotation;
    }

    public boolean isBoundsRestriction() {
        return this.boundsRestriction;
    }

    public void setBoundsRestriction(boolean bl) {
        this.boundsRestriction = bl;
    }

    public static interface MapRenderer {
        default public boolean mouseClicked(MapCanvas mapCanvas, int n, int n2, int n3) {
            return false;
        }

        public void drawMapObjects(MapCanvas var1, float var2);

        default public void update() {
        }
    }
}

