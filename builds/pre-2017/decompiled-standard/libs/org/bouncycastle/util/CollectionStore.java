/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.util;

import java.util.ArrayList;
import java.util.Collection;
import org.bouncycastle.util.Selector;
import org.bouncycastle.util.Store;

public class CollectionStore
implements Store {
    private Collection _local;

    public CollectionStore(Collection collection) {
        this._local = new ArrayList(collection);
    }

    public Collection getMatches(Selector selector) {
        if (selector == null) {
            return new ArrayList(this._local);
        }
        ArrayList arrayList = new ArrayList();
        for (Object e : this._local) {
            if (!selector.match(e)) continue;
            arrayList.add(e);
        }
        return arrayList;
    }
}

