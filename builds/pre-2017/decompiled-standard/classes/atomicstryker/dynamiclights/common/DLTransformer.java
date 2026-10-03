/*
 * Decompiled with CFR 0.152.
 */
package atomicstryker.dynamiclights.common;

import java.util.ListIterator;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
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

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if (string.equals("abw")) {
            return this.handleWorldTransform(byArray, true);
        }
        if (string.equals("net.minecraft.world.World")) {
            return this.handleWorldTransform(byArray, false);
        }
        return byArray;
    }

    private byte[] handleWorldTransform(byte[] byArray, boolean bl) {
        System.out.println("**************** Dynamic Lights transform running on World *********************** ");
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(byArray);
        classReader.accept(classNode, 0);
        for (MethodNode object2 : classNode.methods) {
            Object object;
            if (!object2.name.equals(bl ? "a" : "computeLightValue") || !object2.desc.equals(bl ? "(IIILach;)I" : "(IIILnet/minecraft/world/EnumSkyBlock;)I")) continue;
            System.out.println("In target method! Patching!");
            AbstractInsnNode abstractInsnNode = null;
            ListIterator<AbstractInsnNode> listIterator = object2.instructions.iterator();
            boolean bl2 = false;
            boolean bl3 = false;
            while (listIterator.hasNext()) {
                abstractInsnNode = (AbstractInsnNode)listIterator.next();
                if (abstractInsnNode instanceof VarInsnNode) {
                    object = (VarInsnNode)abstractInsnNode;
                    if (((VarInsnNode)object).var == 6) {
                        if (((AbstractInsnNode)object).getOpcode() == 58) {
                            System.out.println("Bytecode ASTORE 6 case!");
                            bl2 = true;
                            continue;
                        }
                        if (((AbstractInsnNode)object).getOpcode() == 54) {
                            System.out.println("Bytecode ISTORE 6 case!");
                            bl3 = true;
                            abstractInsnNode = (AbstractInsnNode)listIterator.next();
                            break;
                        }
                    }
                    if (((VarInsnNode)object).var == 7 && bl2) break;
                }
                if (!bl2) continue;
                System.out.println("Removing " + abstractInsnNode);
                listIterator.remove();
            }
            object = new InsnList();
            ((InsnList)object).add(new VarInsnNode(25, 0));
            ((InsnList)object).add(new VarInsnNode(21, 5));
            ((InsnList)object).add(new VarInsnNode(21, 1));
            ((InsnList)object).add(new VarInsnNode(21, 2));
            ((InsnList)object).add(new VarInsnNode(21, 3));
            ((InsnList)object).add(new MethodInsnNode(184, "atomicstryker/dynamiclights/client/DynamicLights", "getLightValue", "(L" + (bl ? "acf" : "net/minecraft/world/IBlockAccess") + ";IIII)I"));
            if (bl3) {
                ((InsnList)object).add(new VarInsnNode(54, 6));
            }
            object2.instructions.insertBefore(abstractInsnNode, (InsnList)object);
            System.out.println("Patching Complete!");
            break;
        }
        ClassWriter classWriter = new ClassWriter(3);
        classNode.accept(classWriter);
        return classWriter.toByteArray();
    }
}

