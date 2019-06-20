package core.configuration;

import core.configuration.testProperties.Property;
import core.configuration.testProperties.PropertiesLoader;
import core.configuration.testProperties.PropertyFile;

@PropertyFile("config.properties")
public class TestsConfig {

    private static TestsConfig config;

    public static TestsConfig getConfig() {
        if (config == null) {
            config = new TestsConfig();
        }
        return config;
    }

    public TestsConfig() {
        PropertiesLoader.populate(this);
    }

    @Property("project")
    private String project = "";

    @Property("Device")
    private String device ="";

    @Property("baseUri")
    private String baseUri = "";

    @Property("baseUriPreReq")
    private String baseUriPreReq = "";

    @Property("environment")
    private String environment = "";

    @Property("isEnableReporting")
    private String isEnableReporting = "";

/*##################### --- Pre Requsite Setup --- #####################*/

    @Property("Username")
    private String Username = "";

    @Property("Password")
    private String Password = "";

    @Property("grant_type")
    private String grant_type = "";

    @Property("client_id")
    private String client_id = "";

    @Property("client_secret")
    private String client_secret = "";

/*############################ --- Environment --- ############################*/

    @Property("loginUrl")
    private String loginUrl = "";

    @Property("dbUrl")
    private String dbUrl = "";

    @Property("dbUsername")
    private String dbUsername = "";

    @Property("dbPassword")
    private String dbPassword = "";

    @Property("dbConfigMySql")
    private String dbConfigMySql = "";

    @Property("dbUserNameMySql")
    private String dbUserNameMySql = "";

    @Property("dbPasswordMySql")
    private String dbPasswordMySql = "";

    @Property("dbServerMySql")
    private String dbServerMySql = "";


    public String getProject() {
        return project;
    }

    public String getDevice() {
        return device;
    }

    public String getUsername() {return Username;}

    public String getPassword() {return Password;}

    public String getEnvironment() {return environment;}

    public String getIsEnableReporting() {return isEnableReporting;}

    public String getDbUrl() {
        return dbUrl;
    }

    public String getBaseUri() {
        return baseUri;
    }

    public String getBaseUriPreReq() {
        return baseUriPreReq;
    }

    public String getDbUsername() { return dbUsername; }

    public String getDbPassword() { return dbPassword; }

    public String getLoginUrl() {return loginUrl;}

    public String getDbConfigMySql() {return dbConfigMySql;}

    public String getDbUserNameMySql() {return dbUserNameMySql;}

    public String getDbPasswordMySql() {return dbPasswordMySql;}

    public String getDbServerMySql() {return dbServerMySql;}

    public String getGrantType() {return grant_type;}

    public String getClientId() {return client_id;}

    public String getClientSecret() {return client_secret;}
}
