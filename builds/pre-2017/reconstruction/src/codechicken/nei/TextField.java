/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.gui.GuiDraw;
import codechicken.nei.LayoutManager;
import codechicken.nei.Widget;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatAllowedCharacters;
import org.lwjgl.input.Keyboard;

public abstract class TextField
extends Widget {
    private String text = "";
    public boolean centered;
    public long backdowntime;
    public int backs;
    public String identifier;
    public int cursorCounter;

    public TextField(String string) {
        this.identifier = string;
    }

    public int getTextColour() {
        return this.focused() ? -2039584 : -7303024;
    }

    public void drawBox() {
        GuiDraw.drawRect(this.x, this.y, this.width, this.height, -6250336);
        GuiDraw.drawRect(this.x + 1, this.y + 1, this.width - 2, this.height - 2, -16777216);
    }

    @Override
    public void draw(int n, int n2) {
        int n3;
        this.drawBox();
        String string = this.text;
        if (this.text.length() > this.getMaxTextLength()) {
            n3 = string.length() - this.getMaxTextLength();
            if (n3 < 0 || n3 > string.length()) {
                n3 = 0;
            }
            string = string.substring(n3);
        }
        if (this.focused() && this.cursorCounter / 6 % 2 == 0) {
            string = string + '_';
        }
        n3 = GuiDraw.getStringWidth(this.text);
        int n4 = this.centered ? this.x + (this.width - n3) / 2 : this.x + 4;
        int n5 = this.y + (this.height + 1) / 2 - 3;
        GuiDraw.drawString(string, n4, n5, this.getTextColour());
    }

    @Override
    public void onGuiClick(int n, int n2) {
        if (!this.contains(n, n2)) {
            this.setFocus(false);
        }
    }

    @Override
    public boolean handleClick(int n, int n2, int n3) {
        if (n3 == 1) {
            this.setText("");
        }
        this.setFocus(true);
        return true;
    }

    @Override
    public boolean handleKeyPress(int n, char c) {
        if (!this.focused()) {
            return false;
        }
        if (n == 14) {
            if (this.text.length() > 0) {
                this.setText(this.text.substring(0, this.text.length() - 1));
                this.backdowntime = System.currentTimeMillis();
            }
        } else if (n == 28 || n == 1) {
            this.setFocus(false);
            this.onExit();
        } else if (c == '\u0016') {
            String string = GuiScreen.getClipboardString();
            if (string == null) {
                string = "";
            }
            if (this.isValid(this.text + string)) {
                this.setText(this.text + string);
            }
        } else if (this.isValid(this.text + c)) {
            this.setText(this.text + c);
        }
        return true;
    }

    public void onExit() {
    }

    public abstract void onTextChange(String var1);

    public boolean isValid(String string) {
        return ChatAllowedCharacters._a(string.charAt(string.length() - 1));
    }

    @Override
    public void update() {
        ++this.cursorCounter;
        if (this.backdowntime > 0L) {
            if (Keyboard.isKeyDown(14) && this.text.length() > 0) {
                if ((float)(System.currentTimeMillis() - this.backdowntime) > 200.0f / (1.0f + (float)this.backs * 0.3f)) {
                    this.setText(this.text.substring(0, this.text.length() - 1));
                    this.backdowntime = System.currentTimeMillis();
                    ++this.backs;
                }
            } else {
                this.backdowntime = 0L;
                this.backs = 0;
            }
        }
    }

    public void setText(String string) {
        String string2 = this.text;
        this.text = this.filterText(string);
        this.onTextChange(string2);
    }

    public String filterText(String string) {
        return string;
    }

    private int getMaxTextLength() {
        return this.width / 6 - 2;
    }

    public void setFocus(boolean bl) {
        if (bl) {
            LayoutManager.setInputFocused(this);
        } else if (this.focused()) {
            LayoutManager.setInputFocused(null);
        }
    }

    public boolean focused() {
        return LayoutManager.getInputFocused() == this;
    }

    public String text() {
        return this.text;
    }
}

