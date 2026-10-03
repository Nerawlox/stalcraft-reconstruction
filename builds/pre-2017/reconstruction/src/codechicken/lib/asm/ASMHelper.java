/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.asm;

import codechicken.lib.asm.CC_ClassWriter;
import codechicken.lib.asm.InsnListPrinter;
import codechicken.lib.asm.InstructionComparator;
import codechicken.lib.asm.ObfMapping;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Label;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LocalVariableNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TryCatchBlockNode;

public class ASMHelper {
    public static MethodNode findMethod(ObfMapping obfMapping, ClassNode classNode) {
        for (MethodNode methodNode : classNode.methods) {
            if (!obfMapping.matches(methodNode)) continue;
            return methodNode;
        }
        return null;
    }

    public static FieldNode findField(ObfMapping obfMapping, ClassNode classNode) {
        for (FieldNode fieldNode : classNode.fields) {
            if (!obfMapping.matches(fieldNode)) continue;
            return fieldNode;
        }
        return null;
    }

    public static ClassNode createClassNode(byte[] byArray) {
        return ASMHelper.createClassNode(byArray, 0);
    }

    public static ClassNode createClassNode(byte[] byArray, int n) {
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(byArray);
        classReader.accept(classNode, n);
        return classNode;
    }

    public static byte[] createBytes(ClassNode classNode, int n) {
        CC_ClassWriter cC_ClassWriter = new CC_ClassWriter(n);
        classNode.accept(cC_ClassWriter);
        return cC_ClassWriter.toByteArray();
    }

    public static byte[] writeMethods(String string, byte[] byArray, Multimap<String, MethodWriter> multimap) {
        if (multimap.containsKey(string)) {
            ClassNode classNode = ASMHelper.createClassNode(byArray);
            for (MethodWriter methodWriter : multimap.get(string)) {
                MethodNode methodNode = ASMHelper.findMethod(methodWriter.method, classNode);
                if (methodNode == null) {
                    methodNode = (MethodNode)classNode.visitMethod(methodWriter.access, methodWriter.method.s_name, methodWriter.method.s_desc, null, methodWriter.exceptions);
                }
                methodNode.access = methodWriter.access;
                methodNode.instructions.clear();
                methodWriter.write(methodNode);
            }
            byArray = ASMHelper.createBytes(classNode, 3);
        }
        return byArray;
    }

    public static byte[] injectMethods(String string, byte[] byArray, Multimap<String, MethodInjector> multimap) {
        if (multimap.containsKey(string)) {
            ClassNode classNode = ASMHelper.createClassNode(byArray);
            for (MethodInjector methodInjector : multimap.get(string)) {
                MethodNode methodNode = ASMHelper.findMethod(methodInjector.method, classNode);
                if (methodNode == null) {
                    throw new RuntimeException("Method not found: " + methodInjector.method);
                }
                System.out.println("Injecting into " + methodInjector.method + "\n" + ASMHelper.printInsnList(methodInjector.injection));
                List<AbstractInsnNode> list = methodInjector.before ? InstructionComparator.insnListFindStart(methodNode.instructions, methodInjector.needle) : InstructionComparator.insnListFindEnd(methodNode.instructions, methodInjector.needle);
                if (list.size() == 0) {
                    throw new RuntimeException("Needle not found in Haystack: " + methodInjector.method + "\n" + ASMHelper.printInsnList(methodInjector.needle));
                }
                for (AbstractInsnNode abstractInsnNode : list) {
                    if (methodInjector.before) {
                        System.out.println("Injected before: " + ASMHelper.printInsn(abstractInsnNode));
                        methodNode.instructions.insertBefore(abstractInsnNode, ASMHelper.cloneInsnList(methodInjector.injection));
                        continue;
                    }
                    System.out.println("Injected after: " + ASMHelper.printInsn(abstractInsnNode));
                    methodNode.instructions.insert(abstractInsnNode, ASMHelper.cloneInsnList(methodInjector.injection));
                }
            }
            byArray = ASMHelper.createBytes(classNode, 2);
        }
        return byArray;
    }

    public static String printInsnList(InsnList insnList) {
        InsnListPrinter insnListPrinter = new InsnListPrinter();
        insnListPrinter.visitInsnList(insnList);
        return insnListPrinter.textString();
    }

    public static String printInsn(AbstractInsnNode abstractInsnNode) {
        InsnListPrinter insnListPrinter = new InsnListPrinter();
        insnListPrinter.visitInsn(abstractInsnNode);
        return insnListPrinter.textString();
    }

    public static Map<LabelNode, LabelNode> cloneLabels(InsnList insnList) {
        HashMap<LabelNode, LabelNode> hashMap = new HashMap<LabelNode, LabelNode>();
        for (AbstractInsnNode abstractInsnNode = insnList.getFirst(); abstractInsnNode != null; abstractInsnNode = abstractInsnNode.getNext()) {
            if (abstractInsnNode.getType() != 8) continue;
            hashMap.put((LabelNode)abstractInsnNode, new LabelNode());
        }
        return hashMap;
    }

    public static InsnList cloneInsnList(InsnList insnList) {
        return ASMHelper.cloneInsnList(ASMHelper.cloneLabels(insnList), insnList);
    }

    public static InsnList cloneInsnList(Map<LabelNode, LabelNode> map, InsnList insnList) {
        InsnList insnList2 = new InsnList();
        for (AbstractInsnNode abstractInsnNode = insnList.getFirst(); abstractInsnNode != null; abstractInsnNode = abstractInsnNode.getNext()) {
            insnList2.add(abstractInsnNode.clone(map));
        }
        return insnList2;
    }

