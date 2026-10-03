/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.gui.GuiDraw;
import codechicken.nei.Button;
import codechicken.nei.NEIClientUtils;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatAllowedCharacters;
import org.lwjgl.input.Keyboard;

public abstract class SaveLoadButton
extends Button {
    public boolean saved;
    public long backdowntime;
    public int backs;
    public int cursorCounter;
    public boolean focused;

    public SaveLoadButton(String string) {
        super(string);
    }

    @Override
    public boolean handleClick(int n, int n2, int n3) {
        if (n3 == 1) {
            this.label = "";
            this.onTextChange();
            this.focused = true;
            NEIClientUtils.mc()._N._a("random.click", 1.0f, 1.0f);
            return true;
        }
        return super.handleClick(n, n2, n3);
    }

    public abstract void onTextChange();

    @Override
    public void onGuiClick(int n, int n2) {
        if (!this.contains(n, n2)) {
            this.focused = false;
        }
    }

    @Override
    public boolean handleKeyPress(int n, char c) {
        if (!this.focused) {
            return false;
        }
        if (n == 14) {
            if (this.label.length() > 0) {
                this.label = this.label.substring(0, this.label.length() - 1);
                this.onTextChange();
                this.backdowntime = System.currentTimeMillis();
            }
        } else if (n == 28) {
            this.focused = false;
        } else if (c == '\u0016') {
            String string = GuiScreen.getClipboardString();
            if (string == null) {
                string = "";
            }
            this.label = this.label + string;
            this.onTextChange();
        } else if (ChatAllowedCharacters._a.indexOf(c) >= 0) {
            this.label = this.label + c;
            this.onTextChange();
        }
        return true;
    }

    @Override
    public void update() {
        ++this.cursorCounter;
        if (this.backdowntime > 0L) {
            if (Keyboard.isKeyDown(14) && this.label.length() > 5) {
                if ((float)(System.currentTimeMillis() - this.backdowntime) > 200.0f / (1.0f + (float)this.backs * 0.3f)) {
                    this.label = this.label.substring(0, this.label.length() - 1);
                    this.onTextChange();
                    this.backdowntime = System.currentTimeMillis();
                    ++this.backs;
                }
            } else {
                this.backdowntime = 0L;
                this.backs = 0;
            }
        }
    }

    @Override
    public void draw(int n, int n2) {
        super.draw(n, n2);
        if (this.focused && this.cursorCounter / 6 % 2 == 0) {
            GuiDraw.drawString("_", this.x + (this.width + GuiDraw.getStringWidth(this.getRenderLabel())) / 2, this.y + (this.height - 8) / 2, -1);
        }
    }

    @Override
    public String getRenderLabel() {
        return NEIClientUtils.translate(this.saved ? "load" : "save", new Object[0]) + " " + this.label;
    }
}

