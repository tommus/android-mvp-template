package windly.template.ci

object Keystore {
  private const val directory = "settings/keystore"

  object Debug {
    const val alias = "androiddebugkey"
    const val key = "android"
    const val path = "$directory/debug.jks"
  }
}
