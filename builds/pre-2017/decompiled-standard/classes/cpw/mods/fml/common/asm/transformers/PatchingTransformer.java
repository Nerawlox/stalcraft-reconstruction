/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.asm.transformers;

import cpw.mods.fml.common.patcher.ClassPatchManager;
import net.minecraft.launchwrapper.IClassTransformer;

public class PatchingTransformer
implements IClassTransformer {
    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        return ClassPatchManager.INSTANCE.applyPatch(string, string2, byArray);
    }
}

