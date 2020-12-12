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


add this line to activity. if you want to set transparent, replace color with "-1"
``` java
new Barnava(this).change(R.color.red,R.color.black); // first parameter: statusbar color - secound parameter navigationbar color
```

License
-------

    Copyright 2020 Apprang, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
