/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SealedObjectForKeyProtector;
import java.io.ObjectStreamException;
import javax.crypto.SealedObject;

final class ai
extends SealedObject {
    static final long serialVersionUID = -7051502576727967444L;

    ai(SealedObject sealedObject) {
        super(sealedObject);
    }

    Object a() throws ObjectStreamException {
        return new SealedObjectForKeyProtector(this);
    }
}

