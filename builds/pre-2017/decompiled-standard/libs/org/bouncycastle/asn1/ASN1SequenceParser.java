/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.InMemoryRepresentable;

public interface ASN1SequenceParser
extends ASN1Encodable,
InMemoryRepresentable {
    public ASN1Encodable readObject() throws IOException;
}

