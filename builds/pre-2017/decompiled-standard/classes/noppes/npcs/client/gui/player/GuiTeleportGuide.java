/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.player;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McRect;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.faction.pidb;
import gloomyfolken.mods.stalker.misc.tupg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import mods.pda.client.PdaClient;
import mods.pda.client.component.MapComponent;
import mods.pda.client.component.PdaBackground;
import mods.pda.client.component.PictureButton;
import mods.pda.client.map.icon.MapSavezone;
import mods.pda.client.minimap.MapCanvas;
import net.minecraft.util.ezfc;
import noppes.npcs.packet.PacketGuideTeleportRequest;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

public class GuiTeleportGuide
extends GuiScreenAdvanced
implements MapCanvas.MapRenderer,
zxgf.kjui {
    private final int entityId;
    private final String currentSavezone;
    private final Map<String, Integer> availableSavezones;
    private final int tpBonus;
    private final float discount;
    private int balance = -1;
    private MapComponent map;
    private McLabel balanceLabel;
    private McLabel tpPointsLabel;
    private McButton teleportButton;
    private McLabel warningLabel;
    private String selectedLocation;
    private long selectionTime = -1L;
    private Point bgStart;
    private Dimension bgSize;
    private boolean teleporting = false;
    private int ticksUntilTeleport = -1;
    private boolean showWarning = false;
    private int warningTime = 0;

    public GuiTeleportGuide(int n, Map<String, Integer> map, String string, int n2, float f) {
        super(new GuiRendererBuilder().setTextureSize(1024, 1024).setFontRenderer(ExternalFont.tahoma12).create());
        this.entityId = n;
        this.availableSavezones = map;
        this.currentSavezone = string;
        this.tpBonus = n2;
        this.discount = f;
        new braz().sendToServer();
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        GuiHelper.addBackground(this, Point.zeroPoint, Dimension.zeroDimension, true);
        Point point = new Point(this.screenWidth / 2, this.screenHeight / 2);
        this.bgStart = point.add(-380, -340);
        this.bgSize = new Dimension(760, 680);
        this.addElement(new PdaBackground(this, this.bgStart, this.bgSize, true, true));
        this.addElement(new McRect(this, this.bgStart.add(10, this.bgSize.height - 49), new Dimension(this.bgSize.width - 34, 1), 0x44939393));
        this.initCloseButton();
        this.initMap();
        this.initTitle();
        this.initFunds();
        this.initTeleportButton();
        this.initTpPoints();
        this.initDiscount();
        String string = "\u0412\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0442\u0435 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c\u0441\u044f \u0443\u0441\u043b\u0443\u0433\u0430\u043c\u0438 \u043f\u0440\u043e\u0432\u043e\u0434\u043d\u0438\u043a\u043e\u0432 \u0438\u043c\u0435\u044f \u0442\u043e\u0440\u0433\u043e\u0432\u044b\u0439 \u0440\u044e\u043a\u0437\u0430\u043a!";
        this.warningLabel = new McLabel((IAdvancedGui)this, string, Point.zeroPoint).setFontRenderer(ExternalFont.tahoma14);
        this.addElement(this.warningLabel);
        this.warningLabel.setCentered(point.x, point.y + this.bgSize.height / 2 + 25);
        this.warningLabel.setVisible(false);
        List<String> list = Arrays.asList((Object)((Object)ezfc._o) + "\u0420\u0443\u0431\u043b\u0438 \u0410\u0441\u0441\u043e\u0446\u0438\u0430\u0446\u0438\u0438 \u041f\u0440\u043e\u0432\u043e\u0434\u043d\u0438\u043a\u043e\u0432", "\u041f\u0440\u0438\u043d\u0438\u043c\u0430\u044e\u0442\u0441\u044f \u043f\u0440\u043e\u0432\u043e\u0434\u043d\u0438\u043a\u0430\u043c\u0438 \u043f\u043e \u0432\u0441\u0435\u0439 \u0417\u043e\u043d\u0435 \u0432\u043c\u0435\u0441\u0442\u043e \u043e\u0431\u044b\u0447\u043d\u044b\u0445 \u0440\u0443\u0431\u043b\u0435\u0439");
        if (this.tpPointsLabel != null) {
            this.addElement(new McToolTip((IAdvancedGui)this, list, this.tpPointsLabel));
        }
    }

    private void initTeleportButton() {
        this.teleportButton = GuiHelper.addButton(this, this.bgStart.add(this.bgSize.width - 170, this.bgSize.height - 38 - 3), new Dimension(138, 30), iedw._l, "\u041e\u0442\u043f\u0440\u0430\u0432\u0438\u0442\u044c\u0441\u044f").onClick(guiActionButtonClick -> {
            if (this.teleporting) {
                this.cancelTeleporting();
            } else {
                this.startTeleporting();
            }
        });
        this.teleportButton.setEnabled(false);
        if (this.selectedLocation != null) {
            this.setSelectedLocation(this.selectedLocation);
        }
    }

    private void initCloseButton() {
        this.addElement(new PictureButton((IAdvancedGui)this, iedw._a, this.bgStart.add(this.bgSize.width - 49, 14), new Point(488, 800), new Dimension(13, 13)).setGlColorMouseOver(0x6FFFFFFF).onClick(guiActionButtonClick -> this.closeScreen()));
    }

    private void initDiscount() {
        String string = "\u0421\u043a\u0438\u0434\u043a\u0430: " + (int)(this.discount * 100.0f) + "%";
        String string2 = "\u041f\u0440\u043e\u0432\u043e\u0434\u043d\u0438\u043a\u0438 \u043f\u0440\u0435\u0434\u043e\u0441\u0442\u0430\u0432\u043b\u044f\u044e\u0442 \u0441\u043a\u0438\u0434\u043a\u0443 \u043d\u0430 \u0441\u0432\u043e\u0438 \u0443\u0441\u043b\u0443\u0433\u0438 \u0434\u043b\u044f \u0447\u0430\u0441\u0442\u044b\u0445 \u043a\u043b\u0438\u0435\u043d\u0442\u043e\u0432";
        int n = this.discount > 0.0f ? 0xFFFF00 : 0x939393;
        McLabel mcLabel = new McLabel((IAdvancedGui)this, string, this.bgStart.add(350, this.bgSize.height - 38 - 5), n);
        mcLabel.noMouseInteraction = false;
        mcLabel.setFontRenderer(ExternalFont.tahoma14);
        this.addElement(mcLabel);
        this.addElement(new McToolTip((IAdvancedGui)this, Collections.singletonList(string2), mcLabel));
    }

    private void initTpPoints() {
        if (this.tpBonus > 0) {
            String string = "\u0420\u0410\u041f: " + this.tpBonus;
            this.tpPointsLabel = new McLabel((IAdvancedGui)this, string, this.bgStart.add(200, this.bgSize.height - 38 - 5), 0xFFFF93);
            this.tpPointsLabel.setFontRenderer(ExternalFont.tahoma14);
            this.tpPointsLabel.noMouseInteraction = false;
            this.addElement(this.tpPointsLabel);
        }
    }

    private void initFunds() {
        String string = this.balance < 0 ? "\u0417\u0430\u0433\u0440\u0443\u0437\u043a\u0430..." : this.balance + " \u0440\u0443\u0431.";
        this.balanceLabel = new McLabel((IAdvancedGui)this, "\u0421\u0447\u0451\u0442:" + string, this.bgStart.add(25, this.bgSize.height - 38 - 5), 0x939393).setFontRenderer(ExternalFont.tahoma14);
        this.addElement(this.balanceLabel);
    }

    private void initTitle() {
        String string = null;
        for (MapSavezone mapSavezone : PdaClient.mapSettings.savezones) {
            if (!mapSavezone.getId().equals(this.currentSavezone)) continue;
            string = mapSavezone.getName();
        }
        String string2 = string == null ? "\u041f\u0440\u043e\u0432\u043e\u0434\u043d\u0438\u043a" : "\u041f\u0440\u043e\u0432\u043e\u0434\u043d\u0438\u043a - " + string;
        this.addElement(new McLabel((IAdvancedGui)this, string2, this.bgStart.add(22, 10), 0x939393));
    }

    private void initMap() {
        this.map = new MapComponent(this, this.bgStart.add(10, 42), this.bgSize.add(-35, -95));
        this.addElement(this.map);
        this.map.canvas().setInitialMapCoords(new Vector2f((float)this.field_73882_e._t.field_70165_t, (float)this.field_73882_e._t.field_70161_v));
        this.map.canvas().setZoom(this.map.canvas().getMaxZoom() / 2.0f);
        this.map.canvas().addObjectRenderer(this);
        this.map.init();
    }

    private boolean canTeleportTo(MapSavezone mapSavezone) {
        return this.availableSavezones.containsKey(mapSavezone.getId());
    }

    private void setSelectedLocation(String string) {
        this.selectedLocation = string;
        this.selectionTime = System.currentTimeMillis();
        int n = (int)((float)this.availableSavezones.get(string).intValue() * (1.0f - this.discount));
        int n2 = Math.max(0, n - this.tpBonus);
        this.teleportButton.setEnabled(n2 <= this.balance);
        this.teleportButton.text = "\u041e\u0442\u043f\u0440\u0430\u0432\u0438\u0442\u044c\u0441\u044f (" + n2 + " \u0440\u0443\u0431.)";
        Dimension dimension = new Dimension(this.renderer.getStringWidth(this.teleportButton.text) + 35, 27);
        this.teleportButton.setSize(dimension);
        this.teleportButton.setLocation(this.bgStart.add(this.bgSize.width - dimension.width - 30, this.bgSize.height - 43));
    }

    private void startTeleporting() {
        if (this.hasTradepack()) {
            this.warningTime = 0;
        } else if (!this.teleporting) {
            this.teleporting = true;
            this.ticksUntilTeleport = 100;
        }
    }

    private void cancelTeleporting() {
        if (this.teleporting) {
            this.teleporting = false;
            this.ticksUntilTeleport = 0;
            this.setSelectedLocation(this.selectedLocation);
        }
    }

    private void requestTeleport() {
        if (this.selectedLocation != null) {
            new PacketGuideTeleportRequest(this.entityId, this.selectedLocation).sendToServer();
            this.closeScreen();
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        if (this.showWarning) {
            double d = 0.5 * (double)this.warningTime;
            double d2 = d * Math.exp(1.0 - d) * 0.35 + 0.65;
            this.warningLabel.color = 0xFF000000 | (int)(d2 * 255.0) << 16;
        }
        super.func_73863_a(n, n2, f);
        if (this.teleporting) {
            Dimension dimension = this.teleportButton.getSize();
            Point point = this.teleportButton.getLocation();
            float f2 = ((float)this.ticksUntilTeleport - f) / 100.0f;
            float f3 = (float)(dimension.width - 20) * (1.0f - f2);
            this.renderer.drawRect(point.x, point.y + dimension.height, f3, 2.0, -16711936);
        }
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        ++this.warningTime;
        this.showWarning = this.hasTradepack();
        if (this.showWarning && this.teleporting) {
            this.cancelTeleporting();
        }
        this.warningLabel.setVisible(this.showWarning);
        if (this.teleporting) {
            if (--this.ticksUntilTeleport < 0) {
                this.requestTeleport();
            }
            this.teleportButton.text = "\u041e\u0442\u043c\u0435\u043d\u0430 (" + (this.ticksUntilTeleport / 20 + 1) + " \u0441\u0435\u043a.)";
        }
        if (this.teleporting && --this.ticksUntilTeleport < 0) {
            this.requestTeleport();
        }
    }

    private boolean hasTradepack() {
        return tupg._a(this.field_73882_e._t)._g();
    }

    @Override
    public boolean mouseClicked(MapCanvas mapCanvas, int n, int n2, int n3) {
        List list = PdaClient.mapSettings.savezones.stream().filter(mapSavezone -> this.canTeleportTo((MapSavezone)mapSavezone) && !mapSavezone.getId().equals(this.currentSavezone)).map(mapSavezone -> pzop._a(mapSavezone, mapSavezone.getPos(), Float.valueOf(10.0f))).collect(Collectors.toList());
        MapSavezone mapSavezone2 = (MapSavezone)mapCanvas.findObjectUnderMouse(list, new Point(n, n2));
        if (mapSavezone2 != null) {
            this.setSelectedLocation(mapSavezone2.getId());
            return true;
        }
        return false;
    }

    @Override
    public void drawMapObjects(MapCanvas mapCanvas, float f) {
        gloomyfolken.bundle.common.core.tupg tupg2 = pidb._a(this.field_73882_e._t)._a();
        mapCanvas.drawPlayer(this.field_73882_e._t);
        List<MapSavezone> list = PdaClient.mapSettings.savezones;
        for (MapSavezone mapSavezone : list) {
            mapCanvas.renderer.bindTexture(iedw._a);
            boolean bl = mapSavezone.getId().equals(this.currentSavezone);
            boolean bl2 = this.canTeleportTo(mapSavezone);
            boolean bl3 = mapSavezone.getId().equals(this.selectedLocation);
            int n = bl ? -1 : (bl2 ? mapSavezone.getColor(tupg2) : -7105645);
            String string = (Object)((Object)ezfc._o) + mapSavezone.getName() + "\n";
            if (bl) {
                string = string + "\u0412\u044b \u043d\u0430\u0445\u043e\u0434\u0438\u0442\u0435\u0441\u044c \u0437\u0434\u0435\u0441\u044c";
            } else if (bl2) {
                string = string + this.availableSavezones.get(mapSavezone.getId()) + " \u0440\u0443\u0431.";
                if (!bl3) {
                    string = string + "\n\n\u041d\u0430\u0436\u043c\u0438\u0442\u0435 \u0447\u0442\u043e\u0431\u044b \u0432\u044b\u0431\u0440\u0430\u0442\u044c";
                }
            } else {
                string = string + "\u0421\u0435\u0439\u0447\u0430\u0441 \u043d\u0435\u0434\u043e\u0441\u0442\u0443\u043f\u043d\u043e";
            }
            Vector2f vector2f = mapCanvas.drawMapIcon(mapSavezone.getPos(), MapSavezone.UV, MapSavezone.SIZE, string, n, false, true);
            if (!bl3) continue;
            GL11.glEnable(3042);
            float f2 = 8.5f;
            iedw._a(vector2f.x + (f2 *= zftb._f._a(Math.min(System.currentTimeMillis() - this.selectionTime, 499L), 1.5f, -0.5f, 500.0f)), vector2f.y + f2, 135);
            iedw._a(vector2f.x - f2, vector2f.y - f2, 315);
            iedw._a(vector2f.x - f2, vector2f.y + f2, 225);
            iedw._a(vector2f.x + f2, vector2f.y - f2, 45);
        }
    }

    @Override
    public void setBalance(int n) {
        this.balance = n;
        this.balanceLabel.setText("\u0421\u0447\u0451\u0442: " + this.balance + " \u0440\u0443\u0431.");
    }
}

