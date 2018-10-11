package com.waliahimanshu.demo.data

import com.waliahimanshu.demo.ui.R
import com.waliahimanshu.demo.ui.home.dto.PersonDto
import io.reactivex.Single
import javax.inject.Inject


class UserRepository @Inject constructor() {

    fun getProfiles(): Single<List<PersonDto>> {
        return Single.fromCallable {
            source()
        }
    }
}

private fun source(): ArrayList<PersonDto> {
    val ali = PersonDto("Ali Corner", "Today at 13:33", R.drawable.avatar_ali_connors)
    val trevor = PersonDto("Trever Nand", "Yesterday at 12:33", R.drawable.avatar_trevor)
    val sandra = PersonDto("Sadra Cucatero", "Yesterday at 22:33", R.drawable.avatar_sandra)
    val jerry = PersonDto("Jerry Change", "Yesterday at 12:23", R.drawable.avatar_jerry_chang)
    val anonymous = PersonDto("Tvler Dids", "Yesterday at 00:32", R.drawable.avatar_mom)

    return arrayListOf(ali, trevor, jerry, sandra, anonymous)
}
