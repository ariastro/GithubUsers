<h1 align="center">GithubUser</h1>

<p align="center">
  <a href="https://github.com/ariastro/GithubUsers/blob/master/LICENSE.txt"><img alt="License" src="https://img.shields.io/github/license/ariastro/GithubUsers.svg"/></a>
  <a href="https://android-arsenal.com/api?level=26"><img alt="API" src="https://img.shields.io/badge/API-26%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://github.com/ariastro/GithubUsers/issues"><img alt="Issues" src="https://img.shields.io/github/issues/ariastro/GithubUsers.svg"/></a> 
  <a href="https://linkedin.com/in/arisws"><img alt="Linkedin" src="https://img.shields.io/badge/-LinkedIn-black.svg?logo=linkedin&colorB=555"/></a> 
</p>

<p align="center">
GithubUsers demonstrates modern Android development with Clean Architecture using Jetpack Compose, Hilt, Coroutines, Flow, Room, ViewModel, and Material Design based on MVVM architecture.
<br />
<br />
<a href="https://github.com/ariastro/GithubUsers/issues">Report Bug</a>
·
<a href="https://github.com/ariastro/GithubUsers/issues">Request Feature</a>
</p>
</div>


## Screenshots
<table>
  <tr>
    <td> <img src="https://github.com/ariastro/GithubUsers/blob/main/preview/preview1.png"  alt="1" height = 500px ></td>
    <td><img src="https://github.com/ariastro/GithubUsers/blob/main/preview/preview2.png" alt="2" height = 500px></td>
   </tr> 
</table>

## Download
Go to the [Releases](https://github.com/ariastro/GithubUsers/releases) to download the latest APK.


## Tech stack & Open-source libraries
- Minimum SDK level 26
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- Jetpack
  - [Compose](https://developer.android.com/jetpack/compose): Modern toolkit for building native UI
  - Lifecycle: Observe Android lifecycles and handle UI states upon the lifecycle changes.
  - ViewModel: Manages UI-related data holder and lifecycle aware. Allows data to survive configuration changes such as screen rotations.
  - Room: Constructs Database by providing an abstraction layer over SQLite to allow fluent database access.
  - [Hilt](https://dagger.dev/hilt/): for dependency injection.
- Architecture
  - Clean Architecture
  - MVVM Architecture (Model - View - ViewModel)
  - Repository Pattern
- [Compose Destination](https://github.com/raamcosta/compose-destinations): A KSP library that processes annotations and generates code that uses Official Jetpack Compose Navigation under the hood.
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit): Construct the REST APIs and paging network data.
- [Sandwich](https://github.com/skydoves/Sandwich): Construct a lightweight and modern response interface to handle network payload for Android.
- [Moshi](https://github.com/square/moshi/): A modern JSON library for Kotlin and Java.
- [ksp](https://github.com/google/ksp): Kotlin Symbol Processing API.
- [Material-Components](https://github.com/material-components/material-components-android): Material design components for building ripple animation, and CardView.
- [Landscapist](https://github.com/skydoves/landscapist): Image loading library for compose using Glide, Coil, and Fresco.
- [Timber](https://github.com/JakeWharton/timber): A logger with a small, extensible API.


<!-- GETTING STARTED -->
## Getting Started

To set up a local copy of the project and get it runs smoothly on your machine, you can follow these easily accomplished straightforward steps:

### Installation

1. Get a Github Token at [Github](https://github.com/settings/tokens)
2. Clone the repo
```sh
git clone https://github.com/ariastro/GithubUsers.git
```
4. Enter your Github Token in `local.properties`
```
GITHUB_TOKEN = "YOUR_TOKEN"
```
5. Sync Project and Build Project
6. Enjoy!


<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


## Why MVVM?
MVVM (Model-View-ViewModel) remains a popular architectural pattern for Android development for several reasons:
- **Separation of Concerns**: Separation of concerns is an important principle of software development. It allows you to focus on one aspect of a problem at a time, which makes it easier to reason about complex systems. MVVM helps you separate concerns by keeping your UI code separate from your business logic code.
  - Model (Data): Represents the data and business logic.
  - View (UI): Represents the UI components.
  - ViewModel: Acts as a mediator between the Model and the View. It holds and manages the UI-related data needed by the View and handles user interactions.
- **Maintainability & Testability**: The separation of concerns that MVVM provides makes your code simpler to maintain and test. You can replace one piece of code without affecting another.
- **Reusability**: ViewModel instances can be more easily reused across different UI components. This is particularly useful in scenarios where the same data or logic needs to be displayed or used in multiple places.

<!-- CONTACT -->
## Contact

Ari SWS - ariastronout@gmail.com

Project Link: [https://github.com/ariastro/GithubUsers](https://github.com/ariastro/GithubUsers)

## Find this repository useful? :heart:
Support it by joining __[stargazers](https://github.com/ariastro/GithubUsers/stargazers)__ for this repository. :star: <br>
Also, __[follow me](https://github.com/ariastro)__ on GitHub for my next creations! 🤩


<!-- LICENSE -->
# License
```xml
Copyright 2023 Ari SWS. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
