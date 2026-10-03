/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cl
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
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

public class ci {
    public static by a(InputStream par0InputStream) throws IOException {
        by nbttagcompound;
        DataInputStream datainputstream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(par0InputStream)));
        try {
            nbttagcompound = ci.a(datainputstream);
        }
        finally {
            datainputstream.close();
        }
        return nbttagcompound;
    }

    public static void a(by par0NBTTagCompound, OutputStream par1OutputStream) throws IOException {
        DataOutputStream dataoutputstream = new DataOutputStream(new GZIPOutputStream(par1OutputStream));
        try {
            ci.a(par0NBTTagCompound, dataoutputstream);
        }
        finally {
            dataoutputstream.close();
        }
    }

    public static by a(byte[] par0ArrayOfByte) throws IOException {
        by nbttagcompound;
        DataInputStream datainputstream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(par0ArrayOfByte))));
        try {
            nbttagcompound = ci.a(datainputstream);
        }
        finally {
            datainputstream.close();
        }
        return nbttagcompound;
    }

    public static byte[] a(by par0NBTTagCompound) throws IOException {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        DataOutputStream dataoutputstream = new DataOutputStream(new GZIPOutputStream(bytearrayoutputstream));
        try {
            ci.a(par0NBTTagCompound, dataoutputstream);
        }
        finally {
            dataoutputstream.close();
        }
        return bytearrayoutputstream.toByteArray();
    }

    @SideOnly(value=Side.CLIENT)
    public static void a(by par0NBTTagCompound, File par1File) throws IOException {
        File file2 = new File(par1File.getAbsolutePath() + "_tmp");
        if (file2.exists()) {
            file2.delete();
        }
        ci.b(par0NBTTagCompound, file2);
        if (par1File.exists()) {
            par1File.delete();
        }
        if (par1File.exists()) {
            throw new IOException("Failed to delete " + par1File);
        }
        file2.renameTo(par1File);
    }

    public static by a(DataInput par0DataInput) throws IOException {
        cl nbtbase = cl.a((DataInput)par0DataInput);
        if (nbtbase instanceof by) {
            return (by)nbtbase;
        }
        throw new IOException("Root tag must be a named compound tag");
    }

    public static void a(by par0NBTTagCompound, DataOutput par1DataOutput) throws IOException {
        cl.a((cl)par0NBTTagCompound, (DataOutput)par1DataOutput);
    }

    public static void b(by par0NBTTagCompound, File par1File) throws IOException {
        DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(par1File));
        try {
            ci.a(par0NBTTagCompound, dataoutputstream);
        }
        finally {
            dataoutputstream.close();
        }
    }

    public static by a(File par0File) throws IOException {
        by nbttagcompound;
        if (!par0File.exists()) {
            return null;
        }
        DataInputStream datainputstream = new DataInputStream(new FileInputStream(par0File));
        try {
            nbttagcompound = ci.a(datainputstream);
        }
        finally {
            datainputstream.close();
        }
        return nbttagcompound;
    }
}

