/**
 * File Name:    Attributes.java
 *
 * File Desc:    TODO
 *
 * Product AB:   Spirit_1_0_0
 *
 * Product Name: Spirit
 *
 * Module Name:  TODO
 *
 * Module AB:    TODO
 *
 * Author:       汤力丞
 *
 * History:      6/26/12 created by 汤力丞
 */
package me.lctang.json.validation.impl;

import java.util.*;

import me.lctang.json.validation.impl.syntax.*;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:lctang@yahoo.cn">Michael Tang</a>
 * @version 1.0
 */
public final class Attributes {

    private static final Map<String, Attribute> ATTRIBUTE_MAP = new HashMap<>();

    static {
        String attributeName;
        AttributeSyntaxChecker checker;
        Attribute attribute;

        attributeName = "name";
        checker = new BasicAttributeSyntaxChecker(attributeName, NodeType.STRING);
        attribute = new Attribute(attributeName, checker, null);
        ATTRIBUTE_MAP.put(attributeName, attribute);

        attributeName = "description";
        checker = new BasicAttributeSyntaxChecker(attributeName, NodeType.STRING);
        attribute = new Attribute(attributeName, checker, null);
        ATTRIBUTE_MAP.put(attributeName, attribute);

        attributeName = "type";
        checker = new TypeSyntaxChecker();
        attribute = new Attribute(attributeName, checker, null); // TODO
        ATTRIBUTE_MAP.put(attributeName, attribute);

        attributeName = "properties";
        checker = new PropertiesSyntaxChecker();
        attribute = new Attribute(attributeName, checker, null); // TODO
        ATTRIBUTE_MAP.put(attributeName, attribute);

        /*
        attributeName = "additionalProperties";
        checker = new BasicAttributeSyntaxChecker(attributeName, NodeType.BOOLEAN);
        attribute = new Attribute(attributeName, checker, null);
        ATTRIBUTE_MAP.put(attributeName, attribute);
        */

        attributeName = "items";
        checker = new ItemsSyntaxChecker();
        attribute = new Attribute(attributeName, checker, null);
        ATTRIBUTE_MAP.put(attributeName, attribute);

        attributeName = "minItems";
        checker = new BasicAttributeSyntaxChecker(attributeName, NodeType.INTEGER);
        attribute = new Attribute(attributeName, checker, null);
        ATTRIBUTE_MAP.put(attributeName, attribute);

        attributeName = "maxItems";
        checker = new BasicAttributeSyntaxChecker(attributeName, NodeType.INTEGER);
        attribute = new Attribute(attributeName, checker, null);
        ATTRIBUTE_MAP.put(attributeName, attribute);

        attributeName = "uniqueItems";
        checker = new BasicAttributeSyntaxChecker(attributeName, NodeType.BOOLEAN);
        attribute = new Attribute(attributeName, checker, null);
        ATTRIBUTE_MAP.put(attributeName, attribute);

        attributeName = "nullable";
        checker = new BasicAttributeSyntaxChecker(attributeName, NodeType.BOOLEAN);
        attribute = new Attribute(attributeName, checker, null);
        ATTRIBUTE_MAP.put(attributeName, attribute);
    }

    public static Attribute getAttribute(String attributeName) {
        return ATTRIBUTE_MAP.get(attributeName);
    }

    public static Set<String> getAttributeNames() {
        return Collections.unmodifiableSet(ATTRIBUTE_MAP.keySet());
    }
}
