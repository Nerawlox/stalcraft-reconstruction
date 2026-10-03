/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.tls.ProtocolVersion;
import org.bouncycastle.crypto.tls.TlsClientContext;
import org.bouncycastle.crypto.tls.TlsFatalAlert;
import org.bouncycastle.crypto.tls.TlsUtils;

public class TlsRSAUtils {
    public static byte[] generateEncryptedPreMasterSecret(TlsClientContext tlsClientContext, RSAKeyParameters rSAKeyParameters, OutputStream outputStream) throws IOException {
        byte[] byArray = new byte[48];
        tlsClientContext.getSecureRandom().nextBytes(byArray);
        TlsUtils.writeVersion(tlsClientContext.getClientVersion(), byArray, 0);
        PKCS1Encoding pKCS1Encoding = new PKCS1Encoding(new RSABlindedEngine());
        pKCS1Encoding.init(true, new ParametersWithRandom(rSAKeyParameters, tlsClientContext.getSecureRandom()));
        try {
            boolean bl = tlsClientContext.getServerVersion().getFullVersion() >= ProtocolVersion.TLSv10.getFullVersion();
            byte[] byArray2 = pKCS1Encoding.processBlock(byArray, 0, byArray.length);
            if (bl) {
                TlsUtils.writeOpaque16(byArray2, outputStream);
            } else {
                outputStream.write(byArray2);
            }
        }
        catch (InvalidCipherTextException invalidCipherTextException) {
            throw new TlsFatalAlert(80);
        }
        return byArray;
    }
}

