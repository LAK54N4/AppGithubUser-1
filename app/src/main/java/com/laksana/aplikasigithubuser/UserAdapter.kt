package com.laksana.aplikasigithubuser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(private val userList: ArrayList<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    var listener: OnItemClickCallback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.item_user, parent, false)

        return this.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userList[position])

        holder.itemView.setOnClickListener {
            listener!!.onItemClicked(position)
        }
    }

    override fun getItemCount(): Int = userList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgAvatar = itemView.img_avatar as ImageView
        private val tvUserName = itemView.tv_username as TextView
        private val tvName = itemView.tv_name as TextView

        fun bind(items: User) {
            tvUserName.text = items.username
            tvName.text = items.name
            imgAvatar.setImageResource(items.avatar)
        }
    }
}



