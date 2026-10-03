/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.commons.io.IOUtils;

public class srxe {
    public static List<String> _a(String string) {
        URL uRL = srxe.class.getResource(string);
        ArrayList<String> arrayList = new ArrayList<String>();
        if (uRL == null) {
            return arrayList;
        }
        try {
            Object object;
            Object object2;
            HashMap<File, String> hashMap;
            String string2 = uRL.getProtocol();
            if (string2.equals("file") && (hashMap = srxe._a((File)(object2 = new File(uRL.toURI())), string)) != null) {
                for (Map.Entry object3 : hashMap.entrySet()) {
                    object = (String)object3.getValue() + ((File)object3.getKey()).getName();
                    arrayList.add((String)object);
                }
            }
            if (string2.equals("jar") || string2.equals("zip")) {
                object2 = URLDecoder.decode(uRL.getFile(), "UTF-8");
                int n = ((String)object2).indexOf(33);
                String string3 = ((String)object2).substring(n + 2);
                object2 = new URL(((String)object2).substring(0, n)).getFile();
                ZipFile zipFile = new ZipFile((String)object2);
                object = zipFile.entries();
                while (object.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry)object.nextElement();
                    if (!zipEntry.getName().startsWith(string.substring(1)) || zipEntry.isDirectory()) continue;
                    arrayList.add("/" + zipEntry.getName());
                }
                zipFile.close();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return arrayList;
    }

    private static HashMap<File, String> _a(File file, String string) {
        File[] fileArray;
        HashMap<File, String> hashMap = new HashMap<File, String>();
        for (File file2 : fileArray = file.listFiles()) {
            if (file2.isDirectory()) {
                hashMap.putAll(srxe._a(file2, string + file2.getName() + "/"));
                continue;
            }
            hashMap.put(file2, string);
        }
        return hashMap;
    }

    public static String _b(String string) {
        String string2;
        InputStream inputStream = srxe.class.getResourceAsStream(string);
        try {
            string2 = IOUtils.toString(inputStream, "UTF-8");
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        finally {
            IOUtils.closeQuietly(inputStream);
        }
        return string2;
    }
}

