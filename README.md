# Extract ProtobufJS Messages from Generated Java Classeses

[![Maven Central](https://img.shields.io/maven-central/v/io.github.hbmartin/flipper-plugin-stetho?color=6D3DEE)](https://repo.maven.apache.org/maven2/io/github/hbmartin/flipper-plugin-stetho/)
[![reviewdog badge](https://github.com/hbmartin/flipper-plugin-stetho/actions/workflows/reviewdog.yml/badge.svg)](https://github.com/hbmartin/flipper-plugin-stetho/actions/workflows/reviewdog.yml)
[![CodeFactor](https://www.codefactor.io/repository/github/hbmartin/flipper-plugin-stetho/badge)](https://www.codefactor.io/repository/github/hbmartin/flipper-plugin-stetho)
[![GitHub issues](https://img.shields.io/github/issues/hbmartin/flipper-plugin-stetho)](https://github.com/hbmartin/flipper-plugin-stetho/issues)

Drop in replacement for Stetho to expose dumper plugins in Flipper

## Download

Install in your build.gradle:

```
dependencies {
  implementation 'io.github.hbmartin:flipperstetho:0.1.1'
}
```


## Usage

Instantiate `StethoFlipperPlugin` with a list of the stetho/dumper plugins to expose. Then add that plugin to Flipper. See the demo app.


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
