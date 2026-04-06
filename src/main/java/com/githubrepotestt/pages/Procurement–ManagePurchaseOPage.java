package com.backend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utils.ElementUtils;
import org.junit.Assert;

public class ProcurementManagePurchaseOPage {
    private WebDriver driver;
    private ElementUtils elementUtils;

    @FindBy(id = "purchaseOrderCreationPage")
    private WebElement purchaseOrderCreationPage;
    @FindBy(id = "addButton")
    private WebElement addButton;
    @FindBy(id = "exportButton")
    private WebElement exportButton;
    @FindBy(id = "deleteButton")
    private WebElement deleteButton;
    @FindBy(id = "poNumberField")
    private WebElement poNumberField;
    @FindBy(id = "vendorDropdown")
    private WebElement vendorDropdown;
    @FindBy(id = "errorMessage")
    private WebElement errorMessageElement;
    @FindBy(id = "promptMessage")
    private WebElement promptMessageElement;
    @FindBy(id = "chemicalItemField")
    private WebElement chemicalItemField;
    @FindBy(id = "quantityField")
    private WebElement quantityField;
    @FindBy(id = "saveButton")
    private WebElement saveButton;
    @FindBy(id = "messageElement")
    private WebElement messageElement;

    public ProcurementManagePurchaseOPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToPurchaseOrderCreationPage() {
        try {
            elementUtils.clickElement(purchaseOrderCreationPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickAddButton() {
        try {
            elementUtils.clickElement(addButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickExportButton() {
        try {
            elementUtils.clickElement(exportButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickDeleteButton() {
        try {
            elementUtils.clickElement(deleteButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterExistingPONumber(String existingPoNumber) {
        try {
            elementUtils.clearAndSendKeys(poNumberField, existingPoNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectVendor(String vendor) {
        try {
            elementUtils.clickElement(vendorDropdown);
            elementUtils.selectOptionInDropdown(vendorDropdown, vendor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addChemicalItem(String chemicalItem, String quantity) {
        try {
            elementUtils.clearAndSendKeys(chemicalItemField, chemicalItem);
            elementUtils.clearAndSendKeys(quantityField, quantity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickSaveButton() {
        try {
            elementUtils.clickElement(saveButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isErrorMessageDisplayed(String expectedMessage) {
        try {
            String actualMessage = elementUtils.getElementText(errorMessageElement);
            return actualMessage.equals(expectedMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getErrorMessage() {
        try {
            return elementUtils.getElementText(errorMessageElement);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getPromptMessage() {
        try {
            return elementUtils.getElementText(promptMessageElement);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean isMessageDisplayed(String expectedMessage) {
        try {
            String actualMessage = elementUtils.getElementText(messageElement);
            return actualMessage.equals(expectedMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isPurchaseOrderCreated() {
        // Implement logic to check if the purchase order was created
        return false; // Replace with actual check
    }

    public boolean isPurchaseOrderUpdated() {
        // Implement logic to check if the purchase order was updated
        return false; // Replace with actual check
    }

    public boolean isPurchaseOrderDeleted() {
        // Implement logic to check if the purchase order was deleted
        return false; // Replace with actual check
    }

    public boolean isEighthChemicalItemAdded() {
        // Implement logic to check if the eighth chemical item was added
        return false; // Replace with actual check
    }

    public void changePoNumberToDuplicate() {
        // Implement logic to change PO number to duplicate
    }

    public void selectExistingPurchaseOrder() {
        // Implement logic to select existing purchase order
    }

    public void leaveVendorSelectionBlank() {
        // Implement logic to leave vendor selection blank
    }

    public void addSevenChemicalItems() {
        // Implement logic to add seven chemical items
    }

    public void clickEditButton() {
        // Implement logic to click edit button
    }

    public void confirmDeletion() {
        // Implement logic to confirm deletion
    }

    public void clickCreateNewPoButton() {
        // Implement logic to click create new PO button
    }

    public void enterUniquePoNumber() {
        // Implement logic to enter unique PO number
    }

    public void selectDeletedPurchaseOrder() {
        // Implement logic to select a deleted purchase order
    }

    public void selectJobNumber() {
        try {
            WebElement jobNumberElement = driver.findElement(By.id("jobNumberDropdown")); // Assume an ID locator
            elementUtils.selectOptionInDropdown(jobNumberElement, "Job Number");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isExportActionOccurred() {
        try {
            WebElement exportMessageElement = driver.findElement(By.id("exportActionMessage")); // Assume an ID locator
            String actualMessage = elementUtils.getElementText(exportMessageElement);
            String expectedMessage = "Export action occurred successfully"; // Example expected message
            Assert.assertEquals(actualMessage, expectedMessage, "Export action message does not match!");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void addChemicalItemWithoutQuantity() {
        try {
            WebElement addButton = driver.findElement(By.id("addChemicalButton")); // Assume an ID locator
            elementUtils.clickElement(addButton);
            elementUtils.clearAndSendKeys(chemicalItemField, "Chemical Item");
            WebElement saveButton = driver.findElement(By.id("saveChemicalButton")); // Assume an ID locator
            elementUtils.clickElement(saveButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEighthChemicalItem() {
        try {
            WebElement eighthChemicalButton = driver.findElement(By.id("addEighthChemicalButton")); // Assume an ID locator
            elementUtils.clickElement(eighthChemicalButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isWarningMessageDisplayed() {
        try {
            WebElement warningMessageElement = driver.findElement(By.id("warningMessage")); // Assume an ID locator
            return elementUtils.isElementDisplayed(warningMessageElement);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void navigateToPurchaseOrderList() {
        try {
            driver.get("http://localhost/purchaseOrderList"); // Example URL for navigation
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}