DRM-Android-Core
=====================

[![Build Status](https://img.shields.io/github/workflow/status/NYPL-Simplified/DRM-Android-Core/Android%20CI%20(Authenticated)?style=flat-square)](https://github.com/NYPL-Simplified/DRM-Android-Core/actions?query=workflow%3A%22Android+CI+%28Authenticated%29%22)
[![Maven Central](https://img.shields.io/maven-central/v/org.librarysimplified.drm/org.librarysimplified.drm.core?style=flat-square)](https://repo1.maven.org/maven2/org/librarysimplified/drm/)
[![Maven Central (snapshot)](https://img.shields.io/nexus/s/https/oss.sonatype.org/org.librarysimplified.drm/org.librarysimplified.drm.core.svg?style=flat-square)](https://oss.sonatype.org/content/repositories/snapshots/org.librarysimplified.drm/)

![drm](./src/site/resources/drm.jpg?raw=true)

|Build|Status|
|-----|------|
|[Nightly, Authenticated, JDK 11](https://github.com/NYPL-Simplified/DRM-Android-Core/actions?query=workflow%3A%22Android+CI+%28Daily+Authenticated%2C+JDK+11%29%22)|[![Build Status](https://img.shields.io/github/workflow/status/NYPL-Simplified/DRM-Android-Core/Android%20CI%20(Daily%20Authenticated,%20JDK%2011)?style=flat-square)](https://github.com/NYPL-Simplified/DRM-Android-Core/actions?query=workflow%3A%22Android+CI+%28Daily+Authenticated%2C+JDK+11%29%22)|
|[Nightly, Unauthenticated, JDK 11](https://github.com/NYPL-Simplified/DRM-Android-Core/actions?query=workflow%3A%22Android+CI+%28Daily+Unauthenticated%2C+JDK+11%29%22)|[![Build Status](https://img.shields.io/github/workflow/status/NYPL-Simplified/DRM-Android-Core/Android%20CI%20(Daily%20Unauthenticated,%20JDK%2011)?style=flat-square)](https://github.com/NYPL-Simplified/DRM-Android-Core/actions?query=workflow%3A%22Android+CI+%28Daily+Unauthenticated%2C+JDK+11%29%22)|
|[Nightly, Unauthenticated, JDK 15](https://github.com/NYPL-Simplified/DRM-Android-Core/actions?query=workflow%3A%22Android+CI+%28Daily+Unauthenticated%2C+JDK+15%29%22)|[![Build Status](https://img.shields.io/github/workflow/status/NYPL-Simplified/DRM-Android-Core/Android%20CI%20(Daily%20Unauthenticated,%20JDK%2015)?style=flat-square)](https://github.com/NYPL-Simplified/DRM-Android-Core/actions?query=workflow%3A%22Android+CI+%28Daily+Unauthenticated%2C+JDK+15%29%22)|
|[Last Commit](https://github.com/NYPL-Simplified/DRM-Android-Core/actions?query=workflow%3A%22Android+CI+%28Authenticated%29%22)|[![Build Status](https://img.shields.io/github/workflow/status/NYPL-Simplified/DRM-Android-Core/Android%20CI%20(Authenticated)?style=flat-square)](https://github.com/NYPL-Simplified/DRM-Android-Core/actions?query=workflow%3A%22Android+CI+%28Authenticated%29%22)|

### Usage

Add a dependency on the core API:

```
implementation "org.librarysimplified.drm:org.librarysimplified.drm.core:1.1.0"
```

### Compilation

Make sure you clone this repository with `git clone --recursive`. 
If you forgot to use `--recursive`, then execute:

```
$ git submodule init
$ git submodule update --remote --recursive
```

1. Ensure that the location of your Android SDK is specified in `local.properties`.
   For example:

```
$ cat local.properties
sdk.dir=/path/to/android-sdk
```

2. Build the code:

```
$ ./gradlew clean assemble test
```

3. Optionally publish the code to your local Maven repository:

```
$ ./gradlew clean assemble test publishToMavenLocal
```

### Project Structure

|Module|Description|
|------|-----------|
| [org.librarysimplified.drm.core](https://github.com/NYPL-Simplified/DRM-Android-Core/tree/develop/org.librarysimplified.drm.core) | Core API
| [org.librarysimplified.drm.core.tests](https://github.com/NYPL-Simplified/DRM-Android-Core/tree/develop/org.librarysimplified.drm.core.tests) | Unit tests

### License

```
© 2015 The New York Public Library, Astor, Lenox, and Tilden Foundations

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
or implied. See the License for the specific language governing
permissions and limitations under the License.
```
