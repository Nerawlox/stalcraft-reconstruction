/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Set;
import java.util.regex.Pattern;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class CollectionUtil {
    public static <T> Set<T> asSet(T ... TArray) {
        HashSet<T> hashSet = new HashSet<T>();
        for (T t : TArray) {
            hashSet.add(t);
        }
        return hashSet;
    }

    public static <T> void addAll(Collection<T> collection, T ... TArray) {
        for (T t : TArray) {
            collection.add(t);
        }
    }

    public static <T> void addAll(Collection<T> collection, Iterator<T> iterator2) {
        while (iterator2.hasNext()) {
            collection.add(iterator2.next());
        }
    }

    public static <T> void addAll(Collection<T> collection, Iterable<T> iterable) {
        CollectionUtil.addAll(collection, iterable.iterator());
    }

    public static <T> List<T> cast(List<?> list, Class<T> clazz) {
        for (Object obj : list) {
            clazz.cast(obj);
        }
        return list;
    }

    public static <T> Set<T> cast(Set<?> set, Class<T> clazz) {
        for (Object obj : set) {
            clazz.cast(obj);
        }
        return set;
    }

    public static <T> List<T> resize(List<T> list, int n, T t) {
        block7: {
            block6: {
                if (list instanceof ArrayList) {
                    ((ArrayList)list).ensureCapacity(n);
                }
                if (list.size() >= n) break block6;
                for (int i = list.size(); i < n; ++i) {
                    list.add(t);
                }
                break block7;
            }
            if (list.size() <= n) break block7;
            if (list instanceof RandomAccess) {
                for (int i = list.size() - 1; i >= n; --i) {
                    list.remove(i);
                }
            } else {
                ListIterator<T> listIterator = list.listIterator(n);
                while (listIterator.hasNext()) {
                    listIterator.next();
                    listIterator.remove();
                }
            }
        }
        return list;
    }

    public static <T> List<T> resize(List<T> list, int n) {
        return CollectionUtil.resize(list, n, null);
    }

    public static <T> String join(Iterable<T> iterable, String string) {
        if (iterable == null) {
            return "";
        }
        boolean bl = true;
        StringBuilder stringBuilder = new StringBuilder(1024);
        for (T t : iterable) {
            if (bl) {
                bl = false;
            } else {
                stringBuilder.append(string);
            }
            if (t == null) continue;
            stringBuilder.append(String.valueOf(t));
        }
        return stringBuilder.toString();
    }

    public static <T> List<T> filter(List<T> list, String string, boolean bl) {
        Pattern pattern = Pattern.compile(string);
        ArrayList<T> arrayList = new ArrayList<T>(list.size());
        for (T t : list) {
            String string2 = t == null ? "" : t.toString();
            if (pattern.matcher(string2).matches() != bl) continue;
            arrayList.add(t);
        }
        return arrayList;
    }
}

