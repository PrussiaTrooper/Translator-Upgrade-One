package geekbrains.ru.history.view.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import geekbrains.ru.history.R
import geekbrains.ru.model.data.userdata.Result
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_history_recyclerview_item.view.*

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.RecyclerItemViewHolder>() {

    private var data: List<Result> = arrayListOf()

    fun setData(data: List<Result>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemViewHolder {
        return RecyclerItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_history_recyclerview_item, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: RecyclerItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    //ViewHolder должен имплементировать интерфейс LayoutContainer, иначе view не будет браться из кеша
    inner class RecyclerItemViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bind(data: Result) {
            if (layoutPosition != RecyclerView.NO_POSITION) {
                itemView.header_history_textview_recycler_item.text = data.text
                itemView.setOnClickListener {
                    Toast.makeText(itemView.context, "on click: ${data.text}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}
