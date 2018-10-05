# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile



## Picasso
# Project doesn't use OkHttp 1, the built-in UrlConnectionDownloader is enough
# Warning: com.squareup.picasso.OkHttpDownloader:
#          can't find referenced class com.squareup.okhttp
-dontwarn com.squareup.picasso.OkHttpDownloader
# Note: com.squareup.picasso.Utils:
#       can't find dynamically referenced class com.squareup.okhttp.OkHttpClient
-dontnote com.squareup.picasso.Utils
