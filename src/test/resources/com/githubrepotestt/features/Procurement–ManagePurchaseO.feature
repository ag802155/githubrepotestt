
Feature: Procurement–ManagePurchaseO @feature_manage_purchase_orders

  Background: 
    Given the user is on the Purchase Order Creation Page

  @duplicate_po_number
  Scenario Outline: Validate Duplicate PO Number Prevention
    When the user clicks on the "Create New PO" button
    And the user selects a job number
    And the user enters the existing PO number <existing_po_number>
    And the user selects the vendor <vendor>
    And the user adds a chemical item <chemical_item> and enters the quantity <quantity>
    And the user clicks on the "Add" button to save the PO
    Then the system displays an error message indicating that the PO number must be unique
    And the purchase order is not created

    Examples:
      | existing_po_number | vendor     | chemical_item | quantity |
      | 12345              | Vendor A   | Chemical X    | 10      |

  @prevent_creation_without_vendor
  Scenario Outline: Validate that the system prevents the creation of a purchase order if no vendor is selected
    When the user clicks on the "Create New PO" button
    And the user selects a job number
    And the user enters a unique PO number
    And leaves the vendor selection blank
    And the user adds a chemical item and enters its quantity
    And the user clicks on the "Add" button to save the PO
    Then the system displays an error message indicating that vendor selection is mandatory
    And the purchase order is not created

    Examples:
      | job_number | po_number | chemical_item | quantity |
      | <job_number> | <po_number> | <chemical_item> | <quantity> |

@invalid-chemical-quantity
Scenario Outline: Validate that the system prevents the creation of a purchase order if a chemical item is added without a quantity
  When the user clicks on the "Create New PO" button
  And the user selects a job number
  And the user enters a unique PO number
  And the user selects a vendor
  And the user adds a chemical item but leaves the quantity field blank
  And the user clicks on the "Add" button to save the PO
  Then the system displays an error message indicating that quantity is required for each chemical
  And the purchase order is not created

Examples:
  | job_number | unique_po_number | vendor         |
  | 12345      | PO-001          | Vendor A      |

@limit_exceeded
Scenario Outline: Validate the addition of more than seven chemical items in a single purchase order
  When the user clicks on the "Create New PO" button
  And the user selects a job number
  And the user enters a unique PO number
  And the user selects a vendor
  And the user adds seven chemical items with their quantities
  And the user attempts to add an eighth chemical item
  Then the system displays an error message indicating that the maximum limit of seven chemical items has been reached
  And the eighth chemical item is not added

Examples:
  | job_number | unique_po_number | vendor         |
  | 12345      | PO-001          | Vendor A      |

@duplicate_po_number
Scenario Outline: Validate that the system prevents editing a purchase order to a duplicate PO number
  When the user selects an existing purchase order
  And the user clicks on the "Edit" button
  And the user changes the PO number to an existing duplicate PO number
  And the user clicks on the "Save" button
  Then the system displays an error message indicating that the PO number must be unique
  And the purchase order is not updated

Examples:
  | existing_purchase_order | duplicate_po_number |
  | <existing_purchase_order> | <duplicate_po_number> |

@prevent_deletion_of_nonexistent_order
Scenario Outline: Validate that the system prevents deletion of a purchase order that does not exist
  When the user attempts to select a purchase order that has been deleted
  And the user clicks on the Delete button
  And the user confirms the deletion action
  Then the system displays an error message indicating that the purchase order does not exist
  And no deletion occurs

Examples:
  | purchase_order_status |
  | deleted               |

@no_purchase_orders
Scenario Outline: Validate that the system prevents exporting when no purchase orders exist
  When the user clicks on the "Export" button
  Then the system displays an error message indicating that there are no purchase orders to export
  And no export action occurs

Examples:
  | purchase_orders |
  | none            |

@warning_no_chemical_items
Scenario Outline: Procurement – Manage Purchase Orders
  When the user clicks on the "Create New PO" button
  And the user selects a job number
  And the user enters a unique PO number
  And the user selects a vendor
  And the user does not add any chemical items
  And the user clicks on the "Add" button to save the PO
  Then the system displays a warning message indicating that at least one chemical item must be added
  And the purchase order is not created

Examples:
  | job_number | unique_po_number | vendor       |
  | <job_number> | <unique_po_number> | <vendor> |

@no_purchase_orders
Scenario Outline: Validate that the system handles the scenario gracefully when no purchase orders exist
  Given the user navigates to the list of purchase orders
  Then the system displays a message indicating that no purchase orders exist
  And the user is prompted to create a new purchase order

