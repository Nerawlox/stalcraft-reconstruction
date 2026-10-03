/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class bsvf {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static qoac _a(InputStream inputStream) throws IOException {
        qoac qoac2;
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(inputStream)));
        try {
            qoac2 = bsvf._a(dataInputStream);
        }
        finally {
            dataInputStream.close();
        }
        return qoac2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void _a(qoac qoac2, OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new GZIPOutputStream(outputStream));
        try {
            bsvf._a(qoac2, dataOutputStream);
        }
        finally {
            dataOutputStream.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static qoac _a(byte[] byArray) throws IOException {
        qoac qoac2;
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(byArray))));
        try {
            qoac2 = bsvf._a(dataInputStream);
        }
        finally {
            dataInputStream.close();
        }
        return qoac2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static byte[] _a(qoac qoac2) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(new GZIPOutputStream(byteArrayOutputStream));
        try {
            bsvf._a(qoac2, dataOutputStream);
        }
        finally {
            dataOutputStream.close();
        }
        return byteArrayOutputStream.toByteArray();
    }

    @SideOnly(value=Side.CLIENT)
    public static void _a(qoac qoac2, File file) throws IOException {
        File file2 = new File(file.getAbsolutePath() + "_tmp");
        if (file2.exists()) {
            file2.delete();
        }
        bsvf._b(qoac2, file2);
        if (file.exists()) {
            file.delete();
        }
        if (file.exists()) {
            throw new IOException("Failed to delete " + file);
        }
        file2.renameTo(file);
    }

    public static qoac _a(DataInput dataInput) throws IOException {
        huhy huhy2 = huhy._a(dataInput);
        if (huhy2 instanceof qoac) {
            return (qoac)huhy2;
        }
        throw new IOException("Root tag must be a named compound tag");
    }

    public static void _a(qoac qoac2, DataOutput dataOutput) throws IOException {
        huhy._a(qoac2, dataOutput);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void _b(qoac qoac2, File file) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            bsvf._a(qoac2, dataOutputStream);
        }
        finally {
            dataOutputStream.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static qoac _a(File file) throws IOException {
        qoac qoac2;
        if (!file.exists()) {
            return null;
        }
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            qoac2 = bsvf._a(dataInputStream);
        }
        finally {
            dataInputStream.close();
        }
        return qoac2;
    }
}

