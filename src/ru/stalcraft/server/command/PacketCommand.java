/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ad
 *  net.minecraft.server.MinecraftServer
 */
package ru.stalcraft.server.command;

import net.minecraft.server.MinecraftServer;
import ru.stalcraft.network.DebugGroup;
import ru.stalcraft.network.DebugPriority;
import ru.stalcraft.network.PacketHandler;
import ru.stalcraft.server.network.ClientOpcode;

public class PacketCommand
extends z {
    public String c() {
        return "packetlog";
    }

    public void b(ad cs2, String[] args) {
        jv par3 = MinecraftServer.F().af().f(cs2.c_());
        if (par3 != null && !MinecraftServer.F().af().e(par3.bu)) {
            return;
        }
        if (args.length == 0) {
            cs2.a(new cv().a("/packetlog <add/remove/priority>"));
        } else {
            if (args[0].equals("priority")) {
                if (args.length == 1) {
                    cs2.a(new cv().a(this.getPriorityUsage()));
                    return;
                }
                DebugPriority remove = null;
                try {
                    remove = DebugPriority.valueOf(args[1]);
                }
                catch (Exception exception) {
                    // empty catch block
                }
                if (remove == null) {
                    cs2.a(new cv().a(this.getPriorityUsage()));
                    return;
                }
                PacketHandler.minPriority = remove;
                cs2.a(new cv().a("\u041c\u0438\u043d\u0438\u043c\u0430\u043b\u044c\u043d\u044b\u0439 \u043f\u0440\u0438\u043e\u0440\u0438\u0442\u0435\u0442 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d."));
            }
            if (args[0].equals("remove") || args[0].equals("add")) {
                boolean var12 = args[0].equals("remove");
                if (args.length == 1 || !args[1].equals("group") && !args[1].equals("packet")) {
                    cs2.a(new cv().a("/packetlog <add/remove> <group/packet> <name>"));
                    return;
                }
                if (args[1].equals("group")) {
                    if (args.length == 2) {
                        cs2.a(new cv().a(this.getGroupUsage()));
                        return;
                    }
                    if (args[2].equals("all")) {
                        if (var12) {
                            PacketHandler.debugGroups.clear();
                        } else {
                            for (DebugGroup opcode1 : DebugGroup.values()) {
                                PacketHandler.debugGroups.add(opcode1);
                            }
                        }
                    } else {
                        DebugGroup var13 = null;
                        try {
                            var13 = DebugGroup.valueOf(args[2]);
                        }
                        catch (Exception opcode1) {
                            // empty catch block
                        }
                        if (var13 == null) {
                            cs2.a(new cv().a(this.getGroupUsage()));
                            return;
                        }
                        if (var12) {
                            PacketHandler.debugGroups.remove((Object)var13);
                            cs2.a(new cv().a("\u0413\u0440\u0443\u043f\u043f\u0430 \u0443\u0434\u0430\u043b\u0435\u043d\u0430."));
                        } else {
                            PacketHandler.debugGroups.add(var13);
                            cs2.a(new cv().a("\u0413\u0440\u0443\u043f\u043f\u0430 \u0434\u043e\u0431\u0430\u0432\u043b\u0435\u043d\u0430."));
                        }
                    }
                } else {
                    if (args.length == 2) {
                        cs2.a(new cv().a("/packetlog <add/remove> packet <name>"));
                        return;
                    }
                    if (args[2].equals("all")) {
                        if (var12) {
                            PacketHandler.debugOpcodes.clear();
                        } else {
                            for (ClientOpcode var18 : ClientOpcode.values()) {
                                PacketHandler.debugOpcodes.add(var18);
                            }
                        }
                    } else {
                        ClientOpcode var16 = null;
                        if (var16 == null) {
                            try {
                                var16 = ClientOpcode.valueOf(args[2]);
                            }
                            catch (Exception exception) {
                                // empty catch block
                            }
                        }
                        if (var16 == null) {
                            cs2.a(new cv().a("no such packet!"));
                            return;
                        }
                        if (var12) {
                            PacketHandler.debugOpcodes.remove(var16);
                            cs2.a(new cv().a("\u041f\u0430\u043a\u0435\u0442 \u0443\u0434\u0430\u043b\u0435\u043d."));
                        } else {
                            PacketHandler.debugOpcodes.add(var16);
                            cs2.a(new cv().a("\u041f\u0430\u043a\u0435\u0442 \u0434\u043e\u0431\u0430\u0432\u043b\u0435\u043d."));
                        }
                    }
                }
            }
        }
    }

    private String getPriorityUsage() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("/packetlog priority <");
        DebugPriority[] priorities = DebugPriority.values();
        for (int i2 = 0; i2 < priorities.length; ++i2) {
            sb2.append((Object)priorities[i2]);
            if (i2 + 1 >= priorities.length) continue;
            sb2.append("/");
        }
        sb2.append(">");
        return sb2.toString();
    }

    private String getGroupUsage() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("/packetlog <add/remove> group <");
        DebugGroup[] groups = DebugGroup.values();
        for (int i2 = 0; i2 < groups.length; ++i2) {
            sb2.append((Object)groups[i2]);
            if (i2 + 1 >= groups.length) continue;
            sb2.append("/");
        }
        sb2.append(">");
        return sb2.toString();
    }

    public String c(ad icommandsender) {
        return "";
    }
}

