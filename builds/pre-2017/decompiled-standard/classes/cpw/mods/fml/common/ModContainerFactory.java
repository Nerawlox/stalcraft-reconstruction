/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.FMLModContainer;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.discovery.ModCandidate;
import cpw.mods.fml.common.discovery.asm.ASMModParser;
import cpw.mods.fml.common.discovery.asm.ModAnnotation;
import cpw.mods.fml.common.modloader.ModLoaderModContainer;
import java.io.File;
import java.util.regex.Pattern;
import obf.gloomyfolken.modlist.ModListHooks;
import org.objectweb.asm.Type;

public class ModContainerFactory {
    private static Pattern modClass = Pattern.compile(".*(\\.|)(mod\\_[^\\s$]+)$");
    private static ModContainerFactory INSTANCE = new ModContainerFactory();

    public static ModContainerFactory instance() {
        return INSTANCE;
    }

    public ModContainer build(ASMModParser aSMModParser, File file, ModCandidate modCandidate) {
        String string = aSMModParser.getASMType().getClassName();
        if (aSMModParser.isBaseMod(modCandidate.getRememberedBaseMods()) && modClass.matcher(string).find()) {
            FMLLog.fine("Identified a BaseMod type mod %s", string);
            ModLoaderModContainer modLoaderModContainer = new ModLoaderModContainer(string, file, aSMModParser.getBaseModProperties());
            ModListHooks.onModBuild(aSMModParser, modLoaderModContainer);
            return modLoaderModContainer;
        }
        if (modClass.matcher(string).find()) {
            FMLLog.fine("Identified a class %s following modloader naming convention but not directly a BaseMod or currently seen subclass", string);
            modCandidate.rememberModCandidateType(aSMModParser);
        } else if (aSMModParser.isBaseMod(modCandidate.getRememberedBaseMods())) {
            FMLLog.fine("Found a basemod %s of non-standard naming format", string);
            modCandidate.rememberBaseModType(string);
        }
        if (string.startsWith("net.minecraft.src.") && modCandidate.isClasspath() && !modCandidate.isMinecraftJar()) {
            FMLLog.severe("FML has detected a mod that is using a package name based on 'net.minecraft.src' : %s. This is generally a severe programming error.  There should be no mod code in the minecraft namespace. MOVE YOUR MOD! If you're in eclipse, select your source code and 'refactor' it into a new package. Go on. DO IT NOW!", string);
        }
        for (ModAnnotation modAnnotation : aSMModParser.getAnnotations()) {
            if (!modAnnotation.getASMType().equals(Type.getType(Mod.class))) continue;
            FMLLog.fine("Identified an FMLMod type mod %s", string);
            FMLModContainer fMLModContainer = new FMLModContainer(string, modCandidate, modAnnotation.getValues());
            ModListHooks.onModBuild(aSMModParser, fMLModContainer);
            return fMLModContainer;
        }
        ModContainer modContainer = null;
        ModListHooks.onModBuild(aSMModParser, modContainer);
        return modContainer;
    }
}

