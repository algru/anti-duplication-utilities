package com.github.algru.common.exception.util

import org.scalamock.scalatest.MockFactory
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.slf4j.Logger

class ExceptionThrowerSpec extends AnyWordSpec with Matchers with MockFactory {
  val mockLogger = mock[Logger]

  "ExceptionThrower" should {
    "throw an exception and log.error" in {
      an[Exception] should be thrownBy {
        (mockLogger.error(_: String, _: Throwable)).expects("error message", *).once()
        ExceptionThrower.throwAndLog("error message", classOf[Exception], mockLogger)
      }
    }
  }
}
