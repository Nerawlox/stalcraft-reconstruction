/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.basic;

import com.mcf.davidee.guilib.core.Button;
import com.mcf.davidee.guilib.core.Container;
import com.mcf.davidee.guilib.core.Widget;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.sajh;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public abstract class BasicScreen
extends GuiScreen {
    private GuiScreen parent;
    private boolean hasInit;
    private boolean closed;
    protected List<Container> containers;
    protected Container selectedContainer;

    public BasicScreen(GuiScreen guiScreen) {
        this.parent = guiScreen;
        this.containers = new ArrayList<Container>();
    }

    protected abstract void revalidateGui();

    protected abstract void createGui();

    protected abstract void reopenedGui();

    public GuiScreen getParent() {
        return this.parent;
    }

    public List<Container> getContainers() {
        return this.containers;
    }

    public void close() {
        this.mc._a(this.parent);
    }

    protected void unhandledKeyTyped(char c, int n) {
    }

    protected void drawBackground() {
        this.drawDefaultBackground();
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawBackground();
        ArrayList<Widget> arrayList = new ArrayList<Widget>();
        int n3 = new htou(this.mc._M, this.mc._n, this.mc._o)._e();
        for (Container object : this.containers) {
            arrayList.addAll(object.draw(n, n2, n3));
        }
        for (Widget widget : arrayList) {
            widget.draw(n, n2);
        }
    }

    @Override
    public void updateScreen() {
        for (Container container : this.containers) {
            container.update();
        }
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) {
        if (n3 == 0) {
            for (Container container : this.containers) {
                if (!container.mouseClicked(n, n2)) continue;
                this.selectedContainer = container;
                break;
            }
            for (Container container : this.containers) {
                if (container == this.selectedContainer) continue;
                container.setFocused(null);
            }
        }
    }

    @Override
    protected void mouseMovedOrUp(int n, int n2, int n3) {
        if (n3 == 0) {
            for (Container container : this.containers) {
                container.mouseReleased(n, n2);
            }
        }
    }

    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
        int n = Mouse.getEventDWheel();
        if (n != 0) {
            int n2 = Mouse.getEventX() * this.width / this.mc._n;
            int n3 = this.height - Mouse.getEventY() * this.height / this.mc._o - 1;
            boolean bl = false;
            n = sajh._a(n, -5, 5);
            for (Container container : this.containers) {
                if (!container.inBounds(n2, n3)) continue;
                container.mouseWheel(n);
                bl = true;
                break;
            }
            if (!bl && this.selectedContainer != null) {
                this.selectedContainer.mouseWheel(n);
            }
        }
    }

    @Override
    public void keyTyped(char c, int n) {
        boolean bl;
        boolean bl2 = bl = this.selectedContainer != null ? this.selectedContainer.keyTyped(c, n) : false;
        if (!bl) {
            this.unhandledKeyTyped(c, n);
        }
    }

    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        if (!this.hasInit) {
            this.createGui();
            this.hasInit = true;
        }
        this.revalidateGui();
        if (this.closed) {
            this.reopenedGui();
            this.closed = false;
        }
    }

    public void drawCenteredStringNoShadow(FontRenderer fontRenderer, String string, int n, int n2, int n3) {
        fontRenderer._b(string, n - fontRenderer._b(string) / 2, n2, n3);
    }

    @Override
    public void onGuiClosed() {
        this.closed = true;
        Keyboard.enableRepeatEvents(false);
    }

    public class CloseHandler
    implements Button.ButtonHandler {
        @Override
        public void buttonClicked(Button button) {
            BasicScreen.this.close();
        }
    }
}

