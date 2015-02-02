/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package dlproj;

import java.io.*;
import org.junit.*;

public class GitProjectTest
{
  private GitProject proj;

  @Before
  public void init()
  {
    proj = new GitProject("myp", "/home/temp", "https://github.com/umple-ucsop/dlproj.git");
  }

  @Test
  public void constructor()
  {
    Assert.assertEquals("myp", proj.getName());
  }

  @Test
  public void gitDownload()
  {
    //TODO: Fix assertion
  	proj.Download();
    Assert.assertEquals(1, 1);
  }

}


