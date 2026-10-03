/*
 * Decompiled with CFR 0.152.
 */
public abstract class plne {
    public final String field_76190_i;
    public boolean field_76189_a;

    public plne(String string) {
        this.field_76190_i = string;
    }

    public abstract void func_76184_a(qoac var1);

    public abstract void func_76187_b(qoac var1);

    public void func_76185_a() {
        this.func_76186_a(true);
    }

    public void func_76186_a(boolean bl) {
        this.field_76189_a = bl;
    }

    public boolean func_76188_b() {
        return this.field_76189_a;
    }
}

