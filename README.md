# Android Kotlin MVP Template

## Purpose

A base template for MVP-driven Kotlin-powered Android applications.

## Compatibility

This template assumes the lowest supported Android version is 8.1 Oreo.

## Project Modules

Template consists of the following modules:

1. **application** - the main application module. Produces the `.apk` file.
2. **base** - exposes programming language specific extensions.
3. **base-android** - contains Android specific classes and utilities.
4. **base-mvp** - implements simple Model-View-Presenter framework.
5. **common-network** - exposes networking dependencies.
6. **common-persistence** - exposes persistence dependencies.
7. **configuration** - exposes application configuration via `Configuration`
   class. All those fields are gathered from `gradle.properties` file in this
   module.
8. **resources** - accessible (and optionally injectable) application resources.

## Hint

To simplify kick-starting new project and adapt to your needs - you have to
change only few default values:

- `packageName` - \"`windly.template`\";
- `projectName` - \"`TemplateApplication`\";
- module package - \"`windly.template`\";
- theme base name - \"`Theme.Template`\";
- style base name = \"`Template`\";

> Consider searching for `template` phrase with disabled "match case" feature.

## Template Generation

Pull Request with Yeoman generator that simplifies generation of the project
with configurable name/package is more than greatly appreciated. :)
