# demo-android


Food app design inspiration taken from here : https://www.uplabs.com/posts/food-app-animation
100 % kotlin
Architecture of choice : MVP in favour of testability 

Demo Video portrait mode [portrait](../blob/master/device-portrait.mp4)

Demo Video land mode [land](../blob/master/device-land.mp4)



Using hardcode json to load recepies : [recipes_response.json](../blob/master/app/src/main/res/raw/recipes_response.json)
and [user](../blob/master/app/src/main/java/com/waliahimanshu/demo/data/UserRepository.kt)

Unit Tests :

[RecipesDetailsFragmentPresenterTest](../blob/master/app/src/test/java/com/waliahimanshu/demo/ui/details/RecipesDetailsFragmentPresenterTest.kt)

[RecipeCardItemPresenterTest](../blob/master/app/src/test/java/com/waliahimanshu/demo/ui/home/cardItem/RecipeCardItemPresenterTest.kt)

[RecipesFragmentPresenterTest](../blob/master/app/src/test/java/com/waliahimanshu/demo/ui/home/RecipesFragmentPresenterTest.kt)

Example of RXJava2 to fetch data : 

[RecipesFragmentPresenter](../blob/master/app/src/main/java/com/waliahimanshu/demo/ui/home/RecipesFragmentPresenter.kt)

