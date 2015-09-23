DRM-Android-Core
=====================

## Modules

### nypl-drm-core

The `nypl-drm-core` module provides the core DRM types. Applications
are expected to depend on this module regardless of whether or not
they have support for DRM enabled (because it provides classes that
attempt to load DRM libraries at run-time).

### nypl-drm-core-tests

The `nypl-drm-core-tests` module provides unit tests that will be
executed on an attached Android device during the build.

### nypl-drm-checkstyle

The `nypl-drm-checkstyle` module contains the
[Checkstyle](https://github.com/checkstyle/checkstyle) policy used
for all Java code in the package.

## Building

The build requires Maven and the Android SDK. After deploying
Android `4.4.2_r4` to an accessible Maven repository (using the
[maven-android-sdk-deployer](https://github.com/simpligility/maven-android-sdk-deployer)),
build the package with:

```$ mvn clean package```

If no Android device is attached, it will not be possible to
execute the test suite and this will typically cause the build
to fail. In order to produce a build without running any tests,
use:

```$ mvn clean package -Dmaven.test.skip=true```

## License

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
