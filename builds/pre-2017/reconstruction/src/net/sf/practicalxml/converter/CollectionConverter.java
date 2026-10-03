/*
 * Decompiled with CFR 0.152.
 */
package net.sf.practicalxml.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import net.sf.practicalxml.DomUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class CollectionConverter {
    public static Document convertToXml(Map<String, ?> map, String string, String ... stringArray) {
        Element element = DomUtil.newDocument(string);
        CollectionConverter.appendElements(map, element, CollectionConverter.digestFilter(stringArray));
        return element.getOwnerDocument();
    }

    public static Document convertToXml(Map<String, ?> map, QName qName, String ... stringArray) {
        Element element = DomUtil.newDocument(qName);
        CollectionConverter.appendElements(map, element, CollectionConverter.digestFilter(stringArray));
        return element.getOwnerDocument();
    }

    public static Map<String, ?> convertToMap(Element element, String ... stringArray) {
        return CollectionConverter.convertToMap(element, CollectionConverter.digestFilter(stringArray));
    }

    public static List<Map<String, ?>> convertToMap(List<Element> list, String ... stringArray) {
        ArrayList arrayList = new ArrayList(list.size());
        Set<String> set = CollectionConverter.digestFilter(stringArray);
        for (Element element : list) {
            arrayList.add(CollectionConverter.convertToMap(element, set));
        }
        return arrayList;
    }

    private static Set<String> digestFilter(String ... stringArray) {
        if (stringArray.length == 0) {
            return null;
        }
        HashSet<String> hashSet = new HashSet<String>();
        for (String string : stringArray) {
            hashSet.add(string);
        }
        return hashSet;
    }

    public static Map<String, ?> convertToMap(Element element, Set<String> set) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (Element element2 : DomUtil.getChildren(element)) {
            CollectionConverter.appendChild(hashMap, element2, set);
        }
        return hashMap;
    }

    private static void appendChild(Map<String, Object> map, Element element, Set<String> set) {
        String string = DomUtil.getLocalName(element);
        if (set != null && !set.contains(string)) {
            return;
        }
        Object object = CollectionConverter.getChildValue(element, set);
        if (!map.containsKey(string)) {
            map.put(string, object);
            return;
        }
        Object object2 = map.get(string);
        if (object2 instanceof List) {
            List list = (List)object2;
            list.add(object);
        } else {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            arrayList.add(object2);
            arrayList.add(object);
            map.put(string, arrayList);
        }
    }

    private static Object getChildValue(Element element, Set<String> set) {
        if (DomUtil.hasElementChildren(element)) {
            return CollectionConverter.convertToMap(element, set);
        }
        return DomUtil.getText(element);
    }

    private static void appendElements(Map<String, ?> map, Element element, Set<String> set) {
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String string = entry.getKey();
            if (set != null && !set.contains(string)) continue;
            Object obj = entry.getValue();
            CollectionConverter.appendElement(element, string, obj, set);
        }
    }

    private static void appendElement(Element element, String string, Object object, Set<String> set) {
        block3: {
            block6: {
                block5: {
                    block4: {
                        block2: {
                            if (object != null) break block2;
                            DomUtil.appendChildInheritNamespace(element, string);
                            break block3;
                        }
                        if (!(object instanceof String)) break block4;
                        Element element2 = DomUtil.appendChildInheritNamespace(element, string);
                        DomUtil.setText(element2, (String)object);
                        break block3;
                    }
                    if (!(object instanceof Map)) break block5;
                    Element element3 = DomUtil.appendChildInheritNamespace(element, string);
                    CollectionConverter.appendElements((Map)object, element3, set);
                    break block3;
                }
                if (!(object instanceof Collection)) break block6;
                for (Object e : (Collection)object) {
                    CollectionConverter.appendElement(element, string, e, set);
                }
                break block3;
            }
            if (!object.getClass().isArray()) break block3;
            for (Object object2 : (Object[])object) {
                CollectionConverter.appendElement(element, string, object2, set);
            }
        }
    }
}

