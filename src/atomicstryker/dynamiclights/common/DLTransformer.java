/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.FMLLog
 *  net.minecraft.launchwrapper.IClassTransformer
 *  org.objectweb.asm.ClassReader
 *  org.objectweb.asm.ClassVisitor
 *  org.objectweb.asm.ClassWriter
 *  org.objectweb.asm.tree.AbstractInsnNode
 *  org.objectweb.asm.tree.ClassNode
 *  org.objectweb.asm.tree.FrameNode
 *  org.objectweb.asm.tree.InsnList
 *  org.objectweb.asm.tree.LineNumberNode
 *  org.objectweb.asm.tree.MethodInsnNode
 *  org.objectweb.asm.tree.MethodNode
 *  org.objectweb.asm.tree.VarInsnNode
 */
package atomicstryker.dynamiclights.common;

import cpw.mods.fml.common.FMLLog;
import java.util.ListIterator;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FrameNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LineNumberNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class DLTransformer
implements IClassTransformer {
    private final String classNameWorldObfusc = "abw";
    private final String classNameBlockAccessObfusc = "acf";
    private final String computeLightValueMethodNameO = "a";
    private final String enumSkyBlockObfusc = "ach";
    private final String classNameWorld = "net.minecraft.world.World";
    private final String blockAccessJava = "net/minecraft/world/IBlockAccess";
    private final String computeLightValueMethodName = "computeLightValue";

    public byte[] transform(String name, String newName, byte[] bytes) {
        return name.equals("abw") ? this.handleWorldTransform(bytes, true) : (name.equals("net.minecraft.world.World") ? this.handleWorldTransform(bytes, false) : bytes);
    }

    private byte[] handleWorldTransform(byte[] bytes, boolean obfuscated) {
        FMLLog.info((String)"**************** Dynamic Lights transform running on World *********************** ", (Object[])new Object[0]);
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept((ClassVisitor)classNode, 0);
        for (MethodNode writer : classNode.methods) {
            if (!writer.name.equals(obfuscated ? "a" : "computeLightValue") || !writer.desc.equals(obfuscated ? "(IIILach;)I" : "(IIILnet/minecraft/world/EnumSkyBlock;)I")) continue;
            FMLLog.info((String)"In target method! Patching!", (Object[])new Object[0]);
            AbstractInsnNode targetNode = null;
            ListIterator iter = writer.instructions.iterator();
            boolean deleting = false;
            boolean replacing = false;
            System.out.println("Patching method: name=" + writer.name + ", desc=" + writer.desc);
            while (iter.hasNext()) {
                targetNode = (AbstractInsnNode)iter.next();
                if (targetNode instanceof VarInsnNode) {
                    VarInsnNode toInject = (VarInsnNode)targetNode;
                    if (toInject.var == 6) {
                        if (toInject.getOpcode() == 58) {
                            FMLLog.info((String)"Bytecode ASTORE 6 case!", (Object[])new Object[0]);
                            deleting = true;
                            continue;
                        }
                        if (toInject.getOpcode() == 54) {
                            FMLLog.info((String)"Bytecode ISTORE 6 case!", (Object[])new Object[0]);
                            replacing = true;
                            targetNode = (AbstractInsnNode)iter.next();
                            break;
                        }
                    }
                    if (toInject.var == 7 && deleting) break;
                }
                if (!deleting) continue;
                String removeInfo = "Instruction: name=" + targetNode.toString().split("@")[0] + ", opcode=" + targetNode.getOpcode() + ", type=" + targetNode.getType();
                if (targetNode instanceof LineNumberNode) {
                    removeInfo = removeInfo + ", line=" + ((LineNumberNode)targetNode).line;
                } else if (targetNode instanceof VarInsnNode) {
                    removeInfo = removeInfo + ", var=" + ((VarInsnNode)targetNode).var;
                } else if (targetNode instanceof FrameNode) {
                    removeInfo = removeInfo + ", frametype=" + ((FrameNode)targetNode).type;
                } else if (targetNode instanceof MethodInsnNode) {
                    removeInfo = removeInfo + ", name=" + ((MethodInsnNode)targetNode).name + ", desc=" + ((MethodInsnNode)targetNode).desc + ", owner=" + ((MethodInsnNode)targetNode).owner;
                }
                System.out.println("Removing " + removeInfo);
                iter.remove();
            }
            InsnList toInject1 = new InsnList();
            toInject1.add((AbstractInsnNode)new VarInsnNode(25, 0));
            toInject1.add((AbstractInsnNode)new VarInsnNode(21, 5));
            toInject1.add((AbstractInsnNode)new VarInsnNode(21, 1));
            toInject1.add((AbstractInsnNode)new VarInsnNode(21, 2));
            toInject1.add((AbstractInsnNode)new VarInsnNode(21, 3));
            toInject1.add((AbstractInsnNode)new MethodInsnNode(184, "atomicstryker/dynamiclights/client/DynamicLights", "getLightValue", "(L" + (obfuscated ? "acf" : "net/minecraft/world/IBlockAccess") + ";IIII)I"));
            if (replacing) {
                toInject1.add((AbstractInsnNode)new VarInsnNode(54, 6));
            }
            writer.instructions.insertBefore(targetNode, toInject1);
            FMLLog.info((String)"Patching Complete!", (Object[])new Object[0]);
            break;
        }
        ClassWriter writer1 = new ClassWriter(3);
        classNode.accept((ClassVisitor)writer1);
        return writer1.toByteArray();
    }
}

