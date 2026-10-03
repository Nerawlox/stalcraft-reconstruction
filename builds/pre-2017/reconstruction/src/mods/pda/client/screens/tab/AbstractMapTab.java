/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.screens.tab;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.IScrollable;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.faction.pidb;
import java.util.Collection;
import mods.pda.PdaMod;
import mods.pda.client.PdaClient;
import mods.pda.client.component.MapComponent;
import mods.pda.client.map.render.DefaultMapRenderer;
import mods.pda.client.minimap.MapCanvas;
import mods.pda.client.screens.tab.AbstractPdaTab;
import mods.pda.client.waypoint.QuestWaypoint;
import net.minecraft.client.Minecraft;
import noppes.npcs.client.pda.PdaQuests;
import org.lwjgl.util.vector.Vector2f;

public abstract class AbstractMapTab
extends AbstractPdaTab {
    protected MapComponent map;
    protected DefaultMapRenderer mapRenderer;

    protected AbstractMapTab(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui);
        PdaMod.getClientPda();
        this.mapRenderer = new DefaultMapRenderer(PdaClient.mapSettings).setViewerFaction(pidb._a(Minecraft._E()._t)._a());
    }

    protected MapComponent createMap(Point point, Dimension dimension, MapCanvas.MapRenderer mapRenderer, boolean bl) {
        this.map = new MapComponent(this.pda, point, dimension, bl);
        this.displayPlayerPos();
        McScrollBar mcScrollBar = new McScrollBar(this.parent, (IScrollable)this.map, McScrollBar.ScrollBarType.VERTICAL, this.pdaScreenStart.add(this.pdaScreen.width - 17, 23), this.pdaScreen.height - 35, iedw._j.getVerticalBarStyle());
        mcScrollBar.setEnableWheelHandling(false);
        this.pda.addElement(mcScrollBar);
        this.map.setVerticalBar(mcScrollBar);
        McScrollBar mcScrollBar2 = new McScrollBar(this.parent, (IScrollable)this.map, McScrollBar.ScrollBarType.HORIZONTAL, point.add(0, dimension.height + 9), dimension.width - 3, iedw._j.getHorizontalBarStyle());
        mcScrollBar2.setEnableWheelHandling(false);
        this.pda.addElement(mcScrollBar2);
        this.map.setHorizontalBar(mcScrollBar2);
        this.map.canvas().addObjectRenderer(mapRenderer);
        this.pda.addElement(this.map);
        this.map.init();
        return this.map;
    }

    protected void displayChoosenQuestPos(int n) {
        Collection<QuestWaypoint> collection = PdaMod.getClientPda().questWaypoints.get(n);
        if (collection.isEmpty()) {
            return;
        }
        QuestWaypoint questWaypoint = collection.iterator().next();
        this.map.canvas().setZoom(1.0f);
        this.map.canvas().setInitialMapCoords(new Vector2f(questWaypoint.worldPos().x, questWaypoint.worldPos().z));
    }

    protected void displayChoosenQuestPos(PdaQuests.ClientQuest clientQuest) {
        if (clientQuest != null) {
            this.displayChoosenQuestPos(clientQuest.getQuestId());
        }
    }

    protected void displayPlayerPos() {
        this.map.canvas().displayPlayerPos();
    }

    public MapComponent getMap() {
        return this.map;
    }
}

