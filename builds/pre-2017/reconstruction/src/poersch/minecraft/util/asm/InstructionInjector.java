/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.asm;

import gloomyfolken.hooklib.asm.SafeClassWriter;
import gloomyfolken.hooklib.minecraft.HookLoader;
import java.util.ListIterator;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import poersch.minecraft.util.asm.IClassPatcher;

public class InstructionInjector
implements IClassPatcher {
    public static final int insertAtStart = 0;
    public static final int insertAtEnd = 1;
    private final MethodNode methodNode;
    private final MethodInsnNode targetMethodNode;
    private final int offset;
    private final int mode;

    public InstructionInjector(MethodNode methodNode, MethodInsnNode methodInsnNode, int n) {
        this.methodNode = methodNode;
        this.targetMethodNode = methodInsnNode;
        this.offset = n;
        this.mode = 0;
    }

    public InstructionInjector(MethodNode methodNode, int n) {
        this.methodNode = methodNode;
        this.targetMethodNode = null;
        this.offset = 0;
        this.mode = n;
    }

    public InstructionInjector(MethodNode methodNode) {
        this(methodNode, 0);
    }

    @Override
    public byte[] patchClass(String string, byte[] byArray) {
        System.out.println("[InstructionInjector] Found class:" + string);
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(byArray);
        classReader.accept(classNode, 0);
        block0: for (MethodNode object2 : classNode.methods) {
            if (!object2.name.equals(this.methodNode.name) || !object2.desc.equals(this.methodNode.desc)) continue;
            System.out.println("[InstructionInjector] Found method: " + this.methodNode.name + this.methodNode.desc);
            if (this.targetMethodNode == null) {
                if (this.mode == 0) {
                    object2.instructions.insert(this.methodNode.instructions);
                    System.out.println("[InstructionInjector] Injected instructions at the beginning of: " + this.methodNode.name + this.methodNode.desc);
                    break;
                }
                object2.instructions.insertBefore(object2.instructions.get(object2.instructions.size() - 2), this.methodNode.instructions);
                System.out.println("[InstructionInjector] Injected instructions at the end of: " + this.methodNode.name + this.methodNode.desc);
                break;
            }
            ListIterator<AbstractInsnNode> listIterator = object2.instructions.iterator();
            int n = 0;
            while (listIterator.hasNext()) {
                AbstractInsnNode abstractInsnNode = (AbstractInsnNode)listIterator.next();
                if (abstractInsnNode.getType() == this.targetMethodNode.getType() && abstractInsnNode.getOpcode() == this.targetMethodNode.getOpcode()) {
                    MethodInsnNode methodInsnNode = (MethodInsnNode)abstractInsnNode;
                    if (methodInsnNode.owner.equals(this.targetMethodNode.owner) && methodInsnNode.name.equals(this.targetMethodNode.name) && methodInsnNode.desc.equals(this.targetMethodNode.desc) && n + this.offset >= 0 && n + this.offset < object2.instructions.size()) {
                        object2.instructions.insertBefore(object2.instructions.get(n + this.offset), this.methodNode.instructions);
                        System.out.println("[InstructionInjector] Injected instructions (" + this.offset + ") " + (this.offset > 0 ? "after" : "before") + ": " + this.methodNode.name + this.methodNode.desc);
                        break block0;
                    }
                }
                ++n;
            }
            break block0;
        }
        SafeClassWriter safeClassWriter = new SafeClassWriter(HookLoader.getDeobfuscationMetadataReader(), 2);
        classNode.accept(safeClassWriter);
        return safeClassWriter.toByteArray();
    }
}

