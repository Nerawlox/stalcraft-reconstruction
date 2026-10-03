/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.tab;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import mods.pda.PdaMod;
import mods.pda.client.PdaClient;
import mods.pda.client.component.PictureButton;
import mods.pda.client.map.render.OperatorMapRenderer;
import mods.pda.client.screens.GuiFullMap;
import mods.pda.client.screens.GuiPda;
import mods.pda.client.screens.tab.AbstractMapTab;
import mods.pda.packet.RequestExtraMapData;
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

public class PdaMap
extends AbstractMapTab {
    public PdaMap(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui);
    }

    @Override
    public void requestInformation() {
        super.requestInformation();
        new RequestExtraMapData().sendToServer();
    }

    @Override
    public void init(GuiPda guiPda) {
        super.init(guiPda);
        this.createMap(this.pdaScreenStart.add(10, 35), this.pdaScreen.add(-35, -65), this.mapRenderer, true);
        this.map.canvas().setZoom(PdaClient.mapSettings.savedMapZoom);
        this.map.canvas().addObjectRenderer(new OperatorMapRenderer());
        if (!PdaClient.centerMapPos.enabled && PdaClient.mapSettings.savedMapCoords != null) {
            this.map.canvas().setInitialMapCoords(PdaClient.mapSettings.savedMapCoords);
        } else {
            this.displayPlayerPos();
        }
        this.addPictureButton(this.pdaScreenStart.add(20, this.pdaScreen.height - 72), new Point(394, 834), new Dimension(32, 32), "\u0420\u0430\u0437\u0432\u0435\u0440\u043d\u0443\u0442\u044c", false, guiActionButtonClick -> xpzm._E()._a(new GuiFullMap(this.pda))).setGlColorEnabled(-1259080717).setGlColorMouseOver(-6052957);
        this.addPictureButton(this.pdaScreenStart.add(74, 6), new Point(177, 769), new Dimension(23, 23), "\u041f\u0440\u0438\u0431\u043b\u0438\u0437\u0438\u0442\u044c \u0438 \u0446\u0435\u043d\u0442\u0440\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u043a\u0430\u0440\u0442\u0443 \u043d\u0430 \u0432\u044b\u0431\u0440\u0430\u043d\u043d\u043e\u043c \u043a\u0432\u0435\u0441\u0442\u0435", false, guiActionButtonClick -> this.displayChoosenQuestPos(PdaMod.instance.quests.getActiveQuest()));
        this.addPictureButton(this.pdaScreenStart.add(47, 6), new Point(153, 769), new Dimension(23, 23), "\u041f\u0440\u0438\u0431\u043b\u0438\u0437\u0438\u0442\u044c \u0438 \u0446\u0435\u043d\u0442\u0440\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u043a\u0430\u0440\u0442\u0443 \u043d\u0430 \u0438\u0433\u0440\u043e\u043a\u0435", false, guiActionButtonClick -> this.displayPlayerPos());
        this.addPictureButton(this.pdaScreenStart.add(20, 6), new Point(129, 769), new Dimension(23, 23), "\u041c\u0430\u043a\u0441\u0438\u043c\u0430\u043b\u044c\u043d\u043e \u043e\u0442\u0434\u0430\u043b\u0438\u0442\u044c \u043a\u0430\u0440\u0442\u0443", false, guiActionButtonClick -> this.map.canvas().setZoom(this.map.canvas().getMaxZoom()));
        int n = 0;
        Point point = this.pdaScreenStart.add(this.pdaScreen.width - 40, 9);
        PictureButton pictureButton = this.addPictureButton(point.add(-18 - 21 * n++, 0), new Point(273, 797), new Dimension(23, 18), "\u041e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u043c\u0435\u0442\u043e\u043a", true, guiActionButtonClick -> {
            PdaClient.mapSettings.showUserWaypoints = !PdaClient.mapSettings.showUserWaypoints;
        });
        pictureButton.setActive(PdaClient.mapSettings.showUserWaypoints);
        pictureButton.setSize(new Dimension(19, 19));
        this.addPictureButton(point.add(-19 - 21 * n++, 0), new Point(271, 818), new Dimension(19, 19), "\u041e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u0431\u0430\u0437", true, guiActionButtonClick -> {
            PdaClient.mapSettings.showLands = !PdaClient.mapSettings.showLands;
        }).setActive(PdaClient.mapSettings.showLands);
        this.addPictureButton(point.add(-19 - 21 * n++, 0), new Point(250, 818), new Dimension(19, 19), "\u041e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u0441\u0435\u0439\u0444\u0437\u043e\u043d", true, guiActionButtonClick -> {
            PdaClient.mapSettings.showSafezones = !PdaClient.mapSettings.showSafezones;
        }).setActive(PdaClient.mapSettings.showSafezones);
        this.addPictureButton(point.add(-19 - 21 * n++, 0), new Point(276, 768), new Dimension(19, 19), "\u041e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u043f\u0435\u0440\u0435\u0445\u043e\u0434\u043e\u0432 \u0432 \u043b\u043e\u043a\u0430\u0446\u0438\u0438", true, guiActionButtonClick -> {
            PdaClient.mapSettings.showTeleportation = !PdaClient.mapSettings.showTeleportation;
        }).setTextureSize(new Dimension(19, 21)).setActive(PdaClient.mapSettings.showTeleportation);
        this.addPictureButton(point.add(-19 - 21 * n++, 0), new Point(169, 796), new Dimension(19, 19), "\u041e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u043a\u0443\u0440\u044c\u0435\u0440\u043e\u0432", true, guiActionButtonClick -> {
            PdaClient.mapSettings.showTransporters = !PdaClient.mapSettings.showTransporters;
        }).setActive(PdaClient.mapSettings.showTransporters);
        this.addPictureButton(point.add(-19 - 21 * n++, 0), new Point(209, 796), new Dimension(19, 19), "\u041e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u0430\u0443\u043a\u0446\u0438\u043e\u043d\u0438\u0441\u0442\u043e\u0432", true, guiActionButtonClick -> {
            PdaClient.mapSettings.showAuc = !PdaClient.mapSettings.showAuc;
        }).setActive(PdaClient.mapSettings.showAuc);
        this.addPictureButton(point.add(-19 - 21 * n++, 0), new Point(229, 796), new Dimension(19, 19), "\u041e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u0442\u043e\u0440\u0433\u043e\u0432\u0446\u0435\u0432", true, guiActionButtonClick -> {
            PdaClient.mapSettings.showTraders = !PdaClient.mapSettings.showTraders;
        }).setActive(PdaClient.mapSettings.showTraders);
        this.addPictureButton(point.add(-19 - 21 * n++, 0), new Point(190, 796), new Dimension(19, 19), "\u041e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u041d\u041f\u0421 \u0441 \u0437\u0430\u0434\u0430\u043d\u0438\u044f\u043c\u0438", true, guiActionButtonClick -> {
            PdaClient.mapSettings.showAvailableQuests = !PdaClient.mapSettings.showAvailableQuests;
        }).setActive(PdaClient.mapSettings.showAvailableQuests);
    }

    @Override
    public void keyTyped(char c, int n) {
        super.keyTyped(c, n);
        if (n == PdaMod.mapKeybind._d) {
            this.pda.closeScreen();
        }
    }

    @Override
    public void tick() {
        super.tick();
        PdaClient.mapSettings.savedMapZoom = this.map.canvas().getZoom();
        PdaClient.mapSettings.savedMapCoords = this.map.canvas().getMapCoords();
        this.map.getHorizontalBar().setEnabled(this.map.getEnabled());
        this.map.getVerticalBar().setEnabled(this.map.getEnabled());
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawScreenBackground(this.pdaScreenStart, this.pdaScreen, true);
        GL11.glEnable(3042);
        xpzm._E()._R()._a(iedw._a);
        this.renderer.drawTiledRect(this.pdaScreenStart.add(10, this.pdaScreen.height - 25), new Point(0, 796), new Dimension(this.pdaScreen.width - 35, 17), new Dimension(62, 14), 2);
        super.drawComponent(point, f);
    }
}

