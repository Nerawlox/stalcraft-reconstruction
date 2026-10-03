/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.haddon.implem;

import eu.ha3.mc.haddon.PrivateAccessException;
import eu.ha3.mc.haddon.implem.HaddonUtilitySingleton;
import eu.ha3.mc.haddon.implem.PrivateEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HaddonPrivateEntry
implements PrivateEntry {
    private final String name;
    private final Class target;
    private final int zero;
    private final String[] fieldNames;
    private final List<String> fieldNamesMoreToLess_depleting;

    public HaddonPrivateEntry(String string, Class clazz, int n, String ... stringArray) {
        this.name = string;
        this.target = clazz;
        this.zero = n;
        this.fieldNames = (String[])stringArray.clone();
        this.fieldNamesMoreToLess_depleting = new ArrayList<String>(Arrays.asList(this.fieldNames));
        Collections.reverse(this.fieldNamesMoreToLess_depleting);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Class getTarget() {
        return this.target;
    }

    @Override
    public int getZero() {
        return this.zero;
    }

    @Override
    public String[] getFieldNames() {
        return this.fieldNames;
    }

    @Override
    public Object get(Object object) throws PrivateAccessException {
        while (!this.fieldNamesMoreToLess_depleting.isEmpty()) {
            try {
                return HaddonUtilitySingleton.getInstance().getPrivateValueViaName(this.target, object, this.fieldNamesMoreToLess_depleting.get(0));
            }
            catch (PrivateAccessException privateAccessException) {
                HaddonUtilitySingleton.LOGGER.info("(Haddon) PrivateEntry " + this.name + " cannot resolve " + this.fieldNamesMoreToLess_depleting.get(0));
                this.fieldNamesMoreToLess_depleting.remove(0);
            }
        }
        if (this.zero >= 0) {
            try {
                return HaddonUtilitySingleton.getInstance().getPrivateValue(this.target, object, this.zero);
            }
            catch (PrivateAccessException privateAccessException) {
                HaddonUtilitySingleton.LOGGER.info("(Haddon) PrivateEntry " + this.name + " cannot resolve zero-index " + this.zero);
            }
        }
        this.generateError();
        return null;
    }

    @Override
    public void set(Object object, Object object2) throws PrivateAccessException {
        for (int i = this.fieldNames.length - 1; i >= 0; --i) {
            try {
                HaddonUtilitySingleton.getInstance().setPrivateValueViaName(this.target, object, this.fieldNames[i], object2);
                return;
            }
            catch (PrivateAccessException privateAccessException) {
                continue;
            }
        }
        if (this.zero >= 0) {
            try {
                HaddonUtilitySingleton.getInstance().setPrivateValue(this.target, object, this.zero, object2);
                return;
            }
            catch (PrivateAccessException privateAccessException) {
                // empty catch block
            }
        }
        this.generateError();
    }

    private void generateError() throws PrivateAccessException {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = this.fieldNames.length - 1; i >= 0; --i) {
            stringBuilder.append(this.fieldNames[i]);
            stringBuilder.append(",");
        }
        stringBuilder.append("[").append(this.zero).append("]");
        throw new PrivateAccessException(this.name + "(" + stringBuilder + ") could not be resolved");
    }
}

