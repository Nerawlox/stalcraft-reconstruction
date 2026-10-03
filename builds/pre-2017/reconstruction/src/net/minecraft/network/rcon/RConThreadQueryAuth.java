/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.rcon;

import java.net.DatagramPacket;
import java.util.Date;
import java.util.Random;
import net.minecraft.network.rcon.RConThreadQuery;

public class RConThreadQueryAuth {
    public long _a = new Date().getTime();
    public int _b;
    public byte[] _c;
    public byte[] _d;
    public String _e;
    public final /* synthetic */ RConThreadQuery _f;

    public RConThreadQueryAuth(RConThreadQuery rConThreadQuery, DatagramPacket datagramPacket) {
        this._f = rConThreadQuery;
        byte[] byArray = datagramPacket.getData();
        this._c = new byte[4];
        this._c[0] = byArray[3];
        this._c[1] = byArray[4];
        this._c[2] = byArray[5];
        this._c[3] = byArray[6];
        this._e = new String(this._c);
        this._b = new Random().nextInt(0x1000000);
        this._d = String.format("\t%s%d\u0000", this._e, this._b).getBytes();
    }

    public Boolean _a(long l) {
        return this._a < l;
    }

    public int _a() {
        return this._b;
    }

    public byte[] _b() {
        return this._d;
    }

    public byte[] _c() {
        return this._c;
    }
}

