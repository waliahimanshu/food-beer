package com.waliahimanshu.demo.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.waliahimanshu.demo.ui.R
import javax.inject.Inject




class RecipesEntryActivity : AppCompatActivity(), RecipesEntryContract.View {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: RecipeEntryAdapter

    @Inject
    lateinit var recipesEntryPresenter: RecipesEntryContract.Presenter


    companion object {
        fun getLaunchIntent(context: Context): Intent {
            return Intent(context, RecipesEntryActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        viewManager = LinearLayoutManager(this)
        val elements = RecipeEntryModel("http://static.food2fork.com/Jalapeno2BPopper2BGrilled2BCheese2BSandwich2B12B500fd186186.jpg","Jalapeno Popper Grilled Cheese Sandwich","Ingredients\n" +
                "2 jalapeno peppers, cut in half lengthwise and seeded\n" +
                "2 slices sour dough bread\n" +
                "1 tablespoon butter, room temperature\n" +
                "2 tablespoons cream cheese, room temperature")

        val element1 = RecipeEntryModel("http://static.food2fork.com/Jalapeno2BPopper2BGrilled2BCheese2BSandwich2B12B500fd186186.jpg","Jalapeno Popper Grilled Cheese Sandwich","Ingredients\n" +
                "2 jalapeno peppers, cut in half lengthwise and seeded\n" +
                "2 slices sour dough bread\n" +
                "1 tablespoon butter, room temperature\n" +
                "2 tablespoons cream cheese, room temperature")

        val element2 = RecipeEntryModel("http://static.food2fork.com/Jalapeno2BPopper2BGrilled2BCheese2BSandwich2B12B500fd186186.jpg","Jalapeno Popper Grilled Cheese Sandwich","Ingredients\n" +
                "2 jalapeno peppers, cut in half lengthwise and seeded\n" +
                "2 slices sour dough bread\n" +
                "1 tablespoon butter, room temperature\n" +
                "2 tablespoons cream cheese, room temperature")
        val myDataSet = arrayListOf(elements, element1, element2)
        viewAdapter = RecipeEntryAdapter(myDataSet)

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = viewManager
            adapter = viewAdapter

        }
    }

    override fun showProgressBar(show: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun showEmptyState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setPresenter(presenter: RecipesEntryContract.Presenter) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
