/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.base.Charsets;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.anticheat.pidb;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.asm.NetworkHooks;
import gloomyfolken.mods.stalker.mobs.StalkerMobsHooks;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.crypto.SecretKey;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenDemo;
import net.minecraft.client.gui.GuiScreenDisconnectedOnline;
import net.minecraft.client.gui.GuiWinGame;
import net.minecraft.client.particle.EntityCrit2FX;
import net.minecraft.client.particle.EntityPickupFX;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.NpcMerchant;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.jgro;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.inventory.AnimalChest;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.network.TcpConnection;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet0KeepAlive;
import net.minecraft.network.packet.Packet101CloseWindow;
import net.minecraft.network.packet.Packet106Transaction;
import net.minecraft.network.packet.Packet10Flying;
import net.minecraft.network.packet.Packet130UpdateSign;
import net.minecraft.network.packet.Packet16BlockItemSwitch;
import net.minecraft.network.packet.Packet18Animation;
import net.minecraft.network.packet.Packet202PlayerAbilities;
import net.minecraft.network.packet.Packet203AutoComplete;
import net.minecraft.network.packet.Packet205ClientCommand;
import net.minecraft.network.packet.Packet209SetPlayerTeam;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet252SharedKey;
import net.minecraft.network.packet.Packet255KickDisconnect;
import net.minecraft.network.packet.Packet30Entity;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.network.packet.Packet44UpdateAttributes;
import net.minecraft.network.packet.Packet52MultiBlockChange;
import net.minecraft.network.packet.Packet56MapChunks;
import net.minecraft.network.packet.Packet70GameEvent;
import net.minecraft.network.packet.Packet9Respawn;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreObjectiveCriteria;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.qlgf;
import net.minecraft.util.sajh;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.storage.MapStorage;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

