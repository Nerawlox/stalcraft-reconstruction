/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ChatAllowedCharacters;
import org.lwjgl.opengl.GL11;

public class GuiTextField
extends Gui {
    public final FontRenderer fontRenderer;
    public final int xPos;
    public final int yPos;
    public final int width;
    public final int height;
    public String text = "";
    public int maxStringLength = 32;
    public int cursorCounter;
    public boolean enableBackgroundDrawing = true;
    public boolean canLoseFocus = true;
    public boolean isFocused;
    public boolean isEnabled = true;
    public int lineScrollOffset;
    public int cursorPosition;
    public int selectionEnd;
    public int enabledColor = 0xE0E0E0;
    public int disabledColor = 0x707070;
    public boolean visible = true;

    public GuiTextField(FontRenderer fontRenderer, int n, int n2, int n3, int n4) {
        this.fontRenderer = fontRenderer;
        this.xPos = n;
        this.yPos = n2;
        this.width = n3;
        this.height = n4;
    }

    public void updateCursorCounter() {
        ++this.cursorCounter;
    }

    public void setText(String string) {
        this.text = string.length() > this.maxStringLength ? string.substring(0, this.maxStringLength) : string;
        this.setCursorPositionEnd();
    }

    public String getText() {
        return this.text;
    }

    public String getSelectedtext() {
        int n = this.cursorPosition < this.selectionEnd ? this.cursorPosition : this.selectionEnd;
        int n2 = this.cursorPosition < this.selectionEnd ? this.selectionEnd : this.cursorPosition;
        return this.text.substring(n, n2);
    }

    public void writeText(String string) {
        String string2 = "";
        String string3 = ChatAllowedCharacters._a(string);
        int n = this.cursorPosition < this.selectionEnd ? this.cursorPosition : this.selectionEnd;
        int n2 = this.cursorPosition < this.selectionEnd ? this.selectionEnd : this.cursorPosition;
        int n3 = this.maxStringLength - this.text.length() - (n - this.selectionEnd);
        int n4 = 0;
        if (this.text.length() > 0) {
            string2 = string2 + this.text.substring(0, n);
        }
        if (n3 < string3.length()) {
            string2 = string2 + string3.substring(0, n3);
            n4 = n3;
        } else {
            string2 = string2 + string3;
            n4 = string3.length();
        }
        if (this.text.length() > 0 && n2 < this.text.length()) {
            string2 = string2 + this.text.substring(n2);
        }
        this.text = string2;
        this.moveCursorBy(n - this.selectionEnd + n4);
    }

    public void deleteWords(int n) {
        if (this.text.length() == 0) {
            return;
        }
        if (this.selectionEnd != this.cursorPosition) {
            this.writeText("");
            return;
        }
        this.deleteFromCursor(this.getNthWordFromCursor(n) - this.cursorPosition);
    }

    public void deleteFromCursor(int n) {
        if (this.text.length() == 0) {
            return;
        }
        if (this.selectionEnd != this.cursorPosition) {
            this.writeText("");
            return;
        }
        boolean bl = n < 0;
        int n2 = bl ? this.cursorPosition + n : this.cursorPosition;
        int n3 = bl ? this.cursorPosition : this.cursorPosition + n;
        String string = "";
        if (n2 >= 0) {
            string = this.text.substring(0, n2);
        }
        if (n3 < this.text.length()) {
            string = string + this.text.substring(n3);
        }
        this.text = string;
        if (bl) {
            this.moveCursorBy(n);
        }
    }

    public int getNthWordFromCursor(int n) {
        return this.getNthWordFromPos(n, this.getCursorPosition());
    }

    public int getNthWordFromPos(int n, int n2) {
        return this.func_73798_a(n, this.getCursorPosition(), true);
    }

    public int func_73798_a(int n, int n2, boolean bl) {
        int n3 = n2;
        boolean bl2 = n < 0;
        int n4 = Math.abs(n);
        for (int i = 0; i < n4; ++i) {
            if (bl2) {
                while (bl && n3 > 0 && this.text.charAt(n3 - 1) == ' ') {
                    --n3;
                }
                while (n3 > 0 && this.text.charAt(n3 - 1) != ' ') {
                    --n3;
                }
                continue;
            }
            int n5 = this.text.length();
            if ((n3 = this.text.indexOf(32, n3)) == -1) {
                n3 = n5;
                continue;
            }
            while (bl && n3 < n5 && this.text.charAt(n3) == ' ') {
                ++n3;
            }
        }
        return n3;
    }

    public void moveCursorBy(int n) {
        this.setCursorPosition(this.selectionEnd + n);
    }

    public void setCursorPosition(int n) {
        this.cursorPosition = n;
        int n2 = this.text.length();
        if (this.cursorPosition < 0) {
            this.cursorPosition = 0;
        }
        if (this.cursorPosition > n2) {
            this.cursorPosition = n2;
        }
        this.setSelectionPos(this.cursorPosition);
    }

    public void setCursorPositionZero() {
        this.setCursorPosition(0);
    }

    public void setCursorPositionEnd() {
        this.setCursorPosition(this.text.length());
    }

    public boolean textboxKeyTyped(char c, int n) {
        if (!this.isEnabled || !this.isFocused) {
            return false;
        }
        switch (c) {
            case '\u0001': {
                this.setCursorPositionEnd();
                this.setSelectionPos(0);
                return true;
            }
            case '\u0003': {
                GuiScreen.setClipboardString(this.getSelectedtext());
                return true;
            }
            case '\u0016': {
                this.writeText(GuiScreen.getClipboardString());
                return true;
            }
            case '\u0018': {
                GuiScreen.setClipboardString(this.getSelectedtext());
                this.writeText("");
                return true;
            }
        }
        switch (n) {
            case 203: {
                if (GuiScreen.isShiftKeyDown()) {
                    if (GuiScreen.isCtrlKeyDown()) {
                        this.setSelectionPos(this.getNthWordFromPos(-1, this.getSelectionEnd()));
                    } else {
                        this.setSelectionPos(this.getSelectionEnd() - 1);
                    }
                } else if (GuiScreen.isCtrlKeyDown()) {
                    this.setCursorPosition(this.getNthWordFromCursor(-1));
                } else {
                    this.moveCursorBy(-1);
                }
                return true;
            }
            case 205: {
                if (GuiScreen.isShiftKeyDown()) {
                    if (GuiScreen.isCtrlKeyDown()) {
                        this.setSelectionPos(this.getNthWordFromPos(1, this.getSelectionEnd()));
                    } else {
                        this.setSelectionPos(this.getSelectionEnd() + 1);
                    }
                } else if (GuiScreen.isCtrlKeyDown()) {
                    this.setCursorPosition(this.getNthWordFromCursor(1));
                } else {
                    this.moveCursorBy(1);
                }
                return true;
            }
            case 14: {
                if (GuiScreen.isCtrlKeyDown()) {
                    this.deleteWords(-1);
                } else {
                    this.deleteFromCursor(-1);
                }
                return true;
            }
            case 211: {
                if (GuiScreen.isCtrlKeyDown()) {
                    this.deleteWords(1);
                } else {
                    this.deleteFromCursor(1);
                }
                return true;
            }
            case 199: {
                if (GuiScreen.isShiftKeyDown()) {
                    this.setSelectionPos(0);
                } else {
                    this.setCursorPositionZero();
                }
                return true;
            }
            case 207: {
                if (GuiScreen.isShiftKeyDown()) {
                    this.setSelectionPos(this.text.length());
                } else {
                    this.setCursorPositionEnd();
                }
                return true;
            }
        }
        if (ChatAllowedCharacters._a(c)) {
            this.writeText(Character.toString(c));
            return true;
        }
        return false;
    }

    public void mouseClicked(int n, int n2, int n3) {
        boolean bl;
        boolean bl2 = bl = n >= this.xPos && n < this.xPos + this.width && n2 >= this.yPos && n2 < this.yPos + this.height;
        if (this.canLoseFocus) {
            this.setFocused(this.isEnabled && bl);
        }
        if (this.isFocused && n3 == 0) {
            int n4 = n - this.xPos;
            if (this.enableBackgroundDrawing) {
                n4 -= 4;
            }
            String string = this.fontRenderer._a(this.text.substring(this.lineScrollOffset), this.getWidth());
            this.setCursorPosition(this.fontRenderer._a(string, n4).length() + this.lineScrollOffset);
        }
    }

    public void drawTextBox() {
        if (!this.getVisible()) {
            return;
        }
        if (this.getEnableBackgroundDrawing()) {
            GuiTextField.drawRect(this.xPos - 1, this.yPos - 1, this.xPos + this.width + 1, this.yPos + this.height + 1, -6250336);
            GuiTextField.drawRect(this.xPos, this.yPos, this.xPos + this.width, this.yPos + this.height, -16777216);
        }
        int n = this.isEnabled ? this.enabledColor : this.disabledColor;
        int n2 = this.cursorPosition - this.lineScrollOffset;
        int n3 = this.selectionEnd - this.lineScrollOffset;
        String string = this.fontRenderer._a(this.text.substring(this.lineScrollOffset), this.getWidth());
        boolean bl = n2 >= 0 && n2 <= string.length();
        boolean bl2 = this.isFocused && this.cursorCounter / 6 % 2 == 0 && bl;
        int n4 = this.enableBackgroundDrawing ? this.xPos + 4 : this.xPos;
        int n5 = this.enableBackgroundDrawing ? this.yPos + (this.height - 8) / 2 : this.yPos;
        int n6 = n4;
        if (n3 > string.length()) {
            n3 = string.length();
        }
        if (string.length() > 0) {
            String string2 = bl ? string.substring(0, n2) : string;
            n6 = this.fontRenderer._a(string2, n6, n5, n);
        }
        boolean bl3 = this.cursorPosition < this.text.length() || this.text.length() >= this.getMaxStringLength();
        int n7 = n6;
        if (!bl) {
            n7 = n2 > 0 ? n4 + this.width : n4;
        } else if (bl3) {
            --n7;
            --n6;
        }
        if (string.length() > 0 && bl && n2 < string.length()) {
            n6 = this.fontRenderer._a(string.substring(n2), n6, n5, n);
        }
        if (bl2) {
            if (bl3) {
                Gui.drawRect(n7, n5 - 1, n7 + 1, n5 + 1 + this.fontRenderer._c, -3092272);
            } else {
                this.fontRenderer._a("_", n7, n5, n);
            }
        }
        if (n3 != n2) {
            int n8 = n4 + this.fontRenderer._b(string.substring(0, n3));
            this.drawCursorVertical(n7, n5 - 1, n8 - 1, n5 + 1 + this.fontRenderer._c);
        }
    }

    public void drawCursorVertical(int n, int n2, int n3, int n4) {
        int n5;
        if (n < n3) {
            n5 = n;
            n = n3;
            n3 = n5;
        }
        if (n2 < n4) {
            n5 = n2;
            n2 = n4;
            n4 = n5;
        }
        Tessellator tessellator = Tessellator.instance;
        GL11.glColor4f(0.0f, 0.0f, 255.0f, 255.0f);
        GL11.glDisable(3553);
        GL11.glEnable(3058);
        GL11.glLogicOp(5387);
        tessellator.startDrawingQuads();
        tessellator.addVertex(n, n4, 0.0);
        tessellator.addVertex(n3, n4, 0.0);
        tessellator.addVertex(n3, n2, 0.0);
        tessellator.addVertex(n, n2, 0.0);
        tessellator.draw();
        GL11.glDisable(3058);
        GL11.glEnable(3553);
    }

    public void setMaxStringLength(int n) {
        this.maxStringLength = n;
        if (this.text.length() > n) {
            this.text = this.text.substring(0, n);
        }
    }

    public int getMaxStringLength() {
        return this.maxStringLength;
    }

    public int getCursorPosition() {
        return this.cursorPosition;
    }

    public boolean getEnableBackgroundDrawing() {
        return this.enableBackgroundDrawing;
    }

    public void setEnableBackgroundDrawing(boolean bl) {
        this.enableBackgroundDrawing = bl;
    }

    public void setTextColor(int n) {
        this.enabledColor = n;
    }

    public void setDisabledTextColour(int n) {
        this.disabledColor = n;
    }

    public void setFocused(boolean bl) {
        if (bl && !this.isFocused) {
            this.cursorCounter = 0;
        }
        this.isFocused = bl;
    }

    public boolean isFocused() {
        return this.isFocused;
    }

    public void setEnabled(boolean bl) {
        this.isEnabled = bl;
    }

    public int getSelectionEnd() {
        return this.selectionEnd;
    }

    public int getWidth() {
        return this.getEnableBackgroundDrawing() ? this.width - 8 : this.width;
    }

    public void setSelectionPos(int n) {
        int n2 = this.text.length();
        if (n > n2) {
            n = n2;
        }
        if (n < 0) {
            n = 0;
        }
        this.selectionEnd = n;
        if (this.fontRenderer != null) {
            if (this.lineScrollOffset > n2) {
                this.lineScrollOffset = n2;
            }
            int n3 = this.getWidth();
            String string = this.fontRenderer._a(this.text.substring(this.lineScrollOffset), n3);
            int n4 = string.length() + this.lineScrollOffset;
            if (n == this.lineScrollOffset) {
                this.lineScrollOffset -= this.fontRenderer._a(this.text, n3, true).length();
            }
            if (n > n4) {
                this.lineScrollOffset += n - n4;
            } else if (n <= this.lineScrollOffset) {
                this.lineScrollOffset -= this.lineScrollOffset - n;
            }
            if (this.lineScrollOffset < 0) {
                this.lineScrollOffset = 0;
            }
            if (this.lineScrollOffset > n2) {
                this.lineScrollOffset = n2;
            }
        }
    }

    public void setCanLoseFocus(boolean bl) {
        this.canLoseFocus = bl;
    }

    public boolean getVisible() {
        return this.visible;
    }

    public void setVisible(boolean bl) {
        this.visible = bl;
    }
}

