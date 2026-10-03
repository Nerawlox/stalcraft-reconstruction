/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ezfc;
import net.minecraft.util.zwat;

public class ywav
extends ohnk {
    @Override
    public String func_71517_b() {
        return "scoreboard";
    }

    @Override
    public int func_82362_a() {
        return 2;
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.scoreboard.usage";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length < 1) throw new pksd("commands.scoreboard.usage", new Object[0]);
        if (stringArray[0].equalsIgnoreCase("objectives")) {
            if (stringArray.length == 1) {
                throw new pksd("commands.scoreboard.objectives.usage", new Object[0]);
            }
            if (stringArray[1].equalsIgnoreCase("list")) {
                this._a(nemo2);
                return;
            } else if (stringArray[1].equalsIgnoreCase("add")) {
                if (stringArray.length < 4) throw new pksd("commands.scoreboard.objectives.add.usage", new Object[0]);
                this._a(nemo2, stringArray, 2);
                return;
            } else if (stringArray[1].equalsIgnoreCase("remove")) {
                if (stringArray.length != 3) throw new pksd("commands.scoreboard.objectives.remove.usage", new Object[0]);
                this._a(nemo2, stringArray[2]);
                return;
            } else {
                if (!stringArray[1].equalsIgnoreCase("setdisplay")) throw new pksd("commands.scoreboard.objectives.usage", new Object[0]);
                if (stringArray.length != 3 && stringArray.length != 4) throw new pksd("commands.scoreboard.objectives.setdisplay.usage", new Object[0]);
                this._i(nemo2, stringArray, 2);
            }
            return;
        }
        if (stringArray[0].equalsIgnoreCase("players")) {
            if (stringArray.length == 1) {
                throw new pksd("commands.scoreboard.players.usage", new Object[0]);
            }
            if (stringArray[1].equalsIgnoreCase("list")) {
                if (stringArray.length > 3) throw new pksd("commands.scoreboard.players.list.usage", new Object[0]);
                this._j(nemo2, stringArray, 2);
                return;
            } else if (stringArray[1].equalsIgnoreCase("add")) {
                if (stringArray.length != 5) throw new pksd("commands.scoreboard.players.add.usage", new Object[0]);
                this._k(nemo2, stringArray, 2);
                return;
            } else if (stringArray[1].equalsIgnoreCase("remove")) {
                if (stringArray.length != 5) throw new pksd("commands.scoreboard.players.remove.usage", new Object[0]);
                this._k(nemo2, stringArray, 2);
                return;
            } else if (stringArray[1].equalsIgnoreCase("set")) {
                if (stringArray.length != 5) throw new pksd("commands.scoreboard.players.set.usage", new Object[0]);
                this._k(nemo2, stringArray, 2);
                return;
            } else {
                if (!stringArray[1].equalsIgnoreCase("reset")) throw new pksd("commands.scoreboard.players.usage", new Object[0]);
                if (stringArray.length != 3) throw new pksd("commands.scoreboard.players.reset.usage", new Object[0]);
                this._l(nemo2, stringArray, 2);
            }
            return;
        }
        if (!stringArray[0].equalsIgnoreCase("teams")) throw new pksd("commands.scoreboard.usage", new Object[0]);
        if (stringArray.length == 1) {
            throw new pksd("commands.scoreboard.teams.usage", new Object[0]);
        }
        if (stringArray[1].equalsIgnoreCase("list")) {
            if (stringArray.length > 3) throw new pksd("commands.scoreboard.teams.list.usage", new Object[0]);
            this._e(nemo2, stringArray, 2);
            return;
        } else if (stringArray[1].equalsIgnoreCase("add")) {
            if (stringArray.length < 3) throw new pksd("commands.scoreboard.teams.add.usage", new Object[0]);
            this._b(nemo2, stringArray, 2);
            return;
        } else if (stringArray[1].equalsIgnoreCase("remove")) {
            if (stringArray.length != 3) throw new pksd("commands.scoreboard.teams.remove.usage", new Object[0]);
            this._d(nemo2, stringArray, 2);
            return;
        } else if (stringArray[1].equalsIgnoreCase("empty")) {
            if (stringArray.length != 3) throw new pksd("commands.scoreboard.teams.empty.usage", new Object[0]);
            this._h(nemo2, stringArray, 2);
            return;
        } else if (stringArray[1].equalsIgnoreCase("join")) {
            if (stringArray.length < 4 && (stringArray.length != 3 || !(nemo2 instanceof EntityPlayer))) throw new pksd("commands.scoreboard.teams.join.usage", new Object[0]);
            this._f(nemo2, stringArray, 2);
            return;
        } else if (stringArray[1].equalsIgnoreCase("leave")) {
            if (stringArray.length < 3 && !(nemo2 instanceof EntityPlayer)) throw new pksd("commands.scoreboard.teams.leave.usage", new Object[0]);
            this._g(nemo2, stringArray, 2);
            return;
        } else {
            if (!stringArray[1].equalsIgnoreCase("option")) throw new pksd("commands.scoreboard.teams.usage", new Object[0]);
            if (stringArray.length != 4 && stringArray.length != 5) throw new pksd("commands.scoreboard.teams.option.usage", new Object[0]);
            this._c(nemo2, stringArray, 2);
        }
    }

    public fojy _a() {
        return dzfd._I()._a(0).func_96441_U();
    }

    public igri _a(String string, boolean bl) {
        fojy fojy2 = this._a();
        igri igri2 = fojy2._a(string);
        if (igri2 == null) {
            throw new cekk("commands.scoreboard.objectiveNotFound", string);
        }
        if (bl && igri2._c()._b()) {
            throw new cekk("commands.scoreboard.objectiveReadOnly", string);
        }
        return igri2;
    }

    public dzew _a(String string) {
        fojy fojy2 = this._a();
        dzew dzew2 = fojy2._d(string);
        if (dzew2 == null) {
            throw new cekk("commands.scoreboard.teamNotFound", string);
        }
        return dzew2;
    }

    public void _a(nemo nemo2, String[] stringArray, int n) {
        String string = stringArray[n++];
        String string2 = stringArray[n++];
        fojy fojy2 = this._a();
        nwbn nwbn2 = (nwbn)nwbn._b.get(string2);
        if (nwbn2 == null) {
            Object[] objectArray = nwbn._b.keySet().toArray(new String[0]);
            throw new pksd("commands.scoreboard.objectives.add.wrongType", ywav.func_71527_a(objectArray));
        }
        if (fojy2._a(string) != null) {
            throw new cekk("commands.scoreboard.objectives.add.alreadyExists", string);
        }
        if (string.length() > 16) {
            throw new cene("commands.scoreboard.objectives.add.tooLong", string, 16);
        }
        if (string.length() == 0) {
            throw new pksd("commands.scoreboard.objectives.add.usage", new Object[0]);
        }
        if (stringArray.length > n) {
            String string3 = ywav.func_82360_a(nemo2, stringArray, n);
            if (string3.length() > 32) {
                throw new cene("commands.scoreboard.objectives.add.displayTooLong", string3, 32);
            }
            if (string3.length() > 0) {
                fojy2._a(string, nwbn2)._a(string3);
            } else {
                fojy2._a(string, nwbn2);
            }
        } else {
            fojy2._a(string, nwbn2);
        }
        ywav.func_71522_a(nemo2, "commands.scoreboard.objectives.add.success", string);
    }

    public void _b(nemo nemo2, String[] stringArray, int n) {
        String string = stringArray[n++];
        fojy fojy2 = this._a();
        if (fojy2._d(string) != null) {
            throw new cekk("commands.scoreboard.teams.add.alreadyExists", string);
        }
        if (string.length() > 16) {
            throw new cene("commands.scoreboard.teams.add.tooLong", string, 16);
        }
        if (string.length() == 0) {
            throw new pksd("commands.scoreboard.teams.add.usage", new Object[0]);
        }
        if (stringArray.length > n) {
            String string2 = ywav.func_82360_a(nemo2, stringArray, n);
            if (string2.length() > 32) {
                throw new cene("commands.scoreboard.teams.add.displayTooLong", string2, 32);
            }
            if (string2.length() > 0) {
                fojy2._e(string)._a(string2);
            } else {
                fojy2._e(string);
            }
        } else {
            fojy2._e(string);
        }
        ywav.func_71522_a(nemo2, "commands.scoreboard.teams.add.success", string);
    }

    public void _c(nemo nemo2, String[] stringArray, int n) {
        String string;
        dzew dzew2 = this._a(stringArray[n++]);
        if (!((string = stringArray[n++].toLowerCase()).equalsIgnoreCase("color") || string.equalsIgnoreCase("friendlyfire") || string.equalsIgnoreCase("seeFriendlyInvisibles"))) {
            throw new pksd("commands.scoreboard.teams.option.usage", new Object[0]);
        }
        if (stringArray.length == 4) {
            if (string.equalsIgnoreCase("color")) {
                throw new pksd("commands.scoreboard.teams.option.noValue", string, ywav.func_96333_a(ezfc._a(true, false)));
            }
            if (string.equalsIgnoreCase("friendlyfire") || string.equalsIgnoreCase("seeFriendlyInvisibles")) {
                throw new pksd("commands.scoreboard.teams.option.noValue", string, ywav.func_96333_a(Arrays.asList("true", "false")));
            }
            throw new pksd("commands.scoreboard.teams.option.usage", new Object[0]);
        }
        String string2 = stringArray[n++];
        if (string.equalsIgnoreCase("color")) {
            ezfc ezfc2 = ezfc._b(string2);
            if (string2 == null) {
                throw new pksd("commands.scoreboard.teams.option.noValue", string, ywav.func_96333_a(ezfc._a(true, false)));
            }
            dzew2._b(ezfc2.toString());
            dzew2._c(ezfc._v.toString());
        } else if (string.equalsIgnoreCase("friendlyfire")) {
            if (!string2.equalsIgnoreCase("true") && !string2.equalsIgnoreCase("false")) {
                throw new pksd("commands.scoreboard.teams.option.noValue", string, ywav.func_96333_a(Arrays.asList("true", "false")));
            }
            dzew2._a(string2.equalsIgnoreCase("true"));
        } else if (string.equalsIgnoreCase("seeFriendlyInvisibles")) {
            if (!string2.equalsIgnoreCase("true") && !string2.equalsIgnoreCase("false")) {
                throw new pksd("commands.scoreboard.teams.option.noValue", string, ywav.func_96333_a(Arrays.asList("true", "false")));
            }
            dzew2._b(string2.equalsIgnoreCase("true"));
        }
        ywav.func_71522_a(nemo2, "commands.scoreboard.teams.option.success", string, dzew2._a(), string2);
    }

    public void _d(nemo nemo2, String[] stringArray, int n) {
        fojy fojy2 = this._a();
        dzew dzew2 = this._a(stringArray[n++]);
        fojy2._a(dzew2);
        ywav.func_71522_a(nemo2, "commands.scoreboard.teams.remove.success", dzew2._a());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void _e(nemo nemo2, String[] stringArray, int n) {
        fojy fojy2 = this._a();
        if (stringArray.length > n) {
            dzew dzew2;
            Collection collection;
            if ((collection = (dzew2 = this._a(stringArray[n++]))._c()).size() <= 0) throw new cekk("commands.scoreboard.teams.list.player.empty", dzew2._a());
            nemo2.func_70006_a(zwat._b("commands.scoreboard.teams.list.player.count", collection.size(), dzew2._a())._a(ezfc._c));
            nemo2.func_70006_a(zwat._d(ywav.func_71527_a(collection.toArray())));
            return;
        } else {
            Collection collection = fojy2._e();
            if (collection.size() <= 0) throw new cekk("commands.scoreboard.teams.list.empty", new Object[0]);
            nemo2.func_70006_a(zwat._b("commands.scoreboard.teams.list.count", collection.size())._a(ezfc._c));
            for (dzew dzew3 : collection) {
                nemo2.func_70006_a(zwat._b("commands.scoreboard.teams.list.entry", dzew3._a(), dzew3._b(), dzew3._c().size()));
            }
        }
    }

    public void _f(nemo nemo2, String[] stringArray, int n) {
        fojy fojy2 = this._a();
        dzew dzew2 = fojy2._d(stringArray[n++]);
        HashSet<String> hashSet = new HashSet<String>();
        if (nemo2 instanceof EntityPlayer && n == stringArray.length) {
            String string = ywav.func_71521_c(nemo2).func_70023_ak();
            fojy2._a(string, dzew2);
            hashSet.add(string);
        } else {
            while (n < stringArray.length) {
                String string = ywav.func_96332_d(nemo2, stringArray[n++]);
                fojy2._a(string, dzew2);
                hashSet.add(string);
            }
        }
        if (!hashSet.isEmpty()) {
            ywav.func_71522_a(nemo2, "commands.scoreboard.teams.join.success", hashSet.size(), dzew2._a(), ywav.func_71527_a(hashSet.toArray(new String[0])));
        }
    }

    public void _g(nemo nemo2, String[] stringArray, int n) {
        fojy fojy2 = this._a();
        HashSet<String> hashSet = new HashSet<String>();
        HashSet<String> hashSet2 = new HashSet<String>();
        if (nemo2 instanceof EntityPlayer && n == stringArray.length) {
            String string = ywav.func_71521_c(nemo2).func_70023_ak();
            if (fojy2._f(string)) {
                hashSet.add(string);
            } else {
                hashSet2.add(string);
            }
        } else {
            while (n < stringArray.length) {
                String string;
                if (fojy2._f(string = ywav.func_96332_d(nemo2, stringArray[n++]))) {
                    hashSet.add(string);
                    continue;
                }
                hashSet2.add(string);
            }
        }
        if (!hashSet.isEmpty()) {
            ywav.func_71522_a(nemo2, "commands.scoreboard.teams.leave.success", hashSet.size(), ywav.func_71527_a(hashSet.toArray(new String[0])));
        }
        if (!hashSet2.isEmpty()) {
            throw new cekk("commands.scoreboard.teams.leave.failure", hashSet2.size(), ywav.func_71527_a(hashSet2.toArray(new String[0])));
        }
    }

    public void _h(nemo nemo2, String[] stringArray, int n) {
        dzew dzew2;
        ArrayList arrayList;
        fojy fojy2 = this._a();
        if ((arrayList = new ArrayList((dzew2 = this._a(stringArray[n++]))._c())).isEmpty()) {
            throw new cekk("commands.scoreboard.teams.empty.alreadyEmpty", dzew2._a());
        }
        for (String string : arrayList) {
            fojy2._b(string, dzew2);
        }
        ywav.func_71522_a(nemo2, "commands.scoreboard.teams.empty.success", arrayList.size(), dzew2._a());
    }

    public void _a(nemo nemo2, String string) {
        fojy fojy2 = this._a();
        igri igri2 = this._a(string, false);
        fojy2._b(igri2);
        ywav.func_71522_a(nemo2, "commands.scoreboard.objectives.remove.success", string);
    }

    public void _a(nemo nemo2) {
        fojy fojy2 = this._a();
        Collection collection = fojy2._a();
        if (collection.size() > 0) {
            nemo2.func_70006_a(zwat._b("commands.scoreboard.objectives.list.count", collection.size())._a(ezfc._c));
            for (igri igri2 : collection) {
                nemo2.func_70006_a(zwat._b("commands.scoreboard.objectives.list.entry", igri2._b(), igri2._d(), igri2._c()._a()));
            }
        } else {
            throw new cekk("commands.scoreboard.objectives.list.empty", new Object[0]);
        }
    }

    public void _i(nemo nemo2, String[] stringArray, int n) {
        fojy fojy2 = this._a();
        String string = stringArray[n++];
        int n2 = fojy._i(string);
        igri igri2 = null;
        if (stringArray.length == 4) {
            igri2 = this._a(stringArray[n++], false);
        }
        if (n2 < 0) {
            throw new cekk("commands.scoreboard.objectives.setdisplay.invalidSlot", string);
        }
        fojy2._a(n2, igri2);
        if (igri2 != null) {
            ywav.func_71522_a(nemo2, "commands.scoreboard.objectives.setdisplay.successSet", fojy._b(n2), igri2._b());
        } else {
            ywav.func_71522_a(nemo2, "commands.scoreboard.objectives.setdisplay.successCleared", fojy._b(n2));
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void _j(nemo nemo2, String[] stringArray, int n) {
        fojy fojy2 = this._a();
        if (stringArray.length > n) {
            String string;
            Map map;
            if ((map = fojy2._c(string = ywav.func_96332_d(nemo2, stringArray[n++]))).size() <= 0) throw new cekk("commands.scoreboard.players.list.player.empty", string);
            nemo2.func_70006_a(zwat._b("commands.scoreboard.players.list.player.count", map.size(), string)._a(ezfc._c));
            for (cwdc cwdc2 : map.values()) {
                nemo2.func_70006_a(zwat._b("commands.scoreboard.players.list.player.entry", cwdc2._b(), cwdc2._c()._d(), cwdc2._c()._b()));
            }
            return;
        } else {
            Collection collection = fojy2._b();
            if (collection.size() <= 0) throw new cekk("commands.scoreboard.players.list.empty", new Object[0]);
            nemo2.func_70006_a(zwat._b("commands.scoreboard.players.list.count", collection.size())._a(ezfc._c));
            nemo2.func_70006_a(zwat._d(ywav.func_71527_a(collection.toArray())));
        }
    }

    public void _k(nemo nemo2, String[] stringArray, int n) {
        String string = stringArray[n - 1];
        String string2 = ywav.func_96332_d(nemo2, stringArray[n++]);
        igri igri2 = this._a(stringArray[n++], true);
        int n2 = string.equalsIgnoreCase("set") ? ywav.func_71526_a(nemo2, stringArray[n++]) : ywav.func_71528_a(nemo2, stringArray[n++], 1);
        fojy fojy2 = this._a();
        cwdc cwdc2 = fojy2._a(string2, igri2);
        if (string.equalsIgnoreCase("set")) {
            cwdc2._c(n2);
        } else if (string.equalsIgnoreCase("add")) {
            cwdc2._a(n2);
        } else {
            cwdc2._b(n2);
        }
        ywav.func_71522_a(nemo2, "commands.scoreboard.players.set.success", igri2._b(), string2, cwdc2._b());
    }

    public void _l(nemo nemo2, String[] stringArray, int n) {
        fojy fojy2 = this._a();
        String string = ywav.func_96332_d(nemo2, stringArray[n++]);
        fojy2._b(string);
        ywav.func_71522_a(nemo2, "commands.scoreboard.players.reset.success", string);
    }

    @Override
    public List func_71516_a(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 1) {
            return ywav.func_71530_a(stringArray, "objectives", "players", "teams");
        }
        if (stringArray[0].equalsIgnoreCase("objectives")) {
            if (stringArray.length == 2) {
                return ywav.func_71530_a(stringArray, "list", "add", "remove", "setdisplay");
            }
            if (stringArray[1].equalsIgnoreCase("add")) {
                if (stringArray.length == 4) {
                    return ywav.func_71531_a(stringArray, nwbn._b.keySet());
                }
            } else if (stringArray[1].equalsIgnoreCase("remove")) {
                if (stringArray.length == 3) {
                    return ywav.func_71531_a(stringArray, this._a(false));
                }
            } else if (stringArray[1].equalsIgnoreCase("setdisplay")) {
                if (stringArray.length == 3) {
                    return ywav.func_71530_a(stringArray, "list", "sidebar", "belowName");
                }
                if (stringArray.length == 4) {
                    return ywav.func_71531_a(stringArray, this._a(false));
                }
            }
        } else if (stringArray[0].equalsIgnoreCase("players")) {
            if (stringArray.length == 2) {
                return ywav.func_71530_a(stringArray, "set", "add", "remove", "reset", "list");
            }
            if (stringArray[1].equalsIgnoreCase("set") || stringArray[1].equalsIgnoreCase("add") || stringArray[1].equalsIgnoreCase("remove")) {
                if (stringArray.length == 3) {
                    return ywav.func_71530_a(stringArray, dzfd._I()._i());
                }
                if (stringArray.length == 4) {
                    return ywav.func_71531_a(stringArray, this._a(true));
                }
            } else if ((stringArray[1].equalsIgnoreCase("reset") || stringArray[1].equalsIgnoreCase("list")) && stringArray.length == 3) {
                return ywav.func_71531_a(stringArray, this._a()._b());
            }
        } else if (stringArray[0].equalsIgnoreCase("teams")) {
            if (stringArray.length == 2) {
                return ywav.func_71530_a(stringArray, "add", "remove", "join", "leave", "empty", "list", "option");
            }
            if (stringArray[1].equalsIgnoreCase("join")) {
                if (stringArray.length == 3) {
                    return ywav.func_71531_a(stringArray, this._a()._d());
                }
                if (stringArray.length >= 4) {
                    return ywav.func_71530_a(stringArray, dzfd._I()._i());
                }
            } else {
                if (stringArray[1].equalsIgnoreCase("leave")) {
                    return ywav.func_71530_a(stringArray, dzfd._I()._i());
                }
                if (stringArray[1].equalsIgnoreCase("empty") || stringArray[1].equalsIgnoreCase("list") || stringArray[1].equalsIgnoreCase("remove")) {
                    if (stringArray.length == 3) {
                        return ywav.func_71531_a(stringArray, this._a()._d());
                    }
                } else if (stringArray[1].equalsIgnoreCase("option")) {
                    if (stringArray.length == 3) {
                        return ywav.func_71531_a(stringArray, this._a()._d());
                    }
                    if (stringArray.length == 4) {
                        return ywav.func_71530_a(stringArray, "color", "friendlyfire", "seeFriendlyInvisibles");
                    }
                    if (stringArray.length == 5) {
                        if (stringArray[3].equalsIgnoreCase("color")) {
                            return ywav.func_71531_a(stringArray, ezfc._a(true, false));
                        }
                        if (stringArray[3].equalsIgnoreCase("friendlyfire") || stringArray[3].equalsIgnoreCase("seeFriendlyInvisibles")) {
                            return ywav.func_71530_a(stringArray, "true", "false");
                        }
                    }
                }
            }
        }
        return null;
    }

    public List _a(boolean bl) {
        Collection collection = this._a()._a();
        ArrayList<String> arrayList = new ArrayList<String>();
        for (igri igri2 : collection) {
            if (bl && igri2._c()._b()) continue;
            arrayList.add(igri2._b());
        }
        return arrayList;
    }

    @Override
    public boolean func_82358_a(String[] stringArray, int n) {
        if (stringArray[0].equalsIgnoreCase("players")) {
            return n == 2;
        }
        if (stringArray[0].equalsIgnoreCase("teams")) {
            return n == 2 || n == 3;
        }
        return false;
    }
}

