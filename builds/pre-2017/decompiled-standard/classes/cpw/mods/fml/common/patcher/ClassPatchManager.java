/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.patcher;

import LZMA.LzmaInputStream;
import com.google.common.base.Joiner;
import com.google.common.base.Throwables;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import com.google.common.io.Files;
import cpw.mods.fml.common.patcher.ClassPatch;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.repackage.com.nothome.delta.GDiffPatcher;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Pack200;
import java.util.logging.Level;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import net.minecraft.launchwrapper.LaunchClassLoader;

public class ClassPatchManager {
    public static final ClassPatchManager INSTANCE = new ClassPatchManager();
    public static final boolean dumpPatched = Boolean.parseBoolean(System.getProperty("fml.dumpPatchedClasses", "false"));
    private GDiffPatcher patcher = new GDiffPatcher();
    private ListMultimap<String, ClassPatch> patches;
    private Map<String, byte[]> patchedClasses = Maps.newHashMap();
    private File tempDir;

    private ClassPatchManager() {
        if (dumpPatched) {
            this.tempDir = Files.createTempDir();
            FMLRelaunchLog.info("Dumping patched classes to %s", this.tempDir.getAbsolutePath());
        }
    }

    public byte[] getPatchedResource(String string, String string2, LaunchClassLoader launchClassLoader) throws IOException {
        byte[] byArray = launchClassLoader.getClassBytes(string);
        return this.applyPatch(string, string2, byArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public byte[] applyPatch(String string, String string2, byte[] byArray) {
        if (this.patches == null) {
            return byArray;
        }
        if (this.patchedClasses.containsKey(string)) {
            return this.patchedClasses.get(string);
        }
        List<ClassPatch> list2 = this.patches.get(string);
        if (list2.isEmpty()) {
            return byArray;
        }
        boolean bl = false;
        FMLRelaunchLog.fine("Runtime patching class %s (input size %d), found %d patch%s", string2, byArray == null ? 0 : byArray.length, list2.size(), list2.size() != 1 ? "es" : "");
        for (ClassPatch classPatch : list2) {
            if (!classPatch.targetClassName.equals(string2) && !classPatch.sourceClassName.equals(string)) {
                FMLRelaunchLog.warning("Binary patch found %s for wrong class %s", classPatch.targetClassName, string2);
            }
            if (!(classPatch.existsAtTarget || byArray != null && byArray.length != 0)) {
                byArray = new byte[]{};
            } else if (!classPatch.existsAtTarget) {
                FMLRelaunchLog.warning("Patcher expecting empty class data file for %s, but received non-empty", classPatch.targetClassName);
            } else {
                int n = Hashing.adler32().hashBytes(byArray).asInt();
                if (classPatch.inputChecksum != n) {
                    FMLRelaunchLog.severe("There is a binary discrepency between the expected input class %s (%s) and the actual class. Checksum on disk is %x, in patch %x. Things are probably about to go very wrong. Did you put something into the jar file?", string2, string, n, classPatch.inputChecksum);
                    if (!Boolean.parseBoolean(System.getProperty("fml.ignorePatchDiscrepancies", "false"))) {
                        FMLRelaunchLog.severe("The game is going to exit, because this is a critical error, and it is very improbable that the modded game will work, please obtain clean jar files.", new Object[0]);
                        System.exit(1);
                    } else {
                        FMLRelaunchLog.severe("FML is going to ignore this error, note that the patch will not be applied, and there is likely to be a malfunctioning behaviour, including not running at all", new Object[0]);
                        bl = true;
                        continue;
                    }
                }
            }
            GDiffPatcher gDiffPatcher = this.patcher;
            synchronized (gDiffPatcher) {
                try {
                    byArray = this.patcher.patch(byArray, classPatch.patch);
                }
                catch (IOException iOException) {
                    FMLRelaunchLog.log(Level.SEVERE, iOException, "Encountered problem runtime patching class %s", string);
                }
            }
        }
        if (!bl) {
            FMLRelaunchLog.fine("Successfully applied runtime patches for %s (new size %d)", string2, byArray.length);
        }
        if (dumpPatched) {
            try {
                Files.write(byArray, new File(this.tempDir, string2));
            }
            catch (IOException iOException) {
                FMLRelaunchLog.log(Level.SEVERE, iOException, "Failed to write %s to %s", string2, this.tempDir.getAbsolutePath());
            }
        }
        this.patchedClasses.put(string, byArray);
        return byArray;
    }

    public void setup(Side side) {
        JarInputStream jarInputStream;
        Object object;
        Object object2;
        Pattern pattern = Pattern.compile(String.format("binpatch/%s/.*.binpatch", side.toString().toLowerCase(Locale.ENGLISH)));
        try {
            object2 = this.getClass().getResourceAsStream("/binpatches.pack.lzma");
            if (object2 == null) {
                FMLRelaunchLog.log(Level.SEVERE, "The binary patch set is missing. Either you are in a development environment, or things are not going to work!", new Object[0]);
                return;
            }
            object = new LzmaInputStream((InputStream)object2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            JarOutputStream jarOutputStream = new JarOutputStream(byteArrayOutputStream);
            Pack200.newUnpacker().unpack((InputStream)object, jarOutputStream);
            jarInputStream = new JarInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        }
        catch (Exception exception) {
            FMLRelaunchLog.log(Level.SEVERE, exception, "Error occurred reading binary patches. Expect severe problems!", new Object[0]);
            throw Throwables.propagate(exception);
        }
        this.patches = ArrayListMultimap.create();
        while (true) {
            try {
                while ((object2 = jarInputStream.getNextJarEntry()) != null) {
                    if (pattern.matcher(((ZipEntry)object2).getName()).matches()) {
                        object = this.readPatch((JarEntry)object2, jarInputStream);
                        if (object == null) continue;
                        this.patches.put(((ClassPatch)object).sourceClassName, (ClassPatch)object);
                        continue;
                    }
                    jarInputStream.closeEntry();
                }
            }
            catch (IOException iOException) {
                continue;
            }
            break;
        }
        FMLRelaunchLog.fine("Read %d binary patches", this.patches.size());
        FMLRelaunchLog.fine("Patch list :\n\t%s", Joiner.on("\t\n").join(this.patches.asMap().entrySet()));
        this.patchedClasses.clear();
    }

    private ClassPatch readPatch(JarEntry jarEntry, JarInputStream jarInputStream) {
        ByteArrayDataInput byteArrayDataInput;
        FMLRelaunchLog.finest("Reading patch data from %s", jarEntry.getName());
        try {
            byteArrayDataInput = ByteStreams.newDataInput(ByteStreams.toByteArray(jarInputStream));
        }
        catch (IOException iOException) {
            FMLRelaunchLog.log(Level.WARNING, iOException, "Unable to read binpatch file %s - ignoring", jarEntry.getName());
            return null;
        }
        String string = byteArrayDataInput.readUTF();
        String string2 = byteArrayDataInput.readUTF();
        String string3 = byteArrayDataInput.readUTF();
        boolean bl = byteArrayDataInput.readBoolean();
        int n = 0;
        if (bl) {
            n = byteArrayDataInput.readInt();
        }
        int n2 = byteArrayDataInput.readInt();
        byte[] byArray = new byte[n2];
        byteArrayDataInput.readFully(byArray);
        return new ClassPatch(string, string2, string3, bl, n, byArray);
    }
}

