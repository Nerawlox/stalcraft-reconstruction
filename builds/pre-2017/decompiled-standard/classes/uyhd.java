/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.GloomyCore;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Comparator;
import java.util.stream.Stream;
import net.minecraft.client.xpzm;
import net.minecraft.launchwrapper.Launch;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.tuple.Pair;

public class uyhd {
    private static final int _a = 0;
    private static final int _b = 1;

    public void _a(String string) {
        String string2 = GloomyCore.mcconfig.get("general", "log_upload_host", "127.0.0.1").getString();
        int n = GloomyCore.mcconfig.get("general", "log_upload_port", 28889).getInt(28889);
        GloomyCore.mcconfig.save();
        try {
            Pair<File, File> pair = this._a();
            File file = pair.getLeft();
            File file2 = pair.getRight();
            if (file == null) {
                return;
            }
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(string2, n));
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(string);
            if (file2 == null) {
                dataOutputStream.writeInt(1);
            } else {
                dataOutputStream.writeInt(2);
            }
            uyhd._a(file, 0, dataOutputStream);
            if (file2 != null) {
                uyhd._a(file2, 1, dataOutputStream);
            }
            socket.close();
            file.delete();
            if (file2 != null) {
                file2.delete();
            }
            System.out.println("Finished uploading logs");
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private Pair<File, File> _a() {
        File file = new File(xpzm._E()._P, "crash-reports");
        File file2 = Stream.of(file.listFiles()).max(Comparator.comparing(File::lastModified)).orElse(null);
        if (file2 == null) {
            return Pair.of(null, null);
        }
        File file3 = new File(Launch.minecraftHome, "ForgeModLoader-client-1.log");
        if (file3.exists()) {
            return Pair.of(file2, file3);
        }
        return Pair.of(file2, null);
    }

    private static void _a(File file, int n, DataOutputStream dataOutputStream) throws IOException {
        if (file.isDirectory() || !file.exists()) {
            dataOutputStream.writeLong(0L);
            return;
        }
        String string = FilenameUtils.getBaseName(file.getName());
        dataOutputStream.writeByte(n);
        dataOutputStream.writeUTF(string);
        try (FileInputStream fileInputStream = new FileInputStream(file);){
            dataOutputStream.writeLong(fileInputStream.getChannel().size());
            IOUtils.copy((InputStream)fileInputStream, (OutputStream)dataOutputStream);
        }
    }
}

