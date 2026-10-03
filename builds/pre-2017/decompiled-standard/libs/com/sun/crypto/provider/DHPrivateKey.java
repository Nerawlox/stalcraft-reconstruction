/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE_l;
import com.sun.crypto.provider.SunJCE_n;
import com.sun.crypto.provider.SunJCE_t;
import com.sun.crypto.provider.SunJCE_u;
import com.sun.crypto.provider.SunJCE_v;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.util.Arrays;
import javax.crypto.spec.DHParameterSpec;

class DHPrivateKey
implements PrivateKey,
javax.crypto.interfaces.DHPrivateKey,
Serializable {
    static final long serialVersionUID = 7565477590005668886L;
    private static final BigInteger PKCS8_VERSION = BigInteger.valueOf(0L);
    private BigInteger x;
    private byte[] key;
    private byte[] encodedKey;
    private BigInteger p;
    private BigInteger g;
    private int l;
    private int[] DH_data = new int[]{1, 2, 840, 113549, 1, 3, 1};

    public DHPrivateKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) throws InvalidKeyException {
        this(bigInteger, bigInteger2, bigInteger3, 0);
    }

    public DHPrivateKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int n) throws InvalidKeyException {
        this.x = bigInteger;
        this.p = bigInteger2;
        this.g = bigInteger3;
        this.l = n;
        try {
            this.key = new SunJCE_t(2, this.x.toByteArray()).w();
            this.encodedKey = this.getEncoded();
        }
        catch (IOException iOException) {
            throw new InvalidKeyException("Cannot produce ASN.1 encoding");
        }
    }

    public DHPrivateKey(byte[] byArray) throws InvalidKeyException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        try {
            SunJCE_t sunJCE_t = new SunJCE_t(byteArrayInputStream);
            if (sunJCE_t.e != 48) {
                throw new InvalidKeyException("Key not a SEQUENCE");
            }
            BigInteger bigInteger = sunJCE_t.g.c();
            if (!bigInteger.equals(PKCS8_VERSION)) {
                throw new IOException("version mismatch: (supported: " + PKCS8_VERSION + ", parsed: " + bigInteger);
            }
            SunJCE_t sunJCE_t2 = sunJCE_t.g.i();
            if (sunJCE_t2.e != 48) {
                throw new InvalidKeyException("AlgId is not a SEQUENCE");
            }
            SunJCE_n sunJCE_n = sunJCE_t2.x();
            SunJCE_v sunJCE_v = sunJCE_n.h();
            if (sunJCE_n.t() == 0) {
                throw new InvalidKeyException("Parameters missing");
            }
            SunJCE_t sunJCE_t3 = sunJCE_n.i();
            if (sunJCE_t3.e == 5) {
                throw new InvalidKeyException("Null parameters");
            }
            if (sunJCE_t3.e != 48) {
                throw new InvalidKeyException("Parameters not a SEQUENCE");
            }
            sunJCE_t3.g.s();
            this.p = sunJCE_t3.g.c();
            this.g = sunJCE_t3.g.c();
            if (sunJCE_t3.g.t() != 0) {
                this.l = sunJCE_t3.g.b();
            }
            if (sunJCE_t3.g.t() != 0) {
                throw new InvalidKeyException("Extra parameter data");
            }
            this.key = sunJCE_t.g.f();
            this.parseKeyBits();
            this.encodedKey = (byte[])byArray.clone();
        }
        catch (NumberFormatException numberFormatException) {
            throw new InvalidKeyException("Private-value length too big");
        }
        catch (IOException iOException) {
            throw new InvalidKeyException(iOException.toString());
        }
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public String getAlgorithm() {
        return "DH";
    }

    public synchronized byte[] getEncoded() {
        if (this.encodedKey == null) {
            try {
                SunJCE_l sunJCE_l = new SunJCE_l();
                sunJCE_l.a(PKCS8_VERSION);
                SunJCE_l sunJCE_l2 = new SunJCE_l();
                sunJCE_l2.a(new SunJCE_v(this.DH_data));
                SunJCE_l sunJCE_l3 = new SunJCE_l();
                sunJCE_l3.a(this.p);
                sunJCE_l3.a(this.g);
                if (this.l != 0) {
                    sunJCE_l3.b(this.l);
                }
                SunJCE_t sunJCE_t = new SunJCE_t(48, sunJCE_l3.toByteArray());
                sunJCE_l2.a(sunJCE_t);
                sunJCE_l.a((byte)48, sunJCE_l2);
                sunJCE_l.b(this.key);
                SunJCE_l sunJCE_l4 = new SunJCE_l();
                sunJCE_l4.a((byte)48, sunJCE_l);
                this.encodedKey = sunJCE_l4.toByteArray();
            }
            catch (IOException iOException) {
                return null;
            }
        }
        return (byte[])this.encodedKey.clone();
    }

    public BigInteger getX() {
        return this.x;
    }

    public DHParameterSpec getParams() {
        if (this.l != 0) {
            return new DHParameterSpec(this.p, this.g, this.l);
        }
        return new DHParameterSpec(this.p, this.g);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("SunJCE Diffie-Hellman Private Key:\nx:\n" + SunJCE_u.a(this.x) + "\n" + "p:\n" + SunJCE_u.a(this.p) + "\n" + "g:\n" + SunJCE_u.a(this.g));
        if (this.l != 0) {
            stringBuffer.append("\nl:\n    " + this.l);
        }
        return stringBuffer.toString();
    }

    private void parseKeyBits() throws InvalidKeyException {
        try {
            SunJCE_n sunJCE_n = new SunJCE_n(this.key);
            this.x = sunJCE_n.c();
        }
        catch (IOException iOException) {
            throw new InvalidKeyException(iOException.toString());
        }
    }

    public int hashCode() {
        int n = 0;
        byte[] byArray = this.getEncoded();
        int n2 = 1;
        while (n2 < byArray.length) {
            n += byArray[n2] * n2;
            ++n2;
        }
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PrivateKey)) {
            return false;
        }
        byte[] byArray = this.getEncoded();
        byte[] byArray2 = ((PrivateKey)object).getEncoded();
        return Arrays.equals(byArray, byArray2);
    }
}

