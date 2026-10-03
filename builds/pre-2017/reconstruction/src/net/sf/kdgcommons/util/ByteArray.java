/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.util;

import java.io.UnsupportedEncodingException;

public class ByteArray {
    protected byte[] _data;
    protected int _size;
    protected int _expandBy;

    public ByteArray(int n, int n2) {
        this._data = new byte[n];
        this._size = 0;
        this._expandBy = n2;
    }

    public ByteArray(byte[] byArray) {
        this(byArray.length * 5 / 4, 25);
        this.add(byArray);
    }

    public ByteArray(String string) {
        this(ByteArray.convertToISO8859(string));
    }

    public ByteArray(String string, String string2) throws UnsupportedEncodingException {
        this(string.getBytes(string2));
    }

    public ByteArray() {
        this(64, 25);
    }

    public void add(byte by) {
        this.ensureCapacity(1);
        this._data[this._size++] = by;
    }

    public void add(byte[] byArray) {
        this.add(byArray, 0, byArray.length);
    }

    public void add(byte[] byArray, int n, int n2) {
        this.ensureCapacity(n2);
        for (int i = 0; i < n2; ++i) {
            this._data[this._size++] = byArray[n + i];
        }
    }

    public void add(char c) {
        this.add((byte)(c & 0xFF));
    }

    public void add(String string) {
        this.add(ByteArray.convertToISO8859(string));
    }

    public void add(String string, String string2) throws UnsupportedEncodingException {
        this.add(string.getBytes(string2));
    }

    public void add(ByteArray byteArray) {
        this.ensureCapacity(byteArray.size());
        for (int i = 0; i < byteArray._size; ++i) {
            this._data[this._size++] = byteArray._data[i];
        }
    }

    public byte get(int n) {
        if (n < 0 || n >= this._size) {
            throw new ArrayIndexOutOfBoundsException(n);
        }
        return this._data[n];
    }

    public byte[] getArray() {
        return this._data;
    }

    public byte[] getBytes(int n, int n2) {
        if (n < 0 || n > this._size) {
            throw new IllegalArgumentException("invalid offset: " + n);
        }
        if (n + n2 > this._size) {
            throw new IllegalArgumentException("invalid length: " + n2);
        }
        byte[] byArray = new byte[n2];
        for (int i = 0; i < n2; ++i) {
            byArray[i] = this._data[n + i];
        }
        return byArray;
    }

    public byte[] getBytes(int n) {
        return this.getBytes(n, this._size - n);
    }

    public byte[] getBytes() {
        return this.getBytes(0, this._size);
    }

    public void insert(int n, ByteArray byteArray) {
        this.insert(n, byteArray, 0, byteArray.size());
    }

    public void insert(int n, ByteArray byteArray, int n2, int n3) {
        if (n2 < 0 || n2 > byteArray.size()) {
            throw new IllegalArgumentException("invalid src offset: " + n2);
        }
        if (n2 + n3 > byteArray.size()) {
            throw new IllegalArgumentException("invalid src length: " + n3);
        }
        this.insert(n, byteArray.getArray(), n2, n3);
    }

    public void insert(int n, byte[] byArray) {
        this.insert(n, byArray, 0, byArray.length);
    }

    public void insert(int n, byte[] byArray, int n2, int n3) {
        if (n < 0 || n > this._size) {
            throw new IllegalArgumentException("invalid dst offset: " + n);
        }
        if (n2 < 0 || n2 > byArray.length) {
            throw new IllegalArgumentException("invalid src offset: " + n2);
        }
        if (n2 + n3 > byArray.length) {
            throw new IllegalArgumentException("invalid src length: " + n3);
        }
        this.ensureCapacity(n3);
        System.arraycopy(this._data, n, this._data, n + n3, this._size - n);
        System.arraycopy(byArray, n2, this._data, n, n3);
        this._size += n3;
    }

    public void remove(int n) {
        this.remove(n, 1);
    }

    public void remove(int n, int n2) {
        if (n < 0 || n + n2 >= this._size) {
            throw new IllegalArgumentException("invalid offset/length: " + n + "/" + n2);
        }
        int n3 = n + n2;
        int n4 = this._size - n3;
        System.arraycopy(this._data, n3, this._data, n, n4);
        this._size -= n2;
    }

    public void removeLast() {
        if (this._size > 0) {
            --this._size;
        }
    }

    public int size() {
        return this._size;
    }

    public void setSize(int n) {
        this.setCapacity(n);
        for (int i = this._size; i < n; ++i) {
            this._data[i] = 0;
        }
        this._size = n;
    }

    private static byte[] convertToISO8859(String string) {
        byte[] byArray = new byte[string.length()];
        for (int i = 0; i < byArray.length; ++i) {
            char c = string.charAt(i);
            if (c > '\u00ff') {
                throw new IllegalArgumentException("invalid character at position " + i);
            }
            byArray[i] = (byte)c;
        }
        return byArray;
    }

    private void ensureCapacity(int n) {
        if (this._size + n < this._data.length) {
            return;
        }
        int n2 = this._data.length * this._expandBy / 100;
        this.setCapacity(Math.max(n2, this._size + n));
    }

    private void setCapacity(int n) {
        if (n < this._size) {
            return;
        }
        byte[] byArray = new byte[n];
        for (int i = 0; i < this._size; ++i) {
            byArray[i] = this._data[i];
        }
        this._data = byArray;
    }
}

