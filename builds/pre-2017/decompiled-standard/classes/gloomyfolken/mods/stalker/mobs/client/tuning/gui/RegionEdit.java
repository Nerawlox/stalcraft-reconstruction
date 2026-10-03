/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.tuning.gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import gloomyfolken.mods.stalker.mobs.StalkerMobsMod;
import gloomyfolken.mods.stalker.mobs.client.StalkerMobsClient;
import gloomyfolken.mods.stalker.mobs.packet.PacketSpawnRegionsAction;
import gloomyfolken.mods.stalker.mobs.packet.PacketSpawnRegionsData;
import gloomyfolken.mods.stalker.mobs.packet.PacketSpawnRegionsState;
import gloomyfolken.mods.stalker.mobs.spawn.region.SpawnRegionEntry;
import gloomyfolken.mods.stalker.mobs.spawn.region.SpawnRegionReader;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.FileUtils;

public class RegionEdit {
    public static RegionEdit instance;
    private JTextField regionsFileName;
    private JButton selectRegionsFile;
    private JCheckBox enableMutantSpawn;
    private JButton uploadRegionsToServer;
    private JButton killMutants;
    private JLabel mutantCount;
    private JPanel root;
    private JButton clearServerRegions;
    private JPanel regionsPanel;
    private JTable regionsEnabledTable;
    private JButton sendEnabledStates;
    private JButton downloadRegions;
    private JButton saveRegionsToFile;
    private String regionsJson = "";
    public HashMap<String, Boolean> overrideRegionsState = new HashMap();
    private boolean wasClosed;

    public static boolean openEditor() {
        if (!RegionEdit.isWindowOpened()) {
            RegionEdit.createWindow();
            return true;
        }
        return false;
    }

    private static boolean isWindowOpened() {
        return instance != null && !RegionEdit.instance.wasClosed;
    }

    private static void createWindow() {
        final RegionEdit regionEdit = new RegionEdit();
        try {
            SwingUtilities.invokeAndWait(() -> {
                JFrame jFrame = new JFrame("\u0417\u0430\u043b\u0438\u0432\u0430\u043b\u043a\u0430 \u0430\u0440\u0435\u0430\u043b\u043e\u0432");
                jFrame.setDefaultCloseOperation(2);
                jFrame.addWindowListener(new WindowListener(){

                    @Override
                    public void windowClosing(WindowEvent windowEvent) {
                    }

                    @Override
                    public void windowClosed(WindowEvent windowEvent) {
                        regionEdit.wasClosed = true;
                    }

                    @Override
                    public void windowIconified(WindowEvent windowEvent) {
                    }

                    @Override
                    public void windowDeiconified(WindowEvent windowEvent) {
                    }

                    @Override
                    public void windowActivated(WindowEvent windowEvent) {
                    }

                    @Override
                    public void windowDeactivated(WindowEvent windowEvent) {
                    }

                    @Override
                    public void windowOpened(WindowEvent windowEvent) {
                    }
                });
                jFrame.add(regionEdit.root);
                jFrame.setLocationRelativeTo(null);
                jFrame.pack();
                jFrame.setVisible(true);
                jFrame.requestFocus();
                jFrame.toFront();
                SwingUtilities.updateComponentTreeUI(jFrame);
            });
        }
        catch (InterruptedException | InvocationTargetException exception) {
            exception.printStackTrace();
        }
    }

