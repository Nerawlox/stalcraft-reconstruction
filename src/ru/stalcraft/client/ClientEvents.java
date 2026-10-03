/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  avc
 *  bcy
 *  beu
 *  cpw.mods.fml.relauncher.ReflectionHelper
 *  net.minecraftforge.client.event.DrawBlockHighlightEvent
 *  net.minecraftforge.client.event.FOVUpdateEvent
 *  net.minecraftforge.client.event.GuiOpenEvent
 *  net.minecraftforge.client.event.MouseEvent
 *  net.minecraftforge.client.event.RenderPlayerEvent$Post
 *  net.minecraftforge.client.event.RenderPlayerEvent$Pre
 *  net.minecraftforge.client.event.RenderPlayerEvent$Specials$Pre
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.client.event.sound.SoundLoadEvent
 *  net.minecraftforge.event.ForgeSubscribe
 *  net.minecraftforge.event.entity.player.ItemTooltipEvent
 *  net.minecraftforge.event.world.WorldEvent$Load
 *  org.lwjgl.opengl.GL11
 */
package ru.stalcraft.client;

import cpw.mods.fml.relauncher.ReflectionHelper;
import java.util.Iterator;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.world.WorldEvent;
import org.lwjgl.opengl.GL11;
import ru.stalcraft.ItemsConfig;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.asm.MethodsHelper;
import ru.stalcraft.client.ClientProxy;
import ru.stalcraft.client.ClientWeaponInfo;
import ru.stalcraft.client.clans.TagData;
import ru.stalcraft.client.ejection.ClientEjection;
import ru.stalcraft.client.gui.GuiGameOverStalker;
import ru.stalcraft.client.gui.GuiStalkerConnecting;
import ru.stalcraft.client.gui.GuiStalkerMenu;
import ru.stalcraft.client.network.ClientPacketSender;
import ru.stalcraft.client.player.PlayerClientInfo;
import ru.stalcraft.items.IFlashlight;
import ru.stalcraft.items.ItemWeapon;
import ru.stalcraft.player.PlayerUtils;

public class ClientEvents {
    public static boolean isTickingPlayer = false;
    boolean soundsLoaded = false;
    private static float radiansToDegrees = 57.295776f;

    @ForgeSubscribe
    public void onClick(MouseEvent e2) {
        atv mc = atv.w();
        if (mc.A && mc.h != null && PlayerUtils.getInfo((uf)mc.h).getHandcuffs()) {
            e2.setCanceled(true);
        } else if ((e2.button == 0 || e2.button == 1) && mc.A && mc.h != null && mc.h.by() != null && mc.h.by().b() instanceof IFlashlight) {
            e2.setCanceled(true);
        } else if (e2.button == 1 && e2.buttonstate && mc.A && mc.t != null && mc.t.g instanceof uf && mc.h.by() == null) {
            ClientPacketSender.sendRightClickRequest((uf)mc.t.g);
            e2.setCanceled(true);
        }
        if ((e2.button == 0 || e2.button == 1) && mc.h != null && mc.h.by() != null && mc.h.by().b() instanceof ItemWeapon) {
            e2.setCanceled(true);
        }
        if (e2.button == 0 && mc.h != null && PlayerUtils.getInfo((uf)mc.h).weaponInfo.currentGun != null) {
            e2.setCanceled(true);
        }
    }

    @ForgeSubscribe
    public void onSpecialsPreRender(RenderPlayerEvent.Specials.Pre e2) {
        if (PlayerUtils.getInfo(e2.entityPlayer).getHandcuffs()) {
            e2.renderItem = false;
        }
    }

    @ForgeSubscribe
    public void renderPlayer(RenderPlayerEvent.Pre par1) {
        bbj par2 = (bbj)((Object)ReflectionHelper.getPrivateValue(bhj.class, (Object)par1.renderer, (int)1));
        bbj par3 = (bbj)((Object)ReflectionHelper.getPrivateValue(bhj.class, (Object)par1.renderer, (int)2));
        bbj par4 = (bbj)((Object)ReflectionHelper.getPrivateValue(bhj.class, (Object)par1.renderer, (int)3));
        par2.o = par1.entityPlayer.by() != null && par1.entityPlayer.by().b() instanceof ItemWeapon;
    }

