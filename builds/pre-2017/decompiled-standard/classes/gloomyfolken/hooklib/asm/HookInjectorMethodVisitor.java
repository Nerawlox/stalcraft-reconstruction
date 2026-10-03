/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.hooklib.asm;

import gloomyfolken.hooklib.asm.AsmHook;
import gloomyfolken.hooklib.asm.HookInjectorClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;

public abstract class HookInjectorMethodVisitor
extends AdviceAdapter {
    protected final AsmHook hook;
    protected final HookInjectorClassVisitor cv;
    public final String methodName;
    public final Type methodType;
    public final boolean isStatic;

    protected HookInjectorMethodVisitor(MethodVisitor methodVisitor, int n, String string, String string2, AsmHook asmHook, HookInjectorClassVisitor hookInjectorClassVisitor) {
        super(327680, methodVisitor, n, string, string2);
        this.hook = asmHook;
        this.cv = hookInjectorClassVisitor;
        this.isStatic = (n & 8) != 0;
        this.methodName = string;
        this.methodType = Type.getMethodType(string2);
    }

    protected final void visitHook() {
        if (!this.cv.visitingHook) {
            this.cv.visitingHook = true;
            this.hook.inject(this);
            this.cv.visitingHook = false;
        }
    }

    MethodVisitor getBasicVisitor() {
        return this.mv;
    }

    public static class LineNumber
    extends HookInjectorMethodVisitor {
        private int lineNumber;

        public LineNumber(MethodVisitor methodVisitor, int n, String string, String string2, AsmHook asmHook, HookInjectorClassVisitor hookInjectorClassVisitor, int n2) {
            super(methodVisitor, n, string, string2, asmHook, hookInjectorClassVisitor);
            this.lineNumber = n2;
        }

        @Override
        public void visitLineNumber(int n, Label label) {
            super.visitLineNumber(n, label);
            if (this.lineNumber == n) {
                this.visitHook();
            }
        }
    }

    public static class MethodExit
    extends HookInjectorMethodVisitor {
        public MethodExit(MethodVisitor methodVisitor, int n, String string, String string2, AsmHook asmHook, HookInjectorClassVisitor hookInjectorClassVisitor) {
            super(methodVisitor, n, string, string2, asmHook, hookInjectorClassVisitor);
        }

        @Override
        protected void onMethodExit(int n) {
            if (n != 191) {
                this.visitHook();
            }
        }
    }

    public static class MethodEnter
    extends HookInjectorMethodVisitor {
        public MethodEnter(MethodVisitor methodVisitor, int n, String string, String string2, AsmHook asmHook, HookInjectorClassVisitor hookInjectorClassVisitor) {
            super(methodVisitor, n, string, string2, asmHook, hookInjectorClassVisitor);
        }

        @Override
        protected void onMethodEnter() {
            this.visitHook();
        }
    }
}

