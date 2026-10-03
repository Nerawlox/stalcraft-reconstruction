/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.hooklib.asm;

import gloomyfolken.hooklib.asm.AsmHook;
import gloomyfolken.hooklib.asm.ClassMetadataReader;
import gloomyfolken.hooklib.asm.HookClassTransformer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class HookInjectorClassVisitor
extends ClassVisitor {
    List<AsmHook> hooks;
    List<AsmHook> notInjectedHooks = new ArrayList<AsmHook>(0);
    boolean visitingHook;
    HookClassTransformer transformer;
    String superName;

    public HookInjectorClassVisitor(HookClassTransformer hookClassTransformer, ClassWriter classWriter, List<AsmHook> list) {
        super(327680, classWriter);
        this.hooks = list;
        this.transformer = hookClassTransformer;
    }

    @Override
    public void visit(int n, int n2, String string, String string2, String string3, String[] stringArray) {
        this.superName = string3;
        super.visit(n, n2, string, string2, string3, stringArray);
    }

    @Override
    public MethodVisitor visitMethod(int n, String string, String string2, String string3, String[] stringArray) {
        MethodVisitor methodVisitor = super.visitMethod(n, string, string2, string3, stringArray);
        Iterator<AsmHook> iterator2 = this.hooks.iterator();
        while (iterator2.hasNext()) {
            AsmHook asmHook = iterator2.next();
            if (!this.isTargetMethod(asmHook, string, string2)) continue;
            methodVisitor = asmHook.getInjectorFactory().createHookInjector(methodVisitor, n, string, string2, asmHook, this);
            iterator2.remove();
        }
        return methodVisitor;
    }

    @Override
    public void visitEnd() {
        while (!this.hooks.isEmpty()) {
            AsmHook asmHook = this.hooks.get(0);
            if (asmHook.getCreateMethod()) {
                asmHook.createMethod(this);
            }
            if (!this.hooks.contains(asmHook)) continue;
            this.notInjectedHooks.add(asmHook);
            this.hooks.remove(0);
        }
        super.visitEnd();
    }

    protected ClassMetadataReader.MethodReference findVirtualMethod(String string, String string2, String string3) {
        return this.transformer.classMetadataReader.findVirtualMethod(string, string2, string3);
    }

    protected boolean isTargetMethod(AsmHook asmHook, String string, String string2) {
        return asmHook.isTargetMethod(string, string2);
    }
}

