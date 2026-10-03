/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.ButtonState;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.IScrollable;
import gloomyfolken.mods.core.client.gui.engine.component.IWheelHandler;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentSliderBarStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;

public class McScrollBar
extends GuiComponent
implements IWheelHandler {
    public final IScrollable content;
    public final ScrollBarType type;
    private int length;
    public float pos = 0.0f;
    public boolean mouseDown;
    private int deltaPos;
    private ResourceLocation backgroundImage;
    private Point backgroundImageUV;
    private Dimension backgroundImageSize;
    private int backgroundBorder = 1;
    private boolean isOnlyVerticalBar;
    private boolean enableWheelHandling = true;
    private int sliderLength = -1;

    public McScrollBar(IAdvancedGui iAdvancedGui, IScrollable iScrollable, ScrollBarType scrollBarType, int n, int n2, int n3, ComponentButtonStyle componentButtonStyle) {
        this(iAdvancedGui, iScrollable, scrollBarType, new Point(n, n2), n3, componentButtonStyle);
    }

    public McScrollBar(IAdvancedGui iAdvancedGui, IScrollable iScrollable, ScrollBarType scrollBarType, int n, int n2, int n3, ComponentSliderBarStyle componentSliderBarStyle) {
        this(iAdvancedGui, iScrollable, scrollBarType, new Point(n, n2), n3, componentSliderBarStyle.getStyleForDirection(scrollBarType));
    }

    public McScrollBar(IAdvancedGui iAdvancedGui, IScrollable iScrollable, ScrollBarType scrollBarType, Point point, int n, ComponentSliderBarStyle componentSliderBarStyle) {
        this(iAdvancedGui, iScrollable, scrollBarType, point, n, componentSliderBarStyle.getStyleForDirection(scrollBarType));
    }

    public McScrollBar(IAdvancedGui iAdvancedGui, IScrollable iScrollable, ScrollBarType scrollBarType, Point point, int n, ComponentButtonStyle componentButtonStyle) {
        super(iAdvancedGui, point, componentButtonStyle.getSize());
        int n2 = scrollBarType == ScrollBarType.VERTICAL ? componentButtonStyle.getSize().width : n;
        int n3 = scrollBarType == ScrollBarType.HORIZONTAL ? componentButtonStyle.getSize().height : n;
        this.setSize(new Dimension(n2, n3));
        this.type = scrollBarType;
        this.content = iScrollable;
        this.length = n;
        this.setStyle(componentButtonStyle);
    }

    public McScrollBar setBackgroundImage(ResourceLocation resourceLocation, Point point, Dimension dimension) {
        return this.setBackgroundImage(resourceLocation, point, dimension, 1);
    }

    public McScrollBar setBackgroundImage(ResourceLocation resourceLocation, Point point, Dimension dimension, int n) {
        this.backgroundImage = resourceLocation;
        this.backgroundImageUV = point;
        this.backgroundImageSize = dimension;
        this.backgroundBorder = n;
        return this;
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

    @Override
    public void drawComponent(Point point, float f) {
        if (this.backgroundImage != null) {
            this.renderer.bindTexture(this.backgroundImage);
            this.renderer.drawTiledRect(this.getLocation(), this.backgroundImageUV, this.getSize(), this.backgroundImageSize, this.backgroundBorder);
        }
        if (!this.enabled()) {
            return;
        }
        if (this.mouseDown) {
            this.mouseMove(GuiHelper.getCursorPos(this.parent).subtract(this.origin));
        }
        this.renderer.drawButton(this.getSliderX(), this.getSliderY(), new Dimension(this.getSliderWidth(), this.getSliderHeight()), this.getStyle(), this.getButtonState(point));
    }

    public ButtonState getButtonState(Point point) {
        if (this.mouseDown) {
            return ButtonState.ACTIVE;
        }
        if (this.isMouseOver() && this.isMouseOverSlider(point)) {
            return ButtonState.MOUSE_OVER;
        }
        return ButtonState.DEFAULT;
    }

    public boolean isMouseOverSlider(Point point) {
        return point.x >= this.getSliderX() && point.x <= this.getSliderX() + this.getSliderWidth() && point.y >= this.getSliderY() && point.y <= this.getSliderY() + this.getSliderHeight();
    }

    private int getSliderLength() {
        if (this.sliderLength > 0) {
            return this.sliderLength;
        }
        int n = this.type == ScrollBarType.HORIZONTAL ? this.getStyle().getSize().width : this.getStyle().getSize().height;
        int n2 = (int)((float)this.getSizePerPage() / (float)this.getTotalSize() * (float)this.length);
        return Math.max(n, n2);
    }

    private int getSliderWidth() {
        return this.type == ScrollBarType.HORIZONTAL ? this.getSliderLength() : this.getStyle().getSize().width;
    }

    private int getSliderHeight() {
        return this.type == ScrollBarType.VERTICAL ? this.getSliderLength() : this.getStyle().getSize().height;
    }

    @Override
    public void mouseClicked(Point point, int n) {
        if (n == 0 && this.enabled() && this.isMouseInBounds(point)) {
            int n2 = this.type == ScrollBarType.HORIZONTAL ? point.x : point.y;
            int n3 = this.type == ScrollBarType.HORIZONTAL ? this.getSliderX() : this.getSliderY();
            int n4 = n3 + this.getSliderLength();
            if (n2 < n3) {
                this.scroll(-10);
            } else if (n2 > n4) {
                this.scroll(10);
            } else {
                this.mouseDown = true;
                this.deltaPos = n2 - n3 - this.getSliderLength() / 2;
            }
        }
    }

    @Override
    public void mouseUp(Point point, int n) {
        if (n == 0) {
            this.mouseDown = false;
            this.deltaPos = 0;
        }
    }

    private void mouseMove(Point point) {
        if (this.enabled() && this.mouseDown) {
            int n = this.getSliderLength();
            int n2 = this.type == ScrollBarType.HORIZONTAL ? point.x : point.y;
            int n3 = (this.type == ScrollBarType.HORIZONTAL ? this.getLocation().x : this.getLocation().y) + n / 2;
            this.pos = sajh._a((float)(n2 - this.deltaPos - n3) / (float)(this.length - n), 0.0f, 1.0f);
        }
    }

    @Override
    public void keyTyped(char c, int n) {
        if (!this.enabled() || this.type != ScrollBarType.VERTICAL) {
            return;
        }
        if (n == 201) {
            this.scroll(-15);
        } else if (n == 209) {
            this.scroll(15);
        }
    }

    public boolean enabled() {
        return this.getSizePerPage() < this.getTotalSize();
    }

    private int getTotalSize() {
        return this.type == ScrollBarType.HORIZONTAL ? this.content.getTotalWidth() : this.content.getTotalHeight();
    }

    private int getSizePerPage() {
        return this.type == ScrollBarType.HORIZONTAL ? this.content.getWidthPerPage() : this.content.getHeightPerPage();
    }

    private int getSliderX() {
        if (!this.enabled()) {
            return 0;
        }
        if (this.type == ScrollBarType.HORIZONTAL) {
            return (int)((float)(this.length - this.getSliderLength()) * this.pos) + this.getLocation().x;
        }
        return this.getLocation().x;
    }

    private int getSliderY() {
        if (!this.enabled()) {
            return 0;
        }
        if (this.type == ScrollBarType.VERTICAL) {
            return (int)((float)(this.length - this.getSliderLength()) * this.pos) + this.getLocation().y;
        }
        return this.getLocation().y;
    }

    @Override
    public void tick() {
        if (!this.enabled()) {
            this.pos = 0.0f;
        }
    }

    public void scroll(int n) {
        if (!this.enabled()) {
            return;
        }
        if (this.getTotalSize() > this.getSizePerPage()) {
            this.pos = sajh._a(this.pos + (float)(this.content.getMinScroll() * n) / (float)(this.getTotalSize() - this.getSizePerPage()), 0.0f, 1.0f);
        }
    }

    @Override
    public void handleWheel(int n, Point point) {
        if (!this.isEnableWheelHandling()) {
            return;
        }
        if (this.type == ScrollBarType.VERTICAL && (this.isOnlyVerticalBar || this.content.isMouseInBounds(point))) {
            this.scroll(n > 0 ? -3 : 3);
        }
    }

    @Override
    public boolean isActive() {
        return this.type == ScrollBarType.VERTICAL && this.isEnableWheelHandling();
    }

    @Override
    public void onElementsListUpdate() {
        this.isOnlyVerticalBar = true;
        for (GuiComponent guiComponent : this.parent.getElementsList()) {
            if (guiComponent == this || !(guiComponent instanceof IWheelHandler) || !((IWheelHandler)((Object)guiComponent)).isActive()) continue;
            this.isOnlyVerticalBar = false;
            break;
        }
    }

    public boolean isEnableWheelHandling() {
        return this.enableWheelHandling;
    }

    public void setEnableWheelHandling(boolean bl) {
        this.enableWheelHandling = bl;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int n) {
        this.length = n;
    }

    public McScrollBar setSliderLength(int n) {
        this.sliderLength = n;
        return this;
    }

    public static enum ScrollBarType {
        HORIZONTAL,
        VERTICAL;

    }
}

