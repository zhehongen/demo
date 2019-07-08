 Properties properties = new Properties();
 InputStream inputStream = Object.class.getResourceAsStream("/myConfig.properties");
  try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
  String time = properties.get("time").toString();










