# LUR

LUR is a novel coordinate system, and accompanying 2d utilities for using hexagons.
It stands for Left, Up, Right.
The default (primary) orientation is with the flat sides vertical, and the points horizontal.
This means that the 'Left' direction is 'Left and down')', and that the 'Right' direction ir 'Right and down'. The 'Up' diretion is 'straight up'.

Although there are 3 coordinates, one or more of them will be zero when in normalized form.

The current Java level is 1.7, so that this library can be consumed by libGDX projects.

# Developing

* `./gradlew test` Runs tests
* `./gradlew lur-swing:run` Runs the swing playground


## Verifying java versions
Example - do a full build or test

Expect " major version: 52": 
`javap -verbose lur-test/build/classes/java/test/com/kncept/lur/IntegerLurCoordTest.class | grep major`

Expect "major version: 51"
`javap -verbose lur-library/build/classes/java/main/com/kncept/lur/IntegerLurCoord.class | grep major`

Java Class [versions](https://javaalmanac.io/bytecode/versions/):
```
Java 1.0 	45.0
Java 1.1 	45.3
Java 1.2 	46.0
Java 1.3 	47.0
Java 1.4 	48.0
Java 5  	49.0
Java 6  	50.0
Java 7  	51.0
Java 8  	52.0
Java 9  	53.0
Java 10 	54.0
Java 11 	55.0
Java 12 	56.0
Java 13 	57.0
Java 14 	58.0
Java 15 	59.0
Java 16 	60.0
Java 17 	61.0
Java 18 	62.0
Java 19 	63.0
Java 20 	64.0
Java 21 	65.0
Java 22 	66.0
```


# Reelaseing to OSSRH
Yeah, old ossrh. And the multitude of touchy problems when publishing to it.

`clear && ./gradlew clean && GITHUB_REF_NAME=v0.0.1 ./gradlew  publish --info | tee output.log` and do a clicky-release
or
`GITHUB_REF_NAME=v0.0.1 ./gradlew publishToSonatype closeSonatypeStagingRepository`
?