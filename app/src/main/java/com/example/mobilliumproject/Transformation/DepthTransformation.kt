package com.example.mobilliumproject.Transformation

import android.view.View
import androidx.viewpager.widget.ViewPager

class DepthTransformation : ViewPager.PageTransformer {


    override fun transformPage(page: View, position: Float) {

        if(position<-1){
            page.alpha = 0.0f
        }else if(position<= 0){
            page.alpha = 1f
            page.translationX = 0f
            page.scaleX = 1f
            page.scaleY = 1f
        }else if (position<=1){
            page.translationX = -position * page.width
            page.alpha = 1f-(Math.abs(position))
            page.scaleX = 1f-(Math.abs(position))
            page.scaleY = 1f-(Math.abs(position))
        }else{
            page.alpha = 0f
        }
    }
}