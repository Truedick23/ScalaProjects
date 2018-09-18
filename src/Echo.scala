object Echo {
  def echo (args: String *) =
    for (arg <- args) println(arg);

  def main(args: Array[String]): Unit = {
    val arr = Array("Zhang Shuai", "and", "De Xi", "are", "motherfucking pussies");
    val agree = "Agreed";
    echo(arr: _*);
    echo(agree);
  }
}