    public static List<TryCatchBlockNode> cloneTryCatchBlocks(Map<LabelNode, LabelNode> map, List<TryCatchBlockNode> list) {
        ArrayList<TryCatchBlockNode> arrayList = new ArrayList<TryCatchBlockNode>();
        for (TryCatchBlockNode tryCatchBlockNode : list) {
            arrayList.add(new TryCatchBlockNode(map.get(tryCatchBlockNode.start), map.get(tryCatchBlockNode.end), map.get(tryCatchBlockNode.handler), tryCatchBlockNode.type));
        }
        return arrayList;
    }

    public static List<LocalVariableNode> cloneLocals(Map<LabelNode, LabelNode> map, List<LocalVariableNode> list) {
        ArrayList<LocalVariableNode> arrayList = new ArrayList<LocalVariableNode>();
        for (LocalVariableNode localVariableNode : list) {
            arrayList.add(new LocalVariableNode(localVariableNode.name, localVariableNode.desc, localVariableNode.signature, map.get(localVariableNode.start), map.get(localVariableNode.end), localVariableNode.index));
        }
        return arrayList;
    }

    public static void copy(MethodNode methodNode, MethodNode methodNode2) {
        Map<LabelNode, LabelNode> map = ASMHelper.cloneLabels(methodNode.instructions);
        methodNode2.instructions = ASMHelper.cloneInsnList(map, methodNode.instructions);
        methodNode2.tryCatchBlocks = ASMHelper.cloneTryCatchBlocks(map, methodNode.tryCatchBlocks);
        if (methodNode.localVariables != null) {
            methodNode2.localVariables = ASMHelper.cloneLocals(map, methodNode.localVariables);
        }
        methodNode2.visibleAnnotations = methodNode.visibleAnnotations;
        methodNode2.invisibleAnnotations = methodNode.invisibleAnnotations;
        methodNode2.visitMaxs(methodNode.maxStack, methodNode.maxLocals);
    }

    public static byte[] alterMethods(String string, byte[] byArray, HashMultimap<String, MethodAltercator> hashMultimap) {
        if (hashMultimap.containsKey(string)) {
            ClassNode classNode = ASMHelper.createClassNode(byArray);
            for (MethodAltercator methodAltercator : hashMultimap.get((Object)string)) {
                MethodNode methodNode = ASMHelper.findMethod(methodAltercator.method, classNode);
                if (methodNode == null) {
                    throw new RuntimeException("Method not found: " + methodAltercator.method);
                }
                methodAltercator.alter(methodNode);
            }
            byArray = ASMHelper.createBytes(classNode, 3);
        }
        return byArray;
    }

    public static String printInsnList(InstructionComparator.InsnListSection insnListSection) {
        InsnListPrinter insnListPrinter = new InsnListPrinter();
        insnListPrinter.visitInsnList(insnListSection);
        return insnListPrinter.textString();
    }

    public static int getLocal(List<LocalVariableNode> list, String string) {
        int n = -1;
        for (LocalVariableNode localVariableNode : list) {
            if (!localVariableNode.name.equals(string)) continue;
            if (n >= 0) {
                throw new RuntimeException("Duplicate local variable: " + string + " not coded to handle this scenario.");
            }
            n = localVariableNode.index;
        }
        return n;
    }

    public static void replaceMethodCode(MethodNode methodNode, MethodNode methodNode2) {
        methodNode.instructions.clear();
        if (methodNode.localVariables != null) {
            methodNode.localVariables.clear();
        }
        if (methodNode.tryCatchBlocks != null) {
            methodNode.tryCatchBlocks.clear();
        }
        methodNode2.accept(methodNode);
    }

    public static void removeBlock(InsnList insnList, InstructionComparator.InsnListSection insnListSection) {
        AbstractInsnNode abstractInsnNode = insnListSection.first;
        while (true) {
            AbstractInsnNode abstractInsnNode2 = abstractInsnNode.getNext();
            insnList.remove(abstractInsnNode);
            if (abstractInsnNode == insnListSection.last) break;
            abstractInsnNode = abstractInsnNode2;
        }
    }

    public static class MethodInjector {
        public final ObfMapping method;
        public final InsnList needle;
        public final InsnList injection;
        public final boolean before;

        public MethodInjector(ObfMapping obfMapping, InsnList insnList, InsnList insnList2, boolean bl) {
            this.method = obfMapping;
            this.needle = insnList;
            this.injection = insnList2;
            this.before = bl;
        }
    }

    public static abstract class MethodWriter {
        public final int access;
        public final ObfMapping method;
        public final String[] exceptions;

        public MethodWriter(int n, ObfMapping obfMapping) {
            this(n, obfMapping, null);
        }

        public MethodWriter(int n, ObfMapping obfMapping, String[] stringArray) {
            this.access = n;
            this.method = obfMapping;
            this.exceptions = stringArray;
        }

        public abstract void write(MethodNode var1);
    }

    public static abstract class MethodAltercator {
        public final ObfMapping method;

        public MethodAltercator(ObfMapping obfMapping) {
            this.method = obfMapping;
        }

        public abstract void alter(MethodNode var1);
    }

    public static class ForBlock
    extends CodeBlock {
        public Label cmp = new Label();
        public Label inc = new Label();
        public Label body = new Label();
    }

    public static class CodeBlock {
        public Label start = new Label();
        public Label end = new Label();
    }
}

