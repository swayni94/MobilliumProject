package com.example.mobilliumproject.InterfaceHelper

import android.view.View
import com.example.mobilliumproject.Models.RepoResult

interface EditorRecyclerViewClickListener {

    fun onEditorRecyclerViewItemClick(view : View, editor : RepoResult.ShopsEditor)

    fun onNewShopRecyclerViewItemClick(view : View, editor : RepoResult.ShopsEditor)
}

