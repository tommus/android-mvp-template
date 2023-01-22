# AndroidX Work Manager
-keep class * extends androidx.work.Worker
-keep class * extends androidx.work.InputMerger
-keep public class * extends androidx.work.ListenableWorker {
    public <init>(...);
}
-keep class androidx.work.WorkerParameters

# Firebase Crashlytics
-keep class com.google.firebase.crashlytics.** { *; }
-dontwarn com.google.firebase.crashlytics.**

# Stetho
-keep class com.facebook.stetho.** { *; }
-dontwarn com.facebook.stetho.**
