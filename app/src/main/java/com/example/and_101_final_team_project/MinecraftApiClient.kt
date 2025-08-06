package com.example.and_101_final_team_project

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

suspend fun fetchMinecraftItems(): List<MinecraftItem> {
    return withContext(Dispatchers.IO) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://minecraft-api.vercel.app/api/items")
            .get()
            .build()

        try {
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                val responseBody = response.body?.string()
                val gson = Gson()

                val listType = object : com.google.gson.reflect.TypeToken<List<MinecraftItem>>() {}.type

                return@withContext gson.fromJson(responseBody, listType)
            }
        } catch (e: Exception) {
            return@withContext emptyList<MinecraftItem>()
        }
    }
}