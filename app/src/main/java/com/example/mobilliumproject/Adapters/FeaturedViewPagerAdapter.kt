package com.example.mobilliumproject.Adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.mobilliumproject.MainActivity
import com.example.mobilliumproject.Models.RepoResult
import com.squareup.picasso.Picasso


class FeaturedViewPagerAdapter(val featureds : List<RepoResult.Featured>, val context : MainActivity) : PagerAdapter() {
    override fun isViewFromObject(view: View, object1: Any): Boolean {
        return view == object1
    }

    override fun getCount(): Int {
        return featureds.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView : ImageView = ImageView(context)
        Picasso.get().load(featureds.get(position).cover?.url).fit().centerCrop().into(imageView)
        container.addView(imageView)

        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, object1: Any) {
        container.removeView(object1 as View)
    }
}