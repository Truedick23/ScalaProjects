import scala.io._
import java.io._
object CPW {
  def withPrintWriter (file: File)( op: PrintWriter => Unit) {
    val writer=new PrintWriter(file)
    try{
      op(writer)
    }finally{
      writer.close()
    }
  }

  def main(args: Array[String]): Unit = {
    val file = new File("date.txt")
    withPrintWriter(file){
      writer => writer.println(new java.util.Date)
    }
  }
}

