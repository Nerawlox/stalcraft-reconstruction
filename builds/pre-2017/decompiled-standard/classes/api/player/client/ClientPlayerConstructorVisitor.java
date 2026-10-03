/*
 * Decompiled with CFR 0.152.
 */
package api.player.client;

import org.objectweb.asm.MethodVisitor;

public final class ClientPlayerConstructorVisitor
extends MethodVisitor {
    private final boolean isObfuscated;

    public ClientPlayerConstructorVisitor(MethodVisitor methodVisitor, boolean bl) {
        super(262144, methodVisitor);
        this.isObfuscated = bl;
    }

    @Override
    public void visitMethodInsn(int n, String string, String string2, String string3) {
        super.visitMethodInsn(n, string, string2, string3);
        if (string2.equals("<init>") && string.equals(this.isObfuscated ? "beu" : "net/minecraft/client/entity/AbstractClientPlayer")) {
            this.mv.visitVarInsn(25, 0);
            this.mv.visitVarInsn(25, 0);
            this.mv.visitMethodInsn(184, "api/player/client/ClientPlayerAPI", "create", "(Lapi/player/client/IClientPlayerAPI;)Lapi/player/client/ClientPlayerAPI;");
            this.mv.visitFieldInsn(181, this.isObfuscated ? "bex" : "net/minecraft/client/entity/EntityPlayerSP", "clientPlayerAPI", "Lapi/player/client/ClientPlayerAPI;");
            this.mv.visitVarInsn(25, 0);
            this.mv.visitIntInsn(25, 1);
            this.mv.visitIntInsn(25, 2);
            this.mv.visitIntInsn(25, 3);
            this.mv.visitIntInsn(21, 4);
            this.mv.visitMethodInsn(184, "api/player/client/ClientPlayerAPI", "beforeLocalConstructing", "(Lapi/player/client/IClientPlayerAPI;Lnet/minecraft/client/Minecraft;Lnet/minecraft/world/World;Lnet/minecraft/util/Session;I)V");
        }
    }

    @Override
    public void visitInsn(int n) {
        if (n == 177) {
            this.mv.visitVarInsn(25, 0);
            this.mv.visitIntInsn(25, 1);
            this.mv.visitIntInsn(25, 2);
            this.mv.visitIntInsn(25, 3);
            this.mv.visitIntInsn(21, 4);
            this.mv.visitMethodInsn(184, "api/player/client/ClientPlayerAPI", "afterLocalConstructing", "(Lapi/player/client/IClientPlayerAPI;Lnet/minecraft/client/Minecraft;Lnet/minecraft/world/World;Lnet/minecraft/util/Session;I)V");
        }
        super.visitInsn(n);
    }
}

