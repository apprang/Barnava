# Barnava
Simple way to customise NavigationBar and StatusBar in android 


## Add it in your root build.gradle at the end of repositories:
``` gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

## Gradle Dependency

 ``` gradle
dependencies {
	        implementation 'ir.Apprang:Barnava:VERSION'
	}
 ```
[![](https://jitpack.io/v/ir.Apprang/Barnava.svg)](https://jitpack.io/#ir.Apprang/Barnava)


add this line to activity. if you want to set transparent, replace color with -1
``` java
new Barnava(this).change(R.color.red,R.color.blac); // first parameter: statusbar color - secound parameter navigationbar color
```
