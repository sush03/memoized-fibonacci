package example

import scalacache.caffeine._
import scalacache._
import memoization._
import scalacache.modes.sync._
import language.postfixOps

object Memoization extends App {

  implicit val caffeineCache: Cache[Int] = CaffeineCache[Int]
  var countWithMemo, countWithoutMemo = 0

  def fibWithMemo(n: Int): Int = memoizeSync(None) {
    if (n <= 0) {
      0
    } else if (n == 1) {
      1
    } else {
      countWithMemo = countWithMemo + 1
      fibWithMemo(n - 1) + fibWithMemo(n - 2)
    }
  }

  def fibWithoutMemo(n: Int): Int = {
    if (n <= 0) {
      0
    } else if (n == 1) {
      1
    } else {
      countWithoutMemo = countWithoutMemo + 1
      fibWithoutMemo(n - 1) + fibWithoutMemo(n - 2)
    }
  }

  assert(fibWithoutMemo(7) == fibWithMemo(7))
  assert(countWithoutMemo == 20)  //function calls
  assert(countWithMemo == 6)

}

/*
ScalaCache provides different modes like Synchronous, Try, Future, cats-effect IO, etc.
The cache can be implemented in in-memory cache like Caffeine, Guava or over the network like Redis.

Here, the simple fibonacci (basic recursive approach) is being memoized with syncchronous mode and
the cache is implemented in Caffeine.
*/