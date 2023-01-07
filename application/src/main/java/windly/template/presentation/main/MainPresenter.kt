package windly.template.presentation.main

import dagger.hilt.android.scopes.ActivityScoped
import windly.template.mvp.BasePresenter
import windly.template.mvp.MvpView
import javax.inject.Inject

@ActivityScoped
class MainPresenter @Inject constructor() : BasePresenter<MvpView>()
