/////////////////////////////////////////////////////////////////////////////
//
// Project   ProjectForge
//
// Copyright 2001-2009, Micromata GmbH, Kai Reinhard
//           All rights reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.projectforge.common;

import junit.framework.Assert;

import org.junit.Test;
import org.projectforge.common.MimeType;

/**
 * @author Kai Reinhard (k.reinhard@micromata.de)
 * 
 */
public class MimeTypeTest
{
  @Test
  public void extensionTest()
  {
    Assert.assertNull(MimeType.getMimeType(null));
    Assert.assertNull(MimeType.getMimeType(""));
    Assert.assertNull(MimeType.getMimeType("file"));
    Assert.assertNull(MimeType.getMimeType("pdf"));
    Assert.assertNull(MimeType.getMimeType("pdf."));
    Assert.assertEquals(MimeType.PDF, MimeType.getMimeType(".pdf"));
    Assert.assertEquals(MimeType.PDF, MimeType.getMimeType("file.pdf"));
    Assert.assertEquals(MimeType.JPG, MimeType.getMimeType("picture.jpg"));
    Assert.assertEquals(MimeType.JPG, MimeType.getMimeType("picture.jpeg"));
  }
}
