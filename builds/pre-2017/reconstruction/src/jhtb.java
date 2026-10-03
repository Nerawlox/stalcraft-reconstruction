/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class jhtb
extends oxdc {
    public jhtb(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    private byte _a(byte by, byte by2) {
        return (byte)((0xFF & by) * (0xFF & by2) >> 8);
    }

    private void _a(ByteBuffer byteBuffer, byte by, byte by2, byte by3, byte by4) {
        byteBuffer.put(this._a(by, by4)).put(this._a(by2, by4)).put(this._a(by3, by4)).put(by4);
    }

    private void _b(ByteBuffer byteBuffer, byte by, byte by2, byte by3, byte by4) {
        byteBuffer.put(by).put(this._a(by2, by)).put(this._a(by3, by)).put(this._a(by4, by));
    }

    private void _c(ByteBuffer byteBuffer, byte by, byte by2, byte by3, byte by4) {
        byteBuffer.put(by4).put(this._a(by, by4)).put(this._a(by2, by4)).put(this._a(by3, by4));
    }

    @Override
    protected void _b(ByteBuffer byteBuffer, byte[] byArray) {
        if (this._y != null) {
            byte by = this._y[1];
            byte by2 = this._y[3];
            byte by3 = this._y[5];
            int n = byArray.length;
            for (int i = 1; i < n; i += 3) {
                byte by4 = byArray[i];
                byte by5 = byArray[i + 1];
                byte by6 = byArray[i + 2];
                byte by7 = -1;
                if (by4 == by && by5 == by2 && by6 == by3) {
                    by7 = 0;
                }
                this._b(byteBuffer, by7, by6, by5, by4);
            }
        } else {
            int n = byArray.length;
            for (int i = 1; i < n; i += 3) {
                byteBuffer.put((byte)-1).put(byArray[i + 2]).put(byArray[i + 1]).put(byArray[i]);
            }
        }
    }

    @Override
    protected void _c(ByteBuffer byteBuffer, byte[] byArray) {
        for (int i = 1; i < byArray.length; i += 4) {
            this._a(byteBuffer, byArray[i], byArray[i + 1], byArray[i + 2], byArray[i + 3]);
        }
    }

    @Override
    protected void _e(ByteBuffer byteBuffer, byte[] byArray) {
        if (this._y != null) {
            byte by = this._y[1];
            byte by2 = this._y[3];
            byte by3 = this._y[5];
            int n = byArray.length;
            for (int i = 1; i < n; i += 3) {
                byte by4 = byArray[i];
                byte by5 = byArray[i + 1];
                byte by6 = byArray[i + 2];
                byte by7 = -1;
                if (by4 == by && by5 == by2 && by6 == by3) {
                    by7 = 0;
                }
                this._a(byteBuffer, by4, by5, by6, by7);
            }
        } else {
            int n = byArray.length;
            for (int i = 1; i < n; i += 3) {
                byteBuffer.put(byArray[i]).put(byArray[i + 1]).put(byArray[i + 2]).put((byte)-1);
            }
        }
    }

    @Override
    protected void _f(ByteBuffer byteBuffer, byte[] byArray) {
        if (this._y != null) {
            byte by = this._y[1];
            byte by2 = this._y[3];
            byte by3 = this._y[5];
            int n = byArray.length;
            for (int i = 1; i < n; i += 3) {
                byte by4 = byArray[i];
                byte by5 = byArray[i + 1];
                byte by6 = byArray[i + 2];
                byte by7 = -1;
                if (by4 == by && by5 == by2 && by6 == by3) {
                    by7 = 0;
                }
                this._c(byteBuffer, by6, by5, by4, by7);
            }
        } else {
            int n = byArray.length;
            for (int i = 1; i < n; i += 3) {
                byteBuffer.put(byArray[i + 2]).put(byArray[i + 1]).put(byArray[i]).put((byte)-1);
            }
        }
    }

    @Override
    protected void _i(ByteBuffer byteBuffer, byte[] byArray) {
        int n = byArray.length;
        for (int i = 1; i < n; i += 4) {
            this._b(byteBuffer, byArray[i + 3], byArray[i + 2], byArray[i + 1], byArray[i]);
        }
    }

    @Override
    protected void _j(ByteBuffer byteBuffer, byte[] byArray) {
        int n = byArray.length;
        for (int i = 1; i < n; i += 4) {
            this._c(byteBuffer, byArray[i + 2], byArray[i + 1], byArray[i], byArray[i + 3]);
        }
    }

    @Override
    protected void _k(ByteBuffer byteBuffer, byte[] byArray) {
        int n = byArray.length;
        for (int i = 1; i < n; i += 4) {
            byteBuffer.put(byArray[i]).put(byArray[i + 1]).put(byArray[i + 2]);
        }
    }

    @Override
    protected void _l(ByteBuffer byteBuffer, byte[] byArray) {
        int n = byArray.length;
        for (int i = 1; i < n; i += 4) {
            byteBuffer.put(byArray[i]).put(byArray[i + 1]);
        }
    }

    @Override
    protected void _m(ByteBuffer byteBuffer, byte[] byArray) {
        int n = byArray.length;
        for (int i = 1; i < n; i += 4) {
            byteBuffer.put(byArray[i]);
        }
    }

    @Override
    protected void _n(ByteBuffer byteBuffer, byte[] byArray) {
        if (this._x != null) {
            int n = byArray.length;
            for (int i = 1; i < n; ++i) {
                int n2 = byArray[i] & 0xFF;
                byte by = this._w[n2 * 3 + 0];
                byte by2 = this._w[n2 * 3 + 1];
                byte by3 = this._w[n2 * 3 + 2];
                byte by4 = this._x[n2];
                this._b(byteBuffer, by4, by3, by2, by);
            }
        } else {
            int n = byArray.length;
            for (int i = 1; i < n; ++i) {
                int n3 = byArray[i] & 0xFF;
                byte by = this._w[n3 * 3 + 0];
                byte by5 = this._w[n3 * 3 + 1];
                byte by6 = this._w[n3 * 3 + 2];
                byte by7 = -1;
                byteBuffer.put(by7).put(by6).put(by5).put(by);
            }
        }
    }

    @Override
    protected void _o(ByteBuffer byteBuffer, byte[] byArray) {
        if (this._x != null) {
            int n = byArray.length;
            for (int i = 1; i < n; ++i) {
                int n2 = byArray[i] & 0xFF;
                byte by = this._w[n2 * 3 + 0];
                byte by2 = this._w[n2 * 3 + 1];
                byte by3 = this._w[n2 * 3 + 2];
                byte by4 = this._x[n2];
                this._a(byteBuffer, by, by2, by3, by4);
            }
        } else {
            int n = byArray.length;
            for (int i = 1; i < n; ++i) {
                int n3 = byArray[i] & 0xFF;
                byte by = this._w[n3 * 3 + 0];
                byte by5 = this._w[n3 * 3 + 1];
                byte by6 = this._w[n3 * 3 + 2];
                byte by7 = -1;
                byteBuffer.put(by).put(by5).put(by6).put(by7);
            }
        }
    }

    @Override
    protected void _p(ByteBuffer byteBuffer, byte[] byArray) {
        if (this._x != null) {
            int n = byArray.length;
            for (int i = 1; i < n; ++i) {
                int n2 = byArray[i] & 0xFF;
                byte by = this._w[n2 * 3 + 0];
                byte by2 = this._w[n2 * 3 + 1];
                byte by3 = this._w[n2 * 3 + 2];
                byte by4 = this._x[n2];
                this._c(byteBuffer, by3, by2, by, by4);
            }
        } else {
            int n = byArray.length;
            for (int i = 1; i < n; ++i) {
                int n3 = byArray[i] & 0xFF;
                byte by = this._w[n3 * 3 + 0];
                byte by5 = this._w[n3 * 3 + 1];
                byte by6 = this._w[n3 * 3 + 2];
                byte by7 = -1;
                byteBuffer.put(by6).put(by5).put(by).put(by7);
            }
        }
    }
}

