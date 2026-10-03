/*
 * Decompiled with CFR 0.152.
 */
package znw.mods.guimaker.client;

import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import org.lwjgl.opengl.GL11;
import znw.mods.guimaker.client.IEditor;
import znw.mods.guimaker.client.component.Guideline;

public class GuiComponentsListDebug<T extends GuiComponent>
extends GuiComponentsList<T> {
    private static IEditor editor;

    public <K extends IEditor & IAdvancedGui> GuiComponentsListDebug(K k) {
        super(k);
        editor = k;
    }

    @Override
    public void drawComponent(Point point, float f) {
        int n;
        Object object22;
        if (this == editor.getGuiComponentList()) {
            this.updateElementMouseOver(point.subtract(this.getLocation()));
        }
        for (Object object22 : this) {
            GuiComponentsListDebug.preDrawComponent((GuiComponent)object22, editor.getMousePos(), f);
        }
        for (GuiComponent object3 : this.elements) {
            if (!object3.getVisible()) continue;
            object3.setOrigin(new Point(this.getOrigin().x + this.getLocation().x, this.getOrigin().y + this.getLocation().y));
            GL11.glColor4d(object3.r, object3.g, object3.b, object3.a);
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            GL11.glEnable(3042);
            object3.getRenderer().setOrigin(object3.getOrigin());
            object3.drawComponent(point.subtract(this.getLocation()), f);
            object3.getRenderer().clearOrigin();
            object3.setRGBA(1.0, 1.0, 1.0, 1.0);
        }
        for (Object object22 : this) {
            this.postDrawComponent((GuiComponent)object22, editor.getMousePos(), f);
        }
        for (Guideline guideline : editor.getGuidelines()) {
            n = guideline.getOrientation() == 0 ? 2 : 3000;
            int n2 = guideline.getOrientation() == 1 ? 2 : 3000;
            this.getRenderer().drawRect(guideline.x, guideline.y, n, n2, -1875186482);
        }
        object22 = editor.currentGuideline();
        if (object22 != null) {
            int n3 = ((Guideline)object22).getOrientation() == 0 ? 2 : 3000;
            n = ((Guideline)object22).getOrientation() == 1 ? 2 : 3000;
            this.getRenderer().drawRect(((Guideline)object22).x, ((Guideline)object22).y, n3, n, -1875186482);
        }
    }

    private static void preDrawComponent(GuiComponent guiComponent, Point point, float f) {
        if (editor.getSelectedComponents().contains(guiComponent)) {
            if (editor.isDraggingComponents()) {
                guiComponent.setRGBA(1.0, 1.0, 1.0, 0.5);
            } else {
                guiComponent.setRGBA(0.7, 0.7, 1.0, 1.0);
            }
        }
    }

    private void postDrawComponent(GuiComponent guiComponent, Point point, float f) {
        int n;
        int n2;
        int n3;
        if (editor.getSelectedComponents().contains(guiComponent)) {
            Point point2 = guiComponent.getAbsoluteLocation();
            int n4 = point2.x;
            n3 = point2.y;
            n2 = guiComponent.getSize().width;
            n = guiComponent.getSize().height;
            this.getRenderer().drawRect(n4 - 4, n3 - 4, n2 + 8, n + 8, -1875186482);
            this.getRenderer().drawGradientRect(n4, n3, n2, n, 808687782, 1614825638);
        }
        if (this.getElementMouseOver(editor.getMousePos()) == guiComponent && !editor.isDraggingComponents()) {
            int n5 = editor.detectEdgeCollision(guiComponent, point);
            Point point3 = guiComponent.getAbsoluteLocation();
            n3 = point3.x;
            n2 = point3.y;
            n = point3.x + guiComponent.getSize().width;
            int n6 = point3.y + guiComponent.getSize().height;
            int n7 = n5 == 8 || n5 == 5 ? n5 - 2 : (n5 == 7 || n5 == 4 ? n5 - 1 : n5);
            int n8 = n5 - n7;
            if (n7 < 3) {
                n8 = n5;
            }
            switch (n7) {
                case 6: {
                    this.getRenderer().drawRect(n3, n2, 5.0, guiComponent.getSize().height, -1864409986);
                    break;
                }
                case 3: {
                    this.getRenderer().drawRect(n - 5, n2, 5.0, guiComponent.getSize().height, -1864409986);
                }
            }
            switch (n8) {
                case 1: {
                    this.getRenderer().drawRect(n3, n2, guiComponent.getSize().width, 5.0, -1864409986);
                    break;
                }
                case 2: {
                    this.getRenderer().drawRect(n3, n6 - 5, guiComponent.getSize().width, 5.0, -1864409986);
                }
            }
        }
    }

    private void drawOutlineRect(Point point, Point point2) {
    }

    private void drawComponentOutline(GuiComponent guiComponent, int n) {
    }
}