    private void $$$setupUI$$$() {
        this.root = new JPanel();
        this.root.setLayout(new GridLayoutManager(1, 2, new Insets(4, 4, 4, 4), -1, -1));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        this.root.add((Component)jPanel, new GridConstraints(0, 0, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        jPanel.add((Component)jPanel2, new GridConstraints(0, 0, 1, 1, 1, 1, 3, 1, null, null, null, 0, false));
        this.regionsFileName = new JTextField();
        jPanel2.add((Component)this.regionsFileName, new GridConstraints(0, 1, 1, 1, 8, 1, 4, 0, null, new Dimension(150, -1), null, 0, false));
        this.selectRegionsFile = new JButton();
        this.selectRegionsFile.setText("...");
        jPanel2.add((Component)this.selectRegionsFile, new GridConstraints(0, 2, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        JLabel jLabel = new JLabel();
        jLabel.setText("\u0424\u0430\u0439\u043b \u0430\u0440\u0435\u0430\u043b\u043e\u0432:");
        jPanel2.add((Component)jLabel, new GridConstraints(0, 0, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new GridLayoutManager(6, 3, new Insets(0, 0, 0, 0), -1, -1));
        jPanel.add((Component)jPanel3, new GridConstraints(1, 0, 1, 1, 2, 1, 3, 1, null, null, null, 0, false));
        this.uploadRegionsToServer = new JButton();
        this.uploadRegionsToServer.setText("\u0417\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c \u043d\u0430 \u0441\u0435\u0440\u0432\u0435\u0440");
        jPanel3.add((Component)this.uploadRegionsToServer, new GridConstraints(0, 0, 1, 3, 0, 1, 3, 0, null, null, null, 0, false));
        this.killMutants = new JButton();
        this.killMutants.setText("\u0423\u0431\u0438\u0442\u044c \u0432\u0441\u0435\u0445 \u043c\u0443\u0442\u0430\u043d\u0442\u043e\u0432");
        jPanel3.add((Component)this.killMutants, new GridConstraints(1, 0, 1, 3, 0, 1, 3, 0, null, null, null, 0, false));
        this.enableMutantSpawn = new JCheckBox();
        this.enableMutantSpawn.setSelected(true);
        this.enableMutantSpawn.setText("\u0412\u043a\u043b\u044e\u0447\u0438\u0442\u044c \u0441\u043f\u0430\u0432\u043d \u043c\u0443\u0442\u0430\u043d\u0442\u043e\u0432");
        jPanel3.add((Component)this.enableMutantSpawn, new GridConstraints(5, 0, 1, 1, 8, 0, 3, 0, null, null, null, 0, false));
        JLabel jLabel2 = new JLabel();
        jLabel2.setText("\u041c\u0443\u0442\u0430\u043d\u0442\u043e\u0432 \u0432\u0441\u0435\u0433\u043e:");
        jPanel3.add((Component)jLabel2, new GridConstraints(5, 1, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        this.mutantCount = new JLabel();
        this.mutantCount.setText("0/0");
        jPanel3.add((Component)this.mutantCount, new GridConstraints(5, 2, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        this.clearServerRegions = new JButton();
        this.clearServerRegions.setText("\u041e\u0447\u0438\u0441\u0442\u0438\u0442\u044c \u0432\u0441\u0435 \u0430\u0440\u0435\u0430\u043b\u044b \u043d\u0430 \u0441\u0435\u0440\u0432\u0435\u0440\u0435");
        jPanel3.add((Component)this.clearServerRegions, new GridConstraints(2, 0, 1, 3, 0, 1, 3, 0, null, null, null, 0, false));
        this.downloadRegions = new JButton();
        this.downloadRegions.setText("\u0421\u043a\u0430\u0447\u0430\u0442\u044c \u0430\u0440\u0435\u0430\u043b\u044b \u0441 \u0441\u0435\u0440\u0432\u0435\u0440\u0430");
        jPanel3.add((Component)this.downloadRegions, new GridConstraints(3, 0, 1, 3, 0, 1, 3, 0, null, null, null, 0, false));
        this.saveRegionsToFile = new JButton();
        this.saveRegionsToFile.setText("\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c \u0430\u0440\u0435\u0430\u043b\u044b \u0432 \u0444\u0430\u0439\u043b");
        jPanel3.add((Component)this.saveRegionsToFile, new GridConstraints(4, 0, 1, 3, 0, 1, 3, 0, null, null, null, 0, false));
        JPanel jPanel4 = new JPanel();
        jPanel4.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        this.root.add((Component)jPanel4, new GridConstraints(0, 1, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
        jPanel4.setBorder(BorderFactory.createTitledBorder("\u0410\u043a\u0442\u0438\u0432\u043d\u043e\u0441\u0442\u044c \u0430\u0440\u0435\u0430\u043b\u043e\u0432"));
        this.sendEnabledStates = new JButton();
        this.sendEnabledStates.setText("\u041e\u0431\u043d\u043e\u0432\u0438\u0442\u044c");
        jPanel4.add((Component)this.sendEnabledStates, new GridConstraints(0, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        JPanel jPanel5 = new JPanel();
        jPanel5.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        jPanel4.add((Component)jPanel5, new GridConstraints(1, 0, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
        JScrollPane jScrollPane = new JScrollPane();
        jPanel5.add((Component)jScrollPane, new GridConstraints(0, 0, 1, 1, 0, 3, 5, 5, null, null, null, 0, false));
        this.regionsPanel = new JPanel();
        this.regionsPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        jScrollPane.setViewportView(this.regionsPanel);
        this.regionsEnabledTable = new JTable();
        this.regionsPanel.add((Component)this.regionsEnabledTable, new GridConstraints(0, 0, 1, 1, 0, 3, 4, 4, null, new Dimension(150, 50), null, 0, false));
    }

    public JComponent $$$getRootComponent$$$() {
        return this.root;
    }

    private RegionEdit() {
        instance = this;
        this.$$$setupUI$$$();
        this.regionsEnabledTable.setModel(new RegionTableModel(this.overrideRegionsState));
        this.regionsFileName.setText(StalkerMobsMod.instance.config.get("client", "regionsFileName", "").getString());
        try {
            this.regionsJson = FileUtils.readFileToString(this.getRegionsFile());
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        this.validate();
        this.killMutants.addActionListener(actionEvent -> new PacketSpawnRegionsAction(0).sendToServer());
        this.uploadRegionsToServer.addActionListener(actionEvent -> {
            StalkerMobsMod.instance.config.get("client", "regionsFileName", "").set(this.regionsFileName.getText());
            StalkerMobsMod.instance.config.save();
            StalkerMobsClient.getInstance().updateLocalRegionsData();
            new PacketSpawnRegionsData(this.regionsJson, 0).sendToServer();
        });
        this.enableMutantSpawn.addActionListener(actionEvent -> new PacketSpawnRegionsAction(this.enableMutantSpawn.isSelected() ? 2 : 1).sendToServer());
        this.selectRegionsFile.addActionListener(actionEvent -> {
            String string = "";
            File file = null;
            try {
                file = this.getRegionsFile();
                string = file.getParent();
            }
            catch (Exception exception) {
                // empty catch block
            }
            JFileChooser jFileChooser = new JFileChooser(string);
            if (file != null) {
                jFileChooser.setSelectedFile(file);
            }
            jFileChooser.setFileFilter(new FileFilter(){

                @Override
                public boolean accept(File file) {
                    return file.getName().endsWith(".json") || file.isDirectory();
                }

                @Override
                public String getDescription() {
                    return "Choose a spawn regions file!";
                }
            });
            if (jFileChooser.showOpenDialog(null) == 0) {
                try {
                    this.regionsFileName.setText(jFileChooser.getSelectedFile().getPath());
                    this.regionsJson = FileUtils.readFileToString(this.getRegionsFile());
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                this.validate();
            }
        });
        this.clearServerRegions.addActionListener(actionEvent -> new PacketSpawnRegionsData("", 0).sendToServer());
        this.sendEnabledStates.addActionListener(actionEvent -> new PacketSpawnRegionsState(this.overrideRegionsState).sendToServer());
        this.downloadRegions.addActionListener(actionEvent -> new PacketSpawnRegionsData("", 1).sendToServer());
        this.saveRegionsToFile.addActionListener(actionEvent -> {
            JFileChooser jFileChooser = new JFileChooser();
            File file = new File(jFileChooser.getCurrentDirectory(), "server_regions.json");
            jFileChooser.setSelectedFile(file);
            int n = jFileChooser.showSaveDialog(null);
            if (n == 0) {
                try {
                    FileUtils.writeStringToFile(jFileChooser.getSelectedFile(), this.regionsJson);
                }
                catch (IOException iOException) {
                    JOptionPane.showMessageDialog(null, "\u041e\u0448\u0438\u0431\u043a\u0430: " + iOException.getLocalizedMessage());
                    iOException.printStackTrace();
                }
            }
        });
        new PacketSpawnRegionsState(null).sendToServer();
        new PacketSpawnRegionsData("", 1).sendToServer();
    }

    public void saveRegionsToFileAndSetActive() throws IOException {
        File file = new File(new File("."), "downloaded_regions.json");
        FileUtils.writeStringToFile(file, this.regionsJson);
        this.regionsFileName.setText(file.getPath());
        StalkerMobsMod.instance.config.get("client", "regionsFileName", "").set(this.regionsFileName.getText());
        StalkerMobsMod.instance.config.save();
        StalkerMobsClient.getInstance().updateLocalRegionsData();
    }

    public void setRegionsData(String string) {
        this.regionsJson = string;
        this.validate();
    }

    public void setMutantCount(int n, int n2) {
        this.mutantCount.setText(n + "/" + n2);
    }

    private File getRegionsFile() {
        return new File(this.regionsFileName.getText());
    }

    private void updateRegions(boolean bl2) {
        RegionTableModel regionTableModel = (RegionTableModel)this.regionsEnabledTable.getModel();
        regionTableModel.setRowCount(0);
        regionTableModel.setColumnCount(2);
        if (bl2) {
            Map<String, SpawnRegionEntry> map = SpawnRegionReader.INSTANCE.readRegions(this.regionsJson, null);
            regionTableModel.setRowCount(map.size());
            map.forEach((string, spawnRegionEntry) -> this.overrideRegionsState.putIfAbsent((String)string, true));
            this.overrideRegionsState.entrySet().removeIf(entry -> !map.keySet().contains(entry.getKey()));
            int[] nArray = new int[]{0};
            this.overrideRegionsState.forEach((string, bl) -> {
                regionTableModel.setValueAt(string, nArray[0], 0);
                regionTableModel.setValueAt(bl, nArray[0], 1);
                nArray[0] = nArray[0] + 1;
            });
        }
    }

    private void validate() {
        this.uploadRegionsToServer.setEnabled(false);
        boolean bl = true;
        try {
            Map<String, SpawnRegionEntry> map = SpawnRegionReader.INSTANCE.readRegions(this.regionsJson, null);
            if (map == null || map.isEmpty()) {
                bl = false;
            }
        }
        catch (Exception exception) {
            bl = false;
        }
        this.updateRegions(bl);
        this.uploadRegionsToServer.setEnabled(bl);
        this.regionsEnabledTable.setEnabled(bl);
        this.sendEnabledStates.setEnabled(bl);
    }

    private static class RegionTableModel
    extends DefaultTableModel {
        Map<String, Boolean> overrideRegionsState;

        RegionTableModel(Map<String, Boolean> map) {
            this.overrideRegionsState = map;
        }

        @Override
        public Class<?> getColumnClass(int n) {
            if (n == 1) {
                return Boolean.class;
            }
            return String.class;
        }

        @Override
        public boolean isCellEditable(int n, int n2) {
            return n2 == 1;
        }

        @Override
        public void setValueAt(Object object, int n, int n2) {
            super.setValueAt(object, n, n2);
            if (n2 == 1) {
                Boolean bl = (Boolean)this.getValueAt(n, 1);
                String string = (String)this.getValueAt(n, 0);
                this.overrideRegionsState.put(string, bl);
                SpawnRegionEntry spawnRegionEntry = StalkerMobsClient.getInstance().getLocalRegionsData().get(string);
                if (spawnRegionEntry != null) {
                    spawnRegionEntry.getConfiguration().setEnabled(bl);
                }
            }
        }
    }
}

