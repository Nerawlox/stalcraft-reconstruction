/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.ejection;

import gloomyfolken.hooklib.asm.AsmHook;
import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.mods.asm.MicroTransformer;
import java.util.ListIterator;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

public class zwat
extends MicroTransformer {
    private static final String _a = "gloomyfolken/mods/ejection/EjectionHooks";

    @Override
    public void registerHooks() {
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("net.minecraft.client.renderer.EntityRenderer").setTargetMethod("updateFogColor").addTargetMethodParameters(Type.FLOAT_TYPE).setHookClass(_a).setHookMethod("onFogColorUpdate").setInjectorFactory(AsmHook.ON_EXIT_FACTORY).build());
    }

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if (string.equals("net.minecraft.world.World")) {
            byArray = this._a(byArray, false);
        } else if (string.equals("abw")) {
            byArray = this._a(byArray, true);
        }
        return byArray;
    }

    private byte[] _a(byte[] byArray, boolean bl) {
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(byArray);
        classReader.accept(classNode, 0);
        String string = bl ? "a" : "getSkyColor";
        String string2 = bl ? "Latc;" : "Lnet/minecraft/util/Vec3;";
        String string3 = bl ? "Lnn;" : "Lnet/minecraft/entity/Entity;";
        for (MethodNode methodNode : classNode.methods) {
            AbstractInsnNode abstractInsnNode;
            if (!methodNode.name.equals(string) || !methodNode.desc.equals("(" + string3 + "F)" + string2)) continue;
            ListIterator<AbstractInsnNode> listIterator = methodNode.instructions.iterator();
            AbstractInsnNode abstractInsnNode2 = null;
            while (listIterator.hasNext()) {
                abstractInsnNode = (AbstractInsnNode)listIterator.next();
                if (abstractInsnNode.getOpcode() != 182) continue;
                abstractInsnNode2 = abstractInsnNode;
                break;
            }
            if (abstractInsnNode2 == null) continue;
            abstractInsnNode = new MethodInsnNode(184, _a, "modifyWorldColor", "(" + string2 + ")" + string2);
            methodNode.instructions.insert(abstractInsnNode2, abstractInsnNode);
        }
        ClassWriter classWriter = new ClassWriter(0);
        classNode.accept(classWriter);
        return classWriter.toByteArray();
    }
}

