/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import net.minecraft.block.Block;

public class bqza
extends mqrl {
    @Override
    public String _a() {
        return "simple_render";
    }

    @Override
    public void _b(rpaa rpaa2) {
        Block block = Block.blocksList[rpaa2._e];
        if (block != null) {
            InvokeSideOnly.client(() -> rpgl._a(block, rpaa2));
        }
    }

    @Override
    public boolean _b() {
        return false;
    }
}

