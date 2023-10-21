package com.enescanpolat.sorucevap.data.datasource

import com.enescanpolat.sorucevap.domain.model.CompletionRequest
import com.enescanpolat.sorucevap.domain.model.CompletionResponse
import com.enescanpolat.sorucevap.util.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface OpenAiAPI {

    @Headers("Authorization: Bearer $API_KEY")
    @POST("v1/completions")
    suspend fun getCompletions(@Body completionRequest: CompletionRequest):Response<CompletionResponse>
}
//Failed to get response okhttp3.ResponseBody$Companion$asResponseBody$1@5f41276