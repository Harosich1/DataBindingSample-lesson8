package info.fandroid.databindingsample

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import info.fandroid.databindingsample.data.Popularity

@BindingAdapter("app:hideIfZero")
fun hideIfZero(view: View, number: Int){
    view.visibility = if(number==0) View.GONE else View.VISIBLE
}

@BindingAdapter(value = ["app:progressScaled", "android:max"], requireAll = true)
fun setProgress(progressBar: ProgressBar, likes: Int, max: Int){
    progressBar.progress = (likes * max /10).coerceAtMost(max)
}

@SuppressLint("ResourceAsColor")
@BindingAdapter(value = ["app:progress", "app:popularity"], requireAll = true)
fun updateImage(image: ImageView, likes: Int, popularity: Popularity) {

    val color_popular = Color.parseColor("#ff76a5")
    val color_star = Color.parseColor("#ff0057")

    if(likes == 0) {
        image.setImageResource(R.drawable.ic_person_black_96dp)
        image.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP)
    }
    if(likes >= 1 && likes < 10){
        image.setImageResource(R.drawable.ic_whatshot_black_96dp)
        image.setColorFilter(color_popular, PorterDuff.Mode.SRC_ATOP);
    }

    if(likes > 10){
        image.setImageResource(R.drawable.ic_whatshot_black_96dp)
        image.setColorFilter(color_star, PorterDuff.Mode.SRC_ATOP)
    }
    if(likes > 20){
        image.setImageResource(R.drawable.ic_person_black_96dp)
        image.setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP)
    }




    /**
     * if(progressBar reached more than 10)
     * setImage(this.image)
     */
}




