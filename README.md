# 概述

[中文文档](README.md) | [English Document](README_en.md)

[Github](https://github.com/DragonKnightOfBreeze/Starbound-Text)

Starbound文本支持。

编写这个插件是为了便于维护和更新
[Frackin Universe汉化项目](https://github.com/ProjectSky/FrackinUniverse-sChinese-Project)。

示例：

```
This is some ^red;red^reset; text.
And this is some ^#f8f8f8;custom color^reset; text.
```
 
主要功能：

1. 语法解析。
2. 颜色标记的代码补全和代码折叠。
3. 使用对应的颜色高亮彩色文本。
4. 提供快速插入彩色文本的动态模版，在正确的位置输入`color`即可看到。

注意：
这个插件不提供默认的文件后缀名以关联`Starbound文本`语言，
请自定义文件类型或者使用语言注入功能。

# 参考

* 更多信息：[plugin.xml](src/main/resources/META-INF/plugin.xml)
* 更新日志：[CHANGELOG.md](CHANGELOG.md)
