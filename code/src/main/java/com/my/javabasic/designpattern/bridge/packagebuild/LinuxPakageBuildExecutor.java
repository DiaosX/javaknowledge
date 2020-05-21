package com.my.javabasic.designpattern.bridge.packagebuild;

public class LinuxPakageBuildExecutor extends PackageBuildExecutor {
    @Override
    public PackageBuildResult execute(PackageBuildReq req) {
        System.out.println("Linux操作系统");
        return this.packageBuildProvider.build(req);
    }
}
