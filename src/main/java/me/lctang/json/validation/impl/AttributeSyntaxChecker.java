/**
 * File Name:    AttributeSyntaxChecker.java
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
 * History:      7/5/12 created by 汤力丞
 */
package me.lctang.json.validation.impl;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:lctang@yahoo.cn">Michael Tang</a>
 * @version 1.0
 */
public interface AttributeSyntaxChecker {

    void checkAttribute(SchemaSyntaxChecker schemaSyntaxChecker,
                        JsonNode attributeNode);
}
