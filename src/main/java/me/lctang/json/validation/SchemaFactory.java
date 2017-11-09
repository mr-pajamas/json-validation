/**
 * File Name:    SchemaFactory.java
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
 * History:      6/25/12 created by 汤力丞
 */
package me.lctang.json.validation;

import com.fasterxml.jackson.databind.JsonNode;
import me.lctang.json.validation.impl.SchemaImpl;
import me.lctang.json.validation.impl.SchemaSyntaxChecker;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:lctang@yahoo.cn">Michael Tang</a>
 * @version 1.0
 */
public class SchemaFactory {

    private static SchemaSyntaxChecker schemaSyntaxChecker =
        new SchemaSyntaxChecker();

    public static Schema newSchema(JsonNode schemaNode) {
        //return null;
        //Schema schema = new SchemaImpl(schemaNode, true);
        schemaSyntaxChecker.checkSchema(schemaNode);
        return new SchemaImpl(schemaNode);

    }
}
