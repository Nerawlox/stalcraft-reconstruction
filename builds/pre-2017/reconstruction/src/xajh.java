/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.hooklib.minecraft.MinecraftClassTransformer;
import gloomyfolken.mods.asm.GloomyTransformer;
import gloomyfolken.mods.asm.MicroTransformer;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class xajh
extends MicroTransformer {
    private static final String _a = "gloomyfolken/mods/stalker/respawn/util/RespawnHooks";

    @Override
    public void registerHooks() {
        HookLoader.registerHookContainer(_a);
        MinecraftClassTransformer.registerPostTransformer(new kjui());
    }

    private static class kjui
    implements IClassTransformer {
        private kjui() {
        }

        @Override
        public byte[] transform(String string, String string2, byte[] byArray) {
            if (string2.equals("net.minecraft.server.management.ServerConfigurationManager")) {
                byArray = this._a(byArray);
            }
            return byArray;
        }

        private byte[] _a(byte[] byArray) {
            System.out.println("Transforming ServerConfigurationManager");
            String string = "net/minecraft/entity/player/EntityPlayerMP";
            String string2 = "func_70080_a";
            String string3 = "(DDDFF)V";
            ClassNode classNode = GloomyTransformer.createClassNode(byArray);
            for (MethodNode methodNode : classNode.methods) {
                int n = Type.getArgumentTypes(methodNode.desc).length;
                if (!methodNode.name.equals("moveToWorld") || n != 6) continue;
                System.out.println("Patching ServerConfigurationManager#moveToWorld");
                AbstractInsnNode abstractInsnNode = null;
                int n2 = -1;
                for (int i = 0; i < methodNode.instructions.size(); ++i) {
                    AbstractInsnNode abstractInsnNode2;
                    AbstractInsnNode abstractInsnNode3 = methodNode.instructions.get(i);
                    if (abstractInsnNode3.getOpcode() == 58) {
                        abstractInsnNode2 = (VarInsnNode)abstractInsnNode3;
                        n2 = abstractInsnNode2.var;
                    }
                    if (abstractInsnNode3.getOpcode() != 182) continue;
                    abstractInsnNode2 = (MethodInsnNode)abstractInsnNode3;
                    if (!((MethodInsnNode)abstractInsnNode2).owner.equals(string) || !((MethodInsnNode)abstractInsnNode2).name.equals(string2) || !((MethodInsnNode)abstractInsnNode2).desc.equals(string3)) continue;
                    abstractInsnNode = abstractInsnNode2;
                    break;
                }
                if (abstractInsnNode == null) {
                    System.out.println("Can not find insert position");
                    continue;
                }
                System.out.println("Insert position found");
                InsnList insnList = new InsnList();
                insnList.add(new VarInsnNode(25, 1));
                insnList.add(new VarInsnNode(25, n2));
                insnList.add(new VarInsnNode(21, 6));
                insnList.add(new MethodInsnNode(184, xajh._a, "moveToWorld", "(Lnet/minecraft/entity/player/EntityPlayerMP;Lnet/minecraft/world/WorldServer;Z)Lnet/minecraft/world/WorldServer;", false));
                insnList.add(new VarInsnNode(58, n2));
                methodNode.instructions.insert(abstractInsnNode, insnList);
            }
            return GloomyTransformer.write(classNode);
        }
    }
}

