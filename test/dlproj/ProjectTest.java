/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package dlproj;

import java.io.*;
import org.junit.*;

public class ProjectTest
{

  @Test
  public void constructor()
  {
    Assert.assertEquals("myp", new Project("myp", "/home/temp").getName());
  }

}


