/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.util;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class DataTable {
    private String[] _colNames;
    private Class<?>[] _colClasses;
    private ArrayList<Object[]> _data;
    private HashMap<String, Integer> _name2Col;

    public DataTable(String[] stringArray, Class<?>[] classArray, Object[][] objectArray) {
        int n;
        if (classArray != null && classArray.length != stringArray.length) {
            throw new IllegalArgumentException("colClasses not same size as colNames (expected: " + stringArray.length + ", got: " + classArray.length + ")");
        }
        this._colNames = new String[stringArray.length];
        this._name2Col = new HashMap();
        this._colClasses = new Class[this._colNames.length];
        for (n = 0; n < stringArray.length; ++n) {
            this._colNames[n] = stringArray[n];
            this._name2Col.put(stringArray[n], n);
            this._colClasses[n] = classArray != null ? classArray[n] : null;
        }
        this._data = new ArrayList();
        if (objectArray != null) {
            for (n = 0; n < objectArray.length; ++n) {
                this.internalAddRow(n, objectArray[n]);
            }
        }
    }

    public DataTable(String[] stringArray) {
        this(stringArray, null, null);
    }

    public int size() {
        return this._data.size();
    }

    public int getColumnCount() {
        return this._colNames.length;
    }

    public String getColumnName(int n) {
        return this._colNames[n];
    }

    public Class<?> getColumnClass(int n) {
        return this._colClasses[n];
    }

    public Object getValue(int n, int n2) {
        Object[] objectArray = this._data.get(n);
        return objectArray[n2];
    }

    public Object setValue(int n, int n2, Object object) {
        this.checkClass(n, n2, object);
        Object[] objectArray = this._data.get(n);
        Object object2 = objectArray[n2];
        objectArray[n2] = object;
        return object2;
    }

    public void addRow() {
        this.internalAddRow(this._data.size(), new Object[this.getColumnCount()]);
    }

    public void addRow(Object[] objectArray) {
        this.internalAddRow(this._data.size(), objectArray);
    }

    private void checkRowSize(int n, Object[] objectArray) {
        if (objectArray.length != this._colNames.length) {
            throw new IllegalArgumentException("row[" + n + "] has incorrect size: " + "expected: " + this._colNames.length + ", got: " + objectArray.length);
        }
    }

    private void checkClass(int n, int n2, Object object) {
        if (this._colClasses[n2] != null && object != null && !this._colClasses[n2].isInstance(object)) {
            throw new ClassCastException("cell[" + n + "," + n2 + "]: " + "expected " + this._colClasses[n2].getName() + ", got " + object.getClass().getName());
        }
    }

    private void internalAddRow(int n, Object[] objectArray) {
        this.checkRowSize(n, objectArray);
        Object[] objectArray2 = new Object[this._colNames.length];
        for (int i = 0; i < this._colNames.length; ++i) {
            this.checkClass(n, i, objectArray[i]);
            objectArray2[i] = objectArray[i];
        }
        this._data.add(objectArray2);
    }
}

