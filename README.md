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