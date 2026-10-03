/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.basic;

import com.mcf.davidee.guilib.core.Button;
import com.mcf.davidee.guilib.core.Container;
import com.mcf.davidee.guilib.core.Widget;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.sajh;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public abstract class BasicScreen
extends gqjz {
    private gqjz parent;
    private boolean hasInit;
    private boolean closed;
    protected List<Container> containers;
    protected Container selectedContainer;

    public BasicScreen(gqjz gqjz2) {
        this.parent = gqjz2;
        this.containers = new ArrayList<Container>();
    }

    protected abstract void revalidateGui();

    protected abstract void createGui();

    protected abstract void reopenedGui();

    public gqjz getParent() {
        return this.parent;
    }

    public List<Container> getContainers() {
        return this.containers;
    }

    public void close() {
        this.field_73882_e._a(this.parent);
    }

    protected void unhandledKeyTyped(char c, int n) {
    }

    protected void drawBackground() {
        this.func_73873_v_();
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        this.drawBackground();
        ArrayList<Widget> arrayList = new ArrayList<Widget>();
        int n3 = new htou(this.field_73882_e._M, this.field_73882_e._n, this.field_73882_e._o)._e();
        for (Container object : this.containers) {
            arrayList.addAll(object.draw(n, n2, n3));
        }
        for (Widget widget : arrayList) {
            widget.draw(n, n2);
        }
    }

    @Override
    public void func_73876_c() {
        for (Container container : this.containers) {
            container.update();
        }
    }

    @Override
    protected void func_73864_a(int n, int n2, int n3) {
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
    protected void func_73879_b(int n, int n2, int n3) {
        if (n3 == 0) {
            for (Container container : this.containers) {
                container.mouseReleased(n, n2);
            }
        }
    }

    @Override
    public void func_73867_d() {
        super.func_73867_d();
        int n = Mouse.getEventDWheel();
        if (n != 0) {
            int n2 = Mouse.getEventX() * this.field_73880_f / this.field_73882_e._n;
            int n3 = this.field_73881_g - Mouse.getEventY() * this.field_73881_g / this.field_73882_e._o - 1;
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
    public void func_73869_a(char c, int n) {
        boolean bl;
        boolean bl2 = bl = this.selectedContainer != null ? this.selectedContainer.keyTyped(c, n) : false;
        if (!bl) {
            this.unhandledKeyTyped(c, n);
        }
    }

    @Override
    public void func_73866_w_() {
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

    public void drawCenteredStringNoShadow(qncw qncw2, String string, int n, int n2, int n3) {
        qncw2._b(string, n - qncw2._b(string) / 2, n2, n3);
    }

    @Override
    public void func_73874_b() {
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

