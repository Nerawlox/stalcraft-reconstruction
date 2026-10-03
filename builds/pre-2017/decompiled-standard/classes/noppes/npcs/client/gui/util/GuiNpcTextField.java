/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import noppes.npcs.client.gui.util.ITextfieldListener;

public class GuiNpcTextField
extends ifms {
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

    public GuiNpcTextField(int n, gqjz gqjz2, qncw qncw2, int n2, int n3, int n4, int n5, String string) {
        super(qncw2, n2, n3, n4, n5);
        this.func_73804_f(500);
        this.func_73782_a(string);
        this.id = n;
        if (gqjz2 instanceof ITextfieldListener) {
            this.listener = (ITextfieldListener)((Object)gqjz2);
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
    public boolean func_73802_a(char c, int n) {
        return !this.charAllowed(c, n) ? false : super.func_73802_a(c, n);
    }

    public boolean isEmpty() {
        return this.func_73781_b().trim().length() == 0;
    }

    public int getInteger() {
        return Integer.parseInt(this.func_73781_b());
    }

    public boolean isInteger() {
        try {
            Integer.parseInt(this.func_73781_b());
            return true;
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    @Override
    public void func_73793_a(int n, int n2, int n3) {
        boolean bl = this.func_73806_l();
        super.func_73793_a(n, n2, n3);
        if (bl != this.func_73806_l() && bl) {
            this.unFocused();
        }
        if (this.func_73806_l()) {
            activeTextfield = this;
        }
    }

    public void unFocused() {
        if (this.numbersOnly) {
            if (!this.isEmpty() && this.isInteger()) {
                if (this.getInteger() < this.min) {
                    this.func_73782_a(this.min + "");
                } else if (this.getInteger() > this.max) {
                    this.func_73782_a(this.max + "");
                }
            } else {
                this.func_73782_a(this.def + "");
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

