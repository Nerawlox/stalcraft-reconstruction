/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.ServerAddress;
import net.minecraft.client.multiplayer.ServerData;

@SideOnly(value=Side.CLIENT)
public class fnnc
extends GuiScreen {
    public bscn _a;
    public boolean _b;
    public final GuiScreen _c;

    public fnnc(GuiScreen guiScreen, Minecraft minecraft, ServerData serverData) {
        this.mc = minecraft;
        this._c = guiScreen;
        ServerAddress serverAddress = ServerAddress._a(serverData._b);
        minecraft._a((pkix)null);
        minecraft._a(serverData);
        this._a(serverAddress._a(), serverAddress._b());
    }

    public fnnc(GuiScreen guiScreen, Minecraft minecraft, String string, int n) {
        this.mc = minecraft;
        this._c = guiScreen;
        minecraft._a((pkix)null);
        this._a(string, n);
    }

    public void _a(String string, int n) {
        this.mc._O()._a("Connecting to " + string + ", " + n);
        new dhgx(this, string, n).start();
    }

    @Override
    public void updateScreen() {
        if (this._a != null) {
            this._a._b();
        }
    }

    @Override
    public void keyTyped(char c, int n) {
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120 + 12, wpcz._a("gui.cancel")));
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 0) {
            this._b = true;
            if (this._a != null) {
                this._a._c();
            }
            this.mc._a(this._c);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        if (this._a == null) {
            this.drawCenteredString(this.fontRenderer, wpcz._a("connect.connecting"), this.width / 2, this.height / 2 - 50, 0xFFFFFF);
            this.drawCenteredString(this.fontRenderer, "", this.width / 2, this.height / 2 - 10, 0xFFFFFF);
        } else {
            this.drawCenteredString(this.fontRenderer, wpcz._a("connect.authorizing"), this.width / 2, this.height / 2 - 50, 0xFFFFFF);
            this.drawCenteredString(this.fontRenderer, this._a._c, this.width / 2, this.height / 2 - 10, 0xFFFFFF);
        }
        super.drawScreen(n, n2, f);
    }

    public static bscn _a(fnnc fnnc2, bscn bscn2) {
        fnnc2._a = bscn2;
        return fnnc2._a;
    }

    public static Minecraft _a(fnnc fnnc2) {
        return fnnc2.mc;
    }

    public static boolean _b(fnnc fnnc2) {
        return fnnc2._b;
    }

    public static Minecraft _c(fnnc fnnc2) {
        return fnnc2.mc;
    }

    public static bscn _d(fnnc fnnc2) {
        return fnnc2._a;
    }

    public static GuiScreen _e(fnnc fnnc2) {
        return fnnc2._c;
    }

    public static Minecraft _f(fnnc fnnc2) {
        return fnnc2.mc;
    }

    public static Minecraft _g(fnnc fnnc2) {
        return fnnc2.mc;
    }

    public static Minecraft _h(fnnc fnnc2) {
        return fnnc2.mc;
    }

    public static void _i(fnnc fnnc2) {
        fnnc2._b = true;
        fnnc2._a = null;
    }
}

