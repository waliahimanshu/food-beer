package com.waliahimanshu.demo.ui.home

import com.waliahimanshu.demo.ui.R

object DataSource {

    fun get(): ArrayList<RecipeEntryModel> {
        return arrayList()
    }

}

private fun arrayList(): ArrayList<RecipeEntryModel> {
    val elements = RecipeEntryModel("http://static.food2fork.com/Jalapeno2BPopper2BGrilled2BCheese2BSandwich2B12B500fd186186.jpg",
            PersonModel("Sandra Bull", "Today at 13:33", R.drawable.avatar_ali_connors), "Ingredients\n" +
            "2 jalapeno peppers, cut in half lengthwise and seeded\n" +
            "2 slices sour dough bread\n" +
            "1 tablespoon butter, room temperature\n" +
            "2 tablespoons cream cheese, room temperature")

    val element1 = RecipeEntryModel("http://static.food2fork.com/icedcoffee5766.jpg",
            PersonModel("Audrey Jezz", "Today at 10:33", R.drawable.avatar_jerry_chang), "Ingredients\n" +
            "2 jalapeno peppers, cut in half lengthwise and seeded\n" +
            "2 slices sour dough bread\n" +
            "1 tablespoon butter, room temperature\n" +
            "2 tablespoons cream cheese, room temperature")

    val element2 = RecipeEntryModel("http://static.food2fork.com/avocadomacandcheesedc99.jpg",
            PersonModel("Erik Lucatero", "Yesterday at 12:33", R.drawable.avatar_trevor), "Ingredients\n" +
            "2 jalapeno peppers, cut in half lengthwise and seeded\n" +
            "2 slices sour dough bread\n" +
            "1 tablespoon butter, room temperature\n" +
            "2 tablespoons cream cheese, room temperature")


    val element3 = RecipeEntryModel("http://static.food2fork.com/5551711173_dc42f7fc4b_zbd8a.jpg",
            PersonModel("Erik Lucatero", "Yesterday at 12:33", R.drawable.avatar_sandra), "Ingredients\n" +
            "2 jalapeno peppers, cut in half lengthwise and seeded\n" +
            "2 slices sour dough bread\n" +
            "1 tablespoon butter, room temperature\n" +
            "2 tablespoons cream cheese, room temperature")

    return arrayListOf(elements, element1, element2, element3)
}
