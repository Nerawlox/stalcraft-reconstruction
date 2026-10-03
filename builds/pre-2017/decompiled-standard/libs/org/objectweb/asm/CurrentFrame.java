/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Frame;
import org.objectweb.asm.Item;

class CurrentFrame
extends Frame {
    CurrentFrame() {
    }

    @Override
    void execute(int opcode, int arg, ClassWriter cw, Item item) {
        super.execute(opcode, arg, cw, item);
        Frame successor = new Frame();
        this.merge(cw, successor, 0);
        this.set(successor);
        this.owner.inputStackTop = 0;
    }
}

