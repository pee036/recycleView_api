package com.example.recycleview

import android.content.Intent
import android.net.http.HttpException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recycleview.databinding.ActivityMainBinding
import com.example.recycleview.models.AllghostRadioList
import com.example.recycleview.models.Data
import com.example.recycleview.utils.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class MainActivity : AppCompatActivity() {

//    private  lateinit var recyclerView: RecyclerView
//    private  lateinit var youtubeList : ArrayList<youtube>
//    private  lateinit var youtubeAdapter: youtubeAdapter

    private lateinit var binding: ActivityMainBinding
    private  lateinit var youtubeAdapter: youtubeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch(Dispatchers.IO) {
            val response = try {
                RetrofitInstance.api.getListYoutube()
            } catch (e: IOException) {
                Toast.makeText(applicationContext, "app error ${e.message} ", Toast.LENGTH_SHORT).show()
                return@launch
            }  catch (e: HttpException) {
                Toast.makeText(applicationContext, "http error:${e.message} ", Toast.LENGTH_SHORT).show()
                return@launch
            }
            if (response.isSuccessful && response.body() != null){
                withContext(Dispatchers.Main){
                    val AllghostRadioList: List<Data> = response.body()!!.data
                    binding.apply {
                        youtubeAdapter = youtubeAdapter(AllghostRadioList)
                        recycleView1.adapter = youtubeAdapter
                        recycleView1.layoutManager = LinearLayoutManager(this@MainActivity)

                        youtubeAdapter.onItemClick = {
                            val intent = Intent(this@MainActivity, DetailActivity::class.java)
                            intent.putExtra("youtube",it )
                            startActivity(intent)
                        }
                    }
                }
            }
        }

//        recyclerView = findViewById(R.id.recycleView1)
//        recyclerView.setHasFixedSize(true)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        youtubeList = ArrayList()
//
//        youtubeList.add(youtube(R.drawable.ic_launcher_foreground, "tetetete"))
//        youtubeList.add(youtube(R.drawable.ic_launcher_foreground, "teterrrr"))
//        youtubeList.add(youtube(R.drawable.ic_launcher_foreground, "tevcvcvcete"))
//        youtubeList.add(youtube(R.drawable.ic_launcher_foreground, "tetfdfdete"))
//        youtubeList.add(youtube(R.drawable.ic_launcher_foreground, "tetefddfte"))
//        youtubeList.add(youtube(R.drawable.ic_launcher_foreground, "tetfddfdte"))
//
//        youtubeAdapter = youtubeAdapter(youtubeList)
//        recyclerView.adapter = youtubeAdapter
    }
}