    @ForgeSubscribe
    public void onGuiOpen(GuiOpenEvent e2) {
        if (e2.gui instanceof axv && PlayerUtils.getInfo((uf)atv.w().h).getHandcuffs()) {
            e2.setCanceled(true);
        } else if (e2.gui instanceof axv && !atv.w().c.h()) {
            e2.setCanceled(true);
            ClientPacketSender.sendOpenGuiInventory();
        } else if (e2.gui instanceof avc && !(e2.gui instanceof GuiGameOverStalker)) {
            e2.setCanceled(true);
            GuiGameOverStalker gui = new GuiGameOverStalker();
            int ticksToLie = 0;
            PlayerClientInfo info = (PlayerClientInfo)PlayerUtils.getInfo((uf)atv.w().h);
            if (info.getForceCooldown() > 0) {
                ticksToLie += info.getForceCooldown();
                info.setForceCooldown(-1);
            }
            gui.deathTimer = ticksToLie;
            atv.w().a((awe)((Object)gui));
        } else if (e2.gui instanceof blt && !(e2.gui instanceof GuiStalkerMenu)) {
            e2.setCanceled(true);
            atv.w().a(new GuiStalkerMenu());
        } else if (e2.gui instanceof bcy && !(e2.gui instanceof GuiStalkerConnecting)) {
            e2.gui = new GuiStalkerMenu();
        } else if (e2.gui instanceof avn) {
            return;
        }
    }

    @ForgeSubscribe
    public void onBlockHighlight(DrawBlockHighlightEvent e2) {
        if (!atv.w().c.h()) {
            e2.setCanceled(true);
        }
    }

    @ForgeSubscribe
    public void onFovUpdate(FOVUpdateEvent e2) {
        atv mc = atv.w();
        if (mc.h != null && mc.h.bn.h() != null && mc.h.bn.h().b() instanceof ItemWeapon && ((ClientWeaponInfo)PlayerUtils.getInfo((uf)mc.h).weaponInfo).isAiming()) {
            e2.newfov = e2.fov / ((ItemWeapon)mc.h.bn.h().b()).zoom;
        }
    }

    @ForgeSubscribe
    public void onPlayerPreRender(RenderPlayerEvent.Pre e2) {
        MethodsHelper.renderRope((beu)e2.entityPlayer, MethodsHelper.interpolate(e2.entity.r, e2.entity.u, e2.partialRenderTick) - bgl.b, MethodsHelper.interpolate(e2.entity.s, e2.entity.v, e2.partialRenderTick) - bgl.c, MethodsHelper.interpolate(e2.entity.t, e2.entity.w, e2.partialRenderTick) - bgl.d, e2.partialRenderTick);
    }

    @ForgeSubscribe
    public void onPlayerPostRender(RenderPlayerEvent.Post e2) {
        bgl rm2 = bgl.a;
        double x2 = this.interpolate(e2.entity.r, e2.entity.u, e2.partialRenderTick);
        double y2 = this.interpolate(e2.entity.s, e2.entity.v, e2.partialRenderTick);
        double z2 = this.interpolate(e2.entity.t, e2.entity.w, e2.partialRenderTick);
        this.passSpecialRender(e2.entityPlayer, x2 - bgl.b, y2 - bgl.c, z2 - bgl.d);
    }

    private boolean shouldRenderLivingLabel(uf entity) {
        atv mc = atv.w();
        return mc.t != null && mc.t.g == entity && atv.r() && entity != bgl.a.h && !entity.d((uf)mc.h) && entity.n == null;
    }

    private void passSpecialRender(uf entity, double par2, double par4, double par6) {
        if (this.shouldRenderLivingLabel(entity)) {
            String nameStr = entity.bu;
            TagData tag = (TagData)ClientProxy.tags.get(entity.bu);
            if (tag == null) {
                return;
            }
            String clanStr = ((TagData)ClientProxy.tags.get((Object)entity.bu)).clan;
            if (!clanStr.isEmpty()) {
                clanStr = "<" + clanStr + ">";
            }
            int nameColor = tag.reputation >= 0 ? (tag.isAgressive ? 0x8000FF : 0x11FF11) : 0xAA1111;
            int clanColor = !tag.clan.isEmpty() && ClientProxy.clanData.enemies.contains(tag.clan) ? 0xAA1111 : 0x11FF11;
            this.renderLivingLabel(entity, par2, par4, par6, nameStr, clanStr, nameColor, clanColor);
        }
    }

    private void renderLivingLabel(uf entity, double par2, double par4, double par6, String nameStr, String clanStr, int nameColor, int clanColor) {
        if (entity.bh()) {
            this.renderLivigLabelAt(entity, par2, par4 - 1.5, par6, nameStr, clanStr, nameColor, clanColor);
        } else if (entity.ah()) {
            this.renderLivigLabelAt(entity, par2, par4 - 0.25, par6, nameStr, clanStr, nameColor, clanColor);
        } else {
            this.renderLivigLabelAt(entity, par2, par4, par6, nameStr, clanStr, nameColor, clanColor);
        }
    }

