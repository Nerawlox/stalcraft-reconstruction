/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import com.google.common.collect.Iterators;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.Property;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;

public abstract class GuiComponent
implements Iterable<GuiComponent> {
    public static final GuiRenderer hdRenderer = new GuiRendererBuilder().create();
    public final IAdvancedGui parent;
    protected GuiRenderer renderer;
    @Property
    private boolean enabled = true;
    @Property
    private boolean visible = true;
    private Point location;
    @Property
    private int zLevel;
    @Property
    public double r = 1.0;
    @Property
    public double g = 1.0;
    @Property
    public double b = 1.0;
    @Property
    public double a = 1.0;
    @Property
    private GuiComponentsList parentComponent;
    @Property
    protected ComponentStyle componentStyle;
    public Object userData;
    private Dimension size;
    protected Point bottomRightCorner;
    protected Point origin = Point.zeroPoint;

    protected GuiComponent(IAdvancedGui iAdvancedGui) {
        this(iAdvancedGui, Point.zeroPoint, Dimension.zeroDimension);
    }

    public GuiComponent(IAdvancedGui iAdvancedGui, Point point, Dimension dimension) {
        this.parent = iAdvancedGui;
        this.location = point;
        this.size = dimension;
        this.updateBottomRightCorner();
        this.setRenderer(iAdvancedGui.getRenderer());
    }

    public void setRGBA(double d, double d2, double d3, double d4) {
        this.r = d;
        this.g = d2;
        this.b = d3;
        this.a = d4;
    }

    public boolean isMouseInBounds(Point point) {
        return GuiComponent.isMouseInBounds(point, this.location, this.bottomRightCorner);
    }

    public void drawComponent(Point point, float f) {
    }

    public void keyTyped(char c, int n) {
    }

    public void mouseClicked(int n) {
        this.mouseClicked(this.getRelativeCursorPos(), n);
    }

    public void mouseClicked(Point point, int n) {
    }

    public void mouseUp(int n) {
        this.mouseUp(this.getRelativeCursorPos(), n);
    }

    public void mouseUp(Point point, int n) {
    }

    public void mouseDrag(int n) {
        this.mouseDrag(this.getRelativeCursorPos(), n);
    }

    public void mouseDrag(Point point, int n) {
    }

    public void handleWheel(int n) {
        this.handleWheel(n, this.getRelativeCursorPos());
    }

    public void handleWheel(int n, Point point) {
    }

    public void tick() {
    }

    public void onElementsListUpdate() {
    }

    public IAdvancedGui getParent() {
        return this.parent;
    }

    public boolean getEnabled() {
        boolean bl;
        boolean bl2 = bl = this.enabled && this.visible;
        return this.getParentComponent() != null ? this.getParentComponent().getEnabled() && bl : bl;
    }

    public boolean getVisible() {
        boolean bl = this.visible;
        return this.getParentComponent() != null ? this.getParentComponent().getVisible() && bl : bl;
    }

    public void setEnabled(boolean bl) {
        this.enabled = bl;
    }

    public void setVisible(boolean bl) {
        this.visible = bl;
    }

    public Point getLocation() {
        return this.location;
    }

    public Dimension getSize() {
        return this.size;
    }

    public int getZLevel() {
        return this.zLevel;
    }

    public void setZLevel(int n) {
        this.zLevel = n;
    }

    public ComponentStyle getStyle() {
        return this.componentStyle;
    }

    public void setStyle(ComponentStyle componentStyle) {
        this.componentStyle = componentStyle;
    }

    public GuiComponentsList getParentComponent() {
        return this.parentComponent;
    }

    public void setParentComponent(GuiComponentsList guiComponentsList) {
        this.parentComponent = guiComponentsList;
    }

    public void setLocation(Point point) {
        this.location = point;
        this.updateBottomRightCorner();
    }

    public void move(int n, int n2) {
        this.setLocation(this.getLocation().add(n, n2));
    }

    public void setSize(Dimension dimension) {
        this.size = dimension;
        this.updateBottomRightCorner();
    }

    public GuiRenderer getRenderer() {
        return this.renderer;
    }

    public GuiComponent setRenderer(GuiRenderer guiRenderer) {
        this.renderer = guiRenderer;
        return this;
    }

    public GuiComponent setCentered(int n, int n2) {
        this.setCenteredX(n);
        this.setCenteredY(n2);
        return this;
    }

    public void setCenteredX(int n) {
        int n2 = n - this.getSize().width / 2;
        this.setLocation(new Point(n2, this.getLocation().y));
    }

    public void setCenteredY(int n) {
        int n2 = n - this.getSize().height / 2;
        this.setLocation(new Point(this.getLocation().x, n2));
    }

    public GuiComponent getElementMouseOver(Point point) {
        return !Mouse.isGrabbed() && this.visible && this.isMouseInBounds(point) ? this : null;
    }

    public final boolean isMouseOver() {
        return this == this.parent.getElementsList().getElementMouseOver();
    }

    public String toString() {
        return this.getClass().getCanonicalName() + " at " + this.location;
    }

    protected void updateBottomRightCorner() {
        this.bottomRightCorner = new Point(this.location.x + this.size.width, this.location.y + this.size.height);
    }

    public static boolean isMouseInBounds(Point point, Point point2, Point point3) {
        return point.x >= point2.x && point.x < point3.x && point.y >= point2.y && point.y < point3.y;
    }

    public static void playClickSound() {
        Minecraft._E()._N._a("random.click", 1.0f, 1.0f);
    }

    @Override
    public Iterator<GuiComponent> iterator() {
        return Iterators.singletonIterator(this);
    }

    public Point getAbsoluteLocation() {
        if (this.getParentComponent() == null) {
            return this.getLocation();
        }
        return this.getParentComponent().getAbsoluteLocation().add(this.getLocation());
    }

    public void setAbsoluteLocation(Point point) {
        if (this.getParentComponent() != null) {
            Point point2 = this.getParentComponent().getAbsoluteLocation();
            point = point.subtract(point2);
        }
        this.setLocation(point);
    }

    public Point getParentAbsoluteLocation() {
        GuiComponentsList guiComponentsList = this.getParentComponent();
        return guiComponentsList == null ? Point.zeroPoint : guiComponentsList.getAbsoluteLocation();
    }

    protected Point getRelativeCursorPos() {
        return GuiHelper.getCursorPos(this.parent).subtract(this.getParentAbsoluteLocation());
    }

    public Point getOrigin() {
        return this.origin;
    }

    public void setOrigin(Point point) {
        this.origin = point;
    }
}

