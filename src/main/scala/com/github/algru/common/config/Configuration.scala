package com.github.algru.common.config

import com.typesafe.config.{Config, ConfigFactory}

trait Configuration {
  lazy val baseName: Option[String] = None
  val config: Config = baseName match {
    case Some(configPath) => ConfigFactory.load().getConfig(configPath)
    case None => ConfigFactory.load()
  }
}
