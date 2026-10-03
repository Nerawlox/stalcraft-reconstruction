/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;
import org.lwjgl.opengl.APIUtil;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBShadingLanguageInclude {
    public static final int GL_SHADER_INCLUDE_ARB = 36270;
    public static final int GL_NAMED_STRING_LENGTH_ARB = 36329;
    public static final int GL_NAMED_STRING_TYPE_ARB = 36330;

    private ARBShadingLanguageInclude() {
    }

    public static void glNamedStringARB(int type2, ByteBuffer name2, ByteBuffer string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glNamedStringARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name2);
        BufferChecks.checkDirect(string);
        ARBShadingLanguageInclude.nglNamedStringARB(type2, name2.remaining(), MemoryUtil.getAddress(name2), string.remaining(), MemoryUtil.getAddress(string), function_pointer);
    }

    static native void nglNamedStringARB(int var0, int var1, long var2, int var4, long var5, long var7);

    public static void glNamedStringARB(int type2, CharSequence name2, CharSequence string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glNamedStringARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShadingLanguageInclude.nglNamedStringARB(type2, name2.length(), APIUtil.getBuffer(caps, name2), string.length(), APIUtil.getBuffer(caps, string, name2.length()), function_pointer);
    }

    public static void glDeleteNamedStringARB(ByteBuffer name2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDeleteNamedStringARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name2);
        ARBShadingLanguageInclude.nglDeleteNamedStringARB(name2.remaining(), MemoryUtil.getAddress(name2), function_pointer);
    }

    static native void nglDeleteNamedStringARB(int var0, long var1, long var3);

    public static void glDeleteNamedStringARB(CharSequence name2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glDeleteNamedStringARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShadingLanguageInclude.nglDeleteNamedStringARB(name2.length(), APIUtil.getBuffer(caps, name2), function_pointer);
    }

    public static void glCompileShaderIncludeARB(int shader, int count, ByteBuffer path) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glCompileShaderIncludeARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(path);
        BufferChecks.checkNullTerminated(path, count);
        ARBShadingLanguageInclude.nglCompileShaderIncludeARB(shader, count, MemoryUtil.getAddress(path), 0L, function_pointer);
    }

    static native void nglCompileShaderIncludeARB(int var0, int var1, long var2, long var4, long var6);

    public static void glCompileShaderIncludeARB(int shader, CharSequence[] path) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glCompileShaderIncludeARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkArray(path);
        ARBShadingLanguageInclude.nglCompileShaderIncludeARB2(shader, path.length, APIUtil.getBuffer(caps, path), APIUtil.getLengths(caps, path), function_pointer);
    }

    static native void nglCompileShaderIncludeARB2(int var0, int var1, long var2, long var4, long var6);

    public static boolean glIsNamedStringARB(ByteBuffer name2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glIsNamedStringARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name2);
        boolean __result = ARBShadingLanguageInclude.nglIsNamedStringARB(name2.remaining(), MemoryUtil.getAddress(name2), function_pointer);
        return __result;
    }

    static native boolean nglIsNamedStringARB(int var0, long var1, long var3);

    public static boolean glIsNamedStringARB(CharSequence name2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glIsNamedStringARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = ARBShadingLanguageInclude.nglIsNamedStringARB(name2.length(), APIUtil.getBuffer(caps, name2), function_pointer);
        return __result;
    }

    public static void glGetNamedStringARB(ByteBuffer name2, IntBuffer stringlen, ByteBuffer string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetNamedStringARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name2);
        if (stringlen != null) {
            BufferChecks.checkBuffer(stringlen, 1);
        }
        BufferChecks.checkDirect(string);
        ARBShadingLanguageInclude.nglGetNamedStringARB(name2.remaining(), MemoryUtil.getAddress(name2), string.remaining(), MemoryUtil.getAddressSafe(stringlen), MemoryUtil.getAddress(string), function_pointer);
    }

    static native void nglGetNamedStringARB(int var0, long var1, int var3, long var4, long var6, long var8);

    public static void glGetNamedStringARB(CharSequence name2, IntBuffer stringlen, ByteBuffer string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetNamedStringARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (stringlen != null) {
            BufferChecks.checkBuffer(stringlen, 1);
        }
        BufferChecks.checkDirect(string);
        ARBShadingLanguageInclude.nglGetNamedStringARB(name2.length(), APIUtil.getBuffer(caps, name2), string.remaining(), MemoryUtil.getAddressSafe(stringlen), MemoryUtil.getAddress(string), function_pointer);
    }

    public static String glGetNamedStringARB(CharSequence name2, int bufSize) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetNamedStringARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer string_length = APIUtil.getLengths(caps);
        ByteBuffer string = APIUtil.getBufferByte(caps, bufSize + name2.length());
        ARBShadingLanguageInclude.nglGetNamedStringARB(name2.length(), APIUtil.getBuffer(caps, name2), bufSize, MemoryUtil.getAddress0(string_length), MemoryUtil.getAddress(string), function_pointer);
        string.limit(name2.length() + string_length.get(0));
        return APIUtil.getString(caps, string);
    }

    public static void glGetNamedStringARB(ByteBuffer name2, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetNamedStringivARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name2);
        BufferChecks.checkBuffer(params, 1);
        ARBShadingLanguageInclude.nglGetNamedStringivARB(name2.remaining(), MemoryUtil.getAddress(name2), pname, MemoryUtil.getAddress(params), function_pointer);
    }

    static native void nglGetNamedStringivARB(int var0, long var1, int var3, long var4, long var6);

    public static void glGetNamedStringiARB(CharSequence name2, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetNamedStringivARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        ARBShadingLanguageInclude.nglGetNamedStringivARB(name2.length(), APIUtil.getBuffer(caps, name2), pname, MemoryUtil.getAddress(params), function_pointer);
    }

    public static int glGetNamedStringiARB(CharSequence name2, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.glGetNamedStringivARB;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtil.getBufferInt(caps);
        ARBShadingLanguageInclude.nglGetNamedStringivARB(name2.length(), APIUtil.getBuffer(caps, name2), pname, MemoryUtil.getAddress(params), function_pointer);
        return params.get(0);
    }
}

