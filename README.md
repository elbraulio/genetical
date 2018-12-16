[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/elbraulio/genetical/blob/master/LICENSE) [![Build Status](https://travis-ci.org/elbraulio/genetical.svg?branch=master)](https://travis-ci.org/elbraulio/genetical) [![](https://jitpack.io/v/com.elbraulio/genetical.svg)](https://jitpack.io/#com.elbraulio/genetical) [![](https://img.shields.io/badge/javadocs-ok-green.svg)](https://jitpack.io/com/elbraulio/genetical/latest/javadoc/) [![codecov](https://codecov.io/gh/elbraulio/genetical/branch/master/graph/badge.svg) ](https://codecov.io/gh/elbraulio/genetical) [![codebeat badge](https://codebeat.co/badges/8a7c33db-0a64-4518-98bb-25e99e4c1db1)](https://codebeat.co/projects/github-com-elbraulio-genetical-master)



# How to use

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

<!-- for genetical -->
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