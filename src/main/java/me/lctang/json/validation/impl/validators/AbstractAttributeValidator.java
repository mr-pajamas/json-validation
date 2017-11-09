/**
 * File Name:    AbstractAttributeValidator.java
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

import java.util.*;

import com.fasterxml.jackson.databind.JsonNode;
import me.lctang.json.validation.ErrorReport;
import me.lctang.json.validation.impl.*;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:lctang@yahoo.cn">Michael Tang</a>
 * @version 1.0
 */
public abstract class AbstractAttributeValidator implements AttributeValidator {

    protected JsonNode schema;
    protected ErrorReporter errorReporter;

    private EnumSet<NodeType> instanceTypes = EnumSet.noneOf(NodeType.class);

    private boolean initialized = false;


    protected AbstractAttributeValidator(NodeType... instanceTypes) {
        Collections.addAll(this.instanceTypes, instanceTypes);
    }

    /*
    @Override
    public void setSchema(JsonNode schema) {
        this.schema = schema;
    }

    @Override
    public JsonNode getSchema() {
        return schema;
    }

    @Override
    public void setErrorReporter(ErrorReporter errorReporter) {
        this.errorReporter = errorReporter;
    }

    @Override
    public ErrorReporter getErrorReporter() {
        return errorReporter;
    }
    */

    @Override
    public final void init(JsonNode schema, ErrorReporter errorReporter) {
        this.schema = schema;
        this.errorReporter = errorReporter;
        internalInit();
        initialized = true;
    }

    protected abstract void internalInit();

    @Override
    public List<ErrorReport> getErrorReports() {
        return errorReporter.getErrorReports();
    }

    @Override
    public void validate(JsonNode attribute) throws BreakException {
        if (!initialized)
            throw new IllegalStateException("Validator not initialized");
        if (instanceTypes.contains(NodeType.getNodeType(attribute)))
            validateInstance(attribute);
    }

    protected abstract void validateInstance(JsonNode instance)
        throws BreakException;
}
