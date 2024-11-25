public class testNGtest {


    String item0ActualText = driver.findElement(By.XPATH("//li[@data-tab-section-id='.item0']")).getText();
    String item1ActualText = driver.findElement(By.XPATH("//li[@data-tab-section-id='.item1")).getText();
    String item2ActualText = driver.findElement(By.XPATH("//li[@data-tab-section-id='.item2']")).getText();

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver location");
        driver = new chromeDriver();
        driver.get("https://datacom.com/nz/en/contact-us");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyOurLocationHeaders() {
        
        driver.findElement(By.XPATH("(//li[@data-tab-id="our-locations"])[1]")).click();
        waitForPageToLoad();
        Assert.assertEquals(item0ActualText, "New Zealand");
        Assert.assertEquals(item1ActualText, "Australia");
        Assert.assertEquals(item2ActualText, "Asia");

    }

    @Test
    public void verifyOurLocationsCountryListForNewZealand() {

        driver.findElement(By.XPATH("//li[@data-tab-section-id='.item0']")).click();
        waitForPageToLoad();
        driver.findElement(By.XPATH("//div[@data-map-container-id='map00']")).click();
        waitForPageToLoad();



    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}