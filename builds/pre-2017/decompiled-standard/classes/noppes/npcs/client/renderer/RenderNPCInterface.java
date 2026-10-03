/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.renderer;

import gloomyfolken.mods.effects.client.mcsa.ezfa;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.kjui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.constants.EnumAnimation;
import noppes.npcs.constants.EnumJobType;
import noppes.npcs.constants.EnumMovingType;
import noppes.npcs.constants.EnumStandingType;
import noppes.npcs.entity.EntityNPCHumanMale;
import noppes.npcs.roles.JobBoss;
import org.lwjgl.opengl.GL11;

public class RenderNPCInterface
extends ceev {
    private static final ResourceLocation AVAILABLE_QUEST = new ResourceLocation("customnpcs", "textures/misc/available_quest.png");

    public RenderNPCInterface(ModelBase modelBase, float f) {
        super(modelBase, f);
    }

    protected void renderName(EntityNPCInterface entityNPCInterface, double d, double d2, double d3) {
        float f;
        if (!xpzm._A() || entityNPCInterface == this.field_76990_c._j) {
            return;
        }
        int n = CustomNpcs.npcQuestAvailability.getOrDefault(entityNPCInterface.field_70157_k, 0);
        xpzm xpzm2 = xpzm._E();
        boolean bl = xpzm2._t.field_71075_bZ._d;
        if (!entityNPCInterface.display.showName() && n == 0 && entityNPCInterface.status.isApproved() && (!bl || entityNPCInterface.dungeons.isEmpty())) {
            return;
        }
        float f2 = entityNPCInterface.func_70032_d(this.field_76990_c._j);
        float f3 = f = entityNPCInterface.func_70093_af() ? 16.0f : 20.0f;
        if (f2 > f) {
            return;
        }
        boolean bl2 = xpzm2._v == entityNPCInterface || f2 <= 2.0f;
        float f4 = 2.0f + entityNPCInterface.labelOffset;
        if (entityNPCInterface.aiData.movingType == EnumMovingType.Standing) {
            if (!entityNPCInterface.func_70608_bn() && !entityNPCInterface.isKilled()) {
                if (entityNPCInterface.func_70115_ae()) {
                    f4 *= 0.75f;
                }
            } else {
                f4 = 0.5f;
            }
        }
        f4 = (float)((double)f4 * Math.pow((float)entityNPCInterface.display.modelSize / 5.0f, 1.1));
        f4 = (float)((double)f4 * ((double)entityNPCInterface.scaleY + 0.06));
        f4 += entityNPCInterface.currentAnimation == EnumAnimation.NONE ? entityNPCInterface.aiData.bodyOffsetY / 10.0f - 0.5f : 0.0f;
        if (bl2) {
            GL11.glDepthFunc(519);
        }
        if (bl) {
            String string;
            if (!(entityNPCInterface.dungeons.isEmpty() || entityNPCInterface.dungeons.size() == 1 && entityNPCInterface.dungeons.iterator().next().equals("main") || (string = String.join((CharSequence)";", entityNPCInterface.dungeons)).isEmpty())) {
                this.renderLivingLabel(entityNPCInterface, "S: " + string, d, d2 - 2.0 + (double)f4 + 0.5, d3, 64);
            }
            if (!entityNPCInterface.status.isApproved()) {
                this.renderLivingLabel(entityNPCInterface, "\u0412: " + (entityNPCInterface.status.isFree() ? "\u043d\u0435\u0442" : entityNPCInterface.getCurrentOwner()), d, d2 - 2.0 + (double)f4 + 0.25, d3, 64);
            }
        }
        if (entityNPCInterface.isSeen) {
            boolean bl3 = false;
            if (entityNPCInterface.display.showName()) {
                bl3 = this.renderLivingLabel(entityNPCInterface, entityNPCInterface.func_70023_ak(), d, d2 - 2.0 + (double)f4, d3, 8);
            }
            if (n != 0) {
                this.drawAvailabilityIcon(entityNPCInterface, (float)d, (float)d2, (float)d3, n, bl3);
            }
        }
        if (bl2) {
            GL11.glDepthFunc(515);
        }
    }

    private void drawAvailabilityIcon(EntityNPCInterface entityNPCInterface, float f, float f2, float f3, int n, boolean bl) {
        owxf._a();
        iwya._a(iwya._b, 240.0f, 0.0f);
        float f4 = 0.0066666673f * (float)entityNPCInterface.display.modelSize;
        GL11.glPushMatrix();
        GL11.glTranslatef(f, f2 + 2.4f, f3);
        GL11.glNormal3f(0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-this.field_76990_c._l, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(this.field_76990_c._m, 1.0f, 0.0f, 0.0f);
        GL11.glScalef(-f4, -f4, f4);
        GL11.glEnable(3042);
        GL11.glDisable(2896);
        if (n == 2) {
            GL11.glColor4f(1.0f, 1.0f, 0.0f, 1.0f);
        } else {
            GL11.glColor4f(0.0f, 1.0f, 0.0f, 1.0f);
        }
        this.func_110776_a(AVAILABLE_QUEST);
        float f5 = 128.0f;
        float f6 = 128.0f;
        double d = 0.0625;
        double d2 = bl ? (double)(-f6) * d : 0.0;
        qozx._a((double)(-f5) * d * 0.5, d2, (double)f5 * d, (double)f6 * d, 0.0, 0.0, f5, f6, 128.0, 128.0);
        GL11.glPopMatrix();
        GL11.glDisable(3042);
        GL11.glEnable(2896);
        owxf._b();
    }

    protected boolean renderLivingLabel(EntityNPCInterface entityNPCInterface, String string, double d, double d2, double d3, int n) {
        return this.renderLivingLabel(entityNPCInterface, string, d, d2, d3, n, 10.0f, entityNPCInterface.getFaction().color, true);
    }

    protected boolean renderLivingLabel(EntityNPCInterface entityNPCInterface, String string, double d, double d2, double d3, int n, float f, int n2, boolean bl) {
        float f2 = entityNPCInterface.func_70032_d(this.field_76990_c._j);
        if (f2 <= (float)n) {
            float f3 = 0.0053333337f * (float)entityNPCInterface.display.modelSize;
            GL11.glPushMatrix();
            GL11.glTranslatef((float)d + 0.0f, (float)d2 + 2.3f, (float)d3);
            GL11.glNormal3f(0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-this.field_76990_c._l, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(this.field_76990_c._m, 1.0f, 0.0f, 0.0f);
            GL11.glScalef(-f3, -f3, f3);
            ezfc._a();
            ezfc._d();
            ccuh ccuh2 = ccuh._a._a();
            ccuh2._b[0] = string;
            ccuh2._c[0] = n2;
            ccuh2._b[1] = null;
            ccuh2._c[1] = 0;
            ccuh2._d = f;
            ccuh2.load();
            ezfa._a._b.add(ccuh2);
            ezfc._b();
            GL11.glPopMatrix();
            return true;
        }
        return false;
    }

    protected void renderPlayerScale(EntityNPCInterface entityNPCInterface, float f) {
        float f2 = (float)(entityNPCInterface.display.skinColor >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(entityNPCInterface.display.skinColor >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(entityNPCInterface.display.skinColor & 0xFF) / 255.0f;
        GL11.glColor3f(f2, f3, f4);
        GL11.glScalef(entityNPCInterface.scaleX / 5.0f * (float)entityNPCInterface.display.modelSize, entityNPCInterface.scaleY / 5.0f * (float)entityNPCInterface.display.modelSize, entityNPCInterface.scaleZ / 5.0f * (float)entityNPCInterface.display.modelSize);
    }

    protected void renderPlayerSleep(EntityNPCInterface entityNPCInterface, double d, double d2, double d3) {
        this.field_76989_e = (float)entityNPCInterface.display.modelSize / 10.0f;
        float f = 0.0f;
        float f2 = entityNPCInterface.currentAnimation == EnumAnimation.NONE ? entityNPCInterface.aiData.bodyOffsetY / 10.0f - 0.5f : 0.0f;
        float f3 = 0.0f;
        if (!entityNPCInterface.isKilled() && !entityNPCInterface.isWalking()) {
            if (entityNPCInterface.func_70608_bn()) {
                f = (float)(-Math.cos(Math.toRadians(180 - entityNPCInterface.aiData.orientation)));
                f3 = (float)(-Math.sin(Math.toRadians(entityNPCInterface.aiData.orientation)));
                f2 += 0.14f;
            } else if (entityNPCInterface.func_70115_ae()) {
                f2 -= 0.5f;
            }
        }
        this.renderLiving(entityNPCInterface, d, d2, d3, f, f2, f3);
    }

    private void renderLiving(EntityNPCInterface entityNPCInterface, double d, double d2, double d3, float f, float f2, float f3) {
        f = f / 5.0f * (float)entityNPCInterface.display.modelSize;
        f2 = f2 / 5.0f * (float)entityNPCInterface.display.modelSize;
        f3 = f3 / 5.0f * (float)entityNPCInterface.display.modelSize;
        super.func_77039_a(entityNPCInterface, d + (double)f, d2 + (double)f2, d3 + (double)f3);
    }

    @Override
    protected void func_77043_a(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        EntityNPCInterface entityNPCInterface = (EntityNPCInterface)entityLivingBase;
        if (entityNPCInterface.func_70089_S() && entityNPCInterface.func_70608_bn()) {
            GL11.glRotatef(entityNPCInterface.aiData.orientation, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(this.func_77037_a(entityNPCInterface), 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(270.0f, 0.0f, 1.0f, 0.0f);
        } else {
            super.func_77043_a(entityNPCInterface, f, f2, f3);
        }
    }

    @Override
    protected void func_77033_b(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        if (!MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Specials.Pre(entityLivingBase, this))) {
            this.renderName((EntityNPCInterface)entityLivingBase, d, d2, d3);
        }
    }

    @Override
    protected void func_77041_b(EntityLivingBase entityLivingBase, float f) {
        this.renderPlayerScale((EntityNPCInterface)entityLivingBase, f);
    }

    boolean shouldRenderNpc(EntityNPCInterface entityNPCInterface) {
        return !entityNPCInterface.isKilled() || entityNPCInterface.shouldRenderDeadBody();
    }

    @Override
    public void func_77031_a(EntityLiving entityLiving, double d, double d2, double d3, float f, float f2) {
        EntityNPCInterface entityNPCInterface = (EntityNPCInterface)entityLiving;
        if (this.shouldRenderNpc(entityNPCInterface)) {
            if (entityNPCInterface.advanced.job == EnumJobType.Boss && !entityNPCInterface.isKilled() && entityNPCInterface.deathTime <= 10L && !((JobBoss)entityNPCInterface.jobInterface).hideName) {
                kjui._a(entityNPCInterface, true);
            }
            if (entityNPCInterface.aiData.standingType == EnumStandingType.HeadRotation && !entityNPCInterface.isWalking()) {
                entityNPCInterface.field_70760_ar = entityNPCInterface.field_70761_aq = (float)entityNPCInterface.aiData.orientation;
            }
            super.func_77031_a(entityLiving, d, d2, d3, f, f2);
        }
    }

    @Override
    protected void func_77036_a(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6) {
        super.func_77036_a(entityLivingBase, f, f2, f3, f4, f5, f6);
        EntityNPCInterface entityNPCInterface = (EntityNPCInterface)entityLivingBase;
        if (!entityNPCInterface.display.glowTexture.isEmpty()) {
            GL11.glDepthFunc(515);
            if (entityNPCInterface.textureGlowLocation == null) {
                entityNPCInterface.textureGlowLocation = new ResourceLocation(entityNPCInterface.display.glowTexture);
            }
            this.func_110776_a((ResourceLocation)entityNPCInterface.textureGlowLocation);
            float f7 = 1.0f;
            GL11.glEnable(3042);
            GL11.glBlendFunc(1, 1);
            GL11.glDisable(2896);
            if (entityNPCInterface.func_82150_aj()) {
                GL11.glDepthMask(false);
            } else {
                GL11.glDepthMask(true);
            }
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glPushMatrix();
            GL11.glScalef(1.001f, 1.001f, 1.001f);
            this.field_77045_g.func_78088_a(entityLivingBase, f, f2, f3, f4, f5, f6);
            GL11.glPopMatrix();
            GL11.glEnable(2896);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, f7);
            GL11.glDepthFunc(515);
            GL11.glDisable(3042);
        }
    }

    @Override
    protected float func_77044_a(EntityLivingBase entityLivingBase, float f) {
        EntityNPCInterface entityNPCInterface = (EntityNPCInterface)entityLivingBase;
        return !entityNPCInterface.isKilled() && !entityNPCInterface.display.NoLivingAnimation ? super.func_77044_a(entityLivingBase, f) : 0.0f;
    }

    @Override
    protected void func_77039_a(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        this.renderPlayerSleep((EntityNPCInterface)entityLivingBase, d, d2, d3);
    }

    @Override
    public ResourceLocation func_110775_a(Entity entity) {
        EntityNPCInterface entityNPCInterface = (EntityNPCInterface)entity;
        if (entityNPCInterface.textureLocation == null) {
            if (entityNPCInterface.display.usingSkinUrl) {
                ResourceLocation resourceLocation = AbstractClientPlayer.func_110311_f(entityNPCInterface.display.skinUsername);
                AbstractClientPlayer.func_110304_a(resourceLocation, entityNPCInterface.display.skinUsername);
                entityNPCInterface.textureLocation = resourceLocation;
            } else {
                ResourceLocation resourceLocation = new ResourceLocation(entityNPCInterface.getNpcTexture());
                entityNPCInterface.textureLocation = resourceLocation;
                fmib._a(resourceLocation, entityNPCInterface instanceof EntityNPCHumanMale);
            }
        }
        return (ResourceLocation)entityNPCInterface.textureLocation;
    }
}

