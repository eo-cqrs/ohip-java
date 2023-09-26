[![Managed By Self XDSD](https://self-xdsd.com/b/mbself.svg)](https://self-xdsd.com/p/eo-cqrs/ohip-java?provider=github)

[![EO principles respected here](https://www.elegantobjects.org/badge.svg)](https://www.elegantobjects.org)
[![DevOps By Rultor.com](https://www.rultor.com/b/eo-cars/ohip-java)](https://www.rultor.com/p/eo-cqrs/ohip-java)
[![We recommend IntelliJ IDEA](https://www.elegantobjects.org/intellij-idea.svg)](https://www.jetbrains.com/idea/)
<br>

[![mvn](https://github.com/eo-cqrs/ohip-java/actions/workflows/mvn.yml/badge.svg)](https://github.com/eo-cqrs/ohip/actions/workflows/mvn.yml)
[![maven central](http://maven-badges.herokuapp.com/maven-central/io.github.eo-cqrs/ohip-java/badge.svg)](https://search.maven.org/artifact/io.github.eo-cqrs/ohip-java)
[![javadoc](https://javadoc.io/badge2/io.github.eo-cqrs/ohip-java/javadoc.svg)](https://javadoc.io/doc/io.github.eo-cqrs/ohip-java)
[![codecov](https://codecov.io/gh/eo-cqrs/eo-kafka/branch/master/graph/badge.svg?token=4IFT0H3Y01)](https://codecov.io/gh/eo-cqrs/eo-kafka)

[![Hits-of-Code](https://hitsofcode.com/github/eo-cqrs/ohip-java)](https://hitsofcode.com/view/github/eo-cqrs/ohip-java)
[![Lines-of-Code](https://tokei.rs/b1/github/eo-cqrs/ohip-java)](https://github.com/eo-cqrs/ohip-java)
[![PDD status](http://www.0pdd.com/svg?name=eo-cqrs/ohip-java)](http://www.0pdd.com/p?name=eo-cqrs/ohip-java)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/eo-cqrs/ohip-java/blob/master/LICENSE.txt)

Project architect: [@h1alexbel](https://github.com/h1alexbel)

Java Object-Oriented Wrapper of [OHIP](https://www.oracle.com/hospitality/integration-platform/) API.

**Motivation**. We are lacking off some wrapper for OHIP API 
to simplify API calls and reuse configuration.
we are suggesting this capability through small and cohesive objects.

**Principles**. These are the [design principles](https://www.elegantobjects.org/#principles) behind this wrapper.

**How to use**. All you need is this (get the latest version [here](https://search.maven.org/artifact/io.github.eo-cqrs/ohip)):

Maven:
```xml
<dependency>
  <groupId>io.github.eo-cqrs</groupId>
  <artifactId>ohip</artifactId>
</dependency>
```

Gradle:
```groovy
dependencies {
    compile 'io.github.eo-cqrs:ohip:<version>'
}
```

## Accessing OHIP

TBD..

## How to Contribute

Fork repository, make changes, send us a [pull request](https://www.yegor256.com/2014/04/15/github-guidelines.html).
We will review your changes and apply them to the `master` branch shortly,
provided they don't violate our quality standards. To avoid frustration,
before sending us your pull request please run full Maven build:

```bash
$ mvn clean install
```

You will need Maven 3.8.7+ and Java 17+.

If you want to contribute to the next release version of eo-kafka, please check the [project board](https://github.com/orgs/eo-cqrs/projects/2/views/1).

Our [rultor image](https://github.com/eo-cqrs/eo-kafka-rultor-image) for CI/CD.
