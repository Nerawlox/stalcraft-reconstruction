/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.asm;

import com.google.common.base.Charsets;
import com.google.common.io.ByteStreams;
import cpw.mods.fml.common.CertificateHelper;
import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import cpw.mods.fml.common.patcher.ClassPatchManager;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import cpw.mods.fml.relauncher.IFMLCallHook;
import cpw.mods.fml.relauncher.Side;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.security.cert.Certificate;
import java.util.Map;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.zip.ZipEntry;
import javax.swing.JOptionPane;
import net.minecraft.launchwrapper.LaunchClassLoader;
import obf.gloomyfolken.modlist.ModListHooks;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;

public class FMLSanityChecker
implements IFMLCallHook {
    private static final String FMLFINGERPRINT = "51:0A:FB:4C:AF:A4:A0:F2:F5:CF:C5:0E:B4:CC:3C:30:24:4A:E3:8E".toLowerCase().replace(":", "");
    private static final String FORGEFINGERPRINT = "E3:C3:D5:0C:7C:98:6D:F7:4C:64:5C:0A:C5:46:39:74:1C:90:A5:57".toLowerCase().replace(":", "");
    private static final String MCFINGERPRINT = "CD:99:95:96:56:F7:53:DC:28:D8:63:B4:67:69:F7:F8:FB:AE:FC:FC".toLowerCase().replace(":", "");
    private LaunchClassLoader cl;
    public static File fmlLocation;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    @Override
    public Void call() throws Exception {
        var2_1 = ModListHooks.call(this);
        if (var2_1) {
            return null;
        }
        var2_2 = this.getClass().getProtectionDomain().getCodeSource();
        var3_3 = false;
        var4_4 = false;
        if (var2_2.getLocation().getProtocol().equals("jar")) {
            var4_4 = true;
            var5_5 = var2_2.getCertificates();
            if (var5_5 != null) {
                for (Object var9_18 : var5_5) {
                    var10_19 /* !! */  = CertificateHelper.getFingerprint((Certificate)var9_18);
                    if (var10_19 /* !! */ .equals(FMLSanityChecker.FMLFINGERPRINT)) {
                        FMLRelaunchLog.info("Found valid fingerprint for FML. Certificate fingerprint %s", new Object[]{var10_19 /* !! */ });
                        var3_3 = true;
                        continue;
                    }
                    if (var10_19 /* !! */ .equals(FMLSanityChecker.FORGEFINGERPRINT)) {
                        FMLRelaunchLog.info("Found valid fingerprint for Minecraft Forge. Certificate fingerprint %s", new Object[]{var10_19 /* !! */ });
                        var3_3 = true;
                        continue;
                    }
                    FMLRelaunchLog.severe("Found invalid fingerprint for FML: %s", new Object[]{var10_19 /* !! */ });
                }
            }
        } else {
            var3_3 = true;
        }
        var5_6 = FMLLaunchHandler.side() == Side.SERVER;
        var6_8 = 0;
        try {
            var7_10 = Class.forName("net.minecraft.client.ClientBrandRetriever", false, this.cl);
            var2_2 = var7_10.getProtectionDomain().getCodeSource();
        }
        catch (Exception var7_11) {
            var5_6 = true;
        }
        var7_10 = null;
        if (var4_4 && !var5_6 && var2_2.getLocation().getProtocol().equals("jar")) {
            try {
                var8_13 = var2_2.getLocation().getPath().substring(5);
                var8_13 = var8_13.substring(0, var8_13.lastIndexOf(33));
                var8_13 = URLDecoder.decode(var8_13, Charsets.UTF_8.name());
                var7_10 = new JarFile(var8_13, true);
                var7_10.getManifest();
                var9_18 = var7_10.getJarEntry("net/minecraft/client/ClientBrandRetriever.class");
                ByteStreams.toByteArray(var7_10.getInputStream((ZipEntry)var9_18));
                var10_19 /* !! */  = var9_18.getCertificates();
                v0 = var6_8 = var10_19 /* !! */  != null ? var10_19 /* !! */ .length : 0;
                if (var10_19 /* !! */  == null) ** GOTO lbl66
                for (Certificate var14_23 : var10_19 /* !! */ ) {
                    var15_24 = CertificateHelper.getFingerprint(var14_23);
                    if (!var15_24.equals(FMLSanityChecker.MCFINGERPRINT)) continue;
                    FMLRelaunchLog.info("Found valid fingerprint for Minecraft. Certificate fingerprint %s", new Object[]{var15_24});
                    var5_6 = true;
                }
            }
            catch (Throwable var8_15) {
                FMLRelaunchLog.log(Level.SEVERE, var8_15, "A critical error occurred trying to read the minecraft jar file", new Object[0]);
            }
            finally {
                if (var7_10 != null) {
                    try {
                        var7_10.close();
                    }
                    catch (IOException var8_14) {}
                }
            }
        } else {
            var5_6 = true;
        }
lbl66:
        // 4 sources

        if (!var5_6) {
            FMLRelaunchLog.severe("The minecraft jar %s appears to be corrupt! There has been CRITICAL TAMPERING WITH MINECRAFT, it is highly unlikely minecraft will work! STOP NOW, get a clean copy and try again!", new Object[]{var2_2.getLocation().getFile()});
            if (!Boolean.parseBoolean(System.getProperty("fml.ignoreInvalidMinecraftCertificates", "false"))) {
                FMLRelaunchLog.severe("For your safety, FML will not launch minecraft. You will need to fetch a clean version of the minecraft jar file", new Object[0]);
                FMLRelaunchLog.severe("Technical information: The class net.minecraft.client.ClientBrandRetriever should have been associated with the minecraft jar file, and should have returned us a valid, intact minecraft jar location. This did not work. Either you have modified the minecraft jar file (if so run the forge installer again), or you are using a base editing jar that is changing this class (and likely others too). If you REALLY want to run minecraft in this configuration, add the flag -Dfml.ignoreInvalidMinecraftCertificates=true to the 'JVM settings' in your launcher profile.", new Object[0]);
                System.exit(1);
            } else {
                FMLRelaunchLog.severe("FML has been ordered to ignore the invalid or missing minecraft certificate. This is very likely to cause a problem!", new Object[0]);
                FMLRelaunchLog.severe("Technical information: ClientBrandRetriever was at %s, there were %d certificates for it", new Object[]{var2_2.getLocation(), var6_8});
            }
        }
        if (!var3_3) {
            FMLRelaunchLog.severe("FML appears to be missing any signature data. This is not a good thing", new Object[0]);
        }
        if ((var8_17 = this.cl.getClassBytes("ModLoader")) == null) {
            return null;
        }
        var9_18 = new MLDetectorClassVisitor();
        var10_19 /* !! */  = new ClassReader(var8_17);
        var10_19 /* !! */ .accept((ClassVisitor)var9_18, 1);
        if (!MLDetectorClassVisitor.access$100((MLDetectorClassVisitor)var9_18)) {
            JOptionPane.showMessageDialog(null, "<html>CRITICAL ERROR<br/>ModLoader was detected in this environment<br/>ForgeModLoader cannot be installed alongside ModLoader<br/>All mods should work without ModLoader being installed<br/>Because ForgeModLoader is 100% compatible with ModLoader<br/>Re-install Minecraft Forge or Forge ModLoader into a clean<br/>jar and try again.", "ForgeModLoader critical error", 0);
            throw new RuntimeException("Invalid ModLoader class detected");
        }
        return null;
    }

    @Override
    public void injectData(Map<String, Object> map) {
        boolean bl = ModListHooks.injectData(this, map);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        this.cl = (LaunchClassLoader)map.get("classLoader");
        File file = (File)map.get("mcLocation");
        fmlLocation = (File)map.get("coremodLocation");
        ClassPatchManager.INSTANCE.setup(FMLLaunchHandler.side());
        FMLDeobfuscatingRemapper.INSTANCE.setup(file, this.cl, (String)map.get("deobfuscationFileName"));
    }

    static class MLDetectorClassVisitor
    extends ClassVisitor {
        private boolean foundMarker = false;

        private MLDetectorClassVisitor() {
            super(262144);
        }

        @Override
        public FieldVisitor visitField(int n, String string, String string2, String string3, Object object) {
            if ("fmlMarker".equals(string)) {
                this.foundMarker = true;
            }
            return null;
        }

        static /* synthetic */ boolean access$100(MLDetectorClassVisitor mLDetectorClassVisitor) {
            return mLDetectorClassVisitor.foundMarker;
        }
    }
}

