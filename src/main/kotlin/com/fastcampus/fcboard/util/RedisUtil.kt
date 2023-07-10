package com.fastcampus.fcboard.util

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class RedisUtil(
    private val redisTemplate: RedisTemplate<String, Any>,
) {
    fun setData(key: String, value: Any) {
        redisTemplate.opsForValue().set(key, value.toString())
    }

    fun getData(key: String): Any? {
        return redisTemplate.opsForValue().get(key)
    }

    fun increment(key: String) {
        redisTemplate.opsForValue().increment(key, 1L)
    }

    fun getCount(key: String): Long? {
        return redisTemplate.opsForValue().get(key)?.toString()?.toLong()
    }

    fun getLikeCountKey(postId: Long): String {
        return "like:$postId"
    }
}
