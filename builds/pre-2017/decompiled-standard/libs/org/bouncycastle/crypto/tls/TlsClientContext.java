/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.security.SecureRandom;
import org.bouncycastle.crypto.tls.ProtocolVersion;
import org.bouncycastle.crypto.tls.SecurityParameters;

public interface TlsClientContext {
    public SecureRandom getSecureRandom();

    public SecurityParameters getSecurityParameters();

    public ProtocolVersion getClientVersion();

    public ProtocolVersion getServerVersion();

    public Object getUserObject();

    public void setUserObject(Object var1);
}

