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

import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * Implementation of java standard logger.
 * 
 * @author Kai Reinhard (k.reinhard@micromata.de)
 * 
 */
public class LoggerBridgeJava extends Logger
{
  private java.util.logging.Logger logger;

  private String sourceClass;

  public LoggerBridgeJava()
  {
  }

  public LoggerBridgeJava(final java.util.logging.Logger logger)
  {
    this.logger = logger;
  }

  /**
   * @see org.projectforge.common.Logger#isDebugEnabled()
   */
  @Override
  public boolean isDebugEnabled()
  {
    return logger.isLoggable(Level.FINE);
  }

  /**
   * @see org.projectforge.common.Logger#info(java.lang.Object)
   */
  @Override
  public void debug(final Object message)
  {
    log(Level.FINE, message);
  }

  /**
   * @see org.projectforge.common.Logger#info(java.lang.Object)
   * @see java.util.logging.Logger#info(String)
   */
  @Override
  public void info(final Object message)
  {
    log(Level.INFO, message);
  }

  /**
   * @see org.projectforge.common.Logger#warn(java.lang.Object)
   */
  @Override
  public void warn(final Object message)
  {
    log(Level.WARNING, message);
  }

  /**
   * @see org.projectforge.common.Logger#error(java.lang.Object)
   */
  @Override
  public void error(final Object message)
  {
    log(Level.WARNING, message);
  }

  /**
   * @see org.projectforge.common.Logger#error(java.lang.Object, java.lang.Throwable)
   */
  @Override
  public void error(final Object message, final Throwable t)
  {
    log(Level.WARNING, message, t);
  }

  /**
   * @see org.projectforge.common.Logger#fatal(java.lang.Object)
   */
  @Override
  public void fatal(final Object message)
  {
    log(Level.SEVERE, message);
  }

  /**
   * @see org.projectforge.common.Logger#fatal(java.lang.Object, java.lang.Throwable)
   */
  @Override
  public void fatal(final Object message, final Throwable t)
  {
    log(Level.SEVERE, message, t);
  }

  /**
   * @see org.projectforge.common.Logger#getInternalLogger(java.lang.String)
   */
  @Override
  protected Logger getInternalLogger(final Class< ? > clazz)
  {
    this.sourceClass = clazz.getName();
    return new LoggerBridgeJava(java.util.logging.Logger.getLogger(clazz.getName()));
  }

  private void log(final Level level, final Object message)
  {
    logger.log(level, message != null ? message.toString() : null);
  }

  private void log(final Level level, final Object message, final Throwable t)
  {
    final LogRecord logRecord = new LogRecord(level, message != null ? message.toString() : null);
    logRecord.setSourceClassName(this.sourceClass);
    if (t != null) {
      logRecord.setThrown(t);
    }
    logger.log(logRecord);
  }
}
