package service;

import java.util.UUID;

import model.Photo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tool.Tool_File;


@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class PhotoServiceTest {

	@Autowired
	private PhotoService photoService;
	
	private static Photo photo1 = null;
	private static Photo photo2 = null;
	private static Photo photo3 = null;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		photo1 = new Photo();
		photo1.setId(UUID.randomUUID().toString().replace("-", ""));
		photo1.setPname("img1.jpg");
		byte[] datas1 = Tool_File.getDatas("img/img1.jpg");
		photo1.setSize(datas1.length);
		photo1.setDatas(datas1);
		
		
		photo2 = new Photo();
		photo2.setId(UUID.randomUUID().toString().replace("-", ""));
		photo2.setPname("img2.jpg");
		byte[] datas2 = Tool_File.getDatas("img/img2.jpg");
		photo2.setSize(datas2.length);
		photo2.setDatas(datas2);
		
		photo3 = new Photo();
		photo3.setId(UUID.randomUUID().toString().replace("-", ""));
		photo3.setPname("img3.jpg");
		byte[] datas3 = Tool_File.getDatas("img/img3.jpg");
		photo3.setSize(datas3.length);
		photo3.setDatas(datas3);
	}

	@Test
	public void test1Insert() {
		int result = 0;
		result += photoService.insert(photo1);
		result += photoService.insert(photo2);
		result += photoService.insert(photo3);
		
		Assert.assertEquals(3, result);
	}
	
	@Test
	public void test2QueryById() throws Exception {
		Photo photo = photoService.getUserById(photo1.getId());
		byte[] datas = photo.getDatas();
		System.out.println(datas.length);
		Tool_File.writeDatas(photo.getPname(), datas);
		
		photo = photoService.getUserById(photo2.getId());
		datas = photo.getDatas();
		System.out.println(datas.length);
		Tool_File.writeDatas(photo.getPname(), datas);
		
		photo = photoService.getUserById(photo3.getId());
		datas = photo.getDatas();
		System.out.println(datas.length);
		Tool_File.writeDatas(photo.getPname(), datas);
	}
	
}
