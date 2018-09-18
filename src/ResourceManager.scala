import java.io.File;
object ResourceManager {
  def catagory(name: String) = name match {
    case name if name.endsWith("cpp") => name + " is Source File";
    case name if name.endsWith("exe") => name + " is Executable File";
    case name if name.endsWith("o") => name + " ends with O";
    case _ => name + " is a file";
  }

  def main(args: Array[String]): Unit = {
    val dir = "D:\\CCF";
    val files = (new File(dir)).listFiles;
    for (file <- files)
      println(catagory(file.getName));
  }
}
