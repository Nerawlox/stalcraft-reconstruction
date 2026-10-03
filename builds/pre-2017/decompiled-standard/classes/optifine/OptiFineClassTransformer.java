/*
 * Decompiled with CFR 0.152.
 */
package optifine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.minecraft.launchwrapper.IClassTransformer;

public class OptiFineClassTransformer
implements IClassTransformer {
    private ZipFile ofZipFile = null;

    public OptiFineClassTransformer() {
        try {
            URLClassLoader uRLClassLoader = (URLClassLoader)OptiFineClassTransformer.class.getClassLoader();
            URL[] uRLArray = uRLClassLoader.getURLs();
            for (int i = 0; i < uRLArray.length; ++i) {
                URL uRL = uRLArray[i];
                ZipFile zipFile = OptiFineClassTransformer.getOptiFineZipFile(uRL);
                if (zipFile == null) continue;
                this.ofZipFile = zipFile;
                OptiFineClassTransformer.dbg("OptiFine ClassTransformer");
                OptiFineClassTransformer.dbg("OptiFine URL: " + uRL);
                OptiFineClassTransformer.dbg("OptiFine ZIP file: " + zipFile);
                break;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (this.ofZipFile == null) {
            OptiFineClassTransformer.dbg("*** Can not find the OptiFine JAR in the classpath ***");
            OptiFineClassTransformer.dbg("*** OptiFine will not be loaded! ***");
        }
    }

    private static ZipFile getOptiFineZipFile(URL uRL) {
        try {
            URI uRI = uRL.toURI();
            File file = new File(uRI);
            ZipFile zipFile = new ZipFile(file);
            if (zipFile.getEntry("optifine/OptiFineClassTransformer.class") == null) {
                zipFile.close();
                return null;
            }
            return zipFile;
        }
        catch (Exception exception) {
            return null;
        }
    }

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        byte[] byArray2 = this.getOptiFineClass(string);
        return byArray2 != null ? byArray2 : byArray;
    }

    private byte[] getOptiFineClass(String string) {
        if (this.ofZipFile == null) {
            return null;
        }
        String string2 = string + ".class";
        ZipEntry zipEntry = this.ofZipFile.getEntry(string2);
        if (zipEntry == null) {
            return null;
        }
        try {
            InputStream inputStream = this.ofZipFile.getInputStream(zipEntry);
            byte[] byArray = OptiFineClassTransformer.readAll(inputStream);
            if ((long)byArray.length != zipEntry.getSize()) {
                OptiFineClassTransformer.dbg("Invalid size for " + string2 + ": " + byArray.length + ", should be: " + zipEntry.getSize());
                return null;
            }
            return byArray;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
    }

    public static byte[] readAll(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byArray = new byte[1024];
        while (true) {
            int n;
            if ((n = inputStream.read(byArray)) < 0) {
                inputStream.close();
                byte[] byArray2 = byteArrayOutputStream.toByteArray();
                return byArray2;
            }
            byteArrayOutputStream.write(byArray, 0, n);
        }
    }

    private static void dbg(String string) {
        System.out.println(string);
    }
}

