/////////////////////////////////////////////////////////////////////////////
//
// Project ProjectForge Community Edition
//         www.projectforge.org
//
// Copyright (C) 2001-2014 Kai Reinhard (k.reinhard@micromata.de)
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

/**
 * For being independent of the used logging framework. Different adapters are available: log4j and Java standard logging. You may implement
 * own adapters for other logging mechanisms.
 * 
 * @author Kai Reinhard (k.reinhard@micromata.de)
 * 
 */
public abstract class Logger
{
  private static Logger loggerBridge;

  /**
   * Must be initialized before any logging, otherwise the Java standard logging is used before.
   * @param loggerBridge the loggerBridge to set
   */
  public static void setLoggerBridge(final Logger loggerBridge)
  {
    Logger.loggerBridge = loggerBridge;
  }

  private static Logger getLoggerBridge()
  {
    if (loggerBridge == null) {
      loggerBridge = new LoggerBridgeJava();
    }
    return loggerBridge;
  }

  static public Logger getLogger(final Class< ? > clazz)
  {
    return getLoggerBridge().getInternalLogger(clazz);
  }

  public abstract boolean isDebugEnabled();

  public abstract void debug(Object message);

  public abstract void info(Object message);

  public abstract void warn(Object message);

  public abstract void error(Object message);

  public abstract void error(Object message, Throwable t);

  public abstract void fatal(Object message);

  public abstract void fatal(Object message, Throwable t);

  protected abstract Logger getInternalLogger(final Class< ? > clazz);
}
