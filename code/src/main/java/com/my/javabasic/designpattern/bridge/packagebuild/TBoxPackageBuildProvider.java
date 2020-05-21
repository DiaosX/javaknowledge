package com.my.javabasic.designpattern.bridge.packagebuild;

public class TBoxPackageBuildProvider extends PackageBuildProvider {
    @Override
    public PackageBuildResult build(PackageBuildReq req) {
        System.out.println("TBox");
        PackageBuildResult result = new PackageBuildResult();
        result.setMessage("Tbox");
        result.setSuccess(true);
        return result;
    }
}
