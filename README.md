# AndroidBoilerPlate

Sample Android app that could be used as a reference for new Android projects. It demonstrates the architecture, tools and guidelines that we use when developing for the Android platform.

Libraries and tools included:

- Support libraries
- RecyclerViews
- Navigation Components
- [RxJava](https://github.com/ReactiveX/RxJava)
- [Retrofit 2](http://square.github.io/retrofit/)
- [Dagger 2](http://google.github.io/dagger/)
- [Chuck](https://github.com/jgilfelt/chuck/)

## Requirements

- JDK 1.8
- [Android SDK](http://developer.android.com/sdk/index.html).
- Android 11 [(API 30) ](http://developer.android.com/tools/revisions/platforms.html).
- Latest Android SDK Tools and build tools.


## Architecture

This project follows MVVM Android architecture guidelines.

### How to implement a new screen following MVVM

Imagine you have to implement a login in screen. 

1. Create a new package under `ui` called `login`
2. Create an new Activity called `LoginActivity` and create a new Fragment called `LoginFragment`.
3. Define the viewmodel that your fragment/activity is going to implement. Create a new viewmodel called `LoginViewModel`.
4. Create a `LoginRepository` class that should handle call the data manipulation calls between viewmodel and model.
5. Define your LoginActivity scope inside `ActivityBuilderModule` class. Create a sub module for this activity named `LoginActivityModule` and define your LofinFragment scope inside it.
6. Define your LoginViewModel binding inside `ViewModelModule` class.
7. Create a newtwork api calls related Module called `LoginModule` inside `di/network/` package.
8. Create a newtwork api calls interface class called `LoginNetworkAPI` inside `network/api/login/` package.


## New project setup 

To quickly start a new project from this boilerplate follow the next steps:

* Download this [repository as a zip](https://github.com/sahilgarg90/AndroidBoilerPlate/archive/master.zip).
* Change the package name. 
  * Rename packages in main using Android Studio.
  * In `app/build.gradle` file, `packageName`.
  * In `src/main/AndroidManifest.xml`.
* Create a new git repository.
* Replace the example code with your app code following the same architecture.
* Update README with information relevant to the new project.
