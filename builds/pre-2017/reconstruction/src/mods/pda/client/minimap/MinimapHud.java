/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.minimap;

import gloomyfolken.bundle.common.core.tupg;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.faction.pidb;
import gloomyfolken.mods.stalker.mobs.player.MutantPlayerData;
import mods.pda.PdaMod;
import mods.pda.client.PdaClient;
import mods.pda.client.map.MapSettings;
import mods.pda.client.map.render.DefaultMapRenderer;
import mods.pda.client.minimap.MapCanvas;
import mods.pda.client.minimap.MinimapCanvas;
import mods.regions.RegionsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.ForgeSubscribe;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

public class MinimapHud {
    public static final ResourceLocation MINIMAP_BG = new ResourceLocation("pda", "textures/gui/minimap.png");
    private static final double NOISE_F = 0.25;
    private static final double MAX_NOISE_K = Math.pow(500.0, 0.25);
    public final DefaultMapRenderer mapRenderer = new DefaultMapRenderer(PdaClient.mapSettings).setShowTextIcons(false);
    private GuiRenderer renderer = new GuiRendererBuilder().setTextureSize(1024, 1024).setFontRenderer(ExternalFont.tahoma11).setScale(0.5f).create();
    private GuiRenderer bgRenderer = new GuiRendererBuilder().setTextureSize(1024, 256).create();
    public MapCanvas mapCanvas = new MinimapCanvas(this.renderer, new Point(0, 0), new Dimension(200, 200), true);
    private Minecraft mc;
    private long playersCountUpdateTick = 0L;
    private int playersCount = -1;
    private String regionString = "";
    private float compassError = 0.0f;

    public MinimapHud() {
        this.mapCanvas.setInitialMapCoords(new Vector2f(0.0f, 0.0f));
        this.mapCanvas.addObjectRenderer(this.mapRenderer);
        this.mapCanvas.setSize(new Dimension(255, 255));
        this.mapCanvas.playerIconScale = 0.75f;
        this.mapCanvas.setZoom(1.0f);
        this.mc = Minecraft._E();
    }

    @ForgeSubscribe
    public void onClientTick(lnrm.kjui kjui2) {
        if (kjui2._c == lnrm.pidb._a && this.mc._r != null) {
            this.mapCanvas.tick();
            EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
            if (entityClientPlayerMP != null) {
                tupg tupg2 = pidb._a(entityClientPlayerMP)._a();
                this.mapRenderer.setViewerFaction(tupg2);
                this.mapCanvas.setMapCoords(new Vector2f((float)entityClientPlayerMP.posX, (float)entityClientPlayerMP.posZ));
                this.updateMapPage();
            }
            if (this.mc._r.getWorldTime() % 20L == 0L) {
                String string = this.regionString = RegionsMod.regionsClient != null ? RegionsMod.regionsClient.getRegionDisplayString() : "";
            }
            if (ntte._b - this.playersCountUpdateTick > 100L) {
                this.playersCount = -1;
            }
        }
    }

    private void updateMapPage() {
        MapSettings.MapPage mapPage;
        float f = this.mapCanvas.mapCoords.x;
        float f2 = this.mapCanvas.mapCoords.y;
        if (!(this.mapCanvas.mapPage.contains(f, f2) && this.mapCanvas.mapPage.isValid() || this.mapCanvas.mapPage == (mapPage = PdaClient.mapSettings.getPageForCoords(f, f2)) || this.mapCanvas.mapPage != null && !(mapPage.getDistanceSq(f, f2) <= this.mapCanvas.mapPage.getDistanceSq(f, f2)))) {
            this.mapCanvas.setMapPage(mapPage, false);
        }
    }

    public void updatePlayersCount(int n) {
        this.playersCountUpdateTick = ntte._b;
        if (this.playersCount != n && this.playersCount != -1) {
            float f = this.playersCount < n ? 1.0f : 0.7f;
            this.mc._N._a("pda:radar_update", 1.0f, f);
        }
        this.playersCount = n;
    }

    @ForgeSubscribe
    public void onRenderTick(RenderGameOverlayEvent.Post post) {
        if (post.type != RenderGameOverlayEvent.ElementType.ALL || !PdaClient.showMinimap.enabled) {
            return;
        }
        EntityClientPlayerMP entityClientPlayerMP = this.mc._t;
        if (entityClientPlayerMP == null) {
            return;
        }
        this.mapCanvas.mapRotation = PdaClient.mapRotation.enabled;
        Point point = PdaClient.invertedHud.enabled ? new Point(20, 20) : new Point(this.mc._n - 255 - 20, 20);
        this.mapCanvas.setLocation(point);
        this.mapCanvas.drawMap(this.mapCanvas.getLocation().add(125, 125), 1, post.partialTicks);
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        this.drawIndicators(MutantPlayerData.get(entityClientPlayerMP).getSoundSource().getNoiseAmount(), point);
        this.drawFrame();
        this.drawCompass();
        this.drawTime();
        this.drawPlayersAmount();
        this.drawLocationName();
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }

