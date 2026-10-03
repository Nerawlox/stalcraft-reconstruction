/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import net.minecraft.client.xpzm;

public class TMIUninstaller {
    private static File jarFile;
    public static InstallerGui mainframe;

    public static void main(String[] stringArray) {
        jarFile = new File(stringArray[0]);
        InstallerGui.installLnF();
        mainframe = new InstallerGui();
        mainframe.setDefaultCloseOperation(3);
        mainframe.setLocationRelativeTo(null);
        mainframe.pack();
        mainframe.setVisible(true);
        if (!jarFile.exists()) {
            mainframe.getLabelInfo().setText("Invalid Minecraft.jar");
        } else {
            TMIUninstaller.uninstall();
        }
    }

    private static File getJarFile() {
        URL uRL = xpzm.class.getProtectionDomain().getCodeSource().getLocation();
        try {
            if (uRL.getProtocol().equals("jar")) {
                uRL = new URL(uRL.getPath().substring(0, uRL.getPath().indexOf(33)));
            }
            return new File(uRL.toURI());
        }
        catch (URISyntaxException uRISyntaxException) {
            return new File(uRL.getPath());
        }
        catch (MalformedURLException malformedURLException) {
            throw new RuntimeException(malformedURLException);
        }
    }

    public static void deleteTMIUninstaller() throws IOException {
        System.out.println("Removing TMI Uninstaller");
        TMIUninstaller.deleteDir(new File(TMIUninstaller.getJarFile().getParentFile(), "TMIUninstaller"), true);
    }

