package com.github.algru.common.config

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ConfigurationSpec extends AnyWordSpec with Matchers {
  "Configuration trait" when {
    "read default application.conf" should {
      "get test parameter from entire config" in {
        val testConfig = new Configuration {}
        testConfig.config.getString("global-test.some-parameter") should be ("config-parameter-value")
      }
    }
    "read specific part of application.conf" should {
      "get test parameter from specific part of config" in {
        val testConfig = new Configuration {
          override lazy val baseName: Option[String] = Some("specific-test-config")
        }
        testConfig.config.getString("section.nested-parameter") should be ("nested-parameter-value")
      }
    }
  }
}
