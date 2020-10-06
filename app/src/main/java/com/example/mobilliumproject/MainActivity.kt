package com.example.mobilliumproject

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.lifecycle.Observer
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.android.tools.build.jetifier.core.utils.Log
import com.example.mobilliumproject.Adapters.*
import com.example.mobilliumproject.InterfaceHelper.EditorRecyclerViewClickListener
import com.example.mobilliumproject.Models.RepoResult
import com.example.mobilliumproject.Transformation.DepthTransformation
import com.example.mobilliumproject.databinding.ActivitymainBinding
import com.example.mobilliumproject.viewModelsAndFactory.MobilliumViewModel
import com.example.mobilliumproject.viewModelsAndFactory.MobilliumViewModelFactory
import com.google.android.material.tabs.TabLayout
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(),KodeinAware, View.OnClickListener,
    EditorRecyclerViewClickListener {


    override val kodein by kodein()

    private val factory: MobilliumViewModelFactory by instance()
    private lateinit var viewModel: MobilliumViewModel

    private lateinit var toolbarSearchEditText : EditText
    private lateinit var toolbar_speechButton : Button
    private lateinit var toolbar: Toolbar

    private var adapterProduct: ProductRecyclerAdapter? = null
    private var adapterCategory : CategoryRecyclerAdapter? =null
    private var adapterCollection : CollectionRecyclerAdapter? =null
    private var adapterEditor : EditorRecyclerAdapter ? = null
    private var adapterNewShops : NewShopsRecyclerAdapter ? = null
    private var adapterFeatured : FeaturedViewPagerAdapter ? =null

    private var depthTransformation: DepthTransformation ? = DepthTransformation()
    private var animation : LayoutAnimationController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivitymainBinding = DataBindingUtil.setContentView(this, R.layout.activitymain)

        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this, factory).get(MobilliumViewModel::class.java)
        binding.mobilliumViewModel = viewModel

        val recyclerView_Product = binding.productRecyclerView
        val recyclerView_category = binding.categoryRecyclerView
        val recyclerView_collection =binding.collectionRecyclerView
        val recyclerView_editor = binding.editorShopRecyclerView
        val recyclerView_newShops = binding.newShopsRecyclerView
        val viewpager = binding.sliderView
        val tabLayout = binding.sliderViewTabLayout


        recyclerView_Product!!.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false))
        recyclerView_Product.setHasFixedSize(true)
        recyclerView_category!!.setLayoutManager(LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false))
        recyclerView_collection!!.setLayoutManager(LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false))
        recyclerView_editor!!.setLayoutManager(LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false))
        recyclerView_newShops!!.setLayoutManager(LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false))
        recyclerView_category.setHasFixedSize(true)
        recyclerView_collection.setHasFixedSize(true)
        recyclerView_editor.setHasFixedSize(true)
        recyclerView_newShops.setHasFixedSize(true)
        animation = AnimationUtils.loadLayoutAnimation(this, R.anim.recyclerview_layout_animation)

        toolbarSearchEditText = findViewById(R.id.toolbar_SearchText)
        toolbar = findViewById(R.id.toolbar)
        toolbar_speechButton = findViewById(R.id.toolbar_SpeechButton)
        toolbar_speechButton.setOnClickListener(this)

        toolbar.setNavigationOnClickListener{
            Log.e("deneme", "toolbar navigation deneme")
        }

        getFeaturedViewPagerData(viewpager, tabLayout)
        getProductRecyclerData(recyclerView_Product)
        getCategoryRecyclerData(recyclerView_category)
        getCollectionRecyclerData(recyclerView_collection)
        getEditorRecyclerData(recyclerView_editor)
        getNewShopsRecyclerData(recyclerView_newShops)
    }
    private fun getFeaturedViewPagerData(viewPager : ViewPager, tablayout: TabLayout){
        viewModel.datas?.observe(this, Observer<List<RepoResult>>{ repoResult : List<RepoResult>? ->
            adapterFeatured = FeaturedViewPagerAdapter(repoResult!!.get(0).featured as List<RepoResult.Featured>, this)
            viewPager.setAdapter(adapterFeatured)
            tablayout.setupWithViewPager(viewPager)
            viewPager.setPageTransformer(true, depthTransformation)
        })
    }

    private fun getProductRecyclerData(recyclerView: RecyclerView){
        viewModel.datas?.observe(this, Observer<List<RepoResult>> { repoResult: List<RepoResult>? ->
            adapterProduct= ProductRecyclerAdapter(repoResult!!.get(1).products as List<RepoResult.Product>)
            recyclerView.setAdapter(adapterProduct)
            recyclerView.layoutAnimation = animation
        })
    }

    private fun getCategoryRecyclerData(recyclerView: RecyclerView){
        viewModel.datas?.observe(this,Observer<List<RepoResult>>{repoResult: List<RepoResult>? ->
            adapterCategory = CategoryRecyclerAdapter(repoResult!!.get(2).categories as List<RepoResult.Category>)
            recyclerView.setAdapter(adapterCategory)
            recyclerView.layoutAnimation = animation
        })
    }

    private fun getCollectionRecyclerData(recyclerView: RecyclerView){
        viewModel.datas?.observe(this, Observer<List<RepoResult>>{repoResult : List<RepoResult>? ->
            adapterCollection = CollectionRecyclerAdapter(repoResult!!.get(3).collections as List<RepoResult.Collection>)
            recyclerView.setAdapter(adapterCollection)
            recyclerView.layoutAnimation = animation
        })
    }

    private fun getEditorRecyclerData(recyclerView: RecyclerView){
        viewModel.datas?.observe(this, Observer<List<RepoResult>>{repoResult:List<RepoResult> ? ->
            adapterEditor = EditorRecyclerAdapter(repoResult!!.get(4).shops as List<RepoResult.ShopsEditor>, this)
            recyclerView.setAdapter(adapterEditor)
            recyclerView.layoutAnimation = animation
        })
    }

    private fun getNewShopsRecyclerData(recyclerView: RecyclerView){
        viewModel.datas?.observe(this, Observer<List<RepoResult>>{repoResult:List<RepoResult>? ->
            adapterNewShops = NewShopsRecyclerAdapter(repoResult!!.get(5).shops as List<RepoResult.ShopsEditor>, this)
            recyclerView.setAdapter(adapterNewShops)
            recyclerView.layoutAnimation = animation
        })
    }

    override fun onActivityResult(requestCode:Int, resultCode: Int, data:Intent?){
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){

            REQUEST_CODE_STT ->{
                if (resultCode == Activity.RESULT_OK && data!=null){
                    val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    if (!result.isNullOrEmpty()){
                        val recognizedText = result[0]
                        toolbarSearchEditText.setText(recognizedText)
                    }
                }
            }
        }
    }

    companion object{
        private const val REQUEST_CODE_STT = 1
    }

    override fun onClick(v: View?) {
        val sttIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        sttIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        sttIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        sttIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak Now")
        try {
            startActivityForResult(sttIntent, REQUEST_CODE_STT)
        }catch (e : ActivityNotFoundException){
            e.printStackTrace()
        }
    }

    override fun onEditorRecyclerViewItemClick(view: View, editor: RepoResult.ShopsEditor) {
        val intent = Intent (this, OtherActivity::class.java)
        startActivity(intent)
    }

    override fun onNewShopRecyclerViewItemClick(view: View, editor: RepoResult.ShopsEditor) {
        val intent = Intent (this, OtherActivity::class.java)
        startActivity(intent)
    }

}
