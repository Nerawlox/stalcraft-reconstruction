/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.tree;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.tree.LabelNode;

public class LocalVariableNode {
    public String name;
    public String desc;
    public String signature;
    public LabelNode start;
    public LabelNode end;
    public int index;

    public LocalVariableNode(String name2, String desc, String signature2, LabelNode start, LabelNode end, int index) {
        this.name = name2;
        this.desc = desc;
        this.signature = signature2;
        this.start = start;
        this.end = end;
        this.index = index;
    }

    public void accept(MethodVisitor mv) {
        mv.visitLocalVariable(this.name, this.desc, this.signature, this.start.getLabel(), this.end.getLabel(), this.index);
    }
}

