/**
 * File Name:    ErrorReporterFactory.java
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
 * History:      6/28/12 created by 汤力丞
 */
package me.lctang.json.validation.impl;

import java.util.*;

import me.lctang.json.validation.ErrorReport;
import me.lctang.json.validation.ValidationMode;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:lctang@yahoo.cn">Michael Tang</a>
 * @version 1.0
 */
public class ErrorReporterFactory {

    static ErrorReporter newErrorReporter(ValidationMode mode, String location) {
        ErrorReporter reporter;
        if (mode == ValidationMode.FAIL_FAST)
            reporter = new FailFastErrorReporter();
        else
            reporter = new ForgivingErrorReporter();
        reporter.setLocation(location);
        return reporter;
    }

    private static abstract class AbstractErrorReporter implements ErrorReporter {

        private String location;

        protected List<ErrorReport> errorReports = new LinkedList<ErrorReport>();

        /*
        @Override
        public void handleError(String location, String message)
            throws BreakException {
            handleError(new ErrorReport(location, message));
        }

        @Override
        public abstract void handleError(ErrorReport errorReport)
            throws BreakException;
        */

        @Override
        public void setLocation(String location) {
            this.location = location;
        }

        @Override
        public String getLocation() {
            return location;
        }

        @Override
        public void reportError(String message) throws BreakException {
            handleError(new ErrorReport(location, message));
        }

        protected abstract void handleError(ErrorReport errorReport)
            throws BreakException;

        @Override
        public List<ErrorReport> getErrorReports() {
            return Collections.unmodifiableList(errorReports);
        }
    }

    private static class FailFastErrorReporter extends AbstractErrorReporter {

        @Override
        public void handleError(ErrorReport errorReport)
            throws BreakException {
            errorReports.add(errorReport);
            throw new BreakException();
        }
    }

    private static class ForgivingErrorReporter extends AbstractErrorReporter {

        @Override
        public void handleError(ErrorReport errorReport)
            throws BreakException {
            errorReports.add(errorReport);
        }
    }
}
