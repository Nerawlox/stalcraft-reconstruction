/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.event;

import com.google.common.collect.ImmutableSet;
import cpw.mods.fml.common.event.FMLEvent;
import java.io.File;
import java.util.Set;

public class FMLFingerprintViolationEvent
extends FMLEvent {
    public final boolean isDirectory;
    public final Set<String> fingerprints;
    public final File source;
    public final String expectedFingerprint;

    public FMLFingerprintViolationEvent(boolean bl, File file, ImmutableSet<String> immutableSet, String string) {
        this.isDirectory = bl;
        this.source = file;
        this.fingerprints = immutableSet;
        this.expectedFingerprint = string;
    }
}

