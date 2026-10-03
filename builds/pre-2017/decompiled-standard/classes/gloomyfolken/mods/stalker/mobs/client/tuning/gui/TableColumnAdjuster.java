/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.tuning.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class TableColumnAdjuster
implements PropertyChangeListener,
TableModelListener {
    private JTable table;
    private int spacing;
    private boolean isColumnHeaderIncluded;
    private boolean isColumnDataIncluded;
    private boolean isOnlyAdjustLarger;
    private boolean isDynamicAdjustment;
    private Map<TableColumn, Integer> columnSizes = new HashMap<TableColumn, Integer>();

    public TableColumnAdjuster(JTable jTable) {
        this(jTable, 6);
    }

    public TableColumnAdjuster(JTable jTable, int n) {
        this.table = jTable;
        this.spacing = n;
        this.setColumnHeaderIncluded(true);
        this.setColumnDataIncluded(true);
        this.setOnlyAdjustLarger(false);
        this.setDynamicAdjustment(false);
        this.installActions();
    }

    public void adjustColumns() {
        TableColumnModel tableColumnModel = this.table.getColumnModel();
        for (int i = 0; i < tableColumnModel.getColumnCount(); ++i) {
            this.adjustColumn(i);
        }
    }

    public void adjustColumn(int n) {
        TableColumn tableColumn = this.table.getColumnModel().getColumn(n);
        if (!tableColumn.getResizable()) {
            return;
        }
        int n2 = this.getColumnHeaderWidth(n);
        int n3 = this.getColumnDataWidth(n);
        int n4 = Math.max(n2, n3);
        this.updateTableColumn(n, n4);
    }

    private int getColumnHeaderWidth(int n) {
        if (!this.isColumnHeaderIncluded) {
            return 0;
        }
        TableColumn tableColumn = this.table.getColumnModel().getColumn(n);
        Object object = tableColumn.getHeaderValue();
        TableCellRenderer tableCellRenderer = tableColumn.getHeaderRenderer();
        if (tableCellRenderer == null) {
            tableCellRenderer = this.table.getTableHeader().getDefaultRenderer();
        }
        Component component = tableCellRenderer.getTableCellRendererComponent(this.table, object, false, false, -1, n);
        return component.getPreferredSize().width;
    }

    private int getColumnDataWidth(int n) {
        if (!this.isColumnDataIncluded) {
            return 0;
        }
        int n2 = 0;
        int n3 = this.table.getColumnModel().getColumn(n).getMaxWidth();
        for (int i = 0; i < this.table.getRowCount() && (n2 = Math.max(n2, this.getCellDataWidth(i, n))) < n3; ++i) {
        }
        return n2;
    }

    private int getCellDataWidth(int n, int n2) {
        TableCellRenderer tableCellRenderer = this.table.getCellRenderer(n, n2);
        Component component = this.table.prepareRenderer(tableCellRenderer, n, n2);
        int n3 = component.getPreferredSize().width + this.table.getIntercellSpacing().width;
        return n3;
    }

    private void updateTableColumn(int n, int n2) {
        TableColumn tableColumn = this.table.getColumnModel().getColumn(n);
        if (!tableColumn.getResizable()) {
            return;
        }
        n2 += this.spacing;
        if (this.isOnlyAdjustLarger) {
            n2 = Math.max(n2, tableColumn.getPreferredWidth());
        }
        this.columnSizes.put(tableColumn, new Integer(tableColumn.getWidth()));
        this.table.getTableHeader().setResizingColumn(tableColumn);
        tableColumn.setWidth(n2);
    }

    public void restoreColumns() {
        TableColumnModel tableColumnModel = this.table.getColumnModel();
        for (int i = 0; i < tableColumnModel.getColumnCount(); ++i) {
            this.restoreColumn(i);
        }
    }

    private void restoreColumn(int n) {
        TableColumn tableColumn = this.table.getColumnModel().getColumn(n);
        Integer n2 = this.columnSizes.get(tableColumn);
        if (n2 != null) {
            this.table.getTableHeader().setResizingColumn(tableColumn);
            tableColumn.setWidth(n2);
        }
    }

    public void setColumnHeaderIncluded(boolean bl) {
        this.isColumnHeaderIncluded = bl;
    }

    public void setColumnDataIncluded(boolean bl) {
        this.isColumnDataIncluded = bl;
    }

    public void setOnlyAdjustLarger(boolean bl) {
        this.isOnlyAdjustLarger = bl;
    }

    public void setDynamicAdjustment(boolean bl) {
        if (this.isDynamicAdjustment != bl) {
            if (bl) {
                this.table.addPropertyChangeListener(this);
                this.table.getModel().addTableModelListener(this);
            } else {
                this.table.removePropertyChangeListener(this);
                this.table.getModel().removeTableModelListener(this);
            }
        }
        this.isDynamicAdjustment = bl;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if ("model".equals(propertyChangeEvent.getPropertyName())) {
            TableModel tableModel = (TableModel)propertyChangeEvent.getOldValue();
            tableModel.removeTableModelListener(this);
            tableModel = (TableModel)propertyChangeEvent.getNewValue();
            tableModel.addTableModelListener(this);
            this.adjustColumns();
        }
    }

    @Override
    public void tableChanged(final TableModelEvent tableModelEvent) {
        if (!this.isColumnDataIncluded) {
            return;
        }
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                int n = TableColumnAdjuster.this.table.convertColumnIndexToView(tableModelEvent.getColumn());
                if (tableModelEvent.getType() == 0 && n != -1) {
                    if (TableColumnAdjuster.this.isOnlyAdjustLarger) {
                        int n2 = tableModelEvent.getFirstRow();
                        TableColumn tableColumn = TableColumnAdjuster.this.table.getColumnModel().getColumn(n);
                        if (tableColumn.getResizable()) {
                            int n3 = TableColumnAdjuster.this.getCellDataWidth(n2, n);
                            TableColumnAdjuster.this.updateTableColumn(n, n3);
                        }
                    } else {
                        TableColumnAdjuster.this.adjustColumn(n);
                    }
                } else {
                    TableColumnAdjuster.this.adjustColumns();
                }
            }
        });
    }

    private void installActions() {
        this.installColumnAction(true, true, "adjustColumn", "control ADD");
        this.installColumnAction(false, true, "adjustColumns", "control shift ADD");
        this.installColumnAction(true, false, "restoreColumn", "control SUBTRACT");
        this.installColumnAction(false, false, "restoreColumns", "control shift SUBTRACT");
        this.installToggleAction(true, false, "toggleDynamic", "control MULTIPLY");
        this.installToggleAction(false, true, "toggleLarger", "control DIVIDE");
    }

    private void installColumnAction(boolean bl, boolean bl2, String string, String string2) {
        ColumnAction columnAction = new ColumnAction(bl, bl2);
        KeyStroke keyStroke = KeyStroke.getKeyStroke(string2);
        this.table.getInputMap().put(keyStroke, string);
        this.table.getActionMap().put(string, columnAction);
    }

    private void installToggleAction(boolean bl, boolean bl2, String string, String string2) {
        ToggleAction toggleAction = new ToggleAction(bl, bl2);
        KeyStroke keyStroke = KeyStroke.getKeyStroke(string2);
        this.table.getInputMap().put(keyStroke, string);
        this.table.getActionMap().put(string, toggleAction);
    }

    class ToggleAction
    extends AbstractAction {
        private boolean isToggleDynamic;
        private boolean isToggleLarger;

        public ToggleAction(boolean bl, boolean bl2) {
            this.isToggleDynamic = bl;
            this.isToggleLarger = bl2;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (this.isToggleDynamic) {
                TableColumnAdjuster.this.setDynamicAdjustment(!TableColumnAdjuster.this.isDynamicAdjustment);
                return;
            }
            if (this.isToggleLarger) {
                TableColumnAdjuster.this.setOnlyAdjustLarger(!TableColumnAdjuster.this.isOnlyAdjustLarger);
                return;
            }
        }
    }

    class ColumnAction
    extends AbstractAction {
        private boolean isSelectedColumn;
        private boolean isAdjust;

        public ColumnAction(boolean bl, boolean bl2) {
            this.isSelectedColumn = bl;
            this.isAdjust = bl2;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (this.isSelectedColumn) {
                int[] nArray = TableColumnAdjuster.this.table.getSelectedColumns();
                for (int i = 0; i < nArray.length; ++i) {
                    if (this.isAdjust) {
                        TableColumnAdjuster.this.adjustColumn(nArray[i]);
                        continue;
                    }
                    TableColumnAdjuster.this.restoreColumn(nArray[i]);
                }
            } else if (this.isAdjust) {
                TableColumnAdjuster.this.adjustColumns();
            } else {
                TableColumnAdjuster.this.restoreColumns();
            }
        }
    }
}

