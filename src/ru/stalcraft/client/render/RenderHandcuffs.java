/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bdi
 *  beu
 *  bjo
 *  bma
 *  cpw.mods.fml.relauncher.ReflectionHelper
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraftforge.client.model.AdvancedModelLoader
 *  net.minecraftforge.client.model.IModelCustom
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.util.glu.Project
 */
package ru.stalcraft.client.render;

import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;
import ru.stalcraft.client.models.ModelHand;
import ru.stalcraft.player.PlayerUtils;

public class RenderHandcuffs {
    private static float[] translation = new float[]{-0.457f, -0.454f, -1.241f};
    private static float[] rotation = new float[]{45.0f, 0.0f, 0.0f};
    private static float[] temp = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    private static IModelCustom modelHandcuffs = AdvancedModelLoader.loadModel((String)"/assets/stalker/models/handcuffs.obj");
    private static ModelHand modelHand = new ModelHand();
    private static bjo texture = new bjo("stalker", "models/handcuffs.png");
    private static atv mc = atv.w();

    @SideOnly(value=Side.CLIENT)
    public static boolean renderHandcuffs(bfe renderer, float frame, int anaglyph) {
        if (atv.w().h.aN() <= 0.0f) {
            return true;
        }
        if (PlayerUtils.getInfo((uf)atv.w().h).getHandcuffs() && renderer.n <= 0 && !RenderHandcuffs.mc.i.aj() && RenderHandcuffs.mc.u.aa == 0) {
            RenderHandcuffs.setupTranslations(renderer, frame, anaglyph);
            if (!(RenderHandcuffs.mc.u.aa != 0 || RenderHandcuffs.mc.i.bh() || RenderHandcuffs.mc.u.Z || RenderHandcuffs.mc.c.a())) {
                RenderHandcuffs.doRenderHandcuffs(frame, renderer.c);
            }
            RenderHandcuffs.reloadOldTranslations(renderer, frame, anaglyph);
            return true;
        }
        return false;
    }

