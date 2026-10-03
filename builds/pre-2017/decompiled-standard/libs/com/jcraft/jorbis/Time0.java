/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jorbis;

import com.jcraft.jogg.Buffer;
import com.jcraft.jorbis.Block;
import com.jcraft.jorbis.DspState;
import com.jcraft.jorbis.FuncTime;
import com.jcraft.jorbis.Info;
import com.jcraft.jorbis.InfoMode;

class Time0
extends FuncTime {
    Time0() {
    }

    @Override
    void pack(Object i, Buffer opb) {
    }

    @Override
    Object unpack(Info vi, Buffer opb) {
        return "";
    }

    @Override
    Object look(DspState vd, InfoMode mi, Object i) {
        return "";
    }

    @Override
    void free_info(Object i) {
    }

    @Override
    void free_look(Object i) {
    }

    @Override
    int inverse(Block vb, Object i, float[] in, float[] out) {
        return 0;
    }
}