    public static boolean TMIInstalled() {
        File file = TMIUninstaller.getJarFile();
        if (!file.getName().endsWith(".jar")) {
            return false;
        }
        try {
            ZipFile zipFile = new ZipFile(file);
            ZipEntry zipEntry = zipFile.getEntry("mod_TooManyItems.class");
            zipFile.close();
            return zipEntry != null;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public static void runTMIUninstaller() throws IOException {
        Object object;
        Object object2;
        Object object3;
        String string;
        Object object4;
        System.out.println("Installing Uninstaller.");
        File file = TMIUninstaller.getJarFile();
        File file2 = new File(file.getParentFile(), "TMIUninstaller");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        System.out.println("Installing Uninstaller: " + file2.getPath());
        FileInputStream fileInputStream = new FileInputStream(file);
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
        while ((object4 = zipInputStream.getNextEntry()) != null) {
            string = ((ZipEntry)object4).getName().replace('\\', '/');
            if (((ZipEntry)object4).isDirectory() || !string.replace('/', '.').startsWith(TMIUninstaller.class.getCanonicalName())) continue;
            object3 = new File(file2, string);
            System.out.println("Extracting File: " + ((File)object3).getPath());
            if (!((File)object3).getParentFile().exists()) {
                ((File)object3).getParentFile().mkdirs();
            }
            ((File)object3).createNewFile();
            object2 = new FileOutputStream((File)object3);
            object = new byte[65535];
            int n = 0;
            while ((n = zipInputStream.read((byte[])object)) != -1) {
                ((FileOutputStream)object2).write((byte[])object, 0, n);
            }
            ((FileOutputStream)object2).close();
        }
        fileInputStream.close();
        object4 = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        string = file2.getAbsolutePath();
        object3 = TMIUninstaller.class.getCanonicalName();
        object2 = file.getPath();
        System.out.println("Running Process: " + (String)object4 + " -cp \"" + string + "\" \"" + (String)object3 + "\" \"" + (String)object2 + "\"");
        object = new ProcessBuilder(new String[]{object4, "-cp", string, object3, object2});
        ((ProcessBuilder)object).start();
    }

    public static void deleteDir(File file, boolean bl) throws IOException {
        System.out.println("Deleting Dir: " + file.getPath());
        if (!file.exists()) {
            if (!bl) {
                file.mkdirs();
            }
            return;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                TMIUninstaller.deleteDir(file2, true);
                continue;
            }
            if (file2.delete()) continue;
            throw new IOException("Delete Failed: " + file2);
        }
        if (bl) {
            if (!file.delete()) {
                throw new IOException("Delete Failed: " + file);
            }
        }
    }

    public static void uninstall() {
        File file = new File(jarFile.getParentFile(), jarFile.getName() + ".bak");
        try {
            ZipEntry zipEntry;
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            FileInputStream fileInputStream = new FileInputStream(jarFile);
            fileOutputStream.getChannel().transferFrom(fileInputStream.getChannel(), 0L, jarFile.length());
            fileOutputStream.close();
            fileInputStream.close();
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(jarFile));
            byte[] byArray = new byte[20000];
            int n = 0;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                String string;
                if (zipEntry.isDirectory() || (string = zipEntry.getName()).startsWith("TMI") || string.startsWith("_tmi") || string.startsWith("tmi.png") || string.startsWith("mod_TooManyItems")) continue;
                zipOutputStream.putNextEntry(new ZipEntry(string));
                ZipInputStream zipInputStream2 = zipInputStream;
                while ((n = ((InputStream)zipInputStream2).read(byArray)) != -1) {
                    zipOutputStream.write(byArray, 0, n);
                }
                zipOutputStream.closeEntry();
                zipInputStream.closeEntry();
            }
            zipInputStream.close();
            zipOutputStream.close();
            mainframe.getLabelInfo().setText("Uninstall Completed. Close this and restart minecraft.");
        }
        catch (Exception exception) {
            exception.printStackTrace();
            mainframe.getLabelInfo().setText("Invalid Minecraft.jar");
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(jarFile);
                fileOutputStream.getChannel().transferFrom(fileInputStream.getChannel(), 0L, file.length());
                fileInputStream.close();
                fileOutputStream.close();
            }
            catch (Exception exception2) {
                exception2.printStackTrace();
            }
        }
    }

    public static class InstallerGui
    extends JFrame {
        private static final long serialVersionUID = 1L;
        private JTextField labelInfo;
        private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

        public InstallerGui() {
            this.setTitle("TMI Uninstaller");
            this.initComponents();
        }

        private void initComponents() {
            this.setLayout(new ResizeListener());
            this.add(this.getLabelInfo());
            this.setSize(358, 270);
        }

        public JTextField getLabelInfo() {
            if (this.labelInfo == null) {
                this.labelInfo = new JTextField();
                this.labelInfo.setFont(new Font("Tahoma", 0, 13));
                this.labelInfo.setHorizontalAlignment(0);
                this.labelInfo.setEditable(false);
                this.labelInfo.setText("Uninstalling TMI");
            }
            return this.labelInfo;
        }

        public static void installLnF() {
            try {
                String string = UIManager.getCrossPlatformLookAndFeelClassName();
                UIManager.setLookAndFeel(string);
            }
            catch (Exception exception) {
                System.err.println("Cannot install com.sun.java.swing.plaf.windows.WindowsLookAndFeel on this platform:" + exception.getMessage());
            }
        }

        public class InstallerListener
        implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            }
        }

        private class ResizeListener
        implements LayoutManager {
            private ResizeListener() {
            }

            @Override
            public void addLayoutComponent(String string, Component component) {
            }

            @Override
            public void layoutContainer(Container container) {
                int n = InstallerGui.this.getContentPane().getWidth();
                InstallerGui.this.labelInfo.setBounds(10, 45, n - 20, 20);
                InstallerGui.this.labelInfo.setScrollOffset(1000);
                InstallerGui.this.labelInfo.update(InstallerGui.this.getGraphics());
            }

            @Override
            public Dimension minimumLayoutSize(Container container) {
                return new Dimension(150, 100);
            }

            @Override
            public Dimension preferredLayoutSize(Container container) {
                return new Dimension(250, 120);
            }

            @Override
            public void removeLayoutComponent(Component component) {
            }
        }
    }
}

