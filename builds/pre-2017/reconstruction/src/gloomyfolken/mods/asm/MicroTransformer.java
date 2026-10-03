/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.asm;

import net.minecraft.launchwrapper.IClassTransformer;

public abstract class MicroTransformer
implements IClassTransformer {
    public void registerHooks() {
    }

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        return byArray;
    }
}

