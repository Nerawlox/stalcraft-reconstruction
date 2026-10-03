/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Color;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.kjui;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.FoodStats;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.eifc;
import net.minecraft.util.sajh;
import net.minecraft.util.ugqx;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.ForgeHooks;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class GuiIngame
extends Gui {
    public static final ResourceLocation vignetteTexPath = new ResourceLocation("textures/misc/vignette.png");
    public static final ResourceLocation widgetsTexPath = new ResourceLocation("textures/gui/widgets.png");
    public static final ResourceLocation pumpkinBlurTexPath = new ResourceLocation("textures/misc/pumpkinblur.png");
    public static final RenderItem itemRenderer = new RenderItem();
    public final Random rand = new Random();
    public final Minecraft mc;
    public final GuiNewChat persistantChatGUI;
    public int updateCounter;
    public String recordPlaying = "";
    public int recordPlayingUpFor;
    public boolean recordIsPlaying;
    public float prevVignetteBrightness = 1.0f;
    public int remainingHighlightTicks;
    public ItemStack highlightingItemStack;

    public GuiIngame(Minecraft minecraft) {
        this.mc = minecraft;
        this.persistantChatGUI = new GuiNewChat(minecraft);
    }

    public void renderGameOverlay(float f, boolean bl, int n, int n2) {
        ScoreObjective scoreObjective;
        Object object;
        int n3;
        int n4;
        int n5;
        String string;
        int n6;
        int n7;
        int n8;
        Object object2;
        int n9;
        int n10;
        float f2;
        int n11;
        int n12;
        float f3;
        htou htou2 = new htou(this.mc._M, this.mc._n, this.mc._o);
        int n13 = htou2._a();
        int n14 = htou2._b();
        FontRenderer fontRenderer = this.mc._z;
        this.mc._D.setupOverlayRendering();
        GL11.glEnable(3042);
        if (Minecraft._B()) {
            this.renderVignette(this.mc._t.getBrightness(f), n13, n14);
        } else {
            GL11.glBlendFunc(770, 771);
        }
        ItemStack itemStack = this.mc._t.inventory._e(3);
        if (this.mc._M.thirdPersonView == 0 && itemStack != null && itemStack._a() != null) {
            if (itemStack._d == Block.pumpkin.blockID) {
                this.renderPumpkinBlur(n13, n14);
            } else {
                itemStack._a().renderHelmetOverlay(itemStack, this.mc._t, htou2, f, bl, n, n2);
            }
        }
        if (!this.mc._t.isPotionActive(Potion._k) && (f3 = this.mc._t.prevTimeInPortal + (this.mc._t.timeInPortal - this.mc._t.prevTimeInPortal) * f) > 0.0f) {
            this.func_130015_b(f3, n13, n14);
        }
        if (!this.mc._j._a()) {
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc._R()._a(widgetsTexPath);
            InventoryPlayer inventoryPlayer = this.mc._t.inventory;
            this.zLevel = -90.0f;
            this.drawTexturedModalRect(n13 / 2 - 91, n14 - 22, 0, 0, 182, 22);
            this.drawTexturedModalRect(n13 / 2 - 91 - 1 + inventoryPlayer._c * 20, n14 - 22 - 1, 0, 22, 24, 22);
            this.mc._R()._a(icons);
            GL11.glEnable(3042);
            GL11.glBlendFunc(775, 769);
            this.drawTexturedModalRect(n13 / 2 - 7, n14 / 2 - 7, 0, 0, 16, 16);
            GL11.glDisable(3042);
            this.mc.__ah._a("bossHealth");
            this.renderBossHealth();
            this.mc.__ah._b();
            if (this.mc._j._b()) {
                this.func_110327_a(n13, n14);
            }
            GL11.glDisable(3042);
            this.mc.__ah._a("actionBar");
            GL11.glEnable(32826);
            qnon._c();
            for (int i = 0; i < 9; ++i) {
                n12 = n13 / 2 - 90 + i * 20 + 2;
                n11 = n14 - 16 - 3;
                this.renderInventorySlot(i, n12, n11, f);
            }
            qnon._a();
            GL11.glDisable(32826);
            this.mc.__ah._b();
        }
        if (this.mc._t.getSleepTimer() > 0) {
            this.mc.__ah._a("sleep");
            GL11.glDisable(2929);
            GL11.glDisable(3008);
            int n15 = this.mc._t.getSleepTimer();
            float f4 = (float)n15 / 100.0f;
            if (f4 > 1.0f) {
                f4 = 1.0f - (float)(n15 - 100) / 10.0f;
            }
            n12 = (int)(220.0f * f4) << 24 | 0x101020;
            GuiIngame.drawRect(0, 0, n13, n14, n12);
            GL11.glEnable(3008);
            GL11.glEnable(2929);
            this.mc.__ah._b();
        }
        int n16 = 0xFFFFFF;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        int n17 = n13 / 2 - 91;
        if (this.mc._t.isRidingHorse()) {
            this.mc.__ah._a("jumpBar");
            this.mc._R()._a(Gui.icons);
            f2 = this.mc._t.getHorseJumpPower();
            n10 = 182;
            int n18 = (int)(f2 * (float)(n10 + 1));
            n9 = n14 - 32 + 3;
            this.drawTexturedModalRect(n17, n9, 0, 84, n10, 5);
            if (n18 > 0) {
                this.drawTexturedModalRect(n17, n9, 0, 89, n18, 5);
            }
            this.mc.__ah._b();
        } else if (this.mc._j._g()) {
            this.mc.__ah._a("expBar");
            this.mc._R()._a(Gui.icons);
            n12 = this.mc._t.xpBarCap();
            if (n12 > 0) {
                n10 = 182;
                int n19 = (int)(this.mc._t.experience * (float)(n10 + 1));
                n9 = n14 - 32 + 3;
                this.drawTexturedModalRect(n17, n9, 0, 64, n10, 5);
                if (n19 > 0) {
                    this.drawTexturedModalRect(n17, n9, 0, 69, n19, 5);
                }
            }
            this.mc.__ah._b();
            if (this.mc._t.experienceLevel > 0) {
                this.mc.__ah._a("expLevel");
                boolean bl2 = false;
                int n20 = bl2 ? 0xFFFFFF : 8453920;
                object2 = "" + this.mc._t.experienceLevel;
                n8 = (n13 - fontRenderer._b((String)object2)) / 2;
                n7 = n14 - 31 - 4;
                n6 = 0;
                fontRenderer._b((String)object2, n8 + 1, n7, 0);
                fontRenderer._b((String)object2, n8 - 1, n7, 0);
                fontRenderer._b((String)object2, n8, n7 + 1, 0);
                fontRenderer._b((String)object2, n8, n7 - 1, 0);
                fontRenderer._b((String)object2, n8, n7, n20);
                this.mc.__ah._b();
            }
        }
        if (this.mc._M.heldItemTooltips) {
            this.mc.__ah._a("toolHighlight");
            if (this.remainingHighlightTicks > 0 && this.highlightingItemStack != null) {
                String string2 = this.highlightingItemStack._s();
                n11 = (n13 - fontRenderer._b(string2)) / 2;
                int n21 = n14 - 59;
                if (!this.mc._j._b()) {
                    n21 += 14;
                }
                if ((n9 = (int)((float)this.remainingHighlightTicks * 256.0f / 10.0f)) > 255) {
                    n9 = 255;
                }
                if (n9 > 0) {
                    GL11.glPushMatrix();
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(770, 771);
                    fontRenderer._a(string2, n11, n21, 0xFFFFFF + (n9 << 24));
                    object2 = this.highlightingItemStack._a().getFontRenderer(this.highlightingItemStack);
                    if (object2 != null) {
                        n11 = (n13 - ((FontRenderer)object2)._b(string2)) / 2;
                        ((FontRenderer)object2)._a(string2, n11, n21, 0xFFFFFF + (n9 << 24));
                    } else {
                        fontRenderer._a(string2, n11, n21, 0xFFFFFF + (n9 << 24));
                    }
                    GL11.glDisable(3042);
                    GL11.glPopMatrix();
                }
            }
            this.mc.__ah._b();
        }
        if (this.mc._y()) {
            this.mc.__ah._a("demo");
            String string3 = "";
            string3 = this.mc._r.getTotalWorldTime() >= 120500L ? wpcz._a("demo.demoExpired") : wpcz._a("demo.remainingTime", eifc._a((int)(120500L - this.mc._r.getTotalWorldTime())));
            n11 = fontRenderer._b(string3);
            fontRenderer._a(string3, n13 - n11 - 10, 5, 0xFFFFFF);
            this.mc.__ah._b();
        }
        if (this.mc._M.showDebugInfo) {
            this.mc.__ah._a("debug");
            GL11.glPushMatrix();
            fontRenderer._a("Minecraft 1.6.4 (" + this.mc.__aq + ")", 2, 2, 0xFFFFFF);
            fontRenderer._a(this.mc._u(), 2, 12, 0xFFFFFF);
            fontRenderer._a(this.mc._v(), 2, 22, 0xFFFFFF);
            fontRenderer._a(this.mc._x(), 2, 32, 0xFFFFFF);
            fontRenderer._a(this.mc._w(), 2, 42, 0xFFFFFF);
            long l = Runtime.getRuntime().maxMemory();
            long l2 = Runtime.getRuntime().totalMemory();
            long l3 = Runtime.getRuntime().freeMemory();
            long l4 = l2 - l3;
            string = "Used memory: " + l4 * 100L / l + "% (" + l4 / 1024L / 1024L + "MB) of " + l / 1024L / 1024L + "MB";
            int n22 = 0xE0E0E0;
            this.drawString(fontRenderer, string, n13 - fontRenderer._b(string) - 2, 2, 0xE0E0E0);
            string = "Allocated memory: " + l2 * 100L / l + "% (" + l2 / 1024L / 1024L + "MB)";
            this.drawString(fontRenderer, string, n13 - fontRenderer._b(string) - 2, 12, 0xE0E0E0);
            n6 = sajh._c(this.mc._t.posX);
            n5 = sajh._c(this.mc._t.posY);
            n4 = sajh._c(this.mc._t.posZ);
            this.drawString(fontRenderer, String.format("x: %.5f (%d) // c: %d (%d)", this.mc._t.posX, n6, n6 >> 4, n6 & 0xF), 2, 64, 0xE0E0E0);
            this.drawString(fontRenderer, String.format("y: %.3f (feet pos, %.3f eyes pos)", this.mc._t.boundingBox._c, this.mc._t.posY), 2, 72, 0xE0E0E0);
            this.drawString(fontRenderer, String.format("z: %.5f (%d) // c: %d (%d)", this.mc._t.posZ, n4, n4 >> 4, n4 & 0xF), 2, 80, 0xE0E0E0);
            n3 = sajh._c((double)(this.mc._t.rotationYaw * 4.0f / 360.0f) + 0.5) & 3;
            this.drawString(fontRenderer, "f: " + n3 + " (" + ugqx._c[n3] + ") / " + sajh._g(this.mc._t.rotationYaw), 2, 88, 0xE0E0E0);
            if (this.mc._r != null && this.mc._r.blockExists(n6, n5, n4)) {
                object = this.mc._r.getChunkFromBlockCoords(n6, n4);
                this.drawString(fontRenderer, "lc: " + (((Chunk)object)._a() + 15) + " b: " + ((Chunk)object)._a((int)(n6 & 0xF), (int)(n4 & 0xF), (WorldChunkManager)this.mc._r.getWorldChunkManager())._y + " bl: " + ((Chunk)object)._a(EnumSkyBlock._b, n6 & 0xF, n5, n4 & 0xF) + " sl: " + ((Chunk)object)._a(EnumSkyBlock._a, n6 & 0xF, n5, n4 & 0xF) + " rl: " + ((Chunk)object)._c(n6 & 0xF, n5, n4 & 0xF, 0), 2, 96, 0xE0E0E0);
            }
            this.drawString(fontRenderer, String.format("ws: %.3f, fs: %.3f, g: %b, fl: %d", Float.valueOf(this.mc._t.capabilities._b()), Float.valueOf(this.mc._t.capabilities._a()), this.mc._t.onGround, this.mc._r.getHeightValue(n6, n4)), 2, 104, 0xE0E0E0);
            GL11.glPopMatrix();
            this.mc.__ah._b();
        }
        if (this.recordPlayingUpFor > 0) {
            this.mc.__ah._a("overlayMessage");
            f2 = (float)this.recordPlayingUpFor - f;
            n11 = (int)(f2 * 255.0f / 20.0f);
            if (n11 > 255) {
                n11 = 255;
            }
            if (n11 > 8) {
                GL11.glPushMatrix();
                GL11.glTranslatef(n13 / 2, n14 - 68, 0.0f);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                int n23 = 0xFFFFFF;
                if (this.recordIsPlaying) {
                    n23 = Color.HSBtoRGB(f2 / 50.0f, 0.7f, 0.6f) & 0xFFFFFF;
                }
                fontRenderer._b(this.recordPlaying, -fontRenderer._b(this.recordPlaying) / 2, -4, n23 + (n11 << 24 & 0xFF000000));
                GL11.glDisable(3042);
                GL11.glPopMatrix();
            }
            this.mc.__ah._b();
        }
        if ((scoreObjective = this.mc._r.getScoreboard()._a(1)) != null) {
            this.func_96136_a(scoreObjective, n14, n13, fontRenderer);
        }
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, n14 - 48, 0.0f);
        this.mc.__ah._a("chat");
        this.persistantChatGUI._a(this.updateCounter);
        this.mc.__ah._b();
        GL11.glPopMatrix();
        scoreObjective = this.mc._r.getScoreboard()._a(0);
        if (this.mc._M.keyBindPlayerList._e && (!this.mc._H() || this.mc._t.sendQueue._i.size() > 1 || scoreObjective != null)) {
            this.mc.__ah._a("playerList");
            bscn bscn2 = this.mc._t.sendQueue;
            List list2 = bscn2._i;
            n8 = n9 = bscn2._j;
            n7 = 1;
            while (n8 > 20) {
                n8 = (n9 + ++n7 - 1) / n7;
            }
            int n24 = 300 / n7;
            if (n24 > 150) {
                n24 = 150;
            }
            int n25 = (n13 - n7 * n24) / 2;
            int n26 = 10;
            GuiIngame.drawRect(n25 - 1, n26 - 1, n25 + n24 * n7, n26 + 9 * n8, Integer.MIN_VALUE);
            for (int i = 0; i < n9; ++i) {
                n6 = n25 + i % n7 * n24;
                n5 = n26 + i / n7 * 9;
                GuiIngame.drawRect(n6, n5, n6 + n24 - 1, n5 + 8, 0x20FFFFFF);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glEnable(3008);
                if (i >= list2.size()) continue;
                maza maza2 = (maza)list2.get(i);
                ScorePlayerTeam scorePlayerTeam = this.mc._r.getScoreboard()._g(maza2._a);
                string = ScorePlayerTeam._a(scorePlayerTeam, maza2._a);
                fontRenderer._a(string, n6, n5, 0xFFFFFF);
                if (scoreObjective != null && (n3 = n6 + n24 - 12 - 5) - (n4 = n6 + fontRenderer._b(string) + 5) > 5) {
                    object = scoreObjective._a()._a(maza2._a, scoreObjective);
                    String string4 = (Object)((Object)EnumChatFormatting._o) + "" + ((Score)object)._b();
                    fontRenderer._a(string4, n3 - fontRenderer._b(string4), n5, 0xFFFFFF);
                }
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                this.mc._R()._a(icons);
                n4 = 0;
                n3 = 0;
                int n27 = maza2._c < 0 ? 5 : (maza2._c < 150 ? 0 : (maza2._c < 300 ? 1 : (maza2._c < 600 ? 2 : (maza2._c < 1000 ? 3 : 4))));
                this.zLevel += 100.0f;
                this.drawTexturedModalRect(n6 + n24 - 12, n5, 0 + n4 * 10, 176 + n27 * 8, 10, 8);
                this.zLevel -= 100.0f;
            }
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(2896);
        GL11.glEnable(3008);
    }

    public void func_96136_a(ScoreObjective scoreObjective, int n, int n2, FontRenderer fontRenderer) {
        Scoreboard scoreboard = scoreObjective._a();
        Collection collection = scoreboard._a(scoreObjective);
        if (collection.size() <= 15) {
            int n3 = fontRenderer._b(scoreObjective._d());
            for (Score score : collection) {
                ScorePlayerTeam scorePlayerTeam = scoreboard._g(score._d());
                String string = ScorePlayerTeam._a(scorePlayerTeam, score._d()) + ": " + (Object)((Object)EnumChatFormatting._m) + score._b();
                n3 = Math.max(n3, fontRenderer._b(string));
            }
            int n4 = collection.size() * fontRenderer._c;
            int n5 = n / 2 + n4 / 3;
            int n6 = 3;
            int n7 = n2 - n3 - n6;
            int n8 = 0;
            for (Score score : collection) {
                ScorePlayerTeam scorePlayerTeam = scoreboard._g(score._d());
                String string = ScorePlayerTeam._a(scorePlayerTeam, score._d());
                String string2 = (Object)((Object)EnumChatFormatting._m) + "" + score._b();
                int n9 = n5 - ++n8 * fontRenderer._c;
                int n10 = n2 - n6 + 2;
                GuiIngame.drawRect(n7 - 2, n9, n10, n9 + fontRenderer._c, 0x50000000);
                fontRenderer._b(string, n7, n9, 0x20FFFFFF);
                fontRenderer._b(string2, n10 - fontRenderer._b(string2), n9, 0x20FFFFFF);
                if (n8 != collection.size()) continue;
                String string3 = scoreObjective._d();
                GuiIngame.drawRect(n7 - 2, n9 - fontRenderer._c - 1, n10, n9 - 1, 0x60000000);
                GuiIngame.drawRect(n7 - 2, n9 - 1, n10, n9, 0x50000000);
                fontRenderer._b(string3, n7 + n3 / 2 - fontRenderer._b(string3) / 2, n9 - fontRenderer._c, 0x20FFFFFF);
            }
        }
    }

    public void func_110327_a(int n, int n2) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        boolean bl;
        boolean bl2 = bl = this.mc._t.hurtResistantTime / 3 % 2 == 1;
        if (this.mc._t.hurtResistantTime < 10) {
            bl = false;
        }
        int n9 = sajh._f(this.mc._t.getHealth());
        int n10 = sajh._f(this.mc._t.prevHealth);
        this.rand.setSeed(this.updateCounter * 312871);
        boolean bl3 = false;
        FoodStats foodStats = this.mc._t.getFoodStats();
        int n11 = foodStats._a();
        int n12 = foodStats._b();
        hubf hubf2 = this.mc._t.getEntityAttribute(sajz._a);
        int n13 = n / 2 - 91;
        int n14 = n / 2 + 91;
        int n15 = n2 - 39;
        float f = (float)hubf2._e();
        float f2 = this.mc._t.getAbsorptionAmount();
        int n16 = sajh._f((f + f2) / 2.0f / 10.0f);
        int n17 = Math.max(10 - (n16 - 2), 3);
        int n18 = n15 - (n16 - 1) * n17 - 10;
        float f3 = f2;
        int n19 = ForgeHooks.getTotalArmorValue(this.mc._t);
        int n20 = -1;
        if (this.mc._t.isPotionActive(Potion._l)) {
            n20 = this.updateCounter % sajh._f(f + 5.0f);
        }
        this.mc.__ah._a("armor");
        for (n8 = 0; n8 < 10; ++n8) {
            if (n19 <= 0) continue;
            n7 = n13 + n8 * 8;
            if (n8 * 2 + 1 < n19) {
                this.drawTexturedModalRect(n7, n18, 34, 9, 9, 9);
            }
            if (n8 * 2 + 1 == n19) {
                this.drawTexturedModalRect(n7, n18, 25, 9, 9, 9);
            }
            if (n8 * 2 + 1 <= n19) continue;
            this.drawTexturedModalRect(n7, n18, 16, 9, 9, 9);
        }
        this.mc.__ah._c("health");
        for (n8 = sajh._f((f + f2) / 2.0f) - 1; n8 >= 0; --n8) {
            n7 = 16;
            if (this.mc._t.isPotionActive(Potion._u)) {
                n7 += 36;
            } else if (this.mc._t.isPotionActive(Potion._v)) {
                n7 += 72;
            }
            int n21 = 0;
            if (bl) {
                n21 = 1;
            }
            n6 = sajh._f((float)(n8 + 1) / 10.0f) - 1;
            n5 = n13 + n8 % 10 * 8;
            n4 = n15 - n6 * n17;
            if (n9 <= 4) {
                n4 += this.rand.nextInt(2);
            }
            if (n8 == n20) {
                n4 -= 2;
            }
            n3 = 0;
            if (this.mc._r.getWorldInfo()._t()) {
                n3 = 5;
            }
            this.drawTexturedModalRect(n5, n4, 16 + n21 * 9, 9 * n3, 9, 9);
            if (bl) {
                if (n8 * 2 + 1 < n10) {
                    this.drawTexturedModalRect(n5, n4, n7 + 54, 9 * n3, 9, 9);
                }
                if (n8 * 2 + 1 == n10) {
                    this.drawTexturedModalRect(n5, n4, n7 + 63, 9 * n3, 9, 9);
                }
            }
            if (f3 > 0.0f) {
                if (f3 == f2 && f2 % 2.0f == 1.0f) {
                    this.drawTexturedModalRect(n5, n4, n7 + 153, 9 * n3, 9, 9);
                } else {
                    this.drawTexturedModalRect(n5, n4, n7 + 144, 9 * n3, 9, 9);
                }
                f3 -= 2.0f;
                continue;
            }
            if (n8 * 2 + 1 < n9) {
                this.drawTexturedModalRect(n5, n4, n7 + 36, 9 * n3, 9, 9);
            }
            if (n8 * 2 + 1 != n9) continue;
            this.drawTexturedModalRect(n5, n4, n7 + 45, 9 * n3, 9, 9);
        }
        Entity entity = this.mc._t.ridingEntity;
        if (entity == null) {
            this.mc.__ah._c("food");
            for (n7 = 0; n7 < 10; ++n7) {
                n3 = n15;
                n6 = 16;
                int n22 = 0;
                if (this.mc._t.isPotionActive(Potion._s)) {
                    n6 += 36;
                    n22 = 13;
                }
                if (this.mc._t.getFoodStats()._d() <= 0.0f && this.updateCounter % (n11 * 3 + 1) == 0) {
                    n3 = n15 + (this.rand.nextInt(3) - 1);
                }
                if (bl3) {
                    n22 = 1;
                }
                n4 = n14 - n7 * 8 - 9;
                this.drawTexturedModalRect(n4, n3, 16 + n22 * 9, 27, 9, 9);
                if (bl3) {
                    if (n7 * 2 + 1 < n12) {
                        this.drawTexturedModalRect(n4, n3, n6 + 54, 27, 9, 9);
                    }
                    if (n7 * 2 + 1 == n12) {
                        this.drawTexturedModalRect(n4, n3, n6 + 63, 27, 9, 9);
                    }
                }
                if (n7 * 2 + 1 < n11) {
                    this.drawTexturedModalRect(n4, n3, n6 + 36, 27, 9, 9);
                }
                if (n7 * 2 + 1 != n11) continue;
                this.drawTexturedModalRect(n4, n3, n6 + 45, 27, 9, 9);
            }
        } else if (entity instanceof EntityLivingBase) {
            this.mc.__ah._c("mountHealth");
            EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
            n3 = (int)Math.ceil(entityLivingBase.getHealth());
            float f4 = entityLivingBase.getMaxHealth();
            n5 = (int)(f4 + 0.5f) / 2;
            if (n5 > 30) {
                n5 = 30;
            }
            n4 = n15;
            int n23 = 0;
            while (n5 > 0) {
                int n24 = Math.min(n5, 10);
                n5 -= n24;
                for (int i = 0; i < n24; ++i) {
                    int n25 = 52;
                    int n26 = 0;
                    if (bl3) {
                        n26 = 1;
                    }
                    int n27 = n14 - i * 8 - 9;
                    this.drawTexturedModalRect(n27, n4, n25 + n26 * 9, 9, 9, 9);
                    if (i * 2 + 1 + n23 < n3) {
                        this.drawTexturedModalRect(n27, n4, n25 + 36, 9, 9, 9);
                    }
                    if (i * 2 + 1 + n23 != n3) continue;
                    this.drawTexturedModalRect(n27, n4, n25 + 45, 9, 9, 9);
                }
                n4 -= 10;
                n23 += 20;
            }
        }
        this.mc.__ah._c("air");
        if (this.mc._t.isInsideOfMaterial(Material._h)) {
            n7 = this.mc._t.getAir();
            n3 = sajh._e((double)(n7 - 2) * 10.0 / 300.0);
            n6 = sajh._e((double)n7 * 10.0 / 300.0) - n3;
            for (n5 = 0; n5 < n3 + n6; ++n5) {
                if (n5 < n3) {
                    this.drawTexturedModalRect(n14 - n5 * 8 - 9, n18, 16, 18, 9, 9);
                    continue;
                }
                this.drawTexturedModalRect(n14 - n5 * 8 - 9, n18, 25, 18, 9, 9);
            }
        }
        this.mc.__ah._b();
    }

    public void renderBossHealth() {
        if (kjui._c != null && kjui._b > 0) {
            --kjui._b;
            FontRenderer fontRenderer = this.mc._z;
            htou htou2 = new htou(this.mc._M, this.mc._n, this.mc._o);
            int n = htou2._a();
            int n2 = 182;
            int n3 = n / 2 - n2 / 2;
            int n4 = (int)(kjui._a * (float)(n2 + 1));
            int n5 = 12;
            this.drawTexturedModalRect(n3, n5, 0, 74, n2, 5);
            this.drawTexturedModalRect(n3, n5, 0, 74, n2, 5);
            if (n4 > 0) {
                this.drawTexturedModalRect(n3, n5, 0, 79, n4, 5);
            }
            String string = kjui._c;
            fontRenderer._a(string, n / 2 - fontRenderer._b(string) / 2, n5 - 10, 0xFFFFFF);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc._R()._a(icons);
        }
    }

    public void renderPumpkinBlur(int n, int n2) {
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3008);
        this.mc._R()._a(pumpkinBlurTexPath);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0, n2, -90.0, 0.0, 1.0);
        tessellator.addVertexWithUV(n, n2, -90.0, 1.0, 1.0);
        tessellator.addVertexWithUV(n, 0.0, -90.0, 1.0, 0.0);
        tessellator.addVertexWithUV(0.0, 0.0, -90.0, 0.0, 0.0);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public void renderVignette(float f, int n, int n2) {
        if ((f = 1.0f - f) < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.prevVignetteBrightness = (float)((double)this.prevVignetteBrightness + (double)(f - this.prevVignetteBrightness) * 0.01);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(0, 769);
        GL11.glColor4f(this.prevVignetteBrightness, this.prevVignetteBrightness, this.prevVignetteBrightness, 1.0f);
        this.mc._R()._a(vignetteTexPath);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0, n2, -90.0, 0.0, 1.0);
        tessellator.addVertexWithUV(n, n2, -90.0, 1.0, 1.0);
        tessellator.addVertexWithUV(n, 0.0, -90.0, 1.0, 0.0);
        tessellator.addVertexWithUV(0.0, 0.0, -90.0, 0.0, 0.0);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glBlendFunc(770, 771);
    }

    public void func_130015_b(float f, int n, int n2) {
        if (f < 1.0f) {
            f *= f;
            f *= f;
            f = f * 0.8f + 0.2f;
        }
        GL11.glDisable(3008);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, f);
        Icon icon = Block.portal.getBlockTextureFromSide(1);
        this.mc._R()._a(sctd._c);
        float f2 = icon.getMinU();
        float f3 = icon.getMinV();
        float f4 = icon.getMaxU();
        float f5 = icon.getMaxV();
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0, n2, -90.0, f2, f5);
        tessellator.addVertexWithUV(n, n2, -90.0, f4, f5);
        tessellator.addVertexWithUV(n, 0.0, -90.0, f4, f3);
        tessellator.addVertexWithUV(0.0, 0.0, -90.0, f2, f3);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public void renderInventorySlot(int n, int n2, int n3, float f) {
        ItemStack itemStack = this.mc._t.inventory._a[n];
        if (itemStack != null) {
            float f2 = (float)itemStack._c - f;
            if (f2 > 0.0f) {
                GL11.glPushMatrix();
                float f3 = 1.0f + f2 / 5.0f;
                GL11.glTranslatef(n2 + 8, n3 + 12, 0.0f);
                GL11.glScalef(1.0f / f3, (f3 + 1.0f) / 2.0f, 1.0f);
                GL11.glTranslatef(-(n2 + 8), -(n3 + 12), 0.0f);
            }
            itemRenderer.renderItemAndEffectIntoGUI(this.mc._z, this.mc._R(), itemStack, n2, n3);
            if (f2 > 0.0f) {
                GL11.glPopMatrix();
            }
            itemRenderer.renderItemOverlayIntoGUI(this.mc._z, this.mc._R(), itemStack, n2, n3);
        }
    }

    public void updateTick() {
        if (this.recordPlayingUpFor > 0) {
            --this.recordPlayingUpFor;
        }
        ++this.updateCounter;
        if (this.mc._t != null) {
            ItemStack itemStack = this.mc._t.inventory._a();
            if (itemStack == null) {
                this.remainingHighlightTicks = 0;
            } else if (this.highlightingItemStack != null && itemStack._d == this.highlightingItemStack._d && ItemStack._a(itemStack, this.highlightingItemStack) && (itemStack._f() || itemStack._j() == this.highlightingItemStack._j())) {
                if (this.remainingHighlightTicks > 0) {
                    --this.remainingHighlightTicks;
                }
            } else {
                this.remainingHighlightTicks = 40;
            }
            this.highlightingItemStack = itemStack;
        }
    }

    public void setRecordPlayingMessage(String string) {
        this.func_110326_a("Now playing: " + string, true);
    }

    public void func_110326_a(String string, boolean bl) {
        this.recordPlaying = string;
        this.recordPlayingUpFor = 60;
        this.recordIsPlaying = bl;
    }

    public GuiNewChat getChatGUI() {
        return this.persistantChatGUI;
    }

    public int getUpdateCounter() {
        return this.updateCounter;
    }
}

