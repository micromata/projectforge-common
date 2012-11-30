package org.projectforge.shared.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

/////////////////////////////////////////////////////////////////////////////
//
// Project ProjectForge Community Edition
//         www.projectforge.org
//
// Copyright (C) 2001-2012 Kai Reinhard (k.reinhard@micromata.com)
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

/**
 * Some helper methods used by different packages of ProjectForge.
 * @author Kai Reinhard (k.reinhard@micromata.de)
 * 
 */
public class StorageUtils
{
  private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(StorageUtils.class);

  public static void writeDefaultStorageConfig(final File file, final String authenticationToken)
  {
    FileWriter writer = null;
    try {
      writer = new FileWriter(file);
      writer.append(authenticationToken);
    } catch (final IOException ex) {
      final String msg = "Error while writing '" + file.getAbsolutePath() + "': " + ex.getMessage();
      log.error(msg, ex);
      throw new RuntimeException(msg);
    } finally {
      IOUtils.closeQuietly(writer);
    }
  }

  public static String readDefaultStorageConfig(final File file)
  {
    FileReader reader = null;
    try {
      reader = new FileReader(file);
      final String authenticationToken = IOUtils.toString(reader);
      return authenticationToken != null ? authenticationToken.trim() : null;
    } catch (final FileNotFoundException ex) {
      final String msg = "Error while reading '" + file.getAbsolutePath() + "': " + ex.getMessage();
      log.error(msg, ex);
      throw new RuntimeException(msg);
    } catch (final IOException ex) {
      final String msg = "Error while reading '" + file.getAbsolutePath() + "': " + ex.getMessage();
      log.error(msg, ex);
      throw new RuntimeException(msg);
    } finally {
      IOUtils.closeQuietly(reader);
    }
  }
}
