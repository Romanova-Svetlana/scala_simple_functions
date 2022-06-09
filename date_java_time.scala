import java.time.{LocalDate, LocalTime}
import scala.util.{Try,Success,Failure}

object DateTime {

  def dateNow = LocalDate.now.toString
  def dateTimeNow = LocalDate.now.toString + " " + LocalTime.now.toString

  // convert string to date type
  def dateParse(date: String): Try[java.time.LocalDate] = 
    try {
      val d = LocalDate.parse(date); 
      Success(d) 
    } catch {
      case err : Throwable => Failure(err)
    }

  // change the date to the desired number of days
  def datePlus(date: java.time.LocalDate, days: Int) = date.plusDays(days).toString

}