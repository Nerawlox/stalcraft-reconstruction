/*
 * Decompiled with CFR 0.152.
 */
package codechicken.obfuscator;

import codechicken.lib.asm.ObfMapping;
import codechicken.obfuscator.ObfRemapper;
import java.util.LinkedList;
import java.util.List;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

public class ConstantObfuscator
implements Opcodes {
    public ObfRemapper obf;
    public List<ObfMapping> descCalls = new LinkedList<ObfMapping>();
    public List<ObfMapping> classCalls = new LinkedList<ObfMapping>();

    public ConstantObfuscator(ObfRemapper obfRemapper, String[] stringArray, String[] stringArray2) {
        this.obf = obfRemapper;
        for (String string : stringArray) {
            this.classCalls.add(ObfMapping.fromDesc(string));
        }
        for (String string : stringArray2) {
            this.descCalls.add(ObfMapping.fromDesc(string));
        }
    }

    public void transform(ClassNode classNode) {
        for (MethodNode methodNode : classNode.methods) {
            for (AbstractInsnNode abstractInsnNode = methodNode.instructions.getFirst(); abstractInsnNode != null; abstractInsnNode = abstractInsnNode.getNext()) {
                this.obfuscateInsnSeq(abstractInsnNode);
            }
        }
    }

    private void obfuscateInsnSeq(AbstractInsnNode abstractInsnNode) {
        LdcInsnNode ldcInsnNode;
        if (this.matchesClass(abstractInsnNode)) {
            ldcInsnNode = (LdcInsnNode)abstractInsnNode;
            ldcInsnNode.cst = this.obf.map((String)ldcInsnNode.cst);
        }
        if (this.matchesDesc(abstractInsnNode)) {
            ldcInsnNode = (LdcInsnNode)abstractInsnNode;
            LdcInsnNode ldcInsnNode2 = (LdcInsnNode)ldcInsnNode.getNext();
            LdcInsnNode ldcInsnNode3 = (LdcInsnNode)ldcInsnNode2.getNext();
            ObfMapping obfMapping = new ObfMapping((String)ldcInsnNode.cst, (String)ldcInsnNode2.cst, (String)ldcInsnNode3.cst).map(this.obf);
            ldcInsnNode.cst = obfMapping.s_owner;
            ldcInsnNode2.cst = obfMapping.s_name;
            ldcInsnNode3.cst = obfMapping.s_desc;
        }
    }

    private boolean matchesClass(AbstractInsnNode abstractInsnNode) {
        if (abstractInsnNode.getType() != 9) {
            return false;
        }
        if ((abstractInsnNode = abstractInsnNode.getNext()) == null || abstractInsnNode.getType() != 5) {
            return false;
        }
        for (ObfMapping obfMapping : this.classCalls) {
            if (!obfMapping.matches((MethodInsnNode)abstractInsnNode)) continue;
            return true;
        }
        return false;
    }

    private boolean matchesDesc(AbstractInsnNode abstractInsnNode) {
        if (abstractInsnNode.getType() != 9) {
            return false;
        }
        if ((abstractInsnNode = abstractInsnNode.getNext()) == null || abstractInsnNode.getType() != 9) {
            return false;
        }
        if ((abstractInsnNode = abstractInsnNode.getNext()) == null || abstractInsnNode.getType() != 9) {
            return false;
        }
        if ((abstractInsnNode = abstractInsnNode.getNext()) == null || abstractInsnNode.getType() != 5) {
            return false;
        }
        for (ObfMapping obfMapping : this.descCalls) {
            if (!obfMapping.matches((MethodInsnNode)abstractInsnNode)) continue;
            return true;
        }
        return false;
    }
}

