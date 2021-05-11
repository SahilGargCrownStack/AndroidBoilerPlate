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
- [Data Binding](https://developer.android.com/topic/libraries/data-binding/index.html)
- [OK HTTP](https://github.com/square/okhttp)

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



## Folder structure
```
├── base… Base classes to extend
├── di… Dependency Injection Related files (e.g. Appcomponent, Main modules class, scopes)
│   ├── network… DI Network Modules for each app section
│   ├── subModules… DI sub modules for Activity/fragment/listeners
│   └── repository… Implementation for Domain layer
│       ├── datasource… Implement local and remote datasource
│       └── storage… Share preferences data
├── network… Implement network related classes
│   ├── api… Contains API related classes for each app section
├── ui… View Layer (Contains packages for each ui module)
    ├── main (e.g. Main screen package)
        ├── model… Contains data model classes for this module
        └── viewmodel… Contains viewmodel class for this module
└── utils… Utility functions every where in the app
    ├── connectivity… Network Connection classes
    ├── permissions… runtime Permission related classes

```

## Timeline

```
Total duration: 9-10 working days
Pre-requites: 
    Languages: Java, kotlin
    Design Pattern: MVVM
    Dependency Injection: Knowledge of DI (Dagger-2 is an advantage)
    Network Call: Retrofit-2
    JetPack: Navigation
NOTE: 
    Reference for Dagger2 
        -> https://medium.com/@harivigneshjayapalan/dagger-2-for-android-beginners-dagger-2-part-i-f2de5564ab25
        -> https://www.raywenderlich.com/262-dependency-injection-in-android-with-dagger-2-and-kotlin
    Reference for Retrofit2
        -> https://medium.com/android-news/manage-rest-api-with-okhttp3-retrofit2-gson-and-rxjava2-aa5bea1e8a92  
DAY 1:
-> Overview Project structure
-> Look Gradle files and check about dependencies included and declarations
-> Look AndroidManifest.xml file for permissions and application related components declarations.
-> Learn about Base Files (How to write common code for View files and its usages)
DAY 2:
-> Revise what's DI and how it works imagining real life examples.
-> AndroidApplication - Initialising Dagger
-> Study - What is Module?
DAY 3:
-> Modules in App- AppModule, ActivityBuilderModule, NetworkModule and ViewModelModule
-> AppComponent - Defining Modules
DAY 4:
-> Learn about Scopes/CustomScopes annotation in Dagger
-> Learn few important annotations - Singleton, Provides, Inject 
-> Evaluate setting up dagger files and understand more with syncing between files
DAY 5:
-> (Before moving to networking part - Revise Retrofit and Read again AuthModule and MainModule)
-> Understand carefully '.../androidboilerplate/network' package how to arrange files
-> Understand connection between MainApi, MainApiImpl and MainNetworksAPI
DAY 6:
-> Before moving to ui part, Revise below topics-
-> MVVM design pattern and AndroidLifeCycle
-> Navigation Component and Data-Binding
-> Start understanding about 'ui.main' package
DAY 7:
-> Connect link between MainActivity, MainFragment, MainViewModel and MainRepository
-> Defining fragment in Navigation graph '.../res/navigation/nav_main.xml'
-> Declaring fragment view in '...res/layout/main_activity.xml'
-> Design layout for fragment in '.../res/layout/main_fragment.xml'
DAY 8:
-> Look more files under 'utils' package
-> Revise Broadcast Receiver and how it is used in project '.../utils/connectivity/ConnectivityBroadcastReceiver.kt'
-> Study about permissions '.../utils/permissions'
DAY 9:
Lot of learning have done so far. Its time to perform some practical task. 
-> Compile the project and run. If any error or exception logs in, try to solve it yourself taking help from google.
-> Once project runs successfully, create more fragments/ activities and connect them with networking layer.
DAY 10:
Queries and Evaluation Day
```
