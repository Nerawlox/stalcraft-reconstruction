/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.asm;

import codechicken.lib.asm.ObfMapping;
import java.util.AbstractSequentialList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.IincInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.LineNumberNode;
import org.objectweb.asm.tree.LookupSwitchInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.TableSwitchInsnNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;

public class InstructionComparator {
    public static boolean varInsnEqual(VarInsnNode varInsnNode, VarInsnNode varInsnNode2) {
        if (varInsnNode.var == -1 || varInsnNode2.var == -1) {
            return true;
        }
        return varInsnNode.var == varInsnNode2.var;
    }

    public static boolean methodInsnEqual(AbstractInsnNode abstractInsnNode, int n, ObfMapping obfMapping) {
        if (!(abstractInsnNode instanceof MethodInsnNode) || abstractInsnNode.getOpcode() != n) {
            return false;
        }
        return obfMapping.matches((MethodInsnNode)abstractInsnNode);
    }

    public static boolean methodInsnEqual(MethodInsnNode methodInsnNode, MethodInsnNode methodInsnNode2) {
        return methodInsnNode.owner.equals(methodInsnNode2.owner) && methodInsnNode.name.equals(methodInsnNode2.name) && methodInsnNode.desc.equals(methodInsnNode2.desc);
    }

    public static boolean fieldInsnEqual(FieldInsnNode fieldInsnNode, FieldInsnNode fieldInsnNode2) {
        return fieldInsnNode.owner.equals(fieldInsnNode2.owner) && fieldInsnNode.name.equals(fieldInsnNode2.name) && fieldInsnNode.desc.equals(fieldInsnNode2.desc);
    }

    public static boolean ldcInsnEqual(LdcInsnNode ldcInsnNode, LdcInsnNode ldcInsnNode2) {
        if (ldcInsnNode.cst.equals("~") || ldcInsnNode2.cst.equals("~")) {
            return true;
        }
        return ldcInsnNode.cst.equals(ldcInsnNode2.cst);
    }

    public static boolean typeInsnEqual(TypeInsnNode typeInsnNode, TypeInsnNode typeInsnNode2) {
        if (typeInsnNode.desc.equals("~") || typeInsnNode2.desc.equals("~")) {
            return true;
        }
        return typeInsnNode.desc.equals(typeInsnNode2.desc);
    }

    public static boolean iincInsnEqual(IincInsnNode iincInsnNode, IincInsnNode iincInsnNode2) {
        return iincInsnNode.var == iincInsnNode2.var && iincInsnNode.incr == iincInsnNode2.incr;
    }

    public static boolean intInsnEqual(IntInsnNode intInsnNode, IntInsnNode intInsnNode2) {
        if (intInsnNode.operand == -1 || intInsnNode2.operand == -1) {
            return true;
        }
        return intInsnNode.operand == intInsnNode2.operand;
    }

    public static boolean insnEqual(AbstractInsnNode abstractInsnNode, AbstractInsnNode abstractInsnNode2) {
        if (abstractInsnNode.getOpcode() != abstractInsnNode2.getOpcode()) {
            return false;
        }
        switch (abstractInsnNode2.getType()) {
            case 2: {
                return InstructionComparator.varInsnEqual((VarInsnNode)abstractInsnNode, (VarInsnNode)abstractInsnNode2);
            }
            case 3: {
                return InstructionComparator.typeInsnEqual((TypeInsnNode)abstractInsnNode, (TypeInsnNode)abstractInsnNode2);
            }
            case 4: {
                return InstructionComparator.fieldInsnEqual((FieldInsnNode)abstractInsnNode, (FieldInsnNode)abstractInsnNode2);
            }
            case 5: {
                return InstructionComparator.methodInsnEqual((MethodInsnNode)abstractInsnNode, (MethodInsnNode)abstractInsnNode2);
            }
            case 9: {
                return InstructionComparator.ldcInsnEqual((LdcInsnNode)abstractInsnNode, (LdcInsnNode)abstractInsnNode2);
            }
            case 10: {
                return InstructionComparator.iincInsnEqual((IincInsnNode)abstractInsnNode, (IincInsnNode)abstractInsnNode2);
            }
            case 1: {
                return InstructionComparator.intInsnEqual((IntInsnNode)abstractInsnNode, (IntInsnNode)abstractInsnNode2);
            }
        }
        return true;
    }

    public static InsnList getImportantList(InsnList insnList) {
        Object object;
        if (insnList.size() == 0) {
            return insnList;
        }
        HashMap<LabelNode, LabelNode> hashMap = new HashMap<LabelNode, LabelNode>();
        for (object = insnList.getFirst(); object != null; object = ((AbstractInsnNode)object).getNext()) {
            if (!(object instanceof LabelNode)) continue;
            hashMap.put((LabelNode)object, (LabelNode)object);
        }
        object = new InsnList();
        for (AbstractInsnNode abstractInsnNode = insnList.getFirst(); abstractInsnNode != null; abstractInsnNode = abstractInsnNode.getNext()) {
            if (abstractInsnNode instanceof LabelNode || abstractInsnNode instanceof LineNumberNode) continue;
            ((InsnList)object).add(abstractInsnNode.clone(hashMap));
        }
        return object;
    }

