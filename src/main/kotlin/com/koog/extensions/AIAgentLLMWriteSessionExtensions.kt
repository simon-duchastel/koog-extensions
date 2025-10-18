package com.koog.extensions

import com.jetbrains.ai.api.AIAgentLLMWriteSession
import com.jetbrains.ai.api.LLModel

/**
 * Temporarily changes the model for the duration of the block execution.
 * Restores the original model after the block completes.
 */
suspend fun AIAgentLLMWriteSession.withModel(model: LLModel, block: suspend AIAgentLLMWriteSession.() -> Unit) {
    val originalModel = this.model
    changeModel(model)
    block()
    changeModel(originalModel)
}
