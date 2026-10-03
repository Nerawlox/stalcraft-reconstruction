/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ho
 *  kg
 *  ki
 */
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class kl
extends ki {
    private boolean g;
    private Socket h;
    private byte[] i = new byte[1460];
    private String j;

    kl(ho par1IServer, Socket par2Socket) {
        super(par1IServer);
        this.h = par2Socket;
        try {
            this.h.setSoTimeout(0);
        }
        catch (Exception var4) {
            this.a = false;
        }
        this.j = par1IServer.a("rcon.password", "");
        this.b("Rcon connection from: " + par2Socket.getInetAddress());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        try {
            block14: while (this.a) {
                BufferedInputStream bufferedinputstream = new BufferedInputStream(this.h.getInputStream());
                int i2 = bufferedinputstream.read(this.i, 0, 1460);
                if (10 > i2) {
                    return;
                }
                int b0 = 0;
                int j2 = kg.b((byte[])this.i, (int)0, (int)i2);
                if (j2 != i2 - 4) continue;
                int k2 = b0 + 4;
                int l2 = kg.b((byte[])this.i, (int)k2, (int)i2);
                int i1 = kg.b((byte[])this.i, (int)(k2 += 4));
                k2 += 4;
                switch (i1) {
                    case 2: {
                        if (this.g) {
                            String s2 = kg.a((byte[])this.i, (int)k2, (int)i2);
                            try {
                                this.a(l2, this.b.g(s2));
                            }
                            catch (Exception exception) {
                                this.a(l2, "Error executing: " + s2 + " (" + exception.getMessage() + ")");
                            }
                            continue block14;
                        }
                        this.f();
                        continue block14;
                    }
                    case 3: {
                        String s1 = kg.a((byte[])this.i, (int)k2, (int)i2);
                        int j1 = k2 + s1.length();
                        if (0 != s1.length() && s1.equals(this.j)) {
                            this.g = true;
                            this.a(l2, 2, "");
                            continue block14;
                        }
                        this.g = false;
                        this.f();
                        continue block14;
                    }
                }
                this.a(l2, String.format("Unknown request %s", Integer.toHexString(i1)));
            }
        }
        catch (SocketTimeoutException bufferedinputstream) {
        }
        catch (IOException bufferedinputstream) {
        }
        catch (Exception exception1) {
            System.out.println(exception1);
        }
        finally {
            this.g();
        }
    }

    private void a(int par1, int par2, String par3Str) throws IOException {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(1248);
        DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
        byte[] abyte = par3Str.getBytes("UTF-8");
        dataoutputstream.writeInt(Integer.reverseBytes(abyte.length + 10));
        dataoutputstream.writeInt(Integer.reverseBytes(par1));
        dataoutputstream.writeInt(Integer.reverseBytes(par2));
        dataoutputstream.write(abyte);
        dataoutputstream.write(0);
        dataoutputstream.write(0);
        this.h.getOutputStream().write(bytearrayoutputstream.toByteArray());
    }

    private void f() throws IOException {
        this.a(-1, 2, "");
    }

    private void a(int par1, String par2Str) throws IOException {
        int k2;
        int j2 = par2Str.length();
        do {
            k2 = 4096 <= j2 ? 4096 : j2;
            this.a(par1, 0, par2Str.substring(0, k2));
        } while (0 != (j2 = (par2Str = par2Str.substring(k2)).length()));
    }

    private void g() {
        if (null != this.h) {
            try {
                this.h.close();
            }
            catch (IOException ioexception) {
                this.c("IO: " + ioexception.getMessage());
            }
            this.h = null;
        }
    }
}

