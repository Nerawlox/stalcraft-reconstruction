/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import net.minecraft.util.pibk;

public class NextTickHashSet
extends AbstractSet {
    private pibk longHashMap = new pibk();
    private int size = 0;
    private HashSet emptySet = new HashSet();

    public NextTickHashSet(Set set) {
        this.addAll(set);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof cfex)) {
            return false;
        }
        cfex cfex2 = (cfex)object;
        if (cfex2 == null) {
            return false;
        }
        long l = jjym._a(cfex2._b >> 4, cfex2._d >> 4);
        HashSet hashSet = (HashSet)this.longHashMap._b(l);
        return hashSet == null ? false : hashSet.contains(cfex2);
    }

    @Override
    public boolean add(Object object) {
        boolean bl;
        if (!(object instanceof cfex)) {
            return false;
        }
        cfex cfex2 = (cfex)object;
        if (cfex2 == null) {
            return false;
        }
        long l = jjym._a(cfex2._b >> 4, cfex2._d >> 4);
        HashSet<cfex> hashSet = (HashSet<cfex>)this.longHashMap._b(l);
        if (hashSet == null) {
            hashSet = new HashSet<cfex>();
            this.longHashMap._a(l, hashSet);
        }
        if (bl = hashSet.add(cfex2)) {
            ++this.size;
        }
        return bl;
    }

    @Override
    public boolean remove(Object object) {
        if (!(object instanceof cfex)) {
            return false;
        }
        cfex cfex2 = (cfex)object;
        if (cfex2 == null) {
            return false;
        }
        long l = jjym._a(cfex2._b >> 4, cfex2._d >> 4);
        HashSet hashSet = (HashSet)this.longHashMap._b(l);
        if (hashSet == null) {
            return false;
        }
        boolean bl = hashSet.remove(cfex2);
        if (bl) {
            --this.size;
        }
        return bl;
    }

    public Iterator getNextTickEntries(int n, int n2) {
        long l = jjym._a(n, n2);
        HashSet hashSet = (HashSet)this.longHashMap._b(l);
        if (hashSet == null) {
            hashSet = this.emptySet;
        }
        return hashSet.iterator();
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not implemented");
    }
}

