/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce;

import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTNamedCurves;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves;
import org.bouncycastle.asn1.x9.X962NamedCurves;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;

public class ECNamedCurveTable {
    public static ECNamedCurveParameterSpec getParameterSpec(String string) {
        X9ECParameters x9ECParameters = X962NamedCurves.getByName(string);
        if (x9ECParameters == null) {
            try {
                x9ECParameters = X962NamedCurves.getByOID(new ASN1ObjectIdentifier(string));
            }
            catch (IllegalArgumentException illegalArgumentException) {
                // empty catch block
            }
        }
        if (x9ECParameters == null && (x9ECParameters = SECNamedCurves.getByName(string)) == null) {
            try {
                x9ECParameters = SECNamedCurves.getByOID(new ASN1ObjectIdentifier(string));
            }
            catch (IllegalArgumentException illegalArgumentException) {
                // empty catch block
            }
        }
        if (x9ECParameters == null && (x9ECParameters = TeleTrusTNamedCurves.getByName(string)) == null) {
            try {
                x9ECParameters = TeleTrusTNamedCurves.getByOID(new ASN1ObjectIdentifier(string));
            }
            catch (IllegalArgumentException illegalArgumentException) {
                // empty catch block
            }
        }
        if (x9ECParameters == null) {
            x9ECParameters = NISTNamedCurves.getByName(string);
        }
        if (x9ECParameters == null) {
            return null;
        }
        return new ECNamedCurveParameterSpec(string, x9ECParameters.getCurve(), x9ECParameters.getG(), x9ECParameters.getN(), x9ECParameters.getH(), x9ECParameters.getSeed());
    }

    public static Enumeration getNames() {
        Vector vector = new Vector();
        ECNamedCurveTable.addEnumeration(vector, X962NamedCurves.getNames());
        ECNamedCurveTable.addEnumeration(vector, SECNamedCurves.getNames());
        ECNamedCurveTable.addEnumeration(vector, NISTNamedCurves.getNames());
        ECNamedCurveTable.addEnumeration(vector, TeleTrusTNamedCurves.getNames());
        return vector.elements();
    }

    private static void addEnumeration(Vector vector, Enumeration enumeration) {
        while (enumeration.hasMoreElements()) {
            vector.addElement(enumeration.nextElement());
        }
    }
}

