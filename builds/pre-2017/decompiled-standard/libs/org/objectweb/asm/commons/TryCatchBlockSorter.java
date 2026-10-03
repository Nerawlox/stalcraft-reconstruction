/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.commons;

import java.util.Collections;
import java.util.Comparator;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TryCatchBlockNode;

public class TryCatchBlockSorter
extends MethodNode {
    public TryCatchBlockSorter(MethodVisitor mv, int access, String name2, String desc, String signature2, String[] exceptions) {
        this(393216, mv, access, name2, desc, signature2, exceptions);
    }

    protected TryCatchBlockSorter(int api, MethodVisitor mv, int access, String name2, String desc, String signature2, String[] exceptions) {
        super(api, access, name2, desc, signature2, exceptions);
        this.mv = mv;
    }

    @Override
    public void visitEnd() {
        Comparator<TryCatchBlockNode> comp = new Comparator<TryCatchBlockNode>(){

            @Override
            public int compare(TryCatchBlockNode t1, TryCatchBlockNode t2) {
                int len1 = this.blockLength(t1);
                int len2 = this.blockLength(t2);
                return len1 - len2;
            }

            private int blockLength(TryCatchBlockNode block) {
                int startidx = TryCatchBlockSorter.this.instructions.indexOf(block.start);
                int endidx = TryCatchBlockSorter.this.instructions.indexOf(block.end);
                return endidx - startidx;
            }
        };
        Collections.sort(this.tryCatchBlocks, comp);
        for (int i = 0; i < this.tryCatchBlocks.size(); ++i) {
            ((TryCatchBlockNode)this.tryCatchBlocks.get(i)).updateIndex(i);
        }
        if (this.mv != null) {
            this.accept(this.mv);
        }
    }
}

