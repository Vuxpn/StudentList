import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bai3.R
import com.example.bai3.Student

class StudentAdapter(private var studentList: List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    // ViewHolder class to hold references to each view in the item layout
    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvMSSV: TextView = itemView.findViewById(R.id.tvMSSV)
    }

    // Inflate the item layout and create the ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    // Bind data to the views in each item
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]
        holder.tvName.text = student.name
        holder.tvMSSV.text = student.mssv
    }

    // Return the total count of items
    override fun getItemCount(): Int = studentList.size

    // Method to update the list for search filtering
    fun updateList(newList: List<Student>) {
        studentList = newList
        notifyDataSetChanged()
    }
}
