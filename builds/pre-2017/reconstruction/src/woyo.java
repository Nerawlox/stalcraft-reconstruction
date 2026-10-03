/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import net.minecraft.client.gui.GuiSlotServer;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.EnumChatFormatting;

public class woyo
extends Thread {
    public final /* synthetic */ ServerData _a;
    public final /* synthetic */ GuiSlotServer _b;

    public woyo(GuiSlotServer guiSlotServer, ServerData serverData) {
        this._b = guiSlotServer;
        this._a = serverData;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        try {
            this._a._d = (Object)((Object)EnumChatFormatting._i) + "Polling..";
            long l = System.nanoTime();
            gqju._c(this._a);
            long l2 = System.nanoTime();
            this._a._e = (l2 - l) / 1000000L;
        }
        catch (UnknownHostException unknownHostException) {
            this._a._e = -1L;
            this._a._d = (Object)((Object)EnumChatFormatting._e) + "Can't resolve hostname";
        }
        catch (SocketTimeoutException socketTimeoutException) {
            this._a._e = -1L;
            this._a._d = (Object)((Object)EnumChatFormatting._e) + "Can't reach server";
        }
        catch (ConnectException connectException) {
            this._a._e = -1L;
            this._a._d = (Object)((Object)EnumChatFormatting._e) + "Can't reach server";
        }
        catch (IOException iOException) {
            this._a._e = -1L;
            this._a._d = (Object)((Object)EnumChatFormatting._e) + "Communication error";
        }
        catch (Exception exception) {
            this._a._e = -1L;
            this._a._d = "ERROR: " + exception.getClass();
        }
        finally {
            Object object = gqju._b();
            synchronized (object) {
                gqju._e();
            }
        }
    }
}

