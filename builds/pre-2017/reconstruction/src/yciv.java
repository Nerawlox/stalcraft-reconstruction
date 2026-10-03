/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class yciv {
    @NotNull
    private pzrd _j;
    @NotNull
    private Socket _k;
    @NotNull
    public final String _a;
    @NotNull
    public final String _b;
    @NotNull
    private DataInputStream _l;
    @NotNull
    private DataOutputStream _m;
    @NotNull
    bqiy _c;
    @NotNull
    pzqj _d;
    @NotNull
    public final Queue<ctih> _e;
    @NotNull
    public final List<ctih> _f;
    private volatile boolean _n;
    @Nullable
    private String _o;
    boolean _g;
    private int _p;
    @NotNull
    public Logger _h;
    public final boolean _i;

    public yciv(@NotNull pzrd pzrd2, @NotNull Socket socket, boolean bl, @NotNull Logger logger) throws IOException {
        if (pzrd2 == null) {
            yciv._a(0);
        }
        if (socket == null) {
            yciv._a(1);
        }
        if (logger == null) {
            yciv._a(2);
        }
        this._e = new ConcurrentLinkedQueue<ctih>();
        this._f = Collections.synchronizedList(new ArrayList());
        this._n = true;
        this._j = pzrd2;
        this._k = socket;
        this._h = logger;
        this._i = bl;
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        this._l = new DataInputStream(inputStream);
        this._m = new DataOutputStream(outputStream);
        this._a = socket.getInetAddress().getHostAddress();
        this._b = socket.getInetAddress().getHostAddress() + ":" + socket.getPort();
        try {
            socket.setSoTimeout(30000);
            socket.setTrafficClass(24);
        }
        catch (SocketException socketException) {
            logger.warning(socketException.getMessage());
        }
        this._c = new bqiy(this);
        this._d = new pzqj(this);
        this._c.start();
        this._d.start();
    }

    public void _a(@NotNull ctih ctih2) {
        if (ctih2 == null) {
            yciv._a(3);
        }
        if (!this._g) {
            this._f.add(ctih2);
        }
    }

    public void _a() {
        this._c.interrupt();
        this._d.interrupt();
    }

    public boolean _b() {
        block3: {
            if (!this._f.isEmpty()) {
                ctih ctih2 = this._f.remove(0);
                try {
                    sryv._a(ctih2, this._m);
                    this._m.flush();
                    return true;
                }
                catch (Exception exception) {
                    if (!this._n) break block3;
                    this._h.log(Level.SEVERE, "Got exception writing packet", exception);
                    this._b(exception.getMessage());
                }
            }
        }
        return false;
    }

    public void _c() {
        ctih ctih2;
        if (this._e.isEmpty()) {
            if (this._p++ >= 1200) {
                this._b("timeout");
            }
        } else {
            this._p = 0;
        }
        for (int i = 0; i < this._j._b() && (ctih2 = this._e.poll()) != null; ++i) {
            try {
                this._j._b(ctih2);
                continue;
            }
            catch (Exception exception) {
                this._h.log(Level.WARNING, "Can not process packet from " + this._j._c(), exception);
            }
        }
        this._a();
        if (!this._n && this._e.isEmpty()) {
            this._j._a(this._o);
        }
    }

    public boolean _d() {
        block8: {
            try {
                ctih ctih2 = sryv._a(this._l);
                if (!this._g) {
                    if (ctih2._a()) {
                        this._p = 0;
                        this._j._b(ctih2);
                    } else {
                        this._e.add(ctih2);
                    }
                }
            }
            catch (EOFException eOFException) {
                this._b("End of stream");
            }
            catch (SocketTimeoutException socketTimeoutException) {
                this._b("Socket timeout");
            }
            catch (SocketException socketException) {
                this._b(socketException.getMessage());
            }
            catch (Exception exception) {
                if (!this._n) break block8;
                this._h.log(Level.WARNING, "Can not read packet from " + this._b, exception);
                this._b(exception.getMessage());
            }
        }
        return false;
    }

    public boolean _e() {
        return this._n;
    }

    public boolean _f() {
        return this._g;
    }

    public void _a(String string) {
        if (!this._g) {
            this._h.fine("Requested delayed shutdown for " + this._b + ": " + string);
            this._g = true;
            this._a();
            new ownm(this, string).start();
        }
    }

    public void _b(String string) {
        if (this._n) {
            this._n = false;
            this._o = string;
            new srxy(this).start();
            try {
                this._l.close();
            }
            catch (IOException iOException) {
                // empty catch block
            }
            try {
                this._m.close();
            }
            catch (IOException iOException) {
                // empty catch block
            }
            try {
                this._k.close();
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
    }

    public void _a(@NotNull pzrd pzrd2) {
        if (pzrd2 == null) {
            yciv._a(4);
        }
        this._j = pzrd2;
    }

    @NotNull
    public pzrd _g() {
        pzrd pzrd2 = this._j;
        if (pzrd2 == null) {
            yciv._a(5);
        }
        return pzrd2;
    }

    @NotNull
    public String toString() {
        String string = this._b;
        if (string == null) {
            yciv._a(6);
        }
        return string;
    }

    private static /* synthetic */ void _a(int n) {
        RuntimeException runtimeException;
        Object[] objectArray;
        Object[] objectArray2;
        int n2;
        String string;
        switch (n) {
            default: {
                string = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
            }
            case 5: 
            case 6: {
                string = "@NotNull method %s.%s must not return null";
                break;
            }
        }
        switch (n) {
            default: {
                n2 = 3;
                break;
            }
            case 5: 
            case 6: {
                n2 = 2;
                break;
            }
        }
        Object[] objectArray3 = new Object[n2];
        switch (n) {
            default: {
                objectArray2 = objectArray3;
                objectArray3[0] = "networkHandler";
                break;
            }
            case 1: {
                objectArray2 = objectArray3;
                objectArray3[0] = "socket";
                break;
            }
            case 2: {
                objectArray2 = objectArray3;
                objectArray3[0] = "logger";
                break;
            }
            case 3: {
                objectArray2 = objectArray3;
                objectArray3[0] = "packet";
                break;
            }
            case 4: {
                objectArray2 = objectArray3;
                objectArray3[0] = "handler";
                break;
            }
            case 5: 
            case 6: {
                objectArray2 = objectArray3;
                objectArray3[0] = "gloomyfolken/core/network/TcpConnection";
                break;
            }
        }
        switch (n) {
            default: {
                objectArray = objectArray2;
                objectArray2[1] = "gloomyfolken/core/network/TcpConnection";
                break;
            }
            case 5: {
                objectArray = objectArray2;
                objectArray2[1] = "getNetworkHandler";
                break;
            }
            case 6: {
                objectArray = objectArray2;
                objectArray2[1] = "toString";
                break;
            }
        }
        switch (n) {
            default: {
                objectArray = objectArray;
                objectArray[2] = "<init>";
                break;
            }
            case 3: {
                objectArray = objectArray;
                objectArray[2] = "sendPacket";
                break;
            }
            case 4: {
                objectArray = objectArray;
                objectArray[2] = "setNetworkHandler";
                break;
            }
            case 5: 
            case 6: {
                break;
            }
        }
        String string2 = String.format(string, objectArray);
        switch (n) {
            default: {
                runtimeException = new IllegalArgumentException(string2);
                break;
            }
            case 5: 
            case 6: {
                runtimeException = new IllegalStateException(string2);
                break;
            }
        }
        throw runtimeException;
    }
}

