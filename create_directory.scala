import java.io.File

  // create directory
  def createDir(path: String) = {
    val dir = new File(path)
    dir.mkdirs() match {
      case true => // created
        true
      case false if (new File(path).exists == true) => // already exists
        true
      case _ => // error
        false
    }
  }