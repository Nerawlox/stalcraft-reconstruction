/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collections;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenConfirmation;
import net.minecraft.client.gui.GuiScreenLongRunningTask;
import net.minecraft.client.gui.mco.GuiScreenBackupRestoreTask;
import net.minecraft.client.gui.mco.GuiScreenBackupSelectionList;
import net.minecraft.client.mco.Backup;
import net.minecraft.client.mco.GuiScreenConfirmationType;
import org.lwjgl.input.Keyboard;

public class scox
extends GuiScreen {
    public final xaxz _a;
    public final long _b;
    public List _c = Collections.emptyList();
    public GuiScreenBackupSelectionList _d;
    public int _e = -1;
    public GuiButton _f;

    public scox(xaxz xaxz2, long l) {
        this._a = xaxz2;
        this._b = l;
    }

    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this._d = new GuiScreenBackupSelectionList(this);
        new nvcw(this).start();
        this._a();
    }

    public void _a() {
        this.buttonList.add(new GuiButton(0, this.width / 2 + 6, this.height - 52, 153, 20, wpcz._a("gui.back")));
        this._f = new GuiButton(1, this.width / 2 - 154, this.height - 52, 153, 20, wpcz._a("mco.backup.button.restore"));
        this.buttonList.add(this._f);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (!guiButton.enabled) {
            return;
        }
        if (guiButton.id == 1) {
            String string = wpcz._a("mco.configure.world.restore.question.line1");
            String string2 = wpcz._a("mco.configure.world.restore.question.line2");
            this.mc._a(new GuiScreenConfirmation(this, GuiScreenConfirmationType._a, string, string2, 1));
        } else if (guiButton.id == 0) {
            this.mc._a(this._a);
        } else {
            this._d._a(guiButton);
        }
    }

    @Override
    public void confirmClicked(boolean bl, int n) {
        if (bl && n == 1) {
            this._b();
        } else {
            this.mc._a(this);
        }
    }

    public void _b() {
        if (this._e >= 0 && this._e < this._c.size()) {
            Backup backup = (Backup)this._c.get(this._e);
            GuiScreenBackupRestoreTask guiScreenBackupRestoreTask = new GuiScreenBackupRestoreTask(this, backup, null);
            GuiScreenLongRunningTask guiScreenLongRunningTask = new GuiScreenLongRunningTask(this.mc, this._a, guiScreenBackupRestoreTask);
            guiScreenLongRunningTask._a();
            this.mc._a(guiScreenLongRunningTask);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this._d._a(n, n2, f);
        this.drawCenteredString(this.fontRenderer, wpcz._a("mco.backup.title"), this.width / 2, 20, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }

    public static /* synthetic */ Minecraft _a(scox scox2) {
        return scox2.mc;
    }

    public static /* synthetic */ List _a(scox scox2, List list2) {
        scox2._c = list2;
        return scox2._c;
    }

    public static /* synthetic */ long _b(scox scox2) {
        return scox2._b;
    }

    public static /* synthetic */ Minecraft _c(scox scox2) {
        return scox2.mc;
    }

    public static /* synthetic */ xaxz _d(scox scox2) {
        return scox2._a;
    }

    public static /* synthetic */ Minecraft _e(scox scox2) {
        return scox2.mc;
    }

    public static /* synthetic */ Minecraft _f(scox scox2) {
        return scox2.mc;
    }

    public static /* synthetic */ List _g(scox scox2) {
        return scox2._c;
    }

    public static /* synthetic */ int _a(scox scox2, int n) {
        scox2._e = n;
        return scox2._e;
    }

    public static /* synthetic */ int _h(scox scox2) {
        return scox2._e;
    }

    public static /* synthetic */ FontRenderer _i(scox scox2) {
        return scox2.fontRenderer;
    }

    public static /* synthetic */ FontRenderer _j(scox scox2) {
        return scox2.fontRenderer;
    }
}

