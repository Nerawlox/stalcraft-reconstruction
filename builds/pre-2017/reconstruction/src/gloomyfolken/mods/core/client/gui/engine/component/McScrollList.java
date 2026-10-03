/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.ScissorHelper;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionListSwitch;
import gloomyfolken.mods.core.client.gui.engine.component.ButtonState;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.IScrollable;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;
import gloomyfolken.mods.core.misc.vjsq;
import java.util.List;
import java.util.function.BiConsumer;
import org.lwjgl.opengl.GL11;

public class McScrollList<T extends vjsq>
extends GuiComponent
implements IScrollable {
    protected static final int LINE_HEIGHT = 26;
    private McScrollBar slider;
    protected final List<T> lines;
    protected int lineHeight;
    protected int selectedLineId = -1;
    protected boolean drawIndices = true;
    protected boolean drawLineSeparators = false;
    private BiConsumer<Integer, Integer> lineSelectionListener = (n, n2) -> {};

    public McScrollList(IAdvancedGui iAdvancedGui, ComponentButtonStyle componentButtonStyle, List<T> list2, Point point, Dimension dimension, int n3) {
        super(iAdvancedGui, point, dimension);
        this.lines = list2;
        this.lineHeight = n3;
        this.setStyle(componentButtonStyle);
    }

    public McScrollList(IAdvancedGui iAdvancedGui, ComponentButtonStyle componentButtonStyle, List<T> list2, Point point, Dimension dimension) {
        this(iAdvancedGui, componentButtonStyle, list2, point, dimension, 26);
    }

    @Override
    public void setStyle(ComponentStyle componentStyle) {
        if (componentStyle instanceof ComponentButtonStyle) {
            super.setStyle(componentStyle);
        }
    }

    @Override
    public ComponentButtonStyle getStyle() {
        return (ComponentButtonStyle)super.getStyle();
    }

    public void setSlider(McScrollBar mcScrollBar) {
        this.slider = mcScrollBar;
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.renderer.scaledScissor(this.getLocation(), this.getSize());
        for (int i = 0; i < this.lines.size(); ++i) {
            int n = this.getLocation().y - Math.round((float)(this.getTotalHeight() - this.getHeightPerPage()) * this.slider.pos) + i * this.lineHeight;
            if (n + this.lineHeight <= this.getLocation().y || n >= this.getLocation().y + this.getSize().height) continue;
            this.drawLine(i, n, point);
        }
        ScissorHelper.popScissor();
    }

    protected void drawLine(int n, int n2, Point point) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.renderer.drawButton(this.getLocation().x, n2 + 2, new Dimension(this.getTotalWidth(), this.getStyle().getSize().height), this.getStyle(), this.getState(n, point));
        int n3 = 19;
        int n4 = n2 + Math.abs(this.lineHeight - this.renderer.getFontHeight()) / 2;
        if (this.drawIndices) {
            String string = String.valueOf(n + 1) + ".";
            this.renderer.drawString(string, this.getLocation().x + 25 - this.getWidth(string), n4, this.getStyle().getFontColor().getRGB());
            n3 += 25;
        }
        this.renderer.drawString(((vjsq)this.lines.get(n)).getString(), this.getLocation().x + n3, n4, ((vjsq)this.lines.get(n)).getColor());
        if (this.isDrawLineSeparators() && n != this.lines.size() - 1) {
            this.renderer.drawRect(this.getLocation().x, n2 + this.getStyle().getSize().height + 2, this.getSize().width, 1.0, 0x64646464);
        }
    }

    protected ButtonState getState(int n, Point point) {
        int n2 = n * this.lineHeight - Math.round((float)(this.getTotalHeight() - this.getHeightPerPage()) * this.slider.pos);
        if (this.selectedLineId == n) {
            return ButtonState.ACTIVE;
        }
        if (McScrollList.isMouseInBounds(point, this.getLocation().add(0, n2), this.getLocation().add(this.getSize().width, this.lineHeight + n2))) {
            return ButtonState.MOUSE_OVER;
        }
        return ButtonState.DEFAULT;
    }

    @Override
    public void mouseClicked(Point point, int n) {
        int n2;
        if (this.isMouseOver() && (n2 = (point.y - this.getLocation().y + Math.round((float)(this.getTotalHeight() - this.getHeightPerPage()) * this.slider.pos)) / this.lineHeight) < this.lines.size()) {
            this.lineSelectionListener.accept(n2, n);
            if (n == 0) {
                this.setSelectedLineId(n2);
            }
        }
    }

    @Override
    public void keyTyped(char c, int n) {
        boolean bl = false;
        if (n == 200) {
            this.setSelectedLineId(Math.max(0, this.selectedLineId - 1));
            bl = true;
        } else if (n == 208) {
            this.setSelectedLineId(Math.min(this.lines.size() - 1, this.selectedLineId + 1));
            bl = true;
        }
        if (bl && this.selectedLineId >= 0) {
            int n2 = this.getLocation().y - Math.round((float)(this.getTotalHeight() - this.getHeightPerPage()) * this.slider.pos) + this.selectedLineId * this.lineHeight;
            if (n2 < this.getLocation().y) {
                this.slider.pos = (float)this.selectedLineId * (float)this.lineHeight / (float)(this.getTotalHeight() - this.getHeightPerPage());
            } else if (n2 + this.lineHeight > this.getLocation().y + this.getSize().height) {
                this.slider.pos = (float)((this.selectedLineId + 1) * this.lineHeight - this.getHeightPerPage()) / (float)(this.getTotalHeight() - this.getHeightPerPage());
            }
        }
    }

    public int getSelectedLineId() {
        return this.selectedLineId;
    }

    public T getSelectedLine() {
        return (T)(this.selectedLineId == -1 ? null : (vjsq)this.lines.get(this.selectedLineId));
    }

    public void setSelectedLineId(int n) {
        int n2 = this.selectedLineId;
        this.selectedLineId = n;
        if (this.selectedLineId < -1 || this.selectedLineId >= this.lines.size()) {
            this.selectedLineId = -1;
        }
        this.parent.getActionManager().processAction(new GuiActionListSwitch(this, n2));
    }

    protected int getWidth(String string) {
        return this.renderer.getStringWidth(string);
    }

    @Override
    public void tick() {
        if (this.selectedLineId < -1 || this.selectedLineId >= this.lines.size()) {
            this.setSelectedLineId(this.lines.size() == 0 ? -1 : 0);
        }
    }

    @Override
    public int getTotalWidth() {
        return this.getSize().width;
    }

    @Override
    public int getWidthPerPage() {
        return this.getSize().width;
    }

    @Override
    public int getTotalHeight() {
        return this.lines.size() * this.lineHeight;
    }

    @Override
    public int getHeightPerPage() {
        return this.getSize().height;
    }

    @Override
    public int getMinScroll() {
        return this.lineHeight;
    }

    public McScrollBar getSlider() {
        return this.slider;
    }

    public boolean isDrawIndices() {
        return this.drawIndices;
    }

    public void setDrawIndices(boolean bl) {
        this.drawIndices = bl;
    }

    public boolean isDrawLineSeparators() {
        return this.drawLineSeparators;
    }

    public void setDrawLineSeparators(boolean bl) {
        this.drawLineSeparators = bl;
    }

    public List<T> getLines() {
        return this.lines;
    }

    public McScrollList setLineSelectionListener(BiConsumer<Integer, Integer> biConsumer) {
        this.lineSelectionListener = biConsumer;
        return this;
    }
}

