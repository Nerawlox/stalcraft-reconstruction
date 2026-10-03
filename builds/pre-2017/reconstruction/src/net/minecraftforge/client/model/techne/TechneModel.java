/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.model.techne;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.ModelFormatException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@SideOnly(value=Side.CLIENT)
public class TechneModel
extends ModelBase
implements IModelCustom {
    public static final List<String> cubeTypes = Arrays.asList("d9e621f7-957f-4b77-b1ae-20dcd0da7751", "de81aa14-bd60-4228-8d8d-5238bcd3caaa");
    private String fileName;
    private Map<String, byte[]> zipContents = new HashMap<String, byte[]>();
    private Map<String, ModelRenderer> parts = new LinkedHashMap<String, ModelRenderer>();
    private String texture = null;
    private int textureName;
    private boolean textureNameSet = false;

    public TechneModel(String string, URL uRL) throws ModelFormatException {
        this.fileName = string;
        this.loadTechneModel(uRL);
    }

    private void loadTechneModel(URL uRL) throws ModelFormatException {
        try {
            byte[] byArray;
            ZipEntry zipEntry;
            ZipInputStream zipInputStream = new ZipInputStream(uRL.openStream());
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                byArray = new byte[(int)zipEntry.getSize()];
                int n = 0;
                while (zipInputStream.available() > 0 && n < byArray.length) {
                    byArray[n++] = (byte)zipInputStream.read();
                }
                this.zipContents.put(zipEntry.getName(), byArray);
            }
            byArray = this.zipContents.get("model.xml");
            if (byArray == null) {
                throw new ModelFormatException("Model " + this.fileName + " contains no model.xml file");
            }
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new ByteArrayInputStream(byArray));
            NodeList nodeList = document.getElementsByTagName("Techne");
            if (nodeList.getLength() < 1) {
                throw new ModelFormatException("Model " + this.fileName + " contains no Techne tag");
            }
            NodeList nodeList2 = document.getElementsByTagName("Model");
            if (nodeList2.getLength() < 1) {
                throw new ModelFormatException("Model " + this.fileName + " contains no Model tag");
            }
            NamedNodeMap namedNodeMap = nodeList2.item(0).getAttributes();
            if (namedNodeMap == null) {
                throw new ModelFormatException("Model " + this.fileName + " contains a Model tag with no attributes");
            }
            Node node = namedNodeMap.getNamedItem("texture");
            if (node != null) {
                this.texture = node.getTextContent();
            }
            NodeList nodeList3 = document.getElementsByTagName("Shape");
            for (int i = 0; i < nodeList3.getLength(); ++i) {
                Node node2 = nodeList3.item(i);
                NamedNodeMap namedNodeMap2 = node2.getAttributes();
                if (namedNodeMap2 == null) {
                    throw new ModelFormatException("Shape #" + (i + 1) + " in " + this.fileName + " has no attributes");
                }
                Node node3 = namedNodeMap2.getNamedItem("name");
                String string = null;
                if (node3 != null) {
                    string = node3.getNodeValue();
                }
                if (string == null) {
                    string = "Shape #" + (i + 1);
                }
                String string2 = null;
                Node node4 = namedNodeMap2.getNamedItem("type");
                if (node4 != null) {
                    string2 = node4.getNodeValue();
                }
                if (string2 != null && !cubeTypes.contains(string2)) {
                    FMLLog.warning("Model shape [" + string + "] in " + this.fileName + " is not a cube, ignoring", new Object[0]);
                    continue;
                }
                try {
                    boolean bl = false;
                    String[] stringArray = new String[3];
                    String[] stringArray2 = new String[3];
                    String[] stringArray3 = new String[3];
                    String[] stringArray4 = new String[3];
                    String[] stringArray5 = new String[2];
                    NodeList nodeList4 = node2.getChildNodes();
                    for (int j = 0; j < nodeList4.getLength(); ++j) {
                        Node node5 = nodeList4.item(j);
                        String string3 = node5.getNodeName();
                        String string4 = node5.getTextContent();
                        if (string4 == null) continue;
                        string4 = string4.trim();
                        if (string3.equals("IsMirrored")) {
                            bl = !string4.equals("False");
                            continue;
                        }
                        if (string3.equals("Offset")) {
                            stringArray = string4.split(",");
                            continue;
                        }
                        if (string3.equals("Position")) {
                            stringArray2 = string4.split(",");
                            continue;
                        }
                        if (string3.equals("Rotation")) {
                            stringArray3 = string4.split(",");
                            continue;
                        }
                        if (string3.equals("Size")) {
                            stringArray4 = string4.split(",");
                            continue;
                        }
                        if (!string3.equals("TextureOffset")) continue;
                        stringArray5 = string4.split(",");
                    }
                    ModelRenderer modelRenderer = new ModelRenderer(this, Integer.parseInt(stringArray5[0]), Integer.parseInt(stringArray5[1]));
                    modelRenderer.mirror = bl;
                    modelRenderer.addBox(Float.parseFloat(stringArray[0]), Float.parseFloat(stringArray[1]), Float.parseFloat(stringArray[2]), Integer.parseInt(stringArray4[0]), Integer.parseInt(stringArray4[1]), Integer.parseInt(stringArray4[2]));
                    modelRenderer.setRotationPoint(Float.parseFloat(stringArray2[0]), Float.parseFloat(stringArray2[1]) - 23.4f, Float.parseFloat(stringArray2[2]));
                    modelRenderer.rotateAngleX = (float)Math.toRadians(Float.parseFloat(stringArray3[0]));
                    modelRenderer.rotateAngleY = (float)Math.toRadians(Float.parseFloat(stringArray3[1]));
                    modelRenderer.rotateAngleZ = (float)Math.toRadians(Float.parseFloat(stringArray3[2]));
                    this.parts.put(string, modelRenderer);
                    continue;
                }
                catch (NumberFormatException numberFormatException) {
                    FMLLog.warning("Model shape [" + string + "] in " + this.fileName + " contains malformed integers within its data, ignoring", new Object[0]);
                    numberFormatException.printStackTrace();
                }
            }
        }
        catch (ZipException zipException) {
            throw new ModelFormatException("Model " + this.fileName + " is not a valid zip file");
        }
        catch (IOException iOException) {
            throw new ModelFormatException("Model " + this.fileName + " could not be read", iOException);
        }
        catch (ParserConfigurationException parserConfigurationException) {
        }
        catch (SAXException sAXException) {
            throw new ModelFormatException("Model " + this.fileName + " contains invalid XML", sAXException);
        }
    }

    private void bindTexture() {
    }

    @Override
    public String getType() {
        return "tcn";
    }

    @Override
    public void renderAll() {
        this.bindTexture();
        for (ModelRenderer modelRenderer : this.parts.values()) {
            modelRenderer.renderWithRotation(1.0f);
        }
    }

    @Override
    public void renderPart(String string) {
        ModelRenderer modelRenderer = this.parts.get(string);
        if (modelRenderer != null) {
            this.bindTexture();
            modelRenderer.renderWithRotation(1.0f);
        }
    }

    @Override
    public void renderOnly(String ... stringArray) {
        this.bindTexture();
        for (ModelRenderer modelRenderer : this.parts.values()) {
            for (String string : stringArray) {
                if (!string.equalsIgnoreCase(modelRenderer.boxName)) continue;
                modelRenderer.render(1.0f);
            }
        }
    }

    @Override
    public void renderAllExcept(String ... stringArray) {
        for (ModelRenderer modelRenderer : this.parts.values()) {
            boolean bl = false;
            for (String string : stringArray) {
                if (!string.equalsIgnoreCase(modelRenderer.boxName)) continue;
                bl = true;
            }
            if (bl) continue;
            modelRenderer.render(1.0f);
        }
    }
}

