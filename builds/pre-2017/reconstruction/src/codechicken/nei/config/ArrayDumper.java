/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.config;

import codechicken.nei.config.DataDumper;
import java.util.LinkedList;

public abstract class ArrayDumper<T>
extends DataDumper {
    public ArrayDumper(String string) {
        super(string);
    }

    @Override
    public Iterable<String[]> dump(int n) {
        LinkedList<String[]> linkedList = new LinkedList<String[]>();
        T[] TArray = this.array();
        for (int i = 0; i < TArray.length; ++i) {
            T t = TArray[i];
            if (t == null) {
                if (n != 1 && n != 2) continue;
                linkedList.add(new String[]{Integer.toString(i), null, null, null, null});
                continue;
            }
            if (n != 0 && n != 2) continue;
            linkedList.add(this.dump(i, t));
        }
        return linkedList;
    }

    public abstract T[] array();

    public abstract String[] dump(int var1, T var2);
}

