# UILog
I want to get the Log reports from my test devices, so I made this simple library which will emulate the adb Log class in Android UI , so testers can share there logs and debugging can become easier by tracing the logs.

The wy it works is like this:

1) Add this into your top level `build.gradle` file

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

2) Now we can move on to adding the dependency in the module `build.gradle` file

```
dependencies {
	        compile 'com.github.divyanshunegi:UILog:-SNAPSHOT'
	}
```

Make sure you are using the latest `version` instead of `SNAPSHOT` for stable working of the project. 
The version you can find by this link : https://jitpack.io/#divyanshunegi/UILog

So now with all these steps you have successfully added the dependency for UILog.

3) Now to log anything use this code :

```
UILog.init().w(TAG,"log message"); //Warning logs
UILog.init().e(TAG,"log message"); //Error logs
UILog.init().i(TAG,"log message"); //Info logs
UILog.init().v(TAG,"log message"); //Verbose logs
UILog.init().d(TAG,"log message"); //Debug logs

``` 


4) This will record all the logs you have made in your app in one session, once you close the app from task bar the logs will be gone, to make sure 
you can see your logs you can see them with this code :

```

    <divyanshu.uiloglib.UILogView
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    </divyanshu.uiloglib.UILogView>

```

This will show the logs in the screen, it will show live logs in realtime as well.

I will keep adding more features into the lib, this is tiny lib which I wanted so made one.
