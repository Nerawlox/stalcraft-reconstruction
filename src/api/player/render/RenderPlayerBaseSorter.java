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

    public RenderPlayerBaseSorter(List<String> var1, Map<String, String[]> var2, Map<String, String[]> var3, String var4) {
        this.list = var1;
        this.allBaseSuperiors = var2;
        this.allBaseInferiors = var3;
        this.methodName = var4;
    }

    public void Sort() {
        if (this.list.size() > 1) {
            Set<String> var21;
            int var1;
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
            for (var1 = 0; var1 < this.list.size(); ++var1) {
                boolean var6;
                String var2 = this.list.get(var1);
                String[] var3 = this.allBaseInferiors.get(var2);
                boolean var4 = var3 != null && var3.length > 0;
                String[] var5 = this.allBaseSuperiors.get(var2);
                boolean bl2 = var6 = var5 != null && var5.length > 0;
                if ((var4 || var6) && this.directInferiorsMap == null) {
                    this.directInferiorsMap = new Hashtable<String, Set<String>>();
                }
                if (var4) {
                    this.explicitInferiors = RenderPlayerBaseSorter.build(var2, this.explicitInferiors, this.directInferiorsMap, null, var3);
                }
                if (!var6) continue;
                this.explicitSuperiors = RenderPlayerBaseSorter.build(var2, this.explicitSuperiors, null, this.directInferiorsMap, var5);
            }
            if (this.directInferiorsMap != null) {
                for (var1 = 0; var1 < this.list.size() - 1; ++var1) {
                    for (int var13 = var1 + 1; var13 < this.list.size(); ++var13) {
                        boolean var12;
                        String var14 = this.list.get(var1);
                        String var16 = this.list.get(var13);
                        Set<String> var18 = null;
                        var21 = null;
                        if (this.explicitInferiors != null) {
                            var18 = this.explicitInferiors.get(var14);
                            var21 = this.explicitInferiors.get(var16);
                        }
                        Set<String> var7 = null;
                        Set<String> var8 = null;
                        if (this.explicitSuperiors != null) {
                            var7 = this.explicitSuperiors.get(var14);
                            var8 = this.explicitSuperiors.get(var16);
                        }
                        boolean var9 = var7 != null && var7.contains(var16);
                        boolean var10 = var18 != null && var18.contains(var16);
                        boolean var11 = var8 != null && var8.contains(var14);
                        boolean bl3 = var12 = var21 != null && var21.contains(var14);
                        if (var9 && var11) {
                            throw new UnsupportedOperationException("Can not sort RenderPlayerBase classes for method '" + this.methodName + "'. '" + var14 + "' wants to be inferior to '" + var16 + "' and '" + var16 + "' wants to be inferior to '" + var14 + "'");
                        }
                        if (var10 && var12) {
                            throw new UnsupportedOperationException("Can not sort RenderPlayerBase classes for method '" + this.methodName + "'. '" + var14 + "' wants to be superior to '" + var16 + "' and '" + var16 + "' wants to be superior to '" + var14 + "'");
                        }
                        if (var9 && var10) {
                            throw new UnsupportedOperationException("Can not sort RenderPlayerBase classes for method '" + this.methodName + "'. '" + var14 + "' wants to be superior and inferior to '" + var16 + "'");
                        }
                        if (!var11 || !var12) continue;
                        throw new UnsupportedOperationException("Can not sort RenderPlayerBase classes for method '" + this.methodName + "'. '" + var16 + "' wants to be superior and inferior to '" + var14 + "'");
                    }
                }
                if (this.allInferiors == null) {
                    this.allInferiors = new Hashtable<String, Set<String>>();
                }
                for (var1 = 0; var1 < this.list.size(); ++var1) {
                    this.build(this.list.get(var1), null);
                }
            }
            if (this.withoutSuperiors == null) {
                this.withoutSuperiors = new LinkedList<String>();
            }
            var1 = 0;
            int var13 = this.list.size();
            while (var13 > 1) {
                int var15;
                this.withoutSuperiors.clear();
                for (var15 = var1; var15 < var1 + var13; ++var15) {
                    this.withoutSuperiors.add(this.list.get(var15));
                }
                if (this.allInferiors != null) {
                    for (var15 = var1; var15 < var1 + var13; ++var15) {
                        Set<String> var17 = this.allInferiors.get(this.list.get(var15));
                        if (var17 == null) continue;
                        this.withoutSuperiors.removeAll(var17);
                    }
                }
                boolean var19 = true;
                for (int var20 = var1; var20 < var1 + var13; ++var20) {
                    String var22 = this.list.get(var20);
                    if (this.withoutSuperiors.contains(var22)) {
                        if (var19) {
                            var21 = null;
                            if (this.allInferiors != null) {
                                var21 = this.allInferiors.get(var22);
                            }
                            if (var21 == null || var21.isEmpty()) {
                                this.withoutSuperiors.remove(var22);
                                --var13;
                                ++var1;
                                continue;
                            }
                        }
                        this.list.remove(var20--);
                        --var13;
                    }
                    var19 = false;
                }
                this.list.addAll(var1 + var13, this.withoutSuperiors);
            }
        }
    }

    private Set<String> build(String var1, String var2) {
        Set<String> var3 = this.allInferiors.get(var1);
        if (var3 == null) {
            var3 = this.build(var1, null, var2 != null ? var2 : var1);
            if (var3 == null) {
                var3 = Empty;
            }
            this.allInferiors.put(var1, var3);
        }
        return var3;
    }

    private Set<String> build(String var1, Set<String> var2, String var3) {
        Set<String> var4 = this.directInferiorsMap.get(var1);
        if (var4 == null) {
            return var2;
        }
        if (var2 == null) {
            var2 = new HashSet<String>();
        }
        for (String var6 : var4) {
            Set<String> var7;
            if (var6 == var3) {
                throw new UnsupportedOperationException("Can not sort RenderPlayerBase classes for method '" + this.methodName + "'. Circular superiosity found including '" + var3 + "'");
            }
            if (this.list.contains(var6)) {
                var2.add(var6);
            }
            try {
                var7 = this.build(var6, var3);
            }
            catch (UnsupportedOperationException var9) {
                throw new UnsupportedOperationException("Can not sort RenderPlayerBase classes for method '" + this.methodName + "'. Circular superiosity found including '" + var6 + "'", var9);
            }
            if (var7 == Empty) continue;
            var2.addAll(var7);
        }
        return var2;
    }

    private static Map<String, Set<String>> build(String var0, Map<String, Set<String>> var1, Map<String, Set<String>> var2, Map<String, Set<String>> var3, String[] var4) {
        if (var1 == null) {
            var1 = new Hashtable<String, Set<String>>();
        }
        HashSet<String> var5 = new HashSet<String>();
        for (int var6 = 0; var6 < var4.length; ++var6) {
            if (var4[var6] == null) continue;
            var5.add(var4[var6]);
        }
        if (var2 != null) {
            RenderPlayerBaseSorter.getOrCreateSet(var2, var0).addAll(var5);
        }
        if (var3 != null) {
            Iterator var7 = var5.iterator();
            while (var7.hasNext()) {
                RenderPlayerBaseSorter.getOrCreateSet(var3, (String)var7.next()).add(var0);
            }
        }
        var1.put(var0, var5);
        return var1;
    }

    private static Set<String> getOrCreateSet(Map<String, Set<String>> var0, String var1) {
        Set<String> var2 = var0.get(var1);
        if (var2 != null) {
            return var2;
        }
        HashSet<String> var3 = new HashSet<String>();
        var0.put(var1, var3);
        return var3;
    }
}

