/*
 * Decompiled with CFR 0.152.
 */
package optifine;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class Utils {
    public static final String MAC_OS_HOME_PREFIX = "Library/Application Support";
    private static int[] $SWITCH_TABLE$optifine$Utils$OS;

    public static File getWorkingDirectory() {
        return Utils.getWorkingDirectory("minecraft");
    }

    public static File getWorkingDirectory(String string) {
        String string2 = System.getProperty("user.home", ".");
        File file = null;
        switch (Utils.$SWITCH_TABLE$optifine$Utils$OS()[Utils.getPlatform().ordinal()]) {
            case 1: 
            case 2: {
                file = new File(string2, '.' + string + '/');
                break;
            }
            case 3: {
                String string3 = System.getenv("APPDATA");
                if (string3 != null) {
                    file = new File(string3, "." + string + '/');
                    break;
                }
                file = new File(string2, '.' + string + '/');
                break;
            }
            case 4: {
                file = new File(string2, "Library/Application Support/" + string);
                break;
            }
            default: {
                file = new File(string2, string + '/');
            }
        }
        if (!file.exists() && !file.mkdirs()) {
            throw new RuntimeException("The working directory could not be created: " + file);
        }
        return file;
    }

    public static OS getPlatform() {
        String string = System.getProperty("os.name").toLowerCase();
        return string.contains("win") ? OS.WINDOWS : (string.contains("mac") ? OS.MACOS : (string.contains("solaris") ? OS.SOLARIS : (string.contains("sunos") ? OS.SOLARIS : (string.contains("linux") ? OS.LINUX : (string.contains("unix") ? OS.LINUX : OS.UNKNOWN)))));
    }

    public static int find(byte[] byArray, byte[] byArray2) {
        return Utils.find(byArray, 0, byArray2);
    }

    public static int find(byte[] byArray, int n, byte[] byArray2) {
        for (int i = n; i < byArray.length - byArray2.length; ++i) {
            boolean bl = true;
            for (int j = 0; j < byArray2.length; ++j) {
                if (byArray2[j] == byArray[i + j]) {
                    continue;
                }
                bl = false;
                break;
            }
            if (!bl) continue;
            return i;
        }
        return -1;
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

    public static void dbg(String string) {
        System.out.println(string);
    }

    public static String[] tokenize(String string, String string2) {
        String[] stringArray;
        ArrayList<String[]> arrayList = new ArrayList<String[]>();
        StringTokenizer stringTokenizer = new StringTokenizer(string, string2);
        while (stringTokenizer.hasMoreTokens()) {
            stringArray = stringTokenizer.nextToken();
            arrayList.add(stringArray);
        }
        stringArray = arrayList.toArray(new String[arrayList.size()]);
        return stringArray;
    }

    public static String getExceptionStackTrace(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        printWriter.close();
        try {
            stringWriter.close();
        }
        catch (IOException iOException) {
            // empty catch block
        }
        return stringWriter.getBuffer().toString();
    }

    public static void copyFile(File file, File file2) throws IOException {
        if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            Utils.copyAll(fileInputStream, fileOutputStream);
            fileOutputStream.flush();
            fileInputStream.close();
            fileOutputStream.close();
        }
    }

    public static void copyAll(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] byArray = new byte[1024];
        int n;
        while ((n = inputStream.read(byArray)) >= 0) {
            outputStream.write(byArray, 0, n);
        }
        return;
    }

    public static void showMessage(String string) {
        JOptionPane.showMessageDialog(null, string, "OptiFine", 1);
    }

    public static void showErrorMessage(String string) {
        JOptionPane.showMessageDialog(null, string, "Error", 0);
    }

    public static String readFile(File file) throws IOException {
        return Utils.readFile(file, "ASCII");
    }

    public static String readFile(File file, String string) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader((InputStream)fileInputStream, string);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String string2;
            if ((string2 = bufferedReader.readLine()) == null) {
                bufferedReader.close();
                inputStreamReader.close();
                fileInputStream.close();
                return stringBuffer.toString();
            }
            stringBuffer.append(string2);
            stringBuffer.append("\n");
        }
    }

    public static void centerWindow(Component component, Component component2) {
        if (component != null) {
            Rectangle rectangle;
            Rectangle rectangle2 = component.getBounds();
            if (component2 != null && component2.isVisible()) {
                rectangle = component2.getBounds();
            } else {
                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                rectangle = new Rectangle(0, 0, dimension.width, dimension.height);
            }
            int n = rectangle.x + (rectangle.width - rectangle2.width) / 2;
            int n2 = rectangle.y + (rectangle.height - rectangle2.height) / 2;
            if (n < 0) {
                n = 0;
            }
            if (n2 < 0) {
                n2 = 0;
            }
            component.setBounds(n, n2, rectangle2.width, rectangle2.height);
        }
    }

    static int[] $SWITCH_TABLE$optifine$Utils$OS() {
        if ($SWITCH_TABLE$optifine$Utils$OS != null) {
            return $SWITCH_TABLE$optifine$Utils$OS;
        }
        int[] nArray = new int[OS.values().length];
        try {
            nArray[OS.LINUX.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            nArray[OS.MACOS.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            nArray[OS.SOLARIS.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            nArray[OS.UNKNOWN.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            nArray[OS.WINDOWS.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        $SWITCH_TABLE$optifine$Utils$OS = nArray;
        return nArray;
    }

    public static enum OS {
        LINUX("LINUX", 0),
        SOLARIS("SOLARIS", 1),
        WINDOWS("WINDOWS", 2),
        MACOS("MACOS", 3),
        UNKNOWN("UNKNOWN", 4);

        private static final OS[] ENUM$VALUES;

        private OS(String string2, int n2) {
        }

        static {
            ENUM$VALUES = new OS[]{LINUX, SOLARIS, WINDOWS, MACOS, UNKNOWN};
        }
    }
}

