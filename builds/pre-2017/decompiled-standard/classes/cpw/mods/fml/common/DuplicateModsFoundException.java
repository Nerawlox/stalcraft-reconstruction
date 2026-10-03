/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import com.google.common.collect.SetMultimap;
import cpw.mods.fml.common.LoaderException;
import cpw.mods.fml.common.ModContainer;
import java.io.File;

public class DuplicateModsFoundException
extends LoaderException {
    public SetMultimap<ModContainer, File> dupes;

    public DuplicateModsFoundException(SetMultimap<ModContainer, File> setMultimap) {
        this.dupes = setMultimap;
    }
}

