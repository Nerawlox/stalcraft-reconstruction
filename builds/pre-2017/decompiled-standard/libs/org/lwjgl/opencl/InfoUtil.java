/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opencl;

import org.lwjgl.opencl.CLObject;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
interface InfoUtil<T extends CLObject> {
    public int getInfoInt(T var1, int var2);

    public long getInfoSize(T var1, int var2);

    public long[] getInfoSizeArray(T var1, int var2);

    public long getInfoLong(T var1, int var2);

    public String getInfoString(T var1, int var2);
}

