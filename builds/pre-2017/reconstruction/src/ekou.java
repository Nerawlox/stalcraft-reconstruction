/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.IOException;
import java.net.URI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.EnumOS;
import net.minecraft.util.ezhm;
import org.lwjgl.Sys;

public class ekou
extends GuiScreen {
    public GuiScreen _a;
    public int _b = -1;
    public gqva _c;
    public GameSettings _d;

    public ekou(GuiScreen guiScreen, GameSettings gameSettings) {
        this._a = guiScreen;
        this._d = gameSettings;
    }

    @Override
    public void initGui() {
        this.buttonList.add(new baxz(5, this.width / 2 - 154, this.height - 48, wpcz._a("resourcePack.openFolder")));
        this.buttonList.add(new baxz(6, this.width / 2 + 4, this.height - 48, wpcz._a("gui.done")));
        this._c = new gqva(this, this.mc._T());
        this._c.registerScrollButtons(7, 8);
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (!guiButton.enabled) {
            return;
        }
        if (guiButton.id == 5) {
            File file = gqva._a(this._c)._g();
            String string = file.getAbsolutePath();
            if (ezhm._a() == EnumOS._d) {
                try {
                    this.mc._O()._a(string);
                    Runtime.getRuntime().exec(new String[]{"/usr/bin/open", string});
                    return;
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            } else if (ezhm._a() == EnumOS._c) {
                String string2 = String.format("cmd.exe /C start \"Open file\" \"%s\"", string);
                try {
                    Runtime.getRuntime().exec(string2);
                    return;
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            boolean bl = false;
            try {
                Class<?> clazz = Class.forName("java.awt.Desktop");
                Object object = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                clazz.getMethod("browse", URI.class).invoke(object, file.toURI());
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
                bl = true;
            }
            if (bl) {
                this.mc._O()._a("Opening via system class!");
                Sys.openURL("file://" + string);
            }
        } else if (guiButton.id == 6) {
            this.mc._a(this._a);
        } else {
            this._c.actionPerformed(guiButton);
        }
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
    }

    @Override
    public void mouseMovedOrUp(int n, int n2, int n3) {
        super.mouseMovedOrUp(n, n2, n3);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this._c.drawScreen(n, n2, f);
        if (this._b <= 0) {
            gqva._a(this._c)._c();
            this._b = 20;
        }
        this.drawCenteredString(this.fontRenderer, wpcz._a("resourcePack.title"), this.width / 2, 16, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, wpcz._a("resourcePack.folderInfo"), this.width / 2 - 77, this.height - 26, 0x808080);
        super.drawScreen(n, n2, f);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        --this._b;
    }

    public static /* synthetic */ Minecraft _a(ekou ekou2) {
        return ekou2.mc;
    }

    public static /* synthetic */ Minecraft _b(ekou ekou2) {
        return ekou2.mc;
    }

    public static /* synthetic */ Minecraft _c(ekou ekou2) {
        return ekou2.mc;
    }

    public static /* synthetic */ Minecraft _d(ekou ekou2) {
        return ekou2.mc;
    }

    public static /* synthetic */ Minecraft _e(ekou ekou2) {
        return ekou2.mc;
    }

    public static /* synthetic */ Minecraft _f(ekou ekou2) {
        return ekou2.mc;
    }

    public static /* synthetic */ FontRenderer _g(ekou ekou2) {
        return ekou2.fontRenderer;
    }

    public static /* synthetic */ FontRenderer _h(ekou ekou2) {
        return ekou2.fontRenderer;
    }

    public static /* synthetic */ FontRenderer _i(ekou ekou2) {
        return ekou2.fontRenderer;
    }

    public static /* synthetic */ FontRenderer _j(ekou ekou2) {
        return ekou2.fontRenderer;
    }

    public static /* synthetic */ FontRenderer _k(ekou ekou2) {
        return ekou2.fontRenderer;
    }
}

