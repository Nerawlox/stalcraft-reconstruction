/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.LabelNode;

public class LookupSwitchInsnNode
extends AbstractInsnNode {
    public LabelNode dflt;
    public List<Integer> keys;
    public List<LabelNode> labels;

    public LookupSwitchInsnNode(LabelNode dflt, int[] keys2, LabelNode[] labels) {
        super(171);
        this.dflt = dflt;
        this.keys = new ArrayList<Integer>(keys2 == null ? 0 : keys2.length);
        this.labels = new ArrayList<LabelNode>(labels == null ? 0 : labels.length);
        if (keys2 != null) {
            for (int i = 0; i < keys2.length; ++i) {
                this.keys.add(keys2[i]);
            }
        }
        if (labels != null) {
            this.labels.addAll(Arrays.asList(labels));
        }
    }

    @Override
    public int getType() {
        return 12;
    }

    @Override
    public void accept(MethodVisitor mv) {
        int[] keys2 = new int[this.keys.size()];
        for (int i = 0; i < keys2.length; ++i) {
            keys2[i] = this.keys.get(i);
        }
        Label[] labels = new Label[this.labels.size()];
        for (int i = 0; i < labels.length; ++i) {
            labels[i] = this.labels.get(i).getLabel();
        }
        mv.visitLookupSwitchInsn(this.dflt.getLabel(), keys2, labels);
        this.acceptAnnotations(mv);
    }

    @Override
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> labels) {
        LookupSwitchInsnNode clone = new LookupSwitchInsnNode(LookupSwitchInsnNode.clone(this.dflt, labels), null, LookupSwitchInsnNode.clone(this.labels, labels));
        clone.keys.addAll(this.keys);
        return clone.cloneAnnotations(this);
    }
}

