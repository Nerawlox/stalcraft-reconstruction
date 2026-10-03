/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.asm;

import codechicken.core.asm.CodeChickenCoreModContainer;
import codechicken.lib.asm.ASMHelper;
import codechicken.lib.asm.ASMReader;
import codechicken.lib.asm.InstructionComparator;
import codechicken.lib.asm.ObfMapping;
import codechicken.lib.config.ConfigTag;
import com.google.common.collect.HashMultimap;
import java.util.List;
import java.util.Map;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodNode;

public class TweakTransformer
implements IClassTransformer,
Opcodes {
    private static HashMultimap<String, ASMHelper.MethodAltercator> altercators = HashMultimap.create();
    private static Map<String, ASMReader.ASMBlock> blocks = ASMReader.loadResource("/assets/codechickencore/asm/tweaks.asm");
    public static ConfigTag tweaks;

    public static void load() {
        tweaks = CodeChickenCoreModContainer.config.getTag("tweaks").setComment("Various tweaks that can be applied to game mechanics.").useBraces();
        tweaks.removeTag("persistantLava");
        if (tweaks.getTag("environmentallyFriendlyCreepers").setComment("If set to true, creepers will not destroy landscape. (A version of mobGreifing setting just for creepers)").getBooleanValue(false)) {
            TweakTransformer.alterMethod(new ASMHelper.MethodAltercator(new ObfMapping("tf", "l_", "()V")){

                @Override
                public void alter(MethodNode methodNode) {
                    InsnList insnList = ((ASMReader.ASMBlock)blocks.get((Object)"environmentallyFriendlyCreepers")).insns;
                    List<InstructionComparator.InsnListSection> list = InstructionComparator.insnListFindL(methodNode.instructions, insnList);
                    if (list.size() != 1) {
                        throw new RuntimeException("Needle found " + list.size() + " times in Haystack: " + methodNode.instructions + "\n" + ASMHelper.printInsnList(insnList));
                    }
                    InstructionComparator.InsnListSection insnListSection = list.get(0);
                    methodNode.instructions.insertBefore(insnListSection.first, new InsnNode(3));
                    ASMHelper.removeBlock(methodNode.instructions, insnListSection);
                }
            });
        }
        if (!tweaks.getTag("softLeafReplace").setComment("If set to false, leaves will only replace air when growing").getBooleanValue(false)) {
            TweakTransformer.alterMethod(new ASMHelper.MethodAltercator(new ObfMapping("aqz", "canBeReplacedByLeaves", "(Labw;III)Z")){

                @Override
                public void alter(MethodNode methodNode) {
                    methodNode.instructions = ((ASMReader.ASMBlock)blocks.get((Object)"softLeafReplace")).insns;
                }
            });
        }
        if (tweaks.getTag("finiteWater").setComment("If set to true two adjacent water source blocks will not generate a third.").getBooleanValue(false)) {
            TweakTransformer.alterMethod(new ASMHelper.MethodAltercator(new ObfMapping("apd", "a", "(Labw;IIILjava/util/Random;)V")){

                @Override
                public void alter(MethodNode methodNode) {
                    InsnList insnList = ((ASMReader.ASMBlock)blocks.get((Object)"finiteWater")).insns;
                    List<InstructionComparator.InsnListSection> list = InstructionComparator.insnListFindL(methodNode.instructions, insnList);
                    if (list.size() != 1) {
                        throw new RuntimeException("Needle found " + list.size() + " times in Haystack: " + methodNode.instructions + "\n" + ASMHelper.printInsnList(insnList));
                    }
                    InstructionComparator.InsnListSection insnListSection = list.get(0);
                    LabelNode labelNode = ((JumpInsnNode)insnListSection.last).label;
                    insnListSection.last = labelNode;
                    ASMHelper.removeBlock(methodNode.instructions, insnListSection);
                }
            });
        }
    }

    private static void alterMethod(ASMHelper.MethodAltercator methodAltercator) {
        altercators.put((Object)methodAltercator.method.javaClass(), (Object)methodAltercator);
    }

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        byArray = ASMHelper.alterMethods(string, byArray, altercators);
        return byArray;
    }
}

