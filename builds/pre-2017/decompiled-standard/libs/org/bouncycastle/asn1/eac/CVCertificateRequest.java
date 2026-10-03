/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1.eac;

import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERApplicationSpecific;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.eac.CertificateBody;
import org.bouncycastle.asn1.eac.PublicKeyDataObject;

public class CVCertificateRequest
extends ASN1Object {
    private CertificateBody certificateBody;
    private byte[] innerSignature = null;
    private byte[] outerSignature = null;
    private int valid;
    private static int bodyValid = 1;
    private static int signValid = 2;
    ASN1ObjectIdentifier signOid = null;
    ASN1ObjectIdentifier keyOid = null;
    public static byte[] ZeroArray = new byte[]{0};
    String strCertificateHolderReference;
    byte[] encodedAuthorityReference;
    int ProfileId;
    byte[] certificate = null;
    protected String overSignerReference = null;
    byte[] encoded;
    PublicKeyDataObject iso7816PubKey = null;

    private CVCertificateRequest(DERApplicationSpecific dERApplicationSpecific) throws IOException {
        if (dERApplicationSpecific.getApplicationTag() == 103) {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(dERApplicationSpecific.getObject(16));
            this.initCertBody(DERApplicationSpecific.getInstance(aSN1Sequence.getObjectAt(0)));
            this.outerSignature = DERApplicationSpecific.getInstance(aSN1Sequence.getObjectAt(aSN1Sequence.size() - 1)).getContents();
        } else {
            this.initCertBody(dERApplicationSpecific);
        }
    }

    private void initCertBody(DERApplicationSpecific dERApplicationSpecific) throws IOException {
        if (dERApplicationSpecific.getApplicationTag() == 33) {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(dERApplicationSpecific.getObject(16));
            Enumeration enumeration = aSN1Sequence.getObjects();
            block4: while (enumeration.hasMoreElements()) {
                DERApplicationSpecific dERApplicationSpecific2 = DERApplicationSpecific.getInstance(enumeration.nextElement());
                switch (dERApplicationSpecific2.getApplicationTag()) {
                    case 78: {
                        this.certificateBody = CertificateBody.getInstance(dERApplicationSpecific2);
                        this.valid |= bodyValid;
                        continue block4;
                    }
                    case 55: {
                        this.innerSignature = dERApplicationSpecific2.getContents();
                        this.valid |= signValid;
                        continue block4;
                    }
                }
                throw new IOException("Invalid tag, not an CV Certificate Request element:" + dERApplicationSpecific2.getApplicationTag());
            }
        } else {
            throw new IOException("not a CARDHOLDER_CERTIFICATE in request:" + dERApplicationSpecific.getApplicationTag());
        }
    }

    public static CVCertificateRequest getInstance(Object object) {
        if (object instanceof CVCertificateRequest) {
            return (CVCertificateRequest)object;
        }
        if (object != null) {
            try {
                return new CVCertificateRequest(DERApplicationSpecific.getInstance(object));
            }
            catch (IOException iOException) {
                throw new ASN1ParsingException("unable to parse data: " + iOException.getMessage(), iOException);
            }
        }
        return null;
    }

    public CertificateBody getCertificateBody() {
        return this.certificateBody;
    }

    public PublicKeyDataObject getPublicKey() {
        return this.certificateBody.getPublicKey();
    }

    public byte[] getInnerSignature() {
        return this.innerSignature;
    }

    public byte[] getOuterSignature() {
        return this.outerSignature;
    }

    public boolean hasOuterSignature() {
        return this.outerSignature != null;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.certificateBody);
        try {
            aSN1EncodableVector.add(new DERApplicationSpecific(false, 55, new DEROctetString(this.innerSignature)));
        }
        catch (IOException iOException) {
            throw new IllegalStateException("unable to convert signature!");
        }
        return new DERApplicationSpecific(33, aSN1EncodableVector);
    }
}

