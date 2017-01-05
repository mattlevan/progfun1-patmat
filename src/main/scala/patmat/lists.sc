def times(chars: List[Char]): List[(Char, Int)] = {
  def help(chars: List[Char], xs: List[(Char, Int)]): List[(Char, Int)] =
    chars match {
      case Nil => xs
      case h :: t =>
        if (xs.exists(p => p._1 == h)) help(t, xs)
        else help(t, count(h, 0, chars) :: xs)
    }

  def count(c: Char, freq: Int, chars: List[Char]): (Char, Int) =
    chars match {
      case Nil => (c, freq)
      case h :: t =>
        if (c == h) count(c, freq + 1, t)
        else count(c, freq, t)
    }

  help(chars, List())
}

val chars = List('a', 'a', 'a', 'a', 'b', 'c', 'd', 'd')
times(chars)

val xs = List(3, 4, 5)
val z = 1

z :: xs