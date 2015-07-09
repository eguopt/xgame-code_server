# 关于 Xgame
Xgame 是一个基于 Java 语言实现的 SLG 游戏服框架。其中包括服务器、日志服、Web 代理代码及周边工具。
（游戏客户端项目前还没有提交任何代码）
Xgame 消息层使用 MINA，IO 采用 EclipseLink + MySQL，场景服务为单线程架构。
这套框架的最初来源是“人人游戏”的服务器架构，
当然，仅限于实现思路而不是代码……
Xgame 参考了以往的经验，同时也做出了很多改进！
例如：

- 将消息解码与消息黏包算法分开；
- 自定义的消息加密算法；
- 修改 IoOperation 的返回值为 boolean 类型，以避免死循环（纠正了原框架不严谨的地方）；
- 使用通用 Dao 代码，减少无用的 Dao 派生类；
- 使用 Javassist 技术动态创建并编译 Excel 模板类；
- Excel 模板类支持多层嵌套（理论上没有上限）；
- 使用 Javassist 技术动态创建并编译消息类；
- 消息类支持多层嵌套（理论上没有上限）；
- 修改延迟保存罗辑（LazySaving），使用起来更方便、更明确，只实现 ILazySavingObj 接口即可；
- 日志服务器框架调整为 HTTP 方式；
- 结构化的 ANT 打包脚本；
- 调整机器人压力测试项目，简化框架结构；

----
# 欢迎加入 QQ 群：327606822
----

# Xgame 宗旨

- 精确；
- 极简；
- 注重架构设计的同时，对代码风格的要求极严苛；
- 有意思；

关于“有意思”这件事，后续的文档中会陆续展现……

----

# 后续更新内容

- 【文档】增加 IntelliJ IDEA 开发说明，如何使用 IntelliJ IDEA 打开该项目；
- 【文档】增加 Eclipse 开发说明，如何使用 Eclipse 打开该项目；
- 【文档】增加 ANT 编译打包说明；
- 【代码】完善 Robot 压力测试工具代码；
- 【代码】增加登陆过程代码；
- 【代码】增加 CommDao 增加缓存机制；
- 【代码】增加游戏服（GameServer）的 HTTP 支持；
- 【代码】增加游戏服（GameServer）的 ZooKeeper 支持；
- 【代码】完善日志服务器代码；
- 【代码】增加消息类生成工具，由 JAVA 代码生成 ActionScript 或者 C# 代码；
- ...

----

# 如何使用 IDE 打开这个项目?

*Windows 平台 + IntelliJ IDEA（推荐）：*
> cd C:\Git

> git clone https://git.oschina.net/afrxprojs/xgame-code_server.git

> cd xgame-code_server

> unzip IDEA.zip 

> \# 如果你使用的是 IntelliJ IDEA 则解压 IDEA.zip 文件

> \# 要解压 IDEA.zip 也可以使用其它压缩软件，例如：WinZip、WinRAR

> \# 或者干脆直接双击 IDEA.zip 也可以

> \# 如果提示覆盖文件，直接覆盖就可以了

> 运行 IntelliJ IDEA，在主菜单中选择“File -> Open ...”，在弹出对话框中选择：C:\Git\xame-code_server

> \# 提示：JAVA 版本请选择 1.8，名称要用 jdk1.8 噢



*Windows 平台 + Eclipse*
>[Wiki/如何在 Windows 平台使用 Eclipse 打开项目](https://git.oschina.net/afrxprojs/xgame-code_server/wikis/%E5%A6%82%E4%BD%95%E5%9C%A8-Windows-%E5%B9%B3%E5%8F%B0%E4%BD%BF%E7%94%A8-Eclipse-%E6%89%93%E5%BC%80%E9%A1%B9%E7%9B%AE)