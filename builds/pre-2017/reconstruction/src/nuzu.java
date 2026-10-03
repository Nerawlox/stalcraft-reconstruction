/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.minecraftforge.client.GuiControlsScrollPanel;

@SideOnly(value=Side.CLIENT)
public class nuzu
extends GuiScreen {
    public GuiScreen _a;
    public String _b = "Controls";
    public GameSettings _c;
    public int _d = -1;
    public GuiControlsScrollPanel _e;

    public nuzu(GuiScreen guiScreen, GameSettings gameSettings) {
        this._a = guiScreen;
        this._c = gameSettings;
    }

    public int _a() {
        return this.width / 2 - 155;
    }

    @Override
    public void initGui() {
        this._e = new GuiControlsScrollPanel(this, this._c, this.mc);
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height - 28, wpcz._a("gui.done")));
        this._e.registerScrollButtons(7, 8);
        this._b = wpcz._a("controls.title");
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 200) {
            this.mc._a(this._a);
        }
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
    }

    @Override
    public void keyTyped(char c, int n) {
        if (this._e.keyTyped(c, n)) {
            super.keyTyped(c, n);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this._e.drawScreen(n, n2, f);
        this.drawCenteredString(this.fontRenderer, this._b, this.width / 2, 4, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }
}

