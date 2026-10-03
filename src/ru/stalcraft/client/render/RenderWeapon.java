/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aur
 *  bdi
 *  beu
 *  bjo
 *  bma
 *  cpw.mods.fml.relauncher.ReflectionHelper
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraftforge.client.IItemRenderer
 *  net.minecraftforge.client.IItemRenderer$ItemRenderType
 *  net.minecraftforge.client.IItemRenderer$ItemRendererHelper
 *  net.minecraftforge.client.model.IModelCustom
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client.render;

import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import ru.stalcraft.Logger;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.client.ClientProxy;
import ru.stalcraft.client.ClientWeaponInfo;
import ru.stalcraft.client.gui.GuiSettingsStalker;
import ru.stalcraft.client.loaders.StalkerModelManager;
import ru.stalcraft.client.models.ModelHand;
import ru.stalcraft.items.ItemWeapon;
import ru.stalcraft.player.PlayerUtils;

@SideOnly(value=Side.CLIENT)
public class RenderWeapon
implements IItemRenderer {
    protected static float x;
    protected static float y;
    protected static float z;
    protected static float x1;
    protected static float y1;
    protected static float z1;
    protected static float zoom;
    private static atv mc;
    private String modelName;
    private bjo texture;
    protected ModelHand hand = new ModelHand();
    private bjo blank = new bjo("stalker", "textures/blank.png");
    private bjo shotLight = new bjo("stalker", "textures/particles/weapon/shotlight.png");
    private bjo shotLight1 = new bjo("stalker", "textures/particles/weapon/shotlight1.png");
    private bjo aimTexture = null;
    private bjo aimTextureSight = null;
    private static float[] fpTransform;
    private static float[] playerTransform;
    private static float[] oldLivingTransform;
    private static float[] newLivingTransform;
    private float aimPosY;
    private float aimPosZ;
    private float aimRotX;
    private float posX;
    private float posY;
    private float posZ;
    private static boolean written;
    public ItemWeapon weapon;
    private float handLeftX;
    private float handLeftY;
    private float handLeftZ;
    private float handRightX;
    private float handRightY;
    private float handRightZ;
    private float handRotLeftX;
    private float handRotLeftY;
    private float handRotLeftZ;
    private float handRotRightX;
    private float handRotRightY;
    private float handRotRightZ;
    public static float transformRotHandX;
    public static float transformRotHandY;
    public static float transformRotHandZ;
    public static float clear;
    public float posRotAngle;
    public float posAimRotAngle;
    public float posTranX;
    public float posTranY;
    public float posTranZ;
    public float aim;
    private int timershot;

    public RenderWeapon(ItemWeapon weapon) {
        this.weapon = weapon;
        this.modelName = weapon.modelName;
        this.texture = new bjo("stalker", "models/weapons/" + weapon.modelTexture + ".png");
        this.aimPosY = weapon.aimPosY;
        this.aimPosZ = weapon.aimPosZ;
        this.aimRotX = weapon.aimRotX;
        this.posX = weapon.posX;
        this.posY = weapon.posY;
        this.posZ = weapon.posZ;
        if (weapon.aimingTexture != null && !weapon.aimingTexture.isEmpty()) {
            this.aimTexture = new bjo("stalker", "textures/" + weapon.aimingTexture + ".png");
        }
        if (weapon.aimingTextureSight != null && !weapon.aimingTextureSight.isEmpty()) {
            this.aimTextureSight = new bjo("stalker", "textures/" + weapon.aimingTextureSight + ".png");
        }
    }

    public boolean handleRenderType(ye item, IItemRenderer.ItemRenderType type) {
        return !(type == IItemRenderer.ItemRenderType.INVENTORY || type == IItemRenderer.ItemRenderType.EQUIPPED && !GuiSettingsStalker.useWeaponModels || type == IItemRenderer.ItemRenderType.ENTITY && !GuiSettingsStalker.useWeaponModels);
    }

    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ye item, IItemRenderer.ItemRendererHelper helper) {
        return type != IItemRenderer.ItemRenderType.ENTITY;
    }

    private void renderModel(ye stack) {
        StalkerModelManager m2 = ClientProxy.modelManager;
        m2.tryLoadTexture(this.texture);
        IModelCustom model = m2.getModel("weapons", this.modelName);
        if (model != null && m2.tryBindTexture(this.texture)) {
            model.renderAllExcept(new String[]{"flashlight", "sight", "silencer "});
            by tag = PlayerUtils.getTag(stack);
            if (tag.n("flashlight")) {
                model.renderPart("flashlight");
            }
            if (tag.n("silencer")) {
                model.renderPart("silencer");
            }
            if (tag.n("sight")) {
                model.renderPart("sight");
            }
        }
    }

    public void renderItem(IItemRenderer.ItemRenderType type, ye item, Object ... data) {
        ClientWeaponInfo e2 = (ClientWeaponInfo)PlayerUtils.getInfo((uf)RenderWeapon.mc.h).weaponInfo;
        GL11.glPushMatrix();
        try {
            if (type == IItemRenderer.ItemRenderType.ENTITY) {
                GL11.glPushMatrix();
                GL11.glDisable((int)2896);
                GL11.glTranslatef((float)0.0f, (float)-0.175f, (float)0.0f);
                GL11.glRotatef((float)90.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
                this.renderModel(item);
                GL11.glPopMatrix();
            } else if (type == IItemRenderer.ItemRenderType.EQUIPPED) {
                GL11.glPushMatrix();
                GL11.glDisable((int)2896);
                if (data[1] instanceof uf) {
                    GL11.glTranslatef((float)0.67f, (float)0.8f, (float)0.7f);
                    GL11.glRotatef((float)playerTransform[3], (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glRotatef((float)playerTransform[4], (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)playerTransform[5], (float)0.0f, (float)0.0f, (float)1.0f);
                    GL11.glScalef((float)4.0f, (float)4.0f, (float)4.0f);
                } else {
                    GL11.glTranslatef((float)newLivingTransform[0], (float)newLivingTransform[1], (float)newLivingTransform[2]);
                    GL11.glRotatef((float)newLivingTransform[3], (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glRotatef((float)newLivingTransform[4], (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)newLivingTransform[5], (float)0.0f, (float)0.0f, (float)1.0f);
                    GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
                }
                if (!this.weapon.isPistol) {
                    GL11.glTranslatef((float)0.0f, (float)-0.01f, (float)0.08f);
                } else if (this.weapon.isPistol) {
                    GL11.glTranslatef((float)0.0f, (float)-0.01f, (float)0.08f);
                }
                this.renderModel(item);
                GL11.glPopMatrix();
            } else if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
                GL11.glDisable((int)2896);
                boolean isSprinting = StalkerMain.instance.smHelper.isPlayerRunning((uf)RenderWeapon.mc.h);
                float frame = RenderWeapon.mc.S.c;
                if (e2.isAiming() && RenderWeapon.mc.h.bn.h() != null && !e2.isReloading(RenderWeapon.mc.h.bn.h()) && !isSprinting) {
                    bjo aimTexture = PlayerUtils.getTag(item).n("sight") ? this.aimTextureSight : this.aimTexture;
                    GL11.glPushMatrix();
                    GL11.glTranslatef((float)0.5f, (float)0.5f, (float)0.5f);
                    GL11.glRotatef((float)-45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    if (aimTexture == null) {
                        this.setupTranslation(e2);
                    }
                    boolean sight = PlayerUtils.getTag(item).n("sight");
                    GL11.glTranslatef((float)-1.4f, (float)((aimTexture == null ? 0.9f : 1.3f) + (sight && aimTexture != null ? 0.0f : this.aimPosY)), (float)(0.7f + (sight && aimTexture != null ? 0.0f : this.aimPosZ)));
                    GL11.glRotatef((float)(sight && aimTexture != null ? 0.0f : this.aimRotX), (float)1.0f, (float)0.0f, (float)0.0f);
                    if (aimTexture == null) {
                        this.setupRotation(e2);
                        GL11.glPushMatrix();
                        GL11.glTranslatef((float)-0.1f, (float)-0.4f, (float)0.4f);
                        GL11.glRotatef((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                        GL11.glRotatef((float)0.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                        GL11.glRotatef((float)0.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                        this.hand.render((beu)RenderWeapon.mc.h, 1);
                        GL11.glPopMatrix();
                        if (!this.weapon.isPistol) {
                            GL11.glPushMatrix();
                            GL11.glTranslatef((float)-0.825f, (float)-0.4f, (float)0.1f);
                            GL11.glRotatef((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                            GL11.glRotatef((float)-6.5f, (float)0.0f, (float)1.0f, (float)0.0f);
                            GL11.glRotatef((float)-36.25f, (float)0.0f, (float)0.0f, (float)1.0f);
                            GL11.glScalef((float)1.0f, (float)1.8f, (float)1.0f);
                            this.hand.render((beu)RenderWeapon.mc.h, 1);
                            GL11.glPopMatrix();
                        }
                    }
                    GL11.glScalef((float)3.0f, (float)3.0f, (float)3.0f);
                    if (aimTexture == null) {
                        this.renderModel(item);
                    } else {
                        this.renderAim(aimTexture);
                    }
                    GL11.glPopMatrix();
                    if (RenderWeapon.mc.h.bG.d) {
                        this.listenAiming();
                    }
                } else {
                    GL11.glTranslatef((float)fpTransform[0], (float)fpTransform[1], (float)fpTransform[2]);
                    GL11.glRotatef((float)fpTransform[3], (float)1.0f, (float)0.0f, (float)0.0f);
                    GL11.glRotatef((float)fpTransform[4], (float)0.0f, (float)1.0f, (float)0.0f);
                    GL11.glRotatef((float)fpTransform[5], (float)0.0f, (float)0.0f, (float)1.0f);
                    this.setupTranslation(e2);
                    GL11.glPushMatrix();
                    if (!isSprinting) {
                        this.posRotAngle = 0.0f;
                    }
                    if (isSprinting && !this.weapon.isPistol) {
                        if (this.posRotAngle < 15.0f) {
                            this.posRotAngle += 1.5f;
                        }
                        GL11.glRotatef((float)this.posRotAngle, (float)0.0f, (float)4.0f, (float)0.0f);
                        GL11.glScalef((float)1.25f, (float)1.25f, (float)1.25f);
                        GL11.glTranslatef((float)(this.posX - 0.2f), (float)(this.handRotRightY + 0.95f), (float)(this.posZ + 0.4f));
                        GL11.glPushMatrix();
                        GL11.glRotatef((float)-80.0f, (float)1.0f, (float)0.0f, (float)(this.handRotLeftZ + 0.0f));
                        GL11.glRotatef((float)-1.5f, (float)(this.handRotLeftX + 0.0f), (float)1.0f, (float)0.0f);
                        GL11.glRotatef((float)-55.25f, (float)0.0f, (float)(this.handRotLeftY + 0.0f), (float)1.0f);
                        GL11.glTranslatef((float)(this.handLeftX - 1.0f), (float)(this.handLeftY - 0.8f), (float)(this.handLeftZ + -0.5f));
                        GL11.glScalef((float)1.1f, (float)1.9f, (float)1.1f);
                        this.setupRotation(e2);
                        this.hand.render((beu)RenderWeapon.mc.h, 1);
                        GL11.glPopMatrix();
                        GL11.glPushMatrix();
                        GL11.glRotatef((float)-83.0f, (float)1.0f, (float)0.0f, (float)(this.handRotLeftZ + 0.0f));
                        GL11.glRotatef((float)-1.5f, (float)(this.handRotLeftX + 0.0f), (float)1.0f, (float)0.0f);
                        GL11.glRotatef((float)5.25f, (float)0.0f, (float)(this.handRotLeftY + 0.0f), (float)1.0f);
                        GL11.glTranslatef((float)(this.handLeftX - 0.1f), (float)(this.handLeftY - 0.65f), (float)(this.handLeftZ + -0.4f));
                        GL11.glScalef((float)0.8f, (float)1.6f, (float)1.0f);
                        this.setupRotation(e2);
                        this.hand.render((beu)RenderWeapon.mc.h, 2);
                        GL11.glPopMatrix();
                    } else {
                        GL11.glRotatef((float)-33.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                        GL11.glTranslatef((float)(this.posX - 0.2f), (float)(this.posY + 1.475f), (float)(this.posZ + 1.05f));
                    }
                    this.setupRotation(e2);
                    GL11.glScalef((float)3.0f, (float)3.0f, (float)3.0f);
                    this.renderModel(item);
                    GL11.glPopMatrix();
                    if (!isSprinting || this.weapon.isPistol) {
                        GL11.glPushMatrix();
                        GL11.glRotatef((float)-90.0f, (float)1.0f, (float)0.0f, (float)(this.handRotRightZ + 0.0f));
                        GL11.glRotatef((float)0.0f, (float)(this.handRotRightX + 0.0f), (float)1.0f, (float)0.0f);
                        GL11.glRotatef((float)-33.0f, (float)0.0f, (float)(this.handRotRightY + 0.0f), (float)1.0f);
                        GL11.glTranslatef((float)(this.handRightX - 0.3f), (float)(this.handRightY - 1.3f), (float)(this.handRightZ + 1.075f));
                        this.setupRotation(e2);
                        this.hand.render((beu)RenderWeapon.mc.h, 1);
                        this.hand.render((beu)RenderWeapon.mc.h, 2);
                        GL11.glPopMatrix();
                    }
                    if (!isSprinting && !this.weapon.isPistol) {
                        GL11.glPushMatrix();
                        GL11.glRotatef((float)-83.0f, (float)1.0f, (float)0.0f, (float)(this.handRotLeftZ + 0.0f));
                        GL11.glRotatef((float)-1.5f, (float)(this.handRotLeftX + 0.0f), (float)1.0f, (float)0.0f);
                        GL11.glRotatef((float)-55.25f, (float)0.0f, (float)(this.handRotLeftY + 0.0f), (float)1.0f);
                        GL11.glTranslatef((float)(this.handLeftX - 0.42f + transformRotHandX), (float)(this.handLeftY - 1.1f + transformRotHandY), (float)(this.handLeftZ + 1.1f + transformRotHandZ));
                        GL11.glScalef((float)0.8f, (float)1.9f, (float)1.0f);
                        this.setupRotation(e2);
                        this.hand.render((beu)RenderWeapon.mc.h, 1);
                        GL11.glPopMatrix();
                    }
                    if (RenderWeapon.mc.h.bG.d) {
                        this.listenFirstPerson();
                    }
                }
            }
        }
        catch (NullPointerException var8) {
            var8.printStackTrace();
        }
        GL11.glPopMatrix();
    }

    public void renderOnPlayer(of p2, RenderType renderType, ye stack) {
        GL11.glPushMatrix();
        GL11.glScalef((float)1.45f, (float)1.45f, (float)1.45f);
        if (renderType == RenderType.BACKPACK_RIFLE) {
            GL11.glTranslatef((float)-0.15f, (float)0.3f, (float)0.15f);
            GL11.glRotatef((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glRotatef((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        } else if (renderType == RenderType.RIFLE) {
            GL11.glTranslatef((float)-0.03f, (float)0.3f, (float)(p2.n(3) == null ? 0.1f : 0.15f));
            GL11.glRotatef((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glRotatef((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)115.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        } else if (renderType == RenderType.PISTOL) {
            GL11.glTranslatef((float)0.18f, (float)0.35f, (float)0.0f);
            GL11.glRotatef((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glRotatef((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)-45.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        }
        this.renderModel(stack);
        GL11.glPopMatrix();
    }

    private void renderAim(bjo texture) {
        int i2;
        bdi entityclientplayermp = atv.w().h;
        bma.a((int)bma.b, (float)240.0f, (float)240.0f);
        GL11.glDisable((int)2896);
        GL11.glMatrixMode((int)5890);
        GL11.glPushMatrix();
        atv.w().N.a(this.blank);
        int tex = atv.w().N.b(this.blank).b();
        GL11.glViewport((int)0, (int)0, (int)RenderWeapon.mc.d, (int)RenderWeapon.mc.e);
        GL11.glBindTexture((int)3553, (int)tex);
        int width = RenderWeapon.mc.d;
        int height = RenderWeapon.mc.e;
        float zoom = 2.5f;
        int size = (int)((float)Math.min(width, height) / zoom);
        GL11.glCopyTexImage2D((int)3553, (int)0, (int)6407, (int)(width / 2 - size / 2), (int)(height / 2 - size / 2), (int)size, (int)size, (int)0);
        GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
        GL11.glPopMatrix();
        GL11.glMatrixMode((int)5888);
        GL11.glPushMatrix();
        bfq t2 = bfq.a;
        GL11.glScalef((float)0.22f, (float)0.22f, (float)0.22f);
        float[] x2 = new float[8];
        float[] y2 = new float[8];
        for (i2 = 0; i2 < 8; ++i2) {
            double j2 = Math.toRadians(i2 * 45);
            x2[i2] = (float)Math.cos(j2);
            y2[i2] = (float)Math.sin(j2);
        }
        t2.b();
        t2.a(x2[7], y2[7], 0.0, (x2[7] + 1.0f) / 2.0f, (y2[7] + 1.0f) / 2.0f);
        t2.a(x2[0], y2[0], 0.0, (x2[0] + 1.0f) / 2.0f, (y2[0] + 1.0f) / 2.0f);
        t2.a(x2[1], y2[1], 0.0, (x2[1] + 1.0f) / 2.0f, (y2[1] + 1.0f) / 2.0f);
        t2.a(x2[2], y2[2], 0.0, (x2[2] + 1.0f) / 2.0f, (y2[2] + 1.0f) / 2.0f);
        t2.a();
        t2.b();
        t2.a(x2[6], y2[6], 0.0, (x2[6] + 1.0f) / 2.0f, (y2[6] + 1.0f) / 2.0f);
        t2.a(x2[7], y2[7], 0.0, (x2[7] + 1.0f) / 2.0f, (y2[7] + 1.0f) / 2.0f);
        t2.a(x2[2], y2[2], 0.0, (x2[2] + 1.0f) / 2.0f, (y2[2] + 1.0f) / 2.0f);
        t2.a(x2[3], y2[3], 0.0, (x2[3] + 1.0f) / 2.0f, (y2[3] + 1.0f) / 2.0f);
        t2.a();
        t2.b();
        t2.a(x2[5], y2[5], 0.0, (x2[5] + 1.0f) / 2.0f, (y2[5] + 1.0f) / 2.0f);
        t2.a(x2[6], y2[6], 0.0, (x2[6] + 1.0f) / 2.0f, (y2[6] + 1.0f) / 2.0f);
        t2.a(x2[3], y2[3], 0.0, (x2[3] + 1.0f) / 2.0f, (y2[3] + 1.0f) / 2.0f);
        t2.a(x2[4], y2[4], 0.0, (x2[4] + 1.0f) / 2.0f, (y2[4] + 1.0f) / 2.0f);
        t2.a();
        GL11.glTexParameteri((int)3553, (int)10240, (int)9728);
        atv.w().N.a(texture);
        GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
        GL11.glEnable((int)3042);
        i2 = RenderWeapon.mc.f.h(ls.c(entityclientplayermp.u), ls.c(entityclientplayermp.v), ls.c(entityclientplayermp.w), 0);
        int var14 = i2 % 65536;
        int k2 = i2 / 65536;
        Logger.debug(var14 + ", " + k2);
        bma.a((int)bma.b, (float)((float)var14 / 1.0f), (float)((float)k2 / 1.0f));
        GL11.glBlendFunc((int)770, (int)771);
        t2.b();
        t2.a(-1.0, 1.0, 0.001, 0.0, 0.0);
        t2.a(-1.0, -1.0, 0.001, 0.0, 1.0);
        t2.a(1.0, -1.0, 0.001, 1.0, 1.0);
        t2.a(1.0, 1.0, 0.001, 1.0, 0.0);
        t2.a();
        GL11.glPopMatrix();
        GL11.glEnable((int)2896);
    }

    private void setupRotation(ClientWeaponInfo info) {
        if (RenderWeapon.mc.h.bn.h() != null && info.isReloading(RenderWeapon.mc.h.bn.h())) {
            aur timer = (aur)ReflectionHelper.getPrivateValue(atv.class, (Object)atv.w(), (String[])new String[]{"timer", "field_71428_T", "S"});
            float progress = info.getReloadRenderProgress(timer.c);
            GL11.glRotatef((float)(-65.0f * progress), (float)1.0f, (float)0.0f, (float)0.0f);
        }
    }

    private void setupTranslation(ClientWeaponInfo info) {
        float progress = 0.0f;
        aur timer = (aur)ReflectionHelper.getPrivateValue(atv.class, (Object)atv.w(), (String[])new String[]{"timer", "field_71428_T", "S"});
    }

    private void listenFirstPerson() {
        if (Keyboard.isKeyDown((int)75)) {
            this.posX -= 0.01f;
        }
        if (Keyboard.isKeyDown((int)77)) {
            this.posX += 0.01f;
        }
        if (Keyboard.isKeyDown((int)80)) {
            this.posY -= 0.01f;
        }
        if (Keyboard.isKeyDown((int)72)) {
            this.posY += 0.01f;
        }
        if (Keyboard.isKeyDown((int)71)) {
            this.posZ -= 0.01f;
        }
        if (Keyboard.isKeyDown((int)73)) {
            this.posZ += 0.01f;
        }
        if (Keyboard.isKeyDown((int)76)) {
            this.posX = 0.0f;
            this.posY = 0.0f;
            this.posZ = 0.0f;
        }
        if (Keyboard.isKeyDown((int)82) && !written) {
            System.out.println("posX: " + this.posX);
            System.out.println("posY: " + this.posY);
            System.out.println("posZ: " + this.posZ);
            written = true;
        } else if (!Keyboard.isKeyDown((int)82)) {
            written = false;
        }
    }

    private void listenAiming() {
        if (Keyboard.isKeyDown((int)75)) {
            this.aimRotX -= 0.1f;
        }
        if (Keyboard.isKeyDown((int)77)) {
            this.aimRotX += 0.1f;
        }
        if (Keyboard.isKeyDown((int)80)) {
            this.aimPosY -= 0.01f;
        }
        if (Keyboard.isKeyDown((int)72)) {
            this.aimPosY += 0.01f;
        }
        if (Keyboard.isKeyDown((int)71)) {
            this.aimPosZ -= 0.01f;
        }
        if (Keyboard.isKeyDown((int)73)) {
            this.aimPosZ += 0.01f;
        }
        if (Keyboard.isKeyDown((int)76)) {
            this.aimRotX = 0.0f;
            this.aimPosY = 0.0f;
            this.aimPosZ = 0.0f;
        }
        if (Keyboard.isKeyDown((int)82) && !written) {
            System.out.println("aimRotX: " + this.aimRotX);
            System.out.println("aimPosY: " + this.aimPosY);
            System.out.println("aimPosZ: " + this.aimPosZ);
            written = true;
        } else if (!Keyboard.isKeyDown((int)82)) {
            written = false;
        }
    }

    private void listenThirdPerson() {
        if (Keyboard.isKeyDown((int)78)) {
            if (Keyboard.isKeyDown((int)79)) {
                oldLivingTransform[0] = oldLivingTransform[0] + 0.01f;
            }
            if (Keyboard.isKeyDown((int)80)) {
                oldLivingTransform[1] = oldLivingTransform[1] + 0.01f;
            }
            if (Keyboard.isKeyDown((int)81)) {
                oldLivingTransform[2] = oldLivingTransform[2] + 0.01f;
            }
            if (Keyboard.isKeyDown((int)75)) {
                oldLivingTransform[3] = oldLivingTransform[3] + 0.1f;
            }
            if (Keyboard.isKeyDown((int)76)) {
                oldLivingTransform[4] = oldLivingTransform[4] + 0.1f;
            }
            if (Keyboard.isKeyDown((int)77)) {
                oldLivingTransform[5] = oldLivingTransform[5] + 0.1f;
            }
        } else if (Keyboard.isKeyDown((int)12)) {
            if (Keyboard.isKeyDown((int)79)) {
                oldLivingTransform[0] = oldLivingTransform[0] - 0.01f;
            }
            if (Keyboard.isKeyDown((int)80)) {
                oldLivingTransform[1] = oldLivingTransform[1] - 0.01f;
            }
            if (Keyboard.isKeyDown((int)81)) {
                oldLivingTransform[2] = oldLivingTransform[2] - 0.01f;
            }
            if (Keyboard.isKeyDown((int)75)) {
                oldLivingTransform[3] = oldLivingTransform[3] - 0.1f;
            }
            if (Keyboard.isKeyDown((int)76)) {
                oldLivingTransform[4] = oldLivingTransform[4] - 0.1f;
            }
            if (Keyboard.isKeyDown((int)77)) {
                oldLivingTransform[5] = oldLivingTransform[5] - 0.1f;
            }
        }
        System.out.println(oldLivingTransform[0] + ", " + oldLivingTransform[1] + ", " + oldLivingTransform[2] + ", " + oldLivingTransform[3] + ", " + oldLivingTransform[4] + ", " + oldLivingTransform[5]);
    }

    static {
        zoom = 2.0f;
        mc = atv.w();
        fpTransform = new float[]{-0.355f, -0.06f, 0.234f, -0.6f, -15.4f, -3.85f};
        playerTransform = new float[]{0.66f, 1.3f, 0.78f, -76.8f, 14.1f, 45.3f};
        oldLivingTransform = new float[]{-0.49f, 1.08f, 0.57f, 29.0f, 233.7f, 33.6f};
        newLivingTransform = new float[]{0.23f, 0.84f, 0.76f, 9.1f, 316.6f, 0.0f};
        written = false;
    }

    public static enum RenderType {
        RIFLE("RIFLE", 0),
        BACKPACK_RIFLE("BACKPACK_RIFLE", 1),
        PISTOL("PISTOL", 2);

        private static final RenderType[] $VALUES;

        private RenderType(String var1, int var2) {
        }

        static {
            $VALUES = new RenderType[]{RIFLE, BACKPACK_RIFLE, PISTOL};
        }
    }
}

