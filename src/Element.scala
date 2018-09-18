import Elem.elem
abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int =  contents(0).length
  def above(that: Element) :Element = {
    val this1=this widen that.width
    val that1=that widen this.width
    elem (this1.contents ++ that1.contents)
  }
  def beside(that: Element) :Element = {
    val this1=this heighten that.height
    val that1=that heighten this.height
    Elem.elem(
      for(
        (line1,line2) <- this1.contents zip that1.contents
      ) yield line1+line2
    )
  }
  def widen(w: Int): Element =
    if (w <= width) this
    else {
      val left = Elem.elem(' ', (w - width) / 2, height)
      var right = Elem.elem(' ', w - width - left.width, height)
      left beside this beside right
    }
  def heighten(h: Int): Element =
    if (h <= height) this
    else {
      val top = Elem.elem(' ', width, (h - height) / 2)
      var bot = Elem.elem(' ', width, h - height - top.height)
      top above this above bot
    }
  override def toString = contents mkString "\n"
}

