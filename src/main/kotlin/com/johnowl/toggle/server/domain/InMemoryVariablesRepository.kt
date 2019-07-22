package com.johnowl.toggle.server.domain

import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentHashMap

@Repository
class InMemoryVariablesRepository : VariablesRepository {

    private val db = ConcurrentHashMap<String, Map<String, Any>>()

    override fun add(userId: String, variables: Map<String, Any>): Map<String, Any> {
        db[userId] = variables
        return variables
    }

    override fun getByUserId(userId: String) = db[userId]
}