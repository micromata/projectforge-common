/////////////////////////////////////////////////////////////////////////////
//
// Project ProjectForge Community Edition
//         www.projectforge.org
//
// Copyright (C) 2001-2013 Kai Reinhard (k.reinhard@micromata.de)
//
// ProjectForge is dual-licensed.
//
// This community edition is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License as published
// by the Free Software Foundation; version 3 of the License.
//
// This community edition is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
// Public License for more details.
//
// You should have received a copy of the GNU General Public License along
// with this program; if not, see http://www.gnu.org/licenses/.
//
/////////////////////////////////////////////////////////////////////////////

package org.projectforge.common;

import org.junit.Test;

public class LoggerTest
{
  @Test
  public void testJavaLogging() {
    Logger.setLoggerBridge(new LoggerBridgeJava());
    doLog();
  }

  @Test
  public void testLog4j() {
    Logger.setLoggerBridge(new LoggerBridgeLog4j());
    doLog();
  }

  private void doLog() {
    final Logger log = Logger.getLogger(LoggerTest.class);
    if (log.isDebugEnabled() == true) {
      log.debug("Debug message 1");
    }
    log.debug("Debug message 2");
    log.info("Info message");
    log.warn("Warning message");
    log.error("Error message");
    log.error("Error message", new RuntimeException("This is a test exception"));
    log.fatal("Fatal test message");
    log.fatal("Fatal test message with test exception", new RuntimeException("This is a test exception"));
  }
}
