/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cm
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.common.network.IPacketHandler
 *  cpw.mods.fml.common.network.Player
 *  cpw.mods.fml.relauncher.Side
 *  ea
 */
package ru.stalcraft.network;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import ru.stalcraft.Logger;
import ru.stalcraft.network.DebugPriority;
import ru.stalcraft.network.IOpcode;
import ru.stalcraft.network.IOpcodeClient;
import ru.stalcraft.network.IOpcodeServer;

public class PacketHandler
implements IPacketHandler {
    int colon = ":".charAt(0);
    char slash = "\\".charAt(0);
    public static Set debugGroups = new HashSet();
    public static Set debugOpcodes = new HashSet();
    public static DebugPriority minPriority = DebugPriority.LOW;
    private static HashMap<Integer, IOpcode[]> opcodes = new HashMap();

    public void onPacketData(cm manager, ea packet, Player player) {
        Side side = FMLCommonHandler.instance().getEffectiveSide();
        try {
            int cOpcode;
            String[] data;
            String dataStr;
            DataInputStream e2 = new DataInputStream(new ByteArrayInputStream(packet.c));
            new StringBuilder();
            byte[] bytes = new byte[e2.available()];
            for (int info = 0; info < bytes.length; ++info) {
                bytes[info] = e2.readByte();
            }
            String var20 = new String(bytes, "UTF-8");
            String[] opcodeAndData = var20.split(":", 3);
            int opcode = Integer.valueOf(opcodeAndData[0]);
            int argsCount = Integer.valueOf(opcodeAndData[1]);
            String string = dataStr = opcodeAndData.length == 3 ? opcodeAndData[2] : "";
            if (argsCount == 0) {
                data = new String[]{};
            } else {
                data = new String[argsCount];
                cOpcode = 0;
                int endIndex = -1;
                for (int i2 = 0; i2 < argsCount; ++i2) {
                    int slashCount;
                    do {
                        endIndex = dataStr.indexOf(this.colon, endIndex + 1);
                        slashCount = 0;
                        if (endIndex == -1) {
                            endIndex = dataStr.length();
                            continue;
                        }
                        int j2 = endIndex - 1;
                        while (j2 >= 0 && dataStr.charAt(j2--) == this.slash) {
                            ++slashCount;
                        }
                    } while (slashCount % 2 != 0);
                    data[i2] = dataStr.substring(cOpcode, endIndex);
                    cOpcode = endIndex + 1;
                }
            }
            for (cOpcode = 0; cOpcode < data.length; ++cOpcode) {
                data[cOpcode] = data[cOpcode].replaceAll("\\\\:", ":").replaceAll("\\\\\\\\", "\\\\");
            }
            if (side == Side.CLIENT) {
                ((IOpcodeClient[])opcodes.get(0))[opcode].handle(data);
            } else {
                IOpcodeServer var21 = ((IOpcodeServer[])opcodes.get(1))[opcode];
                if (debugGroups.contains((Object)var21.getGroup())) {
                    if (debugOpcodes.contains(var21)) {
                        if (minPriority.ordinal() <= var21.getPriority().ordinal()) {
                            Logger.debug("Received packet " + var21.getName() + " from player " + ((uf)player).bu);
                            PacketHandler.printArgs(data);
                        }
                    }
                }
                var21.handle((jv)player, data);
            }
        }
        catch (Exception var19) {
            var19.printStackTrace();
        }
    }

    public static void printArgs(String ... args) {
        if (args.length > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Arguments: ");
            for (int i2 = 0; i2 < args.length; ++i2) {
                sb2.append(i2 + 1 + ": \"" + args[i2] + "\"");
                if (i2 + 1 >= args.length) continue;
                sb2.append(", ");
            }
            Logger.debug(sb2.toString());
        }
    }

    public static void printArgs(Object ... args) {
        String[] strArgs = new String[args.length];
        for (int i2 = 0; i2 < args.length; ++i2) {
            strArgs[i2] = args[i2].toString();
        }
        PacketHandler.printArgs(strArgs);
    }

    public static void addPackets(IOpcode[] par2) {
        opcodes.put(par2[0] instanceof IOpcodeClient ? 0 : 1, par2);
    }
}

