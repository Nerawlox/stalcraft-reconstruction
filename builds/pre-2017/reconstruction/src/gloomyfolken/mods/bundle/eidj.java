/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.bundle;

import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.mods.asm.GloomyLoadingPlugin;
import gloomyfolken.mods.asm.GloomyTransformer;
import gloomyfolken.mods.asm.MicroTransformer;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class eidj
extends MicroTransformer {
    private static final String _a = "gloomyfolken/mods/bundle/BundleHooks";

    @Override
    public void registerHooks() {
        if (!GloomyLoadingPlugin._a) {
            HookLoader.registerHookContainer(_a);
        }
    }

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if (string2.equals("net.minecraft.world.WorldServerMulti")) {
            System.out.println("Transforming WorldServerMulti");
            ClassNode classNode = GloomyTransformer.createClassNode(byArray);
            String string3 = "Lnet/minecraft/world/storage/ISaveHandler;";
            String string4 = "Ljava/lang/String;";
            for (MethodNode methodNode : classNode.methods) {
                if (!methodNode.name.equals("<init>")) continue;
                System.out.println("Transforming constructor " + methodNode.desc);
                InsnList insnList = new InsnList();
                insnList.add(new VarInsnNode(25, 2));
                insnList.add(new VarInsnNode(25, 3));
                insnList.add(new MethodInsnNode(184, _a, "spoofSaveHandler", "(" + string3 + string4 + ")" + string3, false));
                insnList.add(new VarInsnNode(58, 2));
                insnList.add(new VarInsnNode(25, 3));
                insnList.add(new MethodInsnNode(184, _a, "spoofWorldName", "(" + string4 + ")" + string4, false));
                insnList.add(new VarInsnNode(58, 3));
                methodNode.instructions.insert(methodNode.instructions.getFirst(), insnList);
            }
            return GloomyTransformer.write(classNode);
        }
        return byArray;
    }
}

