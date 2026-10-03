/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet0KeepAlive;
import net.minecraft.network.packet.Packet101CloseWindow;
import net.minecraft.network.packet.Packet102WindowClick;
import net.minecraft.network.packet.Packet106Transaction;
import net.minecraft.network.packet.Packet107CreativeSetSlot;
import net.minecraft.network.packet.Packet108EnchantItem;
import net.minecraft.network.packet.Packet10Flying;
import net.minecraft.network.packet.Packet130UpdateSign;
import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.network.packet.Packet15Place;
import net.minecraft.network.packet.Packet16BlockItemSwitch;
import net.minecraft.network.packet.Packet18Animation;
import net.minecraft.network.packet.Packet19EntityAction;
import net.minecraft.network.packet.Packet202PlayerAbilities;
import net.minecraft.network.packet.Packet203AutoComplete;
import net.minecraft.network.packet.Packet204ClientInfo;
import net.minecraft.network.packet.Packet205ClientCommand;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet255KickDisconnect;
import net.minecraft.network.packet.Packet27PlayerInput;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.network.packet.Packet7UseEntity;
import net.minecraft.network.packet.Packet9Respawn;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.BanEntry;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IntHashMap;
import net.minecraft.util.turb;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class NetServerHandler
extends NetHandler {
    public final jjpj netManager;
    public final MinecraftServer mcServer;
    public boolean connectionClosed;
    public EntityPlayerMP playerEntity;
    public int currentTicks;
    public int field_72572_g;
    public boolean field_72584_h;
    public int keepAliveRandomID;
    public long keepAliveTimeSent;
    public static Random field_72583_k = new Random();
    public long ticksOfLastKeepAlive;
    public int chatSpamThresholdCount;
    public int creativeItemCreationSpamThresholdTally;
    public double lastPosX;
    public double lastPosY;
    public double lastPosZ;
    public boolean hasMoved = true;
    public IntHashMap field_72586_s = new IntHashMap();

    public NetServerHandler(MinecraftServer minecraftServer, jjpj jjpj2, EntityPlayerMP entityPlayerMP) {
        this.mcServer = minecraftServer;
        this.netManager = jjpj2;
        jjpj2._a(this);
        this.playerEntity = entityPlayerMP;
        entityPlayerMP.playerNetServerHandler = this;
    }

    public void func_72570_d() {
        this.field_72584_h = false;
        ++this.currentTicks;
        this.mcServer._g._a("packetflow");
        this.netManager._b();
        this.mcServer._g._c("keepAlive");
        if ((long)this.currentTicks - this.ticksOfLastKeepAlive > 20L) {
            this.ticksOfLastKeepAlive = this.currentTicks;
            this.keepAliveTimeSent = System.nanoTime() / 1000000L;
            this.keepAliveRandomID = field_72583_k.nextInt();
            this.func_72567_b(new Packet0KeepAlive(this.keepAliveRandomID));
        }
        if (this.chatSpamThresholdCount > 0) {
            --this.chatSpamThresholdCount;
        }
        if (this.creativeItemCreationSpamThresholdTally > 0) {
            --this.creativeItemCreationSpamThresholdTally;
        }
        this.mcServer._g._c("playerTick");
        this.mcServer._g._b();
    }

    public void func_72565_c(String string) {
        if (!this.connectionClosed) {
            this.playerEntity.mountEntityAndWakeUp();
            this.func_72567_b(new Packet255KickDisconnect(string));
            this.netManager._d();
            this.mcServer.__ag()._a(ChatMessageComponent._b("multiplayer.player.left", this.playerEntity.getTranslatedEntityName())._a(EnumChatFormatting._o));
            this.mcServer.__ag()._e(this.playerEntity);
            this.connectionClosed = true;
        }
    }

    @Override
    public void func_110774_a(Packet27PlayerInput packet27PlayerInput) {
        this.playerEntity.setEntityActionState(packet27PlayerInput._a(), packet27PlayerInput._b(), packet27PlayerInput._c(), packet27PlayerInput._d());
    }

    @Override
    public void handleFlying(Packet10Flying packet10Flying) {
        ogfj._a(this, packet10Flying);
        WorldServer worldServer = this.mcServer._a(this.playerEntity.dimension);
        this.field_72584_h = true;
        if (!this.playerEntity.playerConqueredTheEnd) {
            double d;
            if (!this.hasMoved) {
                d = packet10Flying._b - this.lastPosY;
                if (packet10Flying._a == this.lastPosX && d * d < 0.01 && packet10Flying._c == this.lastPosZ) {
                    this.hasMoved = true;
                }
            }
            if (this.hasMoved) {
                double d2;
                double d3;
                double d4;
                if (this.playerEntity.ridingEntity != null) {
                    float f = this.playerEntity.rotationYaw;
                    float f2 = this.playerEntity.rotationPitch;
                    this.playerEntity.ridingEntity.updateRiderPosition();
                    double d5 = this.playerEntity.posX;
                    double d6 = this.playerEntity.posY;
                    double d7 = this.playerEntity.posZ;
                    if (packet10Flying._i) {
                        f = packet10Flying._e;
                        f2 = packet10Flying._f;
                    }
                    this.playerEntity.onGround = packet10Flying._g;
                    this.playerEntity.onUpdateEntity();
                    this.playerEntity.ySize = 0.0f;
                    this.playerEntity.setPositionAndRotation(d5, d6, d7, f, f2);
                    if (this.playerEntity.ridingEntity != null) {
                        this.playerEntity.ridingEntity.updateRiderPosition();
                    }
                    if (!this.hasMoved) {
                        ogfj._b(this, packet10Flying);
                        return;
                    }
                    this.mcServer.__ag()._d(this.playerEntity);
                    if (this.hasMoved) {
                        this.lastPosX = this.playerEntity.posX;
                        this.lastPosY = this.playerEntity.posY;
                        this.lastPosZ = this.playerEntity.posZ;
                    }
                    worldServer.updateEntity(this.playerEntity);
                    ogfj._b(this, packet10Flying);
                    return;
                }
                if (this.playerEntity.isPlayerSleeping()) {
                    this.playerEntity.onUpdateEntity();
                    this.playerEntity.setPositionAndRotation(this.lastPosX, this.lastPosY, this.lastPosZ, this.playerEntity.rotationYaw, this.playerEntity.rotationPitch);
                    worldServer.updateEntity(this.playerEntity);
                    ogfj._b(this, packet10Flying);
                    return;
                }
                d = this.playerEntity.posY;
                this.lastPosX = this.playerEntity.posX;
                this.lastPosY = this.playerEntity.posY;
                this.lastPosZ = this.playerEntity.posZ;
                double d8 = this.playerEntity.posX;
                double d9 = this.playerEntity.posY;
                double d10 = this.playerEntity.posZ;
                float f = this.playerEntity.rotationYaw;
                float f3 = this.playerEntity.rotationPitch;
                if (packet10Flying._h && packet10Flying._b == -999.0 && packet10Flying._d == -999.0) {
                    packet10Flying._h = false;
                }
                if (packet10Flying._h) {
                    d8 = packet10Flying._a;
                    d9 = packet10Flying._b;
                    d10 = packet10Flying._c;
                    d4 = packet10Flying._d - packet10Flying._b;
                    if (!this.playerEntity.isPlayerSleeping() && (d4 > 1.65 || d4 < 0.1)) {
                        this.func_72565_c("Illegal stance");
                        this.mcServer._O()._b(this.playerEntity.getCommandSenderName() + " had an illegal stance: " + d4);
                        ogfj._b(this, packet10Flying);
                        return;
                    }
                    if (Math.abs(packet10Flying._a) > 3.2E7 || Math.abs(packet10Flying._c) > 3.2E7) {
                        this.func_72565_c("Illegal position");
                        ogfj._b(this, packet10Flying);
                        return;
                    }
                }
                if (packet10Flying._i) {
                    f = packet10Flying._e;
                    f3 = packet10Flying._f;
                }
                this.playerEntity.onUpdateEntity();
                this.playerEntity.ySize = 0.0f;
                this.playerEntity.setPositionAndRotation(this.lastPosX, this.lastPosY, this.lastPosZ, f, f3);
                if (!this.hasMoved) {
                    ogfj._b(this, packet10Flying);
                    return;
                }
                d4 = d8 - this.playerEntity.posX;
                double d11 = d9 - this.playerEntity.posY;
                double d12 = d10 - this.playerEntity.posZ;
                double d13 = Math.max(Math.abs(d4), Math.abs(this.playerEntity.motionX));
                double d14 = d13 * d13 + (d3 = Math.max(Math.abs(d11), Math.abs(this.playerEntity.motionY))) * d3 + (d2 = Math.max(Math.abs(d12), Math.abs(this.playerEntity.motionZ))) * d2;
                if (!(!(d14 > 100.0) || this.mcServer._N() && this.mcServer._M().equals(this.playerEntity.getCommandSenderName()))) {
                    this.mcServer._O()._b(this.playerEntity.getCommandSenderName() + " moved too quickly! " + d4 + "," + d11 + "," + d12 + " (" + d13 + ", " + d3 + ", " + d2 + ")");
                    this.setPlayerLocation(this.lastPosX, this.lastPosY, this.lastPosZ, this.playerEntity.rotationYaw, this.playerEntity.rotationPitch);
                    ogfj._b(this, packet10Flying);
                    return;
                }
                float f4 = 0.0625f;
                boolean bl = worldServer.getCollidingBoundingBoxes(this.playerEntity, this.playerEntity.boundingBox._c()._e(f4, f4, f4)).isEmpty();
                if (this.playerEntity.onGround && !packet10Flying._g && d11 > 0.0) {
                    this.playerEntity.addExhaustion(0.2f);
                }
                if (!this.hasMoved) {
                    ogfj._b(this, packet10Flying);
                    return;
                }
                this.playerEntity.moveEntity(d4, d11, d12);
                this.playerEntity.onGround = packet10Flying._g;
                this.playerEntity.addMovementStat(d4, d11, d12);
                double d15 = d11;
                d4 = d8 - this.playerEntity.posX;
                d11 = d9 - this.playerEntity.posY;
                if (d11 > -0.5 || d11 < 0.5) {
                    d11 = 0.0;
                }
                d12 = d10 - this.playerEntity.posZ;
                d14 = d4 * d4 + d11 * d11 + d12 * d12;
                boolean bl2 = false;
                if (d14 > 0.0625 && !this.playerEntity.isPlayerSleeping() && !this.playerEntity.theItemInWorldManager._b()) {
                    bl2 = true;
                    this.mcServer._O()._b(this.playerEntity.getCommandSenderName() + " moved wrongly!");
                }
                if (!this.hasMoved) {
                    ogfj._b(this, packet10Flying);
                    return;
                }
                this.playerEntity.setPositionAndRotation(d8, d9, d10, f, f3);
                boolean bl3 = worldServer.getCollidingBoundingBoxes(this.playerEntity, this.playerEntity.boundingBox._c()._e(f4, f4, f4)).isEmpty();
                if (!(!bl || !bl2 && bl3 || this.playerEntity.isPlayerSleeping() || this.playerEntity.noClip)) {
                    this.setPlayerLocation(this.lastPosX, this.lastPosY, this.lastPosZ, f, f3);
                    ogfj._b(this, packet10Flying);
                    return;
                }
                AxisAlignedBB axisAlignedBB = this.playerEntity.boundingBox._c()._b(f4, f4, f4)._a(0.0, -0.55, 0.0);
                if (!(this.mcServer.__ab() || this.playerEntity.theItemInWorldManager._b() || worldServer.checkBlockCollision(axisAlignedBB) || this.playerEntity.capabilities._c)) {
                    if (d15 >= -0.03125) {
                        ++this.field_72572_g;
                        if (this.field_72572_g > 80) {
                            this.mcServer._O()._b(this.playerEntity.getCommandSenderName() + " was kicked for floating too long!");
                            this.func_72565_c("Flying is not enabled on this server");
                            ogfj._b(this, packet10Flying);
                            return;
                        }
                    }
                } else {
                    this.field_72572_g = 0;
                }
                if (!this.hasMoved) {
                    ogfj._b(this, packet10Flying);
                    return;
                }
                this.playerEntity.onGround = packet10Flying._g;
                this.mcServer.__ag()._d(this.playerEntity);
                this.playerEntity.func_71122_b(this.playerEntity.posY - d, packet10Flying._g);
            } else if (this.currentTicks % 20 == 0) {
                this.setPlayerLocation(this.lastPosX, this.lastPosY, this.lastPosZ, this.playerEntity.rotationYaw, this.playerEntity.rotationPitch);
            }
        }
        ogfj._b(this, packet10Flying);
    }

    public void setPlayerLocation(double d, double d2, double d3, float f, float f2) {
        this.hasMoved = false;
        this.lastPosX = d;
        this.lastPosY = d2;
        this.lastPosZ = d3;
        this.playerEntity.setPositionAndRotation(d, d2, d3, f, f2);
        this.playerEntity.playerNetServerHandler.func_72567_b(new xszx(d, d2 + (double)1.62f, d2, d3, f, f2, false));
    }

    @Override
    public void handleBlockDig(Packet14BlockDig packet14BlockDig) {
        WorldServer worldServer = this.mcServer._a(this.playerEntity.dimension);
        this.playerEntity.func_143004_u();
        if (packet14BlockDig._e == 4) {
            this.playerEntity.dropOneItem(false);
        } else if (packet14BlockDig._e == 3) {
            this.playerEntity.dropOneItem(true);
        } else if (packet14BlockDig._e == 5) {
            this.playerEntity.stopUsingItem();
        } else {
            boolean bl = false;
            if (packet14BlockDig._e == 0) {
                bl = true;
            }
            if (packet14BlockDig._e == 1) {
                bl = true;
            }
            if (packet14BlockDig._e == 2) {
                bl = true;
            }
            int n = packet14BlockDig._a;
            int n2 = packet14BlockDig._b;
            int n3 = packet14BlockDig._c;
            if (bl) {
                double d = this.playerEntity.posX - ((double)n + 0.5);
                double d2 = this.playerEntity.posY - ((double)n2 + 0.5) + 1.5;
                double d3 = this.playerEntity.posZ - ((double)n3 + 0.5);
                double d4 = d * d + d2 * d2 + d3 * d3;
                double d5 = this.playerEntity.theItemInWorldManager._d() + 1.0;
                if (d4 > (d5 *= d5)) {
                    return;
                }
                if (n2 >= this.mcServer.__ae()) {
                    return;
                }
            }
            if (packet14BlockDig._e == 0) {
                if (!this.mcServer._a(worldServer, n, n2, n3, this.playerEntity)) {
                    this.playerEntity.theItemInWorldManager._a(n, n2, n3, packet14BlockDig._d);
                } else {
                    this.playerEntity.playerNetServerHandler.func_72567_b(new cwan(n, n2, n3, worldServer));
                }
            } else if (packet14BlockDig._e == 2) {
                this.playerEntity.theItemInWorldManager._a(n, n2, n3);
                if (worldServer.getBlockId(n, n2, n3) != 0) {
                    this.playerEntity.playerNetServerHandler.func_72567_b(new cwan(n, n2, n3, worldServer));
                }
            } else if (packet14BlockDig._e == 1) {
                this.playerEntity.theItemInWorldManager._b(n, n2, n3);
                if (worldServer.getBlockId(n, n2, n3) != 0) {
                    this.playerEntity.playerNetServerHandler.func_72567_b(new cwan(n, n2, n3, worldServer));
                }
            }
        }
    }

    @Override
    public void handlePlace(Packet15Place packet15Place) {
        Object object;
        WorldServer worldServer = this.mcServer._a(this.playerEntity.dimension);
        ItemStack itemStack = this.playerEntity.inventory._a();
        boolean bl = false;
        int n = packet15Place._a();
        int n2 = packet15Place._b();
        int n3 = packet15Place._c();
        int n4 = packet15Place._d();
        this.playerEntity.func_143004_u();
        if (packet15Place._d() == 255) {
            if (itemStack == null) {
                return;
            }
            object = ForgeEventFactory.onPlayerInteract(this.playerEntity, PlayerInteractEvent.Action.RIGHT_CLICK_AIR, 0, 0, 0, -1);
            if (((PlayerInteractEvent)object).useItem != Event.Result.DENY) {
                this.playerEntity.theItemInWorldManager._a(this.playerEntity, worldServer, itemStack);
            }
        } else if (packet15Place._b() >= this.mcServer.__ae() - 1 && (packet15Place._d() == 1 || packet15Place._b() >= this.mcServer.__ae())) {
            this.playerEntity.playerNetServerHandler.func_72567_b(new Packet3Chat(ChatMessageComponent._b("build.tooHigh", this.mcServer.__ae())._a(EnumChatFormatting._m)));
            bl = true;
        } else {
            double d = this.playerEntity.theItemInWorldManager._d() + 1.0;
            d *= d;
            if (this.hasMoved && this.playerEntity.getDistanceSq((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5) < d && !this.mcServer._a(worldServer, n, n2, n3, this.playerEntity)) {
                this.playerEntity.theItemInWorldManager._a(this.playerEntity, worldServer, itemStack, n, n2, n3, n4, packet15Place._f(), packet15Place._g(), packet15Place._h());
            }
            bl = true;
        }
        if (bl) {
            this.playerEntity.playerNetServerHandler.func_72567_b(new cwan(n, n2, n3, worldServer));
            if (n4 == 0) {
                --n2;
            }
            if (n4 == 1) {
                ++n2;
            }
            if (n4 == 2) {
                --n3;
            }
            if (n4 == 3) {
                ++n3;
            }
            if (n4 == 4) {
                --n;
            }
            if (n4 == 5) {
                ++n;
            }
            this.playerEntity.playerNetServerHandler.func_72567_b(new cwan(n, n2, n3, worldServer));
        }
        if ((itemStack = this.playerEntity.inventory._a()) != null && itemStack._b == 0) {
            this.playerEntity.inventory._a[this.playerEntity.inventory._c] = null;
            itemStack = null;
        }
        if (itemStack == null || itemStack._n() == 0) {
            this.playerEntity.field_71137_h = true;
            this.playerEntity.inventory._a[this.playerEntity.inventory._c] = ItemStack._c(this.playerEntity.inventory._a[this.playerEntity.inventory._c]);
            object = this.playerEntity.openContainer.getSlotFromInventory(this.playerEntity.inventory, this.playerEntity.inventory._c);
            this.playerEntity.openContainer.detectAndSendChanges();
            this.playerEntity.field_71137_h = false;
            if (!ItemStack._b(this.playerEntity.inventory._a(), packet15Place._e())) {
                this.func_72567_b(new ixmv(this.playerEntity.openContainer.windowId, ((Slot)object).slotNumber, this.playerEntity.inventory._a()));
            }
        }
    }

    @Override
    public void handleErrorMessage(String string, Object[] objectArray) {
        this.mcServer._O()._a(this.playerEntity.getCommandSenderName() + " lost connection: " + string);
        this.mcServer.__ag()._a(ChatMessageComponent._b("multiplayer.player.left", this.playerEntity.getTranslatedEntityName())._a(EnumChatFormatting._o));
        this.mcServer.__ag()._e(this.playerEntity);
        this.connectionClosed = true;
        if (this.mcServer._N() && this.playerEntity.getCommandSenderName().equals(this.mcServer._M())) {
            this.mcServer._O()._a("Stopping singleplayer server as player logged out");
            this.mcServer._z();
        }
    }

    @Override
    public void unexpectedPacket(Packet packet) {
        this.mcServer._O()._b(this.getClass() + " wasn't prepared to deal with a " + packet.getClass());
        this.func_72565_c("Protocol error, unexpected packet");
    }

    public void func_72567_b(Packet packet) {
        if (packet instanceof Packet3Chat) {
            Packet3Chat packet3Chat = (Packet3Chat)packet;
            int n = this.playerEntity.getChatVisibility();
            if (n == 2) {
                return;
            }
            if (n == 1 && !packet3Chat._a()) {
                return;
            }
        }
        try {
            this.netManager._a(packet);
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Sending packet");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("Packet being sent");
            crashReportCategory._a("Packet ID", new tglw(this, packet));
            crashReportCategory._a("Packet class", new hukt(this, packet));
            throw new turb(crashReport);
        }
    }

    @Override
    public void handleBlockItemSwitch(Packet16BlockItemSwitch packet16BlockItemSwitch) {
        if (packet16BlockItemSwitch._a >= 0 && packet16BlockItemSwitch._a < InventoryPlayer._b()) {
            this.playerEntity.inventory._c = packet16BlockItemSwitch._a;
            this.playerEntity.func_143004_u();
        } else {
            this.mcServer._O()._b(this.playerEntity.getCommandSenderName() + " tried to set an invalid carried item");
        }
    }

    @Override
    public void handleChat(Packet3Chat packet3Chat) {
        if ((packet3Chat = FMLNetworkHandler.handleChatMessage(this, packet3Chat)) == null || packet3Chat._a == null) {
            return;
        }
        if (this.playerEntity.getChatVisibility() == 2) {
            this.func_72567_b(new Packet3Chat(ChatMessageComponent._e("chat.cannotSend")._a(EnumChatFormatting._m)));
        } else {
            this.playerEntity.func_143004_u();
            String string = packet3Chat._a;
            if (string.length() > 1000) {
                this.func_72565_c("Chat message too long");
            } else {
                for (int i = 0; i < string.length(); ++i) {
                    if (ChatAllowedCharacters._a(string.charAt(i))) continue;
                    this.func_72565_c("Illegal characters in chat");
                    return;
                }
                if (string.startsWith("/")) {
                    this.handleSlashCommand(string);
                } else {
                    if (this.playerEntity.getChatVisibility() == 1) {
                        this.func_72567_b(new Packet3Chat(ChatMessageComponent._e("chat.cannotSend")._a(EnumChatFormatting._m)));
                        return;
                    }
                    ChatMessageComponent chatMessageComponent = ChatMessageComponent._b("chat.type.text", this.playerEntity.getTranslatedEntityName(), string);
                    if ((chatMessageComponent = ForgeHooks.onServerChatEvent(this, string, chatMessageComponent)) == null) {
                        return;
                    }
                    this.mcServer.__ag()._a(chatMessageComponent, false);
                }
                this.chatSpamThresholdCount += 20;
                if (this.chatSpamThresholdCount > 200 && !this.mcServer.__ag()._g(this.playerEntity.getCommandSenderName())) {
                    this.func_72565_c("disconnect.spam");
                }
            }
        }
    }

    public void handleSlashCommand(String string) {
        this.mcServer._J().executeCommand(this.playerEntity, string);
    }

    @Override
    public void handleAnimation(Packet18Animation packet18Animation) {
        this.playerEntity.func_143004_u();
        if (packet18Animation._b == 1) {
            this.playerEntity.swingItem();
        }
    }

    @Override
    public void handleEntityAction(Packet19EntityAction packet19EntityAction) {
        this.playerEntity.func_143004_u();
        if (packet19EntityAction._b == 1) {
            this.playerEntity.setSneaking(true);
        } else if (packet19EntityAction._b == 2) {
            this.playerEntity.setSneaking(false);
        } else if (packet19EntityAction._b == 4) {
            this.playerEntity.setSprinting(true);
        } else if (packet19EntityAction._b == 5) {
            this.playerEntity.setSprinting(false);
        } else if (packet19EntityAction._b == 3) {
            this.playerEntity.wakeUpPlayer(false, true, true);
            this.hasMoved = false;
        } else if (packet19EntityAction._b == 6) {
            if (this.playerEntity.ridingEntity != null && this.playerEntity.ridingEntity instanceof EntityHorse) {
                ((EntityHorse)this.playerEntity.ridingEntity).setJumpPower(packet19EntityAction._c);
            }
        } else if (packet19EntityAction._b == 7 && this.playerEntity.ridingEntity != null && this.playerEntity.ridingEntity instanceof EntityHorse) {
            ((EntityHorse)this.playerEntity.ridingEntity).openGUI(this.playerEntity);
        }
    }

    @Override
    public void handleKickDisconnect(Packet255KickDisconnect packet255KickDisconnect) {
        this.netManager._a("disconnect.quitting", new Object[0]);
    }

    public int func_72568_e() {
        return this.netManager._e();
    }

    @Override
    public void handleUseEntity(Packet7UseEntity packet7UseEntity) {
        WorldServer worldServer = this.mcServer._a(this.playerEntity.dimension);
        Entity entity = worldServer.getEntityByID(packet7UseEntity._b);
        this.playerEntity.func_143004_u();
        if (entity != null) {
            boolean bl = this.playerEntity.canEntityBeSeen(entity);
            double d = 36.0;
            if (!bl) {
                d = 9.0;
            }
            if (this.playerEntity.getDistanceSqToEntity(entity) < d) {
                if (packet7UseEntity._c == 0) {
                    this.playerEntity.interactWith(entity);
                } else if (packet7UseEntity._c == 1) {
                    if (entity instanceof EntityItem || entity instanceof EntityXPOrb || entity instanceof EntityArrow || entity == this.playerEntity) {
                        this.func_72565_c("Attempting to attack an invalid entity");
                        this.mcServer._c("Player " + this.playerEntity.getCommandSenderName() + " tried to attack an invalid entity");
                        return;
                    }
                    this.playerEntity.attackTargetEntityWithCurrentItem(entity);
                }
            }
        }
    }

    @Override
    public void handleClientCommand(Packet205ClientCommand packet205ClientCommand) {
        this.playerEntity.func_143004_u();
        if (packet205ClientCommand._a == 1) {
            if (this.playerEntity.playerConqueredTheEnd) {
                this.playerEntity = this.mcServer.__ag()._a(this.playerEntity, 0, true);
            } else if (this.playerEntity.getServerForPlayer().getWorldInfo()._t()) {
                if (this.mcServer._N() && this.playerEntity.getCommandSenderName().equals(this.mcServer._M())) {
                    this.playerEntity.playerNetServerHandler.func_72565_c("You have died. Game over, man, it's game over!");
                    this.mcServer._T();
                } else {
                    BanEntry banEntry = new BanEntry(this.playerEntity.getCommandSenderName());
                    banEntry._b("Death in Hardcore");
                    this.mcServer.__ag()._l()._a(banEntry);
                    this.playerEntity.playerNetServerHandler.func_72565_c("You have died. Game over, man, it's game over!");
                }
            } else {
                if (this.playerEntity.getHealth() > 0.0f) {
                    return;
                }
                this.playerEntity = this.mcServer.__ag()._a(this.playerEntity, this.playerEntity.dimension, false);
            }
        }
    }

    @Override
    public boolean canProcessPacketsAsync() {
        return true;
    }

    @Override
    public void handleRespawn(Packet9Respawn packet9Respawn) {
    }

    @Override
    public void handleCloseWindow(Packet101CloseWindow packet101CloseWindow) {
        this.playerEntity.closeContainer();
    }

    @Override
    public void handleWindowClick(Packet102WindowClick packet102WindowClick) {
        this.playerEntity.func_143004_u();
        if (this.playerEntity.openContainer.windowId == packet102WindowClick._a && this.playerEntity.openContainer.func_75129_b(this.playerEntity)) {
            ItemStack itemStack = this.playerEntity.openContainer.slotClick(packet102WindowClick._b, packet102WindowClick._c, packet102WindowClick._f, this.playerEntity);
            if (ItemStack._b(packet102WindowClick._e, itemStack)) {
                this.playerEntity.playerNetServerHandler.func_72567_b(new Packet106Transaction(packet102WindowClick._a, packet102WindowClick._d, true));
                this.playerEntity.field_71137_h = true;
                this.playerEntity.openContainer.detectAndSendChanges();
                this.playerEntity.updateHeldItem();
                this.playerEntity.field_71137_h = false;
            } else {
                this.field_72586_s._a(this.playerEntity.openContainer.windowId, packet102WindowClick._d);
                this.playerEntity.playerNetServerHandler.func_72567_b(new Packet106Transaction(packet102WindowClick._a, packet102WindowClick._d, false));
                this.playerEntity.openContainer.func_75128_a(this.playerEntity, false);
                ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
                for (int i = 0; i < this.playerEntity.openContainer.inventorySlots.size(); ++i) {
                    arrayList.add(((Slot)this.playerEntity.openContainer.inventorySlots.get(i)).getStack());
                }
                this.playerEntity.func_71110_a(this.playerEntity.openContainer, arrayList);
            }
        }
    }

    @Override
    public void handleEnchantItem(Packet108EnchantItem packet108EnchantItem) {
        this.playerEntity.func_143004_u();
        if (this.playerEntity.openContainer.windowId == packet108EnchantItem._a && this.playerEntity.openContainer.func_75129_b(this.playerEntity)) {
            this.playerEntity.openContainer.enchantItem(this.playerEntity, packet108EnchantItem._b);
            this.playerEntity.openContainer.detectAndSendChanges();
        }
    }

    @Override
    public void handleCreativeSetSlot(Packet107CreativeSetSlot packet107CreativeSetSlot) {
        if (this.playerEntity.theItemInWorldManager._b()) {
            boolean bl;
            boolean bl2 = packet107CreativeSetSlot._a < 0;
            ItemStack itemStack = packet107CreativeSetSlot._b;
            boolean bl3 = packet107CreativeSetSlot._a >= 1 && packet107CreativeSetSlot._a < 36 + InventoryPlayer._b();
            boolean bl4 = itemStack == null || itemStack._d < Item.itemsList.length && itemStack._d >= 0 && Item.itemsList[itemStack._d] != null;
            boolean bl5 = bl = itemStack == null || itemStack._j() >= 0 && itemStack._j() >= 0 && itemStack._b <= 64 && itemStack._b > 0;
            if (bl3 && bl4 && bl) {
                if (itemStack == null) {
                    this.playerEntity.inventoryContainer.putStackInSlot(packet107CreativeSetSlot._a, null);
                } else {
                    this.playerEntity.inventoryContainer.putStackInSlot(packet107CreativeSetSlot._a, itemStack);
                }
                this.playerEntity.inventoryContainer.func_75128_a(this.playerEntity, true);
            } else if (bl2 && bl4 && bl && this.creativeItemCreationSpamThresholdTally < 200) {
                this.creativeItemCreationSpamThresholdTally += 20;
                EntityItem entityItem = this.playerEntity.dropPlayerItem(itemStack);
                if (entityItem != null) {
                    entityItem.setAgeToCreativeDespawnTime();
                }
            }
        }
    }

    @Override
    public void handleTransaction(Packet106Transaction packet106Transaction) {
        Short s = (Short)this.field_72586_s._b(this.playerEntity.openContainer.windowId);
        if (s != null && packet106Transaction._b == s && this.playerEntity.openContainer.windowId == packet106Transaction._a && !this.playerEntity.openContainer.func_75129_b(this.playerEntity)) {
            this.playerEntity.openContainer.func_75128_a(this.playerEntity, true);
        }
    }

    @Override
    public void handleUpdateSign(Packet130UpdateSign packet130UpdateSign) {
        this.playerEntity.func_143004_u();
        WorldServer worldServer = this.mcServer._a(this.playerEntity.dimension);
        if (worldServer.blockExists(packet130UpdateSign._a, packet130UpdateSign._b, packet130UpdateSign._c)) {
            int n;
            int n2;
            TileEntitySign tileEntitySign;
            TileEntity tileEntity = worldServer.getBlockTileEntity(packet130UpdateSign._a, packet130UpdateSign._b, packet130UpdateSign._c);
            if (tileEntity instanceof TileEntitySign && (!(tileEntitySign = (TileEntitySign)tileEntity)._a() || tileEntitySign._b() != this.playerEntity)) {
                this.mcServer._c("Player " + this.playerEntity.getCommandSenderName() + " just tried to change non-editable sign");
                return;
            }
            for (n2 = 0; n2 < 4; ++n2) {
                n = 1;
                if (packet130UpdateSign._d[n2].length() > 15) {
                    n = 0;
                } else {
                    for (int i = 0; i < packet130UpdateSign._d[n2].length(); ++i) {
                        if (ChatAllowedCharacters._a.indexOf(packet130UpdateSign._d[n2].charAt(i)) >= 0) continue;
                        n = 0;
                    }
                }
                if (n != 0) continue;
                packet130UpdateSign._d[n2] = "!?";
            }
            if (tileEntity instanceof TileEntitySign) {
                n2 = packet130UpdateSign._a;
                n = packet130UpdateSign._b;
                int n3 = packet130UpdateSign._c;
                TileEntitySign tileEntitySign2 = (TileEntitySign)tileEntity;
                System.arraycopy(packet130UpdateSign._d, 0, tileEntitySign2._a, 0, 4);
                tileEntitySign2.onInventoryChanged();
                worldServer.markBlockForUpdate(n2, n, n3);
            }
        }
    }

    @Override
    public void handleKeepAlive(Packet0KeepAlive packet0KeepAlive) {
        if (packet0KeepAlive._a == this.keepAliveRandomID) {
            int n = (int)(System.nanoTime() / 1000000L - this.keepAliveTimeSent);
            this.playerEntity.ping = (this.playerEntity.ping * 3 + n) / 4;
        }
    }

    @Override
    public boolean isServerHandler() {
        return true;
    }

    @Override
    public void handlePlayerAbilities(Packet202PlayerAbilities packet202PlayerAbilities) {
        this.playerEntity.capabilities._b = packet202PlayerAbilities._b() && this.playerEntity.capabilities._c;
    }

    @Override
    public void handleAutoComplete(Packet203AutoComplete packet203AutoComplete) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : this.mcServer._a(this.playerEntity, packet203AutoComplete._a())) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("\u0000");
            }
            stringBuilder.append(string);
        }
        this.playerEntity.playerNetServerHandler.func_72567_b(new Packet203AutoComplete(stringBuilder.toString()));
    }

    @Override
    public void handleClientInfo(Packet204ClientInfo packet204ClientInfo) {
        this.playerEntity.updateClientInfo(packet204ClientInfo);
    }

    @Override
    public void handleCustomPayload(Packet250CustomPayload packet250CustomPayload) {
        FMLNetworkHandler.handlePacket250Packet(packet250CustomPayload, this.netManager, this);
    }

    @Override
    public void handleVanilla250Packet(Packet250CustomPayload packet250CustomPayload) {
        if ("MC|BEdit".equals(packet250CustomPayload.channel)) {
            try {
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(packet250CustomPayload.data));
                ItemStack itemStack = Packet.readItemStack(dataInputStream);
                if (!sdgq._a(itemStack._q())) {
                    throw new IOException("Invalid book tag!");
                }
                ItemStack itemStack2 = this.playerEntity.inventory._a();
                if (itemStack != null && itemStack._d == Item.writableBook.itemID && itemStack._d == itemStack2._d) {
                    itemStack2._a("pages", itemStack._q()._n("pages"));
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if ("MC|BSign".equals(packet250CustomPayload.channel)) {
            try {
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(packet250CustomPayload.data));
                ItemStack itemStack = Packet.readItemStack(dataInputStream);
                if (!ItemEditableBook._a(itemStack._q())) {
                    throw new IOException("Invalid book tag!");
                }
                ItemStack itemStack3 = this.playerEntity.inventory._a();
                if (itemStack != null && itemStack._d == Item.writtenBook.itemID && itemStack3._d == Item.writableBook.itemID) {
                    itemStack3._a("author", new NBTTagString("author", this.playerEntity.getCommandSenderName()));
                    itemStack3._a("title", new NBTTagString("title", itemStack._q()._j("title")));
                    itemStack3._a("pages", itemStack._q()._n("pages"));
                    itemStack3._d = Item.writtenBook.itemID;
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if ("MC|TrSel".equals(packet250CustomPayload.channel)) {
            try {
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(packet250CustomPayload.data));
                int n = dataInputStream.readInt();
                Container container = this.playerEntity.openContainer;
                if (container instanceof ContainerMerchant) {
                    ((ContainerMerchant)container)._a(n);
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if ("MC|AdvCdm".equals(packet250CustomPayload.channel)) {
            if (!this.mcServer.__ac()) {
                this.playerEntity.sendChatToPlayer(ChatMessageComponent._e("advMode.notEnabled"));
            } else if (this.playerEntity.canCommandSenderUseCommand(2, "") && this.playerEntity.capabilities._d) {
                try {
                    DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(packet250CustomPayload.data));
                    int n = dataInputStream.readInt();
                    int n2 = dataInputStream.readInt();
                    int n3 = dataInputStream.readInt();
                    String string = Packet.readString(dataInputStream, 256);
                    TileEntity tileEntity = this.playerEntity.worldObj.getBlockTileEntity(n, n2, n3);
                    if (tileEntity != null && tileEntity instanceof TileEntityCommandBlock) {
                        ((TileEntityCommandBlock)tileEntity)._a(string);
                        this.playerEntity.worldObj.markBlockForUpdate(n, n2, n3);
                        this.playerEntity.sendChatToPlayer(ChatMessageComponent._b("advMode.setCommand.success", string));
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else {
                this.playerEntity.sendChatToPlayer(ChatMessageComponent._e("advMode.notAllowed"));
            }
        } else if ("MC|Beacon".equals(packet250CustomPayload.channel)) {
            if (this.playerEntity.openContainer instanceof ixdv) {
                try {
                    DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(packet250CustomPayload.data));
                    int n = dataInputStream.readInt();
                    int n4 = dataInputStream.readInt();
                    ixdv ixdv2 = (ixdv)this.playerEntity.openContainer;
                    Slot slot = ixdv2.getSlot(0);
                    if (slot.getHasStack()) {
                        slot.decrStackSize(1);
                        TileEntityBeacon tileEntityBeacon = ixdv2._a();
                        tileEntityBeacon._b(n);
                        tileEntityBeacon._c(n4);
                        tileEntityBeacon.onInventoryChanged();
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        } else if ("MC|ItemName".equals(packet250CustomPayload.channel) && this.playerEntity.openContainer instanceof ContainerRepair) {
            ContainerRepair containerRepair = (ContainerRepair)this.playerEntity.openContainer;
            if (packet250CustomPayload.data != null && packet250CustomPayload.data.length >= 1) {
                String string = ChatAllowedCharacters._a(new String(packet250CustomPayload.data));
                if (string.length() <= 30) {
                    containerRepair._a(string);
                }
            } else {
                containerRepair._a("");
            }
        }
    }

    @Override
    public boolean isConnectionClosed() {
        return this.connectionClosed;
    }

    @Override
    public void handleMapData(yexp yexp2) {
        FMLNetworkHandler.handlePacket131Packet(this, yexp2);
    }

    @Override
    public EntityPlayerMP getPlayer() {
        return this.playerEntity;
    }
}

