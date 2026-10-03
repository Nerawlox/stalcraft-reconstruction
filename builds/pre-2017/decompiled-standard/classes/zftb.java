/*
 * Decompiled with CFR 0.152.
 */
public enum zftb {
    _a{

        @Override
        public float _a(float f, float f2, float f3, float f4) {
            return 0.0f;
        }
    }
    ,
    _b{

        @Override
        public float _a(float f, float f2, float f3, float f4) {
            return f / f4 * f3 + f2;
        }
    }
    ,
    _c{

        @Override
        public float _a(float f, float f2, float f3, float f4) {
            return f3 * (f /= f4) * f + f2;
        }
    }
    ,
    _d{

        @Override
        public float _a(float f, float f2, float f3, float f4) {
            return -f3 * (f /= f4) * (f - 2.0f) + f2;
        }
    }
    ,
    _e{

        @Override
        public float _a(float f, float f2, float f3, float f4) {
            return (float)((double)f3 * Math.pow(2.0, 10.0f * (f / f4 - 1.0f)) + (double)f2);
        }
    }
    ,
    _f{

        @Override
        public float _a(float f, float f2, float f3, float f4) {
            return (float)((double)f3 * (-Math.pow(2.0, -10.0f * f / f4) + 1.0) + (double)f2);
        }
    }
    ,
    _g{

        @Override
        public float _a(float f, float f2, float f3, float f4) {
            return (float)((double)f3 * (-Math.pow(2.0, -40.0f * f / f4) + 1.0) + (double)f2);
        }
    }
    ,
    _h{

        @Override
        public float _a(float f, float f2, float f3, float f4) {
            float f5 = 0.3f;
            f = Math.min(f / f4, 1.0f);
            return (float)(Math.pow(2.0, -10.0f * f) * Math.sin((double)(f - f5 / 4.0f) * (Math.PI * 2) / (double)f5) + 1.0) * f3 + f2;
        }
    };


    public abstract float _a(float var1, float var2, float var3, float var4);
}

