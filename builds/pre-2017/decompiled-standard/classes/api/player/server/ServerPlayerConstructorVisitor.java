/*
 * Decompiled with CFR 0.152.
 */
package api.player.server;

import org.objectweb.asm.MethodVisitor;

public final class ServerPlayerConstructorVisitor
extends MethodVisitor {
    private final boolean isObfuscated;

    public ServerPlayerConstructorVisitor(MethodVisitor methodVisitor, boolean bl) {
        super(262144, methodVisitor);
        this.isObfuscated = bl;
    }

    @Override
    public void visitMethodInsn(int n, String string, String string2, String string3) {
        super.visitMethodInsn(n, string, string2, string3);
        if (string2.equals("<init>") && string.equals(this.isObfuscated ? "uf" : "net/minecraft/entity/player/EntityPlayer")) {
            this.mv.visitVarInsn(25, 0);
            this.mv.visitVarInsn(25, 0);
            this.mv.visitMethodInsn(184, "api/player/server/ServerPlayerAPI", "create", "(Lapi/player/server/IServerPlayerAPI;)Lapi/player/server/ServerPlayerAPI;");
            this.mv.visitFieldInsn(181, this.isObfuscated ? "jv" : "net/minecraft/entity/player/EntityPlayerMP", "serverPlayerAPI", "Lapi/player/server/ServerPlayerAPI;");
            this.mv.visitVarInsn(25, 0);
            this.mv.visitIntInsn(25, 1);
            this.mv.visitIntInsn(25, 2);
            this.mv.visitIntInsn(25, 3);
            this.mv.visitIntInsn(25, 4);
            this.mv.visitMethodInsn(184, "api/player/server/ServerPlayerAPI", "beforeLocalConstructing", "(Lapi/player/server/IServerPlayerAPI;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/World;Ljava/lang/String;Lnet/minecraft/item/ItemInWorldManager;)V");
        }
    }

    @Override
    public void visitInsn(int n) {
        if (n == 177) {
            this.mv.visitVarInsn(25, 0);
            this.mv.visitIntInsn(25, 1);
            this.mv.visitIntInsn(25, 2);
            this.mv.visitIntInsn(25, 3);
            this.mv.visitIntInsn(25, 4);
            this.mv.visitMethodInsn(184, "api/player/server/ServerPlayerAPI", "afterLocalConstructing", "(Lapi/player/server/IServerPlayerAPI;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/World;Ljava/lang/String;Lnet/minecraft/item/ItemInWorldManager;)V");
        }
        super.visitInsn(n);
    }
}

