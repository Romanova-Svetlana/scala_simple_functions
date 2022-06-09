import java.util.Calendar
import java.io.PrintWriter
import scala.util.{Try,Success,Failure}

  val logPath = "" // absolute path to the log files directory

  // res - info, warn, error or other
  // mes - any message
  // file - save or not to file
  // err - bug report
  def log(res: String, msg: String, file: Boolean = false, err: List[Any] = List()) = {
    println(s"[$res] $msg")
    for (e <- err) println(s"[$res] $e")
    if (file == true) {
      val m = msg.take(50)
      val logFile = logPath + s"[$res] $m.txt"
      saveFile(logFile, List(s"[$res] $msg", dateTimeNow) ::: err)
    }
  }

  def dateTimeNow = Calendar.getInstance().getTime().toString

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
