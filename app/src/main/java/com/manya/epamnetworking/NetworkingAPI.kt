package com.manya.epamnetworking

import retrofit2.Call
import retrofit2.http.GET

/**
 *
 *  Simple Retrofit API with [GET] query which get jobs in London.
 *
 * @author Maria Kirdun
 */

interface NetworkingAPI {

    @GET("https://jobs.github.com/positions.json?description=java&location=london")
    public fun doGetJobs() : Call<List<Job>>
}