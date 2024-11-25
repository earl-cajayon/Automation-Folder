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
        
        driver.findElement(By.XPATH("(//li[@data-tab-id='our-locations'])[1]")).click();
        waitForPageToLoad();
        Assert.assertEquals(item0ActualText, "New Zealand");
        Assert.assertEquals(item1ActualText, "Australia");
        Assert.assertEquals(item2ActualText, "Asia");

    }

    @Test
    public void verifyOurLocationsCountryListForNewZealand() {

        List<WebElement> actualAddress = driver.findElement(By.XPATH("//p[@class='cmp-location__location__address']"));
        String[] mainAddressExpectedText = {"Auckland", "Christchurch", "Dunedin", "Hamilton", "Hastings", "Nelson", "New Plymouth", "Rotorua", "Tuaranga", "Wellington"};
        String[] addressExpectedText = {"58 Gaunt Street, Auckland CBD, Auckland 1010", 
                                        "67 Gloucester Street, Christchurch 8013", 
                                        "Level 1, 77 Vogel Street, Dunedin 9011", 
                                        "Level 2, 94 Bryce Street, Hamilton 3204", 
                                        "2/117 Heretaunga Street East, Hastings 4122",
                                        "Level 1, 190 Trafalgar Street, Nelson 7010",
                                        "Level 1, 2 Devon Street East, New Plymouth 4310",
                                        "8 Railway Road, Rotorua 3015",
                                        "15-17 Harington Street, Tauranga 3110",
                                        "55 Featherston Street, Pipitea, Wellington 6011,"};

        driver.findElement(By.XPATH("//li[@data-tab-section-id='.item0']")).click();
        waitForPageToLoad();

        for(int elementSize = 0; elementSize <= size.actualAddress; elementSize++) {
            driver.findElement(By.XPATH("(//div[@class='cmp-location__location__name focus-outline-no-offset-location'])[elementSize]")).click();
            waitForPageToLoad();
            Assert.assertEquals(driver.findElement(By.XPATH("(//div[@class='cmp-location__location__name focus-outline-no-offset-location'])[elementSize]")), mainAddressExpectedText[elementSize]);
            Assert.assertEquals(driver.findElement(By.XPATH("(//p[@class='cmp-location__location__address'])[elementSize]")), addressExpectedText[elementSize]);
        }

    }

    @Test
    public void verifyOurLocationsCountryListForAustralia() {

        List<WebElement> actualAddress = driver.findElement(By.XPATH("//p[@class='cmp-location__location__address']"));
        String[] mainAddressExpectedText = {"Adelaide", "Brisbane", "Canberra", "Melbourne", "Modbury", "Perth", "Sydney - Denison Street", "Townsville"};
        String[] addressExpectedText = {"118 Franklin Street, Adelaide, South Australia 5000",
                                        "501 Ann Street, Fortitude Valley, Brisbane, Queensland 4006",
                                        "Level 12, Civic Quarter, 68 Northbourne Ave, Canberra, ACT 2601",
                                        "Level 11, Two Melbourne Quarter, 697 Collins Street, Docklands, Victoria 3008",
                                        "100 Smart Road, Modbury, South Australia 5092",
                                        "Level 11, 66 St. George's Terrace, Perth, Western Australia 6000",
                                        "Level 31, 1 Denison Street, North Sydney, Sydney, NSW 2060",
                                        "Lot 2, 264-278 Woolcock Street, Townsville, Queensland 4810"};

        driver.findElement(By.XPATH("//li[@data-tab-section-id='.item1']")).click();
        waitForPageToLoad();

        for(int elementSize = 0; elementSize <= size.actualAddress; elementSize++) {
            driver.findElement(By.XPATH("(//div[@class='cmp-location__location__name focus-outline-no-offset-location'])[elementSize]")).click();
            waitForPageToLoad();
            Assert.assertEquals(driver.findElement(By.XPATH("(//div[@class='cmp-location__location__name focus-outline-no-offset-location'])[elementSize]")), mainAddressExpectedText[elementSize]);
            Assert.assertEquals(driver.findElement(By.XPATH("(//p[@class='cmp-location__location__address'])[elementSize]")), addressExpectedText[elementSize]);
        }
    }

    @Test
    public void verifyOurLocationsCountryListForAsia() {

        List<WebElement> actualAddress = driver.findElement(By.XPATH("//p[@class='cmp-location__location__address']"));
        String[] mainAddressExpectedText = {"Malaysia", "Philippines", "Singapore"};
        String[] addressExpectedText = {"Level 3A, 1 Sentral, Jalan Rakyat, Kuala Lumpur Sentral, Kuala Lumpur 50470",
                                        "Level 23F, IBM Plaza, 8 Eastwood Ave, Bagumbayan, Quezon City, 1110 Metro Manila, Philippines",
                                        "38 Beach Road, South Beach Tower, #29-11 Singapore 189767"};

        driver.findElement(By.XPATH("//li[@data-tab-section-id='.item1']")).click();
        waitForPageToLoad();

        for(int elementSize = 0; elementSize <= size.actualAddress; elementSize++) {
            driver.findElement(By.XPATH("(//div[@class='cmp-location__location__name focus-outline-no-offset-location'])[elementSize]")).click();
            waitForPageToLoad();
            Assert.assertEquals(driver.findElement(By.XPATH("(//div[@class='cmp-location__location__name focus-outline-no-offset-location'])[elementSize]")), mainAddressExpectedText[elementSize]);
            Assert.assertEquals(driver.findElement(By.XPATH("(//p[@class='cmp-location__location__address'])[elementSize]")), addressExpectedText[elementSize]);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}