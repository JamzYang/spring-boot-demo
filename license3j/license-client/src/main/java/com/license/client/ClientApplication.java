package com.license.client;

import javax0.license3j.HardwareBinder;
import javax0.license3j.License;
import javax0.license3j.io.IOFormat;
import javax0.license3j.io.LicenseReader;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.TimeZone;

@SpringBootApplication
public class ClientApplication {

    private static byte[] key = new byte[]{
            (byte) 0x52,
            (byte) 0x53, (byte) 0x41, (byte) 0x00, (byte) 0x30, (byte) 0x82, (byte) 0x01, (byte) 0x22, (byte) 0x30,
            (byte) 0x0D, (byte) 0x06, (byte) 0x09, (byte) 0x2A, (byte) 0x86, (byte) 0x48, (byte) 0x86, (byte) 0xF7,
            (byte) 0x0D, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x05, (byte) 0x00, (byte) 0x03, (byte) 0x82,
            (byte) 0x01, (byte) 0x0F, (byte) 0x00, (byte) 0x30, (byte) 0x82, (byte) 0x01, (byte) 0x0A, (byte) 0x02,
            (byte) 0x82, (byte) 0x01, (byte) 0x01, (byte) 0x00, (byte) 0x8D, (byte) 0x46, (byte) 0xB5, (byte) 0xD4,
            (byte) 0x27, (byte) 0xB2, (byte) 0xBA, (byte) 0x8D, (byte) 0x81, (byte) 0x09, (byte) 0x38, (byte) 0x7A,
            (byte) 0xBD, (byte) 0x61, (byte) 0xC4, (byte) 0x2A, (byte) 0x1C, (byte) 0x54, (byte) 0x8D, (byte) 0x96,
            (byte) 0xC4, (byte) 0xDB, (byte) 0x74, (byte) 0xE2, (byte) 0x5B, (byte) 0xE7, (byte) 0x12, (byte) 0x1C,
            (byte) 0xEA, (byte) 0xB0, (byte) 0xF0, (byte) 0xC5, (byte) 0x03, (byte) 0x2D, (byte) 0x2F, (byte) 0x31,
            (byte) 0x18, (byte) 0x41, (byte) 0x94, (byte) 0x64, (byte) 0x7F, (byte) 0x09, (byte) 0x48, (byte) 0xF5,
            (byte) 0x52, (byte) 0x74, (byte) 0x88, (byte) 0x60, (byte) 0x6B, (byte) 0x3A, (byte) 0xC2, (byte) 0xD7,
            (byte) 0xB9, (byte) 0x63, (byte) 0x5A, (byte) 0x40, (byte) 0xC5, (byte) 0x88, (byte) 0xB8, (byte) 0x86,
            (byte) 0x7A, (byte) 0x47, (byte) 0xBB, (byte) 0x48, (byte) 0x4B, (byte) 0x70, (byte) 0x35, (byte) 0xAE,
            (byte) 0x58, (byte) 0x89, (byte) 0x09, (byte) 0x8E, (byte) 0x78, (byte) 0x74, (byte) 0x8D, (byte) 0x13,
            (byte) 0x8C, (byte) 0x0B, (byte) 0xB0, (byte) 0xD3, (byte) 0x50, (byte) 0x99, (byte) 0x9D, (byte) 0x32,
            (byte) 0xF6, (byte) 0x2F, (byte) 0x50, (byte) 0xC1, (byte) 0xF7, (byte) 0x23, (byte) 0x31, (byte) 0xBC,
            (byte) 0xC1, (byte) 0xCC, (byte) 0x61, (byte) 0x6A, (byte) 0xC3, (byte) 0x54, (byte) 0x8D, (byte) 0xDB,
            (byte) 0xC7, (byte) 0x5D, (byte) 0xBB, (byte) 0xC1, (byte) 0xB8, (byte) 0x78, (byte) 0x6D, (byte) 0x5D,
            (byte) 0xF0, (byte) 0xF9, (byte) 0x26, (byte) 0xAD, (byte) 0x2C, (byte) 0x06, (byte) 0x8C, (byte) 0xF9,
            (byte) 0x2B, (byte) 0xA3, (byte) 0x47, (byte) 0x39, (byte) 0xEE, (byte) 0x60, (byte) 0x22, (byte) 0x2E,
            (byte) 0x34, (byte) 0x1F, (byte) 0x2E, (byte) 0x1A, (byte) 0x61, (byte) 0x82, (byte) 0x4C, (byte) 0x5B,
            (byte) 0xAF, (byte) 0x4E, (byte) 0x37, (byte) 0xC3, (byte) 0xB8, (byte) 0x20, (byte) 0xCE, (byte) 0x21,
            (byte) 0xFF, (byte) 0x46, (byte) 0x59, (byte) 0xC2, (byte) 0xFA, (byte) 0xEF, (byte) 0x84, (byte) 0x67,
            (byte) 0x0D, (byte) 0x07, (byte) 0xE3, (byte) 0x31, (byte) 0xBB, (byte) 0xF0, (byte) 0x91, (byte) 0x1B,
            (byte) 0x9F, (byte) 0xED, (byte) 0x30, (byte) 0x00, (byte) 0xBE, (byte) 0x3A, (byte) 0xA8, (byte) 0x7B,
            (byte) 0xDC, (byte) 0xC6, (byte) 0x63, (byte) 0x10, (byte) 0xB8, (byte) 0x00, (byte) 0xEB, (byte) 0x91,
            (byte) 0xC7, (byte) 0x56, (byte) 0x89, (byte) 0x18, (byte) 0x9C, (byte) 0x52, (byte) 0x0B, (byte) 0x21,
            (byte) 0xF0, (byte) 0x72, (byte) 0xFF, (byte) 0xE8, (byte) 0x58, (byte) 0xC5, (byte) 0xBE, (byte) 0xE9,
            (byte) 0x2B, (byte) 0x72, (byte) 0xC4, (byte) 0x3F, (byte) 0x3E, (byte) 0x64, (byte) 0x62, (byte) 0x2B,
            (byte) 0x1C, (byte) 0x35, (byte) 0x5F, (byte) 0x2B, (byte) 0xD9, (byte) 0x80, (byte) 0xBD, (byte) 0x7B,
            (byte) 0xCD, (byte) 0x27, (byte) 0xF8, (byte) 0xAC, (byte) 0xF3, (byte) 0xFC, (byte) 0x27, (byte) 0x26,
            (byte) 0xA9, (byte) 0x32, (byte) 0xDF, (byte) 0xBB, (byte) 0x2E, (byte) 0xE1, (byte) 0x0D, (byte) 0x4C,
            (byte) 0x81, (byte) 0x54, (byte) 0x74, (byte) 0x67, (byte) 0xF4, (byte) 0x8C, (byte) 0x3C, (byte) 0xB6,
            (byte) 0x8C, (byte) 0x80, (byte) 0x75, (byte) 0xB5, (byte) 0x87, (byte) 0x76, (byte) 0xB8, (byte) 0x51,
            (byte) 0x91, (byte) 0x26, (byte) 0x0A, (byte) 0xEC, (byte) 0xC4, (byte) 0x51, (byte) 0xB9, (byte) 0x19,
            (byte) 0xB8, (byte) 0xA3, (byte) 0x30, (byte) 0xC7, (byte) 0xB9, (byte) 0x17, (byte) 0xC4, (byte) 0x70,
            (byte) 0x82, (byte) 0xA9, (byte) 0x03, (byte) 0xAD, (byte) 0x02, (byte) 0x03, (byte) 0x01, (byte) 0x00,
            (byte) 0x01,
    };

