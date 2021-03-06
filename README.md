# Flipper Plugin to Replace Stetho

[![npm](https://img.shields.io/npm/v/flipper-plugin-stetho?color=%23FEE933)](https://www.npmjs.com/package/flipper-plugin-stetho)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.hbmartin/flipper-stetho-plugin?color=6D3DEE)](https://repo.maven.apache.org/maven2/io/github/hbmartin/flipper-stetho-plugin/)
[![CI](https://github.com/hbmartin/flipper-plugin-stetho/actions/workflows/main.yml/badge.svg)](https://github.com/hbmartin/flipper-plugin-stetho/actions/workflows/main.yml)
[![CodeFactor](https://www.codefactor.io/repository/github/hbmartin/flipper-plugin-stetho/badge)](https://www.codefactor.io/repository/github/hbmartin/flipper-plugin-stetho)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=hbmartin_flipper-plugin-stetho&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=hbmartin_flipper-plugin-stetho)
[![GitHub issues](https://img.shields.io/github/issues/hbmartin/flipper-plugin-stetho)](https://github.com/hbmartin/flipper-plugin-stetho/issues)

Drop in replacement for Stetho to expose dumper plugins in Flipper

![Demo screenshot](demo.png)

## Download

Install in your build.gradle:

```
dependencies {
  implementation 'io.github.hbmartin:flipper-stetho-plugin:0.2.0'
}
```


## Usage

Instantiate `StethoFlipperPlugin` with a list of the stetho/dumper plugins to expose and add that plugin to Flipper. This is typically done in your `Application`'s `onCreate`. See the demo app.

```
client.addPlugin(StethoFlipperPlugin(listOf(MyDumperPlugin())))
```
Or if you are already injecting a list of dumper plugins, i.e. with Dagger, then you can continue to use that:

```
client.addPlugin(StethoFlipperPlugin(dumperPluginsProvider.get()))
```

## Contributing

* [PRs](https://github.com/hbmartin/flipper-plugin-stetho/pulls) and [bug reports / feature requests](https://github.com/hbmartin/flipper-plugin-stetho/issues) are all welcome!
* Kotlin is linted with [ktlint](https://github.com/pinterest/ktlint) via [ktlint-gradle](https://github.com/JLLeitschuh/ktlint-gradle/tags) and performs static analysis with [detekt](https://github.com/detekt/detekt)
* Treat other people with helpfulness, gratitude, and consideration! See the [Android SE CoC](https://android.stackexchange.com/conduct)

## License

MIT License

Copyright (c) Harold Martin

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
