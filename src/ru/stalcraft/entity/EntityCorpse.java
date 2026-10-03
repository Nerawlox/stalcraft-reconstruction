/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  beu
 *  bic
 *  bjo
 *  com.google.common.io.ByteArrayDataInput
 *  com.google.common.io.ByteArrayDataOutput
 *  cpw.mods.fml.common.registry.IEntityAdditionalSpawnData
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
package ru.stalcraft.entity;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.inventory.CorpseInventory;
import ru.stalcraft.items.ItemWeapon;
import ru.stalcraft.server.network.ServerPacketSender;

public class EntityCorpse
extends og
implements IEntityAdditionalSpawnData {
    private static final int BACKPACK = 28;
    private static final int PISTOL = 29;
    private static final int RIFLE = 30;
    public String username;
    public int ticksDead;
    public float rotationFall;
    public float prevRotationFall;
    private float fallSpeed;
    private float startPitch;
    private float endLeftHand;
    private float endRightHand;
    public float leftHandRotation;
    public float rightHandRotation;
    public float prevLeftHandRotation;
    public float prevRightHandRotation;
    public boolean isFallingFinished;
    private bic downloadedSkin;
    public bjo locationSkin;
    public CorpseInventory inventory;
    private int currentItem;
    private int emptyInventoryTimer;
    private boolean isInventoryEmpty;
    public List openedContainers = new ArrayList();

    public EntityCorpse(abw par1World) {
        super(par1World);
        this.O = 1.0f;
        this.inventory = new CorpseInventory(this);
        this.e = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        if (!par1World.I) {
            this.afterServerInit();
        }
        this.a(this.O, 0.25f);
    }

    public EntityCorpse(uf player) {
        this(player.q);
        this.username = player.bu;
        this.b(player.u, player.v, player.w, player.A, player.B);
        this.aP = player.aP;
        if (player.P < 1.0f) {
            this.fallSpeed = 0.1f;
            this.rotationFall = 90.0f;
            this.finishFalling();
        } else {
            this.fallSpeed = this.q.s.nextBoolean() ? -0.1f : 0.1f;
        }
        this.startPitch = player.B;
        this.endRightHand = this.q.s.nextFloat() * 20.0f;
        this.endLeftHand = -this.q.s.nextFloat() * 20.0f;
        this.aN = this.aO = player.aN;
        this.inventory = new CorpseInventory(this, player);
        this.currentItem = player.bn.c;
        this.afterServerInit();
    }

    protected void afterServerInit() {
        this.updateObjects();
        this.updateInventoryEmpty();
    }

    @Override
    public void a() {
        super.a();
        this.v().a(28, 5);
        this.v().a(29, 5);
        this.v().a(30, 5);
    }

    @Override
    public boolean ar() {
        return true;
    }

    @Override
    public void l_() {
        super.l_();
        if (!this.q.I) {
            if (this.isInventoryOpened()) {
                this.updateInventoryEmpty();
            }
            if (this.isInventoryEmpty) {
                ++this.emptyInventoryTimer;
            }
        }
        if (!(this.q.I || this.ac <= 18000 && this.emptyInventoryTimer <= 6000)) {
            this.x();
        }
        if (!this.isFallingFinished) {
            this.updateFalling();
            if (Math.abs(this.rotationFall) >= 90.0f) {
                this.finishFalling();
            }
        }
        this.updateRotations();
        if (!this.q.I) {
            this.updateObjects();
        }
        this.updateEquipment();
    }

    @Override
    public void a(by tag) {
        super.a(tag);
        this.username = tag.i("username");
        this.ticksDead = tag.e("ticks_dead");
        this.prevRotationFall = this.rotationFall = tag.g("rotation_fall");
        this.fallSpeed = tag.g("fall_speed");
        this.endRightHand = tag.g("end_right_hand");
        this.endLeftHand = tag.g("end_left_hand");
        this.rightHandRotation = this.prevRightHandRotation = tag.g("right_hand_rotation");
        this.leftHandRotation = this.prevLeftHandRotation = tag.g("left_hand_rotation");
        this.isFallingFinished = tag.n("is_falling_finished");
        this.currentItem = tag.e("current_item");
        this.emptyInventoryTimer = tag.e("empty_inv_timer");
        this.inventory.readFromNBT(tag.m("corpse_inventory"));
        this.updateInventoryEmpty();
    }

    @Override
    public void b(by tag) {
        super.b(tag);
        tag.a("username", this.username);
        tag.a("ticks_dead", this.ticksDead);
        tag.a("rotation_fall", this.rotationFall);
        tag.a("fall_speed", this.fallSpeed);
        tag.a("start_pitch", this.startPitch);
        tag.a("end_right_hand", this.endRightHand);
        tag.a("end_left_hand", this.endLeftHand);
        tag.a("right_hand_rotation", this.rightHandRotation);
        tag.a("left_hand_rotation", this.leftHandRotation);
        tag.a("is_falling_finished", this.isFallingFinished);
        tag.a("current_item", this.currentItem);
        tag.a("corpse_inventory", this.inventory.writeToNBT(new cg()));
        tag.a("empty_inv_timer", this.emptyInventoryTimer);
    }

    public void writeSpawnData(ByteArrayDataOutput data) {
        data.writeInt(this.ticksDead);
        data.writeFloat(this.rotationFall);
        data.writeFloat(this.fallSpeed);
        data.writeFloat(this.startPitch);
        data.writeFloat(this.endRightHand);
        data.writeFloat(this.endLeftHand);
        data.writeFloat(this.aN);
        data.writeBoolean(this.isFallingFinished);
        data.writeInt(this.currentItem);
        data.writeUTF(this.username);
    }

    public void readSpawnData(ByteArrayDataInput data) {
        this.ticksDead = data.readInt();
        this.prevRotationFall = this.rotationFall = data.readFloat();
        this.fallSpeed = data.readFloat();
        this.startPitch = data.readFloat();
        this.endRightHand = data.readFloat();
        this.endLeftHand = data.readFloat();
        this.aO = this.aN = data.readFloat();
        this.isFallingFinished = data.readBoolean();
        this.currentItem = data.readInt();
        this.username = data.readUTF();
        uf player = this.q.a(this.username);
        if (player != null) {
            if (player.A != 0.0f) {
                this.A = player.A;
            }
            if (player.aP != 0.0f) {
                this.aP = player.aP;
            }
            if (player.B != 0.0f) {
                this.startPitch = player.B;
            }
            if (player.aN != 0.0f) {
                this.aN = player.aN;
            }
            this.setupSkin(player);
        } else {
            this.setupSkin(this.username);
        }
        int i2 = ls.c(this.u / 16.0);
        int j2 = ls.c(this.w / 16.0);
        this.q.e(i2, j2).a(this);
    }

    @SideOnly(value=Side.CLIENT)
    private void setupSkin(uf player) {
        this.locationSkin = ((beu)player).r();
        this.downloadedSkin = ((beu)player).p();
    }

    @SideOnly(value=Side.CLIENT)
    private void setupSkin(String username) {
        this.locationSkin = beu.f((String)username);
        this.downloadedSkin = beu.a((bjo)this.locationSkin, (String)username);
    }

    private void updateFalling() {
        this.prevRotationFall = this.rotationFall;
        if (this.fallSpeed > 0.0f) {
            this.rotationFall = Math.min(90.0f, this.rotationFall + this.fallSpeed);
            this.fallSpeed += 0.75f;
        } else {
            this.rotationFall = Math.max(-90.0f, this.rotationFall + this.fallSpeed);
            this.fallSpeed -= 0.75f;
        }
    }

    private void updateRotations() {
        this.prevRightHandRotation = this.rightHandRotation;
        this.prevLeftHandRotation = this.leftHandRotation;
        float progress = this.getFallProgress();
        this.rightHandRotation = this.endRightHand * progress;
        this.leftHandRotation = this.endLeftHand * progress;
        this.B = this.startPitch * (1.0f - progress);
    }

    private void finishFalling() {
        double z2;
        double x2;
        this.isFallingFinished = true;
        this.prevRotationFall = this.rotationFall;
        this.prevRightHandRotation = this.rightHandRotation;
        this.prevLeftHandRotation = this.leftHandRotation;
        if (this.rotationFall < 0.0f) {
            x2 = this.u + (double)ls.a(this.aN / 180.0f * (float)Math.PI) * 0.9;
            z2 = this.w + (double)(-ls.b(this.aN / 180.0f * (float)Math.PI)) * 0.9;
        } else {
            x2 = this.u + (double)(-ls.a(this.aN / 180.0f * (float)Math.PI)) * 0.9;
            z2 = this.w + (double)ls.b(this.aN / 180.0f * (float)Math.PI) * 0.9;
        }
        this.b(x2, this.v, z2);
        this.U = this.u;
        this.W = this.w;
    }

    @Override
    public float S() {
        return this.isFallingFinished ? 0.0f : super.S();
    }

    private float getFallProgress() {
        return Math.abs(this.rotationFall) / 90.0f;
    }

    @Override
    protected boolean bc() {
        return true;
    }

    @Override
    public void e(float par1, float par2) {
        this.x = 0.0;
        this.z = 0.0;
        super.e(par1, par2);
    }

    public bjo getTexture() {
        return this.locationSkin;
    }

    @Override
    public void a(double par1, double par3, double par5, float par7, float par8, int par9) {
        if (this.A == 0.0f) {
            this.A = par7;
        }
        if (this.B == 0.0f) {
            this.B = par8;
        }
    }

    @Override
    protected boolean a(uf player) {
        if (!this.q.I) {
            player.openGui(StalkerMain.instance, 2, player.q, this.k, 0, 0);
            ServerPacketSender.sendWindowId(player, player.bp.d);
        }
        return true;
    }

    private void updateObjects() {
        ye backpack = this.getBackpack();
        if (this.ah.f(28) != backpack) {
            if (backpack == null) {
                this.ah.a(28, 5);
                this.ah.h(28);
            } else {
                this.ah.b(28, backpack);
            }
        }
        ye pistol = this.getPistol();
        if (this.ah.f(29) != pistol) {
            if (pistol == null) {
                this.ah.a(29, 5);
                this.ah.h(29);
            } else {
                this.ah.b(29, pistol);
            }
        }
        ye rifle = this.getRifle();
        if (this.ah.f(30) != rifle) {
            if (rifle == null) {
                this.ah.a(30, 5);
                this.ah.h(30);
            } else {
                this.ah.b(30, rifle);
            }
        }
    }

    public ye getBackpack() {
        return this.q.I ? this.ah.f(28) : this.inventory.mainInventory[52];
    }

    public ye getPistol() {
        if (this.q.I) {
            return this.ah.f(29);
        }
        for (int i2 = 0; i2 < 4; ++i2) {
            if (i2 == this.currentItem || this.inventory.mainInventory[i2] == null || !(this.inventory.mainInventory[i2].b() instanceof ItemWeapon) || !((ItemWeapon)this.inventory.mainInventory[i2].b()).isPistol) continue;
            return this.inventory.mainInventory[i2];
        }
        return null;
    }

    public ye getRifle() {
        if (this.q.I) {
            return this.ah.f(30);
        }
        for (int i2 = 0; i2 < 4; ++i2) {
            if (i2 == this.currentItem || this.inventory.mainInventory[i2] == null || !(this.inventory.mainInventory[i2].b() instanceof ItemWeapon) || ((ItemWeapon)this.inventory.mainInventory[i2].b()).isPistol) continue;
            return this.inventory.mainInventory[i2];
        }
        return null;
    }

    @Override
    public ye n(int par1) {
        return par1 == 0 ? this.inventory.mainInventory[this.currentItem] : this.inventory.mainInventory[par1 + 35];
    }

    @Override
    public void c(int par1, ye par2ItemStack) {
        if (par1 == 0) {
            this.inventory.mainInventory[this.currentItem] = par2ItemStack;
        } else {
            this.inventory.mainInventory[par1 + 35] = par2ItemStack;
        }
    }

    private void updateEquipment() {
        for (int i2 = 0; i2 < 5; ++i2) {
            this.ae()[i2] = this.n(i2);
        }
    }

    @Override
    protected void bw() {
    }

    public void updateInventoryEmpty() {
        boolean empty = true;
        for (ye stack : this.inventory.mainInventory) {
            if (stack == null) continue;
            empty = false;
            break;
        }
        this.isInventoryEmpty = empty;
    }

    private boolean isInventoryOpened() {
        return this.openedContainers.size() != 0;
    }

    @Override
    protected boolean i(double par1, double par3, double par5) {
        return true;
    }
}

