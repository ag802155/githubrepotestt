package com.githubrepotestt.stepdefinitions;

import com..utils.ElementUtils;
import org.junit.Assert;
import com..driverfactory.DriverFactory;
import com.githubrepotestt.pages.ProcurementManagePurchaseOPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class ProcurementManagePurchaseO extends DriverFactory {
ProcurementManagePurchaseOPage procurementPage = new ProcurementManagePurchaseOPage(driver);
@Given("the user is on the Purchase Order Creation Page")
public void the_user_is_on_the_purchase_order_creation_page() {
procurementPage.navigateToPurchaseOrderCreationPage();
}
@When("the user clicks on the {string} button")
public void the_user_clicks_on_button(String buttonName) {
procurementPage.clickButton(buttonName);
}
@When("the user selects a job number")
public void the_user_selects_a_job_number() {
procurementPage.selectJobNumber();
}
@When("the user enters the existing PO number {string}")
public void the_user_enters_the_existing_po_number(String existingPoNumber) {
procurementPage.enterExistingPONumber(existingPoNumber);
}
@When("the user selects the vendor {string}")
public void the_user_selects_the_vendor(String vendor) {
procurementPage.selectVendor(vendor);
}
@When("the user adds a chemical item {string} and enters the quantity {string}")
public void the_user_adds_a_chemical_item_and_enters_the_quantity(String chemicalItem, String quantity) {
procurementPage.addChemicalItem(chemicalItem, quantity);
}
@When("the user leaves the vendor selection blank")
public void the_user_leaves_the_vendor_selection_blank() {
procurementPage.leaveVendorSelectionBlank();
}
@When("the user adds a chemical item but leaves the quantity field blank")
public void the_user_adds_a_chemical_item_but_leaves_the_quantity_field_blank() {
procurementPage.addChemicalItemWithoutQuantity();
}
@When("the user attempts to add an eighth chemical item")
public void the_user_attempts_to_add_an_eighth_chemical_item() {
procurementPage.addEighthChemicalItem();
}
@Then("the system displays an error message indicating that the PO number must be unique")
public void the_system_displays_an_error_message_indicating_that_the_po_number_must_be_unique() {
Assert.assertTrue("Expected error message for duplicate PO number is not displayed",
procurementPage.isErrorMessageDisplayed("PO number must be unique"));
}
@Then("the system displays an error message indicating that vendor selection is mandatory")
public void the_system_displays_an_error_message_indicating_that_vendor_selection_is_mandatory() {
Assert.assertTrue("Expected error message for mandatory vendor selection is not displayed",
procurementPage.isErrorMessageDisplayed("vendor selection is mandatory"));
}
@Then("the system displays an error message indicating that quantity is required for each chemical")
public void the_system_displays_an_error_message_indicating_that_quantity_is_required_for_each_chemical() {
Assert.assertTrue("Expected error message for missing quantity is not displayed",
procurementPage.isErrorMessageDisplayed("quantity is required for each chemical"));
}
@Then("the system displays an error message indicating that the maximum limit of seven chemical items has been reached")
public void the_system_displays_an_error_message_indicating_that_the_maximum_limit_of_seven_chemical_items_has_been_reached() {
Assert.assertTrue("Expected error message for maximum limit of chemical items is not displayed",
procurementPage.isErrorMessageDisplayed("maximum limit of seven chemical items has been reached"));
}
@Then("the system displays an error message indicating that the purchase order does not exist")
public void the_system_displays_an_error_message_indicating_that_the_purchase_order_does_not_exist() {
Assert.assertTrue("Expected error message for non-existent purchase order is not displayed",
procurementPage.isErrorMessageDisplayed("purchase order does not exist"));
}
@Then("the system displays a message indicating that no purchase orders exist")
public void the_system_displays_a_message_indicating_that_no_purchase_orders_exist() {
Assert.assertTrue("Expected message indicating no purchase orders exist is not displayed",
procurementPage.isMessageDisplayed("no purchase orders exist"));
}
@Then("the system displays a warning message indicating that at least one chemical item must be added")
public void the_system_displays_a_warning_message_indicating_that_at_least_one_chemical_item_must_be_added() {
Assert.assertTrue("Expected warning message for missing chemical items is not displayed",
procurementPage.isWarningMessageDisplayed("at least one chemical item must be added"));
}
@Then("the purchase order is not created")
public void the_purchase_order_is_not_created() {
Assert.assertFalse("Purchase order should not have been created",
procurementPage.isPurchaseOrderCreated());
}
@Then("no deletion occurs")
public void no_deletion_occurs() {
Assert.assertFalse("Purchase order should not have been deleted",
procurementPage.isPurchaseOrderDeleted());
}
@Then("no export action occurs")
public void no_export_action_occurs() {
Assert.assertFalse("Export action should not have occurred",
procurementPage.isExportActionOccurred());
}

@Given("the user does not add any chemical items")
public void the_user_does_not_add_any_chemical_items() {
// No action needed as the user does not add any chemical items
}
@When("the user clicks on the add button to save the po")
public void the_user_clicks_on_the_add_button_to_save_the_po() {
procurementManagePurchaseOPage.clickAddButton();
}
@When("the user changes the po number to an existing duplicate po number")
public void the_user_changes_the_po_number_to_an_existing_duplicate_po_number() {
procurementManagePurchaseOPage.changePoNumberToDuplicate();
}
@Then("the system should display an error message indicating that the maximum limit of seven chemical items has been reached")
public void the_system_should_display_an_error_message_indicating_that_the_maximum_limit_of_seven_chemical_items_has_been_reached() {
String errorMessage = procurementManagePurchaseOPage.getErrorMessage();
Assert.assertEquals("Maximum limit of seven chemical items has been reached", errorMessage);
}
@Then("the user is prompted to create a new purchase order")
public void the_user_is_prompted_to_create_a_new_purchase_order() {
String promptMessage = procurementManagePurchaseOPage.getPromptMessage();
Assert.assertEquals("Please create a new purchase order", promptMessage);
}
@Then("the system should display an error message indicating that there are no purchase orders to export")
public void the_system_should_display_an_error_message_indicating_that_there_are_no_purchase_orders_to_export() {
String errorMessage = procurementManagePurchaseOPage.getErrorMessage();
Assert.assertEquals("There are no purchase orders to export", errorMessage);
}
@Then("the eighth chemical item is not added")
public void the_eighth_chemical_item_is_not_added() {
procurementManagePurchaseOPage.isEighthChemicalItemAdded();
}
@When("i clickElement on the export button")
public void i_click_on_the_export_button() {
procurementManagePurchaseOPage.clickExportButton();
}
@When("the user clicks on the delete button")
public void the_user_clicks_on_the_delete_button() {
procurementManagePurchaseOPage.clickDeleteButton();
}
@When("the user adds a chemical item {string} enters its quantity {string}")
public void the_user_adds_a_chemical_item_enters_its_quantity(String chemicalItem, String quantity) {
procurementManagePurchaseOPage.addChemicalItem(chemicalItem, quantity);
}
@When("the user selects an existing purchase order")
public void the_user_selects_an_existing_purchase_order() {
procurementManagePurchaseOPage.selectExistingPurchaseOrder();
}
@When("the user selects a vendor {string}")
public void the_user_selects_a_vendor(String vendor) {
procurementManagePurchaseOPage.selectVendor(vendor);
}
@When("the user adds seven chemical items with their quantities")
public void the_user_adds_seven_chemical_items_with_their_quantities() {
procurementManagePurchaseOPage.addSevenChemicalItems();
}
@When("the user clicks on the save button")
public void the_user_clicks_on_the_save_button() {
procurementManagePurchaseOPage.clickSaveButton();
}
@When("leaves the vendor selection blank")
public void leaves_the_vendor_selection_blank() {
procurementManagePurchaseOPage.leaveVendorSelectionBlank();
}
@When("the user clicks on the edit button")
public void the_user_clicks_on_the_edit_button() {
procurementManagePurchaseOPage.clickEditButton();
}
@When("the user confirms the deletion action")
public void the_user_confirms_the_deletion_action() {
procurementManagePurchaseOPage.confirmDeletion();
}
@When("the user clicks on the create new po button")
public void the_user_clicks_on_the_create_new_po_button() {
procurementManagePurchaseOPage.clickCreateNewPoButton();
}
@When("the user enters a unique po number")
public void the_user_enters_a_unique_po_number() {
procurementManagePurchaseOPage.enterUniquePoNumber();
}
@When("the user attempts to select a purchase order that has been deleted")
public void the_user_attempts_to_select_a_purchase_order_that_has_been_deleted() {
procurementManagePurchaseOPage.selectDeletedPurchaseOrder();
}
@Then("the purchase order is not updated")
public void the_purchase_order_is_not_updated() {
procurementManagePurchaseOPage.isPurchaseOrderUpdated();
}
@Then("the user navigates to the list of purchase orders")
public void the_user_navigates_to_the_list_of_purchase_orders() {
procurementManagePurchaseOPage.navigateToPurchaseOrderList();
}
}