/*
 * Decompiled with CFR 0.152.
 */
class abu {
    private String a;
    private boolean b;
    private int c;
    private double d;

    public abu(String par1Str) {
        this.a(par1Str);
    }

    public void a(String par1Str) {
        this.a = par1Str;
        this.b = Boolean.parseBoolean(par1Str);
        try {
            this.c = Integer.parseInt(par1Str);
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            this.d = Double.parseDouble(par1Str);
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
    }

    public String a() {
        return this.a;
    }

    public boolean b() {
        return this.b;
    }
}

