package es.baltajmn.tappapp.ui.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.baltajmn.tappapp.databinding.SingleItemBinding
import es.baltajmn.tappapp.model.User

class UserAdapter(
    private var orderList: ArrayList<User>
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: SingleItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(orderList[position]) {
                binding.username.text = this.name
                binding.totalPrice.text = "5,5"

                //binding.tvDescription.text = this.order[0].name
                binding.item.text = "mixto"
                //binding.tvPrice.text = this.order[0].price.toString()
                binding.price.text = "5,5"


                binding.expandedView.visibility = if (this.expand) View.VISIBLE else View.GONE
                binding.cardLayout.setOnClickListener {
                    this.expand = !this.expand
                    notifyDataSetChanged()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return orderList.size
    }
}