/**
 * File Name:    SchemaSyntaxChecker.java
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

import com.fasterxml.jackson.databind.JsonNode;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:lctang@yahoo.cn">Michael Tang</a>
 * @version 1.0
 */
public class SchemaSyntaxChecker {

    //private final Set<String> checked = new HashSet<String>();

    public void checkSchema(JsonNode schema) {

        Set<String> keywords = new HashSet<>();

        Iterator<String> fieldNameIterator = schema.fieldNames();
        while (fieldNameIterator.hasNext())
            keywords.add(fieldNameIterator.next());

        keywords.retainAll(Attributes.getAttributeNames());

        for (String keyword : keywords)
            Attributes.getAttribute(keyword)
                .getSyntaxChecker().checkAttribute(this, schema);
    }
}
