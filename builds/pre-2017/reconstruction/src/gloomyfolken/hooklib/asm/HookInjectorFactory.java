/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.hooklib.asm;

import gloomyfolken.hooklib.asm.AsmHook;
import gloomyfolken.hooklib.asm.HookInjectorClassVisitor;
import gloomyfolken.hooklib.asm.HookInjectorMethodVisitor;
import org.objectweb.asm.MethodVisitor;

public abstract class HookInjectorFactory {
    protected boolean isPriorityInverted = false;

    abstract HookInjectorMethodVisitor createHookInjector(MethodVisitor var1, int var2, String var3, String var4, AsmHook var5, HookInjectorClassVisitor var6);

    static class LineNumber
    extends HookInjectorFactory {
        private int lineNumber;

        public LineNumber(int n) {
            this.lineNumber = n;
        }

        @Override
        public HookInjectorMethodVisitor createHookInjector(MethodVisitor methodVisitor, int n, String string, String string2, AsmHook asmHook, HookInjectorClassVisitor hookInjectorClassVisitor) {
            return new HookInjectorMethodVisitor.LineNumber(methodVisitor, n, string, string2, asmHook, hookInjectorClassVisitor, this.lineNumber);
        }
    }

    static class MethodExit
    extends HookInjectorFactory {
        public static final MethodExit INSTANCE = new MethodExit();

        private MethodExit() {
            this.isPriorityInverted = true;
        }

        @Override
        public HookInjectorMethodVisitor createHookInjector(MethodVisitor methodVisitor, int n, String string, String string2, AsmHook asmHook, HookInjectorClassVisitor hookInjectorClassVisitor) {
            return new HookInjectorMethodVisitor.MethodExit(methodVisitor, n, string, string2, asmHook, hookInjectorClassVisitor);
        }
    }

    static class MethodEnter
    extends HookInjectorFactory {
        public static final MethodEnter INSTANCE = new MethodEnter();

        private MethodEnter() {
        }

        @Override
        public HookInjectorMethodVisitor createHookInjector(MethodVisitor methodVisitor, int n, String string, String string2, AsmHook asmHook, HookInjectorClassVisitor hookInjectorClassVisitor) {
            return new HookInjectorMethodVisitor.MethodEnter(methodVisitor, n, string, string2, asmHook, hookInjectorClassVisitor);
        }
    }
}

