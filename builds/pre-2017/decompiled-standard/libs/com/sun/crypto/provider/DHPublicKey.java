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
import java.security.PublicKey;
import java.util.Arrays;
import javax.crypto.spec.DHParameterSpec;

class DHPublicKey
implements PublicKey,
javax.crypto.interfaces.DHPublicKey,
Serializable {
    static final long serialVersionUID = 7647557958927458271L;
    private BigInteger y;
    private byte[] key;
    private byte[] encodedKey;
    private BigInteger p;
    private BigInteger g;
    private int l;
    private int[] DH_data = new int[]{1, 2, 840, 113549, 1, 3, 1};

    public DHPublicKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) throws InvalidKeyException {
        this(bigInteger, bigInteger2, bigInteger3, 0);
    }

    public DHPublicKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int n) throws InvalidKeyException {
        this.y = bigInteger;
        this.p = bigInteger2;
        this.g = bigInteger3;
        this.l = n;
        try {
            this.key = new SunJCE_t(2, this.y.toByteArray()).w();
            this.encodedKey = this.getEncoded();
        }
        catch (IOException iOException) {
            throw new InvalidKeyException("Cannot produce ASN.1 encoding");
        }
    }

    public DHPublicKey(byte[] byArray) throws InvalidKeyException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        try {
            SunJCE_t sunJCE_t = new SunJCE_t(byteArrayInputStream);
            if (sunJCE_t.e != 48) {
                throw new InvalidKeyException("Invalid key format");
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
            this.key = sunJCE_t.g.e();
            this.parseKeyBits();
            if (sunJCE_t.g.t() != 0) {
                throw new InvalidKeyException("Excess key data");
            }
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
        return "X.509";
    }

    public String getAlgorithm() {
        return "DH";
    }

    public synchronized byte[] getEncoded() {
        if (this.encodedKey == null) {
            try {
                SunJCE_l sunJCE_l = new SunJCE_l();
                sunJCE_l.a(new SunJCE_v(this.DH_data));
                SunJCE_l sunJCE_l2 = new SunJCE_l();
                sunJCE_l2.a(this.p);
                sunJCE_l2.a(this.g);
                if (this.l != 0) {
                    sunJCE_l2.b(this.l);
                }
                SunJCE_t sunJCE_t = new SunJCE_t(48, sunJCE_l2.toByteArray());
                sunJCE_l.a(sunJCE_t);
                SunJCE_l sunJCE_l3 = new SunJCE_l();
                sunJCE_l3.a((byte)48, sunJCE_l);
                sunJCE_l3.a(this.key);
                SunJCE_l sunJCE_l4 = new SunJCE_l();
                sunJCE_l4.a((byte)48, sunJCE_l3);
                this.encodedKey = sunJCE_l4.toByteArray();
            }
            catch (IOException iOException) {
                return null;
            }
        }
        return (byte[])this.encodedKey.clone();
    }

    public BigInteger getY() {
        return this.y;
    }

    public DHParameterSpec getParams() {
        if (this.l != 0) {
            return new DHParameterSpec(this.p, this.g, this.l);
        }
        return new DHParameterSpec(this.p, this.g);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("SunJCE Diffie-Hellman Public Key:\ny:\n" + SunJCE_u.a(this.y) + "\n" + "p:\n" + SunJCE_u.a(this.p) + "\n" + "g:\n" + SunJCE_u.a(this.g));
        if (this.l != 0) {
            stringBuffer.append("\nl:\n    " + this.l);
        }
        return stringBuffer.toString();
    }

    private void parseKeyBits() throws InvalidKeyException {
        try {
            SunJCE_n sunJCE_n = new SunJCE_n(this.key);
            this.y = sunJCE_n.c();
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
        if (!(object instanceof PublicKey)) {
            return false;
        }
        byte[] byArray = this.getEncoded();
        byte[] byArray2 = ((PublicKey)object).getEncoded();
        return Arrays.equals(byArray, byArray2);
    }
}

