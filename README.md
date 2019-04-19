# Android Kotlin Template

## Purpose

This project is a base template for most of my Kotlin-driven Android applications.

Rather than recreating and configuring again and again I have decided to prepare template that is easily configurable and mostly prepared.

## Compatibility

This application targets Android (5.0) Lollipop and newer.

## Capabilities

1. Application is split into four layers. All implemented in separate modules described below.
2. ***Application*** module (layer) produces `.apk` artifact.
3. ***Domain*** module (layer) that is publicly visible to application layer - implements business logic.
4. ***Network*** exposes networking to domain sub-layer and effectively hides it from application layer,
5. ***Persistence*** exposes database and settings to domain sub-layer and hides it from application layer.  
6. Dependencies and server uris are listed withing`versions.properties` file.
7. Mapping between layer models should be done using Model Mapper library.

## Hint

To simplify kick-starting new project and to make life easier when it comes to the need of changing:

- application name,
- module package,
- theme base name,
- style base name.

I've used a keyword `template` (and `co.windly.template` for module).

Just try to search the project for that word and do not hesitate to make required changes.

> Pull Request with Yeoman generator that simplifies generation of the project with configurable name/package is more than greatly appreciated.  
