/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.screens;

import gloomyfolken.bundle.common.core.tupg;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McToolTip;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.faction.pidb;
import java.util.Collections;
import mods.pda.PdaMod;
import mods.pda.client.PdaClient;
import mods.pda.client.component.MapComponent;
import mods.pda.client.component.PictureButton;
import mods.pda.client.map.render.DefaultMapRenderer;
import mods.pda.client.map.render.OperatorMapRenderer;
import mods.pda.client.screens.GuiPda;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;

public class GuiFullMap
extends GuiScreenAdvanced
implements owwh {
    private MapComponent map;

    public GuiFullMap(gqjz gqjz2) {
        super(new GuiRendererBuilder().setTextureSize(1024, 1024).setFontRenderer(ExternalFont.tahoma12).create(), 0, 0, gqjz2);
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        tupg tupg2 = pidb._a(entityClientPlayerMP)._a();
        this.map = new MapComponent(this, Point.zeroPoint, new Dimension(this.screenWidth, this.screenHeight), true);
        if (PdaClient.mapSettings.savedMapCoords != null) {
            this.map.canvas().setInitialMapCoords(PdaClient.mapSettings.savedMapCoords);
        } else {
            this.map.canvas().setInitialMapCoords(new Vector2f((float)entityClientPlayerMP.field_70165_t, (float)entityClientPlayerMP.field_70161_v));
        }
        this.map.canvas().addObjectRenderer(new DefaultMapRenderer(PdaClient.mapSettings).setViewerFaction(tupg2));
        this.map.canvas().addObjectRenderer(new OperatorMapRenderer());
        this.map.canvas().setZoom(PdaClient.mapSettings.savedMapZoom);
        this.addElement(this.map);
        this.map.init();
        McButton mcButton = new PictureButton((IAdvancedGui)this, iedw._a, new Point(20, this.screenHeight - 52), new Point(394, 834), new Dimension(32, 32)).setGlColorEnabled(-1259080717).setGlColorMouseOver(-6052957).onClick(guiActionButtonClick -> this.closeScreen());
        this.addElement(mcButton);
        this.addElement(new McToolTip((IAdvancedGui)this, Collections.singletonList("\u0421\u0432\u0435\u0440\u043d\u0443\u0442\u044c"), mcButton));
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        if (PdaMod.isInterfering()) {
            GuiPda.drawInterferenceOverlay(this.renderer.scale, 0.0f, 0.0f, this.screenWidth, this.screenHeight, 1.0f, false);
        }
    }

    @Override
    protected void func_73869_a(char c, int n) {
        super.func_73869_a(c, n);
        if (n == PdaMod.mapKeybind._d) {
            this.closeScreen();
        }
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        PdaClient.mapSettings.savedMapZoom = this.map.canvas().getZoom();
        PdaClient.mapSettings.savedMapCoords = this.map.canvas().getMapCoords();
    }

    @Override
    public void func_73860_n() {
        int n = Keyboard.getEventKey();
        char c = Keyboard.getEventCharacter();
        this._a();
        if (Keyboard.getEventKeyState()) {
            this.func_73869_a(c, n);
        }
    }
}