@SideOnly(value=Side.CLIENT)
public class bscn
extends NetHandler {
    public boolean _a;
    public jjpj _b;
    public String _c;
    public Minecraft _d;
    public pkix _e;
    public boolean _f;
    public MapStorage _g = new MapStorage(null);
    public Map _h = new HashMap();
    public List _i = new ArrayList();
    public int _j = 20;
    public GuiScreen _k;
    public Random _l = new Random();
    public static byte _m;

    public bscn(Minecraft minecraft, String string, int n) throws IOException {
        this._d = minecraft;
        Socket socket = new Socket(InetAddress.getByName(string), n);
        this._b = new TcpConnection(minecraft._O(), socket, "Client", this);
        FMLNetworkHandler.onClientConnectionToRemoteServer(this, string, n, this._b);
    }

    public bscn(Minecraft minecraft, String string, int n, GuiScreen guiScreen) throws IOException {
        this._d = minecraft;
        this._k = guiScreen;
        Socket socket = new Socket(InetAddress.getByName(string), n);
        this._b = new TcpConnection(minecraft._O(), socket, "Client", this);
        FMLNetworkHandler.onClientConnectionToRemoteServer(this, string, n, this._b);
    }

    public bscn(Minecraft minecraft, yfci yfci2) throws IOException {
        this._d = minecraft;
        this._b = new tgls(minecraft._O(), this);
        yfci2._a()._a((tgls)this._b, minecraft._P()._a());
        FMLNetworkHandler.onClientConnectionToIntegratedServer(this, yfci2, this._b);
    }

    public void _a() {
        if (this._b != null) {
            this._b._a();
        }
        this._b = null;
        this._e = null;
    }

    public void _b() {
        if (!this._a && this._b != null) {
            this._b._b();
        }
        if (this._b != null) {
            this._b._a();
        }
    }

    @Override
    public void handleServerAuthData(ujpx ujpx2) {
        NetworkHooks.handleServerAuthData(this, ujpx2);
        String string = ujpx2._a().trim();
        PublicKey publicKey = ujpx2._b();
        SecretKey secretKey = qlgf._a();
        if (!"-".equals(string)) {
            String string2 = new BigInteger(qlgf._a(string, publicKey, secretKey)).toString(16);
            String string3 = this._a(this._d._P()._a(), this._d._P()._b(), string2);
            if (!"ok".equalsIgnoreCase(string3)) {
                this._b._a("disconnect.loginFailedInfo", string3);
                return;
            }
        }
        this._b(new Packet252SharedKey(secretKey, publicKey, ujpx2._c()));
    }

    public String _a(String string, String string2, String string3) {
        String string4 = GloomyHooks.sendSessionRequest(this, string, string2, string3);
        return string4;
    }

    public static String _a(String string) throws IOException {
        return URLEncoder.encode(string, "UTF-8");
    }

    @Override
    public void handleSharedKey(Packet252SharedKey packet252SharedKey) {
        boolean bl = NetworkHooks.handleSharedKey(this, packet252SharedKey);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        this._b(FMLNetworkHandler.getFMLFakeLoginPacket());
        this._b(new Packet205ClientCommand(0));
        NetworkHooks.sendAssetsHash(this, packet252SharedKey);
    }

    @Override
    public void handleLogin(txpf txpf2) {
        this._d._j = new vlzh(this._d, this);
        this._d._X._a(dzif._i, 1);
        this._e = new pkix(this, new WorldSettings(0L, txpf2._d, false, txpf2._c, txpf2._b), txpf2._e, txpf2._f, this._d.__ah, this._d._O());
        this._e.isRemote = true;
        this._d._a(this._e);
        this._d._t.dimension = txpf2._e;
        this._d._a(new iwmg(this));
        this._d._t.entityId = txpf2._a;
        this._j = txpf2._h;
        this._d._j._a(txpf2._d);
        FMLNetworkHandler.onConnectionEstablishedToServer(this, this._b, txpf2);
        this._d._M.sendSettingsToServer();
        this._b._a(new Packet250CustomPayload("MC|Brand", ClientBrandRetriever.getClientModName().getBytes(Charsets.UTF_8)));
    }

    @Override
    public void handleVehicleSpawn(ixor ixor2) {
        Entity[] entityArray;
        double d = (double)ixor2._b / 32.0;
        double d2 = (double)ixor2._c / 32.0;
        double d3 = (double)ixor2._d / 32.0;
        Entity entity = null;
        if (ixor2._j == 10) {
            entity = EntityMinecart.createMinecart(this._e, d, d2, d3, ixor2._k);
        } else if (ixor2._j == 90) {
            entityArray = this._a(ixor2._k);
            if (entityArray instanceof EntityPlayer) {
                entity = new EntityFishHook(this._e, d, d2, d3, (EntityPlayer)entityArray);
            }
            ixor2._k = 0;
        } else if (ixor2._j == 60) {
            entity = new EntityArrow(this._e, d, d2, d3);
        } else if (ixor2._j == 61) {
            entity = new EntitySnowball(this._e, d, d2, d3);
        } else if (ixor2._j == 71) {
            entity = new EntityItemFrame(this._e, (int)d, (int)d2, (int)d3, ixor2._k);
            ixor2._k = 0;
        } else if (ixor2._j == 77) {
            entity = new EntityLeashKnot(this._e, (int)d, (int)d2, (int)d3);
            ixor2._k = 0;
        } else if (ixor2._j == 65) {
            entity = new EntityEnderPearl(this._e, d, d2, d3);
        } else if (ixor2._j == 72) {
            entity = new EntityEnderEye(this._e, d, d2, d3);
        } else if (ixor2._j == 76) {
            entity = new EntityFireworkRocket(this._e, d, d2, d3, null);
        } else if (ixor2._j == 63) {
            entity = new EntityLargeFireball(this._e, d, d2, d3, (double)ixor2._e / 8000.0, (double)ixor2._f / 8000.0, (double)ixor2._g / 8000.0);
            ixor2._k = 0;
        } else if (ixor2._j == 64) {
            entity = new EntitySmallFireball(this._e, d, d2, d3, (double)ixor2._e / 8000.0, (double)ixor2._f / 8000.0, (double)ixor2._g / 8000.0);
            ixor2._k = 0;
        } else if (ixor2._j == 66) {
            entity = new EntityWitherSkull(this._e, d, d2, d3, (double)ixor2._e / 8000.0, (double)ixor2._f / 8000.0, (double)ixor2._g / 8000.0);
            ixor2._k = 0;
        } else if (ixor2._j == 62) {
            entity = new EntityEgg(this._e, d, d2, d3);
        } else if (ixor2._j == 73) {
            entity = new EntityPotion((World)this._e, d, d2, d3, ixor2._k);
            ixor2._k = 0;
        } else if (ixor2._j == 75) {
            entity = new EntityExpBottle(this._e, d, d2, d3);
            ixor2._k = 0;
        } else if (ixor2._j == 1) {
            entity = new EntityBoat(this._e, d, d2, d3);
        } else if (ixor2._j == 50) {
            entity = new EntityTNTPrimed(this._e, d, d2, d3, null);
        } else if (ixor2._j == 51) {
            entity = new EntityEnderCrystal(this._e, d, d2, d3);
        } else if (ixor2._j == 2) {
            entity = new EntityItem(this._e, d, d2, d3);
        } else if (ixor2._j == 70) {
            entity = new EntityFallingSand(this._e, d, d2, d3, ixor2._k & 0xFFFF, ixor2._k >> 16);
            ixor2._k = 0;
        }
        if (entity != null) {
            ((Entity)entity).serverPosX = ixor2._b;
            ((Entity)entity).serverPosY = ixor2._c;
            ((Entity)entity).serverPosZ = ixor2._d;
            ((Entity)entity).rotationPitch = (float)(ixor2._h * 360) / 256.0f;
            ((Entity)entity).rotationYaw = (float)(ixor2._i * 360) / 256.0f;
            entityArray = ((Entity)entity).getParts();
            if (entityArray != null) {
                int n = ixor2._a - ((Entity)entity).entityId;
                for (int i = 0; i < entityArray.length; ++i) {
                    entityArray[i].entityId += n;
                }
            }
            ((Entity)entity).entityId = ixor2._a;
            this._e._a(ixor2._a, entity);
            if (ixor2._k > 0) {
                Entity entity2;
                if (ixor2._j == 60 && (entity2 = this._a(ixor2._k)) instanceof EntityLivingBase) {
                    EntityArrow entityArrow = (EntityArrow)entity;
                    entityArrow.shootingEntity = entity2;
                }
                ((Entity)entity).setVelocity((double)ixor2._e / 8000.0, (double)ixor2._f / 8000.0, (double)ixor2._g / 8000.0);
            }
        }
    }

    @Override
    public void handleEntityExpOrb(kmst kmst2) {
        EntityXPOrb entityXPOrb = new EntityXPOrb(this._e, kmst2._b, kmst2._c, kmst2._d, kmst2._e);
        entityXPOrb.serverPosX = kmst2._b;
        entityXPOrb.serverPosY = kmst2._c;
        entityXPOrb.serverPosZ = kmst2._d;
        entityXPOrb.rotationYaw = 0.0f;
        entityXPOrb.rotationPitch = 0.0f;
        entityXPOrb.entityId = kmst2._a;
        this._e._a(kmst2._a, entityXPOrb);
    }

    @Override
    public void handleWeather(dibg dibg2) {
        double d = (double)dibg2._b / 32.0;
        double d2 = (double)dibg2._c / 32.0;
        double d3 = (double)dibg2._d / 32.0;
        EntityLightningBolt entityLightningBolt = null;
        if (dibg2._e == 1) {
            entityLightningBolt = new EntityLightningBolt(this._e, d, d2, d3);
        }
        if (entityLightningBolt != null) {
            entityLightningBolt.serverPosX = dibg2._b;
            entityLightningBolt.serverPosY = dibg2._c;
            entityLightningBolt.serverPosZ = dibg2._d;
            entityLightningBolt.rotationYaw = 0.0f;
            entityLightningBolt.rotationPitch = 0.0f;
            entityLightningBolt.entityId = dibg2._a;
            this._e.addWeatherEffect(entityLightningBolt);
        }
    }

    @Override
    public void handleEntityPainting(ixoa ixoa2) {
        EntityPainting entityPainting = new EntityPainting(this._e, ixoa2._b, ixoa2._c, ixoa2._d, ixoa2._e, ixoa2._f);
        this._e._a(ixoa2._a, entityPainting);
    }

    @Override
    public void handleEntityVelocity(fofa fofa2) {
        Entity entity = this._a(fofa2._a);
        if (entity != null) {
            entity.setVelocity((double)fofa2._b / 8000.0, (double)fofa2._c / 8000.0, (double)fofa2._d / 8000.0);
        }
    }

    @Override
    public void handleEntityMetadata(qoia qoia2) {
        Entity entity = this._a(qoia2._a);
        if (entity != null && qoia2._a() != null) {
            entity.getDataWatcher()._a(qoia2._a());
        }
    }

    @Override
    public void handleNamedEntitySpawn(xsze xsze2) {
        double d = (double)xsze2._c / 32.0;
        double d2 = (double)xsze2._d / 32.0;
        double d3 = (double)xsze2._e / 32.0;
        float f = (float)(xsze2._f * 360) / 256.0f;
        float f2 = (float)(xsze2._g * 360) / 256.0f;
        EntityOtherPlayerMP entityOtherPlayerMP = new EntityOtherPlayerMP(this._d._r, xsze2._b);
        entityOtherPlayerMP.serverPosX = xsze2._c;
        entityOtherPlayerMP.prevPosX = entityOtherPlayerMP.lastTickPosX = (double)entityOtherPlayerMP.serverPosX;
        entityOtherPlayerMP.serverPosY = xsze2._d;
        entityOtherPlayerMP.prevPosY = entityOtherPlayerMP.lastTickPosY = (double)entityOtherPlayerMP.serverPosY;
        entityOtherPlayerMP.serverPosZ = xsze2._e;
        entityOtherPlayerMP.prevPosZ = entityOtherPlayerMP.lastTickPosZ = (double)entityOtherPlayerMP.serverPosZ;
        int n = xsze2._h;
        entityOtherPlayerMP.inventory._a[entityOtherPlayerMP.inventory._c] = n == 0 ? null : new ItemStack(n, 1, 0);
        entityOtherPlayerMP.setPositionAndRotation(d, d2, d3, f, f2);
        this._e._a(xsze2._a, entityOtherPlayerMP);
        List list2 = xsze2._a();
        if (list2 != null) {
            entityOtherPlayerMP.getDataWatcher()._a(list2);
        }
    }

    @Override
    public void handleEntityTeleport(txnr txnr2) {
        boolean bl = StalkerMobsHooks.handleEntityTeleport(this, txnr2);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        Entity entity = this._a(txnr2._a);
        if (entity != null) {
            entity.serverPosX = txnr2._b;
            entity.serverPosY = txnr2._c;
            entity.serverPosZ = txnr2._d;
            double d = (double)entity.serverPosX / 32.0;
            double d2 = (double)entity.serverPosY / 32.0 + 0.015625;
            double d3 = (double)entity.serverPosZ / 32.0;
            float f = (float)(txnr2._e * 360) / 256.0f;
            float f2 = (float)(txnr2._f * 360) / 256.0f;
            entity.setPositionAndRotation2(d, d2, d3, f, f2, 3);
        }
    }

    @Override
    public void handleBlockItemSwitch(Packet16BlockItemSwitch packet16BlockItemSwitch) {
        if (packet16BlockItemSwitch._a >= 0 && packet16BlockItemSwitch._a < InventoryPlayer._b()) {
            this._d._t.inventory._c = packet16BlockItemSwitch._a;
        }
    }

    @Override
    public void handleEntity(Packet30Entity packet30Entity) {
        boolean bl = StalkerMobsHooks.handleEntity(this, packet30Entity);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        Entity entity = this._a(packet30Entity._a);
        if (entity != null) {
            entity.serverPosX += packet30Entity._b;
            entity.serverPosY += packet30Entity._c;
            entity.serverPosZ += packet30Entity._d;
            double d = (double)entity.serverPosX / 32.0;
            double d2 = (double)entity.serverPosY / 32.0;
            double d3 = (double)entity.serverPosZ / 32.0;
            float f = packet30Entity._g ? (float)(packet30Entity._e * 360) / 256.0f : entity.rotationYaw;
            float f2 = packet30Entity._g ? (float)(packet30Entity._f * 360) / 256.0f : entity.rotationPitch;
            entity.setPositionAndRotation2(d, d2, d3, f, f2, 3);
        }
    }

    @Override
    public void handleEntityHeadRotation(ragc ragc2) {
        Entity entity = this._a(ragc2._a);
        if (entity != null) {
            float f = (float)(ragc2._b * 360) / 256.0f;
            entity.setRotationYawHead(f);
        }
    }

    @Override
    public void handleDestroyEntity(ixod ixod2) {
        for (int i = 0; i < ixod2._a.length; ++i) {
            this._e._a(ixod2._a[i]);
        }
    }

    @Override
    public void handleFlying(Packet10Flying packet10Flying) {
        pidb._a(this, packet10Flying);
    }

    @Override
    public void handleMultiBlockChange(Packet52MultiBlockChange packet52MultiBlockChange) {
        int n = packet52MultiBlockChange._a * 16;
        int n2 = packet52MultiBlockChange._b * 16;
        if (packet52MultiBlockChange._c != null) {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(packet52MultiBlockChange._c));
            try {
                for (int i = 0; i < packet52MultiBlockChange._d; ++i) {
                    short s = dataInputStream.readShort();
                    short s2 = dataInputStream.readShort();
                    int n3 = s2 >> 4 & 0xFFF;
                    int n4 = s2 & 0xF;
                    int n5 = s >> 12 & 0xF;
                    int n6 = s >> 8 & 0xF;
                    int n7 = s & 0xFF;
                    this._e._a(n5 + n, n7, n6 + n2, n3, n4);
                }
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
    }

    @Override
    public void handleMapChunk(ujsv ujsv2) {
        if (ujsv2._g) {
            if (ujsv2._c == 0) {
                this._e._a(ujsv2._a, ujsv2._b, false);
                return;
            }
            this._e._a(ujsv2._a, ujsv2._b, true);
        }
        this._e._a(ujsv2._a << 4, 0, ujsv2._b << 4, (ujsv2._a << 4) + 15, 256, (ujsv2._b << 4) + 15);
        Chunk chunk = this._e.getChunkFromChunkCoords(ujsv2._a, ujsv2._b);
        if (ujsv2._g && chunk == null) {
            this._e._a(ujsv2._a, ujsv2._b, true);
            chunk = this._e.getChunkFromChunkCoords(ujsv2._a, ujsv2._b);
        }
        if (chunk != null) {
            chunk._a(ujsv2._b(), ujsv2._c, ujsv2._d, ujsv2._g);
            this._e.markBlockRangeForRenderUpdate(ujsv2._a << 4, 0, ujsv2._b << 4, (ujsv2._a << 4) + 15, 256, (ujsv2._b << 4) + 15);
            if (!ujsv2._g || !(this._e.provider instanceof igyo)) {
                chunk._m();
            }
        }
    }

    @Override
    public void handleBlockChange(cwan cwan2) {
        this._e._a(cwan2._a, cwan2._b, cwan2._c, cwan2._d, cwan2._e);
    }

    @Override
    public void handleKickDisconnect(Packet255KickDisconnect packet255KickDisconnect) {
        this._b._a("disconnect.kicked", packet255KickDisconnect._a);
        this._a = true;
        this._d._a((pkix)null);
        if (this._k != null) {
            this._d._a(new GuiScreenDisconnectedOnline(this._k, "disconnect.disconnected", "disconnect.genericReason", packet255KickDisconnect._a));
        } else {
            this._d._a(new GuiDisconnected(new gqju(new fngq()), "disconnect.disconnected", "disconnect.genericReason", packet255KickDisconnect._a));
        }
    }

    @Override
    public void handleErrorMessage(String string, Object[] objectArray) {
        if (!this._a) {
            this._a = true;
            this._d._a((pkix)null);
            if (this._k != null) {
                this._d._a(new GuiScreenDisconnectedOnline(this._k, "disconnect.lost", string, objectArray));
            } else {
                this._d._a(new GuiDisconnected(new gqju(new fngq()), "disconnect.lost", string, objectArray));
            }
        }
    }

    public void _a(Packet packet) {
        if (!this._a) {
            this._b._a(packet);
            this._b._d();
            FMLNetworkHandler.onConnectionClosed(this._b, this.getPlayer());
        }
    }

    public void _b(Packet packet) {
        if (!this._a) {
            this._b._a(packet);
        }
    }

    @Override
    public void handleCollect(bbyg bbyg2) {
        Entity entity = this._a(bbyg2._a);
        EntityLivingBase entityLivingBase = (EntityLivingBase)this._a(bbyg2._b);
        if (entityLivingBase == null) {
            entityLivingBase = this._d._t;
        }
        if (entity != null) {
            if (entity instanceof EntityXPOrb) {
                this._e.playSoundAtEntity(entity, "random.orb", 0.2f, ((this._l.nextFloat() - this._l.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            } else {
                this._e.playSoundAtEntity(entity, "random.pop", 0.2f, ((this._l.nextFloat() - this._l.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            }
            this._d._w._a(new EntityPickupFX((World)this._d._r, entity, entityLivingBase, -0.5f));
            this._e._a(bbyg2._a);
        }
    }

    @Override
    public void handleChat(Packet3Chat packet3Chat) {
        if ((packet3Chat = FMLNetworkHandler.handleChatMessage(this, packet3Chat)) == null) {
            return;
        }
        ClientChatReceivedEvent clientChatReceivedEvent = new ClientChatReceivedEvent(packet3Chat._a);
        if (!MinecraftForge.EVENT_BUS.post(clientChatReceivedEvent) && clientChatReceivedEvent.message != null) {
            this._d._J.getChatGUI()._a(ChatMessageComponent._c(clientChatReceivedEvent.message)._a(true));
        }
    }

    @Override
    public void handleAnimation(Packet18Animation packet18Animation) {
        Entity entity = this._a(packet18Animation._a);
        if (entity != null) {
            if (packet18Animation._b == 1) {
                EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
                entityLivingBase.swingItem();
            } else if (packet18Animation._b == 2) {
                entity.performHurtAnimation();
            } else if (packet18Animation._b == 3) {
                EntityPlayer entityPlayer = (EntityPlayer)entity;
                entityPlayer.wakeUpPlayer(false, false, false);
            } else if (packet18Animation._b != 4) {
                if (packet18Animation._b == 6) {
                    this._d._w._a(new EntityCrit2FX(this._d._r, entity));
                } else if (packet18Animation._b == 7) {
                    EntityCrit2FX entityCrit2FX = new EntityCrit2FX(this._d._r, entity, "magicCrit");
                    this._d._w._a(entityCrit2FX);
                } else if (packet18Animation._b != 5 || entity instanceof EntityOtherPlayerMP) {
                    // empty if block
                }
            }
        }
    }

    @Override
    public void handleSleep(kmuh kmuh2) {
        Entity entity = this._a(kmuh2._a);
        if (entity != null && kmuh2._e == 0) {
            EntityPlayer entityPlayer = (EntityPlayer)entity;
            entityPlayer.sleepInBedAt(kmuh2._b, kmuh2._c, kmuh2._d);
        }
    }

    public void _c() {
        this._a = true;
        this._b._a();
        this._b._a("disconnect.closed", new Object[0]);
    }

    @Override
    public void handleMobSpawn(tgmo tgmo2) {
        double d = (double)tgmo2._c / 32.0;
        double d2 = (double)tgmo2._d / 32.0;
        double d3 = (double)tgmo2._e / 32.0;
        float f = (float)(tgmo2._i * 360) / 256.0f;
        float f2 = (float)(tgmo2._j * 360) / 256.0f;
        EntityLivingBase entityLivingBase = (EntityLivingBase)jgro._a(tgmo2._b, (World)this._d._r);
        entityLivingBase.serverPosX = tgmo2._c;
        entityLivingBase.serverPosY = tgmo2._d;
        entityLivingBase.serverPosZ = tgmo2._e;
        entityLivingBase.rotationYawHead = (float)(tgmo2._k * 360) / 256.0f;
        Entity[] entityArray = entityLivingBase.getParts();
        if (entityArray != null) {
            int n = tgmo2._a - entityLivingBase.entityId;
            for (int i = 0; i < entityArray.length; ++i) {
                entityArray[i].entityId += n;
            }
        }
        entityLivingBase.entityId = tgmo2._a;
        entityLivingBase.setPositionAndRotation(d, d2, d3, f, f2);
        entityLivingBase.motionX = (float)tgmo2._f / 8000.0f;
        entityLivingBase.motionY = (float)tgmo2._g / 8000.0f;
        entityLivingBase.motionZ = (float)tgmo2._h / 8000.0f;
        this._e._a(tgmo2._a, entityLivingBase);
        List list2 = tgmo2._a();
        if (list2 != null) {
            entityLivingBase.getDataWatcher()._a(list2);
        }
    }

    @Override
    public void handleUpdateTime(rrld rrld2) {
        this._d._r.func_82738_a(rrld2._a);
        this._d._r.setWorldTime(rrld2._b);
    }

    @Override
    public void handleSpawnPosition(xbzt xbzt2) {
        GloomyHooks.handleSpawnPosition(this, xbzt2);
    }

    @Override
    public void handleAttachEntity(nwaj nwaj2) {
        Entity entity = this._a(nwaj2._b);
        Entity entity2 = this._a(nwaj2._c);
        if (nwaj2._a == 0) {
            boolean bl = false;
            if (nwaj2._b == this._d._t.entityId) {
                entity = this._d._t;
                if (entity2 instanceof EntityBoat) {
                    ((EntityBoat)entity2).func_70270_d(false);
                }
                bl = entity.ridingEntity == null && entity2 != null;
            } else if (entity2 instanceof EntityBoat) {
                ((EntityBoat)entity2).func_70270_d(true);
            }
            if (entity == null) {
                return;
            }
            entity.mountEntity(entity2);
            if (bl) {
                GameSettings gameSettings = this._d._M;
                this._d._J.func_110326_a(wpcz._a("mount.onboard", GameSettings.getKeyDisplayString(gameSettings.keyBindSneak._d)), false);
            }
        } else if (nwaj2._a == 1 && entity != null && entity instanceof EntityLiving) {
            if (entity2 != null) {
                ((EntityLiving)entity).setLeashedToEntity(entity2, false);
            } else {
                ((EntityLiving)entity).clearLeashed(false, false);
            }
        }
    }

    @Override
    public void handleEntityStatus(bszz bszz2) {
        Entity entity = this._a(bszz2._a);
        if (entity != null) {
            entity.handleHealthUpdate(bszz2._b);
        }
    }

    public Entity _a(int n) {
        return n == this._d._t.entityId ? this._d._t : this._e.getEntityByID(n);
    }

    @Override
    public void handleUpdateHealth(sdlz sdlz2) {
        this._d._t.setPlayerSPHealth(sdlz2._a);
        this._d._t.getFoodStats()._a(sdlz2._b);
        this._d._t.getFoodStats()._b(sdlz2._c);
    }

    @Override
    public void handleExperience(rajk rajk2) {
        this._d._t.setXPStats(rajk2._a, rajk2._b, rajk2._c);
    }

    @Override
    public void handleRespawn(Packet9Respawn packet9Respawn) {
        fmej._a(this, packet9Respawn);
        if (packet9Respawn._a != this._d._t.dimension) {
            this._f = false;
            Scoreboard scoreboard = this._e.getScoreboard();
            this._e = new pkix(this, new WorldSettings(0L, packet9Respawn._d, false, this._d._r.getWorldInfo()._t(), packet9Respawn._e), packet9Respawn._a, packet9Respawn._b, this._d.__ah, this._d._O());
            this._e._a(scoreboard);
            this._e.isRemote = true;
            this._d._a(this._e);
            this._d._t.dimension = packet9Respawn._a;
            this._d._a(new iwmg(this));
        }
        this._d._c(packet9Respawn._a);
        this._d._j._a(packet9Respawn._d);
        ogqb._a(this, packet9Respawn);
    }

    @Override
    public void handleExplosion(ozcz ozcz2) {
        Explosion explosion = new Explosion(this._d._r, null, ozcz2._a, ozcz2._b, ozcz2._c, ozcz2._d);
        explosion._k = ozcz2._e;
        explosion._a(true);
        this._d._t.motionX += (double)ozcz2._a();
        this._d._t.motionY += (double)ozcz2._b();
        this._d._t.motionZ += (double)ozcz2._c();
    }

    @Override
    public void handleOpenWindow(lpub lpub2) {
        EntityClientPlayerMP entityClientPlayerMP = this._d._t;
        switch (lpub2._b) {
            case 0: {
                entityClientPlayerMP.displayGUIChest(new InventoryBasic(lpub2._c, lpub2._e, lpub2._d));
                entityClientPlayerMP.openContainer.windowId = lpub2._a;
                break;
            }
            case 1: {
                entityClientPlayerMP.displayGUIWorkbench(sajh._c(entityClientPlayerMP.posX), sajh._c(entityClientPlayerMP.posY), sajh._c(entityClientPlayerMP.posZ));
                entityClientPlayerMP.openContainer.windowId = lpub2._a;
                break;
            }
            case 2: {
                TileEntityFurnace tileEntityFurnace = new TileEntityFurnace();
                if (lpub2._e) {
                    tileEntityFurnace._a(lpub2._c);
                }
                entityClientPlayerMP.displayGUIFurnace(tileEntityFurnace);
                entityClientPlayerMP.openContainer.windowId = lpub2._a;
                break;
            }
            case 3: {
                TileEntityDispenser tileEntityDispenser = new TileEntityDispenser();
                if (lpub2._e) {
                    tileEntityDispenser._a(lpub2._c);
                }
                entityClientPlayerMP.displayGUIDispenser(tileEntityDispenser);
                entityClientPlayerMP.openContainer.windowId = lpub2._a;
                break;
            }
            case 4: {
                entityClientPlayerMP.displayGUIEnchantment(sajh._c(entityClientPlayerMP.posX), sajh._c(entityClientPlayerMP.posY), sajh._c(entityClientPlayerMP.posZ), lpub2._e ? lpub2._c : null);
                entityClientPlayerMP.openContainer.windowId = lpub2._a;
                break;
            }
            case 5: {
                TileEntityBrewingStand tileEntityBrewingStand = new TileEntityBrewingStand();
                if (lpub2._e) {
                    tileEntityBrewingStand._a(lpub2._c);
                }
                entityClientPlayerMP.displayGUIBrewingStand(tileEntityBrewingStand);
                entityClientPlayerMP.openContainer.windowId = lpub2._a;
                break;
            }
            case 6: {
                entityClientPlayerMP.displayGUIMerchant(new NpcMerchant(entityClientPlayerMP), lpub2._e ? lpub2._c : null);
                entityClientPlayerMP.openContainer.windowId = lpub2._a;
                break;
            }
            case 7: {
                TileEntityBeacon tileEntityBeacon = new TileEntityBeacon();
                entityClientPlayerMP.displayGUIBeacon(tileEntityBeacon);
                if (lpub2._e) {
                    tileEntityBeacon._a(lpub2._c);
                }
                entityClientPlayerMP.openContainer.windowId = lpub2._a;
                break;
            }
            case 8: {
                entityClientPlayerMP.displayGUIAnvil(sajh._c(entityClientPlayerMP.posX), sajh._c(entityClientPlayerMP.posY), sajh._c(entityClientPlayerMP.posZ));
                entityClientPlayerMP.openContainer.windowId = lpub2._a;
                break;
            }
            case 9: {
                TileEntityHopper tileEntityHopper = new TileEntityHopper();
                if (lpub2._e) {
                    tileEntityHopper._a(lpub2._c);
                }
                entityClientPlayerMP.displayGUIHopper(tileEntityHopper);
                entityClientPlayerMP.openContainer.windowId = lpub2._a;
                break;
            }
            case 10: {
                hdtl hdtl2 = new hdtl();
                if (lpub2._e) {
                    hdtl2._a(lpub2._c);
                }
                entityClientPlayerMP.displayGUIDispenser(hdtl2);
                entityClientPlayerMP.openContainer.windowId = lpub2._a;
                break;
            }
            case 11: {
                Entity entity = this._a(lpub2._f);
                if (entity == null || !(entity instanceof EntityHorse)) break;
                entityClientPlayerMP.displayGUIHorse((EntityHorse)entity, new AnimalChest(lpub2._c, lpub2._e, lpub2._d));
                entityClientPlayerMP.openContainer.windowId = lpub2._a;
            }
        }
    }

    @Override
    public void handleSetSlot(ixmv ixmv2) {
        EntityClientPlayerMP entityClientPlayerMP = this._d._t;
        if (ixmv2._a == -1) {
            entityClientPlayerMP.inventory._d(ixmv2._c);
        } else {
            Object object;
            boolean bl = false;
            if (this._d._B instanceof qngy) {
                object = (qngy)this._d._B;
                boolean bl2 = bl = ((qngy)object)._c() != CreativeTabs.tabInventory.getTabIndex();
            }
            if (ixmv2._a == 0 && ixmv2._b >= 36 && ixmv2._b < 45) {
                object = entityClientPlayerMP.inventoryContainer.getSlot(ixmv2._b).getStack();
                if (ixmv2._c != null && (object == null || ((ItemStack)object)._b < ixmv2._c._b)) {
                    ixmv2._c._c = 5;
                }
                entityClientPlayerMP.inventoryContainer.putStackInSlot(ixmv2._b, ixmv2._c);
            } else if (!(ixmv2._a != entityClientPlayerMP.openContainer.windowId || ixmv2._a == 0 && bl)) {
                entityClientPlayerMP.openContainer.putStackInSlot(ixmv2._b, ixmv2._c);
            }
        }
    }

    @Override
    public void handleTransaction(Packet106Transaction packet106Transaction) {
        Container container = null;
        EntityClientPlayerMP entityClientPlayerMP = this._d._t;
        if (packet106Transaction._a == 0) {
            container = entityClientPlayerMP.inventoryContainer;
        } else if (packet106Transaction._a == entityClientPlayerMP.openContainer.windowId) {
            container = entityClientPlayerMP.openContainer;
        }
        if (container != null && !packet106Transaction._c) {
            this._b(new Packet106Transaction(packet106Transaction._a, packet106Transaction._b, true));
        }
    }

    @Override
    public void handleWindowItems(wptu wptu2) {
        EntityClientPlayerMP entityClientPlayerMP = this._d._t;
        if (wptu2._a == 0) {
            entityClientPlayerMP.inventoryContainer.putStacksInSlots(wptu2._b);
        } else if (wptu2._a == entityClientPlayerMP.openContainer.windowId) {
            entityClientPlayerMP.openContainer.putStacksInSlots(wptu2._b);
        }
    }

    @Override
    public void func_142031_a(wpwt wpwt2) {
        TileEntity tileEntity = this._e.getBlockTileEntity(wpwt2._b, wpwt2._c, wpwt2._d);
        if (tileEntity != null) {
            this._d._t.displayGUIEditSign(tileEntity);
        } else if (wpwt2._a == 0) {
            TileEntitySign tileEntitySign = new TileEntitySign();
            tileEntitySign.setWorldObj(this._e);
            tileEntitySign.xCoord = wpwt2._b;
            tileEntitySign.yCoord = wpwt2._c;
            tileEntitySign.zCoord = wpwt2._d;
            this._d._t.displayGUIEditSign(tileEntitySign);
        }
    }

    @Override
    public void handleUpdateSign(Packet130UpdateSign packet130UpdateSign) {
        TileEntity tileEntity;
        boolean bl = false;
        if (this._d._r.blockExists(packet130UpdateSign._a, packet130UpdateSign._b, packet130UpdateSign._c) && (tileEntity = this._d._r.getBlockTileEntity(packet130UpdateSign._a, packet130UpdateSign._b, packet130UpdateSign._c)) instanceof TileEntitySign) {
            TileEntitySign tileEntitySign = (TileEntitySign)tileEntity;
            if (tileEntitySign._a()) {
                for (int i = 0; i < 4; ++i) {
                    tileEntitySign._a[i] = packet130UpdateSign._d[i];
                }
                tileEntitySign.onInventoryChanged();
            }
            bl = true;
        }
        if (!bl && this._d._t != null) {
            this._d._t.sendChatToPlayer(ChatMessageComponent._d("Unable to locate sign at " + packet130UpdateSign._a + ", " + packet130UpdateSign._b + ", " + packet130UpdateSign._c));
        }
    }

    @Override
    public void handleTileEntityData(wpte wpte2) {
        TileEntity tileEntity;
        if (this._d._r.blockExists(wpte2._a, wpte2._b, wpte2._c) && (tileEntity = this._d._r.getBlockTileEntity(wpte2._a, wpte2._b, wpte2._c)) != null) {
            if (wpte2._d == 1 && tileEntity instanceof xtcq) {
                tileEntity.readFromNBT(wpte2._e);
            } else if (wpte2._d == 2 && tileEntity instanceof TileEntityCommandBlock) {
                tileEntity.readFromNBT(wpte2._e);
            } else if (wpte2._d == 3 && tileEntity instanceof TileEntityBeacon) {
                tileEntity.readFromNBT(wpte2._e);
            } else if (wpte2._d == 4 && tileEntity instanceof TileEntitySkull) {
                tileEntity.readFromNBT(wpte2._e);
            } else {
                tileEntity.onDataPacket(this._b, wpte2);
            }
        }
    }

    @Override
    public void handleUpdateProgressbar(neyc neyc2) {
        EntityClientPlayerMP entityClientPlayerMP = this._d._t;
        this.unexpectedPacket(neyc2);
        if (entityClientPlayerMP.openContainer != null && entityClientPlayerMP.openContainer.windowId == neyc2._a) {
            entityClientPlayerMP.openContainer.updateProgressBar(neyc2._b, neyc2._c);
        }
    }

    @Override
    public void handlePlayerInventory(hdms hdms2) {
        Entity entity = this._a(hdms2._a);
        if (entity != null) {
            entity.setCurrentItemOrArmor(hdms2._b, hdms2._a());
        }
    }

    @Override
    public void handleCloseWindow(Packet101CloseWindow packet101CloseWindow) {
        this._d._t.func_92015_f();
    }

    @Override
    public void handleBlockEvent(ujsb ujsb2) {
        this._d._r.addBlockEvent(ujsb2._a, ujsb2._b, ujsb2._c, ujsb2._f, ujsb2._d, ujsb2._e);
    }

    @Override
    public void handleBlockDestroy(igpu igpu2) {
        this._d._r.destroyBlockInWorldPartially(igpu2._a(), igpu2._b(), igpu2._c(), igpu2._d(), igpu2._e());
    }

    @Override
    public void handleMapChunks(Packet56MapChunks packet56MapChunks) {
        for (int i = 0; i < packet56MapChunks.getNumberOfChunkInPacket(); ++i) {
            int n = packet56MapChunks.getChunkPosX(i);
            int n2 = packet56MapChunks.getChunkPosZ(i);
            this._e._a(n, n2, true);
            this._e._a(n << 4, 0, n2 << 4, (n << 4) + 15, 256, (n2 << 4) + 15);
            Chunk chunk = this._e.getChunkFromChunkCoords(n, n2);
            if (chunk == null) {
                this._e._a(n, n2, true);
                chunk = this._e.getChunkFromChunkCoords(n, n2);
            }
            if (chunk == null) continue;
            chunk._a(packet56MapChunks.getChunkCompressedData(i), packet56MapChunks.field_73590_a[i], packet56MapChunks.field_73588_b[i], true);
            this._e.markBlockRangeForRenderUpdate(n << 4, 0, n2 << 4, (n << 4) + 15, 256, (n2 << 4) + 15);
            if (this._e.provider instanceof igyo) continue;
            chunk._m();
        }
    }

    @Override
    public boolean canProcessPacketsAsync() {
        return this._d != null && this._d._r != null && this._d._t != null && this._e != null;
    }

    @Override
    public void handleGameEvent(Packet70GameEvent packet70GameEvent) {
        EntityClientPlayerMP entityClientPlayerMP = this._d._t;
        int n = packet70GameEvent._b;
        int n2 = packet70GameEvent._c;
        if (n >= 0 && n < Packet70GameEvent._a.length && Packet70GameEvent._a[n] != null) {
            entityClientPlayerMP.addChatMessage(Packet70GameEvent._a[n]);
        }
        if (n == 1) {
            this._e.getWorldInfo()._b(true);
            this._e.setRainStrength(0.0f);
        } else if (n == 2) {
            this._e.getWorldInfo()._b(false);
            this._e.setRainStrength(1.0f);
        } else if (n == 3) {
            this._d._j._a(EnumGameType._a(n2));
        } else if (n == 4) {
            this._d._a(new GuiWinGame());
        } else if (n == 5) {
            GameSettings gameSettings = this._d._M;
            if (n2 == 0) {
                this._d._a(new GuiScreenDemo());
            } else if (n2 == 101) {
                this._d._J.getChatGUI()._a("demo.help.movement", Keyboard.getKeyName(gameSettings.keyBindForward._d), Keyboard.getKeyName(gameSettings.keyBindLeft._d), Keyboard.getKeyName(gameSettings.keyBindBack._d), Keyboard.getKeyName(gameSettings.keyBindRight._d));
            } else if (n2 == 102) {
                this._d._J.getChatGUI()._a("demo.help.jump", Keyboard.getKeyName(gameSettings.keyBindJump._d));
            } else if (n2 == 103) {
                this._d._J.getChatGUI()._a("demo.help.inventory", Keyboard.getKeyName(gameSettings.keyBindInventory._d));
            }
        } else if (n == 6) {
            this._e.playSound(entityClientPlayerMP.posX, entityClientPlayerMP.posY + (double)entityClientPlayerMP.getEyeHeight(), entityClientPlayerMP.posZ, "random.successful_hit", 0.18f, 0.45f, false);
        }
    }

    @Override
    public void handleMapData(yexp yexp2) {
        FMLNetworkHandler.handlePacket131Packet(this, yexp2);
    }

    public void _a(yexp yexp2) {
        if (yexp2._a == Item.map.itemID) {
            ItemMap._a(yexp2._b, this._d._r)._a(yexp2._c);
        } else {
            this._d._O()._b("Unknown itemid: " + yexp2._b);
        }
    }

    @Override
    public void handleDoorChange(qohl qohl2) {
        if (qohl2._a()) {
            this._d._r.func_82739_e(qohl2._a, qohl2._c, qohl2._d, qohl2._e, qohl2._b);
        } else {
            this._d._r.playAuxSFX(qohl2._a, qohl2._c, qohl2._d, qohl2._e, qohl2._b);
        }
    }

    @Override
    public void handleStatistic(dzcl dzcl2) {
        this._d._t.incrementStat(dzif._a(dzcl2._a), dzcl2._b);
    }

    @Override
    public void handleEntityEffect(cwaw cwaw2) {
        Entity entity = this._a(cwaw2._a);
        if (entity instanceof EntityLivingBase) {
            PotionEffect potionEffect = new PotionEffect(cwaw2._b, cwaw2._d, cwaw2._c);
            potionEffect._b(cwaw2._a());
            ((EntityLivingBase)entity).addPotionEffect(potionEffect);
        }
    }

    @Override
    public void handleRemoveEntityEffect(zibp zibp2) {
        Entity entity = this._a(zibp2._a);
        if (entity instanceof EntityLivingBase) {
            ((EntityLivingBase)entity).removePotionEffectClient(zibp2._b);
        }
    }

    @Override
    public boolean isServerHandler() {
        return false;
    }

    @Override
    public void handlePlayerInfo(bbzw bbzw2) {
        maza maza2 = (maza)this._h.get(bbzw2._a);
        if (maza2 == null && bbzw2._b) {
            maza2 = new maza(bbzw2._a);
            this._h.put(bbzw2._a, maza2);
            this._i.add(maza2);
        }
        if (maza2 != null && !bbzw2._b) {
            this._h.remove(bbzw2._a);
            this._i.remove(maza2);
        }
        if (bbzw2._b && maza2 != null) {
            maza2._c = bbzw2._c;
        }
    }

    @Override
    public void handleKeepAlive(Packet0KeepAlive packet0KeepAlive) {
        this._b(new Packet0KeepAlive(packet0KeepAlive._a));
    }

    @Override
    public void handlePlayerAbilities(Packet202PlayerAbilities packet202PlayerAbilities) {
        EntityClientPlayerMP entityClientPlayerMP = this._d._t;
        entityClientPlayerMP.capabilities._b = packet202PlayerAbilities._b();
        entityClientPlayerMP.capabilities._d = packet202PlayerAbilities._d();
        entityClientPlayerMP.capabilities._a = packet202PlayerAbilities._a();
        entityClientPlayerMP.capabilities._c = packet202PlayerAbilities._c();
        entityClientPlayerMP.capabilities._a(packet202PlayerAbilities._e());
        entityClientPlayerMP.capabilities._b(packet202PlayerAbilities._f());
    }

    @Override
    public void handleAutoComplete(Packet203AutoComplete packet203AutoComplete) {
        String[] stringArray = packet203AutoComplete._a().split("\u0000");
        if (this._d._B instanceof fndz) {
            fndz fndz2 = (fndz)this._d._B;
            fndz2._a(stringArray);
        }
    }

    @Override
    public void handleLevelSound(lpza lpza2) {
        this._d._r.playSound(lpza2._b(), lpza2._c(), lpza2._d(), lpza2._a(), lpza2._e(), lpza2._f(), false);
    }

    @Override
    public void handleCustomPayload(Packet250CustomPayload packet250CustomPayload) {
        FMLNetworkHandler.handlePacket250Packet(packet250CustomPayload, this._b, this);
    }

    @Override
    public void handleVanilla250Packet(Packet250CustomPayload packet250CustomPayload) {
        if ("MC|TrList".equals(packet250CustomPayload.channel)) {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(packet250CustomPayload.data));
            try {
                int n = dataInputStream.readInt();
                GuiScreen guiScreen = this._d._B;
                if (guiScreen != null && guiScreen instanceof xayk && n == this._d._t.openContainer.windowId) {
                    IMerchant iMerchant = ((xayk)guiScreen)._a();
                    MerchantRecipeList merchantRecipeList = MerchantRecipeList._a(dataInputStream);
                    iMerchant.setRecipes(merchantRecipeList);
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        } else if ("MC|Brand".equals(packet250CustomPayload.channel)) {
            this._d._t.func_142020_c(new String(packet250CustomPayload.data, Charsets.UTF_8));
        }
    }

    @Override
    public void handleSetObjective(sulv sulv2) {
        Scoreboard scoreboard = this._e.getScoreboard();
        if (sulv2._c == 0) {
            ScoreObjective scoreObjective = scoreboard._a(sulv2._a, ScoreObjectiveCriteria._c);
            scoreObjective._a(sulv2._b);
        } else {
            ScoreObjective scoreObjective = scoreboard._a(sulv2._a);
            if (sulv2._c == 1) {
                scoreboard._b(scoreObjective);
            } else if (sulv2._c == 2) {
                scoreObjective._a(sulv2._b);
            }
        }
    }

    @Override
    public void handleSetScore(plcv plcv2) {
        Scoreboard scoreboard = this._e.getScoreboard();
        ScoreObjective scoreObjective = scoreboard._a(plcv2._b);
        if (plcv2._d == 0) {
            Score score = scoreboard._a(plcv2._a, scoreObjective);
            score._c(plcv2._c);
        } else if (plcv2._d == 1) {
            scoreboard._b(plcv2._a);
        }
    }

    @Override
    public void handleSetDisplayObjective(txou txou2) {
        Scoreboard scoreboard = this._e.getScoreboard();
        if (txou2._b.length() == 0) {
            scoreboard._a(txou2._a, (ScoreObjective)null);
        } else {
            ScoreObjective scoreObjective = scoreboard._a(txou2._b);
            scoreboard._a(txou2._a, scoreObjective);
        }
    }

    @Override
    public void handleSetPlayerTeam(Packet209SetPlayerTeam packet209SetPlayerTeam) {
        Scoreboard scoreboard = this._e.getScoreboard();
        ScorePlayerTeam scorePlayerTeam = packet209SetPlayerTeam._f == 0 ? scoreboard._e(packet209SetPlayerTeam._a) : scoreboard._d(packet209SetPlayerTeam._a);
        if (packet209SetPlayerTeam._f == 0 || packet209SetPlayerTeam._f == 2) {
            scorePlayerTeam._a(packet209SetPlayerTeam._b);
            scorePlayerTeam._b(packet209SetPlayerTeam._c);
            scorePlayerTeam._c(packet209SetPlayerTeam._d);
            scorePlayerTeam._a(packet209SetPlayerTeam._g);
        }
        if (packet209SetPlayerTeam._f == 0 || packet209SetPlayerTeam._f == 3) {
            for (String string : packet209SetPlayerTeam._e) {
                scoreboard._a(string, scorePlayerTeam);
            }
        }
        if (packet209SetPlayerTeam._f == 4) {
            for (String string : packet209SetPlayerTeam._e) {
                scoreboard._b(string, scorePlayerTeam);
            }
        }
        if (packet209SetPlayerTeam._f == 1) {
            scoreboard._a(scorePlayerTeam);
        }
    }

    @Override
    public void handleWorldParticles(grll grll2) {
        for (int i = 0; i < grll2._i(); ++i) {
            double d = this._l.nextGaussian() * (double)grll2._e();
            double d2 = this._l.nextGaussian() * (double)grll2._f();
            double d3 = this._l.nextGaussian() * (double)grll2._g();
            double d4 = this._l.nextGaussian() * (double)grll2._h();
            double d5 = this._l.nextGaussian() * (double)grll2._h();
            double d6 = this._l.nextGaussian() * (double)grll2._h();
            this._e.spawnParticle(grll2._a(), grll2._b() + d, grll2._c() + d2, grll2._d() + d3, d4, d5, d6);
        }
    }

    @Override
    public void func_110773_a(Packet44UpdateAttributes packet44UpdateAttributes) {
        Entity entity = this._a(packet44UpdateAttributes._a());
        if (entity != null) {
            if (!(entity instanceof EntityLivingBase)) {
                throw new IllegalStateException("Server tried to update attributes of a non-living entity (actually: " + entity + ")");
            }
            BaseAttributeMap baseAttributeMap = ((EntityLivingBase)entity).getAttributeMap();
            for (apzo apzo2 : packet44UpdateAttributes._b()) {
                hubf hubf2 = baseAttributeMap._a(apzo2._a());
                if (hubf2 == null) {
                    hubf2 = baseAttributeMap._b(new RangedAttribute(apzo2._a(), 0.0, Double.MIN_NORMAL, Double.MAX_VALUE));
                }
                hubf2._a(apzo2._b());
                hubf2._d();
                for (AttributeModifier attributeModifier : apzo2._c()) {
                    hubf2._a(attributeModifier);
                }
            }
        }
    }

    public jjpj _d() {
        return this._b;
    }

    @Override
    public EntityPlayer getPlayer() {
        return this._d._t;
    }

    public static void _a(byte by) {
        _m = by;
    }

    public static byte _e() {
        return _m;
    }
}

