/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import java.util.LinkedHashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;

public class GuiPlayerInteract
extends GuiScreenAdvanced {
    private static Map<String, PlayerInteractProvider> providers = new LinkedHashMap<String, PlayerInteractProvider>();
    private EntityPlayer player;

    public GuiPlayerInteract(EntityPlayer entityPlayer) {
        this.player = entityPlayer;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.renderer = new GuiRendererBuilder().setTextureSize(1024, 1024).setFontRenderer(ExternalFont.tahoma13).create();
        int n = 0;
        Point point = new Point(this.screenWidth / 2 - 122, this.screenHeight / 2 - 90);
        Dimension dimension = new Dimension(230, 27);
        for (Map.Entry<String, PlayerInteractProvider> entry : providers.entrySet()) {
            GuiHelper.addButton(this, point.add(0, n++ * 40), dimension, iedw._l, entry.getKey()).onClick(guiActionButtonClick -> this.perform((GuiActionButtonClick)guiActionButtonClick, (PlayerInteractProvider)entry.getValue())).setEnabled(entry.getValue().canApply(this.player));
        }
        GuiHelper.addButton(this, point.add(0, n++ * 40), dimension, iedw._l, "\u041e\u0442\u043c\u0435\u043d\u0438\u0442\u044c").onClick(guiActionButtonClick -> this.closeScreen());
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        GL11.glEnable(3042);
        Point point = new Point(this.screenWidth / 2 - 140, this.screenHeight / 2 - 150);
        Dimension dimension = new Dimension(280, 100 + providers.size() * 42);
        Minecraft._E()._R()._a(iedw._a);
        this.renderer.drawTiledRect(point, new Point(128, 959), dimension, new Dimension(64, 64), 20);
        this.renderer.drawTiledRect(point.add(5, 5), new Point(64, 768), new Dimension(dimension.width - 18, 27), new Dimension(64, 27), 23, 0);
        this.renderer.drawTiledRect(point.add(dimension.width - 18, 20), new Point(24, 832), new Dimension(15, dimension.height - 30), new Dimension(15, 64), 2);
        Minecraft._E()._R()._a(iedw._b);
        this.renderer.drawTexturedModalRect(point.add(5, 35), new Point(0, 0), dimension.add(-20, -40));
        this.renderer.drawTexturedModalRect(point.add(dimension.width - 24, 35), new Point(714, 0), dimension.add(-20, -40));
        this.renderer.drawRect(point.add(10, 37), new Dimension(dimension.width - 35, 1), 0x64646464);
        this.renderer.drawRect(point.add(10, dimension.height - 10), new Dimension(dimension.width - 35, 1), 0x64646464);
        GL11.glDisable(3042);
        super.drawScreen(n, n2, f);
    }

    private void perform(GuiActionButtonClick guiActionButtonClick, PlayerInteractProvider playerInteractProvider) {
        playerInteractProvider.performFor(this.player);
        ((McButton)guiActionButtonClick.component).setEnabled(false);
    }

    public static void registerProvider(String string, PlayerInteractProvider playerInteractProvider) {
        providers.put(string, playerInteractProvider);
    }

    public static interface PlayerInteractProvider {
        public void performFor(EntityPlayer var1);

        default public boolean canApply(EntityPlayer entityPlayer) {
            return true;
        }
    }
}

