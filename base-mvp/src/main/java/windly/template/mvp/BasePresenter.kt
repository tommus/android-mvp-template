package windly.template.mvp

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<V : MvpView> : Presenter<V>() {

  /**
   * Holds presenter-bound disposables and offers O(1) add and
   * removal complexity.
   */
  protected val disposables = CompositeDisposable()

  /**
   * Called on implementing classes after the view has
   * been attached.
   */
  override fun onAttached(view: V) = Unit

  /**
   * Called on implementing classes after the currently
   * attached view is detached.
   */
  override fun onDetached(view: V) {
    disposables.clear()
  }
}
