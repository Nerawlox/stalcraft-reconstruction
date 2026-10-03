/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.core;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import gloomyfolken.hooklib.minecraft.HookLoader;
import java.io.File;
import java.util.Map;
import org.objectweb.asm.Label;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;
import poersch.minecraft.util.asm.ClassPatcher;
import poersch.minecraft.util.asm.InterfaceInjector;

@IFMLLoadingPlugin.MCVersion(value="1.6.4")
@IFMLLoadingPlugin.TransformerExclusions(value={"poersch.minecraft.bettergrassandleaves.core"})
public class BGALLoadingPlugin
implements IFMLLoadingPlugin {
    @Override
    public String[] getLibraryRequestClass() {
        return null;
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{ClassPatcher.class.getName()};
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> map) {
        HookLoader.registerHookContainer("poersch.minecraft.bettergrassandleaves.renderer.BlockRendererList");
        boolean bl = (Boolean)map.get("runtimeDeobfuscationEnabled") == false;
        ClassPatcher.addPatchesFrom((File)map.get("coremodLocation"));
        if (bl) {
            FieldNode fieldNode = new FieldNode(1, "colorBetterBlood", "I", null, null);
            MethodNode methodNode = new MethodNode(1, "getColorBetterBlood", "()I", null, null);
            methodNode.visitCode();
            methodNode.visitVarInsn(25, 0);
            methodNode.visitFieldInsn(180, "net/minecraft/entity/Entity", "colorBetterBlood", "I");
            Label label = new Label();
            methodNode.visitJumpInsn(154, label);
            methodNode.visitVarInsn(25, 0);
            methodNode.visitVarInsn(25, 0);
            methodNode.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            methodNode.visitMethodInsn(184, "poersch/minecraft/bettergrassandleaves/renderer/BetterBloodRenderer", "getColorBetterBlood", "(Ljava/lang/Class;)I");
            methodNode.visitFieldInsn(181, "net/minecraft/entity/Entity", "colorBetterBlood", "I");
            methodNode.visitLabel(label);
            methodNode.visitFrame(3, 0, null, 0, null);
            methodNode.visitVarInsn(25, 0);
            methodNode.visitFieldInsn(180, "net/minecraft/entity/Entity", "colorBetterBlood", "I");
            methodNode.visitInsn(172);
            methodNode.visitMaxs(0, 0);
            methodNode.visitEnd();
            ClassPatcher.addPatcherFor("net.minecraft.entity.Entity", new InterfaceInjector("poersch/minecraft/bettergrassandleaves/interfaces/IBetterBlood", fieldNode, methodNode));
        } else {
            FieldNode fieldNode = new FieldNode(1, "colorBetterBlood", "I", null, null);
            MethodNode methodNode = new MethodNode(1, "getColorBetterBlood", "()I", null, null);
            methodNode.visitCode();
            methodNode.visitVarInsn(25, 0);
            methodNode.visitFieldInsn(180, "nn", "colorBetterBlood", "I");
            Label label = new Label();
            methodNode.visitJumpInsn(154, label);
            methodNode.visitVarInsn(25, 0);
            methodNode.visitVarInsn(25, 0);
            methodNode.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            methodNode.visitMethodInsn(184, "poersch/minecraft/bettergrassandleaves/renderer/BetterBloodRenderer", "getColorBetterBlood", "(Ljava/lang/Class;)I");
            methodNode.visitFieldInsn(181, "nn", "colorBetterBlood", "I");
            methodNode.visitLabel(label);
            methodNode.visitFrame(3, 0, null, 0, null);
            methodNode.visitVarInsn(25, 0);
            methodNode.visitFieldInsn(180, "nn", "colorBetterBlood", "I");
            methodNode.visitInsn(172);
            methodNode.visitMaxs(0, 0);
            methodNode.visitEnd();
            ClassPatcher.addPatcherFor("nn", new InterfaceInjector("poersch/minecraft/bettergrassandleaves/interfaces/IBetterBlood", fieldNode, methodNode));
        }
    }
}

