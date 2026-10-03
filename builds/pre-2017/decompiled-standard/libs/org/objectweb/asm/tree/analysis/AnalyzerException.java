/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.tree.analysis;

import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.analysis.Value;

public class AnalyzerException
extends Exception {
    public final AbstractInsnNode node;

    public AnalyzerException(AbstractInsnNode node, String msg) {
        super(msg);
        this.node = node;
    }

    public AnalyzerException(AbstractInsnNode node, String msg, Throwable exception) {
        super(msg, exception);
        this.node = node;
    }

    public AnalyzerException(AbstractInsnNode node, String msg, Object expected, Value encountered) {
        super((msg == null ? "Expected " : msg + ": expected ") + expected + ", but found " + encountered);
        this.node = node;
    }
}

