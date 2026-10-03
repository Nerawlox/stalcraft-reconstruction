/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

public class nfjd {
    public static final byte[] _a = new byte[4096];
    public final File _b;
    public RandomAccessFile _c;
    public final int[] _d = new int[1024];
    public final int[] _e = new int[1024];
    public ArrayList _f;
    public int _g;
    public long _h;

    public nfjd(File file) {
        this._b = file;
        this._g = 0;
        try {
            int n;
            int n2;
            int n3;
            if (file.exists()) {
                this._h = file.lastModified();
            }
            this._c = new RandomAccessFile(file, "rw");
            if (this._c.length() < 4096L) {
                for (n3 = 0; n3 < 1024; ++n3) {
                    this._c.writeInt(0);
                }
                for (n3 = 0; n3 < 1024; ++n3) {
                    this._c.writeInt(0);
                }
                this._g += 8192;
            }
            if ((this._c.length() & 0xFFFL) != 0L) {
                n3 = 0;
                while ((long)n3 < (this._c.length() & 0xFFFL)) {
                    this._c.write(0);
                    ++n3;
                }
            }
            n3 = (int)this._c.length() / 4096;
            this._f = new ArrayList(n3);
            for (n2 = 0; n2 < n3; ++n2) {
                this._f.add(true);
            }
            this._f.set(0, false);
            this._f.set(1, false);
            this._c.seek(0L);
            for (n2 = 0; n2 < 1024; ++n2) {
                this._d[n2] = n = this._c.readInt();
                if (n == 0 || (n >> 8) + (n & 0xFF) > this._f.size()) continue;
                for (int i = 0; i < (n & 0xFF); ++i) {
                    this._f.set((n >> 8) + i, false);
                }
            }
            for (n2 = 0; n2 < 1024; ++n2) {
                this._e[n2] = n = this._c.readInt();
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public synchronized DataInputStream _a(int n, int n2) {
        if (this._c(n, n2)) {
            return null;
        }
        try {
            int n3 = this._d(n, n2);
            if (n3 == 0) {
                return null;
            }
            int n4 = n3 >> 8;
            int n5 = n3 & 0xFF;
            if (n4 + n5 > this._f.size()) {
                return null;
            }
            this._c.seek(n4 * 4096);
            int n6 = this._c.readInt();
            if (n6 > 4096 * n5) {
                return null;
            }
            if (n6 <= 0) {
                return null;
            }
            byte by = this._c.readByte();
            if (by == 1) {
                byte[] byArray = new byte[n6 - 1];
                this._c.read(byArray);
                return new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(byArray))));
            }
            if (by == 2) {
                byte[] byArray = new byte[n6 - 1];
                this._c.read(byArray);
                return new DataInputStream(new BufferedInputStream(new InflaterInputStream(new ByteArrayInputStream(byArray))));
            }
            return null;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public DataOutputStream _b(int n, int n2) {
        if (this._c(n, n2)) {
            return null;
        }
        return new DataOutputStream(new DeflaterOutputStream(new rrvf(this, n, n2)));
    }

    public synchronized void _a(int n, int n2, byte[] byArray, int n3) {
        try {
            int n4 = this._d(n, n2);
            int n5 = n4 >> 8;
            int n6 = n4 & 0xFF;
            int n7 = (n3 + 5) / 4096 + 1;
            if (n7 >= 256) {
                return;
            }
            if (n5 != 0 && n6 == n7) {
                this._a(n5, byArray, n3);
            } else {
                int n8;
                int n9;
                for (n9 = 0; n9 < n6; ++n9) {
                    this._f.set(n5 + n9, true);
                }
                n9 = this._f.indexOf(true);
                int n10 = 0;
                if (n9 != -1) {
                    for (n8 = n9; n8 < this._f.size(); ++n8) {
                        if (n10 != 0) {
                            n10 = ((Boolean)this._f.get(n8)).booleanValue() ? ++n10 : 0;
                        } else if (((Boolean)this._f.get(n8)).booleanValue()) {
                            n9 = n8;
                            n10 = 1;
                        }
                        if (n10 >= n7) break;
                    }
                }
                if (n10 >= n7) {
                    n5 = n9;
                    this._a(n, n2, n5 << 8 | n7);
                    for (n8 = 0; n8 < n7; ++n8) {
                        this._f.set(n5 + n8, false);
                    }
                    this._a(n5, byArray, n3);
                } else {
                    this._c.seek(this._c.length());
                    n5 = this._f.size();
                    for (n8 = 0; n8 < n7; ++n8) {
                        this._c.write(_a);
                        this._f.add(false);
                    }
                    this._g += 4096 * n7;
                    this._a(n5, byArray, n3);
                    this._a(n, n2, n5 << 8 | n7);
                }
            }
            this._b(n, n2, (int)(dzfd.__aq() / 1000L));
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void _a(int n, byte[] byArray, int n2) {
        this._c.seek(n * 4096);
        this._c.writeInt(n2 + 1);
        this._c.writeByte(2);
        this._c.write(byArray, 0, n2);
    }

    public boolean _c(int n, int n2) {
        return n < 0 || n >= 32 || n2 < 0 || n2 >= 32;
    }

    public int _d(int n, int n2) {
        return this._d[n + n2 * 32];
    }

    public boolean _e(int n, int n2) {
        return this._d(n, n2) != 0;
    }

    public void _a(int n, int n2, int n3) {
        this._d[n + n2 * 32] = n3;
        this._c.seek((n + n2 * 32) * 4);
        this._c.writeInt(n3);
    }

    public void _b(int n, int n2, int n3) {
        this._e[n + n2 * 32] = n3;
        this._c.seek(4096 + (n + n2 * 32) * 4);
        this._c.writeInt(n3);
    }

    public void _a() {
        if (this._c != null) {
            this._c.close();
        }
    }
}

