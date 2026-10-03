/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import java.net.ConnectException;
import java.net.UnknownHostException;
import net.minecraft.client.gui.GuiScreenDisconnectedOnline;
import net.minecraft.client.gui.TaskOnlineConnect;

public class ThreadOnlineConnect
extends Thread {
    public final /* synthetic */ String _a;
    public final /* synthetic */ int _b;
    public final /* synthetic */ TaskOnlineConnect _c;

    public ThreadOnlineConnect(TaskOnlineConnect taskOnlineConnect, String string, int n) {
        this._c = taskOnlineConnect;
        this._a = string;
        this._b = n;
    }

    @Override
    public void run() {
        try {
            TaskOnlineConnect._a(this._c, new bscn(this._c._a(), this._a, this._b, TaskOnlineConnect._a(this._c)));
            if (this._c._b()) {
                return;
            }
            this._c._b(wpcz._a("mco.connect.authorizing"));
            TaskOnlineConnect._b(this._c)._b(new yezn(78, this._c._a()._P()._a(), this._a, this._b));
        }
        catch (UnknownHostException unknownHostException) {
            if (this._c._b()) {
                return;
            }
            this._c._a()._a(new GuiScreenDisconnectedOnline(TaskOnlineConnect._a(this._c), "connect.failed", "disconnect.genericReason", "Unknown host '" + this._a + "'"));
        }
        catch (ConnectException connectException) {
            if (this._c._b()) {
                return;
            }
            this._c._a()._a(new GuiScreenDisconnectedOnline(TaskOnlineConnect._a(this._c), "connect.failed", "disconnect.genericReason", connectException.getMessage()));
        }
        catch (Exception exception) {
            if (this._c._b()) {
                return;
            }
            exception.printStackTrace();
            this._c._a()._a(new GuiScreenDisconnectedOnline(TaskOnlineConnect._a(this._c), "connect.failed", "disconnect.genericReason", exception.toString()));
        }
    }
}

