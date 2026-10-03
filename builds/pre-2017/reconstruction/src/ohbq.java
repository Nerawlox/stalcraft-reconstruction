/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.LinkedList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraftforge.common.AchievementPage;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class ohbq
extends GuiScreen {
    public static final int _a = AchievementList._a * 24 - 112;
    public static final int _b = AchievementList._b * 24 - 112;
    public static final int _c = AchievementList._c * 24 - 77;
    public static final int _d = AchievementList._d * 24 - 77;
    public static final ResourceLocation _e = new ResourceLocation("textures/gui/achievement/achievement_background.png");
    public int _f = 256;
    public int _g = 202;
    public int _h;
    public int _i;
    public double _j;
    public double _k;
    public double _l;
    public double _m;
    public double _n;
    public double _o;
    public int _p;
    public StatFileWriter _q;
    public int _r = -1;
    public baxz _s;
    public LinkedList<Achievement> _t = new LinkedList();

    public ohbq(StatFileWriter statFileWriter) {
        this._q = statFileWriter;
        int n = 141;
        int n2 = 141;
        this._l = this._n = (double)(AchievementList._f.displayColumn * 24 - n / 2 - 12);
        this._j = this._n;
        this._m = this._o = (double)(AchievementList._f.displayRow * 24 - n2 / 2);
        this._k = this._o;
        this._t.clear();
        for (Object e : AchievementList._e) {
            if (AchievementPage.isAchievementInPages((Achievement)e)) continue;
            this._t.add((Achievement)e);
        }
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new baxz(1, this.width / 2 + 24, this.height / 2 + 74, 80, 20, wpcz._a("gui.done")));
        this._s = new baxz(2, (this.width - this._f) / 2 + 24, this.height / 2 + 74, 125, 20, AchievementPage.getTitle(this._r));
        this.buttonList.add(this._s);
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 1) {
            this.mc._a((GuiScreen)null);
            this.mc._o();
        }
        if (guiButton.id == 2) {
            ++this._r;
            if (this._r >= AchievementPage.getAchievementPages().size()) {
                this._r = -1;
            }
            this._s.displayString = AchievementPage.getTitle(this._r);
        }
        super.actionPerformed(guiButton);
    }

    @Override
    public void keyTyped(char c, int n) {
        if (n == this.mc._M.keyBindInventory._d) {
            this.mc._a((GuiScreen)null);
            this.mc._o();
        } else {
            super.keyTyped(c, n);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        if (Mouse.isButtonDown(0)) {
            int n3 = (this.width - this._f) / 2;
            int n4 = (this.height - this._g) / 2;
            int n5 = n3 + 8;
            int n6 = n4 + 17;
            if ((this._p == 0 || this._p == 1) && n >= n5 && n < n5 + 224 && n2 >= n6 && n2 < n6 + 155) {
                if (this._p == 0) {
                    this._p = 1;
                } else {
                    this._l -= (double)(n - this._h);
                    this._m -= (double)(n2 - this._i);
                    this._n = this._j = this._l;
                    this._o = this._k = this._m;
                }
                this._h = n;
                this._i = n2;
            }
            if (this._n < (double)_a) {
                this._n = _a;
            }
            if (this._o < (double)_b) {
                this._o = _b;
            }
            if (this._n >= (double)_c) {
                this._n = _c - 1;
            }
            if (this._o >= (double)_d) {
                this._o = _d - 1;
            }
        } else {
            this._p = 0;
        }
        this.drawDefaultBackground();
        this._a(n, n2, f);
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        this._a();
        GL11.glEnable(2896);
        GL11.glEnable(2929);
    }

    @Override
    public void updateScreen() {
        this._j = this._l;
        this._k = this._m;
        double d = this._n - this._l;
        double d2 = this._o - this._m;
        if (d * d + d2 * d2 < 4.0) {
            this._l += d;
            this._m += d2;
        } else {
            this._l += d * 0.85;
            this._m += d2 * 0.85;
        }
    }

    public void _a() {
        int n = (this.width - this._f) / 2;
        int n2 = (this.height - this._g) / 2;
        this.fontRenderer._b("Achievements", n + 15, n2 + 5, 0x404040);
    }

    public void _a(int n, int n2, float f) {
        Object object;
        int n3;
        int n4;
        int n5;
        Object object2;
        int n6;
        int n7;
        int n8 = sajh._c(this._j + (this._l - this._j) * (double)f);
        int n9 = sajh._c(this._k + (this._m - this._k) * (double)f);
        if (n8 < _a) {
            n8 = _a;
        }
        if (n9 < _b) {
            n9 = _b;
        }
        if (n8 >= _c) {
            n8 = _c - 1;
        }
        if (n9 >= _d) {
            n9 = _d - 1;
        }
        int n10 = (this.width - this._f) / 2;
        int n11 = (this.height - this._g) / 2;
        int n12 = n10 + 16;
        int n13 = n11 + 17;
        this.zLevel = 0.0f;
        GL11.glDepthFunc(518);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, 0.0f, -200.0f);
        GL11.glEnable(3553);
        GL11.glDisable(2896);
        GL11.glEnable(32826);
        GL11.glEnable(2903);
        int n14 = n8 + 288 >> 4;
        int n15 = n9 + 288 >> 4;
        int n16 = (n8 + 288) % 16;
        int n17 = (n9 + 288) % 16;
        boolean bl = true;
        boolean bl2 = true;
        boolean bl3 = true;
        boolean bl4 = true;
        boolean bl5 = true;
        Random random = new Random();
        int n18 = 0;
        while (n18 * 16 - n17 < 155) {
            float f2 = 0.6f - (float)(n15 + n18) / 25.0f * 0.3f;
            GL11.glColor4f(f2, f2, f2, 1.0f);
            n7 = 0;
            while (n7 * 16 - n16 < 224) {
                random.setSeed(1234 + n14 + n7);
                random.nextInt();
                n6 = random.nextInt(1 + n15 + n18) + (n15 + n18) / 2;
                Icon icon = Block.sand.getIcon(0, 0);
                if (n6 <= 37 && n15 + n18 != 35) {
                    if (n6 == 22) {
                        icon = random.nextInt(2) == 0 ? Block.oreDiamond.getIcon(0, 0) : Block.oreRedstone.getIcon(0, 0);
                    } else if (n6 == 10) {
                        icon = Block.oreIron.getIcon(0, 0);
                    } else if (n6 == 8) {
                        icon = Block.oreCoal.getIcon(0, 0);
                    } else if (n6 > 4) {
                        icon = Block.stone.getIcon(0, 0);
                    } else if (n6 > 0) {
                        icon = Block.dirt.getIcon(0, 0);
                    }
                } else {
                    icon = Block.bedrock.getIcon(0, 0);
                }
                this.mc._R()._a(sctd._c);
                this.drawTexturedModelRectFromIcon(n12 + n7 * 16 - n16, n13 + n18 * 16 - n17, icon, 16, 16);
                ++n7;
            }
            ++n18;
        }
        GL11.glEnable(2929);
        GL11.glDepthFunc(515);
        GL11.glDisable(3553);
        LinkedList<Achievement> linkedList = this._r == -1 ? this._t : AchievementPage.getAchievementPage(this._r).getAchievements();
        for (n18 = 0; n18 < linkedList.size(); ++n18) {
            object2 = (Achievement)linkedList.get(n18);
            if (((Achievement)object2).parentAchievement == null || !linkedList.contains(((Achievement)object2).parentAchievement)) continue;
            n7 = ((Achievement)object2).displayColumn * 24 - n8 + 11 + n12;
            n6 = ((Achievement)object2).displayRow * 24 - n9 + 11 + n13;
            n5 = ((Achievement)object2).parentAchievement.displayColumn * 24 - n8 + 11 + n12;
            int n19 = ((Achievement)object2).parentAchievement.displayRow * 24 - n9 + 11 + n13;
            boolean bl6 = this._q._a((Achievement)object2);
            n4 = this._q._b((Achievement)object2);
            int n20 = Math.sin((double)(Minecraft._M() % 600L) / 600.0 * Math.PI * 2.0) > 0.6 ? 255 : 130;
            n3 = -16777216;
            if (bl6) {
                n3 = -9408400;
            } else if (n4 != 0) {
                n3 = 65280 + (n20 << 24);
            }
            this.drawHorizontalLine(n7, n5, n6, n3);
            this.drawVerticalLine(n5, n6, n19, n3);
        }
        object2 = null;
        RenderItem renderItem = new RenderItem();
        qnon._c();
        GL11.glDisable(2896);
        GL11.glEnable(32826);
        GL11.glEnable(2903);
        for (n7 = 0; n7 < AchievementList._e.size(); ++n7) {
            float f3;
            object = (Achievement)AchievementList._e.get(n7);
            n5 = ((Achievement)object).displayColumn * 24 - n8;
            int n21 = ((Achievement)object).displayRow * 24 - n9;
            if (n5 < -24 || n21 < -24 || n5 > 224 || n21 > 155) continue;
            if (this._q._a((Achievement)object)) {
                f3 = 1.0f;
                GL11.glColor4f(f3, f3, f3, 1.0f);
            } else if (this._q._b((Achievement)object)) {
                f3 = Math.sin((double)(Minecraft._M() % 600L) / 600.0 * Math.PI * 2.0) < 0.6 ? 0.6f : 0.8f;
                GL11.glColor4f(f3, f3, f3, 1.0f);
            } else {
                f3 = 0.3f;
                GL11.glColor4f(f3, f3, f3, 1.0f);
            }
            this.mc._R()._a(_e);
            n4 = n12 + n5;
            n3 = n13 + n21;
            if (((Achievement)object).getSpecial()) {
                this.drawTexturedModalRect(n4 - 2, n3 - 2, 26, 202, 26, 26);
            } else {
                this.drawTexturedModalRect(n4 - 2, n3 - 2, 0, 202, 26, 26);
            }
            if (!this._q._b((Achievement)object)) {
                float f4 = 0.1f;
                GL11.glColor4f(f4, f4, f4, 1.0f);
                renderItem.renderWithColor = false;
            }
            GL11.glEnable(2896);
            GL11.glEnable(2884);
            renderItem.renderItemAndEffectIntoGUI(this.mc._z, this.mc._R(), ((Achievement)object).theItemStack, n4 + 3, n3 + 3);
            GL11.glDisable(2896);
            if (!this._q._b((Achievement)object)) {
                renderItem.renderWithColor = true;
            }
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            if (n < n12 || n2 < n13 || n >= n12 + 224 || n2 >= n13 + 155 || n < n4 || n > n4 + 22 || n2 < n3 || n2 > n3 + 22) continue;
            object2 = object;
        }
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._R()._a(_e);
        this.drawTexturedModalRect(n10, n11, 0, 0, this._f, this._g);
        GL11.glPopMatrix();
        this.zLevel = 0.0f;
        GL11.glDepthFunc(515);
        GL11.glDisable(2929);
        GL11.glEnable(3553);
        super.drawScreen(n, n2, f);
        if (object2 != null) {
            object = wpcz._a(((StatBase)object2).getName());
            String string = ((Achievement)object2).getDescription();
            n5 = n + 12;
            int n22 = n2 - 4;
            if (this._q._b((Achievement)object2)) {
                n4 = Math.max(this.fontRenderer._b((String)object), 120);
                n3 = this.fontRenderer._b(string, n4);
                if (this._q._a((Achievement)object2)) {
                    n3 += 12;
                }
                this.drawGradientRect(n5 - 3, n22 - 3, n5 + n4 + 3, n22 + n3 + 3 + 12, -1073741824, -1073741824);
                this.fontRenderer._a(string, n5, n22 + 12, n4, -6250336);
                if (this._q._a((Achievement)object2)) {
                    this.fontRenderer._a(wpcz._a("achievement.taken"), n5, n22 + n3 + 4, -7302913);
                }
            } else {
                n4 = Math.max(this.fontRenderer._b((String)object), 120);
                String string2 = wpcz._a("achievement.requires", wpcz._a(((Achievement)object2).parentAchievement.getName()));
                int n23 = this.fontRenderer._b(string2, n4);
                this.drawGradientRect(n5 - 3, n22 - 3, n5 + n4 + 3, n22 + n23 + 12 + 3, -1073741824, -1073741824);
                this.fontRenderer._a(string2, n5, n22 + 12, n4, -9416624);
            }
            this.fontRenderer._a((String)object, n5, n22, this._q._b((Achievement)object2) ? (((Achievement)object2).getSpecial() ? -128 : -1) : (((Achievement)object2).getSpecial() ? -8355776 : -8355712));
        }
        GL11.glEnable(2929);
        GL11.glEnable(2896);
        qnon._a();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return true;
    }
}