Examples:
  |  |
  |  |

@duplicate_po_number
Scenario Outline: Validate that the system prevents the creation of a purchase order with a duplicate PO number
  When the user clicks on the "Create New PO" button
  And the user selects a job number
  And the user enters the existing PO number "<existing_po_number>"
  And the user selects a vendor "<vendor>"
  And the user adds a chemical item "<chemical_item>" and enters its quantity "<quantity>"
  And the user clicks on the "Add" button to save the PO
  Then the system displays an error message indicating that the PO number must be unique
  And the purchase order is not created

Examples:
  | existing_po_number | vendor     | chemical_item | quantity |
  | 12345              | Vendor A   | Chemical X    | 10      |

@vendor_selection_error
Scenario Outline: Validate Vendor Selection is Mandatory
  When the user clicks on the "Create New PO" button
  And the user selects a job number
  And the user enters a unique PO number
  And the user leaves the vendor selection blank
  And the user adds a chemical item and enters its quantity
  And the user clicks on the "Add" button to save the PO
  Then the system displays an error message indicating that vendor selection is mandatory
  And the purchase order is not created

Examples:
  | job_number | po_number |
  | <job_number> | <po_number> |

  @empty-quantity
  Scenario Outline: Procurement – Manage Purchase Orders
    When the user clicks on the "Create New PO" button
    And the user selects a job number
    And the user enters a unique PO number
    And the user selects a vendor
    And the user adds a chemical item but leaves the quantity field blank
    And the user clicks on the "Add" button to save the PO
    Then the system displays an error message indicating that quantity is required for each chemical
    And the purchase order is not created

  Examples:
    | job_number | unique_po_number | vendor        |
    | <job_number> | <unique_po_number> | <vendor> |

@maximum_item_limit
Scenario Outline: Validate that the system prevents the addition of more than seven chemical items in a single purchase order
  When the user clicks on the "Create New PO" button
  And the user selects a job number
  And the user enters a unique PO number
  And the user selects a vendor
  And the user adds seven chemical items with their quantities
  And the user attempts to add an eighth chemical item
  Then the system should display an error message indicating that the maximum limit of seven chemical items has been reached
  And the eighth chemical item is not added

Examples:
  | job_number | unique_po_number | vendor         | chemical_item_1 | chemical_item_2 | chemical_item_3 | chemical_item_4 | chemical_item_5 | chemical_item_6 | chemical_item_7 |
  | 12345      | PO123456        | Vendor A      | Item A          | Item B          | Item C          | Item D          | Item E          | Item F          | Item G          |

  @feature_user_login
  @prevent_duplicate_po_number
  Scenario Outline: Validate that the system prevents editing a purchase order to a duplicate PO number
    Given the user selects an existing purchase order
    When the user clicks on the "Edit" button
    And the user changes the PO number to an existing duplicate PO number
    And the user clicks on the "Save" button
    Then the system displays an error message indicating that the PO number must be unique
    And the purchase order is not updated

  Examples:
    | existing_purchase_order | duplicate_po_number |
    | PO123                   | PO123               |

@prevent_deletion_of_nonexistent_order
Scenario Outline: Validate that the system prevents deletion of a purchase order that does not exist
  When the user attempts to select a purchase order that has been deleted
  And the user clicks on the Delete button
  And the user confirms the deletion action
  Then the system displays an error message indicating that the purchase order does not exist
  And no deletion occurs

Examples:
  | purchase_order_status |
  | deleted               |

@no_purchase_orders
Scenario Outline: Validate that the system prevents exporting when no purchase orders exist
  When I click on the "Export" button
  Then the system should display an error message indicating that there are no purchase orders to export
  And no export action occurs

Examples:
  | action          |
  | Click Export    |

@po-without-chemical-items
Scenario Outline: Validate creation of a purchase order with zero chemical items
  When the user clicks on the "Create New PO" button
  And the user selects a job number
  And the user enters a unique PO number
  And the user selects a vendor
  And the user does not add any chemical items
  And the user clicks on the "Add" button to save the PO
  Then the system displays a warning message indicating that at least one chemical item must be added
  And the purchase order is not created

Examples:
  | job_number | unique_po_number | vendor       |
  | <job_number> | <unique_po_number> | <vendor> |

@no_purchase_orders
Scenario Outline: Validate that the system handles the scenario gracefully when no purchase orders exist
  When the user navigates to the list of purchase orders
  Then the system displays a message indicating that no purchase orders exist
  And the user is prompted to create a new purchase order

Examples:
  | purchase_order_status |
  | no_purchase_orders    |
