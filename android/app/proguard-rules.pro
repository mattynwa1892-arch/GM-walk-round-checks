# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in the SDK location, which normally points to the latest android.jar.

-keep class com.gmwalkaround.inspection.** { *; }
-keep interface com.gmwalkaround.inspection.** { *; }

# Retrofit
-keep class retrofit2.** { *; }
-keep interface retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

# Gson
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.** { *; }
-keep interface com.google.gson.** { *; }
-keepclassmembers enum * { *; }

# OkHttp
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-keepattributes Signature
-keepattributes Exceptions

# Firebase
-keep class com.google.firebase.** { *; }
-keep interface com.google.firebase.** { *; }

# Room
-keep class androidx.room.** { *; }
-keep interface androidx.room.** { *; }
