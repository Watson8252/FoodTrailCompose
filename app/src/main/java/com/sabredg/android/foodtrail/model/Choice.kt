package com.sabredg.android.foodtrail.model

import androidx.annotation.StringRes
import com.sabredg.android.foodtrail.R

enum class Choice (
    @StringRes val choiceName: Int
) {
    Burgers(
        choiceName = R.string.choice_Burgers
    ),
    Chinese(
        choiceName = R.string.choice_Chinese
    ),
    Japanese(
        choiceName = R.string.choice_Japanese
    ),
    Mexican(
        choiceName = R.string.choice_Mexican
    ),
    Seafood(
        choiceName = R.string.choice_Seafood
    ),
    Shawarma(
        choiceName = R.string.choice_Shawarma
    ),
    Sushi(
        choiceName = R.string.choice_Sushi
    ),
    Tacos(
        choiceName = R.string.choice_Tacos
    ),
    Turkish(
        choiceName = R.string.choice_Turkish
    )
}