package n.com.myapplication.screen.user

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import n.com.myapplication.base.recyclerView.OnItemClickListener
import n.com.myapplication.data.model.User
import n.com.myapplication.extension.notNull
import n.com.myapplication.util.Constant.POSITION_DEFAULT

data class ItemUserViewModel(
    val itemClickListener: OnItemClickListener<User>? = null,
    var position: Int = POSITION_DEFAULT,
    @Bindable
    var user: User? = null) : BaseObservable() {

  fun setData(data: User?) {
    data.notNull {
      user = it
      notifyPropertyChanged(BR.user)
    }
  }

  fun onItemClicked(view: View) {
    itemClickListener.notNull { listener ->
      user.notNull {
        listener.onItemViewClick(it, position)
      }
    }
  }

}