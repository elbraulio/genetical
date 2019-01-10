[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/elbraulio/genetical/blob/master/LICENSE) [![Build Status](https://travis-ci.org/elbraulio/genetical.svg?branch=master)](https://travis-ci.org/elbraulio/genetical) [![](https://jitpack.io/v/com.elbraulio/genetical.svg)](https://jitpack.io/#com.elbraulio/genetical) [![](https://img.shields.io/badge/javadocs-ok-green.svg)](https://jitpack.io/com/elbraulio/genetical/latest/javadoc/) [![codecov](https://codecov.io/gh/elbraulio/genetical/branch/master/graph/badge.svg) ](https://codecov.io/gh/elbraulio/genetical) [![codebeat badge](https://codebeat.co/badges/8a7c33db-0a64-4518-98bb-25e99e4c1db1)](https://codebeat.co/projects/github-com-elbraulio-genetical-master)



__genetical__ is a java tool for using genetic algorithm.

# 1. Install

#### maven

```xml
<dependencies>
    ...
    <dependency>
        <groupId>com.elbraulio</groupId>
        <artifactId>genetical</artifactId>
        <version>{version}</version>
    </dependency>
</dependencies>

<!-- elbraulio.com tools -->
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
```



#### gradle

```groovy
dependencies {
        implementation 'com.elbraulio:genetical:{version}'
}
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

# 2. How to use

## 2.1 Indiviual and genes

You can define whatever you want as gene, then you will have a _Individual_ who has those genes. __genetical__ provides a `DefaultIndividual` who only stores a list of _genes_ and give them when someone requieres it.

For instance, we can have a _genes_ as String

```java
List<String> genes = buildGenes();
Individual<String> stringIndividual = new DefaultIndividual(genes);
```

## 2.2 Population

A _population_ is defined as a collection of _Individuals_ that can cross each others. So, for instance we can create a _Population_ of _Individuals_ with genes as String

```java
Population<String> startPop = new DefaultPopulation<>(stringIndividual);
```

and we can evolve it to create a new _Population_ (generation) of _Individuals_ by defining a way to evolve.

### 2.2.1 evolve

___genetical__ provide a default evolve wich is _FittestEvolve_, wich needs a __FittestSelection__, __Crosses__ and __Mutation__.

#### FittestSelection

Follows the concept of [Natural Selection](https://en.wikipedia.org/wiki/Natural_selection). Wich says that the fittest individual will survive and reproduce.

#### Crosses

Defines the way that two _Individuals_ will cross.

#### Mutation

Make mutations to the decendant's genes  after the cross.

# 2.3 Evolve

You have to use `evolve()` method and you will get a new _Population_ which is a new generation of _Individuals_.

```java
Population<String> nextGeneration = startPop.evolve(
                            new FittestEvolve<>(
                                    (individuals) -> { return /* fittest */},
                                    (genesA, genesB) -> { return /* crossed genes */},
                                    (genes) -> { return /* mutated genes */}
                            )
                    );
```

