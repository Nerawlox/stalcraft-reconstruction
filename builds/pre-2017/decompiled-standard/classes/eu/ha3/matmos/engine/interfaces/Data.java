/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.engine.interfaces;

import eu.ha3.matmos.engine.interfaces.Sheet;
import java.util.Set;

public interface Data {
    public void flagUpdate();

    public int getVersion();

    public Set<String> getSheetNames();

    public Sheet<Integer> getSheet(String var1);

    public void setSheet(String var1, Sheet<Integer> var2);
}

