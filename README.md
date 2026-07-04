# Geospacial

A Java library based on algorithms described by Chris Veness.  See Chris' excelent paper here:

http://www.movable-type.co.uk/scripts/latlong.html

## Installation
Add this to your `pom.xml`:
```xml
<dependency>
    <groupId>com.saltygeek</groupId>
    <artifactId>geospacial</artifactId>
    <version>0.1.0</version>
</dependency>
```

## Examples
You can use either degrees or radians.  Just pick the appropriate class.

To find a location based on a source location, a heading, and a distance, do this:

```java
LatLng src = new LatLngDegrees(48.390081, -123.414670);
LatLng dst = src.destinationPoint(1000, LatLngDegrees.S);
```

If you want to measure the distance between two know points, do this:

```java
LatLng src = new LatLngRadians(48.390081, -123.414670);
LatLng dst = new LatLngRadians(47.100231, -123.03210);
System.out.println("Distance from A to B is " + src.distance(dst));
```

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

Copyright (C) 2026, Glen Dinsmore
