package com.example.todostud.feature_note.domain.util

sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
}
