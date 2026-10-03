/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bdm
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

@SideOnly(value=Side.CLIENT)
class avp
extends Thread {
    final bdm a;
    final avo b;

    avp(avo par1GuiSlotServer, bdm par2ServerData) {
        this.b = par1GuiSlotServer;
        this.a = par2ServerData;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        block53: {
            block58: {
                block57: {
                    block56: {
                        block55: {
                            boolean flag = false;
                            try {
                                flag = true;
                                this.a.d = (Object)((Object)a.i) + "Polling..";
                                long i = System.nanoTime();
                                avn.a(this.a);
                                long j2 = System.nanoTime();
                                this.a.e = (j2 - i) / 1000000L;
                                flag = false;
                                break block53;
                            }
                            catch (UnknownHostException unknownhostexception) {
                                this.a.e = -1L;
                                this.a.d = (Object)((Object)a.e) + "Can't resolve hostname";
                                flag = false;
                            }
                            catch (SocketTimeoutException sockettimeoutexception) {
                                this.a.e = -1L;
                                this.a.d = (Object)((Object)a.e) + "Can't reach server";
                                flag = false;
                                break block55;
                            }
                            catch (ConnectException connectexception) {
                                this.a.e = -1L;
                                this.a.d = (Object)((Object)a.e) + "Can't reach server";
                                flag = false;
                                break block56;
                            }
                            catch (IOException ioexception) {
                                this.a.e = -1L;
                                this.a.d = (Object)((Object)a.e) + "Communication error";
                                flag = false;
                                break block57;
                            }
                            catch (Exception exception) {
                                this.a.e = -1L;
                                this.a.d = "ERROR: " + exception.getClass();
                                flag = false;
                                break block58;
                            }
                            finally {
                                if (flag) {
                                    Object unknownhostexception = avn.h();
                                    synchronized (unknownhostexception) {
                                        avn.k();
                                    }
                                }
                            }
                            Object object = avn.h();
                            synchronized (object) {
                                avn.k();
                                return;
                            }
                        }
                        Object object = avn.h();
                        synchronized (object) {
                            avn.k();
                            return;
                        }
                    }
                    Object object = avn.h();
                    synchronized (object) {
                        avn.k();
                        return;
                    }
                }
                Object object = avn.h();
                synchronized (object) {
                    avn.k();
                    return;
                }
            }
            Object object = avn.h();
            synchronized (object) {
                avn.k();
                return;
            }
        }
        Object object = avn.h();
        synchronized (object) {
            avn.k();
        }
    }
}

