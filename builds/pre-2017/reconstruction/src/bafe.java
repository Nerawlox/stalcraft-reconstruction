/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyLoadingPlugin;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.screens.GuiModMainOptions;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import paulscode.sound.SoundSystem;

public class bafe
extends fngq {
    private static ResourceLocation _A = new ResourceLocation("stalker", "textures/gui/mainmenu/background_layer_0.png");
    private static ResourceLocation _B = new ResourceLocation("stalker", "textures/gui/mainmenu/background_layer_1.png");
    private static ResourceLocation _C = new ResourceLocation("stalker", "textures/gui/mainmenu/background_layer_2.png");
    private static ResourceLocation _D = new ResourceLocation("stalker", "textures/gui/mainmenu/navigation.png");
    private List<ydgy> _E = new ArrayList<ydgy>();
    public static String _a = "MenuMusic";
    private static Dimension _F = new Dimension(850, 80);
    private boolean _G = false;
    private long _H = 0L;

    public static void _a() {
        Minecraft minecraft = Minecraft._E();
        jzqf jzqf2 = minecraft._N;
        SoundSystem soundSystem = jzqf2._c;
        xavs xavs2 = jzqf2._g._c("stalker:mainmenu_ambient");
        if (xavs2 != null) {
            soundSystem.newStreamingSource(false, _a, xavs2._b(), xavs2._a(), false, 0.0f, 0.0f, 0.0f, 0, 0.0f);
            soundSystem.setVolume(_a, Math.min(0.1f, minecraft._M.musicVolume));
            soundSystem.play(_a);
        }
    }

    @Override
    public void initGui() {
        this.mc._M.guiScale = 2;
        htou htou2 = new htou(this.mc._M, this.mc._n, this.mc._o);
        this.width = htou2._a();
        this.height = htou2._b();
        this.buttonList.clear();
        this._E.clear();
        for (int i = 0; i < 4; ++i) {
            ydgy ydgy2 = new ydgy(i, this, new Point(this.width - 850, 100 + i * 87), _F, new Point(174, 61 + i * 81), new Point(174, 403 + i * 81), _D);
            this._E.add(ydgy2);
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        SoundSystem soundSystem = Minecraft._E()._N._c;
        if (!this._G && soundSystem != null) {
            if (!soundSystem.playing(_a)) {
                bafe._a();
            }
            this._G = true;
        }
        ++this._H;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glClear(16384);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        float f2 = (float)(Math.sin((float)this._H / 10.0f) * 2.0);
        this._a(_A, n, n2, 2.2f);
        GL11.glTranslatef(0.0f, f2, 0.0f);
        this._a(_B, n, n2, 3.0f);
        GL11.glTranslatef(0.0f, -f2, 0.0f);
        this._a(_C, n, n2, 8.0f);
        for (ydgy ydgy2 : this._E) {
            ydgy2._a(n, n2);
        }
        GL11.glDisable(3042);
        GL11.glEnable(3008);
    }

    private void _a(ResourceLocation resourceLocation, int n, int n2, float f) {
        float f2;
        float f3;
        this.mc._h._a(resourceLocation);
        if (Minecraft._E()._B == this) {
            f3 = -((float)n / (float)this.width - 0.5f) * 2.0f * f;
            f2 = -((float)n2 / (float)this.height - 0.5f) * 2.0f * f;
        } else {
            f3 = 0.0f;
            f2 = 0.0f;
        }
        double d = 0.0;
        double d2 = 0.0;
        double d3 = 1.0;
        double d4 = 1.0;
        double d5 = (double)this.width / (double)this.height;
        double d6 = 1.7777777777777777;
        if (d5 > d6) {
            d2 = (1.0 - d6 / d5) / 2.0;
            d4 = 1.0 - (1.0 - d6 / d5) / 2.0;
        } else if (d6 > d5) {
            d = (1.0 - d5 / d6) / 2.0;
            d3 = 1.0 - (1.0 - d5 / d6) / 2.0;
        }
        int n3 = (int)(2.0f * f);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(f3 - (float)n3, (float)this.height + f2 + (float)n3, this.zLevel, d, d4);
        tessellator.addVertexWithUV((float)this.width + f3 + (float)n3, (float)this.height + f2 + (float)n3, this.zLevel, d3, d4);
        tessellator.addVertexWithUV((float)this.width + f3 + (float)n3, f2 - (float)n3, this.zLevel, d3, d2);
        tessellator.addVertexWithUV(f3 - (float)n3, f2 - (float)n3, this.zLevel, d, d2);
        tessellator.draw();
    }

    @Override
    public void keyTyped(char c, int n) {
        super.keyTyped(c, n);
        if (GloomyLoadingPlugin._a && n == 50) {
            this.mc._a(new gqju(this));
        }
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        for (ydgy ydgy2 : this._E) {
            ydgy2._a(n, n2, n3);
        }
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
    }

    public void _a(ydgy ydgy2) {
        if (ydgy2._a == 0) {
            if (GloomyLoadingPlugin._a) {
                this.mc._a(new fnfu(this));
            } else {
                this._e();
            }
        } else if (ydgy2._a == 1) {
            this.mc._a(new GuiModMainOptions(this));
        } else if (ydgy2._a == 2) {
            try {
                Class<?> clazz = Class.forName("java.awt.Desktop");
                Object object = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                clazz.getMethod("browse", URI.class).invoke(object, new URI("https://stalcraft.ru"));
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } else if (ydgy2._a == 3) {
            this.mc._n();
        }
    }

    private void _e() {
        new Runnable(){

            @Override
            public void run() {
                Minecraft minecraft = Minecraft._E();
                minecraft._a(new ivbz(bafe.this, false));
            }
        }.run();
    }
}

