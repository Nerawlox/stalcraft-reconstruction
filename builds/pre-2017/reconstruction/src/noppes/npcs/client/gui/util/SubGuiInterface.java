/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import net.minecraft.client.gui.GuiScreen;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface2;
import noppes.npcs.client.gui.util.GuiNPCInterface;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.ISubGuiListener;

public class SubGuiInterface
extends GuiNPCInterface {
    public GuiScreen parent;

    @Override
    public void save() {
    }

    @Override
    public void close() {
        if (this.parent instanceof GuiNPCInterface2) {
            ((GuiNPCInterface2)this.parent).closeSubGui(this);
        }
        if (this.parent instanceof GuiContainerNPCInterface2) {
            ((GuiContainerNPCInterface2)this.parent).closeSubGui(this);
        }
        if (this.parent instanceof ISubGuiListener) {
            ((ISubGuiListener)((Object)this.parent)).subGuiClosed(this);
        }
    }

    protected void changeSubGui(SubGuiInterface subGuiInterface) {
        if (this.parent instanceof GuiNPCInterface2) {
            ((GuiNPCInterface2)this.parent).setSubGui(subGuiInterface);
        }
    }

    @Override
    public void mouseMovedOrUp(int n, int n2, int n3) {
    }
}

