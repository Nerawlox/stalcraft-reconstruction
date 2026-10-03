/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import org.objectweb.asm.tree.ClassNode;

public interface IASMHook {
    public ClassNode[] inject(ClassNode var1);

    public void modifyClass(String var1, ClassNode var2);
}

