NYPL-DRM-Android-Core
=====================

© NYPL Labs 2015

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

