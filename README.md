# Android Kotlin Template

## Purpose

This project is a base template for most of my Kotlin-driven Android applications.

Rather than recreating and configuring again and again I have decided to prepare template that is easily configurable
and mostly prepared.

## Compatibility

This application targets Android (5.0) Lollipop and newer.

## Capabilities

1. Application is split into four layers. All implemented in separate modules described below;
2. ***Application*** module (layer) produces `.apk` artifact;
3. ***Domain*** module (layer) that is publicly visible to application layer - implements business logic;
4. ***Network*** exposes networking to domain sub-layer and effectively hides it from application layer;
5. ***Persistence*** exposes database and settings to domain sub-layer and hides it from application layer;  
6. ***Utility*** implements various utility / device-related tools;
7. Dependencies and server uris are listed withing`versions.properties` file;
8. Mapping between layer models should be done using Model Mapper library.

## Dependency Injection

***Dagger*** is configured as dependency injection tool. 

Application layers is injected using the following facade:

- ***UtilityModule*** is exposed to higher-level layers;
- ***PersistenceModule*** is exposed for later use within `DomainModule`;
- ***NetworkModule*** is exposed for later use within `DomainModule`;
- ***DomainModule*** is exposed as ***singleton*** scoped component for later use within `ApplicationModule` / `PresentationModule`;
- ***PresentationModule*** is exposed for later use withing `ApplicationComponent`;
- ***ApplicationComponent*** is exposed as ***application*** scoped component that depends on `DomainComponent`.

`DomainComponent` was implemented as ***dependant*** component. Being said, only exposed (via component interface) 
dependencies will be available from `ApplicationComponent` and it's modules.

This way, the ***network*** and ***persistence*** layer is completely hidden from ***application*** perspective (no
explicit `api` dependencies are present in respective `build.gradle` files).

In result, ***application*** layer might be considered ***data source agnostic*** (it does not even know where the data
comes from - it is just there) making an implementation of ***Single-Source-Of-Truth*** way easier.

## Hint

To simplify kick-starting new project and adapt to your needs - you have to change only few default values:

- application name - \"`Template`\";
- module package - \"`co.windly.template`\";
- theme base name - \"`TemplateTheme`\".

> Consider searching for `template` phrase with disabled "match case" feature.

## Template Generation

Pull Request with Yeoman generator that simplifies generation of the project with configurable name/package is more 
than greatly appreciated. :)
