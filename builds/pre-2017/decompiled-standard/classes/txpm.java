/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class txpm
extends raia {
    public boolean _g;
    public Socket _h;
    public byte[] _i = new byte[1460];
    public String _j;

    public txpm(ziaf ziaf2, Socket socket) {
        super(ziaf2);
        this._h = socket;
        try {
            this._h.setSoTimeout(0);
        }
        catch (Exception exception) {
            this._a = false;
        }
        this._j = ziaf2._a("rcon.password", "");
        this._b("Rcon connection from: " + socket.getInetAddress());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        try {
            while (this._a) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(this._h.getInputStream());
                int n = bufferedInputStream.read(this._i, 0, 1460);
                if (10 > n) {
                    return;
                }
                int n2 = 0;
                int n3 = ywcd._b(this._i, 0, n);
                if (n3 != n - 4) {
                    return;
                }
                int n4 = ywcd._b(this._i, n2 += 4, n);
                int n5 = ywcd._a(this._i, n2 += 4);
                n2 += 4;
                switch (n5) {
                    case 3: {
                        String string = ywcd._a(this._i, n2, n);
                        n2 += string.length();
                        if (0 != string.length() && string.equals(this._j)) {
                            this._g = true;
                            this._a(n4, 2, "");
                            break;
                        }
                        this._g = false;
                        this._e();
                        break;
                    }
                    case 2: {
                        if (this._g) {
                            String string = ywcd._a(this._i, n2, n);
                            try {
                                this._a(n4, this._b._a(string));
                            }
                            catch (Exception exception) {
                                this._a(n4, "Error executing: " + string + " (" + exception.getMessage() + ")");
                            }
                            break;
                        }
                        this._e();
                        break;
                    }
                    default: {
                        this._a(n4, String.format("Unknown request %s", Integer.toHexString(n5)));
                    }
                }
            }
        }
        catch (SocketTimeoutException socketTimeoutException) {
        }
        catch (IOException iOException) {
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
        finally {
            this._f();
        }
    }

    public void _a(int n, int n2, String string) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1248);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        byte[] byArray = string.getBytes("UTF-8");
        dataOutputStream.writeInt(Integer.reverseBytes(byArray.length + 10));
        dataOutputStream.writeInt(Integer.reverseBytes(n));
        dataOutputStream.writeInt(Integer.reverseBytes(n2));
        dataOutputStream.write(byArray);
        dataOutputStream.write(0);
        dataOutputStream.write(0);
        this._h.getOutputStream().write(byteArrayOutputStream.toByteArray());
    }

    public void _e() {
        this._a(-1, 2, "");
    }

    public void _a(int n, String string) {
        int n2;
        int n3 = string.length();
        do {
            n2 = 4096 <= n3 ? 4096 : n3;
            this._a(n, 0, string.substring(0, n2));
        } while (0 != (n3 = (string = string.substring(n2)).length()));
    }

    public void _f() {
        if (null == this._h) {
            return;
        }
        try {
            this._h.close();
        }
        catch (IOException iOException) {
            this._c("IO: " + iOException.getMessage());
        }
        this._h = null;
    }
}

