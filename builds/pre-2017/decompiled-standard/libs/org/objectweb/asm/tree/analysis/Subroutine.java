/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.tree.analysis;

import java.util.ArrayList;
import java.util.List;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.analysis.AnalyzerException;

class Subroutine {
    LabelNode start;
    boolean[] access;
    List<JumpInsnNode> callers;

    private Subroutine() {
    }

    Subroutine(LabelNode start, int maxLocals, JumpInsnNode caller2) {
        this.start = start;
        this.access = new boolean[maxLocals];
        this.callers = new ArrayList<JumpInsnNode>();
        this.callers.add(caller2);
    }

    public Subroutine copy() {
        Subroutine result2 = new Subroutine();
        result2.start = this.start;
        result2.access = new boolean[this.access.length];
        System.arraycopy(this.access, 0, result2.access, 0, this.access.length);
        result2.callers = new ArrayList<JumpInsnNode>(this.callers);
        return result2;
    }

    public boolean merge(Subroutine subroutine) throws AnalyzerException {
        int i;
        boolean changes = false;
        for (i = 0; i < this.access.length; ++i) {
            if (!subroutine.access[i] || this.access[i]) continue;
            this.access[i] = true;
            changes = true;
        }
        if (subroutine.start == this.start) {
            for (i = 0; i < subroutine.callers.size(); ++i) {
                JumpInsnNode caller2 = subroutine.callers.get(i);
                if (this.callers.contains(caller2)) continue;
                this.callers.add(caller2);
                changes = true;
            }
        }
        return changes;
    }
}

