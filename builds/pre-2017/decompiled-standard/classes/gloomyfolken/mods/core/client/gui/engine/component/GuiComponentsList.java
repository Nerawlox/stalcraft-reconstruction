/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import com.google.common.collect.Iterables;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.IFocusable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.lwjgl.opengl.GL11;

public class GuiComponentsList<T extends GuiComponent>
extends GuiComponent {
    protected List<T> elements = new CopyOnWriteArrayList<T>();
    protected List<T> readOnlyElements = this.elements;
    protected GuiComponent mouseOverElement;

    public GuiComponentsList(IAdvancedGui iAdvancedGui) {
        super(iAdvancedGui);
    }

    protected GuiComponentsList(IAdvancedGui iAdvancedGui, Point point, Dimension dimension) {
        super(iAdvancedGui, point, dimension);
    }

    private void addElementWithZOrder(T t) {
        this.elements.add(t);
    }

    public void addElement(T t) {
        this.addElementWithZOrder(t);
        ((GuiComponent)t).setParentComponent(this);
        Collections.sort(this.elements, (guiComponent, guiComponent2) -> guiComponent.getZLevel() - guiComponent2.getZLevel());
        this.parent.getElementsList().onElementsListUpdate();
    }

    public void addAll(T ... TArray) {
        for (T t : TArray) {
            this.addElementWithZOrder(t);
            ((GuiComponent)t).setParentComponent(this);
        }
        Collections.sort(this.elements, (guiComponent, guiComponent2) -> guiComponent.getZLevel() - guiComponent2.getZLevel());
        this.parent.getElementsList().onElementsListUpdate();
    }

    public void addAll(Collection<T> collection) {
        for (GuiComponent guiComponent3 : collection) {
            this.addElementWithZOrder(guiComponent3);
            guiComponent3.setParentComponent(this);
        }
        Collections.sort(this.elements, (guiComponent, guiComponent2) -> guiComponent.getZLevel() - guiComponent2.getZLevel());
        this.parent.getElementsList().onElementsListUpdate();
    }

    public boolean removeElement(T t) {
        boolean bl = this.elements.remove(t);
        ((GuiComponent)t).setParentComponent(null);
        this.parent.getElementsList().onElementsListUpdate();
        return bl;
    }

    public boolean removeAll(T ... TArray) {
        boolean bl = this.elements.removeAll(Arrays.asList(TArray));
        for (T t : TArray) {
            ((GuiComponent)t).setParentComponent(null);
        }
        this.parent.getElementsList().onElementsListUpdate();
        return bl;
    }

    public boolean removeAll(Collection<T> collection) {
        boolean bl = this.elements.removeAll(collection);
        for (GuiComponent guiComponent : collection) {
            guiComponent.setParentComponent(null);
        }
        this.parent.getElementsList().onElementsListUpdate();
        return bl;
    }

    public void clearElements() {
        this.elements.clear();
        this.parent.getElementsList().onElementsListUpdate();
    }

    public List<T> getElements() {
        return this.readOnlyElements;
    }

    @Override
    public Iterator<GuiComponent> iterator() {
        return Iterables.concat(this.elements).iterator();
    }

    public void bringToFront(T t) {
        if (this.removeElement(t)) {
            this.elements.add(t);
            ((GuiComponent)t).setParentComponent(this);
        }
    }

    public void sendToBack(T t) {
        if (this.removeElement(t)) {
            this.elements.add(0, t);
            ((GuiComponent)t).setParentComponent(this);
        }
    }

    @Override
    public void drawComponent(Point point, float f) {
        point = GuiHelper.getCursorPos(this.parent).subtract(this.getAbsoluteLocation());
        if (this == this.parent.getElementsList()) {
            this.updateElementMouseOver(point);
        }
        for (GuiComponent guiComponent : this.elements) {
            if (!guiComponent.getVisible()) continue;
            guiComponent.setOrigin(new Point(this.getOrigin().x + this.getLocation().x, this.getOrigin().y + this.getLocation().y));
            GL11.glColor4d(guiComponent.r, guiComponent.g, guiComponent.b, guiComponent.a);
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            GL11.glEnable(3042);
            guiComponent.renderer.setOrigin(guiComponent.getOrigin());
            guiComponent.drawComponent(point, f);
            guiComponent.renderer.clearOrigin();
            guiComponent.setRGBA(1.0, 1.0, 1.0, 1.0);
        }
    }

    @Override
    public void keyTyped(char c, int n) {
        for (GuiComponent guiComponent : this.elements) {
            if (!guiComponent.getEnabled()) continue;
            guiComponent.keyTyped(c, n);
        }
    }

    @Override
    public void mouseClicked(Point point, int n) {
        for (GuiComponent guiComponent : this.elements) {
            if (!guiComponent.getEnabled()) continue;
            guiComponent.mouseClicked(point.subtract(this.getLocation()), n);
        }
    }

    @Override
    public void mouseUp(Point point, int n) {
        for (GuiComponent guiComponent : this.elements) {
            if (!guiComponent.getEnabled()) continue;
            guiComponent.mouseUp(point.subtract(this.getLocation()), n);
        }
    }

    @Override
    public void mouseDrag(Point point, int n) {
        for (GuiComponent guiComponent : this.elements) {
            if (!guiComponent.getEnabled()) continue;
            guiComponent.mouseDrag(point.subtract(this.getLocation()), n);
        }
    }

    @Override
    public void handleWheel(int n, Point point) {
        if (n != 0) {
            for (GuiComponent guiComponent : this.elements) {
                if (!guiComponent.getEnabled()) continue;
                guiComponent.handleWheel(n, point.subtract(this.getLocation()));
            }
        }
    }

    @Override
    public void tick() {
        for (GuiComponent guiComponent : this.elements) {
            if (!guiComponent.getEnabled()) continue;
            guiComponent.tick();
        }
    }

    @Override
    public void onElementsListUpdate() {
        for (GuiComponent guiComponent : this.elements) {
            guiComponent.onElementsListUpdate();
        }
    }

    public void updateElementMouseOver(Point point) {
        this.mouseOverElement = this.getElementMouseOver(point);
    }

    @Override
    public GuiComponent getElementMouseOver(Point point) {
        for (int i = this.elements.size() - 1; i >= 0; --i) {
            Point point2;
            GuiComponent guiComponent = (GuiComponent)this.elements.get(i);
            GuiComponent guiComponent2 = guiComponent.getElementMouseOver(point2 = new Point(point.x - this.getLocation().x, point.y - this.getLocation().y));
            if (guiComponent2 == null) continue;
            return guiComponent2;
        }
        return null;
    }

    public GuiComponent getElementMouseOver() {
        return this.mouseOverElement;
    }

    public void setElementsRenderer(GuiRenderer guiRenderer) {
        for (GuiComponent guiComponent : this.elements) {
            guiComponent.setRenderer(guiRenderer);
        }
    }

    public void unfocuseAll() {
        for (GuiComponent guiComponent : this.elements) {
            if (guiComponent instanceof IFocusable) {
                ((IFocusable)((Object)guiComponent)).setFocused(false);
                continue;
            }
            if (!(guiComponent instanceof GuiComponentsList)) continue;
            ((GuiComponentsList)guiComponent).unfocuseAll();
        }
    }
}

