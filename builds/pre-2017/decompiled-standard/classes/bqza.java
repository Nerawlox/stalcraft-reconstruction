/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;

public class bqza
extends mqrl {
    @Override
    public String _a() {
        return "simple_render";
    }

    @Override
    public void _b(rpaa rpaa2) {
        twgu twgu2 = twgu.field_71973_m[rpaa2._e];
        if (twgu2 != null) {
            InvokeSideOnly.client(() -> rpgl._a(twgu2, rpaa2));
        }
    }

    @Override
    public boolean _b() {
        return false;
    }
}

