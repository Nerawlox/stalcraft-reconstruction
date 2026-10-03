/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.objectweb.asm.MethodVisitor
 */
package api.player.model;

import org.objectweb.asm.MethodVisitor;

public final class ModelPlayerConstructorVisitor
extends MethodVisitor {
    private final boolean isObfuscated;

    public ModelPlayerConstructorVisitor(MethodVisitor var1, boolean var2) {
        super(262144, var1);
        this.isObfuscated = var2;
    }

    public void visitMethodInsn(int var1, String var2, String var3, String var4) {
        if (this.isObfuscated && var3.equals("<init>") && var2.equals("net/minecraft/client/model/ModelBiped")) {
            var2 = "bbj";
        }
        super.visitMethodInsn(var1, var2, var3, var4);
        if (var3.equals("<init>") && var2.equals(this.isObfuscated ? "bbj" : "net/minecraft/client/model/ModelBiped")) {
            this.mv.visitVarInsn(25, 0);
            this.mv.visitVarInsn(25, 0);
            this.mv.visitVarInsn(23, 1);
            this.mv.visitVarInsn(25, 2);
            this.mv.visitMethodInsn(184, "api/player/model/ModelPlayerAPI", "create", "(Lapi/player/model/IModelPlayerAPI;FLjava/lang/String;)Lapi/player/model/ModelPlayerAPI;");
            this.mv.visitFieldInsn(181, "api/player/model/ModelPlayer", "modelPlayerAPI", "Lapi/player/model/ModelPlayerAPI;");
            this.mv.visitVarInsn(25, 0);
            this.mv.visitIntInsn(23, 1);
            this.mv.visitMethodInsn(184, "api/player/model/ModelPlayerAPI", "beforeLocalConstructing", "(Lapi/player/model/IModelPlayerAPI;F)V");
        }
    }

    public void visitInsn(int var1) {
        if (var1 == 177) {
            this.mv.visitVarInsn(25, 0);
            this.mv.visitIntInsn(23, 1);
            this.mv.visitMethodInsn(184, "api/player/model/ModelPlayerAPI", "afterLocalConstructing", "(Lapi/player/model/IModelPlayerAPI;F)V");
        }
        super.visitInsn(var1);
    }
}

