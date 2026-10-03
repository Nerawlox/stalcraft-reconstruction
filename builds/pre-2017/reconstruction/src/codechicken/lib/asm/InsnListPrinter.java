/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.asm;

import codechicken.lib.asm.InstructionComparator;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import org.objectweb.asm.Label;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.FrameNode;
import org.objectweb.asm.tree.IincInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.LineNumberNode;
import org.objectweb.asm.tree.LookupSwitchInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.objectweb.asm.tree.TableSwitchInsnNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;
import org.objectweb.asm.util.Textifier;

public class InsnListPrinter
extends Textifier {
    private boolean buildingLabelMap = false;

    public void visitInsnList(InsnList insnList) {
        AbstractInsnNode abstractInsnNode;
        this.text.clear();
        if (this.labelNames == null) {
            this.labelNames = new HashMap();
        } else {
            this.labelNames.clear();
        }
        this.buildingLabelMap = true;
        for (abstractInsnNode = insnList.getFirst(); abstractInsnNode != null; abstractInsnNode = abstractInsnNode.getNext()) {
            if (abstractInsnNode.getType() != 8) continue;
            this.visitLabel(((LabelNode)abstractInsnNode).getLabel());
        }
        this.text.clear();
        this.buildingLabelMap = false;
        for (abstractInsnNode = insnList.getFirst(); abstractInsnNode != null; abstractInsnNode = abstractInsnNode.getNext()) {
            this._visitInsn(abstractInsnNode);
        }
    }

    public void visitInsnList(InstructionComparator.InsnListSection insnListSection) {
        this.text.clear();
        if (this.labelNames == null) {
            this.labelNames = new HashMap();
        } else {
            this.labelNames.clear();
        }
        this.buildingLabelMap = true;
        AbstractInsnNode abstractInsnNode = insnListSection.first;
        while (true) {
            if (abstractInsnNode.getType() == 8) {
                this.visitLabel(((LabelNode)abstractInsnNode).getLabel());
            }
            if (abstractInsnNode == insnListSection.last) break;
            abstractInsnNode = abstractInsnNode.getNext();
        }
        this.text.clear();
        this.buildingLabelMap = false;
        abstractInsnNode = insnListSection.first;
        while (true) {
            this._visitInsn(abstractInsnNode);
            if (abstractInsnNode == insnListSection.last) break;
            abstractInsnNode = abstractInsnNode.getNext();
        }
    }

    public void visitInsn(AbstractInsnNode abstractInsnNode) {
        this.text.clear();
        if (this.labelNames == null) {
            this.labelNames = new HashMap();
        } else {
            this.labelNames.clear();
        }
        this._visitInsn(abstractInsnNode);
    }

    private void _visitInsn(AbstractInsnNode abstractInsnNode) {
        switch (abstractInsnNode.getType()) {
            case 0: {
                this.visitInsn(abstractInsnNode.getOpcode());
                break;
            }
            case 1: {
                IntInsnNode intInsnNode = (IntInsnNode)abstractInsnNode;
                this.visitIntInsn(intInsnNode.getOpcode(), intInsnNode.operand);
                break;
            }
            case 2: {
                VarInsnNode varInsnNode = (VarInsnNode)abstractInsnNode;
                this.visitVarInsn(varInsnNode.getOpcode(), varInsnNode.var);
                break;
            }
            case 3: {
                TypeInsnNode typeInsnNode = (TypeInsnNode)abstractInsnNode;
                this.visitTypeInsn(typeInsnNode.getOpcode(), typeInsnNode.desc);
                break;
            }
            case 4: {
                FieldInsnNode fieldInsnNode = (FieldInsnNode)abstractInsnNode;
                this.visitFieldInsn(fieldInsnNode.getOpcode(), fieldInsnNode.owner, fieldInsnNode.name, fieldInsnNode.desc);
                break;
            }
            case 5: {
                MethodInsnNode methodInsnNode = (MethodInsnNode)abstractInsnNode;
                this.visitMethodInsn(methodInsnNode.getOpcode(), methodInsnNode.owner, methodInsnNode.name, methodInsnNode.desc);
                break;
            }
            case 6: {
                InvokeDynamicInsnNode invokeDynamicInsnNode = (InvokeDynamicInsnNode)abstractInsnNode;
                this.visitInvokeDynamicInsn(invokeDynamicInsnNode.name, invokeDynamicInsnNode.desc, invokeDynamicInsnNode.bsm, invokeDynamicInsnNode.bsmArgs);
                break;
            }
            case 7: {
                JumpInsnNode jumpInsnNode = (JumpInsnNode)abstractInsnNode;
                this.visitJumpInsn(jumpInsnNode.getOpcode(), jumpInsnNode.label.getLabel());
                break;
            }
            case 8: {
                LabelNode labelNode = (LabelNode)abstractInsnNode;
                this.visitLabel(labelNode.getLabel());
                break;
            }
            case 9: {
                LdcInsnNode ldcInsnNode = (LdcInsnNode)abstractInsnNode;
                this.visitLdcInsn(ldcInsnNode.cst);
                break;
            }
            case 10: {
                IincInsnNode iincInsnNode = (IincInsnNode)abstractInsnNode;
                this.visitIincInsn(iincInsnNode.var, iincInsnNode.incr);
                break;
            }
            case 11: {
                TableSwitchInsnNode tableSwitchInsnNode = (TableSwitchInsnNode)abstractInsnNode;
                Label[] labelArray = new Label[tableSwitchInsnNode.labels.size()];
                for (int i = 0; i < labelArray.length; ++i) {
                    labelArray[i] = tableSwitchInsnNode.labels.get(i).getLabel();
                }
                this.visitTableSwitchInsn(tableSwitchInsnNode.min, tableSwitchInsnNode.max, tableSwitchInsnNode.dflt.getLabel(), labelArray);
                break;
            }
            case 12: {
                LookupSwitchInsnNode lookupSwitchInsnNode = (LookupSwitchInsnNode)abstractInsnNode;
                Label[] labelArray = new Label[lookupSwitchInsnNode.labels.size()];
                for (int i = 0; i < labelArray.length; ++i) {
                    labelArray[i] = lookupSwitchInsnNode.labels.get(i).getLabel();
                }
                int[] nArray = new int[lookupSwitchInsnNode.keys.size()];
                for (int i = 0; i < nArray.length; ++i) {
                    nArray[i] = lookupSwitchInsnNode.keys.get(i);
                }
                this.visitLookupSwitchInsn(lookupSwitchInsnNode.dflt.getLabel(), nArray, labelArray);
                break;
            }
            case 13: {
                MultiANewArrayInsnNode multiANewArrayInsnNode = (MultiANewArrayInsnNode)abstractInsnNode;
                this.visitMultiANewArrayInsn(multiANewArrayInsnNode.desc, multiANewArrayInsnNode.dims);
                break;
            }
            case 14: {
                FrameNode frameNode = (FrameNode)abstractInsnNode;
                switch (frameNode.type) {
                    case -1: 
                    case 0: {
                        this.visitFrame(frameNode.type, frameNode.local.size(), frameNode.local.toArray(), frameNode.stack.size(), frameNode.stack.toArray());
                        break;
                    }
                    case 1: {
                        this.visitFrame(frameNode.type, frameNode.local.size(), frameNode.local.toArray(), 0, null);
                        break;
                    }
                    case 2: {
                        this.visitFrame(frameNode.type, frameNode.local.size(), null, 0, null);
                        break;
                    }
                    case 3: {
                        this.visitFrame(frameNode.type, 0, null, 0, null);
                        break;
                    }
                    case 4: {
                        this.visitFrame(frameNode.type, 0, null, 1, frameNode.stack.toArray());
                    }
                }
                break;
            }
            case 15: {
                LineNumberNode lineNumberNode = (LineNumberNode)abstractInsnNode;
                this.visitLineNumber(lineNumberNode.line, lineNumberNode.start.getLabel());
            }
        }
    }

    @Override
    public void visitLabel(Label label) {
        if (!this.buildingLabelMap && !this.labelNames.containsKey(label)) {
            this.labelNames.put(label, "LEXT" + this.labelNames.size());
        }
        super.visitLabel(label);
    }

    public String textString() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        this.print(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }
}

