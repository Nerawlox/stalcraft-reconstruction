/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiHelper;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.GuiScreenAdvanced;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.McBackground;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.component.McItemToolTip;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.main.zwaw;
import gloomyfolken.mods.effects.client.mcsa.ezfa;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.sajh;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.BufferUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public abstract class GuiItem
extends GuiScreenAdvanced {
    protected static final Minecraft mc = Minecraft._E();
    protected static final ResourceLocation texture = new ResourceLocation("weapons", "textures/gui/new_upgrade.png");
    protected static final ResourceLocation lineTexture = new ResourceLocation("weapons", "textures/gui/line.png");
    protected static final GuiRenderer guiRenderer = new GuiRendererBuilder().setTextureSize(256, 128).create();
    protected ItemStack stack;
    protected int guiScale;
    protected boolean guiVisible;
    protected McGuiItem guiItem;
    protected McBackground background;
    protected McButton hideGuiButton;
    protected hbcv renderItem;
    protected uhib previewConfig;
    protected static IntBuffer viewportBuf = BufferUtils.createIntBuffer(16);
    protected static FloatBuffer projectionBuf = BufferUtils.createFloatBuffer(16);
    protected static FloatBuffer modelviewBuf = BufferUtils.createFloatBuffer(16);

    public GuiItem(GuiScreen guiScreen, ItemStack itemStack, hbcv hbcv2) {
        super(guiRenderer, 800, 500, guiScreen);
        this.stack = itemStack;
        this.guiScale = Minecraft._E()._M.guiScale;
        this.renderItem = hbcv2;
        this.guiVisible = true;
        if (hbcv2 != null) {
            this.previewConfig = hbcv2._c;
        }
        this.drawParentScreen = false;
        Minecraft._E()._M.guiScale = 2;
    }

    public GuiItem(GuiScreen guiScreen, ItemStack itemStack, hbcv hbcv2, uhib uhib2) {
        this(guiScreen, itemStack, hbcv2);
        this.previewConfig = uhib2;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.guiVisible = true;
        this.background = (McBackground)new McBackground(this, new Point(this.guiLeft, this.guiTop), new Dimension(0, 0)).setHasBackground(true).setRenderer(guiRenderer);
        this.addElement(this.background);
        this.guiItem = this.initGuiItem();
        this.addElement(this.guiItem);
        this.hideGuiButton = GuiHelper.addButton(this, 20, this.screenHeight - 60, 200, 40, "\u0421\u043a\u0440\u044b\u0442\u044c \u0438\u043d\u0442\u0435\u0440\u0444\u0435\u0439\u0441");
        this.actionManager.registerActionHandler(this.hideGuiButton, GuiActionButtonClick.class, guiActionButtonClick -> {
            this.guiVisible = !this.guiVisible;
            this.hideGuiButton.text = this.guiVisible ? "\u0421\u043a\u0440\u044b\u0442\u044c \u0438\u043d\u0442\u0435\u0440\u0444\u0435\u0439\u0441" : "\u041f\u043e\u043a\u0430\u0437\u0430\u0442\u044c \u0438\u043d\u0442\u0435\u0440\u0444\u0435\u0439\u0441";
            for (GuiComponent guiComponent : this.elementsList.getElements()) {
                boolean bl = this.guiVisible || guiComponent == this.background || guiComponent == this.hideGuiButton || guiComponent == this.guiItem;
                guiComponent.setVisible(bl);
            }
        });
    }

    protected McGuiItem initGuiItem() {
        return new McGuiItem(this, new Point(0, 0), new Dimension(GuiItem.mc._n, GuiItem.mc._o));
    }

    @Override
    protected void keyTyped(char c, int n) {
        super.keyTyped(c, n);
        if (Keyboard.isKeyDown(61)) {
            if (n == 31 || n == 20) {
                mc._c();
            } else if (n == 45) {
                GloomyCore.instance.itemsLoader._e();
            }
        }
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        Mouse.setGrabbed(false);
        Mouse.setClipMouseCoordinatesToWindow(true);
        Minecraft._E()._M.guiScale = this.guiScale;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        for (GuiComponent guiComponent : this.getElementsList()) {
            if (!(guiComponent instanceof McSelectSlot) || ((McSelectSlot)guiComponent).toolTip == null) continue;
            this.getElementsList().bringToFront(guiComponent);
        }
        super.drawScreen(n, n2, f);
    }

    protected List<ItemStack> getAvailableStacks() {
        return Collections.emptyList();
    }

    public ItemStack getStack() {
        return this.stack;
    }

    public void setStack(ItemStack itemStack) {
        this.stack = itemStack;
    }

    @Override
    public void drawWorldBackground(int n) {
        if (GuiItem.mc._r != null) {
            this.drawGradientRect(0, 0, this.width, this.height, 0x22000000, 0x22000000);
        } else {
            this.drawBackground(n);
        }
    }

    protected static abstract class SlotRotator {
        public final String name;
        public Vector2f screenPos;
        public float targetAngle;
        public float prevAngle;
        public float angle;
        public final McSelectSlot gui;

        public SlotRotator(String string, McSelectSlot mcSelectSlot) {
            this.name = string;
            this.gui = mcSelectSlot;
        }

        public void updateTargetAngle(Vector2f vector2f) {
            this.screenPos = vector2f;
            Vector2f vector2f2 = new Vector2f(vector2f.x - (float)GuiItem.mc._n / 2.0f, vector2f.y - (float)GuiItem.mc._o / 2.0f);
            this.targetAngle = (float)Math.atan2(vector2f2.y, vector2f2.x);
        }

        public void tick() {
            this.prevAngle = this.angle;
            float f = jywc._a(this.targetAngle - this.angle);
            this.angle = Math.abs(f) < 0.01f ? (this.angle += f) : (this.angle += f * 0.4f);
        }

        public void renderTick(float f) {
            this.gui.setLocation(this.getSlotPos(f));
        }

        public void setAngleToTarget() {
            this.prevAngle = this.angle = this.targetAngle;
        }

        public Point getSlotPos(float f) {
            float f2 = jywc._a(this.prevAngle, this.angle, f);
            Vector2f vector2f = new Vector2f(sajh._b(f2), sajh._a(f2));
            float f3 = (float)GuiItem.mc._n / 4.0f;
            float f4 = (float)GuiItem.mc._o / 4.0f;
            float f5 = f3 * f4 / (float)Math.sqrt(f3 * f3 * sajh._a(f2) * sajh._a(f2) + f4 * f4 * sajh._b(f2) * sajh._b(f2));
            vector2f.set(vector2f.x * f5, vector2f.y * f5);
            GuiItem.mc._h._a(texture);
            Point point = new Point((int)((float)GuiItem.mc._n / 2.0f + vector2f.x - 36.0f), (int)((float)GuiItem.mc._o / 2.0f + vector2f.y - 72.0f));
            return point;
        }

        public abstract String getLocalizedName();
    }

    protected static class McGuiItem
    extends GuiComponent {
        public GuiItem guiItem;
        public float rotationX = 0.0f;
        public float rotationY = 0.0f;
        public float rotationZ = 0.0f;
        public float prevRotationX;
        public float prevRotationY;
        public float prevRotationZ;
        public float oldRotationX;
        public float oldRotationY;
        public float oldRotationZ;
        public float scale;
        public int mouseDownX;
        public int mouseDownY;
        public boolean mouseDown;
        public float zoom;
        public float targetZoom;
        public float prevZoom;
        public float xRotationLimit = 45.0f;
        public float zRotationLimit = 45.0f;
        public List<SlotRotator> slots = new ArrayList<SlotRotator>();
        protected boolean initializedSlots = false;

        public McGuiItem(GuiItem guiItem, Point point, Dimension dimension) {
            super(guiItem, point, dimension);
            this.guiItem = guiItem;
            this.targetZoom = this.prevZoom = guiItem.previewConfig._d;
            this.zoom = this.prevZoom;
        }

        @Override
        public void tick() {
            jysc._H()._n(1.0);
            this.prevZoom = this.zoom;
            this.zoom = Math.abs(this.zoom - this.targetZoom) < 0.001f ? this.targetZoom : (this.zoom += (this.targetZoom - this.zoom) * 0.5f);
            this.prevRotationX = this.rotationX;
            this.prevRotationY = this.rotationY;
            this.prevRotationZ = this.rotationZ;
            if (this.mouseDown) {
                Point point = new Point(Mouse.getX(), GuiItem.mc._o - Mouse.getY());
                float f = (float)(point.x - this.mouseDownX) / 5.0f;
                float f2 = (float)(point.y - this.mouseDownY) / 5.0f;
                this.rotationY = this.oldRotationY - f;
                float f3 = f2 * 0.3f;
                float f4 = f2 * 0.6f;
                this.rotationX = sajh._a(this.oldRotationX - (f3 *= sajh._a((float)Math.toRadians(this.rotationY))), -this.xRotationLimit, this.xRotationLimit);
                this.rotationZ = sajh._a(this.oldRotationZ - (f4 *= sajh._b((float)Math.toRadians(this.rotationY))), -this.zRotationLimit, this.zRotationLimit);
                this.mouseDownX = point.x;
                this.mouseDownY = point.y;
                this.oldRotationX = this.rotationX;
                this.oldRotationY = this.rotationY;
                this.oldRotationZ = this.rotationZ;
            }
            for (SlotRotator slotRotator : this.slots) {
                slotRotator.tick();
            }
        }

        @Override
        public void drawComponent(Point point, float f) {
            this.drawItem(f);
            if (this.guiItem.guiVisible) {
                this.drawDesc();
                this.drawSlots(f);
            }
        }

        @Override
        public void mouseClicked(Point point, int n) {
            if (n != 0) {
                return;
            }
            if (this.parent.getElementsList().getElementMouseOver() == this) {
                this.mouseDownX = point.x;
                this.mouseDownY = point.y;
                this.oldRotationX = this.rotationX;
                this.oldRotationY = this.rotationY;
                this.oldRotationZ = this.rotationZ;
                Mouse.setGrabbed(true);
                Mouse.setClipMouseCoordinatesToWindow(false);
                this.mouseDown = true;
            }
        }

        @Override
        public void mouseUp(Point point, int n) {
            if (n != 0) {
                return;
            }
            Mouse.setGrabbed(false);
            Mouse.setClipMouseCoordinatesToWindow(true);
            this.mouseDown = false;
        }

        @Override
        public void handleWheel(int n, Point point) {
            this.targetZoom = sajh._a(this.targetZoom + Math.signum(n) * 0.1f, this.guiItem.previewConfig._e, this.guiItem.previewConfig._f);
        }

        public void drawDesc() {
            int n = -this.renderer.getFontHeight();
            ArrayList<String> arrayList = new ArrayList<String>();
            MinecraftForge.EVENT_BUS.post(new ycvh(this.guiItem.stack, GuiItem.mc._t, arrayList));
            this.addDesc(arrayList);
            for (String string : arrayList) {
                this.renderer.drawString(string, 20, 20 + (n += this.renderer.getFontHeight()), 0xFFFFFF);
            }
        }

        protected void addDesc(List<String> list) {
            if (this.guiItem.stack._a() instanceof gloomyfolken.mods.core.misc.ezfa) {
                ((gloomyfolken.mods.core.misc.ezfa)((Object)this.guiItem.stack._a()))._c(this.guiItem.stack, GuiItem.mc._t, list);
            }
        }

        protected jywl getSkeleton() {
            return null;
        }

        public void drawItem(float f) {
            float f2 = iwya._d;
            float f3 = iwya._e;
            iwya._a(iwya._b, 240.0f, 0.0f);
            GL11.glEnable(2929);
            GL11.glMatrixMode(5889);
            GL11.glPushMatrix();
            GL11.glLoadIdentity();
            Project.gluPerspective(30.0f, (float)GuiItem.mc._n / (float)GuiItem.mc._o, 0.05f, 100.0f);
            GL11.glMatrixMode(5888);
            GL11.glPushMatrix();
            GL11.glLoadIdentity();
            if (zwaw._a(16384)) {
                GL11.glClear(256);
            }
            eidj._a._c();
            GL11.glTranslatef(0.0f, 0.0f, -5.0f);
            float f4 = jywc._a(this.prevZoom, this.zoom, f);
            GL11.glScalef(3.6f * f4, 3.6f * f4, 3.6f * f4);
            float f5 = jywc._a(this.prevRotationX, this.rotationX, f);
            float f6 = jywc._a(this.prevRotationY, this.rotationY, f);
            float f7 = jywc._a(this.prevRotationZ, this.rotationZ, f);
            GL11.glRotatef(-f6 + 90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-f7, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-f5, 1.0f, 0.0f, 0.0f);
            uhib uhib2 = this.guiItem.previewConfig;
            GL11.glTranslatef(-uhib2._a, -uhib2._b, -uhib2._c);
            ezfc._a();
            ezfc._d();
            this.drawModel(this.guiItem.stack, f);
            jywl jywl2 = this.getSkeleton();
            if (jywl2 != null) {
                this.loadSlotPositions(jywl2, jywl2._e);
                this.findSlotTargetAngles();
            }
            ezfa._a._a();
            ezfc._b();
            zwaw._a(16384, true);
            GL11.glDisable(32826);
            GL11.glMatrixMode(5889);
            GL11.glPopMatrix();
            GL11.glMatrixMode(5888);
            GL11.glPopMatrix();
            GL11.glDisable(2929);
            iwya._a(iwya._b, f2, f3);
            GL11.glDisable(2896);
            anya._h();
            GL11.glEnable(2903);
        }

        protected void drawModel(ItemStack itemStack, float f) {
            this.guiItem.renderItem._e((ItemStack)itemStack)._c.renderAll();
        }

        protected void drawSlots(float f) {
            GL11.glEnable(3042);
            for (SlotRotator slotRotator : this.slots) {
                slotRotator.renderTick(f);
                Vector2f vector2f = slotRotator.screenPos;
                this.drawLine(vector2f, slotRotator.getSlotPos(f).add(36, 70).toVec(), Float.valueOf(2.0f));
                GuiItem.mc._h._a(texture);
                this.renderer.drawTexturedModalRect(new Point((int)vector2f.x - 8, (int)vector2f.y - 8), new Point(0, 106), new Dimension(16, 16));
                String string = slotRotator.getLocalizedName();
                this.renderer.drawRect((int)vector2f.x + 8, (int)vector2f.y - 8, this.renderer.getStringWidth(string) + 1, 16.0, -1442840576);
                GL11.glEnable(3042);
                this.renderer.drawString(string, (int)vector2f.x + 10, (int)vector2f.y - 10, -1);
            }
            GL11.glDisable(3042);
        }

        protected void drawLine(Vector2f vector2f, Vector2f vector2f2, Float f) {
            GuiItem.mc._h._a(lineTexture);
            Vector2f vector2f3 = Vector2f.sub(vector2f2, vector2f, null);
            Vector2f vector2f4 = Vector2f.add(vector2f, (Vector2f)new Vector2f(-vector2f3.y, vector2f3.x).normalise().scale(f.floatValue()), null);
            Vector2f vector2f5 = Vector2f.add(vector2f, (Vector2f)new Vector2f(vector2f3.y, -vector2f3.x).normalise().scale(f.floatValue()), null);
            Vector2f vector2f6 = Vector2f.add(vector2f2, (Vector2f)new Vector2f(-vector2f3.y, vector2f3.x).normalise().scale(f.floatValue()), null);
            Vector2f vector2f7 = Vector2f.add(vector2f2, (Vector2f)new Vector2f(vector2f3.y, -vector2f3.x).normalise().scale(f.floatValue()), null);
            float f2 = this.guiItem.zLevel;
            Tessellator tessellator = Tessellator.instance;
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(vector2f4.x * this.renderer.scale, vector2f4.y * this.renderer.scale, f2, 0.0, 0.0);
            tessellator.addVertexWithUV(vector2f6.x * this.renderer.scale, vector2f6.y * this.renderer.scale, f2, vector2f3.length() * 0.12f / f.floatValue(), 0.0);
            tessellator.addVertexWithUV(vector2f7.x * this.renderer.scale, vector2f7.y * this.renderer.scale, f2, vector2f3.length() * 0.12f / f.floatValue(), 1.0);
            tessellator.addVertexWithUV(vector2f5.x * this.renderer.scale, vector2f5.y * this.renderer.scale, f2, 0.0, 1.0);
            tessellator.draw();
        }

        protected void findSlotTargetAngles() {
            Object object;
            int n;
            int n2;
            float f = 0.7f;
            for (int i = 0; i < this.slots.size() - 1; ++i) {
                n2 = 0;
                for (n = 0; n < this.slots.size() - i - 1; ++n) {
                    if (!(this.slots.get((int)n).targetAngle - f > this.slots.get((int)(n + 1)).targetAngle)) continue;
                    object = this.slots.get(n);
                    this.slots.set(n, this.slots.get(n + 1));
                    this.slots.set(n + 1, (SlotRotator)object);
                    n2 = 1;
                }
                if (n2 == 0) break;
            }
            List list = this.slots.stream().sorted((slotRotator, slotRotator2) -> (int)Math.signum(slotRotator.targetAngle - slotRotator2.targetAngle)).collect(Collectors.toList());
            for (n2 = 0; n2 < 50; ++n2) {
                int n3;
                n = list.size();
                object = new float[n];
                for (n3 = 0; n3 < n; ++n3) {
                    float f2;
                    float f3 = ((SlotRotator)list.get((int)n3)).targetAngle;
                    Vector2f vector2f = new Vector2f(GuiItem.mc._n, GuiItem.mc._o);
                    vector2f.normalise(vector2f);
                    float f4 = vector2f.x;
                    float f5 = vector2f.y;
                    float f6 = f4 * f5 / (float)Math.sqrt(f4 * f4 * sajh._a(f3) * sajh._a(f3) + f5 * f5 * sajh._b(f3) * sajh._b(f3));
                    float f7 = 0.2f / (f6 * ((float)Math.min(GuiItem.mc._n, GuiItem.mc._o) / 1018.0f));
                    SlotRotator slotRotator3 = (SlotRotator)list.get((n + n3 - 1) % n);
                    SlotRotator slotRotator4 = (SlotRotator)list.get((n + n3 + 1) % n);
                    if (n3 != 0 || slotRotator3 != slotRotator4) {
                        f2 = jywc._a(slotRotator3.targetAngle - f3);
                        if (f2 >= 0.0f && f2 <= f7) {
                            int n4 = n3;
                            object[n4] = object[n4] + (f7 - f2) * 0.1f;
                        } else if (f2 <= 0.0f && f2 >= -f7) {
                            int n5 = n3;
                            object[n5] = object[n5] - (-f7 - f2) * 0.1f;
                        }
                    }
                    if (n3 == n - 1 && slotRotator3 == slotRotator4) continue;
                    f2 = jywc._a(slotRotator4.targetAngle - f3);
                    if (f2 >= 0.0f && f2 <= f7) {
                        int n6 = n3;
                        object[n6] = object[n6] - (f7 - f2) * 0.1f;
                        continue;
                    }
                    if (!(f2 <= 0.0f) || !(f2 >= -f7)) continue;
                    int n7 = n3;
                    object[n7] = object[n7] + (-f7 - f2) * 0.1f;
                }
                for (n3 = 0; n3 < n; ++n3) {
                    ((SlotRotator)list.get((int)n3)).targetAngle += object[n3];
                }
            }
        }

        protected void loadSlotPositions(jywl jywl2, ivtm ivtm2) {
            GL11.glGetInteger(2978, viewportBuf);
            GL11.glGetFloat(2983, projectionBuf);
            GL11.glGetFloat(2982, modelviewBuf);
            if (!this.initializedSlots) {
                this.initializeSlots(jywl2, ivtm2);
            }
            for (SlotRotator slotRotator3 : this.slots) {
                Vector3f vector3f = this.getSlotPos3D(jywl2, ivtm2, slotRotator3);
                if (vector3f == null) continue;
                FloatBuffer floatBuffer = FloatBuffer.allocate(3);
                Project.gluProject(vector3f.x, vector3f.y, vector3f.z, modelviewBuf, projectionBuf, viewportBuf, floatBuffer);
                slotRotator3.updateTargetAngle(new Vector2f(floatBuffer.get(0), (float)GuiItem.mc._o - floatBuffer.get(1)));
            }
            if (!this.initializedSlots) {
                this.findSlotTargetAngles();
                for (SlotRotator slotRotator3 : this.slots) {
                    slotRotator3.setAngleToTarget();
                }
                this.slots.sort((slotRotator, slotRotator2) -> (int)Math.signum(slotRotator.targetAngle - slotRotator2.targetAngle));
                this.initializedSlots = true;
            }
        }

        protected void resetSlots() {
            this.initializedSlots = false;
            this.guiItem.getElementsList().removeAll(this.slots.stream().map(slotRotator -> slotRotator.gui).collect(Collectors.toList()));
            this.slots.clear();
        }

        protected Vector3f getSlotPos3D(jywl jywl2, ivtm ivtm2, SlotRotator slotRotator) {
            String string = slotRotator.name;
            jywl.kjui kjui2 = jywl2._a(string);
            if (kjui2 == null) {
                return null;
            }
            return ivtm2._a[kjui2._c];
        }

        protected void initializeSlots(jywl jywl2, ivtm ivtm2) {
        }
    }

    protected static abstract class McSelectSlot
    extends GuiComponent {
        public GuiItem guiItem;
        public Predicate<ItemStack> stackSelector;
        public GuiRenderer.RenderItemHD itemRenderer;
        public ItemStack selectedStack;
        public List<ItemStack> availableStacks = new ArrayList<ItemStack>(1);
        public boolean isSelected = false;
        public boolean wasMouseOverStack;
        public ItemStack lastMouseOverStack;
        public McItemToolTip toolTip;

        public McSelectSlot(GuiItem guiItem, ItemStack itemStack, Predicate<ItemStack> predicate) {
            super(guiItem);
            this.guiItem = guiItem;
            this.selectedStack = itemStack;
            this.stackSelector = predicate;
            this.itemRenderer = this.renderer.createItemRender(2.0f / this.renderer.scale);
            this.updateStacks();
        }

        @Override
        public void tick() {
            this.updateStacks();
            if (this.toolTip != null) {
                this.guiItem.getElementsList().bringToFront(this);
            }
        }

        protected void updateStacks() {
            this.availableStacks.clear();
            List<ItemStack> list = this.guiItem.getAvailableStacks();
            for (int i = 0; i < list.size(); ++i) {
                ItemStack itemStack = list.get(i);
                if (itemStack == null || !this.stackSelector.test(itemStack)) continue;
                boolean bl = ncwh._a(this.selectedStack, itemStack, false);
                for (ItemStack itemStack2 : this.availableStacks) {
                    if (!ncwh._a(itemStack2, itemStack, false)) continue;
                    bl = true;
                }
                if (bl) continue;
                this.availableStacks.add(itemStack);
            }
        }

        @Override
        public void drawComponent(Point point, float f) {
            if (this.guiItem.guiItem.mouseDown) {
                point = Point.zeroPoint;
            }
            Minecraft._E()._h._a(texture);
            this.wasMouseOverStack = false;
            this.lastMouseOverStack = null;
            boolean bl = this.toolTip != null;
            this.toolTip = null;
            if (this.isSelected) {
                ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>(2);
                arrayList.add(this.selectedStack);
                if (this.selectedStack != null) {
                    arrayList.add(null);
                }
                arrayList.addAll(this.availableStacks);
                Point point2 = this.getLocation();
                int n = point2.y;
                int n2 = Math.max((int)Math.floor((double)n / 72.0), 1);
                int n3 = 3;
                if (arrayList.size() > n2 * n3) {
                    n3 = Math.max((int)Math.ceil((double)arrayList.size() / (double)n2), 1);
                }
                for (int i = 0; i < arrayList.size(); ++i) {
                    ItemStack itemStack = (ItemStack)arrayList.get(i);
                    this.renderStackInSlot(itemStack, point2, point, false);
                    if (McSelectSlot.isMouseInBounds(point, point2, point2.add(72, 72))) {
                        this.wasMouseOverStack = true;
                        this.lastMouseOverStack = itemStack;
                    }
                    point2 = i == 0 ? point2.add(0, -72) : (i % n3 == 0 ? point2.add(-72 * (n3 - 1), -72) : point2.add(72, 0));
                }
            } else {
                if (this.selectedStack != null || !this.availableStacks.isEmpty()) {
                    boolean bl2 = McSelectSlot.isMouseInBounds(point, this.getLocation().add(0, -16), this.getLocation().add(72, 0));
                    this.renderer.drawTexturedModalRect(this.getLocation().add(0, -16), new Point(72, bl2 ? 16 : 0), new Dimension(72, 16));
                }
                this.renderStackInSlot(this.selectedStack, this.getLocation(), point, true);
            }
            if (bl && this.toolTip != null) {
                this.toolTip.drawComponent(point, f);
            }
        }

        protected void renderStackInSlot(ItemStack itemStack, Point point, Point point2, boolean bl) {
            this.renderer.bindTexture(texture);
            this.renderer.drawTexturedModalRect(point, new Point(72, 32), new Dimension(72, 72));
            boolean bl2 = McSelectSlot.isMouseInBounds(point2, point, point.add(72, 72));
            if (itemStack != null) {
                this.renderStack(itemStack, point, bl2);
            }
            if (bl2 && (itemStack != null || !bl)) {
                this.renderer.drawRect(point, new Dimension(72, 72), -2130706433);
                GL11.glEnable(3042);
            }
        }

        protected void renderStack(ItemStack itemStack, Point point, boolean bl) {
            GL11.glPushAttrib(1048575);
            this.itemRenderer.renderStack(itemStack, point.x + 4, point.y + 4);
            GL11.glPopAttrib();
            if (bl) {
                this.toolTip = new TempToolTip(itemStack);
            }
            if (!this.canStackBeSelected(itemStack)) {
                this.renderer.drawTexturedModalRect(point, new Point(144, 32), new Dimension(72, 72));
            }
        }

        @Override
        public boolean isMouseInBounds(Point point) {
            if (this.isSelected) {
                return true;
            }
            boolean bl = !this.availableStacks.isEmpty() || this.selectedStack != null;
            return McSelectSlot.isMouseInBounds(point, this.getLocation().add(0, bl ? -16 : 0), this.getLocation().add(72, 72));
        }

        @Override
        public void mouseClicked(Point point, int n) {
            if (n == 0 && this.isMouseInBounds(point)) {
                if (this.isSelected && this.wasMouseOverStack && this.lastMouseOverStack != this.selectedStack && this.canStackBeSelected(this.lastMouseOverStack)) {
                    this.selectedStack = this.lastMouseOverStack;
                    this.onChange(this.selectedStack);
                }
                if (this.isSelected) {
                    this.isSelected = false;
                } else if (!this.availableStacks.isEmpty() || this.selectedStack != null) {
                    this.guiItem.getElementsList().bringToFront(this);
                    this.isSelected = true;
                }
            }
        }

        protected boolean canStackBeSelected(ItemStack itemStack) {
            return true;
        }

        protected abstract void onChange(ItemStack var1);

        protected class TempToolTip
        extends McItemToolTip {
            public TempToolTip(ItemStack itemStack) {
                super((IAdvancedGui)McSelectSlot.this.guiItem, McSelectSlot.this, itemStack);
            }

            @Override
            public void drawComponent(Point point, float f) {
                this.updateLines();
                this.forceDraw(point);
            }
        }
    }
}

