package com.my.javabasic.designpattern.bridge.packagebuild;

public abstract class PackageBuildExecutor {

    protected PackageBuildProvider packageBuildProvider;

//    public PackageBuildExecutor(PackageBuildProvider packageBuildProvider) {
//        this.packageBuildProvider = packageBuildProvider;
//    }

    public void setPackageBuildProvider(PackageBuildProvider packageBuildProvider) {
        this.packageBuildProvider = packageBuildProvider;
    }

    public abstract PackageBuildResult execute(PackageBuildReq req);

}
