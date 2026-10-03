/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import noppes.npcs.client.gui.util.GuiNpcTextField;

public class GuiNpcTextArea
extends GuiNpcTextField {
    public boolean inMenu = true;
    public boolean numbersOnly = false;
    private int posX;
    private int posY;
    private int field_73811_d;
    private int field_73812_e;
    private int field_73822_h;
    private qncw fontrenderer;
    private int field_73817_o = 0;

    public GuiNpcTextArea(int n, gqjz gqjz2, qncw qncw2, int n2, int n3, int n4, int n5, String string) {
        super(n, gqjz2, qncw2, n2, n3, n4, n5, string);
        this.posX = n2;
        this.posY = n3;
        this.field_73811_d = n4;
        this.field_73812_e = n5;
        this.fontrenderer = qncw2;
        this.func_73804_f(1500);
        this.func_73782_a(string);
    }

    @Override
    public void func_73780_a() {
        ++this.field_73822_h;
    }

    @Override
    public boolean func_73802_a(char c, int n) {
        if (!this.func_73806_l()) {
            return false;
        }
        String string = this.func_73781_b();
        this.func_73782_a(string);
        if (c == '\r' || c == '\n') {
            this.func_73782_a(string + c);
        }
        boolean bl = super.func_73802_a(c, n);
        String string2 = this.func_73781_b();
        if (string.length() > string2.length()) {
            --this.field_73817_o;
        }
        if (string.length() < string2.length()) {
            ++this.field_73817_o;
        }
        return bl;
    }

    @Override
    public void func_73793_a(int n, int n2, int n3) {
        boolean bl = this.func_73806_l();
        super.func_73793_a(n, n2, n3);
        if (!bl && this.func_73806_l()) {
            this.field_73817_o = this.func_73781_b().length();
        }
    }

    @Override
    public void func_73795_f() {
        GuiNpcTextArea.func_73734_a(this.posX - 1, this.posY - 1, this.posX + this.field_73811_d + 1, this.posY + this.field_73812_e + 1, -6250336);
        GuiNpcTextArea.func_73734_a(this.posX, this.posY, this.posX + this.field_73811_d, this.posY + this.field_73812_e, -16777216);
        int n = 0;
        String string = "";
        int n2 = 0xE0E0E0;
        for (char c : this.func_73781_b().toCharArray()) {
            if (c != '\r' && c != '\n') {
                if (this.fontrenderer._b(string + c) > this.field_73811_d - 8) {
                    this.func_73731_b(this.fontrenderer, string, this.posX + 4, this.posY + 4 + n * this.fontrenderer._c, n2);
                    string = "";
                    ++n;
                }
                string = string + c;
                continue;
            }
            this.func_73731_b(this.fontrenderer, string, this.posX + 4, this.posY + 4 + n * this.fontrenderer._c, n2);
            string = "";
            ++n;
        }
        this.func_73731_b(this.fontrenderer, string, this.posX + 4, this.posY + 4 + n * this.fontrenderer._c, n2);
        int n3 = this.func_73806_l() && this.field_73822_h / 6 % 2 == 0 ? 1 : 0;
        int n4 = 0;
        n = 0;
        string = "";
        if (n3 != 0 && 0 == this.field_73817_o) {
            this.fontrenderer._b("_", this.posX + 3 + this.fontrenderer._b(string), this.posY + 4 + n * this.fontrenderer._c, n2);
        }
        for (char c : this.func_73781_b().toCharArray()) {
            ++n4;
            if (c != '\r' && c != '\n') {
                if (this.fontrenderer._b(string + c) > this.field_73811_d - 8) {
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
            if (n3 == 0 || n4 != this.field_73817_o) continue;
            this.fontrenderer._b("_", this.posX + 3 + this.fontrenderer._b(string), this.posY + 4 + n * this.fontrenderer._c, n2);
        }
    }
}

