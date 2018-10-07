package com.waliahimanshu.demo.network

import com.flextrade.jfixture.FixtureAnnotations
import com.flextrade.jfixture.JFixture
import com.flextrade.jfixture.annotations.Fixture
import com.flextrade.jfixture.annotations.FromListOf
import com.waliahimanshu.demo.ui.R
import java.util.*


object DataSource {

    @Fixture // You still need to include this annotation
    @FromListOf(strings = ["a", "b", "c"]) // Note the 'strings' parameter
    private val letter: String? = null


    init {
        val jFixture = JFixture()
        FixtureAnnotations.initFixtures(this, jFixture)
    }

    fun get(size: Int): ArrayList<PersonModel> {
        val arrayList = arrayList()
        val listOf = ArrayList<PersonModel>()

        for (i in 1..size) {
            listOf.add(arrayList[Random().nextInt(arrayList.size)])
        }
        return listOf
    }

}

private fun arrayList(): ArrayList<PersonModel> {
    val personModel = PersonModel("Sandra Bull", "Today at 13:33", R.drawable.avatar_ali_connors)

    val personModel1 = PersonModel("Erik Lucatero", "Yesterday at 12:33", R.drawable.avatar_trevor)

    val personModel2 = PersonModel("Erik Lucatero", "Yesterday at 12:33", R.drawable.avatar_sandra)


    return arrayListOf(personModel, personModel1, personModel2)
}
