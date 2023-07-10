package com.fastcampus.fcboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class FcBoardApplication

fun main(args: Array<String>) {
    runApplication<FcBoardApplication>(*args)
}
