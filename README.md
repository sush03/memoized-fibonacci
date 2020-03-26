ScalaCache provides different modes like Synchronous, Try, Future, cats-effect IO, etc.
The cache can be implemented in in-memory cache like Caffeine, Guava or over the network like Redis.

Here, the simple fibonacci (basic recursive approach) is being memoized with syncchronous mode and
the cache is implemented in Caffeine.
