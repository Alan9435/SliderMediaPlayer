[![](https://jitpack.io/v/Alan9435/SliderMediaPlayer.svg)](https://jitpack.io/#Alan9435/SliderMediaPlayer)

## SliderMediaPlayer

#### Displaying slideshows using ViewPager2

#### Downloading images using the Glide library (https://github.com/bumptech/glide)

#### Downloading videos using the ExoPlayer library (https://github.com/google/ExoPlayer)

### Applicable to:
####  &nbsp;⚫ &nbsp; Displaying images and videos
####  &nbsp;⚫ &nbsp; Creating slideshows
####  &nbsp;⚫ &nbsp; Playing videos
![tf](https://github.com/Alan9435/SliderMediaPlayer/assets/81663054/d35a6237-432e-4b64-aca9-1548c7548a1d)


## How to use?
### Step 1. Please check your compile Sdk and target Sdk must be 34 or above
```
  android {
    compileSdk 34
    ...

    defaultConfig {
      ...
      targetSdk 34
    }
  }
```

### Step 2. Add the JitPack repository to your build file
```
buildscript {
    repositories {
	    ...
      maven { url 'https://jitpack.io' }
    }
}
 ```

### Step 3. Add the dependency
```
dependencies {
    ...
    implementation 'com.github.Alan9435:SliderMediaPlayer:1.0'
}
```

### Step 4. Set SliderMediaPlayer in your Layout
```
  <com.alan.slidermediaplayer.SliderMediaPlayer
        android:id="@+id/smpTest"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"/>
```

### Step 5. Get your data from API, and convert to `SliderMediaData`
```
      val myData = listOf(
            SliderMediaData(
                url = "https://images.pexels.com/photos/460672/pexels-photo-460672.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                urlType = TYPE_PHOTO
            ),
            SliderMediaData(
                url = "https://images.pexels.com/photos/47547/squirrel-animal-cute-rodents-47547.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                urlType = TYPE_PHOTO
            ),
            SliderMediaData(
                url = "https://www.ebookfrenzy.com/android_book/movie.mp4",
                urlType = TYPE_VIDEO
            ),
            SliderMediaData(
                url = "https://images.pexels.com/photos/1661179/pexels-photo-1661179.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                urlType = TYPE_PHOTO
            ),
            SliderMediaData(
                url = "https://images.pexels.com/photos/326012/pexels-photo-326012.jpeg",
                urlType = TYPE_PHOTO
            ),
            ...
        )
```

### Step 6. Set `SliderMediaData` to your SliderMediaPlayer
```
  activity?.let { binding.smpTest.setSliderMediaData(myData, it) }
```

### You can view the complete example at [here](app/src/main/java/com/alan/slidermediaplayerliberay/MainActivity.kt)


#  Finish！！！ :tada: :tada: :tada:

### Function Table
|   Function  | Input type   |  Required  | Description |
| :---:   | :---: | :---: | :--- |
| setSliderMediaData | List\<SliderMediaData\>, FragmentActivity   | Yes | Set a list of `SliderMediaData` objects as data to fill your screen |
| goLeft |  | No | page to Left |
| goRight |  | No | page to right |
| setAutoPlay | Boolean | No | If you want Play automatically when you scroll to video page, you can set it to true else set it to false <br><br> default : false |
| setOffscreenPageLimit | Int | No | The offscreenPageLimit attribute is set as an integer value, with a default value of 1, so the ViewPager only keeps the current page in memory. However, if you have a lot of pages or complex pages that take up a lot of memory, you can increase the offscreenPageLimit attribute to retain more pages in memory. This can help to improve the performance of the app and reduce the amount of time required to reload pages when the user navigates back to them <br><br> default : 1 |
| setPlaceholderForPhoto | Int (resources) | No | Set photo page placeholder <br><br> default : ![loading](https://github.com/Alan9435/SliderMediaPlayer/assets/81663054/584ad1e7-0681-4063-a9a5-c60bcf062fd9) |
| setCurrentItem | Int | No | Set current page, you can use this method to set the start page  |

### Attribute Table
|   Attribute  | Input type   |  Required  | Description |
| :---:   | :---: | :---: | :--- |
| autoPlay | Boolean | No | Same as setAutoPlay |
| offscreenPageLimit | integer | No | Same as setOffscreenPageLimit |
| placeholder | Reference | No | Same as setPlaceholderForPhoto |



