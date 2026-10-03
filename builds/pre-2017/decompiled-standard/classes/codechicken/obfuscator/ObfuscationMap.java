/*
 * Decompiled with CFR 0.152.
 */
package codechicken.obfuscator;

import codechicken.lib.asm.ObfMapping;
import codechicken.obfuscator.IHeirachyEvaluator;
import codechicken.obfuscator.ILogStreams;
import codechicken.obfuscator.ObfuscationRun;
import codechicken.obfuscator.SystemLogStreams;
import com.google.common.base.Function;
import com.google.common.collect.ArrayListMultimap;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ObfuscationMap {
    private Map<String, ClassEntry> srgMap = new HashMap<String, ClassEntry>();
    private Map<String, ClassEntry> obfMap = new HashMap<String, ClassEntry>();
    private ArrayListMultimap<String, ObfuscationEntry> srgMemberMap = ArrayListMultimap.create();
    private IHeirachyEvaluator heirachyEvaluator;
    private HashSet<String> mappedClasses = new HashSet();
    public ILogStreams log = SystemLogStreams.inst;

    public ObfuscationMap setHeirachyEvaluator(IHeirachyEvaluator iHeirachyEvaluator) {
        this.heirachyEvaluator = iHeirachyEvaluator;
        return this;
    }

    public ObfuscationMap setLog(ILogStreams iLogStreams) {
        this.log = iLogStreams;
        return this;
    }

    public ObfuscationEntry addClass(String string, String string2) {
        return this.addEntry(new ObfMapping(string, "", ""), new ObfMapping(string2, "", ""));
    }

    public ObfuscationEntry addField(String string, String string2, String string3, String string4) {
        return this.addEntry(new ObfMapping(string, string2, ""), new ObfMapping(string3, string4, ""));
    }

    public ObfuscationEntry addMethod(String string, String string2, String string3, String string4, String string5, String string6) {
        return this.addEntry(new ObfMapping(string, string2, string3), new ObfMapping(string4, string5, string6));
    }

    public ObfuscationEntry addEntry(ObfMapping obfMapping, ObfMapping obfMapping2) {
        ClassEntry classEntry = this.srgMap.get(obfMapping2.s_owner);
        if (classEntry == null) {
            classEntry = new ClassEntry(obfMapping.s_owner, obfMapping2.s_owner);
            this.obfMap.put(obfMapping.s_owner, classEntry);
            this.srgMap.put(obfMapping2.s_owner, classEntry);
        }
        if (obfMapping.s_name.length() > 0) {
            return classEntry.addEntry(obfMapping, obfMapping2);
        }
        return classEntry;
    }

    public void addMcpName(String string, String string2) {
        List list = this.srgMemberMap.get((Object)string);
        if (list.isEmpty()) {
            this.log.err().println("Tried to add mcp name (" + string2 + ") for unknown srg key (" + string + ")");
            return;
        }
        for (ObfuscationEntry obfuscationEntry : list) {
            obfuscationEntry.mcp.s_name = string2;
            this.srgMap.get((Object)obfuscationEntry.srg.s_owner).mcpMap.put(obfuscationEntry.mcp.s_name.concat(obfuscationEntry.mcp.s_desc), obfuscationEntry);
        }
    }

    public ObfuscationEntry lookupSrg(String string) {
        List list = this.srgMemberMap.get((Object)string);
        return list.isEmpty() ? null : (ObfuscationEntry)list.get(0);
    }

    public ObfuscationEntry lookupMcpClass(String string) {
        return this.srgMap.get(string);
    }

    public ObfuscationEntry lookupObfClass(String string) {
        return this.obfMap.get(string);
    }

    public ObfuscationEntry lookupMcpField(String string, String string2) {
        return this.lookupMcpMethod(string, string2, "");
    }

    public ObfuscationEntry lookupSrgField(String string, String string2) {
        ObfuscationEntry obfuscationEntry;
        if (string2.startsWith("field_") && (obfuscationEntry = this.lookupSrg(string2)) != null) {
            return obfuscationEntry;
        }
        this.evaluateHeirachy(string);
        obfuscationEntry = this.srgMap.get(string);
        return obfuscationEntry == null ? null : ((ClassEntry)obfuscationEntry).srgMap.get(string2);
    }

    public ObfuscationEntry lookupObfField(String string, String string2) {
        return this.lookupObfMethod(string, string2, "");
    }

    public ObfuscationEntry lookupMcpMethod(String string, String string2, String string3) {
        this.evaluateHeirachy(string);
        ClassEntry classEntry = this.srgMap.get(string);
        return classEntry == null ? null : classEntry.mcpMap.get(string2.concat(string3));
    }

    public ObfuscationEntry lookupObfMethod(String string, String string2, String string3) {
        this.evaluateHeirachy(string);
        ClassEntry classEntry = this.obfMap.get(string);
        return classEntry == null ? null : classEntry.obfMap.get(string2.concat(string3));
    }

    private boolean isMapped(ObfuscationEntry obfuscationEntry) {
        return this.mappedClasses.contains(obfuscationEntry.srg.s_owner);
    }

    private ObfuscationEntry getOrCreateClassEntry(String string) {
        ObfuscationEntry obfuscationEntry = this.lookupObfClass(string);
        if (obfuscationEntry == null) {
            obfuscationEntry = this.lookupMcpClass(string);
        }
        if (obfuscationEntry == null) {
            obfuscationEntry = this.addClass(string, string);
        }
        return obfuscationEntry;
    }

    public ObfuscationEntry evaluateHeirachy(String string) {
        ObfuscationEntry obfuscationEntry = this.getOrCreateClassEntry(string);
        if (this.isMapped(obfuscationEntry)) {
            return obfuscationEntry;
        }
        this.mappedClasses.add(obfuscationEntry.srg.s_owner);
        if (this.heirachyEvaluator == null) {
            throw new IllegalArgumentException("Cannot call method/field mappings if a heirachy evaluator is not set.");
        }
        if (!this.heirachyEvaluator.isLibClass(obfuscationEntry)) {
            List<String> list = this.heirachyEvaluator.getParents(obfuscationEntry);
            if (list == null) {
                this.log.err().println("Could not find class: " + obfuscationEntry.srg.s_owner);
            } else {
                for (String string2 : list) {
                    this.inherit(obfuscationEntry, this.evaluateHeirachy(string2));
                }
            }
        }
        return obfuscationEntry;
    }

    public void inherit(ObfuscationEntry obfuscationEntry, ObfuscationEntry obfuscationEntry2) {
        this.inherit(obfuscationEntry.srg.s_owner, obfuscationEntry2.srg.s_owner);
    }

    public void inherit(String string, String string2) {
        ClassEntry classEntry = this.srgMap.get(string);
        if (classEntry == null) {
            throw new IllegalStateException("Tried to inerit to an undefined class: " + string + " extends " + string2);
        }
        ClassEntry classEntry2 = this.srgMap.get(string2);
        if (classEntry2 == null) {
            throw new IllegalStateException("Tried to inerit from undefired parent: " + string + " extends " + string2);
        }
        classEntry.inheritFrom(classEntry2);
    }

    public void parseMappings(File[] fileArray) {
        this.parseSRGS(fileArray[0]);
        this.parseCSV(fileArray[1]);
        this.parseCSV(fileArray[2]);
    }

    public static String[] splitLast(String string, char c) {
        int n = string.lastIndexOf(c);
        return new String[]{string.substring(0, n), string.substring(n + 1)};
    }

    public static String[] split4(String string, char c) {
        String[] stringArray = new String[4];
        int n = string.indexOf(c);
        stringArray[0] = string.substring(0, n);
        int n2 = n + 1;
        n = string.indexOf(c, n2);
        stringArray[1] = string.substring(n2, n);
        n2 = n + 1;
        n = string.indexOf(c, n2);
        stringArray[2] = string.substring(n2, n);
        n2 = n + 1;
        n = string.indexOf(c, n2);
        stringArray[3] = string.substring(n2);
        return stringArray;
    }

    private void parseSRGS(File file) {
        this.log.out().println("Parsing " + file.getName());
        Function<String, Void> function = new Function<String, Void>(){

            @Override
            public Void apply(String string) {
                int n = string.indexOf(35);
                if (n > 0) {
                    string = string.substring(0, n).trim();
                }
                if (string.startsWith("CL: ")) {
                    String[] stringArray = ObfuscationMap.splitLast(string.substring(4), ' ');
                    ObfuscationMap.this.addClass(stringArray[0], stringArray[1]);
                } else {
                    if (string.startsWith("FD: ")) {
                        String[] stringArray = ObfuscationMap.splitLast(string.substring(4), ' ');
                        String[] stringArray2 = ObfuscationMap.splitLast(stringArray[0], '/');
                        String[] stringArray3 = ObfuscationMap.splitLast(stringArray[1], '/');
                        ObfuscationMap.this.addField(stringArray2[0], stringArray2[1], stringArray3[0], stringArray3[1]);
                        return null;
                    }
                    if (string.startsWith("MD: ")) {
                        String[] stringArray = ObfuscationMap.split4(string.substring(4), ' ');
                        String[] stringArray4 = ObfuscationMap.splitLast(stringArray[0], '/');
                        String[] stringArray5 = ObfuscationMap.splitLast(stringArray[2], '/');
                        ObfuscationMap.this.addMethod(stringArray4[0], stringArray4[1], stringArray[1], stringArray5[0], stringArray5[1], stringArray[3]);
                        return null;
                    }
                }
                return null;
            }
        };
        ObfuscationRun.processLines(file, function);
    }

    private void parseCSV(File file) {
        this.log.out().println("Parsing " + file.getName());
        Function<String, Void> function = new Function<String, Void>(){

            @Override
            public Void apply(String string) {
                if (string.startsWith("func_") || string.startsWith("field_")) {
                    int n = string.indexOf(44);
                    String string2 = string.substring(0, n);
                    int n2 = n + 1;
                    n = string.indexOf(44, n2);
                    String string3 = string.substring(n2, n);
                    ObfuscationMap.this.addMcpName(string2, string3);
                }
                return null;
            }
        };
        ObfuscationRun.processLines(file, function);
    }

    private class ClassEntry
    extends ObfuscationEntry {
        public Map<String, ObfuscationEntry> mcpMap;
        public Map<String, ObfuscationEntry> srgMap;
        public Map<String, ObfuscationEntry> obfMap;

        public ClassEntry(String string, String string2) {
            super(new ObfMapping(string, "", ""), new ObfMapping(string2, "", ""), new ObfMapping(string2, "", ""));
            this.mcpMap = new HashMap<String, ObfuscationEntry>();
            this.srgMap = new HashMap<String, ObfuscationEntry>();
            this.obfMap = new HashMap<String, ObfuscationEntry>();
        }

        public ObfuscationEntry addEntry(ObfMapping obfMapping, ObfMapping obfMapping2) {
            ObfuscationEntry obfuscationEntry = new ObfuscationEntry(obfMapping, obfMapping2, obfMapping2.copy());
            this.obfMap.put(obfMapping.s_name.concat(obfMapping.s_desc), obfuscationEntry);
            this.srgMap.put(obfMapping2.s_name, obfuscationEntry);
            if (obfMapping2.s_name.startsWith("field_") || obfMapping2.s_name.startsWith("func_")) {
                ObfuscationMap.this.srgMemberMap.put(obfMapping2.s_name, obfuscationEntry);
            }
            return obfuscationEntry;
        }

        public void inheritFrom(ClassEntry classEntry) {
            this.inherit(this.obfMap, classEntry.obfMap);
            this.inherit(this.srgMap, classEntry.srgMap);
            this.inherit(this.mcpMap, classEntry.mcpMap);
        }

        private void inherit(Map<String, ObfuscationEntry> map, Map<String, ObfuscationEntry> map2) {
            for (Map.Entry<String, ObfuscationEntry> entry : map2.entrySet()) {
                if (map.containsKey(entry.getKey())) continue;
                map.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public class ObfuscationEntry {
        public final ObfMapping obf;
        public final ObfMapping srg;
        public final ObfMapping mcp;

        public ObfuscationEntry(ObfMapping obfMapping, ObfMapping obfMapping2, ObfMapping obfMapping3) {
            this.obf = obfMapping;
            this.srg = obfMapping2;
            this.mcp = obfMapping3;
        }
    }
}

