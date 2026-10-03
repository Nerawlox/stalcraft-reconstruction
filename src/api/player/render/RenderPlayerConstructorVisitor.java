/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.objectweb.asm.MethodVisitor
 */
package api.player.render;

import java.util.Map;
import java.util.Stack;
import org.objectweb.asm.MethodVisitor;

public final class RenderPlayerConstructorVisitor
extends MethodVisitor {
    private final boolean isObfuscated;
    private final Map<String, Stack<String>> constructorReplacements;

    public RenderPlayerConstructorVisitor(MethodVisitor var1, boolean var2, Map<String, Stack<String>> var3) {
        super(262144, var1);
        this.isObfuscated = var2;
        this.constructorReplacements = var3;
    }

    public void visitTypeInsn(int var1, String var2) {
        if (var1 == 187 && this.constructorReplacements != null && this.constructorReplacements.containsKey(var2)) {
            int var4;
            Stack<String> var3 = this.constructorReplacements.get(var2);
            if (!var3.isEmpty()) {
                var2 = var3.peek();
            }
            if ((var4 = var2.indexOf(":")) > 0) {
                var2 = var2.substring(0, var4);
            }
        }
        super.visitTypeInsn(var1, var2);
    }

    public void visitMethodInsn(int var1, String var2, String var3, String var4) {
        if (var3.equals("<init>") && this.constructorReplacements != null && this.constructorReplacements.containsKey(var2)) {
            int var6;
            Stack<String> var5 = this.constructorReplacements.get(var2);
            if (!var5.isEmpty()) {
                var2 = var5.pop();
            }
            if ((var6 = var2.indexOf(":")) > 0) {
                this.mv.visitLdcInsn((Object)var2.substring(var6 + 1));
                var2 = var2.substring(0, var6);
                int var7 = var4.indexOf(")");
                var4 = var4.substring(0, var7) + "Ljava/lang/String;" + var4.substring(var7);
            }
        }
        super.visitMethodInsn(var1, var2, var3, var4);
        if (var3.equals("<init>") && var2.equals(this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity")) {
            this.mv.visitVarInsn(25, 0);
            this.mv.visitVarInsn(25, 0);
            this.mv.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "create", "(Lapi/player/render/IRenderPlayerAPI;)Lapi/player/render/RenderPlayerAPI;");
            this.mv.visitFieldInsn(181, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", "renderPlayerAPI", "Lapi/player/render/RenderPlayerAPI;");
            this.mv.visitVarInsn(25, 0);
            this.mv.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "beforeLocalConstructing", "(Lapi/player/render/IRenderPlayerAPI;)V");
        }
    }

    public void visitInsn(int var1) {
        if (var1 == 177) {
            this.mv.visitVarInsn(25, 0);
            this.mv.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "afterLocalConstructing", "(Lapi/player/render/IRenderPlayerAPI;)V");
        }
        super.visitInsn(var1);
    }
}

