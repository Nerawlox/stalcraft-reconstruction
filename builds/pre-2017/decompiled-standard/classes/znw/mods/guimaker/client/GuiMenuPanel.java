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

public class GuiMenuPanel<T extends GuiComponent>
extends GuiComponentsList<T> {
    private IEditor editor;

    public <K extends IEditor & IAdvancedGui> GuiMenuPanel(K k) {
        super(k);
        this.editor = k;
    }

    @Override
    public void drawComponent(Point point, float f) {
        if (this == this.parent.getElementsList()) {
            this.updateElementMouseOver(point);
        }
        this.getRenderer().drawRect(this.getLocation().x, this.getLocation().y, this.getSize().width, this.getSize().height, -1610612736);
        for (GuiComponent guiComponent : this.elements) {
            if (!guiComponent.getVisible()) continue;
            guiComponent.setOrigin(new Point(this.getOrigin().x + this.getLocation().x, this.getOrigin().y + this.getLocation().y));
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            GL11.glEnable(3042);
            guiComponent.getRenderer().setOrigin(guiComponent.getOrigin());
            guiComponent.drawComponent(point.subtract(this.getLocation()), f);
            guiComponent.getRenderer().clearOrigin();
        }
    }
}