    private void renderLivigLabelAt(uf entity, double par3, double par5, double par7, String nameStr, String clanStr, int nameColor, int clanColor) {
        int j2;
        avi fontrenderer = bgl.a.a();
        float f2 = 1.6f;
        float f1 = 0.016666668f * f2;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)par3 + 0.0f), (float)((float)par5 + entity.P + 0.5f), (float)((float)par7));
        GL11.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(-bgl.a.j), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)bgl.a.k, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glScalef((float)(-f1), (float)(-f1), (float)f1);
        GL11.glDisable((int)2896);
        GL11.glDepthMask((boolean)false);
        GL11.glDisable((int)2929);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        bfq tessellator = bfq.a;
        GL11.glDisable((int)3553);
        int b0 = 0;
        int width = Math.max(fontrenderer.a(nameStr), fontrenderer.a(clanStr));
        if (!clanStr.isEmpty()) {
            b0 = (byte)(b0 - 9);
            tessellator.b();
            j2 = width / 2;
            tessellator.a(0.0f, 0.0f, 0.0f, 0.5f);
            tessellator.a((double)(-j2 - 1), -1.0, 0.0);
            tessellator.a((double)(-j2 - 1), 8.0, 0.0);
            tessellator.a((double)(j2 + 1), 8.0, 0.0);
            tessellator.a((double)(j2 + 1), -1.0, 0.0);
            tessellator.a();
            GL11.glEnable((int)3553);
            fontrenderer.b(clanStr, -fontrenderer.a(clanStr) / 2, 0, 0x20FFFFFF);
            GL11.glEnable((int)2929);
            GL11.glDepthMask((boolean)true);
            fontrenderer.b(clanStr, -fontrenderer.a(clanStr) / 2, 0, clanColor);
            GL11.glDepthMask((boolean)false);
            GL11.glDisable((int)2929);
            GL11.glDisable((int)3553);
        }
        tessellator.b();
        j2 = width / 2;
        tessellator.a(0.0f, 0.0f, 0.0f, 0.5f);
        tessellator.a((double)(-j2 - 1), (double)(-1 + b0), 0.0);
        tessellator.a((double)(-j2 - 1), (double)(8 + b0), 0.0);
        tessellator.a((double)(j2 + 1), (double)(8 + b0), 0.0);
        tessellator.a((double)(j2 + 1), (double)(-1 + b0), 0.0);
        tessellator.a();
        tessellator.a(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable((int)3553);
        fontrenderer.b(nameStr, -fontrenderer.a(nameStr) / 2, b0, 0x20FFFFFF);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        fontrenderer.b(nameStr, -fontrenderer.a(nameStr) / 2, b0, nameColor);
        GL11.glEnable((int)2896);
        GL11.glDisable((int)3042);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPopMatrix();
    }

    @ForgeSubscribe
    public void onSoundsLoaded(SoundLoadEvent e2) {
        e2.manager.a("stalker:instal.ogg");
        e2.manager.a("stalker:firemode.ogg");
        e2.manager.a("stalker:hitmarker.ogg");
        e2.manager.a("stalker:radiation.ogg");
        e2.manager.a("stalker:medicine.ogg");
        e2.manager.a("stalker:chemical.ogg");
        e2.manager.a("stalker:biological.ogg");
        e2.manager.a("stalker:machinegun_reload.ogg");
        e2.manager.a("stalker:machinegun_shoot.ogg");
        e2.manager.a("stalker:machinegun_hit.ogg");
        e2.manager.a("stalker:ejection.ogg");
        e2.manager.a("stalker:ejection_start.ogg");
        e2.manager.a("stalker:ejection_end.ogg");
        e2.manager.a("stalker:lightturrel_shoot.ogg");
        e2.manager.a("stalker:lightturrel_hit.ogg");
        e2.manager.a("stalker:middleturrel_shoot.ogg");
        e2.manager.a("stalker:middleturrel_hit.ogg");
        e2.manager.a("stalker:heavyturrel_shoot.ogg");
        e2.manager.a("stalker:heavyturrel_hit.ogg");
        e2.manager.a("stalker:blackhole.ogg");
        e2.manager.a("stalker:blackhole_active.ogg");
        e2.manager.a("stalker:carousel.ogg");
        e2.manager.a("stalker:coach.ogg");
        e2.manager.a("stalker:coach_active.ogg");
        e2.manager.a("stalker:electra.ogg");
        e2.manager.a("stalker:kissel.ogg");
        e2.manager.a("stalker:lighter.ogg");
        e2.manager.a("stalker:steam.ogg");
        e2.manager.a("stalker:trampoline.ogg");
        e2.manager.a("stalker:electra_hit.ogg");
        e2.manager.a("stalker:kissel_hit.ogg");
        e2.manager.a("stalker:steam_hit.ogg");
        e2.manager.a("stalker:trampoline_hit.ogg");
        e2.manager.a("stalker:medicine_a.ogg");
        e2.manager.a("stalker:medicine_b.ogg");
        e2.manager.a("stalker:medicine_c.ogg");
        e2.manager.a("stalker:bandage.ogg");
        e2.manager.a("stalker:radiation_protector.ogg");
        e2.manager.a("stalker:biological_protector.ogg");
        e2.manager.a("stalker:psycho_protector.ogg");
        e2.manager.a("stalker:novokaine.ogg");
        Iterator i$ = ItemsConfig.getSounds().iterator();
        while (i$.hasNext()) {
            e2.manager.a("stalker:" + (String)i$.next() + ".ogg");
        }
    }

    @ForgeSubscribe
    public void onWorldRendering(RenderWorldLastEvent e2) {
    }

    private double interpolate(double prev, double current, double frame) {
        return prev + (current - prev) * frame;
    }

    private float handleRotationFloat(of par1EntityLiving, float par2) {
        return (float)par1EntityLiving.ac + par2;
    }

    public static void renderEjectionSkyBox(ClientEjection e2) {
        GL11.glPushAttrib((int)16640);
        GL11.glDisable((int)3553);
        float[] color = e2.getSkyColor();
        GL11.glColor4f((float)color[0], (float)color[1], (float)color[2], (float)color[3]);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)774, (int)768);
        GL11.glDisable((int)2896);
        GL11.glPushMatrix();
        bfq t2 = bfq.a;
        t2.b();
        t2.a(100.0, 100.0, 100.0);
        t2.a(100.0, -100.0, 100.0);
        t2.a(-100.0, -100.0, 100.0);
        t2.a(-100.0, 100.0, 100.0);
        t2.a();
        t2.b();
        t2.a(100.0, 100.0, -100.0);
        t2.a(-100.0, 100.0, -100.0);
        t2.a(-100.0, -100.0, -100.0);
        t2.a(100.0, -100.0, -100.0);
        t2.a();
        t2.b();
        t2.a(100.0, 100.0, 100.0);
        t2.a(-100.0, 100.0, 100.0);
        t2.a(-100.0, 100.0, -100.0);
        t2.a(100.0, 100.0, -100.0);
        t2.a();
        t2.b();
        t2.a(100.0, -100.0, 100.0);
        t2.a(100.0, -100.0, -100.0);
        t2.a(-100.0, -100.0, -100.0);
        t2.a(-100.0, -100.0, 100.0);
        t2.a();
        t2.b();
        t2.a(100.0, 100.0, 100.0);
        t2.a(100.0, 100.0, -100.0);
        t2.a(100.0, -100.0, -100.0);
        t2.a(100.0, -100.0, 100.0);
        t2.a();
        t2.b();
        t2.a(-100.0, 100.0, 100.0);
        t2.a(-100.0, -100.0, 100.0);
        t2.a(-100.0, -100.0, -100.0);
        t2.a(-100.0, 100.0, -100.0);
        t2.a();
        GL11.glPopMatrix();
        GL11.glEnable((int)2896);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)3553);
        GL11.glPopAttrib();
    }

    @ForgeSubscribe
    public void onWorldLoad(WorldEvent.Load e2) {
        if (StalkerMain.getProxy().isRemote()) {
            ((ClientProxy)StalkerMain.getProxy()).initWorldStatics();
        }
    }

    @ForgeSubscribe
    public void onItemTool(ItemTooltipEvent e2) {
        PlayerClientInfo par2 = (PlayerClientInfo)PlayerUtils.getInfo(e2.entityPlayer);
        if (par2.isNoDrop(e2.itemStack)) {
            e2.toolTip.add(1, (Object)((Object)a.k) + "\u041d\u0435 \u0432\u044b\u043f\u0430\u0434\u0430\u044e\u0449\u0438\u0439 \u043f\u0440\u0435\u0434\u043c\u0435\u0442");
        }
        if (par2.isPersonal(e2.itemStack)) {
            e2.toolTip.add(2, (Object)((Object)a.k) + "\u041f\u0435\u0440\u0441\u043e\u043d\u0430\u043b\u044c\u043d\u044b\u0439 \u043f\u0440\u0435\u0434\u043c\u0435\u0442");
        }
    }
}

