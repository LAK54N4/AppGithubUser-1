package com.laksana.aplikasigithubuser

import android.content.Intent
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), OnItemClickCallback {

    private var items: ArrayList<User> = arrayListOf()
    private var adapter = UserAdapter(items)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listName = findViewById<RecyclerView>(R.id.rv_listName)
        initData()

        adapter.listener = this
        listName.layoutManager = LinearLayoutManager(this)
        listName.adapter = adapter
    }

    private fun initData() {
        val userName = resources.getStringArray(R.array.username)
        val name = resources.getStringArray(R.array.name)
        val avatar = resources.obtainTypedArray(R.array.avatar)
        val location = resources.getStringArray(R.array.location)
        val company = resources.getStringArray(R.array.company)
        val repository = resources.obtainTypedArray(R.array.repository)
        val followers = resources.obtainTypedArray(R.array.followers)
        val following = resources.obtainTypedArray(R.array.following)

        items.clear()

        for (position in userName.indices) {
            items.add(User(
                userName[position],
                name[position],
                location[position],
                repository.getInt(position,0),
                company[position],
                followers.getInt(position, 0),
                following.getInt(position, 0),
                avatar.getResourceId(position,-1)))
        }
        avatar.recycle()
        repository.recycle()
        followers.recycle()
        following.recycle()
    }

    override fun onItemClicked(position: Int) {
        val moveViewDetail = Intent (this@MainActivity, ViewDetailsActivity::class.java)
        moveViewDetail.putExtra(ViewDetailsActivity.EXTRA_USER, items[position])
        startActivity(moveViewDetail)
    }
}
