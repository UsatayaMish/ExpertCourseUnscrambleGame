package com.usatayamish.expertcourseunscramblegame

import com.usatayamish.expertcourseunscramblegame.di.ClearViewModel
import com.usatayamish.expertcourseunscramblegame.di.MyViewModel

class FakeClearViewModel: ClearViewModel {

    var clasz: Class<out MyViewModel> = FakeViewModel::class.java

    override fun clear(viewModelClass: Class<out MyViewModel>) {
        clasz = viewModelClass
    }
}

private class FakeViewModel: MyViewModel