/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.core;

import com.mcf.davidee.guilib.focusable.FocusableWidget;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public abstract class TextField
extends FocusableWidget {
    protected String text = "";
    protected int maxLength = 32;
    protected boolean focused;
    protected int cursorCounter;
    protected int cursorPosition;
    protected int charOffset;
    protected int selectionEnd;
    protected int color;
    protected CharacterFilter filter;

    public TextField(int n, int n2, CharacterFilter characterFilter) {
        super(n, n2);
        this.filter = characterFilter;
        this.color = 0xFFFFFF;
    }

    protected abstract int getDrawX();

    protected abstract int getDrawY();

    public abstract int getInternalWidth();

    protected abstract void drawBackground();

    @Override
    public void draw(int n, int n2) {
        this.drawBackground();
        int n3 = this.cursorPosition - this.charOffset;
        int n4 = this.selectionEnd - this.charOffset;
        String string = this.mc._z._a(this.text.substring(this.charOffset), this.getInternalWidth());
        boolean bl = n3 >= 0 && n3 <= string.length();
        boolean bl2 = this.focused && this.cursorCounter / 6 % 2 == 0 && bl;
        int n5 = this.getDrawX();
        int n6 = this.getDrawY();
        int n7 = n5;
        if (n4 > string.length()) {
            n4 = string.length();
        }
        if (string.length() > 0) {
            String string2 = bl ? string.substring(0, n3) : string;
            n7 = this.mc._z._a(string2, n5, n6, this.color);
        }
        boolean bl3 = this.cursorPosition < this.text.length() || this.text.length() >= this.maxLength;
        int n8 = n7;
        if (!bl) {
            n8 = n3 > 0 ? n5 + this.width : n5;
        } else if (bl3) {
            n8 = n7 - 1;
            --n7;
        }
        if (string.length() > 0 && bl && n3 < string.length()) {
            this.mc._z._a(string.substring(n3), n7, n6, this.color);
        }
        if (bl2) {
            if (bl3) {
                bawa.func_73734_a(n8, n6 - 1, n8 + 1, n6 + 1 + this.mc._z._c, -3092272);
            } else {
                this.mc._z._a("_", n8, n6, this.color);
            }
        }
        if (n4 != n3) {
            int n9 = n5 + this.mc._z._b(string.substring(0, n4));
            this.drawCursorVertical(n8, n6 - 1, n9 - 1, n6 + 1 + this.mc._z._c);
        }
    }

    protected void drawCursorVertical(int n, int n2, int n3, int n4) {
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
        htvf htvf2 = htvf.field_78398_a;
        GL11.glColor4f(0.0f, 0.0f, 255.0f, 255.0f);
        GL11.glDisable(3553);
        GL11.glEnable(3058);
        GL11.glLogicOp(5387);
        htvf2.func_78382_b();
        htvf2.func_78377_a(n, n4, 0.0);
        htvf2.func_78377_a(n3, n4, 0.0);
        htvf2.func_78377_a(n3, n2, 0.0);
        htvf2.func_78377_a(n, n2, 0.0);
        htvf2.func_78381_a();
        GL11.glDisable(3058);
        GL11.glEnable(3553);
    }

    @Override
    public boolean click(int n, int n2) {
        return this.inBounds(n, n2);
    }

    @Override
    public void handleClick(int n, int n2) {
        int n3 = n - this.x;
        String string = this.mc._z._a(this.text.substring(this.charOffset), this.getWidth());
        this.setCursorPosition(this.mc._z._a(string, n3 -= Math.abs(this.getInternalWidth() - this.width) / 2).length() + this.charOffset);
    }

    @Override
    public void update() {
        ++this.cursorCounter;
    }

    @Override
    public void focusGained() {
        this.cursorCounter = 0;
        this.focused = true;
    }

    @Override
    public void focusLost() {
        this.focused = false;
    }

    public String getText() {
        return this.text;
    }

    public void setMaxLength(int n) {
        this.maxLength = n;
        if (this.text.length() > n) {
            this.text = this.text.substring(0, n);
        }
    }

    public void setColor(int n) {
        this.color = n;
    }

    public String getSelectedtext() {
        int n = this.cursorPosition < this.selectionEnd ? this.cursorPosition : this.selectionEnd;
        int n2 = this.cursorPosition < this.selectionEnd ? this.selectionEnd : this.cursorPosition;
        return this.text.substring(n, n2);
    }

    public void setText(String string) {
        this.text = string.length() > this.maxLength ? string.substring(0, this.maxLength) : string;
        this.setCursorPosition(this.text.length());
    }

    public void moveCursorBy(int n) {
        this.setCursorPosition(this.selectionEnd + n);
    }

    public void writeText(String string) {
        int n;
        String string2 = "";
        string = this.filter.filter(string);
        int n2 = this.cursorPosition < this.selectionEnd ? this.cursorPosition : this.selectionEnd;
        int n3 = this.cursorPosition < this.selectionEnd ? this.selectionEnd : this.cursorPosition;
        int n4 = this.maxLength - this.text.length() - (n2 - this.selectionEnd);
        boolean bl = false;
        if (this.text.length() > 0) {
            string2 = string2 + this.text.substring(0, n2);
        }
        if (n4 < string.length()) {
            string2 = string2 + string.substring(0, n4);
            n = n4;
        } else {
            string2 = string2 + string;
            n = string.length();
        }
        if (this.text.length() > 0 && n3 < this.text.length()) {
            string2 = string2 + this.text.substring(n3);
        }
        this.text = string2;
        this.moveCursorBy(n2 - this.selectionEnd + n);
    }

    public void deleteFromCursor(int n) {
        if (this.text.length() > 0) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            } else {
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
        }
    }

    public void setCursorPosition(int n) {
        this.cursorPosition = sajh._a(n, 0, this.text.length());
        this.setSelectionPos(this.cursorPosition);
    }

    public void setSelectionPos(int n) {
        this.selectionEnd = n = sajh._a(n, 0, this.text.length());
        if (this.charOffset > n) {
            this.charOffset = n;
        }
        int n2 = this.getInternalWidth();
        String string = this.mc._z._a(this.text.substring(this.charOffset), n2);
        int n3 = string.length() + this.charOffset;
        if (n == this.charOffset) {
            this.charOffset -= this.mc._z._a(this.text, n2, true).length();
        }
        if (n > n3) {
            this.charOffset += n - 1;
        } else if (n <= this.charOffset) {
            this.charOffset = n;
        }
        this.charOffset = sajh._a(this.charOffset, 0, this.text.length());
    }

    @Override
    public boolean keyTyped(char c, int n) {
        if (this.focused) {
            switch (c) {
                case '\u0001': {
                    this.setCursorPosition(this.text.length());
                    this.setSelectionPos(0);
                    return true;
                }
                case '\u0003': {
                    gqjz.func_73865_d(this.getSelectedtext());
                    return true;
                }
                case '\u0016': {
                    this.writeText(gqjz.func_73870_l());
                    return true;
                }
                case '\u0018': {
                    gqjz.func_73865_d(this.getSelectedtext());
                    this.writeText("");
                    return true;
                }
            }
            switch (n) {
                case 14: {
                    this.deleteFromCursor(-1);
                    return true;
                }
                case 199: {
                    this.setSelectionPos(0);
                    this.setCursorPosition(0);
                    return true;
                }
                case 203: {
                    if (gqjz.func_73877_p()) {
                        this.setSelectionPos(this.selectionEnd - 1);
                    } else {
                        this.moveCursorBy(-1);
                    }
                    return true;
                }
                case 205: {
                    if (gqjz.func_73877_p()) {
                        this.setSelectionPos(this.selectionEnd + 1);
                    } else {
                        this.moveCursorBy(1);
                    }
                    return true;
                }
                case 207: {
                    if (gqjz.func_73877_p()) {
                        this.setSelectionPos(this.text.length());
                    } else {
                        this.setCursorPosition(this.text.length());
                    }
                    return true;
                }
                case 211: {
                    this.deleteFromCursor(1);
                    return true;
                }
            }
            if (this.filter.isAllowedCharacter(c)) {
                this.writeText(Character.toString(c));
                return true;
            }
            return false;
        }
        return false;
    }

    public static interface CharacterFilter {
        public String filter(String var1);

        public boolean isAllowedCharacter(char var1);
    }
}

