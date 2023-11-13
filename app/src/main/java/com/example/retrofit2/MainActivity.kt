package com.example.retrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit2.Model.dataModel
import com.example.retrofit2.Network.ApiClient
import com.example.retrofit2.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client =ApiClient.getInstance()
        val response = client.getCharacters()
        val rickName = ArrayList<String>()

        response.enqueue(object : Callback<dataModel> {
            override fun onResponse(call: Call<dataModel>, response: Response<dataModel>) {
                if (response.isSuccessful) {
                    val responseRick = response.body()
                    val dataModels = responseRick?.result
                    val recylceRick = RickAdapter(dataModels)
                    binding.rvRick.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        recylceRick.notifyDataSetChanged()
                        adapter = recylceRick
                    }
                }
            } override fun onFailure(call: Call<dataModel>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Koneksi error",
                    Toast.LENGTH_LONG).show()
            }
        })
    }
}