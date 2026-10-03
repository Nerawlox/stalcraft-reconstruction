/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.McoServer;
import org.lwjgl.input.Keyboard;

public class GuiScreenSubscription
extends GuiScreen {
    public final GuiScreen _a;
    public final McoServer _b;
    public final int _c = 0;
    public final int _d = 1;
    public int _e;
    public String _f;

    public GuiScreenSubscription(GuiScreen guiScreen, McoServer mcoServer) {
        this._a = guiScreen;
        this._b = mcoServer;
    }

    @Override
    public void updateScreen() {
    }

    @Override
    public void initGui() {
        this._a(this._b._a);
        Keyboard.enableRepeatEvents(true);
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120 + 12, wpcz._a("gui.cancel")));
    }

    public void _a(long l) {
        rqmi rqmi2 = new rqmi(this.mc._P());
        try {
            nedg nedg2 = rqmi2._g(l);
            this._e = nedg2._b;
            this._f = this._b(nedg2._a);
        }
        catch (ExceptionMcoService exceptionMcoService) {
            Minecraft._E()._O()._c(exceptionMcoService.toString());
        }
        catch (IOException iOException) {
            Minecraft._E()._O()._b("Realms: could not parse response");
        }
    }

    public String _b(long l) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getDefault());
        gregorianCalendar.setTimeInMillis(l);
        return SimpleDateFormat.getDateTimeInstance().format(gregorianCalendar.getTime());
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (!guiButton.enabled) {
            return;
        }
        if (guiButton.id == 0) {
            this.mc._a(this._a);
        } else if (guiButton.id == 1) {
            // empty if block
        }
    }

    @Override
    public void keyTyped(char c, int n) {
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        super.mouseClicked(n, n2, n3);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, wpcz._a("mco.configure.world.subscription.title"), this.width / 2, 17, 0xFFFFFF);
        this.drawString(this.fontRenderer, wpcz._a("mco.configure.world.subscription.start"), this.width / 2 - 100, 53, 0xA0A0A0);
        this.drawString(this.fontRenderer, this._f, this.width / 2 - 100, 66, 0xFFFFFF);
        this.drawString(this.fontRenderer, wpcz._a("mco.configure.world.subscription.daysleft"), this.width / 2 - 100, 85, 0xA0A0A0);
        this.drawString(this.fontRenderer, String.valueOf(this._e), this.width / 2 - 100, 98, 0xFFFFFF);
        super.drawScreen(n, n2, f);
    }
}

