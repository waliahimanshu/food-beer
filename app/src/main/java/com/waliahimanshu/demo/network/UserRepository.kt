package com.waliahimanshu.demo.network

import com.waliahimanshu.demo.ui.R
import io.reactivex.Single
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


class UserRepository @Inject constructor() {

    fun getProfiles(size: Int): Single<ArrayList<PersonModel>> {
        val source = source()

        return Single.fromCallable {
            val profiles = ArrayList<PersonModel>()
            for (i in 1..size) {
                profiles.add(source[Random().nextInt(source.size)])
            }
            profiles
        }
    }
}

private fun source(): ArrayList<PersonModel> {
    val ali = PersonModel("Ali Bull", "Today at 13:33", R.drawable.avatar_ali_connors)
    val trevor = PersonModel("Erik Lucatero", "Yesterday at 12:33", R.drawable.avatar_trevor)
    val sandra = PersonModel("Sadra Cucatero", "Yesterday at 22:33", R.drawable.avatar_sandra)
    val jerry = PersonModel("Daze Pale", "Yesterday at 12:23", R.drawable.avatar_jerry_chang)
    val anonymous = PersonModel("Lind Macartney", "Yesterday at 00:32", R.drawable.avatar)

    return arrayListOf(ali, trevor, jerry, sandra, anonymous)
}
