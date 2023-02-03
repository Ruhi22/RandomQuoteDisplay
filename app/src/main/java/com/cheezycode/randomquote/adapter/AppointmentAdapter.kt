package com.cheezycode.randomquote.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cheezycode.randomquote.R
import com.cheezycode.randomquote.models.Data
import com.squareup.picasso.Picasso

class AppointmentAdapter(private val mList: List<Data>, context: Context) : RecyclerView.Adapter<AppointmentAdapter.ViewHolder>() {

    var ctx = context
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        val lowerPatientImage: String = ItemsViewModel.patientImage.toLowerCase()
        val resource = "R.drawable.$lowerPatientImage"
        //holder.imageView.setImageResource(resource.toInt())

        Picasso.with(ctx).load(lowerPatientImage).into(holder.imageView)

        // sets the text to the textview from our itemHolder class
        holder.tv_name.text = ItemsViewModel.Name
        holder.tv_location.text = ItemsViewModel.city
        holder.tv_date.text = ItemsViewModel.date
        holder.tv_time.text = ItemsViewModel.time

        if(!ItemsViewModel.appointmentID.isNullOrEmpty() || !ItemsViewModel.appointmentID.isNullOrBlank()){
            holder.tv_confirmation.text = "Confirmed"
        } else {
            holder.tv_confirmation.text = "Not Confirmed"
        }


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val tv_name: TextView = itemView.findViewById(R.id.tv_name)
        val tv_location: TextView = itemView.findViewById(R.id.tv_location)
        val tv_date: TextView = itemView.findViewById(R.id.tv_date)
        val tv_time: TextView = itemView.findViewById(R.id.tv_time)
        val tv_confirmation: TextView = itemView.findViewById(R.id.tv_confirmation)
    }
}
