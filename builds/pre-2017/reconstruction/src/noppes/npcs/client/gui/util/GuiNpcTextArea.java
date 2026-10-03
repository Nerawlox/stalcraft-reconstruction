/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import noppes.npcs.client.gui.util.GuiNpcTextField;

public class GuiNpcTextArea
extends GuiNpcTextField {
    public boolean inMenu = true;
    public boolean numbersOnly = false;
    private int posX;
    private int posY;
    private int width;
    private int height;
    private int cursorCounter;
    private FontRenderer fontrenderer;
    private int cursorPosition = 0;

    public GuiNpcTextArea(int n, GuiScreen guiScreen, FontRenderer fontRenderer, int n2, int n3, int n4, int n5, String string) {
        super(n, guiScreen, fontRenderer, n2, n3, n4, n5, string);
        this.posX = n2;
        this.posY = n3;
        this.width = n4;
        this.height = n5;
        this.fontrenderer = fontRenderer;
        this.setMaxStringLength(1500);
        this.setText(string);
    }

    @Override
    public void updateCursorCounter() {
        ++this.cursorCounter;
    }

    @Override
    public boolean textboxKeyTyped(char c, int n) {
        if (!this.isFocused()) {
            return false;
        }
        String string = this.getText();
        this.setText(string);
        if (c == '\r' || c == '\n') {
            this.setText(string + c);
        }
        boolean bl = super.textboxKeyTyped(c, n);
        String string2 = this.getText();
        if (string.length() > string2.length()) {
            --this.cursorPosition;
        }
        if (string.length() < string2.length()) {
            ++this.cursorPosition;
        }
        return bl;
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        boolean bl = this.isFocused();
        super.mouseClicked(n, n2, n3);
        if (!bl && this.isFocused()) {
            this.cursorPosition = this.getText().length();
        }
    }

    @Override
    public void drawTextBox() {
        GuiNpcTextArea.drawRect(this.posX - 1, this.posY - 1, this.posX + this.width + 1, this.posY + this.height + 1, -6250336);
        GuiNpcTextArea.drawRect(this.posX, this.posY, this.posX + this.width, this.posY + this.height, -16777216);
        int n = 0;
        String string = "";
        int n2 = 0xE0E0E0;
        for (char c : this.getText().toCharArray()) {
            if (c != '\r' && c != '\n') {
                if (this.fontrenderer._b(string + c) > this.width - 8) {
                    this.drawString(this.fontrenderer, string, this.posX + 4, this.posY + 4 + n * this.fontrenderer._c, n2);
                    string = "";
                    ++n;
                }
                string = string + c;
                continue;
            }
            this.drawString(this.fontrenderer, string, this.posX + 4, this.posY + 4 + n * this.fontrenderer._c, n2);
            string = "";
            ++n;
        }
        this.drawString(this.fontrenderer, string, this.posX + 4, this.posY + 4 + n * this.fontrenderer._c, n2);
        int n3 = this.isFocused() && this.cursorCounter / 6 % 2 == 0 ? 1 : 0;
        int n4 = 0;
        n = 0;
        string = "";
        if (n3 != 0 && 0 == this.cursorPosition) {
            this.fontrenderer._b("_", this.posX + 3 + this.fontrenderer._b(string), this.posY + 4 + n * this.fontrenderer._c, n2);
        }
        for (char c : this.getText().toCharArray()) {
            ++n4;
            if (c != '\r' && c != '\n') {
                if (this.fontrenderer._b(string + c) > this.width - 8) {
                    string = "";
                    ++n;
                    string = string + c;
                } else {
                    string = string + c;
                }
            } else {
                string = "";
                ++n;
            }
            if (n3 == 0 || n4 != this.cursorPosition) continue;
            this.fontrenderer._b("_", this.posX + 3 + this.fontrenderer._b(string), this.posY + 4 + n * this.fontrenderer._c, n2);
        }
    }
}