    public static void main(String[] args) {
        try {
            System.out.printf("------------------------本机信息 start---------------------------------\n");
            HardwareBinder hb = new HardwareBinder();
            System.out.printf("machine id：%s\n", hb.getMachineIdString());
            System.out.printf("mac地址：%s\n", NetUtil.getMACAddress1());

            System.out.printf("------------------------本机信息 end---------------------------------\n");

            ClassPathResource resource = new ClassPathResource("license.bin");
            LicenseReader reader = new LicenseReader(resource.getInputStream());
            License license = reader.read(IOFormat.BASE64);

            //获取过期时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            String expiryDate = sdf.format(license.get("expiryDate").getDate());

            System.out.printf("------------------------license相关信息 start---------------------------------\n");
            System.out.printf("是否到期：%s，到期时间：%s\n", license.isExpired(), expiryDate);
            System.out.printf("签名验证结果：%s\n", license.isOK(key));
            System.out.printf("\n系统变量：\n");
            System.out.printf("licenseId：%s\n", license.getLicenseId().toString());
            System.out.printf("当前电脑uuid与证书是否一致：%s\n", hb.assertUUID(license.getLicenseId().toString()));
            System.out.printf("expiryDate：%s\n", expiryDate);
            System.out.printf("licenseSignature：%s\n", Base64.getEncoder().encodeToString(license.getSignature()));
            System.out.printf("\n自定义变量：\n");
            System.out.printf("maxUser：%s\n", license.get("maxUser").getInt());
            System.out.printf("\nlicense详情：\n");
            System.out.printf("%s\n", license);
            System.out.printf("------------------------license相关信息 end---------------------------------\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new RuntimeException("证书授权不可用！");

        //SpringApplication.run(ClientApplication.class, args);
    }

}
