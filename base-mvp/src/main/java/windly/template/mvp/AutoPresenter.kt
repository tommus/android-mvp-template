package windly.template.mvp

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.State
import androidx.lifecycle.LifecycleOwner
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

abstract class AutoPresenter<V : MvpLifecycleView> : Presenter<V>(),
  DefaultLifecycleObserver {

  private var lifecycle: Lifecycle? = null
  private var viewRef: WeakReference<V>? = null

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

  /**
   * Binds given view as a lifecycle observer.
   */
  fun bind(view: V) {
    this.lifecycle = view.lifecycle
    this.viewRef = WeakReference(view)
    this.lifecycle?.addObserver(this)
  }

  /**
   * Removes view so it will no longer be a lifecycle observer.
   */
  fun reset() {
    lifecycle?.removeObserver(this)
    lifecycle = null
  }

  /**
   * Reacts to lifecycle ON_START event.
   * <p>
   * It attaches the view automatically once the lifecycle become at least
   * STARTED.
   */
  override fun onStart(owner: LifecycleOwner) {
    if (lifecycle?.currentState?.isAtLeast(State.STARTED) == true) {
      viewRef?.get()?.let(::attach)
    }
  }

  /**
   * Reacts to lifecycle ON_STOP event.
   * <p>
   * It detaches the the view.
   */
  override fun onStop(owner: LifecycleOwner) {
    detach()
  }

  /**
   * Reacts to lifecycle ON_DESTROY event.
   * <p>
   * It resets the lifecycle observer by calling reset() method.
   */
  override fun onDestroy(owner: LifecycleOwner) {
    reset()
  }
}
