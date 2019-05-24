package com.manya.epamnetworking

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.networking_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 *
 * Simple [Fragment] for get list of Jobs by [Retrofit] with [GsonConverterFactory] and display at the [RecyclerView].
 *
 * @author Maria Kirdun
 */
class NetworkingFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.networking_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewManager = LinearLayoutManager(activity)
        jobsRecyclerView.layoutManager = viewManager
        jobsRecyclerView.setHasFixedSize(true)

        search()
    }

    private fun search(){

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jobs.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val json = retrofit
            .create(NetworkingAPI::class.java)
            .doGetJobs()
            .enqueue( object : Callback<List<Job>?> {

                override fun onResponse(call: Call<List<Job>?>, response: Response<List<Job>?>) {
                    val jobs = response.body()
                    val viewAdapter = JobsRecyclerAdapter(jobs!!, activity!!.applicationContext)
                    jobsRecyclerView.adapter = viewAdapter

                }

                override fun onFailure(call: Call<List<Job>?>, t: Throwable) {
                    call.cancel()
                }
        })
    }


}
