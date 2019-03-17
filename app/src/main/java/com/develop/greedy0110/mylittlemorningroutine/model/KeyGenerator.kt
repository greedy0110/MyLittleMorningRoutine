package com.develop.greedy0110.mylittlemorningroutine.model

import kotlin.random.Random

object KeyGenerator {
    private val memebers = "`1234567890-=qwertyuiop[]asdfghjkl;'zxcvbnm,./~!@#$%^&*()_+QWERTYUIOP{ASDFGHJKL:ZXCVBNM<>?".toCharArray()
    private val keyLength = 26

    fun getRandomKey(): String {
        var key = ""
        for (i in 0..keyLength) {
            key += memebers[Random.nextInt(0, memebers.size-1)]
        }
        return key
    }

}