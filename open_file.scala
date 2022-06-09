import scala.io.Source

  // reading data from a file
  def openFile(path: String, out: String = "") = try {
      val source = Source.fromFile(path, "UTF-8")
      val data = out match {
        case "s" => List(source.mkString)
        case _ => source.getLines.toList
      }
      Success(data)
    } catch {
      case err : Throwable => Failure(err)
  }