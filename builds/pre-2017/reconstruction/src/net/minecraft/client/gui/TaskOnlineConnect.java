/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.TaskLongRunning;
import net.minecraft.client.gui.ThreadOnlineConnect;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.McoServer;
import net.minecraft.client.multiplayer.ServerAddress;

public class TaskOnlineConnect
extends TaskLongRunning {
    public bscn _b;
    public final McoServer _c;
    public final GuiScreen _d;

    public TaskOnlineConnect(GuiScreen guiScreen, McoServer mcoServer) {
        this._d = guiScreen;
        this._c = mcoServer;
    }

    @Override
    public void run() {
        this._b(wpcz._a("mco.connect.connecting"));
        rqmi rqmi2 = new rqmi(this._a()._P());
        boolean bl = false;
        boolean bl2 = false;
        int n = 5;
        vlwy vlwy2 = null;
        for (int i = 0; i < 10 && !this._b(); ++i) {
            try {
                vlwy2 = rqmi2._b(this._c._a);
                bl = true;
            }
            catch (dhdd dhdd2) {
                n = dhdd2._d;
            }
            catch (ExceptionMcoService exceptionMcoService) {
                bl2 = true;
                this._a(exceptionMcoService.toString());
                Minecraft._E()._O()._c(exceptionMcoService.toString());
                break;
            }
            catch (IOException iOException) {
                Minecraft._E()._O()._b("Realms: could not parse response");
            }
            catch (Exception exception) {
                bl2 = true;
                this._a(exception.getLocalizedMessage());
            }
            if (bl) break;
            this._a(n);
        }
        if (!this._b() && !bl2) {
            if (bl) {
                ServerAddress serverAddress = ServerAddress._a(vlwy2._a);
                this._a(serverAddress._a(), serverAddress._b());
            } else {
                this._a()._a(this._d);
            }
        }
    }

    public void _a(int n) {
        try {
            Thread.sleep(n * 1000);
        }
        catch (InterruptedException interruptedException) {
            Minecraft._E()._O()._b(interruptedException.getLocalizedMessage());
        }
    }

    public void _a(String string, int n) {
        new ThreadOnlineConnect(this, string, n).start();
    }

    @Override
    public void _c() {
        if (this._b != null) {
            this._b._b();
        }
    }

    public static /* synthetic */ bscn _a(TaskOnlineConnect taskOnlineConnect, bscn bscn2) {
        taskOnlineConnect._b = bscn2;
        return taskOnlineConnect._b;
    }

    public static /* synthetic */ GuiScreen _a(TaskOnlineConnect taskOnlineConnect) {
        return taskOnlineConnect._d;
    }

    public static /* synthetic */ bscn _b(TaskOnlineConnect taskOnlineConnect) {
        return taskOnlineConnect._b;
    }
}

