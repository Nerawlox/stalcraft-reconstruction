/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.objectweb.asm.ClassReader
 *  org.objectweb.asm.ClassVisitor
 *  org.objectweb.asm.ClassWriter
 *  org.objectweb.asm.MethodVisitor
 */
package api.player.render;

import api.player.render.RenderPlayerConstructorVisitor;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Stack;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public final class RenderPlayerClassVisitor
extends ClassVisitor {
    public static final String targetClassName = "net.minecraft.client.renderer.entity.RenderPlayer";
    private boolean hadLocalDoRenderLabel;
    private boolean hadLocalDoRenderShadowAndFire;
    private boolean hadLocalGetColorMultiplier;
    private boolean hadLocalGetDeathMaxRotation;
    private boolean hadLocalGetFontRendererFromRenderManager;
    private boolean hadLocalGetResourceLocationFromPlayer;
    private boolean hadLocalHandleRotationFloat;
    private boolean hadLocalInheritRenderPass;
    private boolean hadLocalLoadTexture;
    private boolean hadLocalLoadTextureOfEntity;
    private boolean hadLocalPassSpecialRender;
    private boolean hadLocalRenderArrowsStuckInEntity;
    private boolean hadLocalRenderFirstPersonArm;
    private boolean hadLocalRenderLivingLabel;
    private boolean hadLocalRenderModel;
    private boolean hadLocalRenderPlayer;
    private boolean hadLocalRenderPlayerNameAndScoreLabel;
    private boolean hadLocalRenderPlayerScale;
    private boolean hadLocalRenderPlayerSleep;
    private boolean hadLocalRenderSpecials;
    private boolean hadLocalRenderSwingProgress;
    private boolean hadLocalRotatePlayer;
    private boolean hadLocalSetArmorModel;
    private boolean hadLocalSetPassArmorModel;
    private boolean hadLocalSetRenderManager;
    private boolean hadLocalSetRenderPassModel;
    private boolean hadLocalUpdateIcons;
    private final boolean isObfuscated;
    private final Map<String, Stack<String>> constructorReplacements;

    public static byte[] transform(byte[] var0, boolean var1, Map<String, Stack<String>> var2) {
        try {
            ByteArrayInputStream var3 = new ByteArrayInputStream(var0);
            ClassReader var4 = new ClassReader((InputStream)var3);
            ClassWriter var5 = new ClassWriter(1);
            RenderPlayerClassVisitor var6 = new RenderPlayerClassVisitor((ClassVisitor)var5, var1, var2);
            var4.accept((ClassVisitor)var6, 0);
            byte[] var7 = var5.toByteArray();
            var3.close();
            return var7;
        }
        catch (IOException var8) {
            throw new RuntimeException(var8);
        }
    }

    public RenderPlayerClassVisitor(ClassVisitor var1, boolean var2, Map<String, Stack<String>> var3) {
        super(262144, var1);
        this.isObfuscated = var2;
        this.constructorReplacements = var3;
    }

    public void visit(int var1, int var2, String var3, String var4, String var5, String[] var6) {
        String[] var7 = new String[var6.length + 1];
        for (int var8 = 0; var8 < var6.length; ++var8) {
            var7[var8] = var6[var8];
        }
        var7[var6.length] = "api/player/render/IRenderPlayerAPI";
        super.visit(var1, var2, var3, var4, var5, var7);
    }

    public MethodVisitor visitMethod(int var1, String var2, String var3, String var4, String[] var5) {
        if (var2.equals("<init>")) {
            return new RenderPlayerConstructorVisitor(super.visitMethod(var1, var2, var3, var4, var5), this.isObfuscated, this.constructorReplacements);
        }
        if (var2.equals(this.isObfuscated ? "b" : "func_110813_b") && var3.equals(this.isObfuscated ? "(Lof;)Z" : "(Lnet/minecraft/entity/EntityLivingBase;)Z")) {
            this.hadLocalDoRenderLabel = true;
            return super.visitMethod(17, "localDoRenderLabel", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "b" : "doRenderShadowAndFire") && var3.equals(this.isObfuscated ? "(Lnn;DDDFF)V" : "(Lnet/minecraft/entity/Entity;DDDFF)V")) {
            this.hadLocalDoRenderShadowAndFire = true;
            return super.visitMethod(17, "localDoRenderShadowAndFire", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "getColorMultiplier") && var3.equals(this.isObfuscated ? "(Lof;FF)I" : "(Lnet/minecraft/entity/EntityLivingBase;FF)I")) {
            this.hadLocalGetColorMultiplier = true;
            return super.visitMethod(17, "localGetColorMultiplier", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "getDeathMaxRotation") && var3.equals(this.isObfuscated ? "(Lof;)F" : "(Lnet/minecraft/entity/EntityLivingBase;)F")) {
            this.hadLocalGetDeathMaxRotation = true;
            return super.visitMethod(17, "localGetDeathMaxRotation", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "getFontRendererFromRenderManager") && var3.equals(this.isObfuscated ? "()Lavi;" : "()Lnet/minecraft/client/gui/FontRenderer;")) {
            this.hadLocalGetFontRendererFromRenderManager = true;
            return super.visitMethod(17, "localGetFontRendererFromRenderManager", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "func_110817_a") && var3.equals(this.isObfuscated ? "(Lbeu;)Lbjo;" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;)Lnet/minecraft/util/ResourceLocation;")) {
            this.hadLocalGetResourceLocationFromPlayer = true;
            return super.visitMethod(17, "localGetResourceLocationFromPlayer", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "b" : "handleRotationFloat") && var3.equals(this.isObfuscated ? "(Lof;F)F" : "(Lnet/minecraft/entity/EntityLivingBase;F)F")) {
            this.hadLocalHandleRotationFloat = true;
            return super.visitMethod(17, "localHandleRotationFloat", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "b" : "inheritRenderPass") && var3.equals(this.isObfuscated ? "(Lof;IF)I" : "(Lnet/minecraft/entity/EntityLivingBase;IF)I")) {
            this.hadLocalInheritRenderPass = true;
            return super.visitMethod(17, "localInheritRenderPass", var3, var4, var5);
        }
        if (var2.equals("bindTexture") && var3.equals(this.isObfuscated ? "(Lbjo;)V" : "(Lnet/minecraft/util/ResourceLocation;)V")) {
            this.hadLocalLoadTexture = true;
            return super.visitMethod(17, "localLoadTexture", var3, var4, var5);
        }
        if (var2.equals("bindEntityTexture") && var3.equals(this.isObfuscated ? "(Lnn;)V" : "(Lnet/minecraft/entity/Entity;)V")) {
            this.hadLocalLoadTextureOfEntity = true;
            return super.visitMethod(17, "localLoadTextureOfEntity", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "b" : "passSpecialRender") && var3.equals(this.isObfuscated ? "(Lof;DDD)V" : "(Lnet/minecraft/entity/EntityLivingBase;DDD)V")) {
            this.hadLocalPassSpecialRender = true;
            return super.visitMethod(17, "localPassSpecialRender", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "e" : "renderArrowsStuckInEntity") && var3.equals(this.isObfuscated ? "(Lof;F)V" : "(Lnet/minecraft/entity/EntityLivingBase;F)V")) {
            this.hadLocalRenderArrowsStuckInEntity = true;
            return super.visitMethod(17, "localRenderArrowsStuckInEntity", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "renderFirstPersonArm") && var3.equals(this.isObfuscated ? "(Luf;)V" : "(Lnet/minecraft/entity/player/EntityPlayer;)V")) {
            this.hadLocalRenderFirstPersonArm = true;
            return super.visitMethod(17, "localRenderFirstPersonArm", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "renderLivingLabel") && var3.equals(this.isObfuscated ? "(Lof;Ljava/lang/String;DDDI)V" : "(Lnet/minecraft/entity/EntityLivingBase;Ljava/lang/String;DDDI)V")) {
            this.hadLocalRenderLivingLabel = true;
            return super.visitMethod(17, "localRenderLivingLabel", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "renderModel") && var3.equals(this.isObfuscated ? "(Lof;FFFFFF)V" : "(Lnet/minecraft/entity/EntityLivingBase;FFFFFF)V")) {
            this.hadLocalRenderModel = true;
            return super.visitMethod(17, "localRenderModel", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "func_130009_a") && var3.equals(this.isObfuscated ? "(Lbeu;DDDFF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDDFF)V")) {
            this.hadLocalRenderPlayer = true;
            return super.visitMethod(17, "localRenderPlayer", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "func_96450_a") && var3.equals(this.isObfuscated ? "(Lbeu;DDDLjava/lang/String;FD)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDDLjava/lang/String;FD)V")) {
            this.hadLocalRenderPlayerNameAndScoreLabel = true;
            return super.visitMethod(17, "localRenderPlayerNameAndScoreLabel", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "b" : "renderPlayerScale") && var3.equals(this.isObfuscated ? "(Lbeu;F)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V")) {
            this.hadLocalRenderPlayerScale = true;
            return super.visitMethod(17, "localRenderPlayerScale", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "renderPlayerSleep") && var3.equals(this.isObfuscated ? "(Lbeu;DDD)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDD)V")) {
            this.hadLocalRenderPlayerSleep = true;
            return super.visitMethod(17, "localRenderPlayerSleep", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "renderSpecials") && var3.equals(this.isObfuscated ? "(Lbeu;F)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V")) {
            this.hadLocalRenderSpecials = true;
            return super.visitMethod(17, "localRenderSpecials", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "d" : "renderSwingProgress") && var3.equals(this.isObfuscated ? "(Lof;F)F" : "(Lnet/minecraft/entity/EntityLivingBase;F)F")) {
            this.hadLocalRenderSwingProgress = true;
            return super.visitMethod(17, "localRenderSwingProgress", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "rotatePlayer") && var3.equals(this.isObfuscated ? "(Lbeu;FFF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;FFF)V")) {
            this.hadLocalRotatePlayer = true;
            return super.visitMethod(17, "localRotatePlayer", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "setArmorModel") && var3.equals(this.isObfuscated ? "(Lbeu;IF)I" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;IF)I")) {
            this.hadLocalSetArmorModel = true;
            return super.visitMethod(17, "localSetArmorModel", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "b" : "func_130220_b") && var3.equals(this.isObfuscated ? "(Lbeu;IF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;IF)V")) {
            this.hadLocalSetPassArmorModel = true;
            return super.visitMethod(17, "localSetPassArmorModel", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "setRenderManager") && var3.equals(this.isObfuscated ? "(Lbgl;)V" : "(Lnet/minecraft/client/renderer/entity/RenderManager;)V")) {
            this.hadLocalSetRenderManager = true;
            return super.visitMethod(17, "localSetRenderManager", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "setRenderPassModel") && var3.equals(this.isObfuscated ? "(Lbbo;)V" : "(Lnet/minecraft/client/model/ModelBase;)V")) {
            this.hadLocalSetRenderPassModel = true;
            return super.visitMethod(17, "localSetRenderPassModel", var3, var4, var5);
        }
        if (var2.equals(this.isObfuscated ? "a" : "updateIcons") && var3.equals(this.isObfuscated ? "(Lmt;)V" : "(Lnet/minecraft/client/renderer/texture/IconRegister;)V")) {
            this.hadLocalUpdateIcons = true;
            return super.visitMethod(17, "localUpdateIcons", var3, var4, var5);
        }
        return super.visitMethod(var1, var2, var3, var4, var5);
    }

    public void visitEnd() {
        MethodVisitor var1 = this.cv.visitMethod(1, this.isObfuscated ? "b" : "func_110813_b", "" + (this.isObfuscated ? "(Lof;)Z" : "(Lnet/minecraft/entity/EntityLivingBase;)Z") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "doRenderLabel", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lof;" : "Lnet/minecraft/entity/EntityLivingBase;") + ")Z");
        var1.visitInsn(172);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realDoRenderLabel", "" + (this.isObfuscated ? "(Lof;)Z" : "(Lnet/minecraft/entity/EntityLivingBase;)Z") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "b" : "func_110813_b", "" + (this.isObfuscated ? "(Lof;)Z" : "(Lnet/minecraft/entity/EntityLivingBase;)Z") + "");
        var1.visitInsn(172);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superDoRenderLabel", "" + (this.isObfuscated ? "(Lof;)Z" : "(Lnet/minecraft/entity/EntityLivingBase;)Z") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "b" : "func_110813_b", "" + (this.isObfuscated ? "(Lof;)Z" : "(Lnet/minecraft/entity/EntityLivingBase;)Z") + "");
        var1.visitInsn(172);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalDoRenderLabel) {
            var1 = this.cv.visitMethod(17, "localDoRenderLabel", "" + (this.isObfuscated ? "(Lof;)Z" : "(Lnet/minecraft/entity/EntityLivingBase;)Z") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "b" : "func_110813_b", "" + (this.isObfuscated ? "(Lof;)Z" : "(Lnet/minecraft/entity/EntityLivingBase;)Z") + "");
            var1.visitInsn(172);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "b" : "doRenderShadowAndFire", "" + (this.isObfuscated ? "(Lnn;DDDFF)V" : "(Lnet/minecraft/entity/Entity;DDDFF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(24, 2);
        var1.visitVarInsn(24, 4);
        var1.visitVarInsn(24, 6);
        var1.visitVarInsn(23, 8);
        var1.visitVarInsn(23, 9);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "doRenderShadowAndFire", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lnn;DDDFF" : "Lnet/minecraft/entity/Entity;DDDFF") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realDoRenderShadowAndFire", "" + (this.isObfuscated ? "(Lnn;DDDFF)V" : "(Lnet/minecraft/entity/Entity;DDDFF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(24, 2);
        var1.visitVarInsn(24, 4);
        var1.visitVarInsn(24, 6);
        var1.visitVarInsn(23, 8);
        var1.visitVarInsn(23, 9);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "b" : "doRenderShadowAndFire", "" + (this.isObfuscated ? "(Lnn;DDDFF)V" : "(Lnet/minecraft/entity/Entity;DDDFF)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superDoRenderShadowAndFire", "" + (this.isObfuscated ? "(Lnn;DDDFF)V" : "(Lnet/minecraft/entity/Entity;DDDFF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(24, 2);
        var1.visitVarInsn(24, 4);
        var1.visitVarInsn(24, 6);
        var1.visitVarInsn(23, 8);
        var1.visitVarInsn(23, 9);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "b" : "doRenderShadowAndFire", "" + (this.isObfuscated ? "(Lnn;DDDFF)V" : "(Lnet/minecraft/entity/Entity;DDDFF)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalDoRenderShadowAndFire) {
            var1 = this.cv.visitMethod(17, "localDoRenderShadowAndFire", "" + (this.isObfuscated ? "(Lnn;DDDFF)V" : "(Lnet/minecraft/entity/Entity;DDDFF)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitVarInsn(24, 2);
            var1.visitVarInsn(24, 4);
            var1.visitVarInsn(24, 6);
            var1.visitVarInsn(23, 8);
            var1.visitVarInsn(23, 9);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "b" : "doRenderShadowAndFire", "" + (this.isObfuscated ? "(Lnn;DDDFF)V" : "(Lnet/minecraft/entity/Entity;DDDFF)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "getColorMultiplier", "" + (this.isObfuscated ? "(Lof;FF)I" : "(Lnet/minecraft/entity/EntityLivingBase;FF)I") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitVarInsn(23, 3);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "getColorMultiplier", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lof;FF" : "Lnet/minecraft/entity/EntityLivingBase;FF") + ")I");
        var1.visitInsn(172);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realGetColorMultiplier", "" + (this.isObfuscated ? "(Lof;FF)I" : "(Lnet/minecraft/entity/EntityLivingBase;FF)I") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitVarInsn(23, 3);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "a" : "getColorMultiplier", "" + (this.isObfuscated ? "(Lof;FF)I" : "(Lnet/minecraft/entity/EntityLivingBase;FF)I") + "");
        var1.visitInsn(172);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superGetColorMultiplier", "" + (this.isObfuscated ? "(Lof;FF)I" : "(Lnet/minecraft/entity/EntityLivingBase;FF)I") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitVarInsn(23, 3);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "getColorMultiplier", "" + (this.isObfuscated ? "(Lof;FF)I" : "(Lnet/minecraft/entity/EntityLivingBase;FF)I") + "");
        var1.visitInsn(172);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalGetColorMultiplier) {
            var1 = this.cv.visitMethod(17, "localGetColorMultiplier", "" + (this.isObfuscated ? "(Lof;FF)I" : "(Lnet/minecraft/entity/EntityLivingBase;FF)I") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitVarInsn(23, 2);
            var1.visitVarInsn(23, 3);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "getColorMultiplier", "" + (this.isObfuscated ? "(Lof;FF)I" : "(Lnet/minecraft/entity/EntityLivingBase;FF)I") + "");
            var1.visitInsn(172);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "getDeathMaxRotation", "" + (this.isObfuscated ? "(Lof;)F" : "(Lnet/minecraft/entity/EntityLivingBase;)F") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "getDeathMaxRotation", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lof;" : "Lnet/minecraft/entity/EntityLivingBase;") + ")F");
        var1.visitInsn(174);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realGetDeathMaxRotation", "" + (this.isObfuscated ? "(Lof;)F" : "(Lnet/minecraft/entity/EntityLivingBase;)F") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "a" : "getDeathMaxRotation", "" + (this.isObfuscated ? "(Lof;)F" : "(Lnet/minecraft/entity/EntityLivingBase;)F") + "");
        var1.visitInsn(174);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superGetDeathMaxRotation", "" + (this.isObfuscated ? "(Lof;)F" : "(Lnet/minecraft/entity/EntityLivingBase;)F") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "getDeathMaxRotation", "" + (this.isObfuscated ? "(Lof;)F" : "(Lnet/minecraft/entity/EntityLivingBase;)F") + "");
        var1.visitInsn(174);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalGetDeathMaxRotation) {
            var1 = this.cv.visitMethod(17, "localGetDeathMaxRotation", "" + (this.isObfuscated ? "(Lof;)F" : "(Lnet/minecraft/entity/EntityLivingBase;)F") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "getDeathMaxRotation", "" + (this.isObfuscated ? "(Lof;)F" : "(Lnet/minecraft/entity/EntityLivingBase;)F") + "");
            var1.visitInsn(174);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "getFontRendererFromRenderManager", "" + (this.isObfuscated ? "()Lavi;" : "()Lnet/minecraft/client/gui/FontRenderer;") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "getFontRendererFromRenderManager", "(Lapi/player/render/IRenderPlayerAPI;)" + (this.isObfuscated ? "Lavi;" : "Lnet/minecraft/client/gui/FontRenderer;") + "");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realGetFontRendererFromRenderManager", "" + (this.isObfuscated ? "()Lavi;" : "()Lnet/minecraft/client/gui/FontRenderer;") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "a" : "getFontRendererFromRenderManager", "" + (this.isObfuscated ? "()Lavi;" : "()Lnet/minecraft/client/gui/FontRenderer;") + "");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superGetFontRendererFromRenderManager", "" + (this.isObfuscated ? "()Lavi;" : "()Lnet/minecraft/client/gui/FontRenderer;") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "getFontRendererFromRenderManager", "" + (this.isObfuscated ? "()Lavi;" : "()Lnet/minecraft/client/gui/FontRenderer;") + "");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalGetFontRendererFromRenderManager) {
            var1 = this.cv.visitMethod(17, "localGetFontRendererFromRenderManager", "" + (this.isObfuscated ? "()Lavi;" : "()Lnet/minecraft/client/gui/FontRenderer;") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "getFontRendererFromRenderManager", "" + (this.isObfuscated ? "()Lavi;" : "()Lnet/minecraft/client/gui/FontRenderer;") + "");
            var1.visitInsn(176);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "func_110817_a", "" + (this.isObfuscated ? "(Lbeu;)Lbjo;" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;)Lnet/minecraft/util/ResourceLocation;") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "getResourceLocationFromPlayer", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lbeu;" : "Lnet/minecraft/client/entity/AbstractClientPlayer;") + ")" + (this.isObfuscated ? "Lbjo;" : "Lnet/minecraft/util/ResourceLocation;") + "");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realGetResourceLocationFromPlayer", "" + (this.isObfuscated ? "(Lbeu;)Lbjo;" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;)Lnet/minecraft/util/ResourceLocation;") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "a" : "func_110817_a", "" + (this.isObfuscated ? "(Lbeu;)Lbjo;" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;)Lnet/minecraft/util/ResourceLocation;") + "");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superGetResourceLocationFromPlayer", "" + (this.isObfuscated ? "(Lbeu;)Lbjo;" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;)Lnet/minecraft/util/ResourceLocation;") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "func_110817_a", "" + (this.isObfuscated ? "(Lbeu;)Lbjo;" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;)Lnet/minecraft/util/ResourceLocation;") + "");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalGetResourceLocationFromPlayer) {
            var1 = this.cv.visitMethod(17, "localGetResourceLocationFromPlayer", "" + (this.isObfuscated ? "(Lbeu;)Lbjo;" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;)Lnet/minecraft/util/ResourceLocation;") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "func_110817_a", "" + (this.isObfuscated ? "(Lbeu;)Lbjo;" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;)Lnet/minecraft/util/ResourceLocation;") + "");
            var1.visitInsn(176);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "b" : "handleRotationFloat", "" + (this.isObfuscated ? "(Lof;F)F" : "(Lnet/minecraft/entity/EntityLivingBase;F)F") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "handleRotationFloat", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lof;F" : "Lnet/minecraft/entity/EntityLivingBase;F") + ")F");
        var1.visitInsn(174);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realHandleRotationFloat", "" + (this.isObfuscated ? "(Lof;F)F" : "(Lnet/minecraft/entity/EntityLivingBase;F)F") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "b" : "handleRotationFloat", "" + (this.isObfuscated ? "(Lof;F)F" : "(Lnet/minecraft/entity/EntityLivingBase;F)F") + "");
        var1.visitInsn(174);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superHandleRotationFloat", "" + (this.isObfuscated ? "(Lof;F)F" : "(Lnet/minecraft/entity/EntityLivingBase;F)F") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "b" : "handleRotationFloat", "" + (this.isObfuscated ? "(Lof;F)F" : "(Lnet/minecraft/entity/EntityLivingBase;F)F") + "");
        var1.visitInsn(174);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalHandleRotationFloat) {
            var1 = this.cv.visitMethod(17, "localHandleRotationFloat", "" + (this.isObfuscated ? "(Lof;F)F" : "(Lnet/minecraft/entity/EntityLivingBase;F)F") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitVarInsn(23, 2);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "b" : "handleRotationFloat", "" + (this.isObfuscated ? "(Lof;F)F" : "(Lnet/minecraft/entity/EntityLivingBase;F)F") + "");
            var1.visitInsn(174);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "b" : "inheritRenderPass", "" + (this.isObfuscated ? "(Lof;IF)I" : "(Lnet/minecraft/entity/EntityLivingBase;IF)I") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(21, 2);
        var1.visitVarInsn(23, 3);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "inheritRenderPass", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lof;IF" : "Lnet/minecraft/entity/EntityLivingBase;IF") + ")I");
        var1.visitInsn(172);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realInheritRenderPass", "" + (this.isObfuscated ? "(Lof;IF)I" : "(Lnet/minecraft/entity/EntityLivingBase;IF)I") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(21, 2);
        var1.visitVarInsn(23, 3);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "b" : "inheritRenderPass", "" + (this.isObfuscated ? "(Lof;IF)I" : "(Lnet/minecraft/entity/EntityLivingBase;IF)I") + "");
        var1.visitInsn(172);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superInheritRenderPass", "" + (this.isObfuscated ? "(Lof;IF)I" : "(Lnet/minecraft/entity/EntityLivingBase;IF)I") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(21, 2);
        var1.visitVarInsn(23, 3);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "b" : "inheritRenderPass", "" + (this.isObfuscated ? "(Lof;IF)I" : "(Lnet/minecraft/entity/EntityLivingBase;IF)I") + "");
        var1.visitInsn(172);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalInheritRenderPass) {
            var1 = this.cv.visitMethod(17, "localInheritRenderPass", "" + (this.isObfuscated ? "(Lof;IF)I" : "(Lnet/minecraft/entity/EntityLivingBase;IF)I") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitVarInsn(21, 2);
            var1.visitVarInsn(23, 3);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "b" : "inheritRenderPass", "" + (this.isObfuscated ? "(Lof;IF)I" : "(Lnet/minecraft/entity/EntityLivingBase;IF)I") + "");
            var1.visitInsn(172);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, "bindTexture", "" + (this.isObfuscated ? "(Lbjo;)V" : "(Lnet/minecraft/util/ResourceLocation;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "loadTexture", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lbjo;" : "Lnet/minecraft/util/ResourceLocation;") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realLoadTexture", "" + (this.isObfuscated ? "(Lbjo;)V" : "(Lnet/minecraft/util/ResourceLocation;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", "bindTexture", "" + (this.isObfuscated ? "(Lbjo;)V" : "(Lnet/minecraft/util/ResourceLocation;)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superLoadTexture", "" + (this.isObfuscated ? "(Lbjo;)V" : "(Lnet/minecraft/util/ResourceLocation;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", "bindTexture", "" + (this.isObfuscated ? "(Lbjo;)V" : "(Lnet/minecraft/util/ResourceLocation;)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalLoadTexture) {
            var1 = this.cv.visitMethod(17, "localLoadTexture", "" + (this.isObfuscated ? "(Lbjo;)V" : "(Lnet/minecraft/util/ResourceLocation;)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", "bindTexture", "" + (this.isObfuscated ? "(Lbjo;)V" : "(Lnet/minecraft/util/ResourceLocation;)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, "bindEntityTexture", "" + (this.isObfuscated ? "(Lnn;)V" : "(Lnet/minecraft/entity/Entity;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "loadTextureOfEntity", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lnn;" : "Lnet/minecraft/entity/Entity;") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realLoadTextureOfEntity", "" + (this.isObfuscated ? "(Lnn;)V" : "(Lnet/minecraft/entity/Entity;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", "bindEntityTexture", "" + (this.isObfuscated ? "(Lnn;)V" : "(Lnet/minecraft/entity/Entity;)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superLoadTextureOfEntity", "" + (this.isObfuscated ? "(Lnn;)V" : "(Lnet/minecraft/entity/Entity;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", "bindEntityTexture", "" + (this.isObfuscated ? "(Lnn;)V" : "(Lnet/minecraft/entity/Entity;)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalLoadTextureOfEntity) {
            var1 = this.cv.visitMethod(17, "localLoadTextureOfEntity", "" + (this.isObfuscated ? "(Lnn;)V" : "(Lnet/minecraft/entity/Entity;)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", "bindEntityTexture", "" + (this.isObfuscated ? "(Lnn;)V" : "(Lnet/minecraft/entity/Entity;)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "b" : "passSpecialRender", "" + (this.isObfuscated ? "(Lof;DDD)V" : "(Lnet/minecraft/entity/EntityLivingBase;DDD)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(24, 2);
        var1.visitVarInsn(24, 4);
        var1.visitVarInsn(24, 6);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "passSpecialRender", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lof;DDD" : "Lnet/minecraft/entity/EntityLivingBase;DDD") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realPassSpecialRender", "" + (this.isObfuscated ? "(Lof;DDD)V" : "(Lnet/minecraft/entity/EntityLivingBase;DDD)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(24, 2);
        var1.visitVarInsn(24, 4);
        var1.visitVarInsn(24, 6);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "b" : "passSpecialRender", "" + (this.isObfuscated ? "(Lof;DDD)V" : "(Lnet/minecraft/entity/EntityLivingBase;DDD)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superPassSpecialRender", "" + (this.isObfuscated ? "(Lof;DDD)V" : "(Lnet/minecraft/entity/EntityLivingBase;DDD)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(24, 2);
        var1.visitVarInsn(24, 4);
        var1.visitVarInsn(24, 6);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "b" : "passSpecialRender", "" + (this.isObfuscated ? "(Lof;DDD)V" : "(Lnet/minecraft/entity/EntityLivingBase;DDD)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalPassSpecialRender) {
            var1 = this.cv.visitMethod(17, "localPassSpecialRender", "" + (this.isObfuscated ? "(Lof;DDD)V" : "(Lnet/minecraft/entity/EntityLivingBase;DDD)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitVarInsn(24, 2);
            var1.visitVarInsn(24, 4);
            var1.visitVarInsn(24, 6);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "b" : "passSpecialRender", "" + (this.isObfuscated ? "(Lof;DDD)V" : "(Lnet/minecraft/entity/EntityLivingBase;DDD)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "e" : "renderArrowsStuckInEntity", "" + (this.isObfuscated ? "(Lof;F)V" : "(Lnet/minecraft/entity/EntityLivingBase;F)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "renderArrowsStuckInEntity", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lof;F" : "Lnet/minecraft/entity/EntityLivingBase;F") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realRenderArrowsStuckInEntity", "" + (this.isObfuscated ? "(Lof;F)V" : "(Lnet/minecraft/entity/EntityLivingBase;F)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "e" : "renderArrowsStuckInEntity", "" + (this.isObfuscated ? "(Lof;F)V" : "(Lnet/minecraft/entity/EntityLivingBase;F)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superRenderArrowsStuckInEntity", "" + (this.isObfuscated ? "(Lof;F)V" : "(Lnet/minecraft/entity/EntityLivingBase;F)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "e" : "renderArrowsStuckInEntity", "" + (this.isObfuscated ? "(Lof;F)V" : "(Lnet/minecraft/entity/EntityLivingBase;F)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalRenderArrowsStuckInEntity) {
            var1 = this.cv.visitMethod(17, "localRenderArrowsStuckInEntity", "" + (this.isObfuscated ? "(Lof;F)V" : "(Lnet/minecraft/entity/EntityLivingBase;F)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitVarInsn(23, 2);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "e" : "renderArrowsStuckInEntity", "" + (this.isObfuscated ? "(Lof;F)V" : "(Lnet/minecraft/entity/EntityLivingBase;F)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "renderFirstPersonArm", "" + (this.isObfuscated ? "(Luf;)V" : "(Lnet/minecraft/entity/player/EntityPlayer;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "renderFirstPersonArm", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Luf;" : "Lnet/minecraft/entity/player/EntityPlayer;") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realRenderFirstPersonArm", "" + (this.isObfuscated ? "(Luf;)V" : "(Lnet/minecraft/entity/player/EntityPlayer;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "a" : "renderFirstPersonArm", "" + (this.isObfuscated ? "(Luf;)V" : "(Lnet/minecraft/entity/player/EntityPlayer;)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superRenderFirstPersonArm", "" + (this.isObfuscated ? "(Luf;)V" : "(Lnet/minecraft/entity/player/EntityPlayer;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "renderFirstPersonArm", "" + (this.isObfuscated ? "(Luf;)V" : "(Lnet/minecraft/entity/player/EntityPlayer;)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalRenderFirstPersonArm) {
            var1 = this.cv.visitMethod(17, "localRenderFirstPersonArm", "" + (this.isObfuscated ? "(Luf;)V" : "(Lnet/minecraft/entity/player/EntityPlayer;)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "renderFirstPersonArm", "" + (this.isObfuscated ? "(Luf;)V" : "(Lnet/minecraft/entity/player/EntityPlayer;)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "renderLivingLabel", "" + (this.isObfuscated ? "(Lof;Ljava/lang/String;DDDI)V" : "(Lnet/minecraft/entity/EntityLivingBase;Ljava/lang/String;DDDI)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(25, 2);
        var1.visitVarInsn(24, 3);
        var1.visitVarInsn(24, 5);
        var1.visitVarInsn(24, 7);
        var1.visitVarInsn(21, 9);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "renderLivingLabel", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lof;Ljava/lang/String;DDDI" : "Lnet/minecraft/entity/EntityLivingBase;Ljava/lang/String;DDDI") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realRenderLivingLabel", "" + (this.isObfuscated ? "(Lof;Ljava/lang/String;DDDI)V" : "(Lnet/minecraft/entity/EntityLivingBase;Ljava/lang/String;DDDI)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(25, 2);
        var1.visitVarInsn(24, 3);
        var1.visitVarInsn(24, 5);
        var1.visitVarInsn(24, 7);
        var1.visitVarInsn(21, 9);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "a" : "renderLivingLabel", "" + (this.isObfuscated ? "(Lof;Ljava/lang/String;DDDI)V" : "(Lnet/minecraft/entity/EntityLivingBase;Ljava/lang/String;DDDI)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superRenderLivingLabel", "" + (this.isObfuscated ? "(Lof;Ljava/lang/String;DDDI)V" : "(Lnet/minecraft/entity/EntityLivingBase;Ljava/lang/String;DDDI)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(25, 2);
        var1.visitVarInsn(24, 3);
        var1.visitVarInsn(24, 5);
        var1.visitVarInsn(24, 7);
        var1.visitVarInsn(21, 9);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "renderLivingLabel", "" + (this.isObfuscated ? "(Lof;Ljava/lang/String;DDDI)V" : "(Lnet/minecraft/entity/EntityLivingBase;Ljava/lang/String;DDDI)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalRenderLivingLabel) {
            var1 = this.cv.visitMethod(17, "localRenderLivingLabel", "" + (this.isObfuscated ? "(Lof;Ljava/lang/String;DDDI)V" : "(Lnet/minecraft/entity/EntityLivingBase;Ljava/lang/String;DDDI)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitVarInsn(25, 2);
            var1.visitVarInsn(24, 3);
            var1.visitVarInsn(24, 5);
            var1.visitVarInsn(24, 7);
            var1.visitVarInsn(21, 9);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "renderLivingLabel", "" + (this.isObfuscated ? "(Lof;Ljava/lang/String;DDDI)V" : "(Lnet/minecraft/entity/EntityLivingBase;Ljava/lang/String;DDDI)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "renderModel", "" + (this.isObfuscated ? "(Lof;FFFFFF)V" : "(Lnet/minecraft/entity/EntityLivingBase;FFFFFF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitVarInsn(23, 3);
        var1.visitVarInsn(23, 4);
        var1.visitVarInsn(23, 5);
        var1.visitVarInsn(23, 6);
        var1.visitVarInsn(23, 7);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "renderModel", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lof;FFFFFF" : "Lnet/minecraft/entity/EntityLivingBase;FFFFFF") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realRenderModel", "" + (this.isObfuscated ? "(Lof;FFFFFF)V" : "(Lnet/minecraft/entity/EntityLivingBase;FFFFFF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitVarInsn(23, 3);
        var1.visitVarInsn(23, 4);
        var1.visitVarInsn(23, 5);
        var1.visitVarInsn(23, 6);
        var1.visitVarInsn(23, 7);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "a" : "renderModel", "" + (this.isObfuscated ? "(Lof;FFFFFF)V" : "(Lnet/minecraft/entity/EntityLivingBase;FFFFFF)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superRenderModel", "" + (this.isObfuscated ? "(Lof;FFFFFF)V" : "(Lnet/minecraft/entity/EntityLivingBase;FFFFFF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitVarInsn(23, 3);
        var1.visitVarInsn(23, 4);
        var1.visitVarInsn(23, 5);
        var1.visitVarInsn(23, 6);
        var1.visitVarInsn(23, 7);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "renderModel", "" + (this.isObfuscated ? "(Lof;FFFFFF)V" : "(Lnet/minecraft/entity/EntityLivingBase;FFFFFF)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalRenderModel) {
            var1 = this.cv.visitMethod(17, "localRenderModel", "" + (this.isObfuscated ? "(Lof;FFFFFF)V" : "(Lnet/minecraft/entity/EntityLivingBase;FFFFFF)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitVarInsn(23, 2);
            var1.visitVarInsn(23, 3);
            var1.visitVarInsn(23, 4);
            var1.visitVarInsn(23, 5);
            var1.visitVarInsn(23, 6);
            var1.visitVarInsn(23, 7);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "renderModel", "" + (this.isObfuscated ? "(Lof;FFFFFF)V" : "(Lnet/minecraft/entity/EntityLivingBase;FFFFFF)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "func_130009_a", "" + (this.isObfuscated ? "(Lbeu;DDDFF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDDFF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(24, 2);
        var1.visitVarInsn(24, 4);
        var1.visitVarInsn(24, 6);
        var1.visitVarInsn(23, 8);
        var1.visitVarInsn(23, 9);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "renderPlayer", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lbeu;DDDFF" : "Lnet/minecraft/client/entity/AbstractClientPlayer;DDDFF") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realRenderPlayer", "" + (this.isObfuscated ? "(Lbeu;DDDFF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDDFF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(24, 2);
        var1.visitVarInsn(24, 4);
        var1.visitVarInsn(24, 6);
        var1.visitVarInsn(23, 8);
        var1.visitVarInsn(23, 9);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "a" : "func_130009_a", "" + (this.isObfuscated ? "(Lbeu;DDDFF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDDFF)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superRenderPlayer", "" + (this.isObfuscated ? "(Lbeu;DDDFF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDDFF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(24, 2);
        var1.visitVarInsn(24, 4);
        var1.visitVarInsn(24, 6);
        var1.visitVarInsn(23, 8);
        var1.visitVarInsn(23, 9);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "func_130009_a", "" + (this.isObfuscated ? "(Lbeu;DDDFF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDDFF)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalRenderPlayer) {
            var1 = this.cv.visitMethod(17, "localRenderPlayer", "" + (this.isObfuscated ? "(Lbeu;DDDFF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDDFF)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitVarInsn(24, 2);
            var1.visitVarInsn(24, 4);
            var1.visitVarInsn(24, 6);
            var1.visitVarInsn(23, 8);
            var1.visitVarInsn(23, 9);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "func_130009_a", "" + (this.isObfuscated ? "(Lbeu;DDDFF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDDFF)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "func_96450_a", "" + (this.isObfuscated ? "(Lbeu;DDDLjava/lang/String;FD)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDDLjava/lang/String;FD)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(24, 2);
        var1.visitVarInsn(24, 4);
        var1.visitVarInsn(24, 6);
        var1.visitVarInsn(25, 8);
        var1.visitVarInsn(23, 9);
        var1.visitVarInsn(24, 10);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "renderPlayerNameAndScoreLabel", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lbeu;DDDLjava/lang/String;FD" : "Lnet/minecraft/client/entity/AbstractClientPlayer;DDDLjava/lang/String;FD") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realRenderPlayerNameAndScoreLabel", "" + (this.isObfuscated ? "(Lbeu;DDDLjava/lang/String;FD)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDDLjava/lang/String;FD)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(24, 2);
        var1.visitVarInsn(24, 4);
        var1.visitVarInsn(24, 6);
        var1.visitVarInsn(25, 8);
        var1.visitVarInsn(23, 9);
        var1.visitVarInsn(24, 10);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "a" : "func_96450_a", "" + (this.isObfuscated ? "(Lbeu;DDDLjava/lang/String;FD)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDDLjava/lang/String;FD)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superRenderPlayerNameAndScoreLabel", "" + (this.isObfuscated ? "(Lbeu;DDDLjava/lang/String;FD)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDDLjava/lang/String;FD)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(24, 2);
        var1.visitVarInsn(24, 4);
        var1.visitVarInsn(24, 6);
        var1.visitVarInsn(25, 8);
        var1.visitVarInsn(23, 9);
        var1.visitVarInsn(24, 10);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "func_96450_a", "" + (this.isObfuscated ? "(Lbeu;DDDLjava/lang/String;FD)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDDLjava/lang/String;FD)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalRenderPlayerNameAndScoreLabel) {
            var1 = this.cv.visitMethod(17, "localRenderPlayerNameAndScoreLabel", "" + (this.isObfuscated ? "(Lbeu;DDDLjava/lang/String;FD)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDDLjava/lang/String;FD)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitVarInsn(24, 2);
            var1.visitVarInsn(24, 4);
            var1.visitVarInsn(24, 6);
            var1.visitVarInsn(25, 8);
            var1.visitVarInsn(23, 9);
            var1.visitVarInsn(24, 10);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "func_96450_a", "" + (this.isObfuscated ? "(Lbeu;DDDLjava/lang/String;FD)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDDLjava/lang/String;FD)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "b" : "renderPlayerScale", "" + (this.isObfuscated ? "(Lbeu;F)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "renderPlayerScale", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lbeu;F" : "Lnet/minecraft/client/entity/AbstractClientPlayer;F") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realRenderPlayerScale", "" + (this.isObfuscated ? "(Lbeu;F)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "b" : "renderPlayerScale", "" + (this.isObfuscated ? "(Lbeu;F)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superRenderPlayerScale", "" + (this.isObfuscated ? "(Lbeu;F)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "b" : "renderPlayerScale", "" + (this.isObfuscated ? "(Lbeu;F)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalRenderPlayerScale) {
            var1 = this.cv.visitMethod(17, "localRenderPlayerScale", "" + (this.isObfuscated ? "(Lbeu;F)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitVarInsn(23, 2);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "b" : "renderPlayerScale", "" + (this.isObfuscated ? "(Lbeu;F)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "renderPlayerSleep", "" + (this.isObfuscated ? "(Lbeu;DDD)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDD)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(24, 2);
        var1.visitVarInsn(24, 4);
        var1.visitVarInsn(24, 6);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "renderPlayerSleep", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lbeu;DDD" : "Lnet/minecraft/client/entity/AbstractClientPlayer;DDD") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realRenderPlayerSleep", "" + (this.isObfuscated ? "(Lbeu;DDD)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDD)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(24, 2);
        var1.visitVarInsn(24, 4);
        var1.visitVarInsn(24, 6);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "a" : "renderPlayerSleep", "" + (this.isObfuscated ? "(Lbeu;DDD)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDD)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superRenderPlayerSleep", "" + (this.isObfuscated ? "(Lbeu;DDD)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDD)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(24, 2);
        var1.visitVarInsn(24, 4);
        var1.visitVarInsn(24, 6);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "renderPlayerSleep", "" + (this.isObfuscated ? "(Lbeu;DDD)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDD)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalRenderPlayerSleep) {
            var1 = this.cv.visitMethod(17, "localRenderPlayerSleep", "" + (this.isObfuscated ? "(Lbeu;DDD)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDD)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitVarInsn(24, 2);
            var1.visitVarInsn(24, 4);
            var1.visitVarInsn(24, 6);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "renderPlayerSleep", "" + (this.isObfuscated ? "(Lbeu;DDD)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDD)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "renderSpecials", "" + (this.isObfuscated ? "(Lbeu;F)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "renderSpecials", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lbeu;F" : "Lnet/minecraft/client/entity/AbstractClientPlayer;F") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realRenderSpecials", "" + (this.isObfuscated ? "(Lbeu;F)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "a" : "renderSpecials", "" + (this.isObfuscated ? "(Lbeu;F)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superRenderSpecials", "" + (this.isObfuscated ? "(Lbeu;F)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "renderSpecials", "" + (this.isObfuscated ? "(Lbeu;F)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalRenderSpecials) {
            var1 = this.cv.visitMethod(17, "localRenderSpecials", "" + (this.isObfuscated ? "(Lbeu;F)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitVarInsn(23, 2);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "renderSpecials", "" + (this.isObfuscated ? "(Lbeu;F)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;F)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "d" : "renderSwingProgress", "" + (this.isObfuscated ? "(Lof;F)F" : "(Lnet/minecraft/entity/EntityLivingBase;F)F") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "renderSwingProgress", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lof;F" : "Lnet/minecraft/entity/EntityLivingBase;F") + ")F");
        var1.visitInsn(174);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realRenderSwingProgress", "" + (this.isObfuscated ? "(Lof;F)F" : "(Lnet/minecraft/entity/EntityLivingBase;F)F") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "d" : "renderSwingProgress", "" + (this.isObfuscated ? "(Lof;F)F" : "(Lnet/minecraft/entity/EntityLivingBase;F)F") + "");
        var1.visitInsn(174);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superRenderSwingProgress", "" + (this.isObfuscated ? "(Lof;F)F" : "(Lnet/minecraft/entity/EntityLivingBase;F)F") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "d" : "renderSwingProgress", "" + (this.isObfuscated ? "(Lof;F)F" : "(Lnet/minecraft/entity/EntityLivingBase;F)F") + "");
        var1.visitInsn(174);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalRenderSwingProgress) {
            var1 = this.cv.visitMethod(17, "localRenderSwingProgress", "" + (this.isObfuscated ? "(Lof;F)F" : "(Lnet/minecraft/entity/EntityLivingBase;F)F") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitVarInsn(23, 2);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "d" : "renderSwingProgress", "" + (this.isObfuscated ? "(Lof;F)F" : "(Lnet/minecraft/entity/EntityLivingBase;F)F") + "");
            var1.visitInsn(174);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "rotatePlayer", "" + (this.isObfuscated ? "(Lbeu;FFF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;FFF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitVarInsn(23, 3);
        var1.visitVarInsn(23, 4);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "rotatePlayer", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lbeu;FFF" : "Lnet/minecraft/client/entity/AbstractClientPlayer;FFF") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realRotatePlayer", "" + (this.isObfuscated ? "(Lbeu;FFF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;FFF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitVarInsn(23, 3);
        var1.visitVarInsn(23, 4);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "a" : "rotatePlayer", "" + (this.isObfuscated ? "(Lbeu;FFF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;FFF)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superRotatePlayer", "" + (this.isObfuscated ? "(Lbeu;FFF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;FFF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(23, 2);
        var1.visitVarInsn(23, 3);
        var1.visitVarInsn(23, 4);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "rotatePlayer", "" + (this.isObfuscated ? "(Lbeu;FFF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;FFF)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalRotatePlayer) {
            var1 = this.cv.visitMethod(17, "localRotatePlayer", "" + (this.isObfuscated ? "(Lbeu;FFF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;FFF)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitVarInsn(23, 2);
            var1.visitVarInsn(23, 3);
            var1.visitVarInsn(23, 4);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "rotatePlayer", "" + (this.isObfuscated ? "(Lbeu;FFF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;FFF)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "setArmorModel", "" + (this.isObfuscated ? "(Lbeu;IF)I" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;IF)I") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(21, 2);
        var1.visitVarInsn(23, 3);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "setArmorModel", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lbeu;IF" : "Lnet/minecraft/client/entity/AbstractClientPlayer;IF") + ")I");
        var1.visitInsn(172);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realSetArmorModel", "" + (this.isObfuscated ? "(Lbeu;IF)I" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;IF)I") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(21, 2);
        var1.visitVarInsn(23, 3);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "a" : "setArmorModel", "" + (this.isObfuscated ? "(Lbeu;IF)I" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;IF)I") + "");
        var1.visitInsn(172);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superSetArmorModel", "" + (this.isObfuscated ? "(Lbeu;IF)I" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;IF)I") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(21, 2);
        var1.visitVarInsn(23, 3);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "setArmorModel", "" + (this.isObfuscated ? "(Lbeu;IF)I" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;IF)I") + "");
        var1.visitInsn(172);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalSetArmorModel) {
            var1 = this.cv.visitMethod(17, "localSetArmorModel", "" + (this.isObfuscated ? "(Lbeu;IF)I" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;IF)I") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitVarInsn(21, 2);
            var1.visitVarInsn(23, 3);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "setArmorModel", "" + (this.isObfuscated ? "(Lbeu;IF)I" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;IF)I") + "");
            var1.visitInsn(172);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "b" : "func_130220_b", "" + (this.isObfuscated ? "(Lbeu;IF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;IF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(21, 2);
        var1.visitVarInsn(23, 3);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "setPassArmorModel", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lbeu;IF" : "Lnet/minecraft/client/entity/AbstractClientPlayer;IF") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realSetPassArmorModel", "" + (this.isObfuscated ? "(Lbeu;IF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;IF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(21, 2);
        var1.visitVarInsn(23, 3);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "b" : "func_130220_b", "" + (this.isObfuscated ? "(Lbeu;IF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;IF)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superSetPassArmorModel", "" + (this.isObfuscated ? "(Lbeu;IF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;IF)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(21, 2);
        var1.visitVarInsn(23, 3);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "b" : "func_130220_b", "" + (this.isObfuscated ? "(Lbeu;IF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;IF)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalSetPassArmorModel) {
            var1 = this.cv.visitMethod(17, "localSetPassArmorModel", "" + (this.isObfuscated ? "(Lbeu;IF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;IF)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitVarInsn(21, 2);
            var1.visitVarInsn(23, 3);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "b" : "func_130220_b", "" + (this.isObfuscated ? "(Lbeu;IF)V" : "(Lnet/minecraft/client/entity/AbstractClientPlayer;IF)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "setRenderManager", "" + (this.isObfuscated ? "(Lbgl;)V" : "(Lnet/minecraft/client/renderer/entity/RenderManager;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "setRenderManager", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lbgl;" : "Lnet/minecraft/client/renderer/entity/RenderManager;") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realSetRenderManager", "" + (this.isObfuscated ? "(Lbgl;)V" : "(Lnet/minecraft/client/renderer/entity/RenderManager;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "a" : "setRenderManager", "" + (this.isObfuscated ? "(Lbgl;)V" : "(Lnet/minecraft/client/renderer/entity/RenderManager;)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superSetRenderManager", "" + (this.isObfuscated ? "(Lbgl;)V" : "(Lnet/minecraft/client/renderer/entity/RenderManager;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "setRenderManager", "" + (this.isObfuscated ? "(Lbgl;)V" : "(Lnet/minecraft/client/renderer/entity/RenderManager;)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalSetRenderManager) {
            var1 = this.cv.visitMethod(17, "localSetRenderManager", "" + (this.isObfuscated ? "(Lbgl;)V" : "(Lnet/minecraft/client/renderer/entity/RenderManager;)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "setRenderManager", "" + (this.isObfuscated ? "(Lbgl;)V" : "(Lnet/minecraft/client/renderer/entity/RenderManager;)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "setRenderPassModel", "" + (this.isObfuscated ? "(Lbbo;)V" : "(Lnet/minecraft/client/model/ModelBase;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "setRenderPassModel", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lbbo;" : "Lnet/minecraft/client/model/ModelBase;") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realSetRenderPassModel", "" + (this.isObfuscated ? "(Lbbo;)V" : "(Lnet/minecraft/client/model/ModelBase;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "a" : "setRenderPassModel", "" + (this.isObfuscated ? "(Lbbo;)V" : "(Lnet/minecraft/client/model/ModelBase;)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superSetRenderPassModel", "" + (this.isObfuscated ? "(Lbbo;)V" : "(Lnet/minecraft/client/model/ModelBase;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "setRenderPassModel", "" + (this.isObfuscated ? "(Lbbo;)V" : "(Lnet/minecraft/client/model/ModelBase;)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalSetRenderPassModel) {
            var1 = this.cv.visitMethod(17, "localSetRenderPassModel", "" + (this.isObfuscated ? "(Lbbo;)V" : "(Lnet/minecraft/client/model/ModelBase;)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "setRenderPassModel", "" + (this.isObfuscated ? "(Lbbo;)V" : "(Lnet/minecraft/client/model/ModelBase;)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(1, this.isObfuscated ? "a" : "updateIcons", "" + (this.isObfuscated ? "(Lmt;)V" : "(Lnet/minecraft/client/renderer/texture/IconRegister;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "updateIcons", "(Lapi/player/render/IRenderPlayerAPI;" + (this.isObfuscated ? "Lmt;" : "Lnet/minecraft/client/renderer/texture/IconRegister;") + ")V");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "realUpdateIcons", "" + (this.isObfuscated ? "(Lmt;)V" : "(Lnet/minecraft/client/renderer/texture/IconRegister;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(182, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "a" : "updateIcons", "" + (this.isObfuscated ? "(Lmt;)V" : "(Lnet/minecraft/client/renderer/texture/IconRegister;)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "superUpdateIcons", "" + (this.isObfuscated ? "(Lmt;)V" : "(Lnet/minecraft/client/renderer/texture/IconRegister;)V") + "", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "updateIcons", "" + (this.isObfuscated ? "(Lmt;)V" : "(Lnet/minecraft/client/renderer/texture/IconRegister;)V") + "");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        if (!this.hadLocalUpdateIcons) {
            var1 = this.cv.visitMethod(17, "localUpdateIcons", "" + (this.isObfuscated ? "(Lmt;)V" : "(Lnet/minecraft/client/renderer/texture/IconRegister;)V") + "", (String)null, (String[])null);
            var1.visitVarInsn(25, 0);
            var1.visitVarInsn(25, 1);
            var1.visitMethodInsn(183, this.isObfuscated ? "bhb" : "net/minecraft/client/renderer/entity/RendererLivingEntity", this.isObfuscated ? "a" : "updateIcons", "" + (this.isObfuscated ? "(Lmt;)V" : "(Lnet/minecraft/client/renderer/texture/IconRegister;)V") + "");
            var1.visitInsn(177);
            var1.visitMaxs(0, 0);
            var1.visitEnd();
        }
        var1 = this.cv.visitMethod(17, "getMainModelField", this.isObfuscated ? "()Lbbo;" : "()Lnet/minecraft/client/model/ModelBase;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "i" : "mainModel", this.isObfuscated ? "Lbbo;" : "Lnet/minecraft/client/model/ModelBase;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setMainModelField", this.isObfuscated ? "(Lbbo;)V" : "(Lnet/minecraft/client/model/ModelBase;)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitFieldInsn(181, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "i" : "mainModel", this.isObfuscated ? "Lbbo;" : "Lnet/minecraft/client/model/ModelBase;");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getModelArmorField", this.isObfuscated ? "()Lbbj;" : "()Lnet/minecraft/client/model/ModelBiped;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "h" : "modelArmor", this.isObfuscated ? "Lbbj;" : "Lnet/minecraft/client/model/ModelBiped;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setModelArmorField", this.isObfuscated ? "(Lbbj;)V" : "(Lnet/minecraft/client/model/ModelBiped;)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitFieldInsn(181, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "h" : "modelArmor", this.isObfuscated ? "Lbbj;" : "Lnet/minecraft/client/model/ModelBiped;");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getModelArmorChestplateField", this.isObfuscated ? "()Lbbj;" : "()Lnet/minecraft/client/model/ModelBiped;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "g" : "modelArmorChestplate", this.isObfuscated ? "Lbbj;" : "Lnet/minecraft/client/model/ModelBiped;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setModelArmorChestplateField", this.isObfuscated ? "(Lbbj;)V" : "(Lnet/minecraft/client/model/ModelBiped;)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitFieldInsn(181, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "g" : "modelArmorChestplate", this.isObfuscated ? "Lbbj;" : "Lnet/minecraft/client/model/ModelBiped;");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getModelBipedMainField", this.isObfuscated ? "()Lbbj;" : "()Lnet/minecraft/client/model/ModelBiped;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "f" : "modelBipedMain", this.isObfuscated ? "Lbbj;" : "Lnet/minecraft/client/model/ModelBiped;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setModelBipedMainField", this.isObfuscated ? "(Lbbj;)V" : "(Lnet/minecraft/client/model/ModelBiped;)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitFieldInsn(181, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "f" : "modelBipedMain", this.isObfuscated ? "Lbbj;" : "Lnet/minecraft/client/model/ModelBiped;");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getRenderBlocksField", this.isObfuscated ? "()Lbfr;" : "()Lnet/minecraft/client/renderer/RenderBlocks;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "c" : "renderBlocks", this.isObfuscated ? "Lbfr;" : "Lnet/minecraft/client/renderer/RenderBlocks;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setRenderBlocksField", this.isObfuscated ? "(Lbfr;)V" : "(Lnet/minecraft/client/renderer/RenderBlocks;)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitFieldInsn(181, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "c" : "renderBlocks", this.isObfuscated ? "Lbfr;" : "Lnet/minecraft/client/renderer/RenderBlocks;");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getRenderManagerField", this.isObfuscated ? "()Lbgl;" : "()Lnet/minecraft/client/renderer/entity/RenderManager;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "b" : "renderManager", this.isObfuscated ? "Lbgl;" : "Lnet/minecraft/client/renderer/entity/RenderManager;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setRenderManagerField", this.isObfuscated ? "(Lbgl;)V" : "(Lnet/minecraft/client/renderer/entity/RenderManager;)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitFieldInsn(181, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "b" : "renderManager", this.isObfuscated ? "Lbgl;" : "Lnet/minecraft/client/renderer/entity/RenderManager;");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getRenderPassModelField", this.isObfuscated ? "()Lbbo;" : "()Lnet/minecraft/client/model/ModelBase;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "j" : "renderPassModel", this.isObfuscated ? "Lbbo;" : "Lnet/minecraft/client/model/ModelBase;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setRenderPassModelField", this.isObfuscated ? "(Lbbo;)V" : "(Lnet/minecraft/client/model/ModelBase;)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitFieldInsn(181, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "j" : "renderPassModel", this.isObfuscated ? "Lbbo;" : "Lnet/minecraft/client/model/ModelBase;");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getShadowOpaqueField", "()F", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "e" : "shadowOpaque", "F");
        var1.visitInsn(174);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setShadowOpaqueField", "(F)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(23, 1);
        var1.visitFieldInsn(181, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "e" : "shadowOpaque", "F");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getShadowSizeField", "()F", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "d" : "shadowSize", "F");
        var1.visitInsn(174);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "setShadowSizeField", "(F)V", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(23, 1);
        var1.visitFieldInsn(181, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", this.isObfuscated ? "d" : "shadowSize", "F");
        var1.visitInsn(177);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getRenderPlayerBase", "(Ljava/lang/String;)Lapi/player/render/RenderPlayerBase;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "getRenderPlayerBase", "(Lapi/player/render/IRenderPlayerAPI;Ljava/lang/String;)Lapi/player/render/RenderPlayerBase;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getRenderPlayerBaseIds", "()Ljava/util/Set;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "getRenderPlayerBaseIds", "(Lapi/player/render/IRenderPlayerAPI;)Ljava/util/Set;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "dynamic", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitVarInsn(25, 1);
        var1.visitVarInsn(25, 2);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "dynamic", "(Lapi/player/render/IRenderPlayerAPI;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getRenderPlayerAPI", "()Lapi/player/render/RenderPlayerAPI;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitFieldInsn(180, this.isObfuscated ? "bhj" : "net/minecraft/client/renderer/entity/RenderPlayer", "renderPlayerAPI", "Lapi/player/render/RenderPlayerAPI;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(17, "getRenderPlayer", this.isObfuscated ? "()Lbhj;" : "()Lnet/minecraft/client/renderer/entity/RenderPlayer;", (String)null, (String[])null);
        var1.visitVarInsn(25, 0);
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        var1 = this.cv.visitMethod(9, "getAllInstances", this.isObfuscated ? "()[Lbhj;" : "()[Lnet/minecraft/client/renderer/entity/RenderPlayer;", (String)null, (String[])null);
        var1.visitMethodInsn(184, "api/player/render/RenderPlayerAPI", "getAllInstances", this.isObfuscated ? "()[Lbhj;" : "()[Lnet/minecraft/client/renderer/entity/RenderPlayer;");
        var1.visitInsn(176);
        var1.visitMaxs(0, 0);
        var1.visitEnd();
        this.cv.visitField(18, "renderPlayerAPI", "Lapi/player/render/RenderPlayerAPI;", (String)null, null);
    }
}

