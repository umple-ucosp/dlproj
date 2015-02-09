/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package dlproj;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.*;
import org.eclipse.jgit.api.*;
import org.eclipse.jgit.api.errors.*;

import com.jcraft.jsch.*;

public class DlprojMainTest
{
  
  @Before
  public void init()
  {
    Helper.cleanup();
  }
  
  @After
  public void teardown()
  {
    Helper.cleanup();
  }

  @Test
  public void gitDownload() throws IOException,GitAPIException
  {
    DlprojMain.main(new String[] { "-d", "./tmp", "umple-ucsop/umple.sample.downloader", "master" });
	  Assert.assertEquals(true, (new File("./tmp/umple-ucsop/umple.sample.downloader/master/README.md").exists()));
  }

}


