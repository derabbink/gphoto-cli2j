# gphoto-cli2j


A Java wrapper for the gphoto2 CLI, since libgphoto + JNA it too hard to implement


## What?

This is a library that runs [`gphoto2` cli][gphoto2-cli] commands behind the scenes and parses the output to get workable Java objects as a result.


## Why?

Theoretically, it could be possible to wrap [libgphoto][gphoto-api] in a layer of [JNA][jna] to gain access to a camera from within Java code, but I don't know enough about C *or* JNA to make that happen.<br/>
I'd love to see a JNA wrap around libgphoto, though.


## What Platform?

This library is developed on a Windows machine, but all `gphoto2` commands are run on a [Raspberry Pi][raspberry-pi] with [Raspbian][raspbian] Linux.
The (only) camera used in the development process is a [Canon PowerShot A520][powershot-A520], connected to said Raspberry Pi.<br/>
The intended target JVM is [Oracle Java SE Embedded 7][j-se-embedded] on said Raspbian-powered Raspberry Pi.


[gphoto2-cli]: http://gphoto.org/doc/manual/using-gphoto2.html
[gphoto-api]: http://gphoto.org/doc/api/
[jna]: https://github.com/twall/jna
[raspberry-pi]: http://www.raspberrypi.org
[raspbian]: http://www.raspbian.org/
[powershot-A520]: http://www.usa.canon.com/cusa/support/consumer/digital_cameras/powershot_a_series/powershot_a520
[j-se-embedded]: http://www.oracle.com/technetwork/java/embedded/overview/javase/index.html
