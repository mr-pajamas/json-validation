/**
 * File Name:    TypeValidator.java
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
 * History:      8/2/12 created by 汤力丞
 */
package me.lctang.json.validation.impl.validators;

import java.util.EnumSet;

import com.fasterxml.jackson.databind.JsonNode;
import me.lctang.json.validation.impl.BreakException;
import me.lctang.json.validation.impl.NodeType;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:lctang@yahoo.cn">Michael Tang</a>
 * @version 1.0
 */
public class TypeValidator extends AbstractAttributeValidator {

    private EnumSet<NodeType> validTypes = EnumSet.noneOf(NodeType.class);

    public TypeValidator() {
        super(NodeType.values());
    }

    /*
    @Override
    public void init(JsonNode schema, ErrorReporter errorReporter) {
        super.init(schema, errorReporter);

        JsonNode node = this.schema.get("type");

        String typeValue = node.textValue();

        if ("any".equals(typeValue)) {
            validTypes.addAll(EnumSet.allOf(NodeType.class));
        } else {
            NodeType type = NodeType.forName(typeValue);
            validTypes.add(type);
            if (NodeType.NUMBER == type)
                validTypes.add(NodeType.INTEGER);
        }
    }
    */

    @Override
    protected void internalInit() {
        JsonNode node = schema.get("type");

        String typeValue = node.textValue();

        if ("any".equals(typeValue)) {
            validTypes.addAll(EnumSet.allOf(NodeType.class));
        } else {
            NodeType type = NodeType.forName(typeValue);
            validTypes.add(type);
            if (NodeType.NUMBER == type)
                validTypes.add(NodeType.INTEGER);
        }
    }

    @Override
    protected void validateInstance(JsonNode instance) throws BreakException {
        if (!validTypes.contains(NodeType.getNodeType(instance)))
            errorReporter.reportError("Instance does not match any allowed type");
    }
}
