/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.util;

import java.util.Collection;
import org.bouncycastle.util.Selector;
import org.bouncycastle.util.StoreException;

public interface Store {
    public Collection getMatches(Selector var1) throws StoreException;
}

