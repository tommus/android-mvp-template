package windly.template.mvp

import java.util.function.Consumer

abstract class Presenter<V> {

  /**
   * Holds a reference to presenter's view.
   */
  var view: V? = null

  /**
   * Holds all deferred functions to be called once the view
   * will be attached.
   */
  private val deferredViewUpdates: MutableList<Consumer<V>> = mutableListOf()

  /**
   * Perform the function on the view, if it's attached. If
   * there is no view currently attached, the function is
   * deferred until onAttached() is re-called. At this
   * point they are executed in the order they were passed
   * to this function.
   * <p>
   * If onAttached() is never called (eg. presenter is
   * GC'd, these functions will never be run.
   */
  protected fun whenAttached(function: Consumer<V>) {
    if (view != null) {
      function.accept(view!!)
    } else {
      deferredViewUpdates.add(function)
    }
  }

  /**
   * Perform the function on the view, if it's attached.
   * If there's no view currently attached, the function
   * will never be called.
   */
  protected fun ifAttached(function: Consumer<V>) {
    view?.let { function.accept(it) }
  }

  /**
   * Attach this presenter to its UI element. If a view is
   * already attached, it will be detached via a call to
   * detach() first, then the new one attached.
   */
  open fun attach(view: V) {
    if (view == null) {
      throw IllegalArgumentException("view == null")
    }
    this.view?.let { detach() }
    this.view = view
    for (deferred in deferredViewUpdates) {
      deferred.accept(this.view!!)
    }
    deferredViewUpdates.clear()
    onAttached(view)
  }

  /**
   * Called on implementing classes after the view has
   * been attached.
   */
  abstract fun onAttached(view: V)

  /**
   * Access the currently attached view, or throw an
   * exception if it doesn't exist.
   * <p>
   * This method should be used only when you're sure the
   * view cannot be null.
   */
  fun getAttachedView(): V {
    if (view == null) {
      throw IllegalStateException("Presented was detached!")
    }
    return view!!
  }

  /**
   * Detach any attached view from this presenter. If no
   * view is currently attached, this is a no-op.
   */
  open fun detach() {
    view?.let {
      onDetached(it)
      view = null
    }
  }

  /**
   * Called on implementing classes after the currently
   * attached view is detached.
   */
  abstract fun onDetached(view: V)
}
