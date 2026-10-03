/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.tuning.gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import gloomyfolken.mods.core.misc.hanr;
import gloomyfolken.mods.shop.data.CaseData;
import gloomyfolken.mods.shop.data.CaseType;
import gloomyfolken.mods.stalker.mobs.client.tuning.gui.LootGroupEdit;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.prefs.Preferences;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class CaseEditor {
    private JPanel root;
    private JButton newCaseBtn;
    private JButton deleteCaseBtn;
    private JButton editCaseBtn;
    private JList caseList;
    private JButton saveToFileBtn;
    private JTextField caseName;
    private JTextField caseIcon;
    private JSpinner caseCost;
    private JSpinner caseId;
    private JCheckBox caseIsListable;
    private JCheckBox caseIsKit;
    private JButton openCaseFile;
    private JPanel caseProps;
    private JTable rarityTable;
    private File caseFileIn;
    private File caseFileOut;
    private CaseType activeCase = null;
    private CaseData caseData = null;
    private List<CaseType> openedCases = new ArrayList<CaseType>();
    private boolean changed = false;
    private boolean wasClosed = false;
    private final String LAST_IMPORT_FOLDER = "last_import_folder";
    private final String LAST_EXPORT_FOLDER = "last_export_folder";
    private int NEXT_CASE_ID = 0;
    private FileFilter jsonFilter = new FileFilter(){

        @Override
        public boolean accept(File file) {
            return file.getName().endsWith("json") || file.isDirectory();
        }

        @Override
        public String getDescription() {
            return "Open json file";
        }
    };
    private Preferences prefs = Preferences.userRoot().node(this.getClass().getName());
    private List<JComponent> eventListenerOwners = new ArrayList<JComponent>();
    private static CaseEditor instance;

    public static boolean openEditor() {
        if (!CaseEditor.isWindowOpened()) {
            CaseEditor.createWindow();
            return true;
        }
        return false;
    }

    private static boolean isWindowOpened() {
        return instance != null && !CaseEditor.instance.wasClosed;
    }

    public static CaseEditor createWindow() {
        final CaseEditor caseEditor = new CaseEditor();
        final JFrame jFrame = new JFrame("\u0420\u0435\u0434\u0430\u043a\u0442\u043e\u0440 \u043a\u0435\u0439\u0441\u043e\u0432");
        jFrame.setDefaultCloseOperation(0);
        jFrame.add(caseEditor.root);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.addWindowListener(new WindowListener(){

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                if (caseEditor.changed) {
                    int n = JOptionPane.showConfirmDialog(null, "\u0415\u0441\u0442\u044c \u043d\u0435\u0441\u043e\u0445\u0440\u0430\u043d\u0435\u043d\u043d\u044b\u0435 \u0438\u0437\u043c\u0435\u043d\u0435\u043d\u0438\u044f. \u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c?", "\u0412\u044b\u0445\u043e\u0434", 1);
                    if (n == 0) {
                        caseEditor.changed = false;
                        caseEditor.openSaveDialog();
                        caseEditor.wasClosed = true;
                    } else if (n == 2) {
                        return;
                    }
                }
                jFrame.dispose();
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
                caseEditor.wasClosed = true;
            }

            @Override
            public void windowOpened(WindowEvent windowEvent) {
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
        });
        return caseEditor;
    }

    public static void main(String[] stringArray) {
        CaseEditor.createWindow();
    }

    private CaseEditor() {
        instance = this;
        this.$$$setupUI$$$();
        this.setupReactions();
        this.setActiveCase(null);
        this.setActiveCaseData(new CaseData(), false);
    }

    private void createUIComponents() {
        this.rarityTable = new JTableFuckTheSwing(new DefaultTableModel(new String[]{"\u0412\u0438\u0434", "\u0420\u0435\u0434\u043a\u043e\u0441\u0442\u044c"}, 0)){

            @Override
            public void setValueAt(Object object, int n, int n2) {
                try {
                    Float.parseFloat(object.toString());
                    super.setValueAt(object, n, n2);
                }
                catch (Exception exception) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }

            @Override
            public boolean isCellEditable(int n, int n2) {
                return n2 == 1;
            }
        };
        this.resetRarityTable();
    }

    private void resetRarityTable() {
        this.rarityModel().setRowCount(0);
        for (hanr hanr2 : hanr.values()) {
            this.rarityModel().addRow(new Object[]{hanr2.name(), Float.valueOf(0.0f)});
        }
    }

    private void fillRarityTable(CaseType caseType) {
        if (caseType != null && caseType.rarityDist != null) {
            caseType.rarityDist.forEach((hanr2, f) -> this.rarityModel().setValueAt(f, hanr2.ordinal(), 1));
        }
    }

    private void addActionListenerOwner(JComponent jComponent) {
        this.eventListenerOwners.add(jComponent);
    }

    private DefaultTableModel rarityModel() {
        return (DefaultTableModel)this.rarityTable.getModel();
    }

    private void updateActiveRowRarity() {
        int n = this.rarityTable.getSelectedRow();
        if (this.activeCase != null && n >= 0) {
            if (this.activeCase.rarityDist == null) {
                this.activeCase.rarityDist = new LinkedHashMap<hanr, Float>();
            }
            hanr hanr2 = hanr.values()[n];
            this.activeCase.rarityDist.remove((Object)hanr2);
            try {
                float f = Float.parseFloat((String)this.rarityTable.getValueAt(n, 1));
                if ((double)f > 0.0) {
                    this.activeCase.rarityDist.put(hanr2, Float.valueOf(f));
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            ArrayList<Map.Entry> arrayList = new ArrayList<Map.Entry>();
            for (Map.Entry<hanr, Float> object : this.activeCase.rarityDist.entrySet()) {
                arrayList.add(object);
            }
            arrayList.sort(Comparator.comparing(entry -> (Float)entry.getValue()).thenComparing(entry -> -((hanr)((Object)((Object)((Object)entry.getKey())))).ordinal()));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry2 : arrayList) {
                if (linkedHashMap.put(entry2.getKey(), entry2.getValue()) == null) continue;
                throw new IllegalStateException("Duplicate key");
            }
            this.activeCase.rarityDist = linkedHashMap;
        }
    }

    private void $$$setupUI$$$() {
        this.createUIComponents();
        this.root = new JPanel();
        this.root.setLayout(new GridLayoutManager(4, 2, new Insets(4, 4, 4, 4), -1, -1));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        this.root.add((Component)jPanel, new GridConstraints(1, 0, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
        JScrollPane jScrollPane = new JScrollPane();
        jPanel.add((Component)jScrollPane, new GridConstraints(1, 0, 1, 1, 0, 3, 5, 5, null, null, null, 0, false));
        this.caseList = new JList();
        jScrollPane.setViewportView(this.caseList);
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridLayoutManager(1, 5, new Insets(0, 0, 0, 0), -1, -1));
        jPanel.add((Component)jPanel2, new GridConstraints(0, 0, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
        JLabel jLabel = new JLabel();
        jLabel.setText("\u0421\u043f\u0438\u0441\u043e\u043a \u043a\u0435\u0439\u0441\u043e\u0432:");
        jPanel2.add((Component)jLabel, new GridConstraints(0, 2, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        Spacer spacer = new Spacer();
        jPanel2.add((Component)spacer, new GridConstraints(0, 3, 1, 1, 0, 1, 4, 1, null, null, null, 0, false));
        this.saveToFileBtn = new JButton();
        this.saveToFileBtn.setText("\u0421\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c \u0444\u0430\u0439\u043b \u043a\u0435\u0439\u0441\u043e\u0432");
        jPanel2.add((Component)this.saveToFileBtn, new GridConstraints(0, 4, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.openCaseFile = new JButton();
        this.openCaseFile.setText("\u041e\u0442\u043a\u0440\u044b\u0442\u044c \u0444\u0430\u0439\u043b \u043a\u0435\u0439\u0441\u043e\u0432");
        jPanel2.add((Component)this.openCaseFile, new GridConstraints(0, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        Spacer spacer2 = new Spacer();
        jPanel2.add((Component)spacer2, new GridConstraints(0, 1, 1, 1, 0, 1, 4, 1, null, null, null, 0, false));
        this.caseProps = new JPanel();
        this.caseProps.setLayout(new GridLayoutManager(3, 5, new Insets(0, 0, 0, 0), -1, -1));
        jPanel.add((Component)this.caseProps, new GridConstraints(2, 0, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
        this.caseProps.setBorder(BorderFactory.createTitledBorder("\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u043a\u0435\u0439\u0441\u0430"));
        JLabel jLabel2 = new JLabel();
        jLabel2.setText("ID \u043a\u0435\u0439\u0441\u0430:");
        this.caseProps.add((Component)jLabel2, new GridConstraints(0, 3, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        this.caseId = new JSpinner();
        this.caseProps.add((Component)this.caseId, new GridConstraints(0, 4, 1, 1, 8, 1, 4, 0, null, null, null, 0, false));
        JLabel jLabel3 = new JLabel();
        jLabel3.setText("\u0426\u0435\u043d\u0430:");
        this.caseProps.add((Component)jLabel3, new GridConstraints(1, 3, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        this.caseCost = new JSpinner();
        this.caseProps.add((Component)this.caseCost, new GridConstraints(1, 4, 1, 1, 8, 1, 4, 0, null, null, null, 0, false));
        JLabel jLabel4 = new JLabel();
        jLabel4.setText("\u0418\u043c\u044f:");
        this.caseProps.add((Component)jLabel4, new GridConstraints(0, 0, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        Spacer spacer3 = new Spacer();
        this.caseProps.add((Component)spacer3, new GridConstraints(0, 1, 1, 1, 0, 1, 4, 1, null, null, null, 0, false));
        this.caseName = new JTextField();
        this.caseProps.add((Component)this.caseName, new GridConstraints(0, 2, 1, 1, 8, 1, 4, 0, null, new Dimension(150, -1), null, 0, false));
        JLabel jLabel5 = new JLabel();
        jLabel5.setText("\u0418\u043a\u043e\u043d\u043a\u0430:");
        this.caseProps.add((Component)jLabel5, new GridConstraints(1, 0, 1, 1, 8, 0, 0, 0, null, null, null, 0, false));
        this.caseIcon = new JTextField();
        this.caseProps.add((Component)this.caseIcon, new GridConstraints(1, 2, 1, 1, 8, 1, 4, 0, null, new Dimension(150, -1), null, 0, false));
        this.caseIsListable = new JCheckBox();
        this.caseIsListable.setText("\u0412\u0438\u0434\u0435\u043d \u0432 \u0448\u043e\u043f\u0435");
        this.caseProps.add((Component)this.caseIsListable, new GridConstraints(2, 4, 1, 1, 8, 0, 3, 0, null, null, null, 0, false));
        this.caseIsKit = new JCheckBox();
        this.caseIsKit.setText("\u041d\u0430\u0431\u043e\u0440");
        this.caseProps.add((Component)this.caseIsKit, new GridConstraints(2, 2, 1, 1, 8, 0, 3, 0, null, null, null, 0, false));
        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        jPanel.add((Component)jPanel3, new GridConstraints(3, 0, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
        Spacer spacer4 = new Spacer();
        jPanel3.add((Component)spacer4, new GridConstraints(0, 2, 1, 1, 0, 1, 4, 1, null, null, null, 0, false));
        this.deleteCaseBtn = new JButton();
        this.deleteCaseBtn.setText("\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u043a\u0435\u0439\u0441");
        jPanel3.add((Component)this.deleteCaseBtn, new GridConstraints(0, 3, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.editCaseBtn = new JButton();
        this.editCaseBtn.setText("\u0420\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u0434\u0440\u043e\u043f...");
        jPanel3.add((Component)this.editCaseBtn, new GridConstraints(0, 1, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        this.newCaseBtn = new JButton();
        this.newCaseBtn.setText("\u041d\u043e\u0432\u044b\u0439 \u043a\u0435\u0439\u0441...");
        jPanel3.add((Component)this.newCaseBtn, new GridConstraints(0, 0, 1, 1, 0, 1, 3, 0, null, null, null, 0, false));
        JPanel jPanel4 = new JPanel();
        jPanel4.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        this.root.add((Component)jPanel4, new GridConstraints(1, 1, 1, 1, 0, 3, 3, 3, null, null, null, 0, false));
        jPanel4.setBorder(BorderFactory.createTitledBorder("\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u0440\u0435\u0434\u043a\u043e\u0441\u0442\u0438"));
        jPanel4.add((Component)this.rarityTable, new GridConstraints(0, 0, 1, 1, 0, 3, 4, 4, null, new Dimension(150, 50), null, 0, false));
    }

    public JComponent $$$getRootComponent$$$() {
        return this.root;
    }

    private void setupReactions() {
        this.rarityTable.setSelectionMode(0);
        this.rarityTable.putClientProperty("terminateEditOnFocusLost", true);
        this.caseName.addActionListener(actionEvent -> {
            if (this.activeCase != null) {
                this.changed = true;
                this.activeCase.name = this.caseName.getText();
                DefaultListModel defaultListModel = (DefaultListModel)this.caseList.getModel();
                defaultListModel.setElementAt(this.activeCase.name, this.caseData.typeList.indexOf(this.activeCase));
            }
        });
        this.caseIcon.addActionListener(actionEvent -> {
            if (this.activeCase != null) {
                this.changed = true;
                this.activeCase.icon = this.caseIcon.getText();
            }
        });
        this.caseId.addChangeListener(changeEvent -> {
            if (this.activeCase != null) {
                this.changed = true;
                this.activeCase.case_id = (Integer)this.caseId.getValue();
            }
        });
        this.caseCost.addChangeListener(changeEvent -> {
            if (this.activeCase != null) {
                this.changed = true;
                this.activeCase.price = (Integer)this.caseCost.getValue();
            }
        });
        this.caseIsListable.addChangeListener(changeEvent -> {
            if (this.activeCase != null) {
                this.changed = true;
                this.activeCase.isListable = this.caseIsListable.isSelected();
            }
        });
        this.caseIsKit.addChangeListener(changeEvent -> {
            if (this.activeCase != null) {
                this.changed = true;
            }
        });
        this.editCaseBtn.addActionListener(actionEvent -> {
            if (this.activeCase != null && !this.openedCases.contains(this.activeCase)) {
                this.openedCases.add(this.activeCase);
                LootGroupEdit lootGroupEdit = LootGroupEdit.createWindow(this.activeCase.loot, true);
                this.activeCase.loot = lootGroupEdit.getLootConfiguration();
                this.openedCases.remove(this.activeCase);
                this.changed = true;
            }
        });
        this.newCaseBtn.addActionListener(actionEvent -> {
            CaseType caseType2 = new CaseType();
            caseType2.loot = new satl();
            caseType2.name = "\u0411\u0435\u0437\u044b\u043c\u044f\u043d\u043d\u044b\u0439 \u043a\u0435\u0439\u0441";
            this.NEXT_CASE_ID = this.caseData.typeList.size();
            while (this.caseData.typeList.stream().anyMatch(caseType -> caseType.case_id == this.NEXT_CASE_ID)) {
                ++this.NEXT_CASE_ID;
            }
            caseType2.case_id = this.NEXT_CASE_ID;
            caseType2.icon = "";
            this.caseData.typeList.add(caseType2);
            this.setActiveCaseData(this.caseData, true);
            this.changed = true;
        });
        this.deleteCaseBtn.addActionListener(actionEvent -> {
            if (this.activeCase != null) {
                this.caseData.typeList.remove(this.activeCase);
                this.setActiveCaseData(this.caseData, false);
                this.changed = true;
            }
        });
        this.caseList.setModel(new DefaultListModel());
        this.setupFileOperations();
        this.addActionListenerOwner(this.caseCost);
        this.addActionListenerOwner(this.caseIcon);
        this.addActionListenerOwner(this.caseId);
        this.addActionListenerOwner(this.caseIsKit);
        this.addActionListenerOwner(this.caseIsListable);
        this.addActionListenerOwner(this.caseName);
    }

    private void setupFileOperations() {
        this.openCaseFile.addActionListener(actionEvent -> {
            JFileChooser jFileChooser = new JFileChooser(this.prefs.get("last_import_folder", new File(".").getAbsolutePath()));
            jFileChooser.setFileFilter(this.jsonFilter);
            int n = jFileChooser.showOpenDialog(null);
            if (n == 0) {
                this.prefs.put("last_import_folder", jFileChooser.getSelectedFile().getParent());
                File file = jFileChooser.getSelectedFile();
                if (file != null && file.exists()) {
                    this.caseFileIn = file;
                    this.readFromFile();
                }
            }
        });
        this.saveToFileBtn.addActionListener(actionEvent -> this.openSaveDialog());
    }

    private void openSaveDialog() {
        JFileChooser jFileChooser = new JFileChooser(this.prefs.get("last_export_folder", new File(".").getAbsolutePath()));
        jFileChooser.setFileFilter(this.jsonFilter);
        jFileChooser.setSelectedFile(new File("cases_new.json"));
        int n = jFileChooser.showSaveDialog(null);
        if (n == 0) {
            this.prefs.put("last_export_folder", jFileChooser.getSelectedFile().getParent());
            File file = jFileChooser.getSelectedFile();
            if (!file.getName().endsWith(".json")) {
                file = new File(file + ".json");
            }
            this.caseFileOut = file;
            this.saveToFile();
        }
    }

    private void setActiveCase(CaseType caseType) {
        if (this.activeCase != null) {
            this.eventListenerOwners.forEach(jComponent -> {
                Arrays.stream(jComponent.getListeners(ActionListener.class)).forEach(actionListener -> actionListener.actionPerformed(new ActionEvent(jComponent, -1, "")));
                Arrays.stream(jComponent.getListeners(ChangeListener.class)).forEach(changeListener -> changeListener.stateChanged(new ChangeEvent(jComponent)));
            });
        }
        this.activeCase = caseType;
        if (this.activeCase != null) {
            this.caseName.setText(caseType.name);
            this.caseIcon.setText(caseType.icon);
            this.caseCost.setValue(caseType.price);
            this.caseId.setValue(caseType.case_id);
            this.caseIsKit.setSelected(false);
            this.caseIsListable.setSelected(caseType.isListable);
        }
        this.caseName.setEnabled(this.activeCase != null);
        this.caseIcon.setEnabled(this.activeCase != null);
        this.caseCost.setEnabled(this.activeCase != null);
        this.caseId.setEnabled(this.activeCase != null);
        this.caseIsKit.setEnabled(this.activeCase != null);
        this.caseIsListable.setEnabled(this.activeCase != null);
        this.editCaseBtn.setEnabled(this.activeCase != null);
        this.deleteCaseBtn.setEnabled(this.activeCase != null);
        this.rarityTable.setEnabled(this.activeCase != null);
        this.resetRarityTable();
        this.fillRarityTable(caseType);
    }

    private void setActiveCaseData(CaseData caseData, boolean bl) {
        this.activeCase = null;
        this.setActiveCase(null);
        this.caseList.clearSelection();
        this.caseData = caseData;
        DefaultListModel defaultListModel = (DefaultListModel)this.caseList.getModel();
        defaultListModel.removeAllElements();
        this.caseData.typeList.forEach(caseType -> defaultListModel.addElement(caseType.name));
        this.caseList.addListSelectionListener(listSelectionEvent -> this.updateSelectedCase());
        if (bl) {
            this.caseList.setSelectedIndex(this.caseList.getModel().getSize() - 1);
            this.updateSelectedCase();
        }
    }

    private void updateSelectedCase() {
        int n = this.caseList.getSelectedIndex();
        if (n >= 0 && n < this.caseData.typeList.size()) {
            this.setActiveCase(this.caseData.typeList.get(n));
        } else {
            this.activeCase = null;
        }
    }

    private void readFromFile() {
        if (this.caseFileIn == null) {
            throw new IllegalStateException("No in file specified!");
        }
        try (FileInputStream fileInputStream = FileUtils.openInputStream(this.caseFileIn);){
            String string = IOUtils.toString((InputStream)fileInputStream, "UTF-8");
            if (string.startsWith("\ufeff")) {
                string = string.substring(1);
            }
            this.setActiveCaseData(dwkx._b.fromJson(string, CaseData.class), false);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private void saveToFile() {
        this.updateActiveRowRarity();
        if (this.caseFileOut == null) {
            throw new IllegalStateException("No out file specified!");
        }
        try (FileOutputStream fileOutputStream = FileUtils.openOutputStream(this.caseFileOut);){
            if (this.caseFileOut.exists()) {
                FileUtils.copyFile(this.caseFileOut, new File(this.caseFileOut.getAbsolutePath() + ".bck"));
            }
            IOUtils.write(dwkx._b.toJson(this.caseData), (OutputStream)fileOutputStream, "UTF-8");
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private class JTableFuckTheSwing
    extends JTable {
        private JTableFuckTheSwing(DefaultTableModel defaultTableModel) {
            super(defaultTableModel);
        }

        @Override
        public TableCellEditor getDefaultEditor(Class<?> clazz) {
            TableCellEditor tableCellEditor = super.getDefaultEditor(clazz);
            tableCellEditor.addCellEditorListener(new CellEditorListener(){

                @Override
                public void editingStopped(ChangeEvent changeEvent) {
                    int n = CaseEditor.this.rarityTable.getSelectedRow();
                    try {
                        Float.parseFloat((String)CaseEditor.this.rarityTable.getValueAt(n, 1));
                        CaseEditor.this.updateActiveRowRarity();
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }

                @Override
                public void editingCanceled(ChangeEvent changeEvent) {
                }
            });
            return tableCellEditor;
        }
    }
}

