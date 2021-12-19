package io.ipolyzos.models

import kotlinx.serialization.*

@Serializable
data class ClickEvent(val eventTime: Long,
                      val eventType: String,
                      val productId: Long,
                      val categoryId: Long,
                      val categoryCode: String,
                      val brand: String,
                      val price: String,
                      val userId: Long,
                      val userSession: String)