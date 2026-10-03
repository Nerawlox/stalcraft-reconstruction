/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.objectweb.asm.ClassReader
 *  org.objectweb.asm.ClassVisitor
 *  org.objectweb.asm.ClassWriter
 *  org.objectweb.asm.MethodVisitor
 */
package api.player.model;

import api.player.model.ModelPlayerConstructorVisitor;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public final class ModelPlayerClassVisitor
extends ClassVisitor {
    public static final String targetClassName = "api.player.model.ModelPlayer";
    public static final String obfuscatedClassReference = "api/player/model/ModelPlayer";
    public static final String obfuscatedSuperClassReference = "bbj";
    public static final String deobfuscatedClassReference = "api/player/model/ModelPlayer";
    public static final String deobfuscateSuperClassReference = "net/minecraft/client/model/ModelBiped";
    private boolean hadLocalGetRandomModelBox;
    private boolean hadLocalGetTextureOffset;
    private boolean hadLocalRender;
    private boolean hadLocalRenderCloak;
    private boolean hadLocalRenderEars;
    private boolean hadLocalSetLivingAnimations;
    private boolean hadLocalSetRotationAngles;
    private boolean hadLocalSetTextureOffset;
    private final boolean isObfuscated;

    public static byte[] transform(byte[] var0, boolean var1) {
        try {
            ByteArrayInputStream var2 = new ByteArrayInputStream(var0);
            ClassReader var3 = new ClassReader((InputStream)var2);
            ClassWriter var4 = new ClassWriter(1);
            ModelPlayerClassVisitor var5 = new ModelPlayerClassVisitor((ClassVisitor)var4, var1);
            var3.accept((ClassVisitor)var5, 0);
            byte[] var6 = var4.toByteArray();
            var2.close();
            return var6;
        }
        catch (IOException var7) {
            throw new RuntimeException(var7);
        }
    }

    public ModelPlayerClassVisitor(ClassVisitor var1, boolean var2) {
        super(262144, var1);
        this.isObfuscated = var2;
    }

    public void visit(int var1, int var2, String var3, String var4, String var5, String[] var6) {
        if (this.isObfuscated && var5.equals(deobfuscateSuperClassReference)) {
            var5 = obfuscatedSuperClassReference;
        }
        String[] var7 = new String[var6.length + 1];
        for (int var8 = 0; var8 < var6.length; ++var8) {
            var7[var8] = var6[var8];
        }
        var7[var6.length] = "api/player/model/IModelPlayerAPI";
        super.visit(var1, var2, var3, var4, var5, var7);
    }

    public MethodVisitor visitMethod(int var1, String var2, String var3, String var4, String[] var5) {
        if (var2.equals("<init>")) {
            var3 = "(FLjava/lang/String;)V";
            MethodVisitor var6 = this.cv.visitMethod(1, "<init>", "(F)V", var4, var5);
            var6.visitVarInsn(25, 0);
            var6.visitVarInsn(23, 1);
            var6.visitInsn(1);
            var6.visitMethodInsn(183, "api/player/model/ModelPlayer", "<init>", var3);
            var6.visitInsn(177);
            var6.visitMaxs(0, 0);
            var6.visitEnd();
            return new ModelPlayerConstructorVisitor(super.visitMethod(var1, var2, var3, var4, var5), this.isObfuscated);
        }
        if (var2.equals(this.isObfuscated ? "a" : "getRandomModelBox") && var3.equals(this.isObfuscated ? "(Ljava/util/Random;)Lbcu;" : "(Ljava/util/Random;)Lnet/minecraft/client/model/ModelRenderer;")) {
            this.hadLocalGetRandomModelBox = true;
            return super.visitMethod(17, "localGetRandomModelBox", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "getTextureOffset") && var3.equals(this.isObfuscated ? "(Ljava/lang/String;)Lbcv;" : "(Ljava/lang/String;)Lnet/minecraft/client/model/TextureOffset;")) {
            this.hadLocalGetTextureOffset = true;
            return super.visitMethod(17, "localGetTextureOffset", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "render") && var3.equals(this.isObfuscated ? "(Lnn;FFFFFF)V" : "(Lnet/minecraft/entity/Entity;FFFFFF)V")) {
            this.hadLocalRender = true;
            return super.visitMethod(17, "localRender", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "c" : "renderCloak") && var3.equals("(F)V")) {
            this.hadLocalRenderCloak = true;
            return super.visitMethod(17, "localRenderCloak", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "b" : "renderEars") && var3.equals("(F)V")) {
            this.hadLocalRenderEars = true;
            return super.visitMethod(17, "localRenderEars", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "setLivingAnimations") && var3.equals(this.isObfuscated ? "(Lof;FFF)V" : "(Lnet/minecraft/entity/EntityLivingBase;FFF)V")) {
            this.hadLocalSetLivingAnimations = true;
            return super.visitMethod(17, "localSetLivingAnimations", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "setRotationAngles") && var3.equals(this.isObfuscated ? "(FFFFFFLnn;)V" : "(FFFFFFLnet/minecraft/entity/Entity;)V")) {
            this.hadLocalSetRotationAngles = true;
            return super.visitMethod(17, "localSetRotationAngles", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "setTextureOffset") && var3.equals("(Ljava/lang/String;II)V")) {
            this.hadLocalSetTextureOffset = true;
            return super.visitMethod(17, "localSetTextureOffset", var3, var4, var5);
        }
        return super.visitMethod(var1, var2, var3, var4, var5);
    }

    public void visitEnd() {
        MethodVisitor var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "getRandomModelBox", "" + (this.isObfuscated ? "(Ljava/util/Random;)Lbcu;" : "(Ljava/util/Random;)Lnet/minecraft/client/model/ModelRenderer;") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(184, "api/player/model/ModelPlayerAPI", "getRandomModelBox", "(Lapi/player/model/IModelPlayerAPI;Ljava/util/Random;)" + (this.isObfuscated ? "Lbcu;" : "Lnet/minecraft/client/model/ModelRenderer;") + "");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realGetRandomModelBox", "" + (this.isObfuscated ? "(Ljava/util/Random;)Lbcu;" : "(Ljava/util/Random;)Lnet/minecraft/client/model/ModelRenderer;") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(182, "api/player/model/ModelPlayer", this.isObfuscated ? "a" : "getRandomModelBox", "" + (this.isObfuscated ? "(Ljava/util/Random;)Lbcu;" : "(Ljava/util/Random;)Lnet/minecraft/client/model/ModelRenderer;") + "");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superGetRandomModelBox", "" + (this.isObfuscated ? "(Ljava/util/Random;)Lbcu;" : "(Ljava/util/Random;)Lnet/minecraft/client/model/ModelRenderer;") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(183, this.isObfuscated ? obfuscatedSuperClassReference : deobfuscateSuperClassReference, this.isObfuscated ? "a" : "getRandomModelBox", "" + (this.isObfuscated ? "(Ljava/util/Random;)Lbcu;" : "(Ljava/util/Random;)Lnet/minecraft/client/model/ModelRenderer;") + "");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalGetRandomModelBox) {
            var1 = this.cv.visitMethod(17, "localGetRandomModelBox", "" + (this.isObfuscated ? "(Ljava/util/Random;)Lbcu;" : "(Ljava/util/Random;)Lnet/minecraft/client/model/ModelRenderer;") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitMethodInsn(183, this.isObfuscated ? obfuscatedSuperClassReference : deobfuscateSuperClassReference, this.isObfuscated ? "a" : "getRandomModelBox", "" + (this.isObfuscated ? "(Ljava/util/Random;)Lbcu;" : "(Ljava/util/Random;)Lnet/minecraft/client/model/ModelRenderer;") + "");
            var1.visitInsn(176);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "getTextureOffset", "" + (this.isObfuscated ? "(Ljava/lang/String;)Lbcv;" : "(Ljava/lang/String;)Lnet/minecraft/client/model/TextureOffset;") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(184, "api/player/model/ModelPlayerAPI", "getTextureOffset", "(Lapi/player/model/IModelPlayerAPI;Ljava/lang/String;)" + (this.isObfuscated ? "Lbcv;" : "Lnet/minecraft/client/model/TextureOffset;") + "");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realGetTextureOffset", "" + (this.isObfuscated ? "(Ljava/lang/String;)Lbcv;" : "(Ljava/lang/String;)Lnet/minecraft/client/model/TextureOffset;") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(182, "api/player/model/ModelPlayer", this.isObfuscated ? "a" : "getTextureOffset", "" + (this.isObfuscated ? "(Ljava/lang/String;)Lbcv;" : "(Ljava/lang/String;)Lnet/minecraft/client/model/TextureOffset;") + "");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superGetTextureOffset", "" + (this.isObfuscated ? "(Ljava/lang/String;)Lbcv;" : "(Ljava/lang/String;)Lnet/minecraft/client/model/TextureOffset;") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(183, this.isObfuscated ? obfuscatedSuperClassReference : deobfuscateSuperClassReference, this.isObfuscated ? "a" : "getTextureOffset", "" + (this.isObfuscated ? "(Ljava/lang/String;)Lbcv;" : "(Ljava/lang/String;)Lnet/minecraft/client/model/TextureOffset;") + "");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalGetTextureOffset) {
            var1 = this.cv.visitMethod(17, "localGetTextureOffset", "" + (this.isObfuscated ? "(Ljava/lang/String;)Lbcv;" : "(Ljava/lang/String;)Lnet/minecraft/client/model/TextureOffset;") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitMethodInsn(183, this.isObfuscated ? obfuscatedSuperClassReference : deobfuscateSuperClassReference, this.isObfuscated ? "a" : "getTextureOffset", "" + (this.isObfuscated ? "(Ljava/lang/String;)Lbcv;" : "(Ljava/lang/String;)Lnet/minecraft/client/model/TextureOffset;") + "");
            var1.visitInsn(176);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "render", "" + (this.isObfuscated ? "(Lnn;FFFFFF)V" : "(Lnet/minecraft/entity/Entity;FFFFFF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitVarInsn(23, 3);
        var1.visitVarInsn(23, 4);
        var1.visitVarInsn(23, 5);
        var1.visitVarInsn(23, 6);
        var1.visitVarInsn(23, 7);
        var1.visitMethodInsn(184, "api/player/model/ModelPlayerAPI", "render", "(Lapi/player/model/IModelPlayerAPI;" + (this.isObfuscated ? "Lnn;FFFFFF" : "Lnet/minecraft/entity/Entity;FFFFFF") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realRender", "" + (this.isObfuscated ? "(Lnn;FFFFFF)V" : "(Lnet/minecraft/entity/Entity;FFFFFF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitVarInsn(23, 3);
        var1.visitVarInsn(23, 4);
        var1.visitVarInsn(23, 5);
        var1.visitVarInsn(23, 6);
        var1.visitVarInsn(23, 7);
        var1.visitMethodInsn(182, "api/player/model/ModelPlayer", this.isObfuscated ? "a" : "render", "" + (this.isObfuscated ? "(Lnn;FFFFFF)V" : "(Lnet/minecraft/entity/Entity;FFFFFF)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superRender", "" + (this.isObfuscated ? "(Lnn;FFFFFF)V" : "(Lnet/minecraft/entity/Entity;FFFFFF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitVarInsn(23, 3);
        var1.visitVarInsn(23, 4);
        var1.visitVarInsn(23, 5);
        var1.visitVarInsn(23, 6);
        var1.visitVarInsn(23, 7);
        var1.visitMethodInsn(183, this.isObfuscated ? obfuscatedSuperClassReference : deobfuscateSuperClassReference, this.isObfuscated ? "a" : "render", "" + (this.isObfuscated ? "(Lnn;FFFFFF)V" : "(Lnet/minecraft/entity/Entity;FFFFFF)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalRender) {
            var1 = this.cv.visitMethod(17, "localRender", "" + (this.isObfuscated ? "(Lnn;FFFFFF)V" : "(Lnet/minecraft/entity/Entity;FFFFFF)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitVarInsn(23, 2);
            var1.visitVarInsn(23, 3);
            var1.visitVarInsn(23, 4);
            var1.visitVarInsn(23, 5);
            var1.visitVarInsn(23, 6);
            var1.visitVarInsn(23, 7);
            var1.visitMethodInsn(183, this.isObfuscated ? obfuscatedSuperClassReference : deobfuscateSuperClassReference, this.isObfuscated ? "a" : "render", "" + (this.isObfuscated ? "(Lnn;FFFFFF)V" : "(Lnet/minecraft/entity/Entity;FFFFFF)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "c" : "renderCloak", "(F)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(23, 1);
        var1.visitMethodInsn(184, "api/player/model/ModelPlayerAPI", "renderCloak", "(Lapi/player/model/IModelPlayerAPI;F)V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realRenderCloak", "(F)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(23, 1);
        var1.visitMethodInsn(182, "api/player/model/ModelPlayer", this.isObfuscated ? "c" : "renderCloak", "(F)V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superRenderCloak", "(F)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(23, 1);
        var1.visitMethodInsn(183, this.isObfuscated ? obfuscatedSuperClassReference : deobfuscateSuperClassReference, this.isObfuscated ? "c" : "renderCloak", "(F)V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalRenderCloak) {
            var1 = this.cv.visitMethod(17, "localRenderCloak", "(F)V", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(23, 1);
            var1.visitMethodInsn(183, this.isObfuscated ? obfuscatedSuperClassReference : deobfuscateSuperClassReference, this.isObfuscated ? "c" : "renderCloak", "(F)V");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "b" : "renderEars", "(F)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(23, 1);
        var1.visitMethodInsn(184, "api/player/model/ModelPlayerAPI", "renderEars", "(Lapi/player/model/IModelPlayerAPI;F)V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realRenderEars", "(F)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(23, 1);
        var1.visitMethodInsn(182, "api/player/model/ModelPlayer", this.isObfuscated ? "b" : "renderEars", "(F)V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superRenderEars", "(F)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(23, 1);
        var1.visitMethodInsn(183, this.isObfuscated ? obfuscatedSuperClassReference : deobfuscateSuperClassReference, this.isObfuscated ? "b" : "renderEars", "(F)V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalRenderEars) {
            var1 = this.cv.visitMethod(17, "localRenderEars", "(F)V", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(23, 1);
            var1.visitMethodInsn(183, this.isObfuscated ? obfuscatedSuperClassReference : deobfuscateSuperClassReference, this.isObfuscated ? "b" : "renderEars", "(F)V");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "setLivingAnimations", "" + (this.isObfuscated ? "(Lof;FFF)V" : "(Lnet/minecraft/entity/EntityLivingBase;FFF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitVarInsn(23, 3);
        var1.visitVarInsn(23, 4);
        var1.visitMethodInsn(184, "api/player/model/ModelPlayerAPI", "setLivingAnimations", "(Lapi/player/model/IModelPlayerAPI;" + (this.isObfuscated ? "Lof;FFF" : "Lnet/minecraft/entity/EntityLivingBase;FFF") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realSetLivingAnimations", "" + (this.isObfuscated ? "(Lof;FFF)V" : "(Lnet/minecraft/entity/EntityLivingBase;FFF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitVarInsn(23, 3);
        var1.visitVarInsn(23, 4);
        var1.visitMethodInsn(182, "api/player/model/ModelPlayer", this.isObfuscated ? "a" : "setLivingAnimations", "" + (this.isObfuscated ? "(Lof;FFF)V" : "(Lnet/minecraft/entity/EntityLivingBase;FFF)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superSetLivingAnimations", "" + (this.isObfuscated ? "(Lof;FFF)V" : "(Lnet/minecraft/entity/EntityLivingBase;FFF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitVarInsn(23, 3);
        var1.visitVarInsn(23, 4);
        var1.visitMethodInsn(183, this.isObfuscated ? obfuscatedSuperClassReference : deobfuscateSuperClassReference, this.isObfuscated ? "a" : "setLivingAnimations", "" + (this.isObfuscated ? "(Lof;FFF)V" : "(Lnet/minecraft/entity/EntityLivingBase;FFF)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalSetLivingAnimations) {
            var1 = this.cv.visitMethod(17, "localSetLivingAnimations", "" + (this.isObfuscated ? "(Lof;FFF)V" : "(Lnet/minecraft/entity/EntityLivingBase;FFF)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitVarInsn(23, 2);
            var1.visitVarInsn(23, 3);
            var1.visitVarInsn(23, 4);
            var1.visitMethodInsn(183, this.isObfuscated ? obfuscatedSuperClassReference : deobfuscateSuperClassReference, this.isObfuscated ? "a" : "setLivingAnimations", "" + (this.isObfuscated ? "(Lof;FFF)V" : "(Lnet/minecraft/entity/EntityLivingBase;FFF)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "setRotationAngles", "" + (this.isObfuscated ? "(FFFFFFLnn;)V" : "(FFFFFFLnet/minecraft/entity/Entity;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(23, 1);
        var1.visitVarInsn(23, 2);
        var1.visitVarInsn(23, 3);
        var1.visitVarInsn(23, 4);
        var1.visitVarInsn(23, 5);
        var1.visitVarInsn(23, 6);
        var1.visitVarInsn(25, 7);
        var1.visitMethodInsn(184, "api/player/model/ModelPlayerAPI", "setRotationAngles", "(Lapi/player/model/IModelPlayerAPI;" + (this.isObfuscated ? "FFFFFFLnn;" : "FFFFFFLnet/minecraft/entity/Entity;") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realSetRotationAngles", "" + (this.isObfuscated ? "(FFFFFFLnn;)V" : "(FFFFFFLnet/minecraft/entity/Entity;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(23, 1);
        var1.visitVarInsn(23, 2);
        var1.visitVarInsn(23, 3);
        var1.visitVarInsn(23, 4);
        var1.visitVarInsn(23, 5);
        var1.visitVarInsn(23, 6);
        var1.visitVarInsn(25, 7);
        var1.visitMethodInsn(182, "api/player/model/ModelPlayer", this.isObfuscated ? "a" : "setRotationAngles", "" + (this.isObfuscated ? "(FFFFFFLnn;)V" : "(FFFFFFLnet/minecraft/entity/Entity;)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superSetRotationAngles", "" + (this.isObfuscated ? "(FFFFFFLnn;)V" : "(FFFFFFLnet/minecraft/entity/Entity;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(23, 1);
        var1.visitVarInsn(23, 2);
        var1.visitVarInsn(23, 3);
        var1.visitVarInsn(23, 4);
        var1.visitVarInsn(23, 5);
        var1.visitVarInsn(23, 6);
        var1.visitVarInsn(25, 7);
        var1.visitMethodInsn(183, this.isObfuscated ? obfuscatedSuperClassReference : deobfuscateSuperClassReference, this.isObfuscated ? "a" : "setRotationAngles", "" + (this.isObfuscated ? "(FFFFFFLnn;)V" : "(FFFFFFLnet/minecraft/entity/Entity;)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalSetRotationAngles) {
            var1 = this.cv.visitMethod(17, "localSetRotationAngles", "" + (this.isObfuscated ? "(FFFFFFLnn;)V" : "(FFFFFFLnet/minecraft/entity/Entity;)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(23, 1);
            var1.visitVarInsn(23, 2);
            var1.visitVarInsn(23, 3);
            var1.visitVarInsn(23, 4);
            var1.visitVarInsn(23, 5);
            var1.visitVarInsn(23, 6);
            var1.visitVarInsn(25, 7);
            var1.visitMethodInsn(183, this.isObfuscated ? obfuscatedSuperClassReference : deobfuscateSuperClassReference, this.isObfuscated ? "a" : "setRotationAngles", "" + (this.isObfuscated ? "(FFFFFFLnn;)V" : "(FFFFFFLnet/minecraft/entity/Entity;)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "setTextureOffset", "(Ljava/lang/String;II)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(21, 2);
        var1.visitVarInsn(21, 3);
        var1.visitMethodInsn(184, "api/player/model/ModelPlayerAPI", "setTextureOffset", "(Lapi/player/model/IModelPlayerAPI;Ljava/lang/String;II)V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realSetTextureOffset", "(Ljava/lang/String;II)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(21, 2);
        var1.visitVarInsn(21, 3);
        var1.visitMethodInsn(182, "api/player/model/ModelPlayer", this.isObfuscated ? "a" : "setTextureOffset", "(Ljava/lang/String;II)V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superSetTextureOffset", "(Ljava/lang/String;II)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(21, 2);
        var1.visitVarInsn(21, 3);
        var1.visitMethodInsn(183, this.isObfuscated ? obfuscatedSuperClassReference : deobfuscateSuperClassReference, this.isObfuscated ? "a" : "setTextureOffset", "(Ljava/lang/String;II)V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalSetTextureOffset) {
            var1 = this.cv.visitMethod(17, "localSetTextureOffset", "(Ljava/lang/String;II)V", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitVarInsn(21, 2);
            var1.visitVarInsn(21, 3);
            var1.visitMethodInsn(183, this.isObfuscated ? obfuscatedSuperClassReference : deobfuscateSuperClassReference, this.isObfuscated ? "a" : "setTextureOffset", "(Ljava/lang/String;II)V");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(17, "getAimedBowField", "()Z", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, "api/player/model/ModelPlayer", this.isObfuscated ? "o" : "aimedBow", "Z");
        var1.visitInsn(172);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setAimedBowField", "(Z)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(21, 1);
        var1.visitFieldInsn(181, "api/player/model/ModelPlayer", this.isObfuscated ? "o" : "aimedBow", "Z");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getBipedBodyField", this.isObfuscated ? "()Lbcu;" : "()Lnet/minecraft/client/model/ModelRenderer;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, "api/player/model/ModelPlayer", this.isObfuscated ? "e" : "bipedBody", this.isObfuscated ? "Lbcu;" : "Lnet/minecraft/client/model/ModelRenderer;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setBipedBodyField", this.isObfuscated ? "(Lbcu;)V" : "(Lnet/minecraft/client/model/ModelRenderer;)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitFieldInsn(181, "api/player/model/ModelPlayer", this.isObfuscated ? "e" : "bipedBody", this.isObfuscated ? "Lbcu;" : "Lnet/minecraft/client/model/ModelRenderer;");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getBipedCloakField", this.isObfuscated ? "()Lbcu;" : "()Lnet/minecraft/client/model/ModelRenderer;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, "api/player/model/ModelPlayer", this.isObfuscated ? "k" : "bipedCloak", this.isObfuscated ? "Lbcu;" : "Lnet/minecraft/client/model/ModelRenderer;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setBipedCloakField", this.isObfuscated ? "(Lbcu;)V" : "(Lnet/minecraft/client/model/ModelRenderer;)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitFieldInsn(181, "api/player/model/ModelPlayer", this.isObfuscated ? "k" : "bipedCloak", this.isObfuscated ? "Lbcu;" : "Lnet/minecraft/client/model/ModelRenderer;");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getBipedEarsField", this.isObfuscated ? "()Lbcu;" : "()Lnet/minecraft/client/model/ModelRenderer;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, "api/player/model/ModelPlayer", this.isObfuscated ? "j" : "bipedEars", this.isObfuscated ? "Lbcu;" : "Lnet/minecraft/client/model/ModelRenderer;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setBipedEarsField", this.isObfuscated ? "(Lbcu;)V" : "(Lnet/minecraft/client/model/ModelRenderer;)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitFieldInsn(181, "api/player/model/ModelPlayer", this.isObfuscated ? "j" : "bipedEars", this.isObfuscated ? "Lbcu;" : "Lnet/minecraft/client/model/ModelRenderer;");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getBipedHeadField", this.isObfuscated ? "()Lbcu;" : "()Lnet/minecraft/client/model/ModelRenderer;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, "api/player/model/ModelPlayer", this.isObfuscated ? "c" : "bipedHead", this.isObfuscated ? "Lbcu;" : "Lnet/minecraft/client/model/ModelRenderer;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setBipedHeadField", this.isObfuscated ? "(Lbcu;)V" : "(Lnet/minecraft/client/model/ModelRenderer;)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitFieldInsn(181, "api/player/model/ModelPlayer", this.isObfuscated ? "c" : "bipedHead", this.isObfuscated ? "Lbcu;" : "Lnet/minecraft/client/model/ModelRenderer;");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getBipedHeadwearField", this.isObfuscated ? "()Lbcu;" : "()Lnet/minecraft/client/model/ModelRenderer;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, "api/player/model/ModelPlayer", this.isObfuscated ? "d" : "bipedHeadwear", this.isObfuscated ? "Lbcu;" : "Lnet/minecraft/client/model/ModelRenderer;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setBipedHeadwearField", this.isObfuscated ? "(Lbcu;)V" : "(Lnet/minecraft/client/model/ModelRenderer;)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitFieldInsn(181, "api/player/model/ModelPlayer", this.isObfuscated ? "d" : "bipedHeadwear", this.isObfuscated ? "Lbcu;" : "Lnet/minecraft/client/model/ModelRenderer;");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getBipedLeftArmField", this.isObfuscated ? "()Lbcu;" : "()Lnet/minecraft/client/model/ModelRenderer;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, "api/player/model/ModelPlayer", this.isObfuscated ? "g" : "bipedLeftArm", this.isObfuscated ? "Lbcu;" : "Lnet/minecraft/client/model/ModelRenderer;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setBipedLeftArmField", this.isObfuscated ? "(Lbcu;)V" : "(Lnet/minecraft/client/model/ModelRenderer;)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitFieldInsn(181, "api/player/model/ModelPlayer", this.isObfuscated ? "g" : "bipedLeftArm", this.isObfuscated ? "Lbcu;" : "Lnet/minecraft/client/model/ModelRenderer;");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getBipedLeftLegField", this.isObfuscated ? "()Lbcu;" : "()Lnet/minecraft/client/model/ModelRenderer;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, "api/player/model/ModelPlayer", this.isObfuscated ? "i" : "bipedLeftLeg", this.isObfuscated ? "Lbcu;" : "Lnet/minecraft/client/model/ModelRenderer;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setBipedLeftLegField", this.isObfuscated ? "(Lbcu;)V" : "(Lnet/minecraft/client/model/ModelRenderer;)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitFieldInsn(181, "api/player/model/ModelPlayer", this.isObfuscated ? "i" : "bipedLeftLeg", this.isObfuscated ? "Lbcu;" : "Lnet/minecraft/client/model/ModelRenderer;");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getBipedRightArmField", this.isObfuscated ? "()Lbcu;" : "()Lnet/minecraft/client/model/ModelRenderer;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, "api/player/model/ModelPlayer", this.isObfuscated ? "f" : "bipedRightArm", this.isObfuscated ? "Lbcu;" : "Lnet/minecraft/client/model/ModelRenderer;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setBipedRightArmField", this.isObfuscated ? "(Lbcu;)V" : "(Lnet/minecraft/client/model/ModelRenderer;)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitFieldInsn(181, "api/player/model/ModelPlayer", this.isObfuscated ? "f" : "bipedRightArm", this.isObfuscated ? "Lbcu;" : "Lnet/minecraft/client/model/ModelRenderer;");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getBipedRightLegField", this.isObfuscated ? "()Lbcu;" : "()Lnet/minecraft/client/model/ModelRenderer;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, "api/player/model/ModelPlayer", this.isObfuscated ? "h" : "bipedRightLeg", this.isObfuscated ? "Lbcu;" : "Lnet/minecraft/client/model/ModelRenderer;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setBipedRightLegField", this.isObfuscated ? "(Lbcu;)V" : "(Lnet/minecraft/client/model/ModelRenderer;)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitFieldInsn(181, "api/player/model/ModelPlayer", this.isObfuscated ? "h" : "bipedRightLeg", this.isObfuscated ? "Lbcu;" : "Lnet/minecraft/client/model/ModelRenderer;");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getBoxListField", "()Ljava/util/List;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, "api/player/model/ModelPlayer", this.isObfuscated ? "r" : "boxList", "Ljava/util/List;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setBoxListField", "(Ljava/util/List;)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitFieldInsn(181, "api/player/model/ModelPlayer", this.isObfuscated ? "r" : "boxList", "Ljava/util/List;");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getHeldItemLeftField", "()I", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, "api/player/model/ModelPlayer", this.isObfuscated ? "l" : "heldItemLeft", "I");
        var1.visitInsn(172);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setHeldItemLeftField", "(I)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(21, 1);
        var1.visitFieldInsn(181, "api/player/model/ModelPlayer", this.isObfuscated ? "l" : "heldItemLeft", "I");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getHeldItemRightField", "()I", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, "api/player/model/ModelPlayer", this.isObfuscated ? "m" : "heldItemRight", "I");
        var1.visitInsn(172);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setHeldItemRightField", "(I)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(21, 1);
        var1.visitFieldInsn(181, "api/player/model/ModelPlayer", this.isObfuscated ? "m" : "heldItemRight", "I");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getIsChildField", "()Z", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, "api/player/model/ModelPlayer", this.isObfuscated ? "s" : "isChild", "Z");
        var1.visitInsn(172);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setIsChildField", "(Z)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(21, 1);
        var1.visitFieldInsn(181, "api/player/model/ModelPlayer", this.isObfuscated ? "s" : "isChild", "Z");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getIsRidingField", "()Z", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, "api/player/model/ModelPlayer", this.isObfuscated ? "q" : "isRiding", "Z");
        var1.visitInsn(172);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setIsRidingField", "(Z)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(21, 1);
        var1.visitFieldInsn(181, "api/player/model/ModelPlayer", this.isObfuscated ? "q" : "isRiding", "Z");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getIsSneakField", "()Z", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, "api/player/model/ModelPlayer", this.isObfuscated ? "n" : "isSneak", "Z");
        var1.visitInsn(172);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setIsSneakField", "(Z)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(21, 1);
        var1.visitFieldInsn(181, "api/player/model/ModelPlayer", this.isObfuscated ? "n" : "isSneak", "Z");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getOnGroundField", "()F", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, "api/player/model/ModelPlayer", this.isObfuscated ? "p" : "onGround", "F");
        var1.visitInsn(174);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setOnGroundField", "(F)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(23, 1);
        var1.visitFieldInsn(181, "api/player/model/ModelPlayer", this.isObfuscated ? "p" : "onGround", "F");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getTextureHeightField", "()I", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, "api/player/model/ModelPlayer", this.isObfuscated ? "u" : "textureHeight", "I");
        var1.visitInsn(172);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setTextureHeightField", "(I)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(21, 1);
        var1.visitFieldInsn(181, "api/player/model/ModelPlayer", this.isObfuscated ? "u" : "textureHeight", "I");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getTextureWidthField", "()I", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, "api/player/model/ModelPlayer", this.isObfuscated ? "t" : "textureWidth", "I");
        var1.visitInsn(172);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setTextureWidthField", "(I)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(21, 1);
        var1.visitFieldInsn(181, "api/player/model/ModelPlayer", this.isObfuscated ? "t" : "textureWidth", "I");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getModelPlayerBase", "(Ljava/lang/String;)Lapi/player/model/ModelPlayerBase;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(184, "api/player/model/ModelPlayerAPI", "getModelPlayerBase", "(Lapi/player/model/IModelPlayerAPI;Ljava/lang/String;)Lapi/player/model/ModelPlayerBase;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getModelPlayerBaseIds", "()Ljava/util/Set;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitMethodInsn(184, "api/player/model/ModelPlayerAPI", "getModelPlayerBaseIds", "(Lapi/player/model/IModelPlayerAPI;)Ljava/util/Set;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getExpandParameter", "()F", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitMethodInsn(184, "api/player/model/ModelPlayerAPI", "getExpandParameter", "(Lapi/player/model/IModelPlayerAPI;)F");
        var1.visitInsn(174);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getModelPlayerType", "()Ljava/lang/String;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitMethodInsn(184, "api/player/model/ModelPlayerAPI", "getModelPlayerType", "(Lapi/player/model/IModelPlayerAPI;)Ljava/lang/String;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "dynamic", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(25, 2);
        var1.visitMethodInsn(184, "api/player/model/ModelPlayerAPI", "dynamic", "(Lapi/player/model/IModelPlayerAPI;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getModelPlayerAPI", "()Lapi/player/model/ModelPlayerAPI;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, "api/player/model/ModelPlayer", "modelPlayerAPI", "Lapi/player/model/ModelPlayerAPI;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getModelPlayer", "()Lapi/player/model/ModelPlayer;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(9, "getAllInstances", "()[Lapi/player/model/ModelPlayer;", (String)null, (String[])null);
        var1.visitMethodInsn(184, "api/player/model/ModelPlayerAPI", "getAllInstances", "()[Lapi/player/model/ModelPlayer;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        this.cv.visitField(18, "modelPlayerAPI", "Lapi/player/model/ModelPlayerAPI;", (String)null, null);
    }
}

