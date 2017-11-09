/**
 * File Name:    ErrorReporter.java
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
 * History:      6/27/12 created by 汤力丞
 */
package me.lctang.json.validation.impl;

import java.util.List;

import me.lctang.json.validation.ErrorReport;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:lctang@yahoo.cn">Michael Tang</a>
 * @version 1.0
 */
public interface ErrorReporter {

    void setLocation(String location);

    String getLocation();

    void reportError(String message) throws BreakException;

    //void reportError(ErrorReport errorReport) throws BreakException;

    List<ErrorReport> getErrorReports();
}
