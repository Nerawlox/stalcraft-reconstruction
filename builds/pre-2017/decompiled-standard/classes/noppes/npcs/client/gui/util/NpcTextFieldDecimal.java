/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import noppes.npcs.client.gui.util.GuiNpcTextField;

public class NpcTextFieldDecimal
extends GuiNpcTextField {
    public NpcTextFieldDecimal(int n, gqjz gqjz2, qncw qncw2, int n2, int n3, int n4, int n5, String string) {
        super(n, gqjz2, qncw2, n2, n3, n4, n5, string);
    }

    @Override
    protected boolean charAllowed(char c, int n) {
        if (!(Character.isDigit(c) || this.isEmpty() && c == '-')) {
            if (c == '.') {
                return true;
            }
            for (int n2 : this.allowedSpecialChars) {
                if (n2 != n) continue;
                return true;
            }
            return false;
        }
        return true;
    }

    @Override
    public void unFocused() {
        if (!this.isEmpty() && this.isDouble()) {
            double d = this.getDouble();
            if (d < (double)this.min) {
                this.func_73782_a(String.valueOf(this.min));
            } else if (d > (double)this.max) {
                this.func_73782_a(String.valueOf(this.max));
            }
        } else {
            this.func_73782_a(String.valueOf(this.def));
        }
        if (this.listener != null) {
            this.listener.unFocused(this);
        }
        if (this == GuiNpcTextField.activeTextfield) {
            GuiNpcTextField.activeTextfield = null;
        }
    }

    private boolean isDouble() {
        try {
            Double.parseDouble(this.func_73781_b());
            return true;
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    public double getDouble() {
        return Double.parseDouble(this.func_73781_b());
    }
}

