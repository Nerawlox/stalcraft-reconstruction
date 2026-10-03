/*
 * Decompiled with CFR 0.152.
 */
package org.objectweb.asm.commons;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.LocalVariableNode;
import org.objectweb.asm.tree.LookupSwitchInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TableSwitchInsnNode;
import org.objectweb.asm.tree.TryCatchBlockNode;

public class JSRInlinerAdapter
extends MethodNode
implements Opcodes {
    private static final boolean LOGGING = false;
    private final Map<LabelNode, BitSet> subroutineHeads = new HashMap<LabelNode, BitSet>();
    private final BitSet mainSubroutine = new BitSet();
    final BitSet dualCitizens = new BitSet();

    public JSRInlinerAdapter(MethodVisitor mv, int access, String name2, String desc, String signature2, String[] exceptions) {
        this(393216, mv, access, name2, desc, signature2, exceptions);
        if (this.getClass() != JSRInlinerAdapter.class) {
            throw new IllegalStateException();
        }
    }

    protected JSRInlinerAdapter(int api, MethodVisitor mv, int access, String name2, String desc, String signature2, String[] exceptions) {
        super(api, access, name2, desc, signature2, exceptions);
        this.mv = mv;
    }

    @Override
    public void visitJumpInsn(int opcode, Label lbl) {
        super.visitJumpInsn(opcode, lbl);
        LabelNode ln = ((JumpInsnNode)this.instructions.getLast()).label;
        if (opcode == 168 && !this.subroutineHeads.containsKey(ln)) {
            this.subroutineHeads.put(ln, new BitSet());
        }
    }

    @Override
    public void visitEnd() {
        if (!this.subroutineHeads.isEmpty()) {
            this.markSubroutines();
            this.emitCode();
        }
        if (this.mv != null) {
            this.accept(this.mv);
        }
    }

    private void markSubroutines() {
        BitSet anyvisited = new BitSet();
        this.markSubroutineWalk(this.mainSubroutine, 0, anyvisited);
        for (Map.Entry<LabelNode, BitSet> entry : this.subroutineHeads.entrySet()) {
            LabelNode lab = entry.getKey();
            BitSet sub = entry.getValue();
            int index = this.instructions.indexOf(lab);
            this.markSubroutineWalk(sub, index, anyvisited);
        }
    }

    private void markSubroutineWalk(BitSet sub, int index, BitSet anyvisited) {
        this.markSubroutineWalkDFS(sub, index, anyvisited);
        boolean loop = true;
        while (loop) {
            loop = false;
            for (TryCatchBlockNode trycatch : this.tryCatchBlocks) {
                int handlerindex = this.instructions.indexOf(trycatch.handler);
                if (sub.get(handlerindex)) continue;
                int startindex = this.instructions.indexOf(trycatch.start);
                int endindex = this.instructions.indexOf(trycatch.end);
                int nextbit = sub.nextSetBit(startindex);
                if (nextbit == -1 || nextbit >= endindex) continue;
                this.markSubroutineWalkDFS(sub, handlerindex, anyvisited);
                loop = true;
            }
        }
    }

    private void markSubroutineWalkDFS(BitSet sub, int index, BitSet anyvisited) {
        do {
            LabelNode l;
            int i;
            int destidx;
            AbstractInsnNode node = this.instructions.get(index);
            if (sub.get(index)) {
                return;
            }
            sub.set(index);
            if (anyvisited.get(index)) {
                this.dualCitizens.set(index);
            }
            anyvisited.set(index);
            if (node.getType() == 7 && node.getOpcode() != 168) {
                JumpInsnNode jnode = (JumpInsnNode)node;
                destidx = this.instructions.indexOf(jnode.label);
                this.markSubroutineWalkDFS(sub, destidx, anyvisited);
            }
            if (node.getType() == 11) {
                TableSwitchInsnNode tsnode = (TableSwitchInsnNode)node;
                destidx = this.instructions.indexOf(tsnode.dflt);
                this.markSubroutineWalkDFS(sub, destidx, anyvisited);
                for (i = tsnode.labels.size() - 1; i >= 0; --i) {
                    l = tsnode.labels.get(i);
                    destidx = this.instructions.indexOf(l);
                    this.markSubroutineWalkDFS(sub, destidx, anyvisited);
                }
            }
            if (node.getType() == 12) {
                LookupSwitchInsnNode lsnode = (LookupSwitchInsnNode)node;
                destidx = this.instructions.indexOf(lsnode.dflt);
                this.markSubroutineWalkDFS(sub, destidx, anyvisited);
                for (i = lsnode.labels.size() - 1; i >= 0; --i) {
                    l = lsnode.labels.get(i);
                    destidx = this.instructions.indexOf(l);
                    this.markSubroutineWalkDFS(sub, destidx, anyvisited);
                }
            }
            switch (this.instructions.get(index).getOpcode()) {
                case 167: 
                case 169: 
                case 170: 
                case 171: 
                case 172: 
                case 173: 
                case 174: 
                case 175: 
                case 176: 
                case 177: 
                case 191: {
                    return;
                }
            }
        } while (++index < this.instructions.size());
    }

    private void emitCode() {
        LinkedList<Instantiation> worklist = new LinkedList<Instantiation>();
        worklist.add(new Instantiation(null, this.mainSubroutine));
        InsnList newInstructions = new InsnList();
        ArrayList<TryCatchBlockNode> newTryCatchBlocks = new ArrayList<TryCatchBlockNode>();
        ArrayList<LocalVariableNode> newLocalVariables = new ArrayList<LocalVariableNode>();
        while (!worklist.isEmpty()) {
            Instantiation inst = (Instantiation)worklist.removeFirst();
            this.emitSubroutine(inst, worklist, newInstructions, newTryCatchBlocks, newLocalVariables);
        }
        this.instructions = newInstructions;
        this.tryCatchBlocks = newTryCatchBlocks;
        this.localVariables = newLocalVariables;
    }

    private void emitSubroutine(Instantiation instant, List<Instantiation> worklist, InsnList newInstructions, List<TryCatchBlockNode> newTryCatchBlocks, List<LocalVariableNode> newLocalVariables) {
        LabelNode end;
        LabelNode start;
        LabelNode duplbl = null;
        int c = this.instructions.size();
        for (int i = 0; i < c; ++i) {
            AbstractInsnNode insn = this.instructions.get(i);
            Instantiation owner = instant.findOwner(i);
            if (insn.getType() == 8) {
                LabelNode ilbl = (LabelNode)insn;
                LabelNode remap = instant.rangeLabel(ilbl);
                if (remap == duplbl) continue;
                newInstructions.add(remap);
                duplbl = remap;
                continue;
            }
            if (owner != instant) continue;
            if (insn.getOpcode() == 169) {
                LabelNode retlabel = null;
                Instantiation p = instant;
                while (p != null) {
                    if (p.subroutine.get(i)) {
                        retlabel = p.returnLabel;
                    }
                    p = p.previous;
                }
                if (retlabel == null) {
                    throw new RuntimeException("Instruction #" + i + " is a RET not owned by any subroutine");
                }
                newInstructions.add(new JumpInsnNode(167, retlabel));
                continue;
            }
            if (insn.getOpcode() == 168) {
                LabelNode lbl = ((JumpInsnNode)insn).label;
                BitSet sub = this.subroutineHeads.get(lbl);
                Instantiation newinst = new Instantiation(instant, sub);
                LabelNode startlbl = newinst.gotoLabel(lbl);
                newInstructions.add(new InsnNode(1));
                newInstructions.add(new JumpInsnNode(167, startlbl));
                newInstructions.add(newinst.returnLabel);
                worklist.add(newinst);
                continue;
            }
            newInstructions.add(insn.clone(instant));
        }
        for (TryCatchBlockNode trycatch : this.tryCatchBlocks) {
            start = instant.rangeLabel(trycatch.start);
            if (start == (end = instant.rangeLabel(trycatch.end))) continue;
            LabelNode handler = instant.gotoLabel(trycatch.handler);
            if (start == null || end == null || handler == null) {
                throw new RuntimeException("Internal error!");
            }
            newTryCatchBlocks.add(new TryCatchBlockNode(start, end, handler, trycatch.type));
        }
        for (LocalVariableNode lvnode : this.localVariables) {
            start = instant.rangeLabel(lvnode.start);
            if (start == (end = instant.rangeLabel(lvnode.end))) continue;
            newLocalVariables.add(new LocalVariableNode(lvnode.name, lvnode.desc, lvnode.signature, start, end, lvnode.index));
        }
    }

    private static void log(String str) {
        System.err.println(str);
    }

    private class Instantiation
    extends AbstractMap<LabelNode, LabelNode> {
        final Instantiation previous;
        public final BitSet subroutine;
        public final Map<LabelNode, LabelNode> rangeTable = new HashMap<LabelNode, LabelNode>();
        public final LabelNode returnLabel;

        Instantiation(Instantiation prev, BitSet sub) {
            this.previous = prev;
            this.subroutine = sub;
            Instantiation p = prev;
            while (p != null) {
                if (p.subroutine == sub) {
                    throw new RuntimeException("Recursive invocation of " + sub);
                }
                p = p.previous;
            }
            this.returnLabel = prev != null ? new LabelNode() : null;
            LabelNode duplbl = null;
            int c = JSRInlinerAdapter.this.instructions.size();
            for (int i = 0; i < c; ++i) {
                AbstractInsnNode insn = JSRInlinerAdapter.this.instructions.get(i);
                if (insn.getType() == 8) {
                    LabelNode ilbl = (LabelNode)insn;
                    if (duplbl == null) {
                        duplbl = new LabelNode();
                    }
                    this.rangeTable.put(ilbl, duplbl);
                    continue;
                }
                if (this.findOwner(i) != this) continue;
                duplbl = null;
            }
        }

        public Instantiation findOwner(int i) {
            if (!this.subroutine.get(i)) {
                return null;
            }
            if (!JSRInlinerAdapter.this.dualCitizens.get(i)) {
                return this;
            }
            Instantiation own = this;
            Instantiation p = this.previous;
            while (p != null) {
                if (p.subroutine.get(i)) {
                    own = p;
                }
                p = p.previous;
            }
            return own;
        }

        public LabelNode gotoLabel(LabelNode l) {
            Instantiation owner = this.findOwner(JSRInlinerAdapter.this.instructions.indexOf(l));
            return owner.rangeTable.get(l);
        }

        public LabelNode rangeLabel(LabelNode l) {
            return this.rangeTable.get(l);
        }

        @Override
        public Set<Map.Entry<LabelNode, LabelNode>> entrySet() {
            return null;
        }

        @Override
        public LabelNode get(Object o) {
            return this.gotoLabel((LabelNode)o);
        }
    }
}