    public static boolean insnListMatches(InsnList insnList, InsnList insnList2, int n) {
        if (insnList.size() - n < insnList2.size()) {
            return false;
        }
        for (int i = 0; i < insnList2.size(); ++i) {
            if (InstructionComparator.insnEqual(insnList.get(i + n), insnList2.get(i))) continue;
            return false;
        }
        return true;
    }

    public static List<Integer> insnListFind(InsnList insnList, InsnList insnList2) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i <= insnList.size() - insnList2.size(); ++i) {
            if (!InstructionComparator.insnListMatches(insnList, insnList2, i)) continue;
            linkedList.add(i);
        }
        return linkedList;
    }

    public static List<AbstractInsnNode> insnListFindStart(InsnList insnList, InsnList insnList2) {
        LinkedList<AbstractInsnNode> linkedList = new LinkedList<AbstractInsnNode>();
        for (int n : InstructionComparator.insnListFind(insnList, insnList2)) {
            linkedList.add(insnList.get(n));
        }
        return linkedList;
    }

    public static List<AbstractInsnNode> insnListFindEnd(InsnList insnList, InsnList insnList2) {
        LinkedList<AbstractInsnNode> linkedList = new LinkedList<AbstractInsnNode>();
        for (int n : InstructionComparator.insnListFind(insnList, insnList2)) {
            linkedList.add(insnList.get(n + insnList2.size() - 1));
        }
        return linkedList;
    }

    public static List<InsnListSection> insnListFindL(InsnList insnList, InsnList insnList2) {
        Iterator iterator2;
        Object object2;
        Object object3;
        HashSet<LabelNode> hashSet = new HashSet<LabelNode>();
        block6: for (object3 = insnList.getFirst(); object3 != null; object3 = ((AbstractInsnNode)object3).getNext()) {
            switch (((AbstractInsnNode)object3).getType()) {
                case 8: 
                case 15: {
                    continue block6;
                }
                case 7: {
                    JumpInsnNode jumpInsnNode = (JumpInsnNode)object3;
                    hashSet.add(jumpInsnNode.label);
                    continue block6;
                }
                case 11: {
                    object2 = (TableSwitchInsnNode)object3;
                    for (LabelNode labelNode : ((TableSwitchInsnNode)object2).labels) {
                        hashSet.add(labelNode);
                    }
                    continue block6;
                }
                case 12: {
                    iterator2 = (LookupSwitchInsnNode)object3;
                    for (LabelNode labelNode : ((LookupSwitchInsnNode)((Object)iterator2)).labels) {
                        hashSet.add(labelNode);
                    }
                    continue block6;
                }
            }
        }
        object3 = new LinkedList();
        block9: for (int i = 0; i <= insnList.size() - insnList2.size(); ++i) {
            object2 = InstructionComparator.insnListMatchesL(insnList, insnList2, i, hashSet);
            if (object2 == null) continue;
            iterator2 = ((AbstractSequentialList)object3).iterator();
            while (iterator2.hasNext()) {
                InsnListSection insnListSection = (InsnListSection)iterator2.next();
                if (insnListSection.last != ((InsnListSection)object2).last) continue;
                continue block9;
            }
            ((LinkedList)object3).add(object2);
        }
        return object3;
    }

    private static InsnListSection insnListMatchesL(InsnList insnList, InsnList insnList2, int n, HashSet<LabelNode> hashSet) {
        int n2;
        int n3 = 0;
        for (n2 = n; n2 < insnList.size() && n3 < insnList2.size(); ++n2) {
            AbstractInsnNode abstractInsnNode = insnList.get(n2);
            if (abstractInsnNode.getType() == 15 || abstractInsnNode.getType() == 8 && !hashSet.contains(abstractInsnNode)) continue;
            if (!InstructionComparator.insnEqual(insnList.get(n2), insnList2.get(n3))) {
                return null;
            }
            ++n3;
        }
        if (n3 != insnList2.size()) {
            return null;
        }
        return new InsnListSection(insnList, n, n2 - 1);
    }

    public static class InsnListSection {
        public AbstractInsnNode first;
        public AbstractInsnNode last;

        public InsnListSection(AbstractInsnNode abstractInsnNode, AbstractInsnNode abstractInsnNode2) {
            this.first = abstractInsnNode;
            this.last = abstractInsnNode2;
        }

        public InsnListSection(InsnList insnList, int n, int n2) {
            this(insnList.get(n), insnList.get(n2));
        }
    }
}

