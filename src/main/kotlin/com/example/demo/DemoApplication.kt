package com.example.demo

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
@EnableConfigurationProperties(DemoProperties::class)
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

@ConfigurationProperties("demo")
class DemoProperties(val name: String?, val counter: Int = 42)

@Component
class DemoRunner(val properties: DemoProperties) : ApplicationRunner {

	override fun run(args: ApplicationArguments?) {
		println("Demo properties:")
		println("\t* name -> ${properties.name}")
		println("\t* counter -> ${properties.counter}")
	}

}


