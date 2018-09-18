import scala.collection.mutable.ArrayBuffer
abstract class IntQueue {
  def get():Int
  def put(x:Int)
}
class BasicIntQueue extends IntQueue{
  private val buf =new ArrayBuffer[Int]
  def get()= buf.remove(0)
  def put(x:Int) { buf += x }
}
trait Doubling extends IntQueue{
  abstract override def put(x:Int) { super.put(2*x)}
}
trait Incrementing extends IntQueue{
  abstract override def put(x:Int) { super.put(x+1)}
}
trait Filtering extends IntQueue{
  abstract override def put (x:Int){
    if(x>=0) super.put(x)
  }
}

object trait1 {
  def main(args: Array[String]): Unit = {
    val queue1 = new BasicIntQueue with Doubling with Incrementing
    val queue2 = new BasicIntQueue with Incrementing  with Doubling
    val queue = new BasicIntQueue with Doubling with Incrementing with Filtering
    queue1.put(10)
    queue2.put(10)
    queue.put(-4)
    queue.put(10)
    queue.put(20)
    println(queue1.get())
    println(queue2.get())
    println(queue.get())
    println(queue.get())
  }
}
