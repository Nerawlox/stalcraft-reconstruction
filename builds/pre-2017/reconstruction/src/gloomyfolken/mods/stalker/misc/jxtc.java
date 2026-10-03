/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.misc;

import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.mods.asm.GloomyTransformer;
import gloomyfolken.mods.asm.MicroTransformer;
import java.util.ArrayList;
import java.util.ListIterator;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class jxtc
extends MicroTransformer {
    public static final String _a = "gloomyfolken/mods/stalker/misc/StalkerHooks";

    @Override
    public void registerHooks() {
        HookLoader.registerHookContainer(_a.replace('/', '.'));
    }

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if (string.equals("net.minecraft.client.renderer.entity.RenderItem")) {
            byArray = this._c(byArray, false);
        } else if (string.equals("bgw")) {
            byArray = this._c(byArray, true);
        } else if (string.equals("net.minecraft.entity.item.EntityItem")) {
            byArray = this._d(byArray, false);
        } else if (string.equals("ss")) {
            byArray = this._d(byArray, true);
        } else if (string.equals("net.minecraft.block.BlockWeb")) {
            byArray = this._b(byArray, false);
        } else if (string.equals("arp")) {
            byArray = this._b(byArray, true);
        } else if (string.equals("net.minecraft.block.BlockLeavesBase")) {
            byArray = this._a(byArray, false);
        } else if (string.equals("arh")) {
            byArray = this._a(byArray, true);
        }
        return byArray;
    }

    private byte[] _a(byte[] byArray, boolean bl) {
        System.out.println("[STALKER] Transforming BlockLeavesBase");
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        String string = bl ? "b" : "getCollisionBoundingBoxFromPool";
        String string2 = bl ? "Labw;" : "Lnet/minecraft/world/World;";
        String string3 = bl ? "Lasx;" : "Lnet/minecraft/util/AxisAlignedBB;";
        String string4 = bl ? "a" : "onEntityCollidedWithBlock";
        String string5 = bl ? "c_" : "getSelectedBoundingBoxFromPool";
        String string6 = bl ? "Lnn;" : "Lnet/minecraft/entity/Entity;";
        MethodNode methodNode = new MethodNode(262144);
        methodNode.name = string;
        methodNode.desc = "(" + string2 + "III)" + string3;
        methodNode.access = 1;
        methodNode.maxLocals = 5;
        methodNode.maxStack = 1;
        methodNode.instructions.add(new LabelNode());
        methodNode.instructions.add(new InsnNode(1));
        methodNode.instructions.add(new InsnNode(176));
        methodNode.instructions.add(new LabelNode());
        methodNode.exceptions = new ArrayList<String>();
        classNode.methods.add(methodNode);
        methodNode = new MethodNode(262144);
        methodNode.name = string4;
        methodNode.desc = "(" + string2 + "III" + string6 + ")V";
        methodNode.access = 1;
        methodNode.maxLocals = 6;
        methodNode.maxStack = 1;
        methodNode.instructions.add(new LabelNode());
        methodNode.instructions.add(new VarInsnNode(25, 5));
        methodNode.instructions.add(new MethodInsnNode(184, _a, "inLeaves", "(" + string6 + ")V"));
        methodNode.instructions.add(new LabelNode());
        methodNode.instructions.add(new InsnNode(177));
        methodNode.instructions.add(new LabelNode());
        methodNode.exceptions = new ArrayList<String>();
        classNode.methods.add(methodNode);
        return GloomyTransformer.write(classNode);
    }

    private byte[] _b(byte[] byArray, boolean bl) {
        System.out.println("[STALKER] Transforming BlockWeb");
        String string = bl ? "a" : "onEntityCollidedWithBlock";
        String string2 = bl ? "Labw;" : "Lnet/minecraft/world/World;";
        String string3 = bl ? "Lnn;" : "Lnet/minecraft/entity/Entity;";
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        GloomyTransformer.insertHook(classNode, string, "(" + string2 + "III" + string3 + ")V", _a, "inWeb", "(" + string3 + ")V", false, false, null, new int[]{5}, new int[]{25});
        return GloomyTransformer.write(classNode);
    }

    private byte[] _c(byte[] byArray, boolean bl) {
        System.out.println("[STALKER] Transforming RenderItem");
        ClassNode classNode = GloomyTransformer.createClassNode(byArray);
        String string = bl ? "a" : "doRenderItem";
        String string2 = bl ? "Lbgw;" : "Lnet/minecraft/client/renderer/entity/RenderItem;";
        String string3 = bl ? "Lss;" : "Lnet/minecraft/entity/item/EntityItem;";
        String string4 = bl ? "Lms;" : "Lnet/minecraft/util/Icon;";
        for (MethodNode methodNode : classNode.methods) {
            AbstractInsnNode abstractInsnNode;
            int n;
            ListIterator<AbstractInsnNode> listIterator;
            if (methodNode.name.equals("renderDroppedItem") && methodNode.desc.equals("(" + string3 + string4 + "IFFFFI)V")) {
                listIterator = methodNode.instructions.iterator();
                n = 0;
                while (listIterator.hasNext()) {
                    AbstractInsnNode abstractInsnNode2 = (AbstractInsnNode)listIterator.next();
                    if (abstractInsnNode2.getType() != 5 || !((MethodInsnNode)abstractInsnNode2).name.equals("glRotatef") || ++n != 2) continue;
                    abstractInsnNode = (MethodInsnNode)abstractInsnNode2;
                    ((MethodInsnNode)abstractInsnNode).name = "fakeFourFloats";
                    ((MethodInsnNode)abstractInsnNode).owner = _a;
                }
                continue;
            }
            if (!methodNode.name.equals(string) || !methodNode.desc.equals("(" + string3 + "DDDFF)V")) continue;
            listIterator = methodNode.instructions.iterator();
            n = 0;
            int n2 = 0;
            while (listIterator.hasNext()) {
                MethodInsnNode methodInsnNode;
                abstractInsnNode = (AbstractInsnNode)listIterator.next();
                if (abstractInsnNode.getType() == 5 && ((MethodInsnNode)abstractInsnNode).name.equals("glRotatef") && ++n == 1) {
                    methodInsnNode = (MethodInsnNode)abstractInsnNode;
                    methodInsnNode.name = "fakeFourFloats";
                    methodInsnNode.owner = _a;
                    continue;
                }
                if (abstractInsnNode.getType() != 5 || !((MethodInsnNode)abstractInsnNode).name.equals("glTranslatef") || ++n2 != 3) continue;
                methodInsnNode = (MethodInsnNode)abstractInsnNode;
                methodInsnNode.name = "fakeThreeFloats";
                methodInsnNode.owner = _a;
            }
        }
        GloomyTransformer.insertHook(classNode, "renderDroppedItem", "(" + string3 + string4 + "IFFFFI)V", _a, "renderDroppedItemBefore", "(" + string3 + ")V", false, false, null, new int[]{1}, new int[]{25});
        GloomyTransformer.insertHook(classNode, "renderDroppedItem", "(" + string3 + string4 + "IFFFFI)V", _a, "renderDroppedItemAfter", "(" + string3 + ")V", true, false, null, new int[]{1}, new int[]{25});
        GloomyTransformer.insertHook(classNode, "shouldBob", "()Z", _a, "getTrue", "()Z", false, true, 0, new int[0], new int[0]);
        return GloomyTransformer.write(classNode);
    }

    private byte[] _d(byte[] byArray, boolean bl) {
        System.out.println("[STALKER] Transforming EntityItem");
        ClassReader classReader = new ClassReader(byArray);
        ClassWriter classWriter = new ClassWriter(0);
        kjui kjui2 = new kjui(classWriter, bl);
        classReader.accept(kjui2, 0);
        return classWriter.toByteArray();
    }

    private static class kjui
    extends ClassVisitor {
        private final boolean _a;

        public kjui(ClassVisitor classVisitor, boolean bl) {
            super(327680, classVisitor);
            this._a = bl;
        }

        @Override
        public void visitEnd() {
            String string = this._a ? "a" : "setPositionAndRotation2";
            MethodVisitor methodVisitor = this.cv.visitMethod(1, string, "(DDDFFI)V", null, null);
            methodVisitor.visitCode();
            Object object = new Label();
            methodVisitor.visitLabel((Label)object);
            methodVisitor.visitInsn(177);
            Object object2 = new Label();
            methodVisitor.visitLabel((Label)object2);
            methodVisitor.visitMaxs(0, 10);
            methodVisitor.visitEnd();
            string = this._a ? "S" : "getShadowSize";
            methodVisitor = this.cv.visitMethod(1, string, "()F", null, null);
            methodVisitor.visitCode();
            object = new Label();
            methodVisitor.visitLabel((Label)object);
            methodVisitor.visitLdcInsn(new Float("10.0"));
            methodVisitor.visitInsn(174);
            object2 = new Label();
            methodVisitor.visitLabel((Label)object2);
            methodVisitor.visitMaxs(1, 1);
            methodVisitor.visitEnd();
            string = this._a ? "c" : "interactFirst";
            object = "L" + (this._a ? "uf" : "net/minecraft/entity/player/EntityPlayer") + ";";
            object2 = "L" + (this._a ? "ss" : "net/minecraft/entity/item/EntityItem") + ";";
            methodVisitor = this.cv.visitMethod(1, string, "(" + (String)object + ")Z", null, null);
            methodVisitor.visitCode();
            Label label = new Label();
            methodVisitor.visitLabel(label);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitMethodInsn(184, jxtc._a, "onEntityItemInteract", "(" + (String)object2 + (String)object + ")V", false);
            Label label2 = new Label();
            methodVisitor.visitLabel(label2);
            methodVisitor.visitInsn(4);
            methodVisitor.visitInsn(172);
            Label label3 = new Label();
            methodVisitor.visitLabel(label3);
            methodVisitor.visitMaxs(2, 2);
            methodVisitor.visitEnd();
            string = this._a ? "L" : "canBeCollidedWith";
            methodVisitor = this.cv.visitMethod(1, string, "()Z", null, null);
            methodVisitor.visitCode();
            object = new Label();
            methodVisitor.visitLabel((Label)object);
            methodVisitor.visitInsn(4);
            methodVisitor.visitInsn(172);
            object2 = new Label();
            methodVisitor.visitLabel((Label)object2);
            methodVisitor.visitMaxs(1, 1);
            methodVisitor.visitEnd();
            super.visitEnd();
        }
    }
}

