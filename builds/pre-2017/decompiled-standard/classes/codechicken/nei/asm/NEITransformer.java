/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.asm;

import codechicken.core.asm.ClassOverrider;
import codechicken.core.launch.CodeChickenCorePlugin;
import codechicken.lib.asm.ASMHelper;
import codechicken.lib.asm.ASMReader;
import codechicken.lib.asm.ClassHeirachyManager;
import codechicken.lib.asm.InstructionComparator;
import codechicken.lib.asm.ObfMapping;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import java.util.Map;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class NEITransformer
implements IClassTransformer {
    private Map<String, ASMReader.ASMBlock> asmblocks = ASMReader.loadResource("/assets/nei/asm/blocks.asm");
    private ObfMapping c_GuiContainer = new ObfMapping("awy");
    private ObfMapping c_BlockMobSpawner = new ObfMapping("api");
    private ObfMapping m_func_98281_h = new ObfMapping("abn", "h", "()Lnn;");
    private ObfMapping m_Block_init = new ObfMapping("aqz", "<init>", "(ILakc;)V");

    public byte[] transformer001(String string, byte[] byArray) {
        if (ClassHeirachyManager.classExtends(string, this.c_GuiContainer.javaClass())) {
            ClassNode classNode = ASMHelper.createClassNode(byArray);
            ObfMapping obfMapping = new ObfMapping("awe", "c", "()V");
            ObfMapping obfMapping2 = new ObfMapping(obfMapping, classNode.superName);
            InsnList insnList = new InsnList();
            insnList.add(new VarInsnNode(25, 0));
            insnList.add(obfMapping2.toInsn(183));
            boolean bl = false;
            for (MethodNode methodNode : classNode.methods) {
                InsnList insnList2;
                if (!obfMapping.matches(methodNode) || InstructionComparator.insnListMatches(insnList2 = InstructionComparator.getImportantList(methodNode.instructions), insnList, 0)) continue;
                methodNode.instructions.insertBefore(methodNode.instructions.getFirst(), insnList);
                System.out.println("Inserted super call into " + string + "." + obfMapping2.s_name);
                bl = true;
            }
            if (bl) {
                byArray = ASMHelper.createBytes(classNode, 3);
            }
        }
        return byArray;
    }

    public byte[] transformer002(String string, byte[] byArray) {
        if (this.c_BlockMobSpawner.isClass(string)) {
            ClassNode classNode = ASMHelper.createClassNode(byArray);
            ObfMapping obfMapping = new ObfMapping("aqz", "a", "(Labw;IIILof;Lye;)V");
            MethodVisitor methodVisitor = classNode.visitMethod(1, obfMapping.s_name, obfMapping.s_desc, null, null);
            methodVisitor.visitCode();
            this.asmblocks.get((Object)"mobspawner").insns.accept(methodVisitor);
            methodVisitor.visitMaxs(1, 4);
            byArray = ASMHelper.createBytes(classNode, 3);
            System.out.println("Generated BlockMobSpawner helper method.");
        }
        return byArray;
    }

    public byte[] transformer003(String string, byte[] byArray) {
        if (this.m_func_98281_h.isClass(string)) {
            ClassNode classNode = ASMHelper.createClassNode(byArray);
            MethodNode methodNode = ASMHelper.findMethod(this.m_func_98281_h, classNode);
            AbstractInsnNode abstractInsnNode = InstructionComparator.insnListFindStart(methodNode.instructions, this.asmblocks.get((Object)"needle4").insns).get(0);
            methodNode.instructions.insertBefore(abstractInsnNode, this.asmblocks.get((Object)"call4").insns);
            methodNode.instructions.remove(abstractInsnNode);
            byArray = ASMHelper.createBytes(classNode, 3);
        }
        return byArray;
    }

    public byte[] transformer004(String string, byte[] byArray) {
        if (this.m_Block_init.isClass(string)) {
            ClassNode classNode = ASMHelper.createClassNode(byArray);
            MethodNode methodNode = ASMHelper.findMethod(this.m_Block_init, classNode);
            AbstractInsnNode abstractInsnNode = InstructionComparator.insnListFindStart(methodNode.instructions, this.asmblocks.get((Object)"needle1").insns).get(0);
            AbstractInsnNode abstractInsnNode2 = InstructionComparator.insnListFindStart(methodNode.instructions, this.asmblocks.get((Object)"needle2").insns).get(0);
            methodNode.instructions.insertBefore(abstractInsnNode, this.asmblocks.get((Object)"call").insns);
            ASMHelper.removeBlock(methodNode.instructions, new InstructionComparator.InsnListSection(abstractInsnNode, abstractInsnNode2));
            InstructionComparator.InsnListSection insnListSection = InstructionComparator.insnListFindL(methodNode.instructions, this.asmblocks.get((Object)"needle3").insns).get(0);
            ASMReader.ASMBlock aSMBlock = this.asmblocks.get("pre3");
            methodNode.instructions.insertBefore(insnListSection.first, aSMBlock.insns);
            methodNode.instructions.insert(insnListSection.last, aSMBlock.get("LPOST3"));
            byArray = ASMHelper.createBytes(classNode, 3);
        }
        return byArray;
    }

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        try {
            if (FMLLaunchHandler.side().isClient()) {
                byArray = this.transformer001(string, byArray);
                byArray = this.transformer002(string, byArray);
                byArray = this.transformer003(string, byArray);
                byArray = this.transformer004(string, byArray);
                byArray = ClassOverrider.overrideBytes(string, byArray, new ObfMapping("awy"), CodeChickenCorePlugin.location);
            }
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return byArray;
    }
}

