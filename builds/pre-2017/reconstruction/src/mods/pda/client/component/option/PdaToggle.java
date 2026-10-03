/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.component.option;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McToggleButton;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import java.util.function.Consumer;

public class PdaToggle
extends McToggleButton {
    static final Point ACTIVE_BG_UV = new Point(256, 928);
    static final Point NON_ACTIVE_BG_UV = new Point(256, 952);
    static final Point SELECTOR_UV = new Point(288, 952);
    private Consumer<PdaToggle> onToggle = pdaToggle -> {};
    int switchedTimer = 0;
    int prevOffset = -1;
    int offset = -1;

    public PdaToggle(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, boolean bl) {
        super(iAdvancedGui, "", point, new ComponentButtonStyle());
        this.setSize(dimension);
        this.active = bl;
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.renderer.bindTexture(iedw._a);
        Point point2 = this.switchedTimer == 0 == this.active ? ACTIVE_BG_UV : NON_ACTIVE_BG_UV;
        this.renderer.drawTiledRect(this.getLocation(), point2, this.getSize(), new Dimension(18, 23), 1, 3);
        int n = (int)jywc._a(this.prevOffset == -1 ? (float)this.offset : (float)this.prevOffset, (float)this.offset, f);
        Point point3 = this.getLocation().add(n, 1);
        this.renderer.drawTexturedModalRect(point3, new Point(275, 929), new Dimension(48, 17));
    }

    @Override
    public void tick() {
        super.tick();
        if (this.offset != -1) {
            this.prevOffset = this.offset;
        }
        int n = 2;
        int n2 = this.getSize().width - 48 - 2;
        this.offset = (int)jywc._a(this.active ? (float)n2 : (float)n, this.active ? (float)n : (float)n2, (float)this.switchedTimer / 2.0f);
        if (this.prevOffset == -1) {
            this.prevOffset = this.offset;
        }
        if (this.switchedTimer > 0) {
            --this.switchedTimer;
        }
    }

    @Override
    public void setActive(boolean bl) {
        super.setActive(bl);
        this.onToggle.accept(this);
        this.switchedTimer = 2;
    }

    public void resetAnimation() {
        this.switchedTimer = 0;
    }

    public PdaToggle onToggle(Consumer<PdaToggle> consumer) {
        this.onToggle = consumer;
        return this;
    }
}

