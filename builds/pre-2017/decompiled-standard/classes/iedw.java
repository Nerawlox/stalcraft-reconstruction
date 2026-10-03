/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollButton;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentScrollButtonStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentSliderBarStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;
import java.awt.Color;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class iedw {
    public static final ResourceLocation _a = new ResourceLocation("pda", "textures/gui/main_background.png");
    public static final ResourceLocation _b = new ResourceLocation("pda", "textures/gui/borders.png");
    public static final ComponentButtonStyle _c = new ComponentButtonStyle(){
        {
            this.setTexture(_a);
            this.setSize(12, 23);
            this.setDefaultUv(275, 952);
            this.setMouseOverUv(this.defaultUv);
            this.setActiveUv(this.defaultUv);
            this.borderSizeX = 1;
            this.borderSizeY = 1;
        }
    };
    public static final ComponentButtonStyle _d = new ComponentButtonStyle(){
        {
            this.setTexture(_a);
            this.setSize(12, 23);
            this.setDefaultUv(307, 952);
            this.setMouseOverUv(this.defaultUv);
            this.setActiveUv(this.defaultUv);
            this.borderSizeX = 1;
            this.borderSizeY = 1;
        }
    };
    public static Color _e = new Color(147, 147, 147, 255);
    public static final ComponentButtonStyle _f = new ComponentButtonStyle(){
        {
            this.visibleBackground = false;
            this.setFontColor(_e);
        }
    };
    public static final ComponentButtonStyle _g = new ComponentButtonStyle(){
        {
            this.setTexture(new ResourceLocation("pda", "textures/gui/list_bg.png"));
            this.setSize(20, 25);
            this.setDefaultUv(0, 0);
            this.setActiveUv(0, 320);
            this.setMouseOverUv(0, 640);
            this.setFontColor(_e);
        }
    };
    private static ComponentStyle.StyleStorage _m = new ComponentStyle.StyleStorage("pda");
    public static final ComponentStyle _h = _m.getComponentStyle(McLabel.class);
    public static final ComponentStyle _i = _m.getComponentStyle(McTextField.class);
    public static final ComponentSliderBarStyle _j = (ComponentSliderBarStyle)_m.getComponentStyle(McScrollBar.class);
    public static final ComponentScrollButtonStyle _k = (ComponentScrollButtonStyle)_m.getComponentStyle(McScrollButton.class);
    public static final ComponentButtonStyle _l = (ComponentButtonStyle)_m.getComponentStyle(McButton.class);

    public static void _a(GuiRenderer guiRenderer, Point point, Dimension dimension, boolean bl, boolean bl2) {
        GL11.glEnable(3042);
        xpzm._E()._R()._a(_a);
        if (bl2) {
            guiRenderer.drawTiledRect(point, new Point(128, 959), dimension, new Dimension(64, 64), 20);
        }
        if (bl) {
            guiRenderer.drawTiledRect(point.add(5, 5), new Point(64, 768), new Dimension(dimension.width - 18, 27), new Dimension(64, 27), 23, 0);
        }
        guiRenderer.drawTiledRect(point.add(dimension.width - 18, 20), new Point(24, 832), new Dimension(15, dimension.height - 30), new Dimension(15, 64), 2);
        guiRenderer.drawRect(point.add(10, 37), new Dimension(dimension.width - 35, 1), 0x64646464);
        guiRenderer.drawRect(point.add(10, dimension.height - 8), new Dimension(dimension.width - 35, 1), 0x64646464);
        xpzm._E()._R()._a(_b);
        guiRenderer.drawTiledRect(point.add(5, 35), new Point(0, 0), dimension.add(-25, -40), new Dimension(718, 450), 5, 0);
        GL11.glDisable(3042);
    }

    public static void _a(float f, float f2, int n) {
        xpzm._E()._R()._a(_a);
        GL11.glTranslatef(f, f2, 0.0f);
        GL11.glRotated(n, 0.0, 0.0, 1.0);
        float f3 = 0.5f;
        qozx._a(-10.0f * f3, -6.5 * (double)f3, 20.0f * f3, 13.0f * f3, 601.0, 770.0, 641.0, 796.0, 1024.0, 1024.0);
        GL11.glRotatef(-n, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-f, -f2, 0.0f);
    }
}

