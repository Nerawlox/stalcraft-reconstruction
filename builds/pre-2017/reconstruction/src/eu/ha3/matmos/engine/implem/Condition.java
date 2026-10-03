/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.engine.implem;

import eu.ha3.matmos.conv.MAtmosConvLogger;
import eu.ha3.matmos.engine.implem.Knowledge;
import eu.ha3.matmos.engine.implem.Switchable;
import eu.ha3.matmos.engine.interfaces.Sheet;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

public class Condition
extends Switchable {
    private String sheet = "";
    private int key = 0;
    private String dynamicKey = "";
    private int conditionType = 0;
    private int constant = 0;
    private String list = "";
    private int version = -1;
    private boolean isTrueEvaluated;

    public Condition(Knowledge knowledge) {
        super(knowledge);
    }

    public void setSheet(String string) {
        this.sheet = string;
        this.flagNeedsTesting();
    }

    public void setKey(int n) {
        this.key = n;
        this.flagNeedsTesting();
    }

    public void setDynamic(String string) {
        this.key = -1;
        this.dynamicKey = string;
        this.sheet = "";
        this.flagNeedsTesting();
    }

    public void setSymbol(String string) {
        this.conditionType = -1;
        if (string.equals("!=")) {
            this.conditionType = 0;
        } else if (string.equals("==")) {
            this.conditionType = 1;
        } else if (string.equals(">")) {
            this.conditionType = 2;
        } else if (string.equals(">=")) {
            this.conditionType = 3;
        } else if (string.equals("<")) {
            this.conditionType = 4;
        } else if (string.equals("<=")) {
            this.conditionType = 5;
        } else if (string.equals("in")) {
            this.conditionType = 6;
        } else if (string.equals("!in")) {
            this.conditionType = 7;
        }
        this.flagNeedsTesting();
    }

    public void setConstant(int n) {
        this.constant = n;
        this.flagNeedsTesting();
    }

    public void setList(String string) {
        this.list = string;
        this.flagNeedsTesting();
    }

    public boolean isDynamic() {
        return this.key == -1;
    }

    public String getSheet() {
        return this.sheet;
    }

    public int getKey() {
        return this.key;
    }

    public String getDynamic() {
        return this.dynamicKey;
    }

    public String getList() {
        return this.list;
    }

    public int getConditionType() {
        return this.conditionType;
    }

    public int getConstant() {
        return this.constant;
    }

    @Override
    protected boolean testIfValid() {
        if (this.conditionType == -1) {
            return false;
        }
        boolean bl = false;
        if (!this.isDynamic()) {
            if (this.knowledge.getData().getSheet(this.sheet) != null && this.key >= 0 && this.key < this.knowledge.getData().getSheet(this.sheet).getSize()) {
                bl = true;
            }
        } else if (this.knowledge.getDynamicsKeySet().contains(this.dynamicKey)) {
            bl = true;
        }
        if (bl && (this.conditionType == 6 || this.conditionType == 7)) {
            bl = this.knowledge.getListsKeySet().contains(this.list);
        }
        return bl;
    }

    public boolean evaluate() {
        if (!this.isValid()) {
            return false;
        }
        boolean bl = this.isTrueEvaluated;
        this.isTrueEvaluated = this.testIfTrue();
        if (bl != this.isTrueEvaluated) {
            MAtmosConvLogger.fine("C:" + this.nickname + (this.isTrueEvaluated ? " now On." : " now Off."));
        }
        return this.isTrueEvaluated;
    }

    @Override
    public boolean isActive() {
        return this.isTrue();
    }

    public boolean isTrue() {
        return this.isTrueEvaluated;
    }

    public boolean testIfTrue() {
        int n;
        if (!this.isValid()) {
            return false;
        }
        if (!this.isDynamic()) {
            Sheet<Integer> sheet = this.knowledge.getData().getSheet(this.sheet);
            int n2 = sheet.getVersionOf(this.key);
            if (sheet.getVersionOf(this.key) == this.version) {
                return this.isTrueEvaluated;
            }
            this.version = n2;
            n = sheet.get(this.key);
        } else {
            n = this.knowledge.getDynamic((String)this.dynamicKey).value;
        }
        if (this.conditionType == 0) {
            return n != this.constant;
        }
        if (this.conditionType == 1) {
            return n == this.constant;
        }
        if (this.conditionType == 2) {
            return n > this.constant;
        }
        if (this.conditionType == 3) {
            return n >= this.constant;
        }
        if (this.conditionType == 4) {
            return n < this.constant;
        }
        if (this.conditionType == 5) {
            return n <= this.constant;
        }
        if (this.conditionType == 6) {
            return this.knowledge.getList(this.list).contains(n);
        }
        if (this.conditionType == 7) {
            return !this.knowledge.getList(this.list).contains(n);
        }
        return false;
    }

    @Override
    public String serialize(XMLEventWriter xMLEventWriter) throws XMLStreamException {
        this.buildDescriptibleSerialized(xMLEventWriter);
        if (!this.isDynamic()) {
            this.createNode(xMLEventWriter, "sheet", this.sheet);
            this.createNode(xMLEventWriter, "key", "" + this.key);
        } else {
            this.createNode(xMLEventWriter, "key", "" + this.key);
            this.createNode(xMLEventWriter, "dynamickey", this.dynamicKey);
        }
        if (this.conditionType == 0) {
            this.createNode(xMLEventWriter, "symbol", "!=");
        } else if (this.conditionType == 1) {
            this.createNode(xMLEventWriter, "symbol", "==");
        } else if (this.conditionType == 2) {
            this.createNode(xMLEventWriter, "symbol", ">");
        } else if (this.conditionType == 3) {
            this.createNode(xMLEventWriter, "symbol", ">=");
        } else if (this.conditionType == 4) {
            this.createNode(xMLEventWriter, "symbol", "<");
        } else if (this.conditionType == 5) {
            this.createNode(xMLEventWriter, "symbol", "<=");
        } else if (this.conditionType == 6) {
            this.createNode(xMLEventWriter, "symbol", "in");
        } else if (this.conditionType == 7) {
            this.createNode(xMLEventWriter, "symbol", "!in");
        } else {
            this.createNode(xMLEventWriter, "symbol", "><");
        }
        this.createNode(xMLEventWriter, "constant", "" + this.constant);
        this.createNode(xMLEventWriter, "list", "" + this.list);
        return "";
    }

    public void replaceDynamicName(String string, String string2) {
        if (!this.isDynamic()) {
            return;
        }
        if (this.dynamicKey.equals(string)) {
            this.dynamicKey = string2;
        }
        this.flagNeedsTesting();
    }

    public void replaceListName(String string, String string2) {
        if (this.list.equals(string)) {
            this.list = string2;
        }
        this.flagNeedsTesting();
    }
}

