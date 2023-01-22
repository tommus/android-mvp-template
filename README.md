# Android Kotlin MVP Template

## Purpose

A base template for MVP-driven Kotlin-powered Android applications.

## Compatibility

This template assumes the lowest supported Android version is 8.1 Oreo.

## Project Modules

Template consists of the following modules:

1. **:application** - the main application module. Produces the `.apk` file.
3. **:base:android** - contains Android specific classes and utilities.
2. **:base:language** - exposes programming language specific extensions.
4. **:base:mvp** - implements simple Model-View-Presenter framework.
5. **:common:network** - exposes networking dependencies.
6. **:common:persistence** - exposes persistence dependencies.
7. **:configuration** - exposes application configuration via `Configuration`
   class. All those fields are gathered from `gradle.properties` file in this
   module.
8. **:resources** - accessible (and optionally injectable) application
   resources.

## Hint

To simplify kick-starting new project and adapt to your needs - you have to
change only few default values:

- `packageName` - \"`windly.template`\";
- `projectName` - \"`TemplateApplication`\";
- module package - \"`windly.template`\";
- theme base name - \"`Theme.Template`\";
- style base name - \"`Template`\";

> Consider searching for `template` phrase with disabled "match case" feature.

## Customizer shell script

Instead of manually customizing the project, you can also consider using the
`customizer.sh` shell script.

> Usage: bash customizer.sh my.new.package [ApplicationName]

For example, if you'd like to customize the project to use the following:

- package: dev.windly.solar
- application name: Solar

Execute the script as below:

```shell
bash customizer.sh dev.windly.solar Solar
```

As a result, the customizer shell script will change:

- root package name of all the modules
- application name
- base style and theme names

So, more or less - the project will be kicked off. :)
