/*
 * Decompiled with CFR 0.152.
 */
public class py
extends px {
    private final ub b;

    public py(ub par1EntityVillager) {
        super((og)((Object)par1EntityVillager), uf.class, 8.0f);
        this.b = par1EntityVillager;
    }

    @Override
    public boolean a() {
        if (this.b.bW()) {
            this.a = this.b.m_();
            return true;
        }
        return false;
    }
}

