package com.atguigu.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

//spring boot 2.1.x 以下：@RunWith(SpringRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTests {
	@Test
	public void textFileUpload() throws IOException, MyException {
		// 项目目录不能有特殊字符
		String file = this.getClass().getResource("/tracker.conf").getFile();
		ClientGlobal.init(file);
		TrackerClient trackerClient=new TrackerClient();
		TrackerServer trackerServer=trackerClient.getConnection();
		StorageClient storageClient=new StorageClient(trackerServer,null);
		String orginalFilename="f:001.jpg";
		String[] upload_file = storageClient.upload_file(orginalFilename, "jpg", null);
		for (int i = 0; i < upload_file.length; i++) {
			String s = upload_file[i];
			System.out.println("s = " + s);
			/*
			s = group1
			s = M00/00/00/wKhD4l4G-aSAB0dxAACGx2c4tJ4196.jpg
			 */
		}
	}



}
