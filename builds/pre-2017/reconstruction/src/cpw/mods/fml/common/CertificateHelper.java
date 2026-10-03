/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.cert.Certificate;

public class CertificateHelper {
    private static final String HEXES = "0123456789abcdef";

    public static String getFingerprint(Certificate certificate) {
        if (certificate == null) {
            return "NO VALID CERTIFICATE FOUND";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] byArray = certificate.getEncoded();
            messageDigest.update(byArray);
            byte[] byArray2 = messageDigest.digest();
            return CertificateHelper.hexify(byArray2);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static String getFingerprint(ByteBuffer byteBuffer) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(byteBuffer);
            byte[] byArray = messageDigest.digest();
            return CertificateHelper.hexify(byArray);
        }
        catch (Exception exception) {
            return null;
        }
    }

    private static String hexify(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder(2 * byArray.length);
        for (byte by : byArray) {
            stringBuilder.append(HEXES.charAt((by & 0xF0) >> 4)).append(HEXES.charAt(by & 0xF));
        }
        return stringBuilder.toString();
    }
}

