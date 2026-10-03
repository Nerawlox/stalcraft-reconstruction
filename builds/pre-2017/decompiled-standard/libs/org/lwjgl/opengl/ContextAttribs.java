/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.opengl.ContextAttribsImplementation;
import org.lwjgl.opengl.LinuxContextAttribs;
import org.lwjgl.opengl.WindowsContextAttribs;

public final class ContextAttribs {
    private static final int CONTEXT_ES2_PROFILE_BIT_EXT = 4;
    private static final int CONTEXT_ROBUST_ACCESS_BIT_ARB = 4;
    private static final int CONTEXT_RESET_NOTIFICATION_STRATEGY_ARB = 33366;
    private static final int NO_RESET_NOTIFICATION_ARB = 33377;
    private static final int LOSE_CONTEXT_ON_RESET_ARB = 33362;
    private static final int CONTEXT_RESET_ISOLATION_BIT_ARB = 8;
    private int majorVersion;
    private int minorVersion;
    private int layerPlane;
    private boolean debug;
    private boolean forwardCompatible;
    private boolean robustAccess;
    private boolean profileCore;
    private boolean profileCompatibility;
    private boolean profileES;
    private boolean loseContextOnReset;
    private boolean contextResetIsolation;

    public ContextAttribs() {
        this(1, 0);
    }

    public ContextAttribs(int majorVersion, int minorVersion) {
        if (majorVersion < 0 || 4 < majorVersion || minorVersion < 0 || majorVersion == 4 && 3 < minorVersion || majorVersion == 3 && 3 < minorVersion || majorVersion == 2 && 1 < minorVersion || majorVersion == 1 && 5 < minorVersion) {
            throw new IllegalArgumentException("Invalid OpenGL version specified: " + majorVersion + '.' + minorVersion);
        }
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
    }

    private ContextAttribs(ContextAttribs attribs) {
        this.majorVersion = attribs.majorVersion;
        this.minorVersion = attribs.minorVersion;
        this.layerPlane = attribs.layerPlane;
        this.debug = attribs.debug;
        this.forwardCompatible = attribs.forwardCompatible;
        this.robustAccess = attribs.robustAccess;
        this.profileCore = attribs.profileCore;
        this.profileCompatibility = attribs.profileCompatibility;
        this.profileES = attribs.profileES;
        this.loseContextOnReset = attribs.loseContextOnReset;
    }

    public int getMajorVersion() {
        return this.majorVersion;
    }

    public int getMinorVersion() {
        return this.minorVersion;
    }

