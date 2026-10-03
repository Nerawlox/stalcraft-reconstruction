/*
 * Decompiled with CFR 0.152.
 */
package api.player.render;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class RenderPlayerBaseSorter {
    private Map<String, Set<String>> explicitInferiors;
    private Map<String, Set<String>> explicitSuperiors;
    private Map<String, Set<String>> directInferiorsMap;
    private Map<String, Set<String>> allInferiors;
    private List<String> withoutSuperiors;
    private final List<String> list;
    private final Map<String, String[]> allBaseSuperiors;
    private final Map<String, String[]> allBaseInferiors;
    private final String methodName;
    private static final Set<String> Empty = new HashSet<String>();

    public RenderPlayerBaseSorter(List<String> list2, Map<String, String[]> map, Map<String, String[]> map2, String string) {
        this.list = list2;
        this.allBaseSuperiors = map;
        this.allBaseInferiors = map2;
        this.methodName = string;
    }

    public void Sort() {
        Object object;
        int n;
        String[] stringArray;
        int n2;
        if (this.list.size() <= 1) {
            return;
        }
        if (this.explicitInferiors != null) {
            this.explicitInferiors.clear();
        }
        if (this.explicitSuperiors != null) {
            this.explicitSuperiors.clear();
        }
        if (this.directInferiorsMap != null) {
            this.directInferiorsMap.clear();
        }
        if (this.allInferiors != null) {
            this.allInferiors.clear();
        }
        for (n2 = 0; n2 < this.list.size(); ++n2) {
            boolean bl;
            String string = this.list.get(n2);
            stringArray = this.allBaseInferiors.get(string);
            n = stringArray != null && stringArray.length > 0 ? 1 : 0;
            object = this.allBaseSuperiors.get(string);
            boolean bl2 = bl = object != null && ((String[])object).length > 0;
            if ((n != 0 || bl) && this.directInferiorsMap == null) {
                this.directInferiorsMap = new Hashtable<String, Set<String>>();
            }
            if (n != 0) {
                this.explicitInferiors = RenderPlayerBaseSorter.build(string, this.explicitInferiors, this.directInferiorsMap, null, stringArray);
            }
            if (!bl) continue;
            this.explicitSuperiors = RenderPlayerBaseSorter.build(string, this.explicitSuperiors, null, this.directInferiorsMap, (String[])object);
        }
        if (this.directInferiorsMap != null) {
            for (n2 = 0; n2 < this.list.size() - 1; ++n2) {
                for (int i = n2 + 1; i < this.list.size(); ++i) {
                    boolean bl;
                    stringArray = this.list.get(n2);
                    String string = this.list.get(i);
                    object = null;
                    Set<String> set = null;
                    if (this.explicitInferiors != null) {
                        object = this.explicitInferiors.get(stringArray);
                        set = this.explicitInferiors.get(string);
                    }
                    Set<String> set2 = null;
                    Set<String> set3 = null;
                    if (this.explicitSuperiors != null) {
                        set2 = this.explicitSuperiors.get(stringArray);
                        set3 = this.explicitSuperiors.get(string);
                    }
                    boolean bl3 = set2 != null && set2.contains(string);
                    boolean bl4 = object != null && object.contains(string);
                    boolean bl5 = set3 != null && set3.contains(stringArray);
                    boolean bl6 = bl = set != null && set.contains(stringArray);
                    if (bl3 && bl5) {
                        throw new UnsupportedOperationException("Can not sort RenderPlayerBase classes for method '" + this.methodName + "'. '" + (String)stringArray + "' wants to be inferior to '" + string + "' and '" + string + "' wants to be inferior to '" + (String)stringArray + "'");
                    }
                    if (bl4 && bl) {
                        throw new UnsupportedOperationException("Can not sort RenderPlayerBase classes for method '" + this.methodName + "'. '" + (String)stringArray + "' wants to be superior to '" + string + "' and '" + string + "' wants to be superior to '" + (String)stringArray + "'");
                    }
                    if (bl3 && bl4) {
                        throw new UnsupportedOperationException("Can not sort RenderPlayerBase classes for method '" + this.methodName + "'. '" + (String)stringArray + "' wants to be superior and inferior to '" + string + "'");
                    }
                    if (!bl5 || !bl) continue;
                    throw new UnsupportedOperationException("Can not sort RenderPlayerBase classes for method '" + this.methodName + "'. '" + string + "' wants to be superior and inferior to '" + (String)stringArray + "'");
                }
            }
            if (this.allInferiors == null) {
                this.allInferiors = new Hashtable<String, Set<String>>();
            }
            for (n2 = 0; n2 < this.list.size(); ++n2) {
                this.build(this.list.get(n2), null);
            }
        }
        if (this.withoutSuperiors == null) {
            this.withoutSuperiors = new LinkedList<String>();
        }
        n2 = 0;
        int n3 = this.list.size();
        while (n3 > 1) {
            int n4;
            this.withoutSuperiors.clear();
            for (n4 = n2; n4 < n2 + n3; ++n4) {
                this.withoutSuperiors.add(this.list.get(n4));
            }
            if (this.allInferiors != null) {
                for (n4 = n2; n4 < n2 + n3; ++n4) {
                    Set<String> set = this.allInferiors.get(this.list.get(n4));
                    if (set == null) continue;
                    this.withoutSuperiors.removeAll(set);
                }
            }
            n4 = 1;
            for (n = n2; n < n2 + n3; ++n) {
                object = this.list.get(n);
                if (this.withoutSuperiors.contains(object)) {
                    if (n4 != 0) {
                        Set<String> set = null;
                        if (this.allInferiors != null) {
                            set = this.allInferiors.get(object);
                        }
                        if (set == null || set.isEmpty()) {
                            this.withoutSuperiors.remove(object);
                            --n3;
                            ++n2;
                            continue;
                        }
                    }
                    this.list.remove(n--);
                    --n3;
                }
                n4 = 0;
            }
            this.list.addAll(n2 + n3, this.withoutSuperiors);
        }
    }

    private Set<String> build(String string, String string2) {
        Set<String> set = this.allInferiors.get(string);
        if (set == null) {
            set = this.build(string, null, string2 != null ? string2 : string);
            if (set == null) {
                set = Empty;
            }
            this.allInferiors.put(string, set);
        }
        return set;
    }

    private Set<String> build(String string, Set<String> set, String string2) {
        Set<String> set2 = this.directInferiorsMap.get(string);
        if (set2 == null) {
            return set;
        }
        if (set == null) {
            set = new HashSet<String>();
        }
        for (String string3 : set2) {
            Set<String> set3;
            if (string3 == string2) {
                throw new UnsupportedOperationException("Can not sort RenderPlayerBase classes for method '" + this.methodName + "'. Circular superiosity found including '" + string2 + "'");
            }
            if (this.list.contains(string3)) {
                set.add(string3);
            }
            try {
                set3 = this.build(string3, string2);
            }
            catch (UnsupportedOperationException unsupportedOperationException) {
                throw new UnsupportedOperationException("Can not sort RenderPlayerBase classes for method '" + this.methodName + "'. Circular superiosity found including '" + string3 + "'", unsupportedOperationException);
            }
            if (set3 == Empty) continue;
            set.addAll(set3);
        }
        return set;
    }

    private static Map<String, Set<String>> build(String string, Map<String, Set<String>> map, Map<String, Set<String>> map2, Map<String, Set<String>> map3, String[] stringArray) {
        if (map == null) {
            map = new Hashtable<String, Set<String>>();
        }
        HashSet<String> hashSet = new HashSet<String>();
        for (int i = 0; i < stringArray.length; ++i) {
            if (stringArray[i] == null) continue;
            hashSet.add(stringArray[i]);
        }
        if (map2 != null) {
            RenderPlayerBaseSorter.getOrCreateSet(map2, string).addAll(hashSet);
        }
        if (map3 != null) {
            Iterator iterator2 = hashSet.iterator();
            while (iterator2.hasNext()) {
                RenderPlayerBaseSorter.getOrCreateSet(map3, (String)iterator2.next()).add(string);
            }
        }
        map.put(string, hashSet);
        return map;
    }

    private static Set<String> getOrCreateSet(Map<String, Set<String>> map, String string) {
        Set<String> set = map.get(string);
        if (set != null) {
            return set;
        }
        set = new HashSet<String>();
        map.put(string, set);
        return set;
    }
}

