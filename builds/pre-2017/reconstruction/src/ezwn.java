/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.hooklib.asm.AsmHook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import gloomyfolken.hooklib.asm.ReturnValue;
import gloomyfolken.hooklib.minecraft.HookLibPlugin;
import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.mods.asm.GloomyTransformer;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.asm.MicroTransformer;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class ezwn
extends MicroTransformer {
    public static final int _a = 10000;
    private static final String _b = "gloomyfolken.mods.bigstacks.BigStacksHooks";

    @Override
    public void registerHooks() {
        HookLoader.registerHookContainer(_b);
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("codechicken.nei.InfiniteStackSizeHandler").setTargetMethod("isItemInfinite").addTargetMethodParameters("net.minecraft.item.ItemStack").setTargetMethodReturnType(Type.BOOLEAN_TYPE).setReturnCondition(ReturnCondition.ALWAYS).setReturnValue(ReturnValue.PRIMITIVE_CONSTANT).setPrimitiveConstant(false).setInjectorFactory(AsmHook.ON_ENTER_FACTORY).build());
    }

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        boolean bl = false;
        if (string.equals("codechicken.lib.packet.PacketCustom")) {
            this._b(classNode);
            bl = true;
        }
        if (bl |= this._a(classNode)) {
            return GloomyTransformer.write(classNode);
        }
        return byArray;
    }

    private boolean _a(ClassNode classNode) {
        boolean bl = HookLibPlugin.getObfuscated();
        String string = bl ? "d" : "getInventoryStackLimit";
        String string2 = "()I";
        for (String string3 : classNode.interfaces) {
            if (!this._a(string3)) continue;
            Logger.info("Found 'IInventory' - <%s>. Finding 'getInventoryStackLimit' method...", classNode.name);
            for (MethodNode methodNode : classNode.methods) {
                if (!methodNode.name.equals(string) || !methodNode.desc.equals(string2)) continue;
                methodNode.instructions.clear();
                methodNode.instructions.add(new LdcInsnNode((Object)10000));
                methodNode.instructions.add(new InsnNode(172));
                Logger.info("New max slot size successfully inserted into method <%s>", methodNode.name);
                return true;
            }
        }
        return false;
    }

    private boolean _a(String string) {
        return "mo".equals(string) || "net/minecraft/inventory/IInventory".equals(string);
    }

    private void _b(ClassNode classNode) {
        boolean bl = HookLibPlugin.getObfuscated();
        String string = "writeItemStack";
        String string2 = bl ? "(Lye;Z)Lcodechicken/lib/packet/PacketCustom;" : "(Lnet/minecraft/item/ItemStack;Z)Lcodechicken/lib/packet/PacketCustom;";
        String string3 = "readItemStack";
        String string4 = bl ? "(Z)Lye;" : "(Z)Lnet/minecraft/item/ItemStack;";
        for (MethodNode methodNode : classNode.methods) {
            AbstractInsnNode abstractInsnNode;
            if (methodNode.name.equals(string) && methodNode.desc.equals(string2)) {
                abstractInsnNode = methodNode.instructions.getFirst();
                methodNode.instructions.insertBefore(abstractInsnNode, new InsnNode(4));
                methodNode.instructions.insertBefore(abstractInsnNode, new VarInsnNode(54, 2));
            }
            if (!methodNode.name.equals(string3) || !methodNode.desc.equals(string4)) continue;
            abstractInsnNode = methodNode.instructions.getFirst();
            methodNode.instructions.insertBefore(abstractInsnNode, new InsnNode(4));
            methodNode.instructions.insertBefore(abstractInsnNode, new VarInsnNode(54, 1));
        }
    }
}