    public int getLayerPlane() {
        return this.layerPlane;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isForwardCompatible() {
        return this.forwardCompatible;
    }

    public boolean isProfileCore() {
        return this.profileCore;
    }

    public boolean isProfileCompatibility() {
        return this.profileCompatibility;
    }

    public boolean isProfileES() {
        return this.profileES;
    }

    public ContextAttribs withLayer(int layerPlane) {
        if (layerPlane < 0) {
            throw new IllegalArgumentException("Invalid layer plane specified: " + layerPlane);
        }
        if (layerPlane == this.layerPlane) {
            return this;
        }
        ContextAttribs attribs = new ContextAttribs(this);
        attribs.layerPlane = layerPlane;
        return attribs;
    }

    public ContextAttribs withDebug(boolean debug) {
        if (debug == this.debug) {
            return this;
        }
        ContextAttribs attribs = new ContextAttribs(this);
        attribs.debug = debug;
        return attribs;
    }

    public ContextAttribs withForwardCompatible(boolean forwardCompatible) {
        if (forwardCompatible == this.forwardCompatible) {
            return this;
        }
        ContextAttribs attribs = new ContextAttribs(this);
        attribs.forwardCompatible = forwardCompatible;
        return attribs;
    }

    public ContextAttribs withProfileCore(boolean profileCore) {
        if (this.majorVersion < 3 || this.majorVersion == 3 && this.minorVersion < 2) {
            throw new IllegalArgumentException("Profiles are only supported on OpenGL version 3.2 or higher.");
        }
        if (profileCore == this.profileCore) {
            return this;
        }
        ContextAttribs attribs = new ContextAttribs(this);
        attribs.profileCore = profileCore;
        if (profileCore) {
            attribs.profileCompatibility = false;
        }
        return attribs;
    }

    public ContextAttribs withProfileCompatibility(boolean profileCompatibility) {
        if (this.majorVersion < 3 || this.majorVersion == 3 && this.minorVersion < 2) {
            throw new IllegalArgumentException("Profiles are only supported on OpenGL version 3.2 or higher.");
        }
        if (profileCompatibility == this.profileCompatibility) {
            return this;
        }
        ContextAttribs attribs = new ContextAttribs(this);
        attribs.profileCompatibility = profileCompatibility;
        if (profileCompatibility) {
            attribs.profileCore = false;
        }
        return attribs;
    }

    public ContextAttribs withProfileES(boolean profileES) {
        if (this.majorVersion != 2 || this.minorVersion != 0) {
            throw new IllegalArgumentException("The OpenGL ES profiles is only supported for OpenGL version 2.0.");
        }
        if (profileES == this.profileES) {
            return this;
        }
        ContextAttribs attribs = new ContextAttribs(this);
        attribs.profileES = profileES;
        return attribs;
    }

    public ContextAttribs withLoseContextOnReset(boolean loseContextOnReset) {
        if (loseContextOnReset == this.loseContextOnReset) {
            return this;
        }
        ContextAttribs attribs = new ContextAttribs(this);
        attribs.loseContextOnReset = loseContextOnReset;
        return attribs;
    }

    public ContextAttribs withContextResetIsolation(boolean contextResetIsolation) {
        if (contextResetIsolation == this.contextResetIsolation) {
            return this;
        }
        ContextAttribs attribs = new ContextAttribs(this);
        attribs.contextResetIsolation = contextResetIsolation;
        return attribs;
    }

    private static ContextAttribsImplementation getImplementation() {
        switch (LWJGLUtil.getPlatform()) {
            case 1: {
                return new LinuxContextAttribs();
            }
            case 3: {
                return new WindowsContextAttribs();
            }
        }
        throw new IllegalStateException("Unsupported platform");
    }

    IntBuffer getAttribList() {
        if (LWJGLUtil.getPlatform() == 2) {
            return null;
        }
        ContextAttribsImplementation implementation = ContextAttribs.getImplementation();
        int attribCount = 0;
        if (this.majorVersion != 1 || this.minorVersion != 0) {
            attribCount += 2;
        }
        if (0 < this.layerPlane) {
            ++attribCount;
        }
        int flags = 0;
        if (this.debug) {
            flags |= implementation.getDebugBit();
        }
        if (this.forwardCompatible) {
            flags |= implementation.getForwardCompatibleBit();
        }
        if (this.robustAccess) {
            flags |= 4;
        }
        if (this.contextResetIsolation) {
            flags |= 8;
        }
        if (0 < flags) {
            ++attribCount;
        }
        int profileMask = 0;
        if (this.profileCore) {
            profileMask |= implementation.getProfileCoreBit();
        } else if (this.profileCompatibility) {
            profileMask |= implementation.getProfileCompatibilityBit();
        } else if (this.profileES) {
            profileMask |= 4;
        }
        if (0 < profileMask) {
            ++attribCount;
        }
        if (this.loseContextOnReset) {
            ++attribCount;
        }
        if (attribCount == 0) {
            return null;
        }
        IntBuffer attribs = BufferUtils.createIntBuffer(attribCount * 2 + 1);
        if (this.majorVersion != 1 || this.minorVersion != 0) {
            attribs.put(implementation.getMajorVersionAttrib()).put(this.majorVersion);
            attribs.put(implementation.getMinorVersionAttrib()).put(this.minorVersion);
        }
        if (0 < this.layerPlane) {
            attribs.put(implementation.getLayerPlaneAttrib()).put(this.layerPlane);
        }
        if (0 < flags) {
            attribs.put(implementation.getFlagsAttrib()).put(flags);
        }
        if (0 < profileMask) {
            attribs.put(implementation.getProfileMaskAttrib()).put(profileMask);
        }
        if (this.loseContextOnReset) {
            attribs.put(33366).put(33362);
        }
        attribs.put(0);
        attribs.rewind();
        return attribs;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("ContextAttribs:");
        sb.append(" Version=").append(this.majorVersion).append('.').append(this.minorVersion);
        sb.append(" - Layer=").append(this.layerPlane);
        sb.append(" - Debug=").append(this.debug);
        sb.append(" - ForwardCompatible=").append(this.forwardCompatible);
        sb.append(" - RobustAccess=").append(this.robustAccess);
        if (this.robustAccess) {
            sb.append(" (").append(this.loseContextOnReset ? "LOSE_CONTEXT_ON_RESET" : "NO_RESET_NOTIFICATION");
        }
        sb.append(" - Profile=");
        if (this.profileCore) {
            sb.append("Core");
        } else if (this.profileCompatibility) {
            sb.append("Compatibility");
        } else {
            sb.append("None");
        }
        return sb.toString();
    }
}

