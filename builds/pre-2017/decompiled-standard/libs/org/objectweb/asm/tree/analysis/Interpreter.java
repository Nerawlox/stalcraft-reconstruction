/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.tree.analysis;

import java.util.List;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.analysis.AnalyzerException;
import org.objectweb.asm.tree.analysis.Value;

public abstract class Interpreter<V extends Value> {
    protected final int api;

    protected Interpreter(int api) {
        this.api = api;
    }

    public abstract V newValue(Type var1);

    public abstract V newOperation(AbstractInsnNode var1) throws AnalyzerException;

    public abstract V copyOperation(AbstractInsnNode var1, V var2) throws AnalyzerException;

    public abstract V unaryOperation(AbstractInsnNode var1, V var2) throws AnalyzerException;

    public abstract V binaryOperation(AbstractInsnNode var1, V var2, V var3) throws AnalyzerException;

    public abstract V ternaryOperation(AbstractInsnNode var1, V var2, V var3, V var4) throws AnalyzerException;

    public abstract V naryOperation(AbstractInsnNode var1, List<? extends V> var2) throws AnalyzerException;

    public abstract void returnOperation(AbstractInsnNode var1, V var2, V var3) throws AnalyzerException;

    public abstract V merge(V var1, V var2);
}

