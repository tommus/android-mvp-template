package windly.template.presentation.main

import dagger.Reusable
import windly.template.resources.HelloResources
import javax.inject.Inject

@Reusable
class MainResources @Inject constructor(
  private val resources: HelloResources
) {

  internal fun hello(): CharSequence =
    resources.hello()
}
