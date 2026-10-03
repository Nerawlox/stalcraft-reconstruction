/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.discovery;

import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.discovery.ASMDataTable;
import cpw.mods.fml.common.discovery.ModCandidate;
import java.util.List;
import java.util.regex.Pattern;

public interface ITypeDiscoverer {
    public static final Pattern classFile = Pattern.compile("([^\\s$]+).class$");

    public List<ModContainer> discover(ModCandidate var1, ASMDataTable var2);
}

