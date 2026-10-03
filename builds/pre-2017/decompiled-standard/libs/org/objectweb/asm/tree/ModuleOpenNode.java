/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.tree;

import java.util.List;
import org.objectweb.asm.ModuleVisitor;

public class ModuleOpenNode {
    public String packaze;
    public int access;
    public List<String> modules;

    public ModuleOpenNode(String packaze, int access, List<String> modules) {
        this.packaze = packaze;
        this.access = access;
        this.modules = modules;
    }

    public void accept(ModuleVisitor mv) {
        mv.visitExport(this.packaze, this.access, this.modules == null ? null : this.modules.toArray(new String[0]));
    }
}

