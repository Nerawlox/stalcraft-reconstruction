/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.scoreboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreObjectiveCriteria;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;

public class ServerCommandScoreboard
extends CommandBase {
    @Override
    public String getCommandName() {
        return "scoreboard";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.scoreboard.usage";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length < 1) throw new pksd("commands.scoreboard.usage", new Object[0]);
        if (stringArray[0].equalsIgnoreCase("objectives")) {
            if (stringArray.length == 1) {
                throw new pksd("commands.scoreboard.objectives.usage", new Object[0]);
            }
            if (stringArray[1].equalsIgnoreCase("list")) {
                this._a(iCommandSender);
                return;
            } else if (stringArray[1].equalsIgnoreCase("add")) {
                if (stringArray.length < 4) throw new pksd("commands.scoreboard.objectives.add.usage", new Object[0]);
                this._a(iCommandSender, stringArray, 2);
                return;
            } else if (stringArray[1].equalsIgnoreCase("remove")) {
                if (stringArray.length != 3) throw new pksd("commands.scoreboard.objectives.remove.usage", new Object[0]);
                this._a(iCommandSender, stringArray[2]);
                return;
            } else {
                if (!stringArray[1].equalsIgnoreCase("setdisplay")) throw new pksd("commands.scoreboard.objectives.usage", new Object[0]);
                if (stringArray.length != 3 && stringArray.length != 4) throw new pksd("commands.scoreboard.objectives.setdisplay.usage", new Object[0]);
                this._i(iCommandSender, stringArray, 2);
            }
            return;
        }
        if (stringArray[0].equalsIgnoreCase("players")) {
            if (stringArray.length == 1) {
                throw new pksd("commands.scoreboard.players.usage", new Object[0]);
            }
            if (stringArray[1].equalsIgnoreCase("list")) {
                if (stringArray.length > 3) throw new pksd("commands.scoreboard.players.list.usage", new Object[0]);
                this._j(iCommandSender, stringArray, 2);
                return;
            } else if (stringArray[1].equalsIgnoreCase("add")) {
                if (stringArray.length != 5) throw new pksd("commands.scoreboard.players.add.usage", new Object[0]);
                this._k(iCommandSender, stringArray, 2);
                return;
            } else if (stringArray[1].equalsIgnoreCase("remove")) {
                if (stringArray.length != 5) throw new pksd("commands.scoreboard.players.remove.usage", new Object[0]);
                this._k(iCommandSender, stringArray, 2);
                return;
            } else if (stringArray[1].equalsIgnoreCase("set")) {
                if (stringArray.length != 5) throw new pksd("commands.scoreboard.players.set.usage", new Object[0]);
                this._k(iCommandSender, stringArray, 2);
                return;
            } else {
                if (!stringArray[1].equalsIgnoreCase("reset")) throw new pksd("commands.scoreboard.players.usage", new Object[0]);
                if (stringArray.length != 3) throw new pksd("commands.scoreboard.players.reset.usage", new Object[0]);
                this._l(iCommandSender, stringArray, 2);
            }
            return;
        }
        if (!stringArray[0].equalsIgnoreCase("teams")) throw new pksd("commands.scoreboard.usage", new Object[0]);
        if (stringArray.length == 1) {
            throw new pksd("commands.scoreboard.teams.usage", new Object[0]);
        }
        if (stringArray[1].equalsIgnoreCase("list")) {
            if (stringArray.length > 3) throw new pksd("commands.scoreboard.teams.list.usage", new Object[0]);
            this._e(iCommandSender, stringArray, 2);
            return;
        } else if (stringArray[1].equalsIgnoreCase("add")) {
            if (stringArray.length < 3) throw new pksd("commands.scoreboard.teams.add.usage", new Object[0]);
            this._b(iCommandSender, stringArray, 2);
            return;
        } else if (stringArray[1].equalsIgnoreCase("remove")) {
            if (stringArray.length != 3) throw new pksd("commands.scoreboard.teams.remove.usage", new Object[0]);
            this._d(iCommandSender, stringArray, 2);
            return;
        } else if (stringArray[1].equalsIgnoreCase("empty")) {
            if (stringArray.length != 3) throw new pksd("commands.scoreboard.teams.empty.usage", new Object[0]);
            this._h(iCommandSender, stringArray, 2);
            return;
        } else if (stringArray[1].equalsIgnoreCase("join")) {
            if (stringArray.length < 4 && (stringArray.length != 3 || !(iCommandSender instanceof EntityPlayer))) throw new pksd("commands.scoreboard.teams.join.usage", new Object[0]);
            this._f(iCommandSender, stringArray, 2);
            return;
        } else if (stringArray[1].equalsIgnoreCase("leave")) {
            if (stringArray.length < 3 && !(iCommandSender instanceof EntityPlayer)) throw new pksd("commands.scoreboard.teams.leave.usage", new Object[0]);
            this._g(iCommandSender, stringArray, 2);
            return;
        } else {
            if (!stringArray[1].equalsIgnoreCase("option")) throw new pksd("commands.scoreboard.teams.usage", new Object[0]);
            if (stringArray.length != 4 && stringArray.length != 5) throw new pksd("commands.scoreboard.teams.option.usage", new Object[0]);
            this._c(iCommandSender, stringArray, 2);
        }
    }

    public Scoreboard _a() {
        return MinecraftServer._I()._a(0).getScoreboard();
    }

    public ScoreObjective _a(String string, boolean bl) {
        Scoreboard scoreboard = this._a();
        ScoreObjective scoreObjective = scoreboard._a(string);
        if (scoreObjective == null) {
            throw new cekk("commands.scoreboard.objectiveNotFound", string);
        }
        if (bl && scoreObjective._c()._b()) {
            throw new cekk("commands.scoreboard.objectiveReadOnly", string);
        }
        return scoreObjective;
    }

    public ScorePlayerTeam _a(String string) {
        Scoreboard scoreboard = this._a();
        ScorePlayerTeam scorePlayerTeam = scoreboard._d(string);
        if (scorePlayerTeam == null) {
            throw new cekk("commands.scoreboard.teamNotFound", string);
        }
        return scorePlayerTeam;
    }

    public void _a(ICommandSender iCommandSender, String[] stringArray, int n) {
        String string = stringArray[n++];
        String string2 = stringArray[n++];
        Scoreboard scoreboard = this._a();
        ScoreObjectiveCriteria scoreObjectiveCriteria = (ScoreObjectiveCriteria)ScoreObjectiveCriteria._b.get(string2);
        if (scoreObjectiveCriteria == null) {
            Object[] objectArray = ScoreObjectiveCriteria._b.keySet().toArray(new String[0]);
            throw new pksd("commands.scoreboard.objectives.add.wrongType", ServerCommandScoreboard.joinNiceString(objectArray));
        }
        if (scoreboard._a(string) != null) {
            throw new cekk("commands.scoreboard.objectives.add.alreadyExists", string);
        }
        if (string.length() > 16) {
            throw new cene("commands.scoreboard.objectives.add.tooLong", string, 16);
        }
        if (string.length() == 0) {
            throw new pksd("commands.scoreboard.objectives.add.usage", new Object[0]);
        }
        if (stringArray.length > n) {
            String string3 = ServerCommandScoreboard.func_82360_a(iCommandSender, stringArray, n);
            if (string3.length() > 32) {
                throw new cene("commands.scoreboard.objectives.add.displayTooLong", string3, 32);
            }
            if (string3.length() > 0) {
                scoreboard._a(string, scoreObjectiveCriteria)._a(string3);
            } else {
                scoreboard._a(string, scoreObjectiveCriteria);
            }
        } else {
            scoreboard._a(string, scoreObjectiveCriteria);
        }
        ServerCommandScoreboard.notifyAdmins(iCommandSender, "commands.scoreboard.objectives.add.success", string);
    }

    public void _b(ICommandSender iCommandSender, String[] stringArray, int n) {
        String string = stringArray[n++];
        Scoreboard scoreboard = this._a();
        if (scoreboard._d(string) != null) {
            throw new cekk("commands.scoreboard.teams.add.alreadyExists", string);
        }
        if (string.length() > 16) {
            throw new cene("commands.scoreboard.teams.add.tooLong", string, 16);
        }
        if (string.length() == 0) {
            throw new pksd("commands.scoreboard.teams.add.usage", new Object[0]);
        }
        if (stringArray.length > n) {
            String string2 = ServerCommandScoreboard.func_82360_a(iCommandSender, stringArray, n);
            if (string2.length() > 32) {
                throw new cene("commands.scoreboard.teams.add.displayTooLong", string2, 32);
            }
            if (string2.length() > 0) {
                scoreboard._e(string)._a(string2);
            } else {
                scoreboard._e(string);
            }
        } else {
            scoreboard._e(string);
        }
        ServerCommandScoreboard.notifyAdmins(iCommandSender, "commands.scoreboard.teams.add.success", string);
    }

    public void _c(ICommandSender iCommandSender, String[] stringArray, int n) {
        String string;
        ScorePlayerTeam scorePlayerTeam = this._a(stringArray[n++]);
        if (!((string = stringArray[n++].toLowerCase()).equalsIgnoreCase("color") || string.equalsIgnoreCase("friendlyfire") || string.equalsIgnoreCase("seeFriendlyInvisibles"))) {
            throw new pksd("commands.scoreboard.teams.option.usage", new Object[0]);
        }
        if (stringArray.length == 4) {
            if (string.equalsIgnoreCase("color")) {
                throw new pksd("commands.scoreboard.teams.option.noValue", string, ServerCommandScoreboard.func_96333_a(EnumChatFormatting._a(true, false)));
            }
            if (string.equalsIgnoreCase("friendlyfire") || string.equalsIgnoreCase("seeFriendlyInvisibles")) {
                throw new pksd("commands.scoreboard.teams.option.noValue", string, ServerCommandScoreboard.func_96333_a(Arrays.asList("true", "false")));
            }
            throw new pksd("commands.scoreboard.teams.option.usage", new Object[0]);
        }
        String string2 = stringArray[n++];
        if (string.equalsIgnoreCase("color")) {
            EnumChatFormatting enumChatFormatting = EnumChatFormatting._b(string2);
            if (string2 == null) {
                throw new pksd("commands.scoreboard.teams.option.noValue", string, ServerCommandScoreboard.func_96333_a(EnumChatFormatting._a(true, false)));
            }
            scorePlayerTeam._b(enumChatFormatting.toString());
            scorePlayerTeam._c(EnumChatFormatting._v.toString());
        } else if (string.equalsIgnoreCase("friendlyfire")) {
            if (!string2.equalsIgnoreCase("true") && !string2.equalsIgnoreCase("false")) {
                throw new pksd("commands.scoreboard.teams.option.noValue", string, ServerCommandScoreboard.func_96333_a(Arrays.asList("true", "false")));
            }
            scorePlayerTeam._a(string2.equalsIgnoreCase("true"));
        } else if (string.equalsIgnoreCase("seeFriendlyInvisibles")) {
            if (!string2.equalsIgnoreCase("true") && !string2.equalsIgnoreCase("false")) {
                throw new pksd("commands.scoreboard.teams.option.noValue", string, ServerCommandScoreboard.func_96333_a(Arrays.asList("true", "false")));
            }
            scorePlayerTeam._b(string2.equalsIgnoreCase("true"));
        }
        ServerCommandScoreboard.notifyAdmins(iCommandSender, "commands.scoreboard.teams.option.success", string, scorePlayerTeam._a(), string2);
    }

    public void _d(ICommandSender iCommandSender, String[] stringArray, int n) {
        Scoreboard scoreboard = this._a();
        ScorePlayerTeam scorePlayerTeam = this._a(stringArray[n++]);
        scoreboard._a(scorePlayerTeam);
        ServerCommandScoreboard.notifyAdmins(iCommandSender, "commands.scoreboard.teams.remove.success", scorePlayerTeam._a());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void _e(ICommandSender iCommandSender, String[] stringArray, int n) {
        Scoreboard scoreboard = this._a();
        if (stringArray.length > n) {
            ScorePlayerTeam scorePlayerTeam;
            Collection collection;
            if ((collection = (scorePlayerTeam = this._a(stringArray[n++]))._c()).size() <= 0) throw new cekk("commands.scoreboard.teams.list.player.empty", scorePlayerTeam._a());
            iCommandSender.sendChatToPlayer(ChatMessageComponent._b("commands.scoreboard.teams.list.player.count", collection.size(), scorePlayerTeam._a())._a(EnumChatFormatting._c));
            iCommandSender.sendChatToPlayer(ChatMessageComponent._d(ServerCommandScoreboard.joinNiceString(collection.toArray())));
            return;
        } else {
            Collection collection = scoreboard._e();
            if (collection.size() <= 0) throw new cekk("commands.scoreboard.teams.list.empty", new Object[0]);
            iCommandSender.sendChatToPlayer(ChatMessageComponent._b("commands.scoreboard.teams.list.count", collection.size())._a(EnumChatFormatting._c));
            for (ScorePlayerTeam scorePlayerTeam : collection) {
                iCommandSender.sendChatToPlayer(ChatMessageComponent._b("commands.scoreboard.teams.list.entry", scorePlayerTeam._a(), scorePlayerTeam._b(), scorePlayerTeam._c().size()));
            }
        }
    }

    public void _f(ICommandSender iCommandSender, String[] stringArray, int n) {
        Scoreboard scoreboard = this._a();
        ScorePlayerTeam scorePlayerTeam = scoreboard._d(stringArray[n++]);
        HashSet<String> hashSet = new HashSet<String>();
        if (iCommandSender instanceof EntityPlayer && n == stringArray.length) {
            String string = ServerCommandScoreboard.getCommandSenderAsPlayer(iCommandSender).getEntityName();
            scoreboard._a(string, scorePlayerTeam);
            hashSet.add(string);
        } else {
            while (n < stringArray.length) {
                String string = ServerCommandScoreboard.func_96332_d(iCommandSender, stringArray[n++]);
                scoreboard._a(string, scorePlayerTeam);
                hashSet.add(string);
            }
        }
        if (!hashSet.isEmpty()) {
            ServerCommandScoreboard.notifyAdmins(iCommandSender, "commands.scoreboard.teams.join.success", hashSet.size(), scorePlayerTeam._a(), ServerCommandScoreboard.joinNiceString(hashSet.toArray(new String[0])));
        }
    }

    public void _g(ICommandSender iCommandSender, String[] stringArray, int n) {
        Scoreboard scoreboard = this._a();
        HashSet<String> hashSet = new HashSet<String>();
        HashSet<String> hashSet2 = new HashSet<String>();
        if (iCommandSender instanceof EntityPlayer && n == stringArray.length) {
            String string = ServerCommandScoreboard.getCommandSenderAsPlayer(iCommandSender).getEntityName();
            if (scoreboard._f(string)) {
                hashSet.add(string);
            } else {
                hashSet2.add(string);
            }
        } else {
            while (n < stringArray.length) {
                String string;
                if (scoreboard._f(string = ServerCommandScoreboard.func_96332_d(iCommandSender, stringArray[n++]))) {
                    hashSet.add(string);
                    continue;
                }
                hashSet2.add(string);
            }
        }
        if (!hashSet.isEmpty()) {
            ServerCommandScoreboard.notifyAdmins(iCommandSender, "commands.scoreboard.teams.leave.success", hashSet.size(), ServerCommandScoreboard.joinNiceString(hashSet.toArray(new String[0])));
        }
        if (!hashSet2.isEmpty()) {
            throw new cekk("commands.scoreboard.teams.leave.failure", hashSet2.size(), ServerCommandScoreboard.joinNiceString(hashSet2.toArray(new String[0])));
        }
    }

    public void _h(ICommandSender iCommandSender, String[] stringArray, int n) {
        ScorePlayerTeam scorePlayerTeam;
        ArrayList arrayList;
        Scoreboard scoreboard = this._a();
        if ((arrayList = new ArrayList((scorePlayerTeam = this._a(stringArray[n++]))._c())).isEmpty()) {
            throw new cekk("commands.scoreboard.teams.empty.alreadyEmpty", scorePlayerTeam._a());
        }
        for (String string : arrayList) {
            scoreboard._b(string, scorePlayerTeam);
        }
        ServerCommandScoreboard.notifyAdmins(iCommandSender, "commands.scoreboard.teams.empty.success", arrayList.size(), scorePlayerTeam._a());
    }

    public void _a(ICommandSender iCommandSender, String string) {
        Scoreboard scoreboard = this._a();
        ScoreObjective scoreObjective = this._a(string, false);
        scoreboard._b(scoreObjective);
        ServerCommandScoreboard.notifyAdmins(iCommandSender, "commands.scoreboard.objectives.remove.success", string);
    }

    public void _a(ICommandSender iCommandSender) {
        Scoreboard scoreboard = this._a();
        Collection collection = scoreboard._a();
        if (collection.size() > 0) {
            iCommandSender.sendChatToPlayer(ChatMessageComponent._b("commands.scoreboard.objectives.list.count", collection.size())._a(EnumChatFormatting._c));
            for (ScoreObjective scoreObjective : collection) {
                iCommandSender.sendChatToPlayer(ChatMessageComponent._b("commands.scoreboard.objectives.list.entry", scoreObjective._b(), scoreObjective._d(), scoreObjective._c()._a()));
            }
        } else {
            throw new cekk("commands.scoreboard.objectives.list.empty", new Object[0]);
        }
    }

    public void _i(ICommandSender iCommandSender, String[] stringArray, int n) {
        Scoreboard scoreboard = this._a();
        String string = stringArray[n++];
        int n2 = Scoreboard._i(string);
        ScoreObjective scoreObjective = null;
        if (stringArray.length == 4) {
            scoreObjective = this._a(stringArray[n++], false);
        }
        if (n2 < 0) {
            throw new cekk("commands.scoreboard.objectives.setdisplay.invalidSlot", string);
        }
        scoreboard._a(n2, scoreObjective);
        if (scoreObjective != null) {
            ServerCommandScoreboard.notifyAdmins(iCommandSender, "commands.scoreboard.objectives.setdisplay.successSet", Scoreboard._b(n2), scoreObjective._b());
        } else {
            ServerCommandScoreboard.notifyAdmins(iCommandSender, "commands.scoreboard.objectives.setdisplay.successCleared", Scoreboard._b(n2));
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void _j(ICommandSender iCommandSender, String[] stringArray, int n) {
        Scoreboard scoreboard = this._a();
        if (stringArray.length > n) {
            String string;
            Map map;
            if ((map = scoreboard._c(string = ServerCommandScoreboard.func_96332_d(iCommandSender, stringArray[n++]))).size() <= 0) throw new cekk("commands.scoreboard.players.list.player.empty", string);
            iCommandSender.sendChatToPlayer(ChatMessageComponent._b("commands.scoreboard.players.list.player.count", map.size(), string)._a(EnumChatFormatting._c));
            for (Score score : map.values()) {
                iCommandSender.sendChatToPlayer(ChatMessageComponent._b("commands.scoreboard.players.list.player.entry", score._b(), score._c()._d(), score._c()._b()));
            }
            return;
        } else {
            Collection collection = scoreboard._b();
            if (collection.size() <= 0) throw new cekk("commands.scoreboard.players.list.empty", new Object[0]);
            iCommandSender.sendChatToPlayer(ChatMessageComponent._b("commands.scoreboard.players.list.count", collection.size())._a(EnumChatFormatting._c));
            iCommandSender.sendChatToPlayer(ChatMessageComponent._d(ServerCommandScoreboard.joinNiceString(collection.toArray())));
        }
    }

    public void _k(ICommandSender iCommandSender, String[] stringArray, int n) {
        String string = stringArray[n - 1];
        String string2 = ServerCommandScoreboard.func_96332_d(iCommandSender, stringArray[n++]);
        ScoreObjective scoreObjective = this._a(stringArray[n++], true);
        int n2 = string.equalsIgnoreCase("set") ? ServerCommandScoreboard.parseInt(iCommandSender, stringArray[n++]) : ServerCommandScoreboard.parseIntWithMin(iCommandSender, stringArray[n++], 1);
        Scoreboard scoreboard = this._a();
        Score score = scoreboard._a(string2, scoreObjective);
        if (string.equalsIgnoreCase("set")) {
            score._c(n2);
        } else if (string.equalsIgnoreCase("add")) {
            score._a(n2);
        } else {
            score._b(n2);
        }
        ServerCommandScoreboard.notifyAdmins(iCommandSender, "commands.scoreboard.players.set.success", scoreObjective._b(), string2, score._b());
    }

    public void _l(ICommandSender iCommandSender, String[] stringArray, int n) {
        Scoreboard scoreboard = this._a();
        String string = ServerCommandScoreboard.func_96332_d(iCommandSender, stringArray[n++]);
        scoreboard._b(string);
        ServerCommandScoreboard.notifyAdmins(iCommandSender, "commands.scoreboard.players.reset.success", string);
    }

    @Override
    public List addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            return ServerCommandScoreboard.getListOfStringsMatchingLastWord(stringArray, "objectives", "players", "teams");
        }
        if (stringArray[0].equalsIgnoreCase("objectives")) {
            if (stringArray.length == 2) {
                return ServerCommandScoreboard.getListOfStringsMatchingLastWord(stringArray, "list", "add", "remove", "setdisplay");
            }
            if (stringArray[1].equalsIgnoreCase("add")) {
                if (stringArray.length == 4) {
                    return ServerCommandScoreboard.getListOfStringsFromIterableMatchingLastWord(stringArray, ScoreObjectiveCriteria._b.keySet());
                }
            } else if (stringArray[1].equalsIgnoreCase("remove")) {
                if (stringArray.length == 3) {
                    return ServerCommandScoreboard.getListOfStringsFromIterableMatchingLastWord(stringArray, this._a(false));
                }
            } else if (stringArray[1].equalsIgnoreCase("setdisplay")) {
                if (stringArray.length == 3) {
                    return ServerCommandScoreboard.getListOfStringsMatchingLastWord(stringArray, "list", "sidebar", "belowName");
                }
                if (stringArray.length == 4) {
                    return ServerCommandScoreboard.getListOfStringsFromIterableMatchingLastWord(stringArray, this._a(false));
                }
            }
        } else if (stringArray[0].equalsIgnoreCase("players")) {
            if (stringArray.length == 2) {
                return ServerCommandScoreboard.getListOfStringsMatchingLastWord(stringArray, "set", "add", "remove", "reset", "list");
            }
            if (stringArray[1].equalsIgnoreCase("set") || stringArray[1].equalsIgnoreCase("add") || stringArray[1].equalsIgnoreCase("remove")) {
                if (stringArray.length == 3) {
                    return ServerCommandScoreboard.getListOfStringsMatchingLastWord(stringArray, MinecraftServer._I()._i());
                }
                if (stringArray.length == 4) {
                    return ServerCommandScoreboard.getListOfStringsFromIterableMatchingLastWord(stringArray, this._a(true));
                }
            } else if ((stringArray[1].equalsIgnoreCase("reset") || stringArray[1].equalsIgnoreCase("list")) && stringArray.length == 3) {
                return ServerCommandScoreboard.getListOfStringsFromIterableMatchingLastWord(stringArray, this._a()._b());
            }
        } else if (stringArray[0].equalsIgnoreCase("teams")) {
            if (stringArray.length == 2) {
                return ServerCommandScoreboard.getListOfStringsMatchingLastWord(stringArray, "add", "remove", "join", "leave", "empty", "list", "option");
            }
            if (stringArray[1].equalsIgnoreCase("join")) {
                if (stringArray.length == 3) {
                    return ServerCommandScoreboard.getListOfStringsFromIterableMatchingLastWord(stringArray, this._a()._d());
                }
                if (stringArray.length >= 4) {
                    return ServerCommandScoreboard.getListOfStringsMatchingLastWord(stringArray, MinecraftServer._I()._i());
                }
            } else {
                if (stringArray[1].equalsIgnoreCase("leave")) {
                    return ServerCommandScoreboard.getListOfStringsMatchingLastWord(stringArray, MinecraftServer._I()._i());
                }
                if (stringArray[1].equalsIgnoreCase("empty") || stringArray[1].equalsIgnoreCase("list") || stringArray[1].equalsIgnoreCase("remove")) {
                    if (stringArray.length == 3) {
                        return ServerCommandScoreboard.getListOfStringsFromIterableMatchingLastWord(stringArray, this._a()._d());
                    }
                } else if (stringArray[1].equalsIgnoreCase("option")) {
                    if (stringArray.length == 3) {
                        return ServerCommandScoreboard.getListOfStringsFromIterableMatchingLastWord(stringArray, this._a()._d());
                    }
                    if (stringArray.length == 4) {
                        return ServerCommandScoreboard.getListOfStringsMatchingLastWord(stringArray, "color", "friendlyfire", "seeFriendlyInvisibles");
                    }
                    if (stringArray.length == 5) {
                        if (stringArray[3].equalsIgnoreCase("color")) {
                            return ServerCommandScoreboard.getListOfStringsFromIterableMatchingLastWord(stringArray, EnumChatFormatting._a(true, false));
                        }
                        if (stringArray[3].equalsIgnoreCase("friendlyfire") || stringArray[3].equalsIgnoreCase("seeFriendlyInvisibles")) {
                            return ServerCommandScoreboard.getListOfStringsMatchingLastWord(stringArray, "true", "false");
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
        for (ScoreObjective scoreObjective : collection) {
            if (bl && scoreObjective._c()._b()) continue;
            arrayList.add(scoreObjective._b());
        }
        return arrayList;
    }

    @Override
    public boolean isUsernameIndex(String[] stringArray, int n) {
        if (stringArray[0].equalsIgnoreCase("players")) {
            return n == 2;
        }
        if (stringArray[0].equalsIgnoreCase("teams")) {
            return n == 2 || n == 3;
        }
        return false;
    }
}

