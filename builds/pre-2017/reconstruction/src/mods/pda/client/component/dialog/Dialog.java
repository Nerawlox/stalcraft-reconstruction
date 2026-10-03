/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.component.dialog;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import net.minecraft.client.Minecraft;

public abstract class Dialog
extends GuiComponentsList {
    protected String title = "";

    public Dialog(IAdvancedGui iAdvancedGui, Point point, Dimension dimension) {
        super(iAdvancedGui, point, dimension);
    }

    public final Dialog init() {
        this.clearElements();
        this.setupDialog();
        return this;
    }

    protected abstract void setupDialog();

    public Dialog setStatus(boolean bl) {
        this.setVisible(bl);
        this.setEnabled(bl);
        return this;
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawBackground();
        if (this.title != null) {
            this.renderer.drawString(this.title, this.getLocation().add(25, 10), iedw._e.getRGB());
        }
        super.drawComponent(point, f);
    }

    protected void drawBackground() {
        Minecraft._E()._R()._a(iedw._a);
        this.renderer.drawTiledRect(this.getLocation(), new Point(128, 959), this.getSize(), new Dimension(64, 64), 20);
        this.renderer.drawTiledRect(this.getLocation().add(5, 5), new Point(64, 768), new Dimension(this.getSize().width - 18, 27), new Dimension(64, 27), 23, 0);
        Minecraft._E()._R()._a(iedw._b);
        this.renderer.drawTexturedModalRect(this.getLocation().add(5, 35), new Point(0, 0), this.getSize().add(-20, -40));
        this.renderer.drawRect(this.getLocation().add(10, 37), new Dimension(this.getSize().width - 35, 1), 0x64646464);
        this.renderer.drawRect(this.getLocation().add(10, this.getSize().height - 10), new Dimension(this.getSize().width - 35, 1), 0x64646464);
    }

    @Override
    public GuiComponent getElementMouseOver(Point point) {
        return this.getEnabled() ? super.getElementMouseOver(point) : null;
    }

    public String getTitle() {
        return this.title;
    }

    public Dialog setTitle(String string) {
        this.title = string;
        return this;
    }

    public <T extends GuiComponent> T add(T t) {
        this.addElement(t);
        return t;
    }
}

