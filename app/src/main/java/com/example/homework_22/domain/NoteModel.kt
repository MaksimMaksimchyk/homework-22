package com.example.homework_22.domain

import java.util.Date

class NoteModel(
    val id: Long = System.currentTimeMillis(),
    val content: String,
    val createdAt: Date = Date()
)