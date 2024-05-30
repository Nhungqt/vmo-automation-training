package com.vmo.letskodeit.features;

import com.vmo.letskodeit.common.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

@Epic("Vntrip")
@Feature("Booking hotel")
@Story("Add data from excel")
public class AddDataFromExcelFile extends BaseTest {
    @BeforeTest
    public void setUpTestData() throws IOException {
        System.out.println("--------------Setup Test Level Data---------------");
        utils.excelutils.ExcelUtil.setExcelFileSheet("LonginData");
    }


}
