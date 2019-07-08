//读取配置文件
Properties properties = new Properties();
 InputStream inputStream = Object.class.getResourceAsStream("/myConfig.properties");
  try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
  String time = properties.get("time").toString();
//读取json文件，并反序列化

[{
		"deviceId": "A01B0100000001",
		"productKey": "402888db6bb20bc0016bb20c50d30000",
		"properties": [{
				"name": "power",
				"dataItemID": "000001",
				"valueType": "float",
				"min": "40",
				"max": "60",
				"isIncrease": false
			},
			{
				"name": "energy",
				"dataItemID": "000007",
				"valueType": "int",
				"min": "10",
				"max": "20",
				"isIncrease": true
			}
		]
	},
	{
		"deviceId": "A01B0100000002",
		"productKey": "402888db6bc02960016bc02a94b70000",
		"properties": [{
			"name": "power",
			"dataItemID": "000001",
			"valueType": "float",
			"min": "40",
			"max": "60",
			"isIncrease": false
		}, {
			"name": "energy",
			"dataItemID": "000007",
			"valueType": "int",
			"min": "10",
			"max": "20",
			"isIncrease": true
		}]
	}
]

 File file2 = null;
        try {
            file2 = ResourceUtils.getFile("classpath:deviceInfo.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String file1 = null;
        try {
            file1 = FileUtils.readFileToString(file2, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<deviceInfoConfig> parse = JSONObject.parseArray(file1, deviceInfoConfig.class);

//保存配置文件
 File file = null;
        try {
            file = ResourceUtils.getFile("classpath:myConfig.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileOutputStream oFile = null;//true表示追加打开
        try {
            oFile = new FileOutputStream(file, false);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            properties.store(oFile, "properties file changed at time: " + dateFormat1.format(new Date()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }







