/**
 * File Name:    PropertiesValidator.java
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
 * History:      8/3/12 created by 汤力丞
 */
package me.lctang.json.validation.impl.validators;

import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import me.lctang.json.validation.impl.BreakException;
import me.lctang.json.validation.impl.NodeType;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:lctang@yahoo.cn">Michael Tang</a>
 * @version 1.0
 */
public class PropertiesValidator extends AbstractAttributeValidator {



    public PropertiesValidator() {
        super(NodeType.OBJECT);
    }

    @Override
    protected void internalInit() {
        Iterator<Map.Entry<String, JsonNode>> fields =
            schema.get("properties").fields();

        //Map<String, JsonNode> map = new HashMap<String, JsonNode>();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> entry = fields.next();
        }
    }

    @Override
    protected void validateInstance(JsonNode instance) throws BreakException {
        // TODO
    }
}
