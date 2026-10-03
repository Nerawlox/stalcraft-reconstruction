/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.api;

import codechicken.nei.PositionedStack;
import codechicken.nei.api.IRecipeOverlayRenderer;
import codechicken.nei.api.IStackPositioner;
import codechicken.nei.forge.GuiContainerManager;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

public class DefaultOverlayRenderer
implements IRecipeOverlayRenderer {
    IStackPositioner positioner;
    ArrayList<PositionedStack> ingreds;

    public DefaultOverlayRenderer(List<PositionedStack> list2, IStackPositioner iStackPositioner) {
        iStackPositioner = this.positioner = iStackPositioner;
        this.ingreds = new ArrayList();
        for (PositionedStack positionedStack : list2) {
            this.ingreds.add(positionedStack.copy());
        }
        this.ingreds = iStackPositioner.positionStacks(this.ingreds);
    }

    @Override
    public void renderOverlay(GuiContainerManager guiContainerManager, yeso yeso2) {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 1);
        GL11.glColor4d(0.6, 0.6, 0.6, 0.7);
        GuiContainerManager.setColouredItemRender(true);
        for (PositionedStack positionedStack : this.ingreds) {
            if (positionedStack.relx != yeso2.field_75223_e || positionedStack.rely != yeso2.field_75221_f) continue;
            GuiContainerManager.drawItem(positionedStack.relx, positionedStack.rely, positionedStack.item);
        }
        GuiContainerManager.setColouredItemRender(false);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
        GL11.glEnable(2896);
    }
}

