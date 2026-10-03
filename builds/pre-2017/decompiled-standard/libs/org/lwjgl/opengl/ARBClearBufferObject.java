/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GL43;
import org.lwjgl.opengl.GLContext;

public final class ARBClearBufferObject {
    private ARBClearBufferObject() {
    }

    public static void glClearBufferData(int target, int internalformat, int format, int type2, ByteBuffer data2) {
        GL43.glClearBufferData(target, internalformat, format, type2, data2);
    }

    public static void glClearBufferSubData(int target, int internalformat, long offset, int format, int type2, ByteBuffer data2) {
        GL43.glClearBufferSubData(target, internalformat, offset, format, type2, data2);
    }

    public static void glClearNamedBufferDataEXT(int buffer, int internalformat, int format, int type2, ByteBuffer data2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glClearNamedBufferDataEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data2, 1);
        ARBClearBufferObject.nglClearNamedBufferDataEXT(buffer, internalformat, format, type2, MemoryUtil.getAddress(data2), function_pointer);
    }

    static native void nglClearNamedBufferDataEXT(int var0, int var1, int var2, int var3, long var4, long var6);

    public static void glClearNamedBufferSubDataEXT(int buffer, int internalformat, long offset, int format, int type2, ByteBuffer data2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glClearNamedBufferSubDataEXT;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data2);
        ARBClearBufferObject.nglClearNamedBufferSubDataEXT(buffer, internalformat, offset, data2.remaining(), format, type2, MemoryUtil.getAddress(data2), function_pointer);
    }

    static native void nglClearNamedBufferSubDataEXT(int var0, int var1, long var2, long var4, int var6, int var7, long var8, long var10);
}

