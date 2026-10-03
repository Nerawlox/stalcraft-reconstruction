/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  azb
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
class azc
extends Thread {
    final bak a;
    final azb b;

    azc(azb par1GuiSlotOnlineServerList, bak par2McoServer) {
        this.b = par1GuiSlotOnlineServerList;
        this.a = par2McoServer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        block57: {
            block58: {
                block59: {
                    block62: {
                        block60: {
                            boolean flag = false;
                            try {
                                flag = true;
                                if (!this.a.n) {
                                    this.a.n = true;
                                    this.a.p = -2L;
                                    this.a.m = "";
                                    ayz.k();
                                    long i = System.nanoTime();
                                    ayz.a(this.b.a, this.a);
                                    long j2 = System.nanoTime();
                                    this.a.p = (j2 - i) / 1000000L;
                                    flag = false;
                                } else if (this.a.o) {
                                    this.a.o = false;
                                    ayz.a(this.b.a, this.a);
                                    flag = false;
                                } else {
                                    flag = false;
                                }
                                break block57;
                            }
                            catch (UnknownHostException unknownhostexception) {
                                this.a.p = -1L;
                                flag = false;
                                break block58;
                            }
                            catch (SocketTimeoutException sockettimeoutexception) {
                                this.a.p = -1L;
                                flag = false;
                                break block59;
                            }
                            catch (ConnectException connectexception) {
                                this.a.p = -1L;
                                flag = false;
                                break block60;
                            }
                            catch (IOException ioexception) {
                                this.a.p = -1L;
                                flag = false;
                            }
                            catch (Exception exception) {
                                this.a.p = -1L;
                                flag = false;
                                break block62;
                            }
                            finally {
                                if (flag) {
                                    Object object = ayz.i();
                                    synchronized (object) {
                                        ayz.r();
                                    }
                                }
                            }
                            Object object = ayz.i();
                            synchronized (object) {
                                ayz.r();
                                return;
                            }
                        }
                        Object object = ayz.i();
                        synchronized (object) {
                            ayz.r();
                            return;
                        }
                    }
                    Object object = ayz.i();
                    synchronized (object) {
                        ayz.r();
                        return;
                    }
                }
                Object object = ayz.i();
                synchronized (object) {
                    ayz.r();
                    return;
                }
            }
            Object object = ayz.i();
            synchronized (object) {
                ayz.r();
                return;
            }
        }
        Object object = ayz.i();
        synchronized (object) {
            ayz.r();
        }
    }
}