    private static void doRenderHandcuffs(float frame, bfj renderer) {
        float equippedProgress = ((Float)ReflectionHelper.getPrivateValue(bfj.class, (Object)renderer, (String[])new String[]{"equippedProgress", "field_78454_c", "g"})).floatValue();
        float prevEquippedProgress = ((Float)ReflectionHelper.getPrivateValue(bfj.class, (Object)renderer, (String[])new String[]{"prevEquippedProgress", "field_78451_d", "h"})).floatValue();
        ye itemToRender = (ye)ReflectionHelper.getPrivateValue(bfj.class, (Object)renderer, (String[])new String[]{"itemToRender", "field_78453_b", "f"});
        float var10000 = prevEquippedProgress + (equippedProgress - prevEquippedProgress) * frame;
        bdi entityclientplayermp = atv.w().h;
        float f2 = entityclientplayermp.D + (entityclientplayermp.B - entityclientplayermp.D) * frame;
        GL11.glPushMatrix();
        GL11.glRotatef((float)f2, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glRotatef((float)(entityclientplayermp.C + (entityclientplayermp.A - entityclientplayermp.C) * frame), (float)0.0f, (float)1.0f, (float)0.0f);
        att.b();
        GL11.glPopMatrix();
        float f3 = entityclientplayermp.j + (entityclientplayermp.h - entityclientplayermp.j) * frame;
        float f4 = entityclientplayermp.i + (entityclientplayermp.g - entityclientplayermp.i) * frame;
        GL11.glRotatef((float)((entityclientplayermp.B - f3) * 0.05f), (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glRotatef((float)((entityclientplayermp.A - f4) * 0.05f), (float)0.0f, (float)1.0f, (float)0.0f);
        ye itemstack = itemToRender;
        float f5 = atv.w().f.q(ls.c(entityclientplayermp.u), ls.c(entityclientplayermp.v), ls.c(entityclientplayermp.w));
        f5 = 1.0f;
        int i2 = atv.w().f.h(ls.c(entityclientplayermp.u), ls.c(entityclientplayermp.v), ls.c(entityclientplayermp.w), 0);
        int j2 = i2 % 65536;
        int k2 = i2 / 65536;
        bma.a((int)bma.b, (float)((float)j2 / 1.0f), (float)((float)k2 / 1.0f));
        GL11.glColor4f((float)f5, (float)f5, (float)f5, (float)1.0f);
        bhj renderplayer = (bhj)bgl.a.a((nn)RenderHandcuffs.mc.h);
        GL11.glEnable((int)32826);
        GL11.glScalef((float)1.0f, (float)1.0f, (float)1.0f);
        mc.J().a(entityclientplayermp.r());
        GL11.glPushMatrix();
        GL11.glTranslatef((float)0.18f, (float)-0.785f, (float)-0.87f);
        GL11.glRotatef((float)-45.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        modelHand.render((beu)entityclientplayermp, 2);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)-0.43f, (float)-0.785f, (float)-0.87f);
        GL11.glRotatef((float)-45.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        modelHand.render((beu)entityclientplayermp, 1);
        GL11.glPopMatrix();
        mc.J().a(texture);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)translation[0], (float)translation[1], (float)translation[2]);
        GL11.glRotatef((float)rotation[0], (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glRotatef((float)rotation[1], (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)rotation[2], (float)0.0f, (float)0.0f, (float)1.0f);
        GL11.glScalef((float)0.017f, (float)0.017f, (float)0.017f);
        modelHandcuffs.renderAll();
        GL11.glPopMatrix();
        GL11.glDisable((int)32826);
        att.a();
    }

    private static void setupTranslations(bfe renderer, float frame, float anaglyph) {
        GL11.glMatrixMode((int)5889);
        GL11.glLoadIdentity();
        float f1 = 0.07f;
        if (RenderHandcuffs.mc.u.g) {
            GL11.glTranslatef((float)(-(anaglyph * 2.0f - 1.0f) * f1), (float)0.0f, (float)0.0f);
        }
        double cameraZoom = (Double)ReflectionHelper.getPrivateValue(bfe.class, (Object)renderer, (String[])new String[]{"cameraZoom", "field_78503_V", "Y"});
        double cameraYaw = (Double)ReflectionHelper.getPrivateValue(bfe.class, (Object)renderer, (String[])new String[]{"cameraYaw", "field_78502_W", "Z"});
        double cameraPitch = (Double)ReflectionHelper.getPrivateValue(bfe.class, (Object)renderer, (String[])new String[]{"cameraPitch", "field_78509_X", "aa"});
        if (cameraZoom != 1.0) {
            GL11.glTranslatef((float)((float)cameraYaw), (float)((float)(-cameraPitch)), (float)0.0f);
            GL11.glScaled((double)cameraZoom, (double)cameraZoom, (double)1.0);
        }
        float farPlaneDistance = ((Float)ReflectionHelper.getPrivateValue(bfe.class, (Object)renderer, (String[])new String[]{"farPlaneDistance", "field_78530_s", "r"})).floatValue();
        float getFOVModifier = 0.0f;
        try {
            getFOVModifier = ((Float)ReflectionHelper.findMethod(bfe.class, (Object)renderer, (String[])new String[]{"getFOVModifier", "func_78481_a", "a"}, (Class[])new Class[]{Float.class, Boolean.class}).invoke(renderer, Float.valueOf(frame), false)).floatValue();
        }
        catch (Exception exception) {
            // empty catch block
        }
        Project.gluPerspective((float)getFOVModifier, (float)((float)RenderHandcuffs.mc.d / (float)RenderHandcuffs.mc.e), (float)0.05f, (float)(farPlaneDistance * 2.0f));
        if (RenderHandcuffs.mc.c.a()) {
            float f2 = 0.6666667f;
            GL11.glScalef((float)1.0f, (float)f2, (float)1.0f);
        }
        GL11.glMatrixMode((int)5888);
        GL11.glLoadIdentity();
        if (RenderHandcuffs.mc.u.g) {
            GL11.glTranslatef((float)((anaglyph * 2.0f - 1.0f) * 0.1f), (float)0.0f, (float)0.0f);
        }
        GL11.glPushMatrix();
        try {
            ReflectionHelper.findMethod(bfe.class, (Object)renderer, (String[])new String[]{"hurtCameraEffect", "func_78482_e", "e"}, (Class[])new Class[]{Float.class}).invoke(renderer, Float.valueOf(frame));
        }
        catch (Exception e1) {
            e1.printStackTrace();
        }
        if (RenderHandcuffs.mc.u.f) {
            try {
                ReflectionHelper.findMethod(bfe.class, (Object)renderer, (String[])new String[]{"setupViewBobbing", "func_78475_f", "f"}, (Class[])new Class[]{Float.class}).invoke(renderer, Float.valueOf(frame));
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        renderer.b((double)frame);
    }

    private static void reloadOldTranslations(bfe renderer, float frame, float anaglyph) {
        GL11.glPopMatrix();
        if (RenderHandcuffs.mc.u.aa == 0 && !RenderHandcuffs.mc.i.bh()) {
            renderer.c.b(frame);
            try {
                ReflectionHelper.findMethod(bfe.class, (Object)renderer, (String[])new String[]{"hurtCameraEffect", "func_78482_e", "e"}, (Class[])new Class[]{Float.class}).invoke(renderer, Float.valueOf(frame));
            }
            catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        if (RenderHandcuffs.mc.u.f) {
            try {
                ReflectionHelper.findMethod(bfe.class, (Object)renderer, (String[])new String[]{"setupViewBobbing", "func_78475_f", "f"}, (Class[])new Class[]{Float.class}).invoke(renderer, Float.valueOf(frame));
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        renderer.a((double)frame);
    }

    public static void renderHandcuffsThirdPerson(bbj model) {
        if (Keyboard.isKeyDown((int)72)) {
            temp = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        if (Keyboard.isKeyDown((int)78)) {
            if (Keyboard.isKeyDown((int)79)) {
                temp[0] = temp[0] + 0.001f;
            }
            if (Keyboard.isKeyDown((int)80)) {
                temp[1] = temp[1] + 0.001f;
            }
            if (Keyboard.isKeyDown((int)81)) {
                temp[2] = temp[2] + 0.001f;
            }
            if (Keyboard.isKeyDown((int)75)) {
                temp[3] = temp[3] + 0.04f;
            }
            if (Keyboard.isKeyDown((int)76)) {
                temp[4] = temp[4] + 0.04f;
            }
            if (Keyboard.isKeyDown((int)77)) {
                temp[5] = temp[5] + 0.04f;
            }
        } else if (Keyboard.isKeyDown((int)12)) {
            if (Keyboard.isKeyDown((int)79)) {
                temp[0] = temp[0] - 0.001f;
            }
            if (Keyboard.isKeyDown((int)80)) {
                temp[1] = temp[1] - 0.001f;
            }
            if (Keyboard.isKeyDown((int)81)) {
                temp[2] = temp[2] - 0.001f;
            }
            if (Keyboard.isKeyDown((int)75)) {
                temp[3] = temp[3] - 0.04f;
            }
            if (Keyboard.isKeyDown((int)76)) {
                temp[4] = temp[4] - 0.04f;
            }
            if (Keyboard.isKeyDown((int)77)) {
                temp[5] = temp[5] - 0.04f;
            }
        }
        GL11.glPushMatrix();
        mc.J().a(texture);
        GL11.glPushMatrix();
        model.g.c(0.0625f);
        GL11.glTranslatef((float)-0.698f, (float)0.501f, (float)0.15f);
        GL11.glRotatef((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glScalef((float)0.017f, (float)0.017f, (float)0.017f);
        modelHandcuffs.renderPart("Mesh4");
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        model.f.c(0.0625f);
        GL11.glTranslatef((float)-0.212f, (float)0.501f, (float)0.15f);
        GL11.glRotatef((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glScalef((float)0.017f, (float)0.017f, (float)0.017f);
        modelHandcuffs.renderPart("Mesh5");
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        model.f.c(0.0625f);
        GL11.glTranslatef((float)-0.249f, (float)0.415f, (float)0.226f);
        GL11.glRotatef((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glRotatef((float)-10.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)9.24f, (float)0.0f, (float)0.0f, (float)1.0f);
        GL11.glScalef((float)0.02f, (float)0.02f, (float)0.02f);
        modelHandcuffs.renderOnly(new String[]{"Mesh1", "Mesh2", "Mesh3"});
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}

