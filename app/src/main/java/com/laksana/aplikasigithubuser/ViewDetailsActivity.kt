package com.laksana.aplikasigithubuser

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class ViewDetailsActivity: AppCompatActivity() {
    companion object {
        const val EXTRA_USER = "username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_user)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.title = "Detail User"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val detailsUsername: TextView = findViewById(R.id.details_username)
        val detailsName: TextView = findViewById(R.id.details_name)
        val avatar: ImageView = findViewById(R.id.details_img_avatar)
        val location: TextView = findViewById(R.id.details_location)
        val repository: TextView = findViewById(R.id.details_repository)
        val followers: TextView = findViewById(R.id.details_followers)
        val following: TextView = findViewById(R.id.details_following)
        val company: TextView = findViewById(R.id.details_company)

        val data = intent.getParcelableExtra(EXTRA_USER) as User

        detailsUsername.text = data.username
        detailsName.text = data.name
        avatar.setImageResource(data.avatar)
        location.text = data.location
        repository.text = data.repository.toString()
        followers.text = data.followers.toString()
        following.text = data.following.toString()
        company.text = data.company
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}