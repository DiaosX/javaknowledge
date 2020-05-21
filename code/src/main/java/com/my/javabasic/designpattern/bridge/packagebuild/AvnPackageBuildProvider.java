package com.my.javabasic.designpattern.bridge.packagebuild;

public class AvnPackageBuildProvider extends PackageBuildProvider {
    @Override
    public PackageBuildResult build(PackageBuildReq req) {
        System.out.println("Avn");
        PackageBuildResult result = new PackageBuildResult();
        result.setMessage("Avn");
        result.setSuccess(true);
        return result;
    }
}
