/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.tls.TlsFatalAlert;

public class ProtocolVersion {
    public static final ProtocolVersion SSLv3 = new ProtocolVersion(768);
    public static final ProtocolVersion TLSv10 = new ProtocolVersion(769);
    public static final ProtocolVersion TLSv11 = new ProtocolVersion(770);
    public static final ProtocolVersion TLSv12 = new ProtocolVersion(771);
    private int version;

    private ProtocolVersion(int n) {
        this.version = n & 0xFFFF;
    }

    public int getFullVersion() {
        return this.version;
    }

    public int getMajorVersion() {
        return this.version >> 8;
    }

    public int getMinorVersion() {
        return this.version & 0xFF;
    }

    public boolean equals(Object object) {
        return this == object;
    }

    public int hashCode() {
        return this.version;
    }

    public static ProtocolVersion get(int n, int n2) throws IOException {
        switch (n) {
            case 3: {
                switch (n2) {
                    case 0: {
                        return SSLv3;
                    }
                    case 1: {
                        return TLSv10;
                    }
                    case 2: {
                        return TLSv11;
                    }
                    case 3: {
                        return TLSv12;
                    }
                }
            }
        }
        throw new TlsFatalAlert(47);
    }
}

