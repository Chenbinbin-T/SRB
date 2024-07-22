package com.atguigu.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.model.AccessControlList;
import com.aliyun.oss.model.CannedAccessControlList;
import org.junit.Test;

public class OSSTest {
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    String endpoint = "oss-cn-beijing.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    String accessKeyId = "LTAI5tMXBtD9hh6bR2pYPBP5";
    String accessKeySecret = "9RszkABjk4GGqKoewG2s2YRX3TOZNT";
    String bucketName = "srb-file-cbb-1";

    // 用代码测试阿里云OSS的Bucket创建
    @Test
    public void testCreateBucket() {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 创建存储空间。
        ossClient.createBucket(bucketName);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    // 判断bucket是否存在
    @Test
    public void testExist() {

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        boolean exists = ossClient.doesBucketExist(bucketName);
        System.out.println(exists);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    // 设置bucket访问权限
    @Test
    public void testSetBucketAcl() {

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 设置存储空间的访问权限为：公共读。
        ossClient.setBucketAcl(bucketName, CannedAccessControlList.Private);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    // 获取bucket的访问权限的具体信息
    @Test
    public void testGetBucketAcl(){
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 获取bucket的访问权限的具体信息
        AccessControlList bucketAcl = ossClient.getBucketAcl(bucketName);
        System.out.println(bucketAcl.toString());

        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
