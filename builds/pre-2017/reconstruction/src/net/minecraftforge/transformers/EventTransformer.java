/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.transformers;

import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraftforge.event.Event;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.FrameNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;

public class EventTransformer
implements IClassTransformer {
    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if (byArray == null || string.equals("net.minecraftforge.event.Event") || string.startsWith("net.minecraft.") || string.indexOf(46) == -1) {
            return byArray;
        }
        ClassReader classReader = new ClassReader(byArray);
        ClassNode classNode = new ClassNode();
        classReader.accept(classNode, 0);
        try {
            if (this.buildEvents(classNode)) {
                ClassWriter classWriter = new ClassWriter(3);
                classNode.accept(classWriter);
                return classWriter.toByteArray();
            }
            return byArray;
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return byArray;
    }

    private boolean buildEvents(ClassNode classNode) throws Exception {
        MethodNode methodNode2;
        Class<?> clazz = this.getClass().getClassLoader().loadClass(classNode.superName.replace('/', '.'));
        if (!Event.class.isAssignableFrom(clazz)) {
            return false;
        }
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        Class<?> clazz2 = Class.forName("net.minecraftforge.event.ListenerList", false, this.getClass().getClassLoader());
        Type type = Type.getType(clazz2);
        for (MethodNode methodNode2 : classNode.methods) {
            if (methodNode2.name.equals("setup") && methodNode2.desc.equals(Type.getMethodDescriptor(Type.VOID_TYPE, new Type[0])) && (methodNode2.access & 4) == 4) {
                bl = true;
            }
            if (methodNode2.name.equals("getListenerList") && methodNode2.desc.equals(Type.getMethodDescriptor(type, new Type[0])) && (methodNode2.access & 1) == 1) {
                bl2 = true;
            }
            if (!methodNode2.name.equals("<init>") || !methodNode2.desc.equals(Type.getMethodDescriptor(Type.VOID_TYPE, new Type[0]))) continue;
            bl3 = true;
        }
        if (bl) {
            if (!bl2) {
                throw new RuntimeException("Event class defines setup() but does not define getListenerList! " + classNode.name);
            }
            return false;
        }
        Type type2 = Type.getType(classNode.superName);
        classNode.fields.add(new FieldNode(10, "LISTENER_LIST", type.getDescriptor(), null, null));
        methodNode2 = new MethodNode(262144, 1, "<init>", Type.getMethodDescriptor(Type.VOID_TYPE, new Type[0]), null, null);
        methodNode2.instructions.add(new VarInsnNode(25, 0));
        methodNode2.instructions.add(new MethodInsnNode(183, type2.getInternalName(), "<init>", Type.getMethodDescriptor(Type.VOID_TYPE, new Type[0])));
        methodNode2.instructions.add(new InsnNode(177));
        if (!bl3) {
            classNode.methods.add(methodNode2);
        }
        methodNode2 = new MethodNode(262144, 4, "setup", Type.getMethodDescriptor(Type.VOID_TYPE, new Type[0]), null, null);
        methodNode2.instructions.add(new VarInsnNode(25, 0));
        methodNode2.instructions.add(new MethodInsnNode(183, type2.getInternalName(), "setup", Type.getMethodDescriptor(Type.VOID_TYPE, new Type[0])));
        methodNode2.instructions.add(new FieldInsnNode(178, classNode.name, "LISTENER_LIST", type.getDescriptor()));
        LabelNode labelNode = new LabelNode();
        methodNode2.instructions.add(new JumpInsnNode(198, labelNode));
        methodNode2.instructions.add(new InsnNode(177));
        methodNode2.instructions.add(labelNode);
        methodNode2.instructions.add(new FrameNode(3, 0, null, 0, null));
        methodNode2.instructions.add(new TypeInsnNode(187, type.getInternalName()));
        methodNode2.instructions.add(new InsnNode(89));
        methodNode2.instructions.add(new VarInsnNode(25, 0));
        methodNode2.instructions.add(new MethodInsnNode(183, type2.getInternalName(), "getListenerList", Type.getMethodDescriptor(type, new Type[0])));
        methodNode2.instructions.add(new MethodInsnNode(183, type.getInternalName(), "<init>", Type.getMethodDescriptor(Type.VOID_TYPE, type)));
        methodNode2.instructions.add(new FieldInsnNode(179, classNode.name, "LISTENER_LIST", type.getDescriptor()));
        methodNode2.instructions.add(new InsnNode(177));
        classNode.methods.add(methodNode2);
        methodNode2 = new MethodNode(262144, 1, "getListenerList", Type.getMethodDescriptor(type, new Type[0]), null, null);
        methodNode2.instructions.add(new FieldInsnNode(178, classNode.name, "LISTENER_LIST", type.getDescriptor()));
        methodNode2.instructions.add(new InsnNode(176));
        classNode.methods.add(methodNode2);
        return true;
    }
}

