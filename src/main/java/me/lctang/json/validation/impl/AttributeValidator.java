/**
 * File Name:    AttributeValidator.java
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

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import me.lctang.json.validation.ErrorReport;
import me.lctang.json.validation.ValidationMode;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:lctang@yahoo.cn">Michael Tang</a>
 * @version 1.0
 */
public interface AttributeValidator {

    //void setSchema(JsonNode schema);

    //JsonNode getSchema();

    //void setErrorReporter(ErrorReporter errorReporter);

    void init(JsonNode schema);  //// TODO

    void setValidationMode(ValidationMode mode);

    ValidationMode getValidationMode();


    void validate(JsonNode attribute) throws BreakException;

    List<ErrorReport> getErrorReports();
}
