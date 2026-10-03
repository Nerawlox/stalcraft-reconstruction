/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import noppes.npcs.client.gui.util.ITextfieldListener;

public class GuiNpcTextField
extends GuiTextField {
    protected static GuiNpcTextField activeTextfield = null;
    protected final int[] allowedSpecialChars = new int[]{14, 211, 203, 205};
    public boolean enabled = true;
    public boolean inMenu = true;
    public boolean numbersOnly = false;
    public int id;
    public int min = 0;
    public int max = Integer.MAX_VALUE;
    public int def = 0;
    protected ITextfieldListener listener;

    public GuiNpcTextField(int n, GuiScreen guiScreen, FontRenderer fontRenderer, int n2, int n3, int n4, int n5, String string) {
        super(fontRenderer, n2, n3, n4, n5);
        this.setMaxStringLength(500);
        this.setText(string);
        this.id = n;
        if (guiScreen instanceof ITextfieldListener) {
            this.listener = (ITextfieldListener)((Object)guiScreen);
        }
    }

    public static void unfocus() {
        if (activeTextfield != null) {
            activeTextfield.unFocused();
        }
        activeTextfield = null;
    }

    protected boolean charAllowed(char c, int n) {
        if (!(!this.numbersOnly || Character.isDigit(c) || this.isEmpty() && c == '-')) {
            for (int n2 : this.allowedSpecialChars) {
                if (n2 != n) continue;
                return true;
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean textboxKeyTyped(char c, int n) {
        return !this.charAllowed(c, n) ? false : super.textboxKeyTyped(c, n);
    }

    public boolean isEmpty() {
        return this.getText().trim().length() == 0;
    }

    public int getInteger() {
        return Integer.parseInt(this.getText());
    }

    public boolean isInteger() {
        try {
            Integer.parseInt(this.getText());
            return true;
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        boolean bl = this.isFocused();
        super.mouseClicked(n, n2, n3);
        if (bl != this.isFocused() && bl) {
            this.unFocused();
        }
        if (this.isFocused()) {
            activeTextfield = this;
        }
    }

    public void unFocused() {
        if (this.numbersOnly) {
            if (!this.isEmpty() && this.isInteger()) {
                if (this.getInteger() < this.min) {
                    this.setText(this.min + "");
                } else if (this.getInteger() > this.max) {
                    this.setText(this.max + "");
                }
            } else {
                this.setText(this.def + "");
            }
        }
        if (this.listener != null) {
            this.listener.unFocused(this);
        }
        if (this == activeTextfield) {
            activeTextfield = null;
        }
    }

    public void setMinMaxDefault(int n, int n2, int n3) {
        this.min = n;
        this.max = n2;
        this.def = n3;
    }
}

