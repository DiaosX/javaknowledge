package com.my.javabasic.designpattern.bridge.packagebuild;

public class AndroidPakageBuildExecutor extends PackageBuildExecutor {
    @Override
    public PackageBuildResult execute(PackageBuildReq req) {
        System.out.println("Android操作系统");
        return this.packageBuildProvider.build(req);
    }
}
