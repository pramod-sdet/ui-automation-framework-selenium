package com.pramod.automation.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.pramod.automation.constants.Env;
import com.pramod.pojo.Config;
import com.pramod.pojo.Environment;

public class JSONUtility {
	public static Environment readJSON(Env env) {

		Gson gson = new Gson();

		File jsonFile = new File(System.getProperty("user.dir") + "//config//config.json");

		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		Config config = gson.fromJson(fileReader, Config.class);
		Environment environment = config.getEnvironments().get("QA");
		return environment;
		}

}