    private void drawIndicators(float f, Point point) {
        float f2 = (float)(Math.pow(f, 0.25) / MAX_NOISE_K);
        Tessellator tessellator = Tessellator.instance;
        GL11.glEnable(3553);
        this.mc._R()._a(MINIMAP_BG);
        tessellator.startDrawing(6);
        float f3 = point.x + 150;
        float f4 = point.y + 165;
        float f5 = 415.0f;
        float f6 = 172.0f;
        float f7 = this.renderer.scale;
        float f8 = 9.765625E-4f;
        float f9 = 0.00390625f;
        tessellator.addVertexWithUV(f3 * f7, f4 * f7, 0.0, f5 * f8, f6 * f9);
        double d = 1.5707963267948966;
        double d2 = 1.5707963267948966 * (double)f2;
        float f10 = 20.0f;
        double d3 = d2 / (double)f10;
        double d4 = d;
        int n = 0;
        while ((float)n < f10) {
            float f11 = 85.0f;
            double d5 = Math.cos(d4) * (double)f11;
            double d6 = Math.sin(d4) * (double)f11;
            tessellator.addVertexWithUV(((double)f3 + d5) * (double)f7, ((double)f4 + d6) * (double)f7, 0.0, ((double)f5 + d5) * (double)f8, ((double)f6 + d6) * (double)f9);
            d4 -= d3;
            ++n;
        }
        tessellator.draw();
    }

    private void drawFrame() {
        this.mc._R()._a(MINIMAP_BG);
        this.bgRenderer.drawTexturedRect(this.mapCanvas.location, new Point(512, 0), new Point(767, 255), this.mapCanvas.size);
    }

    private void drawCompass() {
        this.mc._R()._a(iedw._a);
        Point point = new Point(403, 770);
        Dimension dimension = new Dimension(14, 37);
        Point point2 = this.mapCanvas.location.add(29, 31);
        GL11.glTranslated(point2.x / 2, point2.y / 2, 0.0);
        float f = this.mapCanvas.mapRotation ? -(this.mc._t.rotationYaw + 180.0f) : 0.0f;
        GL11.glRotatef(f += this.getAndUpdateCompassError(), 0.0f, 0.0f, 1.0f);
        this.renderer.drawTexturedRect(new Point(-dimension.width / 2, -dimension.height / 2), point, point.add(dimension.width, dimension.height), dimension);
        GL11.glRotatef(-f, 0.0f, 0.0f, 1.0f);
        GL11.glTranslated(-point2.x / 2, -point2.y / 2, 0.0);
    }

    private float getAndUpdateCompassError() {
        if (PdaMod.isInterfering()) {
            float f = PdaMod.getInterference();
            float f2 = 9.0f;
            this.compassError = (double)f > 0.2 ? (this.compassError += f * f2) : (this.compassError -= f * f2 * 10.0f);
        } else {
            this.compassError = 0.0f;
        }
        return this.compassError;
    }

    private void drawTime() {
        Point point = this.mapCanvas.location.add(13, 215);
        this.renderer.drawString(bqgh._b(this.mc._r.getWorldTime()), point, iedw._e.getRGB());
    }

    private void drawPlayersAmount() {
        Point point = this.mapCanvas.location.add(243, 127);
        this.renderer.drawCenteredString(this.playersCount >= 0 ? String.valueOf(this.playersCount) : "-", point, iedw._e.getRGB());
    }

    private void drawLocationName() {
        String string = qlxw._a;
        if (this.regionString != null && !this.regionString.isEmpty()) {
            string = this.regionString + ", " + string;
        }
        if (string != null) {
            int n = this.renderer.getStringWidth(string);
            Point point = this.mapCanvas.location.add(252 - n, -12);
            this.renderer.renderStringAbsolutePos(string, point.x, point.y, iedw._e.getRGB(), true);
        }
    }

    public static enum MinimapPos {
        TOPLEFT{

            @Override
            public Point getPos(Dimension dimension) {
                return new Point(20, 20);
            }
        }
        ,
        TOPRIGHT{

            @Override
            public Point getPos(Dimension dimension) {
                return new Point(dimension.width - 255 - 20, 20);
            }
        };


        public abstract Point getPos(Dimension var1);
    }
}

