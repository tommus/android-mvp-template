package windly.template.android.permission

import android.content.Context
import android.content.pm.PackageManager.PERMISSION_GRANTED
import java.lang.Boolean.TRUE

object PermissionUtils {

  /**
   * Returns true if (and only if) all required permissions were granted.
   */
  fun hasPermissions(context: Context, vararg permissions: String): Boolean =
    permissions
      .map(context::checkSelfPermission)
      .all { it == PERMISSION_GRANTED }

  /**
   * Returns true if (and only if) all required permissions were granted.
   */
  fun permissionsGranted(results: Map<String, Boolean>): Boolean =
    results.values.all(TRUE::equals)

  /**
   * Returns a list of all those permissions that user deny.
   */
  fun missingPermissions(results: Map<String, Boolean>): List<String> =
    results.filter { !it.value }.keys.toCollection(mutableListOf())

  /**
   * Returns a list of all those permissions that user granted.
   */
  fun grantedPermissions(results: Map<String, Boolean>): List<String> =
    results.filter { it.value }.keys.toCollection(mutableListOf())
}
