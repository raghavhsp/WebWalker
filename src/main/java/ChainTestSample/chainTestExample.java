package ChainTestSample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.aventstack.chaintest.conf.Configuration;
import com.aventstack.chaintest.domain.Build;
import com.aventstack.chaintest.domain.Result;
import com.aventstack.chaintest.domain.SystemInfo;
import com.aventstack.chaintest.domain.Test;
import com.aventstack.chaintest.generator.ChainTestSimpleGenerator;
import com.aventstack.chaintest.service.ChainPluginService;

public class chainTestExample {

 static final String GENERATOR_NAME = "simple";
 static final String BASE_PROPERTY = "chaintest.generator.simple";
 static final String PROP_ENABLED = BASE_PROPERTY + ".enabled";
 static final String PROP_OUT_FILE_NAME = BASE_PROPERTY + ".output-file";
 static final String PROP_SAVE_OFFLINE = BASE_PROPERTY + ".offline";
 static final String PROP_DATETIME_FORMAT = BASE_PROPERTY + ".datetime-format";
 static final String PROP_DOCUMENT_TITLE = BASE_PROPERTY + ".document-title";
 static final String PROP_DARK_THEME = BASE_PROPERTY + ".dark-theme";
 static final String PROP_JS = BASE_PROPERTY + ".js";
 static final String PROP_CSS = BASE_PROPERTY + ".css";
 static final String BASE_TEMPLATE_NAME = "index.ftl";
 static final String DEFAULT_OUT_FILE_NAME = "Simple.html";
 static final String DEFAULT_OUT_DIR = "target/chaintest/";
 static final String RESOURCES_DIR = "/resources";
 static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss a";	

	public static void main(String a[])
	
	
	{
		
		ChainTestSimpleGenerator genCT = new ChainTestSimpleGenerator();
		
		Configuration  configCT= new Configuration();
		try {
			configCT.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Optional<Map<String, String>> propertiesCT = Optional.ofNullable(configCT.getConfig());
		
		
		   final List<String> SYS_PROPS = List.of(
		            "java.version",
		            "java.vm.name",
		            "java.vm.vendor",
		            "java.class.version",
		            "java.runtime.name",
		            "os.name",
		            "os.arch",
		            "os.version"
		    );
		
	   // On Execution Start
		ChainPluginService cpsObj = new ChainPluginService("TESTNG");
		Build build = new Build("TESTNG");
		SystemInfo systemInfo = new SystemInfo();
		
	
		
		List<SystemInfo> listSysInfo = new ArrayList<>();
		SYS_PROPS.forEach(prop -> {listSysInfo.add(new SystemInfo(prop, System.getProperty(prop)));});
		build.setSystemInfo(listSysInfo);
		
		genCT.start(propertiesCT, "TESTNG", build);
		
		
		// On Start
		Test suiteTest = new Test("SuiteName");
		
		//Before Class
		
		
		// On Test Start
		 Test testClazz = new Test("ChildTest", Optional.of("chainTestExample"), new ArrayList<String>());
		 suiteTest.addChild(testClazz);
		 testClazz.setExternalId("ChildTest");
		 
		 testClazz.addScreenshotURL("https://icons.iconarchive.com/icons/bokehlicia/captiva/128/atom-icon.png");
		 testClazz.addLog("Sample Step Log");
		 testClazz.addLog("Sample Step Log");
		 testClazz.addLog("Sample Step Log");
		 testClazz.addLog("Sample Step Log");
		 
		 File file = new File(System.getProperty("user.dir")+File.separator+"AttachmentsForTest"+File.separator+"Image01.jpg");
		 
		 testClazz.addEmbed(file, "image/jpg");
		 
		 suiteTest.setDescription("This is a sample chai test");
		 
		 suiteTest.addLog("Sample Step Log suiteTest");
		 suiteTest.addLog("Sample Step Log suiteTest");
		 suiteTest.addLog("Sample Step Log suiteTest");
		 suiteTest.addLog("Sample Step Log suiteTest");
		 
		 // On Test Complete
		 Test childOfChild = new Test("ChildOFChild");
		 
		 childOfChild.addTag("Critical");
		 
		 testClazz.complete();
		 suiteTest.complete();
		 
		 suiteTest.addChild(childOfChild);
		 
		 childOfChild.addLog("Sample Step Log suiteTest");
		 childOfChild.addLog("Sample Step Log suiteTest");
		 childOfChild.addLog("Sample Step Log suiteTest");
		 childOfChild.addLog("Sample Step Log suiteTest");
		 
		 List<Test> testList = new ArrayList<>();
		 testList.add(suiteTest);
		 testList.add(testClazz);
		 
		 build.updateStats(suiteTest);
		 build.updateStats(testClazz);
		 build.complete();
		 genCT.flush( testList);
		 
		 
		 
		 
		 
		
		 
		 
		
		 
		
		
		
//		ChainTestSimpleGenerator genCT = new ChainTestSimpleGenerator();
//		Configuration  configCT= new Configuration();
//		try {
//			configCT.load();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		Map<String , String > propertiesCT = configCT.getConfig();
//	System.out.println(propertiesCT);	
//		
//		
//		genCT.start(propertiesCT, null, null);
	
	}

	
}
