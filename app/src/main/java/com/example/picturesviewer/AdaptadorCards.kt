import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.picturesviewer.R

class AdaptadorCards(var items: ArrayList<Card>) : RecyclerView.Adapter<AdaptadorCards.TarjViewHolder>() {
    private lateinit var onClick: (View) -> Unit

    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imag : ImageView

        init {
            imag = itemView.findViewById(R.id.foto)
        }

        fun bindTarjeta(t: Card, onClick: (View) -> Unit) = with(itemView) {
            imag.setImageResource(t.foto)
            setOnClickListener{ onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_cards, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        var itemCard = items[pos]
        viewHolder.bindTarjeta(itemCard,onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}