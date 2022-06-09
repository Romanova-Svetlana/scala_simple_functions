import java.io.PrintWriter
import scala.util.{Try,Success,Failure}

  // saving data to a file on disk
  def saveFile[T](path: String, text: List[T]) = try { 
      val out = new PrintWriter(path) 
      try {
        for (t <- text) out.println(t)
        Success(path)
      } catch {
        case err : Throwable => Failure(err)
      } finally { 
        out.close() 
      }
    } catch {
      case err : Throwable => Failure(err)
    }